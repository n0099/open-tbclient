package com.baidu.tieba.forum;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ci7;
import com.baidu.tieba.fi7;
import com.baidu.tieba.forum.controller.ForumActivityControllerMapKt;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.fp5;
import com.baidu.tieba.h25;
import com.baidu.tieba.i25;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.m4b;
import com.baidu.tieba.m75;
import com.baidu.tieba.ve7;
import com.baidu.tieba.wh7;
import com.baidu.tieba.xh7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0005¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J'\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\"\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u000eH\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020!H\u0014J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\u000eH\u0014J\u001a\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020!2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u000eH\u0014J\b\u00105\u001a\u00020\u000eH\u0014J\b\u00106\u001a\u000200H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/baidu/tieba/forum/ForumActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "Lcom/baidu/tieba/forum/controller/IGetActivityController;", "Lcom/baidu/tbadk/core/util/videoPreload/IVideoNeedPreload;", "Lcom/baidu/tbadk/core/dialog/yun/strategy/IForumDialogExtSupoort;", "Lcom/baidu/tbadk/core/voice/VoiceManager$IVoiceActivityDefault;", "Lcom/baidu/tbadk/core/voice/VoiceManager$IMediaPlayerVoiceActivity;", "Lcom/baidu/tieba/tracker/interfaces/ITraceable;", "()V", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "controllerManager", "Lcom/baidu/tieba/forum/controller/ActivityControllerManager;", "finish", "", "getActivityController", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/tieba/forum/controller/BaseActivityController;", Bundle.EXTRA_KEY_CLAZZ, "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/baidu/tieba/forum/controller/BaseActivityController;", "getCurrentPageKey", "", "getDialogExtSupoort", "Lcom/baidu/tbadk/core/dialog/yun/strategy/IForumDialogExt;", "getMediaPlayerVoiceManager", "Lcom/baidu/tbadk/core/voice/VoiceManager;", "getTraceId", "getTraceScene", "getTraceSource", "getVoiceManager", "onActivityResult", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", MissionEvent.MESSAGE_PAUSE, "onResume", "videoNeedPreload", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ForumActivity extends BaseFragmentActivity implements fi7, IVideoNeedPreload, i25, VoiceManager.k, VoiceManager.i, m4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ActivityForumBinding a;
    public final wh7 b;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public /* synthetic */ VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        return m75.a(this, voiceModel);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a006" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m4b
    public String l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "frs_landing_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m4b
    public String z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "frs" : (String) invokeV.objValue;
    }

    public ForumActivity() {
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
        new LinkedHashMap();
        this.b = new wh7(ForumActivityControllerMapKt.a().invoke(this));
        new ve7();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            this.b.h();
            fp5.a.a(getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "new_frs_page"), new Pair<>("error_info", "new frs page unfinished destroy"));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ci7.n(this).p();
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ci7.n(this).p();
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.finish();
            this.b.a();
        }
    }

    @Override // com.baidu.tieba.m4b
    public String getTraceId() {
        InterceptResult invokeV;
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdUniqueId a = ci7.a(this);
            if (a == null || (obj = a.toString()) == null) {
                return BdUniqueId.gen().toString();
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i25
    public h25 i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ci7.f(this);
        }
        return (h25) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.b.d()) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            this.b.i();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            this.b.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Fragment A = ci7.m(this).A();
            if (A instanceof IVideoNeedPreload) {
                return ((IVideoNeedPreload) A).videoNeedPreload();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fi7
    public <T extends xh7> T j2(KClass<T> clazz) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, clazz)) == null) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (T) this.b.b(clazz);
        }
        return (T) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.b.e(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            this.b.f(newConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                this.b.c(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            ActivityForumBinding c = ActivityForumBinding.c(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(c, "inflate(layoutInflater)");
            this.a = c;
            Boolean bool = null;
            if (c == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                c = null;
            }
            setContentView(c.getRoot());
            wh7 wh7Var = this.b;
            ActivityForumBinding activityForumBinding = this.a;
            if (activityForumBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityForumBinding = null;
            }
            wh7Var.g(bundle, activityForumBinding);
            Intent intent = getIntent();
            if (intent != null) {
                bool = Boolean.valueOf(intent.getBooleanExtra("key_no_animation", false));
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
            fp5.a aVar = fp5.a;
            BdUniqueId uniqueId = getUniqueId();
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            aVar.e(uniqueId, this);
            fp5.a.g(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, keyEvent)) == null) {
            boolean z = false;
            if (keyEvent != null && keyEvent.getAction() == 0) {
                z = true;
            }
            if (z && keyEvent.getKeyCode() == 24) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
