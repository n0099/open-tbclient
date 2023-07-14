package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ForumPresentInfo;
import tbclient.UserRankPresentInfo;
/* loaded from: classes5.dex */
public class a35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<a> a;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(a35 a35Var, UserRankPresentInfo userRankPresentInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a35Var, userRankPresentInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (userRankPresentInfo == null) {
                return;
            }
            Integer num = userRankPresentInfo.user_id;
            String str = userRankPresentInfo.user_name;
            String str2 = userRankPresentInfo.portrait;
        }
    }

    public a35() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(ForumPresentInfo forumPresentInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, forumPresentInfo) != null) || forumPresentInfo == null) {
            return;
        }
        String str = forumPresentInfo.content;
        this.a = new ArrayList<>();
        for (int i = 0; i < forumPresentInfo.user_list.size(); i++) {
            this.a.add(new a(this, forumPresentInfo.user_list.get(i)));
        }
    }
}
