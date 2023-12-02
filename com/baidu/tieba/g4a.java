package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView a;
    public final TBSpecificationBtn b;
    public final PbFragment c;
    public String d;

    public g4a(TextView mPbViews, TBSpecificationBtn mPbViewsBtn, PbFragment mPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mPbViews, mPbViewsBtn, mPbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mPbViews, "mPbViews");
        Intrinsics.checkNotNullParameter(mPbViewsBtn, "mPbViewsBtn");
        Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
        this.a = mPbViews;
        this.b = mPbViewsBtn;
        this.c = mPbFragment;
        c();
    }

    public static final void d(g4a this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(this$0.c.getContext(), (int) R.string.obfuscated_res_0x7f0f0e70);
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = this$0.c.getPageContext();
            TiebaPlusConfigData b = this$0.b();
            String str = this$0.d;
            Intrinsics.checkNotNull(str);
            urlManager.dealOneLink(pageContext, new String[]{b.getJumpUrlWithTid(str)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }
    }

    public final void a(String tid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            this.d = tid;
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (b().isSwitchOpen()) {
                this.b.l(i);
            } else {
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            }
        }
    }

    public final void f(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, charSequence) != null) || charSequence == null) {
            return;
        }
        if (b().isSwitchOpen()) {
            this.b.setText(charSequence.toString());
        } else {
            this.a.setText(charSequence);
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (b().isSwitchOpen()) {
                this.b.setVisibility(i);
                this.a.setVisibility(8);
                return;
            }
            this.b.setVisibility(8);
            this.a.setVisibility(i);
        }
    }

    public final TiebaPlusConfigData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TiebaPlusConfigData config = TbSingleton.getInstance().getTiebaPlusConfigData();
            if (config == null) {
                config = TiebaPlusConfigData.DEFAULT;
            }
            Intrinsics.checkNotNullExpressionValue(config, "config");
            return config;
        }
        return (TiebaPlusConfigData) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e65 e65Var = new e65();
            e65Var.u(R.color.CAM_X0302);
            this.b.setConfig(e65Var);
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.v3a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        g4a.d(g4a.this, view2);
                    }
                }
            });
        }
    }
}
