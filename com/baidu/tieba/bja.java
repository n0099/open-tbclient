package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.zk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareItem a;
    public zk9 b;
    public final a c;

    /* loaded from: classes5.dex */
    public static final class a implements zk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bja a;

        @Override // com.baidu.tieba.zk9.a
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(bja bjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bjaVar;
        }

        @Override // com.baidu.tieba.zk9.a
        public void a(yk9 data) {
            boolean z;
            ShareItem shareItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String a = data.a();
                if (a.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && (shareItem = this.a.a) != null) {
                    shareItem.setShareToken(a);
                }
            }
        }
    }

    public bja() {
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
        this.c = new a(this);
    }

    public final void c() {
        zk9 zk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (zk9Var = this.b) != null) {
            zk9Var.c();
        }
    }

    public final void d(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem) == null) {
            Intrinsics.checkNotNullParameter(shareItem, "shareItem");
            this.a = shareItem;
            zk9 zk9Var = this.b;
            if (zk9Var != null) {
                zk9Var.a(shareItem);
            }
        }
    }

    public final void b(Context context) {
        BdUniqueId uniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            BdPageContext<?> a2 = a5.a(context);
            if (a2 != null && (uniqueId = a2.getUniqueId()) != null) {
                Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
                zk9 zk9Var = new zk9(uniqueId);
                this.b = zk9Var;
                Intrinsics.checkNotNull(zk9Var);
                zk9Var.g(this.c);
            }
        }
    }
}
