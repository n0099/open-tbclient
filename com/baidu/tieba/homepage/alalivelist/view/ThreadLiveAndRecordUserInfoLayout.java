package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadLiveAndRecordUserInfoLayout extends LinearLayout {
    private boolean alI;
    private View.OnClickListener alO;
    public TbImageView alY;
    private View.OnClickListener ama;
    public ViewStub bbA;
    public TextView bbB;
    public TextView bbC;
    public TextView bbD;
    public TextView bbE;
    private bl bbF;
    private View.OnClickListener bbG;
    private View.OnClickListener bbH;
    public ClickableHeaderImageView bbz;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bbG = new l(this);
        this.bbH = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbG = new l(this);
        this.bbH = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbG = new l(this);
        this.bbH = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(w.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bbz = (ClickableHeaderImageView) this.rootView.findViewById(w.h.imgAlaUserCover);
        this.bbA = (ViewStub) this.rootView.findViewById(w.h.vsHeadImageMask);
        this.bbB = (TextView) this.rootView.findViewById(w.h.tvAlaUserName);
        this.bbC = (TextView) this.rootView.findViewById(w.h.tvBarName);
        this.bbE = (TextView) this.rootView.findViewById(w.h.tvCommentLabel);
        this.bbD = (TextView) this.rootView.findViewById(w.h.tvCommentNum);
        this.bbz.setDefaultResource(17170445);
        this.bbz.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbz.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbz.setRadius(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds70));
    }

    public void r(bl blVar) {
        if (blVar != null) {
            this.bbF = blVar;
            if (!StringUtils.isNull(blVar.rz())) {
                this.bbC.setVisibility(0);
                String string = getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(blVar.rz(), 5, true));
                this.bbC.setText(string);
                this.bbC.setContentDescription(string);
                this.bbC.setOnClickListener(this.bbH);
                this.bbC.setClickable(this.alI);
            } else {
                this.bbC.setVisibility(8);
            }
            this.bbz.setVisibility(0);
            this.bbz.setData(this.bbF);
            this.bbz.setAfterClickListener(this.ama);
            UserTbVipInfoData rv = this.bbF.rv();
            if (rv != null && rv.getvipV_url() != null && this.bbA != null) {
                if (this.alY == null) {
                    this.bbA.inflate();
                    this.alY = (TbImageView) this.rootView.findViewById(w.h.user_head_mask);
                }
                this.alY.c(rv.getvipV_url(), 10, false);
                this.bbz.setIsBigV(true);
            }
            this.bbB.setVisibility(0);
            this.bbB.setOnClickListener(this.bbG);
            if (this.bbF.getAuthor() != null) {
                this.bbB.setText(this.bbF.getAuthor().getName_show());
            }
            if (this.bbF.getThreadType() == 49) {
                this.bbD.setText(au.t(this.bbF.rM().audience_count));
                this.bbD.setMaxEms(9);
                this.bbE.setText(w.l.recommend_ala_live_comment_label);
                aq.i(this.bbD, w.e.cp_other_e);
            } else if (this.bbF.getThreadType() == 50) {
                this.bbD.setText(au.t(this.bbF.rL().play_count.intValue()));
                this.bbE.setText(w.l.recommend_ala_record_comment_label);
                aq.i(this.bbD, w.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.alO = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.alI = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ama = onClickListener;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        aq.i(this.bbC, w.e.cp_cont_c);
        aq.j(this.rootView, w.e.cp_bg_line_d);
        aq.i(this.bbB, w.e.cp_cont_f);
        if (this.bbF != null && this.bbF.getThreadType() == 49) {
            aq.i(this.bbD, w.e.cp_other_e);
        } else if (this.bbF != null && this.bbF.getThreadType() == 50) {
            aq.i(this.bbD, w.e.cp_cont_c);
        }
        aq.i(this.bbE, w.e.cp_cont_c);
    }
}
