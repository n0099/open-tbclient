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
    public TextView iPC;
    public TextView iPD;
    public TextView iPE;
    public TextView iPF;
    public NoPressedLinearLayout iPG;
    public LinearLayout iPu;
    public LinearLayout iPv;
    public LinearLayout iPw;
    public LinearLayout iPx;
    public HeadImageView iPy;
    public HeadImageView iPz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.iPu = (LinearLayout) view.findViewById(R.id.member1);
        this.iPy = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.iPC = (TextView) view.findViewById(R.id.textview_user_name1);
        this.iPy.setIsRound(true);
        this.iPy.setBorderColor(color);
        this.iPy.setBorderWidth(dimens);
        this.iPy.setOnClickListener(onClickListener);
        this.iPv = (LinearLayout) view.findViewById(R.id.member2);
        this.iPz = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.iPD = (TextView) view.findViewById(R.id.textview_user_name2);
        this.iPz.setIsRound(true);
        this.iPz.setBorderColor(color);
        this.iPz.setBorderWidth(dimens);
        this.iPz.setOnClickListener(onClickListener);
        this.iPw = (LinearLayout) view.findViewById(R.id.member3);
        this.iPA = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.iPE = (TextView) view.findViewById(R.id.textview_user_name3);
        this.iPA.setIsRound(true);
        this.iPA.setBorderColor(color);
        this.iPA.setBorderWidth(dimens);
        this.iPA.setOnClickListener(onClickListener);
        this.iPx = (LinearLayout) view.findViewById(R.id.member4);
        this.iPB = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.iPF = (TextView) view.findViewById(R.id.textview_user_name4);
        this.iPB.setIsRound(true);
        this.iPB.setBorderColor(color);
        this.iPB.setBorderWidth(dimens);
        this.iPB.setOnClickListener(onClickListener);
        this.iPG = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.iPy.startLoad(str, 12, false);
                    this.iPy.setTag(bawuRoleInfoPub);
                    this.iPy.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iPC.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iPu.setVisibility(0);
                    return;
                case 1:
                    this.iPz.startLoad(str, 12, false);
                    this.iPz.setTag(bawuRoleInfoPub);
                    this.iPz.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iPD.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iPv.setVisibility(0);
                    return;
                case 2:
                    this.iPA.startLoad(str, 12, false);
                    this.iPA.setTag(bawuRoleInfoPub);
                    this.iPA.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iPE.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iPw.setVisibility(0);
                    return;
                case 3:
                    this.iPB.startLoad(str, 12, false);
                    this.iPB.setTag(bawuRoleInfoPub);
                    this.iPB.setContentDescription(bawuRoleInfoPub.user_name);
                    this.iPF.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.iPx.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void pK(boolean z) {
        if (this.iPy.getVisibility() == 0) {
            this.iPy.setIsNight(z);
            this.iPy.refresh();
        }
        if (this.iPz.getVisibility() == 0) {
            this.iPz.setIsNight(z);
            this.iPz.refresh();
        }
        if (this.iPA.getVisibility() == 0) {
            this.iPA.setIsNight(z);
            this.iPA.refresh();
        }
        if (this.iPB.getVisibility() == 0) {
            this.iPB.setIsNight(z);
            this.iPB.refresh();
        }
    }
}
