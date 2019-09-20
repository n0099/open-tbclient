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
    public LinearLayout fsX;
    public LinearLayout fsY;
    public LinearLayout fsZ;
    public LinearLayout fta;
    public HeadImageView ftb;
    public HeadImageView ftc;
    public HeadImageView ftd;
    public HeadImageView fte;
    public TextView ftf;
    public TextView ftg;
    public TextView fth;
    public TextView fti;
    public NoPressedLinearLayout ftj;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int g = com.baidu.adp.lib.util.l.g(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.fsX = (LinearLayout) view.findViewById(R.id.member1);
        this.ftb = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.ftf = (TextView) view.findViewById(R.id.textview_user_name1);
        this.ftb.setIsRound(true);
        this.ftb.setBorderColor(color);
        this.ftb.setBorderWidth(g);
        this.ftb.setOnClickListener(onClickListener);
        this.fsY = (LinearLayout) view.findViewById(R.id.member2);
        this.ftc = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.ftg = (TextView) view.findViewById(R.id.textview_user_name2);
        this.ftc.setIsRound(true);
        this.ftc.setBorderColor(color);
        this.ftc.setBorderWidth(g);
        this.ftc.setOnClickListener(onClickListener);
        this.fsZ = (LinearLayout) view.findViewById(R.id.member3);
        this.ftd = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.fth = (TextView) view.findViewById(R.id.textview_user_name3);
        this.ftd.setIsRound(true);
        this.ftd.setBorderColor(color);
        this.ftd.setBorderWidth(g);
        this.ftd.setOnClickListener(onClickListener);
        this.fta = (LinearLayout) view.findViewById(R.id.member4);
        this.fte = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.fti = (TextView) view.findViewById(R.id.textview_user_name4);
        this.fte.setIsRound(true);
        this.fte.setBorderColor(color);
        this.fte.setBorderWidth(g);
        this.fte.setOnClickListener(onClickListener);
        this.ftj = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.ftb.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.ftb.setTag(bawuRoleInfoPub);
                    this.ftb.setContentDescription(bawuRoleInfoPub.user_name);
                    this.ftf.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fsX.setVisibility(0);
                    return;
                case 1:
                    this.ftc.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.ftc.setTag(bawuRoleInfoPub);
                    this.ftc.setContentDescription(bawuRoleInfoPub.user_name);
                    this.ftg.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fsY.setVisibility(0);
                    return;
                case 2:
                    this.ftd.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.ftd.setTag(bawuRoleInfoPub);
                    this.ftd.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fth.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fsZ.setVisibility(0);
                    return;
                case 3:
                    this.fte.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fte.setTag(bawuRoleInfoPub);
                    this.fte.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fti.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fta.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void jI(boolean z) {
        if (this.ftb.getVisibility() == 0) {
            this.ftb.setIsNight(z);
            this.ftb.refresh();
        }
        if (this.ftc.getVisibility() == 0) {
            this.ftc.setIsNight(z);
            this.ftc.refresh();
        }
        if (this.ftd.getVisibility() == 0) {
            this.ftd.setIsNight(z);
            this.ftd.refresh();
        }
        if (this.fte.getVisibility() == 0) {
            this.fte.setIsNight(z);
            this.fte.refresh();
        }
    }
}
