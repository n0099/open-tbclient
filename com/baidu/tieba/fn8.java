package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class fn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public View.OnClickListener b;
    public RelativeLayout c;
    public HeadImageView d;
    public TextView e;
    public TextView f;
    public ImageView g;

    public fn8(PbFragment pbFragment, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = pbFragment;
        this.b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i) == null) && bdTypeListView != null && (relativeLayout = this.c) != null) {
            bdTypeListView.w(relativeLayout, i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0747, (ViewGroup) null);
        this.c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091187);
        this.d = headImageView;
        headImageView.setIsRound(true);
        this.d.setPlaceHolder(1);
        this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0925da);
        this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0925d9);
        this.g = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091186);
        this.c.setOnClickListener(this.b);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
            }
            HeadImageView headImageView = this.d;
            if (headImageView != null) {
                headImageView.setSkinType(i);
            }
            TextView textView = this.e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && bdTypeListView != null && (relativeLayout = this.c) != null) {
            bdTypeListView.removeHeaderView(relativeLayout);
        }
    }

    public void e(ki8 ki8Var, BdTypeListView bdTypeListView) {
        String charSequence;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, ki8Var, bdTypeListView) == null) && ki8Var != null && bdTypeListView != null) {
            if (ki8Var.Q().isVideoThreadType() && ki8Var.Q().getSmartApp() != null) {
                SmartApp smartApp = ki8Var.Q().getSmartApp();
                this.c.setVisibility(0);
                d(bdTypeListView);
                a(bdTypeListView, 1);
                if (!gi.isEmpty(smartApp.avatar)) {
                    this.d.N(smartApp.avatar, 10, false, false);
                }
                if (!gi.isEmpty(smartApp.name)) {
                    charSequence = smartApp.name + " " + ((Object) this.a.getText(R.string.smart_app_suffix));
                } else {
                    charSequence = this.a.getText(R.string.intelligent_smart_app).toString();
                }
                this.e.setText(charSequence);
                if (!gi.isEmpty(smartApp._abstract)) {
                    this.f.setText(smartApp._abstract);
                } else {
                    this.f.setText(this.a.getText(R.string.smart_app_default_abstract));
                }
                this.c.setTag(smartApp);
                return;
            }
            this.c.setVisibility(8);
            d(bdTypeListView);
        }
    }
}
