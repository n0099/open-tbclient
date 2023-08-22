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
import com.baidu.tieba.ag;
import com.baidu.tieba.ai7;
import com.baidu.tieba.b56;
import com.baidu.tieba.ci7;
import com.baidu.tieba.di;
import com.baidu.tieba.ex7;
import com.baidu.tieba.f36;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.g36;
import com.baidu.tieba.h36;
import com.baidu.tieba.hh7;
import com.baidu.tieba.jg;
import com.baidu.tieba.ku7;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lv5;
import com.baidu.tieba.n55;
import com.baidu.tieba.no7;
import com.baidu.tieba.ns6;
import com.baidu.tieba.og7;
import com.baidu.tieba.pg7;
import com.baidu.tieba.qg7;
import com.baidu.tieba.qi7;
import com.baidu.tieba.sf5;
import com.baidu.tieba.t85;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.u56;
import com.baidu.tieba.u85;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.tieba.wi0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.yw7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class FrsActivity extends BaseFragmentActivity implements h36, VoiceManager.i, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload, ci7, t85, wi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public no7 a;
    public ai7 b;
    public ku7 c;
    public ag<TbImageView> d;
    public ag<TbImageView> e;
    public boolean f;
    public boolean g;
    public qi7 h;
    public long i;
    public ItemInfo j;
    public GuidePopupWindow k;
    public boolean l;
    @NonNull
    public final PriorityOrganizer m;
    public final xi0 n;
    public ResponsedEventListener o;
    public hh7 p;
    public ResponsedEventListener q;
    public CustomMessageListener r;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t85
    public String m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView q1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes5.dex */
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lp5
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

    /* loaded from: classes5.dex */
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lp5
        /* renamed from: g */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null || this.a.a.Z() == null) {
                    return false;
                }
                if (goodsEvent.getDispose()) {
                    return true;
                }
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.a).setType(9).setForumWriteData(this.a.a.Z().R3()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
                goodsEvent.setDispost(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.E1();
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        this.n = new xi0();
        this.o = new a(this);
        this.p = new hh7(this);
        this.q = new b(this);
        this.r = new c(this, 2921476);
    }

    public final boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.isLogin() || SharedPrefHelper.getInstance().getBoolean("has_guide_popup_window_been_shown", false)) {
                return false;
            }
            no7 no7Var = this.a;
            if (no7Var != null && no7Var.f0() != null && this.a.f0().getUserData() != null && this.a.f0().getUserData().getIs_manager() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ci7
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            no7 no7Var = this.a;
            if (no7Var != null && no7Var.Z() != null && this.a.Z().k4() != null && this.a.Z().k4().B() != null && this.a.Z().k4().B().d == 16) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                no7 no7Var = this.a;
                if (no7Var != null && no7Var.Z() != null) {
                    pageStayDurationItem.setFid(JavaTypesHelper.toLong(this.a.Z().l, 0L));
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.setAbTag(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        PageStayDurationItem pageStayDurationItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            this.lastResumeTime = 0L;
            super.onPause();
            no7 no7Var = this.a;
            if (no7Var != null) {
                no7Var.z0();
            }
            long j = this.i;
            if (j >= 0) {
                long j2 = currentTimeMillis - j;
                if (j2 >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                    pageStayDurationItem.setStayDurationTime(j2);
                    PageStayDurationStat.getInstance().stat(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                }
            }
            TbSingleton.getInstance().isInFrs = false;
            qi7 qi7Var = this.h;
            if (qi7Var != null) {
                qi7Var.a();
            }
            this.l = false;
            YunDialogManager.onHidden(n55.q);
        }
    }

    public void F1(boolean z) {
        no7 no7Var;
        FragmentTabHost b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (no7Var = this.a) != null && (b0 = no7Var.b0()) != null && b0.getFragmentTabWidget() != null) {
            if (z) {
                b0.e(2);
            } else {
                b0.e(4);
            }
        }
    }

    @Override // com.baidu.tieba.h36
    public void Y(f36 f36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, f36Var) == null) {
            no7 no7Var = this.a;
            if (no7Var instanceof h36) {
                no7Var.Y(f36Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            this.n.a(motionEvent);
            no7 no7Var = this.a;
            if (no7Var != null) {
                no7Var.T(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.hideLoadingView(view2);
            G1(view2, false);
        }
    }

    @Override // com.baidu.tieba.ci7
    public void k1(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, itemInfo) == null) {
            this.j = itemInfo;
        }
    }

    @Override // com.baidu.tieba.h36
    public g36 n1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            no7 no7Var = this.a;
            if (no7Var instanceof h36) {
                return no7Var.n1(i);
            }
            return null;
        }
        return (g36) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        no7 no7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i) == null) && (no7Var = this.a) != null) {
            no7Var.v0(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, configuration) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048609, this, intent) == null) {
            super.onNewIntent(intent);
            no7 no7Var = this.a;
            if (no7Var != null) {
                no7Var.y0(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            no7 no7Var = this.a;
            if (no7Var != null) {
                no7Var.B0(bundle);
            }
            bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            super.onScreenShot(str);
            no7 no7Var = this.a;
            if (no7Var != null) {
                no7Var.C0(str);
            }
        }
    }

    public boolean B1(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, keyEvent)) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.h36
    public void I0(int i, g36 g36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, g36Var) == null) {
            no7 no7Var = this.a;
            if (no7Var instanceof h36) {
                no7Var.I0(i, g36Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i, keyEvent)) == null) {
            no7 no7Var = this.a;
            if (no7Var != null) {
                return no7Var.x0(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void C1() {
        no7 no7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (no7Var = this.a) != null && no7Var.f0() != null && this.a.f0().getForum() != null) {
            SpecHotTopicHelper.removeSpecTopicIconForFrs(Long.valueOf(JavaTypesHelper.toLong(this.a.f0().getForum().getId(), 0L)));
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (A1()) {
                SharedPrefHelper.getInstance().putBoolean("has_guide_popup_window_been_shown", true);
                D1();
                if (jg.i(this.k, this)) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.g) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onResume();
            no7 no7Var = this.a;
            if (no7Var != null) {
                no7Var.A0();
            }
            TbSingleton.getInstance().isInFrs = true;
            this.l = true;
            if (u1() != null && u1().x4()) {
                YunDialogManager.onShow(this, n55.q);
            }
        }
    }

    @Override // com.baidu.tieba.t85
    public String v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            no7 no7Var = this.a;
            if (no7Var != null && no7Var.f0() != null && this.a.f0().getForum() != null) {
                return this.a.f0().getForum().getId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void D1() {
        no7 no7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.k != null && (no7Var = this.a) != null && no7Var.f0() != null && this.a.f0().getForum() != null) {
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            no7 no7Var = this.a;
            if (no7Var != null) {
                return no7Var.G0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.e == null) {
                this.e = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.e;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wi0
    @NonNull
    public xi0 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return (xi0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return new e(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        TbPageTag tbPageTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            no7 no7Var = this.a;
            if (no7Var != null) {
                tbPageTag = no7Var.e0();
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

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ag<TbImageView> h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.d == null) {
                this.d = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.d;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onStop();
        }
    }

    public PriorityOrganizer q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.m;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    public FrsFragment u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            no7 no7Var = this.a;
            if (no7Var == null) {
                return null;
            }
            return no7Var.Z();
        }
        return (FrsFragment) invokeV.objValue;
    }

    public qi7 v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.h;
        }
        return (qi7) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            no7 no7Var = this.a;
            if (no7Var != null && no7Var.Z() != null) {
                return this.a.Z().videoNeedPreload();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public no7 w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.a;
        }
        return (no7) invokeV.objValue;
    }

    public void x1() {
        ku7 ku7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (ku7Var = this.c) != null) {
            ku7Var.h();
        }
    }

    @Override // com.baidu.tieba.ci7
    public ItemInfo y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.j;
        }
        return (ItemInfo) invokeV.objValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public void G1(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view2, z) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090c54) {
                TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
            } else if (view2.getId() == 16908290) {
                TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
            }
            if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
                x1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
            if (nextPageSourceKeyList == null) {
                nextPageSourceKeyList = new ArrayList<>();
            }
            no7 no7Var = this.a;
            if (no7Var != null && no7Var.q0() && this.a.b0() != null && (this.a.b0().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.a.b0().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.a.b0().getCurrentFragment()).isPrimary()) {
                nextPageSourceKeyList.add(((BaseFragment) this.a.b0().getCurrentFragment()).getCurrentPageKey());
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
        if (interceptable == null || interceptable.invokeIIL(1048603, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            no7 no7Var = this.a;
            if (no7Var != null) {
                no7Var.u0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048611, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            u1().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            super.showLoadingView(view2, z, i);
            G1(view2, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
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
            b56.k().d();
            u56.i().b();
            no7 no7Var = new no7(this);
            this.a = no7Var;
            no7Var.j0(bundle);
            this.b = new ai7(this);
            if (ku7.i(intent)) {
                this.f = true;
                enterExitAnimation();
                if (this.c == null) {
                    ku7 ku7Var = new ku7(this, (ViewGroup) getWindow().getDecorView(), getIntent());
                    this.c = ku7Var;
                    ku7Var.l();
                }
            }
            this.h = new qi7(this);
            registerResponsedEventListener(TipEvent.class, this.o);
            ns6.a(getIntent(), getPageContext(), 25050);
            this.k = new GuidePopupWindow(this);
            registerListener(this.r);
            registerListener(this.p);
            this.q.setPriority(10);
            registerResponsedEventListener(GoodsEvent.class, this.q);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && lv5.r()) {
                no7 no7Var2 = this.a;
                if (no7Var2 != null && no7Var2.Z() != null) {
                    str = this.a.Z().k0();
                } else {
                    str = "";
                }
                yw7.m().J(this, ex7.e().d("frs_feed"), yw7.b("frs", "1"), str, lv5.f());
            }
            if (this.a != null) {
                u85.c(this.a.W() + "_onCreate_" + System.currentTimeMillis());
                TbLog activityLog = ActivityLog.getInstance();
                activityLog.i("FRS", "onCreate:" + this.a.W());
            }
            sf5.b(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onDestroy();
            C1();
            if (this.a != null) {
                TbLog activityLog = ActivityLog.getInstance();
                activityLog.i("FRS", "onDestroy:" + this.a.W());
                if (this.a.f0() != null && this.a.f0().getForum() != null && !TextUtils.isEmpty(this.a.f0().getForum().getId())) {
                    FrsVideoTabPlayActivityConfig.removeVideoTabListByFid(this.a.f0().getForum().getId());
                    FrsVideoTabPlayActivityConfig.subtractFrsPageCount(this.a.f0().getForum().getId());
                }
                this.a.w0();
            }
            pg7.f().m();
            og7.h().n();
            og7.h().c();
            qg7.c().a();
            if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                TbadkCoreApplication.getInst().setTaskId("");
            }
            FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
            if (frsNetModel != null) {
                frsNetModel.p0(null);
            }
            TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            b56.k().e();
            u56.i().c();
            ai7 ai7Var = this.b;
            if (ai7Var != null) {
                ai7Var.b();
            }
        }
    }
}
