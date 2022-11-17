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
public class hu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ou8 a;
    public ew4 b;
    public nu8 c;
    public mu8 d;
    public ku8 e;
    public iu8 f;
    public iu8 g;
    public iu8 h;
    public lu8 i;
    public ju8 j;
    public MainTabActivity k;
    public as8 l;
    public boolean m;

    public hu8(@NonNull MainTabActivity mainTabActivity, @NonNull as8 as8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, as8Var};
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
        this.l = as8Var;
        this.a = new ou8(mainTabActivity.getPageContext(), as8Var, mainTabActivity, false);
        this.b = new ew4(mainTabActivity.getPageContext());
        this.c = new nu8(mainTabActivity, as8Var);
        this.d = new mu8(mainTabActivity, as8Var);
        this.i = new lu8(mainTabActivity, as8Var);
        this.j = new ju8(mainTabActivity, as8Var);
        this.e = new ku8(mainTabActivity, as8Var);
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
        bw4.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.m) {
            return;
        }
        ph7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.a);
        bw4.g(linkedList);
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
            iu8 iu8Var = new iu8(this.k, this.l, "source_from_help");
            this.f = iu8Var;
            linkedList.add(iu8Var);
            iu8 iu8Var2 = new iu8(this.k, this.l, "source_from_virtual_image");
            this.g = iu8Var2;
            linkedList.add(iu8Var2);
            iu8 iu8Var3 = new iu8(this.k, this.l, "source_from_theme");
            this.h = iu8Var3;
            linkedList.add(iu8Var3);
            bw4.g(linkedList);
            this.m = true;
        }
    }
}
