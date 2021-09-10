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
import c.a.q0.s.s.a;
import c.a.r0.w0.i0;
import c.a.r0.w0.q0;
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
import tbclient.FrsPage.TipInfo;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class FrsTabController implements c.a.r0.f.e.b, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String l0;
    public static final String m0;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBarCoverTip A;
    public boolean B;
    public boolean C;
    public c.a.r0.e0.e D;
    public c.a.r0.w0.n2.e E;
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
    public FrsActivity f51294e;

    /* renamed from: f  reason: collision with root package name */
    public FrsFragment f51295f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabHostFragment f51296g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j3.m f51297h;

    /* renamed from: i  reason: collision with root package name */
    public i0 f51298i;
    public CustomMessageListener i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f51299j;
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
        public List<BaseFragment> f51300a;

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
            this.f51300a = new ArrayList(2);
        }

        public boolean add(BaseFragment baseFragment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragment)) == null) ? ListUtils.add(this.f51300a, baseFragment) : invokeL.booleanValue;
        }

        public BaseFragment findFragmentByTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (c.a.e.e.p.k.isEmpty(str)) {
                    return null;
                }
                for (BaseFragment baseFragment : this.f51300a) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51300a.size() : invokeV.intValue;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (BaseFragment) ListUtils.remove(this.f51300a, i2) : (BaseFragment) invokeI.objValue;
        }

        public BaseFragment removeFragmentByTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                if (c.a.e.e.p.k.isEmpty(str)) {
                    return null;
                }
                Iterator<BaseFragment> it = this.f51300a.iterator();
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
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, baseFragment)) == null) ? ListUtils.add(this.f51300a, i2, baseFragment) : invokeIL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public BaseFragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (BaseFragment) ListUtils.getItem(this.f51300a, i2) : (BaseFragment) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51301a;

        /* renamed from: com.baidu.tieba.frs.gametab.FrsTabController$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1758a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f51302e;

            public View$OnClickListenerC1758a(a aVar) {
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
                this.f51302e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f51302e.f51301a.f51297h.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.r0.j3.i0.n(this.f51302e.f51301a.f51294e, "RecommendHistoryPage", hashMap)));
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
            this.f51301a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof FrsRecommendResMsg)) {
                if (httpResponsedMessage.getError() != 0) {
                    new BdTopToast(this.f51301a.f51294e).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show((ViewGroup) this.f51301a.f51294e.findViewById(R.id.frs));
                    return;
                }
                FrsRecommendResMsg frsRecommendResMsg = (FrsRecommendResMsg) httpResponsedMessage;
                int pushStatus = frsRecommendResMsg.getPushStatus();
                String pushMsg = frsRecommendResMsg.getPushMsg();
                if (pushStatus == 1) {
                    new ScreenTopToast(this.f51301a.f51294e).setTitle(this.f51301a.f51294e.getString(R.string.frs_recommend_suc_tip_title)).setContent(this.f51301a.f51294e.getString(R.string.frs_recommend_suc_tip_content)).setBtnText(this.f51301a.f51294e.getString(R.string.dialog_confirm_see)).setBtnClickListener(new View$OnClickListenerC1758a(this)).show((ViewGroup) this.f51301a.f51294e.findViewById(R.id.frs));
                } else {
                    new BdTopToast(this.f51301a.f51294e).setIcon(false).setContent(pushMsg).show((ViewGroup) this.f51301a.f51294e.findViewById(R.id.frs));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51303a;

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
            this.f51303a = frsTabController;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.r0.j3.m mVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f51303a.f51299j || responsedMessage.hasError() || responsedMessage.getError() != 0) {
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
                this.f51303a.f51299j = true;
                this.f51303a.o0(mVar, true, i2);
                if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                    c.a.q0.s.o.a.b().l("2", mVar.getForum().getId());
                }
            }
            if (mVar == null || mVar.getUserData() == null || mVar.getUserData().getNewGodData() == null) {
                return;
            }
            if (mVar.getForum() != null) {
                c.a.q0.d1.z.g().j(mVar.getForum().getId());
            }
            c.a.q0.d1.z.g().k(2, mVar.getUserData().getNewGodData());
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51304a;

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
            this.f51304a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f51304a.r = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51305a;

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
            this.f51305a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.f51305a.f51299j && this.f51305a.f51297h == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.j3.m)) {
                c.a.r0.j3.m mVar = (c.a.r0.j3.m) customResponsedMessage.getData();
                if (mVar.getForum() == null || this.f51305a.l == null || !this.f51305a.l.equals(mVar.getForum().getName())) {
                    return;
                }
                this.f51305a.o0(mVar, false, -1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51306a;

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
            this.f51306a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f51306a.s == null || this.f51306a.t == null || !(customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                return;
            }
            FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
            this.f51306a.y = aVar.a();
            this.f51306a.z = aVar.b();
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51307a;

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
            this.f51307a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f51307a.J();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51308a;

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
            this.f51308a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f51308a.s == null || this.f51308a.t == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f51308a.s.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes7.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51309a;

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
            this.f51309a = frsTabController;
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
                R = this.f51309a.R(9);
                if (R == -1) {
                    R = this.f51309a.R(2);
                }
            } else {
                R = this.f51309a.R(intValue);
            }
            if (R == -1 || !this.f51309a.a0() || this.f51309a.f51296g == null) {
                return;
            }
            this.f51309a.f51296g.setCurrentTab(R);
            if (this.f51309a.Q(R) != 1) {
                this.f51309a.f51295f.setCanShowSpeedTipView(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51310a;

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
            this.f51310a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f51310a.M(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51311a;

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
            this.f51311a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<c.a.r0.w0.x1.a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.f51311a.f51296g == null) {
                    return;
                }
                for (c.a.r0.w0.x1.a aVar : newNotifyData) {
                    if (aVar != null) {
                        for (int i3 = 0; i3 < this.f51311a.f51298i.g().size(); i3++) {
                            FragmentTabHost.b tabSpec = this.f51311a.f51296g.getTabSpec(i3);
                            if (tabSpec != null && (i2 = tabSpec.f47567a) != 1 && i2 != this.f51311a.f51296g.getCurrentTabType() && tabSpec.f47567a == aVar.a() && aVar.b() && tabSpec.f47568b.getTip(String.valueOf(tabSpec.f47567a)) != null) {
                                tabSpec.f47568b.getTip(String.valueOf(tabSpec.f47567a)).f48413a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51312a;

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
            this.f51312a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f51312a.E == null || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ForumData) {
                this.f51312a.M((ForumData) customResponsedMessage.getData());
            } else if (customResponsedMessage.getData() instanceof Long) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.f51312a.b0(longValue) && this.f51312a.E.a(longValue) >= 3) {
                    this.f51312a.E.b(longValue);
                    this.f51312a.H = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51313a;

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
            this.f51313a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.f51313a.f51294e, 2000).setIcon(false).setContent(this.f51313a.f51294e.getString(R.string.frs_top_forum_rules_click_toast)).show((ViewGroup) this.f51313a.f51294e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51314a;

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
            this.f51314a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.j3.r0.k)) {
                c.a.r0.j3.r0.k kVar = (c.a.r0.j3.r0.k) customResponsedMessage.getData();
                if (this.f51314a.E == null || kVar == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.f51314a.E.c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(kVar.f21117a));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51315e;

        public g0(FrsTabController frsTabController) {
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
            this.f51315e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.e.e.m.e.a().removeCallbacks(this);
                this.f51315e.c0();
                c.a.e.e.m.e.a().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51316a;

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
            this.f51316a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.f51316a.J = booleanValue;
                if (booleanValue) {
                    this.f51316a.u.setVisibility(8);
                } else {
                    this.f51316a.u.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51317a;

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
            this.f51317a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof c.a.r0.w0.l2.a) || ((c.a.r0.w0.l2.a) customResponsedMessage.getData()).f26997a == null) {
                this.f51317a.w.removeAllViews();
                this.f51317a.w.setVisibility(8);
                return;
            }
            View view = ((c.a.r0.w0.l2.a) customResponsedMessage.getData()).f26997a;
            if (view.getParent() != null) {
                if (((ViewGroup) view.getParent()) != this.f51317a.w) {
                    ((ViewGroup) view.getParent()).removeView(view);
                    this.f51317a.w.removeAllViews();
                    this.f51317a.w.addView(view);
                }
            } else {
                this.f51317a.w.removeAllViews();
                this.f51317a.w.addView(view);
            }
            this.f51317a.w.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public class j implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51318e;

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
            this.f51318e = frsTabController;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && i2 == 0) {
                this.f51318e.z = false;
                this.f51318e.s.setForceIntercept(false);
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
            this.f51318e.u.setVisibility(0);
            if (this.f51318e.O() != null) {
                this.f51318e.O().setLiteProgramListFragmentSelect(false);
            }
            this.f51318e.f51295f.showRefreshIcon();
        }
    }

    /* loaded from: classes7.dex */
    public class k implements FrsBaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51319a;

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
            this.f51319a = frsTabController;
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51319a.s == null) {
                return;
            }
            if (this.f51319a.s.getCurrentItem() == 0) {
                this.f51319a.s.setmDisallowSlip(true);
            } else {
                this.f51319a.s.setmDisallowSlip(false);
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f51319a.s.getCurrentItem() == 0) {
                    if (this.f51319a.y && this.f51319a.z) {
                        this.f51319a.s.setmDisallowSlip(false);
                    }
                    if (!this.f51319a.z) {
                        this.f51319a.s.setmDisallowSlip(true);
                    }
                    this.f51319a.s.setmDisallowSlip(true);
                } else {
                    this.f51319a.s.setmDisallowSlip(true);
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
        public final /* synthetic */ FrsTabController f51320a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f51321e;

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
                this.f51321e = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f51321e.f51320a.f51297h.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.r0.j3.i0.n(this.f51321e.f51320a.f51294e, "ForumGradePage", hashMap)));
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
            this.f51320a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new ScreenTopToast(this.f51320a.f51294e).setTitle(this.f51320a.f51294e.getString(R.string.frs_recommend_fail_month_tip)).setBtnText(this.f51320a.f51294e.getString(R.string.frs_recommend_fail_tip_btn)).setBtnClickListener(new a(this)).show((ViewGroup) this.f51320a.f51294e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51322e;

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
            this.f51322e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51322e.u0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51323e;

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
            this.f51323e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FrsTabController frsTabController = this.f51323e;
                boolean K = frsTabController.K(frsTabController.f51297h.getGameTabInfo());
                if (K) {
                    this.f51323e.t.notifyDataSetChanged();
                    if (K && this.f51323e.f51296g != null) {
                        this.f51323e.f51296g.setFrsMainFragment(this.f51323e.f51295f);
                        this.f51323e.f51296g.processAddTabResponse(this.f51323e.f51297h, this.f51323e.f51298i);
                    }
                }
                if (this.f51323e.f51294e.isLoadingViewAttached()) {
                    this.f51323e.f51294e.hideLoadingView(this.f51323e.f51294e.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51324e;

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
            this.f51324e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51324e.f51295f.isPageStayDurationClose = true;
                this.f51324e.X(this.f51324e.f51295f != null ? this.f51324e.f51295f.getArguments() : null);
                this.f51324e.t.notifyDataSetChanged();
                if (this.f51324e.f51294e.isLoadingViewAttached()) {
                    this.f51324e.f51294e.hideLoadingView(this.f51324e.f51294e.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f51325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j3.m f51326f;

        public p(FrsTabController frsTabController, AlertDialog alertDialog, c.a.r0.j3.m mVar) {
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
            this.f51325e = alertDialog;
            this.f51326f = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f51325e) == null) {
                return;
            }
            alertDialog.dismiss();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_CANCEL);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.f51326f.getForum() != null) {
                statisticItem.param("fid", this.f51326f.getForum().getId());
                statisticItem.param("fname", this.f51326f.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f51327e;

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
            this.f51327e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.q0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f51327e) == null) {
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
        public final /* synthetic */ c.a.q0.s.s.a f51328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f51330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51331h;

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
            this.f51331h = frsTabController;
            this.f51328e = aVar;
            this.f51329f = i2;
            this.f51330g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.s.s.a aVar = this.f51328e;
                if (aVar != null) {
                    aVar.dismiss();
                }
                int i2 = this.f51329f;
                if (i2 == 1) {
                    UrlManager.getInstance().dealOneLink(this.f51331h.f51294e.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + this.f51331h.O().getForumName() + "&fid=" + this.f51331h.O().getForumId()});
                } else if (i2 == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.f51331h.O().getForumId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.r0.j3.i0.n(this.f51331h.f51294e, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                } else if (i2 != 3 || TextUtils.isEmpty(this.f51330g)) {
                } else {
                    UrlManager.getInstance().dealOneLink(this.f51331h.f51294e.getPageContext(), new String[]{this.f51330g});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f51332e;

        public s(FrsTabController frsTabController, c.a.q0.s.s.a aVar) {
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
            this.f51332e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f51332e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51333a;

        /* loaded from: classes7.dex */
        public class a extends c.a.q0.h0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ t f51334a;

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
                this.f51334a = tVar;
            }

            @Override // c.a.q0.h0.b
            public c.a.q0.h0.c createFragmentTabStructure() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.f51334a.f51333a.f51295f.getForumName());
                    bundle.putString("from", this.f51334a.f51333a.f51295f.getFrom());
                    bundle.putString("forum_id", this.f51334a.f51333a.f51295f.getForumId());
                    bundle.putInt("tab_id", 503);
                    bundle.putBoolean(FrsCommonTabFragment.CAN_AUTO_PLAY_VIDEO, this.f51334a.f51333a.f51297h.isFrsVideoAutoPlay);
                    bundle.putBoolean(FrsCommonTabFragment.NEED_LOG, this.f51334a.f51333a.f51297h.needLog == 1);
                    bundle.putBoolean(FrsCommonTabFragment.IS_BRAND_FORUM, this.f51334a.f51333a.f51297h.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.f51334a.f51333a.f51297h);
                    bundle.putSerializable(FrsCommonTabFragment.VIEW_DATA, frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    c.a.q0.h0.c cVar = new c.a.q0.h0.c();
                    cVar.f13467a = frsSportsRecommendFragment;
                    cVar.f13471e = 25;
                    cVar.f13475i = c.a.q0.h0.c.k;
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
            this.f51333a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i0)) {
                if (!c.a.q0.s.d0.b.j().g(this.f51333a.o, true)) {
                    c.a.e.e.m.e.a().post(this.f51333a.S);
                }
                ((i0) customResponsedMessage.getData()).a(new a(this));
                this.f51333a.Y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51335a;

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
            this.f51335a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.m(this.f51335a.f51294e, this.f51335a.f51294e.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.f51335a.f51294e.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51336a;

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
            this.f51336a = frsTabController;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                ItemCardHelper.x(this.f51336a.f51294e, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f51336a.f51294e.findViewById(R.id.frs), j2);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f51336a.f51294e, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f51336a.f51294e.findViewById(R.id.frs), 0L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51337e;

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
            this.f51337e = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                    parseUri.setFlags(268435456);
                    this.f51337e.f51294e.startActivity(parseUri);
                    TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51338a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f51339e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ x f51340f;

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
                this.f51340f = xVar;
                this.f51339e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51340f.f51338a.f51294e == null) {
                    return;
                }
                c.a.r0.j2.j.c.a(this.f51340f.f51338a.f51294e.getPageContext(), this.f51339e).show();
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
            this.f51338a = frsTabController;
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
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51341e;

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
            this.f51341e = frsTabController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                new StatisticItem("c13439").eventStat();
                if (this.f51341e.O() == null || TextUtils.isEmpty(this.f51341e.O().getForumId()) || TextUtils.isEmpty(this.f51341e.l) || this.f51341e.f51294e == null) {
                    return;
                }
                if (this.f51341e.A != null) {
                    this.f51341e.A.hideTip();
                }
                int i2 = c.a.q0.s.d0.b.j().k("key_bawu_task_toast", 0) == -1 ? 1 : 0;
                UrlManager.getInstance().dealOneLink(this.f51341e.f51294e.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.f51341e.O().getForumId() + "&fn=" + this.f51341e.l + "&noread=" + i2});
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumData f51342e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsTabController f51343f;

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
            this.f51343f = frsTabController;
            this.f51342e = forumData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51343f.E == null) {
                return;
            }
            if (this.f51343f.I) {
                this.f51343f.x0(this.f51342e.getName(), this.f51342e.getId(), this.f51342e.getImage_url(), true);
            } else {
                this.f51343f.H = true;
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
        this.f51299j = false;
        this.k = new Handler();
        this.n = 0;
        this.r = false;
        this.B = false;
        this.C = false;
        this.H = false;
        this.I = false;
        this.K = new a(this, CmdConfigHttp.CMD_FRS_RECOMMEND);
        this.L = new l(this, 2921465);
        this.M = new a0(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.N = new b0(this, 2001615);
        this.O = new c0(this, 2921342);
        this.P = new d0(this, 2001627);
        this.Q = new e0(this, 0);
        this.R = new f0(this, 2921518);
        this.S = new g0(this);
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
        this.i0 = new u(this, 2001440);
        this.j0 = new v(this);
        this.k0 = new w(this);
        this.f51294e = frsActivity;
        this.o = c.a.q0.s.d0.b.n("show_game_forem_tab_hot_point");
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.p != this.n && a0()) {
                this.f51296g.setCurrentTab(this.n);
                if (Q(this.n) != 1) {
                    this.f51295f.setCanShowSpeedTipView(false);
                }
                this.p = this.n;
                t0(this.f51296g.getCurrentFragment(), this.n);
                return;
            }
            this.f51295f.closeActivity();
        }
    }

    public final boolean K(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (this.f51294e.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.f51294e;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (a0()) {
                return false;
            }
            this.f51295f.isPageStayDurationClose = true;
            q0();
            if (c.a.q0.s.d0.b.j().g("frs_game_login_tip", true)) {
                c.a.q0.s.d0.b.j().t("frs_login_tip", true);
                c.a.q0.s.d0.b.j().t("frs_game_login_tip", false);
            }
            Z(list);
            if (this.f51295f.getTabController() != null) {
                this.f51295f.getTabController().S(true);
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
                runnable = new z(this, forumData);
            }
            this.F = runnable;
            c.a.e.e.m.e.a().postDelayed(this.F, 60000L);
        }
    }

    public final void M(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, forumData) == null) || this.f51295f.getHeaderVC() == null || this.E == null) {
            return;
        }
        if (forumData == null) {
            forumData = this.f51297h.getForum();
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
            FrsActivity frsActivity = this.f51294e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51295f : (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.f51296g;
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
            i0 i0Var = this.f51298i;
            if (i0Var != null && i2 < ListUtils.getCount(i0Var.g())) {
                return this.f51298i.g().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            i0 i0Var = this.f51298i;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.g());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f51298i.g().get(i3).tab_id.intValue() == i2) {
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
                return this.f51295f.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.f51296g;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.getCurrentTabType()) {
                    return this.f51295f.getTbPageTag();
                }
                Fragment currentFragment = this.f51296g.getCurrentFragment();
                if (currentFragment instanceof BaseFragment) {
                    return ((BaseFragment) currentFragment).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public c.a.r0.j3.m T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f51297h : (c.a.r0.j3.m) invokeV.objValue;
    }

    public final boolean U(c.a.r0.j3.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mVar)) == null) {
            if (mVar != null && mVar.getUserData() != null) {
                int is_manager = mVar.getUserData().getIs_manager();
                boolean g2 = c.a.q0.s.d0.b.j().g("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !g2) {
                    w0(1, this.f51294e.getString(R.string.forum_tool_first_bazhu_content), String.valueOf(R.drawable.pic_mask_update), "");
                    c.a.q0.s.d0.b.j().t("key_forum_tool_find_dialog_show", true);
                    return true;
                } else if (!g2 && is_manager == 2) {
                    w0(2, this.f51294e.getString(R.string.forum_tool_first_bawu_content), String.valueOf(R.drawable.pic_mask_update), "");
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
            if (forumData == null) {
                return false;
            }
            if (c.a.q0.g1.b.a.g(this.f51294e.getPageContext(), antiData, R.id.frs) || z0(forumData)) {
                return true;
            }
            List<TipInfo> tipInfos = forumData.getTipInfos();
            if (ListUtils.isEmpty(tipInfos)) {
                return false;
            }
            return c.a.q0.g1.b.a.f(this.f51294e.getPageContext(), tipInfos.get(0), TbadkCoreApplication.getCurrentAccount(), forumData.getId(), this.f51294e.getString(R.string.frs_risk_dialog_button_text));
        }
        return invokeLL.booleanValue;
    }

    public void W(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) || (frsActivity = this.f51294e) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.frs_base_layout);
        this.s = (FrsBaseViewPager) this.f51294e.findViewById(R.id.frs_base_viewpager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this, this.f51294e.getSupportFragmentManager());
        this.t = fragmentAdapter;
        this.s.setAdapter(fragmentAdapter);
        this.s.setPageTransformer(true, new CubeOutViewPagerTransformer());
        this.s.addOnPageChangeListener(this.b0);
        this.s.setmDisallowSlip(true);
        this.s.setOnTouchEventListener(this.c0);
        c.a.q0.s.u.c.d(this.s).f(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.f51294e.findViewById(R.id.frs_post_forum_button);
        this.u = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.u.setHasShadow(false);
        this.w = (FrameLayout) this.f51294e.findViewById(R.id.frs_bottom_extra);
        this.v = (FRSRefreshButton) this.f51294e.findViewById(R.id.frs_refresh_forum_button);
        this.x = (LinearLayout) this.f51294e.findViewById(R.id.frs_ll_redpack);
        this.f51294e.registerListener(this.U);
        this.f51294e.registerListener(this.V);
        this.M.getHttpMessageListener().setPriority(-1);
        this.M.getSocketMessageListener().setPriority(-1);
        this.f51294e.registerListener(this.N);
        this.P.setSelfListener(true);
        this.f51294e.registerListener(this.P);
        this.O.setSelfListener(true);
        this.f51294e.registerListener(this.O);
        this.f51294e.registerListener(this.T);
        if (bundle == null) {
            this.l = this.f51294e.getIntent().getStringExtra("name");
            this.m = this.f51294e.getIntent().getStringExtra("from");
            this.n = this.f51294e.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.l = bundle.getString("name");
            this.m = bundle.getString("from");
            this.n = bundle.getInt("default_tab_id", 0);
        }
        X(bundle);
        this.t.notifyDataSetChanged();
        this.q = new ShareSuccessReplyToServerModel();
        this.f51294e.registerListener(this.M);
        this.f51294e.registerListener(this.K);
        this.f51294e.registerListener(this.L);
        this.f51294e.registerListener(this.R);
        this.f51294e.registerListener(this.Z);
        this.a0.setPriority(Integer.MAX_VALUE);
        this.a0.setSelfListener(true);
        this.f51294e.registerListener(this.a0);
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
        t tVar = new t(this, 2001616);
        tVar.setPriority(Integer.MAX_VALUE);
        tVar.setSelfListener(true);
        this.f51294e.registerListener(tVar);
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
        this.f51298i = new i0(this.f51294e.getActivity(), arrayList);
        if (O() != null) {
            this.f51298i.k(O().getForumId());
            this.f51298i.l(O().getForumName());
            if (O().getFrsViewData() != null && O().getFrsViewData().getForum() != null) {
                ForumData forum = O().getFrsViewData().getForum();
                this.f51298i.j(forum.getForumGameLabel());
                this.f51298i.m(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.f51295f;
        frsFragment.isPageStayDurationClose = false;
        new c.a.r0.w0.x1.e(frsFragment).a(this.f51298i);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.f51298i);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.f51294e.getUniqueId());
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
            c.a.r0.j3.m mVar = this.f51297h;
            return (mVar == null || j2 == 0 || (forum = mVar.getForum()) == null || c.a.e.e.m.b.g(forum.getId(), 0L) != j2) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    public final void c0() {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (i0Var = this.f51298i) == null || TextUtils.isEmpty(i0Var.d())) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021074);
        httpMessage.addParam("forum_id", this.f51297h.getForum().getId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final FrsFragment d0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bundle)) == null) {
            if (this.f51295f == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.f51295f = frsFragment;
                frsFragment.setArguments(bundle);
                this.f51295f.setBaseTag(l0);
            }
            FrsFragment frsFragment2 = this.f51295f;
            frsFragment2.isPageStayDurationClose = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    @Override // c.a.r0.f.e.b
    public void dispatchInjectPluginMessage(c.a.r0.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) {
            FrsFragment frsFragment = this.f51295f;
            if (frsFragment instanceof c.a.r0.f.e.b) {
                frsFragment.dispatchInjectPluginMessage(dVar);
            }
        }
    }

    public final FrsTabHostFragment e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f51296g == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.f51296g = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(m0);
                this.f51296g.setDefaultTabId(this.n);
            }
            return this.f51296g;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public void f0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i2, i3, intent) == null) {
            if (!a0()) {
                this.f51295f.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f51296g;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.getCurrentTabType()) {
                        this.f51295f.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment currentFragment = this.f51296g.getCurrentFragment();
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
                        c.a.r0.x2.a.g().m(this.f51294e.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.q) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.w(str, intExtra2, new x(this));
                    }
                } else if (i2 == 13011) {
                    c.a.r0.x2.a.g().m(this.f51294e.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.f51296g;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.getWriteTab() != null) {
                        this.f51296g.getWriteTab().n(this.f51294e.getPageContext());
                        return;
                    }
                    FrsFragment frsFragment = this.f51295f;
                    if (frsFragment == null || frsFragment.getFrsView() == null || this.f51295f.getFrsView().Y() == null || this.f51295f.getFrsView().Y().f27392g == null) {
                        return;
                    }
                    this.f51295f.getFrsView().Y().f27392g.n(this.f51294e.getPageContext());
                }
            }
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1 && skinType != 4) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.f51294e);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.f51294e);
            }
            FrsFragment frsFragment = this.f51295f;
            if (frsFragment != null) {
                frsFragment.onChangeSkinType(i2);
            }
            FrsTabHostFragment frsTabHostFragment = this.f51296g;
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
                FrsFragment frsFragment = this.f51295f;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).getFrsCommonImageLayoutPool();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f51296g;
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

    @Override // c.a.r0.f.e.b
    public c.a.r0.f.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            FrsFragment frsFragment = this.f51295f;
            if (frsFragment instanceof c.a.r0.f.e.b) {
                return frsFragment.getInjectPlugin(i2);
            }
            return null;
        }
        return (c.a.r0.f.e.a) invokeI.objValue;
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
                return this.f51295f.getVoiceManager();
            }
            FrsTabHostFragment frsTabHostFragment = this.f51296g;
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
        c.a.r0.w0.n2.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.SCROLL_LISTENER_TAG);
            this.k.removeCallbacksAndMessages(null);
            if (this.f51294e.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.f51294e;
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
            FrsFragment frsFragment = this.f51295f;
            if (frsFragment != null && frsFragment.getModelController() != null) {
                this.f51295f.getModelController().D0();
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
            c.a.r0.j3.m mVar = this.f51297h;
            if (mVar != null && mVar.getForum() != null && (eVar = this.E) != null) {
                eVar.b(c.a.e.e.m.b.g(this.f51297h.getForum().getId(), 0L));
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
                    FrsFragment frsFragment = this.f51295f;
                    if (frsFragment == null || !frsFragment.isAdded()) {
                        return false;
                    }
                    return this.f51295f.onKeyDown(i2, keyEvent);
                }
                return this.f51294e.onSuperKeyDown(i2, keyEvent);
            } else if (this.J) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                return false;
            } else if (a0() && (frsTabHostFragment = this.f51296g) != null && frsTabHostFragment.isWriteTabShowing()) {
                this.f51296g.hideWriteTab();
                UtilHelper.setNavigationBarBackground(this.f51294e, this.f51296g.getBottomNavigationBarColor());
                return false;
            } else {
                FrsFragment frsFragment2 = this.f51295f;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    if (this.f51295f.onKeyDown(i2, keyEvent)) {
                        return true;
                    }
                    J();
                    return false;
                }
                return this.f51294e.onSuperKeyDown(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void j0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, intent) == null) || (frsFragment = this.f51295f) == null) {
            return;
        }
        frsFragment.onNewIntent(intent);
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.I = false;
            c.a.r0.w0.n2.e eVar = this.E;
            if (eVar != null) {
                eVar.d();
            }
            if (!a0()) {
                this.f51295f.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f51296g;
                if (frsTabHostFragment != null) {
                    Fragment currentFragment = frsTabHostFragment.getCurrentFragment();
                    if (currentFragment instanceof BaseFragment) {
                        ((BaseFragment) currentFragment).setPrimary(false);
                    }
                }
            }
            c.a.q0.d1.z.g().i();
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
                this.f51295f.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.f51296g;
                if (frsTabHostFragment != null) {
                    Fragment currentFragment = frsTabHostFragment.getCurrentFragment();
                    if (currentFragment instanceof BaseFragment) {
                        ((BaseFragment) currentFragment).setPrimary(true);
                    }
                }
            }
            if (this.r) {
                this.r = false;
                FrsFragment frsFragment = this.f51295f;
                if (frsFragment != null) {
                    frsFragment.refresh();
                }
            }
            c.a.r0.j3.m mVar = this.f51297h;
            if (mVar != null && mVar.getUserData() != null && this.f51297h.getUserData().getNewGodData() != null) {
                if (this.f51297h.getForum() != null) {
                    c.a.q0.d1.z.g().j(this.f51297h.getForum().getId());
                }
                c.a.q0.d1.z.g().k(2, this.f51297h.getUserData().getNewGodData());
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
        c.a.r0.j3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || (mVar = this.f51297h) == null || mVar.getForum() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f51297h.getForum().getId()).param("obj_type", 2));
    }

    public final void o0(c.a.r0.j3.m mVar, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{mVar, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || mVar == null || mVar.getForum() == null) {
            return;
        }
        this.f51297h = mVar;
        ForumData forum = mVar.getForum();
        if (!U(mVar) && z2) {
            boolean V = V(forum, mVar.getAnti());
            FrsFragment frsFragment = this.f51295f;
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
            c.a.r0.w0.m.a(this.f51294e.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
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
            if ((!this.G || i2 == 4) && forum.isLike() == 0 && c.a.q0.b.d.Y() && TbadkCoreApplication.isLogin()) {
                this.E = new c.a.r0.w0.n2.e();
                this.f51294e.registerListener(this.X);
                this.f51294e.registerListener(this.W);
                this.f51294e.registerListener(this.Y);
                L(forum);
            }
        }
    }

    public final void p0() {
        c.a.r0.j3.m mVar;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (mVar = this.f51297h) == null || (themeColorInfo = mVar.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
            this.f51294e.registerListener(1021074, this.Q);
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

    @Override // c.a.r0.f.e.b
    public void setInjectPlugin(int i2, c.a.r0.f.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048617, this, i2, aVar) == null) {
            FrsFragment frsFragment = this.f51295f;
            if (frsFragment instanceof c.a.r0.f.e.b) {
                frsFragment.setInjectPlugin(i2, aVar);
            }
        }
    }

    public final void t0(Fragment fragment, int i2) {
        c.a.r0.j3.m mVar;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048618, this, fragment, i2) == null) || !(fragment instanceof q0) || (mVar = this.f51297h) == null || mVar.getForum() == null || (navigationBar = ((q0) fragment).getNavigationBar()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f51297h.getForum().getName(), 5, true, true) + this.f51294e.getActivity().getString(R.string.forum));
        navigationBar.setCenterTextTitle(sb.toString());
    }

    public final void u0() {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (frsActivity = this.f51294e) == null) {
            return;
        }
        if (this.A == null) {
            this.A = (NavigationBarCoverTip) frsActivity.findViewById(R.id.navigation_cover_tip);
        }
        if (this.A == null) {
            return;
        }
        View inflate = View.inflate(this.f51294e, R.layout.write_thread_share_guide, null);
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
        cVar.r();
        tBSpecificationBtn.setConfig(cVar);
        tBSpecificationBtn.changeSkinType();
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.A, R.color.cp_link_tip_a_alpha95);
        tBSpecificationBtn.setOnClickListener(new y(this));
        this.A.showTip(this.f51294e, inflate, 30000);
        new StatisticItem("c13438").eventStat();
        int k2 = c.a.q0.s.d0.b.j().k("key_bawu_task_toast", 0);
        if (k2 >= 0) {
            c.a.q0.s.d0.b.j().v("key_bawu_task_toast", k2 + 1);
        }
    }

    public final void v0() {
        c.a.r0.j3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (mVar = this.f51297h) == null || mVar.getEntelechyTabInfo() == null || this.f51297h.getEntelechyTabInfo().tab == null) {
            return;
        }
        if (this.f51294e.getIntent() == null || !FrsActivityConfig.FRS_FROM_ITEM.equals(this.f51294e.getIntent().getStringExtra("from"))) {
            boolean z2 = false;
            Iterator<FrsTabInfo> it = this.f51297h.getEntelechyTabInfo().tab.iterator();
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
                    c.a.r0.e0.e eVar = new c.a.r0.e0.e(this.f51294e.getPageContext(), this.u);
                    this.D = eVar;
                    eVar.g0(R.drawable.pic_sign_tip_down);
                    this.D.L(2);
                    this.D.h0(true);
                    this.D.j0(-c.a.e.e.p.l.g(this.f51294e, R.dimen.tbds20));
                    this.D.k0(-c.a.e.e.p.l.g(this.f51294e, R.dimen.tbds20));
                    this.D.X(R.color.CAM_X0101);
                    this.D.P(R.dimen.tbds54);
                    this.D.a0(c.a.e.e.p.l.g(this.f51294e, R.dimen.tbds44));
                }
                this.D.m0(this.f51294e.getString(R.string.frs_evaluate_tip), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    public final void w0(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f51294e);
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.f51294e);
            frsForumToolDialogView.setStartLoadUrl(i2, str2);
            frsForumToolDialogView.setContent(str);
            frsForumToolDialogView.setCancleButtonListener(new q(this, aVar));
            frsForumToolDialogView.setConfirmButtonListener(new r(this, aVar, i2, str3));
            aVar.setContentView(frsForumToolDialogView);
            aVar.create(this.f51294e.getPageContext()).show();
        }
    }

    public final boolean x0(String str, String str2, String str3, boolean z2) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{str, str2, str3, Boolean.valueOf(z2)})) == null) {
            if (!this.E.g(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.f51295f) == null || frsFragment.getHeaderVC() == null) {
                return false;
            }
            this.H = false;
            this.E.h(this.f51294e, str, str2, str3, this.f51295f.getHeaderVC().v());
            this.E.e().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean y0(c.a.r0.j3.m mVar) {
        InterceptResult invokeL;
        PopInfo popInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, mVar)) == null) {
            if (c.a.q0.s.d0.b.j().g(c.a.q0.s.d0.b.n("key_frs_shield_thread_dialog"), false) || mVar.getUserData() == null || mVar.getUserData().getIs_manager() <= 0 || (popInfo = mVar.frsMaskPopInfo) == null || popInfo.if_pop.intValue() != 1) {
                return false;
            }
            ImageView imageView = new ImageView(this.f51294e);
            imageView.setImageResource(SkinManager.getResourceId(R.drawable.pic_frs_popup_shield));
            TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.comment_tab_dialog_botton_text, TBAlertConfig.OperateBtnStyle.MAIN);
            c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f51294e);
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

    public final boolean z0(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, forumData)) == null) {
            if (c.a.e.e.p.k.isEmpty(forumData.getRiskTipPop()) || c.a.e.e.p.k.isEmpty(forumData.getRiskTipPopTitle())) {
                return false;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f51294e);
            aVar.setTitle(forumData.getRiskTipPopTitle());
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setMessage(forumData.getRiskTipPop());
            aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new s(this, aVar));
            aVar.create(this.f51294e.getPageContext()).show();
            return true;
        }
        return invokeL.booleanValue;
    }
}
