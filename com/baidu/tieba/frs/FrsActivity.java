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
import com.baidu.tieba.b46;
import com.baidu.tieba.bg;
import com.baidu.tieba.c46;
import com.baidu.tieba.c95;
import com.baidu.tieba.d46;
import com.baidu.tieba.d95;
import com.baidu.tieba.ei;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.hj7;
import com.baidu.tieba.hw5;
import com.baidu.tieba.ig5;
import com.baidu.tieba.iy7;
import com.baidu.tieba.jj7;
import com.baidu.tieba.kg;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.oi7;
import com.baidu.tieba.oy7;
import com.baidu.tieba.q66;
import com.baidu.tieba.rt6;
import com.baidu.tieba.t55;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tv7;
import com.baidu.tieba.vh7;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.tieba.wh7;
import com.baidu.tieba.wp7;
import com.baidu.tieba.x56;
import com.baidu.tieba.xh7;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xj7;
import com.baidu.tieba.yi0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class FrsActivity extends BaseFragmentActivity implements d46, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload, jj7, c95, xi0, VoiceManager.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wp7 a;
    public hj7 b;
    public tv7 c;
    public bg<TbImageView> d;
    public bg<TbImageView> e;
    public boolean f;
    public boolean g;
    public xj7 h;
    public long i;
    public ItemInfo j;
    public GuidePopupWindow k;
    public boolean l;
    @NonNull
    public final PriorityOrganizer m;
    public final yi0 n;
    public VoiceManager o;
    public ResponsedEventListener p;
    public oi7 q;
    public ResponsedEventListener r;
    public CustomMessageListener s;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c95
    public String n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, voiceModel)) == null) {
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.eq5
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.eq5
        /* renamed from: g */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null || this.a.a.Y() == null) {
                    return false;
                }
                if (goodsEvent.getDispose()) {
                    return true;
                }
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.a).setType(9).setForumWriteData(this.a.a.Y().T3()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
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
                this.a.F1();
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
        this.n = new yi0();
        this.p = new a(this);
        this.q = new oi7(this);
        this.r = new b(this);
        this.s = new c(this, 2921476);
    }

    public final boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin() || SharedPrefHelper.getInstance().getBoolean("has_guide_popup_window_been_shown", false)) {
                return false;
            }
            wp7 wp7Var = this.a;
            if (wp7Var != null && wp7Var.f0() != null && this.a.f0().getUserData() != null && this.a.f0().getUserData().getIs_manager() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jj7
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var != null && wp7Var.Y() != null && this.a.Y().m4() != null && this.a.Y().m4().B() != null && this.a.Y().m4().B().d == 16) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                wp7 wp7Var = this.a;
                if (wp7Var != null && wp7Var.Y() != null) {
                    pageStayDurationItem.setFid(JavaTypesHelper.toLong(this.a.Y().l, 0L));
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.setAbTag(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public void G1(boolean z) {
        wp7 wp7Var;
        FragmentTabHost b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (wp7Var = this.a) != null && (b0 = wp7Var.b0()) != null && b0.getFragmentTabWidget() != null) {
            if (z) {
                b0.e(2);
            } else {
                b0.e(4);
            }
        }
    }

    @Override // com.baidu.tieba.d46
    public void Z(b46 b46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b46Var) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var instanceof d46) {
                wp7Var.Z(b46Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            this.n.a(motionEvent);
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                wp7Var.T(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view2) == null) {
            super.hideLoadingView(view2);
            H1(view2, false);
        }
    }

    @Override // com.baidu.tieba.jj7
    public void l1(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, itemInfo) == null) {
            this.j = itemInfo;
        }
    }

    @Override // com.baidu.tieba.d46
    public c46 o1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var instanceof d46) {
                return wp7Var.o1(i);
            }
            return null;
        }
        return (c46) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        wp7 wp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && (wp7Var = this.a) != null) {
            wp7Var.v0(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, configuration) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048611, this, intent) == null) {
            super.onNewIntent(intent);
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                wp7Var.y0(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                wp7Var.B0(bundle);
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
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            super.onScreenShot(str);
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                wp7Var.C0(str);
            }
        }
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                return wp7Var.H0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public bg<TbImageView> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.e == null) {
                this.e = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.e;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xi0
    @NonNull
    public yi0 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.n;
        }
        return (yi0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return new e(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        TbPageTag tbPageTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                tbPageTag = wp7Var.e0();
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
    public bg<TbImageView> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.d == null) {
                this.d = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.d;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public PriorityOrganizer q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.m;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    public FrsFragment v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var == null) {
                return null;
            }
            return wp7Var.Y();
        }
        return (FrsFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var != null && wp7Var.Y() != null) {
                return this.a.Y().videoNeedPreload();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public xj7 w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.h;
        }
        return (xj7) invokeV.objValue;
    }

    public wp7 x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.a;
        }
        return (wp7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jj7
    public ItemInfo y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.j;
        }
        return (ItemInfo) invokeV.objValue;
    }

    public void y1() {
        tv7 tv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (tv7Var = this.c) != null) {
            tv7Var.h();
        }
    }

    public boolean C1(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, keyEvent)) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.d46
    public void J0(int i, c46 c46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, c46Var) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var instanceof d46) {
                wp7Var.J0(i, c46Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i, keyEvent)) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                return wp7Var.x0(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void D1() {
        wp7 wp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (wp7Var = this.a) != null && wp7Var.f0() != null && this.a.f0().getForum() != null) {
            SpecHotTopicHelper.removeSpecTopicIconForFrs(Long.valueOf(JavaTypesHelper.toLong(this.a.f0().getForum().getId(), 0L)));
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (B1()) {
                SharedPrefHelper.getInstance().putBoolean("has_guide_popup_window_been_shown", true);
                E1();
                if (kg.i(this.k, this)) {
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
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.g) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                wp7Var.A0();
            }
            TbSingleton.getInstance().isInFrs = true;
            this.l = true;
            if (v1() != null && v1().z4()) {
                YunDialogManager.onShow(this, t55.q);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.c95
    public String u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            wp7 wp7Var = this.a;
            if (wp7Var != null && wp7Var.f0() != null && this.a.f0().getForum() != null) {
                return this.a.f0().getForum().getId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void E1() {
        wp7 wp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.k != null && (wp7Var = this.a) != null && wp7Var.f0() != null && this.a.f0().getForum() != null) {
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

    public void H1(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, view2, z) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090c50) {
                TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
            } else if (view2.getId() == 16908290) {
                TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
            }
            if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
                y1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
            if (nextPageSourceKeyList == null) {
                nextPageSourceKeyList = new ArrayList<>();
            }
            wp7 wp7Var = this.a;
            if (wp7Var != null && wp7Var.q0() && this.a.b0() != null && (this.a.b0().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.a.b0().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.a.b0().getCurrentFragment()).isPrimary()) {
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
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            this.lastResumeTime = 0L;
            super.onPause();
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                wp7Var.z0();
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
            xj7 xj7Var = this.h;
            if (xj7Var != null) {
                xj7Var.a();
            }
            this.l = false;
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            YunDialogManager.onHidden(t55.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048605, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            wp7 wp7Var = this.a;
            if (wp7Var != null) {
                wp7Var.u0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048613, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            v1().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            super.showLoadingView(view2, z, i);
            H1(view2, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
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
            x56.k().d();
            q66.i().b();
            wp7 wp7Var = new wp7(this);
            this.a = wp7Var;
            wp7Var.j0(bundle);
            this.b = new hj7(this);
            if (tv7.i(intent)) {
                this.f = true;
                enterExitAnimation();
                if (this.c == null) {
                    tv7 tv7Var = new tv7(this, (ViewGroup) getWindow().getDecorView(), getIntent());
                    this.c = tv7Var;
                    tv7Var.l();
                }
            }
            this.h = new xj7(this);
            registerResponsedEventListener(TipEvent.class, this.p);
            rt6.a(getIntent(), getPageContext(), 25050);
            this.k = new GuidePopupWindow(this);
            registerListener(this.s);
            registerListener(this.q);
            this.r.setPriority(10);
            registerResponsedEventListener(GoodsEvent.class, this.r);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && hw5.r()) {
                wp7 wp7Var2 = this.a;
                if (wp7Var2 != null && wp7Var2.Y() != null) {
                    str = this.a.Y().l0();
                } else {
                    str = "";
                }
                iy7.m().J(this, oy7.e().d("frs_feed"), iy7.b("frs", "1"), str, hw5.f());
            }
            if (this.a != null) {
                d95.c(this.a.W() + "_onCreate_" + System.currentTimeMillis());
                TbLog activityLog = ActivityLog.getInstance();
                activityLog.i("FRS", "onCreate:" + this.a.W());
            }
            VoiceManager voiceManager = new VoiceManager();
            this.o = voiceManager;
            voiceManager.setIsUseMediaPlayer(true);
            this.o.onCreate(getPageContext());
            ig5.b(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDestroy();
            D1();
            if (this.a != null) {
                TbLog activityLog = ActivityLog.getInstance();
                activityLog.i("FRS", "onDestroy:" + this.a.W());
                if (this.a.f0() != null && this.a.f0().getForum() != null && !TextUtils.isEmpty(this.a.f0().getForum().getId())) {
                    FrsVideoTabPlayActivityConfig.removeVideoTabListByFid(this.a.f0().getForum().getId());
                    FrsVideoTabPlayActivityConfig.subtractFrsPageCount(this.a.f0().getForum().getId());
                }
                this.a.w0();
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            wh7.f().m();
            vh7.h().n();
            vh7.h().c();
            xh7.c().a();
            if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                TbadkCoreApplication.getInst().setTaskId("");
            }
            FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
            if (frsNetModel != null) {
                frsNetModel.o0(null);
            }
            TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            x56.k().e();
            q66.i().c();
            hj7 hj7Var = this.b;
            if (hj7Var != null) {
                hj7Var.b();
            }
        }
    }
}
