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
    public LinearLayout gVj;
    public LinearLayout gVk;
    public LinearLayout gVl;
    public LinearLayout gVm;
    public HeadImageView gVn;
    public HeadImageView gVo;
    public HeadImageView gVp;
    public HeadImageView gVq;
    public TextView gVr;
    public TextView gVs;
    public TextView gVt;
    public TextView gVu;
    public NoPressedLinearLayout gVv;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.gVj = (LinearLayout) view.findViewById(R.id.member1);
        this.gVn = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.gVr = (TextView) view.findViewById(R.id.textview_user_name1);
        this.gVn.setIsRound(true);
        this.gVn.setBorderColor(color);
        this.gVn.setBorderWidth(dimens);
        this.gVn.setOnClickListener(onClickListener);
        this.gVk = (LinearLayout) view.findViewById(R.id.member2);
        this.gVo = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.gVs = (TextView) view.findViewById(R.id.textview_user_name2);
        this.gVo.setIsRound(true);
        this.gVo.setBorderColor(color);
        this.gVo.setBorderWidth(dimens);
        this.gVo.setOnClickListener(onClickListener);
        this.gVl = (LinearLayout) view.findViewById(R.id.member3);
        this.gVp = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.gVt = (TextView) view.findViewById(R.id.textview_user_name3);
        this.gVp.setIsRound(true);
        this.gVp.setBorderColor(color);
        this.gVp.setBorderWidth(dimens);
        this.gVp.setOnClickListener(onClickListener);
        this.gVm = (LinearLayout) view.findViewById(R.id.member4);
        this.gVq = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.gVu = (TextView) view.findViewById(R.id.textview_user_name4);
        this.gVq.setIsRound(true);
        this.gVq.setBorderColor(color);
        this.gVq.setBorderWidth(dimens);
        this.gVq.setOnClickListener(onClickListener);
        this.gVv = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.gVn.startLoad(str, 12, false);
                    this.gVn.setTag(bawuRoleInfoPub);
                    this.gVn.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gVr.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gVj.setVisibility(0);
                    return;
                case 1:
                    this.gVo.startLoad(str, 12, false);
                    this.gVo.setTag(bawuRoleInfoPub);
                    this.gVo.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gVs.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gVk.setVisibility(0);
                    return;
                case 2:
                    this.gVp.startLoad(str, 12, false);
                    this.gVp.setTag(bawuRoleInfoPub);
                    this.gVp.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gVt.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gVl.setVisibility(0);
                    return;
                case 3:
                    this.gVq.startLoad(str, 12, false);
                    this.gVq.setTag(bawuRoleInfoPub);
                    this.gVq.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gVu.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gVm.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void mh(boolean z) {
        if (this.gVn.getVisibility() == 0) {
            this.gVn.setIsNight(z);
            this.gVn.refresh();
        }
        if (this.gVo.getVisibility() == 0) {
            this.gVo.setIsNight(z);
            this.gVo.refresh();
        }
        if (this.gVp.getVisibility() == 0) {
            this.gVp.setIsNight(z);
            this.gVp.refresh();
        }
        if (this.gVq.getVisibility() == 0) {
            this.gVq.setIsNight(z);
            this.gVq.refresh();
        }
    }
}
