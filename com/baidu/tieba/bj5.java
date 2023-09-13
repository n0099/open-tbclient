package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tieba.il5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class bj5 extends il5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<aj5> m;

    @Override // com.baidu.tieba.ti5
    public void G(si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, si5Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements il5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj5 a;

        public a(bj5 bj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj5Var;
        }

        @Override // com.baidu.tieba.il5.a
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeILL = interceptable.invokeILL(1048576, this, i, view2, viewGroup)) != null) {
                return (View) invokeILL.objValue;
            }
            DLauncher C = this.a.C(i);
            if (C.getLayoutParams() == null) {
                C.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            }
            return C;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CommonTabContentView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj5 a;

        public b(bj5 bj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj5Var;
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
        public void a(View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && view2.isEnabled() && (view2 instanceof DLauncher) && this.a.j != null) {
                this.a.j.A(view2);
            }
        }
    }

    public bj5() {
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

    @Override // com.baidu.tieba.il5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinkedList<aj5> linkedList = this.m;
            if (linkedList != null) {
                linkedList.clear();
            }
            this.m = null;
        }
    }

    @Override // com.baidu.tieba.il5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinkedList<aj5> linkedList = this.m;
            if (linkedList != null) {
                return linkedList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void B(LinkedList<aj5> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, linkedList) == null) {
            this.m = linkedList;
        }
    }

    public final DLauncher C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 0 && i < c()) {
                return (DLauncher) this.m.get(i);
            }
            return null;
        }
        return (DLauncher) invokeI.objValue;
    }

    @Override // com.baidu.tieba.il5
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            q(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
            t(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
            u(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
            o(4);
            v(2);
            x(new a(this));
            h().b(this);
            s(new b(this));
        }
    }
}
