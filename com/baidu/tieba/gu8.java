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
public class gu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nu8 a;
    public dw4 b;
    public mu8 c;
    public lu8 d;
    public ju8 e;
    public hu8 f;
    public hu8 g;
    public hu8 h;
    public ku8 i;
    public iu8 j;
    public MainTabActivity k;
    public zr8 l;
    public boolean m;

    public gu8(@NonNull MainTabActivity mainTabActivity, @NonNull zr8 zr8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, zr8Var};
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
        this.l = zr8Var;
        this.a = new nu8(mainTabActivity.getPageContext(), zr8Var, mainTabActivity, false);
        this.b = new dw4(mainTabActivity.getPageContext());
        this.c = new mu8(mainTabActivity, zr8Var);
        this.d = new lu8(mainTabActivity, zr8Var);
        this.i = new ku8(mainTabActivity, zr8Var);
        this.j = new iu8(mainTabActivity, zr8Var);
        this.e = new ju8(mainTabActivity, zr8Var);
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
        aw4.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.m) {
            return;
        }
        oh7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.a);
        aw4.g(linkedList);
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
            hu8 hu8Var = new hu8(this.k, this.l, "source_from_help");
            this.f = hu8Var;
            linkedList.add(hu8Var);
            hu8 hu8Var2 = new hu8(this.k, this.l, "source_from_virtual_image");
            this.g = hu8Var2;
            linkedList.add(hu8Var2);
            hu8 hu8Var3 = new hu8(this.k, this.l, "source_from_theme");
            this.h = hu8Var3;
            linkedList.add(hu8Var3);
            aw4.g(linkedList);
            this.m = true;
        }
    }
}
