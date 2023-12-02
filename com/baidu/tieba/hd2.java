package com.baidu.tieba;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public long B;
    public long C;
    public boolean D;
    public int E;
    public String F;
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public int s;
    public String t;
    public String u;
    public String v;
    public long w;
    public int x;
    public int y;
    public int z;

    public hd2() {
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
        this.B = PMSAppInfo.DEFAULT_SWAN_APP_PKG_MAX_AGE;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SwanAppDbInfo{appId='" + this.a + "', appKey='" + this.b + "', errorCode=" + this.d + ", errorDetail='" + this.e + "', errorMsg='" + this.f + "', resumeDate='" + this.g + "', maxSwanVersion='" + this.j + "', minSwanVersion='" + this.k + "', name='" + this.l + "', version='" + this.q + "', type=" + this.r + ", isHaveZip=" + this.s + ", targetSwanVersion='" + this.v + "', mAppZipSize=" + this.w + ", mPendingApsErrcode=" + this.x + ", category=" + this.y + ", versionCode='" + this.A + "', maxAge=" + this.B + ", createTime=" + this.C + ", forceFetchMetaInfoFlag=" + this.D + ", payProtected=" + this.E + '}';
        }
        return (String) invokeV.objValue;
    }
}
