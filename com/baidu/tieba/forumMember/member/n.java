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
    public LinearLayout glc;
    public LinearLayout gld;
    public LinearLayout gle;
    public LinearLayout glf;
    public HeadImageView glg;
    public HeadImageView glh;
    public HeadImageView gli;
    public HeadImageView glj;
    public TextView glk;
    public TextView gll;
    public TextView glm;
    public TextView gln;
    public NoPressedLinearLayout glo;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.glc = (LinearLayout) view.findViewById(R.id.member1);
        this.glg = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.glk = (TextView) view.findViewById(R.id.textview_user_name1);
        this.glg.setIsRound(true);
        this.glg.setBorderColor(color);
        this.glg.setBorderWidth(dimens);
        this.glg.setOnClickListener(onClickListener);
        this.gld = (LinearLayout) view.findViewById(R.id.member2);
        this.glh = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.gll = (TextView) view.findViewById(R.id.textview_user_name2);
        this.glh.setIsRound(true);
        this.glh.setBorderColor(color);
        this.glh.setBorderWidth(dimens);
        this.glh.setOnClickListener(onClickListener);
        this.gle = (LinearLayout) view.findViewById(R.id.member3);
        this.gli = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.glm = (TextView) view.findViewById(R.id.textview_user_name3);
        this.gli.setIsRound(true);
        this.gli.setBorderColor(color);
        this.gli.setBorderWidth(dimens);
        this.gli.setOnClickListener(onClickListener);
        this.glf = (LinearLayout) view.findViewById(R.id.member4);
        this.glj = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.gln = (TextView) view.findViewById(R.id.textview_user_name4);
        this.glj.setIsRound(true);
        this.glj.setBorderColor(color);
        this.glj.setBorderWidth(dimens);
        this.glj.setOnClickListener(onClickListener);
        this.glo = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.glg.startLoad(str, 12, false);
                    this.glg.setTag(bawuRoleInfoPub);
                    this.glg.setContentDescription(bawuRoleInfoPub.user_name);
                    this.glk.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glc.setVisibility(0);
                    return;
                case 1:
                    this.glh.startLoad(str, 12, false);
                    this.glh.setTag(bawuRoleInfoPub);
                    this.glh.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gll.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gld.setVisibility(0);
                    return;
                case 2:
                    this.gli.startLoad(str, 12, false);
                    this.gli.setTag(bawuRoleInfoPub);
                    this.gli.setContentDescription(bawuRoleInfoPub.user_name);
                    this.glm.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gle.setVisibility(0);
                    return;
                case 3:
                    this.glj.startLoad(str, 12, false);
                    this.glj.setTag(bawuRoleInfoPub);
                    this.glj.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gln.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glf.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void kX(boolean z) {
        if (this.glg.getVisibility() == 0) {
            this.glg.setIsNight(z);
            this.glg.refresh();
        }
        if (this.glh.getVisibility() == 0) {
            this.glh.setIsNight(z);
            this.glh.refresh();
        }
        if (this.gli.getVisibility() == 0) {
            this.gli.setIsNight(z);
            this.gli.refresh();
        }
        if (this.glj.getVisibility() == 0) {
            this.glj.setIsNight(z);
            this.glj.refresh();
        }
    }
}
