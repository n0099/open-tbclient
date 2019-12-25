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
/* loaded from: classes7.dex */
public class n extends v.a {
    public LinearLayout gfP;
    public LinearLayout gfQ;
    public LinearLayout gfR;
    public LinearLayout gfS;
    public HeadImageView gfT;
    public HeadImageView gfU;
    public HeadImageView gfV;
    public HeadImageView gfW;
    public TextView gfX;
    public TextView gfY;
    public TextView gfZ;
    public TextView gga;
    public NoPressedLinearLayout ggb;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.gfP = (LinearLayout) view.findViewById(R.id.member1);
        this.gfT = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.gfX = (TextView) view.findViewById(R.id.textview_user_name1);
        this.gfT.setIsRound(true);
        this.gfT.setBorderColor(color);
        this.gfT.setBorderWidth(dimens);
        this.gfT.setOnClickListener(onClickListener);
        this.gfQ = (LinearLayout) view.findViewById(R.id.member2);
        this.gfU = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.gfY = (TextView) view.findViewById(R.id.textview_user_name2);
        this.gfU.setIsRound(true);
        this.gfU.setBorderColor(color);
        this.gfU.setBorderWidth(dimens);
        this.gfU.setOnClickListener(onClickListener);
        this.gfR = (LinearLayout) view.findViewById(R.id.member3);
        this.gfV = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.gfZ = (TextView) view.findViewById(R.id.textview_user_name3);
        this.gfV.setIsRound(true);
        this.gfV.setBorderColor(color);
        this.gfV.setBorderWidth(dimens);
        this.gfV.setOnClickListener(onClickListener);
        this.gfS = (LinearLayout) view.findViewById(R.id.member4);
        this.gfW = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.gga = (TextView) view.findViewById(R.id.textview_user_name4);
        this.gfW.setIsRound(true);
        this.gfW.setBorderColor(color);
        this.gfW.setBorderWidth(dimens);
        this.gfW.setOnClickListener(onClickListener);
        this.ggb = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.gfT.startLoad(str, 12, false);
                    this.gfT.setTag(bawuRoleInfoPub);
                    this.gfT.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gfX.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gfP.setVisibility(0);
                    return;
                case 1:
                    this.gfU.startLoad(str, 12, false);
                    this.gfU.setTag(bawuRoleInfoPub);
                    this.gfU.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gfY.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gfQ.setVisibility(0);
                    return;
                case 2:
                    this.gfV.startLoad(str, 12, false);
                    this.gfV.setTag(bawuRoleInfoPub);
                    this.gfV.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gfZ.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gfR.setVisibility(0);
                    return;
                case 3:
                    this.gfW.startLoad(str, 12, false);
                    this.gfW.setTag(bawuRoleInfoPub);
                    this.gfW.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gga.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gfS.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void kI(boolean z) {
        if (this.gfT.getVisibility() == 0) {
            this.gfT.setIsNight(z);
            this.gfT.refresh();
        }
        if (this.gfU.getVisibility() == 0) {
            this.gfU.setIsNight(z);
            this.gfU.refresh();
        }
        if (this.gfV.getVisibility() == 0) {
            this.gfV.setIsNight(z);
            this.gfV.refresh();
        }
        if (this.gfW.getVisibility() == 0) {
            this.gfW.setIsNight(z);
            this.gfW.refresh();
        }
    }
}
