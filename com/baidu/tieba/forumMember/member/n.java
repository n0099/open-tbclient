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
/* loaded from: classes17.dex */
public class n extends af.a {
    public HeadImageView hPA;
    public HeadImageView hPB;
    public TextView hPC;
    public TextView hPD;
    public TextView hPE;
    public TextView hPF;
    public NoPressedLinearLayout hPG;
    public LinearLayout hPu;
    public LinearLayout hPv;
    public LinearLayout hPw;
    public LinearLayout hPx;
    public HeadImageView hPy;
    public HeadImageView hPz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.hPu = (LinearLayout) view.findViewById(R.id.member1);
        this.hPy = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.hPC = (TextView) view.findViewById(R.id.textview_user_name1);
        this.hPy.setIsRound(true);
        this.hPy.setBorderColor(color);
        this.hPy.setBorderWidth(dimens);
        this.hPy.setOnClickListener(onClickListener);
        this.hPv = (LinearLayout) view.findViewById(R.id.member2);
        this.hPz = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.hPD = (TextView) view.findViewById(R.id.textview_user_name2);
        this.hPz.setIsRound(true);
        this.hPz.setBorderColor(color);
        this.hPz.setBorderWidth(dimens);
        this.hPz.setOnClickListener(onClickListener);
        this.hPw = (LinearLayout) view.findViewById(R.id.member3);
        this.hPA = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.hPE = (TextView) view.findViewById(R.id.textview_user_name3);
        this.hPA.setIsRound(true);
        this.hPA.setBorderColor(color);
        this.hPA.setBorderWidth(dimens);
        this.hPA.setOnClickListener(onClickListener);
        this.hPx = (LinearLayout) view.findViewById(R.id.member4);
        this.hPB = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.hPF = (TextView) view.findViewById(R.id.textview_user_name4);
        this.hPB.setIsRound(true);
        this.hPB.setBorderColor(color);
        this.hPB.setBorderWidth(dimens);
        this.hPB.setOnClickListener(onClickListener);
        this.hPG = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.hPy.startLoad(str, 12, false);
                    this.hPy.setTag(bawuRoleInfoPub);
                    this.hPy.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hPC.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hPu.setVisibility(0);
                    return;
                case 1:
                    this.hPz.startLoad(str, 12, false);
                    this.hPz.setTag(bawuRoleInfoPub);
                    this.hPz.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hPD.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hPv.setVisibility(0);
                    return;
                case 2:
                    this.hPA.startLoad(str, 12, false);
                    this.hPA.setTag(bawuRoleInfoPub);
                    this.hPA.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hPE.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hPw.setVisibility(0);
                    return;
                case 3:
                    this.hPB.startLoad(str, 12, false);
                    this.hPB.setTag(bawuRoleInfoPub);
                    this.hPB.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hPF.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hPx.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void nY(boolean z) {
        if (this.hPy.getVisibility() == 0) {
            this.hPy.setIsNight(z);
            this.hPy.refresh();
        }
        if (this.hPz.getVisibility() == 0) {
            this.hPz.setIsNight(z);
            this.hPz.refresh();
        }
        if (this.hPA.getVisibility() == 0) {
            this.hPA.setIsNight(z);
            this.hPA.refresh();
        }
        if (this.hPB.getVisibility() == 0) {
            this.hPB.setIsNight(z);
            this.hPB.refresh();
        }
    }
}
