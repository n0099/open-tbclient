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
public class cna implements qla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ena a;
    public dna b;
    public MainTabActivity c;
    public kka d;

    public cna(@NonNull MainTabActivity mainTabActivity, @NonNull kka kkaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, kkaVar};
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
        this.d = kkaVar;
        this.a = new ena(mainTabActivity.getPageContext(), kkaVar, mainTabActivity, false);
        new r55(mainTabActivity.getPageContext());
    }

    @Override // com.baidu.tieba.qla
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            o55.g(linkedList);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            dna dnaVar = new dna(this.c, this.d, "source_from_theme");
            this.b = dnaVar;
            linkedList.add(dnaVar);
            o55.g(linkedList);
        }
    }
}
