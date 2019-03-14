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
    public LinearLayout eVO;
    public LinearLayout eVP;
    public LinearLayout eVQ;
    public LinearLayout eVR;
    public HeadImageView eVS;
    public HeadImageView eVT;
    public HeadImageView eVU;
    public HeadImageView eVV;
    public TextView eVW;
    public TextView eVX;
    public TextView eVY;
    public TextView eVZ;
    public NoPressedLinearLayout eWa;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int h = com.baidu.adp.lib.util.l.h(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = al.getColor(d.C0277d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.eVO = (LinearLayout) view.findViewById(d.g.member1);
        this.eVS = (HeadImageView) view.findViewById(d.g.imageview_user_photo1);
        this.eVW = (TextView) view.findViewById(d.g.textview_user_name1);
        this.eVS.setIsRound(true);
        this.eVS.setBorderColor(color);
        this.eVS.setBorderWidth(h);
        this.eVS.setOnClickListener(onClickListener);
        this.eVP = (LinearLayout) view.findViewById(d.g.member2);
        this.eVT = (HeadImageView) view.findViewById(d.g.imageview_user_photo2);
        this.eVX = (TextView) view.findViewById(d.g.textview_user_name2);
        this.eVT.setIsRound(true);
        this.eVT.setBorderColor(color);
        this.eVT.setBorderWidth(h);
        this.eVT.setOnClickListener(onClickListener);
        this.eVQ = (LinearLayout) view.findViewById(d.g.member3);
        this.eVU = (HeadImageView) view.findViewById(d.g.imageview_user_photo3);
        this.eVY = (TextView) view.findViewById(d.g.textview_user_name3);
        this.eVU.setIsRound(true);
        this.eVU.setBorderColor(color);
        this.eVU.setBorderWidth(h);
        this.eVU.setOnClickListener(onClickListener);
        this.eVR = (LinearLayout) view.findViewById(d.g.member4);
        this.eVV = (HeadImageView) view.findViewById(d.g.imageview_user_photo4);
        this.eVZ = (TextView) view.findViewById(d.g.textview_user_name4);
        this.eVV.setIsRound(true);
        this.eVV.setBorderColor(color);
        this.eVV.setBorderWidth(h);
        this.eVV.setOnClickListener(onClickListener);
        this.eWa = (NoPressedLinearLayout) view.findViewById(d.g.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.eVS.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.eVS.setTag(bawuRoleInfoPub);
                    this.eVS.setContentDescription(bawuRoleInfoPub.user_name);
                    this.eVW.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.eVO.setVisibility(0);
                    return;
                case 1:
                    this.eVT.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.eVT.setTag(bawuRoleInfoPub);
                    this.eVT.setContentDescription(bawuRoleInfoPub.user_name);
                    this.eVX.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.eVP.setVisibility(0);
                    return;
                case 2:
                    this.eVU.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.eVU.setTag(bawuRoleInfoPub);
                    this.eVU.setContentDescription(bawuRoleInfoPub.user_name);
                    this.eVY.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.eVQ.setVisibility(0);
                    return;
                case 3:
                    this.eVV.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.eVV.setTag(bawuRoleInfoPub);
                    this.eVV.setContentDescription(bawuRoleInfoPub.user_name);
                    this.eVZ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.eVR.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void iN(boolean z) {
        if (this.eVS.getVisibility() == 0) {
            this.eVS.setIsNight(z);
            this.eVS.refresh();
        }
        if (this.eVT.getVisibility() == 0) {
            this.eVT.setIsNight(z);
            this.eVT.refresh();
        }
        if (this.eVU.getVisibility() == 0) {
            this.eVU.setIsNight(z);
            this.eVU.refresh();
        }
        if (this.eVV.getVisibility() == 0) {
            this.eVV.setIsNight(z);
            this.eVV.refresh();
        }
    }
}
