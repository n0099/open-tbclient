package com.baidu.tieba.frs.videomiddlepage;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import b.a.e.f.m.b;
import b.a.e.f.p.k;
import b.a.q0.a.c;
import b.a.q0.o0.d;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class VideoMiddlePageActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoMiddlePageFragment mFragment;
    public String mFrom;
    public String mId;
    public boolean mIsFromSchema;
    public String mNid;

    public VideoMiddlePageActivity() {
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
    }

    private void doEnterStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_ENTER_VIDEO_PAGE);
            if (!StringUtils.isNull(this.mFrom)) {
                statisticItem.param("obj_source", this.mFrom);
            }
            if (TextUtils.isEmpty(this.mNid)) {
                statisticItem.param("obj_type", "1");
            } else {
                statisticItem.param("obj_type", "2");
                statisticItem.param("obj_id", this.mNid);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Intent intent = getIntent();
            this.mId = intent.getStringExtra("PARAM_FID");
            this.mFrom = intent.getStringExtra("PARAM_FROM");
            this.mNid = intent.getStringExtra("key_nid");
            initFragment();
            doEnterStatistic();
        }
    }

    private void initFragment() {
        FragmentManager supportFragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (supportFragmentManager = getSupportFragmentManager()) == null || supportFragmentManager.isDestroyed()) {
            return;
        }
        VideoMiddlePageFragment videoMiddlePageFragment = (VideoMiddlePageFragment) supportFragmentManager.findFragmentByTag(VideoMiddlePageFragment.class.getCanonicalName());
        if (videoMiddlePageFragment == null) {
            videoMiddlePageFragment = VideoMiddlePageFragment.getInstance(this.mFrom, this.mId);
            supportFragmentManager.beginTransaction().add(R.id.video_middle_page_container, videoMiddlePageFragment, VideoMiddlePageFragment.class.getCanonicalName()).commitAllowingStateLoss();
        }
        this.mFragment = videoMiddlePageFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mIsFromSchema) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a023" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (k.isEmpty(this.mId)) {
                return 0L;
            }
            return b.g(this.mId, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && !StringUtils.isNull(this.mFrom)) {
                ArrayList arrayList = new ArrayList();
                if ("index".equals(this.mFrom)) {
                    arrayList.add("a002");
                } else if ("concern_tab".equals(this.mFrom)) {
                    arrayList.add("a038");
                } else if ("frs".equals(this.mFrom)) {
                    arrayList.add("a006");
                } else if ("homepage".equals(this.mFrom)) {
                    arrayList.add("a002");
                }
                pageStayDurationItem.x(arrayList);
                pageStayDurationItem.l = "0";
                pageStayDurationItem.r = TextUtils.isEmpty(this.mNid) ? "0" : "1";
            }
            return pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.locatePage = getCurrentPageKey();
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || UtilHelper.isFlyMeOs()) {
            return;
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 2) {
                setSwipeBackEnabled(false);
            } else {
                setSwipeBackEnabled(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !b.a.e.a.b.g().i("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setContentView(R.layout.activity_video_middle_page_layout);
            init();
            if (Build.VERSION.SDK_INT >= 28) {
                if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                    b.a.r0.y3.d.b(1, getWindow().getAttributes(), getWindow());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        VideoMiddlePageFragment videoMiddlePageFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, keyEvent)) == null) {
            if (keyEvent != null && (videoMiddlePageFragment = this.mFragment) != null) {
                if (videoMiddlePageFragment.onKeyDown(i2)) {
                    return true;
                }
                return super.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            b.a.q0.a.d.y().F();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (k.isEmpty(this.mId)) {
                return;
            }
            b.a.q0.a.d.y().Q(c.a0, b.g(this.mId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
        }
    }
}
