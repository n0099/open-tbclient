package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.frs.view.FrsForumToolDialogView;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.s.a;
import d.a.q0.u0.i0;
import d.a.q0.u0.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddBawuPopInfo;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabController implements d.a.q0.e.e.b, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String l0;
    public static final String m0;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBarCoverTip A;
    public boolean B;
    public boolean C;
    public d.a.q0.e0.e D;
    public d.a.q0.u0.n2.e E;
    public Runnable F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public HttpMessageListener K;
    public CustomMessageListener L;
    public d.a.d.c.g.a M;
    public CustomMessageListener N;
    public CustomMessageListener O;
    public CustomMessageListener P;
    public HttpMessageListener Q;
    public CustomMessageListener R;
    public Runnable S;
    public CustomMessageListener T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public CustomMessageListener a0;
    public ViewPager.OnPageChangeListener b0;
    public FrsBaseViewPager.a c0;

    /* renamed from: e  reason: collision with root package name */
    public FrsActivity f15851e;

    /* renamed from: f  reason: collision with root package name */
    public FrsFragment f15852f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabHostFragment f15853g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h3.m f15854h;

    /* renamed from: i  reason: collision with root package name */
    public i0 f15855i;
    public CustomMessageListener i0;
    public boolean j;
    public final ItemCardHelper.b j0;
    public final Handler k;
    public Runnable k0;
    public String l;
    public String m;
    public int n;
    public String o;
    public int p;
    public ShareSuccessReplyToServerModel q;
    public boolean r;
    public FrsBaseViewPager s;
    public FragmentAdapter t;
    public OvalActionButton u;
    public FRSRefreshButton v;
    public FrameLayout w;
    public LinearLayout x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<BaseFragment> f15856a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FrsTabController frsTabController, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15856a = new ArrayList(2);
        }

        public boolean b(int i2, BaseFragment baseFragment) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, baseFragment)) == null) ? ListUtils.add(this.f15856a, i2, baseFragment) : invokeIL.booleanValue;
        }

        public BaseFragment c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (d.a.d.e.p.k.isEmpty(str)) {
                    return null;
                }
                for (BaseFragment baseFragment : this.f15856a) {
                    if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                        return baseFragment;
                    }
                }
                return null;
            }
            return (BaseFragment) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        /* renamed from: d */
        public BaseFragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? (BaseFragment) ListUtils.getItem(this.f15856a, i2) : (BaseFragment) invokeI.objValue;
        }

        public String e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                if (getItem(i2) != null) {
                    return getItem(i2).getBaseTag();
                }
                return null;
            }
            return (String) invokeI.objValue;
        }

        public BaseFragment f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (BaseFragment) ListUtils.remove(this.f15856a, i2) : (BaseFragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15856a.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                return -2;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15857a;

        /* renamed from: com.baidu.tieba.frs.gametab.FrsTabController$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0200a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f15858e;

            public View$OnClickListenerC0200a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15858e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f15858e.f15857a.f15854h.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.q0.h3.h0.m(this.f15858e.f15857a.f15851e, "RecommendHistoryPage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15857a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof FrsRecommendResMsg)) {
                if (httpResponsedMessage.getError() == 0) {
                    FrsRecommendResMsg frsRecommendResMsg = (FrsRecommendResMsg) httpResponsedMessage;
                    int pushStatus = frsRecommendResMsg.getPushStatus();
                    String pushMsg = frsRecommendResMsg.getPushMsg();
                    if (pushStatus == 1) {
                        ScreenTopToast screenTopToast = new ScreenTopToast(this.f15857a.f15851e);
                        screenTopToast.m(this.f15857a.f15851e.getString(R.string.frs_recommend_suc_tip_title));
                        screenTopToast.l(this.f15857a.f15851e.getString(R.string.frs_recommend_suc_tip_content));
                        screenTopToast.k(this.f15857a.f15851e.getString(R.string.dialog_confirm_see));
                        screenTopToast.j(new View$OnClickListenerC0200a(this));
                        screenTopToast.n((ViewGroup) this.f15857a.f15851e.findViewById(R.id.frs));
                        return;
                    }
                    BdTopToast bdTopToast = new BdTopToast(this.f15857a.f15851e);
                    bdTopToast.i(false);
                    bdTopToast.h(pushMsg);
                    bdTopToast.j((ViewGroup) this.f15857a.f15851e.findViewById(R.id.frs));
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.f15857a.f15851e);
                bdTopToast2.i(false);
                bdTopToast2.h(httpResponsedMessage.getErrorString());
                bdTopToast2.j((ViewGroup) this.f15857a.f15851e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15859a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15859a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.f15859a.j && this.f15859a.f15854h == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.q0.h3.m)) {
                d.a.q0.h3.m mVar = (d.a.q0.h3.m) customResponsedMessage.getData();
                if (mVar.getForum() == null || this.f15859a.l == null || !this.f15859a.l.equals(mVar.getForum().getName())) {
                    return;
                }
                this.f15859a.o0(mVar, false, -1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15860a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15860a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f15860a.r = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15861a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15861a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f15861a.J();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15862a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15862a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f15862a.s == null || this.f15862a.t == null || !(customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                return;
            }
            FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
            this.f15862a.y = aVar.a();
            this.f15862a.z = aVar.b();
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15863a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15863a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int R;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (10001 == intValue) {
                R = this.f15863a.R(9);
                if (R == -1) {
                    R = this.f15863a.R(2);
                }
            } else {
                R = this.f15863a.R(intValue);
            }
            if (R == -1 || !this.f15863a.a0() || this.f15863a.f15853g == null) {
                return;
            }
            this.f15863a.f15853g.u1(R);
            if (this.f15863a.Q(R) != 1) {
                this.f15863a.f15852f.p3(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15864a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15864a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f15864a.s == null || this.f15864a.t == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f15864a.s.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    public class d0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15865a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15865a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<d.a.q0.u0.w1.a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.f15865a.f15853g == null) {
                    return;
                }
                for (d.a.q0.u0.w1.a aVar : newNotifyData) {
                    if (aVar != null) {
                        for (int i3 = 0; i3 < this.f15865a.f15855i.g().size(); i3++) {
                            FragmentTabHost.b m1 = this.f15865a.f15853g.m1(i3);
                            if (m1 != null && (i2 = m1.f12393a) != 1 && i2 != this.f15865a.f15853g.f1() && m1.f12393a == aVar.a() && aVar.b() && m1.f12394b.d(String.valueOf(m1.f12393a)) != null) {
                                m1.f12394b.d(String.valueOf(m1.f12393a)).f13164a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15866a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15866a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f15866a.M(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15867a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15867a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.f15867a.f15851e, 2000);
                bdTopToast.i(false);
                bdTopToast.h(this.f15867a.f15851e.getString(R.string.frs_top_forum_rules_click_toast));
                bdTopToast.j((ViewGroup) this.f15867a.f15851e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15868a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15868a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f15868a.E == null || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ForumData) {
                this.f15868a.M((ForumData) customResponsedMessage.getData());
            } else if (customResponsedMessage.getData() instanceof Long) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.f15868a.b0(longValue) && this.f15868a.E.a(longValue) >= 3) {
                    this.f15868a.E.b(longValue);
                    this.f15868a.H = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15869e;

        public f0(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15869e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.d.e.m.e.a().removeCallbacks(this);
                this.f15869e.c0();
                d.a.d.e.m.e.a().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15870a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15870a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.q0.h3.q0.k)) {
                d.a.q0.h3.q0.k kVar = (d.a.q0.h3.q0.k) customResponsedMessage.getData();
                if (this.f15870a.E == null || kVar == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.f15870a.E.c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(kVar.f58818a));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15871a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15871a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.f15871a.J = booleanValue;
                if (booleanValue) {
                    this.f15871a.u.setVisibility(8);
                } else {
                    this.f15871a.u.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15872a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15872a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof d.a.q0.u0.k2.a) || ((d.a.q0.u0.k2.a) customResponsedMessage.getData()).f63652a == null) {
                this.f15872a.w.removeAllViews();
                this.f15872a.w.setVisibility(8);
                return;
            }
            View view = ((d.a.q0.u0.k2.a) customResponsedMessage.getData()).f63652a;
            if (view.getParent() != null) {
                if (((ViewGroup) view.getParent()) != this.f15872a.w) {
                    ((ViewGroup) view.getParent()).removeView(view);
                    this.f15872a.w.removeAllViews();
                    this.f15872a.w.addView(view);
                }
            } else {
                this.f15872a.w.removeAllViews();
                this.f15872a.w.addView(view);
            }
            this.f15872a.w.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15873e;

        public j(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15873e = frsTabController;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0) {
                this.f15873e.z = false;
                this.f15873e.s.setForceIntercept(false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 == 1) {
                return;
            }
            this.f15873e.u.setVisibility(0);
            if (this.f15873e.O() != null) {
                this.f15873e.O().w3(false);
            }
            this.f15873e.f15852f.W3();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements FrsBaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15874a;

        public k(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15874a = frsTabController;
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15874a.s == null) {
                return;
            }
            if (this.f15874a.s.getCurrentItem() == 0) {
                this.f15874a.s.setmDisallowSlip(true);
            } else {
                this.f15874a.s.setmDisallowSlip(false);
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f15874a.s.getCurrentItem() == 0) {
                    if (this.f15874a.y && this.f15874a.z) {
                        this.f15874a.s.setmDisallowSlip(false);
                    }
                    if (!this.f15874a.z) {
                        this.f15874a.s.setmDisallowSlip(true);
                    }
                    this.f15874a.s.setmDisallowSlip(true);
                } else {
                    this.f15874a.s.setmDisallowSlip(true);
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15875a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f15876e;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15876e = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f15876e.f15875a.f15854h.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.q0.h3.h0.m(this.f15876e.f15875a.f15851e, "ForumGradePage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15875a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ScreenTopToast screenTopToast = new ScreenTopToast(this.f15875a.f15851e);
                screenTopToast.m(this.f15875a.f15851e.getString(R.string.frs_recommend_fail_month_tip));
                screenTopToast.k(this.f15875a.f15851e.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.f15875a.f15851e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15877e;

        public m(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15877e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15877e.u0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15878e;

        public n(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15878e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FrsTabController frsTabController = this.f15878e;
                boolean K = frsTabController.K(frsTabController.f15854h.getGameTabInfo());
                if (K) {
                    this.f15878e.t.notifyDataSetChanged();
                    if (K && this.f15878e.f15853g != null) {
                        this.f15878e.f15853g.w1(this.f15878e.f15852f);
                        this.f15878e.f15853g.t1(this.f15878e.f15854h, this.f15878e.f15855i);
                    }
                }
                if (this.f15878e.f15851e.isLoadingViewAttached()) {
                    this.f15878e.f15851e.hideLoadingView(this.f15878e.f15851e.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15879e;

        public o(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15879e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15879e.f15852f.O = true;
                this.f15879e.X(this.f15879e.f15852f != null ? this.f15879e.f15852f.getArguments() : null);
                this.f15879e.t.notifyDataSetChanged();
                if (this.f15879e.f15851e.isLoadingViewAttached()) {
                    this.f15879e.f15851e.hideLoadingView(this.f15879e.f15851e.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f15880e;

        public p(FrsTabController frsTabController, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15880e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.p0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f15880e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f15881e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15882f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f15883g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15884h;

        public q(FrsTabController frsTabController, d.a.p0.s.s.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, aVar, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15884h = frsTabController;
            this.f15881e = aVar;
            this.f15882f = i2;
            this.f15883g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.p0.s.s.a aVar = this.f15881e;
                if (aVar != null) {
                    aVar.dismiss();
                }
                int i2 = this.f15882f;
                if (i2 == 1) {
                    UrlManager.getInstance().dealOneLink(this.f15884h.f15851e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + this.f15884h.O().g() + "&fid=" + this.f15884h.O().h()});
                } else if (i2 == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.f15884h.O().h());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.q0.h3.h0.m(this.f15884h.f15851e, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i2 != 3 || TextUtils.isEmpty(this.f15883g)) {
                } else {
                    UrlManager.getInstance().dealOneLink(this.f15884h.f15851e.getPageContext(), new String[]{this.f15883g});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f15885e;

        public r(FrsTabController frsTabController, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15885e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f15885e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15886a;

        /* loaded from: classes4.dex */
        public class a extends d.a.p0.g0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ s f15887a;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15887a = sVar;
            }

            @Override // d.a.p0.g0.b
            public d.a.p0.g0.c createFragmentTabStructure() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.f15887a.f15886a.f15852f.g());
                    bundle.putString("from", this.f15887a.f15886a.f15852f.A2());
                    bundle.putString("forum_id", this.f15887a.f15886a.f15852f.h());
                    bundle.putInt("tab_id", 503);
                    bundle.putBoolean("can_auto_play_video", this.f15887a.f15886a.f15854h.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", this.f15887a.f15886a.f15854h.needLog == 1);
                    bundle.putBoolean("is_brand_forum", this.f15887a.f15886a.f15854h.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.f15887a.f15886a.f15854h);
                    bundle.putSerializable("view_data", frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    d.a.p0.g0.c cVar = new d.a.p0.g0.c();
                    cVar.f52618a = frsSportsRecommendFragment;
                    cVar.f52622e = 25;
                    cVar.f52626i = d.a.p0.g0.c.k;
                    return cVar;
                }
                return (d.a.p0.g0.c) invokeV.objValue;
            }

            @Override // d.a.p0.g0.b
            public TbFragmentTabIndicator getTabIndicator(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                    this.mIndicator = fragmentTabIndicator;
                    fragmentTabIndicator.setTextSize(2.0f);
                    return this.mIndicator;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // d.a.p0.g0.b
            public boolean isAvailable() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15886a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i0)) {
                if (!d.a.p0.s.d0.b.j().g(this.f15886a.o, true)) {
                    d.a.d.e.m.e.a().post(this.f15886a.S);
                }
                ((i0) customResponsedMessage.getData()).a(new a(this));
                this.f15886a.Y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15888a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(FrsTabController frsTabController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2)};
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
            this.f15888a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.j(this.f15888a.f15851e, this.f15888a.f15851e.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.f15888a.f15851e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15889a;

        public u(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15889a = frsTabController;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.u(this.f15889a.f15851e, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f15889a.f15851e.findViewById(R.id.frs));
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.u(this.f15889a.f15851e, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f15889a.f15851e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15890e;

        public v(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15890e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                    parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    this.f15890e.f15851e.startActivity(parseUri);
                    TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15891a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f15892e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ w f15893f;

            public a(w wVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {wVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15893f = wVar;
                this.f15892e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15893f.f15891a.f15851e == null) {
                    return;
                }
                d.a.q0.h2.j.c.a(this.f15893f.f15891a.f15851e.getPageContext(), this.f15892e).show();
            }
        }

        public w(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15891a = frsTabController;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                d.a.d.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15894e;

        public x(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15894e = frsTabController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                new StatisticItem("c13439").eventStat();
                if (this.f15894e.O() == null || TextUtils.isEmpty(this.f15894e.O().h()) || TextUtils.isEmpty(this.f15894e.l) || this.f15894e.f15851e == null) {
                    return;
                }
                if (this.f15894e.A != null) {
                    this.f15894e.A.e();
                }
                int i2 = d.a.p0.s.d0.b.j().k("key_bawu_task_toast", 0) == -1 ? 1 : 0;
                UrlManager.getInstance().dealOneLink(this.f15894e.f15851e.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.f15894e.O().h() + "&fn=" + this.f15894e.l + "&noread=" + i2});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumData f15895e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15896f;

        public y(FrsTabController frsTabController, ForumData forumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, forumData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15896f = frsTabController;
            this.f15895e = forumData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15896f.E == null) {
                return;
            }
            if (this.f15896f.I) {
                this.f15896f.x0(this.f15895e.getName(), this.f15895e.getId(), this.f15895e.getImage_url(), true);
            } else {
                this.f15896f.H = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f15897a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(FrsTabController frsTabController, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15897a = frsTabController;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.q0.h3.m mVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f15897a.j || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                mVar = frsPageHttpResponseMessage.getResponseData();
                i2 = frsPageHttpResponseMessage.getUpdateType();
            } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                mVar = fRSPageSocketResponsedMessage.getResponseData();
                i2 = fRSPageSocketResponsedMessage.getUpdateType();
            } else {
                mVar = null;
                i2 = -1;
            }
            if (mVar != null) {
                this.f15897a.j = true;
                this.f15897a.o0(mVar, true, i2);
                if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                    d.a.p0.s.o.a.b().l("2", mVar.getForum().getId());
                }
            }
            if (mVar == null || mVar.getUserData() == null || mVar.getUserData().getNewGodData() == null) {
                return;
            }
            if (mVar.getForum() != null) {
                d.a.p0.b1.y.g().j(mVar.getForum().getId());
            }
            d.a.p0.b1.y.g().k(2, mVar.getUserData().getNewGodData());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(794554255, "Lcom/baidu/tieba/frs/gametab/FrsTabController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(794554255, "Lcom/baidu/tieba/frs/gametab/FrsTabController;");
                return;
            }
        }
        l0 = FrsFragment.class.getSimpleName();
        m0 = FrsTabHostFragment.class.getSimpleName();
    }

    public FrsTabController(FrsActivity frsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = new Handler();
        this.n = 0;
        this.r = false;
        this.B = false;
        this.C = false;
        this.H = false;
        this.I = false;
        this.K = new a(this, CmdConfigHttp.CMD_FRS_RECOMMEND);
        this.L = new l(this, 2921465);
        this.M = new z(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.N = new a0(this, 2001615);
        this.O = new b0(this, 2921342);
        this.P = new c0(this, 2001627);
        this.Q = new d0(this, 0);
        this.R = new e0(this, 2921518);
        this.S = new f0(this);
        this.T = new b(this, 2005016);
        this.U = new c(this, 2921369);
        this.V = new d(this, 2921370);
        this.W = new e(this, 2001375);
        this.X = new f(this, 2921498);
        this.Y = new g(this, 2001437);
        this.Z = new h(this, 2921586);
        this.a0 = new i(this, 2921590);
        this.b0 = new j(this);
        this.c0 = new k(this);
        this.i0 = new t(this, 2001440);
        this.j0 = new u(this);
        this.k0 = new v(this);
        this.f15851e = frsActivity;
        this.o = d.a.p0.s.d0.b.n("show_game_forem_tab_hot_point");
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.p != this.n && a0()) {
                this.f15853g.u1(this.n);
                if (Q(this.n) != 1) {
                    this.f15852f.p3(false);
                }
                this.p = this.n;
                t0(this.f15853g.e1(), this.n);
                return;
            }
            this.f15852f.q2();
        }
    }

    public final boolean K(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (this.f15851e.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.f15851e;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (a0()) {
                return false;
            }
            this.f15852f.O = true;
            q0();
            if (d.a.p0.s.d0.b.j().g("frs_game_login_tip", true)) {
                d.a.p0.s.d0.b.j().t("frs_login_tip", true);
                d.a.p0.s.d0.b.j().t("frs_game_login_tip", false);
            }
            Z(list);
            if (this.f15852f.K2() != null) {
                this.f15852f.K2().S(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void L(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData) == null) {
            boolean z2 = false;
            if (x0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
                if (this.F != null) {
                    d.a.d.e.m.e.a().removeCallbacks(this.F);
                }
                z2 = true;
            }
            if (!this.G) {
                this.E.e().h(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
                this.G = true;
            }
            if (z2) {
                return;
            }
            Runnable runnable = this.F;
            if (runnable == null) {
                runnable = new y(this, forumData);
            }
            this.F = runnable;
            d.a.d.e.m.e.a().postDelayed(this.F, 60000L);
        }
    }

    public final void M(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, forumData) == null) || this.f15852f.R() == null || this.E == null) {
            return;
        }
        if (forumData == null) {
            forumData = this.f15854h.getForum();
        }
        if (forumData == null || forumData.isLike() == 1) {
            return;
        }
        if (!this.I) {
            this.H = true;
        } else if (!x0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) || this.F == null) {
        } else {
            d.a.d.e.m.e.a().removeCallbacks(this.F);
        }
    }

    public final FragmentManager N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsActivity frsActivity = this.f15851e;
            if (frsActivity != null) {
                return frsActivity.getSupportFragmentManager();
            }
            return null;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public FrsFragment O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15852f : (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.f15853g;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.i1();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public final int Q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            i0 i0Var = this.f15855i;
            if (i0Var != null && i2 < ListUtils.getCount(i0Var.g())) {
                return this.f15855i.g().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            i0 i0Var = this.f15855i;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.g());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f15855i.g().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public TbPageTag S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!a0()) {
                return this.f15852f.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.f15853g;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.f1()) {
                    return this.f15852f.getTbPageTag();
                }
                Fragment e1 = this.f15853g.e1();
                if (e1 instanceof BaseFragment) {
                    return ((BaseFragment) e1).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public d.a.q0.h3.m T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f15854h : (d.a.q0.h3.m) invokeV.objValue;
    }

    public final boolean U(d.a.q0.h3.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mVar)) == null) {
            if (mVar != null && mVar.getUserData() != null) {
                int is_manager = mVar.getUserData().getIs_manager();
                boolean g2 = d.a.p0.s.d0.b.j().g("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !g2) {
                    w0(1, this.f15851e.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
                    d.a.p0.s.d0.b.j().t("key_forum_tool_find_dialog_show", true);
                    return true;
                } else if (!g2 && is_manager == 2) {
                    w0(2, this.f15851e.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
                    d.a.p0.s.d0.b.j().t("key_forum_tool_find_dialog_show", true);
                    return true;
                } else {
                    AddBawuPopInfo addBawuPopInfo = mVar.bawuPopInfo;
                    if (addBawuPopInfo != null) {
                        w0(3, addBawuPopInfo.content, addBawuPopInfo.img_url, addBawuPopInfo.jump_url);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean V(ForumData forumData, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, forumData, antiData)) == null) {
            if (forumData == null) {
                return false;
            }
            if (d.a.p0.e1.b.a.g(this.f15851e.getPageContext(), antiData, R.id.frs) || y0(forumData)) {
                return true;
            }
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (ListUtils.isEmpty(tipInfos)) {
                return false;
            }
            return d.a.p0.e1.b.a.f(this.f15851e.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.f15851e.getString(R.string.frs_risk_dialog_button_text));
        }
        return invokeLL.booleanValue;
    }

    public void W(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) || (frsActivity = this.f15851e) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.frs_base_layout);
        this.s = (FrsBaseViewPager) this.f15851e.findViewById(R.id.frs_base_viewpager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this, this.f15851e.getSupportFragmentManager());
        this.t = fragmentAdapter;
        this.s.setAdapter(fragmentAdapter);
        this.s.setPageTransformer(true, new CubeOutViewPagerTransformer());
        this.s.addOnPageChangeListener(this.b0);
        this.s.setmDisallowSlip(true);
        this.s.setOnTouchEventListener(this.c0);
        OvalActionButton ovalActionButton = (OvalActionButton) this.f15851e.findViewById(R.id.frs_post_forum_button);
        this.u = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.u.setHasShadow(false);
        this.w = (FrameLayout) this.f15851e.findViewById(R.id.frs_bottom_extra);
        this.v = (FRSRefreshButton) this.f15851e.findViewById(R.id.frs_refresh_forum_button);
        this.x = (LinearLayout) this.f15851e.findViewById(R.id.frs_ll_redpack);
        this.f15851e.registerListener(this.U);
        this.f15851e.registerListener(this.V);
        this.M.getHttpMessageListener().setPriority(-1);
        this.M.getSocketMessageListener().setPriority(-1);
        this.f15851e.registerListener(this.N);
        this.P.setSelfListener(true);
        this.f15851e.registerListener(this.P);
        this.O.setSelfListener(true);
        this.f15851e.registerListener(this.O);
        this.f15851e.registerListener(this.T);
        if (bundle == null) {
            this.l = this.f15851e.getIntent().getStringExtra("name");
            this.m = this.f15851e.getIntent().getStringExtra("from");
            this.n = this.f15851e.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.l = bundle.getString("name");
            this.m = bundle.getString("from");
            this.n = bundle.getInt("default_tab_id", 0);
        }
        X(bundle);
        this.t.notifyDataSetChanged();
        this.q = new ShareSuccessReplyToServerModel();
        this.f15851e.registerListener(this.M);
        this.f15851e.registerListener(this.K);
        this.f15851e.registerListener(this.L);
        this.f15851e.registerListener(this.R);
        this.f15851e.registerListener(this.Z);
        this.a0.setPriority(Integer.MAX_VALUE);
        this.a0.setSelfListener(true);
        this.f15851e.registerListener(this.a0);
    }

    public final void X(Bundle bundle) {
        FragmentManager N;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) || (N = N()) == null || N.isDestroyed() || (fragmentAdapter = this.t) == null) {
            return;
        }
        try {
            FrsFragment frsFragment = (FrsFragment) fragmentAdapter.c(l0);
            if (frsFragment == null) {
                frsFragment = d0(bundle);
            }
            frsFragment.C3(this.u);
            frsFragment.F3(this.v);
            frsFragment.E3(this.x);
            if (l0.equals(this.t.e(0))) {
                return;
            }
            if (m0.equals(this.t.e(0))) {
                this.t.f(0);
            }
            this.t.b(0, frsFragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Y() {
        FragmentManager N;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (N = N()) == null || N.isDestroyed() || (fragmentAdapter = this.t) == null) {
            return;
        }
        try {
            FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) fragmentAdapter.c(m0);
            if (frsTabHostFragment == null) {
                frsTabHostFragment = e0();
            }
            frsTabHostFragment.y1(this.u);
            frsTabHostFragment.x1(this.v);
            if (m0.equals(this.t.e(0))) {
                return;
            }
            if (l0.equals(this.t.e(0))) {
                this.t.f(0);
            }
            this.t.b(0, frsTabHostFragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Z(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        s sVar = new s(this, 2001616);
        sVar.setPriority(Integer.MAX_VALUE);
        sVar.setSelfListener(true);
        this.f15851e.registerListener(sVar);
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = list.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    FrsTabInfo frsTabInfo = (FrsTabInfo) it2.next();
                    if (frsTabInfo != null && frsTabInfo.tab_id == next.tab_id) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    arrayList.add(next);
                }
            }
        }
        this.f15855i = new i0(this.f15851e.getActivity(), arrayList);
        if (O() != null) {
            this.f15855i.k(O().h());
            this.f15855i.l(O().g());
            if (O().l0() != null && O().l0().getForum() != null) {
                ForumData forum = O().l0().getForum();
                this.f15855i.j(forum.getForumGameLabel());
                this.f15855i.m(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.f15852f;
        frsFragment.O = false;
        new d.a.q0.u0.w1.e(frsFragment).a(this.f15855i);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.f15855i);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.f15851e.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FragmentAdapter fragmentAdapter = this.t;
            if (fragmentAdapter == null) {
                return false;
            }
            return fragmentAdapter.getItem(0) instanceof FrsTabHostFragment;
        }
        return invokeV.booleanValue;
    }

    public boolean b0(long j2) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
            d.a.q0.h3.m mVar = this.f15854h;
            return (mVar == null || j2 == 0 || (forum = mVar.getForum()) == null || d.a.d.e.m.b.f(forum.getId(), 0L) != j2) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    public final void c0() {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (i0Var = this.f15855i) == null || TextUtils.isEmpty(i0Var.d())) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021074);
        httpMessage.addParam("forum_id", this.f15854h.getForum().getId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final FrsFragment d0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bundle)) == null) {
            if (this.f15852f == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.f15852f = frsFragment;
                frsFragment.setArguments(bundle);
                this.f15852f.setBaseTag(l0);
            }
            FrsFragment frsFragment2 = this.f15852f;
            frsFragment2.O = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    @Override // d.a.q0.e.e.b
    public void dispatchInjectPluginMessage(d.a.q0.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) {
            FrsFragment frsFragment = this.f15852f;
            if (frsFragment instanceof d.a.q0.e.e.b) {
                frsFragment.dispatchInjectPluginMessage(dVar);
            }
        }
    }

    public final FrsTabHostFragment e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f15853g == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.f15853g = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(m0);
                this.f15853g.v1(this.n);
            }
            return this.f15853g;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public void f0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i2, i3, intent) == null) {
            if (!a0()) {
                this.f15852f.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f15853g;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.f1()) {
                        this.f15852f.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment e1 = this.f15853g.e1();
                        if (e1 != null) {
                            e1.onActivityResult(i2, i3, intent);
                        }
                    }
                }
            }
            if (i3 == -1) {
                if (i2 != 24007) {
                    if (i2 == 13011) {
                        d.a.q0.v2.a.g().m(this.f15851e.getPageContext());
                        return;
                    }
                    return;
                }
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    d.a.q0.v2.a.g().m(this.f15851e.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.q) == null) {
                        return;
                    }
                    shareSuccessReplyToServerModel.w(str, intExtra2, new w(this));
                }
            }
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1 && skinType != 4) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.f15851e);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.f15851e);
            }
            FrsFragment frsFragment = this.f15852f;
            if (frsFragment != null) {
                frsFragment.onChangeSkinType(i2);
            }
            FrsTabHostFragment frsTabHostFragment = this.f15853g;
            if (frsTabHostFragment != null) {
                frsTabHostFragment.onChangeSkinType(i2);
            }
            p0();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.a.d.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (!a0()) {
                FrsFragment frsFragment = this.f15852f;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).getFrsCommonImageLayoutPool();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f15853g;
                if (frsTabHostFragment == null) {
                    return null;
                }
                Fragment e1 = frsTabHostFragment.e1();
                if (e1 instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) e1).getFrsCommonImageLayoutPool();
                }
            }
            return null;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    @Override // d.a.q0.e.e.b
    public d.a.q0.e.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            FrsFragment frsFragment = this.f15852f;
            if (frsFragment instanceof d.a.q0.e.e.b) {
                return frsFragment.getInjectPlugin(i2);
            }
            return null;
        }
        return (d.a.q0.e.e.a) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (!a0()) {
                return this.f15852f.getVoiceManager();
            }
            FrsTabHostFragment frsTabHostFragment = this.f15853g;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment e1 = frsTabHostFragment.e1();
            if (e1 instanceof VoiceManager.j) {
                return ((VoiceManager.j) e1).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void h0() {
        d.a.q0.u0.n2.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.j);
            this.k.removeCallbacksAndMessages(null);
            if (this.f15851e.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.f15851e;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.S != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.S);
            }
            d.a.p0.s.d0.b.j().t(this.o, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.q;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.f15852f;
            if (frsFragment != null && frsFragment.g0() != null) {
                this.f15852f.g0().D0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.A;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.m)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.m)) {
                d.a.p0.y.d.h().i(false);
            }
            if (this.F != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.F);
            }
            d.a.q0.h3.m mVar = this.f15854h;
            if (mVar != null && mVar.getForum() != null && (eVar = this.E) != null) {
                eVar.b(d.a.d.e.m.b.f(this.f15854h.getForum().getId(), 0L));
            }
            d.a.d.e.m.e.a().removeCallbacks(this.k0);
        }
    }

    public boolean i0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    FrsFragment frsFragment = this.f15852f;
                    if (frsFragment == null || !frsFragment.isAdded()) {
                        return false;
                    }
                    return this.f15852f.onKeyDown(i2, keyEvent);
                }
                return this.f15851e.onSuperKeyDown(i2, keyEvent);
            } else if (this.J) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                return false;
            } else if (a0() && (frsTabHostFragment = this.f15853g) != null && frsTabHostFragment.p1()) {
                this.f15853g.o1();
                UtilHelper.setNavigationBarBackground(this.f15851e, this.f15853g.d1());
                return false;
            } else {
                FrsFragment frsFragment2 = this.f15852f;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    if (this.f15852f.onKeyDown(i2, keyEvent)) {
                        return true;
                    }
                    J();
                    return false;
                }
                return this.f15851e.onSuperKeyDown(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void j0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, intent) == null) || (frsFragment = this.f15852f) == null) {
            return;
        }
        frsFragment.onNewIntent(intent);
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.I = false;
            d.a.q0.u0.n2.e eVar = this.E;
            if (eVar != null) {
                eVar.d();
            }
            if (!a0()) {
                this.f15852f.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f15853g;
                if (frsTabHostFragment != null) {
                    Fragment e1 = frsTabHostFragment.e1();
                    if (e1 instanceof BaseFragment) {
                        ((BaseFragment) e1).setPrimary(false);
                    }
                }
            }
            d.a.p0.b1.y.g().i();
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                d.a.d.e.m.e.a().postDelayed(this.k0, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.i0);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (!a0()) {
                this.f15852f.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f15853g;
                if (frsTabHostFragment != null) {
                    Fragment e1 = frsTabHostFragment.e1();
                    if (e1 instanceof BaseFragment) {
                        ((BaseFragment) e1).setPrimary(true);
                    }
                }
            }
            if (this.r) {
                this.r = false;
                FrsFragment frsFragment = this.f15852f;
                if (frsFragment != null) {
                    frsFragment.refresh();
                }
            }
            d.a.q0.h3.m mVar = this.f15854h;
            if (mVar != null && mVar.getUserData() != null && this.f15854h.getUserData().getNewGodData() != null) {
                if (this.f15854h.getForum() != null) {
                    d.a.p0.b1.y.g().j(this.f15854h.getForum().getId());
                }
                d.a.p0.b1.y.g().k(2, this.f15854h.getUserData().getNewGodData());
            }
            this.I = true;
            if (this.H) {
                M(null);
            }
            ItemCardHelper.s(this.j0);
            MessageManager.getInstance().registerListener(this.i0);
        }
    }

    public void m0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            bundle.putString("name", this.l);
            bundle.putInt("default_tab_id", this.n);
            bundle.putString("from", this.m);
        }
    }

    public void n0(String str) {
        d.a.q0.h3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || (mVar = this.f15854h) == null || mVar.getForum() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f15854h.getForum().getId()).param("obj_type", 2));
    }

    public final void o0(d.a.q0.h3.m mVar, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{mVar, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || mVar == null || mVar.getForum() == null) {
            return;
        }
        this.f15854h = mVar;
        ForumData forum = mVar.getForum();
        if (!U(mVar)) {
            if (z2) {
                boolean V = V(forum, mVar.getAnti());
                FrsFragment frsFragment = this.f15852f;
                if (frsFragment != null) {
                    frsFragment.D3(V);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
        }
        if (forum.getIsShowBawuTask() && d.a.p0.s.d0.b.j().k("key_bawu_task_toast", 0) == 0 && !this.B) {
            this.B = true;
            d.a.d.e.m.e.a().postDelayed(new m(this), 30000L);
        }
        if (mVar.bazhuExam != null && !this.C && z2) {
            d.a.q0.u0.m.a(this.f15851e.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
            this.C = true;
        }
        if (ListUtils.getCount(mVar.getGameTabInfo()) > 0) {
            this.k.post(new n(this));
        } else if (a0()) {
            this.k.post(new o(this));
        }
        p0();
        v0();
        if (z2) {
            if ((!this.G || i2 == 4) && forum.isLike() == 0 && d.a.p0.b.d.m0() && TbadkCoreApplication.isLogin()) {
                this.E = new d.a.q0.u0.n2.e();
                this.f15851e.registerListener(this.X);
                this.f15851e.registerListener(this.W);
                this.f15851e.registerListener(this.Y);
                L(forum);
            }
        }
    }

    public final void p0() {
        d.a.q0.h3.m mVar;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (mVar = this.f15854h) == null || (themeColorInfo = mVar.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 4) {
            themeElement = themeColorInfo.dark;
        } else if (skinType == 1) {
            themeElement = themeColorInfo.night;
        } else {
            themeElement = themeColorInfo.day;
        }
        this.u.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921571, themeElement));
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.f15851e.registerListener(1021074, this.Q);
        }
    }

    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.n = i2;
        }
    }

    public void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.p = i2;
        }
    }

    @Override // d.a.q0.e.e.b
    public void setInjectPlugin(int i2, d.a.q0.e.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048617, this, i2, aVar) == null) {
            FrsFragment frsFragment = this.f15852f;
            if (frsFragment instanceof d.a.q0.e.e.b) {
                frsFragment.setInjectPlugin(i2, aVar);
            }
        }
    }

    public final void t0(Fragment fragment, int i2) {
        d.a.q0.h3.m mVar;
        NavigationBar j0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048618, this, fragment, i2) == null) || !(fragment instanceof q0) || (mVar = this.f15854h) == null || mVar.getForum() == null || (j0 = ((q0) fragment).j0()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f15854h.getForum().getName(), 5, true, true) + this.f15851e.getActivity().getString(R.string.forum));
        j0.setCenterTextTitle(sb.toString());
    }

    public final void u0() {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (frsActivity = this.f15851e) == null) {
            return;
        }
        if (this.A == null) {
            this.A = (NavigationBarCoverTip) frsActivity.findViewById(R.id.navigation_cover_tip);
        }
        if (this.A == null) {
            return;
        }
        View inflate = View.inflate(this.f15851e, R.layout.write_thread_share_guide, null);
        TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.share_icon);
        if (TextUtils.isEmpty(this.l)) {
            textView.setText("吧主您好，本吧考核新制度上线啦");
        } else {
            textView.setText(this.l + "吧吧主您好，本吧考核新制度上线啦");
        }
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
        d.a.p0.s.f0.n.c cVar = new d.a.p0.s.f0.n.c();
        cVar.r();
        tBSpecificationBtn.setConfig(cVar);
        tBSpecificationBtn.k();
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.A, R.color.cp_link_tip_a_alpha95);
        tBSpecificationBtn.setOnClickListener(new x(this));
        this.A.m(this.f15851e, inflate, 30000);
        new StatisticItem("c13438").eventStat();
        int k2 = d.a.p0.s.d0.b.j().k("key_bawu_task_toast", 0);
        if (k2 >= 0) {
            d.a.p0.s.d0.b.j().v("key_bawu_task_toast", k2 + 1);
        }
    }

    public final void v0() {
        d.a.q0.h3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (mVar = this.f15854h) == null || mVar.getEntelechyTabInfo() == null || this.f15854h.getEntelechyTabInfo().tab == null) {
            return;
        }
        if (this.f15851e.getIntent() == null || !FrsActivityConfig.FRS_FROM_ITEM.equals(this.f15851e.getIntent().getStringExtra("from"))) {
            boolean z2 = false;
            Iterator<FrsTabInfo> it = this.f15854h.getEntelechyTabInfo().tab.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().tab_type.intValue() == 16) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                if (this.D == null) {
                    d.a.q0.e0.e eVar = new d.a.q0.e0.e(this.f15851e.getPageContext(), this.u);
                    this.D = eVar;
                    eVar.g0(R.drawable.pic_sign_tip_down);
                    this.D.L(2);
                    this.D.h0(true);
                    this.D.j0(-d.a.d.e.p.l.g(this.f15851e, R.dimen.tbds20));
                    this.D.k0(-d.a.d.e.p.l.g(this.f15851e, R.dimen.tbds20));
                    this.D.X(R.color.CAM_X0101);
                    this.D.P(R.dimen.tbds54);
                    this.D.a0(d.a.d.e.p.l.g(this.f15851e, R.dimen.tbds44));
                }
                this.D.m0(this.f15851e.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    public final void w0(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f15851e);
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.f15851e);
            frsForumToolDialogView.setStartLoadUrl(i2, str2);
            frsForumToolDialogView.setContent(str);
            frsForumToolDialogView.setCancleButtonListener(new p(this, aVar));
            frsForumToolDialogView.setConfirmButtonListener(new q(this, aVar, i2, str3));
            aVar.setContentView(frsForumToolDialogView);
            aVar.create(this.f15851e.getPageContext()).show();
        }
    }

    public final boolean x0(String str, String str2, String str3, boolean z2) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{str, str2, str3, Boolean.valueOf(z2)})) == null) {
            if (!this.E.g(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.f15852f) == null || frsFragment.R() == null) {
                return false;
            }
            this.H = false;
            this.E.h(this.f15851e, str, str2, str3, this.f15852f.R().x());
            this.E.e().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean y0(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, forumData)) == null) {
            if (d.a.d.e.p.k.isEmpty(forumData.getRiskTipPop()) || d.a.d.e.p.k.isEmpty(forumData.getRiskTipPopTitle())) {
                return false;
            }
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f15851e);
            aVar.setTitle(forumData.getRiskTipPopTitle());
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setMessage(forumData.getRiskTipPop());
            aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new r(this, aVar));
            aVar.create(this.f15851e.getPageContext()).show();
            return true;
        }
        return invokeL.booleanValue;
    }
}
