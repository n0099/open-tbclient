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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bx {
    private com.baidu.tieba.tbadkCore.w MS;
    private LinearLayout bip;
    private View biq;
    private TextView bir;
    private ImageView bis;
    private TextView bit;
    private View biu;
    private List<FeedForumData> biw;
    TbPageContext<FrsActivity> mTbPageContext;
    private int mType;
    private List<cd> biv = new ArrayList();
    private Handler mHandler = new Handler();
    private int mSkinType = 3;
    private String mForumId = "";
    private boolean bix = false;
    private View.OnClickListener mOnClickListener = new by(this);
    private com.baidu.adp.base.g aWL = new bz(this);

    public bx(TbPageContext<FrsActivity> tbPageContext, View view, int i) {
        this.mType = 1;
        this.mTbPageContext = tbPageContext;
        this.bip = (LinearLayout) view.findViewById(t.g.frs_header_feed_forums);
        this.biq = view.findViewById(t.g.frs_header_feed_forums_divider);
        this.biu = view.findViewById(t.g.layout_like_feed_forum_header);
        this.bir = (TextView) this.bip.findViewById(t.g.like_feed_forums_label);
        this.bis = (ImageView) this.bip.findViewById(t.g.like_feed_forums_arrow);
        this.bis.setOnClickListener(this.mOnClickListener);
        this.bit = (TextView) this.bip.findViewById(t.g.feed_forums_more);
        this.bit.setOnClickListener(this.mOnClickListener);
        this.MS = new com.baidu.tieba.tbadkCore.w(tbPageContext);
        this.MS.setLoadDataCallBack(this.aWL);
        this.mType = i;
    }

    public void b(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if (oVar.aoE() != null && oVar.aoE().isLike() == 0) {
                hide();
                return;
            }
            if (oVar.aoE() != null) {
                this.mForumId = oVar.aoE().getId();
            }
            this.biw = oVar.aLf();
            wO();
            if (this.mType == 1 && !this.bix) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10027").aa(ImageViewerConfig.FORUM_ID, this.mForumId));
                this.bix = true;
            }
        }
    }

    public void e(String str, List<FeedForumData> list) {
        this.mForumId = str;
        this.biw = list;
        wO();
        if (this.mType == 2 && !this.bix) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10035").aa(ImageViewerConfig.FORUM_ID, this.mForumId));
            this.bix = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wO() {
        int i;
        if (com.baidu.tbadk.core.util.x.o(this.biw) == 0) {
            hide();
            return;
        }
        show();
        int size = this.biw.size() > 2 ? 2 : this.biw.size();
        int size2 = size - this.biv.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.mType == 1) {
                    i = t.h.frs_header_feed_forum_item;
                } else {
                    i = t.h.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(i, (ViewGroup) null);
                this.bip.addView(inflate);
                this.biv.add(new cd(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.biv.size() - 1;
                this.bip.removeView(this.biv.get(size3).aKv);
                this.biv.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.biw.get(i4);
            cd cdVar = this.biv.get(i4);
            if (feedForumData != null && cdVar != null) {
                cdVar.aKv.setTag(feedForumData);
                cdVar.aKv.setOnClickListener(this.mOnClickListener);
                cdVar.biB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                cdVar.biB.d(feedForumData.getAvatar(), 15, false);
                cdVar.aPr.setText(feedForumData.getForumName());
                cdVar.biC.setText(String.format(this.mTbPageContext.getPageActivity().getString(t.j.attention_post_count), gs(feedForumData.getMemberCount()), gs(feedForumData.getPostNum())));
                cdVar.biD.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    cdVar.biE.setClickable(true);
                    cdVar.biE.setOnClickListener(this.mOnClickListener);
                    cdVar.biE.setTag(feedForumData);
                    cdVar.biE.setText(t.j.attention_n);
                    cdVar.biE.setEnabled(true);
                } else {
                    a(cdVar);
                }
            }
        }
        PI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cd cdVar) {
        if (cdVar != null && cdVar.biE != null) {
            cdVar.biE.setText(this.mTbPageContext.getString(t.j.already_attentioned));
            com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_e, 1);
            cdVar.biE.setEnabled(false);
        }
    }

    private String gs(int i) {
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
    public void Gp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
        aVar.cE(this.mTbPageContext.getPageActivity().getString(t.j.not_intrested));
        aVar.a(t.j.alert_yes_button, new cb(this));
        aVar.b(t.j.alert_no_button, new cc(this));
        aVar.b(this.mTbPageContext).uj();
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            PI();
        }
        this.mSkinType = i;
    }

    private void PI() {
        com.baidu.tbadk.core.util.ar.l(this.bip, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.l(this.biq, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.l(this.biu, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.b(this.bir, t.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.ar.c(this.bis, t.f.icon_frs_recommend_arrow_down);
        com.baidu.tbadk.core.util.ar.b(this.bit, t.d.cp_cont_e, 1);
        for (cd cdVar : this.biv) {
            com.baidu.tbadk.core.util.ar.k(cdVar.aKv, t.f.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.ar.b(cdVar.aPr, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.b(cdVar.biC, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ar.b(cdVar.biD, t.d.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ar.k(cdVar.biE, t.f.btn_frs_feed_forum_attention);
            if (cdVar.biE.isEnabled()) {
                com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_e, 1);
            }
        }
    }

    public void hide() {
        this.bip.setVisibility(8);
    }

    public void show() {
        this.bip.setVisibility(0);
    }
}
