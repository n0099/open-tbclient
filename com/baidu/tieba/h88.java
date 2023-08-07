package com.baidu.tieba;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h88 implements g88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g88 a;
    public AbsHListView b;

    public h88(AbsHListView absHListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absHListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = absHListView;
    }

    public void c(g88 g88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g88Var) == null) {
            this.a = g88Var;
        }
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, actionMode) == null) {
            this.a.onDestroyActionMode(actionMode);
            AbsHListView absHListView = this.b;
            absHListView.mChoiceActionMode = null;
            absHListView.clearChoices();
            AbsHListView absHListView2 = this.b;
            absHListView2.mDataChanged = true;
            absHListView2.rememberSyncState();
            this.b.requestLayout();
            this.b.setLongClickable(true);
        }
    }

    @Override // com.baidu.tieba.g88
    @TargetApi(11)
    public void a(ActionMode actionMode, int i, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{actionMode, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.a.a(actionMode, i, j, z);
            if (this.b.getCheckedItemCount() == 0) {
                actionMode.finish();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, actionMode, menuItem)) == null) {
            return this.a.onActionItemClicked(actionMode, menuItem);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, actionMode, menu)) == null) {
            if (!this.a.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            this.b.setLongClickable(false);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, actionMode, menu)) == null) {
            return this.a.onPrepareActionMode(actionMode, menu);
        }
        return invokeLL.booleanValue;
    }
}
