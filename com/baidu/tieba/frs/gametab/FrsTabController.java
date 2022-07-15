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
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
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
import com.repackage.be6;
import com.repackage.c15;
import com.repackage.c45;
import com.repackage.cr4;
import com.repackage.dh8;
import com.repackage.eg;
import com.repackage.fp6;
import com.repackage.ho6;
import com.repackage.je6;
import com.repackage.jk6;
import com.repackage.kn4;
import com.repackage.ng;
import com.repackage.nk6;
import com.repackage.oi;
import com.repackage.ok8;
import com.repackage.os7;
import com.repackage.p55;
import com.repackage.pi;
import com.repackage.q55;
import com.repackage.qg;
import com.repackage.ri5;
import com.repackage.si5;
import com.repackage.ti5;
import com.repackage.ur4;
import com.repackage.v88;
import com.repackage.vd5;
import com.repackage.vu4;
import com.repackage.wz5;
import com.repackage.xt4;
import com.repackage.za;
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
public class FrsTabController implements ti5, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String k0;
    public static final String l0;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public HttpMessageListener H;
    public CustomMessageListener I;
    public za J;
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
    public dh8 d;
    public be6 e;
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
    public wz5 y;
    public fp6 z;

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
                if (oi.isEmpty(str)) {
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
        public class View$OnClickListenerC0194a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0194a(a aVar) {
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
                        screenTopToast.m(this.a.a.getString(R.string.obfuscated_res_0x7f0f0738));
                        screenTopToast.l(this.a.a.getString(R.string.obfuscated_res_0x7f0f0737));
                        screenTopToast.k(this.a.a.getString(R.string.obfuscated_res_0x7f0f04e2));
                        screenTopToast.j(new View$OnClickListenerC0194a(this));
                        screenTopToast.n((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090a90));
                        return;
                    }
                    BdTopToast bdTopToast = new BdTopToast(this.a.a);
                    bdTopToast.i(false);
                    bdTopToast.h(pushMsg);
                    bdTopToast.j((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090a90));
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.a);
                bdTopToast2.i(false);
                bdTopToast2.h(httpResponsedMessage.getErrorString());
                bdTopToast2.j((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090a90));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 extends za {
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

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            dh8 dh8Var;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.f || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                dh8Var = frsPageHttpResponseMessage.getResponseData();
                i = frsPageHttpResponseMessage.getUpdateType();
            } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                dh8Var = fRSPageSocketResponsedMessage.getResponseData();
                i = fRSPageSocketResponsedMessage.getUpdateType();
            } else {
                dh8Var = null;
                i = -1;
            }
            if (dh8Var != null) {
                this.a.f = true;
                this.a.t0(dh8Var, true, i);
                if (dh8Var != null && dh8Var.getForum() != null && !StringUtils.isNull(dh8Var.getForum().getId())) {
                    kn4.b().l("2", dh8Var.getForum().getId());
                }
            }
            this.a.F0(dh8Var);
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
                qg.a().removeCallbacks(this);
                this.a.g0();
                qg.a().postDelayed(this, 30000L);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.f && this.a.d == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof dh8)) {
                dh8 dh8Var = (dh8) customResponsedMessage.getData();
                if (dh8Var.getForum() == null || this.a.h == null || !this.a.h.equals(dh8Var.getForum().getName())) {
                    return;
                }
                this.a.t0(dh8Var, false, -1);
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
                this.a.M();
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
            int V;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (10001 == intValue) {
                V = this.a.V(9);
                if (V == -1) {
                    V = this.a.V(2);
                }
            } else {
                V = this.a.V(intValue);
            }
            if (V == -1 || !this.a.d0() || this.a.c == null) {
                return;
            }
            this.a.c.d2(V);
            if (this.a.U(V) != 1) {
                this.a.b.q4(false);
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
                List<jk6> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.a.c == null) {
                    return;
                }
                for (jk6 jk6Var : newNotifyData) {
                    if (jk6Var != null) {
                        for (int i2 = 0; i2 < this.a.e.f().size(); i2++) {
                            FragmentTabHost.b T1 = this.a.c.T1(i2);
                            if (T1 != null && (i = T1.a) != 1 && i != this.a.c.M1() && T1.a == jk6Var.a() && jk6Var.b() && T1.b.d(String.valueOf(T1.a)) != null) {
                                T1.b.d(String.valueOf(T1.a)).a.setVisibility(0);
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
                this.a.P(null);
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
                bdTopToast.h(this.a.a.getString(R.string.obfuscated_res_0x7f0f0750));
                bdTopToast.j((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090a90));
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.z == null || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ForumData) {
                this.a.P((ForumData) customResponsedMessage.getData());
            } else if (customResponsedMessage.getData() instanceof Long) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.f0(longValue) && this.a.z.a(longValue) >= 3) {
                    this.a.z.b(longValue);
                    this.a.C = true;
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
                this.a.F = ((Boolean) customResponsedMessage.getData()).booleanValue();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ok8)) {
                ok8 ok8Var = (ok8) customResponsedMessage.getData();
                if (this.a.z == null || ok8Var == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.a.z.c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(ok8Var.a));
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
                this.a.E = booleanValue;
                if (booleanValue) {
                    this.a.q.setVisibility(8);
                    this.a.G = false;
                    return;
                }
                this.a.q.setVisibility(0);
                this.a.G = true;
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
            if (!(customResponsedMessage.getData() instanceof ho6) || ((ho6) customResponsedMessage.getData()).a == null) {
                this.a.s.removeAllViews();
                this.a.s.setVisibility(8);
                return;
            }
            View view2 = ((ho6) customResponsedMessage.getData()).a;
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
            FrsTabController frsTabController = this.a;
            frsTabController.G = true;
            if (frsTabController.R() != null) {
                this.a.R().z4(false);
            }
            this.a.b.Y4();
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
                screenTopToast.m(this.a.a.getString(R.string.obfuscated_res_0x7f0f0731));
                screenTopToast.k(this.a.a.getString(R.string.obfuscated_res_0x7f0f0733));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090a90));
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
                this.a.A0();
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
                boolean N = frsTabController.N(frsTabController.d.getGameTabInfo());
                if (N) {
                    this.a.p.notifyDataSetChanged();
                    if (N && this.a.c != null) {
                        this.a.c.f2(this.a.b);
                        this.a.c.c2(this.a.d, this.a.e);
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
                this.a.a0(this.a.b != null ? this.a.b.getArguments() : null);
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
        public final /* synthetic */ dh8 b;

        public q(FrsTabController frsTabController, AlertDialog alertDialog, dh8 dh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, alertDialog, dh8Var};
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
            this.b = dh8Var;
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
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;

        public r(FrsTabController frsTabController, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                cr4 cr4Var = this.a;
                if (cr4Var != null) {
                    cr4Var.dismiss();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FrsTabController d;

        public s(FrsTabController frsTabController, cr4 cr4Var, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabController, cr4Var, Integer.valueOf(i), str};
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
            this.a = cr4Var;
            this.b = i;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                cr4 cr4Var = this.a;
                if (cr4Var != null) {
                    cr4Var.dismiss();
                }
                int i = this.b;
                if (i == 1) {
                    UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawuteam?fn=" + this.d.R().c() + "&fid=" + this.d.R().d()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.d.R().d());
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
        public class a extends p55 {
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

            @Override // com.repackage.p55
            public q55 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.c.a.b.c());
                    bundle.putString("from", this.c.a.b.p3());
                    bundle.putString("forum_id", this.c.a.b.d());
                    bundle.putInt("tab_id", 503);
                    bundle.putBoolean("can_auto_play_video", this.c.a.d.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", this.c.a.d.needLog == 1);
                    bundle.putBoolean("is_brand_forum", this.c.a.d.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.c.a.d);
                    bundle.putSerializable("view_data", frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    q55 q55Var = new q55();
                    q55Var.a = frsSportsRecommendFragment;
                    q55Var.e = 25;
                    q55Var.i = q55.k;
                    return q55Var;
                }
                return (q55) invokeV.objValue;
            }

            @Override // com.repackage.p55
            public TbFragmentTabIndicator c(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02e6, (ViewGroup) null);
                    this.b = fragmentTabIndicator;
                    fragmentTabIndicator.setTextSize(2.0f);
                    return this.b;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // com.repackage.p55
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof be6)) {
                if (!xt4.k().h(this.a.k, true)) {
                    qg.a().post(this.a.Q);
                }
                ((be6) customResponsedMessage.getData()).a(new a(this));
                this.a.b0();
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
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090a90));
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
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090a90), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090a90), 0L);
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
                os7.a(this.b.a.a.getPageContext(), this.a).show();
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
                qg.a().postDelayed(new a(this, customDialogData), 1000L);
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
                if (this.a.R() == null || TextUtils.isEmpty(this.a.R().d()) || TextUtils.isEmpty(this.a.h) || this.a.a == null) {
                    return;
                }
                if (this.a.w != null) {
                    this.a.w.e();
                }
                int i = xt4.k().l("key_bawu_task_toast", 0) == -1 ? 1 : 0;
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.a.R().d() + "&fn=" + this.a.h + "&noread=" + i});
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.z == null) {
                return;
            }
            if (this.b.D) {
                this.b.D0(this.a.getName(), this.a.getId(), this.a.getImage_url(), true);
            } else {
                this.b.C = true;
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
        this.C = false;
        this.D = false;
        this.G = true;
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
        this.k = xt4.o("show_game_forem_tab_hot_point");
    }

    public final void A0() {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frsActivity = this.a) == null) {
            return;
        }
        if (this.w == null) {
            this.w = (NavigationBarCoverTip) frsActivity.findViewById(R.id.obfuscated_res_0x7f091598);
        }
        if (this.w == null) {
            return;
        }
        View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d08e5, null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092538);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f091d41);
        if (TextUtils.isEmpty(this.h)) {
            textView.setText("吧主您好，本吧考核新制度上线啦");
        } else {
            textView.setText(this.h + "吧吧主您好，本吧考核新制度上线啦");
        }
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03ad));
        vu4 vu4Var = new vu4();
        vu4Var.s();
        tBSpecificationBtn.setConfig(vu4Var);
        tBSpecificationBtn.k();
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.w, R.color.cp_link_tip_a_alpha95);
        tBSpecificationBtn.setOnClickListener(new y(this));
        this.w.m(this.a, inflate, 30000);
        new StatisticItem("c13438").eventStat();
        int l2 = xt4.k().l("key_bawu_task_toast", 0);
        if (l2 >= 0) {
            xt4.k().w("key_bawu_task_toast", l2 + 1);
        }
    }

    public final void B0() {
        dh8 dh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (dh8Var = this.d) == null || dh8Var.getEntelechyTabInfo() == null || this.d.getEntelechyTabInfo().a == null) {
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
                if (this.y == null) {
                    wz5 wz5Var = new wz5(this.a.getPageContext(), this.q);
                    this.y = wz5Var;
                    wz5Var.e0(R.drawable.pic_sign_tip_down);
                    this.y.L(2);
                    this.y.f0(true);
                    this.y.h0(-pi.f(this.a, R.dimen.tbds20));
                    this.y.i0(-pi.f(this.a, R.dimen.tbds20));
                    this.y.X(R.color.CAM_X0101);
                    this.y.P(R.dimen.tbds54);
                    this.y.a0(pi.f(this.a, R.dimen.tbds44));
                }
                this.y.k0(this.a.getString(R.string.obfuscated_res_0x7f0f06cf), "first_into_frs_with_evaluate_tab");
            }
        }
    }

    public final void C0(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            cr4 cr4Var = new cr4(this.a);
            cr4Var.setContentViewSize(2);
            cr4Var.setCanceledOnTouchOutside(false);
            FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(this.a);
            frsForumToolDialogView.setStartLoadUrl(i2, str2);
            frsForumToolDialogView.setContent(str);
            frsForumToolDialogView.setCancleButtonListener(new r(this, cr4Var));
            frsForumToolDialogView.setConfirmButtonListener(new s(this, cr4Var, i2, str3));
            cr4Var.setContentView(frsForumToolDialogView);
            cr4Var.create(this.a.getPageContext()).show();
        }
    }

    public final boolean D0(String str, String str2, String str3, boolean z2) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Boolean.valueOf(z2)})) == null) {
            if (!this.z.g(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.b) == null || frsFragment.p0() == null) {
                return false;
            }
            this.C = false;
            this.z.h(this.a, str, str2, str3, this.b.p0().A());
            this.z.e().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean E0(dh8 dh8Var) {
        InterceptResult invokeL;
        PopInfo popInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dh8Var)) == null) {
            if (xt4.k().h(xt4.o("key_frs_shield_thread_dialog"), false) || dh8Var.getUserData() == null || dh8Var.getUserData().getIs_manager() <= 0 || (popInfo = dh8Var.frsMaskPopInfo) == null || popInfo.if_pop.intValue() != 1) {
                return false;
            }
            ImageView imageView = new ImageView(this.a);
            imageView.setImageResource(SkinManager.getResourceId(R.drawable.pic_frs_popup_shield));
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0402, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a);
            tBAlertBuilder.u(dh8Var.frsMaskPopInfo.title);
            tBAlertBuilder.p(dh8Var.frsMaskPopInfo.v_title);
            tBAlertBuilder.n(true);
            tBAlertBuilder.j(imageView);
            tBAlertBuilder.r(aVar);
            tBAlertBuilder.i(false);
            aVar.a(new q(this, tBAlertBuilder.w(), dh8Var));
            xt4.k().u(xt4.o("key_frs_shield_thread_dialog"), true);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (dh8Var.getForum() != null) {
                statisticItem.param("fid", dh8Var.getForum().getId());
                statisticItem.param("fname", dh8Var.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
            FrsFragment frsFragment = this.b;
            if (frsFragment != null) {
                frsFragment.v4(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void F0(dh8 dh8Var) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dh8Var) == null) || dh8Var == null || dh8Var.getUserData() == null || dh8Var.getUserData().getNewGodData() == null || (frsFragment = this.b) == null || frsFragment.v3()) {
            return;
        }
        if (dh8Var.getForum() != null) {
            vd5.g().j(dh8Var.getForum().getId());
        }
        vd5.g().k(2, dh8Var.getUserData().getNewGodData());
        FrsFragment frsFragment2 = this.b;
        if (frsFragment2 != null) {
            frsFragment2.v4(e0(dh8Var.getUserData().getNewGodData()));
            this.b.w4(e0(dh8Var.getUserData().getNewGodData()));
        }
    }

    @Override // com.repackage.ti5
    public void L(ri5 ri5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ri5Var) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof ti5) {
                frsFragment.L(ri5Var);
            }
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.l != this.j && d0()) {
                this.c.d2(this.j);
                if (U(this.j) != 1) {
                    this.b.q4(false);
                }
                this.l = this.j;
                z0(this.c.L1(), this.j);
                return;
            }
            this.b.d3();
        }
    }

    public final boolean N(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            if (this.a.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.a;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (d0()) {
                return false;
            }
            this.b.M = true;
            w0();
            if (xt4.k().h("frs_game_login_tip", true)) {
                xt4.k().u("frs_login_tip", true);
                xt4.k().u("frs_game_login_tip", false);
            }
            c0(list);
            if (this.b.D3() != null) {
                this.b.D3().W(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void O(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, forumData) == null) {
            boolean z2 = false;
            if (D0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
                if (this.A != null) {
                    qg.a().removeCallbacks(this.A);
                }
                z2 = true;
            }
            if (!this.B) {
                this.z.e().h(TbadkCoreApplication.getCurrentAccount(), forumData.getId(), System.currentTimeMillis());
                this.B = true;
            }
            if (z2) {
                return;
            }
            Runnable runnable = this.A;
            if (runnable == null) {
                runnable = new z(this, forumData);
            }
            this.A = runnable;
            qg.a().postDelayed(this.A, 60000L);
        }
    }

    public final void P(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, forumData) == null) || this.b.p0() == null || this.z == null) {
            return;
        }
        if (forumData == null) {
            forumData = this.d.getForum();
        }
        if (forumData == null || forumData.isLike() == 1) {
            return;
        }
        if (!this.D) {
            this.C = true;
        } else if (!D0(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) || this.A == null) {
        } else {
            qg.a().removeCallbacks(this.A);
        }
    }

    public final FragmentManager Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FrsActivity frsActivity = this.a;
            if (frsActivity != null) {
                return frsActivity.getSupportFragmentManager();
            }
            return null;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public FrsFragment R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b : (FrsFragment) invokeV.objValue;
    }

    @Override // com.repackage.ti5
    public si5 R0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof ti5) {
                return frsFragment.R0(i2);
            }
            return null;
        }
        return (si5) invokeI.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public eg<TbImageView> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!d0()) {
                FrsFragment frsFragment = this.b;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).S();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment == null) {
                    return null;
                }
                Fragment L1 = frsTabHostFragment.L1();
                if (L1 instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) L1).S();
                }
            }
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public FragmentTabHost T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.P1();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public final int U(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            be6 be6Var = this.e;
            if (be6Var != null && i2 < ListUtils.getCount(be6Var.f())) {
                return this.e.f().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int V(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            be6 be6Var = this.e;
            if (be6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(be6Var.f());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.e.f().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public TbPageTag W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!d0()) {
                return this.b.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.M1()) {
                    return this.b.getTbPageTag();
                }
                Fragment L1 = this.c.L1();
                if (L1 instanceof BaseFragment) {
                    return ((BaseFragment) L1).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public dh8 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.d : (dh8) invokeV.objValue;
    }

    public final boolean Y(dh8 dh8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, dh8Var)) == null) {
            if (dh8Var != null && dh8Var.getUserData() != null) {
                int is_manager = dh8Var.getUserData().getIs_manager();
                boolean h2 = xt4.k().h("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !h2) {
                    C0(1, this.a.getString(R.string.obfuscated_res_0x7f0f06bb), String.valueOf((int) R.drawable.obfuscated_res_0x7f080ed8), "");
                    xt4.k().u("key_forum_tool_find_dialog_show", true);
                    FrsFragment frsFragment = this.b;
                    if (frsFragment != null) {
                        frsFragment.v4(true);
                    }
                    return true;
                } else if (!h2 && is_manager == 2) {
                    C0(2, this.a.getString(R.string.obfuscated_res_0x7f0f06ba), String.valueOf((int) R.drawable.obfuscated_res_0x7f080ed8), "");
                    xt4.k().u("key_forum_tool_find_dialog_show", true);
                    FrsFragment frsFragment2 = this.b;
                    if (frsFragment2 != null) {
                        frsFragment2.v4(true);
                    }
                    return true;
                } else {
                    AddBawuPopInfo addBawuPopInfo = dh8Var.bawuPopInfo;
                    if (addBawuPopInfo != null) {
                        C0(3, addBawuPopInfo.content, addBawuPopInfo.img_url, addBawuPopInfo.jump_url);
                        FrsFragment frsFragment3 = this.b;
                        if (frsFragment3 != null) {
                            frsFragment3.v4(true);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void Z(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) || (frsActivity = this.a) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.obfuscated_res_0x7f0d02f4);
        this.o = (FrsBaseViewPager) this.a.findViewById(R.id.obfuscated_res_0x7f090aa7);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this, this.a.getSupportFragmentManager());
        this.p = fragmentAdapter;
        this.o.setAdapter(fragmentAdapter);
        this.o.setPageTransformer(true, new CubeOutViewPagerTransformer());
        this.o.addOnPageChangeListener(this.Z);
        this.o.setmDisallowSlip(true);
        this.o.setOnTouchEventListener(this.g0);
        ur4.d(this.o).f(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.a.findViewById(R.id.obfuscated_res_0x7f090b7d);
        this.q = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.q.setHasShadow(false);
        this.s = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090aaa);
        this.r = (FRSRefreshButton) this.a.findViewById(R.id.obfuscated_res_0x7f090b9a);
        this.t = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090b57);
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
        a0(bundle);
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

    public final void a0(Bundle bundle) {
        FragmentManager Q;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) || (Q = Q()) == null || Q.isDestroyed() || (fragmentAdapter = this.p) == null) {
            return;
        }
        try {
            FrsFragment frsFragment = (FrsFragment) fragmentAdapter.c(k0);
            if (frsFragment == null) {
                frsFragment = h0(bundle);
            }
            frsFragment.F4(this.q);
            frsFragment.H4(this.r);
            frsFragment.G4(this.t);
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

    public final void b0() {
        FragmentManager Q;
        FragmentAdapter fragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (Q = Q()) == null || Q.isDestroyed() || (fragmentAdapter = this.p) == null) {
            return;
        }
        try {
            FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) fragmentAdapter.c(l0);
            if (frsTabHostFragment == null) {
                frsTabHostFragment = i0();
            }
            frsTabHostFragment.h2(this.q);
            frsTabHostFragment.g2(this.r);
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

    public final void c0(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, list) == null) || ListUtils.isEmpty(list)) {
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
        this.e = new be6(this.a.getActivity(), arrayList);
        if (R() != null) {
            this.e.j(R().d());
            this.e.k(R().c());
            if (R().Q0() != null && R().Q0().getForum() != null) {
                ForumData forum = R().Q0().getForum();
                this.e.i(forum.getForumGameLabel());
                this.e.l(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.b;
        frsFragment.M = false;
        new nk6(frsFragment).g(this.e);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.e);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            FragmentAdapter fragmentAdapter = this.p;
            if (fragmentAdapter == null) {
                return false;
            }
            return fragmentAdapter.getItem(0) instanceof FrsTabHostFragment;
        }
        return invokeV.booleanValue;
    }

    public final boolean e0(NewGodData newGodData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, newGodData)) == null) {
            return (((((System.currentTimeMillis() - xt4.k().m("key_new_god_dialog_showed_time", 0L)) + 3000) > ImagesInvalidService.FILE_VALID_TIME ? 1 : (((System.currentTimeMillis() - xt4.k().m("key_new_god_dialog_showed_time", 0L)) + 3000) == ImagesInvalidService.FILE_VALID_TIME ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean f0(long j2) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048603, this, j2)) == null) {
            dh8 dh8Var = this.d;
            return (dh8Var == null || j2 == 0 || (forum = dh8Var.getForum()) == null || ng.g(forum.getId(), 0L) != j2) ? false : true;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void g0() {
        be6 be6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (be6Var = this.e) == null || TextUtils.isEmpty(be6Var.c())) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021074);
        httpMessage.addParam("forum_id", this.d.getForum().getId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final FrsFragment h0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, bundle)) == null) {
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

    public final FrsTabHostFragment i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.c == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.c = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(l0);
                this.c.e2(this.j);
            }
            return this.c;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public void j0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048608, this, i2, i3, intent) == null) {
            if (!d0()) {
                this.b.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.M1()) {
                        this.b.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment L1 = this.c.L1();
                        if (L1 != null) {
                            L1.onActivityResult(i2, i3, intent);
                        }
                    }
                }
            }
            if (i3 == -1) {
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1) {
                        v88.g().m(this.a.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem == null || (str = shareItem.w) == null || (shareSuccessReplyToServerModel = this.m) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.A(str, intExtra2, new x(this));
                    }
                } else if (i2 == 13011) {
                    v88.g().m(this.a.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.c;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.U1() != null) {
                        this.c.U1().o(this.a.getPageContext());
                        return;
                    }
                    FrsFragment frsFragment = this.b;
                    if (frsFragment == null || frsFragment.l1() == null || this.b.l1().Z() == null || this.b.l1().Z().h == null) {
                        return;
                    }
                    this.b.l1().Z().h.o(this.a.getPageContext());
                }
            }
        }
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
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
            v0();
        }
    }

    public void l0() {
        fp6 fp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.j);
            this.g.removeCallbacksAndMessages(null);
            if (this.a.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.a;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.Q != null) {
                qg.a().removeCallbacks(this.Q);
            }
            xt4.k().u(this.k, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.m;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.L0() != null) {
                this.b.L0().G0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.w;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.i)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.i)) {
                c45.h().i(false);
            }
            if (this.A != null) {
                qg.a().removeCallbacks(this.A);
            }
            dh8 dh8Var = this.d;
            if (dh8Var != null && dh8Var.getForum() != null && (fp6Var = this.z) != null) {
                fp6Var.b(ng.g(this.d.getForum().getId(), 0L));
            }
            qg.a().removeCallbacks(this.j0);
        }
    }

    public boolean m0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048611, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    FrsFragment frsFragment = this.b;
                    if (frsFragment == null || !frsFragment.isAdded()) {
                        return false;
                    }
                    return this.b.c4(i2, keyEvent);
                }
                return this.a.y0(i2, keyEvent);
            } else if (this.E) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                return false;
            } else if (this.F) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921642));
                return true;
            } else if (d0() && (frsTabHostFragment = this.c) != null && frsTabHostFragment.Y1()) {
                this.c.X1();
                UtilHelper.setNavigationBarBackground(this.a, this.c.K1());
                return false;
            } else {
                FrsFragment frsFragment2 = this.b;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    if (this.b.c4(i2, keyEvent)) {
                        return true;
                    }
                    M();
                    return false;
                }
                return this.a.y0(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void n0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, intent) == null) || (frsFragment = this.b) == null) {
            return;
        }
        frsFragment.d4(intent);
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.D = false;
            fp6 fp6Var = this.z;
            if (fp6Var != null) {
                fp6Var.d();
            }
            if (!d0()) {
                this.b.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    Fragment L1 = frsTabHostFragment.L1();
                    if (L1 instanceof BaseFragment) {
                        ((BaseFragment) L1).setPrimary(false);
                    }
                }
            }
            vd5.g().i();
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                qg.a().postDelayed(this.j0, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.h0);
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (!d0()) {
                this.b.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    Fragment L1 = frsTabHostFragment.L1();
                    if (L1 instanceof BaseFragment) {
                        ((BaseFragment) L1).setPrimary(true);
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
            F0(this.d);
            this.D = true;
            if (this.C) {
                P(null);
            }
            ItemCardHelper.v(this.i0);
            MessageManager.getInstance().registerListener(this.h0);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                c15.q().w(downloadData);
            }
        }
    }

    @Override // com.repackage.ti5
    public void q0(int i2, si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048615, this, i2, si5Var) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof ti5) {
                frsFragment.q0(i2, si5Var);
            }
        }
    }

    public void r0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            bundle.putString("name", this.h);
            bundle.putInt("default_tab_id", this.j);
            bundle.putString("from", this.i);
        }
    }

    public void s0(String str) {
        dh8 dh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || (dh8Var = this.d) == null || dh8Var.getForum() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.d.getForum().getId()).param("obj_type", 2));
    }

    public final void t0(dh8 dh8Var, boolean z2, int i2) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{dh8Var, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || dh8Var == null || dh8Var.getForum() == null || (frsActivity = this.a) == null || frsActivity.getPageContext() == null) {
            return;
        }
        this.d = dh8Var;
        ForumData forum = dh8Var.getForum();
        if (z2 && forum != null && !TextUtils.isEmpty(forum.getId())) {
            FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && !frsFragment.v3() && !this.b.J4(this.d, this.a.getPageContext()) && !this.b.X4(dh8Var)) {
            if (z2) {
                if (!E0(dh8Var) && !Y(dh8Var)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
                }
            } else if (!Y(dh8Var)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            }
        }
        if (forum.getIsShowBawuTask() && xt4.k().l("key_bawu_task_toast", 0) == 0 && !this.x) {
            this.x = true;
            qg.a().postDelayed(new n(this), 30000L);
        }
        if (ListUtils.getCount(dh8Var.getGameTabInfo()) > 0) {
            this.g.post(new o(this));
        } else if (d0()) {
            this.g.post(new p(this));
        }
        v0();
        B0();
        if (z2) {
            if ((!this.B || i2 == 4) && forum.isLike() == 0 && UbsABTestHelper.needShowFrsGuide() && TbadkCoreApplication.isLogin()) {
                this.z = new fp6();
                this.a.registerListener(this.V);
                this.a.registerListener(this.U);
                this.a.registerListener(this.W);
                O(forum);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!d0()) {
                return this.b.u0();
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment L1 = frsTabHostFragment.L1();
            if (L1 instanceof VoiceManager.j) {
                return ((VoiceManager.j) L1).u0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void v0() {
        dh8 dh8Var;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (dh8Var = this.d) == null || (themeColorInfo = dh8Var.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(1021074, this.N);
        }
    }

    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.j = i2;
        }
    }

    public void y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.l = i2;
        }
    }

    public final void z0(Fragment fragment, int i2) {
        dh8 dh8Var;
        NavigationBar N0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048624, this, fragment, i2) == null) || !(fragment instanceof je6) || (dh8Var = this.d) == null || dh8Var.getForum() == null || (N0 = ((je6) fragment).N0()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.d.getForum().getName(), 5, true, true) + this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0650));
        N0.setCenterTextTitle(sb.toString());
    }
}
