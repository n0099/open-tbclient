package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.view.AdDownloadDlgView;
import com.baidu.nadcore.download.view.DefaultDownloadViewLP;
import com.baidu.nadcore.download.view.NadLPDownloadAuditView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class hh0 extends ih0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;
    public ch0 h;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh0 a;

        public a(hh0 hh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WeakReference<oh0<?>> weakReference = this.a.e;
                if (weakReference != null) {
                    weakReference.clear();
                }
                this.a.e = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ NadLPDownloadAuditView b;

        public b(hh0 hh0Var, ViewGroup viewGroup, NadLPDownloadAuditView nadLPDownloadAuditView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh0Var, viewGroup, nadLPDownloadAuditView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = nadLPDownloadAuditView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.removeView(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ NadLPDownloadAuditView b;

        public c(hh0 hh0Var, ViewGroup viewGroup, NadLPDownloadAuditView nadLPDownloadAuditView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh0Var, viewGroup, nadLPDownloadAuditView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = nadLPDownloadAuditView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.removeView(this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View] */
    public hh0(@NonNull vg0 vg0Var, @NonNull oh0<?> oh0Var) {
        super(vg0Var, oh0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vg0Var, oh0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((vg0) objArr2[0], (oh0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        oh0Var.getRealView().setOnClickListener(this);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.g = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            m();
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    @Override // com.baidu.tieba.ih0
    public void s(oh0<?> oh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oh0Var) == null) {
            super.s(oh0Var);
            oh0Var.getRealView().setOnClickListener(this);
        }
    }

    public void z(ch0 ch0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ch0Var) == null) {
            this.h = ch0Var;
        }
    }

    public void B(ViewGroup viewGroup, ch0 ch0Var, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, ch0Var, activity) == null) && viewGroup != null && (this.e.get() instanceof DefaultDownloadViewLP)) {
            oh0<?> oh0Var = this.e.get();
            if (!(oh0Var instanceof DefaultDownloadViewLP)) {
                return;
            }
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) oh0Var;
            defaultDownloadViewLP.e(false);
            ji0.c(ch0Var, defaultDownloadViewLP, activity, new a(this), null);
        }
    }

    public void C(ViewGroup viewGroup, ch0 ch0Var, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, ch0Var, context) == null) && viewGroup != null && (this.e.get() instanceof DefaultDownloadViewLP)) {
            oh0<?> oh0Var = this.e.get();
            if (!(oh0Var instanceof DefaultDownloadViewLP)) {
                return;
            }
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) oh0Var;
            defaultDownloadViewLP.e(false);
            AdDownloadDlgView adDownloadDlgView = new AdDownloadDlgView(context);
            adDownloadDlgView.b(ch0Var);
            adDownloadDlgView.setDownloadView(defaultDownloadViewLP);
            NadLPDownloadAuditView nadLPDownloadAuditView = new NadLPDownloadAuditView(context);
            nadLPDownloadAuditView.getDownloadView().addView(adDownloadDlgView);
            adDownloadDlgView.setOnCloseClickListener(new b(this, viewGroup, nadLPDownloadAuditView));
            nadLPDownloadAuditView.getDownloadViewOtherArea().setOnClickListener(new c(this, viewGroup, nadLPDownloadAuditView));
            viewGroup.addView(nadLPDownloadAuditView);
        }
    }

    public ch0 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (ch0) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WeakReference<oh0<?>> weakReference = this.e;
            if (weakReference != null && weakReference.get() != null) {
                oh0<?> oh0Var = this.e.get();
                if (oh0Var instanceof View) {
                    return !((View) oh0Var).isAttachedToWindow();
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
