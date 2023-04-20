package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class br9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hr9 a;
    public x05 b;
    public gr9 c;
    public fr9 d;
    public dr9 e;
    public er9 f;
    public cr9 g;
    public MainTabActivity h;
    public boolean i;

    public br9(@NonNull MainTabActivity mainTabActivity, @NonNull ro9 ro9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ro9Var};
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
        this.a = new hr9(mainTabActivity.getPageContext(), ro9Var, mainTabActivity, false);
        this.b = new x05(mainTabActivity.getPageContext());
        this.c = new gr9(mainTabActivity, ro9Var);
        this.d = new fr9(mainTabActivity, ro9Var);
        this.f = new er9(mainTabActivity, ro9Var);
        this.g = new cr9(mainTabActivity, ro9Var);
        this.e = new dr9(mainTabActivity, ro9Var);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || LooperBlockSwitch.getIsOn() || !this.i) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.g);
        linkedList.add(this.c);
        linkedList.add(this.d);
        linkedList.add(this.e);
        u05.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                u05.g(linkedList);
            } else if (!this.i) {
            } else {
                yc8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.g);
                linkedList2.add(this.a);
                u05.g(linkedList2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                u05.g(linkedList);
                return;
            }
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(this.a);
            linkedList2.add(this.c);
            linkedList2.add(this.d);
            linkedList2.add(this.g);
            linkedList2.add(this.b);
            linkedList2.add(this.f);
            u05.g(linkedList2);
            this.i = true;
        }
    }
}
