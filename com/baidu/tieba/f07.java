package com.baidu.tieba;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class f07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public PopupWindow c;
    public Handler d;
    public Runnable e;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f07 a;

        public a(f07 f07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f07Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                jg.c(this.a.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ f07 c;

        public b(f07 f07Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f07Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f07Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.g(this.a, this.b);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f07 a;

        public c(f07 f07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e();
            }
        }
    }

    public f07(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new Handler();
        this.e = new a(this);
        this.a = tbPageContext;
    }

    public final int d(LinkedList<VisitedForumData> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList)) == null) {
            int size = linkedList.size();
            for (int i = 0; i < 3 && i < size; i++) {
                VisitedForumData visitedForumData = linkedList.get(i);
                if (visitedForumData != null && visitedForumData.isAlaForum()) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void c(LinkedList<VisitedForumData> linkedList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, linkedList, i) == null) {
            if (linkedList != null && linkedList.size() >= 1) {
                int d = d(linkedList);
                if (d < 0) {
                    SharedPrefHelper.getInstance().putBoolean("key_enter_forum_ufan_recent_visit_tip_show", true);
                    return;
                } else if (SharedPrefHelper.getInstance().getBoolean("key_enter_forum_ufan_recent_visit_tip_show", false)) {
                    return;
                } else {
                    this.d.postDelayed(new b(this, i, d), 100L);
                    return;
                }
            }
            SharedPrefHelper.getInstance().putBoolean("key_enter_forum_ufan_recent_visit_tip_show", true);
        }
    }

    public void e() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (popupWindow = this.c) != null) {
            jg.c(popupWindow);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.removeCallbacksAndMessages(null);
        }
    }

    public final void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            SharedPrefHelper.getInstance().putBoolean("key_enter_forum_ufan_recent_visit_tip_show", true);
            PopupWindow popupWindow = this.c;
            if (popupWindow != null && popupWindow.isShowing()) {
                return;
            }
            if (this.b == null) {
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02c1, (ViewGroup) null);
                this.b = inflate;
                inflate.setOnClickListener(new c(this));
            }
            if (this.c == null) {
                PopupWindow popupWindow2 = new PopupWindow(this.b, -2, -2);
                this.c = popupWindow2;
                popupWindow2.setOutsideTouchable(true);
                GreyUtil.grey(this.c);
            }
            jg.m(this.c, this.a.getPageActivity().findViewById(16908290), 51, this.a.getResources().getDimensionPixelSize(R.dimen.tbds44) + (i2 * this.a.getResources().getDimensionPixelSize(R.dimen.tbds220)), i);
            this.d.postDelayed(this.e, 5000L);
        }
    }
}
