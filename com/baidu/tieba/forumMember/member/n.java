package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class n extends ad.a {
    public LinearLayout hwn;
    public LinearLayout hwo;
    public LinearLayout hwp;
    public LinearLayout hwq;
    public HeadImageView hwr;
    public HeadImageView hws;
    public HeadImageView hwt;
    public HeadImageView hwu;
    public TextView hwv;
    public TextView hww;
    public TextView hwx;
    public TextView hwy;
    public NoPressedLinearLayout hwz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = an.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.hwn = (LinearLayout) view.findViewById(R.id.member1);
        this.hwr = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.hwv = (TextView) view.findViewById(R.id.textview_user_name1);
        this.hwr.setIsRound(true);
        this.hwr.setBorderColor(color);
        this.hwr.setBorderWidth(dimens);
        this.hwr.setOnClickListener(onClickListener);
        this.hwo = (LinearLayout) view.findViewById(R.id.member2);
        this.hws = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.hww = (TextView) view.findViewById(R.id.textview_user_name2);
        this.hws.setIsRound(true);
        this.hws.setBorderColor(color);
        this.hws.setBorderWidth(dimens);
        this.hws.setOnClickListener(onClickListener);
        this.hwp = (LinearLayout) view.findViewById(R.id.member3);
        this.hwt = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.hwx = (TextView) view.findViewById(R.id.textview_user_name3);
        this.hwt.setIsRound(true);
        this.hwt.setBorderColor(color);
        this.hwt.setBorderWidth(dimens);
        this.hwt.setOnClickListener(onClickListener);
        this.hwq = (LinearLayout) view.findViewById(R.id.member4);
        this.hwu = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.hwy = (TextView) view.findViewById(R.id.textview_user_name4);
        this.hwu.setIsRound(true);
        this.hwu.setBorderColor(color);
        this.hwu.setBorderWidth(dimens);
        this.hwu.setOnClickListener(onClickListener);
        this.hwz = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.hwr.startLoad(str, 12, false);
                    this.hwr.setTag(bawuRoleInfoPub);
                    this.hwr.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hwv.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hwn.setVisibility(0);
                    return;
                case 1:
                    this.hws.startLoad(str, 12, false);
                    this.hws.setTag(bawuRoleInfoPub);
                    this.hws.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hww.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hwo.setVisibility(0);
                    return;
                case 2:
                    this.hwt.startLoad(str, 12, false);
                    this.hwt.setTag(bawuRoleInfoPub);
                    this.hwt.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hwx.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hwp.setVisibility(0);
                    return;
                case 3:
                    this.hwu.startLoad(str, 12, false);
                    this.hwu.setTag(bawuRoleInfoPub);
                    this.hwu.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hwy.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hwq.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void mN(boolean z) {
        if (this.hwr.getVisibility() == 0) {
            this.hwr.setIsNight(z);
            this.hwr.refresh();
        }
        if (this.hws.getVisibility() == 0) {
            this.hws.setIsNight(z);
            this.hws.refresh();
        }
        if (this.hwt.getVisibility() == 0) {
            this.hwt.setIsNight(z);
            this.hwt.refresh();
        }
        if (this.hwu.getVisibility() == 0) {
            this.hwu.setIsNight(z);
            this.hwu.refresh();
        }
    }
}
