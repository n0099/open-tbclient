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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadLiveAndRecordUserInfoLayout extends LinearLayout {
    private bk aSs;
    private boolean alS;
    private View.OnClickListener alY;
    public TbImageView ami;
    private View.OnClickListener amk;
    public ClickableHeaderImageView bcT;
    public ViewStub bcU;
    public TextView bcV;
    public TextView bcW;
    public TextView bcX;
    public TextView bcY;
    private View.OnClickListener bcZ;
    private View.OnClickListener bda;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bcZ = new l(this);
        this.bda = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcZ = new l(this);
        this.bda = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcZ = new l(this);
        this.bda = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(w.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bcT = (ClickableHeaderImageView) this.rootView.findViewById(w.h.imgAlaUserCover);
        this.bcU = (ViewStub) this.rootView.findViewById(w.h.vsHeadImageMask);
        this.bcV = (TextView) this.rootView.findViewById(w.h.tvAlaUserName);
        this.bcW = (TextView) this.rootView.findViewById(w.h.tvBarName);
        this.bcY = (TextView) this.rootView.findViewById(w.h.tvCommentLabel);
        this.bcX = (TextView) this.rootView.findViewById(w.h.tvCommentNum);
        this.bcT.setDefaultResource(17170445);
        this.bcT.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bcT.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bcT.setRadius(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds70));
    }

    public void p(bk bkVar) {
        if (bkVar != null) {
            this.aSs = bkVar;
            if (!StringUtils.isNull(bkVar.rD())) {
                this.bcW.setVisibility(0);
                String string = getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bkVar.rD(), 5, true));
                this.bcW.setText(string);
                this.bcW.setContentDescription(string);
                this.bcW.setOnClickListener(this.bda);
                this.bcW.setClickable(this.alS);
            } else {
                this.bcW.setVisibility(8);
            }
            this.bcT.setVisibility(0);
            this.bcT.setData(this.aSs);
            this.bcT.setAfterClickListener(this.amk);
            UserTbVipInfoData rz = this.aSs.rz();
            if (rz != null && rz.getvipV_url() != null && this.bcU != null) {
                if (this.ami == null) {
                    this.bcU.inflate();
                    this.ami = (TbImageView) this.rootView.findViewById(w.h.user_head_mask);
                }
                this.ami.c(rz.getvipV_url(), 10, false);
                this.bcT.setIsBigV(true);
            }
            this.bcV.setVisibility(0);
            this.bcV.setOnClickListener(this.bcZ);
            if (this.aSs.getAuthor() != null) {
                this.bcV.setText(this.aSs.getAuthor().getName_show());
            }
            if (this.aSs.getThreadType() == 49) {
                this.bcX.setText(au.t(this.aSs.rQ().audience_count));
                this.bcX.setMaxEms(9);
                this.bcY.setText(w.l.recommend_ala_live_comment_label);
                aq.i(this.bcX, w.e.cp_other_e);
            } else if (this.aSs.getThreadType() == 50) {
                this.bcX.setText(au.t(this.aSs.rP().play_count.intValue()));
                this.bcY.setText(w.l.recommend_ala_record_comment_label);
                aq.i(this.bcX, w.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.alY = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.alS = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amk = onClickListener;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        aq.i(this.bcW, w.e.cp_cont_c);
        aq.j(this.rootView, w.e.cp_bg_line_d);
        aq.i(this.bcV, w.e.cp_cont_f);
        if (this.aSs != null && this.aSs.getThreadType() == 49) {
            aq.i(this.bcX, w.e.cp_other_e);
        } else if (this.aSs != null && this.aSs.getThreadType() == 50) {
            aq.i(this.bcX, w.e.cp_cont_c);
        }
        aq.i(this.bcY, w.e.cp_cont_c);
    }
}
