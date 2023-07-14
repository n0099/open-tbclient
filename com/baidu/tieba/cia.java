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
public class cia implements pga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jia a;
    public j65 b;
    public iia c;
    public hia d;
    public fia e;
    public dia f;
    public gia g;
    public eia h;
    public MainTabActivity i;
    public pfa j;
    public boolean k;

    public cia(@NonNull MainTabActivity mainTabActivity, @NonNull pfa pfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
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
        this.j = pfaVar;
        this.a = new jia(mainTabActivity.getPageContext(), pfaVar, mainTabActivity, false);
        this.b = new j65(mainTabActivity.getPageContext());
        this.c = new iia(mainTabActivity, pfaVar);
        this.d = new hia(mainTabActivity, pfaVar);
        this.g = new gia(mainTabActivity, pfaVar);
        this.h = new eia(mainTabActivity, pfaVar);
        this.e = new fia(mainTabActivity, pfaVar);
    }

    @Override // com.baidu.tieba.pga
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                g65.g(linkedList);
            } else if (!this.k) {
            } else {
                ny8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.h);
                linkedList2.add(this.a);
                g65.g(linkedList2);
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
        g65.g(linkedList);
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
            dia diaVar = new dia(this.i, this.j, "source_from_theme");
            this.f = diaVar;
            linkedList.add(diaVar);
            g65.g(linkedList);
            this.k = true;
        }
    }
}
