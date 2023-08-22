package com.baidu.tieba.downloadmanager.ui;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DownloadManagerNoDataLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public NoDataView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerNoDataLayout(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(context, R.dimen.tbds585)));
            this.b = NoDataViewFactory.b(getContext(), this, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NORESULT, BdUtilHelper.getDimens(context, R.dimen.M_H_X010)), null, null, true);
            this.a = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d8);
            this.b.setVisibility(0);
        }
    }

    public void b(TbPageContext<BaseFragmentActivity> tbPageContext, int i) {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) && (noDataView = this.b) != null) {
            noDataView.f(tbPageContext, i);
        }
    }

    public void setNoDataText(int i) {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (noDataView = this.b) != null) {
            noDataView.setTextOption(NoDataViewFactory.e.c(String.format(this.a, TbadkApplication.getInst().getString(i))));
        }
    }
}
