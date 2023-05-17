package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ModelHelper {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ModelHelper sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public IUpdatesModel mUpdatesModel;
    public IValidateModel mValidateModel;

    public ModelHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init();
    }

    public static ModelHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (ModelHelper.class) {
                    if (sInstance == null) {
                        sInstance = new ModelHelper();
                    }
                }
            }
            return sInstance;
        }
        return (ModelHelper) invokeV.objValue;
    }

    public IUpdatesModel getUpdatasModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mUpdatesModel;
        }
        return (IUpdatesModel) invokeV.objValue;
    }

    public IValidateModel getValidateModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mValidateModel;
        }
        return (IValidateModel) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001299, IValidateModel.class);
            if (runTask != null) {
                this.mValidateModel = (IValidateModel) runTask.getData();
            }
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001298, IUpdatesModel.class);
            if (runTask2 != null) {
                this.mUpdatesModel = (IUpdatesModel) runTask2.getData();
            }
        }
    }
}
