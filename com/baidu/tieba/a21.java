package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.query.JoinType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final JoinType a;
    public final String b;
    public final String c;
    public final w11 d;
    public final o11 e;
    public final o11 f;
    public final StringBuilder g;
    public boolean h;
    public boolean i;

    public final void a(String str, String str2, o11 o11Var, o11 o11Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, o11Var, o11Var2) == null) {
            this.g.append(str);
            this.g.append(".");
            this.g.append(o11Var.b);
            this.g.append(" = ");
            this.g.append(str2);
            this.g.append(".");
            this.g.append(o11Var2.b);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.h) {
            return;
        }
        this.h = true;
        this.g.append(" ");
        this.g.append(this.a.toString());
        this.g.append(" JOIN ");
        this.g.append(this.d.g());
        this.g.append(" AS ");
        this.g.append(this.c);
        this.g.append(" ON ");
        if (this.i) {
            this.g.append("(");
        }
        a(this.b, this.c, this.e, this.f);
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b();
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.g);
            if (this.i) {
                sb.append(") ");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
