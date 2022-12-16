package com.baidu.tieba.frs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.by6;
import com.baidu.tieba.ch;
import com.baidu.tieba.di0;
import com.baidu.tieba.dr6;
import com.baidu.tieba.ei0;
import com.baidu.tieba.fl6;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.gw4;
import com.baidu.tieba.hs5;
import com.baidu.tieba.hy4;
import com.baidu.tieba.iw4;
import com.baidu.tieba.iy4;
import com.baidu.tieba.lk6;
import com.baidu.tieba.n9;
import com.baidu.tieba.nc5;
import com.baidu.tieba.og;
import com.baidu.tieba.p45;
import com.baidu.tieba.pr5;
import com.baidu.tieba.pv6;
import com.baidu.tieba.q66;
import com.baidu.tieba.ry4;
import com.baidu.tieba.sj6;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.ti5;
import com.baidu.tieba.tj6;
import com.baidu.tieba.tl6;
import com.baidu.tieba.uj6;
import com.baidu.tieba.up5;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.tieba.vp5;
import com.baidu.tieba.vx6;
import com.baidu.tieba.we5;
import com.baidu.tieba.wk5;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.ye5;
import com.baidu.tieba.ze5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class FrsActivity extends BaseFragmentActivity implements wp5, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload, fl6, hy4, di0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dr6 a;
    public pv6 b;
    public og<TbImageView> c;
    public og<TbImageView> d;
    public boolean e;
    public boolean f;
    public boolean g;
    public WeakReference<Context> h;
    public tl6 i;
    public long j;
    public ItemInfo k;
    public GuidePopupWindow l;
    public boolean m;
    @NonNull
    public final PriorityOrganizer n;
    public final ei0 o;
    public nc5 p;
    public lk6 q;
    public nc5 r;
    public CustomMessageListener s;

    @Override // com.baidu.tieba.hy4
    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i b1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.ve5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a extends nc5<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity c;

        public a(FrsActivity frsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gc5
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId > 0 && this.c.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.t(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).v();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends nc5<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity c;

        public b(FrsActivity frsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gc5
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null || this.c.a.Q() == null) {
                    return false;
                }
                if (goodsEvent.getDispose()) {
                    return true;
                }
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.c).setType(9).setForumWriteData(this.c.a.Q().p3()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
                goodsEvent.setDispost(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsActivity frsActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsActivity, Integer.valueOf(i)};
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
            this.a = frsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.c1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity a;

        public d(FrsActivity frsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                iw4.t("frsGuide");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends we5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity b;

        @Override // com.baidu.tieba.we5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public e(FrsActivity frsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsActivity;
        }

        @Override // com.baidu.tieba.we5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ze5.b().c();
            }
            return invokeV.intValue;
        }
    }

    public FrsActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = true;
        this.m = false;
        this.n = PriorityOrganizer.h();
        this.o = new ei0();
        this.p = new a(this);
        this.q = new lk6(this);
        this.r = new b(this);
        this.s = new c(this, 2921476);
    }

    public final boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!TbadkCoreApplication.isLogin() || ry4.l().i("has_guide_popup_window_been_shown", false)) {
                return false;
            }
            dr6 dr6Var = this.a;
            if (dr6Var != null && dr6Var.W() != null && this.a.W().getUserData() != null && this.a.W().getUserData().getIs_manager() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ye5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ye5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                dr6 dr6Var = this.a;
                if (dr6Var != null && dr6Var.Q() != null) {
                    pageStayDurationItem.t(xg.g(this.a.Q().l, 0L));
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (ye5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        ye5 pageStayDurationItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            this.lastResumeTime = 0L;
            super.onPause();
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                dr6Var.l0();
            }
            long j = this.j;
            if (j >= 0) {
                long j2 = currentTimeMillis - j;
                if (j2 >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                    pageStayDurationItem.y(j2);
                    ze5.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                }
            }
            TbSingleton.getInstance().isInFrs = false;
            tl6 tl6Var = this.i;
            if (tl6Var != null) {
                tl6Var.a();
            }
            this.m = false;
            iw4.o(gw4.p);
        }
    }

    @Override // com.baidu.tieba.fl6
    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var != null && dr6Var.Q() != null && this.a.Q().G3() != null && this.a.Q().G3().B() != null && this.a.Q().G3().B().d == 16) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fl6
    public void I0(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemInfo) == null) {
            this.k = itemInfo;
        }
    }

    @Override // com.baidu.tieba.wp5
    public void O(up5 up5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, up5Var) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var instanceof wp5) {
                dr6Var.O(up5Var);
            }
        }
    }

    @Override // com.baidu.tieba.wp5
    public vp5 T0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var instanceof wp5) {
                return dr6Var.T0(i);
            }
            return null;
        }
        return (vp5) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            this.o.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e1(boolean z) {
        dr6 dr6Var;
        FragmentTabHost R;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (dr6Var = this.a) != null && (R = dr6Var.R()) != null && R.getFragmentTabWidget() != null) {
            if (z) {
                R.e(2);
            } else {
                R.e(4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view2) == null) {
            super.hideLoadingView(view2);
            f1(view2, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        dr6 dr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && (dr6Var = this.a) != null) {
            dr6Var.h0(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921745));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, intent) == null) {
            super.onNewIntent(intent);
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                dr6Var.k0(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                dr6Var.n0(bundle);
            }
            bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            super.onScreenShot(str);
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                dr6Var.o0(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public og<TbImageView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d == null) {
                this.d = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.d;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.di0
    @NonNull
    public ei0 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.o;
        }
        return (ei0) invokeV.objValue;
    }

    public FrsFragment O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var == null) {
                return null;
            }
            return dr6Var.Q();
        }
        return (FrsFragment) invokeV.objValue;
    }

    public tl6 P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (tl6) invokeV.objValue;
    }

    public dr6 Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (dr6) invokeV.objValue;
    }

    public void R0() {
        pv6 pv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (pv6Var = this.b) != null) {
            pv6Var.h();
        }
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public og<TbImageView> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.c == null) {
                this.c = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.c;
        }
        return (og) invokeV.objValue;
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && X0()) {
            ry4.l().v("has_guide_popup_window_been_shown", true);
            a1();
            if (ch.i(this.l, this)) {
                iw4.n("frsGuide");
            }
        }
    }

    public PriorityOrganizer d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!this.e && !this.f) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.ve5
    public we5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return new e(this);
        }
        return (we5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        TbPageTag tbPageTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                tbPageTag = dr6Var.V();
            } else {
                tbPageTag = null;
            }
            if (tbPageTag == null) {
                return super.getTbPageTag();
            }
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fl6
    public ItemInfo j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.k;
        }
        return (ItemInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onStop();
            this.g = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                return dr6Var.r0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var != null && dr6Var.Q() != null) {
                return this.a.Q().videoNeedPreload();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Y0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, keyEvent)) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i, keyEvent)) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                return dr6Var.j0(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.wp5
    public void t0(int i, vp5 vp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i, vp5Var) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var instanceof wp5) {
                dr6Var.t0(i, vp5Var);
            }
        }
    }

    public final void Z0() {
        dr6 dr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (dr6Var = this.a) != null && dr6Var.W() != null && this.a.W().getForum() != null) {
            SpecHotTopicHelper.removeSpecTopicIconForFrs(Long.valueOf(xg.g(this.a.W().getForum().getId(), 0L)));
        }
    }

    @Override // com.baidu.tieba.hy4
    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            dr6 dr6Var = this.a;
            if (dr6Var != null && dr6Var.W() != null && this.a.W().getForum() != null) {
                return this.a.W().getForum().getId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.f) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onResume();
            if (this.g) {
                wk5.f(this.h);
                this.g = false;
            }
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                dr6Var.m0();
            }
            TbSingleton.getInstance().isInFrs = true;
            this.m = true;
            iw4.p(this, gw4.p);
        }
    }

    public final void a1() {
        dr6 dr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.l != null && (dr6Var = this.a) != null && dr6Var.W() != null && this.a.W().getForum() != null) {
            ForumData forum = this.a.W().getForum();
            this.l.t();
            this.l.s(String.valueOf(this.a.W().getUserData().getLevel_id()));
            this.l.r(this.a.W().getUserData());
            this.l.k(forum.getName());
            this.l.p(forum.getMember_num(), forum.getThread_num());
            this.l.o(Integer.parseInt(forum.getId()));
            this.l.u(forum.getName());
            this.l.setOnDismissListener(new d(this));
        }
    }

    public void f1(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, view2, z) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090b17) {
                TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
            } else if (view2.getId() == 16908290) {
                TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
            }
            if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
                R0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.ve5
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
            if (nextPageSourceKeyList == null) {
                nextPageSourceKeyList = new ArrayList<>();
            }
            dr6 dr6Var = this.a;
            if (dr6Var != null && dr6Var.c0() && this.a.R() != null && (this.a.R().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.a.R().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.a.R().getCurrentFragment()).isPrimary()) {
                nextPageSourceKeyList.add(((BaseFragment) this.a.R().getCurrentFragment()).getCurrentPageKey());
            } else {
                nextPageSourceKeyList.add(getCurrentPageKey());
            }
            return nextPageSourceKeyList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048609, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                dr6Var.g0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048617, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            O0().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            super.showLoadingView(view2, z, i);
            f1(view2, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                BdUniqueId bdUniqueId2 = (BdUniqueId) intent.getSerializableExtra(FrsActivityConfig.FRS_PAGE_ID);
                if (bdUniqueId2 != null) {
                    setUniqueId(bdUniqueId2);
                }
                if ((intent.getParcelableExtra(IntentConfig.KEY_URI) != null || intent.getStringExtra(MainTabActivityConfig.PUSH_TID) != null) && !n9.g().i("MainTabActivity")) {
                    this.f = true;
                }
            } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
                setUniqueId(bdUniqueId);
            }
            if (this.f) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            pr5.k().d();
            hs5.i().b();
            dr6 dr6Var = new dr6(this);
            this.a = dr6Var;
            dr6Var.X(bundle);
            if (pv6.i(intent)) {
                this.e = true;
                enterExitAnimation();
                if (this.b == null) {
                    pv6 pv6Var = new pv6(this, (ViewGroup) getWindow().getDecorView(), getIntent());
                    this.b = pv6Var;
                    pv6Var.l();
                }
            }
            this.h = new WeakReference<>(TbadkCoreApplication.getInst());
            this.i = new tl6(this);
            registerResponsedEventListener(TipEvent.class, this.p);
            q66.a(getIntent(), getPageContext(), 25050);
            this.l = new GuidePopupWindow(this);
            registerListener(this.s);
            registerListener(this.q);
            this.r.setPriority(10);
            registerResponsedEventListener(GoodsEvent.class, this.r);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && ti5.r()) {
                dr6 dr6Var2 = this.a;
                if (dr6Var2 != null && dr6Var2.Q() != null) {
                    str = this.a.Q().W();
                } else {
                    str = "";
                }
                vx6.m().K(this, by6.e().d("frs_feed"), vx6.b("frs", "1"), str, ti5.f());
            }
            if (this.a != null) {
                iy4.c(this.a.N() + "_onCreate_" + System.currentTimeMillis());
            }
            p45.b(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDestroy();
            Z0();
            dr6 dr6Var = this.a;
            if (dr6Var != null) {
                if (dr6Var.W() != null && this.a.W().getForum() != null && !TextUtils.isEmpty(this.a.W().getForum().getId())) {
                    FrsVideoTabPlayActivityConfig.removeVideoTabListByFid(this.a.W().getForum().getId());
                    FrsVideoTabPlayActivityConfig.subtractFrsPageCount(this.a.W().getForum().getId());
                }
                this.a.i0();
            }
            tj6.f().m();
            sj6.h().n();
            sj6.h().c();
            uj6.c().a();
            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                TbadkCoreApplication.getInst().setTaskId("");
            }
            FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
            if (frsNetModel != null) {
                frsNetModel.i0(null);
            }
            TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            pr5.k().e();
            hs5.i().c();
        }
    }
}
