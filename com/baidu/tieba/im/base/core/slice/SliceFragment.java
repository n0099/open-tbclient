package com.baidu.tieba.im.base.core.slice;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tieba.mm8;
import com.baidu.tieba.nm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001DB\u000f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\"\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0013H\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0016J$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0013H\u0016J+\u00106\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u0018082\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001eH\u0016J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u0013H\u0016J\u0011\u0010@\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010C\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0001R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/baidu/tieba/im/base/core/slice/SliceFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/im/base/core/slice/ability/OpAbility;", "Lcom/baidu/tieba/im/base/core/slice/ability/SysEventAbility;", "Lcom/baidu/tieba/im/base/core/slice/ability/LogAbility;", "rootSlice", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "(Lcom/baidu/tieba/im/base/core/slice/Slice;)V", "backGroundListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "lastSkinType", "", "lockScreenListener", "addChild", "", "container", "Landroid/view/ViewGroup;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "contains", "", "hideChild", "isShowing", "logD", LocalFilesFilterKt.FILTER_NAME_LOG, "", "logE", "throwable", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityFinish", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackgroundSwitched", NotificationCompat.WearableExtender.KEY_BACKGROUND, "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardVisibilityChanged", "isVisible", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSaveInstanceState", "outState", "onScreenLocked", "locked", "removeChild", "setTag", "tag", "showChild", "RootSlice", "im-base-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class SliceFragment extends BaseFragment implements nm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Slice a;
    public int b;
    public final CustomMessageListener c;
    public final CustomMessageListener d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SliceFragment() {
        this(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Slice) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void u2(ViewGroup container, Slice child) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, container, child) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(child, "child");
            this.a.I(container, child);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/im/base/core/slice/SliceFragment$RootSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "im-base-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class RootSlice extends Slice {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RootSlice() {
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

        @Override // com.baidu.tieba.im.base.core.slice.Slice
        public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(container, "container");
                c0(container);
                return M();
            }
            return (View) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SliceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SliceFragment sliceFragment) {
            super(2001011);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sliceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sliceFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, response) == null) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getCmd() != 2001011) {
                    return;
                }
                Object data = response.getData();
                if (data instanceof Boolean) {
                    this.a.v2(((Boolean) data).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SliceFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SliceFragment sliceFragment) {
            super(2016523);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sliceFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sliceFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, response) == null) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.getCmd() != 2016523) {
                    return;
                }
                Object data = response.getData();
                if (data instanceof Boolean) {
                    this.a.w2(((Boolean) data).booleanValue());
                }
            }
        }
    }

    public SliceFragment(Slice rootSlice) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rootSlice};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(rootSlice, "rootSlice");
        this.a = rootSlice;
        new mm8(null, 1, null);
        this.b = -1;
        this.c = new b(this);
        this.d = new a(this);
    }

    public /* synthetic */ SliceFragment(Slice slice, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new RootSlice() : slice);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.a.R(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            return new FrameLayout(inflater.getContext());
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, permissions, grantResults) == null) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            super.onRequestPermissionsResult(i, permissions, grantResults);
            this.a.X(i, permissions, grantResults);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a.J(this, null, (ViewGroup) requireView(), bundle);
            registerListener(this.c);
            registerListener(this.d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.b == i) {
            return;
        }
        this.b = i;
        super.onChangeSkinType(i);
        this.a.onChangeSkinType(i);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            this.a.T(newConfig);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.a.W(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            super.onSaveInstanceState(outState);
            this.a.Y(outState);
        }
    }

    public void v2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            nm8.a.c(this, z);
            this.a.S(z);
        }
    }

    public void w2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            nm8.a.i(this, z);
            this.a.Z(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onActivityFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onActivityFinish();
            this.a.Q();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.onKeyDown(i, event);
            return this.a.onKeyDown(i, event);
        }
        return invokeIL.booleanValue;
    }
}
