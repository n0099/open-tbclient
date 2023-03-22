package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c62 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c62(q83 q83Var) {
        super(q83Var, "/swanAPI/setPhoneContact");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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

    @SuppressLint({"BDOfflineUrl"})
    private void insert(Context context, b62 b62Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, b62Var, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
            intent.putExtra("name", b62Var.d());
            intent.putExtra("email", b62Var.r);
            intent.putParcelableArrayListExtra("data", k(b62Var));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            l(context, intent, callbackHandler);
        }
    }

    public final void j(Context context, b62 b62Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, b62Var, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
            intent.setType("vnd.android.cursor.item/contact");
            intent.putExtra("name", b62Var.d());
            intent.putExtra("email", b62Var.r);
            intent.putParcelableArrayListExtra("data", k(b62Var));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            l(context, intent, callbackHandler);
        }
    }

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (context != null && callbackHandler != null && t73Var != null) {
                if (t73Var.n0()) {
                    if (q93.b) {
                        Log.d("SetPhoneContactAction", "SetPhoneContactAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (q93.b) {
                    Log.d("SetPhoneContactAction", "handle params:" + optParamsAsJo);
                }
                String optString = optParamsAsJo.optString("action");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                b62 a = b62.a(optParamsAsJo);
                if (!a.t()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                this.c = optParamsAsJo.optString("cb");
                char c = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -1183792455) {
                    if (hashCode == 3108362 && optString.equals(StatKey.EDITADDR_TAG_STAGE_EDIT)) {
                        c = 1;
                    }
                } else if (optString.equals("insert")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                        return false;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    j(context, a, callbackHandler);
                    return true;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                insert(context, a, callbackHandler);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final ArrayList<ContentValues> k(b62 b62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b62Var)) == null) {
            ArrayList<ContentValues> arrayList = new ArrayList<>(16);
            arrayList.add(b62Var.j());
            arrayList.add(b62Var.h());
            arrayList.add(b62Var.s());
            arrayList.add(b62Var.i());
            arrayList.add(b62Var.g());
            arrayList.add(b62Var.r());
            arrayList.add(b62Var.k());
            arrayList.add(b62Var.o());
            arrayList.add(b62Var.n());
            arrayList.add(b62Var.m());
            arrayList.add(b62Var.l());
            arrayList.add(b62Var.b());
            arrayList.add(b62Var.p());
            arrayList.add(b62Var.e());
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void l(Context context, Intent intent, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, intent, callbackHandler) == null) {
            try {
                context.startActivity(intent);
                if (!TextUtils.isEmpty(this.c)) {
                    callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(0, DnsModel.MSG_OK).toString());
                }
            } catch (Exception e) {
                if (q93.b) {
                    Log.d("SetPhoneContactAction", "startContactActivity:" + e.toString());
                }
                if (!TextUtils.isEmpty(this.c)) {
                    callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
                }
            }
        }
    }
}
