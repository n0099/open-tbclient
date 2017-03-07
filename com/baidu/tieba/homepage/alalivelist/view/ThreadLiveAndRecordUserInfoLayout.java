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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadLiveAndRecordUserInfoLayout extends LinearLayout {
    private bj aRF;
    private boolean alI;
    private View.OnClickListener alM;
    private View.OnClickListener amj;
    public ClickableHeaderImageView bbN;
    public ViewStub bbO;
    public TextView bbP;
    public TextView bbQ;
    public TextView bbR;
    public TextView bbS;
    private View.OnClickListener bbT;
    private View.OnClickListener bbU;
    public TbImageView bbi;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bbT = new l(this);
        this.bbU = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbT = new l(this);
        this.bbU = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbT = new l(this);
        this.bbU = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(w.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bbN = (ClickableHeaderImageView) this.rootView.findViewById(w.h.imgAlaUserCover);
        this.bbO = (ViewStub) this.rootView.findViewById(w.h.vsHeadImageMask);
        this.bbP = (TextView) this.rootView.findViewById(w.h.tvAlaUserName);
        this.bbQ = (TextView) this.rootView.findViewById(w.h.tvBarName);
        this.bbS = (TextView) this.rootView.findViewById(w.h.tvCommentLabel);
        this.bbR = (TextView) this.rootView.findViewById(w.h.tvCommentNum);
        this.bbN.setDefaultResource(17170445);
        this.bbN.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbN.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbN.setRadius(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds70));
    }

    public void k(bj bjVar) {
        if (bjVar != null) {
            this.aRF = bjVar;
            if (!StringUtils.isNull(bjVar.rV())) {
                this.bbQ.setVisibility(0);
                String string = getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bjVar.rV(), 5, true));
                this.bbQ.setText(string);
                this.bbQ.setContentDescription(string);
                this.bbQ.setOnClickListener(this.bbU);
                this.bbQ.setClickable(this.alI);
            } else {
                this.bbQ.setVisibility(8);
            }
            this.bbN.setVisibility(0);
            this.bbN.setData(this.aRF);
            this.bbN.setAfterClickListener(this.amj);
            UserTbVipInfoData rR = this.aRF.rR();
            if (rR != null && rR.getvipV_url() != null && this.bbO != null) {
                if (this.bbi == null) {
                    this.bbO.inflate();
                    this.bbi = (TbImageView) this.rootView.findViewById(w.h.user_head_mask);
                }
                this.bbi.c(rR.getvipV_url(), 10, false);
                this.bbN.setIsBigV(true);
            }
            this.bbP.setVisibility(0);
            this.bbP.setOnClickListener(this.bbT);
            if (this.aRF.getAuthor() != null) {
                this.bbP.setText(this.aRF.getAuthor().getName_show());
            }
            if (this.aRF.getThreadType() == 49) {
                this.bbR.setText(au.t(this.aRF.si().audience_count));
                this.bbR.setMaxEms(9);
                this.bbS.setText(w.l.recommend_ala_live_comment_label);
                aq.i((View) this.bbR, w.e.cp_other_e);
            } else if (this.aRF.getThreadType() == 50) {
                this.bbR.setText(au.t(this.aRF.sh().play_count.intValue()));
                this.bbS.setText(w.l.recommend_ala_record_comment_label);
                aq.i((View) this.bbR, w.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.alM = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.alI = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amj = onClickListener;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        aq.i((View) this.bbQ, w.e.cp_cont_c);
        aq.j(this.rootView, w.e.cp_bg_line_d);
        aq.i((View) this.bbP, w.e.cp_cont_f);
        if (this.aRF != null && this.aRF.getThreadType() == 49) {
            aq.i((View) this.bbR, w.e.cp_other_e);
        } else if (this.aRF != null && this.aRF.getThreadType() == 50) {
            aq.i((View) this.bbR, w.e.cp_cont_c);
        }
        aq.i((View) this.bbS, w.e.cp_cont_c);
    }
}
