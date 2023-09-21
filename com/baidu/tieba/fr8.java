package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog.GroupChatDialogFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kr8 a;
    public TbPageContext b;
    public GroupChatDialogFragment c;
    @Nullable
    public vq8 d;
    public ao5 e;
    public LoadingView f;
    public NoDataView g;
    public String h;
    public final View.OnClickListener i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr8 a;

        public a(fr8 fr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fr8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                if (this.a.e != null) {
                    this.a.e.dettachView(this.a.a.m());
                    this.a.e = null;
                }
                if (this.a.d != null) {
                    this.a.i();
                    this.a.c.U1();
                }
            }
        }
    }

    public fr8(@NonNull GroupChatDialogFragment groupChatDialogFragment, @NonNull TbPageContext tbPageContext, @NonNull vq8 vq8Var, kr8 kr8Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatDialogFragment, tbPageContext, vq8Var, kr8Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.c = groupChatDialogFragment;
        this.b = tbPageContext;
        this.d = vq8Var;
        this.a = kr8Var;
        this.h = str;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            LoadingView loadingView = this.f;
            if (loadingView != null) {
                loadingView.onChangeSkinType(i);
            }
            ao5 ao5Var = this.e;
            if (ao5Var != null) {
                ao5Var.onChangeSkinType();
            }
            NoDataView noDataView = this.g;
            if (noDataView != null) {
                noDataView.f(this.b, i);
            }
        }
    }

    public void e() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (loadingView = this.f) != null) {
            loadingView.dettachView(this.a.m());
        }
    }

    public void f() {
        ao5 ao5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ao5Var = this.e) != null) {
            ao5Var.dettachView(this.a.m());
            this.e = null;
        }
    }

    public void g() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.g) != null) {
            noDataView.setVisibility(8);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.a.n() != null) {
                this.a.n().setVisibility(8);
            }
            if (this.f == null) {
                LoadingView loadingView = new LoadingView(mm6.getContext());
                this.f = loadingView;
                loadingView.onChangeSkinType();
            }
            this.f.attachView(this.a.m());
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a.n() != null) {
                this.a.n().setVisibility(8);
            }
            e();
            if (this.e == null) {
                this.e = new ao5(mm6.getContext(), this.i);
            }
            this.e.j(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds300));
            this.e.attachView(this.a.m(), true);
            this.e.o();
            this.e.onChangeSkinType();
            this.e.e(R.color.transparent);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NoDataViewFactory.ImgType imgType = NoDataViewFactory.ImgType.WEBVIEW;
            String string = mm6.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0965);
            if (this.h.equals("message_tab")) {
                imgType = NoDataViewFactory.ImgType.CREATE;
                string = mm6.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0cd2);
            }
            if (this.a.n() != null) {
                this.a.n().setVisibility(8);
            }
            if (this.g == null) {
                this.g = NoDataViewFactory.b(mm6.getContext(), this.a.r(), NoDataViewFactory.d.b(imgType, 400), NoDataViewFactory.e.d(null, string), null, true);
            }
            this.g.f(this.b, TbadkApplication.getInst().getSkinType());
            this.g.setVisibility(0);
        }
    }
}
