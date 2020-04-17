package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes10.dex */
public class n extends y.a {
    public LinearLayout gVd;
    public LinearLayout gVe;
    public LinearLayout gVf;
    public LinearLayout gVg;
    public HeadImageView gVh;
    public HeadImageView gVi;
    public HeadImageView gVj;
    public HeadImageView gVk;
    public TextView gVl;
    public TextView gVm;
    public TextView gVn;
    public TextView gVo;
    public NoPressedLinearLayout gVp;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.gVd = (LinearLayout) view.findViewById(R.id.member1);
        this.gVh = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.gVl = (TextView) view.findViewById(R.id.textview_user_name1);
        this.gVh.setIsRound(true);
        this.gVh.setBorderColor(color);
        this.gVh.setBorderWidth(dimens);
        this.gVh.setOnClickListener(onClickListener);
        this.gVe = (LinearLayout) view.findViewById(R.id.member2);
        this.gVi = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.gVm = (TextView) view.findViewById(R.id.textview_user_name2);
        this.gVi.setIsRound(true);
        this.gVi.setBorderColor(color);
        this.gVi.setBorderWidth(dimens);
        this.gVi.setOnClickListener(onClickListener);
        this.gVf = (LinearLayout) view.findViewById(R.id.member3);
        this.gVj = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.gVn = (TextView) view.findViewById(R.id.textview_user_name3);
        this.gVj.setIsRound(true);
        this.gVj.setBorderColor(color);
        this.gVj.setBorderWidth(dimens);
        this.gVj.setOnClickListener(onClickListener);
        this.gVg = (LinearLayout) view.findViewById(R.id.member4);
        this.gVk = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.gVo = (TextView) view.findViewById(R.id.textview_user_name4);
        this.gVk.setIsRound(true);
        this.gVk.setBorderColor(color);
        this.gVk.setBorderWidth(dimens);
        this.gVk.setOnClickListener(onClickListener);
        this.gVp = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.gVh.startLoad(str, 12, false);
                    this.gVh.setTag(bawuRoleInfoPub);
                    this.gVh.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gVl.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gVd.setVisibility(0);
                    return;
                case 1:
                    this.gVi.startLoad(str, 12, false);
                    this.gVi.setTag(bawuRoleInfoPub);
                    this.gVi.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gVm.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gVe.setVisibility(0);
                    return;
                case 2:
                    this.gVj.startLoad(str, 12, false);
                    this.gVj.setTag(bawuRoleInfoPub);
                    this.gVj.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gVn.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gVf.setVisibility(0);
                    return;
                case 3:
                    this.gVk.startLoad(str, 12, false);
                    this.gVk.setTag(bawuRoleInfoPub);
                    this.gVk.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gVo.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gVg.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void mh(boolean z) {
        if (this.gVh.getVisibility() == 0) {
            this.gVh.setIsNight(z);
            this.gVh.refresh();
        }
        if (this.gVi.getVisibility() == 0) {
            this.gVi.setIsNight(z);
            this.gVi.refresh();
        }
        if (this.gVj.getVisibility() == 0) {
            this.gVj.setIsNight(z);
            this.gVj.refresh();
        }
        if (this.gVk.getVisibility() == 0) {
            this.gVk.setIsNight(z);
            this.gVk.refresh();
        }
    }
}
