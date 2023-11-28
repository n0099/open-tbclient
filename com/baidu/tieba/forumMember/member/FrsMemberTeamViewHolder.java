package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes6.dex */
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
        int dimens = BdUtilHelper.getDimens(BdBaseApplication.getInst().getApp(), R.dimen.obfuscated_res_0x7f070198);
        int color = SkinManager.getColor(R.color.black_alpha10);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926b2);
        this.a = textView;
        textView.setOnClickListener(onClickListener);
        this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917dd);
        this.f = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09112e);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925dc);
        this.f.setIsRound(true);
        this.f.setBorderColor(color);
        this.f.setBorderWidth(dimens);
        this.f.setOnClickListener(onClickListener);
        this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917de);
        this.g = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09112f);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925dd);
        this.g.setIsRound(true);
        this.g.setBorderColor(color);
        this.g.setBorderWidth(dimens);
        this.g.setOnClickListener(onClickListener);
        this.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917df);
        this.h = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091130);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925de);
        this.h.setIsRound(true);
        this.h.setBorderColor(color);
        this.h.setBorderWidth(dimens);
        this.h.setOnClickListener(onClickListener);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917e0);
        this.i = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091131);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925df);
        this.i.setIsRound(true);
        this.i.setBorderColor(color);
        this.i.setBorderWidth(dimens);
        this.i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c5b);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, bawuRoleInfoPub, i) == null) && bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            b(bawuRoleInfoPub, this.i, this.m, this.e);
                            return;
                        }
                        return;
                    }
                    b(bawuRoleInfoPub, this.h, this.l, this.d);
                    return;
                }
                b(bawuRoleInfoPub, this.g, this.k, this.c);
                return;
            }
            b(bawuRoleInfoPub, this.f, this.j, this.b);
        }
    }

    public final void b(BawuRoleInfoPub bawuRoleInfoPub, HeadImageView headImageView, TextView textView, LinearLayout linearLayout) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bawuRoleInfoPub, headImageView, textView, linearLayout) != null) || bawuRoleInfoPub == null) {
            return;
        }
        zx9.a(headImageView, bawuRoleInfoPub.avatar_url, bawuRoleInfoPub.portrait, 12);
        headImageView.setTag(bawuRoleInfoPub);
        headImageView.setContentDescription(bawuRoleInfoPub.user_name);
        if (StringUtils.isNull(bawuRoleInfoPub.name_show)) {
            str = bawuRoleInfoPub.user_name;
        } else {
            str = bawuRoleInfoPub.name_show;
        }
        textView.setText(str);
        linearLayout.setVisibility(0);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
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
