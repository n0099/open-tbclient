package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
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
import tbclient.BawuRoleInfoPub;
/* loaded from: classes5.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f32210b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f32211c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f32212d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f32213e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f32214f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f32215g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f32216h;
    public HeadImageView i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int f2 = n.f(BdBaseApplication.getInst().getApp(), R.dimen.obfuscated_res_0x7f070198);
        int color = SkinManager.getColor(R.color.black_alpha10);
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09205b);
        this.a = textView;
        textView.setOnClickListener(onClickListener);
        this.f32210b = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0913c9);
        this.f32214f = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090e90);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f78);
        this.f32214f.setIsRound(true);
        this.f32214f.setBorderColor(color);
        this.f32214f.setBorderWidth(f2);
        this.f32214f.setOnClickListener(onClickListener);
        this.f32211c = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0913ca);
        this.f32215g = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090e91);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f79);
        this.f32215g.setIsRound(true);
        this.f32215g.setBorderColor(color);
        this.f32215g.setBorderWidth(f2);
        this.f32215g.setOnClickListener(onClickListener);
        this.f32212d = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0913cb);
        this.f32216h = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090e92);
        this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f7a);
        this.f32216h.setIsRound(true);
        this.f32216h.setBorderColor(color);
        this.f32216h.setBorderWidth(f2);
        this.f32216h.setOnClickListener(onClickListener);
        this.f32213e = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0913cc);
        this.i = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090e93);
        this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f7b);
        this.i.setIsRound(true);
        this.i.setBorderColor(color);
        this.i.setBorderWidth(f2);
        this.i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090a66);
    }

    public void c(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bawuRoleInfoPub, i) == null) || bawuRoleInfoPub == null || i < 0 || i > 3) {
            return;
        }
        String str = bawuRoleInfoPub.portrait;
        if (i == 0) {
            this.f32214f.J(str, 12, false);
            this.f32214f.setTag(bawuRoleInfoPub);
            this.f32214f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f32210b.setVisibility(0);
        } else if (i == 1) {
            this.f32215g.J(str, 12, false);
            this.f32215g.setTag(bawuRoleInfoPub);
            this.f32215g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f32211c.setVisibility(0);
        } else if (i == 2) {
            this.f32216h.J(str, 12, false);
            this.f32216h.setTag(bawuRoleInfoPub);
            this.f32216h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f32212d.setVisibility(0);
        } else if (i != 3) {
        } else {
            this.i.J(str, 12, false);
            this.i.setTag(bawuRoleInfoPub);
            this.i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f32213e.setVisibility(0);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.f32214f.getVisibility() == 0) {
                this.f32214f.setSkinType(i);
                this.f32214f.refresh();
            }
            if (this.f32215g.getVisibility() == 0) {
                this.f32215g.setSkinType(i);
                this.f32215g.refresh();
            }
            if (this.f32216h.getVisibility() == 0) {
                this.f32216h.setSkinType(i);
                this.f32216h.refresh();
            }
            if (this.i.getVisibility() == 0) {
                this.i.setSkinType(i);
                this.i.refresh();
            }
        }
    }
}
