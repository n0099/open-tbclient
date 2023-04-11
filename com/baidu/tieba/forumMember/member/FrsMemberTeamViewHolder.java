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
import com.baidu.tieba.ii;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
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
        int g = ii.g(BdBaseApplication.getInst().getApp(), R.dimen.obfuscated_res_0x7f070198);
        int color = SkinManager.getColor(R.color.black_alpha10);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092420);
        this.a = textView;
        textView.setOnClickListener(onClickListener);
        this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091658);
        this.f = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09101b);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09234f);
        this.f.setIsRound(true);
        this.f.setBorderColor(color);
        this.f.setBorderWidth(g);
        this.f.setOnClickListener(onClickListener);
        this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091659);
        this.g = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09101c);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092350);
        this.g.setIsRound(true);
        this.g.setBorderColor(color);
        this.g.setBorderWidth(g);
        this.g.setOnClickListener(onClickListener);
        this.d = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09165a);
        this.h = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09101d);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092351);
        this.h.setIsRound(true);
        this.h.setBorderColor(color);
        this.h.setBorderWidth(g);
        this.h.setOnClickListener(onClickListener);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09165b);
        this.i = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09101e);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092352);
        this.i.setIsRound(true);
        this.i.setBorderColor(color);
        this.i.setBorderWidth(g);
        this.i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b8b);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, bawuRoleInfoPub, i) == null) && bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            String str5 = bawuRoleInfoPub.portrait;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            this.i.N(str5, 12, false);
                            this.i.setTag(bawuRoleInfoPub);
                            this.i.setContentDescription(bawuRoleInfoPub.user_name);
                            TextView textView = this.m;
                            if (StringUtils.isNull(bawuRoleInfoPub.name_show)) {
                                str4 = bawuRoleInfoPub.user_name;
                            } else {
                                str4 = bawuRoleInfoPub.name_show;
                            }
                            textView.setText(str4);
                            this.e.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    this.h.N(str5, 12, false);
                    this.h.setTag(bawuRoleInfoPub);
                    this.h.setContentDescription(bawuRoleInfoPub.user_name);
                    TextView textView2 = this.l;
                    if (StringUtils.isNull(bawuRoleInfoPub.name_show)) {
                        str3 = bawuRoleInfoPub.user_name;
                    } else {
                        str3 = bawuRoleInfoPub.name_show;
                    }
                    textView2.setText(str3);
                    this.d.setVisibility(0);
                    return;
                }
                this.g.N(str5, 12, false);
                this.g.setTag(bawuRoleInfoPub);
                this.g.setContentDescription(bawuRoleInfoPub.user_name);
                TextView textView3 = this.k;
                if (StringUtils.isNull(bawuRoleInfoPub.name_show)) {
                    str2 = bawuRoleInfoPub.user_name;
                } else {
                    str2 = bawuRoleInfoPub.name_show;
                }
                textView3.setText(str2);
                this.c.setVisibility(0);
                return;
            }
            this.f.N(str5, 12, false);
            this.f.setTag(bawuRoleInfoPub);
            this.f.setContentDescription(bawuRoleInfoPub.user_name);
            TextView textView4 = this.j;
            if (StringUtils.isNull(bawuRoleInfoPub.name_show)) {
                str = bawuRoleInfoPub.user_name;
            } else {
                str = bawuRoleInfoPub.name_show;
            }
            textView4.setText(str);
            this.b.setVisibility(0);
        }
    }

    public void b(int i) {
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
