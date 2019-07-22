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
    public LinearLayout fqK;
    public LinearLayout fqL;
    public LinearLayout fqM;
    public LinearLayout fqN;
    public HeadImageView fqO;
    public HeadImageView fqP;
    public HeadImageView fqQ;
    public HeadImageView fqR;
    public TextView fqS;
    public TextView fqT;
    public TextView fqU;
    public TextView fqV;
    public NoPressedLinearLayout fqW;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int g = com.baidu.adp.lib.util.l.g(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.fqK = (LinearLayout) view.findViewById(R.id.member1);
        this.fqO = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.fqS = (TextView) view.findViewById(R.id.textview_user_name1);
        this.fqO.setIsRound(true);
        this.fqO.setBorderColor(color);
        this.fqO.setBorderWidth(g);
        this.fqO.setOnClickListener(onClickListener);
        this.fqL = (LinearLayout) view.findViewById(R.id.member2);
        this.fqP = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.fqT = (TextView) view.findViewById(R.id.textview_user_name2);
        this.fqP.setIsRound(true);
        this.fqP.setBorderColor(color);
        this.fqP.setBorderWidth(g);
        this.fqP.setOnClickListener(onClickListener);
        this.fqM = (LinearLayout) view.findViewById(R.id.member3);
        this.fqQ = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.fqU = (TextView) view.findViewById(R.id.textview_user_name3);
        this.fqQ.setIsRound(true);
        this.fqQ.setBorderColor(color);
        this.fqQ.setBorderWidth(g);
        this.fqQ.setOnClickListener(onClickListener);
        this.fqN = (LinearLayout) view.findViewById(R.id.member4);
        this.fqR = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.fqV = (TextView) view.findViewById(R.id.textview_user_name4);
        this.fqR.setIsRound(true);
        this.fqR.setBorderColor(color);
        this.fqR.setBorderWidth(g);
        this.fqR.setOnClickListener(onClickListener);
        this.fqW = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.fqO.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fqO.setTag(bawuRoleInfoPub);
                    this.fqO.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fqS.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fqK.setVisibility(0);
                    return;
                case 1:
                    this.fqP.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fqP.setTag(bawuRoleInfoPub);
                    this.fqP.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fqT.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fqL.setVisibility(0);
                    return;
                case 2:
                    this.fqQ.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fqQ.setTag(bawuRoleInfoPub);
                    this.fqQ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fqU.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fqM.setVisibility(0);
                    return;
                case 3:
                    this.fqR.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.fqR.setTag(bawuRoleInfoPub);
                    this.fqR.setContentDescription(bawuRoleInfoPub.user_name);
                    this.fqV.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.fqN.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void jF(boolean z) {
        if (this.fqO.getVisibility() == 0) {
            this.fqO.setIsNight(z);
            this.fqO.refresh();
        }
        if (this.fqP.getVisibility() == 0) {
            this.fqP.setIsNight(z);
            this.fqP.refresh();
        }
        if (this.fqQ.getVisibility() == 0) {
            this.fqQ.setIsNight(z);
            this.fqQ.refresh();
        }
        if (this.fqR.getVisibility() == 0) {
            this.fqR.setIsNight(z);
            this.fqR.refresh();
        }
    }
}
