package com.baidu.tieba.im.base.core.inputtool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.AsyncUploadTask;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PicManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.EmotionNoLaunchView;
import com.baidu.tbadk.editortools.sendtool.SendNoLaunchView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.akc;
import com.baidu.tieba.au5;
import com.baidu.tieba.bm8;
import com.baidu.tieba.bn8;
import com.baidu.tieba.cm8;
import com.baidu.tieba.cn8;
import com.baidu.tieba.dk8;
import com.baidu.tieba.dm8;
import com.baidu.tieba.ek8;
import com.baidu.tieba.el5;
import com.baidu.tieba.eu5;
import com.baidu.tieba.fk8;
import com.baidu.tieba.ft5;
import com.baidu.tieba.hk8;
import com.baidu.tieba.ik8;
import com.baidu.tieba.im.base.core.inputtool.GroupInputViewController;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.consts.BotSourceType;
import com.baidu.tieba.im.base.core.inputtool.consts.ToolState;
import com.baidu.tieba.im.base.core.inputtool.data.AtData;
import com.baidu.tieba.im.base.core.inputtool.data.InputBanData;
import com.baidu.tieba.im.base.core.inputtool.data.PaddingContentData;
import com.baidu.tieba.im.base.core.inputtool.keyboardtool.PanelType;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.SkillSugRequest;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.jk8;
import com.baidu.tieba.kd;
import com.baidu.tieba.ke5;
import com.baidu.tieba.kk8;
import com.baidu.tieba.l85;
import com.baidu.tieba.le5;
import com.baidu.tieba.lk8;
import com.baidu.tieba.ll8;
import com.baidu.tieba.mk8;
import com.baidu.tieba.ml8;
import com.baidu.tieba.my0;
import com.baidu.tieba.nk8;
import com.baidu.tieba.nl8;
import com.baidu.tieba.ok8;
import com.baidu.tieba.ol8;
import com.baidu.tieba.pk8;
import com.baidu.tieba.qd;
import com.baidu.tieba.tu5;
import com.baidu.tieba.uk8;
import com.baidu.tieba.vk8;
import com.baidu.tieba.w4;
import com.baidu.tieba.wk8;
import com.baidu.tieba.xd5;
import com.baidu.tieba.xk8;
import com.baidu.tieba.yd5;
import com.baidu.tieba.yjc;
import com.baidu.tieba.yk8;
import com.baidu.tieba.zl8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GroupInputViewController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bn8 A;
    public ml8 B;
    public ol8 C;
    public nl8 D;
    public ll8 E;
    public ek8 F;
    public String G;
    public int H;
    public Object I;
    public xk8 J;
    public BotsDTO.BotListDTO.UserDTO K;
    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> L;
    public int M;
    public List<BotsDTO.BotListDTO.SkillDTO> N;
    public BotsDTO.BotListDTO.SkillDTO O;
    public GroupChatRobotTopHeadView P;
    public BotSourceType Q;
    @NonNull
    public zl8 R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1114T;
    public boolean U;
    public List<AtSelectData> V;
    public List<InputBanData> W;
    public int X;
    @Nullable
    public cn8 Y;
    public final CustomMessageListener Z;
    public int a;
    public final CustomMessageListener a0;
    public ToolState b;
    public yd5 b0;
    @Nullable
    public Context c;
    public hk8.m c0;
    public WriteImagesInfo d;
    public final pk8 d0;
    public LocalPicModel e;
    public hk8.l e0;
    public View f;
    public final w4 f0;
    public String g;
    public final CustomMessageListener g0;
    public String h;
    public kk8 h0;
    public String i;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> j;
    public EditorTools k;
    @NonNull
    public final InputToolFragment l;
    @Nullable
    public final GroupInputTool m;
    public fk8 n;
    public cm8 o;
    @Nullable
    public dk8 p;
    @Nullable
    public hk8 q;
    @Nullable
    public yk8 r;
    @Nullable
    public vk8 s;
    public final long t;
    public boolean u;
    public String v;
    public boolean w;
    public PermissionJudgePolicy x;
    public boolean y;
    @Nullable
    public nk8 z;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
        }
    }

    public void J1(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i2) == null) {
        }
    }

    public boolean v0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048687, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ GroupInputViewController d;

        /* loaded from: classes6.dex */
        public class a extends au5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.au5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    e eVar = this.a;
                    eVar.d.y0(eVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ft5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.ft5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.e = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        e eVar = this.a;
                        eVar.d.e = new LocalPicModel(eVar.b, eVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.e.setLoadDataCallBack(this.a.d.f0);
                    this.a.d.e.getData();
                }
            }
        }

        public e(GroupInputViewController groupInputViewController, ImageFileInfo imageFileInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, imageFileInfo, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupInputViewController;
            this.a = imageFileInfo;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageFileInfo imageFileInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (imageFileInfo = this.a) != null && imageFileInfo.getFilePath() != null) {
                eu5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ml8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes6.dex */
        public class a implements ml8.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.baidu.tieba.ml8.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.T1(BotSourceType.ONE, false, false);
                }
            }
        }

        public h(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.ml8.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.c2(userDTO, skillDTO);
                this.a.h0();
                if (this.a.z != null) {
                    if (skillDTO.isFuncJump() && skillDTO.getAbilityItem() != null) {
                        this.a.z.q(skillDTO.getAbilityItem());
                        this.a.e1();
                        this.a.d1();
                        return;
                    } else if (skillDTO.isFuncSendMsg() && !TextUtils.isEmpty(userDTO.getUk())) {
                        this.a.z.k(userDTO.getUk(), skillDTO.getType());
                        this.a.R0().w(null);
                        this.a.e1();
                        this.a.d1();
                        return;
                    }
                }
                this.a.A0();
                this.a.M1(true);
                if (this.a.R0() != null) {
                    this.a.R0().w(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lk8 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ GroupInputViewController c;

        /* loaded from: classes6.dex */
        public class a implements IUploadTransferListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ l b;

            public a(l lVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = str;
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFailed(int i, int i2, String str) {
                lk8 lk8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (lk8Var = this.b.a) != null) {
                    lk8Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                lk8 lk8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (lk8Var = this.b.a) != null) {
                    lk8Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                lk8 lk8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (lk8Var = this.b.a) != null) {
                    lk8Var.b(i);
                }
            }
        }

        public l(GroupInputViewController groupInputViewController, lk8 lk8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, lk8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = groupInputViewController;
            this.a = lk8Var;
            this.b = str;
        }

        @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
        public void onGenBosObjectUrlListener(int i, String str, String str2, String str3, Map<String, String> map) {
            String str4;
            String str5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3, map}) == null) {
                if (i == 0) {
                    String str6 = null;
                    if (map == null) {
                        str4 = "";
                        str5 = str4;
                    } else {
                        String str7 = map.get(AsyncChatTask.PUT_URL);
                        str5 = map.get(AsyncChatTask.GET_URL);
                        str4 = str7;
                        str6 = map.get("thumb_url");
                    }
                    if (qd.isEmpty(str4) || qd.isEmpty(str5) || qd.isEmpty(str6)) {
                        lk8 lk8Var = this.a;
                        if (lk8Var != null) {
                            lk8Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.r2(1, str4, str5, this.b, "image/jpeg", str2, str3, new a(this, str6));
                    return;
                }
                this.a.a(i, 1, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements hk8.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public a(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.hk8.l
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.m != null && this.a.m.I() != null && z) {
                this.a.m.I().a(ViewState.INVISIBLE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements ml8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public a0(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, userReplyInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = userReplyInfoData;
        }

        @Override // com.baidu.tieba.ml8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.C.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public b(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    String sPathGen = responseData.getSPathGen();
                    if (this.a.r1() && this.a.q != null && !StringUtils.isNull(sPathGen)) {
                        this.a.q.Q(sPathGen, str);
                        return;
                    } else if (responseData.getExtraMap() != null) {
                        this.a.z.b(responseData.getSPathGen(), str, responseData.getExtraMap());
                        return;
                    } else {
                        this.a.z.l(responseData.getSPathGen(), str);
                        return;
                    }
                }
                this.a.l.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements mk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public b0(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, userReplyInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = userReplyInfoData;
        }

        @Override // com.baidu.tieba.mk8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.C.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends au5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l85 a;
        public final /* synthetic */ GroupInputViewController b;

        public c(GroupInputViewController groupInputViewController, l85 l85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, l85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = l85Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.au5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = el5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.y0(imageFileInfo);
                String b = el5.b.b(this.a.d());
                int i = x.a[this.a.g().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            str = "-1";
                        } else {
                            str = "3";
                        }
                    } else {
                        str = "2";
                    }
                } else {
                    str = "1";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(EmotionUbcHelper.MEME_ID, b);
                hashMap.put("meme_type", str);
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements ml8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ GroupInputViewController b;

        public c0(GroupInputViewController groupInputViewController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = str;
        }

        @Override // com.baidu.tieba.ml8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.D.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ft5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public d(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ft5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.e = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.e.setExtraMap(map);
                this.a.e.setLoadDataCallBack(this.a.f0);
                this.a.e.getData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements mk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ GroupInputViewController b;

        public d0(GroupInputViewController groupInputViewController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = str;
        }

        @Override // com.baidu.tieba.mk8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.D.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements pk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.pk8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public e0(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.pk8
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.z != null) {
                this.a.z.d(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public f(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l.H != null) {
                    this.a.l.H.d();
                }
                this.a.m.h0(false);
                this.a.R1(PanelType.INPUT_KEYBOARD, -10086);
                this.a.y = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(GroupInputViewController groupInputViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Integer.valueOf(i)};
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
            this.a = groupInputViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (booleanValue && this.a.y) {
                    this.a.y = false;
                    if (!this.a.n0()) {
                        this.a.u0(true, 1);
                    }
                }
                if (!booleanValue && this.a.E != null) {
                    this.a.E.l();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ol8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public i(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.ol8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            if (this.a.m.I() != null) {
                this.a.m.I().c(ViewState.GONE);
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.Q1(groupInputViewController.j.getString(R.string.im_msg_input_hint));
            this.a.S1(false);
            this.a.m.C(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.ol8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.Q1(groupInputViewController.G);
            this.a.S1(true);
            this.a.m.w(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.ol8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.q0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements nl8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public j(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.nl8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            if (this.a.m.I() != null) {
                this.a.m.I().c(ViewState.GONE);
            }
            this.a.S1(false);
            this.a.m.C(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.nl8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.Q1(groupInputViewController.G);
            this.a.S1(true);
            this.a.m.w(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.nl8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(GroupInputViewController groupInputViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Integer.valueOf(i)};
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
            this.a = groupInputViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ToolState toolState;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (booleanValue) {
                    toolState = ToolState.VOICE;
                } else {
                    toolState = ToolState.TEXT;
                }
                if (this.a.b == toolState) {
                    return;
                }
                this.a.b = toolState;
                if (this.a.p != null) {
                    this.a.p.I(this.a.b);
                }
                this.a.u2(booleanValue);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements GroupChatRobotTopHeadView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public m(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotTopHeadView.b
        public void onCloseEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.a;
                groupInputViewController.Q1(groupInputViewController.G);
                this.a.v1(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ol8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BotSourceType a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ GroupInputViewController d;

        public n(GroupInputViewController groupInputViewController, BotSourceType botSourceType, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, botSourceType, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupInputViewController;
            this.a = botSourceType;
            this.b = z;
            this.c = z2;
        }

        @Override // com.baidu.tieba.ol8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.l2(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class o implements nl8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BotSourceType a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ GroupInputViewController d;

        public o(GroupInputViewController groupInputViewController, BotSourceType botSourceType, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, botSourceType, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupInputViewController;
            this.a = botSourceType;
            this.b = z;
            this.c = z2;
        }

        @Override // com.baidu.tieba.nl8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.l2(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class p implements mk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ GroupInputViewController b;

        public p(GroupInputViewController groupInputViewController, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = z;
        }

        @Override // com.baidu.tieba.mk8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.k2(groupInputViewController.O, false, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements ml8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ GroupInputViewController b;

        public q(GroupInputViewController groupInputViewController, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupInputViewController;
            this.a = z;
        }

        @Override // com.baidu.tieba.ml8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.k2(groupInputViewController.O, false, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public r(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q != null) {
                if (this.a.q.N()) {
                    this.a.q.D();
                    return;
                }
                this.a.f1(false);
                this.a.A0();
                this.a.s2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public s(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.q != null && this.a.q.N()) {
                    this.a.q.D();
                    return;
                }
                this.a.g1(true, false, null);
                this.a.s2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements hk8.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public t(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.hk8.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C1();
                if (this.a.U) {
                    return;
                }
                this.a.g1(true, true, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ mk8 c;
        public final /* synthetic */ GroupInputViewController d;

        public u(GroupInputViewController groupInputViewController, boolean z, boolean z2, mk8 mk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z), Boolean.valueOf(z2), mk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = groupInputViewController;
            this.a = z;
            this.b = z2;
            this.c = mk8Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.d.z1(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.z1(this.a, this.b);
            mk8 mk8Var = this.c;
            if (mk8Var != null) {
                mk8Var.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(GroupInputViewController groupInputViewController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Integer.valueOf(i)};
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
            this.a = groupInputViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.f1114T = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements kk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public w(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.kk8
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z2) {
                    this.a.x0();
                } else {
                    this.a.R1(PanelType.EXPRESSION, -10086);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class x {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(225244031, "Lcom/baidu/tieba/im/base/core/inputtool/GroupInputViewController$x;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(225244031, "Lcom/baidu/tieba/im/base/core/inputtool/GroupInputViewController$x;");
                    return;
                }
            }
            int[] iArr = new int[EmotionGroupType.values().length];
            a = iArr;
            try {
                iArr[EmotionGroupType.BIG_EMOTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EmotionGroupType.USER_COLLECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EmotionGroupType.USER_DIY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements yd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public y(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.yd5
        public void S(xd5 xd5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, xd5Var) != null) || xd5Var == null) {
                return;
            }
            int i = xd5Var.a;
            if (i != 5 && i != 64) {
                if (i == 24) {
                    Object obj = xd5Var.c;
                    if (obj instanceof l85) {
                        l85 l85Var = (l85) obj;
                        if (l85Var.g() != EmotionGroupType.LOCAL) {
                            this.a.B1(l85Var);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 8) {
                    this.a.C1();
                    if (this.a.U) {
                        return;
                    }
                    this.a.f1(true);
                    return;
                } else if (i == 4) {
                    Object obj2 = xd5Var.c;
                    if (obj2 instanceof String) {
                        this.a.g = (String) obj2;
                        this.a.u0(false, 1);
                        this.a.E.n(100L);
                        this.a.I1();
                        return;
                    }
                    return;
                } else if (i == 14) {
                    this.a.w1();
                    return;
                } else if (i != 17) {
                    if (i == 62) {
                        boolean booleanValue = ((Boolean) xd5Var.c).booleanValue();
                        if (this.a.m == null) {
                            return;
                        }
                        this.a.m.h0(booleanValue);
                        if (booleanValue) {
                            this.a.r0();
                        } else {
                            this.a.u0(true, 1);
                        }
                        if (!booleanValue) {
                            this.a.R1(PanelType.INPUT_KEYBOARD, -10086);
                        }
                        if (!this.a.m.c0() || this.a.Q0() != ToolState.TEXT) {
                            return;
                        }
                        this.a.Y1(false);
                        this.a.L1(false);
                        return;
                    } else if (i == 63) {
                        boolean booleanValue2 = ((Boolean) xd5Var.c).booleanValue();
                        if (this.a.m == null) {
                            return;
                        }
                        if (booleanValue2) {
                            this.a.R1(PanelType.VOICE, -10086);
                        } else {
                            this.a.R1(PanelType.INPUT_KEYBOARD, -10086);
                        }
                        this.a.m.h0(false);
                        return;
                    } else if (i == 80 && !this.a.m.c0()) {
                        this.a.R1(PanelType.NONE, -10086);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.a.R1(PanelType.INPUT_KEYBOARD, -10086);
        }
    }

    /* loaded from: classes6.dex */
    public class z implements hk8.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public z(GroupInputViewController groupInputViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputViewController;
        }

        @Override // com.baidu.tieba.hk8.m
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.f2(z);
        }
    }

    public GroupInputViewController(@NonNull InputToolFragment inputToolFragment, @Nullable cn8 cn8Var, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputToolFragment, cn8Var, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ToolState.TEXT;
        this.d = new WriteImagesInfo(1);
        this.e = null;
        this.k = null;
        this.w = true;
        this.G = null;
        this.J = new xk8();
        this.L = new ArrayList();
        this.M = 0;
        this.P = null;
        this.f1114T = false;
        this.U = false;
        this.V = new ArrayList();
        this.W = new ArrayList();
        this.X = 0;
        this.Z = new k(this, 2921790);
        this.a0 = new v(this, 2921800);
        this.b0 = new y(this);
        this.c0 = new z(this);
        this.d0 = new e0(this);
        this.e0 = new a(this);
        this.f0 = new b(this);
        this.g0 = new g(this, 2921785);
        this.h0 = new w(this);
        this.t = j2;
        this.l = inputToolFragment;
        this.j = inputToolFragment.getPageContext();
        this.c = this.l.getContext();
        this.Y = cn8Var;
        this.m = this.l.M2();
        ek8 ek8Var = new ek8(inputToolFragment);
        this.F = ek8Var;
        ek8Var.o(this.b0);
        this.R = new jk8(this);
        this.E = new ll8(this, this.j, new akc() { // from class: com.baidu.tieba.ck8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.akc
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? GroupInputViewController.this.t1() : invokeV.objValue;
            }
        }, cn8Var);
        h1();
        N1();
        i1();
        MessageManager.getInstance().registerListener(this.Z);
        MessageManager.getInstance().registerListener(this.a0);
        hk8 hk8Var = this.q;
        if (hk8Var != null) {
            hk8Var.b0(this.e0);
        }
        this.n = new fk8(this);
        this.o = new cm8();
    }

    public final void k2(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2, boolean z3) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{skillDTO, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.m != null && skillDTO2 != null) {
                boolean z5 = false;
                if (this.Q == BotSourceType.TWO) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.m.F(true);
                this.m.G(!z4);
                String str = "";
                if (skillDTO2.getKeyboard() == 1) {
                    if (!TextUtils.isEmpty(skillDTO2.getKeyboardContent())) {
                        P1(skillDTO2.getKeyboardContent());
                    } else {
                        P1("");
                    }
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        Q1(skillDTO2.getExp());
                    } else if (z4) {
                        Q1(this.j.getString(R.string.obfuscated_res_0x7f0f0986));
                    }
                    d2(1, !TextUtils.isEmpty(this.g));
                    U1(false);
                    V1(false);
                    S1(false);
                    this.m.n0(new r(this));
                    if (this.m.V() != null) {
                        GroupInputTool groupInputTool = this.m;
                        if (skillDTO2.getKeyboardType() == 1) {
                            z5 = true;
                        }
                        groupInputTool.i0(z5);
                        m2();
                    }
                    n2(skillDTO2, z3);
                } else {
                    if (this.m.V() != null) {
                        this.m.V().v();
                    }
                    this.m.n0(new s(this));
                    o2(skillDTO2, z3);
                }
                cm8 cm8Var = this.o;
                int T0 = T0();
                String name = skillDTO2.getName();
                long K0 = K0();
                String L0 = L0();
                long S0 = S0();
                BotsDTO.BotListDTO.UserDTO userDTO = this.K;
                if (userDTO != null) {
                    str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                }
                cm8Var.a(1, T0, name, K0, L0, S0, str);
            }
        }
    }

    public final void A1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.S = true;
            g1(true, false, new p(this, z2));
        }
    }

    public void D1(bn8 bn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bn8Var) == null) {
            this.A = bn8Var;
        }
    }

    public void E1(BotsDTO botsDTO) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, botsDTO) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.g0(botsDTO);
        }
    }

    public void F1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.G = str;
        }
    }

    public void K1(List<InputBanData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            this.W = list;
        }
    }

    public final void M1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048601, this, z2) != null) || (groupInputTool = this.m) == null) {
            return;
        }
        if (z2) {
            groupInputTool.l0(1);
        } else {
            groupInputTool.l0(0);
        }
    }

    public void O1(String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, str) == null) && (editorTools = this.k) != null) {
            editorTools.K(new xd5(75, 3, str));
        }
    }

    public void P1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.g = str;
            if (!TextUtils.isEmpty(str)) {
                this.i = str;
            }
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.K(new xd5(6, 3, str));
            }
        }
    }

    public void Q1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.v = str;
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.K(new xd5(71, 3, StringHelper.cutChineseAndEnglishWithEmoji(str, 28, "...")));
            }
        }
    }

    public void S1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.m0(z2);
        }
    }

    public void V1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) && this.k.t(6) != null) {
            if (!z2) {
                this.k.t(6).hide();
            } else {
                this.k.t(6).display();
            }
        }
    }

    public void W1(yjc<PanelType, PanelType, Float, Float> yjcVar) {
        ek8 ek8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, yjcVar) == null) && (ek8Var = this.F) != null) {
            ek8Var.r(yjcVar);
        }
    }

    public void X1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.X = i2;
        }
    }

    public void Z1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, view2) == null) {
            this.f = view2;
        }
    }

    public final void a2(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.I() != null) {
            this.m.I().d(z2);
        }
    }

    public void c1(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            A0();
            s0(str);
        }
    }

    public void e2(@Nullable nk8 nk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, nk8Var) == null) {
            this.z = nk8Var;
        }
    }

    public final void f1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z2) == null) {
            g1(false, z2, null);
        }
    }

    public void h2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, editorTools) == null) {
            this.k = editorTools;
        }
    }

    @Nullable
    public final xk8 k0(@NonNull boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048653, this, z2)) == null) {
            xk8 xk8Var = this.J;
            if (xk8Var != null) {
                xk8Var.a = this.K;
                xk8Var.b = this.O;
                xk8Var.c = this.L;
                xk8Var.e(z2);
            }
            return this.J;
        }
        return (xk8) invokeZ.objValue;
    }

    @NonNull
    public final SkillSugRequest l0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048656, this, i2)) == null) {
            return new SkillSugRequest(i2, this.K.getUk(), K0(), S0());
        }
        return (SkillSugRequest) invokeI.objValue;
    }

    public final void m0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) && R0() != null) {
            R0().w(new q(this, z2));
        }
    }

    public boolean p1(@NonNull List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, list)) == null) {
            if (list.isEmpty()) {
                return false;
            }
            return this.R.a(list);
        }
        return invokeL.booleanValue;
    }

    public final void u2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z2) == null) {
            if (z2) {
                r0();
                Y1(true);
                L1(true);
                x0();
                return;
            }
            u0(true, 1);
            int i2 = this.a;
            if (i2 == 0) {
                Y1(false);
            } else if (i2 == 1) {
                L1(false);
            }
        }
    }

    public final void z0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.H) {
                    this.O = skillDTO;
                    return;
                }
            }
        }
    }

    public void R1(PanelType panelType, int i2) {
        ek8 ek8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048611, this, panelType, i2) == null) && (ek8Var = this.F) != null) {
            ek8Var.u(panelType, i2);
        }
    }

    public void c2(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, userDTO, skillDTO) == null) {
            this.K = userDTO;
            this.O = skillDTO;
        }
    }

    public void j2(@NonNull String str, @NonNull wk8 wk8Var) {
        fk8 fk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048652, this, str, wk8Var) == null) && (fk8Var = this.n) != null) {
            fk8Var.b(str, wk8Var);
        }
    }

    public void t2(@Nullable yk8 yk8Var, @Nullable vk8 vk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048683, this, yk8Var, vk8Var) == null) {
            this.r = yk8Var;
            this.s = vk8Var;
            dk8 dk8Var = this.p;
            if (dk8Var != null) {
                dk8Var.O(yk8Var, vk8Var);
            }
            ll8 ll8Var = this.E;
            if (ll8Var != null) {
                ll8Var.r(this.r, this.s);
            }
        }
    }

    public void w2(@NonNull String str, @NonNull ok8 ok8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048692, this, str, ok8Var) == null) {
            ik8 ik8Var = new ik8(this.c, str, "audio/amr");
            ik8Var.b(ok8Var);
            BIMManager.audioTrans(this.c, str, "audio/amr", "amr", 12, ik8Var);
        }
    }

    public void x1(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, userReplyInfoData, obj) == null) {
            this.I = obj;
            A0();
            t0(userReplyInfoData);
            g0(userReplyInfoData);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            ek8 ek8Var = this.F;
            if (ek8Var != null) {
                ek8Var.X0().setIsUseMediaPlayer(false);
                this.F.l();
            }
            dk8 dk8Var = this.p;
            if (dk8Var != null) {
                dk8Var.A();
            }
            hk8 hk8Var = this.q;
            if (hk8Var != null) {
                hk8Var.R();
            }
            ll8 ll8Var = this.E;
            if (ll8Var != null) {
                ll8Var.p();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.g0);
            MessageManager.getInstance().unRegisterListener(this.Z);
            MessageManager.getInstance().unRegisterListener(this.a0);
        }
    }

    public String H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            EditorTools editorTools = this.k;
            if (editorTools == null) {
                return "";
            }
            ke5 u2 = editorTools.u(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (u2 != null) {
                le5 le5Var = u2.m;
                if ((le5Var instanceof View) && ((View) le5Var).getVisibility() != 0) {
                    str = TbEnum.ChatInputStatus.INPUT_STATUS_VOICE;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, this.g);
            hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, str);
            return OrmObject.jsonStrWithObject((AbsMsglistView.DraftContent) OrmObject.objectWithMap(hashMap, AbsMsglistView.DraftContent.class));
        }
        return (String) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && this.K != null && this.O != null) {
            bm8.f().h(bm8.f().c(this.K.getUk(), this.O.getType(), this.K.getNameShow(), this.O.getName(), this.K.getPortrait(), this.O.getDesc(), this.O.getFuncType()));
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            A0();
            if (q1()) {
                q0();
            }
            if (o1()) {
                p0();
            }
            w0();
            hk8 hk8Var = this.q;
            if (hk8Var != null && hk8Var.M()) {
                f1(true);
            }
            d2(2, true);
            U1(true);
            V1(true);
            this.V.clear();
            this.U = false;
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048691, this) != null) || !n1()) {
            return;
        }
        e1();
        this.d.mIsFromIm = true;
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.c, this.d.toJsonString(), true, false);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setResourceType(1);
        albumFloatActivityConfig.setCanEditImage(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public final void x0() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048693, this) == null) && (groupInputTool = this.m) != null && groupInputTool.I() != null) {
            if (this.r != null && !this.m.e0() && StringUtils.isNull(this.g) && ListUtils.isNotEmpty(this.r.c())) {
                this.m.I().a(ViewState.VISIBLE);
            } else {
                this.m.I().a(ViewState.GONE);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            this.u = false;
            ek8 ek8Var = this.F;
            if (ek8Var != null) {
                ek8Var.m();
                this.F.p(this.u);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            this.u = true;
            ek8 ek8Var = this.F;
            if (ek8Var != null) {
                ek8Var.n();
                this.F.p(this.u);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            if (P0() != null && P0().R()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(Long.valueOf(this.t), H0());
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = null;
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.K(new xd5(9, -1, Boolean.TRUE));
            }
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                C1();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void D0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (skillDTO = this.O) != null && skillDTO.getItems() != null) {
            this.L.addAll(this.O.getItems());
        }
    }

    @Nullable
    public dk8 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.p;
        }
        return (dk8) invokeV.objValue;
    }

    public int I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.M;
        }
        return invokeV.intValue;
    }

    public ll8 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.E;
        }
        return (ll8) invokeV.objValue;
    }

    public final long K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            vk8 vk8Var = this.s;
            if (vk8Var != null) {
                return vk8Var.a();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            vk8 vk8Var = this.s;
            if (vk8Var != null) {
                return vk8Var.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List<InputBanData> M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.W;
        }
        return (List) invokeV.objValue;
    }

    public String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (TextUtils.isEmpty(this.g)) {
                return "";
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public GroupInputTool P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.m;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.b;
        }
        return (ToolState) invokeV.objValue;
    }

    @Nullable
    public ml8 R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.B;
        }
        return (ml8) invokeV.objValue;
    }

    public final long S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            yk8 yk8Var = this.r;
            if (yk8Var != null) {
                return yk8Var.d();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            BotSourceType botSourceType = this.Q;
            if (botSourceType == BotSourceType.DIRECT_CHAT) {
                return 6;
            }
            if (botSourceType == BotSourceType.ONE) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Nullable
    public hk8 U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.q;
        }
        return (hk8) invokeV.objValue;
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (TextUtils.isEmpty(this.i)) {
                if (TextUtils.isEmpty(this.h)) {
                    return "";
                }
                return this.h;
            }
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public nl8 W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.D;
        }
        return (nl8) invokeV.objValue;
    }

    @Nullable
    public ol8 X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.C;
        }
        return (ol8) invokeV.objValue;
    }

    @NonNull
    public zl8 Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.R;
        }
        return (zl8) invokeV.objValue;
    }

    @Nullable
    public VoiceManager Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            ek8 ek8Var = this.F;
            if (ek8Var != null) {
                return ek8Var.X0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public BotSourceType a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.Q;
        }
        return (BotSourceType) invokeV.objValue;
    }

    public void b2() {
        hk8 hk8Var;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && (hk8Var = this.q) != null && hk8Var.M() && (arrayList = (ArrayList) this.q.C()) != null) {
            this.L = arrayList;
        }
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.n != null) {
            wk8 wk8Var = new wk8();
            wk8Var.b(false);
            j2("key_emotion_tool", wk8Var);
        }
    }

    public void e1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && this.n != null) {
            wk8 wk8Var = new wk8();
            wk8Var.b(false);
            j2("key_keyboard", wk8Var);
            R1(PanelType.NONE, -10086);
        }
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && this.p == null) {
            this.p = new dk8(this.c, this);
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            ek8 ek8Var = this.F;
            if (ek8Var != null) {
                ek8Var.i();
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                groupInputTool.q0(this.d0);
            }
        }
    }

    public final void j1() {
        ml8 ml8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (ml8Var = this.B) != null) {
            ml8Var.v(new h(this));
        }
    }

    public final GroupChatRobotTopHeadView k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView U = groupInputTool.U();
            this.P = U;
            U.setEventCallback(new m(this));
            return this.P;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void l1() {
        nl8 nl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && (nl8Var = this.D) != null) {
            nl8Var.i(new j(this));
        }
    }

    public final void m1() {
        ol8 ol8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && (ol8Var = this.C) != null) {
            ol8Var.i(new i(this));
        }
    }

    public void m2() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (groupInputTool = this.m) != null && groupInputTool.V() != null) {
            this.m.V().q();
            R1(PanelType.INPUT_KEYBOARD, -10086);
        }
    }

    public boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            BdUtilHelper.showToast(this.c, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                return groupInputTool.D();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            nl8 nl8Var = this.D;
            if (nl8Var != null && nl8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        nl8 nl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && (nl8Var = this.D) != null) {
            nl8Var.k(null);
        }
    }

    public void q0() {
        ol8 ol8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && (ol8Var = this.C) != null) {
            ol8Var.j(null);
        }
    }

    public final boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            ol8 ol8Var = this.C;
            if (ol8Var != null && ol8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && R0() != null) {
            R0().w(null);
        }
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.R() && this.f1114T) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ CharSequence t1() {
        return this.g;
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            this.J.a();
            this.L.clear();
            this.K = null;
            this.O = null;
            this.I = null;
        }
    }

    public void y1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.i0(false);
        }
    }

    public void B1(l85 l85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, l85Var) == null) && l85Var != null && l85Var.c() != null && l85Var.c().getRawBitmap() != null && this.F != null) {
            Activity pageActivity = this.j.getPageActivity();
            if (this.x == null || this.F.g() == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.x = permissionJudgePolicy;
                this.F.s(permissionJudgePolicy);
            }
            this.x.clearRequestPermissionList();
            this.x.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.x.startRequestPermission(pageActivity)) {
                return;
            }
            eu5.b(new c(this, l85Var), new d(this));
        }
    }

    public void b1(List<PaddingContentData> list) {
        String type;
        AtData atData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, list) == null) && !list.isEmpty()) {
            this.V.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = "";
                if (TextUtils.isEmpty(list.get(i2).getType())) {
                    type = "";
                } else {
                    type = list.get(i2).getType();
                }
                if ("at".equals(type) && (atData = list.get(i2).getAtData()) != null) {
                    if (!TextUtils.isEmpty(atData.getAtPortrait())) {
                        str = atData.getAtPortrait();
                    }
                    this.V.add(new AtSelectData(str, atData.getAtName(), BIMManager.getBdUidFromBdUK(atData.getAtBaiduUk())));
                }
            }
        }
    }

    public final void y0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                String filePath = imageFileInfo.getFilePath();
                if (!StringUtils.isNull(imageFileInfo.getExtra())) {
                    filePath = filePath + "/" + imageFileInfo.getExtra();
                }
                Bitmap c2 = tu5.c(0, this.c, null, filePath, TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void C0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (skillDTO = this.O) != null && skillDTO.isCanKeyboardInput()) {
            if (!TextUtils.isEmpty(this.O.getKeyboardContent())) {
                P1(this.O.getKeyboardContent());
            } else {
                P1("");
            }
        }
    }

    @NonNull
    public uk8 G0() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            uk8 uk8Var = new uk8();
            uk8Var.g(S0());
            yk8 yk8Var = this.r;
            if (yk8Var != null) {
                i2 = yk8Var.a();
            } else {
                i2 = 0;
            }
            uk8Var.h(i2);
            uk8Var.e(K0());
            uk8Var.f(L0());
            return uk8Var;
        }
        return (uk8) invokeV.objValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            dk8 dk8Var = this.p;
            if (dk8Var == null || my0.h(dk8Var.v()) != 1 || !this.p.v().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (this.X == 0) {
                return q2() + this.g;
            }
            return this.g + q2();
        }
        return (String) invokeV.objValue;
    }

    public final String q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (AtSelectData atSelectData : this.V) {
                sb.append("@");
                sb.append(atSelectData.getNameShow());
                sb.append(" ");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void s2() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            cm8 cm8Var = this.o;
            int T0 = T0();
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.O;
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            String str3 = str;
            long K0 = K0();
            String L0 = L0();
            long S0 = S0();
            BotsDTO.BotListDTO.UserDTO userDTO = this.K;
            if (userDTO != null) {
                str2 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str2 = "";
            }
            cm8Var.a(2, T0, str3, K0, L0, S0, str2);
        }
    }

    public final void C1() {
        List<AtSelectData> list;
        Map<String, Integer> map;
        int i2;
        String str;
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        String str2;
        String str3;
        List<AtSelectData> t2;
        Map<String, Integer> n2;
        List<AtSelectData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!this.w) {
                i0();
                e1();
            } else if (this.z == null) {
            } else {
                b2();
                xk8 xk8Var = this.J;
                if (xk8Var != null) {
                    xk8Var.a = this.K;
                    xk8Var.b = this.O;
                    xk8Var.c = this.L;
                }
                if (this.p != null) {
                    if (o1() && (list2 = this.V) != null && list2.size() > 0) {
                        t2 = this.V;
                        this.g = p2();
                    } else {
                        t2 = this.p.t();
                    }
                    List<AtSelectData> list3 = t2;
                    if (o1() && this.p.s() != null) {
                        n2 = j0(this.g, this.V);
                    } else {
                        this.p.y();
                        n2 = this.p.n();
                    }
                    if (!ListUtils.isEmpty(this.p.t())) {
                        this.o.c(K0(), S0());
                    }
                    map = n2;
                    list = list3;
                } else {
                    list = null;
                    map = null;
                }
                if (this.P != null && (skillDTO = this.O) != null && skillDTO.getName() != null) {
                    cm8 cm8Var = this.o;
                    int T0 = T0();
                    BotsDTO.BotListDTO.SkillDTO skillDTO2 = this.O;
                    if (skillDTO2 != null) {
                        str2 = skillDTO2.getName();
                    } else {
                        str2 = StringUtil.NULL_STRING;
                    }
                    String str4 = str2;
                    long K0 = K0();
                    String L0 = L0();
                    long S0 = S0();
                    BotsDTO.BotListDTO.UserDTO userDTO = this.K;
                    if (userDTO == null) {
                        str3 = "";
                    } else {
                        str3 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    cm8Var.a(3, T0, str4, K0, L0, S0, str3);
                }
                if (q1()) {
                    i2 = 1;
                } else if (o1()) {
                    i2 = 4;
                } else if (this.J != null) {
                    if (this.I == null) {
                        i2 = 2;
                    } else {
                        i2 = 3;
                    }
                } else {
                    i2 = 0;
                }
                if (!dm8.a(this.L)) {
                    this.U = true;
                    return;
                }
                nk8 nk8Var = this.z;
                String str5 = this.g;
                if (str5 == null) {
                    str = "";
                } else {
                    str = str5;
                }
                nk8Var.m(str, this.I, this.J, list, map, i2);
                i0();
                dk8 dk8Var = this.p;
                if (dk8Var != null) {
                    dk8Var.G();
                }
            }
        }
    }

    public final void N1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (groupInputTool = this.m) != null && this.F != null) {
            this.B = groupInputTool.Q();
            if (this.m.X() != null && this.m.O() != null) {
                GroupChatUserReplyView X = this.m.X();
                GroupInputTool groupInputTool2 = this.m;
                this.C = new ol8(X, groupInputTool2, groupInputTool2.O());
            }
            if (this.m.W() != null && this.m.O() != null) {
                GroupChatUserReplyView W = this.m.W();
                GroupInputTool groupInputTool3 = this.m;
                this.D = new nl8(W, groupInputTool3, groupInputTool3.O());
            }
            MessageManager.getInstance().registerListener(this.g0);
            j1();
            m1();
            l1();
            k1();
            if (this.m.V() != null) {
                this.F.q(this.m);
                h2(this.m.V());
                if (this.m.M() != null) {
                    Z1(this.m.M());
                }
                if (this.t != 0 && !qd.isEmpty(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.t)))) {
                    H1(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.t)));
                }
                dk8 dk8Var = this.p;
                if (dk8Var != null) {
                    dk8Var.J(this.m, this.k);
                    this.p.B();
                }
            }
            this.m.p0(this.h0);
        }
    }

    public final int F0(String str, AtSelectData atSelectData, Map<String, Integer> map, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048586, this, str, atSelectData, map, i2)) == null) {
            if (!map.containsValue(Integer.valueOf(i2))) {
                return i2;
            }
            return F0(str, atSelectData, map, str.indexOf("@" + atSelectData.getNameShow(), i2 + 1));
        }
        return invokeLLLI.intValue;
    }

    public void G1(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z2)}) == null) {
            this.I = obj;
            this.K = userDTO;
            this.O = skillDTO;
            xk8 xk8Var = this.J;
            if (xk8Var != null) {
                xk8Var.d(z2);
            }
        }
    }

    public void H1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.k != null) {
                this.k.K(new xd5(6, 3, optString));
            }
            this.g = optString;
            if (TextUtils.equals(jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY), TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.k != null) {
                this.k.K(new xd5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void U1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.K() != null && (this.m.K().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.m.K().m).setNeedHideForever(z2);
            if (!z2) {
                this.m.K().m.hide();
            } else {
                this.m.K().m.display();
            }
        }
    }

    public final void s0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048678, this, str) != null) || this.D == null) {
            return;
        }
        ml8 ml8Var = this.B;
        if (ml8Var != null && ml8Var.n()) {
            this.B.w(new c0(this, str));
            return;
        }
        GroupInputTool groupInputTool = this.m;
        if (groupInputTool != null && groupInputTool.R()) {
            v1(new d0(this, str));
            return;
        }
        this.D.l(null, str);
        a2(true);
        if (q1()) {
            this.C.k(false);
            this.a = 0;
        }
    }

    public final void t0(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048681, this, userReplyInfoData) != null) || this.C == null) {
            return;
        }
        ml8 ml8Var = this.B;
        if (ml8Var != null && ml8Var.n()) {
            this.B.w(new a0(this, userReplyInfoData));
            return;
        }
        GroupInputTool groupInputTool = this.m;
        if (groupInputTool != null && groupInputTool.R()) {
            v1(new b0(this, userReplyInfoData));
            return;
        }
        this.C.l(null, userReplyInfoData);
        a2(true);
        if (o1()) {
            this.D.j(false);
            this.a = 1;
        }
    }

    public void v1(@Nullable mk8 mk8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, mk8Var) == null) {
            g1(true, false, mk8Var);
            s2();
            A0();
            w0();
            M1(false);
            cm8 cm8Var = this.o;
            long K0 = K0();
            String L0 = L0();
            long S0 = S0();
            BotsDTO.BotListDTO.UserDTO userDTO = this.K;
            if (userDTO != null) {
                str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str = "";
            }
            cm8Var.b(2, K0, L0, S0, str);
            dk8 dk8Var = this.p;
            if (dk8Var != null) {
                dk8Var.G();
            }
        }
    }

    public void I1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (groupInputTool = this.m) != null && groupInputTool.N() != null && this.m.N().i() != null && this.M == 0 && this.m.N().i().getLineCount() > 0) {
            int i2 = 5;
            if (5 > this.m.N().i().getLineCount()) {
                i2 = this.m.N().i().getLineCount();
            }
            this.M = this.m.N().i().getHeight() / i2;
        }
    }

    public final void L1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) && W0() != null) {
            if (z2) {
                if (W0().e()) {
                    W0().j(false);
                    this.a = 1;
                }
            } else if (!W0().g()) {
                W0().j(true);
            }
        }
    }

    public final void Y1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) && X0() != null) {
            if (z2) {
                if (X0().e()) {
                    X0().k(false);
                    this.a = 0;
                }
            } else if (!X0().g()) {
                X0().k(!z2);
            }
        }
    }

    public final void f2(boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048640, this, z2) != null) || this.P == null || !z2) {
            return;
        }
        BotsDTO.BotListDTO.UserDTO userDTO = this.K;
        String str3 = null;
        if (userDTO != null) {
            str = userDTO.getPortrait();
            str2 = this.K.getNameShow();
        } else {
            str = null;
            str2 = null;
        }
        BotsDTO.BotListDTO.SkillDTO skillDTO = this.O;
        if (skillDTO != null) {
            str3 = skillDTO.getName();
        }
        this.P.setData(str, str2, str3);
        this.P.setVisibility(0);
    }

    public void g0(@NonNull UserReplyInfoData userReplyInfoData) {
        dk8 dk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048641, this, userReplyInfoData) != null) || (dk8Var = this.p) == null) {
            return;
        }
        dk8Var.G();
        this.p.k(new AtSelectData(userReplyInfoData.getmPortrait(), userReplyInfoData.getmNameShow(), String.valueOf(userReplyInfoData.getmUid()), userReplyInfoData.isRobot()), false);
    }

    public void T1(BotSourceType botSourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{botSourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (q1()) {
                this.C.j(new n(this, botSourceType, z2, z3));
            } else if (o1()) {
                this.D.k(new o(this, botSourceType, z2, z3));
            } else {
                l2(botSourceType, z2, z3);
            }
        }
    }

    public final void g1(boolean z2, boolean z3, @Nullable mk8 mk8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), mk8Var}) == null) && this.q != null && this.m != null) {
            a2(true);
            if (this.m.I() != null) {
                this.m.I().c(ViewState.VISIBLE);
            }
            this.q.F(new u(this, z2, z3, mk8Var));
        }
    }

    public void g2(int i2, @NonNull Object obj, @NonNull xk8 xk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048643, this, i2, obj, xk8Var) == null) {
            this.H = i2;
            this.I = obj;
            this.K = xk8Var.a;
            if (this.N == null) {
                this.N = new ArrayList();
            }
            this.N.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = xk8Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.N.addAll(xk8Var.b.getSubSkill());
                z0(this.N);
            }
            xk8 xk8Var2 = this.J;
            if (xk8Var2 != null) {
                xk8Var2.d(xk8Var.c());
            }
        }
    }

    public void d2(int i2, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) && (groupInputTool = this.m) != null && groupInputTool.S() != null && (this.m.S().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.m.S().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.m.S().m).setSendVisibility(z2);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.m.S().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.m.S().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.m.S().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.m.S().m).setSendVisibility(true);
            }
        }
    }

    public final void n2(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048664, this, skillDTO, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.O() != null) {
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
            hk8 hk8Var = this.q;
            if (hk8Var == null) {
                hk8 hk8Var2 = new hk8(this.m.O(), this.c0, this.O, this.K);
                this.q = hk8Var2;
                hk8Var2.G(items, G0(), z2);
            } else {
                hk8Var.P(items, z2);
            }
            this.q.Y(this.l.getPageContext());
            this.q.X(this.Y);
            this.q.H(this.A);
            k0(!ListUtils.isEmpty(items));
            Object obj = this.I;
            if (obj instanceof BaseItem) {
                this.q.Z((BaseItem) obj);
            }
            this.q.a0(l0(skillDTO.getType()));
            this.q.c0(z2, !ListUtils.isEmpty(items));
        }
    }

    public final void o2(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048667, this, skillDTO, z2) == null) {
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.O() != null && !ListUtils.isEmpty(items)) {
                hk8 hk8Var = this.q;
                if (hk8Var == null) {
                    hk8 hk8Var2 = new hk8(this.m.O(), this.c0, this.O, this.K);
                    this.q = hk8Var2;
                    hk8Var2.G(items, G0(), z2);
                } else {
                    hk8Var.P(items, z2);
                }
                this.q.Y(this.l.getPageContext());
                this.q.X(this.Y);
                this.q.H(this.A);
                k0(!ListUtils.isEmpty(items));
                Object obj = this.I;
                if (obj instanceof BaseItem) {
                    this.q.Z((BaseItem) obj);
                }
                this.q.a0(l0(skillDTO.getType()));
                this.q.e0(new t(this), this.e0, z2);
            }
        }
    }

    public void u0(boolean z2, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048684, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && (groupInputTool = this.m) != null && groupInputTool.V() != null && !this.m.c0() && this.B != null) {
            if (z2) {
                this.m.V().requestFocus();
            }
            if (!this.m.V().hasFocus()) {
                return;
            }
            boolean z3 = false;
            z3 = (i2 == 3 || i2 == 2) ? true : true;
            if (i2 != 2 && i2 != 3 && (TextUtils.isEmpty(this.g) || !"/".equals(this.g))) {
                this.B.w(null);
                return;
            }
            hk8 hk8Var = this.q;
            if (hk8Var != null && hk8Var.M() && this.Q == BotSourceType.TWO) {
                return;
            }
            this.B.z(null, i2, Boolean.valueOf(z3));
        }
    }

    public void f0(@NonNull AtSelectData atSelectData, boolean z2, boolean z3) {
        dk8 dk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048638, this, new Object[]{atSelectData, Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || (dk8Var = this.p) == null) {
            return;
        }
        dk8Var.G();
        this.p.l(atSelectData, false, z2, z3);
    }

    public void i2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) {
            this.w = z2;
            if (this.k != null) {
                if (SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_audio_switch", true)) {
                    this.k.setToolEnabled(z2, 6);
                }
                this.k.K(new xd5(72, 3, Boolean.valueOf(z2)));
                if (this.k.u(37) != null && (this.k.u(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.k.u(37).m).setEnabled(z2);
                }
                if (SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_picture_switch", true) && this.k.u(38) != null && (this.k.u(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.k.u(38).m).setIconEnable(z2);
                    ((SendNoLaunchView) this.k.u(38).m).setSendInterceptToastText(this.v, z2);
                }
            }
            dk8 dk8Var = this.p;
            if (dk8Var != null) {
                dk8Var.K(z2);
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.N() != null && this.m.N().i() != null) {
                if (z2) {
                    this.m.N().i().setEnabled(true);
                    this.m.N().i().setOnClickListener(new f(this));
                    return;
                }
                this.m.N().i().setEnabled(false);
            }
        }
    }

    @NonNull
    public final Map<String, Integer> j0(@NonNull String str, @NonNull List<AtSelectData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048650, this, str, list)) == null) {
            HashMap hashMap = new HashMap();
            for (AtSelectData atSelectData : list) {
                int F0 = F0(str, atSelectData, hashMap, str.indexOf("@" + atSelectData.getNameShow()));
                if (F0 >= 0) {
                    hashMap.put(atSelectData.getUid(), Integer.valueOf(F0));
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public void v2(@NonNull String str, @NonNull lk8 lk8Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048689, this, str, lk8Var) != null) || StringUtils.isNull(str)) {
            return;
        }
        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(kd.d().c(str));
        if (reSizeBitmap != null) {
            BdImage bdImage = new BdImage(reSizeBitmap, false);
            int width = bdImage.getWidth();
            i3 = bdImage.getHeight();
            i2 = width;
        } else {
            i2 = 0;
            i3 = 0;
        }
        BIMManager.genBosObjectUrl(this.c, str, "image/jpeg", "jpg", 12, i2, i3, new l(this, lk8Var, str));
    }

    public final void l2(BotSourceType botSourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{botSourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.Q = botSourceType;
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.I() != null) {
                this.m.I().c(ViewState.GONE);
            }
            if (this.Q == BotSourceType.TWO) {
                this.h = this.g;
                GroupInputTool groupInputTool2 = this.m;
                if (groupInputTool2 != null) {
                    if (groupInputTool2.E()) {
                        m0(z3);
                        return;
                    } else if (this.m.R()) {
                        A1(z3);
                        return;
                    }
                }
            }
            k2(this.O, z2, z3);
        }
    }

    public final void r2(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.c, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void s1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048679, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.d.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                SafeHandler.getInst().postDelayed(new e(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.d;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    public void u1(int i2, int i3, @Nullable Intent intent) {
        ek8 ek8Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048685, this, i2, i3, intent) == null) && i3 == -1 && intent != null && (ek8Var = this.F) != null) {
            ek8Var.k(i2, i3, intent);
            if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
                if (i2 == 12004) {
                    boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                    intent.getStringExtra(AtListActivityConfig.CALL_AT_LIST_SOURCE);
                    ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    dk8 dk8Var = this.p;
                    if (dk8Var != null && parcelableArrayListExtra != null) {
                        dk8Var.N(parcelableArrayListExtra);
                        this.p.H(parcelableArrayListExtra, true);
                    }
                    if (this.B != null && booleanExtra) {
                        u0(false, 2);
                        return;
                    }
                    return;
                }
                return;
            }
            String stringExtra = intent.getStringExtra("file_name");
            if (stringExtra == null) {
                stringExtra = TbConfig.IMAGE_RESIZED_FILE;
                str = null;
            } else {
                str = TbConfig.LOCAL_PIC_DIR;
            }
            LocalPicModel localPicModel = this.e;
            if (localPicModel != null) {
                localPicModel.cancelLoadData();
                this.e = null;
            }
            String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra2 != null) {
                this.d.parseJson(stringExtra2);
                WriteImagesInfo writeImagesInfo = this.d;
                if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                    s1(str, stringExtra);
                    return;
                }
                LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.e = localPicModel2;
                localPicModel2.setLoadDataCallBack(this.f0);
                this.e.getData();
                return;
            }
            LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.e = localPicModel3;
            localPicModel3.setLoadDataCallBack(this.f0);
            this.e.getData();
        }
    }

    public final void z1(boolean z2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048698, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.m != null) {
            if (!this.S) {
                w0();
            }
            boolean z4 = false;
            this.S = false;
            this.m.o0(false);
            this.m.i0(false);
            if (this.Q == BotSourceType.TWO) {
                z4 = true;
            }
            if (z4 && !z3) {
                str = this.h;
            } else {
                str = this.g;
            }
            this.g = str;
            this.i = "";
            if (TextUtils.isEmpty(str)) {
                d2(2, true);
            } else {
                d2(3, true);
            }
            U1(true);
            V1(true);
            S1(true);
            a2(true);
            if (this.m.V() != null && z2) {
                this.m.V().r();
            }
            if (this.Q == BotSourceType.ONE && !TextUtils.isEmpty(this.G)) {
                Q1(this.G);
            } else if (z4) {
                if (!z3 && !TextUtils.isEmpty(this.g)) {
                    P1(this.g);
                }
                if (!TextUtils.isEmpty(this.G)) {
                    Q1(this.G);
                } else {
                    Q1(this.j.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }
}
