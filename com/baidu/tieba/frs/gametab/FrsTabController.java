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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.a.r0.x0.i0;
import c.a.r0.x0.q0;
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
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
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
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddBawuPopInfo;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class FrsTabController implements c.a.r0.g.e.b, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String l0;
    public static final String m0;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBarCoverTip A;
    public boolean B;
    public boolean C;
    public c.a.r0.f0.e D;
    public c.a.r0.x0.n2.e E;
    public Runnable F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public HttpMessageListener K;
    public CustomMessageListener L;
    public c.a.e.c.g.a M;
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
    public FrsActivity f51336e;

    /* renamed from: f  reason: collision with root package name */
    public FrsFragment f51337f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabHostFragment f51338g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.k3.m f51339h;

    /* renamed from: i  reason: collision with root package name */
    public i0 f51340i;
    public CustomMessageListener i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f51341j;
    public final ItemCardHelper.c j0;
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

    /* loaded from: classes7.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<BaseFragment> f51342a;

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
            this.f51342a = new ArrayList(2);
        }

        public boolean add(BaseFragment baseFragment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragment)) == null) ? ListUtils.add(this.f51342a, baseFragment) : invokeL.booleanValue;
        }

        public BaseFragment findFragmentByTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (c.a.e.e.p.k.isEmpty(str)) {
                    return null;
                }
                for (BaseFragment baseFragment : this.f51342a) {
                    if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                        return baseFragment;
                    }
                }
                return null;
            }
            return (BaseFragment) invokeL.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51342a.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                return -2;
            }
            return invokeL.intValue;
        }

        public String getItemTag(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                if (getItem(i2) != null) {
                    return getItem(i2).getBaseTag();
                }
                return null;
            }
            return (String) invokeI.objValue;
        }

        public BaseFragment remove(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (BaseFragment) ListUtils.remove(this.f51342a, i2) : (BaseFragment) invokeI.objValue;
        }

        public BaseFragment removeFragmentByTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                if (c.a.e.e.p.k.isEmpty(str)) {
                    return null;
                }
                Iterator<BaseFragment> it = this.f51342a.iterator();
                while (it.hasNext()) {
                    BaseFragment next = it.next();
                    if (next != null && str.equals(next)) {
                        it.remove();
                        return next;
                    }
                }
                return null;
            }
            return (BaseFragment) invokeL.objValue;
        }

        public boolean add(int i2, BaseFragment baseFragment) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, baseFragment)) == null) ? ListUtils.add(this.f51342a, i2, baseFragment) : invokeIL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public BaseFragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (BaseFragment) ListUtils.getItem(this.f51342a, i2) : (BaseFragment) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51343a;

        /* renamed from: com.baidu.tieba.frs.gametab.FrsTabController$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1763a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f51344e;

            public View$OnClickListenerC1763a(a aVar) {
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
                this.f51344e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f51344e.f51343a.f51339h.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.r0.k3.i0.n(this.f51344e.f51343a.f51336e, "RecommendHistoryPage", hashMap)));
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
            this.f51343a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof FrsRecommendResMsg)) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(this.f51343a.f51336e).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show((ViewGroup) this.f51343a.f51336e.findViewById(R.id.frs));
                    return;
                }
                FrsRecommendResMsg frsRecommendResMsg = (FrsRecommendResMsg) httpResponsedMessage;
                int pushStatus = frsRecommendResMsg.getPushStatus();
                String pushMsg = frsRecommendResMsg.getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(this.f51343a.f51336e).setTitle(this.f51343a.f51336e.getString(R.string.frs_recommend_suc_tip_title)).setContent(this.f51343a.f51336e.getString(R.string.frs_recommend_suc_tip_content)).setBtnText(this.f51343a.f51336e.getString(R.string.dialog_confirm_see)).setBtnClickListener(new View$OnClickListenerC1763a(this)).show((ViewGroup) this.f51343a.f51336e.findViewById(R.id.frs));
                } else {
                    new BdTopToast(this.f51343a.f51336e).setIcon(false).setContent(pushMsg).show((ViewGroup) this.f51343a.f51336e.findViewById(R.id.frs));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51345a;

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
            this.f51345a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.f51345a.f51341j && this.f51345a.f51339h == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.k3.m)) {
                c.a.r0.k3.m mVar = (c.a.r0.k3.m) customResponsedMessage.getData();
                if (mVar.getForum() == null || this.f51345a.l == null || !this.f51345a.l.equals(mVar.getForum().getName())) {
                    return;
                }
                this.f51345a.o0(mVar, false, -1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51346a;

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
            this.f51346a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f51346a.r = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51347a;

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
            this.f51347a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f51347a.J();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51348a;

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
            this.f51348a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f51348a.s == null || this.f51348a.t == null || !(customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                return;
            }
            FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
            this.f51348a.y = aVar.a();
            this.f51348a.z = aVar.b();
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51349a;

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
            this.f51349a = frsTabController;
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
                R = this.f51349a.R(9);
                if (R == -1) {
                    R = this.f51349a.R(2);
                }
            } else {
                R = this.f51349a.R(intValue);
            }
            if (R == -1 || !this.f51349a.a0() || this.f51349a.f51338g == null) {
                return;
            }
            this.f51349a.f51338g.setCurrentTab(R);
            if (this.f51349a.Q(R) != 1) {
                this.f51349a.f51337f.setCanShowSpeedTipView(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51350a;

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
            this.f51350a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f51350a.s == null || this.f51350a.t == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f51350a.s.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes7.dex */
    public class d0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51351a;

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
            this.f51351a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<c.a.r0.x0.x1.a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.f51351a.f51338g == null) {
                    return;
                }
                for (c.a.r0.x0.x1.a aVar : newNotifyData) {
                    if (aVar != null) {
                        for (int i3 = 0; i3 < this.f51351a.f51340i.g().size(); i3++) {
                            FragmentTabHost.b tabSpec = this.f51351a.f51338g.getTabSpec(i3);
                            if (tabSpec != null && (i2 = tabSpec.f47589a) != 1 && i2 != this.f51351a.f51338g.getCurrentTabType() && tabSpec.f47589a == aVar.a() && aVar.b() && tabSpec.f47590b.getTip(String.valueOf(tabSpec.f47589a)) != null) {
                                tabSpec.f47590b.getTip(String.valueOf(tabSpec.f47589a)).f48445a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51352a;

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
            this.f51352a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f51352a.M(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51353a;

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
            this.f51353a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.f51353a.f51336e, 2000).setIcon(false).setContent(this.f51353a.f51336e.getString(R.string.frs_top_forum_rules_click_toast)).show((ViewGroup) this.f51353a.f51336e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51354a;

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
            this.f51354a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f51354a.E == null || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ForumData) {
                this.f51354a.M((ForumData) customResponsedMessage.getData());
            } else if (customResponsedMessage.getData() instanceof Long) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.f51354a.b0(longValue) && this.f51354a.E.a(longValue) >= 3) {
                    this.f51354a.E.b(longValue);
                    this.f51354a.H = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51355e;

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
            this.f51355e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this);
                this.f51355e.c0();
                c.a.e.e.m.e.a().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51356a;

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
            this.f51356a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.k3.r0.k)) {
                c.a.r0.k3.r0.k kVar = (c.a.r0.k3.r0.k) customResponsedMessage.getData();
                if (this.f51356a.E == null || kVar == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.f51356a.E.c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(kVar.f21309a));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51357a;

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
            this.f51357a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.f51357a.J = booleanValue;
                if (booleanValue) {
                    this.f51357a.u.setVisibility(8);
                } else {
                    this.f51357a.u.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51358a;

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
            this.f51358a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof c.a.r0.x0.l2.a) || ((c.a.r0.x0.l2.a) customResponsedMessage.getData()).f27192a == null) {
                this.f51358a.w.removeAllViews();
                this.f51358a.w.setVisibility(8);
                return;
            }
            View view = ((c.a.r0.x0.l2.a) customResponsedMessage.getData()).f27192a;
            if (view.getParent() != null) {
                if (((ViewGroup) view.getParent()) != this.f51358a.w) {
                    ((ViewGroup) view.getParent()).removeView(view);
                    this.f51358a.w.removeAllViews();
                    this.f51358a.w.addView(view);
                }
            } else {
                this.f51358a.w.removeAllViews();
                this.f51358a.w.addView(view);
            }
            this.f51358a.w.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public class j implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51359e;

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
            this.f51359e = frsTabController;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0) {
                this.f51359e.z = false;
                this.f51359e.s.setForceIntercept(false);
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
            this.f51359e.u.setVisibility(0);
            if (this.f51359e.O() != null) {
                this.f51359e.O().setLiteProgramListFragmentSelect(false);
            }
            this.f51359e.f51337f.showRefreshIcon();
        }
    }

    /* loaded from: classes7.dex */
    public class k implements FrsBaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51360a;

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
            this.f51360a = frsTabController;
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51360a.s == null) {
                return;
            }
            if (this.f51360a.s.getCurrentItem() == 0) {
                this.f51360a.s.setmDisallowSlip(true);
            } else {
                this.f51360a.s.setmDisallowSlip(false);
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f51360a.s.getCurrentItem() == 0) {
                    if (this.f51360a.y && this.f51360a.z) {
                        this.f51360a.s.setmDisallowSlip(false);
                    }
                    if (!this.f51360a.z) {
                        this.f51360a.s.setmDisallowSlip(true);
                    }
                    this.f51360a.s.setmDisallowSlip(true);
                } else {
                    this.f51360a.s.setmDisallowSlip(true);
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51361a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f51362e;

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
                this.f51362e = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f51362e.f51361a.f51339h.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.r0.k3.i0.n(this.f51362e.f51361a.f51336e, "ForumGradePage", hashMap)));
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
            this.f51361a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new ScreenTopToast(this.f51361a.f51336e).setTitle(this.f51361a.f51336e.getString(R.string.frs_recommend_fail_month_tip)).setBtnText(this.f51361a.f51336e.getString(R.string.frs_recommend_fail_tip_btn)).setBtnClickListener(new a(this)).show((ViewGroup) this.f51361a.f51336e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51363e;

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
            this.f51363e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51363e.u0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51364e;

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
            this.f51364e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FrsTabController frsTabController = this.f51364e;
                boolean K = frsTabController.K(frsTabController.f51339h.getGameTabInfo());
                if (K) {
                    this.f51364e.t.notifyDataSetChanged();
                    if (K && this.f51364e.f51338g != null) {
                        this.f51364e.f51338g.setFrsMainFragment(this.f51364e.f51337f);
                        this.f51364e.f51338g.processAddTabResponse(this.f51364e.f51339h, this.f51364e.f51340i);
                    }
                }
                if (this.f51364e.f51336e.isLoadingViewAttached()) {
                    this.f51364e.f51336e.hideLoadingView(this.f51364e.f51336e.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51365e;

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
            this.f51365e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51365e.f51337f.isPageStayDurationClose = true;
                this.f51365e.X(this.f51365e.f51337f != null ? this.f51365e.f51337f.getArguments() : null);
                this.f51365e.t.notifyDataSetChanged();
                if (this.f51365e.f51336e.isLoadingViewAttached()) {
                    this.f51365e.f51336e.hideLoadingView(this.f51365e.f51336e.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f51366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.k3.m f51367f;

        public p(FrsTabController frsTabController, AlertDialog alertDialog, c.a.r0.k3.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, alertDialog, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51366e = alertDialog;
            this.f51367f = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f51366e) == null) {
                return;
            }
            alertDialog.dismiss();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_CANCEL);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.f51367f.getForum() != null) {
                statisticItem.param("fid", this.f51367f.getForum().getId());
                statisticItem.param("fname", this.f51367f.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f51368e;

        public q(FrsTabController frsTabController, c.a.q0.s.s.a aVar) {
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
            this.f51368e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.q0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f51368e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f51369e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51370f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f51371g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51372h;

        public r(FrsTabController frsTabController, c.a.q0.s.s.a aVar, int i2, String str) {
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
            this.f51372h = frsTabController;
            this.f51369e = aVar;
            this.f51370f = i2;
            this.f51371g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.s.s.a aVar = this.f51369e;
                if (aVar != null) {
                    aVar.dismiss();
                }
                int i2 = this.f51370f;
                if (i2 == 1) {
                    UrlManager.getInstance().dealOneLink(this.f51372h.f51336e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + this.f51372h.O().getForumName() + "&fid=" + this.f51372h.O().getForumId()});
                } else if (i2 == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.f51372h.O().getForumId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.r0.k3.i0.n(this.f51372h.f51336e, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i2 != 3 || TextUtils.isEmpty(this.f51371g)) {
                } else {
                    UrlManager.getInstance().dealOneLink(this.f51372h.f51336e.getPageContext(), new String[]{this.f51371g});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51373a;

        /* loaded from: classes7.dex */
        public class a extends c.a.q0.h0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ s f51374a;

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
                this.f51374a = sVar;
            }

            @Override // c.a.q0.h0.b
            public c.a.q0.h0.c createFragmentTabStructure() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.f51374a.f51373a.f51337f.getForumName());
                    bundle.putString("from", this.f51374a.f51373a.f51337f.getFrom());
                    bundle.putString("forum_id", this.f51374a.f51373a.f51337f.getForumId());
                    bundle.putInt("tab_id", 503);
                    bundle.putBoolean(FrsCommonTabFragment.CAN_AUTO_PLAY_VIDEO, this.f51374a.f51373a.f51339h.isFrsVideoAutoPlay);
                    bundle.putBoolean(FrsCommonTabFragment.NEED_LOG, this.f51374a.f51373a.f51339h.needLog == 1);
                    bundle.putBoolean(FrsCommonTabFragment.IS_BRAND_FORUM, this.f51374a.f51373a.f51339h.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.f51374a.f51373a.f51339h);
                    bundle.putSerializable(FrsCommonTabFragment.VIEW_DATA, frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    c.a.q0.h0.c cVar = new c.a.q0.h0.c();
                    cVar.f13471a = frsSportsRecommendFragment;
                    cVar.f13475e = 25;
                    cVar.f13479i = c.a.q0.h0.c.k;
                    return cVar;
                }
                return (c.a.q0.h0.c) invokeV.objValue;
            }

            @Override // c.a.q0.h0.b
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

            @Override // c.a.q0.h0.b
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
            this.f51373a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i0)) {
                if (!c.a.q0.s.d0.b.j().g(this.f51373a.o, true)) {
                    c.a.e.e.m.e.a().post(this.f51373a.S);
                }
                ((i0) customResponsedMessage.getData()).a(new a(this));
                this.f51373a.Y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51375a;

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
            this.f51375a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.f51375a.f51336e, this.f51375a.f51336e.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.f51375a.f51336e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51376a;

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
            this.f51376a = frsTabController;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                ItemCardHelper.x(this.f51376a.f51336e, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f51376a.f51336e.findViewById(R.id.frs), j2);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f51376a.f51336e, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f51376a.f51336e.findViewById(R.id.frs), 0L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51377e;

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
            this.f51377e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                    parseUri.setFlags(268435456);
                    this.f51377e.f51336e.startActivity(parseUri);
                    TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51378a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f51379e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ w f51380f;

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
                this.f51380f = wVar;
                this.f51379e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51380f.f51378a.f51336e == null) {
                    return;
                }
                c.a.r0.k2.j.c.a(this.f51380f.f51378a.f51336e.getPageContext(), this.f51379e).show();
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
            this.f51378a = frsTabController;
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
                c.a.e.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51381e;

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
            this.f51381e = frsTabController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                new StatisticItem("c13439").eventStat();
                if (this.f51381e.O() == null || TextUtils.isEmpty(this.f51381e.O().getForumId()) || TextUtils.isEmpty(this.f51381e.l) || this.f51381e.f51336e == null) {
                    return;
                }
                if (this.f51381e.A != null) {
                    this.f51381e.A.hideTip();
                }
                int i2 = c.a.q0.s.d0.b.j().k("key_bawu_task_toast", 0) == -1 ? 1 : 0;
                UrlManager.getInstance().dealOneLink(this.f51381e.f51336e.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.f51381e.O().getForumId() + "&fn=" + this.f51381e.l + "&noread=" + i2});
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumData f51382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51383f;

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
            this.f51383f = frsTabController;
            this.f51382e = forumData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51383f.E == null) {
                return;
            }
            if (this.f51383f.I) {
                this.f51383f.x0(this.f51382e.getName(), this.f51382e.getId(), this.f51382e.getImage_url(), true);
            } else {
                this.f51383f.H = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51384a;

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
            this.f51384a = frsTabController;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.r0.k3.m mVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f51384a.f51341j || responsedMessage.hasError() || responsedMessage.getError() != 0) {
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
                this.f51384a.f51341j = true;
                this.f51384a.o0(mVar, true, i2);
                if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                    c.a.q0.s.o.a.b().l("2", mVar.getForum().getId());
                }
            }
            if (mVar == null || mVar.getUserData() == null || mVar.getUserData().getNewGodData() == null) {
                return;
            }
            if (mVar.getForum() != null) {
                c.a.q0.d1.b0.g().j(mVar.getForum().getId());
            }
            c.a.q0.d1.b0.g().k(2, mVar.getUserData().getNewGodData());
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
        this.f51341j = false;
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
        this.f51336e = frsActivity;
        this.o = c.a.q0.s.d0.b.n("show_game_forem_tab_hot_point");
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.p != this.n && a0()) {
                this.f51338g.setCurrentTab(this.n);
                if (Q(this.n) != 1) {
                    this.f51337f.setCanShowSpeedTipView(false);
                }
                this.p = this.n;
                t0(this.f51338g.getCurrentFragment(), this.n);
                return;
            }
            this.f51337f.closeActivity();
        }
    }

    public final boolean K(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (this.f51336e.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.f51336e;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (a0()) {
                return false;
            }
            this.f51337f.isPageStayDurationClose = true;
            q0();
            if (c.a.q0.s.d0.b.j().g("frs_game_login_tip", true)) {
                c.a.q0.s.d0.b.j().t("frs_login_tip", true);
                c.a.q0.s.d0.b.j().t("frs_game_login_tip", false);
            }
            Z(list);
            if (this.f51337f.getTabController() != null) {
                this.f51337f.getTabController().S(true);
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
                    c.a.e.e.m.e.a().removeCallbacks(this.F);
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
            c.a.e.e.m.e.a().postDelayed(this.F, 60000L);
        }
    }

    public final void M(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, forumData) == null) || this.f51337f.getHeaderVC() == null || this.E == null) {
            return;
        }
        if (forumData == null) {
            forumData = this.f51339h.getForum();
        }
        if (forumData == null || forumData.isLike() == 1) {
            return;
        }
        if (!this.I) {
            this.H = true;
        } else if (!x0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) || this.F == null) {
        } else {
            c.a.e.e.m.e.a().removeCallbacks(this.F);
        }
    }

    public final FragmentManager N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsActivity frsActivity = this.f51336e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51337f : (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.f51338g;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.getTabHost();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public final int Q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            i0 i0Var = this.f51340i;
            if (i0Var != null && i2 < ListUtils.getCount(i0Var.g())) {
                return this.f51340i.g().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            i0 i0Var = this.f51340i;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.g());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f51340i.g().get(i3).tab_id.intValue() == i2) {
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
                return this.f51337f.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.f51338g;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.getCurrentTabType()) {
                    return this.f51337f.getTbPageTag();
                }
                Fragment currentFragment = this.f51338g.getCurrentFragment();
                if (currentFragment instanceof BaseFragment) {
                    return ((BaseFragment) currentFragment).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public c.a.r0.k3.m T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f51339h : (c.a.r0.k3.m) invokeV.objValue;
    }

    public final boolean U(c.a.r0.k3.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mVar)) == null) {
            if (mVar != null && mVar.getUserData() != null) {
                int is_manager = mVar.getUserData().getIs_manager();
                boolean g2 = c.a.q0.s.d0.b.j().g("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !g2) {
                    w0(1, this.f51336e.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
                    c.a.q0.s.d0.b.j().t("key_forum_tool_find_dialog_show", true);
                    return true;
                } else if (!g2 && is_manager == 2) {
                    w0(2, this.f51336e.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
                    c.a.q0.s.d0.b.j().t("key_forum_tool_find_dialog_show", true);
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
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void W(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) || (frsActivity = this.f51336e) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.frs_base_layout);
        this.s = (FrsBaseViewPager) this.f51336e.findViewById(R.id.frs_base_viewpager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this, this.f51336e.getSupportFragmentManager());
        this.t = fragmentAdapter;
        this.s.setAdapter(fragmentAdapter);
        this.s.setPageTransformer(true, new CubeOutViewPagerTransformer());
        this.s.addOnPageChangeListener(this.b0);
        this.s.setmDisallowSlip(true);
        this.s.setOnTouchEventListener(this.c0);
        c.a.q0.s.u.c.d(this.s).f(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.f51336e.findViewById(R.id.frs_post_forum_button);
        this.u = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.u.setHasShadow(false);
        this.w = (FrameLayout) this.f51336e.findViewById(R.id.frs_bottom_extra);
        this.v = (FRSRefreshButton) this.f51336e.findViewById(R.id.frs_refresh_forum_button);
        this.x = (LinearLayout) this.f51336e.findViewById(R.id.frs_ll_redpack);
        this.f51336e.registerListener(this.U);
        this.f51336e.registerListener(this.V);
        this.M.getHttpMessageListener().setPriority(-1);
        this.M.getSocketMessageListener().setPriority(-1);
        this.f51336e.registerListener(this.N);
        this.P.setSelfListener(true);
        this.f51336e.registerListener(this.P);
        this.O.setSelfListener(true);
        this.f51336e.registerListener(this.O);
        this.f51336e.registerListener(this.T);
        if (bundle == null) {
            this.l = this.f51336e.getIntent().getStringExtra("name");
            this.m = this.f51336e.getIntent().getStringExtra("from");
            this.n = this.f51336e.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.l = bundle.getString("name");
            this.m = bundle.getString("from");
            this.n = bundle.getInt("default_tab_id", 0);
        }
        X(bundle);
        this.t.notifyDataSetChanged();
        this.q = new ShareSuccessReplyToServerModel();
        this.f51336e.registerListener(this.M);
        this.f51336e.registerListener(this.K);
        this.f51336e.registerListener(this.L);
        this.f51336e.registerListener(this.R);
        this.f51336e.registerListener(this.Z);
        this.a0.setPriority(Integer.MAX_VALUE);
        this.a0.setSelfListener(true);
        this.f51336e.registerListener(this.a0);
    }

    public final void X(Bundle bundle) {
        FragmentManager N;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) || (N = N()) == null || N.isDestroyed() || (fragmentAdapter = this.t) == null) {
            return;
        }
        try {
            FrsFragment frsFragment = (FrsFragment) fragmentAdapter.findFragmentByTag(l0);
            if (frsFragment == null) {
                frsFragment = d0(bundle);
            }
            frsFragment.setWriteIcon(this.u);
            frsFragment.setmRefreshIcon(this.v);
            frsFragment.setmFrsllRedpack(this.x);
            if (l0.equals(this.t.getItemTag(0))) {
                return;
            }
            if (m0.equals(this.t.getItemTag(0))) {
                this.t.remove(0);
            }
            this.t.add(0, frsFragment);
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
            FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) fragmentAdapter.findFragmentByTag(m0);
            if (frsTabHostFragment == null) {
                frsTabHostFragment = e0();
            }
            frsTabHostFragment.setWriteIcon(this.u);
            frsTabHostFragment.setRefreshIcon(this.v);
            if (m0.equals(this.t.getItemTag(0))) {
                return;
            }
            if (l0.equals(this.t.getItemTag(0))) {
                this.t.remove(0);
            }
            this.t.add(0, frsTabHostFragment);
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
        this.f51336e.registerListener(sVar);
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
        this.f51340i = new i0(this.f51336e.getActivity(), arrayList);
        if (O() != null) {
            this.f51340i.k(O().getForumId());
            this.f51340i.l(O().getForumName());
            if (O().getFrsViewData() != null && O().getFrsViewData().getForum() != null) {
                ForumData forum = O().getFrsViewData().getForum();
                this.f51340i.j(forum.getForumGameLabel());
                this.f51340i.m(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.f51337f;
        frsFragment.isPageStayDurationClose = false;
        new c.a.r0.x0.x1.e(frsFragment).a(this.f51340i);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.f51340i);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.f51336e.getUniqueId());
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
            c.a.r0.k3.m mVar = this.f51339h;
            return (mVar == null || j2 == 0 || (forum = mVar.getForum()) == null || c.a.e.e.m.b.g(forum.getId(), 0L) != j2) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    public final void c0() {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (i0Var = this.f51340i) == null || TextUtils.isEmpty(i0Var.d())) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021074);
        httpMessage.addParam("forum_id", this.f51339h.getForum().getId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final FrsFragment d0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bundle)) == null) {
            if (this.f51337f == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.f51337f = frsFragment;
                frsFragment.setArguments(bundle);
                this.f51337f.setBaseTag(l0);
            }
            FrsFragment frsFragment2 = this.f51337f;
            frsFragment2.isPageStayDurationClose = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    @Override // c.a.r0.g.e.b
    public void dispatchInjectPluginMessage(c.a.r0.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) {
            FrsFragment frsFragment = this.f51337f;
            if (frsFragment instanceof c.a.r0.g.e.b) {
                frsFragment.dispatchInjectPluginMessage(dVar);
            }
        }
    }

    public final FrsTabHostFragment e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f51338g == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.f51338g = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(m0);
                this.f51338g.setDefaultTabId(this.n);
            }
            return this.f51338g;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public void f0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i2, i3, intent) == null) {
            if (!a0()) {
                this.f51337f.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f51338g;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.getCurrentTabType()) {
                        this.f51337f.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment currentFragment = this.f51338g.getCurrentFragment();
                        if (currentFragment != null) {
                            currentFragment.onActivityResult(i2, i3, intent);
                        }
                    }
                }
            }
            if (i3 == -1) {
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1) {
                        c.a.r0.y2.a.g().m(this.f51336e.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.q) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.w(str, intExtra2, new w(this));
                    }
                } else if (i2 == 13011) {
                    c.a.r0.y2.a.g().m(this.f51336e.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.f51338g;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.getWriteTab() != null) {
                        this.f51338g.getWriteTab().n(this.f51336e.getPageContext());
                        return;
                    }
                    FrsFragment frsFragment = this.f51337f;
                    if (frsFragment == null || frsFragment.getFrsView() == null || this.f51337f.getFrsView().Y() == null || this.f51337f.getFrsView().Y().f27588g == null) {
                        return;
                    }
                    this.f51337f.getFrsView().Y().f27588g.n(this.f51336e.getPageContext());
                }
            }
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1 && skinType != 4) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.f51336e);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.f51336e);
            }
            FrsFragment frsFragment = this.f51337f;
            if (frsFragment != null) {
                frsFragment.onChangeSkinType(i2);
            }
            FrsTabHostFragment frsTabHostFragment = this.f51338g;
            if (frsTabHostFragment != null) {
                frsTabHostFragment.onChangeSkinType(i2);
            }
            p0();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public c.a.e.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (!a0()) {
                FrsFragment frsFragment = this.f51337f;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).getFrsCommonImageLayoutPool();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f51338g;
                if (frsTabHostFragment == null) {
                    return null;
                }
                Fragment currentFragment = frsTabHostFragment.getCurrentFragment();
                if (currentFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) currentFragment).getFrsCommonImageLayoutPool();
                }
            }
            return null;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.r0.g.e.b
    public c.a.r0.g.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            FrsFragment frsFragment = this.f51337f;
            if (frsFragment instanceof c.a.r0.g.e.b) {
                return frsFragment.getInjectPlugin(i2);
            }
            return null;
        }
        return (c.a.r0.g.e.a) invokeI.objValue;
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
                return this.f51337f.getVoiceManager();
            }
            FrsTabHostFragment frsTabHostFragment = this.f51338g;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment currentFragment = frsTabHostFragment.getCurrentFragment();
            if (currentFragment instanceof VoiceManager.j) {
                return ((VoiceManager.j) currentFragment).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void h0() {
        c.a.r0.x0.n2.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.SCROLL_LISTENER_TAG);
            this.k.removeCallbacksAndMessages(null);
            if (this.f51336e.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.f51336e;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.S != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.S);
            }
            c.a.q0.s.d0.b.j().t(this.o, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.q;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.f51337f;
            if (frsFragment != null && frsFragment.getModelController() != null) {
                this.f51337f.getModelController().D0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.A;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.onDestroy();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.m)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.m)) {
                c.a.q0.y.d.h().i(false);
            }
            if (this.F != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.F);
            }
            c.a.r0.k3.m mVar = this.f51339h;
            if (mVar != null && mVar.getForum() != null && (eVar = this.E) != null) {
                eVar.b(c.a.e.e.m.b.g(this.f51339h.getForum().getId(), 0L));
            }
            c.a.e.e.m.e.a().removeCallbacks(this.k0);
        }
    }

    public boolean i0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    FrsFragment frsFragment = this.f51337f;
                    if (frsFragment == null || !frsFragment.isAdded()) {
                        return false;
                    }
                    return this.f51337f.onKeyDown(i2, keyEvent);
                }
                return this.f51336e.onSuperKeyDown(i2, keyEvent);
            } else if (this.J) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                return false;
            } else if (a0() && (frsTabHostFragment = this.f51338g) != null && frsTabHostFragment.isWriteTabShowing()) {
                this.f51338g.hideWriteTab();
                UtilHelper.setNavigationBarBackground(this.f51336e, this.f51338g.getBottomNavigationBarColor());
                return false;
            } else {
                FrsFragment frsFragment2 = this.f51337f;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    if (this.f51337f.onKeyDown(i2, keyEvent)) {
                        return true;
                    }
                    J();
                    return false;
                }
                return this.f51336e.onSuperKeyDown(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void j0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, intent) == null) || (frsFragment = this.f51337f) == null) {
            return;
        }
        frsFragment.onNewIntent(intent);
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.I = false;
            c.a.r0.x0.n2.e eVar = this.E;
            if (eVar != null) {
                eVar.d();
            }
            if (!a0()) {
                this.f51337f.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f51338g;
                if (frsTabHostFragment != null) {
                    Fragment currentFragment = frsTabHostFragment.getCurrentFragment();
                    if (currentFragment instanceof BaseFragment) {
                        ((BaseFragment) currentFragment).setPrimary(false);
                    }
                }
            }
            c.a.q0.d1.b0.g().i();
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                c.a.e.e.m.e.a().postDelayed(this.k0, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.i0);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (!a0()) {
                this.f51337f.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f51338g;
                if (frsTabHostFragment != null) {
                    Fragment currentFragment = frsTabHostFragment.getCurrentFragment();
                    if (currentFragment instanceof BaseFragment) {
                        ((BaseFragment) currentFragment).setPrimary(true);
                    }
                }
            }
            if (this.r) {
                this.r = false;
                FrsFragment frsFragment = this.f51337f;
                if (frsFragment != null) {
                    frsFragment.refresh();
                }
            }
            c.a.r0.k3.m mVar = this.f51339h;
            if (mVar != null && mVar.getUserData() != null && this.f51339h.getUserData().getNewGodData() != null) {
                if (this.f51339h.getForum() != null) {
                    c.a.q0.d1.b0.g().j(this.f51339h.getForum().getId());
                }
                c.a.q0.d1.b0.g().k(2, this.f51339h.getUserData().getNewGodData());
            }
            this.I = true;
            if (this.H) {
                M(null);
            }
            ItemCardHelper.v(this.j0);
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
        c.a.r0.k3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || (mVar = this.f51339h) == null || mVar.getForum() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f51339h.getForum().getId()).param("obj_type", 2));
    }

    public final void o0(c.a.r0.k3.m mVar, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{mVar, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || mVar == null || mVar.getForum() == null) {
            return;
        }
        this.f51339h = mVar;
        ForumData forum = mVar.getForum();
        if (z2 && forum != null && !TextUtils.isEmpty(forum.getId())) {
            FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
        }
        if (!U(mVar) && z2) {
            boolean V = V(forum, mVar.getAnti());
            FrsFragment frsFragment = this.f51337f;
            if (frsFragment != null) {
                frsFragment.setYoungsterDialogShown(V);
            }
            if (!(!V ? y0(mVar) : false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
        }
        if (forum.getIsShowBawuTask() && c.a.q0.s.d0.b.j().k("key_bawu_task_toast", 0) == 0 && !this.B) {
            this.B = true;
            c.a.e.e.m.e.a().postDelayed(new m(this), 30000L);
        }
        if (mVar.bazhuExam != null && !this.C && z2) {
            c.a.r0.x0.m.a(this.f51336e.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
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
            if ((!this.G || i2 == 4) && forum.isLike() == 0 && c.a.q0.b.d.i0() && TbadkCoreApplication.isLogin()) {
                this.E = new c.a.r0.x0.n2.e();
                this.f51336e.registerListener(this.X);
                this.f51336e.registerListener(this.W);
                this.f51336e.registerListener(this.Y);
                L(forum);
            }
        }
    }

    public final void p0() {
        c.a.r0.k3.m mVar;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (mVar = this.f51339h) == null || (themeColorInfo = mVar.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
            this.f51336e.registerListener(1021074, this.Q);
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

    @Override // c.a.r0.g.e.b
    public void setInjectPlugin(int i2, c.a.r0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048617, this, i2, aVar) == null) {
            FrsFragment frsFragment = this.f51337f;
            if (frsFragment instanceof c.a.r0.g.e.b) {
                frsFragment.setInjectPlugin(i2, aVar);
            }
        }
    }

    public final void t0(Fragment fragment, int i2) {
        c.a.r0.k3.m mVar;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048618, this, fragment, i2) == null) || !(fragment instanceof q0) || (mVar = this.f51339h) == null || mVar.getForum() == null || (navigationBar = ((q0) fragment).getNavigationBar()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f51339h.getForum().getName(), 5, true, true) + this.f51336e.getActivity().getString(R.string.forum));
        navigationBar.setCenterTextTitle(sb.toString());
    }

    public final void u0() {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (frsActivity = this.f51336e) == null) {
            return;
        }
        if (this.A == null) {
            this.A = (NavigationBarCoverTip) frsActivity.findViewById(R.id.navigation_cover_tip);
        }
        if (this.A == null) {
            return;
        }
        View inflate = View.inflate(this.f51336e, R.layout.write_thread_share_guide, null);
        TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.share_icon);
        if (TextUtils.isEmpty(this.l)) {
            textView.setText("吧主您好，本吧考核新制度上线啦");
        } else {
            textView.setText(this.l + "吧吧主您好，本吧考核新制度上线啦");
        }
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
        c.a.q0.s.f0.n.c cVar = new c.a.q0.s.f0.n.c();
        cVar.s();
        tBSpecificationBtn.setConfig(cVar);
        tBSpecificationBtn.changeSkinType();
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.A, R.color.cp_link_tip_a_alpha95);
        tBSpecificationBtn.setOnClickListener(new x(this));
        this.A.showTip(this.f51336e, inflate, 30000);
        new StatisticItem("c13438").eventStat();
        int k2 = c.a.q0.s.d0.b.j().k("key_bawu_task_toast", 0);
        if (k2 >= 0) {
            c.a.q0.s.d0.b.j().v("key_bawu_task_toast", k2 + 1);
        }
    }

    public final void v0() {
        c.a.r0.k3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (mVar = this.f51339h) == null || mVar.getEntelechyTabInfo() == null || this.f51339h.getEntelechyTabInfo().f21174a == null) {
            return;
        }
        if (this.f51336e.getIntent() == null || !FrsActivityConfig.FRS_FROM_ITEM.equals(this.f51336e.getIntent().getStringExtra("from"))) {
            boolean z2 = false;
            Iterator<FrsTabInfo> it = this.f51339h.getEntelechyTabInfo().f21174a.iterator();
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
                    c.a.r0.f0.e eVar = new c.a.r0.f0.e(this.f51336e.getPageContext(), this.u);
                    this.D = eVar;
                    eVar.g0(R.drawable.pic_sign_tip_down);
                    this.D.L(2);
                    this.D.h0(true);
                    this.D.j0(-c.a.e.e.p.l.g(this.f51336e, R.dimen.tbds20));
                    this.D.k0(-c.a.e.e.p.l.g(this.f51336e, R.dimen.tbds20));
                    this.D.X(R.color.CAM_X0101);
                    this.D.P(R.dimen.tbds54);
                    this.D.a0(c.a.e.e.p.l.g(this.f51336e, R.dimen.tbds44));
                }
                this.D.m0(this.f51336e.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    public final void w0(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f51336e);
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.f51336e);
            frsForumToolDialogView.setStartLoadUrl(i2, str2);
            frsForumToolDialogView.setContent(str);
            frsForumToolDialogView.setCancleButtonListener(new q(this, aVar));
            frsForumToolDialogView.setConfirmButtonListener(new r(this, aVar, i2, str3));
            aVar.setContentView(frsForumToolDialogView);
            aVar.create(this.f51336e.getPageContext()).show();
        }
    }

    public final boolean x0(String str, String str2, String str3, boolean z2) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{str, str2, str3, Boolean.valueOf(z2)})) == null) {
            if (!this.E.g(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.f51337f) == null || frsFragment.getHeaderVC() == null) {
                return false;
            }
            this.H = false;
            this.E.h(this.f51336e, str, str2, str3, this.f51337f.getHeaderVC().v());
            this.E.e().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean y0(c.a.r0.k3.m mVar) {
        InterceptResult invokeL;
        PopInfo popInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, mVar)) == null) {
            if (c.a.q0.s.d0.b.j().g(c.a.q0.s.d0.b.n("key_frs_shield_thread_dialog"), false) || mVar.getUserData() == null || mVar.getUserData().getIs_manager() <= 0 || (popInfo = mVar.frsMaskPopInfo) == null || popInfo.if_pop.intValue() != 1) {
                return false;
            }
            ImageView imageView = new ImageView(this.f51336e);
            imageView.setImageResource(SkinManager.getResourceId(R.drawable.pic_frs_popup_shield));
            TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.comment_tab_dialog_botton_text, TBAlertConfig.OperateBtnStyle.MAIN);
            c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f51336e);
            lVar.q(mVar.frsMaskPopInfo.title);
            lVar.m(mVar.frsMaskPopInfo.v_title);
            lVar.l(true);
            lVar.h(imageView);
            lVar.o(aVar);
            lVar.g(false);
            aVar.a(new p(this, lVar.s(), mVar));
            c.a.q0.s.d0.b.j().t(c.a.q0.s.d0.b.n("key_frs_shield_thread_dialog"), true);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (mVar.getForum() != null) {
                statisticItem.param("fid", mVar.getForum().getId());
                statisticItem.param("fname", mVar.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
            return true;
        }
        return invokeL.booleanValue;
    }
}
