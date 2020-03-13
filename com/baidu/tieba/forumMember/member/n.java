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
    public TextView glA;
    public NoPressedLinearLayout glB;
    public LinearLayout glp;
    public LinearLayout glq;
    public LinearLayout glr;
    public LinearLayout gls;
    public HeadImageView glt;
    public HeadImageView glu;
    public HeadImageView glv;
    public HeadImageView glw;
    public TextView glx;
    public TextView gly;
    public TextView glz;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.glp = (LinearLayout) view.findViewById(R.id.member1);
        this.glt = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.glx = (TextView) view.findViewById(R.id.textview_user_name1);
        this.glt.setIsRound(true);
        this.glt.setBorderColor(color);
        this.glt.setBorderWidth(dimens);
        this.glt.setOnClickListener(onClickListener);
        this.glq = (LinearLayout) view.findViewById(R.id.member2);
        this.glu = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.gly = (TextView) view.findViewById(R.id.textview_user_name2);
        this.glu.setIsRound(true);
        this.glu.setBorderColor(color);
        this.glu.setBorderWidth(dimens);
        this.glu.setOnClickListener(onClickListener);
        this.glr = (LinearLayout) view.findViewById(R.id.member3);
        this.glv = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.glz = (TextView) view.findViewById(R.id.textview_user_name3);
        this.glv.setIsRound(true);
        this.glv.setBorderColor(color);
        this.glv.setBorderWidth(dimens);
        this.glv.setOnClickListener(onClickListener);
        this.gls = (LinearLayout) view.findViewById(R.id.member4);
        this.glw = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.glA = (TextView) view.findViewById(R.id.textview_user_name4);
        this.glw.setIsRound(true);
        this.glw.setBorderColor(color);
        this.glw.setBorderWidth(dimens);
        this.glw.setOnClickListener(onClickListener);
        this.glB = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.glt.startLoad(str, 12, false);
                    this.glt.setTag(bawuRoleInfoPub);
                    this.glt.setContentDescription(bawuRoleInfoPub.user_name);
                    this.glx.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glp.setVisibility(0);
                    return;
                case 1:
                    this.glu.startLoad(str, 12, false);
                    this.glu.setTag(bawuRoleInfoPub);
                    this.glu.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gly.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glq.setVisibility(0);
                    return;
                case 2:
                    this.glv.startLoad(str, 12, false);
                    this.glv.setTag(bawuRoleInfoPub);
                    this.glv.setContentDescription(bawuRoleInfoPub.user_name);
                    this.glz.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glr.setVisibility(0);
                    return;
                case 3:
                    this.glw.startLoad(str, 12, false);
                    this.glw.setTag(bawuRoleInfoPub);
                    this.glw.setContentDescription(bawuRoleInfoPub.user_name);
                    this.glA.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gls.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void kX(boolean z) {
        if (this.glt.getVisibility() == 0) {
            this.glt.setIsNight(z);
            this.glt.refresh();
        }
        if (this.glu.getVisibility() == 0) {
            this.glu.setIsNight(z);
            this.glu.refresh();
        }
        if (this.glv.getVisibility() == 0) {
            this.glv.setIsNight(z);
            this.glv.refresh();
        }
        if (this.glw.getVisibility() == 0) {
            this.glw.setIsNight(z);
            this.glw.refresh();
        }
    }
}
