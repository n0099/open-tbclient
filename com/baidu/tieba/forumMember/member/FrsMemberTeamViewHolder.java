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
import d.b.b.e.p.l;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15929a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15930b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15931c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15932d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15933e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15934f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15935g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15936h;
    public HeadImageView i;
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
        this.f15929a = textView;
        textView.setOnClickListener(onClickListener);
        this.f15930b = (LinearLayout) view.findViewById(R.id.member1);
        this.f15934f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f15934f.setIsRound(true);
        this.f15934f.setBorderColor(color);
        this.f15934f.setBorderWidth(g2);
        this.f15934f.setOnClickListener(onClickListener);
        this.f15931c = (LinearLayout) view.findViewById(R.id.member2);
        this.f15935g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f15935g.setIsRound(true);
        this.f15935g.setBorderColor(color);
        this.f15935g.setBorderWidth(g2);
        this.f15935g.setOnClickListener(onClickListener);
        this.f15932d = (LinearLayout) view.findViewById(R.id.member3);
        this.f15936h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f15936h.setIsRound(true);
        this.f15936h.setBorderColor(color);
        this.f15936h.setBorderWidth(g2);
        this.f15936h.setOnClickListener(onClickListener);
        this.f15933e = (LinearLayout) view.findViewById(R.id.member4);
        this.i = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.m = (TextView) view.findViewById(R.id.textview_user_name4);
        this.i.setIsRound(true);
        this.i.setBorderColor(color);
        this.i.setBorderWidth(g2);
        this.i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        String str;
        if (bawuRoleInfoPub == null || i < 0 || i > 3) {
            return;
        }
        BaijiahaoInfo baijiahaoInfo = bawuRoleInfoPub.baijiahao_info;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar)) {
            str = bawuRoleInfoPub.baijiahao_info.avatar;
        } else {
            str = bawuRoleInfoPub.portrait;
        }
        if (i == 0) {
            this.f15934f.W(str, 12, false);
            this.f15934f.setTag(bawuRoleInfoPub);
            this.f15934f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15930b.setVisibility(0);
        } else if (i == 1) {
            this.f15935g.W(str, 12, false);
            this.f15935g.setTag(bawuRoleInfoPub);
            this.f15935g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15931c.setVisibility(0);
        } else if (i == 2) {
            this.f15936h.W(str, 12, false);
            this.f15936h.setTag(bawuRoleInfoPub);
            this.f15936h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15932d.setVisibility(0);
        } else if (i != 3) {
        } else {
            this.i.W(str, 12, false);
            this.i.setTag(bawuRoleInfoPub);
            this.i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15933e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        if (this.f15934f.getVisibility() == 0) {
            this.f15934f.setIsNight(z);
            this.f15934f.refresh();
        }
        if (this.f15935g.getVisibility() == 0) {
            this.f15935g.setIsNight(z);
            this.f15935g.refresh();
        }
        if (this.f15936h.getVisibility() == 0) {
            this.f15936h.setIsNight(z);
            this.f15936h.refresh();
        }
        if (this.i.getVisibility() == 0) {
            this.i.setIsNight(z);
            this.i.refresh();
        }
    }
}
