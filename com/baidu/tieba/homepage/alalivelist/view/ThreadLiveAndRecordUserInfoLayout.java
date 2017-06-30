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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadLiveAndRecordUserInfoLayout extends LinearLayout {
    private View.OnClickListener amF;
    public TbImageView amQ;
    private View.OnClickListener amS;
    private boolean amx;
    public ClickableHeaderImageView bdC;
    public ViewStub bdD;
    public TextView bdE;
    public TextView bdF;
    public TextView bdG;
    public TextView bdH;
    private bm bdI;
    private View.OnClickListener bdJ;
    private View.OnClickListener bdK;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bdJ = new l(this);
        this.bdK = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdJ = new l(this);
        this.bdK = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdJ = new l(this);
        this.bdK = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(w.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bdC = (ClickableHeaderImageView) this.rootView.findViewById(w.h.imgAlaUserCover);
        this.bdD = (ViewStub) this.rootView.findViewById(w.h.vsHeadImageMask);
        this.bdE = (TextView) this.rootView.findViewById(w.h.tvAlaUserName);
        this.bdF = (TextView) this.rootView.findViewById(w.h.tvBarName);
        this.bdH = (TextView) this.rootView.findViewById(w.h.tvCommentLabel);
        this.bdG = (TextView) this.rootView.findViewById(w.h.tvCommentNum);
        this.bdC.setDefaultResource(17170445);
        this.bdC.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bdC.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bdC.setRadius(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds70));
    }

    public void t(bm bmVar) {
        if (bmVar != null) {
            this.bdI = bmVar;
            if (!StringUtils.isNull(bmVar.rw())) {
                this.bdF.setVisibility(0);
                String string = getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bmVar.rw(), 5, true));
                this.bdF.setText(string);
                this.bdF.setContentDescription(string);
                this.bdF.setOnClickListener(this.bdK);
                this.bdF.setClickable(this.amx);
            } else {
                this.bdF.setVisibility(8);
            }
            this.bdC.setVisibility(0);
            this.bdC.setData(this.bdI);
            this.bdC.setAfterClickListener(this.amS);
            UserTbVipInfoData rr = this.bdI.rr();
            if (rr != null && rr.getvipV_url() != null && this.bdD != null) {
                if (this.amQ == null) {
                    this.bdD.inflate();
                    this.amQ = (TbImageView) this.rootView.findViewById(w.h.user_head_mask);
                }
                this.amQ.c(rr.getvipV_url(), 10, false);
                this.bdC.setIsBigV(true);
            }
            this.bdE.setVisibility(0);
            this.bdE.setOnClickListener(this.bdJ);
            if (this.bdI.getAuthor() != null) {
                this.bdE.setText(this.bdI.getAuthor().getName_show());
            }
            if (this.bdI.getThreadType() == 49) {
                this.bdG.setText(aw.t(this.bdI.rJ().audience_count));
                this.bdG.setMaxEms(9);
                this.bdH.setText(w.l.recommend_ala_live_comment_label);
                as.i(this.bdG, w.e.cp_other_e);
            } else if (this.bdI.getThreadType() == 50) {
                this.bdG.setText(aw.t(this.bdI.rI().play_count.intValue()));
                this.bdH.setText(w.l.recommend_ala_record_comment_label);
                as.i(this.bdG, w.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.amF = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.amx = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amS = onClickListener;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        as.i(this.bdF, w.e.cp_cont_c);
        as.j(this.rootView, w.e.cp_bg_line_d);
        as.i(this.bdE, w.e.cp_cont_f);
        if (this.bdI != null && this.bdI.getThreadType() == 49) {
            as.i(this.bdG, w.e.cp_other_e);
        } else if (this.bdI != null && this.bdI.getThreadType() == 50) {
            as.i(this.bdG, w.e.cp_cont_c);
        }
        as.i(this.bdH, w.e.cp_cont_c);
    }
}
