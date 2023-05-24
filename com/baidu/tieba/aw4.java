package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aw4 implements kh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareItem a;
    public PermissionJudgePolicy b;

    @Override // com.baidu.tieba.kh6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        jh6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.kh6
    public /* synthetic */ void onDestroy() {
        jh6.b(this);
    }

    /* loaded from: classes4.dex */
    public class a extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ aw4 c;

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        public a(aw4 aw4Var, int i, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw4Var, Integer.valueOf(i), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aw4Var;
            this.a = i;
            this.b = context;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists()) {
                if (this.c.a != null) {
                    this.c.a.k0 = 1;
                    this.c.a.B = str;
                }
                int i = this.a;
                if (i != 0) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b, i, this.c.a, true));
                }
            }
        }
    }

    public aw4() {
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

    public final void e(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareItem) == null) {
            this.a = shareItem;
        }
    }

    @Override // com.baidu.tieba.kh6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if ("share".equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(f(webView, jSONObject.optInt("channel"), jSONObject.optInt("shareimg"), jSONObject.optString("img"), jSONObject.optString("isShowMoreForum"), jSONObject.optString("url"), jSONObject.optString("title"), jSONObject.optString("desc"), jSONObject.optString("topic"), jSONObject.optString("wbtitle"), jSONObject.optString("wbcontent"), jSONObject.optInt("weixin_disable"), jSONObject.optString("extdata"), jSONObject.optInt("source"), jSONObject.optString("topicid"), jSONObject.optString("disableSafari"), jSONObject.optLong("roomId"), jSONObject.optInt("filterRooms"), jSONObject.optInt("roomMemberCount"), jSONObject.optLong("fid"), jSONObject.optString("forumName"), jSONObject.optString("onlyThirdShare"), jSONObject.optString("addObserverNotify"), jSONObject.optString("panelTitle"), jSONObject.optJSONObject("shareIMCard")).a());
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    BdLog.e(e);
                    return false;
                }
            } else if (CommonTbJsBridge.SET_SHARE_INFO.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(d(webView, jSONObject2.optString("title"), jSONObject2.optString("desc"), jSONObject2.optString("img"), jSONObject2.optString("url"), jSONObject2.optString("topic"), jSONObject2.optString("wbtitle"), jSONObject2.optString("wbcontent"), jSONObject2.optString("isShowMoreForum"), jSONObject2.optInt("shareimg"), jSONObject2.optString("extdata")).a());
                    return true;
                } catch (JSONException e2) {
                    BdLog.e(e2);
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public ks9 d(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i), str9})) == null) {
            ks9 ks9Var = new ks9();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", str);
                jSONObject.put("desc", str2);
                jSONObject.put("img", str3);
                jSONObject.put("url", str4);
                jSONObject.put("topic", str5);
                jSONObject.put("wbtitle", str6);
                jSONObject.put("wbcontent", str7);
                jSONObject.put("isShowMoreForum", str8);
                jSONObject.put("shareimg", i);
                jSONObject.put("extdata", str9);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            String jSONObject2 = jSONObject.toString();
            if (!qi.isEmpty(jSONObject2)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016566, jSONObject2));
                i2 = 1;
            } else {
                i2 = 0;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("resultCode", i2);
                ks9Var.o(jSONObject3.toString());
                return ks9Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return ks9Var;
            }
        }
        return (ks9) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v10, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public ks9 f(WebView webView, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, int i4, String str10, String str11, long j, int i5, int i6, long j2, String str12, String str13, String str14, String str15, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        int i7;
        CustomResponsedMessage runTask;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{webView, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i3), str9, Integer.valueOf(i4), str10, str11, Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2), str12, str13, str14, str15, jSONObject})) == null) {
            ks9 ks9Var = new ks9();
            Activity a2 = zg6.a(webView.getContext());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("channel", i);
                jSONObject2.put("shareimg", i2);
                jSONObject2.put("img", str);
                jSONObject2.put("isShowMoreForum", str2);
                jSONObject2.put("url", str3);
                jSONObject2.put("title", str4);
                jSONObject2.put("desc", str5);
                jSONObject2.put("topic", str6);
                jSONObject2.put("wbtitle", str7);
                jSONObject2.put("wbcontent", str8);
                jSONObject2.put("weixin_disable", i3);
                jSONObject2.put("extdata", str9);
                jSONObject2.put("topicId", str10);
                jSONObject2.put("roomId", j);
                jSONObject2.put("filterRooms", i5);
                jSONObject2.put("roomMemberCount", i6);
                jSONObject2.put("fid", j2);
                jSONObject2.put("forumName", str12);
                jSONObject2.put("panelTitle", str15);
                jSONObject2.put("shareIMCard", jSONObject);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            String jSONObject3 = jSONObject2.toString();
            if (!qi.isEmpty(jSONObject3) && (runTask = MessageManager.getInstance().runTask(2016568, ShareItem.class, jSONObject3)) != null) {
                ShareItem shareItem = (ShareItem) runTask.getData();
                if (shareItem != null) {
                    shareItem.I = 17;
                    shareItem.g = true;
                    if (i4 == 1) {
                        shareItem.B0 = str10;
                    }
                    if (!TextUtils.isEmpty(str15)) {
                        shareItem.p(str15);
                    }
                }
                if (shareItem != null && shareItem.j()) {
                    i(a2, shareItem, i5);
                    ks9Var.o("");
                    return ks9Var;
                } else if (shareItem != null && shareItem.i()) {
                    i(a2, shareItem, i5);
                    ks9Var.o("");
                    return ks9Var;
                } else if (shareItem != null && shareItem.k()) {
                    i(a2, shareItem, i5);
                    ks9Var.o("");
                    return ks9Var;
                } else if ("1".equals(str2) && shareItem != null) {
                    shareItem.A = str;
                    shareItem.x = str3;
                    shareItem.v = str4 + " " + str5;
                    shareItem.q = true;
                    if (i4 == 1) {
                        shareItem.B0 = str10;
                    }
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) a2, shareItem, true, (SparseArray<String>) null);
                    shareDialogConfig.mShowMoreForumShare = true;
                    cn6.c().l(shareDialogConfig);
                    ks9Var.o("");
                    return ks9Var;
                } else if (i == 0) {
                    if (shareItem != null && !qi.isEmpty(str) && i2 == 1) {
                        e(shareItem);
                        g(a2, str, i);
                    }
                    j(a2, shareItem, "1".equals(str13));
                    i7 = 1;
                } else {
                    if (shareItem != null && !qi.isEmpty(str)) {
                        z = 1;
                        i7 = 1;
                        if (i2 == 1) {
                            e(shareItem);
                            g(a2, str, i);
                        }
                    } else {
                        z = 1;
                    }
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a2, i, shareItem, z));
                    i7 = z;
                }
            } else {
                i7 = 0;
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("resultCode", i7);
                ks9Var.o(jSONObject4.toString());
                return ks9Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return ks9Var;
            }
        }
        return (ks9) invokeCommon.objValue;
    }

    public final void g(Context context, String str, int i) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048581, this, context, str, i) != null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        if (this.b == null) {
            this.b = new PermissionJudgePolicy();
        }
        this.b.clearRequestPermissionList();
        this.b.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.b.startRequestPermission(currentActivity)) {
            return;
        }
        InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(currentActivity, str, new a(this, i, context));
        insertGalleryAsyncTask.setFrom(1);
        insertGalleryAsyncTask.execute(new String[0]);
    }

    public void j(Context context, ShareItem shareItem, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, shareItem, z) != null) || shareItem == null) {
            return;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(context, shareItem, true);
        shareDialogConfig.setIsSupportNightMode(true);
        if (!z) {
            if (shareItem.k0 != 0) {
                shareDialogConfig.hideMode |= 32;
            }
            shareDialogConfig.setIsCopyLink(true);
        }
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.x);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public ks9 h(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, hashMap)) == null) {
            ks9 ks9Var = new ks9();
            int intValue = ((Integer) hashMap.get("shareChannel")).intValue();
            int intValue2 = ((Integer) hashMap.get("shareStatus")).intValue();
            if (intValue2 != 3 && intValue2 != 2) {
                ShareItem shareItem = (ShareItem) hashMap.get("shareItem");
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("title", shareItem.v);
                    jSONObject2.put("desc", shareItem.w);
                    jSONObject2.put("img", shareItem.z);
                    jSONObject2.put("url", shareItem.x);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", intValue);
                    jSONObject3.put("shareData", jSONObject2);
                    jSONObject.put("resultCode", 1);
                    jSONObject.put("data", jSONObject3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(webView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, jSONObject);
                ks9Var.o(jSONObject.toString());
            } else {
                ks9Var.p();
            }
            return ks9Var;
        }
        return (ks9) invokeLL.objValue;
    }

    public void i(Context context, ShareItem shareItem, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048583, this, context, shareItem, i) != null) || shareItem == null) {
            return;
        }
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        shareItem.M0 = z;
        shareItem.o0 = true;
        cn6.c().l(new ShareDialogConfig(context, shareItem, true, (SparseArray<String>) null));
        if (shareItem.j()) {
            shareItem.R = 11;
            l58.b(shareItem.L0);
        }
    }
}
