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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ThreadLiveAndRecordUserInfoLayout extends LinearLayout {
    private bh aLS;
    public TbImageView aUV;
    public ClickableHeaderImageView aVA;
    public ViewStub aVB;
    public TextView aVC;
    public TextView aVD;
    public TextView aVE;
    public TextView aVF;
    private View.OnClickListener aVG;
    private View.OnClickListener aVH;
    private View.OnClickListener agO;
    private boolean agp;
    private View.OnClickListener agt;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.aVG = new l(this);
        this.aVH = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVG = new l(this);
        this.aVH = new m(this);
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aVG = new l(this);
        this.aVH = new m(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(r.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.aVA = (ClickableHeaderImageView) this.rootView.findViewById(r.h.imgAlaUserCover);
        this.aVB = (ViewStub) this.rootView.findViewById(r.h.vsHeadImageMask);
        this.aVC = (TextView) this.rootView.findViewById(r.h.tvAlaUserName);
        this.aVD = (TextView) this.rootView.findViewById(r.h.tvBarName);
        this.aVF = (TextView) this.rootView.findViewById(r.h.tvCommentLabel);
        this.aVE = (TextView) this.rootView.findViewById(r.h.tvCommentNum);
        this.aVA.setDefaultResource(17170445);
        this.aVA.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.aVA.setDefaultBgResource(r.e.cp_bg_line_e);
        this.aVA.setRadius(com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds70));
    }

    public void k(bh bhVar) {
        if (bhVar != null) {
            this.aLS = bhVar;
            if (!StringUtils.isNull(bhVar.rB())) {
                this.aVD.setVisibility(0);
                String string = getContext().getString(r.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bhVar.rB(), 5, true));
                this.aVD.setText(string);
                this.aVD.setContentDescription(string);
                this.aVD.setOnClickListener(this.aVH);
                this.aVD.setClickable(this.agp);
            } else {
                this.aVD.setVisibility(8);
            }
            this.aVA.setVisibility(0);
            this.aVA.setData(this.aLS);
            this.aVA.setAfterClickListener(this.agO);
            UserTbVipInfoData rx = this.aLS.rx();
            if (rx != null && rx.getvipV_url() != null && this.aVB != null) {
                if (this.aUV == null) {
                    this.aVB.inflate();
                    this.aUV = (TbImageView) this.rootView.findViewById(r.h.user_head_mask);
                }
                this.aUV.c(rx.getvipV_url(), 10, false);
                this.aVA.setIsBigV(true);
            }
            this.aVC.setVisibility(0);
            this.aVC.setOnClickListener(this.aVG);
            if (this.aLS.getAuthor() != null) {
                this.aVC.setText(this.aLS.getAuthor().getName_show());
            }
            if (this.aLS.getThreadType() == 49) {
                this.aVE.setText(at.u(this.aLS.rO().audience_count));
                this.aVE.setMaxEms(9);
                this.aVF.setText(r.l.recommend_ala_live_comment_label);
                ap.i((View) this.aVE, r.e.cp_other_e);
            } else if (this.aLS.getThreadType() == 50) {
                this.aVE.setText(at.u(this.aLS.rN().play_count.intValue()));
                this.aVF.setText(r.l.recommend_ala_record_comment_label);
                ap.i((View) this.aVE, r.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.agt = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.agp = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agO = onClickListener;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.i((View) this.aVD, r.e.cp_cont_c);
        ap.j(this.rootView, r.g.addresslist_item_bg);
        ap.i((View) this.aVC, r.e.cp_cont_f);
        if (this.aLS != null && this.aLS.getThreadType() == 49) {
            ap.i((View) this.aVE, r.e.cp_other_e);
        } else if (this.aLS != null && this.aLS.getThreadType() == 50) {
            ap.i((View) this.aVE, r.e.cp_cont_c);
        }
        ap.i((View) this.aVF, r.e.cp_cont_c);
    }
}
