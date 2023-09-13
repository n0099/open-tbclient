package com.baidu.tieba.enterForum.home;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.MaintabAddResponedData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bha;
import com.baidu.tieba.bia;
import com.baidu.tieba.bo5;
import com.baidu.tieba.by5;
import com.baidu.tieba.cx5;
import com.baidu.tieba.df;
import com.baidu.tieba.e17;
import com.baidu.tieba.ef;
import com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumHttpResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumAdModel;
import com.baidu.tieba.enterForum.model.EnterForumAdResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.ff;
import com.baidu.tieba.i17;
import com.baidu.tieba.i9;
import com.baidu.tieba.tt6;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import com.baidu.tieba.w07;
import com.baidu.tieba.xx5;
import com.baidu.tieba.y07;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class EnterForumDelegateStatic extends FragmentDelegate {
    public static /* synthetic */ Interceptable $ic;
    public static ef a;
    public static EnterForumModel b;
    public static EnterForumAdModel c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public a(j jVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                EnterForumDelegateStatic.f((Activity) this.a.getData());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !TbadkCoreApplication.isLogin()) {
                return;
            }
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            if (sharedPrefHelper.getBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), false)) {
                return;
            }
            SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
            if (sharedPrefHelper2.getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0) <= 5 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Activity)) {
                SafeHandler.getInst().post(new a(this, customResponsedMessage));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements df {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        @Override // com.baidu.tieba.df
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    EnterForumDelegateStatic.a.d();
                }
            }
        }

        public q(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // com.baidu.tieba.df
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                BubbleLayout bubbleLayout = (BubbleLayout) View.inflate(this.a, R.layout.obfuscated_res_0x7f0d02c5, null);
                TextView textView = (TextView) bubbleLayout.findViewById(R.id.obfuscated_res_0x7f090a23);
                textView.setOnClickListener(new a(this));
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                bubbleLayout.d(SkinManager.getColor(R.color.cp_link_tip_a_alpha95));
                return bubbleLayout;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.df
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (BdUtilHelper.getEquipmentDensity(this.a) > 0.0f) {
                    return (int) ((this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703f5) * 2) / BdUtilHelper.getEquipmentDensity(this.a));
                }
                return this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703f5);
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070233) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (UtilHelper.getVirtualBarHeight(this.a) > 0 || MenuKeyUtils.hasSmartBar()) {
                    dimensionPixelSize -= BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f0701d5);
                }
                if (BdUtilHelper.getEquipmentDensity(this.a) > 0.0f) {
                    return (int) ((dimensionPixelSize * 3) / BdUtilHelper.getEquipmentDensity(this.a));
                }
                return dimensionPixelSize;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements bo5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(EnterForumDelegateStatic enterForumDelegateStatic, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumDelegateStatic, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.bo5.b
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements EnterForumModel.f {
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

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                y07 e = eVar.d.e();
                ArrayList arrayList = new ArrayList();
                Iterator<w07> it = e.b().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().i());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(2001329, arrayList));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends i9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            }
        }

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
    }

    /* loaded from: classes5.dex */
    public class d extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || !(responsedMessage instanceof ForumGuideHttpResponseMessage) || EnterForumDelegateStatic.b.getUniqueId() != responsedMessage.getOrginalMessage().getTag() || responsedMessage.hasError()) {
                return;
            }
            EnterForumDelegateStatic.b.c0((ForumGuideHttpResponseMessage) responsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && TbadkCoreApplication.isLogin() && (customResponsedMessage instanceof RequestEnterForumDataMessage)) {
                if (((RequestEnterForumDataMessage) customResponsedMessage).isCache()) {
                    EnterForumDelegateStatic.b.W(true);
                } else {
                    EnterForumDelegateStatic.b.X(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<tt6> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2016562, new i17());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0 && strArr[0] != null) {
                    String lowerCase = strArr[0].toLowerCase();
                    if (lowerCase.contains("unidispatch/hotuserrank")) {
                        HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(tbPageContext.getPageActivity());
                        hotUserRankActivityConfig.setUri(Uri.parse(lowerCase));
                        tbPageContext.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                String data = customMessage.getData();
                VisitedForumData visitedForumData = new VisitedForumData();
                visitedForumData.setForumId(data);
                e17.n().i(visitedForumData);
                TiebaStatic.log(new StatisticItem("c13005").param("fid", data));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FragmentTabStructure fragmentTabStructure;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                EnterForumDelegateStatic.c.S();
            }
            ((MaintabAddResponedData) customResponsedMessage.getData()).addFragment(enterForumDelegateStatic);
            if (((MaintabAddResponedData) customResponsedMessage.getData()).getContext() == null || (fragmentTabStructure = enterForumDelegateStatic.getFragmentTabStructure()) == null || fragmentTabStructure.frag.isAdded()) {
                return;
            }
            fragmentTabStructure.frag.setArguments(new Bundle());
        }
    }

    /* loaded from: classes5.dex */
    public class k implements CustomMessageTask.CustomRunnable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                e17.n().r();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2921483, e17.n().m());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m extends xx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.xx5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork();
                netWork.setUrl(TbConfig.SERVER_ADDRESS + "/ala/sys/liveBarConcerned");
                netWork.addPostData("uid", TbadkCoreApplication.getCurrentAccount());
                String postNetData = netWork.postNetData();
                if (netWork.isNetSuccess() && netWork.getServerErrorCode() == 0) {
                    try {
                        boolean z = false;
                        if (new JSONObject(postNetData).optInt("live_bar_concerned", 0) == 1) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    } catch (JSONException unused) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements cx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public n(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bool) != null) || !bool.booleanValue()) {
                return;
            }
            EnterForumDelegateStatic.q(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && EnterForumDelegateStatic.a != null) {
                EnterForumDelegateStatic.a.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements ff.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Handler a;
        public final /* synthetic */ Runnable b;

        @Override // com.baidu.tieba.ff.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public p(Handler handler, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = handler;
            this.b = runnable;
        }

        @Override // com.baidu.tieba.ff.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putBoolean("key_enter_forum_ufan_tip_show" + TbadkCoreApplication.getCurrentAccount(), true);
                ef unused = EnterForumDelegateStatic.a = null;
                this.a.removeCallbacks(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2056451033, "Lcom/baidu/tieba/enterForum/home/EnterForumDelegateStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2056451033, "Lcom/baidu/tieba/enterForum/home/EnterForumDelegateStatic;");
                return;
            }
        }
        i iVar = new i(2007002);
        iVar.setPriority(3);
        MessageManager.getInstance().registerListener(iVar);
        if (BdUtilHelper.isMainThread()) {
            MessageManager.getInstance().registerListener(new j(2921341));
        }
        k();
        g();
        j();
        m();
        TbadkCoreApplication.getInst().RegisterIntent(HotUserRankActivityConfig.class, HotUserRankActivity.class);
        l();
        h();
        o();
        n();
        p();
        i();
    }

    public EnterForumDelegateStatic() {
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

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016562, new f());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            UrlManager.getInstance().addListener(new g());
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921519, new h());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            e17.n();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            bha.e(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST, TbConfig.URL_ENTER_FORUM_AD, EnterForumAdResponsedMessage.class, false, false, true, false);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            bha.h(309651, TabFeedListSocketResponsedMessage.class, false, false);
            bha.c(309651, CmdConfigHttp.CMD_TAB_FEED_LIST, TbConfig.URL_TAB_FEED_LIST, TabFeedListHttpResponsedMessage.class, false, false, true, false);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921483, new l());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            e17.n();
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921479, new k());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return MainTabActivityConfig.ENTER_FORUM_DELEGATE_AVAILABLE;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) bo5.e().d(1002, new a(this, context));
            this.mIndicator = maintabBottomIndicator;
            return maintabBottomIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    public static void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, activity) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            int i2 = sharedPrefHelper.getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), 0);
            SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
            sharedPrefHelper2.getInt("key_enter_forum_ufan_attention_check_count" + TbadkCoreApplication.getCurrentAccount(), i2 + 1);
            by5.b(new m(), new n(activity));
        }
    }

    public static void q(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, activity) == null) {
            ef efVar = a;
            if (efVar != null) {
                efVar.d();
            }
            Handler handler = new Handler();
            o oVar = new o();
            ff ffVar = new ff();
            ffVar.d(true);
            ffVar.h(new p(handler, oVar));
            ffVar.k(activity.getWindow().getDecorView());
            ffVar.c(20);
            ffVar.j(false);
            ffVar.a(new q(activity));
            ef b2 = ffVar.b();
            a = b2;
            b2.m(activity);
            handler.postDelayed(oVar, 5000L);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            bia.d();
            if (b == null) {
                EnterForumModel enterForumModel = new EnterForumModel(null);
                b = enterForumModel;
                enterForumModel.i0(new b());
            }
            if (c == null) {
                EnterForumAdModel enterForumAdModel = new EnterForumAdModel();
                c = enterForumAdModel;
                enterForumAdModel.setLoadDataCallBack(new c());
            }
            MessageManager.getInstance().registerListener(new d(CmdConfigHttp.CMD_ENTER_FORUM_DATA, 309683));
            MessageManager.getInstance().registerListener(new e(2001323));
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            bha.h(303011, forumRecommendSocketResponseMessage.class, false, false);
            bha.c(303011, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, "c/f/forum/forumrecommend", forumRecommendHttpResponseMessage.class, false, false, false, false);
            bha.c(309683, CmdConfigHttp.CMD_ENTER_FORUM_DATA, "c/f/forum/forumGuide", ForumGuideHttpResponseMessage.class, false, false, true, false);
            bha.c(309685, CmdConfigHttp.CMD_SET_LIKE_FORUM, "c/c/forum/setLikeForumSort", SetLikeForumHttpResponseMessage.class, false, false, false, false);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            bha.h(309601, RecentlyVisitedForumSocketResponseMessage.class, false, false);
            bha.c(309601, CmdConfigHttp.CMD_GET_HISTORY_FORUM, "c/f/forum/gethistoryforum", RecentlyVisitedForumHttpResponseMessage.class, false, false, false, false);
            bha.e(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM, "c/c/forum/delHistoryForum", null, false, false, false, false);
        }
    }

    @Override // com.baidu.tbadk.mainTab.FragmentDelegate
    public FragmentTabStructure createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
            fragmentTabStructure.frag = new EnterForumTabFragment();
            fragmentTabStructure.type = 1;
            fragmentTabStructure.textResId = R.string.enter_forum;
            fragmentTabStructure.showIconType = FragmentTabStructure.SHOWBOTH;
            fragmentTabStructure.animationResId = R.raw.lottie_tab_forum;
            fragmentTabStructure.dynamicIconData = MainTabBottomDynamicIconManager.getInstance().getIconData(MainTabBottomDynamicIconManager.TAG_ENTER_FORUM);
            return fragmentTabStructure;
        }
        return (FragmentTabStructure) invokeV.objValue;
    }
}
