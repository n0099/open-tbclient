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
    public HeadImageView djA;
    public HeadImageView djB;
    public TextView djC;
    public TextView djD;
    public TextView djE;
    public TextView djF;
    public NoPressedLinearLayout djG;
    public View djH;
    public LinearLayout dju;
    public LinearLayout djv;
    public LinearLayout djw;
    public LinearLayout djx;
    public HeadImageView djy;
    public HeadImageView djz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int f = com.baidu.adp.lib.util.l.f(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = am.getColor(d.C0140d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dju = (LinearLayout) view.findViewById(d.g.member1);
        this.djy = (HeadImageView) view.findViewById(d.g.imageview_user_photo1);
        this.djC = (TextView) view.findViewById(d.g.textview_user_name1);
        this.djy.setIsRound(true);
        this.djy.setBorderColor(color);
        this.djy.setBorderWidth(f);
        this.djy.setOnClickListener(onClickListener);
        this.djv = (LinearLayout) view.findViewById(d.g.member2);
        this.djz = (HeadImageView) view.findViewById(d.g.imageview_user_photo2);
        this.djD = (TextView) view.findViewById(d.g.textview_user_name2);
        this.djz.setIsRound(true);
        this.djz.setBorderColor(color);
        this.djz.setBorderWidth(f);
        this.djz.setOnClickListener(onClickListener);
        this.djw = (LinearLayout) view.findViewById(d.g.member3);
        this.djA = (HeadImageView) view.findViewById(d.g.imageview_user_photo3);
        this.djE = (TextView) view.findViewById(d.g.textview_user_name3);
        this.djA.setIsRound(true);
        this.djA.setBorderColor(color);
        this.djA.setBorderWidth(f);
        this.djA.setOnClickListener(onClickListener);
        this.djx = (LinearLayout) view.findViewById(d.g.member4);
        this.djB = (HeadImageView) view.findViewById(d.g.imageview_user_photo4);
        this.djF = (TextView) view.findViewById(d.g.textview_user_name4);
        this.djB.setIsRound(true);
        this.djB.setBorderColor(color);
        this.djB.setBorderWidth(f);
        this.djB.setOnClickListener(onClickListener);
        this.djG = (NoPressedLinearLayout) view.findViewById(d.g.forum_member_team_item_view);
        this.djH = view.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.djy.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.djy.setTag(bawuRoleInfoPub);
                    this.djy.setContentDescription(bawuRoleInfoPub.user_name);
                    this.djC.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dju.setVisibility(0);
                    return;
                case 1:
                    this.djz.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.djz.setTag(bawuRoleInfoPub);
                    this.djz.setContentDescription(bawuRoleInfoPub.user_name);
                    this.djD.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.djv.setVisibility(0);
                    return;
                case 2:
                    this.djA.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.djA.setTag(bawuRoleInfoPub);
                    this.djA.setContentDescription(bawuRoleInfoPub.user_name);
                    this.djE.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.djw.setVisibility(0);
                    return;
                case 3:
                    this.djB.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.djB.setTag(bawuRoleInfoPub);
                    this.djB.setContentDescription(bawuRoleInfoPub.user_name);
                    this.djF.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.djx.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fr(boolean z) {
        if (this.djy.getVisibility() == 0) {
            this.djy.setIsNight(z);
            this.djy.refresh();
        }
        if (this.djz.getVisibility() == 0) {
            this.djz.setIsNight(z);
            this.djz.refresh();
        }
        if (this.djA.getVisibility() == 0) {
            this.djA.setIsNight(z);
            this.djA.refresh();
        }
        if (this.djB.getVisibility() == 0) {
            this.djB.setIsNight(z);
            this.djB.refresh();
        }
    }
}
