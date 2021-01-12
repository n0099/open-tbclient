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
/* loaded from: classes7.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {
    public LinearLayout iXb;
    public LinearLayout iXc;
    public LinearLayout iXd;
    public LinearLayout iXe;
    public HeadImageView iXf;
    public HeadImageView iXg;
    public HeadImageView iXh;
    public HeadImageView iXi;
    public TextView iXj;
    public TextView iXk;
    public TextView iXl;
    public TextView iXm;
    public NoPressedLinearLayout iXn;
    public TextView mTitleView;

    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ao.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.iXb = (LinearLayout) view.findViewById(R.id.member1);
        this.iXf = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.iXj = (TextView) view.findViewById(R.id.textview_user_name1);
        this.iXf.setIsRound(true);
        this.iXf.setBorderColor(color);
        this.iXf.setBorderWidth(dimens);
        this.iXf.setOnClickListener(onClickListener);
        this.iXc = (LinearLayout) view.findViewById(R.id.member2);
        this.iXg = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.iXk = (TextView) view.findViewById(R.id.textview_user_name2);
        this.iXg.setIsRound(true);
        this.iXg.setBorderColor(color);
        this.iXg.setBorderWidth(dimens);
        this.iXg.setOnClickListener(onClickListener);
        this.iXd = (LinearLayout) view.findViewById(R.id.member3);
        this.iXh = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.iXl = (TextView) view.findViewById(R.id.textview_user_name3);
        this.iXh.setIsRound(true);
        this.iXh.setBorderColor(color);
        this.iXh.setBorderWidth(dimens);
        this.iXh.setOnClickListener(onClickListener);
        this.iXe = (LinearLayout) view.findViewById(R.id.member4);
        this.iXi = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.iXm = (TextView) view.findViewById(R.id.textview_user_name4);
        this.iXi.setIsRound(true);
        this.iXi.setBorderColor(color);
        this.iXi.setBorderWidth(dimens);
        this.iXi.setOnClickListener(onClickListener);
        this.iXn = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.iXf.startLoad(str, 12, false);
                    this.iXf.setTag(bawuRoleInfoPub);
                    this.iXf.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iXj.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iXb.setVisibility(0);
                    return;
                case 1:
                    this.iXg.startLoad(str, 12, false);
                    this.iXg.setTag(bawuRoleInfoPub);
                    this.iXg.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iXk.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iXc.setVisibility(0);
                    return;
                case 2:
                    this.iXh.startLoad(str, 12, false);
                    this.iXh.setTag(bawuRoleInfoPub);
                    this.iXh.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iXl.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iXd.setVisibility(0);
                    return;
                case 3:
                    this.iXi.startLoad(str, 12, false);
                    this.iXi.setTag(bawuRoleInfoPub);
                    this.iXi.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iXm.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iXe.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void qd(boolean z) {
        if (this.iXf.getVisibility() == 0) {
            this.iXf.setIsNight(z);
            this.iXf.refresh();
        }
        if (this.iXg.getVisibility() == 0) {
            this.iXg.setIsNight(z);
            this.iXg.refresh();
        }
        if (this.iXh.getVisibility() == 0) {
            this.iXh.setIsNight(z);
            this.iXh.refresh();
        }
        if (this.iXi.getVisibility() == 0) {
            this.iXi.setIsNight(z);
            this.iXi.refresh();
        }
    }
}
