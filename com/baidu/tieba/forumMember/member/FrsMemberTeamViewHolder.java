package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes8.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {
    public LinearLayout jbI;
    public LinearLayout jbJ;
    public LinearLayout jbK;
    public LinearLayout jbL;
    public HeadImageView jbM;
    public HeadImageView jbN;
    public HeadImageView jbO;
    public HeadImageView jbP;
    public TextView jbQ;
    public TextView jbR;
    public TextView jbS;
    public TextView jbT;
    public NoPressedLinearLayout jbU;
    public TextView mTitleView;

    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ao.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.jbI = (LinearLayout) view.findViewById(R.id.member1);
        this.jbM = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.jbQ = (TextView) view.findViewById(R.id.textview_user_name1);
        this.jbM.setIsRound(true);
        this.jbM.setBorderColor(color);
        this.jbM.setBorderWidth(dimens);
        this.jbM.setOnClickListener(onClickListener);
        this.jbJ = (LinearLayout) view.findViewById(R.id.member2);
        this.jbN = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.jbR = (TextView) view.findViewById(R.id.textview_user_name2);
        this.jbN.setIsRound(true);
        this.jbN.setBorderColor(color);
        this.jbN.setBorderWidth(dimens);
        this.jbN.setOnClickListener(onClickListener);
        this.jbK = (LinearLayout) view.findViewById(R.id.member3);
        this.jbO = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.jbS = (TextView) view.findViewById(R.id.textview_user_name3);
        this.jbO.setIsRound(true);
        this.jbO.setBorderColor(color);
        this.jbO.setBorderWidth(dimens);
        this.jbO.setOnClickListener(onClickListener);
        this.jbL = (LinearLayout) view.findViewById(R.id.member4);
        this.jbP = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.jbT = (TextView) view.findViewById(R.id.textview_user_name4);
        this.jbP.setIsRound(true);
        this.jbP.setBorderColor(color);
        this.jbP.setBorderWidth(dimens);
        this.jbP.setOnClickListener(onClickListener);
        this.jbU = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.jbM.startLoad(str, 12, false);
                    this.jbM.setTag(bawuRoleInfoPub);
                    this.jbM.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jbQ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jbI.setVisibility(0);
                    return;
                case 1:
                    this.jbN.startLoad(str, 12, false);
                    this.jbN.setTag(bawuRoleInfoPub);
                    this.jbN.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jbR.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jbJ.setVisibility(0);
                    return;
                case 2:
                    this.jbO.startLoad(str, 12, false);
                    this.jbO.setTag(bawuRoleInfoPub);
                    this.jbO.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jbS.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jbK.setVisibility(0);
                    return;
                case 3:
                    this.jbP.startLoad(str, 12, false);
                    this.jbP.setTag(bawuRoleInfoPub);
                    this.jbP.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jbT.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jbL.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void qh(boolean z) {
        if (this.jbM.getVisibility() == 0) {
            this.jbM.setIsNight(z);
            this.jbM.refresh();
        }
        if (this.jbN.getVisibility() == 0) {
            this.jbN.setIsNight(z);
            this.jbN.refresh();
        }
        if (this.jbO.getVisibility() == 0) {
            this.jbO.setIsNight(z);
            this.jbO.refresh();
        }
        if (this.jbP.getVisibility() == 0) {
            this.jbP.setIsNight(z);
            this.jbP.refresh();
        }
    }
}
