package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class n extends v.a {
    public LinearLayout fsk;
    public LinearLayout fsl;
    public LinearLayout fsm;
    public LinearLayout fsn;
    public HeadImageView fso;
    public HeadImageView fsp;
    public HeadImageView fsq;
    public HeadImageView fsr;
    public TextView fss;
    public TextView fst;
    public TextView fsu;
    public TextView fsv;
    public NoPressedLinearLayout fsw;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.fsk = (LinearLayout) view.findViewById(R.id.member1);
        this.fso = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.fss = (TextView) view.findViewById(R.id.textview_user_name1);
        this.fso.setIsRound(true);
        this.fso.setBorderColor(color);
        this.fso.setBorderWidth(dimens);
        this.fso.setOnClickListener(onClickListener);
        this.fsl = (LinearLayout) view.findViewById(R.id.member2);
        this.fsp = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.fst = (TextView) view.findViewById(R.id.textview_user_name2);
        this.fsp.setIsRound(true);
        this.fsp.setBorderColor(color);
        this.fsp.setBorderWidth(dimens);
        this.fsp.setOnClickListener(onClickListener);
        this.fsm = (LinearLayout) view.findViewById(R.id.member3);
        this.fsq = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.fsu = (TextView) view.findViewById(R.id.textview_user_name3);
        this.fsq.setIsRound(true);
        this.fsq.setBorderColor(color);
        this.fsq.setBorderWidth(dimens);
        this.fsq.setOnClickListener(onClickListener);
        this.fsn = (LinearLayout) view.findViewById(R.id.member4);
        this.fsr = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.fsv = (TextView) view.findViewById(R.id.textview_user_name4);
        this.fsr.setIsRound(true);
        this.fsr.setBorderColor(color);
        this.fsr.setBorderWidth(dimens);
        this.fsr.setOnClickListener(onClickListener);
        this.fsw = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.fso.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fso.setTag(bawuRoleInfoPub);
                    this.fso.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fss.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fsk.setVisibility(0);
                    return;
                case 1:
                    this.fsp.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fsp.setTag(bawuRoleInfoPub);
                    this.fsp.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fst.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fsl.setVisibility(0);
                    return;
                case 2:
                    this.fsq.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fsq.setTag(bawuRoleInfoPub);
                    this.fsq.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fsu.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fsm.setVisibility(0);
                    return;
                case 3:
                    this.fsr.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fsr.setTag(bawuRoleInfoPub);
                    this.fsr.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fsv.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fsn.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void jw(boolean z) {
        if (this.fso.getVisibility() == 0) {
            this.fso.setIsNight(z);
            this.fso.refresh();
        }
        if (this.fsp.getVisibility() == 0) {
            this.fsp.setIsNight(z);
            this.fsp.refresh();
        }
        if (this.fsq.getVisibility() == 0) {
            this.fsq.setIsNight(z);
            this.fsq.refresh();
        }
        if (this.fsr.getVisibility() == 0) {
            this.fsr.setIsNight(z);
            this.fsr.refresh();
        }
    }
}
