package com.baidu.tieba.browser.core.webview.offline;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tieba.browser.core.webview.bridge.BridgeWebView;
import com.baidu.tieba.browser.core.webview.offline.data.OfflineBridgeData;
import com.baidu.tieba.g56;
import com.baidu.tieba.n66;
import com.baidu.tieba.o66;
import com.baidu.tieba.o76;
import com.baidu.tieba.q66;
import com.baidu.tieba.r66;
import com.baidu.tieba.ry4;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class OfflineWebView extends BridgeWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o66 t;
    public int u;
    public String v;
    public String w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 0;
        this.v = "none";
        this.w = "0.0.0.0";
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = 0;
        this.v = "none";
        this.w = "0.0.0.0";
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.u = 0;
        this.v = "none";
        this.w = "0.0.0.0";
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.t = new o66();
        }
    }

    @Override // com.baidu.tieba.browser.core.webview.base.BaseWebView, android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            o66 o66Var = this.t;
            if (o66Var != null) {
                o66Var.h();
                this.t = null;
            }
        }
    }

    @Override // com.baidu.tieba.browser.core.webview.bridge.BridgeWebView, com.baidu.tieba.browser.core.webview.base.BaseWebView
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
        }
    }

    @Override // com.baidu.tieba.browser.core.webview.bridge.BridgeWebView, com.baidu.tieba.browser.core.webview.base.BaseWebView
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.f();
        }
    }

    public final String l(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Iterator<String> it;
        String str4;
        Iterator<String> it2;
        String str5;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap hashMap = new HashMap();
            String str6 = null;
            try {
                URL url = new URL(str);
                r66 c = q66.a().c(url.getPath());
                try {
                    if (c == null) {
                        if (q66.a().b() != null) {
                            this.u = 3;
                        }
                        return null;
                    }
                    if (g56.e()) {
                        c.e = true;
                    }
                    int i = 2;
                    int i2 = 0;
                    try {
                        if (!c.e) {
                            this.u = 4;
                            ry4.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str, "hybridName", c.b, "hybridVersion", this.w, "hybridResult", "processing bundle");
                            return null;
                        }
                        try {
                            String i3 = n66.h().i(c.b);
                            if (!TextUtils.isEmpty(c.b) && !TextUtils.isEmpty(c.c) && !TextUtils.isEmpty(i3)) {
                                this.v = n66.p(true, c.b);
                                this.w = n66.p(false, i3);
                                String str7 = n66.h().g() + "/" + c.b + "/" + i3 + "/";
                                String str8 = c.c;
                                if (!c.c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                    str8 = c.c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                                }
                                String str9 = str7 + str8;
                                File file = new File(str9);
                                ArrayList<String> arrayList = c.d;
                                if (!str9.contains("/android_asset/")) {
                                    if (!file.exists()) {
                                        this.u = 2;
                                        ry4.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.v, "hybridVersion", this.w, "hybridResult", "path not found");
                                        return null;
                                    } else if (ListUtils.isEmpty(arrayList)) {
                                        return null;
                                    } else {
                                        for (String str10 : arrayList) {
                                            if (StringUtils.isNull(str10)) {
                                                ry4.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.v, "hybridVersion", this.w, "hybridResult", "static file path is null");
                                                this.u = 1;
                                                return null;
                                            } else if (!new File(str7, str10).exists()) {
                                                this.u = 1;
                                                ry4.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str10, "hybridName", this.v, "hybridVersion", this.w, "hybridResult", "bundle incomplete");
                                                return null;
                                            }
                                        }
                                    }
                                }
                                String query = url.getQuery();
                                str2 = "file://" + str7 + str8;
                                try {
                                    if (!TextUtils.isEmpty(query)) {
                                        str2 = str2 + "?" + query;
                                    }
                                    if (c.a != null && c.a.size() != 0) {
                                        String str11 = "&";
                                        if (!TextUtils.isEmpty(query) && (split = query.split("&")) != null) {
                                            int length = split.length;
                                            int i4 = 0;
                                            while (i4 < length) {
                                                String[] split2 = split[i4].split("=");
                                                if (split2 != null && split2.length == i) {
                                                    hashMap.put("{" + split2[0] + "}", split2[1]);
                                                }
                                                i4++;
                                                i = 2;
                                            }
                                        }
                                        hashMap.put("{client_version}", TbConfig.getVersion());
                                        hashMap.put("{client_type}", "2");
                                        if (TbSingleton.getInstance().getSyncYYSwitch()) {
                                            str3 = "1";
                                        } else {
                                            str3 = "0";
                                        }
                                        hashMap.put("{is_yy_user}", str3);
                                        Iterator<String> it3 = c.a.iterator();
                                        while (it3.hasNext()) {
                                            String next = it3.next();
                                            StringBuilder sb = new StringBuilder();
                                            String query2 = new URL(next).getQuery();
                                            if (!TextUtils.isEmpty(query2)) {
                                                String[] split3 = query2.split(str11);
                                                if (split3 != null) {
                                                    int length2 = split3.length;
                                                    boolean z = true;
                                                    while (i2 < length2) {
                                                        String str12 = split3[i2];
                                                        if (!z) {
                                                            sb.append(str11);
                                                        } else {
                                                            z = false;
                                                        }
                                                        String[] split4 = str12.split("=");
                                                        if (split4 != null) {
                                                            it2 = it3;
                                                            str5 = str11;
                                                            if (split4.length == 2) {
                                                                String str13 = (String) hashMap.get(split4[1]);
                                                                if (str13 == null) {
                                                                    str13 = split4[1];
                                                                    if (str13.contains("{") && str13.contains("}")) {
                                                                        str13 = null;
                                                                    }
                                                                }
                                                                sb.append(split4[0]);
                                                                sb.append("=");
                                                                if (!TextUtils.isEmpty(str13)) {
                                                                    sb.append(str13);
                                                                }
                                                                i2++;
                                                                it3 = it2;
                                                                str11 = str5;
                                                            }
                                                        } else {
                                                            it2 = it3;
                                                            str5 = str11;
                                                        }
                                                        i2++;
                                                        it3 = it2;
                                                        str11 = str5;
                                                    }
                                                }
                                                it = it3;
                                                str4 = str11;
                                                String sb2 = sb.toString();
                                                if (!TextUtils.isEmpty(sb2)) {
                                                    next = next.replace(query2, sb2);
                                                }
                                            } else {
                                                it = it3;
                                                str4 = str11;
                                            }
                                            OfflineBridgeData offlineBridgeData = new OfflineBridgeData();
                                            offlineBridgeData.type = "get";
                                            offlineBridgeData.url = next;
                                            offlineBridgeData.module = c.b;
                                            offlineBridgeData.begin = System.currentTimeMillis();
                                            if (this.t != null) {
                                                this.t.j(this, offlineBridgeData, null);
                                            }
                                            it3 = it;
                                            str11 = str4;
                                            i2 = 0;
                                        }
                                        return str2;
                                    }
                                    return str2;
                                } catch (MalformedURLException unused) {
                                    str6 = str2;
                                    return str6;
                                }
                            }
                            return null;
                        } catch (MalformedURLException unused2) {
                            str2 = null;
                        }
                    } catch (MalformedURLException unused3) {
                        str6 = null;
                    }
                } catch (MalformedURLException unused4) {
                }
            } catch (MalformedURLException unused5) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016d  */
    @Override // com.baidu.tieba.browser.core.webview.base.BaseWebView, android.webkit.WebView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        String str2;
        boolean z;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String str5 = str;
            if (StringUtils.isNull(str)) {
                return;
            }
            if (TbSingleton.getInstance().isDebugToolMode() && TbDebugSingleton.getInstance().getUrlSwitchMap() != null) {
                HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().a;
                String str6 = null;
                for (String str7 : hashMap.keySet()) {
                    if (!TextUtils.isEmpty(str7) && str5.contains(str7)) {
                        str6 = str7;
                    }
                }
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(hashMap.get(str6))) {
                    String str8 = hashMap.get(str6);
                    Uri parse = Uri.parse(str);
                    if (!TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getHost())) {
                        str4 = parse.getScheme() + ": // " + parse.getHost();
                    } else {
                        str4 = "";
                    }
                    if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str4)) {
                        str5 = str5.replace(str4, str8);
                    }
                }
            }
            if (!str5.contains("javascript:")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                String str9 = "?";
                if (str5.contains("?")) {
                    str9 = "&";
                }
                sb.append(str9);
                sb.append("_webview_time=");
                sb.append(System.currentTimeMillis());
                str5 = sb.toString();
                ry4.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str5);
                if (str5.length() > 100) {
                    str2 = str5.substring(0, 100);
                } else {
                    str2 = str5;
                }
                if (!n66.l(str5)) {
                    String l = l(str5);
                    if (!TextUtils.isEmpty(l)) {
                        ry4.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", l, "hybridName", this.v, "hybridVersion", this.w, "hybridResult", "success");
                        str5 = l;
                        z = true;
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL);
                        if (!z) {
                            str3 = "1";
                        } else {
                            str3 = "2";
                        }
                        TiebaStatic.log(statisticItem.param("obj_locate", str3).param("obj_source", str2).param("obj_type", this.u).param("obj_name", n66.g).param("obj_param1", this.v).param("obj_id", this.w));
                        this.u = 0;
                        this.v = "none";
                        this.w = "0.0.0.0";
                        ry4.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", str2, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    }
                } else {
                    this.u = 5;
                }
                z = false;
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL);
                if (!z) {
                }
                TiebaStatic.log(statisticItem2.param("obj_locate", str3).param("obj_source", str2).param("obj_type", this.u).param("obj_name", n66.g).param("obj_param1", this.v).param("obj_id", this.w));
                this.u = 0;
                this.v = "none";
                this.w = "0.0.0.0";
                ry4.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", str2, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            }
            o76.b("lt-log", "offline-end:" + str5);
            super.loadUrl(str5);
        }
    }
}
