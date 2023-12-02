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
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.ee;
import com.baidu.tieba.ge;
import com.baidu.tieba.gf5;
import com.baidu.tieba.he5;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.kh5;
import com.baidu.tieba.po8;
import com.baidu.tieba.qo8;
import com.baidu.tieba.rd;
import com.baidu.tieba.sn8;
import com.baidu.tieba.uo8;
import com.baidu.tieba.xn8;
import com.baidu.tieba.yn8;
import com.baidu.tieba.ze5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class GroupInputTool implements LifecycleObserver, ge, qo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final InputToolFragment a;
    @Nullable
    public xn8 b;
    @Nullable
    public sn8 c;
    @Nullable
    public yn8 d;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                Object obj = hashMap.get("status");
                Object obj2 = hashMap.get("containerHeight");
                boolean z = obj instanceof String;
                if (!z || !rd.isEquals((String) obj, YYOption.IsLive.VALUE_TRUE)) {
                    if (z && rd.isEquals((String) obj, "false")) {
                        this.a.f = false;
                    }
                } else {
                    this.a.f = true;
                }
                if (obj2 instanceof String) {
                    String str = (String) obj2;
                    if (Integer.parseInt(str) != 0) {
                        TbSingleton.getInstance().setEmotionBoardHeight(Integer.parseInt(str));
                    }
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.Q() != null && this.a.Q().n()) {
                if (this.a.e) {
                    this.a.a.m3().w();
                } else {
                    this.a.Q().w(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements uo8.e {
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

        @Override // com.baidu.tieba.uo8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.d != null) {
                    this.a.d.c(ViewState.GONE);
                }
                this.a.m0(false);
                this.a.a0();
                this.a.w(i, i2, j, animatorListenerAdapter, z);
            }
        }

        @Override // com.baidu.tieba.uo8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.d != null) {
                    this.a.d.c(ViewState.VISIBLE);
                }
                this.a.m0(true);
                this.a.v(i, i2, j, animatorListenerAdapter, z);
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
        b0();
    }

    public void F(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.W2() != null) {
            this.a.W2().setDisallowInterceptTouchEvent(z);
        }
    }

    public void G(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.e3() != null) {
            this.a.e3().setDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.baidu.tieba.qo8
    public void b(int i) {
        yn8 yn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            f0(true);
            InputToolFragment inputToolFragment = this.a;
            if ((inputToolFragment == null || inputToolFragment.N() != 8) && (yn8Var = this.d) != null && !this.f) {
                yn8Var.a(ViewState.INVISIBLE);
            }
        }
    }

    public void g0(BotsDTO botsDTO) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, botsDTO) == null) && (inputToolFragment = this.a) != null && inputToolFragment.g3() != null) {
            this.a.g3().u(botsDTO);
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f = z;
        }
    }

    public void i0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && (inputToolFragment = this.a) != null) {
            inputToolFragment.B3(z);
        }
    }

    public void j0(yn8 yn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, yn8Var) == null) {
            this.d = yn8Var;
        }
    }

    public void k0(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && (inputToolFragment = this.a) != null) {
            inputToolFragment.C3(i);
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            k0(i);
        }
    }

    public void m0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.m3() != null) {
            this.a.m3().setTopShadowDividerVisible(z);
        }
    }

    public void n0(View.OnClickListener onClickListener) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, onClickListener) == null) && onClickListener != null && (inputToolFragment = this.a) != null && inputToolFragment.e3() != null) {
            this.a.e3().setOnClickListener(onClickListener);
        }
    }

    public void o0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.e3() != null) {
            if (!z) {
                this.a.e3().setVisibility(8);
            } else {
                this.a.e3().setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.ge
    public void onDeletedVoice(String str) {
        xn8 xn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, str) == null) && (xn8Var = this.b) != null) {
            xn8Var.a();
        }
    }

    @Override // com.baidu.tieba.ge
    public void onShowRecordTime(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048619, this, i) == null) && (inputToolFragment = this.a) != null && inputToolFragment.k3() != null) {
            this.a.k3().onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.ge
    public void onShowRecording(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && (inputToolFragment = this.a) != null && inputToolFragment.k3() != null) {
            this.a.k3().onShowRecording(i);
        }
    }

    public void p0(sn8 sn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, sn8Var) == null) {
            this.c = sn8Var;
        }
    }

    public void q0(xn8 xn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, xn8Var) == null) {
            this.b = xn8Var;
        }
    }

    @Override // com.baidu.tieba.ge
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048617, this, str, i) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i);
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            xn8 xn8Var = this.b;
            if (xn8Var != null) {
                xn8Var.b(voiceModel);
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

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.e && !this.f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Q() != null && Q().n()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public yn8 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (yn8) invokeV.objValue;
    }

    @Nullable
    public Context J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public ze5 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.X2();
        }
        return (ze5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.a3();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public gf5 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.c3();
        }
        return (gf5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.d3();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null || inputToolFragment.e3() == null || this.a.e3().getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public uo8 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.g3();
        }
        return (uo8) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (O() == null || (findViewById = O().findViewById(R.id.obfuscated_res_0x7f090f05)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public kh5 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.j3();
        }
        return (kh5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.k3();
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    @Nullable
    public GroupChatRobotTopHeadView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.l3();
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    @Nullable
    public EditorTools V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.m3();
        }
        return (EditorTools) invokeV.objValue;
    }

    public GroupChatUserReplyView W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.Z2();
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public GroupChatUserReplyView X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.f3();
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || Q() == null) {
            return;
        }
        Q().t(new d(this));
    }

    public final void a0() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.e3() != null) {
            this.a.e3().setOnClickListener(new c(this));
        }
    }

    public final void b0() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (inputToolFragment = this.a) == null) {
            return;
        }
        inputToolFragment.requireActivity();
        MessageManager.getInstance().registerListener(this.i);
        this.a.E3(this);
        Z();
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qo8
    public void d() {
        yn8 yn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            po8.a(this);
            InputToolFragment inputToolFragment = this.a;
            if ((inputToolFragment == null || inputToolFragment.N() != 8) && (yn8Var = this.d) != null) {
                yn8Var.a(ViewState.INVISIBLE);
            }
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.x3()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ge
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.k3() != null) {
                return this.a.k3().isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ge
    public void onStopingRecorder() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.k3() != null) {
            this.a.k3().onStopingRecorder();
        }
    }

    public void Y() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.m3() != null) {
            this.f = false;
            this.a.m3().w();
            this.a.m3().y();
            this.a.m3().K(new he5(5, -1, null));
        }
    }

    @Override // com.baidu.tieba.qo8
    public void f() {
        InputToolFragment inputToolFragment;
        InputToolFragment inputToolFragment2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            f0(false);
            if (this.d != null && !this.f && Q() != null && !Q().n() && (inputToolFragment2 = this.a) != null && inputToolFragment2.b3() != null && !this.a.b3().A()) {
                this.d.a(ViewState.VISIBLE);
            }
            if (this.d != null && (inputToolFragment = this.a) != null && inputToolFragment.b3() != null && this.a.b3().A()) {
                this.d.a(ViewState.GONE);
            }
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.e = z;
            Q().r(z);
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.W2() != null) {
                this.a.W2().setIsKeyboardOn(z);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921785, Boolean.valueOf(z)));
        }
    }

    @Override // com.baidu.tieba.ge
    public void onShowErr(int i, String str) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048618, this, i, str) == null) && (inputToolFragment = this.a) != null && inputToolFragment.k3() != null) {
            this.a.k3().onShowErr(i, str);
            if (!StringUtils.isNull(str)) {
                if (i == 3) {
                    this.a.showToast(str);
                    this.a.k3().setRecoding(false);
                } else if (i == 2) {
                    Handler handler = this.j;
                    handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ge
    public void onStartedRecorder(boolean z, int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (inputToolFragment = this.a) != null && inputToolFragment.k3() != null) {
            this.a.k3().onStartedRecorder(z, ee.c);
        }
    }

    public void r0(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.g = j;
            this.h = j2;
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null) {
                inputToolFragment.h3().setRoomDetailInfo(this.g, this.h);
            }
        }
    }

    public void v(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && this.a != null) {
            if (!z && P()) {
                o0(false);
            }
            this.a.U2(i, i2, j, animatorListenerAdapter);
        }
    }

    public void w(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && this.a != null) {
            if (z && !P()) {
                o0(true);
            }
            this.a.U2(i, i2, j, animatorListenerAdapter);
        }
    }
}
