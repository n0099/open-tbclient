package com.baidu.tieba.forumMember.member;

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
import com.repackage.pi;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public LinearLayout b;
    public LinearLayout c;
    public LinearLayout d;
    public LinearLayout e;
    public HeadImageView f;
    public HeadImageView g;
    public HeadImageView h;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public NoPressedLinearLayout n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMemberTeamViewHolder(View view2, View.OnClickListener onClickListener) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, onClickListener};
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
        int f = pi.f(BdBaseApplication.getInst().getApp(), R.dimen.obfuscated_res_0x7f070198);
        int color = SkinManager.getColor(R.color.black_alpha10);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920e9);
        this.a = textView;
        textView.setOnClickListener(onClickListener);
        this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091436);
        this.f = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e57);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092008);
        this.f.setIsRound(true);
        this.f.setBorderColor(color);
        this.f.setBorderWidth(f);
        this.f.setOnClickListener(onClickListener);
        this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091437);
        this.g = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e58);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092009);
        this.g.setIsRound(true);
        this.g.setBorderColor(color);
        this.g.setBorderWidth(f);
        this.g.setOnClickListener(onClickListener);
        this.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091438);
        this.h = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e59);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09200a);
        this.h.setIsRound(true);
        this.h.setBorderColor(color);
        this.h.setBorderWidth(f);
        this.h.setOnClickListener(onClickListener);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091439);
        this.i = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e5a);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09200b);
        this.i.setIsRound(true);
        this.i.setBorderColor(color);
        this.i.setBorderWidth(f);
        this.i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a3e);
    }

    public void c(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bawuRoleInfoPub, i) == null) || bawuRoleInfoPub == null || i < 0 || i > 3) {
            return;
        }
        String str = bawuRoleInfoPub.portrait;
        if (i == 0) {
            this.f.J(str, 12, false);
            this.f.setTag(bawuRoleInfoPub);
            this.f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.b.setVisibility(0);
        } else if (i == 1) {
            this.g.J(str, 12, false);
            this.g.setTag(bawuRoleInfoPub);
            this.g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.c.setVisibility(0);
        } else if (i == 2) {
            this.h.J(str, 12, false);
            this.h.setTag(bawuRoleInfoPub);
            this.h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.d.setVisibility(0);
        } else if (i != 3) {
        } else {
            this.i.J(str, 12, false);
            this.i.setTag(bawuRoleInfoPub);
            this.i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.e.setVisibility(0);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.f.getVisibility() == 0) {
                this.f.setSkinType(i);
                this.f.refresh();
            }
            if (this.g.getVisibility() == 0) {
                this.g.setSkinType(i);
                this.g.refresh();
            }
            if (this.h.getVisibility() == 0) {
                this.h.setSkinType(i);
                this.h.refresh();
            }
            if (this.i.getVisibility() == 0) {
                this.i.setSkinType(i);
                this.i.refresh();
            }
        }
    }
}
