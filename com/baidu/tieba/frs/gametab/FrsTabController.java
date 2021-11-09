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
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import b.a.r0.x0.i0;
import b.a.r0.x0.q0;
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
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
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
/* loaded from: classes9.dex */
public class FrsTabController implements b.a.r0.g.e.b, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String n0;
    public static final String o0;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBarCoverTip A;
    public boolean B;
    public boolean C;
    public b.a.r0.f0.g D;
    public b.a.r0.x0.x2.e E;
    public Runnable F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public HttpMessageListener L;
    public CustomMessageListener M;
    public b.a.e.c.g.a N;
    public CustomMessageListener O;
    public CustomMessageListener P;
    public CustomMessageListener Q;
    public HttpMessageListener R;
    public CustomMessageListener S;
    public CustomMessageListener T;
    public Runnable U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public CustomMessageListener a0;
    public CustomMessageListener b0;
    public CustomMessageListener c0;

    /* renamed from: e  reason: collision with root package name */
    public FrsActivity f48668e;

    /* renamed from: f  reason: collision with root package name */
    public FrsFragment f48669f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabHostFragment f48670g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.l3.m f48671h;

    /* renamed from: i  reason: collision with root package name */
    public i0 f48672i;
    public ViewPager.OnPageChangeListener i0;
    public boolean j;
    public FrsBaseViewPager.a j0;
    public final Handler k;
    public CustomMessageListener k0;
    public String l;
    public final ItemCardHelper.c l0;
    public String m;
    public Runnable m0;
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

    /* loaded from: classes9.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<BaseFragment> f48673a;

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
            this.f48673a = new ArrayList(2);
        }

        public boolean add(BaseFragment baseFragment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragment)) == null) ? ListUtils.add(this.f48673a, baseFragment) : invokeL.booleanValue;
        }

        public BaseFragment findFragmentByTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (b.a.e.e.p.k.isEmpty(str)) {
                    return null;
                }
                for (BaseFragment baseFragment : this.f48673a) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48673a.size() : invokeV.intValue;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (BaseFragment) ListUtils.remove(this.f48673a, i2) : (BaseFragment) invokeI.objValue;
        }

        public BaseFragment removeFragmentByTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                if (b.a.e.e.p.k.isEmpty(str)) {
                    return null;
                }
                Iterator<BaseFragment> it = this.f48673a.iterator();
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
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, baseFragment)) == null) ? ListUtils.add(this.f48673a, i2, baseFragment) : invokeIL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public BaseFragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (BaseFragment) ListUtils.getItem(this.f48673a, i2) : (BaseFragment) invokeI.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48674a;

        /* renamed from: com.baidu.tieba.frs.gametab.FrsTabController$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1721a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f48675e;

            public View$OnClickListenerC1721a(a aVar) {
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
                this.f48675e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f48675e.f48674a.f48671h.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new b.a.r0.l3.j0.n(this.f48675e.f48674a.f48668e, "RecommendHistoryPage", hashMap)));
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
            this.f48674a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof FrsRecommendResMsg)) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(this.f48674a.f48668e).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show((ViewGroup) this.f48674a.f48668e.findViewById(e1.frs));
                    return;
                }
                FrsRecommendResMsg frsRecommendResMsg = (FrsRecommendResMsg) httpResponsedMessage;
                int pushStatus = frsRecommendResMsg.getPushStatus();
                String pushMsg = frsRecommendResMsg.getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(this.f48674a.f48668e).setTitle(this.f48674a.f48668e.getString(h1.frs_recommend_suc_tip_title)).setContent(this.f48674a.f48668e.getString(h1.frs_recommend_suc_tip_content)).setBtnText(this.f48674a.f48668e.getString(h1.dialog_confirm_see)).setBtnClickListener(new View$OnClickListenerC1721a(this)).show((ViewGroup) this.f48674a.f48668e.findViewById(e1.frs));
                } else {
                    new BdTopToast(this.f48674a.f48668e).setIcon(false).setContent(pushMsg).show((ViewGroup) this.f48674a.f48668e.findViewById(e1.frs));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a0 extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48676a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(FrsTabController frsTabController, int i2, int i3) {
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
            this.f48676a = frsTabController;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.a.r0.l3.m mVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f48676a.j || responsedMessage.hasError() || responsedMessage.getError() != 0) {
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
                this.f48676a.j = true;
                this.f48676a.p0(mVar, true, i2);
                if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                    b.a.q0.s.o.a.b().l("2", mVar.getForum().getId());
                }
            }
            if (mVar == null || mVar.getUserData() == null || mVar.getUserData().getNewGodData() == null) {
                return;
            }
            if (mVar.getForum() != null) {
                b.a.q0.d1.b0.g().j(mVar.getForum().getId());
            }
            b.a.q0.d1.b0.g().k(2, mVar.getUserData().getNewGodData());
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48677e;

        public b(FrsTabController frsTabController) {
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
            this.f48677e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.e.e.m.e.a().removeCallbacks(this);
                this.f48677e.d0();
                b.a.e.e.m.e.a().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48678a;

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
            this.f48678a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.f48678a.j && this.f48678a.f48671h == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.l3.m)) {
                b.a.r0.l3.m mVar = (b.a.r0.l3.m) customResponsedMessage.getData();
                if (mVar.getForum() == null || this.f48678a.l == null || !this.f48678a.l.equals(mVar.getForum().getName())) {
                    return;
                }
                this.f48678a.p0(mVar, false, -1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48679a;

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
            this.f48679a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f48679a.r = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48680a;

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
            this.f48680a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f48680a.K();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48681a;

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
            this.f48681a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f48681a.s == null || this.f48681a.t == null || !(customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                return;
            }
            FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
            this.f48681a.y = aVar.a();
            this.f48681a.z = aVar.b();
        }
    }

    /* loaded from: classes9.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48682a;

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
            this.f48682a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int S;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (10001 == intValue) {
                S = this.f48682a.S(9);
                if (S == -1) {
                    S = this.f48682a.S(2);
                }
            } else {
                S = this.f48682a.S(intValue);
            }
            if (S == -1 || !this.f48682a.b0() || this.f48682a.f48670g == null) {
                return;
            }
            this.f48682a.f48670g.setCurrentTab(S);
            if (this.f48682a.R(S) != 1) {
                this.f48682a.f48669f.setCanShowSpeedTipView(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48683a;

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
            this.f48683a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f48683a.s == null || this.f48683a.t == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f48683a.s.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes9.dex */
    public class e0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48684a;

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
            this.f48684a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<b.a.r0.x0.h2.a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.f48684a.f48670g == null) {
                    return;
                }
                for (b.a.r0.x0.h2.a aVar : newNotifyData) {
                    if (aVar != null) {
                        for (int i3 = 0; i3 < this.f48684a.f48672i.f().size(); i3++) {
                            FragmentTabHost.b tabSpec = this.f48684a.f48670g.getTabSpec(i3);
                            if (tabSpec != null && (i2 = tabSpec.f45183a) != 1 && i2 != this.f48684a.f48670g.getCurrentTabType() && tabSpec.f45183a == aVar.a() && aVar.b() && tabSpec.f45184b.getTip(String.valueOf(tabSpec.f45183a)) != null) {
                                tabSpec.f45184b.getTip(String.valueOf(tabSpec.f45183a)).f45973a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48685a;

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
            this.f48685a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f48685a.N(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48686a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(FrsTabController frsTabController, int i2) {
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
            this.f48686a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.f48686a.f48668e, 2000).setIcon(false).setContent(this.f48686a.f48668e.getString(h1.frs_top_forum_rules_click_toast)).show((ViewGroup) this.f48686a.f48668e.findViewById(e1.frs));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48687a;

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
            this.f48687a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f48687a.E == null || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ForumData) {
                this.f48687a.N((ForumData) customResponsedMessage.getData());
            } else if (customResponsedMessage.getData() instanceof Long) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.f48687a.c0(longValue) && this.f48687a.E.a(longValue) >= 3) {
                    this.f48687a.E.b(longValue);
                    this.f48687a.H = true;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48688a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(FrsTabController frsTabController, int i2) {
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
            this.f48688a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921641) {
                this.f48688a.K = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48689a;

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
            this.f48689a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.l3.s0.k)) {
                b.a.r0.l3.s0.k kVar = (b.a.r0.l3.s0.k) customResponsedMessage.getData();
                if (this.f48689a.E == null || kVar == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.f48689a.E.c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(kVar.f20874a));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48690a;

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
            this.f48690a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.f48690a.J = booleanValue;
                if (booleanValue) {
                    this.f48690a.u.setVisibility(8);
                } else {
                    this.f48690a.u.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48691a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsTabController frsTabController, int i2) {
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
            this.f48691a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof b.a.r0.x0.v2.a) || ((b.a.r0.x0.v2.a) customResponsedMessage.getData()).f26448a == null) {
                this.f48691a.w.removeAllViews();
                this.f48691a.w.setVisibility(8);
                return;
            }
            View view = ((b.a.r0.x0.v2.a) customResponsedMessage.getData()).f26448a;
            if (view.getParent() != null) {
                if (((ViewGroup) view.getParent()) != this.f48691a.w) {
                    ((ViewGroup) view.getParent()).removeView(view);
                    this.f48691a.w.removeAllViews();
                    this.f48691a.w.addView(view);
                }
            } else {
                this.f48691a.w.removeAllViews();
                this.f48691a.w.addView(view);
            }
            this.f48691a.w.setVisibility(0);
        }
    }

    /* loaded from: classes9.dex */
    public class k implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48692e;

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
            this.f48692e = frsTabController;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0) {
                this.f48692e.z = false;
                this.f48692e.s.setForceIntercept(false);
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
            this.f48692e.u.setVisibility(0);
            if (this.f48692e.P() != null) {
                this.f48692e.P().setLiteProgramListFragmentSelect(false);
            }
            this.f48692e.f48669f.showRefreshIcon();
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48693a;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f48694e;

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
                this.f48694e = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f48694e.f48693a.f48671h.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new b.a.r0.l3.j0.n(this.f48694e.f48693a.f48668e, "ForumGradePage", hashMap)));
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
            this.f48693a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new ScreenTopToast(this.f48693a.f48668e).setTitle(this.f48693a.f48668e.getString(h1.frs_recommend_fail_month_tip)).setBtnText(this.f48693a.f48668e.getString(h1.frs_recommend_fail_tip_btn)).setBtnClickListener(new a(this)).show((ViewGroup) this.f48693a.f48668e.findViewById(e1.frs));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements FrsBaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48695a;

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
            this.f48695a = frsTabController;
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48695a.s == null) {
                return;
            }
            if (this.f48695a.s.getCurrentItem() == 0) {
                this.f48695a.s.setmDisallowSlip(true);
            } else {
                this.f48695a.s.setmDisallowSlip(false);
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f48695a.s.getCurrentItem() == 0) {
                    if (this.f48695a.y && this.f48695a.z) {
                        this.f48695a.s.setmDisallowSlip(false);
                    }
                    if (!this.f48695a.z) {
                        this.f48695a.s.setmDisallowSlip(true);
                    }
                    this.f48695a.s.setmDisallowSlip(true);
                } else {
                    this.f48695a.s.setmDisallowSlip(true);
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48696e;

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
            this.f48696e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48696e.v0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48697e;

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
            this.f48697e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FrsTabController frsTabController = this.f48697e;
                boolean L = frsTabController.L(frsTabController.f48671h.getGameTabInfo());
                if (L) {
                    this.f48697e.t.notifyDataSetChanged();
                    if (L && this.f48697e.f48670g != null) {
                        this.f48697e.f48670g.setFrsMainFragment(this.f48697e.f48669f);
                        this.f48697e.f48670g.processAddTabResponse(this.f48697e.f48671h, this.f48697e.f48672i);
                    }
                }
                if (this.f48697e.f48668e.isLoadingViewAttached()) {
                    this.f48697e.f48668e.hideLoadingView(this.f48697e.f48668e.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48698e;

        public p(FrsTabController frsTabController) {
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
            this.f48698e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48698e.f48669f.isPageStayDurationClose = true;
                this.f48698e.Y(this.f48698e.f48669f != null ? this.f48698e.f48669f.getArguments() : null);
                this.f48698e.t.notifyDataSetChanged();
                if (this.f48698e.f48668e.isLoadingViewAttached()) {
                    this.f48698e.f48668e.hideLoadingView(this.f48698e.f48668e.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f48699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l3.m f48700f;

        public q(FrsTabController frsTabController, AlertDialog alertDialog, b.a.r0.l3.m mVar) {
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
            this.f48699e = alertDialog;
            this.f48700f = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f48699e) == null) {
                return;
            }
            alertDialog.dismiss();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_CANCEL);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.f48700f.getForum() != null) {
                statisticItem.param("fid", this.f48700f.getForum().getId());
                statisticItem.param("fname", this.f48700f.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes9.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f48701e;

        public r(FrsTabController frsTabController, b.a.q0.s.s.a aVar) {
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
            this.f48701e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a.q0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f48701e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f48702e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48703f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48704g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48705h;

        public s(FrsTabController frsTabController, b.a.q0.s.s.a aVar, int i2, String str) {
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
            this.f48705h = frsTabController;
            this.f48702e = aVar;
            this.f48703f = i2;
            this.f48704g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.q0.s.s.a aVar = this.f48702e;
                if (aVar != null) {
                    aVar.dismiss();
                }
                int i2 = this.f48703f;
                if (i2 == 1) {
                    UrlManager.getInstance().dealOneLink(this.f48705h.f48668e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + this.f48705h.P().getForumName() + "&fid=" + this.f48705h.P().getForumId()});
                } else if (i2 == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.f48705h.P().getForumId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new b.a.r0.l3.j0.n(this.f48705h.f48668e, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i2 != 3 || TextUtils.isEmpty(this.f48704g)) {
                } else {
                    UrlManager.getInstance().dealOneLink(this.f48705h.f48668e.getPageContext(), new String[]{this.f48704g});
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48706a;

        /* loaded from: classes9.dex */
        public class a extends b.a.q0.h0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ t f48707a;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48707a = tVar;
            }

            @Override // b.a.q0.h0.b
            public b.a.q0.h0.c createFragmentTabStructure() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.f48707a.f48706a.f48669f.getForumName());
                    bundle.putString("from", this.f48707a.f48706a.f48669f.getFrom());
                    bundle.putString("forum_id", this.f48707a.f48706a.f48669f.getForumId());
                    bundle.putInt("tab_id", 503);
                    bundle.putBoolean(FrsCommonTabFragment.CAN_AUTO_PLAY_VIDEO, this.f48707a.f48706a.f48671h.isFrsVideoAutoPlay);
                    bundle.putBoolean(FrsCommonTabFragment.NEED_LOG, this.f48707a.f48706a.f48671h.needLog == 1);
                    bundle.putBoolean(FrsCommonTabFragment.IS_BRAND_FORUM, this.f48707a.f48706a.f48671h.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.f48707a.f48706a.f48671h);
                    bundle.putSerializable(FrsCommonTabFragment.VIEW_DATA, frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    b.a.q0.h0.c cVar = new b.a.q0.h0.c();
                    cVar.f12612a = frsSportsRecommendFragment;
                    cVar.f12616e = 25;
                    cVar.f12620i = b.a.q0.h0.c.k;
                    return cVar;
                }
                return (b.a.q0.h0.c) invokeV.objValue;
            }

            @Override // b.a.q0.h0.b
            public TbFragmentTabIndicator getTabIndicator(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(f1.fragmenttabindicator, (ViewGroup) null);
                    this.mIndicator = fragmentTabIndicator;
                    fragmentTabIndicator.setTextSize(2.0f);
                    return this.mIndicator;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // b.a.q0.h0.b
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
            this.f48706a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i0)) {
                if (!b.a.q0.s.e0.b.j().g(this.f48706a.o, true)) {
                    b.a.e.e.m.e.a().post(this.f48706a.U);
                }
                ((i0) customResponsedMessage.getData()).a(new a(this));
                this.f48706a.Z();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48708a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(FrsTabController frsTabController, int i2) {
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
            this.f48708a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.f48708a.f48668e, this.f48708a.f48668e.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.f48708a.f48668e.findViewById(e1.frs));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48709a;

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
            this.f48709a = frsTabController;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.f48709a.f48668e, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f48709a.f48668e.findViewById(e1.frs), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f48709a.f48668e, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f48709a.f48668e.findViewById(e1.frs), 0L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48710e;

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
            this.f48710e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                    parseUri.setFlags(268435456);
                    this.f48710e.f48668e.startActivity(parseUri);
                    TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48711a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f48712e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ x f48713f;

            public a(x xVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {xVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48713f = xVar;
                this.f48712e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48713f.f48711a.f48668e == null) {
                    return;
                }
                b.a.r0.k2.t.c.a(this.f48713f.f48711a.f48668e.getPageContext(), this.f48712e).show();
            }
        }

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
            this.f48711a = frsTabController;
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
                b.a.e.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48714e;

        public y(FrsTabController frsTabController) {
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
            this.f48714e = frsTabController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                new StatisticItem("c13439").eventStat();
                if (this.f48714e.P() == null || TextUtils.isEmpty(this.f48714e.P().getForumId()) || TextUtils.isEmpty(this.f48714e.l) || this.f48714e.f48668e == null) {
                    return;
                }
                if (this.f48714e.A != null) {
                    this.f48714e.A.hideTip();
                }
                int i2 = b.a.q0.s.e0.b.j().k("key_bawu_task_toast", 0) == -1 ? 1 : 0;
                UrlManager.getInstance().dealOneLink(this.f48714e.f48668e.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.f48714e.P().getForumId() + "&fn=" + this.f48714e.l + "&noread=" + i2});
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumData f48715e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f48716f;

        public z(FrsTabController frsTabController, ForumData forumData) {
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
            this.f48716f = frsTabController;
            this.f48715e = forumData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48716f.E == null) {
                return;
            }
            if (this.f48716f.I) {
                this.f48716f.y0(this.f48715e.getName(), this.f48715e.getId(), this.f48715e.getImage_url(), true);
            } else {
                this.f48716f.H = true;
            }
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
        n0 = FrsFragment.class.getSimpleName();
        o0 = FrsTabHostFragment.class.getSimpleName();
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
        this.L = new a(this, CmdConfigHttp.CMD_FRS_RECOMMEND);
        this.M = new l(this, 2921465);
        this.N = new a0(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.O = new b0(this, 2001615);
        this.P = new c0(this, 2921342);
        this.Q = new d0(this, 2001627);
        this.R = new e0(this, 0);
        this.S = new f0(this, 2921518);
        this.T = new g0(this, 2921641);
        this.U = new b(this);
        this.V = new c(this, 2005016);
        this.W = new d(this, 2921369);
        this.X = new e(this, 2921370);
        this.Y = new f(this, 2001375);
        this.Z = new g(this, 2921498);
        this.a0 = new h(this, 2001437);
        this.b0 = new i(this, 2921586);
        this.c0 = new j(this, 2921590);
        this.i0 = new k(this);
        this.j0 = new m(this);
        this.k0 = new u(this, 2001440);
        this.l0 = new v(this);
        this.m0 = new w(this);
        this.f48668e = frsActivity;
        this.o = b.a.q0.s.e0.b.n("show_game_forem_tab_hot_point");
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.p != this.n && b0()) {
                this.f48670g.setCurrentTab(this.n);
                if (R(this.n) != 1) {
                    this.f48669f.setCanShowSpeedTipView(false);
                }
                this.p = this.n;
                u0(this.f48670g.getCurrentFragment(), this.n);
                return;
            }
            this.f48669f.closeActivity();
        }
    }

    public final boolean L(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (this.f48668e.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.f48668e;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (b0()) {
                return false;
            }
            this.f48669f.isPageStayDurationClose = true;
            r0();
            if (b.a.q0.s.e0.b.j().g("frs_game_login_tip", true)) {
                b.a.q0.s.e0.b.j().t("frs_login_tip", true);
                b.a.q0.s.e0.b.j().t("frs_game_login_tip", false);
            }
            a0(list);
            if (this.f48669f.getTabController() != null) {
                this.f48669f.getTabController().S(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData) == null) {
            boolean z2 = false;
            if (y0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
                if (this.F != null) {
                    b.a.e.e.m.e.a().removeCallbacks(this.F);
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
                runnable = new z(this, forumData);
            }
            this.F = runnable;
            b.a.e.e.m.e.a().postDelayed(this.F, 60000L);
        }
    }

    public final void N(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, forumData) == null) || this.f48669f.getHeaderVC() == null || this.E == null) {
            return;
        }
        if (forumData == null) {
            forumData = this.f48671h.getForum();
        }
        if (forumData == null || forumData.isLike() == 1) {
            return;
        }
        if (!this.I) {
            this.H = true;
        } else if (!y0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) || this.F == null) {
        } else {
            b.a.e.e.m.e.a().removeCallbacks(this.F);
        }
    }

    public final FragmentManager O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsActivity frsActivity = this.f48668e;
            if (frsActivity != null) {
                return frsActivity.getSupportFragmentManager();
            }
            return null;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public FrsFragment P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48669f : (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.f48670g;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.getTabHost();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public final int R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            i0 i0Var = this.f48672i;
            if (i0Var != null && i2 < ListUtils.getCount(i0Var.f())) {
                return this.f48672i.f().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int S(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            i0 i0Var = this.f48672i;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.f());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f48672i.f().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public TbPageTag T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!b0()) {
                return this.f48669f.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.f48670g;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.getCurrentTabType()) {
                    return this.f48669f.getTbPageTag();
                }
                Fragment currentFragment = this.f48670g.getCurrentFragment();
                if (currentFragment instanceof BaseFragment) {
                    return ((BaseFragment) currentFragment).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public b.a.r0.l3.m U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f48671h : (b.a.r0.l3.m) invokeV.objValue;
    }

    public final boolean V(b.a.r0.l3.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mVar)) == null) {
            if (mVar != null && mVar.getUserData() != null) {
                int is_manager = mVar.getUserData().getIs_manager();
                boolean g2 = b.a.q0.s.e0.b.j().g("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !g2) {
                    x0(1, this.f48668e.getString(h1.forum_tool_first_bazhu_content), String.valueOf(d1.pic_mask_update), "");
                    b.a.q0.s.e0.b.j().t("key_forum_tool_find_dialog_show", true);
                    return true;
                } else if (!g2 && is_manager == 2) {
                    x0(2, this.f48668e.getString(h1.forum_tool_first_bawu_content), String.valueOf(d1.pic_mask_update), "");
                    b.a.q0.s.e0.b.j().t("key_forum_tool_find_dialog_show", true);
                    return true;
                } else {
                    AddBawuPopInfo addBawuPopInfo = mVar.bawuPopInfo;
                    if (addBawuPopInfo != null) {
                        x0(3, addBawuPopInfo.content, addBawuPopInfo.img_url, addBawuPopInfo.jump_url);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean W(ForumData forumData, AntiData antiData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, forumData, antiData)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void X(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) || (frsActivity = this.f48668e) == null) {
            return;
        }
        frsActivity.setContentView(f1.frs_base_layout);
        this.s = (FrsBaseViewPager) this.f48668e.findViewById(e1.frs_base_viewpager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this, this.f48668e.getSupportFragmentManager());
        this.t = fragmentAdapter;
        this.s.setAdapter(fragmentAdapter);
        this.s.setPageTransformer(true, new CubeOutViewPagerTransformer());
        this.s.addOnPageChangeListener(this.i0);
        this.s.setmDisallowSlip(true);
        this.s.setOnTouchEventListener(this.j0);
        b.a.q0.s.u.c.d(this.s).f(b1.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.f48668e.findViewById(e1.frs_post_forum_button);
        this.u = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.u.setHasShadow(false);
        this.w = (FrameLayout) this.f48668e.findViewById(e1.frs_bottom_extra);
        this.v = (FRSRefreshButton) this.f48668e.findViewById(e1.frs_refresh_forum_button);
        this.x = (LinearLayout) this.f48668e.findViewById(e1.frs_ll_redpack);
        this.f48668e.registerListener(this.W);
        this.f48668e.registerListener(this.X);
        this.N.getHttpMessageListener().setPriority(-1);
        this.N.getSocketMessageListener().setPriority(-1);
        this.f48668e.registerListener(this.O);
        this.Q.setSelfListener(true);
        this.f48668e.registerListener(this.Q);
        this.P.setSelfListener(true);
        this.f48668e.registerListener(this.P);
        this.f48668e.registerListener(this.V);
        if (bundle == null) {
            this.l = this.f48668e.getIntent().getStringExtra("name");
            this.m = this.f48668e.getIntent().getStringExtra("from");
            this.n = this.f48668e.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.l = bundle.getString("name");
            this.m = bundle.getString("from");
            this.n = bundle.getInt("default_tab_id", 0);
        }
        Y(bundle);
        this.t.notifyDataSetChanged();
        this.q = new ShareSuccessReplyToServerModel();
        this.f48668e.registerListener(this.N);
        this.f48668e.registerListener(this.L);
        this.f48668e.registerListener(this.M);
        this.f48668e.registerListener(this.S);
        this.f48668e.registerListener(this.b0);
        this.f48668e.registerListener(this.T);
        this.c0.setPriority(Integer.MAX_VALUE);
        this.c0.setSelfListener(true);
        this.f48668e.registerListener(this.c0);
    }

    public final void Y(Bundle bundle) {
        FragmentManager O;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) || (O = O()) == null || O.isDestroyed() || (fragmentAdapter = this.t) == null) {
            return;
        }
        try {
            FrsFragment frsFragment = (FrsFragment) fragmentAdapter.findFragmentByTag(n0);
            if (frsFragment == null) {
                frsFragment = e0(bundle);
            }
            frsFragment.setWriteIcon(this.u);
            frsFragment.setmRefreshIcon(this.v);
            frsFragment.setmFrsllRedpack(this.x);
            if (n0.equals(this.t.getItemTag(0))) {
                return;
            }
            if (o0.equals(this.t.getItemTag(0))) {
                this.t.remove(0);
            }
            this.t.add(0, frsFragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Z() {
        FragmentManager O;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (O = O()) == null || O.isDestroyed() || (fragmentAdapter = this.t) == null) {
            return;
        }
        try {
            FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) fragmentAdapter.findFragmentByTag(o0);
            if (frsTabHostFragment == null) {
                frsTabHostFragment = f0();
            }
            frsTabHostFragment.setWriteIcon(this.u);
            frsTabHostFragment.setRefreshIcon(this.v);
            if (o0.equals(this.t.getItemTag(0))) {
                return;
            }
            if (n0.equals(this.t.getItemTag(0))) {
                this.t.remove(0);
            }
            this.t.add(0, frsTabHostFragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a0(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        t tVar = new t(this, 2001616);
        tVar.setPriority(Integer.MAX_VALUE);
        tVar.setSelfListener(true);
        this.f48668e.registerListener(tVar);
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
        this.f48672i = new i0(this.f48668e.getActivity(), arrayList);
        if (P() != null) {
            this.f48672i.j(P().getForumId());
            this.f48672i.k(P().getForumName());
            if (P().getFrsViewData() != null && P().getFrsViewData().getForum() != null) {
                ForumData forum = P().getFrsViewData().getForum();
                this.f48672i.i(forum.getForumGameLabel());
                this.f48672i.l(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.f48669f;
        frsFragment.isPageStayDurationClose = false;
        new b.a.r0.x0.h2.e(frsFragment).a(this.f48672i);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.f48672i);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.f48668e.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean b0() {
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

    public boolean c0(long j2) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
            b.a.r0.l3.m mVar = this.f48671h;
            return (mVar == null || j2 == 0 || (forum = mVar.getForum()) == null || b.a.e.e.m.b.g(forum.getId(), 0L) != j2) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    public final void d0() {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (i0Var = this.f48672i) == null || TextUtils.isEmpty(i0Var.c())) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021074);
        httpMessage.addParam("forum_id", this.f48671h.getForum().getId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // b.a.r0.g.e.b
    public void dispatchInjectPluginMessage(b.a.r0.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dVar) == null) {
            FrsFragment frsFragment = this.f48669f;
            if (frsFragment instanceof b.a.r0.g.e.b) {
                frsFragment.dispatchInjectPluginMessage(dVar);
            }
        }
    }

    public final FrsFragment e0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bundle)) == null) {
            if (this.f48669f == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.f48669f = frsFragment;
                frsFragment.setArguments(bundle);
                this.f48669f.setBaseTag(n0);
            }
            FrsFragment frsFragment2 = this.f48669f;
            frsFragment2.isPageStayDurationClose = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    public final FrsTabHostFragment f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f48670g == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.f48670g = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(o0);
                this.f48670g.setDefaultTabId(this.n);
            }
            return this.f48670g;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public void g0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i2, i3, intent) == null) {
            if (!b0()) {
                this.f48669f.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f48670g;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.getCurrentTabType()) {
                        this.f48669f.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment currentFragment = this.f48670g.getCurrentFragment();
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
                        b.a.r0.y2.a.g().m(this.f48668e.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.q) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.w(str, intExtra2, new x(this));
                    }
                } else if (i2 == 13011) {
                    b.a.r0.y2.a.g().m(this.f48668e.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.f48670g;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.getWriteTab() != null) {
                        this.f48670g.getWriteTab().n(this.f48668e.getPageContext());
                        return;
                    }
                    FrsFragment frsFragment = this.f48669f;
                    if (frsFragment == null || frsFragment.getFrsView() == null || this.f48669f.getFrsView().X() == null || this.f48669f.getFrsView().X().f26848g == null) {
                        return;
                    }
                    this.f48669f.getFrsView().X().f26848g.n(this.f48668e.getPageContext());
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public b.a.e.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (!b0()) {
                FrsFragment frsFragment = this.f48669f;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).getFrsCommonImageLayoutPool();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f48670g;
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
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.r0.g.e.b
    public b.a.r0.g.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            FrsFragment frsFragment = this.f48669f;
            if (frsFragment instanceof b.a.r0.g.e.b) {
                return frsFragment.getInjectPlugin(i2);
            }
            return null;
        }
        return (b.a.r0.g.e.a) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!b0()) {
                return this.f48669f.getVoiceManager();
            }
            FrsTabHostFragment frsTabHostFragment = this.f48670g;
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

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1 && skinType != 4) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.f48668e);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.f48668e);
            }
            FrsFragment frsFragment = this.f48669f;
            if (frsFragment != null) {
                frsFragment.onChangeSkinType(i2);
            }
            FrsTabHostFragment frsTabHostFragment = this.f48670g;
            if (frsTabHostFragment != null) {
                frsTabHostFragment.onChangeSkinType(i2);
            }
            q0();
        }
    }

    public void i0() {
        b.a.r0.x0.x2.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.SCROLL_LISTENER_TAG);
            this.k.removeCallbacksAndMessages(null);
            if (this.f48668e.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.f48668e;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.U != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.U);
            }
            b.a.q0.s.e0.b.j().t(this.o, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.q;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.f48669f;
            if (frsFragment != null && frsFragment.getModelController() != null) {
                this.f48669f.getModelController().D0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.A;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.onDestroy();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.m)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.m)) {
                b.a.q0.y.d.h().i(false);
            }
            if (this.F != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.F);
            }
            b.a.r0.l3.m mVar = this.f48671h;
            if (mVar != null && mVar.getForum() != null && (eVar = this.E) != null) {
                eVar.b(b.a.e.e.m.b.g(this.f48671h.getForum().getId(), 0L));
            }
            b.a.e.e.m.e.a().removeCallbacks(this.m0);
        }
    }

    public boolean j0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    FrsFragment frsFragment = this.f48669f;
                    if (frsFragment == null || !frsFragment.isAdded()) {
                        return false;
                    }
                    return this.f48669f.onKeyDown(i2, keyEvent);
                }
                return this.f48668e.onSuperKeyDown(i2, keyEvent);
            } else if (this.J) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                return false;
            } else if (this.K) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921642));
                return true;
            } else if (b0() && (frsTabHostFragment = this.f48670g) != null && frsTabHostFragment.isWriteTabShowing()) {
                this.f48670g.hideWriteTab();
                UtilHelper.setNavigationBarBackground(this.f48668e, this.f48670g.getBottomNavigationBarColor());
                return false;
            } else {
                FrsFragment frsFragment2 = this.f48669f;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    if (this.f48669f.onKeyDown(i2, keyEvent)) {
                        return true;
                    }
                    K();
                    return false;
                }
                return this.f48668e.onSuperKeyDown(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void k0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, intent) == null) || (frsFragment = this.f48669f) == null) {
            return;
        }
        frsFragment.onNewIntent(intent);
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.I = false;
            b.a.r0.x0.x2.e eVar = this.E;
            if (eVar != null) {
                eVar.d();
            }
            if (!b0()) {
                this.f48669f.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f48670g;
                if (frsTabHostFragment != null) {
                    Fragment currentFragment = frsTabHostFragment.getCurrentFragment();
                    if (currentFragment instanceof BaseFragment) {
                        ((BaseFragment) currentFragment).setPrimary(false);
                    }
                }
            }
            b.a.q0.d1.b0.g().i();
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                b.a.e.e.m.e.a().postDelayed(this.m0, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.k0);
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (!b0()) {
                this.f48669f.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f48670g;
                if (frsTabHostFragment != null) {
                    Fragment currentFragment = frsTabHostFragment.getCurrentFragment();
                    if (currentFragment instanceof BaseFragment) {
                        ((BaseFragment) currentFragment).setPrimary(true);
                    }
                }
            }
            if (this.r) {
                this.r = false;
                FrsFragment frsFragment = this.f48669f;
                if (frsFragment != null) {
                    frsFragment.refresh();
                }
            }
            b.a.r0.l3.m mVar = this.f48671h;
            if (mVar != null && mVar.getUserData() != null && this.f48671h.getUserData().getNewGodData() != null) {
                if (this.f48671h.getForum() != null) {
                    b.a.q0.d1.b0.g().j(this.f48671h.getForum().getId());
                }
                b.a.q0.d1.b0.g().k(2, this.f48671h.getUserData().getNewGodData());
            }
            this.I = true;
            if (this.H) {
                N(null);
            }
            ItemCardHelper.v(this.l0);
            MessageManager.getInstance().registerListener(this.k0);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                b.a.q0.w.c.q().w(downloadData);
            }
        }
    }

    public void n0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            bundle.putString("name", this.l);
            bundle.putInt("default_tab_id", this.n);
            bundle.putString("from", this.m);
        }
    }

    public void o0(String str) {
        b.a.r0.l3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || (mVar = this.f48671h) == null || mVar.getForum() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f48671h.getForum().getId()).param("obj_type", 2));
    }

    public final void p0(b.a.r0.l3.m mVar, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{mVar, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || mVar == null || mVar.getForum() == null) {
            return;
        }
        this.f48671h = mVar;
        ForumData forum = mVar.getForum();
        if (z2 && forum != null && !TextUtils.isEmpty(forum.getId())) {
            FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
        }
        if (!V(mVar) && z2) {
            boolean W = W(forum, mVar.getAnti());
            FrsFragment frsFragment = this.f48669f;
            if (frsFragment != null) {
                frsFragment.setYoungsterDialogShown(W);
            }
            if (!(!W ? z0(mVar) : false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
        }
        if (forum.getIsShowBawuTask() && b.a.q0.s.e0.b.j().k("key_bawu_task_toast", 0) == 0 && !this.B) {
            this.B = true;
            b.a.e.e.m.e.a().postDelayed(new n(this), 30000L);
        }
        if (mVar.bazhuExam != null && !this.C && z2) {
            b.a.r0.x0.m.a(this.f48668e.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
            this.C = true;
        }
        if (ListUtils.getCount(mVar.getGameTabInfo()) > 0) {
            this.k.post(new o(this));
        } else if (b0()) {
            this.k.post(new p(this));
        }
        q0();
        w0();
        if (z2) {
            if ((!this.G || i2 == 4) && forum.isLike() == 0 && b.a.q0.b.d.j0() && TbadkCoreApplication.isLogin()) {
                this.E = new b.a.r0.x0.x2.e();
                this.f48668e.registerListener(this.Z);
                this.f48668e.registerListener(this.Y);
                this.f48668e.registerListener(this.a0);
                M(forum);
            }
        }
    }

    public final void q0() {
        b.a.r0.l3.m mVar;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (mVar = this.f48671h) == null || (themeColorInfo = mVar.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.f48668e.registerListener(1021074, this.R);
        }
    }

    public void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.n = i2;
        }
    }

    @Override // b.a.r0.g.e.b
    public void setInjectPlugin(int i2, b.a.r0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048616, this, i2, aVar) == null) {
            FrsFragment frsFragment = this.f48669f;
            if (frsFragment instanceof b.a.r0.g.e.b) {
                frsFragment.setInjectPlugin(i2, aVar);
            }
        }
    }

    public void t0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.p = i2;
        }
    }

    public final void u0(Fragment fragment, int i2) {
        b.a.r0.l3.m mVar;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048618, this, fragment, i2) == null) || !(fragment instanceof q0) || (mVar = this.f48671h) == null || mVar.getForum() == null || (navigationBar = ((q0) fragment).getNavigationBar()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f48671h.getForum().getName(), 5, true, true) + this.f48668e.getActivity().getString(h1.forum));
        navigationBar.setCenterTextTitle(sb.toString());
    }

    public final void v0() {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (frsActivity = this.f48668e) == null) {
            return;
        }
        if (this.A == null) {
            this.A = (NavigationBarCoverTip) frsActivity.findViewById(e1.navigation_cover_tip);
        }
        if (this.A == null) {
            return;
        }
        View inflate = View.inflate(this.f48668e, f1.write_thread_share_guide, null);
        TextView textView = (TextView) inflate.findViewById(e1.write_thread_success_tips);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(e1.share_icon);
        if (TextUtils.isEmpty(this.l)) {
            textView.setText("吧主您好，本吧考核新制度上线啦");
        } else {
            textView.setText(this.l + "吧吧主您好，本吧考核新制度上线啦");
        }
        tBSpecificationBtn.setTextSize(c1.tbds34);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(h1.check_immediately));
        b.a.q0.s.g0.n.c cVar = new b.a.q0.s.g0.n.c();
        cVar.s();
        tBSpecificationBtn.setConfig(cVar);
        tBSpecificationBtn.changeSkinType();
        SkinManager.setViewTextColor(textView, b1.CAM_X0101);
        SkinManager.setBackgroundColor(this.A, b1.cp_link_tip_a_alpha95);
        tBSpecificationBtn.setOnClickListener(new y(this));
        this.A.showTip(this.f48668e, inflate, 30000);
        new StatisticItem("c13438").eventStat();
        int k2 = b.a.q0.s.e0.b.j().k("key_bawu_task_toast", 0);
        if (k2 >= 0) {
            b.a.q0.s.e0.b.j().v("key_bawu_task_toast", k2 + 1);
        }
    }

    public final void w0() {
        b.a.r0.l3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (mVar = this.f48671h) == null || mVar.getEntelechyTabInfo() == null || this.f48671h.getEntelechyTabInfo().f20737a == null) {
            return;
        }
        if (this.f48668e.getIntent() == null || !FrsActivityConfig.FRS_FROM_ITEM.equals(this.f48668e.getIntent().getStringExtra("from"))) {
            boolean z2 = false;
            Iterator<FrsTabInfo> it = this.f48671h.getEntelechyTabInfo().f20737a.iterator();
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
                    b.a.r0.f0.g gVar = new b.a.r0.f0.g(this.f48668e.getPageContext(), this.u);
                    this.D = gVar;
                    gVar.g0(d1.pic_sign_tip_down);
                    this.D.L(2);
                    this.D.h0(true);
                    this.D.j0(-b.a.e.e.p.l.g(this.f48668e, c1.tbds20));
                    this.D.k0(-b.a.e.e.p.l.g(this.f48668e, c1.tbds20));
                    this.D.X(b1.CAM_X0101);
                    this.D.P(c1.tbds54);
                    this.D.a0(b.a.e.e.p.l.g(this.f48668e, c1.tbds44));
                }
                this.D.m0(this.f48668e.getString(h1.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    public final void x0(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f48668e);
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.f48668e);
            frsForumToolDialogView.setStartLoadUrl(i2, str2);
            frsForumToolDialogView.setContent(str);
            frsForumToolDialogView.setCancleButtonListener(new r(this, aVar));
            frsForumToolDialogView.setConfirmButtonListener(new s(this, aVar, i2, str3));
            aVar.setContentView(frsForumToolDialogView);
            aVar.create(this.f48668e.getPageContext()).show();
        }
    }

    public final boolean y0(String str, String str2, String str3, boolean z2) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{str, str2, str3, Boolean.valueOf(z2)})) == null) {
            if (!this.E.g(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.f48669f) == null || frsFragment.getHeaderVC() == null) {
                return false;
            }
            this.H = false;
            this.E.h(this.f48668e, str, str2, str3, this.f48669f.getHeaderVC().v());
            this.E.e().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean z0(b.a.r0.l3.m mVar) {
        InterceptResult invokeL;
        PopInfo popInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, mVar)) == null) {
            if (b.a.q0.s.e0.b.j().g(b.a.q0.s.e0.b.n("key_frs_shield_thread_dialog"), false) || mVar.getUserData() == null || mVar.getUserData().getIs_manager() <= 0 || (popInfo = mVar.frsMaskPopInfo) == null || popInfo.if_pop.intValue() != 1) {
                return false;
            }
            ImageView imageView = new ImageView(this.f48668e);
            imageView.setImageResource(SkinManager.getResourceId(d1.pic_frs_popup_shield));
            TBAlertConfig.a aVar = new TBAlertConfig.a(h1.comment_tab_dialog_botton_text, TBAlertConfig.OperateBtnStyle.MAIN);
            b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f48668e);
            lVar.r(mVar.frsMaskPopInfo.title);
            lVar.n(mVar.frsMaskPopInfo.v_title);
            lVar.l(true);
            lVar.h(imageView);
            lVar.p(aVar);
            lVar.g(false);
            aVar.a(new q(this, lVar.t(), mVar));
            b.a.q0.s.e0.b.j().t(b.a.q0.s.e0.b.n("key_frs_shield_thread_dialog"), true);
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
