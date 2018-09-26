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
    public LinearLayout dpl;
    public LinearLayout dpm;
    public LinearLayout dpn;
    public LinearLayout dpo;
    public HeadImageView dpp;
    public HeadImageView dpq;
    public HeadImageView dpr;
    public HeadImageView dps;
    public TextView dpt;
    public TextView dpu;
    public TextView dpv;
    public TextView dpw;
    public NoPressedLinearLayout dpx;
    public View dpy;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int h = com.baidu.adp.lib.util.l.h(BdBaseApplication.getInst().getApp(), e.C0141e.ds1);
        int color = al.getColor(e.d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(e.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dpl = (LinearLayout) view.findViewById(e.g.member1);
        this.dpp = (HeadImageView) view.findViewById(e.g.imageview_user_photo1);
        this.dpt = (TextView) view.findViewById(e.g.textview_user_name1);
        this.dpp.setIsRound(true);
        this.dpp.setBorderColor(color);
        this.dpp.setBorderWidth(h);
        this.dpp.setOnClickListener(onClickListener);
        this.dpm = (LinearLayout) view.findViewById(e.g.member2);
        this.dpq = (HeadImageView) view.findViewById(e.g.imageview_user_photo2);
        this.dpu = (TextView) view.findViewById(e.g.textview_user_name2);
        this.dpq.setIsRound(true);
        this.dpq.setBorderColor(color);
        this.dpq.setBorderWidth(h);
        this.dpq.setOnClickListener(onClickListener);
        this.dpn = (LinearLayout) view.findViewById(e.g.member3);
        this.dpr = (HeadImageView) view.findViewById(e.g.imageview_user_photo3);
        this.dpv = (TextView) view.findViewById(e.g.textview_user_name3);
        this.dpr.setIsRound(true);
        this.dpr.setBorderColor(color);
        this.dpr.setBorderWidth(h);
        this.dpr.setOnClickListener(onClickListener);
        this.dpo = (LinearLayout) view.findViewById(e.g.member4);
        this.dps = (HeadImageView) view.findViewById(e.g.imageview_user_photo4);
        this.dpw = (TextView) view.findViewById(e.g.textview_user_name4);
        this.dps.setIsRound(true);
        this.dps.setBorderColor(color);
        this.dps.setBorderWidth(h);
        this.dps.setOnClickListener(onClickListener);
        this.dpx = (NoPressedLinearLayout) view.findViewById(e.g.forum_member_team_item_view);
        this.dpy = view.findViewById(e.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dpp.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dpp.setTag(bawuRoleInfoPub);
                    this.dpp.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dpt.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dpl.setVisibility(0);
                    return;
                case 1:
                    this.dpq.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dpq.setTag(bawuRoleInfoPub);
                    this.dpq.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dpu.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dpm.setVisibility(0);
                    return;
                case 2:
                    this.dpr.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dpr.setTag(bawuRoleInfoPub);
                    this.dpr.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dpv.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dpn.setVisibility(0);
                    return;
                case 3:
                    this.dps.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dps.setTag(bawuRoleInfoPub);
                    this.dps.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dpw.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dpo.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fI(boolean z) {
        if (this.dpp.getVisibility() == 0) {
            this.dpp.setIsNight(z);
            this.dpp.refresh();
        }
        if (this.dpq.getVisibility() == 0) {
            this.dpq.setIsNight(z);
            this.dpq.refresh();
        }
        if (this.dpr.getVisibility() == 0) {
            this.dpr.setIsNight(z);
            this.dpr.refresh();
        }
        if (this.dps.getVisibility() == 0) {
            this.dps.setIsNight(z);
            this.dps.refresh();
        }
    }
}
