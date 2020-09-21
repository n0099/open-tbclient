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
/* loaded from: classes22.dex */
public class n extends af.a {
    public HeadImageView hWA;
    public HeadImageView hWB;
    public TextView hWC;
    public TextView hWD;
    public TextView hWE;
    public TextView hWF;
    public NoPressedLinearLayout hWG;
    public LinearLayout hWu;
    public LinearLayout hWv;
    public LinearLayout hWw;
    public LinearLayout hWx;
    public HeadImageView hWy;
    public HeadImageView hWz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.hWu = (LinearLayout) view.findViewById(R.id.member1);
        this.hWy = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.hWC = (TextView) view.findViewById(R.id.textview_user_name1);
        this.hWy.setIsRound(true);
        this.hWy.setBorderColor(color);
        this.hWy.setBorderWidth(dimens);
        this.hWy.setOnClickListener(onClickListener);
        this.hWv = (LinearLayout) view.findViewById(R.id.member2);
        this.hWz = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.hWD = (TextView) view.findViewById(R.id.textview_user_name2);
        this.hWz.setIsRound(true);
        this.hWz.setBorderColor(color);
        this.hWz.setBorderWidth(dimens);
        this.hWz.setOnClickListener(onClickListener);
        this.hWw = (LinearLayout) view.findViewById(R.id.member3);
        this.hWA = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.hWE = (TextView) view.findViewById(R.id.textview_user_name3);
        this.hWA.setIsRound(true);
        this.hWA.setBorderColor(color);
        this.hWA.setBorderWidth(dimens);
        this.hWA.setOnClickListener(onClickListener);
        this.hWx = (LinearLayout) view.findViewById(R.id.member4);
        this.hWB = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.hWF = (TextView) view.findViewById(R.id.textview_user_name4);
        this.hWB.setIsRound(true);
        this.hWB.setBorderColor(color);
        this.hWB.setBorderWidth(dimens);
        this.hWB.setOnClickListener(onClickListener);
        this.hWG = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.hWy.startLoad(str, 12, false);
                    this.hWy.setTag(bawuRoleInfoPub);
                    this.hWy.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hWC.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hWu.setVisibility(0);
                    return;
                case 1:
                    this.hWz.startLoad(str, 12, false);
                    this.hWz.setTag(bawuRoleInfoPub);
                    this.hWz.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hWD.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hWv.setVisibility(0);
                    return;
                case 2:
                    this.hWA.startLoad(str, 12, false);
                    this.hWA.setTag(bawuRoleInfoPub);
                    this.hWA.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hWE.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hWw.setVisibility(0);
                    return;
                case 3:
                    this.hWB.startLoad(str, 12, false);
                    this.hWB.setTag(bawuRoleInfoPub);
                    this.hWB.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hWF.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hWx.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void oe(boolean z) {
        if (this.hWy.getVisibility() == 0) {
            this.hWy.setIsNight(z);
            this.hWy.refresh();
        }
        if (this.hWz.getVisibility() == 0) {
            this.hWz.setIsNight(z);
            this.hWz.refresh();
        }
        if (this.hWA.getVisibility() == 0) {
            this.hWA.setIsNight(z);
            this.hWA.refresh();
        }
        if (this.hWB.getVisibility() == 0) {
            this.hWB.setIsNight(z);
            this.hWB.refresh();
        }
    }
}
