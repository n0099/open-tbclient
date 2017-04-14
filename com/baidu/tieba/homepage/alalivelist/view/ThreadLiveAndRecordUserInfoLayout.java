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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadLiveAndRecordUserInfoLayout extends LinearLayout {
    private bi aRV;
    private boolean alW;
    private View.OnClickListener ama;
    private View.OnClickListener amx;
    public ClickableHeaderImageView bbG;
    public ViewStub bbH;
    public TextView bbI;
    public TextView bbJ;
    public TextView bbK;
    public TextView bbL;
    private View.OnClickListener bbM;
    private View.OnClickListener bbN;
    public TbImageView bbb;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bbM = new l(this);
        this.bbN = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbM = new l(this);
        this.bbN = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbM = new l(this);
        this.bbN = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(w.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bbG = (ClickableHeaderImageView) this.rootView.findViewById(w.h.imgAlaUserCover);
        this.bbH = (ViewStub) this.rootView.findViewById(w.h.vsHeadImageMask);
        this.bbI = (TextView) this.rootView.findViewById(w.h.tvAlaUserName);
        this.bbJ = (TextView) this.rootView.findViewById(w.h.tvBarName);
        this.bbL = (TextView) this.rootView.findViewById(w.h.tvCommentLabel);
        this.bbK = (TextView) this.rootView.findViewById(w.h.tvCommentNum);
        this.bbG.setDefaultResource(17170445);
        this.bbG.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbG.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbG.setRadius(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds70));
    }

    public void k(bi biVar) {
        if (biVar != null) {
            this.aRV = biVar;
            if (!StringUtils.isNull(biVar.st())) {
                this.bbJ.setVisibility(0);
                String string = getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(biVar.st(), 5, true));
                this.bbJ.setText(string);
                this.bbJ.setContentDescription(string);
                this.bbJ.setOnClickListener(this.bbN);
                this.bbJ.setClickable(this.alW);
            } else {
                this.bbJ.setVisibility(8);
            }
            this.bbG.setVisibility(0);
            this.bbG.setData(this.aRV);
            this.bbG.setAfterClickListener(this.amx);
            UserTbVipInfoData sp = this.aRV.sp();
            if (sp != null && sp.getvipV_url() != null && this.bbH != null) {
                if (this.bbb == null) {
                    this.bbH.inflate();
                    this.bbb = (TbImageView) this.rootView.findViewById(w.h.user_head_mask);
                }
                this.bbb.c(sp.getvipV_url(), 10, false);
                this.bbG.setIsBigV(true);
            }
            this.bbI.setVisibility(0);
            this.bbI.setOnClickListener(this.bbM);
            if (this.aRV.getAuthor() != null) {
                this.bbI.setText(this.aRV.getAuthor().getName_show());
            }
            if (this.aRV.getThreadType() == 49) {
                this.bbK.setText(au.t(this.aRV.sG().audience_count));
                this.bbK.setMaxEms(9);
                this.bbL.setText(w.l.recommend_ala_live_comment_label);
                aq.i(this.bbK, w.e.cp_other_e);
            } else if (this.aRV.getThreadType() == 50) {
                this.bbK.setText(au.t(this.aRV.sF().play_count.intValue()));
                this.bbL.setText(w.l.recommend_ala_record_comment_label);
                aq.i(this.bbK, w.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ama = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.alW = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amx = onClickListener;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        aq.i(this.bbJ, w.e.cp_cont_c);
        aq.j(this.rootView, w.e.cp_bg_line_d);
        aq.i(this.bbI, w.e.cp_cont_f);
        if (this.aRV != null && this.aRV.getThreadType() == 49) {
            aq.i(this.bbK, w.e.cp_other_e);
        } else if (this.aRV != null && this.aRV.getThreadType() == 50) {
            aq.i(this.bbK, w.e.cp_cont_c);
        }
        aq.i(this.bbL, w.e.cp_cont_c);
    }
}
