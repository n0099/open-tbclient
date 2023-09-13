package com.baidu.tieba;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a37 implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public int b;
    public c c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(AbsListView absListView, int i, int i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, absListView, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<d> a;

        public b(a37 a37Var, AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a37Var, absListView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = absListView.getChildAt(i4);
                if (childAt != null) {
                    this.a.add(new d(a37Var, childAt, i + i4, null));
                }
            }
        }

        public /* synthetic */ b(a37 a37Var, AbsListView absListView, int i, a aVar) {
            this(a37Var, absListView, i);
        }

        public final int b(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                if (bVar == null) {
                    return 0;
                }
                for (d dVar : this.a) {
                    for (d dVar2 : bVar.a) {
                        if (dVar.a == dVar2.a) {
                            return dVar.b - dVar2.b;
                        }
                    }
                }
                return 0;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public d(a37 a37Var, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a37Var, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = view2.getTop();
        }

        public /* synthetic */ d(a37 a37Var, View view2, int i, a aVar) {
            this(a37Var, view2, i);
        }
    }

    public a37() {
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
        this.b = 0;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.c = cVar;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i, i2, i3) != null) || absListView == null || i < 0 || absListView.getChildCount() <= 0 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        if (i == 0 && childAt.getTop() == absListView.getPaddingTop()) {
            int i4 = this.b;
            if (i4 != 0 && (cVar = this.c) != null) {
                cVar.a(absListView, 0, -i4);
            }
            this.b = 0;
            this.a = null;
            return;
        }
        b bVar = new b(this, absListView, i, null);
        b bVar2 = this.a;
        if (bVar2 != null) {
            int b2 = bVar2.b(bVar);
            this.a = bVar;
            int i5 = this.b + b2;
            this.b = i5;
            c cVar2 = this.c;
            if (cVar2 != null) {
                cVar2.a(absListView, i5, b2);
                return;
            }
            return;
        }
        this.a = bVar;
        int paddingTop = absListView.getPaddingTop() - childAt.getTop();
        this.b = paddingTop;
        c cVar3 = this.c;
        if (cVar3 != null) {
            cVar3.a(absListView, paddingTop, 0);
        }
    }
}
