package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g2a {
    public static /* synthetic */ Interceptable $ic;
    public static g2a f;
    public static final String g;
    public static int h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public Map<String, String> c;
    public CustomMessageListener d;
    public NetMessageListener e;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g2a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g2a g2aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g2aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g2aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.a.a) {
                return;
            }
            this.a.a = true;
            if (QuickWebViewSwitch.getInOn()) {
                if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                    e eVar = new e(this.a);
                    eVar.setPriority(4);
                    eVar.execute(new Void[0]);
                    return;
                }
                c cVar = new c(this.a, null);
                cVar.setPriority(4);
                cVar.execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g2a g2aVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g2aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
            com.baidu.tbadk.browser.BrowserHelper.setAdCookie(r0.get(r2));
         */
        @Override // com.baidu.adp.framework.listener.NetMessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                try {
                    List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                    if (header != null && header.size() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= header.size()) {
                                break;
                            }
                            if (!TextUtils.isEmpty(header.get(i)) && header.get(i).contains("BAIDUID=")) {
                                break;
                            }
                            i++;
                        }
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                Map<String, k2a> moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                if (moduleInfos != null && moduleInfos.size() > 0) {
                    for (String str : moduleInfos.keySet()) {
                        g2a.l(str, moduleInfos.get(str));
                    }
                    return;
                }
                h2a.a().g(true);
            } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                Map<String, k2a> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                    for (String str2 : moduleInfos2.keySet()) {
                        g2a.l(str2, moduleInfos2.get(str2));
                    }
                    return;
                }
                h2a.a().g(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ g2a b;

        public c(g2a g2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g2aVar;
            this.a = null;
        }

        public /* synthetic */ c(g2a g2aVar, a aVar) {
            this(g2aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            d A;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                String modName = TbSingleton.getInstance().getModName();
                if (TextUtils.isEmpty(modName) || (A = this.b.A(modName)) == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.a = netWork;
                netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.a.addPostData("mod_name", modName);
                NetWork netWork2 = this.a;
                if (A.a) {
                    str = "1";
                } else {
                    str = "2";
                }
                netWork2.addPostData("status", str);
                NetWork netWork3 = this.a;
                if (A.a) {
                    str2 = "";
                } else {
                    str2 = A.b;
                }
                netWork3.addPostData("fail_reason", str2);
                this.a.postNetData();
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                e eVar = new e(this.b);
                eVar.setPriority(4);
                eVar.execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;

        public d() {
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
    }

    /* loaded from: classes6.dex */
    public class e extends BdAsyncTask<Void, Void, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g2a a;

        public e(g2a g2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g2aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                if (fVar == null) {
                    Logger.addLog("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
                } else {
                    h2a.a().i(fVar.b);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public f doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            HashMap<String, i2a> hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                f fVar = new f();
                for (String str : g2a.n().q()) {
                    String p = g2a.n().p(str);
                    g o = g2a.o(str, p);
                    if (o != null && !TextUtils.isEmpty(o.a) && (hashMap = o.b) != null && hashMap.size() != 0) {
                        if (fVar.a == null) {
                            fVar.a = new HashMap();
                        }
                        fVar.a.put(str, o);
                        if (fVar.b == null) {
                            fVar.b = new HashMap<>();
                        }
                        fVar.b.putAll(o.b);
                        g2a.j(o.c, str);
                    } else {
                        g2a.h = 5;
                        Logger.addLog("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", str, "hybridVersion", p, "hybridResult", "bundle incomplete");
                        this.a.i(str);
                    }
                }
                return fVar;
            }
            return (f) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, g> a;
        public HashMap<String, i2a> b;

        public f() {
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
    }

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public HashMap<String, i2a> b;
        public String c;

        public g() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947743411, "Lcom/baidu/tieba/g2a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947743411, "Lcom/baidu/tieba/g2a;");
                return;
            }
        }
        g = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
        h = 0;
    }

    public g2a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.d = new a(this, 2001371);
        this.e = new b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
    }

    public void h(String str) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !TextUtils.isEmpty(str) && (map = this.c) != null) {
            map.remove(str);
        }
    }

    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.c != null && !TextUtils.isEmpty(str)) {
                return this.c.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static String y(boolean z, @Nullable String str) {
        InterceptResult invokeZL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65551, null, z, str)) == null) {
            if (z) {
                str2 = "none";
            } else {
                str2 = "0.0.0.0";
            }
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            return str;
        }
        return (String) invokeZL.objValue;
    }

    public void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.c == null) {
            this.c = new ConcurrentHashMap();
        }
        this.c.put(str, str2);
    }

    public static void j(String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65544, null, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = g + "bdtbNWCache/" + str2;
        File file = new File(str3);
        if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
            for (String str4 : list) {
                if (!StringUtils.isNull(str4) && !str4.equals(str)) {
                    FileHelper.deleteFileOrDir(new File(str3 + "/" + str4));
                }
            }
        }
    }

    public static void l(String str, k2a k2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, k2aVar) == null) {
            if (k2aVar != null && !StringUtils.isNull(k2aVar.c()) && !StringUtils.isNull(k2aVar.b()) && !StringUtils.isNull(k2aVar.a())) {
                String p = n().p(str);
                String c2 = k2aVar.c();
                String a2 = k2aVar.a();
                boolean d2 = k2aVar.d();
                if (StringUtils.isNull(p)) {
                    p = "0.0.0.0";
                }
                if (d2 && c2.equals(p)) {
                    h2a.a().h(true, str);
                    return;
                } else {
                    Logger.addLog("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", a2, "hybridVersion", c2, "lastVersion", p, "type", "start", "hybridName", str, "hybridResult", "success");
                    return;
                }
            }
            h2a.a().h(true, str);
        }
    }

    public static g o(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            File file = new File(g + "bdtbNWCache");
            FileInputStream fileInputStream2 = null;
            if (!file.exists() || TextUtils.isEmpty(str2)) {
                return null;
            }
            g gVar = new g();
            File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
            gVar.a = file.getAbsolutePath();
            gVar.c = str2;
            File file3 = new File(file2, "router.json");
            try {
                if (!file3.exists()) {
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(file3);
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
                try {
                    gVar.b = w(fileInputStream);
                    fi.e(fileInputStream);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    fi.e(fileInputStream2);
                    return gVar;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    fi.e(fileInputStream2);
                    throw th;
                }
                return gVar;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (g) invokeLL.objValue;
        }
    }

    public static g2a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f == null) {
                synchronized (g2a.class) {
                    if (f == null) {
                        f = new g2a();
                    }
                }
            }
            return f;
        }
        return (g2a) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<String, String> map = this.c;
            if (map != null && !map.isEmpty()) {
                return new JSONObject(this.c).toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.c == null) {
                this.c = new ConcurrentHashMap();
            }
            this.c.clear();
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public Set<String> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c == null) {
                this.c = new ConcurrentHashMap();
            }
            return this.c.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String B = B();
            if (!TextUtils.isEmpty(B)) {
                SharedPrefHelper.getInstance().putString("pref_key_quick_webview_versions", B);
            }
        }
    }

    public static boolean s(String str) {
        InterceptResult invokeL;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str)) {
                try {
                    queryParameter = Uri.parse(str).getQueryParameter("useOfflinePackage");
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return TextUtils.equals("0", queryParameter);
            }
            queryParameter = null;
            return TextUtils.equals("0", queryParameter);
        }
        return invokeL.booleanValue;
    }

    public static void u(JSONObject jSONObject, HashMap<String, i2a> hashMap) {
        String str;
        String str2;
        String str3;
        boolean z;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, jSONObject, hashMap) == null) {
            JSONObject jSONObject2 = jSONObject;
            String str4 = "source";
            String str5 = "path";
            if (jSONObject2 != null && hashMap != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!hashMap.containsKey(next)) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                            ArrayList<String> arrayList = new ArrayList<>();
                            if (jSONObject3.has("data_urls") && (optJSONArray2 = jSONObject3.optJSONArray("data_urls")) != null) {
                                for (int i = 0; i < optJSONArray2.length(); i++) {
                                    arrayList.add(optJSONArray2.optString(i));
                                }
                            }
                            if (!jSONObject3.has("module")) {
                                str = "";
                            } else {
                                str = jSONObject3.optString("module");
                            }
                            if (!jSONObject3.has(str5)) {
                                str2 = "";
                            } else {
                                str2 = jSONObject3.optString(str5);
                            }
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            if (jSONObject3.has(str4) && (optJSONArray = jSONObject3.optJSONArray(str4)) != null) {
                                str3 = str4;
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    arrayList2.add(optJSONArray.optString(i2));
                                }
                            } else {
                                str3 = str4;
                            }
                            String optString = jSONObject3.optString("staticPrePath", "");
                            int optInt = jSONObject3.optInt("proxyMode");
                            h2a.a().j(next, next);
                            h2a.a().k(next, str2);
                            Iterator<String> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                String next2 = it.next();
                                if (!TextUtils.isEmpty(next2)) {
                                    h2a a2 = h2a.a();
                                    String str6 = str5;
                                    a2.j(optString + "/" + next2, next);
                                    h2a a3 = h2a.a();
                                    a3.k(optString + "/" + next2, next2);
                                    str5 = str6;
                                }
                            }
                            String str7 = str5;
                            i2a i2aVar = new i2a();
                            i2aVar.a = arrayList;
                            i2aVar.b = str;
                            i2aVar.c = str2;
                            i2aVar.d = arrayList2;
                            if (optInt == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            i2aVar.f = z;
                            hashMap.put(next, i2aVar);
                            jSONObject2 = jSONObject;
                            str4 = str3;
                            str5 = str7;
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x004d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x004f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0051 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x0005 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v15, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v16, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v17, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v21, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    public static HashMap<String, i2a> w(InputStream inputStream) {
        InterceptResult invokeL;
        InputStreamReader inputStreamReader;
        Throwable th;
        Object obj;
        HashMap<String, i2a> hashMap;
        Object obj2;
        Object obj3;
        Reader reader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, inputStream)) == null) {
            InputStreamReader inputStreamReader2 = null;
            try {
                if (inputStream == 0) {
                    return null;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        inputStream = new BufferedReader(inputStreamReader);
                        try {
                            try {
                                for (String readLine = inputStream.readLine(); readLine != null; readLine = inputStream.readLine()) {
                                    stringBuffer.append(readLine);
                                }
                                inputStream.close();
                                hashMap = new HashMap<>();
                                try {
                                    JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                                    u(jSONObject.optJSONObject("proxyConfig"), hashMap);
                                    u(jSONObject.optJSONObject("config"), hashMap);
                                    fi.g(inputStreamReader);
                                    reader = inputStream;
                                } catch (IOException e2) {
                                    e = e2;
                                    inputStreamReader2 = inputStreamReader;
                                    obj3 = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj3;
                                    fi.g(inputStreamReader2);
                                    reader = inputStream;
                                    fi.g(reader);
                                    return hashMap;
                                } catch (JSONException e3) {
                                    e = e3;
                                    inputStreamReader2 = inputStreamReader;
                                    obj2 = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj2;
                                    fi.g(inputStreamReader2);
                                    reader = inputStream;
                                    fi.g(reader);
                                    return hashMap;
                                } catch (Exception e4) {
                                    e = e4;
                                    inputStreamReader2 = inputStreamReader;
                                    obj = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj;
                                    fi.g(inputStreamReader2);
                                    reader = inputStream;
                                    fi.g(reader);
                                    return hashMap;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fi.g(inputStreamReader);
                                fi.g(inputStream);
                                throw th;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            hashMap = null;
                        } catch (JSONException e6) {
                            e = e6;
                            hashMap = null;
                        } catch (Exception e7) {
                            e = e7;
                            hashMap = null;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        inputStream = 0;
                        hashMap = null;
                    } catch (JSONException e9) {
                        e = e9;
                        inputStream = 0;
                        hashMap = null;
                    } catch (Exception e10) {
                        e = e10;
                        inputStream = 0;
                        hashMap = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = 0;
                    }
                } catch (IOException e11) {
                    e = e11;
                    obj3 = null;
                    hashMap = null;
                } catch (JSONException e12) {
                    e = e12;
                    obj2 = null;
                    hashMap = null;
                } catch (Exception e13) {
                    e = e13;
                    obj = null;
                    hashMap = null;
                } catch (Throwable th4) {
                    inputStreamReader = null;
                    th = th4;
                    inputStream = 0;
                }
                fi.g(reader);
                return hashMap;
            } catch (Throwable th5) {
                inputStreamReader = inputStreamReader2;
                th = th5;
            }
        } else {
            return (HashMap) invokeL.objValue;
        }
    }

    public final d A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            d dVar = new d();
            if (TextUtils.isEmpty(str)) {
                dVar.b = "module not exit";
                return dVar;
            }
            File file = new File(g + "bdtbNWCache", str);
            String p = n().p(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                dVar.a = false;
                if (!file.exists()) {
                    dVar.b = "bundle not exist";
                    return dVar;
                } else if (TextUtils.isEmpty(p)) {
                    dVar.b = "the local has no valid version name";
                    return dVar;
                } else {
                    String str2 = file.getAbsolutePath() + "/" + p + "/";
                    if (!new File(str2).exists()) {
                        dVar.b = "bundle not exist";
                        return dVar;
                    }
                    String str3 = file.getAbsolutePath() + "/" + p + ".zip";
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        FileHelper.deleteFileOrDir(file2);
                    }
                    if (t85.e(str2, str3)) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        netWork.addPostData("offline_pack_version", p);
                        netWork.addPostData("mod_name", str);
                        netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                        netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                        t(netWork.uploadFile("offline_pack_file_stream", str3), dVar);
                        if (!dVar.a) {
                            return dVar;
                        }
                    } else {
                        dVar.b = "zip bundle error";
                        return dVar;
                    }
                }
            } else {
                dVar.a = true;
            }
            if (TbSingleton.getInstance().isClearOffPack()) {
                i(str);
                if (!TextUtils.isEmpty(p)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", p));
                }
                if (file.exists() && !StringUtils.isNull(p)) {
                    if (!new File(file.getAbsolutePath(), p).exists()) {
                        return dVar;
                    }
                    dVar.b = "delete fail";
                    dVar.a = false;
                }
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public void g() {
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k();
            SharedPrefHelper.getInstance().putString("pref_key_quick_webview_versions", "");
            String str = g + "bdtbNWCache";
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                for (String str2 : list) {
                    if (!StringUtils.isNull(str2)) {
                        FileHelper.deleteFileOrDir(new File(str + "/" + str2));
                    }
                }
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        h(str);
        SharedPrefHelper.getInstance().putString("pref_key_quick_webview_versions", B());
        File file = new File(g + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (keys == null) {
                return;
            }
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    if (this.c == null) {
                        this.c = new ConcurrentHashMap();
                    }
                    this.c.put(next, optString);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().registerListener(this.e);
            MessageManager.getInstance().registerListener(this.d);
            this.b = new File(g + "bdtbNWCache").getAbsolutePath();
            v(SharedPrefHelper.getInstance().getString("pref_key_quick_webview_versions", ""));
        }
    }

    public final d t(String str, d dVar) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, dVar)) == null) {
            if (StringUtils.isNull(str)) {
                dVar.b = "serve return is null";
                return dVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("error_code") == 0) {
                    z = true;
                } else {
                    z = false;
                }
                dVar.a = z;
                dVar.b = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (JSONException e2) {
                dVar.b = "parse json exception";
                BdLog.e(e2);
            }
            return dVar;
        }
        return (d) invokeLL.objValue;
    }
}
