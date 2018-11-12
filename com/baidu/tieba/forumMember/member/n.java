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
    public LinearLayout dyF;
    public LinearLayout dyG;
    public LinearLayout dyH;
    public LinearLayout dyI;
    public HeadImageView dyJ;
    public HeadImageView dyK;
    public HeadImageView dyL;
    public HeadImageView dyM;
    public TextView dyN;
    public TextView dyO;
    public TextView dyP;
    public TextView dyQ;
    public NoPressedLinearLayout dyR;
    public View dyS;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int h = com.baidu.adp.lib.util.l.h(BdBaseApplication.getInst().getApp(), e.C0200e.ds1);
        int color = al.getColor(e.d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(e.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dyF = (LinearLayout) view.findViewById(e.g.member1);
        this.dyJ = (HeadImageView) view.findViewById(e.g.imageview_user_photo1);
        this.dyN = (TextView) view.findViewById(e.g.textview_user_name1);
        this.dyJ.setIsRound(true);
        this.dyJ.setBorderColor(color);
        this.dyJ.setBorderWidth(h);
        this.dyJ.setOnClickListener(onClickListener);
        this.dyG = (LinearLayout) view.findViewById(e.g.member2);
        this.dyK = (HeadImageView) view.findViewById(e.g.imageview_user_photo2);
        this.dyO = (TextView) view.findViewById(e.g.textview_user_name2);
        this.dyK.setIsRound(true);
        this.dyK.setBorderColor(color);
        this.dyK.setBorderWidth(h);
        this.dyK.setOnClickListener(onClickListener);
        this.dyH = (LinearLayout) view.findViewById(e.g.member3);
        this.dyL = (HeadImageView) view.findViewById(e.g.imageview_user_photo3);
        this.dyP = (TextView) view.findViewById(e.g.textview_user_name3);
        this.dyL.setIsRound(true);
        this.dyL.setBorderColor(color);
        this.dyL.setBorderWidth(h);
        this.dyL.setOnClickListener(onClickListener);
        this.dyI = (LinearLayout) view.findViewById(e.g.member4);
        this.dyM = (HeadImageView) view.findViewById(e.g.imageview_user_photo4);
        this.dyQ = (TextView) view.findViewById(e.g.textview_user_name4);
        this.dyM.setIsRound(true);
        this.dyM.setBorderColor(color);
        this.dyM.setBorderWidth(h);
        this.dyM.setOnClickListener(onClickListener);
        this.dyR = (NoPressedLinearLayout) view.findViewById(e.g.forum_member_team_item_view);
        this.dyS = view.findViewById(e.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dyJ.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dyJ.setTag(bawuRoleInfoPub);
                    this.dyJ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dyN.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dyF.setVisibility(0);
                    return;
                case 1:
                    this.dyK.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dyK.setTag(bawuRoleInfoPub);
                    this.dyK.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dyO.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dyG.setVisibility(0);
                    return;
                case 2:
                    this.dyL.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dyL.setTag(bawuRoleInfoPub);
                    this.dyL.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dyP.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dyH.setVisibility(0);
                    return;
                case 3:
                    this.dyM.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dyM.setTag(bawuRoleInfoPub);
                    this.dyM.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dyQ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dyI.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void gk(boolean z) {
        if (this.dyJ.getVisibility() == 0) {
            this.dyJ.setIsNight(z);
            this.dyJ.refresh();
        }
        if (this.dyK.getVisibility() == 0) {
            this.dyK.setIsNight(z);
            this.dyK.refresh();
        }
        if (this.dyL.getVisibility() == 0) {
            this.dyL.setIsNight(z);
            this.dyL.refresh();
        }
        if (this.dyM.getVisibility() == 0) {
            this.dyM.setIsNight(z);
            this.dyM.refresh();
        }
    }
}
