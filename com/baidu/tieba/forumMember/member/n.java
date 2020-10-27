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
    public LinearLayout ixR;
    public LinearLayout ixS;
    public LinearLayout ixT;
    public LinearLayout ixU;
    public HeadImageView ixV;
    public HeadImageView ixW;
    public HeadImageView ixX;
    public HeadImageView ixY;
    public TextView ixZ;
    public TextView iya;
    public TextView iyb;
    public TextView iyc;
    public NoPressedLinearLayout iyd;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.ixR = (LinearLayout) view.findViewById(R.id.member1);
        this.ixV = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.ixZ = (TextView) view.findViewById(R.id.textview_user_name1);
        this.ixV.setIsRound(true);
        this.ixV.setBorderColor(color);
        this.ixV.setBorderWidth(dimens);
        this.ixV.setOnClickListener(onClickListener);
        this.ixS = (LinearLayout) view.findViewById(R.id.member2);
        this.ixW = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.iya = (TextView) view.findViewById(R.id.textview_user_name2);
        this.ixW.setIsRound(true);
        this.ixW.setBorderColor(color);
        this.ixW.setBorderWidth(dimens);
        this.ixW.setOnClickListener(onClickListener);
        this.ixT = (LinearLayout) view.findViewById(R.id.member3);
        this.ixX = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.iyb = (TextView) view.findViewById(R.id.textview_user_name3);
        this.ixX.setIsRound(true);
        this.ixX.setBorderColor(color);
        this.ixX.setBorderWidth(dimens);
        this.ixX.setOnClickListener(onClickListener);
        this.ixU = (LinearLayout) view.findViewById(R.id.member4);
        this.ixY = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.iyc = (TextView) view.findViewById(R.id.textview_user_name4);
        this.ixY.setIsRound(true);
        this.ixY.setBorderColor(color);
        this.ixY.setBorderWidth(dimens);
        this.ixY.setOnClickListener(onClickListener);
        this.iyd = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.ixV.startLoad(str, 12, false);
                    this.ixV.setTag(bawuRoleInfoPub);
                    this.ixV.setContentDescription(bawuRoleInfoPub.user_name);
                    this.ixZ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.ixR.setVisibility(0);
                    return;
                case 1:
                    this.ixW.startLoad(str, 12, false);
                    this.ixW.setTag(bawuRoleInfoPub);
                    this.ixW.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iya.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.ixS.setVisibility(0);
                    return;
                case 2:
                    this.ixX.startLoad(str, 12, false);
                    this.ixX.setTag(bawuRoleInfoPub);
                    this.ixX.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iyb.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.ixT.setVisibility(0);
                    return;
                case 3:
                    this.ixY.startLoad(str, 12, false);
                    this.ixY.setTag(bawuRoleInfoPub);
                    this.ixY.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iyc.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.ixU.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void pb(boolean z) {
        if (this.ixV.getVisibility() == 0) {
            this.ixV.setIsNight(z);
            this.ixV.refresh();
        }
        if (this.ixW.getVisibility() == 0) {
            this.ixW.setIsNight(z);
            this.ixW.refresh();
        }
        if (this.ixX.getVisibility() == 0) {
            this.ixX.setIsNight(z);
            this.ixX.refresh();
        }
        if (this.ixY.getVisibility() == 0) {
            this.ixY.setIsNight(z);
            this.ixY.refresh();
        }
    }
}
