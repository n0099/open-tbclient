package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.s0.q1.c;
import c.a.s0.q1.h;
import c.a.s0.q1.l.j;
import c.a.s0.q1.l.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class HotRanklistActivity extends BaseActivity<HotRanklistActivity> implements HotRanklistModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callFrom;
    public CustomMessageListener changeTabListener;
    public c.a.s0.q1.k.b hotTopicShareModel;
    public boolean isTabListLoaded;
    public String listType;
    public List<j> mHotTopicRanklistDataList;
    public List<p> mTopicTabList;
    public long pageStayTime;
    public c.a.s0.q1.o.b ranklistMainView;
    public HotRanklistModel ranklistModel;

    /* loaded from: classes12.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotRanklistActivity f46132e;

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
            this.f46132e = hotRanklistActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.f46132e.ranklistModel != null) {
                j jVar = (j) this.f46132e.mHotTopicRanklistDataList.get(this.f46132e.ranklistMainView.h());
                if (jVar == null || ListUtils.isEmpty(jVar.b())) {
                    this.f46132e.ranklistMainView.k();
                    this.f46132e.ranklistMainView.x();
                    this.f46132e.loadHotTopicRanklistData();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotRanklistActivity a;

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
            this.a = hotRanklistActivity;
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
                int j2 = this.a.ranklistMainView.j((p) data);
                if (j2 >= 0) {
                    this.a.ranklistMainView.s(j2);
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
        c.a.s0.q1.o.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (bVar = this.ranklistMainView) == null) {
            return;
        }
        bVar.r();
    }

    private void firstTimeLoadNetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            showLoadingView(this.ranklistMainView.i(), true);
            if (!k.A()) {
                hideLoadingView(this.ranklistMainView.i());
                showNetRefreshView(this.ranklistMainView.i(), getResources().getString(h.refresh_view_title_text), null, getResources().getString(h.refresh_view_button_text), true, getNetRefreshListener());
                setNetRefreshViewEmotionMarginTop(m.f(getActivity(), c.ds350));
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
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
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
            this.ranklistMainView = new c.a.s0.q1.o.b(this);
            this.hotTopicShareModel = new c.a.s0.q1.k.b(this);
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

    @Override // com.baidu.tbadk.BaseActivity, c.a.r0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a014" : (String) invokeV.objValue;
    }

    public void loadHotTopicRanklistData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!k.z()) {
                this.ranklistMainView.q();
            } else if (this.ranklistModel != null) {
                String str = this.isTabListLoaded ? "0" : "1";
                if (!ListUtils.isEmpty(this.mTopicTabList)) {
                    this.listType = this.mTopicTabList.get(this.ranklistMainView.h()).f21679f;
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
            if (!ListUtils.isEmpty(jVar.f21651b) && !this.isTabListLoaded) {
                this.mTopicTabList = jVar.f21651b;
                this.mHotTopicRanklistDataList = new ArrayList();
                for (p pVar : jVar.f21651b) {
                    j jVar2 = new j();
                    jVar2.a = pVar.f21679f;
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
                    } else if (this.mHotTopicRanklistDataList.get(i4).a.equals(jVar.a)) {
                        i3 = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i3 == 0) {
                    jVar.f21651b = this.mTopicTabList;
                } else if (ListUtils.isEmpty(this.mHotTopicRanklistDataList.get(0).f21651b)) {
                    this.mHotTopicRanklistDataList.get(0).f21651b = this.mTopicTabList;
                }
                this.mHotTopicRanklistDataList.add(i3, jVar);
                this.mHotTopicRanklistDataList.remove(i3 + 1);
            }
            this.ranklistMainView.n(this.mHotTopicRanklistDataList);
            if (this.isTabListLoaded || ListUtils.isEmpty(this.mHotTopicRanklistDataList) || ListUtils.isEmpty(this.mHotTopicRanklistDataList.get(0).f21651b) || ListUtils.isEmpty(this.mTopicTabList)) {
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
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && k.A()) {
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
        c.a.s0.q1.k.b bVar = this.hotTopicShareModel;
        String str = pVar.f21681h;
        String str2 = pVar.f21683j;
        String str3 = pVar.f21680g;
        bVar.f(null, str, str2, str3, pVar.f21682i, str3, false, 0L);
    }
}
