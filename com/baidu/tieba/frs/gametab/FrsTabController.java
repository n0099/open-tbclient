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
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.tbadk.coreExtra.data.NewGodData;
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
import com.baidu.tieba.R;
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
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
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
import com.repackage.bg;
import com.repackage.bs4;
import com.repackage.d55;
import com.repackage.e55;
import com.repackage.gk6;
import com.repackage.gs4;
import com.repackage.gt7;
import com.repackage.ip6;
import com.repackage.iu4;
import com.repackage.kg;
import com.repackage.kk6;
import com.repackage.ko6;
import com.repackage.ld5;
import com.repackage.li;
import com.repackage.m98;
import com.repackage.mi;
import com.repackage.ng;
import com.repackage.nr4;
import com.repackage.od6;
import com.repackage.oi8;
import com.repackage.oz5;
import com.repackage.p05;
import com.repackage.p35;
import com.repackage.rc6;
import com.repackage.wa;
import com.repackage.wd6;
import com.repackage.wn4;
import com.repackage.xh5;
import com.repackage.yh5;
import com.repackage.zh5;
import com.repackage.zl8;
import com.repackage.zu4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddBawuPopInfo;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class FrsTabController implements zh5, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String k0;
    public static final String l0;
    public transient /* synthetic */ FieldHolder $fh;
    public ip6 A;
    public Runnable B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public HttpMessageListener H;
    public CustomMessageListener I;
    public wa J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public CustomMessageListener M;
    public HttpMessageListener N;
    public CustomMessageListener O;
    public CustomMessageListener P;
    public Runnable Q;
    public CustomMessageListener R;
    public CustomMessageListener S;
    public CustomMessageListener T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public ViewPager.OnPageChangeListener Z;
    public FrsActivity a;
    public FrsFragment b;
    public FrsTabHostFragment c;
    public oi8 d;
    public od6 e;
    public boolean f;
    public final Handler g;
    public FrsBaseViewPager.a g0;
    public String h;
    public CustomMessageListener h0;
    public String i;
    public final ItemCardHelper.c i0;
    public int j;
    public Runnable j0;
    public String k;
    public int l;
    public ShareSuccessReplyToServerModel m;
    public boolean n;
    public FrsBaseViewPager o;
    public FragmentAdapter p;
    public OvalActionButton q;
    public FRSRefreshButton r;
    public FrameLayout s;
    public LinearLayout t;
    public boolean u;
    public boolean v;
    public NavigationBarCoverTip w;
    public boolean x;
    public boolean y;
    public oz5 z;

    /* loaded from: classes3.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<BaseFragment> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FrsTabController frsTabController, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList(2);
        }

        public boolean b(int i, BaseFragment baseFragment) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, baseFragment)) == null) ? ListUtils.add(this.a, i, baseFragment) : invokeIL.booleanValue;
        }

        public BaseFragment c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (li.isEmpty(str)) {
                    return null;
                }
                for (BaseFragment baseFragment : this.a) {
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
        public BaseFragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? (BaseFragment) ListUtils.getItem(this.a, i) : (BaseFragment) invokeI.objValue;
        }

        public String e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (getItem(i) != null) {
                    return getItem(i).getBaseTag();
                }
                return null;
            }
            return (String) invokeI.objValue;
        }

        public BaseFragment f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? (BaseFragment) ListUtils.remove(this.a, i) : (BaseFragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.size() : invokeV.intValue;
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

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* renamed from: com.baidu.tieba.frs.gametab.FrsTabController$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0188a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0188a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.a.d.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.a, "RecommendHistoryPage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
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
                        ScreenTopToast screenTopToast = new ScreenTopToast(this.a.a);
                        screenTopToast.m(this.a.a.getString(R.string.obfuscated_res_0x7f0f0733));
                        screenTopToast.l(this.a.a.getString(R.string.obfuscated_res_0x7f0f0732));
                        screenTopToast.k(this.a.a.getString(R.string.obfuscated_res_0x7f0f04e0));
                        screenTopToast.j(new View$OnClickListenerC0188a(this));
                        screenTopToast.n((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090aac));
                        return;
                    }
                    BdTopToast bdTopToast = new BdTopToast(this.a.a);
                    bdTopToast.i(false);
                    bdTopToast.h(pushMsg);
                    bdTopToast.j((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090aac));
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.a);
                bdTopToast2.i(false);
                bdTopToast2.h(httpResponsedMessage.getErrorString());
                bdTopToast2.j((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090aac));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(FrsTabController frsTabController, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = frsTabController;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            oi8 oi8Var;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.f || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                oi8Var = frsPageHttpResponseMessage.getResponseData();
                i = frsPageHttpResponseMessage.getUpdateType();
            } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                oi8Var = fRSPageSocketResponsedMessage.getResponseData();
                i = fRSPageSocketResponsedMessage.getUpdateType();
            } else {
                oi8Var = null;
                i = -1;
            }
            if (oi8Var != null) {
                this.a.f = true;
                this.a.q0(oi8Var, true, i);
                if (oi8Var != null && oi8Var.getForum() != null && !StringUtils.isNull(oi8Var.getForum().getId())) {
                    wn4.b().l("2", oi8Var.getForum().getId());
                }
            }
            this.a.B0(oi8Var);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public b(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ng.a().removeCallbacks(this);
                this.a.e0();
                ng.a().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.f && this.a.d == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof oi8)) {
                oi8 oi8Var = (oi8) customResponsedMessage.getData();
                if (oi8Var.getForum() == null || this.a.h == null || !this.a.h.equals(oi8Var.getForum().getName())) {
                    return;
                }
                this.a.q0(oi8Var, false, -1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.n = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.L();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.o == null || this.a.p == null || !(customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                return;
            }
            FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
            this.a.u = aVar.a();
            this.a.v = aVar.b();
        }
    }

    /* loaded from: classes3.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int T;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (10001 == intValue) {
                T = this.a.T(9);
                if (T == -1) {
                    T = this.a.T(2);
                }
            } else {
                T = this.a.T(intValue);
            }
            if (T == -1 || !this.a.b0() || this.a.c == null) {
                return;
            }
            this.a.c.l1(T);
            if (this.a.S(T) != 1) {
                this.a.b.x3(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.o == null || this.a.p == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.o.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes3.dex */
    public class e0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<gk6> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.a.c == null) {
                    return;
                }
                for (gk6 gk6Var : newNotifyData) {
                    if (gk6Var != null) {
                        for (int i2 = 0; i2 < this.a.e.f().size(); i2++) {
                            FragmentTabHost.b c1 = this.a.c.c1(i2);
                            if (c1 != null && (i = c1.a) != 1 && i != this.a.c.V0() && c1.a == gk6Var.a() && gk6Var.b() && c1.b.d(String.valueOf(c1.a)) != null) {
                                c1.b.d(String.valueOf(c1.a)).a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.O(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.a, 2000);
                bdTopToast.i(false);
                bdTopToast.h(this.a.a.getString(R.string.obfuscated_res_0x7f0f074b));
                bdTopToast.j((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090aac));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.A == null || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ForumData) {
                this.a.O((ForumData) customResponsedMessage.getData());
            } else if (customResponsedMessage.getData() instanceof Long) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.d0(longValue) && this.a.A.a(longValue) >= 3) {
                    this.a.A.b(longValue);
                    this.a.D = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921641) {
                this.a.G = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zl8)) {
                zl8 zl8Var = (zl8) customResponsedMessage.getData();
                if (this.a.A == null || zl8Var == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.a.A.c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(zl8Var.a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.a.F = booleanValue;
                if (booleanValue) {
                    this.a.q.setVisibility(8);
                } else {
                    this.a.q.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof ko6) || ((ko6) customResponsedMessage.getData()).a == null) {
                this.a.s.removeAllViews();
                this.a.s.setVisibility(8);
                return;
            }
            View view2 = ((ko6) customResponsedMessage.getData()).a;
            if (view2.getParent() != null) {
                if (((ViewGroup) view2.getParent()) != this.a.s) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                    this.a.s.removeAllViews();
                    this.a.s.addView(view2);
                }
            } else {
                this.a.s.removeAllViews();
                this.a.s.addView(view2);
            }
            this.a.s.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public k(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                this.a.v = false;
                this.a.o.setForceIntercept(false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i == 1) {
                return;
            }
            this.a.q.setVisibility(0);
            if (this.a.Q() != null) {
                this.a.Q().G3(false);
            }
            this.a.b.f4();
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.a.d.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.a, "ForumGradePage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ScreenTopToast screenTopToast = new ScreenTopToast(this.a.a);
                screenTopToast.m(this.a.a.getString(R.string.obfuscated_res_0x7f0f072c));
                screenTopToast.k(this.a.a.getString(R.string.obfuscated_res_0x7f0f072e));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090aac));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements FrsBaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public m(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.o == null) {
                return;
            }
            if (this.a.o.getCurrentItem() == 0) {
                this.a.o.setmDisallowSlip(true);
            } else {
                this.a.o.setmDisallowSlip(false);
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.o.getCurrentItem() == 0) {
                    if (this.a.u && this.a.v) {
                        this.a.o.setmDisallowSlip(false);
                    }
                    if (!this.a.v) {
                        this.a.o.setmDisallowSlip(true);
                    }
                    this.a.o.setmDisallowSlip(true);
                } else {
                    this.a.o.setmDisallowSlip(true);
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public n(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public o(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FrsTabController frsTabController = this.a;
                boolean M = frsTabController.M(frsTabController.d.getGameTabInfo());
                if (M) {
                    this.a.p.notifyDataSetChanged();
                    if (M && this.a.c != null) {
                        this.a.c.n1(this.a.b);
                        this.a.c.k1(this.a.d, this.a.e);
                    }
                }
                if (this.a.a.isLoadingViewAttached()) {
                    this.a.a.hideLoadingView(this.a.a.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public p(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.M = true;
                this.a.Y(this.a.b != null ? this.a.b.getArguments() : null);
                this.a.p.notifyDataSetChanged();
                if (this.a.a.isLoadingViewAttached()) {
                    this.a.a.hideLoadingView(this.a.a.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ oi8 b;

        public q(FrsTabController frsTabController, AlertDialog alertDialog, oi8 oi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, alertDialog, oi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
            this.b = oi8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_CANCEL);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.b.getForum() != null) {
                statisticItem.param("fid", this.b.getForum().getId());
                statisticItem.param("fname", this.b.getForum().getName());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;

        public r(FrsTabController frsTabController, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nr4 nr4Var = this.a;
                if (nr4Var != null) {
                    nr4Var.dismiss();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FrsTabController d;

        public s(FrsTabController frsTabController, nr4 nr4Var, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, nr4Var, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = frsTabController;
            this.a = nr4Var;
            this.b = i;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nr4 nr4Var = this.a;
                if (nr4Var != null) {
                    nr4Var.dismiss();
                }
                int i = this.b;
                if (i == 1) {
                    UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuteam?fn=" + this.d.Q().a() + "&fid=" + this.d.Q().b()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.d.Q().b());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.d.a, "ForumDetailPage", hashMap)));
                } else if (i != 3 || TextUtils.isEmpty(this.c)) {
                } else {
                    UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{this.c});
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* loaded from: classes3.dex */
        public class a extends d55 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t c;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = tVar;
            }

            @Override // com.repackage.d55
            public e55 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.c.a.b.a());
                    bundle.putString("from", this.c.a.b.x2());
                    bundle.putString("forum_id", this.c.a.b.b());
                    bundle.putInt("tab_id", 503);
                    bundle.putBoolean("can_auto_play_video", this.c.a.d.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", this.c.a.d.needLog == 1);
                    bundle.putBoolean("is_brand_forum", this.c.a.d.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.c.a.d);
                    bundle.putSerializable("view_data", frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    e55 e55Var = new e55();
                    e55Var.a = frsSportsRecommendFragment;
                    e55Var.e = 25;
                    e55Var.i = e55.k;
                    return e55Var;
                }
                return (e55) invokeV.objValue;
            }

            @Override // com.repackage.d55
            public TbFragmentTabIndicator c(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02ef, (ViewGroup) null);
                    this.b = fragmentTabIndicator;
                    fragmentTabIndicator.setTextSize(2.0f);
                    return this.b;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // com.repackage.d55
            public boolean d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof od6)) {
                if (!iu4.k().h(this.a.k, true)) {
                    ng.a().post(this.a.Q);
                }
                ((od6) customResponsedMessage.getData()).a(new a(this));
                this.a.Z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(FrsTabController frsTabController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, Integer.valueOf(i)};
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
            this.a = frsTabController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090aac));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public v(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090aac), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090aac), j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public w(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                    parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    this.a.a.startActivity(parseUri);
                    TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ x b;

            public a(x xVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {xVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = xVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.a == null) {
                    return;
                }
                gt7.a(this.b.a.a.getPageContext(), this.a).show();
            }
        }

        public x(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
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
                ng.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabController a;

        public y(FrsTabController frsTabController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new StatisticItem("c13439").eventStat();
                if (this.a.Q() == null || TextUtils.isEmpty(this.a.Q().b()) || TextUtils.isEmpty(this.a.h) || this.a.a == null) {
                    return;
                }
                if (this.a.w != null) {
                    this.a.w.e();
                }
                int i = iu4.k().l("key_bawu_task_toast", 0) == -1 ? 1 : 0;
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.a.Q().b() + "&fn=" + this.a.h + "&noread=" + i});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumData a;
        public final /* synthetic */ FrsTabController b;

        public z(FrsTabController frsTabController, ForumData forumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, forumData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsTabController;
            this.a = forumData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.A == null) {
                return;
            }
            if (this.b.E) {
                this.b.z0(this.a.getName(), this.a.getId(), this.a.getImage_url(), true);
            } else {
                this.b.D = true;
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
        k0 = FrsFragment.class.getSimpleName();
        l0 = FrsTabHostFragment.class.getSimpleName();
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
        this.f = false;
        this.g = new Handler();
        this.j = 0;
        this.n = false;
        this.x = false;
        this.y = false;
        this.D = false;
        this.E = false;
        this.H = new a(this, CmdConfigHttp.CMD_FRS_RECOMMEND);
        this.I = new l(this, 2921465);
        this.J = new a0(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.K = new b0(this, 2001615);
        this.L = new c0(this, 2921342);
        this.M = new d0(this, 2001627);
        this.N = new e0(this, 0);
        this.O = new f0(this, 2921518);
        this.P = new g0(this, 2921641);
        this.Q = new b(this);
        this.R = new c(this, 2005016);
        this.S = new d(this, 2921369);
        this.T = new e(this, 2921370);
        this.U = new f(this, 2001375);
        this.V = new g(this, 2921498);
        this.W = new h(this, 2001437);
        this.X = new i(this, 2921586);
        this.Y = new j(this, 2921590);
        this.Z = new k(this);
        this.g0 = new m(this);
        this.h0 = new u(this, 2001440);
        this.i0 = new v(this);
        this.j0 = new w(this);
        this.a = frsActivity;
        this.k = iu4.o("show_game_forem_tab_hot_point");
    }

    public final boolean A0(oi8 oi8Var) {
        InterceptResult invokeL;
        PopInfo popInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oi8Var)) == null) {
            if (iu4.k().h(iu4.o("key_frs_shield_thread_dialog"), false) || oi8Var.getUserData() == null || oi8Var.getUserData().getIs_manager() <= 0 || (popInfo = oi8Var.frsMaskPopInfo) == null || popInfo.if_pop.intValue() != 1) {
                return false;
            }
            ImageView imageView = new ImageView(this.a);
            imageView.setImageResource(SkinManager.getResourceId(R.drawable.pic_frs_popup_shield));
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0407, TBAlertConfig.OperateBtnStyle.MAIN);
            bs4 bs4Var = new bs4(this.a);
            bs4Var.w(oi8Var.frsMaskPopInfo.title);
            bs4Var.p(oi8Var.frsMaskPopInfo.v_title);
            bs4Var.n(true);
            bs4Var.j(imageView);
            bs4Var.r(aVar);
            bs4Var.i(false);
            aVar.a(new q(this, bs4Var.y(), oi8Var));
            iu4.k().u(iu4.o("key_frs_shield_thread_dialog"), true);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (oi8Var.getForum() != null) {
                statisticItem.param("fid", oi8Var.getForum().getId());
                statisticItem.param("fname", oi8Var.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
            FrsFragment frsFragment = this.b;
            if (frsFragment != null) {
                frsFragment.C3(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void B0(oi8 oi8Var) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oi8Var) == null) || oi8Var == null || oi8Var.getUserData() == null || oi8Var.getUserData().getNewGodData() == null || (frsFragment = this.b) == null || frsFragment.D2()) {
            return;
        }
        if (oi8Var.getForum() != null) {
            ld5.g().j(oi8Var.getForum().getId());
        }
        ld5.g().k(2, oi8Var.getUserData().getNewGodData());
        FrsFragment frsFragment2 = this.b;
        if (frsFragment2 != null) {
            frsFragment2.C3(c0(oi8Var.getUserData().getNewGodData()));
            this.b.D3(c0(oi8Var.getUserData().getNewGodData()));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.l != this.j && b0()) {
                this.c.l1(this.j);
                if (S(this.j) != 1) {
                    this.b.x3(false);
                }
                this.l = this.j;
                v0(this.c.U0(), this.j);
                return;
            }
            this.b.n2();
        }
    }

    public final boolean M(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (this.a.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.a;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (b0()) {
                return false;
            }
            this.b.M = true;
            s0();
            if (iu4.k().h("frs_game_login_tip", true)) {
                iu4.k().u("frs_login_tip", true);
                iu4.k().u("frs_game_login_tip", false);
            }
            a0(list);
            if (this.b.L2() != null) {
                this.b.L2().T(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void N(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumData) == null) {
            boolean z2 = false;
            if (z0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
                if (this.B != null) {
                    ng.a().removeCallbacks(this.B);
                }
                z2 = true;
            }
            if (!this.C) {
                this.A.e().h(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
                this.C = true;
            }
            if (z2) {
                return;
            }
            Runnable runnable = this.B;
            if (runnable == null) {
                runnable = new z(this, forumData);
            }
            this.B = runnable;
            ng.a().postDelayed(this.B, 60000L);
        }
    }

    public final void O(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, forumData) == null) || this.b.N() == null || this.A == null) {
            return;
        }
        if (forumData == null) {
            forumData = this.d.getForum();
        }
        if (forumData == null || forumData.isLike() == 1) {
            return;
        }
        if (!this.E) {
            this.D = true;
        } else if (!z0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) || this.B == null) {
        } else {
            ng.a().removeCallbacks(this.B);
        }
    }

    public final FragmentManager P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsActivity frsActivity = this.a;
            if (frsActivity != null) {
                return frsActivity.getSupportFragmentManager();
            }
            return null;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public FrsFragment Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.Y0();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public final int S(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            od6 od6Var = this.e;
            if (od6Var != null && i2 < ListUtils.getCount(od6Var.f())) {
                return this.e.f().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            od6 od6Var = this.e;
            if (od6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(od6Var.f());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.e.f().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public TbPageTag U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!b0()) {
                return this.b.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.V0()) {
                    return this.b.getTbPageTag();
                }
                Fragment U0 = this.c.U0();
                if (U0 instanceof BaseFragment) {
                    return ((BaseFragment) U0).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public oi8 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.d : (oi8) invokeV.objValue;
    }

    public final boolean W(oi8 oi8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, oi8Var)) == null) {
            if (oi8Var != null && oi8Var.getUserData() != null) {
                int is_manager = oi8Var.getUserData().getIs_manager();
                boolean h2 = iu4.k().h("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !h2) {
                    y0(1, this.a.getString(R.string.obfuscated_res_0x7f0f06b6), String.valueOf((int) R.drawable.obfuscated_res_0x7f080f56), "");
                    iu4.k().u("key_forum_tool_find_dialog_show", true);
                    FrsFragment frsFragment = this.b;
                    if (frsFragment != null) {
                        frsFragment.C3(true);
                    }
                    return true;
                } else if (!h2 && is_manager == 2) {
                    y0(2, this.a.getString(R.string.obfuscated_res_0x7f0f06b5), String.valueOf((int) R.drawable.obfuscated_res_0x7f080f56), "");
                    iu4.k().u("key_forum_tool_find_dialog_show", true);
                    FrsFragment frsFragment2 = this.b;
                    if (frsFragment2 != null) {
                        frsFragment2.C3(true);
                    }
                    return true;
                } else {
                    AddBawuPopInfo addBawuPopInfo = oi8Var.bawuPopInfo;
                    if (addBawuPopInfo != null) {
                        y0(3, addBawuPopInfo.content, addBawuPopInfo.img_url, addBawuPopInfo.jump_url);
                        FrsFragment frsFragment3 = this.b;
                        if (frsFragment3 != null) {
                            frsFragment3.C3(true);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void X(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) || (frsActivity = this.a) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.obfuscated_res_0x7f0d02fd);
        this.o = (FrsBaseViewPager) this.a.findViewById(R.id.obfuscated_res_0x7f090ac3);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this, this.a.getSupportFragmentManager());
        this.p = fragmentAdapter;
        this.o.setAdapter(fragmentAdapter);
        this.o.setPageTransformer(true, new CubeOutViewPagerTransformer());
        this.o.addOnPageChangeListener(this.Z);
        this.o.setmDisallowSlip(true);
        this.o.setOnTouchEventListener(this.g0);
        gs4.d(this.o).f(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.a.findViewById(R.id.obfuscated_res_0x7f090b9c);
        this.q = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.q.setHasShadow(false);
        this.s = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090ac6);
        this.r = (FRSRefreshButton) this.a.findViewById(R.id.obfuscated_res_0x7f090bbe);
        this.t = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090b76);
        this.a.registerListener(this.S);
        this.a.registerListener(this.T);
        this.J.getHttpMessageListener().setPriority(-1);
        this.J.getSocketMessageListener().setPriority(-1);
        this.a.registerListener(this.K);
        this.M.setSelfListener(true);
        this.a.registerListener(this.M);
        this.L.setSelfListener(true);
        this.a.registerListener(this.L);
        this.a.registerListener(this.R);
        if (bundle == null) {
            this.h = this.a.getIntent().getStringExtra("name");
            this.i = this.a.getIntent().getStringExtra("from");
            this.j = this.a.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.h = bundle.getString("name");
            this.i = bundle.getString("from");
            this.j = bundle.getInt("default_tab_id", 0);
        }
        Y(bundle);
        this.p.notifyDataSetChanged();
        this.m = new ShareSuccessReplyToServerModel();
        this.a.registerListener(this.J);
        this.a.registerListener(this.H);
        this.a.registerListener(this.I);
        this.a.registerListener(this.O);
        this.a.registerListener(this.X);
        this.a.registerListener(this.P);
        this.Y.setPriority(Integer.MAX_VALUE);
        this.Y.setSelfListener(true);
        this.a.registerListener(this.Y);
    }

    public final void Y(Bundle bundle) {
        FragmentManager P;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) || (P = P()) == null || P.isDestroyed() || (fragmentAdapter = this.p) == null) {
            return;
        }
        try {
            FrsFragment frsFragment = (FrsFragment) fragmentAdapter.c(k0);
            if (frsFragment == null) {
                frsFragment = f0(bundle);
            }
            frsFragment.M3(this.q);
            frsFragment.O3(this.r);
            frsFragment.N3(this.t);
            if (k0.equals(this.p.e(0))) {
                return;
            }
            if (l0.equals(this.p.e(0))) {
                this.p.f(0);
            }
            this.p.b(0, frsFragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Z() {
        FragmentManager P;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (P = P()) == null || P.isDestroyed() || (fragmentAdapter = this.p) == null) {
            return;
        }
        try {
            FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) fragmentAdapter.c(l0);
            if (frsTabHostFragment == null) {
                frsTabHostFragment = g0();
            }
            frsTabHostFragment.p1(this.q);
            frsTabHostFragment.o1(this.r);
            if (l0.equals(this.p.e(0))) {
                return;
            }
            if (k0.equals(this.p.e(0))) {
                this.p.f(0);
            }
            this.p.b(0, frsTabHostFragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a0(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        t tVar = new t(this, 2001616);
        tVar.setPriority(Integer.MAX_VALUE);
        tVar.setSelfListener(true);
        this.a.registerListener(tVar);
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
        this.e = new od6(this.a.getActivity(), arrayList);
        if (Q() != null) {
            this.e.j(Q().b());
            this.e.k(Q().a());
            if (Q().g0() != null && Q().g0().getForum() != null) {
                ForumData forum = Q().g0().getForum();
                this.e.i(forum.getForumGameLabel());
                this.e.l(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.b;
        frsFragment.M = false;
        new kk6(frsFragment).g(this.e);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.e);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            FragmentAdapter fragmentAdapter = this.p;
            if (fragmentAdapter == null) {
                return false;
            }
            return fragmentAdapter.getItem(0) instanceof FrsTabHostFragment;
        }
        return invokeV.booleanValue;
    }

    public final boolean c0(NewGodData newGodData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, newGodData)) == null) {
            return (((((System.currentTimeMillis() - iu4.k().m("key_new_god_dialog_showed_time", 0L)) + 3000) > 259200000L ? 1 : (((System.currentTimeMillis() - iu4.k().m("key_new_god_dialog_showed_time", 0L)) + 3000) == 259200000L ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean d0(long j2) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j2)) == null) {
            oi8 oi8Var = this.d;
            return (oi8Var == null || j2 == 0 || (forum = oi8Var.getForum()) == null || kg.g(forum.getId(), 0L) != j2) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.repackage.zh5
    public void dispatchInjectPluginMessage(xh5 xh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, xh5Var) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof zh5) {
                frsFragment.dispatchInjectPluginMessage(xh5Var);
            }
        }
    }

    public final void e0() {
        od6 od6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (od6Var = this.e) == null || TextUtils.isEmpty(od6Var.c())) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021074);
        httpMessage.addParam("forum_id", this.d.getForum().getId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final FrsFragment f0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, bundle)) == null) {
            if (this.b == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.b = frsFragment;
                frsFragment.setArguments(bundle);
                this.b.setBaseTag(k0);
            }
            FrsFragment frsFragment2 = this.b;
            frsFragment2.M = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    public final FrsTabHostFragment g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.c == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.c = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(l0);
                this.c.m1(this.j);
            }
            return this.c;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public bg<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (!b0()) {
                FrsFragment frsFragment = this.b;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).getFrsCommonImageLayoutPool();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment == null) {
                    return null;
                }
                Fragment U0 = frsTabHostFragment.U0();
                if (U0 instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) U0).getFrsCommonImageLayoutPool();
                }
            }
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.zh5
    public yh5 getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof zh5) {
                return frsFragment.getInjectPlugin(i2);
            }
            return null;
        }
        return (yh5) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (!b0()) {
                return this.b.getVoiceManager();
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment U0 = frsTabHostFragment.U0();
            if (U0 instanceof VoiceManager.j) {
                return ((VoiceManager.j) U0).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void h0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048605, this, i2, i3, intent) == null) {
            if (!b0()) {
                this.b.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.V0()) {
                        this.b.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment U0 = this.c.U0();
                        if (U0 != null) {
                            U0.onActivityResult(i2, i3, intent);
                        }
                    }
                }
            }
            if (i3 == -1) {
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1) {
                        m98.g().m(this.a.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem == null || (str = shareItem.v) == null || (shareSuccessReplyToServerModel = this.m) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.y(str, intExtra2, new x(this));
                    }
                } else if (i2 == 13011) {
                    m98.g().m(this.a.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.c;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.d1() != null) {
                        this.c.d1().p(this.a.getPageContext());
                        return;
                    }
                    FrsFragment frsFragment = this.b;
                    if (frsFragment == null || frsFragment.w0() == null || this.b.w0().Y() == null || this.b.w0().Y().g == null) {
                        return;
                    }
                    this.b.w0().Y().g.p(this.a.getPageContext());
                }
            }
        }
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1 && skinType != 4) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.a);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            }
            FrsFragment frsFragment = this.b;
            if (frsFragment != null) {
                frsFragment.onChangeSkinType(i2);
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment != null) {
                frsTabHostFragment.onChangeSkinType(i2);
            }
            r0();
        }
    }

    public void j0() {
        ip6 ip6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.j);
            this.g.removeCallbacksAndMessages(null);
            if (this.a.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.a;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.Q != null) {
                ng.a().removeCallbacks(this.Q);
            }
            iu4.k().u(this.k, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.m;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.b0() != null) {
                this.b.b0().E0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.w;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.i)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.i)) {
                p35.h().i(false);
            }
            if (this.B != null) {
                ng.a().removeCallbacks(this.B);
            }
            oi8 oi8Var = this.d;
            if (oi8Var != null && oi8Var.getForum() != null && (ip6Var = this.A) != null) {
                ip6Var.b(kg.g(this.d.getForum().getId(), 0L));
            }
            ng.a().removeCallbacks(this.j0);
        }
    }

    public boolean k0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    FrsFragment frsFragment = this.b;
                    if (frsFragment == null || !frsFragment.isAdded()) {
                        return false;
                    }
                    return this.b.i3(i2, keyEvent);
                }
                return this.a.onSuperKeyDown(i2, keyEvent);
            } else if (this.F) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                return false;
            } else if (this.G) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921642));
                return true;
            } else if (b0() && (frsTabHostFragment = this.c) != null && frsTabHostFragment.g1()) {
                this.c.f1();
                UtilHelper.setNavigationBarBackground(this.a, this.c.T0());
                return false;
            } else {
                FrsFragment frsFragment2 = this.b;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    if (this.b.i3(i2, keyEvent)) {
                        return true;
                    }
                    L();
                    return false;
                }
                return this.a.onSuperKeyDown(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void l0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, intent) == null) || (frsFragment = this.b) == null) {
            return;
        }
        frsFragment.j3(intent);
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.E = false;
            ip6 ip6Var = this.A;
            if (ip6Var != null) {
                ip6Var.d();
            }
            if (!b0()) {
                this.b.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    Fragment U0 = frsTabHostFragment.U0();
                    if (U0 instanceof BaseFragment) {
                        ((BaseFragment) U0).setPrimary(false);
                    }
                }
            }
            ld5.g().i();
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                ng.a().postDelayed(this.j0, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.h0);
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (!b0()) {
                this.b.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    Fragment U0 = frsTabHostFragment.U0();
                    if (U0 instanceof BaseFragment) {
                        ((BaseFragment) U0).setPrimary(true);
                    }
                }
            }
            if (this.n) {
                this.n = false;
                FrsFragment frsFragment = this.b;
                if (frsFragment != null) {
                    frsFragment.refresh();
                }
            }
            B0(this.d);
            this.E = true;
            if (this.D) {
                O(null);
            }
            ItemCardHelper.v(this.i0);
            MessageManager.getInstance().registerListener(this.h0);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                p05.q().w(downloadData);
            }
        }
    }

    public void o0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            bundle.putString("name", this.h);
            bundle.putInt("default_tab_id", this.j);
            bundle.putString("from", this.i);
        }
    }

    public void p0(String str) {
        oi8 oi8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || (oi8Var = this.d) == null || oi8Var.getForum() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.d.getForum().getId()).param("obj_type", 2));
    }

    public final void q0(oi8 oi8Var, boolean z2, int i2) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{oi8Var, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || oi8Var == null || oi8Var.getForum() == null || (frsActivity = this.a) == null || frsActivity.getPageContext() == null) {
            return;
        }
        this.d = oi8Var;
        ForumData forum = oi8Var.getForum();
        if (z2 && forum != null && !TextUtils.isEmpty(forum.getId())) {
            FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && !frsFragment.D2() && !this.b.Q3(this.d, this.a.getPageContext())) {
            if (z2) {
                if (!A0(oi8Var) && !W(oi8Var)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
                }
            } else if (!W(oi8Var)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
        }
        if (forum.getIsShowBawuTask() && iu4.k().l("key_bawu_task_toast", 0) == 0 && !this.x) {
            this.x = true;
            ng.a().postDelayed(new n(this), 30000L);
        }
        if (oi8Var.bazhuExam != null && !this.y && z2) {
            rc6.a(this.a.getPageContext(), oi8Var.bazhuExam, forum.getId(), forum.getName());
            this.y = true;
        }
        if (ListUtils.getCount(oi8Var.getGameTabInfo()) > 0) {
            this.g.post(new o(this));
        } else if (b0()) {
            this.g.post(new p(this));
        }
        r0();
        x0();
        if (z2) {
            if ((!this.C || i2 == 4) && forum.isLike() == 0 && UbsABTestHelper.needShowFrsGuide() && TbadkCoreApplication.isLogin()) {
                this.A = new ip6();
                this.a.registerListener(this.V);
                this.a.registerListener(this.U);
                this.a.registerListener(this.W);
                N(forum);
            }
        }
    }

    public final void r0() {
        oi8 oi8Var;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (oi8Var = this.d) == null || (themeColorInfo = oi8Var.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        this.q.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921571, themeElement));
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(1021074, this.N);
        }
    }

    @Override // com.repackage.zh5
    public void setInjectPlugin(int i2, yh5 yh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048617, this, i2, yh5Var) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof zh5) {
                frsFragment.setInjectPlugin(i2, yh5Var);
            }
        }
    }

    public void t0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.j = i2;
        }
    }

    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.l = i2;
        }
    }

    public final void v0(Fragment fragment, int i2) {
        oi8 oi8Var;
        NavigationBar d02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048620, this, fragment, i2) == null) || !(fragment instanceof wd6) || (oi8Var = this.d) == null || oi8Var.getForum() == null || (d02 = ((wd6) fragment).d0()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.d.getForum().getName(), 5, true, true) + this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f064b));
        d02.setCenterTextTitle(sb.toString());
    }

    public final void w0() {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (frsActivity = this.a) == null) {
            return;
        }
        if (this.w == null) {
            this.w = (NavigationBarCoverTip) frsActivity.findViewById(R.id.obfuscated_res_0x7f09153f);
        }
        if (this.w == null) {
            return;
        }
        View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d08d2, null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924d7);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f091cfb);
        if (TextUtils.isEmpty(this.h)) {
            textView.setText("吧主您好，本吧考核新制度上线啦");
        } else {
            textView.setText(this.h + "吧吧主您好，本吧考核新制度上线啦");
        }
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03b3));
        zu4 zu4Var = new zu4();
        zu4Var.s();
        tBSpecificationBtn.setConfig(zu4Var);
        tBSpecificationBtn.k();
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.w, R.color.cp_link_tip_a_alpha95);
        tBSpecificationBtn.setOnClickListener(new y(this));
        this.w.m(this.a, inflate, 30000);
        new StatisticItem("c13438").eventStat();
        int l2 = iu4.k().l("key_bawu_task_toast", 0);
        if (l2 >= 0) {
            iu4.k().w("key_bawu_task_toast", l2 + 1);
        }
    }

    public final void x0() {
        oi8 oi8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (oi8Var = this.d) == null || oi8Var.getEntelechyTabInfo() == null || this.d.getEntelechyTabInfo().a == null) {
            return;
        }
        if (this.a.getIntent() == null || !FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.getIntent().getStringExtra("from"))) {
            boolean z2 = false;
            Iterator<FrsTabInfo> it = this.d.getEntelechyTabInfo().a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().tab_type.intValue() == 16) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                if (this.z == null) {
                    oz5 oz5Var = new oz5(this.a.getPageContext(), this.q);
                    this.z = oz5Var;
                    oz5Var.g0(R.drawable.pic_sign_tip_down);
                    this.z.L(2);
                    this.z.h0(true);
                    this.z.j0(-mi.f(this.a, R.dimen.tbds20));
                    this.z.k0(-mi.f(this.a, R.dimen.tbds20));
                    this.z.X(R.color.CAM_X0101);
                    this.z.P(R.dimen.tbds54);
                    this.z.a0(mi.f(this.a, R.dimen.tbds44));
                }
                this.z.m0(this.a.getString(R.string.obfuscated_res_0x7f0f06c9), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    public final void y0(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            nr4 nr4Var = new nr4(this.a);
            nr4Var.setContentViewSize(2);
            nr4Var.setCanceledOnTouchOutside(false);
            FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.a);
            frsForumToolDialogView.setStartLoadUrl(i2, str2);
            frsForumToolDialogView.setContent(str);
            frsForumToolDialogView.setCancleButtonListener(new r(this, nr4Var));
            frsForumToolDialogView.setConfirmButtonListener(new s(this, nr4Var, i2, str3));
            nr4Var.setContentView(frsForumToolDialogView);
            nr4Var.create(this.a.getPageContext()).show();
        }
    }

    public final boolean z0(String str, String str2, String str3, boolean z2) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{str, str2, str3, Boolean.valueOf(z2)})) == null) {
            if (!this.A.g(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.b) == null || frsFragment.N() == null) {
                return false;
            }
            this.D = false;
            this.A.h(this.a, str, str2, str3, this.b.N().A());
            this.A.e().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z2);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
