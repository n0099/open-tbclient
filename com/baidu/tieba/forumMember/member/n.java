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
    public NoPressedLinearLayout hPA;
    public LinearLayout hPo;
    public LinearLayout hPp;
    public LinearLayout hPq;
    public LinearLayout hPr;
    public HeadImageView hPs;
    public HeadImageView hPt;
    public HeadImageView hPu;
    public HeadImageView hPv;
    public TextView hPw;
    public TextView hPx;
    public TextView hPy;
    public TextView hPz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = ap.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.hPo = (LinearLayout) view.findViewById(R.id.member1);
        this.hPs = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.hPw = (TextView) view.findViewById(R.id.textview_user_name1);
        this.hPs.setIsRound(true);
        this.hPs.setBorderColor(color);
        this.hPs.setBorderWidth(dimens);
        this.hPs.setOnClickListener(onClickListener);
        this.hPp = (LinearLayout) view.findViewById(R.id.member2);
        this.hPt = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.hPx = (TextView) view.findViewById(R.id.textview_user_name2);
        this.hPt.setIsRound(true);
        this.hPt.setBorderColor(color);
        this.hPt.setBorderWidth(dimens);
        this.hPt.setOnClickListener(onClickListener);
        this.hPq = (LinearLayout) view.findViewById(R.id.member3);
        this.hPu = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.hPy = (TextView) view.findViewById(R.id.textview_user_name3);
        this.hPu.setIsRound(true);
        this.hPu.setBorderColor(color);
        this.hPu.setBorderWidth(dimens);
        this.hPu.setOnClickListener(onClickListener);
        this.hPr = (LinearLayout) view.findViewById(R.id.member4);
        this.hPv = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.hPz = (TextView) view.findViewById(R.id.textview_user_name4);
        this.hPv.setIsRound(true);
        this.hPv.setBorderColor(color);
        this.hPv.setBorderWidth(dimens);
        this.hPv.setOnClickListener(onClickListener);
        this.hPA = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.hPs.startLoad(str, 12, false);
                    this.hPs.setTag(bawuRoleInfoPub);
                    this.hPs.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hPw.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hPo.setVisibility(0);
                    return;
                case 1:
                    this.hPt.startLoad(str, 12, false);
                    this.hPt.setTag(bawuRoleInfoPub);
                    this.hPt.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hPx.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hPp.setVisibility(0);
                    return;
                case 2:
                    this.hPu.startLoad(str, 12, false);
                    this.hPu.setTag(bawuRoleInfoPub);
                    this.hPu.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hPy.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hPq.setVisibility(0);
                    return;
                case 3:
                    this.hPv.startLoad(str, 12, false);
                    this.hPv.setTag(bawuRoleInfoPub);
                    this.hPv.setContentDescription(bawuRoleInfoPub.user_name);
                    this.hPz.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.hPr.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void nW(boolean z) {
        if (this.hPs.getVisibility() == 0) {
            this.hPs.setIsNight(z);
            this.hPs.refresh();
        }
        if (this.hPt.getVisibility() == 0) {
            this.hPt.setIsNight(z);
            this.hPt.refresh();
        }
        if (this.hPu.getVisibility() == 0) {
            this.hPu.setIsNight(z);
            this.hPu.refresh();
        }
        if (this.hPv.getVisibility() == 0) {
            this.hPv.setIsNight(z);
            this.hPv.refresh();
        }
    }
}
