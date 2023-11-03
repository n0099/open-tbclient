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
import com.baidu.tieba.ah5;
import com.baidu.tieba.de;
import com.baidu.tieba.fe;
import com.baidu.tieba.hl8;
import com.baidu.tieba.il8;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.kk8;
import com.baidu.tieba.ml8;
import com.baidu.tieba.pe5;
import com.baidu.tieba.pk8;
import com.baidu.tieba.qd;
import com.baidu.tieba.qk8;
import com.baidu.tieba.we5;
import com.baidu.tieba.xd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class GroupInputTool implements LifecycleObserver, fe, il8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final InputToolFragment a;
    @Nullable
    public pk8 b;
    @Nullable
    public kk8 c;
    @Nullable
    public qk8 d;
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
                if (!z || !qd.isEquals((String) obj, YYOption.IsLive.VALUE_TRUE)) {
                    if (z && qd.isEquals((String) obj, "false")) {
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
                    this.a.a.a3().w();
                } else {
                    this.a.Q().w(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ml8.e {
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

        @Override // com.baidu.tieba.ml8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.d != null) {
                    this.a.d.c(ViewState.GONE);
                }
                this.a.m0(false);
                this.a.a0();
                this.a.C(i, i2, j, animatorListenerAdapter, z);
            }
        }

        @Override // com.baidu.tieba.ml8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.d != null) {
                    this.a.d.c(ViewState.VISIBLE);
                }
                this.a.m0(true);
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
        b0();
    }

    public void F(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.K2() != null) {
            this.a.K2().setDisallowInterceptTouchEvent(z);
        }
    }

    public void G(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.S2() != null) {
            this.a.S2().setDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.baidu.tieba.il8
    public void b(int i) {
        qk8 qk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            f0(true);
            InputToolFragment inputToolFragment = this.a;
            if ((inputToolFragment == null || inputToolFragment.M() != 8) && (qk8Var = this.d) != null && !this.f) {
                qk8Var.a(ViewState.INVISIBLE);
            }
        }
    }

    public void g0(BotsDTO botsDTO) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, botsDTO) == null) && (inputToolFragment = this.a) != null && inputToolFragment.U2() != null) {
            this.a.U2().u(botsDTO);
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.f = z;
        }
    }

    public void i0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && (inputToolFragment = this.a) != null) {
            inputToolFragment.p3(z);
        }
    }

    public void j0(qk8 qk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, qk8Var) == null) {
            this.d = qk8Var;
        }
    }

    public void k0(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && (inputToolFragment = this.a) != null) {
            inputToolFragment.q3(i);
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            k0(i);
        }
    }

    public void m0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.a3() != null) {
            this.a.a3().setTopShadowDividerVisible(z);
        }
    }

    public void n0(View.OnClickListener onClickListener) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, onClickListener) == null) && onClickListener != null && (inputToolFragment = this.a) != null && inputToolFragment.S2() != null) {
            this.a.S2().setOnClickListener(onClickListener);
        }
    }

    public void o0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.S2() != null) {
            if (!z) {
                this.a.S2().setVisibility(8);
            } else {
                this.a.S2().setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.fe
    public void onDeletedVoice(String str) {
        pk8 pk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, str) == null) && (pk8Var = this.b) != null) {
            pk8Var.a();
        }
    }

    @Override // com.baidu.tieba.fe
    public void onShowRecordTime(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && (inputToolFragment = this.a) != null && inputToolFragment.Y2() != null) {
            this.a.Y2().onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.fe
    public void onShowRecording(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048621, this, i) == null) && (inputToolFragment = this.a) != null && inputToolFragment.Y2() != null) {
            this.a.Y2().onShowRecording(i);
        }
    }

    public void p0(kk8 kk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, kk8Var) == null) {
            this.c = kk8Var;
        }
    }

    public void q0(pk8 pk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, pk8Var) == null) {
            this.b = pk8Var;
        }
    }

    @Override // com.baidu.tieba.fe
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, str, i) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i);
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            pk8 pk8Var = this.b;
            if (pk8Var != null) {
                pk8Var.b(voiceModel);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Q() != null && Q().n()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public qk8 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (qk8) invokeV.objValue;
    }

    @Nullable
    public Context J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public pe5 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.L2();
        }
        return (pe5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.O2();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public we5 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.Q2();
        }
        return (we5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.R2();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null || inputToolFragment.S2() == null || this.a.S2().getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ml8 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.U2();
        }
        return (ml8) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (O() == null || (findViewById = O().findViewById(R.id.obfuscated_res_0x7f090ee4)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public ah5 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.X2();
        }
        return (ah5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.Y2();
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    @Nullable
    public GroupChatRobotTopHeadView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.Z2();
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    @Nullable
    public EditorTools V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.a3();
        }
        return (EditorTools) invokeV.objValue;
    }

    public GroupChatUserReplyView W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.N2();
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public GroupChatUserReplyView X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.T2();
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || Q() == null) {
            return;
        }
        Q().t(new d(this));
    }

    public final void a0() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.S2() != null) {
            this.a.S2().setOnClickListener(new c(this));
        }
    }

    public final void b0() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || (inputToolFragment = this.a) == null) {
            return;
        }
        inputToolFragment.requireActivity();
        MessageManager.getInstance().registerListener(this.i);
        this.a.s3(this);
        Z();
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.il8
    public void d() {
        qk8 qk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            hl8.a(this);
            InputToolFragment inputToolFragment = this.a;
            if ((inputToolFragment == null || inputToolFragment.M() != 8) && (qk8Var = this.d) != null) {
                qk8Var.a(ViewState.INVISIBLE);
            }
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.l3()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fe
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.Y2() != null) {
                return this.a.Y2().isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fe
    public void onStopingRecorder() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.Y2() != null) {
            this.a.Y2().onStopingRecorder();
        }
    }

    public void C(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && this.a != null) {
            if (z && !P()) {
                o0(true);
            }
            this.a.I2(i, i2, j, animatorListenerAdapter);
        }
    }

    public void w(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && this.a != null) {
            if (!z && P()) {
                o0(false);
            }
            this.a.I2(i, i2, j, animatorListenerAdapter);
        }
    }

    public void Y() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.a3() != null) {
            this.f = false;
            this.a.a3().w();
            this.a.a3().y();
            this.a.a3().K(new xd5(5, -1, null));
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.e = z;
            Q().r(z);
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.K2() != null) {
                this.a.K2().setIsKeyboardOn(z);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921785, Boolean.valueOf(z)));
        }
    }

    @Override // com.baidu.tieba.il8
    public void g() {
        InputToolFragment inputToolFragment;
        InputToolFragment inputToolFragment2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            f0(false);
            if (this.d != null && !this.f && Q() != null && !Q().n() && (inputToolFragment2 = this.a) != null && inputToolFragment2.P2() != null && !this.a.P2().A()) {
                this.d.a(ViewState.VISIBLE);
            }
            if (this.d != null && (inputToolFragment = this.a) != null && inputToolFragment.P2() != null && this.a.P2().A()) {
                this.d.a(ViewState.GONE);
            }
        }
    }

    @Override // com.baidu.tieba.fe
    public void onShowErr(int i, String str) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048619, this, i, str) == null) && (inputToolFragment = this.a) != null && inputToolFragment.Y2() != null) {
            this.a.Y2().onShowErr(i, str);
            if (!StringUtils.isNull(str)) {
                if (i == 3) {
                    this.a.showToast(str);
                    this.a.Y2().setRecoding(false);
                } else if (i == 2) {
                    Handler handler = this.j;
                    handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.fe
    public void onStartedRecorder(boolean z, int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (inputToolFragment = this.a) != null && inputToolFragment.Y2() != null) {
            this.a.Y2().onStartedRecorder(z, de.c);
        }
    }

    public void r0(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.g = j;
            this.h = j2;
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null) {
                inputToolFragment.V2().setRoomDetailInfo(this.g, this.h);
            }
        }
    }
}
