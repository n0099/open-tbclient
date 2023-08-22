package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ila implements wja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kla a;
    public jla b;
    public MainTabActivity c;
    public qia d;

    public ila(@NonNull MainTabActivity mainTabActivity, @NonNull qia qiaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, qiaVar};
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
        this.d = qiaVar;
        this.a = new kla(mainTabActivity.getPageContext(), qiaVar, mainTabActivity, false);
        new l55(mainTabActivity.getPageContext());
    }

    @Override // com.baidu.tieba.wja
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            i55.g(linkedList);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            jla jlaVar = new jla(this.c, this.d, "source_from_theme");
            this.b = jlaVar;
            linkedList.add(jlaVar);
            i55.g(linkedList);
        }
    }
}
