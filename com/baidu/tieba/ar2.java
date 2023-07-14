package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public class ar2 extends pp2<gs2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pp2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "enableLocalMirror" : (String) invokeV.objValue;
    }

    public ar2() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pp2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull gs2 gs2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, gs2Var) == null) {
            String str = command.what;
            d(gs2Var, str, "" + command.obj, true);
            Object obj = command.obj;
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (TextUtils.equals("auto", str2)) {
                    gs2Var.h0(str2);
                } else if (TextUtils.equals("enable", str2)) {
                    gs2Var.h0(str2);
                } else if (TextUtils.equals(PackageTable.DISABLE, str2)) {
                    gs2Var.h0(str2);
                }
            }
        }
    }
}
