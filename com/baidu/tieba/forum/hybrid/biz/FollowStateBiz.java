package com.baidu.tieba.forum.hybrid.biz;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.fh7;
import com.baidu.tieba.forum.hybrid.manager.BizBase;
import com.baidu.tieba.forum.hybrid.manager.WrapListener;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.qd;
import com.baidu.tieba.qo5;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.tieba.ug7;
import com.baidu.tieba.vi7;
import com.baidu.tieba.w4;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FrsPage.ForumInfo;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001fJ\u001a\u0010\"\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020!H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/tieba/forum/hybrid/biz/FollowStateBiz;", "Lcom/baidu/tieba/forum/hybrid/manager/BizBase;", "Lcom/baidu/tieba/forum/hybrid/manager/Clean;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;)V", "mAttentionListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mBdLoadDataCallBack", "Lcom/baidu/adp/base/BdLoadDataCallBack;", "mLikeInjectListener", "Lcom/baidu/tieba/tbadkCore/util/AntiHelper$AntiDialogInjectClickListener;", "mLikeModel", "Lcom/baidu/tieba/tbadkCore/LikeModel;", "mUnLikeForumListener", "addLikeBtnClickStat", "", "attentionCallback", "result", "", "keyListeners", "", "Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "()[Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "onDataUpdate", MissionEvent.MESSAGE_DESTROY, "saveAcceptNotify", "isOn", "", "forumId", "", "startLike", "needAnimation", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "startLikeForum", "data", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FollowStateBiz extends BizBase implements vi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LikeModel f;
    public final AntiHelper.k g;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public final w4 j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-238661931, "Lcom/baidu/tieba/forum/hybrid/biz/FollowStateBiz;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-238661931, "Lcom/baidu/tieba/forum/hybrid/biz/FollowStateBiz;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FollowStateBiz a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FollowStateBiz followStateBiz) {
            super(2921600);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {followStateBiz};
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
            this.a = followStateBiz;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof LikeReturnData)) {
                this.a.q(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FollowStateBiz a;

        public b(FollowStateBiz followStateBiz) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {followStateBiz};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = followStateBiz;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.a.q(result);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 dlg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dlg) == null) {
                Intrinsics.checkNotNullParameter(dlg, "dlg");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FollowStateBiz a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FollowStateBiz followStateBiz) {
            super(2001438);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {followStateBiz};
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
            this.a = followStateBiz;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            String str;
            ForumInfo e;
            Long l;
            ForumInfo e2;
            Long l2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage.getData() instanceof AttentionBarData)) {
                    return;
                }
                Object data = responsedMessage.getData();
                if (data != null) {
                    AttentionBarData attentionBarData = (AttentionBarData) data;
                    if (attentionBarData.isSuccess) {
                        String valueOf = String.valueOf(attentionBarData.forumId);
                        fh7 c = this.a.c();
                        if (c != null && (e2 = c.e()) != null && (l2 = e2.id) != null) {
                            str = String.valueOf(l2);
                        } else {
                            str = null;
                        }
                        if (TextUtils.equals(valueOf, str)) {
                            fh7 c2 = this.a.c();
                            Intrinsics.checkNotNull(c2);
                            c2.F(0);
                            JSONObject jSONObject = new JSONObject();
                            JSONKt.c(jSONObject, "signStatus", "6");
                            this.a.d().invoke("frsPageNa.frsSignStatus", jSONObject);
                            fh7 c3 = this.a.c();
                            if (c3 != null && (e = c3.e()) != null && (l = e.id) != null) {
                                FollowStateBiz followStateBiz = this.a;
                                long longValue = l.longValue();
                                followStateBiz.r(false, String.valueOf(longValue));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, String.valueOf(longValue)));
                                LikeReturnData likeReturnData = new LikeReturnData();
                                likeReturnData.setLike(0);
                                likeReturnData.setFid(String.valueOf(longValue));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.tbadkCore.writeModel.AttentionBarData");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowStateBiz(TbPageContext<BaseFragmentActivity> pageContext, TbWebView webView) {
        super(pageContext, webView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView};
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
        this.f = new LikeModel(pageContext);
        this.g = new c();
        this.h = new a(this);
        this.i = new d(this);
        this.j = new b(this);
        pageContext.registerListener(this.h);
        pageContext.registerListener(this.i);
        this.f.setLoadDataCallBack(this.j);
    }

    public final void r(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048581, this, z, str) == null) {
            OfficialSettingCache.getInstance().saveAcceptNotifyAsync(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    @Override // com.baidu.tieba.ui7
    public WrapListener[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new WrapListener[]{e().invoke("frsPage.frsSign", new FollowStateBiz$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.forum.hybrid.manager.BizBase
    public void i() {
        Integer num;
        int intValue;
        ForumInfo e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            fh7 c2 = c();
            Intrinsics.checkNotNull(c2);
            fh7 c3 = c();
            if (c3 != null && (e = c3.e()) != null) {
                num = e.is_like;
            } else {
                num = null;
            }
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            c2.F(intValue);
        }
    }

    @Override // com.baidu.tieba.vi7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.c0();
        }
    }

    public final void p() {
        ForumInfo e;
        String str;
        ForumInfo e2;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            qo5.b(f().getContext(), statisticItem);
            fh7 c2 = c();
            if (c2 != null && (e2 = c2.e()) != null && (l = e2.id) != null) {
                statisticItem.param("fid", l.longValue());
            }
            fh7 c3 = c();
            if (c3 != null && (e = c3.e()) != null && (str = e.name) != null) {
                statisticItem.param("fname", str);
            }
            statisticItem.param("obj_param1", "100465_3");
            TiebaStatic.log(statisticItem);
        }
    }

    public final void q(Object obj) {
        boolean z;
        ForumInfo e;
        Long l;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, obj) != null) || obj == null) {
            return;
        }
        if (AntiHelper.m(this.f.getErrorCode(), this.f.getErrorString())) {
            if (AntiHelper.t(f().getPageActivity(), this.f.d0(), this.g) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                return;
            }
            return;
        }
        if (!(obj instanceof LikeReturnData)) {
            obj = null;
        }
        boolean z2 = false;
        if (obj != null && this.f.getErrorCode() == 0) {
            z = true;
        } else {
            z = false;
        }
        Intrinsics.checkNotNull(obj);
        LikeReturnData likeReturnData = (LikeReturnData) obj;
        if (likeReturnData.getErrorCode() == 3250013) {
            BdToast.makeText(TbadkCoreApplication.getInst().getContext(), likeReturnData.getErrorMsg()).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
        } else {
            z2 = z;
        }
        if (z2) {
            fh7 c2 = c();
            Intrinsics.checkNotNull(c2);
            c2.F(1);
            likeReturnData.setLike(1);
            JSONObject jSONObject = new JSONObject();
            JSONKt.c(jSONObject, "signStatus", "7");
            JSONKt.c(jSONObject, "data", likeReturnData.originData);
            d().invoke("frsPageNa.frsSignStatus", jSONObject);
            fh7 c3 = c();
            if (c3 != null && (e = c3.e()) != null && (l = e.id) != null) {
                long longValue = l.longValue();
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
                httpMessage.addParam("scene_from", "frs");
                httpMessage.addParam("forum_ids", longValue);
                MessageManager.getInstance().sendMessage(httpMessage);
                if ((f().getPageActivity() instanceof FragmentActivity) && !BdToastHelper.canShowToast(likeReturnData.getToastData())) {
                    Activity pageActivity = f().getPageActivity();
                    if (pageActivity != null) {
                        ug7.i((FragmentActivity) pageActivity).s(String.valueOf(longValue));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    }
                }
                r(true, String.valueOf(longValue));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, obj));
            p();
        } else if (this.f.getErrorCode() == 22) {
            f().showToast(f().getString(R.string.had_liked_forum));
        } else {
            f().showToast(this.f.getErrorString());
        }
    }

    public final void s(boolean z) {
        boolean z2;
        String str;
        boolean z3;
        String str2;
        ForumInfo e;
        ForumInfo e2;
        Long l;
        String str3;
        String str4;
        String str5;
        String str6;
        Long l2;
        long longValue;
        ForumInfo e3;
        Long l3;
        long longValue2;
        ForumInfo e4;
        Long l4;
        long longValue3;
        ForumInfo e5;
        String str7;
        String str8;
        ForumInfo e6;
        Long l5;
        long longValue4;
        ForumInfo e7;
        ForumInfo e8;
        ForumInfo e9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                TbadkCoreApplication.getInst().login(f(), new CustomMessage<>(2002001, new LoginActivityConfig(f().getPageActivity(), true, 11002)));
                return;
            }
            fh7 c2 = c();
            Long l6 = null;
            if (c2 != null && (e9 = c2.e()) != null) {
                str = e9.name;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
                fh7 c3 = c();
                if (c3 != null && (e8 = c3.e()) != null) {
                    l = e8.id;
                } else {
                    l = null;
                }
                if (l != null) {
                    fh7 c4 = c();
                    if (c4 != null) {
                        str3 = c4.h();
                    } else {
                        str3 = null;
                    }
                    long j = 0;
                    if (Intrinsics.areEqual(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND, str3)) {
                        StatisticItem statisticItem = new StatisticItem("c10356");
                        fh7 c5 = c();
                        if (c5 != null && (e7 = c5.e()) != null) {
                            l5 = e7.id;
                        } else {
                            l5 = null;
                        }
                        if (l5 == null) {
                            longValue4 = 0;
                        } else {
                            longValue4 = l5.longValue();
                        }
                        TiebaStatic.log(statisticItem.param("fid", longValue4));
                    } else {
                        fh7 c6 = c();
                        if (c6 != null) {
                            str4 = c6.h();
                        } else {
                            str4 = null;
                        }
                        if (Intrinsics.areEqual(FrsActivityConfig.FRS_FROM_SQUARE_HOT, str4)) {
                            StatisticItem param = new StatisticItem("c10590").param("obj_type", 2);
                            fh7 c7 = c();
                            if (c7 != null && (e5 = c7.e()) != null) {
                                l4 = e5.id;
                            } else {
                                l4 = null;
                            }
                            if (l4 == null) {
                                longValue3 = 0;
                            } else {
                                longValue3 = l4.longValue();
                            }
                            TiebaStatic.log(param.param("fid", longValue3));
                        } else {
                            fh7 c8 = c();
                            if (c8 != null) {
                                str5 = c8.h();
                            } else {
                                str5 = null;
                            }
                            if (Intrinsics.areEqual(FrsActivityConfig.FRS_FROM_SQUARE_TOP, str5)) {
                                StatisticItem param2 = new StatisticItem("c10587").param("obj_type", 2);
                                fh7 c9 = c();
                                if (c9 != null && (e4 = c9.e()) != null) {
                                    l3 = e4.id;
                                } else {
                                    l3 = null;
                                }
                                if (l3 == null) {
                                    longValue2 = 0;
                                } else {
                                    longValue2 = l3.longValue();
                                }
                                TiebaStatic.log(param2.param("fid", longValue2));
                            } else {
                                fh7 c10 = c();
                                if (c10 != null) {
                                    str6 = c10.h();
                                } else {
                                    str6 = null;
                                }
                                if (Intrinsics.areEqual(FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND, str6)) {
                                    StatisticItem param3 = new StatisticItem("c10578").param("obj_type", 2);
                                    fh7 c11 = c();
                                    if (c11 != null && (e3 = c11.e()) != null) {
                                        l2 = e3.id;
                                    } else {
                                        l2 = null;
                                    }
                                    if (l2 == null) {
                                        longValue = 0;
                                    } else {
                                        longValue = l2.longValue();
                                    }
                                    TiebaStatic.log(param3.param("fid", longValue));
                                }
                            }
                        }
                    }
                    this.f.setFrom("recom_flist_like_frs");
                    fh7 c12 = c();
                    if (c12 != null) {
                        str7 = c12.h();
                    } else {
                        str7 = null;
                    }
                    if (Intrinsics.areEqual(FrsActivityConfig.FRS_FROM_SQUARE, str7)) {
                        TiebaStatic.eventStat(f().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                    } else {
                        fh7 c13 = c();
                        if (c13 != null) {
                            str8 = c13.h();
                        } else {
                            str8 = null;
                        }
                        if (Intrinsics.areEqual(FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND, str8)) {
                            StatisticItem statisticItem2 = new StatisticItem("c10359");
                            fh7 c14 = c();
                            if (c14 != null && (e6 = c14.e()) != null) {
                                l6 = e6.id;
                            }
                            if (l6 != null) {
                                j = l6.longValue();
                            }
                            TiebaStatic.log(statisticItem2.param("fid", j));
                        }
                    }
                    LikeModel likeModel = this.f;
                    fh7 c15 = c();
                    Intrinsics.checkNotNull(c15);
                    ForumInfo e10 = c15.e();
                    Intrinsics.checkNotNull(e10);
                    String str9 = e10.name;
                    fh7 c16 = c();
                    Intrinsics.checkNotNull(c16);
                    ForumInfo e11 = c16.e();
                    Intrinsics.checkNotNull(e11);
                    likeModel.h0(str9, String.valueOf(e11.id), "FRS");
                    return;
                }
            }
            TbLog hybridLog = HybridLog.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("关注吧失败，fname=");
            fh7 c17 = c();
            if (c17 != null && (e2 = c17.e()) != null) {
                str2 = e2.name;
            } else {
                str2 = null;
            }
            sb.append(str2);
            sb.append(" fid=");
            fh7 c18 = c();
            if (c18 != null && (e = c18.e()) != null) {
                l6 = e.id;
            }
            sb.append(l6);
            hybridLog.e("FollowStateBiz", sb.toString());
        }
    }

    public final void t(String str) {
        ForumInfo e;
        Long l;
        ForumInfo e2;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            fh7 c2 = c();
            Intrinsics.checkNotNull(c2);
            if (c2.n() == 1) {
                return;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                k(R.string.obfuscated_res_0x7f0f0e61);
            } else if (!ViewHelper.checkUpIsLogin(f().getPageActivity())) {
                fh7 c3 = c();
                if (c3 != null && (e2 = c3.e()) != null && (l2 = e2.id) != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", l2.longValue()));
                }
            } else {
                s(true);
                if (!qd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    fh7 c4 = c();
                    if (c4 != null && (e = c4.e()) != null && (l = e.id) != null) {
                        statisticItem.param("fid", l.longValue());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }
}
