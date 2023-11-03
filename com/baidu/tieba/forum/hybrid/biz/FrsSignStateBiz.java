package com.baidu.tieba.forum.hybrid.biz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewSupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.messageCenter.SignManager;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.ci8;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.di8;
import com.baidu.tieba.eh7;
import com.baidu.tieba.forum.hybrid.manager.BizBase;
import com.baidu.tieba.forum.hybrid.manager.WrapListener;
import com.baidu.tieba.gba;
import com.baidu.tieba.homepagecore.data.ForumSignInResultRespondedMessage;
import com.baidu.tieba.lq6;
import com.baidu.tieba.mq6;
import com.baidu.tieba.oq6;
import com.baidu.tieba.pq6;
import com.baidu.tieba.sh7;
import com.baidu.tieba.si7;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ui7;
import com.baidu.tieba.yw4;
import com.baidu.tieba.z95;
import com.baidu.tieba.zo4;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.SignInfo;
import tbclient.SignActivityInfo;
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010.\u001a\u00020/2\u0006\u0010.\u001a\u00020\u0011J\u0006\u00100\u001a\u00020\u0011J\b\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020\u0011H\u0002J\u0006\u00103\u001a\u00020\u001aJ\b\u00104\u001a\u00020\u0011H\u0002J\u0013\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0016¢\u0006\u0002\u00108J\b\u00109\u001a\u00020/H\u0016J\b\u0010:\u001a\u00020/H\u0016J\u0013\u0010;\u001a\b\u0012\u0004\u0012\u00020<06H\u0016¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020/H\u0002J\u0010\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\u000fH\u0002J\u0010\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020\rH\u0002J\u0012\u0010C\u001a\u00020/2\b\u0010@\u001a\u0004\u0018\u00010DH\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010@\u001a\u00020\rH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/baidu/tieba/forum/hybrid/biz/FrsSignStateBiz;", "Lcom/baidu/tieba/forum/hybrid/manager/BizBase;", "Lcom/baidu/tieba/forum/hybrid/manager/Clean;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "getRootView", "Lkotlin/Function0;", "Landroid/view/ViewGroup;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lkotlin/jvm/functions/Function0;)V", "currentSignData", "Lcom/baidu/tbadk/core/data/SignData;", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "", "hasClickGuideToChatRoom", "", "isProcess", "isShowSign", "isSignShowAdded", "mActivityLink", "mCurScore", "", "mHasShowFollowDialog", "", "Ljava/util/Date;", "getMHasShowFollowDialog", "()Ljava/util/Map;", "setMHasShowFollowDialog", "(Ljava/util/Map;)V", "mInjectListener", "Lcom/baidu/tieba/tbadkCore/util/AntiHelper$AntiDialogInjectClickListener;", "mIsLevelUp", "mLevelRatio", "", "mLevelUpScore", "mSignActivityInfo", "Ltbclient/SignActivityInfo;", "mSignLinkUrl", "mSignTaskListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mSignTimeCheckerListener", "mSignedStateListener", "signStatusListener", "Lcom/baidu/adp/framework/listener/HttpMessageListener;", "canSign", "", "checkForumSign", "getGroupChatSignSchema", "getHaveLike", "isShowFollowDialog", "isWalletSign", "keyListeners", "", "Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "()[Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "onDataUpdate", MissionEvent.MESSAGE_DESTROY, "requestCodeHandlers", "Lcom/baidu/tieba/forum/hybrid/manager/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/forum/hybrid/manager/ActivityRequestCodeHandler;", "startSign", "startSignForum", "data", "updateLevel", "signData", "updateSignByResign", "Landroid/content/Intent;", "updateSignData", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsSignStateBiz extends BizBase implements ui7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public String g;
    public SignActivityInfo h;
    public final String i;
    public Map<String, Date> j;
    public boolean k;
    public SignData l;
    public boolean m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public final CustomMessageListener r;
    public final CustomMessageListener s;
    public final AntiHelper.k t;
    public final CustomMessageListener u;
    public final HttpMessageListener v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1164321384, "Lcom/baidu/tieba/forum/hybrid/biz/FrsSignStateBiz;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1164321384, "Lcom/baidu/tieba/forum/hybrid/biz/FrsSignStateBiz;");
        }
    }

    @Override // com.baidu.tieba.ui7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends pq6<di8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSignStateBiz b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsSignStateBiz frsSignStateBiz, Class<di8> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSignStateBiz, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsSignStateBiz;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pq6
        public void onEvent(di8 event) {
            ForumInfo e;
            Long l;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                eh7 c = this.b.c();
                if (c != null && (e = c.e()) != null && (l = e.id) != null) {
                    long longValue = l.longValue();
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
                    httpMessage.addParam("scene_from", "frs");
                    httpMessage.addParam("forum_ids", longValue);
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(zz4 dlg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dlg) == null) {
                Intrinsics.checkNotNullParameter(dlg, "dlg");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 dlg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dlg) == null) {
                Intrinsics.checkNotNullParameter(dlg, "dlg");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSignStateBiz a;
        public final /* synthetic */ TbPageContext<BaseFragmentActivity> b;
        public final /* synthetic */ Function0<ViewGroup> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsSignStateBiz frsSignStateBiz, TbPageContext<BaseFragmentActivity> tbPageContext, Function0<? extends ViewGroup> function0) {
            super(2001425);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSignStateBiz, tbPageContext, function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSignStateBiz;
            this.b = tbPageContext;
            this.c = function0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:73:0x023d  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x025d  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumInfo forumInfo;
            boolean z;
            SignData signData;
            boolean z2;
            ForumInfo e;
            Long l;
            int i;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof SignMessage)) {
                return;
            }
            eh7 c = this.a.c();
            if (c != null) {
                forumInfo = c.e();
            } else {
                forumInfo = null;
            }
            if (forumInfo == null) {
                return;
            }
            eh7 c2 = this.a.c();
            Intrinsics.checkNotNull(c2);
            ForumInfo e2 = c2.e();
            Intrinsics.checkNotNull(e2);
            if (Intrinsics.areEqual(e2.name, this.a.f) && Intrinsics.areEqual(customResponsedMessage.getOrginalMessage().getTag(), this.b.getUniqueId())) {
                TiebaStatic.eventStat(this.b.getPageActivity(), "sign_end_time", String.valueOf(System.currentTimeMillis()));
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                    if (signMessage.signData != null) {
                        AntiHelper.t(this.b.getPageActivity(), signMessage.signData.blockPopInfoData, this.a.t);
                    } else {
                        AntiHelper.u(this.b.getPageActivity(), signMessage.mSignErrorString);
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
                    return;
                }
                String str2 = e2.name;
                SignData signData2 = signMessage.signData;
                boolean z3 = false;
                if (signData2 != null) {
                    String str3 = signData2.forumId;
                    if (str3 != null) {
                        Long l2 = e2.id;
                        if (l2 != null) {
                            str = String.valueOf(l2);
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str3, str)) {
                            signData2.forumId = String.valueOf(e2.id);
                            signData2.forumName = e2.name;
                            this.a.K(signData2);
                            z = true;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    signData2 = null;
                    z = false;
                }
                if (z && signData2 != null) {
                    Integer currentLevel = e2.user_level;
                    if (this.a.m) {
                        Integer nowLevel = e2.user_level;
                        Intrinsics.checkNotNullExpressionValue(currentLevel, "currentLevel");
                        int intValue = currentLevel.intValue();
                        Intrinsics.checkNotNullExpressionValue(nowLevel, "nowLevel");
                        if (intValue < nowLevel.intValue()) {
                            currentLevel = nowLevel;
                        } else {
                            currentLevel = Integer.valueOf(nowLevel.intValue() + 1);
                        }
                    }
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    int i2 = signData2.sign_bonus_point;
                    Intrinsics.checkNotNullExpressionValue(currentLevel, "currentLevel");
                    inst.addSignedForum(str2, i2, currentLevel.intValue());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData2));
                    try {
                        i = new JSONObject(signData2.userInfoJson).getInt("activity_status");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if (i == 1 || i == 2) {
                        z2 = true;
                        if (!z2 && this.a.q) {
                            SignActivityInfo signActivityInfo = this.a.h;
                            if (signActivityInfo != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(signData2.userInfoJson);
                                    Long l3 = signActivityInfo.activity_id;
                                    Intrinsics.checkNotNullExpressionValue(l3, "it.activity_id");
                                    jSONObject.put("activity_id", l3.longValue());
                                    jSONObject.put("activity_suc_msg", signActivityInfo.activity_suc_msg);
                                    jSONObject.put("activity_fail_msg", signActivityInfo.activity_fail_msg);
                                    Integer num = signActivityInfo.gift_type;
                                    Intrinsics.checkNotNullExpressionValue(num, "it.gift_type");
                                    jSONObject.put("gift_type", num.intValue());
                                    jSONObject.put("gift_url", signActivityInfo.gift_url);
                                    jSONObject.put("gift_name", signActivityInfo.gift_name);
                                    jSONObject.put("icon_name", signActivityInfo.icon_name);
                                    Integer num2 = signActivityInfo.icon_lifecycle;
                                    Intrinsics.checkNotNullExpressionValue(num2, "it.icon_lifecycle");
                                    jSONObject.put("icon_lifecycle", num2.intValue());
                                    jSONObject.put("activity_name", signActivityInfo.activity_name);
                                    jSONObject.put(EditHeadActivityConfig.IMAGE_URL, signActivityInfo.image_url);
                                    SignManager.getInstance().setSignInfo(jSONObject.toString());
                                } catch (Exception unused) {
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE, "1");
                            BrowserHelper.startWebActivity(this.b.getPageActivity(), "", this.a.i, false, true, true, bundle);
                            zo4.f().j().b();
                            return;
                        } else if (!this.a.F() && signData2.contDays > 0) {
                            SignManager.getInstance().setSignInfo(signData2.userInfoJson);
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE, "1");
                            BrowserHelper.startWebActivity(this.b.getPageActivity(), "", this.a.g, false, true, true, bundle2);
                            zo4.f().j().b();
                            return;
                        } else {
                            SignManager.getInstance().setSignInfo(null);
                            if (!this.a.C()) {
                                FrsSignStateBiz frsSignStateBiz = this.a;
                                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0887, new Object[]{Integer.valueOf(signData2.user_sign_rank)});
                                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.st…ss, sdata.user_sign_rank)");
                                frsSignStateBiz.l(string);
                            } else {
                                FrsSignStateBiz frsSignStateBiz2 = this.a;
                                String string2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0886, new Object[]{Integer.valueOf(signData2.sign_bonus_point), Integer.valueOf(signData2.user_sign_rank)});
                                Intrinsics.checkNotNullExpressionValue(string2, "getInst()\n              …nt, sdata.user_sign_rank)");
                                frsSignStateBiz2.l(string2);
                            }
                            ViewGroup invoke = this.c.invoke();
                            Date E = this.a.E();
                            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.b.getPageActivity()).areNotificationsEnabled();
                            if (z95.e().G() && areNotificationsEnabled) {
                                z3 = true;
                            }
                            if (z3 && this.a.k && this.a.A()) {
                                gba.d.a().h("forum_sign");
                                SignManager.getInstance().checkAndShowTimePicker(1, this.b, invoke, true);
                                eh7 c3 = this.a.c();
                                if (c3 != null && (e = c3.e()) != null && (l = e.id) != null) {
                                    this.a.D().put(String.valueOf(l.longValue()), E);
                                }
                                TbSingleton.getInstance().setHasShowTip(this.a.D());
                                return;
                            }
                            return;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                    if (!this.a.F()) {
                    }
                    SignManager.getInstance().setSignInfo(null);
                    if (!this.a.C()) {
                    }
                    ViewGroup invoke2 = this.c.invoke();
                    Date E2 = this.a.E();
                    boolean areNotificationsEnabled2 = NotificationManagerCompat.from(this.b.getPageActivity()).areNotificationsEnabled();
                    if (z95.e().G()) {
                        z3 = true;
                    }
                    if (z3) {
                        return;
                    }
                    return;
                }
                if (signMessage.mSignErrorCode == 160002 && (signData = this.a.l) != null) {
                    signData.is_signed = 1;
                }
                FrsSignStateBiz frsSignStateBiz3 = this.a;
                String str4 = signMessage.mSignErrorString;
                Intrinsics.checkNotNullExpressionValue(str4, "responsedMessage.mSignErrorString");
                frsSignStateBiz3.l(str4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSignStateBiz a;
        public final /* synthetic */ Function0<ViewGroup> b;
        public final /* synthetic */ TbPageContext<BaseFragmentActivity> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsSignStateBiz frsSignStateBiz, Function0<? extends ViewGroup> function0, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(2921738);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSignStateBiz, function0, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSignStateBiz;
            this.b = function0;
            this.c = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            ForumInfo e;
            Long l;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                Date E = this.a.E();
                ViewGroup invoke = this.b.invoke();
                if (invoke != null && this.a.k && PushOpenUtil.shouldShowPushOpenView(TbadkCoreApplication.getInst(), 4)) {
                    SignManager.getInstance().checkAndShowTimePicker(1, this.c, invoke, false);
                    gba.d.a().h("forum_sign");
                    eh7 c = this.a.c();
                    if (c != null && (e = c.e()) != null && (l = e.id) != null) {
                        this.a.D().put(String.valueOf(l.longValue()), E);
                    }
                    TbSingleton.getInstance().setHasShowTip(this.a.D());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSignStateBiz a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsSignStateBiz frsSignStateBiz) {
            super(2001222);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSignStateBiz};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSignStateBiz;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumInfo forumInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                eh7 c = this.a.c();
                String str = null;
                if (c != null) {
                    forumInfo = c.e();
                } else {
                    forumInfo = null;
                }
                if (forumInfo == null) {
                    return;
                }
                eh7 c2 = this.a.c();
                Intrinsics.checkNotNull(c2);
                ForumInfo e = c2.e();
                Intrinsics.checkNotNull(e);
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    SignData signData = (SignData) data;
                    Integer currentLevel = e.user_level;
                    String str2 = signData.forumId;
                    if (str2 != null) {
                        Long l = e.id;
                        if (l != null) {
                            str = String.valueOf(l);
                        }
                        if (!Intrinsics.areEqual(str2, str)) {
                            return;
                        }
                        this.a.K(signData);
                        if (this.a.m) {
                            Integer nowLevel = e.user_level;
                            Intrinsics.checkNotNullExpressionValue(currentLevel, "currentLevel");
                            int intValue = currentLevel.intValue();
                            Intrinsics.checkNotNullExpressionValue(nowLevel, "nowLevel");
                            if (intValue >= nowLevel.intValue()) {
                                nowLevel = Integer.valueOf(nowLevel.intValue() + 1);
                            }
                            currentLevel = nowLevel;
                        }
                        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                        String str3 = e.name;
                        int i = signData.sign_bonus_point;
                        Intrinsics.checkNotNullExpressionValue(currentLevel, "currentLevel");
                        inst.addSignedForum(str3, i, currentLevel.intValue());
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.SignData");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSignStateBiz a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsSignStateBiz frsSignStateBiz) {
            super(CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSignStateBiz};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSignStateBiz;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Long l;
            ci8.b b;
            ForumInfo e;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003577 && (httpResponsedMessage instanceof ForumSignInResultRespondedMessage)) {
                ForumSignInResultRespondedMessage forumSignInResultRespondedMessage = (ForumSignInResultRespondedMessage) httpResponsedMessage;
                if (!forumSignInResultRespondedMessage.hasError()) {
                    eh7 c = this.a.c();
                    if (c != null && (e = c.e()) != null) {
                        l = e.id;
                    } else {
                        l = null;
                    }
                    if (l == null) {
                        return;
                    }
                    long longValue = l.longValue();
                    ci8 data = forumSignInResultRespondedMessage.getData();
                    if (data != null && (b = data.b(longValue)) != null) {
                        FrsSignStateBiz frsSignStateBiz = this.a;
                        SignData signData = frsSignStateBiz.l;
                        if (signData == null) {
                            signData = new SignData();
                        }
                        signData.miss_sign_num = b.b().c().a();
                        signData.is_signed = b.b().c().b() ? 1 : 0;
                        if (b.b().b()) {
                            signData.showGuideToChatRoom = true;
                            signData.chatRoomGuideData = new yw4(b.b().a().a(), b.b().a().c(), b.b().a().b());
                        }
                        frsSignStateBiz.K(signData);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSignStateBiz(TbPageContext<BaseFragmentActivity> pageContext, TbWebView webView, Function0<? extends ViewGroup> getRootView) {
        super(pageContext, webView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView, getRootView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(getRootView, "getRootView");
        this.f = "";
        this.g = TbSingleton.getInstance().getWalletSignLink();
        this.i = "https://tieba.baidu.com/mo/q/signActivityPage";
        this.j = new HashMap();
        this.r = new c(this, pageContext, getRootView);
        this.s = new d(this, getRootView, pageContext);
        this.t = new b();
        this.u = new e(this);
        this.v = new f(this);
        pageContext.registerListener(this.r);
        pageContext.registerListener(this.u);
        pageContext.registerListener(this.s);
        pageContext.registerListener(this.v);
        oq6 b2 = mq6.b();
        BdUniqueId uniqueId = pageContext.getUniqueId();
        Intrinsics.checkNotNullExpressionValue(uniqueId, "pageContext.uniqueId");
        b2.b(new lq6(uniqueId, di8.class), new a(this, di8.class));
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbSingleton.getInstance().getPushStrategyConfig().d()) {
                return PushOpenUtil.shouldShowPushOpenView(TbadkCoreApplication.getInst(), 4);
            }
            return gba.d.a().b("forum_sign");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.forum.hybrid.manager.BizBase
    public void i() {
        eh7 c2;
        ForumInfo e2;
        SignInfo signInfo;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (c2 = c()) != null && (e2 = c2.e()) != null && (signInfo = e2.sign_in_info) != null) {
            SignData b2 = sh7.b(signInfo);
            this.l = b2;
            Intrinsics.checkNotNull(b2);
            eh7 c3 = c();
            Intrinsics.checkNotNull(c3);
            ForumInfo e3 = c3.e();
            Intrinsics.checkNotNull(e3);
            Long l = e3.id;
            if (l != null) {
                str = String.valueOf(l);
            } else {
                str = null;
            }
            b2.forumId = str;
        }
    }

    public final String B() {
        InterceptResult invokeV;
        SignData signData;
        yw4 yw4Var;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.p || (signData = this.l) == null || (yw4Var = signData.chatRoomGuideData) == null || (c2 = yw4Var.c()) == null) {
                return "";
            }
            return c2;
        }
        return (String) invokeV.objValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            eh7 c2 = c();
            if (c2 != null && c2.n() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final Map<String, Date> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (Map) invokeV.objValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return !TextUtils.isEmpty(this.g);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ti7
    public WrapListener[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new WrapListener[]{e().invoke("frsPage.frsSign", new FrsSignStateBiz$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.forum.hybrid.manager.BizBase, com.baidu.tieba.ti7
    public si7[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new si7[]{h(24002, new FrsSignStateBiz$requestCodeHandlers$1(this))} : (si7[]) invokeV.objValue;
    }

    public final Date E() {
        InterceptResult invokeV;
        ForumInfo e2;
        Long l;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Map<String, Date> hasShowTip = TbSingleton.getInstance().getHasShowTip();
            Intrinsics.checkNotNullExpressionValue(hasShowTip, "getInstance().hasShowTip");
            this.j = hasShowTip;
            Date date = new Date(System.currentTimeMillis());
            eh7 c2 = c();
            if (c2 != null && (e2 = c2.e()) != null && (l = e2.id) != null && (valueOf = String.valueOf(l)) != null) {
                if ((!this.j.isEmpty()) && this.j.containsKey(valueOf)) {
                    if (TimeHelper.getDayDifference(this.j.get(valueOf), date) >= 1) {
                        this.k = true;
                    }
                } else {
                    this.k = true;
                }
            }
            return date;
        }
        return (Date) invokeV.objValue;
    }

    public final void G() {
        boolean z;
        ForumInfo forumInfo;
        String name;
        SignActivityInfo k;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            eh7 c2 = c();
            if (c2 != null && (k = c2.k()) != null && (l = k.activity_id) != null) {
                TbSingleton.getInstance().setActivityId(String.valueOf(l.longValue()));
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                TbadkCoreApplication.getInst().login(f(), new CustomMessage<>(2002001, new LoginActivityConfig(f().getPageActivity(), true, 11014)));
                return;
            }
            eh7 c3 = c();
            ForumInfo forumInfo2 = null;
            if (c3 != null) {
                forumInfo = c3.e();
            } else {
                forumInfo = null;
            }
            if (forumInfo == null) {
                return;
            }
            ForumData forumData = new ForumData();
            eh7 c4 = c();
            if (c4 != null) {
                forumInfo2 = c4.e();
            }
            forumData.parserProtobuf(forumInfo2);
            forumData.setFromPage("frs");
            if (forumData.getName() == null) {
                name = "";
            } else {
                name = forumData.getName();
                Intrinsics.checkNotNullExpressionValue(name, "forumData.name");
            }
            this.f = name;
            CustomMessage customMessage = new CustomMessage(2001425, forumData);
            customMessage.setTag(f().getUniqueId());
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public final void H(String str) {
        ForumInfo e2;
        Long l;
        long j;
        Long l2;
        ForumInfo e3;
        ForumInfo e4;
        yw4 yw4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            eh7 c2 = c();
            Intrinsics.checkNotNull(c2);
            if (c2.n() != 1) {
                return;
            }
            try {
                this.q = new JSONObject(str).optBoolean("isProcess");
            } catch (Exception unused) {
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                k(R.string.obfuscated_res_0x7f0f0e61);
            } else if (!ViewHelper.checkUpIsLogin(f().getPageActivity())) {
            } else {
                String B = B();
                long j2 = 0;
                boolean z = false;
                if (!TextUtils.isEmpty(B)) {
                    UrlManager.getInstance().dealOneLink(f(), new String[]{B});
                    SignData signData = this.l;
                    if (signData != null && (yw4Var = signData.chatRoomGuideData) != null) {
                        j = yw4Var.a();
                    } else {
                        j = 0;
                    }
                    StatisticItem param = new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount());
                    eh7 c3 = c();
                    String str2 = null;
                    if (c3 != null && (e4 = c3.e()) != null) {
                        l2 = e4.id;
                    } else {
                        l2 = null;
                    }
                    if (l2 != null) {
                        j2 = l2.longValue();
                    }
                    StatisticItem param2 = param.param("fid", j2);
                    eh7 c4 = c();
                    if (c4 != null && (e3 = c4.e()) != null) {
                        str2 = e3.name;
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    TiebaStatic.log(param2.param("fname", str2).param("room_id", j));
                    this.p = true;
                    return;
                }
                SignData signData2 = this.l;
                if (signData2 != null && signData2.is_signed == 0) {
                    z = true;
                }
                if (z) {
                    G();
                    StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                    Activity pageActivity = f().getPageActivity();
                    eh7 c5 = c();
                    if (c5 != null && (e2 = c5.e()) != null && (l = e2.id) != null) {
                        j2 = l.longValue();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewSupplementSignActivityConfig(pageActivity, (int) j2, 24002)));
                }
            }
        }
    }

    public final void J(Intent intent) {
        String str;
        ForumInfo e2;
        ForumInfo e3;
        Integer num;
        ForumInfo e4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, intent) != null) || intent == null) {
            return;
        }
        boolean z = false;
        int intExtra = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
        HybridLog.getInstance().i("FrsSignStateBiz", "从补签页面回来 " + intExtra + WebvttCueParser.CHAR_SPACE + intExtra2 + WebvttCueParser.CHAR_SPACE + intExtra3 + WebvttCueParser.CHAR_SPACE + intExtra4);
        eh7 c2 = c();
        if (c2 != null && (e4 = c2.e()) != null) {
            long j = intExtra;
            Long l = e4.id;
            if (l != null && j == l.longValue()) {
                z = true;
            }
        }
        if (z && intExtra2 > 0 && intExtra3 > 0) {
            SignData signData = this.l;
            if (signData == null) {
                signData = new SignData();
            }
            signData.sign_bonus_point = intExtra4;
            signData.miss_sign_num -= intExtra3;
            signData.count_sign_num = intExtra2;
            K(signData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i = -1;
            eh7 c3 = c();
            if (c3 != null && (e3 = c3.e()) != null && (num = e3.user_level) != null) {
                int intValue = num.intValue();
                if (this.m) {
                    i = intValue + 1;
                }
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            eh7 c4 = c();
            if (c4 != null && (e2 = c4.e()) != null) {
                str = e2.name;
            } else {
                str = null;
            }
            inst.addSignedForum(str, signData.sign_bonus_point, i);
        }
    }

    public final void I(SignData signData) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, signData) == null) {
            int i = signData.sign_bonus_point;
            this.m = false;
            if (i >= this.n - this.o) {
                this.m = true;
                this.n = signData.levelup_score;
            }
            int i2 = this.o + i;
            this.o = i2;
            int i3 = this.n;
            if (i2 > i3) {
                this.o = i3;
            }
            int i4 = this.n;
            if (i4 != 0) {
                f2 = this.o / i4;
            } else {
                f2 = 0.0f;
            }
            int i5 = (f2 > 0.999f ? 1 : (f2 == 0.999f ? 0 : -1));
        }
    }

    public final void K(SignData signData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, signData) == null) {
            this.l = signData;
            I(signData);
            JSONObject jSONObject = new JSONObject();
            JSONKt.c(jSONObject, "signStatus", "1");
            JSONKt.c(jSONObject, "signMissNum", Integer.valueOf(signData.miss_sign_num));
            JSONKt.c(jSONObject, "data", signData.toJsonObject());
            d().invoke("frsPageNa.frsSignStatus", jSONObject);
        }
    }
}
