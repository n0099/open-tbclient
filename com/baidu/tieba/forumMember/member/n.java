package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class n extends q.a {
    public LinearLayout dgE;
    public LinearLayout dgF;
    public LinearLayout dgG;
    public LinearLayout dgH;
    public HeadImageView dgI;
    public HeadImageView dgJ;
    public HeadImageView dgK;
    public HeadImageView dgL;
    public TextView dgM;
    public TextView dgN;
    public TextView dgO;
    public TextView dgP;
    public NoPressedLinearLayout dgQ;
    public View dgR;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int e = com.baidu.adp.lib.util.l.e(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = am.getColor(d.C0142d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dgE = (LinearLayout) view.findViewById(d.g.member1);
        this.dgI = (HeadImageView) view.findViewById(d.g.imageview_user_photo1);
        this.dgM = (TextView) view.findViewById(d.g.textview_user_name1);
        this.dgI.setIsRound(true);
        this.dgI.setBorderColor(color);
        this.dgI.setBorderWidth(e);
        this.dgI.setOnClickListener(onClickListener);
        this.dgF = (LinearLayout) view.findViewById(d.g.member2);
        this.dgJ = (HeadImageView) view.findViewById(d.g.imageview_user_photo2);
        this.dgN = (TextView) view.findViewById(d.g.textview_user_name2);
        this.dgJ.setIsRound(true);
        this.dgJ.setBorderColor(color);
        this.dgJ.setBorderWidth(e);
        this.dgJ.setOnClickListener(onClickListener);
        this.dgG = (LinearLayout) view.findViewById(d.g.member3);
        this.dgK = (HeadImageView) view.findViewById(d.g.imageview_user_photo3);
        this.dgO = (TextView) view.findViewById(d.g.textview_user_name3);
        this.dgK.setIsRound(true);
        this.dgK.setBorderColor(color);
        this.dgK.setBorderWidth(e);
        this.dgK.setOnClickListener(onClickListener);
        this.dgH = (LinearLayout) view.findViewById(d.g.member4);
        this.dgL = (HeadImageView) view.findViewById(d.g.imageview_user_photo4);
        this.dgP = (TextView) view.findViewById(d.g.textview_user_name4);
        this.dgL.setIsRound(true);
        this.dgL.setBorderColor(color);
        this.dgL.setBorderWidth(e);
        this.dgL.setOnClickListener(onClickListener);
        this.dgQ = (NoPressedLinearLayout) view.findViewById(d.g.forum_member_team_item_view);
        this.dgR = view.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dgI.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dgI.setTag(bawuRoleInfoPub);
                    this.dgI.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dgM.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dgE.setVisibility(0);
                    return;
                case 1:
                    this.dgJ.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dgJ.setTag(bawuRoleInfoPub);
                    this.dgJ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dgN.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dgF.setVisibility(0);
                    return;
                case 2:
                    this.dgK.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dgK.setTag(bawuRoleInfoPub);
                    this.dgK.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dgO.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dgG.setVisibility(0);
                    return;
                case 3:
                    this.dgL.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dgL.setTag(bawuRoleInfoPub);
                    this.dgL.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dgP.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dgH.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fq(boolean z) {
        if (this.dgI.getVisibility() == 0) {
            this.dgI.setIsNight(z);
            this.dgI.refresh();
        }
        if (this.dgJ.getVisibility() == 0) {
            this.dgJ.setIsNight(z);
            this.dgJ.refresh();
        }
        if (this.dgK.getVisibility() == 0) {
            this.dgK.setIsNight(z);
            this.dgK.refresh();
        }
        if (this.dgL.getVisibility() == 0) {
            this.dgL.setIsNight(z);
            this.dgL.refresh();
        }
    }
}
