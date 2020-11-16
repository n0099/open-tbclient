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
    public LinearLayout iEC;
    public LinearLayout iED;
    public LinearLayout iEE;
    public LinearLayout iEF;
    public HeadImageView iEG;
    public HeadImageView iEH;
    public HeadImageView iEI;
    public HeadImageView iEJ;
    public TextView iEK;
    public TextView iEL;
    public TextView iEM;
    public TextView iEN;
    public NoPressedLinearLayout iEO;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.iEC = (LinearLayout) view.findViewById(R.id.member1);
        this.iEG = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.iEK = (TextView) view.findViewById(R.id.textview_user_name1);
        this.iEG.setIsRound(true);
        this.iEG.setBorderColor(color);
        this.iEG.setBorderWidth(dimens);
        this.iEG.setOnClickListener(onClickListener);
        this.iED = (LinearLayout) view.findViewById(R.id.member2);
        this.iEH = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.iEL = (TextView) view.findViewById(R.id.textview_user_name2);
        this.iEH.setIsRound(true);
        this.iEH.setBorderColor(color);
        this.iEH.setBorderWidth(dimens);
        this.iEH.setOnClickListener(onClickListener);
        this.iEE = (LinearLayout) view.findViewById(R.id.member3);
        this.iEI = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.iEM = (TextView) view.findViewById(R.id.textview_user_name3);
        this.iEI.setIsRound(true);
        this.iEI.setBorderColor(color);
        this.iEI.setBorderWidth(dimens);
        this.iEI.setOnClickListener(onClickListener);
        this.iEF = (LinearLayout) view.findViewById(R.id.member4);
        this.iEJ = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.iEN = (TextView) view.findViewById(R.id.textview_user_name4);
        this.iEJ.setIsRound(true);
        this.iEJ.setBorderColor(color);
        this.iEJ.setBorderWidth(dimens);
        this.iEJ.setOnClickListener(onClickListener);
        this.iEO = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.iEG.startLoad(str, 12, false);
                    this.iEG.setTag(bawuRoleInfoPub);
                    this.iEG.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iEK.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iEC.setVisibility(0);
                    return;
                case 1:
                    this.iEH.startLoad(str, 12, false);
                    this.iEH.setTag(bawuRoleInfoPub);
                    this.iEH.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iEL.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iED.setVisibility(0);
                    return;
                case 2:
                    this.iEI.startLoad(str, 12, false);
                    this.iEI.setTag(bawuRoleInfoPub);
                    this.iEI.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iEM.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iEE.setVisibility(0);
                    return;
                case 3:
                    this.iEJ.startLoad(str, 12, false);
                    this.iEJ.setTag(bawuRoleInfoPub);
                    this.iEJ.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iEN.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iEF.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void pn(boolean z) {
        if (this.iEG.getVisibility() == 0) {
            this.iEG.setIsNight(z);
            this.iEG.refresh();
        }
        if (this.iEH.getVisibility() == 0) {
            this.iEH.setIsNight(z);
            this.iEH.refresh();
        }
        if (this.iEI.getVisibility() == 0) {
            this.iEI.setIsNight(z);
            this.iEI.refresh();
        }
        if (this.iEJ.getVisibility() == 0) {
            this.iEJ.setIsNight(z);
            this.iEJ.refresh();
        }
    }
}
