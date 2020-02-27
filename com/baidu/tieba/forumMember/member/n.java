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
    public LinearLayout gla;
    public LinearLayout glb;
    public LinearLayout glc;
    public LinearLayout gld;
    public HeadImageView gle;
    public HeadImageView glf;
    public HeadImageView glg;
    public HeadImageView glh;
    public TextView gli;
    public TextView glj;
    public TextView glk;
    public TextView gll;
    public NoPressedLinearLayout glm;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.gla = (LinearLayout) view.findViewById(R.id.member1);
        this.gle = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.gli = (TextView) view.findViewById(R.id.textview_user_name1);
        this.gle.setIsRound(true);
        this.gle.setBorderColor(color);
        this.gle.setBorderWidth(dimens);
        this.gle.setOnClickListener(onClickListener);
        this.glb = (LinearLayout) view.findViewById(R.id.member2);
        this.glf = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.glj = (TextView) view.findViewById(R.id.textview_user_name2);
        this.glf.setIsRound(true);
        this.glf.setBorderColor(color);
        this.glf.setBorderWidth(dimens);
        this.glf.setOnClickListener(onClickListener);
        this.glc = (LinearLayout) view.findViewById(R.id.member3);
        this.glg = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.glk = (TextView) view.findViewById(R.id.textview_user_name3);
        this.glg.setIsRound(true);
        this.glg.setBorderColor(color);
        this.glg.setBorderWidth(dimens);
        this.glg.setOnClickListener(onClickListener);
        this.gld = (LinearLayout) view.findViewById(R.id.member4);
        this.glh = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.gll = (TextView) view.findViewById(R.id.textview_user_name4);
        this.glh.setIsRound(true);
        this.glh.setBorderColor(color);
        this.glh.setBorderWidth(dimens);
        this.glh.setOnClickListener(onClickListener);
        this.glm = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.gle.startLoad(str, 12, false);
                    this.gle.setTag(bawuRoleInfoPub);
                    this.gle.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gli.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gla.setVisibility(0);
                    return;
                case 1:
                    this.glf.startLoad(str, 12, false);
                    this.glf.setTag(bawuRoleInfoPub);
                    this.glf.setContentDescription(bawuRoleInfoPub.user_name);
                    this.glj.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glb.setVisibility(0);
                    return;
                case 2:
                    this.glg.startLoad(str, 12, false);
                    this.glg.setTag(bawuRoleInfoPub);
                    this.glg.setContentDescription(bawuRoleInfoPub.user_name);
                    this.glk.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.glc.setVisibility(0);
                    return;
                case 3:
                    this.glh.startLoad(str, 12, false);
                    this.glh.setTag(bawuRoleInfoPub);
                    this.glh.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gll.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gld.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void kX(boolean z) {
        if (this.gle.getVisibility() == 0) {
            this.gle.setIsNight(z);
            this.gle.refresh();
        }
        if (this.glf.getVisibility() == 0) {
            this.glf.setIsNight(z);
            this.glf.refresh();
        }
        if (this.glg.getVisibility() == 0) {
            this.glg.setIsNight(z);
            this.glg.refresh();
        }
        if (this.glh.getVisibility() == 0) {
            this.glh.setIsNight(z);
            this.glh.refresh();
        }
    }
}
