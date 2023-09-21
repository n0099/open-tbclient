package com.baidu.tieba.im.base.core.inputtool;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.bd8;
import com.baidu.tieba.de8;
import com.baidu.tieba.gd8;
import com.baidu.tieba.hd8;
import com.baidu.tieba.hl5;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.nj5;
import com.baidu.tieba.qi;
import com.baidu.tieba.si;
import com.baidu.tieba.uj5;
import com.baidu.tieba.wi5;
import com.baidu.tieba.yd8;
import com.baidu.tieba.zd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GroupInputTool implements LifecycleObserver, si, zd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final InputToolFragment a;
    @Nullable
    public gd8 b;
    @Nullable
    public bd8 c;
    @Nullable
    public hd8 d;
    public boolean e;
    public boolean f;
    public long g;
    public long h;
    public final CustomMessageListener i;
    public final Handler j;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GroupInputTool groupInputTool, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool, Integer.valueOf(i)};
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
            this.a = groupInputTool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.f = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.c != null) {
                    this.a.c.a(this.a.e, this.a.f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GroupInputTool groupInputTool, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    this.a.j.removeMessages(1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public c(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.O() != null && this.a.O().m()) {
                if (this.a.e) {
                    this.a.a.C2().r();
                } else {
                    this.a.O().v(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements de8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public d(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // com.baidu.tieba.de8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.d != null) {
                    this.a.d.c(ViewState.GONE);
                }
                this.a.k0(false);
                this.a.Y();
                this.a.B(i, i2, j, animatorListenerAdapter, z);
            }
        }

        @Override // com.baidu.tieba.de8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.d != null) {
                    this.a.d.c(ViewState.VISIBLE);
                }
                this.a.k0(true);
                this.a.w(i, i2, j, animatorListenerAdapter, z);
            }
        }
    }

    public GroupInputTool(@Nullable InputToolFragment inputToolFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputToolFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this, 2921776);
        this.j = new b(this, Looper.myLooper());
        this.a = inputToolFragment;
        Z();
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            bd8 bd8Var = this.c;
            if (bd8Var != null) {
                bd8Var.a(z, this.f);
            }
            this.e = z;
            O().q(z);
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.m2() != null) {
                this.a.m2().setIsKeyboardOn(z);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921785, Boolean.valueOf(z)));
        }
    }

    public void E(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.m2() != null) {
            this.a.m2().setDisallowInterceptTouchEvent(z);
        }
    }

    public void F(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.u2() != null) {
            this.a.u2().setDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.baidu.tieba.zd8
    public void b(int i) {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            d0(true);
            InputToolFragment inputToolFragment = this.a;
            if ((inputToolFragment == null || inputToolFragment.H() != 8) && (hd8Var = this.d) != null && !this.f) {
                hd8Var.a(ViewState.INVISIBLE);
            }
        }
    }

    public void e0(BotsDTO botsDTO) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, botsDTO) == null) && (inputToolFragment = this.a) != null && inputToolFragment.w2() != null) {
            this.a.w2().t(botsDTO);
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f = z;
        }
    }

    public void g0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && (inputToolFragment = this.a) != null) {
            inputToolFragment.Q2(z);
        }
    }

    public void h0(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, hd8Var) == null) {
            this.d = hd8Var;
        }
    }

    public void i0(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && (inputToolFragment = this.a) != null) {
            inputToolFragment.R2(i);
        }
    }

    public void j0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            i0(i);
        }
    }

    public void k0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.C2() != null) {
            this.a.C2().setTopShadowDividerVisible(z);
        }
    }

    public void l0(View.OnClickListener onClickListener) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, onClickListener) == null) && onClickListener != null && (inputToolFragment = this.a) != null && inputToolFragment.u2() != null) {
            this.a.u2().setOnClickListener(onClickListener);
        }
    }

    public void m0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.u2() != null) {
            if (!z) {
                this.a.u2().setVisibility(8);
            } else {
                this.a.u2().setVisibility(0);
            }
        }
    }

    public void n0(gd8 gd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, gd8Var) == null) {
            this.b = gd8Var;
        }
    }

    @Override // com.baidu.tieba.si
    public void onDeletedVoice(String str) {
        gd8 gd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, str) == null) && (gd8Var = this.b) != null) {
            gd8Var.a();
        }
    }

    @Override // com.baidu.tieba.si
    public void onShowRecordTime(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i) == null) && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            this.a.A2().onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.si
    public void onShowRecording(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i) == null) && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            this.a.A2().onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.si
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, str, i) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i);
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            gd8 gd8Var = this.b;
            if (gd8Var != null) {
                gd8Var.b(voiceModel);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && (handler = this.j) != null) {
            handler.removeMessages(1);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.e && !this.f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (O() != null && O().m()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public hd8 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (hd8) invokeV.objValue;
    }

    @Nullable
    public nj5 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.n2();
        }
        return (nj5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.q2();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public uj5 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.s2();
        }
        return (uj5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.t2();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null || inputToolFragment.u2() == null || this.a.u2().getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public de8 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.w2();
        }
        return (de8) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (M() == null || (findViewById = M().findViewById(R.id.obfuscated_res_0x7f090e94)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public hl5 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.z2();
        }
        return (hl5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.A2();
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    @Nullable
    public GroupChatRobotTopHeadView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.B2();
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    @Nullable
    public EditorTools T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.C2();
        }
        return (EditorTools) invokeV.objValue;
    }

    public GroupChatUserReplyView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.p2();
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public GroupChatUserReplyView V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.v2();
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || O() == null) {
            return;
        }
        O().s(new d(this));
    }

    public final void Y() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.u2() != null) {
            this.a.u2().setOnClickListener(new c(this));
        }
    }

    public final void Z() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (inputToolFragment = this.a) == null) {
            return;
        }
        inputToolFragment.requireActivity();
        MessageManager.getInstance().registerListener(this.i);
        this.a.T2(this);
        X();
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.M2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zd8
    public void c() {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            yd8.a(this);
            InputToolFragment inputToolFragment = this.a;
            if ((inputToolFragment == null || inputToolFragment.H() != 8) && (hd8Var = this.d) != null) {
                hd8Var.a(ViewState.INVISIBLE);
            }
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.si
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.A2() != null) {
                return this.a.A2().isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.si
    public void onStopingRecorder() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            this.a.A2().onStopingRecorder();
        }
    }

    public void B(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && this.a != null) {
            if (z && !N()) {
                m0(true);
            }
            this.a.k2(i, i2, j, animatorListenerAdapter);
        }
    }

    public void w(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && this.a != null) {
            if (!z && N()) {
                m0(false);
            }
            this.a.k2(i, i2, j, animatorListenerAdapter);
        }
    }

    public void W() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.C2() != null) {
            this.f = false;
            this.a.C2().r();
            this.a.C2().t();
            this.a.C2().D(new wi5(5, -1, null));
            bd8 bd8Var = this.c;
            if (bd8Var != null) {
                bd8Var.a(this.e, this.f);
            }
        }
    }

    @Override // com.baidu.tieba.zd8
    public void g() {
        InputToolFragment inputToolFragment;
        InputToolFragment inputToolFragment2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            d0(false);
            if (this.d != null && !this.f && O() != null && !O().m() && (inputToolFragment2 = this.a) != null && inputToolFragment2.r2() != null && !this.a.r2().z()) {
                this.d.a(ViewState.VISIBLE);
            }
            if (this.d != null && (inputToolFragment = this.a) != null && inputToolFragment.r2() != null && this.a.r2().z()) {
                this.d.a(ViewState.GONE);
            }
        }
    }

    public void o0(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.g = j;
            this.h = j2;
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null) {
                inputToolFragment.x2().setRoomDetailInfo(this.g, this.h);
            }
        }
    }

    @Override // com.baidu.tieba.si
    public void onStartedRecorder(boolean z, int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            this.a.A2().onStartedRecorder(z, qi.c);
        }
    }

    @Override // com.baidu.tieba.si
    public void onShowErr(int i, String str) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048621, this, i, str) == null) && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            this.a.A2().onShowErr(i, str);
            if (!StringUtils.isNull(str)) {
                if (i == 3) {
                    this.a.showToast(str);
                    this.a.A2().setRecoding(false);
                } else if (i == 2) {
                    Handler handler = this.j;
                    handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }
}
