package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.e;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class n extends q.a {
    public LinearLayout dHS;
    public LinearLayout dHT;
    public LinearLayout dHU;
    public LinearLayout dHV;
    public HeadImageView dHW;
    public HeadImageView dHX;
    public HeadImageView dHY;
    public HeadImageView dHZ;
    public TextView dIa;
    public TextView dIb;
    public TextView dIc;
    public TextView dId;
    public NoPressedLinearLayout dIe;
    public View dIf;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int h = com.baidu.adp.lib.util.l.h(BdBaseApplication.getInst().getApp(), e.C0210e.ds1);
        int color = al.getColor(e.d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(e.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dHS = (LinearLayout) view.findViewById(e.g.member1);
        this.dHW = (HeadImageView) view.findViewById(e.g.imageview_user_photo1);
        this.dIa = (TextView) view.findViewById(e.g.textview_user_name1);
        this.dHW.setIsRound(true);
        this.dHW.setBorderColor(color);
        this.dHW.setBorderWidth(h);
        this.dHW.setOnClickListener(onClickListener);
        this.dHT = (LinearLayout) view.findViewById(e.g.member2);
        this.dHX = (HeadImageView) view.findViewById(e.g.imageview_user_photo2);
        this.dIb = (TextView) view.findViewById(e.g.textview_user_name2);
        this.dHX.setIsRound(true);
        this.dHX.setBorderColor(color);
        this.dHX.setBorderWidth(h);
        this.dHX.setOnClickListener(onClickListener);
        this.dHU = (LinearLayout) view.findViewById(e.g.member3);
        this.dHY = (HeadImageView) view.findViewById(e.g.imageview_user_photo3);
        this.dIc = (TextView) view.findViewById(e.g.textview_user_name3);
        this.dHY.setIsRound(true);
        this.dHY.setBorderColor(color);
        this.dHY.setBorderWidth(h);
        this.dHY.setOnClickListener(onClickListener);
        this.dHV = (LinearLayout) view.findViewById(e.g.member4);
        this.dHZ = (HeadImageView) view.findViewById(e.g.imageview_user_photo4);
        this.dId = (TextView) view.findViewById(e.g.textview_user_name4);
        this.dHZ.setIsRound(true);
        this.dHZ.setBorderColor(color);
        this.dHZ.setBorderWidth(h);
        this.dHZ.setOnClickListener(onClickListener);
        this.dIe = (NoPressedLinearLayout) view.findViewById(e.g.forum_member_team_item_view);
        this.dIf = view.findViewById(e.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dHW.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dHW.setTag(bawuRoleInfoPub);
                    this.dHW.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dIa.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dHS.setVisibility(0);
                    return;
                case 1:
                    this.dHX.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dHX.setTag(bawuRoleInfoPub);
                    this.dHX.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dIb.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dHT.setVisibility(0);
                    return;
                case 2:
                    this.dHY.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dHY.setTag(bawuRoleInfoPub);
                    this.dHY.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dIc.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dHU.setVisibility(0);
                    return;
                case 3:
                    this.dHZ.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dHZ.setTag(bawuRoleInfoPub);
                    this.dHZ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dId.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dHV.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void gn(boolean z) {
        if (this.dHW.getVisibility() == 0) {
            this.dHW.setIsNight(z);
            this.dHW.refresh();
        }
        if (this.dHX.getVisibility() == 0) {
            this.dHX.setIsNight(z);
            this.dHX.refresh();
        }
        if (this.dHY.getVisibility() == 0) {
            this.dHY.setIsNight(z);
            this.dHY.refresh();
        }
        if (this.dHZ.getVisibility() == 0) {
            this.dHZ.setIsNight(z);
            this.dHZ.refresh();
        }
    }
}
