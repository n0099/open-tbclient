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
    public LinearLayout dIC;
    public LinearLayout dID;
    public LinearLayout dIE;
    public LinearLayout dIF;
    public HeadImageView dIG;
    public HeadImageView dIH;
    public HeadImageView dII;
    public HeadImageView dIJ;
    public TextView dIK;
    public TextView dIL;
    public TextView dIM;
    public TextView dIN;
    public NoPressedLinearLayout dIO;
    public View dIP;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int h = com.baidu.adp.lib.util.l.h(BdBaseApplication.getInst().getApp(), e.C0210e.ds1);
        int color = al.getColor(e.d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(e.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dIC = (LinearLayout) view.findViewById(e.g.member1);
        this.dIG = (HeadImageView) view.findViewById(e.g.imageview_user_photo1);
        this.dIK = (TextView) view.findViewById(e.g.textview_user_name1);
        this.dIG.setIsRound(true);
        this.dIG.setBorderColor(color);
        this.dIG.setBorderWidth(h);
        this.dIG.setOnClickListener(onClickListener);
        this.dID = (LinearLayout) view.findViewById(e.g.member2);
        this.dIH = (HeadImageView) view.findViewById(e.g.imageview_user_photo2);
        this.dIL = (TextView) view.findViewById(e.g.textview_user_name2);
        this.dIH.setIsRound(true);
        this.dIH.setBorderColor(color);
        this.dIH.setBorderWidth(h);
        this.dIH.setOnClickListener(onClickListener);
        this.dIE = (LinearLayout) view.findViewById(e.g.member3);
        this.dII = (HeadImageView) view.findViewById(e.g.imageview_user_photo3);
        this.dIM = (TextView) view.findViewById(e.g.textview_user_name3);
        this.dII.setIsRound(true);
        this.dII.setBorderColor(color);
        this.dII.setBorderWidth(h);
        this.dII.setOnClickListener(onClickListener);
        this.dIF = (LinearLayout) view.findViewById(e.g.member4);
        this.dIJ = (HeadImageView) view.findViewById(e.g.imageview_user_photo4);
        this.dIN = (TextView) view.findViewById(e.g.textview_user_name4);
        this.dIJ.setIsRound(true);
        this.dIJ.setBorderColor(color);
        this.dIJ.setBorderWidth(h);
        this.dIJ.setOnClickListener(onClickListener);
        this.dIO = (NoPressedLinearLayout) view.findViewById(e.g.forum_member_team_item_view);
        this.dIP = view.findViewById(e.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dIG.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dIG.setTag(bawuRoleInfoPub);
                    this.dIG.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dIK.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dIC.setVisibility(0);
                    return;
                case 1:
                    this.dIH.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dIH.setTag(bawuRoleInfoPub);
                    this.dIH.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dIL.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dID.setVisibility(0);
                    return;
                case 2:
                    this.dII.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dII.setTag(bawuRoleInfoPub);
                    this.dII.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dIM.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dIE.setVisibility(0);
                    return;
                case 3:
                    this.dIJ.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dIJ.setTag(bawuRoleInfoPub);
                    this.dIJ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dIN.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dIF.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void gq(boolean z) {
        if (this.dIG.getVisibility() == 0) {
            this.dIG.setIsNight(z);
            this.dIG.refresh();
        }
        if (this.dIH.getVisibility() == 0) {
            this.dIH.setIsNight(z);
            this.dIH.refresh();
        }
        if (this.dII.getVisibility() == 0) {
            this.dII.setIsNight(z);
            this.dII.refresh();
        }
        if (this.dIJ.getVisibility() == 0) {
            this.dIJ.setIsNight(z);
            this.dIJ.refresh();
        }
    }
}
