package com.baidu.tieba.frs;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class by {
    private com.baidu.tieba.tbadkCore.x Dp;
    private LinearLayout biB;
    private View biC;
    private TextView biD;
    private ImageView biE;
    private TextView biF;
    private View biG;
    private View biH;
    private List<FeedForumData> biJ;
    private boolean biL;
    TbPageContext<FrsActivity> mTbPageContext;
    private int mType;
    private List<ce> biI = new ArrayList();
    private Handler mHandler = new Handler();
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean biK = false;
    private View.OnClickListener mOnClickListener = new bz(this);
    private com.baidu.adp.base.g aXD = new ca(this);

    public by(TbPageContext<FrsActivity> tbPageContext, View view, int i, boolean z) {
        this.mType = 1;
        this.mTbPageContext = tbPageContext;
        this.biB = (LinearLayout) view.findViewById(t.g.frs_header_feed_forums);
        this.biC = view.findViewById(t.g.frs_header_feed_forums_divider);
        this.biG = view.findViewById(t.g.layout_like_feed_forum_header);
        this.biD = (TextView) this.biB.findViewById(t.g.like_feed_forums_label);
        this.biE = (ImageView) this.biB.findViewById(t.g.like_feed_forums_arrow);
        this.biE.setOnClickListener(this.mOnClickListener);
        this.biF = (TextView) this.biB.findViewById(t.g.feed_forums_more);
        this.biH = view.findViewById(t.g.feed_forum_bottom_line);
        this.biF.setOnClickListener(this.mOnClickListener);
        this.Dp = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.Dp.setLoadDataCallBack(this.aXD);
        this.mType = i;
        this.biL = z;
    }

    public void b(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if (oVar.avD() != null && oVar.avD().isLike() == 0) {
                hide();
                return;
            }
            if (oVar.avD() != null) {
                this.mForumId = oVar.avD().getId();
            }
            this.biJ = oVar.aSt();
            uQ();
            if (this.mType == 1 && !this.biK) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10027").ac("fid", this.mForumId));
                this.biK = true;
            }
        }
    }

    public void d(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.biJ = list;
        uQ();
        if (this.mType == 2 && !this.biK) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10035").ac("fid", this.mForumId));
            this.biK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ() {
        int i;
        if (com.baidu.tbadk.core.util.y.r(this.biJ) == 0) {
            hide();
            return;
        }
        show();
        int size = this.biJ.size() > 2 ? 2 : this.biJ.size();
        int size2 = size - this.biI.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = t.h.frs_header_feed_forum_item;
                } else {
                    i = t.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.biB.addView(inflate);
                this.biI.add(new ce(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.biI.size() - 1;
                this.biB.removeView(this.biI.get(size3).aJB);
                this.biI.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.biJ.get(i4);
            ce ceVar = this.biI.get(i4);
            if (feedForumData != null && ceVar != null) {
                ceVar.aJB.setTag(feedForumData);
                ceVar.aJB.setOnClickListener(this.mOnClickListener);
                ceVar.biP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                ceVar.biP.c(feedForumData.getAvatar(), 15, false);
                ceVar.aOG.setText(feedForumData.getForumName());
                ceVar.biQ.setText(String.format(this.mTbPageContext.getPageActivity().getString(t.j.attention_post_count), go(feedForumData.getMemberCount()), go(feedForumData.getPostNum())));
                ceVar.biR.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    ceVar.biS.setClickable(true);
                    ceVar.biS.setOnClickListener(this.mOnClickListener);
                    ceVar.biS.setTag(feedForumData);
                    ceVar.biS.setText(t.j.attention_n);
                    ceVar.biS.setEnabled(true);
                } else {
                    a(ceVar);
                }
            }
        }
        if (this.biL) {
            this.biH.setVisibility(0);
        } else {
            this.biH.setVisibility(8);
        }
        Qv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ce ceVar) {
        if (ceVar != null && ceVar.biS != null) {
            ceVar.biS.setText(this.mTbPageContext.getString(t.j.already_attentioned));
            com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_e, 1);
            ceVar.biS.setEnabled(false);
        }
    }

    private String go(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        if (i / 10000.0f <= 9999.9f) {
            return String.format("%.1fW", Float.valueOf(i / 10000.0f));
        }
        return "9999.9+W";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fk() {
        a aVar = new a(this.mTbPageContext.getPageActivity());
        aVar.cA(this.mTbPageContext.getPageActivity().getString(t.j.not_intrested));
        aVar.a(t.j.alert_yes_button, new cc(this));
        aVar.b(t.j.alert_no_button, new cd(this));
        aVar.b(this.mTbPageContext).rV();
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            Qv();
        }
        this.mSkinType = i;
    }

    private void Qv() {
        com.baidu.tbadk.core.util.at.l(this.biB, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(this.biC, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.l(this.biG, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.c(this.biD, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.at.c(this.biE, t.f.icon_frs_recommend_arrow_down);
        com.baidu.tbadk.core.util.at.c(this.biF, t.d.cp_cont_e, 1);
        for (ce ceVar : this.biI) {
            com.baidu.tbadk.core.util.at.k(ceVar.aJB, t.f.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.at.c(ceVar.aOG, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(ceVar.biQ, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(ceVar.biR, t.d.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.at.k(ceVar.biS, t.f.btn_frs_feed_forum_attention);
            if (ceVar.biS.isEnabled()) {
                com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_e, 1);
            }
        }
    }

    public void hide() {
        this.biB.setVisibility(8);
    }

    public void show() {
        this.biB.setVisibility(0);
    }
}
