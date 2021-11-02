package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class DragSortItemViewCheckable extends DragSortItemView implements Checkable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragSortItemViewCheckable(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View childAt = getChildAt(0);
            if (childAt instanceof Checkable) {
                return ((Checkable) childAt).isChecked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View childAt = getChildAt(0);
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(z);
            }
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View childAt = getChildAt(0);
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).toggle();
            }
        }
    }
}
