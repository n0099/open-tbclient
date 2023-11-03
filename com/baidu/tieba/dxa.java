package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class dxa implements rva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fxa a;
    public exa b;
    public MainTabActivity c;
    public lua d;

    public dxa(@NonNull MainTabActivity mainTabActivity, @NonNull lua luaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, luaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = mainTabActivity;
        this.d = luaVar;
        this.a = new fxa(mainTabActivity.getPageContext(), luaVar, mainTabActivity, false);
    }

    @Override // com.baidu.tieba.rva
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            p05.g(linkedList);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            exa exaVar = new exa(this.c, this.d, "source_from_theme");
            this.b = exaVar;
            linkedList.add(exaVar);
            p05.g(linkedList);
        }
    }
}
