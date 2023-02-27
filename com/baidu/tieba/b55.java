package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b55 {
    public static /* synthetic */ Interceptable $ic;
    public static b55 f;
    public static ContentResolver g;
    public static HashMap<String, String> h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public SharedPreferences b;
    public String c;
    public ConcurrentHashMap<String, Object> d;
    public String e;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ ContentValues b;
        public final /* synthetic */ b55 c;

        public a(b55 b55Var, Uri uri, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b55Var, uri, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b55Var;
            this.a = uri;
            this.b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.c.K(this.a, this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ b55 b;

        public b(b55 b55Var, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b55Var, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b55Var;
            this.a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.b.h(this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public b55() {
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
        this.e = null;
        this.d = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        h = hashMap;
        hashMap.put(a55.a, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS);
        h.put(a55.b, "remote_settings");
        h.put(a55.c, "bdservice_settings");
        h.put(a55.d, a55.g);
        h.put(a55.e, a55.h);
        h.put(a55.f, a55.i);
        g = TbadkCoreApplication.getInst().getContext().getContentResolver();
    }

    public synchronized SharedPreferences r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            synchronized (this) {
                if (!PermissionUtil.isBrowseMode() && PermissionUtil.isAgreePrivacyPolicy()) {
                    if (this.c == null || this.c.length() == 0) {
                        if (this.a == null || this.a.length() == 0) {
                            this.a = p();
                        }
                        if (h.containsKey(this.a)) {
                            this.c = h.get(this.a);
                        } else {
                            this.c = AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS;
                        }
                    }
                    return TbadkCoreApplication.getInst().getSharedPreferences(this.c, 0);
                }
                return TbadkCoreApplication.getInst().getSharedPreferences(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, 0);
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public final void F(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            J(parse, contentValues);
        }
    }

    public void J(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, uri, contentValues) == null) {
            if (ej.E()) {
                new a(this, uri, contentValues).execute(new Void[0]);
            } else {
                K(uri, contentValues);
            }
        }
    }

    public final void K(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, uri, contentValues) == null) {
            try {
                g.insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void M(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i) == null) {
            SharedPreferences r = r();
            this.b = r;
            SharedPreferences.Editor edit = r.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void N(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j) == null) {
            SharedPreferences r = r();
            this.b = r;
            SharedPreferences.Editor edit = r.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public final void x(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048609, this, str, obj) == null) && str != null && obj != null) {
            this.d.put(str, obj);
            f();
        }
    }

    public static synchronized b55 m() {
        InterceptResult invokeV;
        b55 b55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (b55.class) {
                if (f == null) {
                    f = new b55();
                }
                b55Var = f;
            }
            return b55Var;
        }
        return (b55) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SharedPreferences r = r();
            this.b = r;
            SharedPreferences.Editor edit = r.edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public ContentResolver k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return g;
        }
        return (ContentResolver) invokeV.objValue;
    }

    public static String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str + "_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeL.objValue;
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (c(str)) {
                I(str);
            } else if (this.d.containsKey(str)) {
                this.d.remove(str);
            } else {
                SharedPreferences r = r();
                this.b = r;
                EditorHelper.remove(r, str);
            }
        }
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            g(Uri.parse(j() + str));
        }
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = a55.k.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(a55.k[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, uri) == null) {
            if (ej.E()) {
                new b(this, uri).execute(new Void[0]);
            } else {
                h(uri);
            }
        }
    }

    public final void h(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, uri) == null) {
            try {
                g.delete(uri, null, null);
            } catch (SecurityException e) {
                BdLog.detailException(e);
            }
        }
    }

    public String t(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, uri)) == null) {
            try {
                return g.getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            return t(Uri.parse(j() + str));
        }
        return (String) invokeL.objValue;
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            if (c(str)) {
                return false;
            }
            if (!this.d.containsKey(str) && !r().contains(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void A(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            if (c(str)) {
                E(str, j);
            } else if (ej.E()) {
                x(str, Long.valueOf(j));
            } else {
                SharedPreferences r = r();
                this.b = r;
                SharedPreferences.Editor edit = r.edit();
                edit.putLong(str, j);
                edit.commit();
            }
        }
    }

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (c(str)) {
                F(str, str2);
            } else if (StringUtil.NULL_STRING.equals(str2)) {
                H(str);
            } else if (ej.E()) {
                x(str, str2);
            } else {
                SharedPreferences r = r();
                this.b = r;
                SharedPreferences.Editor edit = r.edit();
                edit.putString(str, str2);
                edit.commit();
            }
        }
    }

    public final void C(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, str, f2) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(f2));
            J(parse, contentValues);
        }
    }

    public final void D(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i));
            J(parse, contentValues);
        }
    }

    public final void E(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            J(parse, contentValues);
        }
    }

    public final void G(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            Uri parse = Uri.parse(j() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            J(parse, contentValues);
        }
    }

    public boolean i(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048596, this, str, z)) == null) {
            if (c(str)) {
                String u = u(str);
                if (u == null) {
                    return z;
                }
                try {
                    return Boolean.parseBoolean(u);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return z;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            SharedPreferences r = r();
            this.b = r;
            return r.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public float l(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048599, this, str, f2)) == null) {
            if (c(str)) {
                String u = u(str);
                if (u == null) {
                    return f2;
                }
                try {
                    return Float.parseFloat(u);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return f2;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            SharedPreferences r = r();
            this.b = r;
            return r.getFloat(str, f2);
        }
        return invokeLF.floatValue;
    }

    public int n(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, str, i)) == null) {
            if (c(str)) {
                String u = u(str);
                if (u == null) {
                    return i;
                }
                try {
                    return Integer.parseInt(u);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            SharedPreferences r = r();
            this.b = r;
            return r.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public String s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c(str)) {
                String u = u(str);
                if (u != null) {
                    return u;
                }
                return str2;
            }
            Object obj = this.d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            SharedPreferences r = r();
            this.b = r;
            return r.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, str, z) == null) {
            if (c(str)) {
                G(str, z);
            } else if (ej.E()) {
                x(str, Boolean.valueOf(z));
            } else {
                SharedPreferences r = r();
                this.b = r;
                SharedPreferences.Editor edit = r.edit();
                edit.putBoolean(str, z);
                edit.commit();
            }
        }
    }

    public void y(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048610, this, str, f2) == null) {
            if (c(str)) {
                C(str, f2);
            } else if (ej.E()) {
                x(str, Float.valueOf(f2));
            } else {
                SharedPreferences r = r();
                this.b = r;
                SharedPreferences.Editor edit = r.edit();
                edit.putFloat(str, f2);
                edit.commit();
            }
        }
    }

    public void z(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, str, i) == null) {
            if (c(str)) {
                D(str, i);
            } else if (ej.E()) {
                x(str, Integer.valueOf(i));
            } else {
                SharedPreferences r = r();
                this.b = r;
                SharedPreferences.Editor edit = r.edit();
                edit.putInt(str, i);
                edit.commit();
            }
        }
    }

    public void L() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.d.isEmpty()) {
            return;
        }
        SharedPreferences r = r();
        this.b = r;
        if (r == null || (edit = r.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        edit.commit();
        this.d.clear();
    }

    public void f() {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.d.isEmpty()) {
            return;
        }
        SharedPreferences r = r();
        this.b = r;
        if (r == null || (edit = r.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
        this.d.clear();
    }

    public void e(String str) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.b = r();
            if (!TextUtils.isEmpty(str) && (sharedPreferences = this.b) != null) {
                Set<String> keySet = sharedPreferences.getAll().keySet();
                SharedPreferences.Editor edit = this.b.edit();
                for (String str2 : keySet) {
                    if (str2.endsWith("_" + str)) {
                        edit.remove(str2);
                    }
                }
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
        }
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.e == null) {
                String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            String str = a55.a;
            ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity");
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                int myPid = Process.myPid();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return str;
                }
                return str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public long o(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048601, this, str, j)) == null) {
            if (c(str)) {
                String u = u(str);
                if (u == null) {
                    return j;
                }
                try {
                    return Long.parseLong(u);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            Object obj = this.d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            SharedPreferences r = r();
            this.b = r;
            try {
                return r.getLong(str, j);
            } catch (ClassCastException e2) {
                BdLog.e(e2);
                return j;
            }
        }
        return invokeLJ.longValue;
    }
}
