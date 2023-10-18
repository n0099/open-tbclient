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
import com.baidu.tieba.ad;
import com.baidu.tieba.ae5;
import com.baidu.tieba.cd5;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.j88;
import com.baidu.tieba.k88;
import com.baidu.tieba.m78;
import com.baidu.tieba.nd;
import com.baidu.tieba.nf5;
import com.baidu.tieba.o88;
import com.baidu.tieba.pd;
import com.baidu.tieba.r78;
import com.baidu.tieba.s78;
import com.baidu.tieba.td5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class GroupInputTool implements LifecycleObserver, pd, k88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final InputToolFragment a;
    @Nullable
    public r78 b;
    @Nullable
    public m78 c;
    @Nullable
    public s78 d;
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
                if (!z || !ad.isEquals((String) obj, YYOption.IsLive.VALUE_TRUE)) {
                    if (z && ad.isEquals((String) obj, "false")) {
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
                    this.a.a.I2().r();
                } else {
                    this.a.Q().w(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements o88.e {
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

        @Override // com.baidu.tieba.o88.e
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

        @Override // com.baidu.tieba.o88.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) {
                if (this.a.d != null) {
                    this.a.d.c(ViewState.VISIBLE);
                }
                this.a.m0(true);
                this.a.B(i, i2, j, animatorListenerAdapter, z);
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
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.s2() != null) {
            this.a.s2().setDisallowInterceptTouchEvent(z);
        }
    }

    public void H(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            this.a.A2().setDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.baidu.tieba.k88
    public void b(int i) {
        s78 s78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            f0(true);
            InputToolFragment inputToolFragment = this.a;
            if ((inputToolFragment == null || inputToolFragment.I() != 8) && (s78Var = this.d) != null && !this.f) {
                s78Var.a(ViewState.INVISIBLE);
            }
        }
    }

    public void g0(BotsDTO botsDTO) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, botsDTO) == null) && (inputToolFragment = this.a) != null && inputToolFragment.C2() != null) {
            this.a.C2().u(botsDTO);
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f = z;
        }
    }

    public void i0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (inputToolFragment = this.a) != null) {
            inputToolFragment.X2(z);
        }
    }

    public void j0(s78 s78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, s78Var) == null) {
            this.d = s78Var;
        }
    }

    public void k0(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i) == null) && (inputToolFragment = this.a) != null) {
            inputToolFragment.Y2(i);
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            k0(i);
        }
    }

    public void m0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.I2() != null) {
            this.a.I2().setTopShadowDividerVisible(z);
        }
    }

    public void n0(View.OnClickListener onClickListener) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, onClickListener) == null) && onClickListener != null && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            this.a.A2().setOnClickListener(onClickListener);
        }
    }

    public void o0(boolean z) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            if (!z) {
                this.a.A2().setVisibility(8);
            } else {
                this.a.A2().setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.pd
    public void onDeletedVoice(String str) {
        r78 r78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, str) == null) && (r78Var = this.b) != null) {
            r78Var.a();
        }
    }

    @Override // com.baidu.tieba.pd
    public void onShowRecordTime(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048621, this, i) == null) && (inputToolFragment = this.a) != null && inputToolFragment.G2() != null) {
            this.a.G2().onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.pd
    public void onShowRecording(int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i) == null) && (inputToolFragment = this.a) != null && inputToolFragment.G2() != null) {
            this.a.G2().onShowRecording(i);
        }
    }

    public void p0(m78 m78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, m78Var) == null) {
            this.c = m78Var;
        }
    }

    public void q0(r78 r78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, r78Var) == null) {
            this.b = r78Var;
        }
    }

    @Override // com.baidu.tieba.pd
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048619, this, str, i) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i);
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            r78 r78Var = this.b;
            if (r78Var != null) {
                r78Var.b(voiceModel);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (Q() != null && Q().n()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public s78 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (s78) invokeV.objValue;
    }

    @Nullable
    public Context J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public td5 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.t2();
        }
        return (td5) invokeV.objValue;
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
            return inputToolFragment.w2();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public ae5 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.y2();
        }
        return (ae5) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.z2();
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null || inputToolFragment.A2() == null || this.a.A2().getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public o88 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.C2();
        }
        return (o88) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (O() == null || (findViewById = O().findViewById(R.id.obfuscated_res_0x7f090eae)) == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public nf5 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.F2();
        }
        return (nf5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.G2();
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    @Nullable
    public GroupChatRobotTopHeadView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.H2();
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    @Nullable
    public EditorTools V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.I2();
        }
        return (EditorTools) invokeV.objValue;
    }

    public GroupChatUserReplyView W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.v2();
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public GroupChatUserReplyView X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment == null) {
                return null;
            }
            return inputToolFragment.B2();
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || Q() == null) {
            return;
        }
        Q().t(new d(this));
    }

    public final void a0() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.A2() != null) {
            this.a.A2().setOnClickListener(new c(this));
        }
    }

    public final void b0() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (inputToolFragment = this.a) == null) {
            return;
        }
        inputToolFragment.requireActivity();
        MessageManager.getInstance().registerListener(this.i);
        this.a.a3(this);
        Z();
    }

    @Override // com.baidu.tieba.k88
    public void c() {
        s78 s78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            j88.a(this);
            InputToolFragment inputToolFragment = this.a;
            if ((inputToolFragment == null || inputToolFragment.I() != 8) && (s78Var = this.d) != null) {
                s78Var.a(ViewState.INVISIBLE);
            }
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.T2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pd
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.G2() != null) {
                return this.a.G2().isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pd
    public void onStopingRecorder() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.G2() != null) {
            this.a.G2().onStopingRecorder();
        }
    }

    public void B(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && this.a != null) {
            if (!z && P()) {
                o0(false);
            }
            this.a.q2(i, i2, j, animatorListenerAdapter);
        }
    }

    public void C(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) == null) && this.a != null) {
            if (z && !P()) {
                o0(true);
            }
            this.a.q2(i, i2, j, animatorListenerAdapter);
        }
    }

    public void Y() {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (inputToolFragment = this.a) != null && inputToolFragment.I2() != null) {
            this.f = false;
            this.a.I2().r();
            this.a.I2().t();
            this.a.I2().D(new cd5(5, -1, null));
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.e = z;
            Q().r(z);
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null && inputToolFragment.s2() != null) {
                this.a.s2().setIsKeyboardOn(z);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921785, Boolean.valueOf(z)));
        }
    }

    @Override // com.baidu.tieba.k88
    public void g() {
        InputToolFragment inputToolFragment;
        InputToolFragment inputToolFragment2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            f0(false);
            if (this.d != null && !this.f && Q() != null && !Q().n() && (inputToolFragment2 = this.a) != null && inputToolFragment2.x2() != null && !this.a.x2().A()) {
                this.d.a(ViewState.VISIBLE);
            }
            if (this.d != null && (inputToolFragment = this.a) != null && inputToolFragment.x2() != null && this.a.x2().A()) {
                this.d.a(ViewState.GONE);
            }
        }
    }

    @Override // com.baidu.tieba.pd
    public void onShowErr(int i, String str) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048620, this, i, str) == null) && (inputToolFragment = this.a) != null && inputToolFragment.G2() != null) {
            this.a.G2().onShowErr(i, str);
            if (!StringUtils.isNull(str)) {
                if (i == 3) {
                    this.a.showToast(str);
                    this.a.G2().setRecoding(false);
                } else if (i == 2) {
                    Handler handler = this.j;
                    handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pd
    public void onStartedRecorder(boolean z, int i) {
        InputToolFragment inputToolFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (inputToolFragment = this.a) != null && inputToolFragment.G2() != null) {
            this.a.G2().onStartedRecorder(z, nd.c);
        }
    }

    public void r0(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.g = j;
            this.h = j2;
            InputToolFragment inputToolFragment = this.a;
            if (inputToolFragment != null) {
                inputToolFragment.D2().setRoomDetailInfo(this.g, this.h);
            }
        }
    }
}
