package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes6.dex */
public class hha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<fha> a;
    public ArrayList<gha> b;

    public hha() {
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
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
    }

    public void a(ActPost actPost) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, actPost) != null) || actPost == null) {
            return;
        }
        String str = actPost.list_head;
        for (ActHot actHot : actPost.act_hot) {
            if (actHot != null) {
                fha fhaVar = new fha();
                fhaVar.a(actHot);
                this.a.add(fhaVar);
            }
        }
        List<LinkInfo> list = actPost.link_info;
        for (LinkInfo linkInfo : list) {
            if (list != null) {
                gha ghaVar = new gha();
                ghaVar.a(linkInfo);
                this.b.add(ghaVar);
            }
        }
    }
}
