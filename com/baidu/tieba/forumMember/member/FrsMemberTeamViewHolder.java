package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes7.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {
    public LinearLayout jeF;
    public LinearLayout jeG;
    public LinearLayout jeH;
    public LinearLayout jeI;
    public HeadImageView jeJ;
    public HeadImageView jeK;
    public HeadImageView jeL;
    public HeadImageView jeM;
    public TextView jeN;
    public TextView jeO;
    public TextView jeP;
    public TextView jeQ;
    public NoPressedLinearLayout jeR;
    public TextView mTitleView;

    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.jeF = (LinearLayout) view.findViewById(R.id.member1);
        this.jeJ = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.jeN = (TextView) view.findViewById(R.id.textview_user_name1);
        this.jeJ.setIsRound(true);
        this.jeJ.setBorderColor(color);
        this.jeJ.setBorderWidth(dimens);
        this.jeJ.setOnClickListener(onClickListener);
        this.jeG = (LinearLayout) view.findViewById(R.id.member2);
        this.jeK = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.jeO = (TextView) view.findViewById(R.id.textview_user_name2);
        this.jeK.setIsRound(true);
        this.jeK.setBorderColor(color);
        this.jeK.setBorderWidth(dimens);
        this.jeK.setOnClickListener(onClickListener);
        this.jeH = (LinearLayout) view.findViewById(R.id.member3);
        this.jeL = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.jeP = (TextView) view.findViewById(R.id.textview_user_name3);
        this.jeL.setIsRound(true);
        this.jeL.setBorderColor(color);
        this.jeL.setBorderWidth(dimens);
        this.jeL.setOnClickListener(onClickListener);
        this.jeI = (LinearLayout) view.findViewById(R.id.member4);
        this.jeM = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.jeQ = (TextView) view.findViewById(R.id.textview_user_name4);
        this.jeM.setIsRound(true);
        this.jeM.setBorderColor(color);
        this.jeM.setBorderWidth(dimens);
        this.jeM.setOnClickListener(onClickListener);
        this.jeR = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.jeJ.startLoad(str, 12, false);
                    this.jeJ.setTag(bawuRoleInfoPub);
                    this.jeJ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jeN.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jeF.setVisibility(0);
                    return;
                case 1:
                    this.jeK.startLoad(str, 12, false);
                    this.jeK.setTag(bawuRoleInfoPub);
                    this.jeK.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jeO.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jeG.setVisibility(0);
                    return;
                case 2:
                    this.jeL.startLoad(str, 12, false);
                    this.jeL.setTag(bawuRoleInfoPub);
                    this.jeL.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jeP.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jeH.setVisibility(0);
                    return;
                case 3:
                    this.jeM.startLoad(str, 12, false);
                    this.jeM.setTag(bawuRoleInfoPub);
                    this.jeM.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jeQ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jeI.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void qn(boolean z) {
        if (this.jeJ.getVisibility() == 0) {
            this.jeJ.setIsNight(z);
            this.jeJ.refresh();
        }
        if (this.jeK.getVisibility() == 0) {
            this.jeK.setIsNight(z);
            this.jeK.refresh();
        }
        if (this.jeL.getVisibility() == 0) {
            this.jeL.setIsNight(z);
            this.jeL.refresh();
        }
        if (this.jeM.getVisibility() == 0) {
            this.jeM.setIsNight(z);
            this.jeM.refresh();
        }
    }
}
