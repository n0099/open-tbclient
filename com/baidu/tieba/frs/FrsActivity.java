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
import com.baidu.tbadk.core.log.ActivityLog;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.aj7;
import com.baidu.tieba.ay7;
import com.baidu.tieba.bh;
import com.baidu.tieba.bh5;
import com.baidu.tieba.c76;
import com.baidu.tieba.cj7;
import com.baidu.tieba.da5;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.fx5;
import com.baidu.tieba.g56;
import com.baidu.tieba.gv7;
import com.baidu.tieba.h29;
import com.baidu.tieba.h56;
import com.baidu.tieba.h9;
import com.baidu.tieba.hi7;
import com.baidu.tieba.ht5;
import com.baidu.tieba.i56;
import com.baidu.tieba.jp7;
import com.baidu.tieba.jt5;
import com.baidu.tieba.kt5;
import com.baidu.tieba.l65;
import com.baidu.tieba.m65;
import com.baidu.tieba.ng;
import com.baidu.tieba.oh7;
import com.baidu.tieba.ph7;
import com.baidu.tieba.qh7;
import com.baidu.tieba.qj7;
import com.baidu.tieba.t95;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.u95;
import com.baidu.tieba.ux7;
import com.baidu.tieba.v76;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.tieba.vj0;
import com.baidu.tieba.wg;
import com.baidu.tieba.wj0;
import com.baidu.tieba.wt6;
import com.baidu.tieba.xi;
import com.baidu.tieba.xq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class FrsActivity extends BaseFragmentActivity implements i56, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload, cj7, t95, vj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jp7 a;
    public aj7 b;
    public gv7 c;
    public ng<TbImageView> d;
    public ng<TbImageView> e;
    public boolean f;
    public boolean g;
    public qj7 h;
    public long i;
    public ItemInfo j;
    public GuidePopupWindow k;
    public boolean l;
    @NonNull
    public final PriorityOrganizer m;
    public final wj0 n;
    public xq5 o;
    public hi7 p;
    public xq5 q;
    public CustomMessageListener r;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.gt5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t95
    public String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends xq5<TipEvent> {
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
        @Override // com.baidu.tieba.qq5
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId > 0 && this.c.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.s(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends xq5<GoodsEvent> {
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
        @Override // com.baidu.tieba.qq5
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null || this.c.a.Z() == null) {
                    return false;
                }
                if (goodsEvent.getDispose()) {
                    return true;
                }
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.c).setType(9).setForumWriteData(this.c.a.Z().E3()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
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
                m65.u("frsGuide");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends ht5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity b;

        @Override // com.baidu.tieba.ht5
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

        @Override // com.baidu.tieba.ht5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return kt5.b().c();
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
        this.m = PriorityOrganizer.o();
        this.n = new wj0();
        this.o = new a(this);
        this.p = new hi7(this);
        this.q = new b(this);
        this.r = new c(this, 2921476);
    }

    public final boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin() || da5.p().l("has_guide_popup_window_been_shown", false)) {
                return false;
            }
            jp7 jp7Var = this.a;
            if (jp7Var != null && jp7Var.g0() != null && this.a.g0().getUserData() != null && this.a.g0().getUserData().getIs_manager() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cj7
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var != null && jp7Var.Z() != null && this.a.Z().W3() != null && this.a.Z().W3().B() != null && this.a.Z().W3().B().d == 16) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public jt5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            jt5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                jp7 jp7Var = this.a;
                if (jp7Var != null && jp7Var.Z() != null) {
                    pageStayDurationItem.t(wg.g(this.a.Z().l, 0L));
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (jt5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        jt5 pageStayDurationItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            this.lastResumeTime = 0L;
            super.onPause();
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                jp7Var.B0();
            }
            long j = this.i;
            if (j >= 0) {
                long j2 = currentTimeMillis - j;
                if (j2 >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                    pageStayDurationItem.y(j2);
                    kt5.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                }
            }
            TbSingleton.getInstance().isInFrs = false;
            qj7 qj7Var = this.h;
            if (qj7Var != null) {
                qj7Var.a();
            }
            this.l = false;
            m65.o(l65.p);
        }
    }

    public void H1(boolean z) {
        jp7 jp7Var;
        FragmentTabHost c0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (jp7Var = this.a) != null && (c0 = jp7Var.c0()) != null && c0.getFragmentTabWidget() != null) {
            if (z) {
                c0.e(2);
            } else {
                c0.e(4);
            }
        }
    }

    @Override // com.baidu.tieba.i56
    public void S(g56 g56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, g56Var) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var instanceof i56) {
                jp7Var.S(g56Var);
            }
        }
    }

    @Override // com.baidu.tieba.i56
    public h56 d1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var instanceof i56) {
                return jp7Var.d1(i);
            }
            return null;
        }
        return (h56) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            this.n.a(motionEvent);
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                jp7Var.U(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            super.hideLoadingView(view2);
            I1(view2, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        jp7 jp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i) == null) && (jp7Var = this.a) != null) {
            jp7Var.v0(i);
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
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                jp7Var.z0(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                jp7Var.D0(bundle);
            }
            bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            super.onScreenShot(str);
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                jp7Var.E0(str);
            }
        }
    }

    @Override // com.baidu.tieba.cj7
    public void p1(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, itemInfo) == null) {
            this.j = itemInfo;
        }
    }

    @Override // com.baidu.tieba.i56
    public void A0(int i, h56 h56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, h56Var) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var instanceof i56) {
                jp7Var.A0(i, h56Var);
            }
        }
    }

    public boolean C1(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, keyEvent)) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048607, this, i, keyEvent)) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                return jp7Var.x0(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.cj7
    public ItemInfo B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (ItemInfo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ng<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.e == null) {
                this.e = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.e;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ng<TbImageView> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.d == null) {
                this.d = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.d;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vj0
    @NonNull
    public wj0 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.n;
        }
        return (wj0) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.gt5
    public ht5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return new e(this);
        }
        return (ht5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        TbPageTag tbPageTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                tbPageTag = jp7Var.f0();
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onStop();
        }
    }

    public PriorityOrganizer r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.m;
        }
        return (PriorityOrganizer) invokeV.objValue;
    }

    public FrsFragment v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var == null) {
                return null;
            }
            return jp7Var.Z();
        }
        return (FrsFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var != null && jp7Var.Z() != null) {
                return this.a.Z().videoNeedPreload();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public qj7 w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.h;
        }
        return (qj7) invokeV.objValue;
    }

    public jp7 x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.a;
        }
        return (jp7) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                return jp7Var.y0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void y1() {
        gv7 gv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (gv7Var = this.c) != null) {
            gv7Var.h();
        }
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public final void D1() {
        jp7 jp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (jp7Var = this.a) != null && jp7Var.g0() != null && this.a.g0().getForum() != null) {
            SpecHotTopicHelper.removeSpecTopicIconForFrs(Long.valueOf(wg.g(this.a.g0().getForum().getId(), 0L)));
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (A1()) {
                da5.p().A("has_guide_popup_window_been_shown", true);
                E1();
                if (bh.i(this.k, this)) {
                    m65.n("frsGuide");
                    return;
                } else {
                    m65.u("frsGuide");
                    return;
                }
            }
            m65.u("frsGuide");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.g) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                jp7Var.C0();
            }
            TbSingleton.getInstance().isInFrs = true;
            this.l = true;
            if (!LooperBlockSwitch.getIsOn() || (v1() != null && v1().j4())) {
                m65.p(this, l65.p);
            }
        }
    }

    @Override // com.baidu.tieba.t95
    public String v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            jp7 jp7Var = this.a;
            if (jp7Var != null && jp7Var.g0() != null && this.a.g0().getForum() != null) {
                return this.a.g0().getForum().getId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void E1() {
        jp7 jp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.k != null && (jp7Var = this.a) != null && jp7Var.g0() != null && this.a.g0().getForum() != null) {
            ForumData forum = this.a.g0().getForum();
            this.k.v();
            this.k.u(String.valueOf(this.a.g0().getUserData().getLevel_id()));
            this.k.t(this.a.g0().getUserData());
            this.k.m(forum.getName());
            this.k.r(forum.getMember_num(), forum.getThread_num());
            this.k.q(Integer.parseInt(forum.getId()));
            this.k.x(forum.getName());
            this.k.setOnDismissListener(new d(this));
        }
    }

    public void I1(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, view2, z) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090c35) {
                TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
            } else if (view2.getId() == 16908290) {
                TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
            }
            if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
                y1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.gt5
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
            if (nextPageSourceKeyList == null) {
                nextPageSourceKeyList = new ArrayList<>();
            }
            jp7 jp7Var = this.a;
            if (jp7Var != null && jp7Var.q0() && this.a.c0() != null && (this.a.c0().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.a.c0().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.a.c0().getCurrentFragment()).isPrimary()) {
                nextPageSourceKeyList.add(((BaseFragment) this.a.c0().getCurrentFragment()).getCurrentPageKey());
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
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            jp7 jp7Var = this.a;
            if (jp7Var != null) {
                jp7Var.u0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048610, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            v1().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            super.showLoadingView(view2, z, i);
            I1(view2, true);
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
                if ((intent.getParcelableExtra(IntentConfig.KEY_URI) != null || intent.getStringExtra(MainTabActivityConfig.PUSH_TID) != null) && !h9.f().h("MainTabActivity")) {
                    this.g = true;
                }
            } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
                setUniqueId(bdUniqueId);
            }
            if (this.g) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            c76.k().d();
            v76.i().b();
            jp7 jp7Var = new jp7(this);
            this.a = jp7Var;
            jp7Var.j0(bundle);
            this.b = new aj7(this);
            if (gv7.i(intent)) {
                this.f = true;
                enterExitAnimation();
                if (this.c == null) {
                    gv7 gv7Var = new gv7(this, (ViewGroup) getWindow().getDecorView(), getIntent());
                    this.c = gv7Var;
                    gv7Var.l();
                }
            }
            this.h = new qj7(this);
            registerResponsedEventListener(TipEvent.class, this.o);
            wt6.a(getIntent(), getPageContext(), 25050);
            this.k = new GuidePopupWindow(this);
            registerListener(this.r);
            registerListener(this.p);
            this.q.setPriority(10);
            registerResponsedEventListener(GoodsEvent.class, this.q);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && fx5.r()) {
                jp7 jp7Var2 = this.a;
                if (jp7Var2 != null && jp7Var2.Z() != null) {
                    str = this.a.Z().d0();
                } else {
                    str = "";
                }
                ux7.m().J(this, ay7.e().d("frs_feed"), ux7.b("frs", "1"), str, fx5.f());
            }
            if (this.a != null) {
                u95.c(this.a.X() + "_onCreate_" + System.currentTimeMillis());
                h29 activityLog = ActivityLog.getInstance();
                activityLog.c("FRS", "onCreate:" + this.a.X());
            }
            bh5.b(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDestroy();
            D1();
            if (this.a != null) {
                h29 activityLog = ActivityLog.getInstance();
                activityLog.c("FRS", "onDestroy:" + this.a.X());
                if (this.a.g0() != null && this.a.g0().getForum() != null && !TextUtils.isEmpty(this.a.g0().getForum().getId())) {
                    FrsVideoTabPlayActivityConfig.removeVideoTabListByFid(this.a.g0().getForum().getId());
                    FrsVideoTabPlayActivityConfig.subtractFrsPageCount(this.a.g0().getForum().getId());
                }
                this.a.w0();
            }
            ph7.f().m();
            oh7.h().n();
            oh7.h().c();
            qh7.c().a();
            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                TbadkCoreApplication.getInst().setTaskId("");
            }
            FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
            if (frsNetModel != null) {
                frsNetModel.x0(null);
            }
            TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            c76.k().e();
            v76.i().c();
            aj7 aj7Var = this.b;
            if (aj7Var != null) {
                aj7Var.b();
            }
        }
    }
}
