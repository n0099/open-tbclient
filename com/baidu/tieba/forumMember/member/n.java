package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class n extends v.a {
    public LinearLayout eVA;
    public LinearLayout eVB;
    public LinearLayout eVC;
    public LinearLayout eVD;
    public HeadImageView eVE;
    public HeadImageView eVF;
    public HeadImageView eVG;
    public HeadImageView eVH;
    public TextView eVI;
    public TextView eVJ;
    public TextView eVK;
    public TextView eVL;
    public NoPressedLinearLayout eVM;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int h = com.baidu.adp.lib.util.l.h(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = al.getColor(d.C0277d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.eVA = (LinearLayout) view.findViewById(d.g.member1);
        this.eVE = (HeadImageView) view.findViewById(d.g.imageview_user_photo1);
        this.eVI = (TextView) view.findViewById(d.g.textview_user_name1);
        this.eVE.setIsRound(true);
        this.eVE.setBorderColor(color);
        this.eVE.setBorderWidth(h);
        this.eVE.setOnClickListener(onClickListener);
        this.eVB = (LinearLayout) view.findViewById(d.g.member2);
        this.eVF = (HeadImageView) view.findViewById(d.g.imageview_user_photo2);
        this.eVJ = (TextView) view.findViewById(d.g.textview_user_name2);
        this.eVF.setIsRound(true);
        this.eVF.setBorderColor(color);
        this.eVF.setBorderWidth(h);
        this.eVF.setOnClickListener(onClickListener);
        this.eVC = (LinearLayout) view.findViewById(d.g.member3);
        this.eVG = (HeadImageView) view.findViewById(d.g.imageview_user_photo3);
        this.eVK = (TextView) view.findViewById(d.g.textview_user_name3);
        this.eVG.setIsRound(true);
        this.eVG.setBorderColor(color);
        this.eVG.setBorderWidth(h);
        this.eVG.setOnClickListener(onClickListener);
        this.eVD = (LinearLayout) view.findViewById(d.g.member4);
        this.eVH = (HeadImageView) view.findViewById(d.g.imageview_user_photo4);
        this.eVL = (TextView) view.findViewById(d.g.textview_user_name4);
        this.eVH.setIsRound(true);
        this.eVH.setBorderColor(color);
        this.eVH.setBorderWidth(h);
        this.eVH.setOnClickListener(onClickListener);
        this.eVM = (NoPressedLinearLayout) view.findViewById(d.g.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.eVE.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.eVE.setTag(bawuRoleInfoPub);
                    this.eVE.setContentDescription(bawuRoleInfoPub.user_name);
                    this.eVI.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.eVA.setVisibility(0);
                    return;
                case 1:
                    this.eVF.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.eVF.setTag(bawuRoleInfoPub);
                    this.eVF.setContentDescription(bawuRoleInfoPub.user_name);
                    this.eVJ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.eVB.setVisibility(0);
                    return;
                case 2:
                    this.eVG.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.eVG.setTag(bawuRoleInfoPub);
                    this.eVG.setContentDescription(bawuRoleInfoPub.user_name);
                    this.eVK.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.eVC.setVisibility(0);
                    return;
                case 3:
                    this.eVH.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.eVH.setTag(bawuRoleInfoPub);
                    this.eVH.setContentDescription(bawuRoleInfoPub.user_name);
                    this.eVL.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.eVD.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void iN(boolean z) {
        if (this.eVE.getVisibility() == 0) {
            this.eVE.setIsNight(z);
            this.eVE.refresh();
        }
        if (this.eVF.getVisibility() == 0) {
            this.eVF.setIsNight(z);
            this.eVF.refresh();
        }
        if (this.eVG.getVisibility() == 0) {
            this.eVG.setIsNight(z);
            this.eVG.refresh();
        }
        if (this.eVH.getVisibility() == 0) {
            this.eVH.setIsNight(z);
            this.eVH.refresh();
        }
    }
}
