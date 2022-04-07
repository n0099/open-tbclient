package com.baidu.tieba.chosen.posts;

import android.os.Bundle;
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
import com.repackage.i65;
import com.repackage.py5;
import com.repackage.r65;
import com.repackage.s65;
import com.repackage.ty5;
/* loaded from: classes3.dex */
public class ChosenPostActivity extends BaseActivity<ChosenPostActivity> implements r65 {
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
    public py5 mViewController;
    public ViewEventCenter mViewEventController;

    public ChosenPostActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void handlePictureClick(s65 s65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, s65Var) == null) {
            i65 a = s65Var.a();
            if (a instanceof ty5) {
                sendMessage(((ty5) a).a(getPageContext().getPageActivity()));
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

    public py5 getViewController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mViewController == null) {
                this.mViewController = new py5(this);
            }
            return this.mViewController;
        }
        return (py5) invokeV.objValue;
    }

    @Override // com.repackage.r65
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            getViewController().p(getPageContext(), i);
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
                this.mModelController.D(getIntent().getExtras());
            } else if (bundle != null) {
                this.mModelController.D(bundle);
            } else {
                this.mModelController.D(null);
            }
            setContentView(this.mViewController.r());
            this.mViewController.t();
            this.mViewController.p(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            adjustResizeForSoftInput();
        }
    }

    @Override // com.repackage.r65
    public boolean onEventDispatch(s65 s65Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, s65Var)) == null) {
            if (s65Var.b() == 4096) {
                handlePictureClick(s65Var);
            }
            return getViewController().s(s65Var) || getModelController().F(s65Var);
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
