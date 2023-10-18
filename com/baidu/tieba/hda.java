package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class hda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<FrsTabInfo> a;
    public List<FrsTabInfo> b;
    public List<FrsTabInfo> c;

    public hda() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public void a(NavTabInfo navTabInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, navTabInfo) != null) || navTabInfo == null) {
            return;
        }
        this.a = new ArrayList(navTabInfo.tab);
        this.b = new ArrayList(navTabInfo.menu);
        this.c = new ArrayList(navTabInfo.head);
    }
}
