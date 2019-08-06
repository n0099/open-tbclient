package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class n extends v.a {
    public LinearLayout frj;
    public LinearLayout frk;
    public LinearLayout frl;
    public LinearLayout frm;
    public HeadImageView frn;
    public HeadImageView fro;
    public HeadImageView frp;
    public HeadImageView frq;
    public TextView frr;
    public TextView frt;
    public TextView fru;
    public TextView frv;
    public NoPressedLinearLayout frw;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int g = com.baidu.adp.lib.util.l.g(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.frj = (LinearLayout) view.findViewById(R.id.member1);
        this.frn = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.frr = (TextView) view.findViewById(R.id.textview_user_name1);
        this.frn.setIsRound(true);
        this.frn.setBorderColor(color);
        this.frn.setBorderWidth(g);
        this.frn.setOnClickListener(onClickListener);
        this.frk = (LinearLayout) view.findViewById(R.id.member2);
        this.fro = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.frt = (TextView) view.findViewById(R.id.textview_user_name2);
        this.fro.setIsRound(true);
        this.fro.setBorderColor(color);
        this.fro.setBorderWidth(g);
        this.fro.setOnClickListener(onClickListener);
        this.frl = (LinearLayout) view.findViewById(R.id.member3);
        this.frp = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.fru = (TextView) view.findViewById(R.id.textview_user_name3);
        this.frp.setIsRound(true);
        this.frp.setBorderColor(color);
        this.frp.setBorderWidth(g);
        this.frp.setOnClickListener(onClickListener);
        this.frm = (LinearLayout) view.findViewById(R.id.member4);
        this.frq = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.frv = (TextView) view.findViewById(R.id.textview_user_name4);
        this.frq.setIsRound(true);
        this.frq.setBorderColor(color);
        this.frq.setBorderWidth(g);
        this.frq.setOnClickListener(onClickListener);
        this.frw = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.frn.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.frn.setTag(bawuRoleInfoPub);
                    this.frn.setContentDescription(bawuRoleInfoPub.user_name);
                    this.frr.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.frj.setVisibility(0);
                    return;
                case 1:
                    this.fro.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fro.setTag(bawuRoleInfoPub);
                    this.fro.setContentDescription(bawuRoleInfoPub.user_name);
                    this.frt.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.frk.setVisibility(0);
                    return;
                case 2:
                    this.frp.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.frp.setTag(bawuRoleInfoPub);
                    this.frp.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fru.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.frl.setVisibility(0);
                    return;
                case 3:
                    this.frq.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.frq.setTag(bawuRoleInfoPub);
                    this.frq.setContentDescription(bawuRoleInfoPub.user_name);
                    this.frv.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.frm.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void jF(boolean z) {
        if (this.frn.getVisibility() == 0) {
            this.frn.setIsNight(z);
            this.frn.refresh();
        }
        if (this.fro.getVisibility() == 0) {
            this.fro.setIsNight(z);
            this.fro.refresh();
        }
        if (this.frp.getVisibility() == 0) {
            this.frp.setIsNight(z);
            this.frp.refresh();
        }
        if (this.frq.getVisibility() == 0) {
            this.frq.setIsNight(z);
            this.frq.refresh();
        }
    }
}
