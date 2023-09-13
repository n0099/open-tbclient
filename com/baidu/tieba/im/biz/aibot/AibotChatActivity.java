package com.baidu.tieba.im.biz.aibot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ax5;
import com.baidu.tieba.im.base.core.SliceActivity;
import com.baidu.tieba.im.biz.aibot.data.AibotArgs;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.oc8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\bH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/AibotChatActivity;", "Lcom/baidu/tieba/im/base/core/SliceActivity;", "()V", "IS_ANIMATION", "", "curBotUk", AiBotChatDispatcher.AI_SINGLE_IS_ANIMATION, "closeAnimation", "", "enterExitAnimation", "initFragment", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "shouldChangeStatusBarIconAndTextColor", "", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotChatActivity extends SliceActivity {
    public static /* synthetic */ Interceptable $ic;
    public static final a e;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public final String c;
    public String d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1738347842, "Lcom/baidu/tieba/im/biz/aibot/AibotChatActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1738347842, "Lcom/baidu/tieba/im/biz/aibot/AibotChatActivity;");
                return;
            }
        }
        e = new a(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        @JvmOverloads
        public final void a(Context context, String paid, String botUk, String str, String str2, String str3, String str4, String str5, String str6, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, paid, botUk, str, str2, str3, str4, str5, str6, Integer.valueOf(i)}) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(paid, "paid");
                Intrinsics.checkNotNullParameter(botUk, "botUk");
                Intent intent = new Intent(context, AibotChatActivity.class);
                intent.putExtra("paid", paid);
                intent.putExtra(AiBotChatDispatcher.AI_SINGLE_IS_ANIMATION, str5);
                intent.putExtra("botUk", botUk);
                intent.putExtra("argsData", new AibotArgs(str, str2, str3, str4, str6, i));
                oc8.a.a("navTo", paid, botUk, str, str2, str3, str4, str5, str6, Integer.valueOf(i));
                context.startActivity(intent);
            }
        }
    }

    public AibotChatActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "1";
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (Intrinsics.areEqual(this.c, this.b)) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 5);
            } else {
                super.closeAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (Intrinsics.areEqual(this.c, this.b)) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 5);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002b);
            setSwipeBackEnabled(false);
            if (bundle == null) {
                s1();
                getWindow().setSoftInputMode(48);
                this.b = getIntent().getStringExtra(AiBotChatDispatcher.AI_SINGLE_IS_ANIMATION);
                enterExitAnimation();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent != null) {
                str = intent.getStringExtra("botUk");
            } else {
                str = null;
            }
            if (str != null && !Intrinsics.areEqual(str, this.d)) {
                setIntent(intent);
                s1();
            }
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AibotChatFragment aibotChatFragment = new AibotChatFragment();
            if (getIntent() != null) {
                this.d = getIntent().getStringExtra("botUk");
                aibotChatFragment.setArguments(getIntent().getExtras());
            }
            ax5.c(getSupportFragmentManager(), R.id.obfuscated_res_0x7f090c3e, aibotChatFragment);
        }
    }
}
