package com.baidu.tieba.forum.hybrid.biz;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.ar6;
import com.baidu.tieba.br6;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.dr6;
import com.baidu.tieba.er6;
import com.baidu.tieba.fl8;
import com.baidu.tieba.forum.hybrid.biz.FrsFollowAndSignBiz;
import com.baidu.tieba.forum.hybrid.manager.BizBase;
import com.baidu.tieba.forum.hybrid.manager.WrapListener;
import com.baidu.tieba.ft5;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.l68;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.oi7;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FrsPage.ForumInfo;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0013H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/forum/hybrid/biz/FrsFollowAndSignBiz;", "Lcom/baidu/tieba/forum/hybrid/manager/BizBase;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;)V", "signController", "Lcom/baidu/tieba/forum/hybrid/biz/FrsFollowAndSignBiz$SignController;", "getSignController", "()Lcom/baidu/tieba/forum/hybrid/biz/FrsFollowAndSignBiz$SignController;", "signController$delegate", "Lkotlin/Lazy;", "handleCancelFollow", "", "isSuccess", "", "data", "", "handleFollow", "handleFollowAndSignStatus", "dataJsonStr", "keyListeners", "", "Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "()[Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "saveAcceptNotify", "isOn", "forumId", "SignController", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsFollowAndSignBiz extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy f;

    /* loaded from: classes6.dex */
    public static final class a extends er6<fl8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFollowAndSignBiz b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsFollowAndSignBiz frsFollowAndSignBiz, Class<fl8> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFollowAndSignBiz, cls};
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
            this.b = frsFollowAndSignBiz;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(fl8 event) {
            String str;
            ForumInfo d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                JSONObject jSONObject = new JSONObject();
                JSONKt.c(jSONObject, "chatSign", "1");
                this.b.d().invoke("frsPageNa.GroupChatSignStatus", jSONObject);
                TbLog defaultLog = DefaultLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("群内发生签到行为，已经通知H5。当前吧为：");
                oi7 c = this.b.c();
                if (c != null && (d = c.d()) != null) {
                    str = d.name;
                } else {
                    str = null;
                }
                sb.append(str);
                defaultLog.i("FrsFollowAndSign", sb.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final oi7 a;
        public boolean b;
        public int c;
        public int d;

        public b(oi7 oi7Var) {
            Integer num;
            int intValue;
            ForumInfo d;
            ForumInfo d2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi7Var;
            Integer num2 = null;
            if (oi7Var != null && (d2 = oi7Var.d()) != null) {
                num = d2.levelup_score;
            } else {
                num = null;
            }
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            this.c = intValue;
            oi7 oi7Var2 = this.a;
            if (oi7Var2 != null && (d = oi7Var2.d()) != null) {
                num2 = d.cur_score;
            }
            this.d = num2 != null ? num2.intValue() : 0;
        }

        public final void a(String data) {
            String str;
            String str2;
            Integer num;
            int intValue;
            ForumInfo d;
            ForumInfo d2;
            ForumInfo d3;
            ForumInfo d4;
            Long l;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                SignData signData = new SignData();
                signData.parserJson(data);
                oi7 oi7Var = this.a;
                String str3 = null;
                if (oi7Var != null && (d4 = oi7Var.d()) != null && (l = d4.id) != null) {
                    str = String.valueOf(l);
                } else {
                    str = null;
                }
                signData.forumId = str;
                oi7 oi7Var2 = this.a;
                if (oi7Var2 != null && (d3 = oi7Var2.d()) != null) {
                    str2 = d3.name;
                } else {
                    str2 = null;
                }
                signData.forumName = str2;
                b(signData);
                oi7 oi7Var3 = this.a;
                if (oi7Var3 != null && (d2 = oi7Var3.d()) != null) {
                    num = d2.user_level;
                } else {
                    num = null;
                }
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                if (this.b) {
                    intValue++;
                }
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                oi7 oi7Var4 = this.a;
                if (oi7Var4 != null && (d = oi7Var4.d()) != null) {
                    str3 = d.name;
                }
                inst.addSignedForum(str3, signData.sign_bonus_point, intValue);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            }
        }

        public final void b(SignData signData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, signData) == null) {
                int i = signData.sign_bonus_point;
                this.b = false;
                if (i >= this.c - this.d) {
                    this.b = true;
                    this.c = signData.levelup_score;
                }
                int i2 = this.d + i;
                this.d = i2;
                int i3 = this.c;
                if (i2 > i3) {
                    this.d = i3;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFollowAndSignBiz(TbPageContext<BaseFragmentActivity> pageContext, TbWebView webView) {
        super(pageContext, webView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<b>(this) { // from class: com.baidu.tieba.forum.hybrid.biz.FrsFollowAndSignBiz$signController$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrsFollowAndSignBiz this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrsFollowAndSignBiz.b invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new FrsFollowAndSignBiz.b(this.this$0.c());
                }
                return (FrsFollowAndSignBiz.b) invokeV.objValue;
            }
        });
        dr6 b2 = br6.b();
        BdUniqueId uniqueId = pageContext.getUniqueId();
        Intrinsics.checkNotNullExpressionValue(uniqueId, "pageContext.uniqueId");
        b2.b(new ar6(uniqueId, fl8.class), new a(this, fl8.class));
    }

    public final void p(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048581, this, z, str) == null) {
            OfficialSettingCache.getInstance().saveAcceptNotifyAsync(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    @Override // com.baidu.tieba.qk7
    public WrapListener[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new WrapListener[]{e().invoke("frsPage.followAndSignStatus", new FrsFollowAndSignBiz$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    public final b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (b) this.f.getValue();
        }
        return (b) invokeV.objValue;
    }

    public final void m(boolean z, String str) {
        Long l;
        long longValue;
        oi7 c;
        ForumInfo d;
        Long l2;
        String str2;
        Long l3;
        ForumInfo d2;
        String str3;
        ForumInfo d3;
        ForumInfo d4;
        ForumInfo d5;
        ForumInfo d6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
            AttentionBarData attentionBarData = new AttentionBarData();
            oi7 c2 = c();
            String str4 = null;
            if (c2 != null && (d6 = c2.d()) != null) {
                l = d6.id;
            } else {
                l = null;
            }
            if (l == null) {
                longValue = 0;
            } else {
                longValue = l.longValue();
            }
            attentionBarData.forumId = longValue;
            if (z) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                oi7 c3 = c();
                if (c3 != null && (d5 = c3.d()) != null) {
                    str2 = d5.name;
                } else {
                    str2 = null;
                }
                inst.delLikeForum(str2);
                oi7 c4 = c();
                if (c4 != null && (d4 = c4.d()) != null) {
                    l3 = d4.id;
                } else {
                    l3 = null;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, l3));
                oi7 c5 = c();
                if (c5 != null && (d3 = c5.d()) != null) {
                    str4 = d3.name;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, str4));
                attentionBarData.isSuccess = true;
                oi7 c6 = c();
                if (c6 != null && (d2 = c6.d()) != null && (str3 = d2.name) != null) {
                    l68.a.d(str3);
                }
            } else {
                attentionBarData.isSuccess = false;
                if (str != null) {
                    attentionBarData.errorMessage = str;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, attentionBarData));
            if (z && (c = c()) != null && (d = c.d()) != null && (l2 = d.id) != null) {
                long longValue2 = l2.longValue();
                p(false, String.valueOf(longValue2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, String.valueOf(longValue2)));
                LikeReturnData likeReturnData = new LikeReturnData();
                likeReturnData.setLike(0);
                likeReturnData.setFid(String.valueOf(longValue2));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
            }
        }
    }

    public final void n(boolean z, String str) {
        Long l;
        long longValue;
        Long l2;
        String str2;
        ForumInfo d;
        String str3;
        ForumInfo d2;
        Long l3;
        ForumInfo d3;
        ForumInfo d4;
        ForumInfo d5;
        ForumInfo d6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            LikeReturnData likeReturnData = new LikeReturnData();
            likeReturnData.parserJson(str);
            BdToastData bdToastData = new BdToastData();
            bdToastData.parserJson(str);
            likeReturnData.setToastData(bdToastData);
            AttentionBarData attentionBarData = new AttentionBarData();
            oi7 c = c();
            String str4 = null;
            if (c != null && (d6 = c.d()) != null) {
                l = d6.id;
            } else {
                l = null;
            }
            long j = 0;
            if (l == null) {
                longValue = 0;
            } else {
                longValue = l.longValue();
            }
            attentionBarData.forumId = longValue;
            attentionBarData.likeNum = likeReturnData.getLikeNum();
            if (z) {
                oi7 c2 = c();
                if (c2 != null && (d5 = c2.d()) != null) {
                    l2 = d5.id;
                } else {
                    l2 = null;
                }
                if (l2 != null) {
                    j = l2.longValue();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(j)));
                oi7 c3 = c();
                if (c3 != null && (d4 = c3.d()) != null) {
                    str2 = d4.name;
                } else {
                    str2 = null;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new ft5.a(str2, likeReturnData.getUserLevel())));
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                oi7 c4 = c();
                if (c4 != null && (d3 = c4.d()) != null) {
                    str4 = d3.name;
                }
                inst.addLikeForum(str4);
                attentionBarData.isSuccess = true;
                oi7 c5 = c();
                if (c5 != null && (d2 = c5.d()) != null && (l3 = d2.id) != null) {
                    long longValue2 = l3.longValue();
                    likeReturnData.setFid(String.valueOf(longValue2));
                    p(true, String.valueOf(longValue2));
                }
                oi7 c6 = c();
                if (c6 != null && (d = c6.d()) != null && (str3 = d.name) != null) {
                    l68.a.h(str3);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
            } else {
                attentionBarData.isSuccess = false;
            }
            attentionBarData.errorMessage = likeReturnData.getErrorMsg();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, attentionBarData));
        }
    }

    public final void o(String str) {
        ForumInfo d;
        String str2;
        ForumInfo d2;
        ForumInfo d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String str3 = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("type");
                String optString = jSONObject.optString("data");
                TbLog defaultLog = DefaultLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("收到H5通知，操作类型为：");
                sb.append(optInt);
                sb.append("。当前吧为：");
                oi7 c = c();
                if (c != null && (d3 = c.d()) != null) {
                    str2 = d3.name;
                } else {
                    str2 = null;
                }
                sb.append(str2);
                defaultLog.e("FrsFollowAndSign", sb.toString());
                if (optInt != 1) {
                    if (optInt != 2) {
                        if (optInt != 3) {
                            if (optInt != 4) {
                                if (optInt != 5) {
                                    TbLog defaultLog2 = DefaultLog.getInstance();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("收到H5通知，操作类型为：");
                                    sb2.append(optInt);
                                    sb2.append("，不需要处理。当前吧为：");
                                    oi7 c2 = c();
                                    if (c2 != null && (d2 = c2.d()) != null) {
                                        str3 = d2.name;
                                    }
                                    sb2.append(str3);
                                    defaultLog2.e("FrsFollowAndSign", sb2.toString());
                                    return;
                                } else if (optString != null) {
                                    l().a(optString);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            m(false, optString);
                            return;
                        }
                        m(true, optString);
                    } else if (optString != null) {
                        n(false, optString);
                    }
                } else if (optString != null) {
                    n(true, optString);
                }
            } catch (Exception e) {
                TbLog defaultLog3 = DefaultLog.getInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("收到H5通知，数据解析异常！当前吧为：");
                oi7 c3 = c();
                if (c3 != null && (d = c3.d()) != null) {
                    str3 = d.name;
                }
                sb3.append(str3);
                sb3.append(", 异常信息为：");
                sb3.append(e.getMessage());
                defaultLog3.e("FrsFollowAndSign", sb3.toString());
            }
        }
    }
}
