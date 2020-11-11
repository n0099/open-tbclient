package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes23.dex */
public class n extends af.a {
    public LinearLayout iDO;
    public LinearLayout iDP;
    public LinearLayout iDQ;
    public LinearLayout iDR;
    public HeadImageView iDS;
    public HeadImageView iDT;
    public HeadImageView iDU;
    public HeadImageView iDV;
    public TextView iDW;
    public TextView iDX;
    public TextView iDY;
    public TextView iDZ;
    public NoPressedLinearLayout iEa;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.iDO = (LinearLayout) view.findViewById(R.id.member1);
        this.iDS = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.iDW = (TextView) view.findViewById(R.id.textview_user_name1);
        this.iDS.setIsRound(true);
        this.iDS.setBorderColor(color);
        this.iDS.setBorderWidth(dimens);
        this.iDS.setOnClickListener(onClickListener);
        this.iDP = (LinearLayout) view.findViewById(R.id.member2);
        this.iDT = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.iDX = (TextView) view.findViewById(R.id.textview_user_name2);
        this.iDT.setIsRound(true);
        this.iDT.setBorderColor(color);
        this.iDT.setBorderWidth(dimens);
        this.iDT.setOnClickListener(onClickListener);
        this.iDQ = (LinearLayout) view.findViewById(R.id.member3);
        this.iDU = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.iDY = (TextView) view.findViewById(R.id.textview_user_name3);
        this.iDU.setIsRound(true);
        this.iDU.setBorderColor(color);
        this.iDU.setBorderWidth(dimens);
        this.iDU.setOnClickListener(onClickListener);
        this.iDR = (LinearLayout) view.findViewById(R.id.member4);
        this.iDV = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.iDZ = (TextView) view.findViewById(R.id.textview_user_name4);
        this.iDV.setIsRound(true);
        this.iDV.setBorderColor(color);
        this.iDV.setBorderWidth(dimens);
        this.iDV.setOnClickListener(onClickListener);
        this.iEa = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        String str;
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            if (bawuRoleInfoPub.baijiahao_info != null && !TextUtils.isEmpty(bawuRoleInfoPub.baijiahao_info.avatar)) {
                str = bawuRoleInfoPub.baijiahao_info.avatar;
            } else {
                str = bawuRoleInfoPub.portrait;
            }
            switch (i) {
                case 0:
                    this.iDS.startLoad(str, 12, false);
                    this.iDS.setTag(bawuRoleInfoPub);
                    this.iDS.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iDW.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iDO.setVisibility(0);
                    return;
                case 1:
                    this.iDT.startLoad(str, 12, false);
                    this.iDT.setTag(bawuRoleInfoPub);
                    this.iDT.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iDX.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iDP.setVisibility(0);
                    return;
                case 2:
                    this.iDU.startLoad(str, 12, false);
                    this.iDU.setTag(bawuRoleInfoPub);
                    this.iDU.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iDY.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iDQ.setVisibility(0);
                    return;
                case 3:
                    this.iDV.startLoad(str, 12, false);
                    this.iDV.setTag(bawuRoleInfoPub);
                    this.iDV.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iDZ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iDR.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void pk(boolean z) {
        if (this.iDS.getVisibility() == 0) {
            this.iDS.setIsNight(z);
            this.iDS.refresh();
        }
        if (this.iDT.getVisibility() == 0) {
            this.iDT.setIsNight(z);
            this.iDT.refresh();
        }
        if (this.iDU.getVisibility() == 0) {
            this.iDU.setIsNight(z);
            this.iDU.refresh();
        }
        if (this.iDV.getVisibility() == 0) {
            this.iDV.setIsNight(z);
            this.iDV.refresh();
        }
    }
}
