package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class n extends q.a {
    public LinearLayout cVB;
    public LinearLayout cVC;
    public LinearLayout cVD;
    public LinearLayout cVE;
    public HeadImageView cVF;
    public HeadImageView cVG;
    public HeadImageView cVH;
    public HeadImageView cVI;
    public TextView cVJ;
    public TextView cVK;
    public TextView cVL;
    public TextView cVM;
    public NoPressedLinearLayout cVN;
    public View cVO;
    public TextView mTitleView;

    public n(View view2, View.OnClickListener onClickListener) {
        super(view2);
        int e = com.baidu.adp.lib.util.l.e(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = ak.getColor(d.C0126d.black_alpha10);
        this.mTitleView = (TextView) view2.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.cVB = (LinearLayout) view2.findViewById(d.g.member1);
        this.cVF = (HeadImageView) view2.findViewById(d.g.imageview_user_photo1);
        this.cVJ = (TextView) view2.findViewById(d.g.textview_user_name1);
        this.cVF.setIsRound(true);
        this.cVF.setBorderColor(color);
        this.cVF.setBorderWidth(e);
        this.cVF.setOnClickListener(onClickListener);
        this.cVC = (LinearLayout) view2.findViewById(d.g.member2);
        this.cVG = (HeadImageView) view2.findViewById(d.g.imageview_user_photo2);
        this.cVK = (TextView) view2.findViewById(d.g.textview_user_name2);
        this.cVG.setIsRound(true);
        this.cVG.setBorderColor(color);
        this.cVG.setBorderWidth(e);
        this.cVG.setOnClickListener(onClickListener);
        this.cVD = (LinearLayout) view2.findViewById(d.g.member3);
        this.cVH = (HeadImageView) view2.findViewById(d.g.imageview_user_photo3);
        this.cVL = (TextView) view2.findViewById(d.g.textview_user_name3);
        this.cVH.setIsRound(true);
        this.cVH.setBorderColor(color);
        this.cVH.setBorderWidth(e);
        this.cVH.setOnClickListener(onClickListener);
        this.cVE = (LinearLayout) view2.findViewById(d.g.member4);
        this.cVI = (HeadImageView) view2.findViewById(d.g.imageview_user_photo4);
        this.cVM = (TextView) view2.findViewById(d.g.textview_user_name4);
        this.cVI.setIsRound(true);
        this.cVI.setBorderColor(color);
        this.cVI.setBorderWidth(e);
        this.cVI.setOnClickListener(onClickListener);
        this.cVN = (NoPressedLinearLayout) view2.findViewById(d.g.forum_member_team_item_view);
        this.cVO = view2.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.cVF.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cVF.setTag(bawuRoleInfoPub);
                    this.cVF.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cVJ.setText(bawuRoleInfoPub.user_name);
                    this.cVB.setVisibility(0);
                    return;
                case 1:
                    this.cVG.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cVG.setTag(bawuRoleInfoPub);
                    this.cVG.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cVK.setText(bawuRoleInfoPub.user_name);
                    this.cVC.setVisibility(0);
                    return;
                case 2:
                    this.cVH.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cVH.setTag(bawuRoleInfoPub);
                    this.cVH.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cVL.setText(bawuRoleInfoPub.user_name);
                    this.cVD.setVisibility(0);
                    return;
                case 3:
                    this.cVI.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cVI.setTag(bawuRoleInfoPub);
                    this.cVI.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cVM.setText(bawuRoleInfoPub.user_name);
                    this.cVE.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fl(boolean z) {
        if (this.cVF.getVisibility() == 0) {
            this.cVF.setIsNight(z);
            this.cVF.refresh();
        }
        if (this.cVG.getVisibility() == 0) {
            this.cVG.setIsNight(z);
            this.cVG.refresh();
        }
        if (this.cVH.getVisibility() == 0) {
            this.cVH.setIsNight(z);
            this.cVH.refresh();
        }
        if (this.cVI.getVisibility() == 0) {
            this.cVI.setIsNight(z);
            this.cVI.refresh();
        }
    }
}
