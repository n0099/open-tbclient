package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tieba.cf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class hm8 extends cf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<wc5> m;

    @Override // com.baidu.tieba.qc5
    public void C(pc5 pc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pc5Var) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements cf5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm8 a;

        public a(hm8 hm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm8Var;
        }

        @Override // com.baidu.tieba.cf5.a
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view2, viewGroup)) == null) {
                DLauncher A = this.a.A(i);
                if (A.getLayoutParams() == null) {
                    A.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                }
                return A;
            }
            return (View) invokeILL.objValue;
        }
    }

    public hm8() {
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

    @Override // com.baidu.tieba.cf5
    public void a() {
        LinkedList<wc5> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (linkedList = this.m) != null) {
            linkedList.clear();
            this.m = null;
        }
    }

    @Override // com.baidu.tieba.cf5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList<wc5> linkedList = this.m;
            if (linkedList != null) {
                return linkedList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final DLauncher A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= 0 && i < c()) {
                return (DLauncher) this.m.get(i);
            }
            return null;
        }
        return (DLauncher) invokeI.objValue;
    }

    public void z(LinkedList<wc5> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, linkedList) == null) {
            this.m = linkedList;
        }
    }

    @Override // com.baidu.tieba.cf5
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            o(4);
            v(2);
            q(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
            t(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
            u(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
            x(new a(this));
            h().b(this);
        }
    }
}
