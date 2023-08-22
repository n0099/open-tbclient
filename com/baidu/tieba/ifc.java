package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class ifc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fec a;
    public udc b;

    /* loaded from: classes6.dex */
    public class a implements fec {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ifc a;

        public a(ifc ifcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ifcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ifcVar;
        }

        @Override // com.baidu.tieba.fec
        public void a(PayFlowType payFlowType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, payFlowType) != null) {
                return;
            }
            this.a.g(payFlowType);
        }

        @Override // com.baidu.tieba.fec
        public void b(PayFlowType payFlowType, PayDialogType payDialogType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payFlowType, payDialogType) != null) {
                return;
            }
            this.a.f(payFlowType, payDialogType);
        }

        @Override // com.baidu.tieba.fec
        public void c(String str, PayFlowType payFlowType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, payFlowType) != null) {
                return;
            }
            this.a.i(str, payFlowType);
        }

        @Override // com.baidu.tieba.fec
        public void d(String str, PayFlowType payFlowType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048579, this, str, payFlowType) != null) {
                return;
            }
            this.a.h(str, payFlowType);
        }
    }

    public ifc(udc udcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {udcVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = udcVar;
        j();
    }

    public fec e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (fec) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RLog.info("ViewLifecycleManager", "preparePayFlowLifecycle");
            this.a = new a(this);
        }
    }

    public final void f(PayFlowType payFlowType, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payFlowType, payDialogType) == null) {
            RLog.info("ViewLifecycleManager", "notifyPayDialogTypeChange payFlowType:" + payFlowType.name() + " payDialogType:" + payDialogType + " mYYPayController:" + this.b.getCurPayController());
            if (payDialogType == PayDialogType.PAY_NONE_DIALOG) {
                l(payFlowType);
            }
        }
    }

    public final synchronized void h(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, payFlowType) == null) {
            synchronized (this) {
                RLog.info("ViewLifecycleManager", "payActivityDestroyRecord name:" + str + " payFlowType:" + payFlowType.name() + " mYYPayController:" + this.b.getCurPayController());
                if (this.b.getCurPayController() != null) {
                    this.b.getCurPayController().l(str, payFlowType);
                }
                l(payFlowType);
            }
        }
    }

    public final synchronized void i(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, payFlowType) == null) {
            synchronized (this) {
                RLog.info("ViewLifecycleManager", "payActivityVisitRecord name:" + str + " payFlowType:" + payFlowType.name() + " mYYPayController:" + this.b.getCurPayController());
                if (this.b.getCurPayController() != null) {
                    this.b.getCurPayController().d(str, payFlowType);
                }
            }
        }
    }

    public final void g(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payFlowType) == null) {
            RLog.info("ViewLifecycleManager", "notifyPayFlowWork payFlowType:" + payFlowType.name() + " mYYPayController:" + this.b.getCurPayController());
        }
    }

    public final void k(PayFlowType payFlowType) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, payFlowType) == null) {
            if (this.b.getCurPayController() != null && this.b.getCurPayController().e()) {
                z = true;
            } else {
                z = false;
            }
            RLog.info("ViewLifecycleManager", "tryReleasePayController payFlowType:" + payFlowType.name() + " release:" + z + " mYYPayController:" + this.b.getCurPayController());
            if (z) {
                this.b.releasePayController(true);
                this.b.cancelAllRequest();
            }
        }
    }

    public final synchronized void l(PayFlowType payFlowType) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, payFlowType) == null) {
            synchronized (this) {
                if (this.b.getCurPayController() != null && this.b.getCurPayController().k(payFlowType)) {
                    z = true;
                } else {
                    z = false;
                }
                RLog.info("ViewLifecycleManager", "tryReleasePayFlow payFlowType:" + payFlowType.name() + " release:" + z + " mYYPayController:" + this.b.getCurPayController());
                if (z) {
                    this.b.getCurPayController().c(payFlowType, true);
                }
                k(payFlowType);
            }
        }
    }
}
