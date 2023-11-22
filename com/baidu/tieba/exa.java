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
public class exa implements sva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gxa a;
    public fxa b;
    public MainTabActivity c;
    public mua d;

    public exa(@NonNull MainTabActivity mainTabActivity, @NonNull mua muaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, muaVar};
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
        this.d = muaVar;
        this.a = new gxa(mainTabActivity.getPageContext(), muaVar, mainTabActivity, false);
    }

    @Override // com.baidu.tieba.sva
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
            fxa fxaVar = new fxa(this.c, this.d, "source_from_theme");
            this.b = fxaVar;
            linkedList.add(fxaVar);
            p05.g(linkedList);
        }
    }
}
