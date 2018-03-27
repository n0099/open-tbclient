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
    public LinearLayout dBL;
    public LinearLayout dBM;
    public LinearLayout dBN;
    public LinearLayout dBO;
    public HeadImageView dBP;
    public HeadImageView dBQ;
    public HeadImageView dBR;
    public HeadImageView dBS;
    public TextView dBT;
    public TextView dBU;
    public TextView dBV;
    public TextView dBW;
    public NoPressedLinearLayout dBX;
    public View dBY;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int t = com.baidu.adp.lib.util.l.t(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = aj.getColor(d.C0141d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dBL = (LinearLayout) view.findViewById(d.g.member1);
        this.dBP = (HeadImageView) view.findViewById(d.g.imageview_user_photo1);
        this.dBT = (TextView) view.findViewById(d.g.textview_user_name1);
        this.dBP.setIsRound(true);
        this.dBP.setBorderColor(color);
        this.dBP.setBorderWidth(t);
        this.dBP.setOnClickListener(onClickListener);
        this.dBM = (LinearLayout) view.findViewById(d.g.member2);
        this.dBQ = (HeadImageView) view.findViewById(d.g.imageview_user_photo2);
        this.dBU = (TextView) view.findViewById(d.g.textview_user_name2);
        this.dBQ.setIsRound(true);
        this.dBQ.setBorderColor(color);
        this.dBQ.setBorderWidth(t);
        this.dBQ.setOnClickListener(onClickListener);
        this.dBN = (LinearLayout) view.findViewById(d.g.member3);
        this.dBR = (HeadImageView) view.findViewById(d.g.imageview_user_photo3);
        this.dBV = (TextView) view.findViewById(d.g.textview_user_name3);
        this.dBR.setIsRound(true);
        this.dBR.setBorderColor(color);
        this.dBR.setBorderWidth(t);
        this.dBR.setOnClickListener(onClickListener);
        this.dBO = (LinearLayout) view.findViewById(d.g.member4);
        this.dBS = (HeadImageView) view.findViewById(d.g.imageview_user_photo4);
        this.dBW = (TextView) view.findViewById(d.g.textview_user_name4);
        this.dBS.setIsRound(true);
        this.dBS.setBorderColor(color);
        this.dBS.setBorderWidth(t);
        this.dBS.setOnClickListener(onClickListener);
        this.dBX = (NoPressedLinearLayout) view.findViewById(d.g.forum_member_team_item_view);
        this.dBY = view.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dBP.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBP.setTag(bawuRoleInfoPub);
                    this.dBP.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dBT.setText(bawuRoleInfoPub.user_name);
                    this.dBL.setVisibility(0);
                    return;
                case 1:
                    this.dBQ.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBQ.setTag(bawuRoleInfoPub);
                    this.dBQ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dBU.setText(bawuRoleInfoPub.user_name);
                    this.dBM.setVisibility(0);
                    return;
                case 2:
                    this.dBR.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBR.setTag(bawuRoleInfoPub);
                    this.dBR.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dBV.setText(bawuRoleInfoPub.user_name);
                    this.dBN.setVisibility(0);
                    return;
                case 3:
                    this.dBS.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBS.setTag(bawuRoleInfoPub);
                    this.dBS.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dBW.setText(bawuRoleInfoPub.user_name);
                    this.dBO.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fF(boolean z) {
        if (this.dBP.getVisibility() == 0) {
            this.dBP.setIsNight(z);
            this.dBP.refresh();
        }
        if (this.dBQ.getVisibility() == 0) {
            this.dBQ.setIsNight(z);
            this.dBQ.refresh();
        }
        if (this.dBR.getVisibility() == 0) {
            this.dBR.setIsNight(z);
            this.dBR.refresh();
        }
        if (this.dBS.getVisibility() == 0) {
            this.dBS.setIsNight(z);
            this.dBS.refresh();
        }
    }
}
