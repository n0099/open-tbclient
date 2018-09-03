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
import com.baidu.tieba.f;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class n extends q.a {
    public TextView djA;
    public TextView djB;
    public TextView djC;
    public TextView djD;
    public NoPressedLinearLayout djE;
    public View djF;
    public LinearLayout djs;
    public LinearLayout djt;
    public LinearLayout dju;
    public LinearLayout djv;
    public HeadImageView djw;
    public HeadImageView djx;
    public HeadImageView djy;
    public HeadImageView djz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int f = com.baidu.adp.lib.util.l.f(BdBaseApplication.getInst().getApp(), f.e.ds1);
        int color = am.getColor(f.d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(f.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.djs = (LinearLayout) view.findViewById(f.g.member1);
        this.djw = (HeadImageView) view.findViewById(f.g.imageview_user_photo1);
        this.djA = (TextView) view.findViewById(f.g.textview_user_name1);
        this.djw.setIsRound(true);
        this.djw.setBorderColor(color);
        this.djw.setBorderWidth(f);
        this.djw.setOnClickListener(onClickListener);
        this.djt = (LinearLayout) view.findViewById(f.g.member2);
        this.djx = (HeadImageView) view.findViewById(f.g.imageview_user_photo2);
        this.djB = (TextView) view.findViewById(f.g.textview_user_name2);
        this.djx.setIsRound(true);
        this.djx.setBorderColor(color);
        this.djx.setBorderWidth(f);
        this.djx.setOnClickListener(onClickListener);
        this.dju = (LinearLayout) view.findViewById(f.g.member3);
        this.djy = (HeadImageView) view.findViewById(f.g.imageview_user_photo3);
        this.djC = (TextView) view.findViewById(f.g.textview_user_name3);
        this.djy.setIsRound(true);
        this.djy.setBorderColor(color);
        this.djy.setBorderWidth(f);
        this.djy.setOnClickListener(onClickListener);
        this.djv = (LinearLayout) view.findViewById(f.g.member4);
        this.djz = (HeadImageView) view.findViewById(f.g.imageview_user_photo4);
        this.djD = (TextView) view.findViewById(f.g.textview_user_name4);
        this.djz.setIsRound(true);
        this.djz.setBorderColor(color);
        this.djz.setBorderWidth(f);
        this.djz.setOnClickListener(onClickListener);
        this.djE = (NoPressedLinearLayout) view.findViewById(f.g.forum_member_team_item_view);
        this.djF = view.findViewById(f.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.djw.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.djw.setTag(bawuRoleInfoPub);
                    this.djw.setContentDescription(bawuRoleInfoPub.user_name);
                    this.djA.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.djs.setVisibility(0);
                    return;
                case 1:
                    this.djx.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.djx.setTag(bawuRoleInfoPub);
                    this.djx.setContentDescription(bawuRoleInfoPub.user_name);
                    this.djB.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.djt.setVisibility(0);
                    return;
                case 2:
                    this.djy.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.djy.setTag(bawuRoleInfoPub);
                    this.djy.setContentDescription(bawuRoleInfoPub.user_name);
                    this.djC.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dju.setVisibility(0);
                    return;
                case 3:
                    this.djz.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.djz.setTag(bawuRoleInfoPub);
                    this.djz.setContentDescription(bawuRoleInfoPub.user_name);
                    this.djD.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.djv.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fr(boolean z) {
        if (this.djw.getVisibility() == 0) {
            this.djw.setIsNight(z);
            this.djw.refresh();
        }
        if (this.djx.getVisibility() == 0) {
            this.djx.setIsNight(z);
            this.djx.refresh();
        }
        if (this.djy.getVisibility() == 0) {
            this.djy.setIsNight(z);
            this.djy.refresh();
        }
        if (this.djz.getVisibility() == 0) {
            this.djz.setIsNight(z);
            this.djz.refresh();
        }
    }
}
