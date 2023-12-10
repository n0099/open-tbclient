package com.baidu.tieba.frs;

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
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.log.ActivityLog;
import com.baidu.tbadk.core.pagestay.PageStayDurationProxy;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.pageStayDuration.PageStayDurationFilter;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.pageStayDuration.PageStayDurationStat;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a08;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.g36;
import com.baidu.tieba.h25;
import com.baidu.tieba.i25;
import com.baidu.tieba.jt7;
import com.baidu.tieba.le0;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lq6;
import com.baidu.tieba.lt7;
import com.baidu.tieba.me0;
import com.baidu.tieba.n26;
import com.baidu.tieba.p45;
import com.baidu.tieba.pb;
import com.baidu.tieba.q45;
import com.baidu.tieba.q88;
import com.baidu.tieba.qs7;
import com.baidu.tieba.r06;
import com.baidu.tieba.r28;
import com.baidu.tieba.rd;
import com.baidu.tieba.s06;
import com.baidu.tieba.t06;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.tieba.w58;
import com.baidu.tieba.w88;
import com.baidu.tieba.wb5;
import com.baidu.tieba.ws5;
import com.baidu.tieba.xr7;
import com.baidu.tieba.y05;
import com.baidu.tieba.yb;
import com.baidu.tieba.yr7;
import com.baidu.tieba.zr7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class FrsActivity extends BaseFragmentActivity implements t06, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload, lt7, p45, le0, VoiceManager.i, i25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a08 a;
    public jt7 b;
    public w58 c;
    public pb<TbImageView> d;
    public pb<TbImageView> e;
    public boolean f;
    public boolean g;
    public r28 h;
    public long i;
    public ItemInfo j;
    public GuidePopupWindow k;
    public boolean l;
    @NonNull
    public final PriorityOrganizer m;
    public final me0 n;
    public VoiceManager o;
    public ResponsedEventListener p;
    public qs7 q;
    public ResponsedEventListener r;
    public CustomMessageListener s;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p45
    public String j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends ResponsedEventListener<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity a;

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
            this.a = frsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.om5
        /* renamed from: g */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId > 0 && this.a.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.q(this.a.getActivity(), tipEvent.message, tipEvent.linkUrl).s();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ResponsedEventListener<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity a;

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
            this.a = frsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.om5
        /* renamed from: g */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null || this.a.a.a0() == null) {
                    return false;
                }
                if (goodsEvent.getDispose()) {
                    return true;
                }
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.a).setType(9).setForumWriteData(this.a.a.a0().D4()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
                goodsEvent.setDispost(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.x1();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                YunDialogManager.unMarkShowingDialogName("frsGuide");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends PageStayDurationFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity a;

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public boolean isCurrentPageCanBeAddToSourceTrace() {
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
            this.a = frsActivity;
        }

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return PageStayDurationStat.getInstance().getMaxCostFromServer();
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
        this.g = false;
        this.l = false;
        this.m = PriorityOrganizer.create();
        this.n = new me0();
        this.p = new a(this);
        this.q = new qs7(this);
        this.r = new b(this);
        this.s = new c(this, 2921476);
    }

    @Override // com.baidu.tieba.lt7
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a08 a08Var = this.a;
            if (a08Var != null && a08Var.a0() != null && this.a.a0().V4() != null && this.a.a0().V4().B() != null && this.a.a0().V4().B().d == 16) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                a08 a08Var = this.a;
                if (a08Var != null && a08Var.a0() != null) {
                    pageStayDurationItem.setFid(JavaTypesHelper.toLong(this.a.a0().l, 0L));
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.setAbTag(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public final boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (!TbadkCoreApplication.isLogin() || SharedPrefHelper.getInstance().getBoolean("has_guide_popup_window_been_shown", false)) {
                return false;
            }
            a08 a08Var = this.a;
            if (a08Var != null && a08Var.f0() != null && this.a.f0().getUserData() != null && this.a.f0().getUserData().getIs_manager() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t06
    public s06 T1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            a08 a08Var = this.a;
            if (a08Var instanceof t06) {
                return a08Var.T1(i);
            }
            return null;
        }
        return (s06) invokeI.objValue;
    }

    @Override // com.baidu.tieba.lt7
    public void c1(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, itemInfo) == null) {
            this.j = itemInfo;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            this.n.a(motionEvent);
            a08 a08Var = this.a;
            if (a08Var != null) {
                a08Var.V(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            super.hideLoadingView(view2);
            z1(view2, false);
        }
    }

    @Override // com.baidu.tieba.t06
    public void o0(r06 r06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, r06Var) == null) {
            a08 a08Var = this.a;
            if (a08Var instanceof t06) {
                a08Var.o0(r06Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        a08 a08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i) == null) && (a08Var = this.a) != null) {
            a08Var.w0(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            GuidePopupWindow guidePopupWindow = this.k;
            if (guidePopupWindow != null) {
                guidePopupWindow.k();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921745));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, intent) == null) {
            super.onNewIntent(intent);
            a08 a08Var = this.a;
            if (a08Var != null) {
                a08Var.A0(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            a08 a08Var = this.a;
            if (a08Var != null) {
                a08Var.D0(bundle);
            }
            bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            super.onScreenShot(str);
            a08 a08Var = this.a;
            if (a08Var != null) {
                a08Var.E0(str);
            }
        }
    }

    public void y1(boolean z) {
        a08 a08Var;
        FragmentTabHost b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && (a08Var = this.a) != null && (b0 = a08Var.b0()) != null && b0.getFragmentTabWidget() != null) {
            if (z) {
                b0.e(2);
            } else {
                b0.e(4);
            }
        }
    }

    @Override // com.baidu.tieba.le0
    @NonNull
    public me0 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return (me0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public PriorityOrganizer a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public pb<TbImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == null) {
                this.e = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.e;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a08 a08Var = this.a;
            if (a08Var != null) {
                return a08Var.d1();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.f && !this.g) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return new e(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        TbPageTag tbPageTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            a08 a08Var = this.a;
            if (a08Var != null) {
                tbPageTag = a08Var.e0();
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

    @Override // com.baidu.tieba.i25
    public h25 i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return n1();
        }
        return (h25) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lt7
    public ItemInfo l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.j;
        }
        return (ItemInfo) invokeV.objValue;
    }

    public FrsFragment n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            a08 a08Var = this.a;
            if (a08Var == null) {
                return null;
            }
            return a08Var.a0();
        }
        return (FrsFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public r28 p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.h;
        }
        return (r28) invokeV.objValue;
    }

    public a08 q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.a;
        }
        return (a08) invokeV.objValue;
    }

    public void r1() {
        w58 w58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (w58Var = this.c) != null) {
            w58Var.h();
        }
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            a08 a08Var = this.a;
            if (a08Var != null && a08Var.a0() != null) {
                return this.a.a0().videoNeedPreload();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public pb<TbImageView> y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.d == null) {
                this.d = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.d;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t06
    public void f1(int i, s06 s06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, s06Var) == null) {
            a08 a08Var = this.a;
            if (a08Var instanceof t06) {
                a08Var.f1(i, s06Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048607, this, i, keyEvent)) == null) {
            a08 a08Var = this.a;
            if (a08Var != null) {
                return a08Var.z0(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public boolean u1(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048622, this, i, keyEvent)) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.g) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tieba.p45
    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            a08 a08Var = this.a;
            if (a08Var != null && a08Var.f0() != null && this.a.f0().getForum() != null) {
                return this.a.f0().getForum().getId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            a08 a08Var = this.a;
            if (a08Var != null) {
                a08Var.C0();
            }
            TbSingleton.getInstance().isInFrs = true;
            this.l = true;
            if (n1() != null && n1().i5()) {
                YunDialogManager.onShow(this, y05.q);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    public final void v1() {
        a08 a08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (a08Var = this.a) != null && a08Var.f0() != null && this.a.f0().getForum() != null) {
            SpecHotTopicHelper.removeSpecTopicIconForFrs(Long.valueOf(JavaTypesHelper.toLong(this.a.f0().getForum().getId(), 0L)));
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (t1()) {
                SharedPrefHelper.getInstance().putBoolean("has_guide_popup_window_been_shown", true);
                w1();
                if (yb.i(this.k, this)) {
                    YunDialogManager.markShowingDialogName("frsGuide");
                    return;
                } else {
                    YunDialogManager.unMarkShowingDialogName("frsGuide");
                    return;
                }
            }
            YunDialogManager.unMarkShowingDialogName("frsGuide");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
            if (nextPageSourceKeyList == null) {
                nextPageSourceKeyList = new ArrayList<>();
            }
            a08 a08Var = this.a;
            if (a08Var != null && a08Var.r0() && this.a.b0() != null && (this.a.b0().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.a.b0().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.a.b0().getCurrentFragment()).isPrimary()) {
                nextPageSourceKeyList.add(((BaseFragment) this.a.b0().getCurrentFragment()).getCurrentPageKey());
            } else {
                nextPageSourceKeyList.add(getCurrentPageKey());
            }
            return nextPageSourceKeyList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        PageStayDurationItem pageStayDurationItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            this.lastResumeTime = 0L;
            super.onPause();
            a08 a08Var = this.a;
            if (a08Var != null) {
                a08Var.B0();
            }
            if (!PageStayDurationProxy.isPageCountSTime()) {
                long j = this.i;
                if (j >= 0) {
                    long j2 = currentTimeMillis - j;
                    if (j2 >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                        pageStayDurationItem.setStayDurationTime(j2);
                        PageStayDurationStat.getInstance().stat(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                    }
                }
            }
            TbSingleton.getInstance().isInFrs = false;
            r28 r28Var = this.h;
            if (r28Var != null) {
                r28Var.a();
            }
            this.l = false;
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            YunDialogManager.onHidden(y05.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            a08 a08Var = this.a;
            if (a08Var != null) {
                a08Var.v0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048610, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            n1().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            super.showLoadingView(view2, z, i);
            z1(view2, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                BdUniqueId bdUniqueId2 = (BdUniqueId) intent.getSerializableExtra(FrsActivityConfig.FRS_PAGE_ID);
                if (bdUniqueId2 != null) {
                    setUniqueId(bdUniqueId2);
                }
                if ((intent.getParcelableExtra(IntentConfig.KEY_URI) != null || intent.getStringExtra(MainTabActivityConfig.PUSH_TID) != null) && !BdActivityStack.getInst().isActivityExist("MainTabActivity")) {
                    this.g = true;
                }
            } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
                setUniqueId(bdUniqueId);
            }
            if (this.g) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            n26.k().d();
            g36.i().b();
            a08 a08Var = new a08(this);
            this.a = a08Var;
            a08Var.i0(bundle);
            this.b = new jt7(this);
            if (w58.i(intent)) {
                this.f = true;
                enterExitAnimation();
                if (this.c == null) {
                    w58 w58Var = new w58(this, (ViewGroup) getWindow().getDecorView(), getIntent());
                    this.c = w58Var;
                    w58Var.l();
                }
            }
            this.h = new r28(this);
            registerResponsedEventListener(TipEvent.class, this.p);
            lq6.a(getIntent(), getPageContext(), 25050);
            this.k = new GuidePopupWindow(this);
            registerListener(this.s);
            registerListener(this.q);
            this.r.setPriority(10);
            registerResponsedEventListener(GoodsEvent.class, this.r);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && ws5.r()) {
                a08 a08Var2 = this.a;
                if (a08Var2 != null && a08Var2.a0() != null) {
                    str = this.a.a0().C0();
                } else {
                    str = "";
                }
                q88.m().J(this, w88.e().d("frs_feed"), q88.b("frs", "1"), str, ws5.f());
            }
            if (this.a != null) {
                q45.c(this.a.Y() + "_onCreate_" + System.currentTimeMillis());
                TbLog activityLog = ActivityLog.getInstance();
                activityLog.i("FRS", "onCreate:" + this.a.Y());
            }
            VoiceManager voiceManager = new VoiceManager();
            this.o = voiceManager;
            voiceManager.setIsUseMediaPlayer(true);
            this.o.onCreate(getPageContext());
            wb5.b(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDestroy();
            v1();
            if (this.a != null) {
                TbLog activityLog = ActivityLog.getInstance();
                activityLog.i("FRS", "onDestroy:" + this.a.Y());
                if (this.a.f0() != null && this.a.f0().getForum() != null && !TextUtils.isEmpty(this.a.f0().getForum().getId())) {
                    FrsVideoTabPlayActivityConfig.removeVideoTabListByFid(this.a.f0().getForum().getId());
                    FrsVideoTabPlayActivityConfig.subtractFrsPageCount(this.a.f0().getForum().getId());
                }
                this.a.x0();
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            yr7.f().m();
            xr7.h().n();
            xr7.h().c();
            zr7.c().a();
            if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                TbadkCoreApplication.getInst().setTaskId("");
            }
            FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
            if (frsNetModel != null) {
                frsNetModel.q0(null);
            }
            TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            n26.k().e();
            g36.i().c();
            jt7 jt7Var = this.b;
            if (jt7Var != null) {
                jt7Var.b();
            }
        }
    }

    public final void w1() {
        a08 a08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && this.k != null && (a08Var = this.a) != null && a08Var.f0() != null && this.a.f0().getForum() != null) {
            ForumData forum = this.a.f0().getForum();
            this.k.v();
            this.k.u(String.valueOf(this.a.f0().getUserData().getLevel_id()));
            this.k.t(this.a.f0().getUserData());
            this.k.m(forum.getName());
            this.k.r(forum.getMember_num(), forum.getThread_num());
            this.k.q(Integer.parseInt(forum.getId()));
            this.k.x(forum.getName());
            this.k.setOnDismissListener(new d(this));
        }
    }

    public void z1(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048629, this, view2, z) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090caf) {
                TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
            } else if (view2.getId() == 16908290) {
                TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
            }
            if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
                r1();
            }
        }
    }
}
