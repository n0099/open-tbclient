package com.baidu.tieba.frs;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.d1.w0;
import c.a.r0.d1.x0;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.i1;
import c.a.s0.d1.r;
import c.a.s0.d1.s;
import c.a.s0.d1.y2.m;
import c.a.s0.j3.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceHttpResponseMessage;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceSocketResponseMessage;
import com.baidu.tieba.frs.achievement.AchievementActivity;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.frs.dynamic.FrsDynamicHttpResponseMessage;
import com.baidu.tieba.frs.dynamic.FrsDynamicSocketResponsedMessage;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.frs.movearea.FrsMoveAreaResMsg;
import com.baidu.tieba.home.CreateForumSuccessActivity;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import java.util.Map;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.StarTrends.StarTrendsResIdl;
/* loaded from: classes12.dex */
public class FrsActivityStatic {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f44490b = true;

    /* renamed from: c  reason: collision with root package name */
    public static String f44491c = "";

    /* renamed from: d  reason: collision with root package name */
    public static final CustomMessageListener f44492d;

    /* renamed from: e  reason: collision with root package name */
    public static final CustomMessageListener f44493e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a implements CustomMessageTask.CustomRunnable<TbPageContext> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<c.a.s0.d1.k> run(CustomMessage<TbPageContext> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage.getData() instanceof TbPageContext)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921336, new r(customMessage.getData(), s.f16352f));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                x0.a(c.a.s0.d1.x1.a.f16585i, StarTrendsResIdl.class);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class c implements UrlManager.UrlSchemaHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlSchemaHandler
        public void deal(TbPageContext<?> tbPageContext, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, map) == null) || tbPageContext == null || map == null) {
                return;
            }
            String str = map.get("forum_id");
            String str2 = map.get("from");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new ForumRulesShowActivityConfig(tbPageContext.getPageActivity(), str, str2).start();
        }
    }

    /* loaded from: classes12.dex */
    public static class d implements CustomMessageTask.CustomRunnable<FrsActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    int requestCode = customMessage.getData().getRequestCode();
                    if (requestCode == 0) {
                        customMessage.getData().startActivity(FrsActivity.class);
                    } else {
                        customMessage.getData().startActivityForResult(requestCode, FrsActivity.class);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class e implements CustomMessageTask.CustomRunnable<FrsActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(FrsActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class f implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String substring;
            boolean z;
            int e2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null) {
                    boolean z2 = false;
                    if (strArr[0] != null && tbPageContext != null && tbPageContext.getPageActivity() != null) {
                        String lowerCase = strArr[0].toLowerCase();
                        String str2 = strArr.length > 1 ? strArr[1] : null;
                        int e3 = c.a.d.f.m.b.e(w0.c(lowerCase, "call_from="), 0);
                        if (!lowerCase.startsWith("http://tieba.baidu.com/f?") && !lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                            if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_FRS)) {
                                r4 = lowerCase.substring(4);
                                e2 = 0;
                                z = true;
                            } else {
                                if (lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                                    r4 = lowerCase.substring(25);
                                    z2 = true;
                                } else if (lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains(FrsFragment.FORUM_KW)) {
                                    r4 = w0.c(lowerCase, FrsFragment.FORUM_KW);
                                    if (!TextUtils.isEmpty(r4)) {
                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(r4, str2);
                                        if (e3 > 0) {
                                            createNormalCfg.setCallFrom(e3);
                                        } else {
                                            createNormalCfg.setCallFrom(12);
                                        }
                                        if (lowerCase.contains(TbConfig.WEB_VIEW_NEED_FRESH)) {
                                            createNormalCfg.setRequestCode(25045);
                                        }
                                        tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg));
                                        return 0;
                                    }
                                } else if (lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_GAME_FRS_TAB)) {
                                    r4 = w0.c(lowerCase, FrsFragment.FORUM_KW);
                                    e2 = c.a.d.f.m.b.e(w0.c(lowerCase, "tab_id="), 0);
                                    z = false;
                                } else if (lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_FRS)) {
                                    Uri parse = Uri.parse(lowerCase);
                                    if (parse != null) {
                                        r4 = parse.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
                                        String queryParameter = parse.getQueryParameter(c.a.r0.a.g.Z);
                                        if (!StringUtils.isNull(queryParameter)) {
                                            TbSingleton.getInstance().setFromWhichSearchSource(queryParameter);
                                        }
                                    }
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(r4, str2);
                                    if (lowerCase.contains("achievement")) {
                                        createNormalCfg2.setAchievementUrl(lowerCase);
                                    }
                                    tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                    return 0;
                                } else if (lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_FRS_ITEM_TAB)) {
                                    Uri parse2 = Uri.parse(lowerCase);
                                    tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(parse2 != null ? parse2.getQueryParameter(CreateForumSuccessActivity.FORUM_NAME_STRING) : null, FrsActivityConfig.FRS_FROM_ITEM)));
                                    return 0;
                                } else {
                                    return 3;
                                }
                                e2 = 0;
                                z = false;
                            }
                        } else {
                            if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                                substring = lowerCase.substring(25);
                            } else {
                                substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring(25) : null;
                            }
                            if (substring != null) {
                                String[] split = substring.split("&");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= split.length) {
                                        str = null;
                                        z = false;
                                        break;
                                    } else if (split[i2] != null && split[i2].startsWith(FrsFragment.FORUM_KW)) {
                                        str = split[i2].substring(3);
                                        z = true;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    r4 = URLDecoder.decode(str);
                                }
                            } else {
                                z = false;
                            }
                            e2 = c.a.d.f.m.b.e(w0.c(lowerCase, "default_tab_id="), 0);
                        }
                        if (!TextUtils.isEmpty(r4)) {
                            FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(r4, str2);
                            if (e2 != 0) {
                                createNormalCfg3.setDefaultGameTabId(e2);
                            }
                            if (e3 > 0) {
                                createNormalCfg3.setCallFrom(e3);
                            } else {
                                createNormalCfg3.setCallFrom(12);
                            }
                            tbPageContext.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                            return 1;
                        } else if (z2 && !TextUtils.isEmpty(r4)) {
                            c.a.d.f.m.f.startService(TbadkCoreApplication.getInst(), m.c(TbadkCoreApplication.getInst(), r4));
                            c.a.s0.d1.y2.l.e(lowerCase, 2, 2);
                            return 1;
                        } else if (z) {
                            tbPageContext.showToast(i1.page_not_found);
                            return 1;
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof NewMsgArriveResponsedMessage) && customResponsedMessage.getCmd() == 2012111) {
                int intValue = ((NewMsgArriveResponsedMessage) customResponsedMessage).getData().intValue();
                if (intValue != 1 && intValue != 4 && intValue != 3 && intValue != 2) {
                    FrsActivityStatic.f44490b = false;
                    FrsActivityStatic.a = false;
                    return;
                }
                FrsActivityStatic.f44490b = true;
                FrsActivityStatic.a = true;
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            int e2 = c.a.d.f.m.b.e(customResponsedMessage.getData().toString(), 1);
            if (e2 == 1 || e2 == 0) {
                FrsActivityStatic.f44490b = false;
                FrsActivityStatic.a = false;
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001012) {
                if (y.q().b() != null) {
                    y.q().b().f();
                }
                if (y.q().n() != null) {
                    y.q().n().c();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getCmd() == 2016501 && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                c.a.s0.d1.y2.k.a();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class k implements c.a.r0.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.e.e
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = c.a.r0.e.d.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, c1.CAM_X0302);
                    layoutParams.setMargins(c.a.d.f.p.m.f(context, d1.ds8), 0, c.a.d.f.p.m.f(context, d1.ds8), 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class l extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                x0.a(c.a.s0.v3.m.WIRE, FrsPageResIdl.class);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1072256339, "Lcom/baidu/tieba/frs/FrsActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1072256339, "Lcom/baidu/tieba/frs/FrsActivityStatic;");
                return;
            }
        }
        f44492d = new g(2012111);
        f44493e = new h(2012112);
        TbadkCoreApplication.getInst().RegisterIntent(FrsActivityConfig.class, FrsActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ForumRuleEditActivityConfig.class, ForumRulesEditActivity.class);
        a();
        c();
        d();
        b();
        l();
        e();
        LocationModel.H();
        j();
        i();
        f();
        o();
        MessageManager.getInstance().registerListener(f44492d);
        MessageManager.getInstance().registerListener(f44493e);
        h();
        m();
        n();
        k();
        TbadkCoreApplication.getInst().RegisterIntent(ForumRulesShowActivityConfig.class, ForumRulesShowActivity.class);
        g();
        SwitchManager.getInstance().registerSwitch(c.a.s0.d1.w0.class);
    }

    public FrsActivityStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c.a.r0.e.c.b().c(1, new k());
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            UrlManager.getInstance().addListener(new f());
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            TbadkApplication.getInst().RegisterIntent(AchievementActivityConfig.class, AchievementActivity.class);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new e());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            MessageManager.getInstance().registerListener(new j(2016501));
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            c.a.s0.v3.f0.a.h(309602, FrsDynamicSocketResponsedMessage.class, false, false).setPriority(4);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_DYNAMIC, c.a.s0.v3.f0.a.a(TbConfig.FRS_DYNAMIC_ADDRESS, 309602));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsDynamicHttpResponseMessage.class);
            tbHttpMessageTask.setIsImm(true);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            b bVar = new b();
            bVar.setSelfExecute(true);
            bVar.setPriority(4);
            bVar.execute(new Void[0]);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            UrlManager.getInstance().registerSchema(UrlSchemaHelper.SCHEMA_TYPE_FRS_RULES, new c());
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            c.a.s0.v3.f0.a.f(301002, LoadMoreResponseSocketMessage.class, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, c.a.s0.v3.f0.a.a(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.s0.v3.f0.a.h(301001, FRSPageSocketResponsedMessage.class, false, false).setPriority(4);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, c.a.s0.v3.f0.a.a(TbConfig.FRS_ADDRESS, 301001));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
            tbHttpMessageTask.setIsImm(true);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            l lVar = new l();
            lVar.setSelfExecute(true);
            lVar.setPriority(4);
            lVar.execute(new Void[0]);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921336, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            c.a.s0.v3.f0.a.h(309667, GetLiveHorseRaceSocketResponseMessage.class, false, false);
            c.a.s0.v3.f0.a.c(309667, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, TbConfig.URL_FRS_LIVE_HORSERACE_LIST, GetLiveHorseRaceHttpResponseMessage.class, true, false, true, false);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            MessageManager.getInstance().registerListener(new i(2001012));
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_MOVE_AREA, TbConfig.SERVER_ADDRESS + TbConfig.URL_FRS_MOVE_AREA);
            tbHttpMessageTask.setResponsedClass(FrsMoveAreaResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_RECOMMEND, TbConfig.SERVER_ADDRESS + TbConfig.URL_FRS_RECOMMEND);
            tbHttpMessageTask.setResponsedClass(FrsRecommendResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
            tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
