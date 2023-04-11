package com.baidu.tieba.browser;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.livesdk.api.share.Share;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.TBWebViewActivity;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.data.ResponeDelAllUserDataHttpResMsg;
import com.baidu.tbadk.core.account.data.ResponseDelAllUserDataSocketMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.RedirectInterceptionSwitch;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TBWebContainerActivity;
import com.baidu.tieba.cj5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e05;
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.it4;
import com.baidu.tieba.jg;
import com.baidu.tieba.ke6;
import com.baidu.tieba.lf6;
import com.baidu.tieba.nu4;
import com.baidu.tieba.ot4;
import com.baidu.tieba.q25;
import com.baidu.tieba.qf6;
import com.baidu.tieba.rf6;
import com.baidu.tieba.ru4;
import com.baidu.tieba.s99;
import com.baidu.tieba.se6;
import com.baidu.tieba.sq5;
import com.baidu.tieba.tb6;
import com.baidu.tieba.u35;
import com.baidu.tieba.ub6;
import com.baidu.tieba.ur5;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.yv4;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TBWebContainerActivity extends BaseWebViewActivity {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> K;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public final CustomMessageListener B;
    public final za C;
    public final CustomMessageListener D;
    public cj5 E;
    public cj5 F;
    public final Runnable G;
    public boolean H;
    public CustomMessageListener I;
    public final CustomMessageListener J;
    public TbWebView a;
    public ValueCallback<Uri> b;
    public ValueCallback<Uri[]> c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public String j;
    public ShareItem k;
    public PermissionJudgePolicy l;
    public n m;
    public s99 n;
    public boolean o;
    public WebViewBroadcastReceiver p;
    public boolean q;
    public ShareItem r;
    public boolean s;
    public final Stack<String> t;
    public boolean u;
    public int v;
    public int w;
    public boolean x;
    public String y;
    public final ItemCardHelper.c z;

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean needDelayLoadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class n implements e05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ TBWebContainerActivity b;

        /* loaded from: classes3.dex */
        public class a extends InsertGalleryAsyncTask.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
            public void a(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                }
            }

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    ii.P(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
                }
            }
        }

        public n(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tBWebContainerActivity;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        @Override // com.baidu.tieba.e05.c
        public void a(e05 e05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, e05Var, i, view2) == null) && e05Var == this.b.getListMenu()) {
                if (i == 0) {
                    if (this.b.l == null) {
                        this.b.l = new PermissionJudgePolicy();
                    }
                    this.b.l.clearRequestPermissionList();
                    this.b.l.appendRequestPermission(this.b, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.b.l.startRequestPermission(this.b)) {
                        return;
                    }
                    new InsertGalleryAsyncTask(this.b.getActivity(), this.a, new a(this)).execute(new String[0]);
                }
                e05Var.e();
            }
        }

        public String[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.b.getPageContext().getString(R.string.save_to_local));
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public a(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mView.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.a.mUrl.contains(str) || str.contains(this.a.mUrl)) {
                    this.a.hideProgressBar();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            this.a.d = (String) customResponsedMessage.getData();
            this.a.showRightShareIcon();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ TBWebContainerActivity b;

        public d(TBWebContainerActivity tBWebContainerActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tBWebContainerActivity;
            this.a = shareItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.mView.S(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public e(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ShareItem> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject(customMessage.getData());
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        String optString5 = jSONObject.optString("topic");
                        String optString6 = jSONObject.optString("wbtitle");
                        String optString7 = jSONObject.optString("wbcontent");
                        this.a.k = this.a.createShareContent(optString, optString4, optString2, optString3);
                        this.a.k.T = optString5;
                        this.a.k.U = optString6;
                        this.a.k.V = optString7;
                        this.a.k.k0 = jSONObject.optInt("shareimg");
                        this.a.k.s0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    this.a.k.X = jSONObject3.toString();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        this.a.k.L0 = GroupInfoData.fromJsonH5(jSONObject);
                        return new CustomResponsedMessage<>(2016568, this.a.k);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public f(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.orderGameApkResult(String.valueOf(j), 0, null);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.orderGameApkResult(String.valueOf(j), 1, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.e = (String) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.a.r(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(TBWebContainerActivity tBWebContainerActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = tBWebContainerActivity;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (!(responsedMessage instanceof ResponeDelAllUserDataHttpResMsg) && !(responsedMessage instanceof ResponseDelAllUserDataSocketMessage)) {
                    return;
                }
                yv4.c().e(responsedMessage.hasError(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                se6.a().a(this.a.a.get(), "writePostSuccess", new HashMap<>());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends cj5<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity c;

        public k(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi5
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (!tipEvent.isCloseCurrentPage) {
                    DefaultNavigationBarCoverTip.t(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).v();
                    return true;
                } else if (tipEvent.pageId > 0 && this.c.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.t(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).v();
                    return true;
                } else {
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l extends cj5<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity c;

        public l(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                this.c.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent(), topToastEvent.getToastDelay());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public m(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.mView != null) {
                this.a.mView.S(this.a.r);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends qf6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public final /* synthetic */ TBWebContainerActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(TBWebContainerActivity tBWebContainerActivity) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((WebViewClient) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tBWebContainerActivity;
        }

        public /* synthetic */ void b() {
            this.c.mView.v();
        }

        @Override // com.baidu.tieba.qf6, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.b = false;
                this.c.mUrl = str;
                String title = webView.getTitle();
                if (!this.c.mFixTitle && !StringUtils.isNull(title)) {
                    this.c.mUrlTitle = title;
                }
                if (!this.c.H) {
                    this.c.mView.G(this.c.mUrlTitle);
                }
                if (this.c.isTranslucent()) {
                    this.c.mView.D(false);
                } else {
                    this.c.mView.D(this.c.mIsShowNavBar);
                }
                this.c.mView.J(this.c.isNeedShowShareItem());
                if (!StringUtils.isNull(this.c.mUrl) && this.c.mUrl.contains(TBWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                    this.c.mView.E(8);
                }
                this.c.hideProgressBar();
                this.c.stopLoadTimer();
                if (this.c.mView != null) {
                    this.c.mView.o(this.c.mUrl);
                }
                if (this.c.u) {
                    this.c.t.add(str);
                }
            }
        }

        @Override // com.baidu.tieba.qf6, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
                Log.e("lt-log", "shouldOverrideUrlLoading:" + str);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (RedirectInterceptionSwitch.isOn() && this.b && Build.VERSION.SDK_INT >= 26 && (UtilHelper.isOppoDevice() || UtilHelper.isVivoDevice())) {
                    if (!URLUtil.isNetworkUrl(str)) {
                        if (str.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                            return true;
                        } else if (!TextUtils.isEmpty(UrlManager.getInstance().getSchemaKeyByUrl(str))) {
                            this.c.tryDeeplink(str);
                            return true;
                        }
                    }
                    return false;
                }
                int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.c.getPageContext(), new String[]{str, this.c.mUrl});
                if (dealOneLinkWithOutJumpWebView == 1) {
                    this.c.finish();
                    return true;
                } else if (dealOneLinkWithOutJumpWebView == 0) {
                    return true;
                } else {
                    if (dealOneLinkWithOutJumpWebView == 2) {
                        return false;
                    }
                    this.c.mUrl = str;
                    if (this.c.H) {
                        this.c.H = false;
                        ke6.a().c(new Runnable() { // from class: com.baidu.tieba.pb6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    TBWebContainerActivity.o.this.b();
                                }
                            }
                        });
                    }
                    this.c.hideCrashTip();
                    if (URLUtil.isNetworkUrl(str)) {
                        if (!this.c.q) {
                            this.c.showProgressBar();
                        }
                        if (this.c.H && this.c.mView != null) {
                            this.c.mView.x();
                        }
                        return false;
                    }
                    TBWebContainerActivity tBWebContainerActivity = this.c;
                    tBWebContainerActivity.tryDeeplink(tBWebContainerActivity.mUrl);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.qf6, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.b = true;
                this.c.mUrl = str;
                if (!this.c.q) {
                    this.c.showProgressBar();
                }
                this.c.startLoadTimer();
            }
        }

        @Override // com.baidu.tieba.qf6, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    this.b = false;
                    webView.stopLoading();
                    this.c.stopLoadTimer();
                    this.c.onReceivedError(i);
                }
            }
        }

        @Override // com.baidu.tieba.qf6, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT >= 23 && webResourceRequest.isForMainFrame()) {
                    this.b = false;
                    webView.stopLoading();
                    this.c.stopLoadTimer();
                    this.c.onReceivedError(webResourceError.getErrorCode());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-454306116, "Lcom/baidu/tieba/browser/TBWebContainerActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-454306116, "Lcom/baidu/tieba/browser/TBWebContainerActivity;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        K = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        K.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        K.put(Share.QQDENGLU, "qq_zone");
        K.put(Share.SINAWEIBO, "sina_weibo");
        K.put(Share.QQWEIBO, "qq_weibo");
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                this.a = new TbWebView(getPageContext().getPageActivity());
                this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.a.setWebViewClient(new o(this));
                this.a.l(this.createdTime);
                this.a.o(new ub6() { // from class: com.baidu.tieba.qb6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ub6
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            TBWebContainerActivity.this.x2((WebView) obj);
                        }
                    }
                });
            }
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            sendFinishMessage();
            super.onDestroy();
            s99 s99Var = this.n;
            if (s99Var != null) {
                s99Var.h();
                this.n = null;
            }
            if (this.G != null) {
                jg.a().removeCallbacks(this.G);
            }
            nu4.a();
            WebViewBroadcastReceiver webViewBroadcastReceiver = this.p;
            if (webViewBroadcastReceiver != null) {
                webViewBroadcastReceiver.unregister();
            }
            ru4.e().g();
            TbWebView tbWebView = this.a;
            if (tbWebView != null) {
                tbWebView.s();
                this.a = null;
            }
            unRegisterResponsedEventListener();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onResume();
            TbWebView tbWebView = this.a;
            if (tbWebView == null) {
                return;
            }
            tbWebView.w();
            registerGetShareContentTask();
            ItemCardHelper.w(this.z);
            se6.a().a(this.a.get(), CommonTbJsBridge.RE_SHOW, null);
            if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.f) {
                se6.a().a(this.a.get(), CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
            }
            this.f = false;
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void showShare() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && !StringUtils.isNull(this.d)) {
            try {
                JSONObject jSONObject = new JSONObject(this.d);
                ShareItem createShareContent = createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"));
                this.r.L0 = GroupInfoData.fromJsonH5(jSONObject);
                jg.a().post(new d(this, createShareContent));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            TbWebView tbWebView = this.a;
            if (tbWebView == null) {
                return false;
            }
            if (this.u) {
                if (this.t.isEmpty() || this.t.size() == 1) {
                    return false;
                }
                this.t.pop();
                this.a.r(this.t.pop());
                return true;
            }
            rf6 controller = tbWebView.getController();
            if (!controller.a()) {
                return false;
            }
            controller.b();
            return true;
        }
        return invokeV.booleanValue;
    }

    public TBWebContainerActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f = true;
        this.h = "normal";
        this.i = "normal";
        this.o = false;
        this.s = false;
        this.t = new Stack<>();
        this.v = 0;
        this.w = 0;
        this.y = "";
        this.z = new f(this);
        this.A = new g(this, 2016566);
        this.B = new h(this, 2921434);
        this.C = new i(this, CmdConfigHttp.CMD_HTTP_ONEKEY_DELETION_HISTORY, 309736);
        this.D = new j(this, 2921786);
        this.E = new k(this);
        this.F = new l(this);
        this.G = new m(this);
        this.H = false;
        this.I = new b(this, 2921023);
        this.J = new c(this, 2921331);
    }

    public final void choosePrivateIm(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) != null) || intent == null) {
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PersonalChatActivityConfig.KEY_SELECT_MSG_LIST_FINISH);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("private_msg", parcelableArrayListExtra);
        se6.a().a(this.a.get(), "goToSelectPrivateMsgPage", hashMap);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void loadUrl(String str) {
        TbWebView tbWebView;
        ot4 ot4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (this.H && (ot4Var = this.mView) != null) {
                ot4Var.x();
            }
            if (!StringUtils.isNull(str) && (tbWebView = this.a) != null) {
                tbWebView.r(str);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, intent) == null) {
            super.onNewIntent(intent);
            sendDetailBroadcast("onStart");
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            handleError();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("isLogin", Boolean.valueOf(z));
            se6.a().a(this.a.get(), CommonTbJsBridge.LOGIN_RESULT_TO_H5, linkedHashMap);
            setRefreshPage(false);
        }
    }

    public final void sendCompleteTask(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, str) == null) && !hi.isEmpty(str)) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
            completeTaskReqMsg.completeId = str;
            sendMessage(completeTaskReqMsg);
        }
    }

    public final void sendDetailBroadcast(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, str) != null) || !"live".equals(this.j)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("DetailLifecycle", str);
        intent.setAction("com.baidu.tieba.live.action.detail_broadcast");
        sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setNeedViewShowLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.setNeedViewShowLoading(z);
        }
    }

    public void setRefreshPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.isNeedRefresh = z;
        }
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, valueCallback) == null) {
            this.b = valueCallback;
        }
    }

    public void setUploadMessageAboveL(ValueCallback<Uri[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, valueCallback) == null) {
            this.c = valueCallback;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    public /* synthetic */ boolean y2(WebView webView, View view2) {
        if (!TextUtils.isEmpty(this.mUrl) && this.mUrl.contains("haokan.baidu.com/activity/")) {
            return false;
        }
        return w2(webView);
    }

    public void z2(@NonNull View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, view2, str) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.USER_SKIN_OVERLAY)) {
                q25.d(view2).f(R.color.CAM_X0503);
            } else {
                view2.setBackgroundColor(0);
            }
        }
    }

    public final void chooseImageFromAlbum(Intent intent) {
        String stringExtra;
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) != null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(stringExtra);
        writeImagesInfo.updateQuality();
        LinkedList linkedList = new LinkedList();
        if (writeImagesInfo.getChosedFiles() != null) {
            Iterator<ImageFileInfo> it = writeImagesInfo.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ImageUploadResult.picInfo picinfo = next.serverPicInfo;
                    if (picinfo != null && (picDetailedInfo = picinfo.originPic) != null) {
                        linkedHashMap.put("url", picDetailedInfo.picUrl);
                    }
                    linkedHashMap.put("identifier", next.getFilePath());
                    linkedList.add(linkedHashMap);
                }
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("array", linkedList);
        se6.a().a(this.a.get(), "selectPhotoAlbum", linkedHashMap2);
    }

    public void jumpToEditHeadActivity(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, intent) != null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
        writeImagesInfo.parseJson(stringExtra);
        writeImagesInfo.updateQuality();
        if (!ListUtils.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this, (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 4, writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, true);
            editHeadActivityConfig.setWaterMaskType(3);
            editHeadActivityConfig.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
            editHeadActivityConfig.setNeedPaste(false);
            editHeadActivityConfig.setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (isTranslucent()) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!isTranslucent() && !this.mIsFromSchema) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.finish();
            sendDetailBroadcast(MissionEvent.MESSAGE_STOP);
            TbWebView tbWebView = this.a;
            if (tbWebView != null) {
                lf6.c(tbWebView);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.tieba.ll5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.q) {
                return "a077";
            }
            if (!StringUtils.isNull(this.y)) {
                return this.y;
            }
            return super.getCurrentPageKey();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public String getShareInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public ValueCallback<Uri> getUploadMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (ValueCallback) invokeV.objValue;
    }

    public ValueCallback<Uri[]> getUploadMessageAboveL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c;
        }
        return (ValueCallback) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            it4.j(getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            createWebView();
            if (!TextUtils.isEmpty(this.mUrl)) {
                loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean needDealClickGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (!this.o) {
                return false;
            }
            se6.a().a(this.a.get(), CommonTbJsBridge.CLICK_GO_BACK_TO_H5, null);
            this.o = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || needDealClickGoBack()) {
            return;
        }
        super.onBackPressed();
    }

    public final void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new e(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.H = true;
            if (1 != 0 && this.mView != null) {
                runOnUiThread(new a(this));
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setSkinOverly() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (tbWebView = this.a) != null) {
            z2(tbWebView, this.mUrl);
        }
    }

    public final void showRightShareIcon() {
        ot4 ot4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (ot4Var = this.mView) != null) {
            ot4Var.F();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (tbWebView = this.a) != null) {
            tbWebView.get().getSettings().setBuiltInZoomControls(true);
        }
    }

    public void handleError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbWebView tbWebView = this.a;
            if (tbWebView != null) {
                this.mUrl = tbWebView.get().getUrl();
                this.a.getController().d();
            }
            hideProgressBar();
            if (isTranslucent()) {
                if (this.x) {
                    finish();
                    return;
                }
                TbWebView tbWebView2 = this.a;
                if (tbWebView2 != null) {
                    tbWebView2.setVisibility(8);
                    return;
                }
                return;
            }
            showNoDataView();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onPause();
            TbWebView tbWebView = this.a;
            if (tbWebView == null) {
                return;
            }
            tbWebView.t();
            MessageManager.getInstance().unRegisterTask(2016568);
            ItemCardHelper.w(null);
            se6.a().a(this.a.get(), CommonTbJsBridge.RE_HIDE, null);
        }
    }

    public final void handleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048590, this, intent, i2) != null) || !this.mShareResultToFe) {
            return;
        }
        boolean z = false;
        this.mShareResultToFe = false;
        if (intent == null) {
            return;
        }
        String str = K.get(intent.getStringExtra("share_to"));
        HashMap hashMap = new HashMap();
        if (i2 == -1) {
            z = true;
        }
        hashMap.put(MapBundleKey.MapObjKey.OBJ_BID, this.g);
        hashMap.put("result", Boolean.valueOf(z));
        hashMap.put("channel", str);
        u35.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
        if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1) {
            this.a.r("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public final void newHandleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048598, this, intent, i2) == null) && this.k != null && i2 == -1) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            String stringExtra = intent.getStringExtra("complete_id");
            if (intExtra == 1) {
                sendCompleteTask(stringExtra);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("shareChannel", Integer.valueOf(intExtra2));
                linkedHashMap.put("shareItem", this.k);
                se6.a().a(this.a.get(), CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap);
            }
            if (intExtra == 3) {
                if (intExtra2 == 8 || intExtra2 == 6) {
                    sendCompleteTask(stringExtra);
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("shareChannel", Integer.valueOf(intExtra2));
                    linkedHashMap2.put("shareItem", this.k);
                    se6.a().a(this.a.get(), CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap2);
                }
            }
        }
    }

    public final void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048591, this, intent, i2) != null) || i2 != -1 || intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = new JSONArray();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                Iterator<ImageFileInfo> it = writeImagesInfo.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("originalUrl", next.serverPicInfo.originPic.picUrl);
                    jSONObject.put("originalWidth", next.serverPicInfo.originPic.width);
                    jSONObject.put("originalHeight", next.serverPicInfo.originPic.height);
                    jSONObject.put("photoUrl", next.serverPicInfo.bigPic.picUrl);
                    jSONObject.put("photoWidth", next.serverPicInfo.bigPic.width);
                    jSONObject.put("photoHeight", next.serverPicInfo.bigPic.height);
                    jSONObject.put("photoThumbUrl", next.serverPicInfo.smallPic.picUrl);
                    jSONObject.put("filePath", next.getFilePath());
                    jSONArray.put(jSONObject);
                }
            }
            hashMap.put(TbConfig.LOCAL_PIC_DIR, jSONArray);
            u35.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        TbWebView tbWebView;
        Uri uri;
        Uri[] uriArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i2, i3, intent) == null) {
            if (i2 == 1) {
                if (i3 == -1) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (getUploadMessageAboveL() == null) {
                            return;
                        }
                        if (intent != null) {
                            String dataString = intent.getDataString();
                            ClipData clipData = intent.getClipData();
                            if (clipData != null) {
                                uriArr = new Uri[clipData.getItemCount()];
                                for (int i4 = 0; i4 < clipData.getItemCount(); i4++) {
                                    uriArr[i4] = clipData.getItemAt(i4).getUri();
                                }
                            } else {
                                uriArr = null;
                            }
                            if (dataString != null) {
                                uriArr = new Uri[]{Uri.parse(dataString)};
                            }
                        } else {
                            uriArr = null;
                        }
                        if (uriArr != null) {
                            getUploadMessageAboveL().onReceiveValue(uriArr);
                        }
                        setUploadMessageAboveL(null);
                    } else if (getUploadMessage() != null) {
                        if (intent != null && i3 == -1) {
                            uri = intent.getData();
                        } else {
                            uri = null;
                        }
                        getUploadMessage().onReceiveValue(uri);
                        setUploadMessage(null);
                    }
                }
            } else if (i2 != 11043) {
                if (i2 != 12002) {
                    if (i2 != 12009) {
                        if (i2 != 12015) {
                            if (i2 != 24007) {
                                if (i2 != 25042) {
                                    if (i2 != 25045) {
                                        if (i2 != 25070) {
                                            if (i2 != 220010) {
                                                if (i2 != 25073) {
                                                    if (i2 != 25074) {
                                                        switch (i2) {
                                                            case 12017:
                                                                chooseImageFromAlbum(intent);
                                                                return;
                                                            case 12018:
                                                                selectReportThemeTid(intent);
                                                                return;
                                                            case 12019:
                                                                choosePrivateIm(intent);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                    } else if (i3 == -1 && intent != null) {
                                                        HashMap<String, Object> hashMap = new HashMap<>();
                                                        hashMap.put("tailId", intent.getStringExtra("tailId"));
                                                        hashMap.put("tailColor", intent.getStringExtra("tailColor"));
                                                        hashMap.put("tailContent", intent.getStringExtra("tailContent"));
                                                        se6.a().a(this.a.get(), CommonTbJsBridge.REFRESH_TAIL, hashMap);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (i3 == -1) {
                                                    se6.a().a(this.a.get(), CommonTbJsBridge.OPEN_VIP_SUCCESS, null);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (-1 == i3 && (tbWebView = this.a) != null) {
                                                tbWebView.getController().c();
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                        se6.a().a(this.a.get(), CommonTbJsBridge.RE_SHOW, null);
                                        return;
                                    }
                                    TbWebView tbWebView2 = this.a;
                                    if (tbWebView2 != null) {
                                        tbWebView2.getController().c();
                                        return;
                                    }
                                    return;
                                } else if (-1 == i3) {
                                    finish();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            handleShareResult(intent, i3);
                            newHandleShareResult(intent, i3);
                            return;
                        }
                        handleUploadResult(intent, i3);
                        return;
                    } else if (intent != null) {
                        Serializable serializableExtra = intent.getSerializableExtra("pic_info");
                        if (serializableExtra instanceof PhotoUrlData) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("url", ((PhotoUrlData) serializableExtra).getOriginPic());
                            se6.a().a(this.a.get(), "GetPhotoAlbum", linkedHashMap);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                jumpToEditHeadActivity(intent);
            } else if (-1 == i3 && intent != null) {
                int intExtra = intent.getIntExtra("social_type", 0);
                String stringExtra = intent.getStringExtra("activity_id");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("social_type", Integer.valueOf(intExtra));
                linkedHashMap2.put("activityId", stringExtra);
                se6.a().a(this.a.get(), CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, linkedHashMap2);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.a != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                se6.a().a(this.a.get(), CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
                q25.d(this.a).f(R.color.CAM_X0503);
            }
        }
    }

    public final void selectReportThemeTid(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048613, this, intent) != null) || intent == null) {
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(ReportThemeActivityConfig.REPORT_TID_LIST);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (stringArrayListExtra != null) {
            linkedHashMap.put("tid", stringArrayListExtra);
        }
        se6.a().a(this.a.get(), "goToReportThreadPage", linkedHashMap);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            parserIntent();
            boolean equals = TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.i);
            boolean equals2 = TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.h);
            if (!equals && !equals2) {
                z = false;
            } else {
                z = true;
            }
            setIsTranslucent(z);
            if (isTranslucent()) {
                setNeedViewShowLoading(false);
                getWindow().setWindowAnimations(R.style.obfuscated_res_0x7f100146);
            }
            setIsAddSwipeBackLayout(!isTranslucent());
            super.onCreate(bundle);
            setSwipeBackEnabled(true);
            ot4 ot4Var = this.mView;
            if (ot4Var != null) {
                if (this.w == 1) {
                    ot4Var.H(true);
                }
                this.mView.B(this.v);
            }
            MessageManager.getInstance().runTask(2001308, (Class) null);
            if (this.mNeedCookie) {
                initCookie();
            }
            registerListener(this.I);
            registerListener(this.J);
            registerListener(this.A);
            this.B.setSelfListener(true);
            registerListener(this.B);
            registerListener(this.C);
            registerListener(this.D);
            sendDetailBroadcast("onStart");
            registerResponsedEventListener(TopToastEvent.class, this.F);
            registerResponsedEventListener(TipEvent.class, this.E);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onWebViewLogin(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            super.onWebViewLogin(z);
            if (this.a != null) {
                JSONObject jSONObject = new JSONObject();
                if (z) {
                    str = "1";
                } else {
                    str = "0";
                }
                try {
                    jSONObject.put("no", str);
                    loadUrl("javascript:tiebaClientLoginCallBack(" + jSONObject.toString() + SmallTailInfo.EMOTION_SUFFIX);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final boolean w2(View view2) {
        InterceptResult invokeL;
        WebView.HitTestResult hitTestResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, view2)) == null) {
            if (!(view2 instanceof WebView) || (hitTestResult = ((WebView) view2).getHitTestResult()) == null || hitTestResult.getType() != 5) {
                return false;
            }
            if (this.m == null) {
                this.m = new n(this);
            }
            this.m.c(hitTestResult.getExtra());
            createListMenu(this.m.b(), this.m, false);
            showListMenu();
            return true;
        }
        return invokeL.booleanValue;
    }

    public /* synthetic */ void x2(final WebView webView) {
        webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.ob6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? TBWebContainerActivity.this.y2(webView, view2) : invokeL.booleanValue;
            }
        });
        this.a.setOnScrollChangeListener(new tb6(this));
        WebSettings settings = webView.getSettings();
        if (isTranslucent()) {
            webView.setBackgroundColor(0);
        } else {
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            webView.setInitialScale(100);
            webView.setScrollBarStyle(33554432);
        }
        settings.setMediaPlaybackRequiresUserGesture(!this.isAutoPlayVideo);
        if (this.s) {
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
            settings.setLoadWithOverviewMode(true);
        }
        if (this.mEnableJs) {
            addJavascriptInterface();
        }
        CompatibleUtile.getInstance().removeJavascriptInterface(webView);
    }

    public void orderGameApkResult(@NonNull String str, int i2, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048610, this, str, i2, str2) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", str);
            hashMap.put("resultCode", Integer.valueOf(i2));
            hashMap.put("name", str2);
            se6.a().a(this.a.get(), "orderGameApkResult", hashMap);
        }
    }

    public final void parserIntent() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        this.i = intent.getStringExtra(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT);
        this.v = intent.getIntExtra(WebViewActivityConfig.TAG_LOADING_STYLE, 0);
        this.w = intent.getIntExtra(WebViewActivityConfig.TAG_SHOW_LOADING_SWITCH, 0);
        this.mDialogName = intent.getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME);
        intent.getBooleanExtra(WebViewActivityConfig.TAG_LOAD_BY_WEB_CLIENT, false);
        this.s = intent.getBooleanExtra(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, false);
        this.u = intent.getBooleanExtra(TbWebViewActivityConfig.KEY_USE_CUSTOM_HISTORY_STACK, false);
        this.x = intent.getBooleanExtra(WebViewActivityConfig.TAG_TRANSLUCENT_AUTO_CLOSE, false);
        String stringExtra = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.y = ur5.c(stringExtra, "page_key=");
        if (sq5.a(stringExtra).booleanValue()) {
            this.q = true;
            setNeedViewShowLoading(false);
            getPageStayDurationItem().D(sq5.c(stringExtra));
        }
        if (hi.isEquals(ur5.c(stringExtra, WebViewActivityConfig.PAGE_TYPE), WebViewActivityConfig.TAG_NEW_GOD_INVITE)) {
            setNeedViewShowLoading(false);
        }
        Uri parse = Uri.parse(stringExtra);
        if (parse == null) {
            return;
        }
        try {
            this.h = parse.getQueryParameter("page_type");
        } catch (Exception unused) {
        }
        try {
            boolean contains = stringExtra.contains("recClose=1");
            this.j = ur5.d(stringExtra, "page_from");
            if (contains) {
                WebViewBroadcastReceiver webViewBroadcastReceiver = new WebViewBroadcastReceiver();
                this.p = webViewBroadcastReceiver;
                webViewBroadcastReceiver.register(this);
            }
        } catch (Exception unused2) {
        }
        try {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                BdUniDispatchSchemeController.getInstance().parseWebViewScheme(uri);
            }
        } catch (Exception unused3) {
        }
    }

    public final void sendFinishMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (!TextUtils.isEmpty(this.mUrl) && this.mUrl.contains(UrlSchemaHelper.SIGN_FRS_DIALOG)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921738, null));
            }
            if (!TextUtils.isEmpty(this.mUrl) && this.mUrl.contains(UrlSchemaHelper.VIRTUAL_IMAGE_MAIN_URL)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
            }
            if (!TextUtils.isEmpty(this.mDialogName)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921753, this.mDialogName));
            }
        }
    }
}
