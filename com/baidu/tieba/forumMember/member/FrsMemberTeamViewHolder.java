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
    public TextView f15076a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15077b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15078c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15079d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15080e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15081f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15082g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15083h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f15084i;
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
        this.f15076a = textView;
        textView.setOnClickListener(onClickListener);
        this.f15077b = (LinearLayout) view.findViewById(R.id.member1);
        this.f15081f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f15081f.setIsRound(true);
        this.f15081f.setBorderColor(color);
        this.f15081f.setBorderWidth(g2);
        this.f15081f.setOnClickListener(onClickListener);
        this.f15078c = (LinearLayout) view.findViewById(R.id.member2);
        this.f15082g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f15082g.setIsRound(true);
        this.f15082g.setBorderColor(color);
        this.f15082g.setBorderWidth(g2);
        this.f15082g.setOnClickListener(onClickListener);
        this.f15079d = (LinearLayout) view.findViewById(R.id.member3);
        this.f15083h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f15083h.setIsRound(true);
        this.f15083h.setBorderColor(color);
        this.f15083h.setBorderWidth(g2);
        this.f15083h.setOnClickListener(onClickListener);
        this.f15080e = (LinearLayout) view.findViewById(R.id.member4);
        this.f15084i = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.m = (TextView) view.findViewById(R.id.textview_user_name4);
        this.f15084i.setIsRound(true);
        this.f15084i.setBorderColor(color);
        this.f15084i.setBorderWidth(g2);
        this.f15084i.setOnClickListener(onClickListener);
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
            this.f15081f.V(str, 12, false);
            this.f15081f.setTag(bawuRoleInfoPub);
            this.f15081f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15077b.setVisibility(0);
        } else if (i2 == 1) {
            this.f15082g.V(str, 12, false);
            this.f15082g.setTag(bawuRoleInfoPub);
            this.f15082g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15078c.setVisibility(0);
        } else if (i2 == 2) {
            this.f15083h.V(str, 12, false);
            this.f15083h.setTag(bawuRoleInfoPub);
            this.f15083h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15079d.setVisibility(0);
        } else if (i2 != 3) {
        } else {
            this.f15084i.V(str, 12, false);
            this.f15084i.setTag(bawuRoleInfoPub);
            this.f15084i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15080e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        if (this.f15081f.getVisibility() == 0) {
            this.f15081f.setIsNight(z);
            this.f15081f.refresh();
        }
        if (this.f15082g.getVisibility() == 0) {
            this.f15082g.setIsNight(z);
            this.f15082g.refresh();
        }
        if (this.f15083h.getVisibility() == 0) {
            this.f15083h.setIsNight(z);
            this.f15083h.refresh();
        }
        if (this.f15084i.getVisibility() == 0) {
            this.f15084i.setIsNight(z);
            this.f15084i.refresh();
        }
    }
}
