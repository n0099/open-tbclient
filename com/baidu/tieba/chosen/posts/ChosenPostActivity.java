package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
import c.a.o0.i0.c.a;
import c.a.p0.b0.a.b;
import c.a.p0.b0.a.c.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVENT_ID_PICTURE_CLICK = 4096;
    public static final int EVENT_ID_RELOAD_DATA = 4100;
    public static final int EVENT_ID_REQUEST_BOTTOM = 4098;
    public static final int EVENT_ID_REQUEST_PULL = 4097;
    public static final int EVENT_ID_SEND_CACHE = 4099;
    public static final int EVENT_ID_UNLIKE = 4101;
    public static final int EVENT_ID_UNLIKE_RESULT = 4102;
    public transient /* synthetic */ FieldHolder $fh;
    public ChosenPostModelController mModelController;
    public b mViewController;
    public ViewEventCenter mViewEventController;

    public ChosenPostActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void handlePictureClick(c.a.o0.i0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bVar) == null) {
            c.a.o0.i0.b.a a2 = bVar.a();
            if (a2 instanceof d) {
                sendMessage(((d) a2).a(getPageContext().getPageActivity()));
            }
        }
    }

    public ViewEventCenter getEventCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mViewEventController == null) {
                this.mViewEventController = new ViewEventCenter();
            }
            return this.mViewEventController;
        }
        return (ViewEventCenter) invokeV.objValue;
    }

    public ChosenPostModelController getModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mModelController == null) {
                this.mModelController = new ChosenPostModelController(this);
            }
            return this.mModelController;
        }
        return (ChosenPostModelController) invokeV.objValue;
    }

    public b getViewController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mViewController == null) {
                this.mViewController = new b(this);
            }
            return this.mViewController;
        }
        return (b) invokeV.objValue;
    }

    @Override // c.a.o0.i0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            getViewController().n(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            getEventCenter().addEventDelegate(this);
            this.mModelController = getModelController();
            this.mViewController = getViewController();
            if (getIntent() != null) {
                this.mModelController.B(getIntent().getExtras());
            } else if (bundle != null) {
                this.mModelController.B(bundle);
            } else {
                this.mModelController.B(null);
            }
            setContentView(this.mViewController.o());
            this.mViewController.q();
            this.mViewController.n(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            adjustResizeForSoftInput();
        }
    }

    @Override // c.a.o0.i0.c.a
    public boolean onEventDispatch(c.a.o0.i0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            if (bVar.b() == 4096) {
                handlePictureClick(bVar);
            }
            return getViewController().p(bVar) || getModelController().D(bVar);
        }
        return invokeL.booleanValue;
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, errorData) == null) || errorData == null || StringUtils.isNull(errorData.error_msg)) {
            return;
        }
        showToast(errorData.error_msg);
    }
}
