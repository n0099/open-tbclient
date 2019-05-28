package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class n extends v.a {
    public LinearLayout flM;
    public LinearLayout flN;
    public LinearLayout flO;
    public LinearLayout flP;
    public HeadImageView flQ;
    public HeadImageView flR;
    public HeadImageView flS;
    public HeadImageView flT;
    public TextView flU;
    public TextView flV;
    public TextView flW;
    public TextView flX;
    public NoPressedLinearLayout flY;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int g = com.baidu.adp.lib.util.l.g(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = al.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.flM = (LinearLayout) view.findViewById(R.id.member1);
        this.flQ = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.flU = (TextView) view.findViewById(R.id.textview_user_name1);
        this.flQ.setIsRound(true);
        this.flQ.setBorderColor(color);
        this.flQ.setBorderWidth(g);
        this.flQ.setOnClickListener(onClickListener);
        this.flN = (LinearLayout) view.findViewById(R.id.member2);
        this.flR = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.flV = (TextView) view.findViewById(R.id.textview_user_name2);
        this.flR.setIsRound(true);
        this.flR.setBorderColor(color);
        this.flR.setBorderWidth(g);
        this.flR.setOnClickListener(onClickListener);
        this.flO = (LinearLayout) view.findViewById(R.id.member3);
        this.flS = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.flW = (TextView) view.findViewById(R.id.textview_user_name3);
        this.flS.setIsRound(true);
        this.flS.setBorderColor(color);
        this.flS.setBorderWidth(g);
        this.flS.setOnClickListener(onClickListener);
        this.flP = (LinearLayout) view.findViewById(R.id.member4);
        this.flT = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.flX = (TextView) view.findViewById(R.id.textview_user_name4);
        this.flT.setIsRound(true);
        this.flT.setBorderColor(color);
        this.flT.setBorderWidth(g);
        this.flT.setOnClickListener(onClickListener);
        this.flY = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.flQ.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.flQ.setTag(bawuRoleInfoPub);
                    this.flQ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.flU.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.flM.setVisibility(0);
                    return;
                case 1:
                    this.flR.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.flR.setTag(bawuRoleInfoPub);
                    this.flR.setContentDescription(bawuRoleInfoPub.user_name);
                    this.flV.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.flN.setVisibility(0);
                    return;
                case 2:
                    this.flS.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.flS.setTag(bawuRoleInfoPub);
                    this.flS.setContentDescription(bawuRoleInfoPub.user_name);
                    this.flW.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.flO.setVisibility(0);
                    return;
                case 3:
                    this.flT.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.flT.setTag(bawuRoleInfoPub);
                    this.flT.setContentDescription(bawuRoleInfoPub.user_name);
                    this.flX.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.flP.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void jv(boolean z) {
        if (this.flQ.getVisibility() == 0) {
            this.flQ.setIsNight(z);
            this.flQ.refresh();
        }
        if (this.flR.getVisibility() == 0) {
            this.flR.setIsNight(z);
            this.flR.refresh();
        }
        if (this.flS.getVisibility() == 0) {
            this.flS.setIsNight(z);
            this.flS.refresh();
        }
        if (this.flT.getVisibility() == 0) {
            this.flT.setIsNight(z);
            this.flT.refresh();
        }
    }
}
