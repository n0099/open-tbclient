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
    public HeadImageView frA;
    public TextView frB;
    public TextView frC;
    public TextView frD;
    public TextView frE;
    public NoPressedLinearLayout frF;
    public LinearLayout frt;
    public LinearLayout fru;
    public LinearLayout frv;
    public LinearLayout frw;
    public HeadImageView frx;
    public HeadImageView fry;
    public HeadImageView frz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.frt = (LinearLayout) view.findViewById(R.id.member1);
        this.frx = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.frB = (TextView) view.findViewById(R.id.textview_user_name1);
        this.frx.setIsRound(true);
        this.frx.setBorderColor(color);
        this.frx.setBorderWidth(dimens);
        this.frx.setOnClickListener(onClickListener);
        this.fru = (LinearLayout) view.findViewById(R.id.member2);
        this.fry = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.frC = (TextView) view.findViewById(R.id.textview_user_name2);
        this.fry.setIsRound(true);
        this.fry.setBorderColor(color);
        this.fry.setBorderWidth(dimens);
        this.fry.setOnClickListener(onClickListener);
        this.frv = (LinearLayout) view.findViewById(R.id.member3);
        this.frz = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.frD = (TextView) view.findViewById(R.id.textview_user_name3);
        this.frz.setIsRound(true);
        this.frz.setBorderColor(color);
        this.frz.setBorderWidth(dimens);
        this.frz.setOnClickListener(onClickListener);
        this.frw = (LinearLayout) view.findViewById(R.id.member4);
        this.frA = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.frE = (TextView) view.findViewById(R.id.textview_user_name4);
        this.frA.setIsRound(true);
        this.frA.setBorderColor(color);
        this.frA.setBorderWidth(dimens);
        this.frA.setOnClickListener(onClickListener);
        this.frF = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.frx.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.frx.setTag(bawuRoleInfoPub);
                    this.frx.setContentDescription(bawuRoleInfoPub.user_name);
                    this.frB.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.frt.setVisibility(0);
                    return;
                case 1:
                    this.fry.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fry.setTag(bawuRoleInfoPub);
                    this.fry.setContentDescription(bawuRoleInfoPub.user_name);
                    this.frC.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fru.setVisibility(0);
                    return;
                case 2:
                    this.frz.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.frz.setTag(bawuRoleInfoPub);
                    this.frz.setContentDescription(bawuRoleInfoPub.user_name);
                    this.frD.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.frv.setVisibility(0);
                    return;
                case 3:
                    this.frA.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.frA.setTag(bawuRoleInfoPub);
                    this.frA.setContentDescription(bawuRoleInfoPub.user_name);
                    this.frE.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.frw.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void jw(boolean z) {
        if (this.frx.getVisibility() == 0) {
            this.frx.setIsNight(z);
            this.frx.refresh();
        }
        if (this.fry.getVisibility() == 0) {
            this.fry.setIsNight(z);
            this.fry.refresh();
        }
        if (this.frz.getVisibility() == 0) {
            this.frz.setIsNight(z);
            this.frz.refresh();
        }
        if (this.frA.getVisibility() == 0) {
            this.frA.setIsNight(z);
            this.frA.refresh();
        }
    }
}
