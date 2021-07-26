package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f15296a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15297b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15298c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15299d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15300e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15301f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15302g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15303h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f15304i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public NoPressedLinearLayout n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int g2 = l.g(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = SkinManager.getColor(R.color.black_alpha10);
        TextView textView = (TextView) view.findViewById(R.id.title_text_view);
        this.f15296a = textView;
        textView.setOnClickListener(onClickListener);
        this.f15297b = (LinearLayout) view.findViewById(R.id.member1);
        this.f15301f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f15301f.setIsRound(true);
        this.f15301f.setBorderColor(color);
        this.f15301f.setBorderWidth(g2);
        this.f15301f.setOnClickListener(onClickListener);
        this.f15298c = (LinearLayout) view.findViewById(R.id.member2);
        this.f15302g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f15302g.setIsRound(true);
        this.f15302g.setBorderColor(color);
        this.f15302g.setBorderWidth(g2);
        this.f15302g.setOnClickListener(onClickListener);
        this.f15299d = (LinearLayout) view.findViewById(R.id.member3);
        this.f15303h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f15303h.setIsRound(true);
        this.f15303h.setBorderColor(color);
        this.f15303h.setBorderWidth(g2);
        this.f15303h.setOnClickListener(onClickListener);
        this.f15300e = (LinearLayout) view.findViewById(R.id.member4);
        this.f15304i = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.m = (TextView) view.findViewById(R.id.textview_user_name4);
        this.f15304i.setIsRound(true);
        this.f15304i.setBorderColor(color);
        this.f15304i.setBorderWidth(g2);
        this.f15304i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bawuRoleInfoPub, i2) == null) || bawuRoleInfoPub == null || i2 < 0 || i2 > 3) {
            return;
        }
        BaijiahaoInfo baijiahaoInfo = bawuRoleInfoPub.baijiahao_info;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar)) {
            str = bawuRoleInfoPub.baijiahao_info.avatar;
        } else {
            str = bawuRoleInfoPub.portrait;
        }
        if (i2 == 0) {
            this.f15301f.M(str, 12, false);
            this.f15301f.setTag(bawuRoleInfoPub);
            this.f15301f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15297b.setVisibility(0);
        } else if (i2 == 1) {
            this.f15302g.M(str, 12, false);
            this.f15302g.setTag(bawuRoleInfoPub);
            this.f15302g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15298c.setVisibility(0);
        } else if (i2 == 2) {
            this.f15303h.M(str, 12, false);
            this.f15303h.setTag(bawuRoleInfoPub);
            this.f15303h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15299d.setVisibility(0);
        } else if (i2 != 3) {
        } else {
            this.f15304i.M(str, 12, false);
            this.f15304i.setTag(bawuRoleInfoPub);
            this.f15304i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15300e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (this.f15301f.getVisibility() == 0) {
                this.f15301f.setIsNight(z);
                this.f15301f.refresh();
            }
            if (this.f15302g.getVisibility() == 0) {
                this.f15302g.setIsNight(z);
                this.f15302g.refresh();
            }
            if (this.f15303h.getVisibility() == 0) {
                this.f15303h.setIsNight(z);
                this.f15303h.refresh();
            }
            if (this.f15304i.getVisibility() == 0) {
                this.f15304i.setIsNight(z);
                this.f15304i.refresh();
            }
        }
    }
}
