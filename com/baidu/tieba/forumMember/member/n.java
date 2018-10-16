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
    public View dxA;
    public LinearLayout dxn;
    public LinearLayout dxo;
    public LinearLayout dxp;
    public LinearLayout dxq;
    public HeadImageView dxr;
    public HeadImageView dxs;
    public HeadImageView dxt;
    public HeadImageView dxu;
    public TextView dxv;
    public TextView dxw;
    public TextView dxx;
    public TextView dxy;
    public NoPressedLinearLayout dxz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int h = com.baidu.adp.lib.util.l.h(BdBaseApplication.getInst().getApp(), e.C0175e.ds1);
        int color = al.getColor(e.d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(e.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dxn = (LinearLayout) view.findViewById(e.g.member1);
        this.dxr = (HeadImageView) view.findViewById(e.g.imageview_user_photo1);
        this.dxv = (TextView) view.findViewById(e.g.textview_user_name1);
        this.dxr.setIsRound(true);
        this.dxr.setBorderColor(color);
        this.dxr.setBorderWidth(h);
        this.dxr.setOnClickListener(onClickListener);
        this.dxo = (LinearLayout) view.findViewById(e.g.member2);
        this.dxs = (HeadImageView) view.findViewById(e.g.imageview_user_photo2);
        this.dxw = (TextView) view.findViewById(e.g.textview_user_name2);
        this.dxs.setIsRound(true);
        this.dxs.setBorderColor(color);
        this.dxs.setBorderWidth(h);
        this.dxs.setOnClickListener(onClickListener);
        this.dxp = (LinearLayout) view.findViewById(e.g.member3);
        this.dxt = (HeadImageView) view.findViewById(e.g.imageview_user_photo3);
        this.dxx = (TextView) view.findViewById(e.g.textview_user_name3);
        this.dxt.setIsRound(true);
        this.dxt.setBorderColor(color);
        this.dxt.setBorderWidth(h);
        this.dxt.setOnClickListener(onClickListener);
        this.dxq = (LinearLayout) view.findViewById(e.g.member4);
        this.dxu = (HeadImageView) view.findViewById(e.g.imageview_user_photo4);
        this.dxy = (TextView) view.findViewById(e.g.textview_user_name4);
        this.dxu.setIsRound(true);
        this.dxu.setBorderColor(color);
        this.dxu.setBorderWidth(h);
        this.dxu.setOnClickListener(onClickListener);
        this.dxz = (NoPressedLinearLayout) view.findViewById(e.g.forum_member_team_item_view);
        this.dxA = view.findViewById(e.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dxr.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dxr.setTag(bawuRoleInfoPub);
                    this.dxr.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dxv.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dxn.setVisibility(0);
                    return;
                case 1:
                    this.dxs.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dxs.setTag(bawuRoleInfoPub);
                    this.dxs.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dxw.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dxo.setVisibility(0);
                    return;
                case 2:
                    this.dxt.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dxt.setTag(bawuRoleInfoPub);
                    this.dxt.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dxx.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dxp.setVisibility(0);
                    return;
                case 3:
                    this.dxu.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dxu.setTag(bawuRoleInfoPub);
                    this.dxu.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dxy.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dxq.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void ga(boolean z) {
        if (this.dxr.getVisibility() == 0) {
            this.dxr.setIsNight(z);
            this.dxr.refresh();
        }
        if (this.dxs.getVisibility() == 0) {
            this.dxs.setIsNight(z);
            this.dxs.refresh();
        }
        if (this.dxt.getVisibility() == 0) {
            this.dxt.setIsNight(z);
            this.dxt.refresh();
        }
        if (this.dxu.getVisibility() == 0) {
            this.dxu.setIsNight(z);
            this.dxu.refresh();
        }
    }
}
