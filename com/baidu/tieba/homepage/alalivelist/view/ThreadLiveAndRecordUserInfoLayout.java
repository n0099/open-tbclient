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
    private bi aRX;
    private boolean alW;
    private View.OnClickListener ama;
    private View.OnClickListener amx;
    public TbImageView bbX;
    public ClickableHeaderImageView bcC;
    public ViewStub bcD;
    public TextView bcE;
    public TextView bcF;
    public TextView bcG;
    public TextView bcH;
    private View.OnClickListener bcI;
    private View.OnClickListener bcJ;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bcI = new l(this);
        this.bcJ = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcI = new l(this);
        this.bcJ = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcI = new l(this);
        this.bcJ = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(w.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bcC = (ClickableHeaderImageView) this.rootView.findViewById(w.h.imgAlaUserCover);
        this.bcD = (ViewStub) this.rootView.findViewById(w.h.vsHeadImageMask);
        this.bcE = (TextView) this.rootView.findViewById(w.h.tvAlaUserName);
        this.bcF = (TextView) this.rootView.findViewById(w.h.tvBarName);
        this.bcH = (TextView) this.rootView.findViewById(w.h.tvCommentLabel);
        this.bcG = (TextView) this.rootView.findViewById(w.h.tvCommentNum);
        this.bcC.setDefaultResource(17170445);
        this.bcC.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bcC.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bcC.setRadius(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds70));
    }

    public void k(bi biVar) {
        if (biVar != null) {
            this.aRX = biVar;
            if (!StringUtils.isNull(biVar.st())) {
                this.bcF.setVisibility(0);
                String string = getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(biVar.st(), 5, true));
                this.bcF.setText(string);
                this.bcF.setContentDescription(string);
                this.bcF.setOnClickListener(this.bcJ);
                this.bcF.setClickable(this.alW);
            } else {
                this.bcF.setVisibility(8);
            }
            this.bcC.setVisibility(0);
            this.bcC.setData(this.aRX);
            this.bcC.setAfterClickListener(this.amx);
            UserTbVipInfoData sp = this.aRX.sp();
            if (sp != null && sp.getvipV_url() != null && this.bcD != null) {
                if (this.bbX == null) {
                    this.bcD.inflate();
                    this.bbX = (TbImageView) this.rootView.findViewById(w.h.user_head_mask);
                }
                this.bbX.c(sp.getvipV_url(), 10, false);
                this.bcC.setIsBigV(true);
            }
            this.bcE.setVisibility(0);
            this.bcE.setOnClickListener(this.bcI);
            if (this.aRX.getAuthor() != null) {
                this.bcE.setText(this.aRX.getAuthor().getName_show());
            }
            if (this.aRX.getThreadType() == 49) {
                this.bcG.setText(au.t(this.aRX.sG().audience_count));
                this.bcG.setMaxEms(9);
                this.bcH.setText(w.l.recommend_ala_live_comment_label);
                aq.i(this.bcG, w.e.cp_other_e);
            } else if (this.aRX.getThreadType() == 50) {
                this.bcG.setText(au.t(this.aRX.sF().play_count.intValue()));
                this.bcH.setText(w.l.recommend_ala_record_comment_label);
                aq.i(this.bcG, w.e.cp_cont_c);
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
        aq.i(this.bcF, w.e.cp_cont_c);
        aq.j(this.rootView, w.e.cp_bg_line_d);
        aq.i(this.bcE, w.e.cp_cont_f);
        if (this.aRX != null && this.aRX.getThreadType() == 49) {
            aq.i(this.bcG, w.e.cp_other_e);
        } else if (this.aRX != null && this.aRX.getThreadType() == 50) {
            aq.i(this.bcG, w.e.cp_cont_c);
        }
        aq.i(this.bcH, w.e.cp_cont_c);
    }
}
