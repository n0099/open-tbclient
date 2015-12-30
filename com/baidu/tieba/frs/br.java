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
public class br {
    private com.baidu.tieba.tbadkCore.x MB;
    private LinearLayout bfH;
    private View bfI;
    private TextView bfJ;
    private ImageView bfK;
    private TextView bfL;
    private View bfM;
    private List<FeedForumData> bfO;
    TbPageContext<FrsActivity> mTbPageContext;
    private int mType;
    private List<bx> bfN = new ArrayList();
    private Handler mHandler = new Handler();
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean bfP = false;
    private View.OnClickListener mOnClickListener = new bs(this);
    private com.baidu.adp.base.g aUC = new bt(this);

    public br(TbPageContext<FrsActivity> tbPageContext, View view, int i) {
        this.mType = 1;
        this.mTbPageContext = tbPageContext;
        this.bfH = (LinearLayout) view.findViewById(n.g.frs_header_feed_forums);
        this.bfI = view.findViewById(n.g.frs_header_feed_forums_divider);
        this.bfM = view.findViewById(n.g.layout_like_feed_forum_header);
        this.bfJ = (TextView) this.bfH.findViewById(n.g.like_feed_forums_label);
        this.bfK = (ImageView) this.bfH.findViewById(n.g.like_feed_forums_arrow);
        this.bfK.setOnClickListener(this.mOnClickListener);
        this.bfL = (TextView) this.bfH.findViewById(n.g.feed_forums_more);
        this.bfL.setOnClickListener(this.mOnClickListener);
        this.MB = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.MB.setLoadDataCallBack(this.aUC);
        this.mType = i;
    }

    public void b(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if (pVar.akG() != null && pVar.akG().isLike() == 0) {
                hide();
                return;
            }
            if (pVar.akG() != null) {
                this.mForumId = pVar.akG().getId();
            }
            this.bfO = pVar.aEb();
            NI();
            if (this.mType == 1 && !this.bfP) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10027").aa(ImageViewerConfig.FORUM_ID, this.mForumId));
                this.bfP = true;
            }
        }
    }

    public void e(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.bfO = list;
        NI();
        if (this.mType == 2 && !this.bfP) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10035").aa(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.bfP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI() {
        int i;
        if (com.baidu.tbadk.core.util.y.l(this.bfO) == 0) {
            hide();
            return;
        }
        show();
        int size = this.bfO.size() > 2 ? 2 : this.bfO.size();
        int size2 = size - this.bfN.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = n.h.frs_header_feed_forum_item;
                } else {
                    i = n.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.bfH.addView(inflate);
                this.bfN.add(new bx(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.bfN.size() - 1;
                this.bfH.removeView(this.bfN.get(size3).aJq);
                this.bfN.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.bfO.get(i4);
            bx bxVar = this.bfN.get(i4);
            if (feedForumData != null && bxVar != null) {
                bxVar.aJq.setTag(feedForumData);
                bxVar.aJq.setOnClickListener(this.mOnClickListener);
                bxVar.bfT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bxVar.bfT.d(feedForumData.getAvatar(), 15, false);
                bxVar.aOn.setText(feedForumData.getForumName());
                bxVar.bfU.setText(String.format(this.mTbPageContext.getPageActivity().getString(n.j.attention_post_count), fV(feedForumData.getMemberCount()), fV(feedForumData.getPostNum())));
                bxVar.bfV.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bxVar.bfW.setClickable(true);
                    bxVar.bfW.setOnClickListener(this.mOnClickListener);
                    bxVar.bfW.setTag(feedForumData);
                    bxVar.bfW.setText(n.j.attention_n);
                    bxVar.bfW.setEnabled(true);
                } else {
                    a(bxVar);
                }
            }
        }
        NJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bx bxVar) {
        if (bxVar != null && bxVar.bfW != null) {
            bxVar.bfW.setText(this.mTbPageContext.getString(n.j.already_attentioned));
            com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_e, 1);
            bxVar.bfW.setEnabled(false);
        }
    }

    private String fV(int i) {
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
        aVar.cF(this.mTbPageContext.getPageActivity().getString(n.j.not_intrested));
        aVar.a(n.j.alert_yes_button, new bv(this));
        aVar.b(n.j.alert_no_button, new bw(this));
        aVar.b(this.mTbPageContext).tf();
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            NJ();
        }
        this.mSkinType = i;
    }

    private void NJ() {
        com.baidu.tbadk.core.util.as.j(this.bfH, n.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.j(this.bfI, n.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.j(this.bfM, n.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.b(this.bfJ, n.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.as.c(this.bfK, n.f.icon_frs_recommend_arrow_down);
        com.baidu.tbadk.core.util.as.b(this.bfL, n.d.cp_cont_e, 1);
        for (bx bxVar : this.bfN) {
            com.baidu.tbadk.core.util.as.i(bxVar.aJq, n.f.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.as.b(bxVar.aOn, n.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.as.b(bxVar.bfU, n.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.as.b(bxVar.bfV, n.d.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.as.i((View) bxVar.bfW, n.f.btn_frs_feed_forum_attention);
            if (bxVar.bfW.isEnabled()) {
                com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_e, 1);
            }
        }
    }

    public void hide() {
        this.bfH.setVisibility(8);
    }

    public void show() {
        this.bfH.setVisibility(0);
    }
}
