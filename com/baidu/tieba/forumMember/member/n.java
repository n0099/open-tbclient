package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class n extends v.a {
    public LinearLayout glX;
    public LinearLayout glY;
    public LinearLayout glZ;
    public LinearLayout gma;
    public HeadImageView gmb;
    public HeadImageView gmc;
    public HeadImageView gmd;
    public HeadImageView gme;
    public TextView gmf;
    public TextView gmg;
    public TextView gmh;
    public TextView gmi;
    public NoPressedLinearLayout gmj;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.glX = (LinearLayout) view.findViewById(R.id.member1);
        this.gmb = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.gmf = (TextView) view.findViewById(R.id.textview_user_name1);
        this.gmb.setIsRound(true);
        this.gmb.setBorderColor(color);
        this.gmb.setBorderWidth(dimens);
        this.gmb.setOnClickListener(onClickListener);
        this.glY = (LinearLayout) view.findViewById(R.id.member2);
        this.gmc = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.gmg = (TextView) view.findViewById(R.id.textview_user_name2);
        this.gmc.setIsRound(true);
        this.gmc.setBorderColor(color);
        this.gmc.setBorderWidth(dimens);
        this.gmc.setOnClickListener(onClickListener);
        this.glZ = (LinearLayout) view.findViewById(R.id.member3);
        this.gmd = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.gmh = (TextView) view.findViewById(R.id.textview_user_name3);
        this.gmd.setIsRound(true);
        this.gmd.setBorderColor(color);
        this.gmd.setBorderWidth(dimens);
        this.gmd.setOnClickListener(onClickListener);
        this.gma = (LinearLayout) view.findViewById(R.id.member4);
        this.gme = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.gmi = (TextView) view.findViewById(R.id.textview_user_name4);
        this.gme.setIsRound(true);
        this.gme.setBorderColor(color);
        this.gme.setBorderWidth(dimens);
        this.gme.setOnClickListener(onClickListener);
        this.gmj = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.gmb.startLoad(str, 12, false);
                    this.gmb.setTag(bawuRoleInfoPub);
                    this.gmb.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gmf.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glX.setVisibility(0);
                    return;
                case 1:
                    this.gmc.startLoad(str, 12, false);
                    this.gmc.setTag(bawuRoleInfoPub);
                    this.gmc.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gmg.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glY.setVisibility(0);
                    return;
                case 2:
                    this.gmd.startLoad(str, 12, false);
                    this.gmd.setTag(bawuRoleInfoPub);
                    this.gmd.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gmh.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glZ.setVisibility(0);
                    return;
                case 3:
                    this.gme.startLoad(str, 12, false);
                    this.gme.setTag(bawuRoleInfoPub);
                    this.gme.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gmi.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gma.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void lc(boolean z) {
        if (this.gmb.getVisibility() == 0) {
            this.gmb.setIsNight(z);
            this.gmb.refresh();
        }
        if (this.gmc.getVisibility() == 0) {
            this.gmc.setIsNight(z);
            this.gmc.refresh();
        }
        if (this.gmd.getVisibility() == 0) {
            this.gmd.setIsNight(z);
            this.gmd.refresh();
        }
        if (this.gme.getVisibility() == 0) {
            this.gme.setIsNight(z);
            this.gme.refresh();
        }
    }
}
