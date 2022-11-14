package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n00 a;
    public List<ez> b;

    /* loaded from: classes4.dex */
    public class a implements Comparator<ez> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(fz fzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fzVar};
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ez ezVar, ez ezVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ezVar, ezVar2)) == null) {
                int i = ezVar2.b - ezVar.b;
                if (i == 0) {
                    if (ezVar.d && ezVar2.d) {
                        return 0;
                    }
                    if (ezVar.d) {
                        return -1;
                    }
                    if (ezVar2.d) {
                        return 1;
                    }
                }
                return i;
            }
            return invokeLL.intValue;
        }
    }

    public fz() {
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
        c();
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr != null) {
                String str = "";
                for (byte b : bArr) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        sb = new StringBuilder();
                        sb.append(str);
                        str = "0";
                    } else {
                        sb = new StringBuilder();
                    }
                    sb.append(str);
                    sb.append(hexString);
                    str = sb.toString();
                }
                return str.toLowerCase();
            }
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        return (String) invokeL.objValue;
    }

    public static byte[] f(byte[] bArr, n00 n00Var) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, n00Var)) == null) {
            k00 a2 = k00.a();
            a2.b(2, n00Var);
            return a2.c(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public List<ez> b(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, context, intent, z)) == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null) {
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.applicationInfo != null) {
                        try {
                            Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                            if (bundle != null) {
                                String string = bundle.getString("galaxy_data");
                                if (!TextUtils.isEmpty(string)) {
                                    byte[] b = q00.b(string.getBytes(IMAudioTransRequest.CHARSET));
                                    JSONObject jSONObject = new JSONObject(new String(b));
                                    ez ezVar = new ez();
                                    ezVar.b = jSONObject.getInt("priority");
                                    ezVar.a = resolveInfo.activityInfo.applicationInfo;
                                    if (context.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                        ezVar.d = true;
                                    }
                                    if (z) {
                                        String string2 = bundle.getString("galaxy_sf");
                                        if (!TextUtils.isEmpty(string2)) {
                                            PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                            JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                            int length = jSONArray.length();
                                            String[] strArr = new String[length];
                                            for (int i = 0; i < length; i++) {
                                                strArr[i] = jSONArray.getString(i);
                                            }
                                            if (e(strArr, g(packageInfo.signatures))) {
                                                byte[] f = f(q00.b(string2.getBytes()), this.a);
                                                if (f != null && Arrays.equals(f, s00.a(b))) {
                                                    ezVar.c = true;
                                                }
                                            }
                                        }
                                    }
                                    arrayList.add(ezVar);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            Collections.sort(arrayList, new a(this));
            return arrayList;
        }
        return (List) invokeLLZ.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new o00(gz.a(), gz.b());
        }
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            List<ez> b = b(context, new Intent("com.baidu.intent.action.GALAXY").setPackage(context.getPackageName()), true);
            if (b == null || b.size() == 0) {
                for (int i = 0; i < 3; i++) {
                    Log.w("CuidBuddyInfoManager", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
                }
                return false;
            }
            boolean z = b.get(0).c;
            if (!z) {
                for (int i2 = 0; i2 < 3; i2++) {
                    Log.w("CuidBuddyInfoManager", "galaxy config err, In the release version of the signature should be matched");
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, strArr, strArr2)) == null) {
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                return false;
            }
            HashSet hashSet = new HashSet();
            for (String str : strArr) {
                hashSet.add(str);
            }
            HashSet hashSet2 = new HashSet();
            for (String str2 : strArr2) {
                hashSet2.add(str2);
            }
            return hashSet.equals(hashSet2);
        }
        return invokeLL.booleanValue;
    }

    public final String[] g(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, signatureArr)) == null) {
            int length = signatureArr.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = a(s00.a(signatureArr[i].toByteArray()));
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public List<ez> h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            List<ez> list = this.b;
            if (list != null) {
                return list;
            }
            d(context);
            List<ez> b = b(context, new Intent("com.baidu.intent.action.GALAXY"), true);
            this.b = b;
            return b;
        }
        return (List) invokeL.objValue;
    }
}
