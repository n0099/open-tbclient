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
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.im.data.ShareFloatCardData;
import com.baidu.tieba.pb.data.PbPostShareData;
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
/* loaded from: classes5.dex */
public class at4 implements qj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareItem a;
    public PermissionJudgePolicy b;

    @Override // com.baidu.tieba.qj6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        pj6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.qj6
    public /* synthetic */ void onDestroy() {
        pj6.b(this);
    }

    /* loaded from: classes5.dex */
    public class a extends InsertGalleryAsyncTask.InsertGalleryListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ at4 c;

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        public a(at4 at4Var, int i, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at4Var, Integer.valueOf(i), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = at4Var;
            this.a = i;
            this.b = context;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists()) {
                if (this.c.a != null) {
                    this.c.a.shareType = 1;
                    this.c.a.localFile = str;
                }
                int i = this.a;
                if (i != 0) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b, i, this.c.a, true));
                }
            }
        }
    }

    public at4() {
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

    @Override // com.baidu.tieba.qj6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if ("share".equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(f(webView, jSONObject.optInt("channel"), jSONObject.optInt("shareimg"), jSONObject.optString("img"), jSONObject.optString("isShowMoreForum"), jSONObject.optString("url"), jSONObject.optString("title"), jSONObject.optString("desc"), jSONObject.optString("topic"), jSONObject.optString("wbtitle"), jSONObject.optString("wbcontent"), jSONObject.optInt("weixin_disable"), jSONObject.optString("extdata"), jSONObject.optInt("source"), jSONObject.optString("topicid"), jSONObject.optString("disableSafari"), jSONObject.optLong("roomId"), jSONObject.optInt("filterRooms"), jSONObject.optInt("roomMemberCount"), jSONObject.optLong("fid"), jSONObject.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), jSONObject.optString("onlyThirdShare"), jSONObject.optString("addObserverNotify"), jSONObject.optString("panelTitle"), jSONObject.optJSONObject("shareIMCard"), jSONObject.optJSONObject("floatShareCard")).a());
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

    public gxa d(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i), str9})) == null) {
            gxa gxaVar = new gxa();
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
            if (!rd.isEmpty(jSONObject2)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016566, jSONObject2));
                i2 = 1;
            } else {
                i2 = 0;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("resultCode", i2);
                gxaVar.o(jSONObject3.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeCommon.objValue;
    }

    public gxa f(WebView webView, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, int i4, String str10, String str11, long j, int i5, int i6, long j2, String str12, String str13, String str14, String str15, JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeCommon;
        gxa gxaVar;
        int i7;
        CustomResponsedMessage runTask;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{webView, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i3), str9, Integer.valueOf(i4), str10, str11, Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2), str12, str13, str14, str15, jSONObject, jSONObject2})) == null) {
            gxa gxaVar2 = new gxa();
            Activity a2 = fj6.a(webView.getContext());
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("channel", i);
                jSONObject3.put("shareimg", i2);
                jSONObject3.put("img", str);
                jSONObject3.put("isShowMoreForum", str2);
                jSONObject3.put("url", str3);
                jSONObject3.put("title", str4);
                jSONObject3.put("desc", str5);
                jSONObject3.put("topic", str6);
                jSONObject3.put("wbtitle", str7);
                jSONObject3.put("wbcontent", str8);
                jSONObject3.put("weixin_disable", i3);
                jSONObject3.put("extdata", str9);
                jSONObject3.put("topicId", str10);
                jSONObject3.put("roomId", j);
                jSONObject3.put("filterRooms", i5);
                jSONObject3.put("roomMemberCount", i6);
                jSONObject3.put("fid", j2);
                jSONObject3.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, str12);
                jSONObject3.put("panelTitle", str15);
                jSONObject3.put("shareIMCard", jSONObject);
                jSONObject3.put("floatShareCard", jSONObject2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            String jSONObject4 = jSONObject3.toString();
            if (!rd.isEmpty(jSONObject4) && (runTask = MessageManager.getInstance().runTask(2016568, ShareItem.class, jSONObject4)) != null) {
                ShareItem shareItem = (ShareItem) runTask.getData();
                if (shareItem != null) {
                    shareItem.objSource = 17;
                    shareItem.isFromWebActivity = true;
                    if (i4 == 1) {
                        shareItem.topicId = str10;
                    }
                    if (!TextUtils.isEmpty(str15)) {
                        shareItem.setSharePanelTitle(str15);
                    }
                }
                if (shareItem != null && jSONObject2 != null) {
                    j(a2, shareItem, ((ShareFloatCardData) DataExt.toEntity(jSONObject2.toString(), ShareFloatCardData.class)).buildShareFloatCardData(), "1".equals(str13));
                    gxaVar2.o("");
                    return gxaVar2;
                }
                gxaVar = gxaVar2;
                if (shareItem != null && shareItem.isShareGroup()) {
                    i(a2, shareItem, i5);
                    gxaVar.o("");
                    return gxaVar;
                } else if (shareItem != null && shareItem.isShareAlbum()) {
                    i(a2, shareItem, i5);
                    gxaVar.o("");
                    return gxaVar;
                } else if (shareItem != null && shareItem.isShareTopic()) {
                    i(a2, shareItem, i5);
                    gxaVar.o("");
                    return gxaVar;
                } else if (shareItem != null && shareItem.isShareActive()) {
                    shareItem.setShowMoreForumIcon("1".equals(str2));
                    i(a2, shareItem, i5);
                    gxaVar.o("");
                    return gxaVar;
                } else if ("1".equals(str2) && shareItem != null) {
                    shareItem.imageUrl = str;
                    shareItem.linkUrl = str3;
                    shareItem.title = str4 + " " + str5;
                    shareItem.setShowMoreForumIcon(true);
                    if (i4 == 1) {
                        shareItem.topicId = str10;
                    }
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) a2, shareItem, true, (SparseArray<String>) null);
                    shareDialogConfig.mShowMoreForumShare = true;
                    TransmitShareController.getInstance().showShareDialog(shareDialogConfig);
                    gxaVar.o("");
                    return gxaVar;
                } else {
                    if (i == 0) {
                        if (shareItem != null && !rd.isEmpty(str) && i2 == 1) {
                            e(shareItem);
                            g(a2, str, i);
                        }
                        k(a2, shareItem, "1".equals(str13));
                    } else {
                        if (shareItem != null && !rd.isEmpty(str)) {
                            z = true;
                            if (i2 == 1) {
                                e(shareItem);
                                g(a2, str, i);
                            }
                        } else {
                            z = true;
                        }
                        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a2, i, shareItem, z));
                    }
                    i7 = 1;
                }
            } else {
                gxaVar = gxaVar2;
                i7 = 0;
            }
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("resultCode", i7);
                gxaVar.o(jSONObject5.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeCommon.objValue;
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

    public void k(Context context, ShareItem shareItem, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048585, this, context, shareItem, z) != null) || shareItem == null) {
            return;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(context, shareItem, true);
        shareDialogConfig.setIsSupportNightMode(true);
        if (!z) {
            if (shareItem.shareType != 0) {
                shareDialogConfig.hideMode |= 32;
            }
            shareDialogConfig.setIsCopyLink(true);
        }
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.linkUrl);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public gxa h(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            int intValue = ((Integer) hashMap.get("shareChannel")).intValue();
            int intValue2 = ((Integer) hashMap.get("shareStatus")).intValue();
            if (intValue2 != 3 && intValue2 != 2) {
                ShareItem shareItem = (ShareItem) hashMap.get("shareItem");
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("title", shareItem.title);
                    jSONObject2.put("desc", shareItem.content);
                    jSONObject2.put("img", shareItem.imageUri);
                    jSONObject2.put("url", shareItem.linkUrl);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", intValue);
                    jSONObject3.put("shareData", jSONObject2);
                    jSONObject.put("resultCode", 1);
                    jSONObject.put("data", jSONObject3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(webView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, jSONObject);
                gxaVar.o(jSONObject.toString());
            } else {
                gxaVar.p();
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public void i(Context context, ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048583, this, context, shareItem, i) != null) || shareItem == null) {
            return;
        }
        if (i == 1) {
            shareItem.setFilterRooms(true);
            shareItem.setFilterPerson(false);
        } else if (i == 2) {
            shareItem.setFilterRooms(false);
            shareItem.setFilterPerson(true);
        }
        shareItem.isShowShareOuerItem = true;
        TransmitShareController.getInstance().showShareDialog(new ShareDialogConfig(context, shareItem, true, (SparseArray<String>) null));
        if (shareItem.isShareGroup()) {
            shareItem.obj_type = 11;
            oz8.b(shareItem.groupData);
        }
    }

    public void j(Context context, ShareItem shareItem, PbPostShareData pbPostShareData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, shareItem, pbPostShareData, Boolean.valueOf(z)}) != null) || shareItem == null) {
            return;
        }
        PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(context, shareItem, 1, true, pbPostShareData);
        pbPostShareDialogConfig.setIsSupportNightMode(true);
        if (!z) {
            if (shareItem.shareType != 0) {
                pbPostShareDialogConfig.hideMode |= 32;
            }
            pbPostShareDialogConfig.setIsCopyLink(true);
        }
        pbPostShareDialogConfig.setIsSupportNightMode(true);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.linkUrl);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
    }
}
