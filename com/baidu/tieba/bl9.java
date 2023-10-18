package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public View a;
    public ViewGroup b;
    public EMTextView c;
    @NonNull
    public bs5<String> d;
    public boolean e;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public bl9(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = bs5.b();
        this.e = false;
        this.a = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0710, (ViewGroup) null);
        b();
    }

    public void a(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) && !this.e) {
            this.e = true;
            this.a.setVisibility(0);
            bdTypeListView.w(this.a, 1);
        }
    }

    public void d(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && this.e) {
            this.e = false;
            this.a.setVisibility(8);
            bdTypeListView.removeHeaderView(this.a);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0907bc);
            EMTextView eMTextView = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09276e);
            this.c = eMTextView;
            EMManager.from(eMTextView).setTextLinePadding(R.dimen.M_H_X003).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
        }
    }

    public void e(@NonNull ye9 ye9Var, int i, @Nullable a aVar) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, ye9Var, i, aVar) == null) {
            boolean z3 = true;
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            if (i == 25) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z && !z2) {
                z3 = false;
            }
            boolean u0 = ye9Var.u0(z3);
            if (u0) {
                this.c.setText(ye9Var.x());
                this.a.setVisibility(0);
                f(ye9Var.Q(), ye9Var.l(), ye9Var.m(), z, z2);
            } else {
                this.a.setVisibility(8);
            }
            if (aVar != null) {
                aVar.a(u0);
            }
        }
    }

    public final void f(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !this.d.a(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR)) {
            return;
        }
        int i = 2;
        if (z) {
            i = 1;
        }
        if (z2) {
            i = 3;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR).param("tid", str).param("fid", str2).param("fname", str3).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", i));
    }
}
