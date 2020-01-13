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
/* loaded from: classes8.dex */
public class n extends v.a {
    public LinearLayout giZ;
    public LinearLayout gja;
    public LinearLayout gjb;
    public LinearLayout gjc;
    public HeadImageView gjd;
    public HeadImageView gje;
    public HeadImageView gjf;
    public HeadImageView gjg;
    public TextView gjh;
    public TextView gji;
    public TextView gjj;
    public TextView gjk;
    public NoPressedLinearLayout gjl;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int dimens = com.baidu.adp.lib.util.l.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = am.getColor(R.color.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(R.id.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.giZ = (LinearLayout) view.findViewById(R.id.member1);
        this.gjd = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.gjh = (TextView) view.findViewById(R.id.textview_user_name1);
        this.gjd.setIsRound(true);
        this.gjd.setBorderColor(color);
        this.gjd.setBorderWidth(dimens);
        this.gjd.setOnClickListener(onClickListener);
        this.gja = (LinearLayout) view.findViewById(R.id.member2);
        this.gje = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.gji = (TextView) view.findViewById(R.id.textview_user_name2);
        this.gje.setIsRound(true);
        this.gje.setBorderColor(color);
        this.gje.setBorderWidth(dimens);
        this.gje.setOnClickListener(onClickListener);
        this.gjb = (LinearLayout) view.findViewById(R.id.member3);
        this.gjf = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.gjj = (TextView) view.findViewById(R.id.textview_user_name3);
        this.gjf.setIsRound(true);
        this.gjf.setBorderColor(color);
        this.gjf.setBorderWidth(dimens);
        this.gjf.setOnClickListener(onClickListener);
        this.gjc = (LinearLayout) view.findViewById(R.id.member4);
        this.gjg = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.gjk = (TextView) view.findViewById(R.id.textview_user_name4);
        this.gjg.setIsRound(true);
        this.gjg.setBorderColor(color);
        this.gjg.setBorderWidth(dimens);
        this.gjg.setOnClickListener(onClickListener);
        this.gjl = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
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
                    this.gjd.startLoad(str, 12, false);
                    this.gjd.setTag(bawuRoleInfoPub);
                    this.gjd.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gjh.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.giZ.setVisibility(0);
                    return;
                case 1:
                    this.gje.startLoad(str, 12, false);
                    this.gje.setTag(bawuRoleInfoPub);
                    this.gje.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gji.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gja.setVisibility(0);
                    return;
                case 2:
                    this.gjf.startLoad(str, 12, false);
                    this.gjf.setTag(bawuRoleInfoPub);
                    this.gjf.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gjj.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gjb.setVisibility(0);
                    return;
                case 3:
                    this.gjg.startLoad(str, 12, false);
                    this.gjg.setTag(bawuRoleInfoPub);
                    this.gjg.setContentDescription(bawuRoleInfoPub.user_name);
                    this.gjk.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.gjc.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void kT(boolean z) {
        if (this.gjd.getVisibility() == 0) {
            this.gjd.setIsNight(z);
            this.gjd.refresh();
        }
        if (this.gje.getVisibility() == 0) {
            this.gje.setIsNight(z);
            this.gje.refresh();
        }
        if (this.gjf.getVisibility() == 0) {
            this.gjf.setIsNight(z);
            this.gjf.refresh();
        }
        if (this.gjg.getVisibility() == 0) {
            this.gjg.setIsNight(z);
            this.gjg.refresh();
        }
    }
}
