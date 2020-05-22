package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class n extends aa.a {
    public LinearLayout hjV;
    public LinearLayout hjW;
    public LinearLayout hjX;
    public LinearLayout hjY;
    public HeadImageView hjZ;
    public HeadImageView hka;
    public HeadImageView hkb;
    public HeadImageView hkc;
    public TextView hkd;
    public TextView hke;
    public TextView hkf;
    public TextView hkg;
    public NoPressedLinearLayout hkh;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.hjV = (LinearLayout) view.findViewById(R.id.member1);
        this.hjZ = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.hkd = (TextView) view.findViewById(R.id.textview_user_name1);
        this.hjZ.setIsRound(true);
        this.hjZ.setBorderColor(color);
        this.hjZ.setBorderWidth(dimens);
        this.hjZ.setOnClickListener(onClickListener);
        this.hjW = (LinearLayout) view.findViewById(R.id.member2);
        this.hka = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.hke = (TextView) view.findViewById(R.id.textview_user_name2);
        this.hka.setIsRound(true);
        this.hka.setBorderColor(color);
        this.hka.setBorderWidth(dimens);
        this.hka.setOnClickListener(onClickListener);
        this.hjX = (LinearLayout) view.findViewById(R.id.member3);
        this.hkb = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.hkf = (TextView) view.findViewById(R.id.textview_user_name3);
        this.hkb.setIsRound(true);
        this.hkb.setBorderColor(color);
        this.hkb.setBorderWidth(dimens);
        this.hkb.setOnClickListener(onClickListener);
        this.hjY = (LinearLayout) view.findViewById(R.id.member4);
        this.hkc = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.hkg = (TextView) view.findViewById(R.id.textview_user_name4);
        this.hkc.setIsRound(true);
        this.hkc.setBorderColor(color);
        this.hkc.setBorderWidth(dimens);
        this.hkc.setOnClickListener(onClickListener);
        this.hkh = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.hjZ.startLoad(str, 12, false);
                    this.hjZ.setTag(bawuRoleInfoPub);
                    this.hjZ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hkd.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hjV.setVisibility(0);
                    return;
                case 1:
                    this.hka.startLoad(str, 12, false);
                    this.hka.setTag(bawuRoleInfoPub);
                    this.hka.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hke.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hjW.setVisibility(0);
                    return;
                case 2:
                    this.hkb.startLoad(str, 12, false);
                    this.hkb.setTag(bawuRoleInfoPub);
                    this.hkb.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hkf.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hjX.setVisibility(0);
                    return;
                case 3:
                    this.hkc.startLoad(str, 12, false);
                    this.hkc.setTag(bawuRoleInfoPub);
                    this.hkc.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hkg.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hjY.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void mC(boolean z) {
        if (this.hjZ.getVisibility() == 0) {
            this.hjZ.setIsNight(z);
            this.hjZ.refresh();
        }
        if (this.hka.getVisibility() == 0) {
            this.hka.setIsNight(z);
            this.hka.refresh();
        }
        if (this.hkb.getVisibility() == 0) {
            this.hkb.setIsNight(z);
            this.hkb.refresh();
        }
        if (this.hkc.getVisibility() == 0) {
            this.hkc.setIsNight(z);
            this.hkc.refresh();
        }
    }
}
