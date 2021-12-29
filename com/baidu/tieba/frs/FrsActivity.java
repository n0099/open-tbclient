package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import c.a.d.f.p.m;
import c.a.s0.e1.u0;
import c.a.s0.k0.i;
import c.a.s0.q0.e;
import c.a.t0.d1.f1;
import c.a.t0.d1.m0;
import c.a.t0.d1.x2.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes12.dex */
public class FrsActivity extends BaseFragmentActivity implements c.a.t0.h.e.b, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload, m0, c.a.s0.s.c0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean doRefresh;
    public GuidePopupWindow frsGuidePopupView;
    public boolean isNeedTransition;
    public ItemInfo mCommentTabItemInfo;
    public c.a.d.f.k.b<TbImageView> mFrsCommonImagePool;
    public CustomMessageListener mGuideWindowListener;
    public boolean mIsFromSchema;
    public long mSpecialTabPageStayTime;
    public i mSwanappReturnProductDateListener;
    public FrsTabController mTabController;
    public i mTipsEventListener;
    public f mTransitionController;
    public c.a.d.f.k.b<TbImageView> mUserIconPool;
    public WeakReference<Context> mWeakContext;

    /* loaded from: classes12.dex */
    public class a extends i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsActivity f44675g;

        public a(FrsActivity frsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44675g = frsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.k0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.f44675g.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.makeText(this.f44675g.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b extends i<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsActivity f44676g;

        public b(FrsActivity frsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44676g = frsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.k0.b
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null || this.f44676g.mTabController.P() == null) {
                    return false;
                }
                if (goodsEvent.getDispose()) {
                    return true;
                }
                if (WriteActivityConfig.isAsyncWriting()) {
                    return false;
                }
                WriteActivityConfig.newInstance(this.f44676g).setType(9).setForumWriteData(this.f44676g.mTabController.P().getForumWriteData()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
                goodsEvent.setDispost(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsActivity frsActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsActivity, Integer.valueOf(i2)};
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

    /* loaded from: classes12.dex */
    public class d extends c.a.s0.q0.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsActivity;
        }

        @Override // c.a.s0.q0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? e.b().c() : invokeV.intValue;
        }

        @Override // c.a.s0.q0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsFromSchema = false;
        this.doRefresh = true;
        this.mTipsEventListener = new a(this);
        this.mSwanappReturnProductDateListener = new b(this);
        this.mGuideWindowListener = new c(this, 2921476);
    }

    private boolean isShowGuidePopup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (TbadkCoreApplication.isLogin() && !c.a.s0.s.g0.b.j().g("has_guide_popup_window_been_shown", false)) {
                FrsTabController frsTabController = this.mTabController;
                return frsTabController == null || frsTabController.U() == null || this.mTabController.U().getUserData() == null || this.mTabController.U().getUserData().getIs_manager() == 1;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void removeSpecTopicIcon() {
        FrsTabController frsTabController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (frsTabController = this.mTabController) == null || frsTabController.U() == null || this.mTabController.U().getForum() == null) {
            return;
        }
        SpecHotTopicHelper.removeSpecTopicIconForFrs(Long.valueOf(c.a.d.f.m.b.g(this.mTabController.U().getForum().getId(), 0L)));
    }

    private void setWindowData() {
        FrsTabController frsTabController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.frsGuidePopupView == null || (frsTabController = this.mTabController) == null || frsTabController.U() == null || this.mTabController.U().getForum() == null) {
            return;
        }
        ForumData forum = this.mTabController.U().getForum();
        this.frsGuidePopupView.setUserNickName();
        this.frsGuidePopupView.setUserLeavel(String.valueOf(this.mTabController.U().getUserData().getLevel_id()));
        this.frsGuidePopupView.setUserHeadImg(this.mTabController.U().getUserData());
        this.frsGuidePopupView.setBaName(forum.getName());
        this.frsGuidePopupView.setNumber(forum.getMember_num(), forum.getThread_num());
        this.frsGuidePopupView.setForumId(Integer.parseInt(forum.getId()));
        this.frsGuidePopupView.setmForumName(forum.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideWindow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && isShowGuidePopup()) {
            c.a.s0.s.g0.b.j().t("has_guide_popup_window_been_shown", true);
            setWindowData();
            g.i(this.frsGuidePopupView, this);
        }
    }

    @Override // c.a.t0.h.e.b
    public void dispatchInjectPluginMessage(c.a.t0.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController instanceof c.a.t0.h.e.b) {
                frsTabController.dispatchInjectPluginMessage(dVar);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public c.a.d.f.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mFrsCommonImagePool == null) {
                this.mFrsCommonImagePool = FrsCommonImageLayout.createFrsCommonIamgeLayoutPool(getPageContext().getPageActivity(), 12);
            }
            return this.mFrsCommonImagePool;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public FrsFragment getFrsFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController == null) {
                return null;
            }
            return frsTabController.P();
        }
        return (FrsFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // c.a.t0.h.e.b
    public c.a.t0.h.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController instanceof c.a.t0.h.e.b) {
                return frsTabController.getInjectPlugin(i2);
            }
            return null;
        }
        return (c.a.t0.h.e.a) invokeI.objValue;
    }

    @Override // c.a.t0.d1.m0
    public ItemInfo getItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mCommentTabItemInfo : (ItemInfo) invokeV.objValue;
    }

    @Override // c.a.s0.s.c0.a
    public String getLatestRelatedFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController == null || frsTabController.U() == null || this.mTabController.U().getForum() == null) {
                return null;
            }
            return this.mTabController.U().getForum().getId();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.s.c0.a
    public String getLatestRelatedTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public View getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, c.a.s0.q0.a
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
            if (nextPageSourceKeyList == null) {
                nextPageSourceKeyList = new ArrayList<>();
            }
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null && frsTabController.b0() && this.mTabController.Q() != null && (this.mTabController.Q().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.mTabController.Q().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.mTabController.Q().getCurrentFragment()).isPrimary()) {
                nextPageSourceKeyList.add(((BaseFragment) this.mTabController.Q().getCurrentFragment()).getCurrentPageKey());
            } else {
                nextPageSourceKeyList.add(getCurrentPageKey());
            }
            return nextPageSourceKeyList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public c.a.s0.q0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.s0.q0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                FrsTabController frsTabController = this.mTabController;
                if (frsTabController != null && frsTabController.P() != null) {
                    pageStayDurationItem.t(c.a.d.f.m.b.g(this.mTabController.P().forumId, 0L));
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().q);
                }
            }
            return pageStayDurationItem;
        }
        return (c.a.s0.q0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, c.a.s0.q0.a
    public c.a.s0.q0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new d(this) : (c.a.s0.q0.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            TbPageTag T = frsTabController != null ? frsTabController.T() : null;
            return T == null ? super.getTbPageTag() : T;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.d.f.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.mUserIconPool == null) {
                this.mUserIconPool = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.mUserIconPool;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                return frsTabController.getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            super.hideLoadingView(view);
            updateLoadingViewState(view, false);
        }
    }

    public void hideTransition() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (fVar = this.mTransitionController) == null) {
            return;
        }
        fVar.h();
    }

    @Override // c.a.t0.d1.m0
    public boolean isInScoreTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            return (frsTabController == null || frsTabController.P() == null || this.mTabController.P().getTabController() == null || this.mTabController.P().getTabController().A() == null || this.mTabController.P().getTabController().A().f45399d != 16) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.g0(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        FrsTabController frsTabController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || (frsTabController = this.mTabController) == null) {
            return;
        }
        frsTabController.h0(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                BdUniqueId bdUniqueId2 = (BdUniqueId) intent.getSerializableExtra(FrsActivityConfig.FRS_PAGE_ID);
                if (bdUniqueId2 != null) {
                    setUniqueId(bdUniqueId2);
                }
                if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !c.a.d.a.b.g().i("MainTabActivity")) {
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
            if (f.i(intent)) {
                this.isNeedTransition = true;
                enterExitAnimation();
                if (this.mTransitionController == null) {
                    this.mTransitionController = new f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
                }
                this.mTransitionController.l();
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
            c.a.t0.k0.a.a(getIntent(), getPageContext(), 25050);
            this.frsGuidePopupView = new GuidePopupWindow(this);
            registerListener(this.mGuideWindowListener);
            this.mSwanappReturnProductDateListener.setPriority(10);
            registerResponsedEventListener(GoodsEvent.class, this.mSwanappReturnProductDateListener);
            if (c.a.s0.b.d.r()) {
                FrsTabController frsTabController2 = this.mTabController;
                c.a.t0.e1.a.i().C(this, c.a.t0.e1.e.c.e().d("frs_feed"), c.a.t0.e1.a.b("frs", "1"), (frsTabController2 == null || frsTabController2.P() == null) ? "" : this.mTabController.P().getFid());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDestroy();
            removeSpecTopicIcon();
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                if (frsTabController.U() != null && this.mTabController.U().getForum() != null && !TextUtils.isEmpty(this.mTabController.U().getForum().getId())) {
                    FrsVideoTabPlayActivityConfig.removeVideoTabListByFid(this.mTabController.U().getForum().getId());
                    FrsVideoTabPlayActivityConfig.subtractFrsPageCount(this.mTabController.U().getForum().getId());
                }
                this.mTabController.i0();
            }
            c.a.t0.d1.b.f().m();
            c.a.t0.d1.a.h().n();
            c.a.t0.d1.a.h().c();
            c.a.t0.d1.c.c().a();
            if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                TbadkCoreApplication.getInst().setTaskId("");
            }
            FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
            if (frsNetModel != null) {
                frsNetModel.Y(null);
            }
            TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
            TbPageExtraHelper.v(getCurrentPageKey());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, keyEvent)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                return frsTabController.j0(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, intent) == null) {
            super.onNewIntent(intent);
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.k0(intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        c.a.s0.q0.d pageStayDurationItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            this.lastResumeTime = 0L;
            super.onPause();
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.l0();
            }
            long j2 = this.mSpecialTabPageStayTime;
            if (j2 >= 0) {
                long j3 = currentTimeMillis - j2;
                if (j3 >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                    pageStayDurationItem.y(j3);
                    e.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                }
            }
            TbSingleton.getInstance().isInFrs = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048606, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            getFrsFragment().onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onResume();
            if (this.doRefresh) {
                u0.g(this.mWeakContext);
                this.doRefresh = false;
            }
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.m0();
            }
            TbSingleton.getInstance().isInFrs = true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.n0(bundle);
            }
            bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            super.onScreenShot(str);
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null) {
                frsTabController.o0(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onStop();
            this.doRefresh = true;
        }
    }

    public boolean onSuperKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048611, this, i2, keyEvent)) == null) ? super.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // c.a.t0.h.e.b
    public void setInjectPlugin(int i2, c.a.t0.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048612, this, i2, aVar) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController instanceof c.a.t0.h.e.b) {
                frsTabController.setInjectPlugin(i2, aVar);
            }
        }
    }

    @Override // c.a.t0.d1.m0
    public void setItemInfo(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, itemInfo) == null) {
            this.mCommentTabItemInfo = itemInfo;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            super.showLoadingView(view, z, i2);
            updateLoadingViewState(view, true);
        }
    }

    public void showTabHost(boolean z) {
        FrsTabController frsTabController;
        FragmentTabHost Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || (frsTabController = this.mTabController) == null || (Q = frsTabController.Q()) == null || Q.getFragmentTabWidget() == null) {
            return;
        }
        if (z) {
            Q.changeStyle(2);
        } else {
            Q.changeStyle(4);
        }
    }

    public void updateLoadingViewState(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048616, this, view, z) == null) {
            if (view.getId() == f1.frs) {
                TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
            } else if (view.getId() == 16908290) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController == null || frsTabController.P() == null) {
                return false;
            }
            return this.mTabController.P().videoNeedPreload();
        }
        return invokeV.booleanValue;
    }
}
