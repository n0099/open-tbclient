package com.baidu.tieba;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fr6 extends MutableContextWrapper implements TbPageContextSupport, BdPageContextSupport {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fr6(Context context) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.BdPageContextSupport
    public TbPageContext<?> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context baseContext = getBaseContext();
            if (baseContext instanceof TbPageContextSupport) {
                return ((TbPageContextSupport) baseContext).getPageContext();
            }
            if (!TbadkCoreApplication.getInst().isDebugMode()) {
                return null;
            }
            throw new IllegalArgumentException("base context is not TbPageContextSupport!!!");
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // android.content.MutableContextWrapper
    public void setBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            if (context instanceof TbPageContextSupport) {
                super.setBaseContext(context);
            } else if (!TbadkCoreApplication.getInst().isDebugMode()) {
            } else {
                throw new IllegalArgumentException("base context is not TbPageContextSupport!!!");
            }
        }
    }
}
