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
/* loaded from: classes8.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {
    public LinearLayout jcI;
    public LinearLayout jcJ;
    public LinearLayout jcK;
    public LinearLayout jcL;
    public HeadImageView jcM;
    public HeadImageView jcN;
    public HeadImageView jcO;
    public HeadImageView jcP;
    public TextView jcQ;
    public TextView jcR;
    public TextView jcS;
    public TextView jcT;
    public NoPressedLinearLayout jcU;
    public TextView mTitleView;

    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.jcI = (LinearLayout) view.findViewById(R.id.member1);
        this.jcM = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.jcQ = (TextView) view.findViewById(R.id.textview_user_name1);
        this.jcM.setIsRound(true);
        this.jcM.setBorderColor(color);
        this.jcM.setBorderWidth(dimens);
        this.jcM.setOnClickListener(onClickListener);
        this.jcJ = (LinearLayout) view.findViewById(R.id.member2);
        this.jcN = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.jcR = (TextView) view.findViewById(R.id.textview_user_name2);
        this.jcN.setIsRound(true);
        this.jcN.setBorderColor(color);
        this.jcN.setBorderWidth(dimens);
        this.jcN.setOnClickListener(onClickListener);
        this.jcK = (LinearLayout) view.findViewById(R.id.member3);
        this.jcO = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.jcS = (TextView) view.findViewById(R.id.textview_user_name3);
        this.jcO.setIsRound(true);
        this.jcO.setBorderColor(color);
        this.jcO.setBorderWidth(dimens);
        this.jcO.setOnClickListener(onClickListener);
        this.jcL = (LinearLayout) view.findViewById(R.id.member4);
        this.jcP = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.jcT = (TextView) view.findViewById(R.id.textview_user_name4);
        this.jcP.setIsRound(true);
        this.jcP.setBorderColor(color);
        this.jcP.setBorderWidth(dimens);
        this.jcP.setOnClickListener(onClickListener);
        this.jcU = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.jcM.startLoad(str, 12, false);
                    this.jcM.setTag(bawuRoleInfoPub);
                    this.jcM.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jcQ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jcI.setVisibility(0);
                    return;
                case 1:
                    this.jcN.startLoad(str, 12, false);
                    this.jcN.setTag(bawuRoleInfoPub);
                    this.jcN.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jcR.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jcJ.setVisibility(0);
                    return;
                case 2:
                    this.jcO.startLoad(str, 12, false);
                    this.jcO.setTag(bawuRoleInfoPub);
                    this.jcO.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jcS.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jcK.setVisibility(0);
                    return;
                case 3:
                    this.jcP.startLoad(str, 12, false);
                    this.jcP.setTag(bawuRoleInfoPub);
                    this.jcP.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jcT.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jcL.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void qn(boolean z) {
        if (this.jcM.getVisibility() == 0) {
            this.jcM.setIsNight(z);
            this.jcM.refresh();
        }
        if (this.jcN.getVisibility() == 0) {
            this.jcN.setIsNight(z);
            this.jcN.refresh();
        }
        if (this.jcO.getVisibility() == 0) {
            this.jcO.setIsNight(z);
            this.jcO.refresh();
        }
        if (this.jcP.getVisibility() == 0) {
            this.jcP.setIsNight(z);
            this.jcP.refresh();
        }
    }
}
