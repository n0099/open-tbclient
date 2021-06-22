package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15118a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15119b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15120c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15121d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15122e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15123f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15124g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15125h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f15126i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public NoPressedLinearLayout n;

    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        int g2 = l.g(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = SkinManager.getColor(R.color.black_alpha10);
        TextView textView = (TextView) view.findViewById(R.id.title_text_view);
        this.f15118a = textView;
        textView.setOnClickListener(onClickListener);
        this.f15119b = (LinearLayout) view.findViewById(R.id.member1);
        this.f15123f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f15123f.setIsRound(true);
        this.f15123f.setBorderColor(color);
        this.f15123f.setBorderWidth(g2);
        this.f15123f.setOnClickListener(onClickListener);
        this.f15120c = (LinearLayout) view.findViewById(R.id.member2);
        this.f15124g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f15124g.setIsRound(true);
        this.f15124g.setBorderColor(color);
        this.f15124g.setBorderWidth(g2);
        this.f15124g.setOnClickListener(onClickListener);
        this.f15121d = (LinearLayout) view.findViewById(R.id.member3);
        this.f15125h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f15125h.setIsRound(true);
        this.f15125h.setBorderColor(color);
        this.f15125h.setBorderWidth(g2);
        this.f15125h.setOnClickListener(onClickListener);
        this.f15122e = (LinearLayout) view.findViewById(R.id.member4);
        this.f15126i = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.m = (TextView) view.findViewById(R.id.textview_user_name4);
        this.f15126i.setIsRound(true);
        this.f15126i.setBorderColor(color);
        this.f15126i.setBorderWidth(g2);
        this.f15126i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub, int i2) {
        String str;
        if (bawuRoleInfoPub == null || i2 < 0 || i2 > 3) {
            return;
        }
        BaijiahaoInfo baijiahaoInfo = bawuRoleInfoPub.baijiahao_info;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar)) {
            str = bawuRoleInfoPub.baijiahao_info.avatar;
        } else {
            str = bawuRoleInfoPub.portrait;
        }
        if (i2 == 0) {
            this.f15123f.U(str, 12, false);
            this.f15123f.setTag(bawuRoleInfoPub);
            this.f15123f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15119b.setVisibility(0);
        } else if (i2 == 1) {
            this.f15124g.U(str, 12, false);
            this.f15124g.setTag(bawuRoleInfoPub);
            this.f15124g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15120c.setVisibility(0);
        } else if (i2 == 2) {
            this.f15125h.U(str, 12, false);
            this.f15125h.setTag(bawuRoleInfoPub);
            this.f15125h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15121d.setVisibility(0);
        } else if (i2 != 3) {
        } else {
            this.f15126i.U(str, 12, false);
            this.f15126i.setTag(bawuRoleInfoPub);
            this.f15126i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15122e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        if (this.f15123f.getVisibility() == 0) {
            this.f15123f.setIsNight(z);
            this.f15123f.refresh();
        }
        if (this.f15124g.getVisibility() == 0) {
            this.f15124g.setIsNight(z);
            this.f15124g.refresh();
        }
        if (this.f15125h.getVisibility() == 0) {
            this.f15125h.setIsNight(z);
            this.f15125h.refresh();
        }
        if (this.f15126i.getVisibility() == 0) {
            this.f15126i.setIsNight(z);
            this.f15126i.refresh();
        }
    }
}
