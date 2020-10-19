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
    public HeadImageView ilA;
    public TextView ilB;
    public TextView ilC;
    public TextView ilD;
    public TextView ilE;
    public NoPressedLinearLayout ilF;
    public LinearLayout ilt;
    public LinearLayout ilu;
    public LinearLayout ilv;
    public LinearLayout ilw;
    public HeadImageView ilx;
    public HeadImageView ily;
    public HeadImageView ilz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.ilt = (LinearLayout) view.findViewById(R.id.member1);
        this.ilx = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.ilB = (TextView) view.findViewById(R.id.textview_user_name1);
        this.ilx.setIsRound(true);
        this.ilx.setBorderColor(color);
        this.ilx.setBorderWidth(dimens);
        this.ilx.setOnClickListener(onClickListener);
        this.ilu = (LinearLayout) view.findViewById(R.id.member2);
        this.ily = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.ilC = (TextView) view.findViewById(R.id.textview_user_name2);
        this.ily.setIsRound(true);
        this.ily.setBorderColor(color);
        this.ily.setBorderWidth(dimens);
        this.ily.setOnClickListener(onClickListener);
        this.ilv = (LinearLayout) view.findViewById(R.id.member3);
        this.ilz = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.ilD = (TextView) view.findViewById(R.id.textview_user_name3);
        this.ilz.setIsRound(true);
        this.ilz.setBorderColor(color);
        this.ilz.setBorderWidth(dimens);
        this.ilz.setOnClickListener(onClickListener);
        this.ilw = (LinearLayout) view.findViewById(R.id.member4);
        this.ilA = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.ilE = (TextView) view.findViewById(R.id.textview_user_name4);
        this.ilA.setIsRound(true);
        this.ilA.setBorderColor(color);
        this.ilA.setBorderWidth(dimens);
        this.ilA.setOnClickListener(onClickListener);
        this.ilF = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.ilx.startLoad(str, 12, false);
                    this.ilx.setTag(bawuRoleInfoPub);
                    this.ilx.setContentDescription(bawuRoleInfoPub.user_name);
                    this.ilB.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.ilt.setVisibility(0);
                    return;
                case 1:
                    this.ily.startLoad(str, 12, false);
                    this.ily.setTag(bawuRoleInfoPub);
                    this.ily.setContentDescription(bawuRoleInfoPub.user_name);
                    this.ilC.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.ilu.setVisibility(0);
                    return;
                case 2:
                    this.ilz.startLoad(str, 12, false);
                    this.ilz.setTag(bawuRoleInfoPub);
                    this.ilz.setContentDescription(bawuRoleInfoPub.user_name);
                    this.ilD.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.ilv.setVisibility(0);
                    return;
                case 3:
                    this.ilA.startLoad(str, 12, false);
                    this.ilA.setTag(bawuRoleInfoPub);
                    this.ilA.setContentDescription(bawuRoleInfoPub.user_name);
                    this.ilE.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.ilw.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void oJ(boolean z) {
        if (this.ilx.getVisibility() == 0) {
            this.ilx.setIsNight(z);
            this.ilx.refresh();
        }
        if (this.ily.getVisibility() == 0) {
            this.ily.setIsNight(z);
            this.ily.refresh();
        }
        if (this.ilz.getVisibility() == 0) {
            this.ilz.setIsNight(z);
            this.ilz.refresh();
        }
        if (this.ilA.getVisibility() == 0) {
            this.ilA.setIsNight(z);
            this.ilA.refresh();
        }
    }
}
