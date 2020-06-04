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
    public LinearLayout hkg;
    public LinearLayout hkh;
    public LinearLayout hki;
    public LinearLayout hkj;
    public HeadImageView hkk;
    public HeadImageView hkl;
    public HeadImageView hkm;
    public HeadImageView hkn;
    public TextView hko;
    public TextView hkp;
    public TextView hkq;
    public TextView hkr;
    public NoPressedLinearLayout hks;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.hkg = (LinearLayout) view.findViewById(R.id.member1);
        this.hkk = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.hko = (TextView) view.findViewById(R.id.textview_user_name1);
        this.hkk.setIsRound(true);
        this.hkk.setBorderColor(color);
        this.hkk.setBorderWidth(dimens);
        this.hkk.setOnClickListener(onClickListener);
        this.hkh = (LinearLayout) view.findViewById(R.id.member2);
        this.hkl = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.hkp = (TextView) view.findViewById(R.id.textview_user_name2);
        this.hkl.setIsRound(true);
        this.hkl.setBorderColor(color);
        this.hkl.setBorderWidth(dimens);
        this.hkl.setOnClickListener(onClickListener);
        this.hki = (LinearLayout) view.findViewById(R.id.member3);
        this.hkm = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.hkq = (TextView) view.findViewById(R.id.textview_user_name3);
        this.hkm.setIsRound(true);
        this.hkm.setBorderColor(color);
        this.hkm.setBorderWidth(dimens);
        this.hkm.setOnClickListener(onClickListener);
        this.hkj = (LinearLayout) view.findViewById(R.id.member4);
        this.hkn = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.hkr = (TextView) view.findViewById(R.id.textview_user_name4);
        this.hkn.setIsRound(true);
        this.hkn.setBorderColor(color);
        this.hkn.setBorderWidth(dimens);
        this.hkn.setOnClickListener(onClickListener);
        this.hks = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.hkk.startLoad(str, 12, false);
                    this.hkk.setTag(bawuRoleInfoPub);
                    this.hkk.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hko.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hkg.setVisibility(0);
                    return;
                case 1:
                    this.hkl.startLoad(str, 12, false);
                    this.hkl.setTag(bawuRoleInfoPub);
                    this.hkl.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hkp.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hkh.setVisibility(0);
                    return;
                case 2:
                    this.hkm.startLoad(str, 12, false);
                    this.hkm.setTag(bawuRoleInfoPub);
                    this.hkm.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hkq.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hki.setVisibility(0);
                    return;
                case 3:
                    this.hkn.startLoad(str, 12, false);
                    this.hkn.setTag(bawuRoleInfoPub);
                    this.hkn.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hkr.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hkj.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void mC(boolean z) {
        if (this.hkk.getVisibility() == 0) {
            this.hkk.setIsNight(z);
            this.hkk.refresh();
        }
        if (this.hkl.getVisibility() == 0) {
            this.hkl.setIsNight(z);
            this.hkl.refresh();
        }
        if (this.hkm.getVisibility() == 0) {
            this.hkm.setIsNight(z);
            this.hkm.refresh();
        }
        if (this.hkn.getVisibility() == 0) {
            this.hkn.setIsNight(z);
            this.hkn.refresh();
        }
    }
}
