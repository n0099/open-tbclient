package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendNoLaunchView;
import com.baidu.tieba.im.base.core.inputtool.GroupInputTool;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.keyboardtool.PanelType;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes5.dex */
public class ek8 implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceManager a;
    public GroupInputTool b;
    public Context c;
    public TbPageContext d;
    public boolean e;
    public final InputToolFragment f;
    public ISendVoiceView g;
    public PermissionJudgePolicy h;
    public yd5 i;
    public EditorTools j;
    public PanelType k;
    public PanelType l;
    public float m;
    public yjc<PanelType, PanelType, Float, Float> n;
    public lw8 o;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView J1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    public void k(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements lw8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek8 a;

        @Override // com.baidu.tieba.lw8
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            }
        }

        public a(ek8 ek8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ek8Var;
        }

        @Override // com.baidu.tieba.lw8
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.a != null && this.a.h().f()) {
                    if (this.a.f == null) {
                        return true;
                    }
                    FragmentActivity fragmentActivity = this.a.f.getFragmentActivity();
                    if (this.a.h == null) {
                        this.a.h = new PermissionJudgePolicy();
                    }
                    this.a.h.clearRequestPermissionList();
                    this.a.h.appendRequestPermission(fragmentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    this.a.h.appendRequestPermission(fragmentActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                    return !this.a.h.startRequestPermission(fragmentActivity);
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.lw8
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.h() != null) {
                this.a.h().cancelRecord();
            }
        }

        @Override // com.baidu.tieba.lw8
        public boolean isForeground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.e;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.lw8
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.h() != null) {
                this.a.h().stopRecord();
            }
        }

        @Override // com.baidu.tieba.lw8
        public void startRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.h() != null) {
                this.a.h().c(this.a.b, -1);
                this.a.h().d(de.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-830181127, "Lcom/baidu/tieba/ek8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-830181127, "Lcom/baidu/tieba/ek8$b;");
                    return;
                }
            }
            int[] iArr = new int[PanelType.values().length];
            a = iArr;
            try {
                iArr[PanelType.INPUT_KEYBOARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PanelType.VOICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PanelType.EXPRESSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PanelType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[PanelType.INPUTCHANGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ek8(@NonNull InputToolFragment inputToolFragment) {
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
        this.g = null;
        this.j = null;
        PanelType panelType = PanelType.NONE;
        this.k = panelType;
        this.l = panelType;
        this.m = 0.0f;
        this.o = new a(this);
        this.c = inputToolFragment.getContext();
        this.d = inputToolFragment.getPageContext();
        this.f = inputToolFragment;
        j();
    }

    public void o(yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yd5Var) == null) {
            this.i = yd5Var;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e = z;
        }
    }

    public void r(yjc<PanelType, PanelType, Float, Float> yjcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, yjcVar) == null) {
            this.n = yjcVar;
        }
    }

    public void s(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, permissionJudgePolicy) == null) {
            this.h = permissionJudgePolicy;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    @NonNull
    public VoiceManager X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Nullable
    public PermissionJudgePolicy g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (PermissionJudgePolicy) invokeV.objValue;
    }

    public ota h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VoiceManager voiceManager = this.a;
            if (voiceManager != null && voiceManager.getRecorderManager() != null) {
                return this.a.getRecorderManager();
            }
            return null;
        }
        return (ota) invokeV.objValue;
    }

    public void i() {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (iSendVoiceView = this.g) != null) {
            iSendVoiceView.setTouchCallBack(this.o);
        }
    }

    public void l() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (voiceManager = this.a) != null) {
            voiceManager.onDestory(this.d);
        }
    }

    public void m() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (voiceManager = this.a) != null) {
            voiceManager.onPause();
        }
    }

    public void n() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (voiceManager = this.a) != null) {
            voiceManager.onResume(this.d);
            this.a.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a == null) {
                this.a = new VoiceManager();
                X0().setIsUseMediaPlayer(true);
                this.a.onCreate(this.d);
            }
            this.a.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
            VoiceManager.setIsNeedBlackScreen(false);
        }
    }

    public void q(GroupInputTool groupInputTool) {
        yd5 yd5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, groupInputTool) == null) {
            this.b = groupInputTool;
            EditorTools V = groupInputTool.V();
            this.j = V;
            if (V != null && this.b != null && (yd5Var = this.i) != null) {
                V.setActionListener(24, yd5Var);
                this.j.setActionListener(8, this.i);
                this.j.setActionListener(4, this.i);
                this.j.setActionListener(14, this.i);
                this.j.setActionListener(5, this.i);
                this.j.setActionListener(17, this.i);
                this.j.setActionListener(16, this.i);
                this.j.setActionListener(62, this.i);
                this.j.setActionListener(64, this.i);
                this.j.setActionListener(63, this.i);
                this.j.setActionListener(80, this.i);
                this.g = this.b.T();
                v(SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_audio_switch", true));
                t(SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_picture_switch", true), this.c.getString(R.string.function_can_not_use));
                this.j.K(new xd5(73, 3, 200));
                this.j.K(new xd5(79, 3, Boolean.TRUE));
            }
        }
    }

    public void t(boolean z, String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048591, this, z, str) == null) && (editorTools = this.j) != null && editorTools.u(38) != null && (this.j.u(38).m instanceof SendNoLaunchView)) {
            ((SendNoLaunchView) this.j.u(38).m).setPicIconEnable(z);
            ((SendNoLaunchView) this.j.u(38).m).setSendInterceptToastText(str, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(PanelType panelType, int i) {
        GroupInputTool groupInputTool;
        float f;
        yjc<PanelType, PanelType, Float, Float> yjcVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, panelType, i) == null) {
            if ((((el8.l != 0 || panelType != PanelType.INPUT_KEYBOARD) && this.k != panelType) || panelType == PanelType.INPUTCHANGE) && (groupInputTool = this.b) != null && groupInputTool.N() != null && this.b.N().i() != null) {
                this.l = panelType;
                this.b.N().i().getLineCount();
                int i3 = b.a[panelType.ordinal()];
                float f2 = 0.0f;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    i = el8.l;
                                } else if (this.k != PanelType.EXPRESSION) {
                                    f2 = this.m;
                                }
                            } else {
                                PanelType panelType2 = this.k;
                                if (panelType2 == PanelType.EXPRESSION) {
                                    i2 = TbSingleton.getInstance().getEmotionBoardHeight();
                                } else {
                                    if (panelType2 != PanelType.VOICE) {
                                        i2 = el8.l;
                                    }
                                    f = 0.0f;
                                }
                                f2 = -i2;
                                f = 0.0f;
                            }
                        } else if (this.k == PanelType.INPUT_KEYBOARD) {
                            if (TbSingleton.getInstance().getEmotionBoardHeight() != 0) {
                                f2 = -el8.l;
                                i = TbSingleton.getInstance().getEmotionBoardHeight();
                            }
                            f = 0.0f;
                        } else {
                            if (TbSingleton.getInstance().getEmotionBoardHeight() != 0) {
                                i = TbSingleton.getInstance().getEmotionBoardHeight();
                            }
                            f = 0.0f;
                        }
                    } else {
                        PanelType panelType3 = this.k;
                        if (panelType3 != PanelType.NONE && panelType3 == PanelType.INPUT_KEYBOARD) {
                            i2 = el8.l;
                            f2 = -i2;
                        }
                        f = 0.0f;
                    }
                    yjcVar = this.n;
                    if (yjcVar != null) {
                        yjcVar.b(this.l, this.k, Float.valueOf(f2), Float.valueOf(f));
                    }
                    this.m = f;
                    this.k = panelType;
                }
                i = el8.l;
                f = -i;
                yjcVar = this.n;
                if (yjcVar != null) {
                }
                this.m = f;
                this.k = panelType;
            }
        }
    }

    public void v(boolean z) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (editorTools = this.j) != null) {
            if (editorTools.u(6) != null && !z) {
                this.j.u(6).f = R.color.CAM_X0109;
                this.j.u(6).k = false;
                return;
            }
            this.j.u(6).f = R.color.CAM_X0105;
            this.j.u(6).k = true;
        }
    }
}
