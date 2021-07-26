package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.g1.c.j;
import d.a.q0.g1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callFrom;
    public CustomMessageListener changeTabListener;
    public d.a.q0.g1.b.b hotTopicShareModel;
    public boolean isTabListLoaded;
    public String listType;
    public List<j> mHotTopicRanklistDataList;
    public List<p> mTopicTabList;
    public long pageStayTime;
    public d.a.q0.g1.f.b ranklistMainView;
    public HotRanklistModel ranklistModel;

    /* loaded from: classes4.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRanklistActivity f17121e;

        public a(HotRanklistActivity hotRanklistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotRanklistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17121e = hotRanklistActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f17121e.ranklistModel != null) {
                j jVar = (j) this.f17121e.mHotTopicRanklistDataList.get(this.f17121e.ranklistMainView.h());
                if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                    this.f17121e.ranklistMainView.k();
                    this.f17121e.ranklistMainView.x();
                    this.f17121e.loadHotTopicRanklistData();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotRanklistActivity f17122a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HotRanklistActivity hotRanklistActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotRanklistActivity, Integer.valueOf(i2)};
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
            this.f17122a = hotRanklistActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof p) {
                int j = this.f17122a.ranklistMainView.j((p) data);
                if (j >= 0) {
                    this.f17122a.ranklistMainView.s(j);
                }
            }
        }
    }

    public HotRanklistActivity() {
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
        this.callFrom = "";
        this.listType = "";
        this.pageStayTime = System.currentTimeMillis();
        this.isTabListLoaded = false;
        this.changeTabListener = new b(this, 2001433);
    }

    private void destoryListeners() {
        d.a.q0.g1.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (bVar = this.ranklistMainView) == null) {
            return;
        }
        bVar.r();
    }

    private void firstTimeLoadNetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            showLoadingView(this.ranklistMainView.i(), true);
            if (!d.a.d.e.p.j.A()) {
                hideLoadingView(this.ranklistMainView.i());
                showNetRefreshView(this.ranklistMainView.i(), getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
                setNetRefreshViewEmotionMarginTop(l.g(getActivity(), R.dimen.ds350));
                this.ranklistMainView.t(0);
                this.ranklistMainView.w(8);
                this.ranklistMainView.v(8);
                return;
            }
            this.ranklistMainView.t(8);
            this.ranklistMainView.w(0);
            this.ranklistMainView.v(0);
            loadHotTopicRanklistData();
        }
    }

    private void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            registerListener(this.changeTabListener);
            this.ranklistMainView.u(new a(this));
        }
    }

    private void initParamsFromIntent(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.callFrom = intent.getStringExtra(IntentConfig.CALL_FROM);
                this.listType = intent.getStringExtra(IntentConfig.LIST_TYPE);
            } else if (bundle != null) {
                this.callFrom = bundle.getString(IntentConfig.CALL_FROM);
                this.listType = bundle.getString(IntentConfig.LIST_TYPE);
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.ranklistMainView = new d.a.q0.g1.f.b(this);
            this.hotTopicShareModel = new d.a.q0.g1.b.b(this);
            HotRanklistModel hotRanklistModel = new HotRanklistModel(getPageContext());
            this.ranklistModel = hotRanklistModel;
            hotRanklistModel.B(this);
        }
    }

    private void sendPauseMessageForVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a014" : (String) invokeV.objValue;
    }

    public void loadHotTopicRanklistData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!d.a.d.e.p.j.z()) {
                this.ranklistMainView.q();
            } else if (this.ranklistModel != null) {
                String str = this.isTabListLoaded ? "0" : "1";
                if (!ListUtils.isEmpty(this.mTopicTabList)) {
                    this.listType = this.mTopicTabList.get(this.ranklistMainView.h()).f56999f;
                }
                this.ranklistModel.y(this.callFrom, this.listType, str, 0L);
            }
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.b
    public void loadNetDataCallback(boolean z, j jVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), jVar, Integer.valueOf(i2), str}) == null) {
            this.ranklistMainView.q();
            hideLoadingView(this.ranklistMainView.i());
            if (!z && !StringUtils.isNull(str)) {
                showToast(str);
            }
            if (this.ranklistMainView == null) {
                return;
            }
            if (!ListUtils.isEmpty(jVar.f56974b) && !this.isTabListLoaded) {
                this.mTopicTabList = jVar.f56974b;
                this.mHotTopicRanklistDataList = new ArrayList();
                for (p pVar : jVar.f56974b) {
                    j jVar2 = new j();
                    jVar2.f56973a = pVar.f56999f;
                    this.mHotTopicRanklistDataList.add(jVar2);
                }
            }
            int i3 = -1;
            if (ListUtils.isEmpty(this.mHotTopicRanklistDataList)) {
                this.mHotTopicRanklistDataList = new ArrayList();
            } else if (jVar != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= this.mHotTopicRanklistDataList.size()) {
                        break;
                    } else if (this.mHotTopicRanklistDataList.get(i4).f56973a.equals(jVar.f56973a)) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 == 0) {
                    jVar.f56974b = this.mTopicTabList;
                } else if (ListUtils.isEmpty(this.mHotTopicRanklistDataList.get(0).f56974b)) {
                    this.mHotTopicRanklistDataList.get(0).f56974b = this.mTopicTabList;
                }
                this.mHotTopicRanklistDataList.add(i3, jVar);
                this.mHotTopicRanklistDataList.remove(i3 + 1);
            }
            this.ranklistMainView.n(this.mHotTopicRanklistDataList);
            if (this.isTabListLoaded || ListUtils.isEmpty(this.mHotTopicRanklistDataList) || ListUtils.isEmpty(this.mHotTopicRanklistDataList.get(0).f56974b) || ListUtils.isEmpty(this.mTopicTabList)) {
                return;
            }
            this.isTabListLoaded = true;
            this.ranklistMainView.z();
            if (i3 >= 0) {
                this.ranklistMainView.s(i3);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.ranklistMainView.o(i2);
            changeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            initParamsFromIntent(bundle);
            initUI();
            initListeners();
            firstTimeLoadNetData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004014));
            destoryListeners();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (i2 == 4 && this.ranklistMainView.p()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && d.a.d.e.p.j.A()) {
            hideNetRefreshView(this.ranklistMainView.i());
            firstTimeLoadNetData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            sendPauseMessageForVideo();
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (StringUtils.isNull(this.callFrom) && StringUtils.isNull(this.listType)) {
                return;
            }
            bundle.putString(IntentConfig.CALL_FROM, this.callFrom);
            bundle.putString(IntentConfig.LIST_TYPE, this.listType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            long currentTimeMillis = System.currentTimeMillis() - this.pageStayTime;
            StatisticItem statisticItem = new StatisticItem("c10818");
            TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, "" + currentTimeMillis));
        }
    }

    public void shareTopic() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || ListUtils.isEmpty(this.mTopicTabList) || (pVar = this.mTopicTabList.get(this.ranklistMainView.h())) == null) {
            return;
        }
        this.hotTopicShareModel.e(null, pVar.f57001h, pVar.j, pVar.f57000g, pVar.f57002i, false);
    }
}
