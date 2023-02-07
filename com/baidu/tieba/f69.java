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
public class f69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m69 a;
    public d15 b;
    public l69 c;
    public k69 d;
    public i69 e;
    public g69 f;
    public g69 g;
    public g69 h;
    public j69 i;
    public h69 j;
    public MainTabActivity k;
    public v39 l;
    public boolean m;

    public f69(@NonNull MainTabActivity mainTabActivity, @NonNull v39 v39Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, v39Var};
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
        this.l = v39Var;
        this.a = new m69(mainTabActivity.getPageContext(), v39Var, mainTabActivity, false);
        this.b = new d15(mainTabActivity.getPageContext());
        this.c = new l69(mainTabActivity, v39Var);
        this.d = new k69(mainTabActivity, v39Var);
        this.i = new j69(mainTabActivity, v39Var);
        this.j = new h69(mainTabActivity, v39Var);
        this.e = new i69(mainTabActivity, v39Var);
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
        a15.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.m) {
            return;
        }
        ut7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.a);
        a15.g(linkedList);
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
            g69 g69Var = new g69(this.k, this.l, "source_from_help");
            this.f = g69Var;
            linkedList.add(g69Var);
            g69 g69Var2 = new g69(this.k, this.l, "source_from_virtual_image");
            this.g = g69Var2;
            linkedList.add(g69Var2);
            g69 g69Var3 = new g69(this.k, this.l, "source_from_theme");
            this.h = g69Var3;
            linkedList.add(g69Var3);
            a15.g(linkedList);
            this.m = true;
        }
    }
}
