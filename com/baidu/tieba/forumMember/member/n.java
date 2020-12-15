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
    public HeadImageView iPA;
    public HeadImageView iPB;
    public HeadImageView iPC;
    public HeadImageView iPD;
    public TextView iPE;
    public TextView iPF;
    public TextView iPG;
    public TextView iPH;
    public NoPressedLinearLayout iPI;
    public LinearLayout iPw;
    public LinearLayout iPx;
    public LinearLayout iPy;
    public LinearLayout iPz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.iPw = (LinearLayout) view.findViewById(R.id.member1);
        this.iPA = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.iPE = (TextView) view.findViewById(R.id.textview_user_name1);
        this.iPA.setIsRound(true);
        this.iPA.setBorderColor(color);
        this.iPA.setBorderWidth(dimens);
        this.iPA.setOnClickListener(onClickListener);
        this.iPx = (LinearLayout) view.findViewById(R.id.member2);
        this.iPB = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.iPF = (TextView) view.findViewById(R.id.textview_user_name2);
        this.iPB.setIsRound(true);
        this.iPB.setBorderColor(color);
        this.iPB.setBorderWidth(dimens);
        this.iPB.setOnClickListener(onClickListener);
        this.iPy = (LinearLayout) view.findViewById(R.id.member3);
        this.iPC = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.iPG = (TextView) view.findViewById(R.id.textview_user_name3);
        this.iPC.setIsRound(true);
        this.iPC.setBorderColor(color);
        this.iPC.setBorderWidth(dimens);
        this.iPC.setOnClickListener(onClickListener);
        this.iPz = (LinearLayout) view.findViewById(R.id.member4);
        this.iPD = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.iPH = (TextView) view.findViewById(R.id.textview_user_name4);
        this.iPD.setIsRound(true);
        this.iPD.setBorderColor(color);
        this.iPD.setBorderWidth(dimens);
        this.iPD.setOnClickListener(onClickListener);
        this.iPI = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.iPA.startLoad(str, 12, false);
                    this.iPA.setTag(bawuRoleInfoPub);
                    this.iPA.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iPE.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iPw.setVisibility(0);
                    return;
                case 1:
                    this.iPB.startLoad(str, 12, false);
                    this.iPB.setTag(bawuRoleInfoPub);
                    this.iPB.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iPF.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iPx.setVisibility(0);
                    return;
                case 2:
                    this.iPC.startLoad(str, 12, false);
                    this.iPC.setTag(bawuRoleInfoPub);
                    this.iPC.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iPG.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iPy.setVisibility(0);
                    return;
                case 3:
                    this.iPD.startLoad(str, 12, false);
                    this.iPD.setTag(bawuRoleInfoPub);
                    this.iPD.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iPH.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iPz.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void pK(boolean z) {
        if (this.iPA.getVisibility() == 0) {
            this.iPA.setIsNight(z);
            this.iPA.refresh();
        }
        if (this.iPB.getVisibility() == 0) {
            this.iPB.setIsNight(z);
            this.iPB.refresh();
        }
        if (this.iPC.getVisibility() == 0) {
            this.iPC.setIsNight(z);
            this.iPC.refresh();
        }
        if (this.iPD.getVisibility() == 0) {
            this.iPD.setIsNight(z);
            this.iPD.refresh();
        }
    }
}
