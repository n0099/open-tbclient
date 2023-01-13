package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class g29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n29 a;
    public qw4 b;
    public m29 c;
    public l29 d;
    public j29 e;
    public h29 f;
    public h29 g;
    public h29 h;
    public k29 i;
    public i29 j;
    public MainTabActivity k;
    public wz8 l;
    public boolean m;

    public g29(@NonNull MainTabActivity mainTabActivity, @NonNull wz8 wz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, wz8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.k = mainTabActivity;
        this.l = wz8Var;
        this.a = new n29(mainTabActivity.getPageContext(), wz8Var, mainTabActivity, false);
        this.b = new qw4(mainTabActivity.getPageContext());
        this.c = new m29(mainTabActivity, wz8Var);
        this.d = new l29(mainTabActivity, wz8Var);
        this.i = new k29(mainTabActivity, wz8Var);
        this.j = new i29(mainTabActivity, wz8Var);
        this.e = new j29(mainTabActivity, wz8Var);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.m) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.c);
        linkedList.add(this.d);
        linkedList.add(this.e);
        nw4.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.m) {
            return;
        }
        cp7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.a);
        nw4.g(linkedList);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            linkedList.add(this.c);
            linkedList.add(this.d);
            linkedList.add(this.j);
            linkedList.add(this.b);
            linkedList.add(this.i);
            h29 h29Var = new h29(this.k, this.l, "source_from_help");
            this.f = h29Var;
            linkedList.add(h29Var);
            h29 h29Var2 = new h29(this.k, this.l, "source_from_virtual_image");
            this.g = h29Var2;
            linkedList.add(h29Var2);
            h29 h29Var3 = new h29(this.k, this.l, "source_from_theme");
            this.h = h29Var3;
            linkedList.add(h29Var3);
            nw4.g(linkedList);
            this.m = true;
        }
    }
}
