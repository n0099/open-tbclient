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
    public LinearLayout dBI;
    public LinearLayout dBJ;
    public LinearLayout dBK;
    public LinearLayout dBL;
    public HeadImageView dBM;
    public HeadImageView dBN;
    public HeadImageView dBO;
    public HeadImageView dBP;
    public TextView dBQ;
    public TextView dBR;
    public TextView dBS;
    public TextView dBT;
    public NoPressedLinearLayout dBU;
    public View dBV;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int t = com.baidu.adp.lib.util.l.t(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = aj.getColor(d.C0141d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dBI = (LinearLayout) view.findViewById(d.g.member1);
        this.dBM = (HeadImageView) view.findViewById(d.g.imageview_user_photo1);
        this.dBQ = (TextView) view.findViewById(d.g.textview_user_name1);
        this.dBM.setIsRound(true);
        this.dBM.setBorderColor(color);
        this.dBM.setBorderWidth(t);
        this.dBM.setOnClickListener(onClickListener);
        this.dBJ = (LinearLayout) view.findViewById(d.g.member2);
        this.dBN = (HeadImageView) view.findViewById(d.g.imageview_user_photo2);
        this.dBR = (TextView) view.findViewById(d.g.textview_user_name2);
        this.dBN.setIsRound(true);
        this.dBN.setBorderColor(color);
        this.dBN.setBorderWidth(t);
        this.dBN.setOnClickListener(onClickListener);
        this.dBK = (LinearLayout) view.findViewById(d.g.member3);
        this.dBO = (HeadImageView) view.findViewById(d.g.imageview_user_photo3);
        this.dBS = (TextView) view.findViewById(d.g.textview_user_name3);
        this.dBO.setIsRound(true);
        this.dBO.setBorderColor(color);
        this.dBO.setBorderWidth(t);
        this.dBO.setOnClickListener(onClickListener);
        this.dBL = (LinearLayout) view.findViewById(d.g.member4);
        this.dBP = (HeadImageView) view.findViewById(d.g.imageview_user_photo4);
        this.dBT = (TextView) view.findViewById(d.g.textview_user_name4);
        this.dBP.setIsRound(true);
        this.dBP.setBorderColor(color);
        this.dBP.setBorderWidth(t);
        this.dBP.setOnClickListener(onClickListener);
        this.dBU = (NoPressedLinearLayout) view.findViewById(d.g.forum_member_team_item_view);
        this.dBV = view.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dBM.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBM.setTag(bawuRoleInfoPub);
                    this.dBM.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dBQ.setText(bawuRoleInfoPub.user_name);
                    this.dBI.setVisibility(0);
                    return;
                case 1:
                    this.dBN.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBN.setTag(bawuRoleInfoPub);
                    this.dBN.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dBR.setText(bawuRoleInfoPub.user_name);
                    this.dBJ.setVisibility(0);
                    return;
                case 2:
                    this.dBO.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBO.setTag(bawuRoleInfoPub);
                    this.dBO.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dBS.setText(bawuRoleInfoPub.user_name);
                    this.dBK.setVisibility(0);
                    return;
                case 3:
                    this.dBP.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dBP.setTag(bawuRoleInfoPub);
                    this.dBP.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dBT.setText(bawuRoleInfoPub.user_name);
                    this.dBL.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fF(boolean z) {
        if (this.dBM.getVisibility() == 0) {
            this.dBM.setIsNight(z);
            this.dBM.refresh();
        }
        if (this.dBN.getVisibility() == 0) {
            this.dBN.setIsNight(z);
            this.dBN.refresh();
        }
        if (this.dBO.getVisibility() == 0) {
            this.dBO.setIsNight(z);
            this.dBO.refresh();
        }
        if (this.dBP.getVisibility() == 0) {
            this.dBP.setIsNight(z);
            this.dBP.refresh();
        }
    }
}
