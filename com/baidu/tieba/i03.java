package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i03 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e03 c;
    public o03 d;
    public g03 e;
    public f03 f;
    public l03 g;
    public d03 h;
    public m03 i;
    public k03 j;
    public n03 k;
    public h03 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i03(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/video");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.ed3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        char c;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            h82.i("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + ed3.a(unitedSchemeEntity, "params"));
            switch (str.hashCode()) {
                case -1701478259:
                    if (str.equals("/swanAPI/video/pause")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440375597:
                    if (str.equals("/swanAPI/video/open")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440349763:
                    if (str.equals("/swanAPI/video/play")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440267007:
                    if (str.equals("/swanAPI/video/seek")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440252277:
                    if (str.equals("/swanAPI/video/stop")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1145507635:
                    if (str.equals("/swanAPI/video/remove")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1049743086:
                    if (str.equals("/swanAPI/video/update")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -274000988:
                    if (str.equals("/swanAPI/video/fullScreen")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 711122280:
                    if (str.equals("/swanAPI/video/sendDanmu")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1568993060:
                    if (str.equals("/swanAPI/video/playbackRate")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (this.c == null) {
                        this.c = new e03("/swanAPI/video/open");
                    }
                    c2 = this.c.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case 1:
                    if (this.d == null) {
                        this.d = new o03("/swanAPI/video/update");
                    }
                    c2 = this.d.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case 2:
                    if (this.j == null) {
                        this.j = new k03("/swanAPI/video/remove");
                    }
                    c2 = this.j.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case 3:
                    if (this.e == null) {
                        this.e = new g03("/swanAPI/video/play");
                    }
                    c2 = this.e.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case 4:
                    if (this.f == null) {
                        this.f = new f03("/swanAPI/video/pause");
                    }
                    c2 = this.f.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case 5:
                    if (this.g == null) {
                        this.g = new l03("/swanAPI/video/seek");
                    }
                    c2 = this.g.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case 6:
                    if (this.h == null) {
                        this.h = new d03("/swanAPI/video/fullScreen");
                    }
                    c2 = this.h.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case 7:
                    if (this.i == null) {
                        this.i = new m03("/swanAPI/video/sendDanmu");
                    }
                    c2 = this.i.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case '\b':
                    if (this.k == null) {
                        this.k = new n03("/swanAPI/video/stop");
                    }
                    c2 = this.k.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                case '\t':
                    if (this.l == null) {
                        this.l = new h03("/swanAPI/video/playbackRate");
                    }
                    c2 = this.l.c(context, unitedSchemeEntity, callbackHandler, hb3Var);
                    break;
                default:
                    c2 = false;
                    break;
            }
            if (!c2 && !super.i(context, unitedSchemeEntity, callbackHandler, str, hb3Var)) {
                return false;
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
