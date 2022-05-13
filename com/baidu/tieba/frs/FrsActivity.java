package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bg;
import com.repackage.de5;
import com.repackage.er6;
import com.repackage.f65;
import com.repackage.fc6;
import com.repackage.gc6;
import com.repackage.hc6;
import com.repackage.hz4;
import com.repackage.iu4;
import com.repackage.iz5;
import com.repackage.kg;
import com.repackage.kr6;
import com.repackage.lc5;
import com.repackage.li;
import com.repackage.n85;
import com.repackage.oh0;
import com.repackage.p85;
import com.repackage.pg;
import com.repackage.ph0;
import com.repackage.q85;
import com.repackage.rd6;
import com.repackage.x8;
import com.repackage.xh5;
import com.repackage.yh5;
import com.repackage.yo6;
import com.repackage.yt4;
import com.repackage.zh5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes3.dex */
public class FrsActivity extends BaseFragmentActivity implements zh5, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload, rd6, yt4, oh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean doRefresh;
    public GuidePopupWindow frsGuidePopupView;
    public boolean isNeedTransition;
    public ItemInfo mCommentTabItemInfo;
    public bg<TbImageView> mFrsCommonImagePool;
    public CustomMessageListener mGuideWindowListener;
    public boolean mIsFromSchema;
    public long mSpecialTabPageStayTime;
    public f65 mSwanappReturnProductDateListener;
    public FrsTabController mTabController;
    public f65 mTipsEventListener;
    public yo6 mTransitionController;
    public bg<TbImageView> mUserIconPool;
    public WeakReference<Context> mWeakContext;
    public final ph0 touchInfoCollector;

    /* loaded from: classes3.dex */
    public class a extends f65<TipEvent> {
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
        @Override // com.repackage.y55
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.c.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.s(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends f65<GoodsEvent> {
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
        @Override // com.repackage.y55
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null || this.c.mTabController.Q() == null) {
                    return false;
                }
                if (goodsEvent.getDispose()) {
                    return true;
                }
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.c).setType(9).setForumWriteData(this.c.mTabController.Q().w2()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
                goodsEvent.setDispost(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.showGuideWindow();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends n85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity b;

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
            this.b = frsActivity;
        }

        @Override // com.repackage.n85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? q85.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.n85
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
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
        this.mIsFromSchema = false;
        this.doRefresh = true;
        this.touchInfoCollector = new ph0();
        this.mTipsEventListener = new a(this);
        this.mSwanappReturnProductDateListener = new b(this);
        this.mGuideWindowListener = new c(this, 2921476);
    }

    private boolean isShowGuidePopup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA() || !TbadkCoreApplication.isLogin() || iu4.k().h("has_guide_popup_window_been_shown", false)) {
                return false;
            }
            FrsTabController frsTabController = this.mTabController;
            return frsTabController == null || frsTabController.V() == null || this.mTabController.V().getUserData() == null || this.mTabController.V().getUserData().getIs_manager() == 1;
        }
        return invokeV.booleanValue;
    }

    private void removeSpecTopicIcon() {
        FrsTabController frsTabController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (frsTabController = this.mTabController) == null || frsTabController.V() == null || this.mTabController.V().getForum() == null) {
            return;
        }
        SpecHotTopicHelper.removeSpecTopicIconForFrs(Long.valueOf(kg.g(this.mTabController.V().getForum().getId(), 0L)));
    }

    private void setWindowData() {
        FrsTabController frsTabController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.frsGuidePopupView == null || (frsTabController = this.mTabController) == null || frsTabController.V() == null || this.mTabController.V().getForum() == null) {
            return;
        }
        ForumData forum = this.mTabController.V().getForum();
        this.frsGuidePopupView.t();
        this.frsGuidePopupView.s(String.valueOf(this.mTabController.V().getUserData().getLevel_id()));
        this.frsGuidePopupView.r(this.mTabController.V().getUserData());
        this.frsGuidePopupView.k(forum.getName());
        this.frsGuidePopupView.p(forum.getMember_num(), forum.getThread_num());
        this.frsGuidePopupView.o(Integer.parseInt(forum.getId()));
        this.frsGuidePopupView.u(forum.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideWindow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && isShowGuidePopup()) {
            iu4.k().u("has_guide_popup_window_been_shown", true);
            setWindowData();
            pg.i(this.frsGuidePopupView, this);
        }
    }

    @Override // com.repackage.zh5
    public void dispatchInjectPluginMessage(xh5 xh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xh5Var) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController instanceof zh5) {
                frsTabController.dispatchInjectPluginMessage(xh5Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            this.touchInfoCollector.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.isNeedTransition && !this.mIsFromSchema) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.m85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public bg<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mFrsCommonImagePool == null) {
                this.mFrsCommonImagePool = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.mFrsCommonImagePool;
        }
        return (bg) invokeV.objValue;
    }

    public FrsFragment getFrsFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController == null) {
                return null;
            }
            return frsTabController.Q();
        }
        return (FrsFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.repackage.zh5
    public yh5 getInjectPlugin(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController instanceof zh5) {
                return frsTabController.getInjectPlugin(i);
            }
            return null;
        }
        return (yh5) invokeI.objValue;
    }

    @Override // com.repackage.rd6
    public ItemInfo getItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mCommentTabItemInfo : (ItemInfo) invokeV.objValue;
    }

    @Override // com.repackage.yt4
    public String getLatestRelatedFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController == null || frsTabController.V() == null || this.mTabController.V().getForum() == null) {
                return null;
            }
            return this.mTabController.V().getForum().getId();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.yt4
    public String getLatestRelatedTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public View getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.m85
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
            if (nextPageSourceKeyList == null) {
                nextPageSourceKeyList = new ArrayList<>();
            }
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null && frsTabController.b0() && this.mTabController.R() != null && (this.mTabController.R().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.mTabController.R().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.mTabController.R().getCurrentFragment()).isPrimary()) {
                nextPageSourceKeyList.add(((BaseFragment) this.mTabController.R().getCurrentFragment()).getCurrentPageKey());
            } else {
                nextPageSourceKeyList.add(getCurrentPageKey());
            }
            return nextPageSourceKeyList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public p85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            p85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                FrsTabController frsTabController = this.mTabController;
                if (frsTabController != null && frsTabController.Q() != null) {
                    pageStayDurationItem.t(kg.g(this.mTabController.Q().l, 0L));
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (p85) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.m85
    public n85 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new d(this) : (n85) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            TbPageTag U = frsTabController != null ? frsTabController.U() : null;
            return U == null ? super.getTbPageTag() : U;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.repackage.oh0
    @NonNull
    public ph0 getTouchInfoCollector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.touchInfoCollector : (ph0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public bg<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mUserIconPool == null) {
                this.mUserIconPool = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.mUserIconPool;
        }
        return (bg) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                return frsTabController.getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            super.hideLoadingView(view2);
            updateLoadingViewState(view2, false);
        }
    }

    public void hideTransition() {
        yo6 yo6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (yo6Var = this.mTransitionController) == null) {
            return;
        }
        yo6Var.h();
    }

    @Override // com.repackage.rd6
    public boolean isInScoreTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            return (frsTabController == null || frsTabController.Q() == null || this.mTabController.Q().L2() == null || this.mTabController.Q().L2().A() == null || this.mTabController.Q().L2().A().d != 16) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048601, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.h0(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        FrsTabController frsTabController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || (frsTabController = this.mTabController) == null) {
            return;
        }
        frsTabController.i0(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                BdUniqueId bdUniqueId2 = (BdUniqueId) intent.getSerializableExtra(FrsActivityConfig.FRS_PAGE_ID);
                if (bdUniqueId2 != null) {
                    setUniqueId(bdUniqueId2);
                }
                if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !x8.g().i("MainTabActivity")) {
                    this.mIsFromSchema = true;
                }
            } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
                setUniqueId(bdUniqueId);
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            FrsTabController frsTabController = new FrsTabController(this);
            this.mTabController = frsTabController;
            frsTabController.X(bundle);
            if (yo6.i(intent)) {
                this.isNeedTransition = true;
                enterExitAnimation();
                if (this.mTransitionController == null) {
                    yo6 yo6Var = new yo6(this, (ViewGroup) getWindow().getDecorView(), getIntent());
                    this.mTransitionController = yo6Var;
                    yo6Var.l();
                }
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
            iz5.a(getIntent(), getPageContext(), 25050);
            this.frsGuidePopupView = new GuidePopupWindow(this);
            registerListener(this.mGuideWindowListener);
            this.mSwanappReturnProductDateListener.setPriority(10);
            registerResponsedEventListener(GoodsEvent.class, this.mSwanappReturnProductDateListener);
            if (UbsABTestHelper.isFrsFunAdSdkTest() && lc5.r()) {
                FrsTabController frsTabController2 = this.mTabController;
                er6.j().E(this, kr6.e().d("frs_feed"), er6.b("frs", "1"), (frsTabController2 == null || frsTabController2.Q() == null) ? "" : this.mTabController.Q().y(), lc5.f());
            }
            hz4.b(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDestroy();
            removeSpecTopicIcon();
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                if (frsTabController.V() != null && this.mTabController.V().getForum() != null && !TextUtils.isEmpty(this.mTabController.V().getForum().getId())) {
                    FrsVideoTabPlayActivityConfig.removeVideoTabListByFid(this.mTabController.V().getForum().getId());
                    FrsVideoTabPlayActivityConfig.subtractFrsPageCount(this.mTabController.V().getForum().getId());
                }
                this.mTabController.j0();
            }
            gc6.f().m();
            fc6.h().n();
            fc6.h().c();
            hc6.c().a();
            if (!li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                TbadkCoreApplication.getInst().setTaskId("");
            }
            FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
            if (frsNetModel != null) {
                frsNetModel.a0(null);
            }
            TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            UbsABTestHelper.tryClearFrsModifyABCache();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i, keyEvent)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                return frsTabController.k0(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, intent) == null) {
            super.onNewIntent(intent);
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.l0(intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        p85 pageStayDurationItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            this.lastResumeTime = 0L;
            super.onPause();
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.m0();
            }
            long j = this.mSpecialTabPageStayTime;
            if (j >= 0) {
                long j2 = currentTimeMillis - j;
                if (j2 >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                    pageStayDurationItem.y(j2);
                    q85.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                }
            }
            TbSingleton.getInstance().isInFrs = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048608, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            getFrsFragment().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onResume();
            if (this.doRefresh) {
                de5.g(this.mWeakContext);
                this.doRefresh = false;
            }
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.n0();
            }
            TbSingleton.getInstance().isInFrs = true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.o0(bundle);
            }
            bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            super.onScreenShot(str);
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.p0(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onStop();
            this.doRefresh = true;
        }
    }

    public boolean onSuperKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i, keyEvent)) == null) ? super.onKeyDown(i, keyEvent) : invokeIL.booleanValue;
    }

    @Override // com.repackage.zh5
    public void setInjectPlugin(int i, yh5 yh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048614, this, i, yh5Var) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController instanceof zh5) {
                frsTabController.setInjectPlugin(i, yh5Var);
            }
        }
    }

    @Override // com.repackage.rd6
    public void setItemInfo(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, itemInfo) == null) {
            this.mCommentTabItemInfo = itemInfo;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            super.showLoadingView(view2, z, i);
            updateLoadingViewState(view2, true);
        }
    }

    public void showTabHost(boolean z) {
        FrsTabController frsTabController;
        FragmentTabHost R;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z) == null) || (frsTabController = this.mTabController) == null || (R = frsTabController.R()) == null || R.getFragmentTabWidget() == null) {
            return;
        }
        if (z) {
            R.f(2);
        } else {
            R.f(4);
        }
    }

    public void updateLoadingViewState(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048618, this, view2, z) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090aac) {
                TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
            } else if (view2.getId() == 16908290) {
                TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
            }
            if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
                hideTransition();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController == null || frsTabController.Q() == null) {
                return false;
            }
            return this.mTabController.Q().videoNeedPreload();
        }
        return invokeV.booleanValue;
    }
}
