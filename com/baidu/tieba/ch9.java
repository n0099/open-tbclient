package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ch9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ih9 a;
    public t05 b;
    public hh9 c;
    public gh9 d;
    public eh9 e;
    public fh9 f;
    public dh9 g;
    public MainTabActivity h;
    public boolean i;

    public ch9(@NonNull MainTabActivity mainTabActivity, @NonNull se9 se9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, se9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.h = mainTabActivity;
        this.a = new ih9(mainTabActivity.getPageContext(), se9Var, mainTabActivity, false);
        this.b = new t05(mainTabActivity.getPageContext());
        this.c = new hh9(mainTabActivity, se9Var);
        this.d = new gh9(mainTabActivity, se9Var);
        this.f = new fh9(mainTabActivity, se9Var);
        this.g = new dh9(mainTabActivity, se9Var);
        this.e = new eh9(mainTabActivity, se9Var);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.i) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.g);
        linkedList.add(this.c);
        linkedList.add(this.d);
        linkedList.add(this.e);
        q05.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.i) {
            return;
        }
        z18.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.g);
        linkedList.add(this.a);
        q05.g(linkedList);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            linkedList.add(this.c);
            linkedList.add(this.d);
            linkedList.add(this.g);
            linkedList.add(this.b);
            linkedList.add(this.f);
            q05.g(linkedList);
            this.i = true;
        }
    }
}
