package com.baidu.tieba.frs;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bo {
    private com.baidu.tieba.tbadkCore.x Ml;
    private LinearLayout bbI;
    private View bbJ;
    private TextView bbK;
    private ImageView bbL;
    private TextView bbM;
    private View bbN;
    private List<FeedForumData> bbP;
    TbPageContext<FrsActivity> mTbPageContext;
    private int mType;
    private List<bu> bbO = new ArrayList();
    private Handler mHandler = new Handler();
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean bbQ = false;
    private View.OnClickListener mOnClickListener = new bp(this);
    private com.baidu.adp.base.g aQL = new bq(this);

    public bo(TbPageContext<FrsActivity> tbPageContext, View view, int i) {
        this.mType = 1;
        this.mTbPageContext = tbPageContext;
        this.bbI = (LinearLayout) view.findViewById(n.f.frs_header_feed_forums);
        this.bbJ = view.findViewById(n.f.frs_header_feed_forums_divider);
        this.bbN = view.findViewById(n.f.layout_like_feed_forum_header);
        this.bbK = (TextView) this.bbI.findViewById(n.f.like_feed_forums_label);
        this.bbL = (ImageView) this.bbI.findViewById(n.f.like_feed_forums_arrow);
        this.bbL.setOnClickListener(this.mOnClickListener);
        this.bbM = (TextView) this.bbI.findViewById(n.f.feed_forums_more);
        this.bbM.setOnClickListener(this.mOnClickListener);
        this.Ml = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.Ml.setLoadDataCallBack(this.aQL);
        this.mType = i;
    }

    public void b(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if (pVar.ajy() != null && pVar.ajy().isLike() == 0) {
                hide();
                return;
            }
            if (pVar.ajy() != null) {
                this.mForumId = pVar.ajy().getId();
            }
            this.bbP = pVar.aBT();
            Np();
            if (this.mType == 1 && !this.bbQ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10027").ab(ImageViewerConfig.FORUM_ID, this.mForumId));
                this.bbQ = true;
            }
        }
    }

    public void e(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.bbP = list;
        Np();
        if (this.mType == 2 && !this.bbQ) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10035").ab(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.bbQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Np() {
        int i;
        if (com.baidu.tbadk.core.util.y.k(this.bbP) == 0) {
            hide();
            return;
        }
        show();
        int size = this.bbP.size() > 2 ? 2 : this.bbP.size();
        int size2 = size - this.bbO.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = n.g.frs_header_feed_forum_item;
                } else {
                    i = n.g.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.bbI.addView(inflate);
                this.bbO.add(new bu(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.bbO.size() - 1;
                this.bbI.removeView(this.bbO.get(size3).aHS);
                this.bbO.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.bbP.get(i4);
            bu buVar = this.bbO.get(i4);
            if (feedForumData != null && buVar != null) {
                buVar.aHS.setTag(feedForumData);
                buVar.aHS.setOnClickListener(this.mOnClickListener);
                buVar.bbU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                buVar.bbU.d(feedForumData.getAvatar(), 15, false);
                buVar.aUB.setText(feedForumData.getForumName());
                buVar.bbV.setText(String.format(this.mTbPageContext.getPageActivity().getString(n.i.attention_post_count), ga(feedForumData.getMemberCount()), ga(feedForumData.getPostNum())));
                buVar.bbW.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    buVar.bbX.setClickable(true);
                    buVar.bbX.setOnClickListener(this.mOnClickListener);
                    buVar.bbX.setTag(feedForumData);
                    buVar.bbX.setText(n.i.attention_n);
                    buVar.bbX.setEnabled(true);
                } else {
                    a(buVar);
                }
            }
        }
        Nq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bu buVar) {
        if (buVar != null && buVar.bbX != null) {
            buVar.bbX.setText(this.mTbPageContext.getString(n.i.already_attentioned));
            com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_e, 1);
            buVar.bbX.setEnabled(false);
        }
    }

    private String ga(int i) {
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
    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.cC(this.mTbPageContext.getPageActivity().getString(n.i.not_intrested));
        aVar.a(n.i.alert_yes_button, new bs(this));
        aVar.b(n.i.alert_no_button, new bt(this));
        aVar.b(this.mTbPageContext).tv();
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            Nq();
        }
        this.mSkinType = i;
    }

    private void Nq() {
        com.baidu.tbadk.core.util.as.j(this.bbI, n.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.j(this.bbJ, n.c.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.j(this.bbN, n.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.b(this.bbK, n.c.cp_cont_c, 1);
        com.baidu.tbadk.core.util.as.c(this.bbL, n.e.icon_frs_recommend_arrow_down);
        com.baidu.tbadk.core.util.as.b(this.bbM, n.c.cp_cont_e, 1);
        for (bu buVar : this.bbO) {
            com.baidu.tbadk.core.util.as.i(buVar.aHS, n.e.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.as.b(buVar.aUB, n.c.cp_cont_b, 1);
            com.baidu.tbadk.core.util.as.b(buVar.bbV, n.c.cp_cont_c, 1);
            com.baidu.tbadk.core.util.as.b(buVar.bbW, n.c.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_i, 1);
            com.baidu.tbadk.core.util.as.i((View) buVar.bbX, n.e.btn_frs_feed_forum_attention);
            if (buVar.bbX.isEnabled()) {
                com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_e, 1);
            }
        }
    }

    public void hide() {
        this.bbI.setVisibility(8);
    }

    public void show() {
        this.bbI.setVisibility(0);
    }
}
