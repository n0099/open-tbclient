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
    public LinearLayout jcW;
    public LinearLayout jcX;
    public LinearLayout jcY;
    public LinearLayout jcZ;
    public HeadImageView jda;
    public HeadImageView jdb;
    public HeadImageView jdc;
    public HeadImageView jdd;
    public TextView jde;
    public TextView jdf;
    public TextView jdg;
    public TextView jdh;
    public NoPressedLinearLayout jdi;
    public TextView mTitleView;

    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.jcW = (LinearLayout) view.findViewById(R.id.member1);
        this.jda = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.jde = (TextView) view.findViewById(R.id.textview_user_name1);
        this.jda.setIsRound(true);
        this.jda.setBorderColor(color);
        this.jda.setBorderWidth(dimens);
        this.jda.setOnClickListener(onClickListener);
        this.jcX = (LinearLayout) view.findViewById(R.id.member2);
        this.jdb = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.jdf = (TextView) view.findViewById(R.id.textview_user_name2);
        this.jdb.setIsRound(true);
        this.jdb.setBorderColor(color);
        this.jdb.setBorderWidth(dimens);
        this.jdb.setOnClickListener(onClickListener);
        this.jcY = (LinearLayout) view.findViewById(R.id.member3);
        this.jdc = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.jdg = (TextView) view.findViewById(R.id.textview_user_name3);
        this.jdc.setIsRound(true);
        this.jdc.setBorderColor(color);
        this.jdc.setBorderWidth(dimens);
        this.jdc.setOnClickListener(onClickListener);
        this.jcZ = (LinearLayout) view.findViewById(R.id.member4);
        this.jdd = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.jdh = (TextView) view.findViewById(R.id.textview_user_name4);
        this.jdd.setIsRound(true);
        this.jdd.setBorderColor(color);
        this.jdd.setBorderWidth(dimens);
        this.jdd.setOnClickListener(onClickListener);
        this.jdi = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.jda.startLoad(str, 12, false);
                    this.jda.setTag(bawuRoleInfoPub);
                    this.jda.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jde.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jcW.setVisibility(0);
                    return;
                case 1:
                    this.jdb.startLoad(str, 12, false);
                    this.jdb.setTag(bawuRoleInfoPub);
                    this.jdb.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jdf.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jcX.setVisibility(0);
                    return;
                case 2:
                    this.jdc.startLoad(str, 12, false);
                    this.jdc.setTag(bawuRoleInfoPub);
                    this.jdc.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jdg.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jcY.setVisibility(0);
                    return;
                case 3:
                    this.jdd.startLoad(str, 12, false);
                    this.jdd.setTag(bawuRoleInfoPub);
                    this.jdd.setContentDescription(bawuRoleInfoPub.user_name);
                    this.jdh.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.jcZ.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void qn(boolean z) {
        if (this.jda.getVisibility() == 0) {
            this.jda.setIsNight(z);
            this.jda.refresh();
        }
        if (this.jdb.getVisibility() == 0) {
            this.jdb.setIsNight(z);
            this.jdb.refresh();
        }
        if (this.jdc.getVisibility() == 0) {
            this.jdc.setIsNight(z);
            this.jdc.refresh();
        }
        if (this.jdd.getVisibility() == 0) {
            this.jdd.setIsNight(z);
            this.jdd.refresh();
        }
    }
}
