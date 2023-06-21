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
/* loaded from: classes5.dex */
public class f5a implements s3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m5a a;
    public x55 b;
    public l5a c;
    public k5a d;
    public i5a e;
    public g5a f;
    public j5a g;
    public h5a h;
    public MainTabActivity i;
    public s2a j;
    public boolean k;

    public f5a(@NonNull MainTabActivity mainTabActivity, @NonNull s2a s2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, s2aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.i = mainTabActivity;
        this.j = s2aVar;
        this.a = new m5a(mainTabActivity.getPageContext(), s2aVar, mainTabActivity, false);
        this.b = new x55(mainTabActivity.getPageContext());
        this.c = new l5a(mainTabActivity, s2aVar);
        this.d = new k5a(mainTabActivity, s2aVar);
        this.g = new j5a(mainTabActivity, s2aVar);
        this.h = new h5a(mainTabActivity, s2aVar);
        this.e = new i5a(mainTabActivity, s2aVar);
    }

    @Override // com.baidu.tieba.s3a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                u55.g(linkedList);
            } else if (!this.k) {
            } else {
                zn8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.h);
                linkedList2.add(this.a);
                u55.g(linkedList2);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || LooperBlockSwitch.getIsOn() || !this.k) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.h);
        linkedList.add(this.c);
        linkedList.add(this.d);
        linkedList.add(this.e);
        u55.g(linkedList);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            if (!LooperBlockSwitch.getIsOn()) {
                linkedList.add(this.c);
                linkedList.add(this.d);
                linkedList.add(this.h);
                linkedList.add(this.b);
                linkedList.add(this.g);
            }
            g5a g5aVar = new g5a(this.i, this.j, "source_from_theme");
            this.f = g5aVar;
            linkedList.add(g5aVar);
            u55.g(linkedList);
            this.k = true;
        }
    }
}
