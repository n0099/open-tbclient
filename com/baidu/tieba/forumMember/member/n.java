package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class n extends r.a {
    public LinearLayout dBU;
    public LinearLayout dBV;
    public LinearLayout dBW;
    public LinearLayout dBX;
    public HeadImageView dBY;
    public HeadImageView dBZ;
    public HeadImageView dCa;
    public HeadImageView dCb;
    public TextView dCc;
    public TextView dCd;
    public TextView dCe;
    public TextView dCf;
    public NoPressedLinearLayout dCg;
    public View dCh;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int t = com.baidu.adp.lib.util.l.t(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = aj.getColor(d.C0140d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dBU = (LinearLayout) view.findViewById(d.g.member1);
        this.dBY = (HeadImageView) view.findViewById(d.g.imageview_user_photo1);
        this.dCc = (TextView) view.findViewById(d.g.textview_user_name1);
        this.dBY.setIsRound(true);
        this.dBY.setBorderColor(color);
        this.dBY.setBorderWidth(t);
        this.dBY.setOnClickListener(onClickListener);
        this.dBV = (LinearLayout) view.findViewById(d.g.member2);
        this.dBZ = (HeadImageView) view.findViewById(d.g.imageview_user_photo2);
        this.dCd = (TextView) view.findViewById(d.g.textview_user_name2);
        this.dBZ.setIsRound(true);
        this.dBZ.setBorderColor(color);
        this.dBZ.setBorderWidth(t);
        this.dBZ.setOnClickListener(onClickListener);
        this.dBW = (LinearLayout) view.findViewById(d.g.member3);
        this.dCa = (HeadImageView) view.findViewById(d.g.imageview_user_photo3);
        this.dCe = (TextView) view.findViewById(d.g.textview_user_name3);
        this.dCa.setIsRound(true);
        this.dCa.setBorderColor(color);
        this.dCa.setBorderWidth(t);
        this.dCa.setOnClickListener(onClickListener);
        this.dBX = (LinearLayout) view.findViewById(d.g.member4);
        this.dCb = (HeadImageView) view.findViewById(d.g.imageview_user_photo4);
        this.dCf = (TextView) view.findViewById(d.g.textview_user_name4);
        this.dCb.setIsRound(true);
        this.dCb.setBorderColor(color);
        this.dCb.setBorderWidth(t);
        this.dCb.setOnClickListener(onClickListener);
        this.dCg = (NoPressedLinearLayout) view.findViewById(d.g.forum_member_team_item_view);
        this.dCh = view.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dBY.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBY.setTag(bawuRoleInfoPub);
                    this.dBY.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dCc.setText(bawuRoleInfoPub.user_name);
                    this.dBU.setVisibility(0);
                    return;
                case 1:
                    this.dBZ.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBZ.setTag(bawuRoleInfoPub);
                    this.dBZ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dCd.setText(bawuRoleInfoPub.user_name);
                    this.dBV.setVisibility(0);
                    return;
                case 2:
                    this.dCa.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dCa.setTag(bawuRoleInfoPub);
                    this.dCa.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dCe.setText(bawuRoleInfoPub.user_name);
                    this.dBW.setVisibility(0);
                    return;
                case 3:
                    this.dCb.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dCb.setTag(bawuRoleInfoPub);
                    this.dCb.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dCf.setText(bawuRoleInfoPub.user_name);
                    this.dBX.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fF(boolean z) {
        if (this.dBY.getVisibility() == 0) {
            this.dBY.setIsNight(z);
            this.dBY.refresh();
        }
        if (this.dBZ.getVisibility() == 0) {
            this.dBZ.setIsNight(z);
            this.dBZ.refresh();
        }
        if (this.dCa.getVisibility() == 0) {
            this.dCa.setIsNight(z);
            this.dCa.refresh();
        }
        if (this.dCb.getVisibility() == 0) {
            this.dCb.setIsNight(z);
            this.dCb.refresh();
        }
    }
}
