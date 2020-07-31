package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes17.dex */
public class n extends ad.a {
    public LinearLayout hBZ;
    public LinearLayout hCa;
    public LinearLayout hCb;
    public LinearLayout hCc;
    public HeadImageView hCd;
    public HeadImageView hCe;
    public HeadImageView hCf;
    public HeadImageView hCg;
    public TextView hCh;
    public TextView hCi;
    public TextView hCj;
    public TextView hCk;
    public NoPressedLinearLayout hCl;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ao.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.hBZ = (LinearLayout) view.findViewById(R.id.member1);
        this.hCd = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.hCh = (TextView) view.findViewById(R.id.textview_user_name1);
        this.hCd.setIsRound(true);
        this.hCd.setBorderColor(color);
        this.hCd.setBorderWidth(dimens);
        this.hCd.setOnClickListener(onClickListener);
        this.hCa = (LinearLayout) view.findViewById(R.id.member2);
        this.hCe = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.hCi = (TextView) view.findViewById(R.id.textview_user_name2);
        this.hCe.setIsRound(true);
        this.hCe.setBorderColor(color);
        this.hCe.setBorderWidth(dimens);
        this.hCe.setOnClickListener(onClickListener);
        this.hCb = (LinearLayout) view.findViewById(R.id.member3);
        this.hCf = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.hCj = (TextView) view.findViewById(R.id.textview_user_name3);
        this.hCf.setIsRound(true);
        this.hCf.setBorderColor(color);
        this.hCf.setBorderWidth(dimens);
        this.hCf.setOnClickListener(onClickListener);
        this.hCc = (LinearLayout) view.findViewById(R.id.member4);
        this.hCg = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.hCk = (TextView) view.findViewById(R.id.textview_user_name4);
        this.hCg.setIsRound(true);
        this.hCg.setBorderColor(color);
        this.hCg.setBorderWidth(dimens);
        this.hCg.setOnClickListener(onClickListener);
        this.hCl = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.hCd.startLoad(str, 12, false);
                    this.hCd.setTag(bawuRoleInfoPub);
                    this.hCd.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hCh.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hBZ.setVisibility(0);
                    return;
                case 1:
                    this.hCe.startLoad(str, 12, false);
                    this.hCe.setTag(bawuRoleInfoPub);
                    this.hCe.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hCi.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hCa.setVisibility(0);
                    return;
                case 2:
                    this.hCf.startLoad(str, 12, false);
                    this.hCf.setTag(bawuRoleInfoPub);
                    this.hCf.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hCj.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hCb.setVisibility(0);
                    return;
                case 3:
                    this.hCg.startLoad(str, 12, false);
                    this.hCg.setTag(bawuRoleInfoPub);
                    this.hCg.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hCk.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hCc.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void ns(boolean z) {
        if (this.hCd.getVisibility() == 0) {
            this.hCd.setIsNight(z);
            this.hCd.refresh();
        }
        if (this.hCe.getVisibility() == 0) {
            this.hCe.setIsNight(z);
            this.hCe.refresh();
        }
        if (this.hCf.getVisibility() == 0) {
            this.hCf.setIsNight(z);
            this.hCf.refresh();
        }
        if (this.hCg.getVisibility() == 0) {
            this.hCg.setIsNight(z);
            this.hCg.refresh();
        }
    }
}
