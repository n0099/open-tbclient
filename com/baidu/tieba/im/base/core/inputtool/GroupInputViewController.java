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
import com.baidu.tieba.ad8;
import com.baidu.tieba.adc;
import com.baidu.tieba.cd8;
import com.baidu.tieba.cdc;
import com.baidu.tieba.ce8;
import com.baidu.tieba.cy5;
import com.baidu.tieba.dd8;
import com.baidu.tieba.de8;
import com.baidu.tieba.di;
import com.baidu.tieba.dx5;
import com.baidu.tieba.ed8;
import com.baidu.tieba.ee8;
import com.baidu.tieba.fd8;
import com.baidu.tieba.fe8;
import com.baidu.tieba.gd8;
import com.baidu.tieba.hp5;
import com.baidu.tieba.i31;
import com.baidu.tieba.i9;
import com.baidu.tieba.id5;
import com.baidu.tieba.ij5;
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
import com.baidu.tieba.jj5;
import com.baidu.tieba.ld8;
import com.baidu.tieba.md8;
import com.baidu.tieba.nd8;
import com.baidu.tieba.od8;
import com.baidu.tieba.pd8;
import com.baidu.tieba.qe8;
import com.baidu.tieba.ry5;
import com.baidu.tieba.se8;
import com.baidu.tieba.sf8;
import com.baidu.tieba.te8;
import com.baidu.tieba.tf8;
import com.baidu.tieba.uc8;
import com.baidu.tieba.ue8;
import com.baidu.tieba.vc8;
import com.baidu.tieba.wc8;
import com.baidu.tieba.wi5;
import com.baidu.tieba.xh;
import com.baidu.tieba.xi5;
import com.baidu.tieba.yc8;
import com.baidu.tieba.yx5;
import com.baidu.tieba.zc8;
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
    public sf8 A;
    public de8 B;
    public fe8 C;
    public ee8 D;
    public ce8 E;
    public vc8 F;
    public String G;
    public int H;
    public Object I;
    public od8 J;
    public BotsDTO.BotListDTO.UserDTO K;
    public List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> L;
    public List<BotsDTO.BotListDTO.SkillDTO> M;
    public BotsDTO.BotListDTO.SkillDTO N;
    public GroupChatRobotTopHeadView O;
    public BotSourceType P;
    @NonNull
    public qe8 Q;
    public boolean R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1112T;
    public List<AtSelectData> U;
    public List<InputBanData> V;
    public int W;
    @Nullable
    public tf8 X;
    public final CustomMessageListener Y;
    public final CustomMessageListener Z;
    public int a;
    public xi5 a0;
    public ToolState b;
    public yc8.m b0;
    @Nullable
    public Context c;
    public final gd8 c0;
    public WriteImagesInfo d;
    public yc8.l d0;
    public LocalPicModel e;
    public final i9 e0;
    public View f;
    public final CustomMessageListener f0;
    public String g;
    public String h;
    public String i;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> j;
    public EditorTools k;
    @NonNull
    public final InputToolFragment l;
    @Nullable
    public final GroupInputTool m;
    public wc8 n;
    public te8 o;
    @Nullable
    public uc8 p;
    @Nullable
    public yc8 q;
    @Nullable
    public pd8 r;
    @Nullable
    public md8 s;
    public final long t;
    public boolean u;
    public String v;
    public boolean w;
    public PermissionJudgePolicy x;
    public boolean y;
    @Nullable
    public ed8 z;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
        }
    }

    public void F1(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i2) == null) {
        }
    }

    public boolean t0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048683, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
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
        public class a extends yx5<Object> {
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

            @Override // com.baidu.tieba.yx5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    e eVar = this.a;
                    eVar.d.w0(eVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements dx5<Object> {
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

            @Override // com.baidu.tieba.dx5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.e = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        e eVar = this.a;
                        eVar.d.e = new LocalPicModel(eVar.b, eVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    this.a.d.e.setLoadDataCallBack(this.a.d.e0);
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
                cy5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements de8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        /* loaded from: classes6.dex */
        public class a implements de8.d {
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

            @Override // com.baidu.tieba.de8.d
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.P1(BotSourceType.ONE, false, false);
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

        @Override // com.baidu.tieba.de8.f
        public void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, userDTO, skillDTO) == null) && userDTO != null && skillDTO != null) {
                this.a.Y1(userDTO, skillDTO);
                this.a.f0();
                if (this.a.z != null) {
                    if (skillDTO.isFuncJump() && skillDTO.getAbilityItem() != null) {
                        this.a.z.p(skillDTO.getAbilityItem());
                        this.a.b1();
                        this.a.a1();
                        return;
                    } else if (skillDTO.isFuncSendMsg() && !TextUtils.isEmpty(userDTO.getUk())) {
                        this.a.z.k(userDTO.getUk(), skillDTO.getType());
                        this.a.O0().v(null);
                        this.a.b1();
                        this.a.a1();
                        return;
                    }
                }
                this.a.y0();
                this.a.I1(true);
                if (this.a.O0() != null) {
                    this.a.O0().v(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements IGenBosObjectUrlListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd8 a;
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
                cd8 cd8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (cd8Var = this.b.a) != null) {
                    cd8Var.a(i, i2, str);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onFinished(int i, String str) {
                cd8 cd8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (cd8Var = this.b.a) != null) {
                    cd8Var.c(i, str, this.a);
                }
            }

            @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
            public void onProgress(int i) {
                cd8 cd8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (cd8Var = this.b.a) != null) {
                    cd8Var.b(i);
                }
            }
        }

        public l(GroupInputViewController groupInputViewController, cd8 cd8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, cd8Var, str};
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
            this.a = cd8Var;
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
                    if (di.isEmpty(str4) || di.isEmpty(str5) || di.isEmpty(str6)) {
                        cd8 cd8Var = this.a;
                        if (cd8Var != null) {
                            cd8Var.a(i, 1, this.b);
                            return;
                        }
                        return;
                    }
                    this.c.n2(1, str4, str5, this.b, "image/jpeg", str2, str3, new a(this, str6));
                    return;
                }
                this.a.a(i, 1, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements yc8.l {
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

        @Override // com.baidu.tieba.yc8.l
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.m != null && this.a.m.H() != null && z) {
                this.a.m.H().a(ViewState.INVISIBLE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements dd8 {
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

        @Override // com.baidu.tieba.dd8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.C.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends i9 {
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

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof LocalPicModel.ResponseData) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    String str = responseData.getBitmap().getWidth() + "," + responseData.getBitmap().getHeight();
                    String sPathGen = responseData.getSPathGen();
                    if (this.a.o1() && this.a.q != null && !StringUtils.isNull(sPathGen)) {
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
    public class b0 implements de8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ GroupInputViewController b;

        public b0(GroupInputViewController groupInputViewController, String str) {
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

        @Override // com.baidu.tieba.de8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.D.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends yx5<Map<String, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id5 a;
        public final /* synthetic */ GroupInputViewController b;

        public c(GroupInputViewController groupInputViewController, id5 id5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, id5Var};
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
            this.a = id5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yx5
        /* renamed from: a */
        public Map<String, Object> doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = hp5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.w0(imageFileInfo);
                String b = hp5.b.b(this.a.d());
                int i = w.a[this.a.getType().ordinal()];
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
    public class c0 implements dd8 {
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

        @Override // com.baidu.tieba.dd8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.D.l(null, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dx5<Map<String, Object>> {
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
        @Override // com.baidu.tieba.dx5
        /* renamed from: a */
        public void onReturnDataInUI(Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                this.a.e = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.a.e.setExtraMap(map);
                this.a.e.setLoadDataCallBack(this.a.e0);
                this.a.e.getData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements gd8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        @Override // com.baidu.tieba.gd8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public d0(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.gd8
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null && !StringUtils.isNull(voiceModel.getVoiceId()) && this.a.z != null) {
                this.a.z.c(voiceModel.getVoiceId(), voiceModel.getDuration());
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
                if (this.a.l.E != null) {
                    this.a.l.E.c();
                }
                this.a.m.f0(false);
                this.a.N1(PanelType.INPUT_KEYBOARD);
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
                    if (!this.a.l0()) {
                        this.a.s0(true, 1);
                    }
                }
                if (!booleanValue && this.a.E != null) {
                    this.a.E.l();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements fe8.e {
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

        @Override // com.baidu.tieba.fe8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            if (this.a.m.H() != null) {
                this.a.m.H().c(ViewState.GONE);
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.M1(groupInputViewController.j.getString(R.string.im_msg_input_hint));
            this.a.O1(false);
            this.a.m.B(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.fe8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.M1(groupInputViewController.G);
            this.a.O1(true);
            this.a.m.w(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.fe8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.o0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ee8.e {
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

        @Override // com.baidu.tieba.ee8.e
        public void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            if (this.a.m.H() != null) {
                this.a.m.H().c(ViewState.GONE);
            }
            this.a.O1(false);
            this.a.m.B(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.ee8.e
        public void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter, Boolean.valueOf(z)}) != null) || this.a.m == null) {
                return;
            }
            GroupInputViewController groupInputViewController = this.a;
            groupInputViewController.M1(groupInputViewController.G);
            this.a.O1(true);
            this.a.m.w(i, i2, j, animatorListenerAdapter, z);
        }

        @Override // com.baidu.tieba.ee8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.n0();
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
                this.a.q2(booleanValue);
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
                groupInputViewController.M1(groupInputViewController.G);
                this.a.s1(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements fe8.d {
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

        @Override // com.baidu.tieba.fe8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.h2(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ee8.d {
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

        @Override // com.baidu.tieba.ee8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.h2(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class p implements dd8 {
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

        @Override // com.baidu.tieba.dd8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.g2(groupInputViewController.N, false, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements de8.d {
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

        @Override // com.baidu.tieba.de8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupInputViewController groupInputViewController = this.b;
                groupInputViewController.g2(groupInputViewController.N, false, this.a);
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
                this.a.c1(false);
                this.a.y0();
                this.a.o2();
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
                this.a.d1(true, false, null);
                this.a.o2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements yc8.k {
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

        @Override // com.baidu.tieba.yc8.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z1();
                if (this.a.f1112T) {
                    return;
                }
                this.a.d1(true, true, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ dd8 c;
        public final /* synthetic */ GroupInputViewController d;

        public u(GroupInputViewController groupInputViewController, boolean z, boolean z2, dd8 dd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputViewController, Boolean.valueOf(z), Boolean.valueOf(z2), dd8Var};
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
            this.c = dd8Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.d.w1(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.d.w1(this.a, this.b);
            dd8 dd8Var = this.c;
            if (dd8Var != null) {
                dd8Var.a();
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
                this.a.S = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class w {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(225244000, "Lcom/baidu/tieba/im/base/core/inputtool/GroupInputViewController$w;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(225244000, "Lcom/baidu/tieba/im/base/core/inputtool/GroupInputViewController$w;");
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
    public class x implements xi5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputViewController a;

        public x(GroupInputViewController groupInputViewController) {
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

        @Override // com.baidu.tieba.xi5
        public void O(wi5 wi5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, wi5Var) != null) || wi5Var == null) {
                return;
            }
            int i = wi5Var.a;
            if (i != 5 && i != 64) {
                if (i == 24) {
                    Object obj = wi5Var.c;
                    if (obj instanceof id5) {
                        id5 id5Var = (id5) obj;
                        if (id5Var.getType() != EmotionGroupType.LOCAL) {
                            this.a.y1(id5Var);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i == 8) {
                    this.a.z1();
                    if (this.a.f1112T) {
                        return;
                    }
                    this.a.c1(true);
                    return;
                } else if (i == 4) {
                    Object obj2 = wi5Var.c;
                    if (obj2 instanceof String) {
                        this.a.g = (String) obj2;
                        this.a.s0(false, 1);
                        this.a.E.n(100L);
                        return;
                    }
                    return;
                } else if (i == 14) {
                    this.a.t1();
                    return;
                } else if (i != 17) {
                    if (i == 62) {
                        boolean booleanValue = ((Boolean) wi5Var.c).booleanValue();
                        if (this.a.m == null) {
                            return;
                        }
                        this.a.m.f0(booleanValue);
                        if (booleanValue) {
                            this.a.p0();
                        } else {
                            this.a.s0(true, 1);
                        }
                        if (booleanValue) {
                            this.a.N1(PanelType.EXPRESSION);
                        } else {
                            this.a.N1(PanelType.INPUT_KEYBOARD);
                        }
                        if (!this.a.m.a0() || this.a.N0() != ToolState.TEXT) {
                            return;
                        }
                        this.a.U1(false);
                        this.a.H1(false);
                        return;
                    } else if (i == 63) {
                        boolean booleanValue2 = ((Boolean) wi5Var.c).booleanValue();
                        if (this.a.m == null) {
                            return;
                        }
                        if (booleanValue2) {
                            this.a.N1(PanelType.NONE);
                        } else {
                            this.a.N1(PanelType.INPUT_KEYBOARD);
                        }
                        this.a.m.f0(false);
                        return;
                    } else if (i == 80 && !this.a.m.a0()) {
                        this.a.N1(PanelType.NONE);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.a.N1(PanelType.INPUT_KEYBOARD);
        }
    }

    /* loaded from: classes6.dex */
    public class y implements yc8.m {
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

        @Override // com.baidu.tieba.yc8.m
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.b2(z);
        }
    }

    /* loaded from: classes6.dex */
    public class z implements de8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserReplyInfoData a;
        public final /* synthetic */ GroupInputViewController b;

        public z(GroupInputViewController groupInputViewController, UserReplyInfoData userReplyInfoData) {
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

        @Override // com.baidu.tieba.de8.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.C.l(null, this.a);
            }
        }
    }

    public GroupInputViewController(@NonNull InputToolFragment inputToolFragment, @Nullable tf8 tf8Var, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputToolFragment, tf8Var, Long.valueOf(j2)};
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
        this.J = new od8();
        this.L = new ArrayList();
        this.O = null;
        this.S = false;
        this.f1112T = false;
        this.U = new ArrayList();
        this.V = new ArrayList();
        this.W = 0;
        this.Y = new k(this, 2921790);
        this.Z = new v(this, 2921800);
        this.a0 = new x(this);
        this.b0 = new y(this);
        this.c0 = new d0(this);
        this.d0 = new a(this);
        this.e0 = new b(this);
        this.f0 = new g(this, 2921785);
        this.t = j2;
        this.l = inputToolFragment;
        this.j = inputToolFragment.getPageContext();
        this.c = this.l.getContext();
        this.X = tf8Var;
        this.m = this.l.o2();
        vc8 vc8Var = new vc8(inputToolFragment);
        this.F = vc8Var;
        vc8Var.o(this.a0);
        this.Q = new ad8(this);
        this.E = new ce8(this, this.j, new cdc() { // from class: com.baidu.tieba.tc8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.cdc
            public final Object call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? GroupInputViewController.this.q1() : invokeV.objValue;
            }
        }, tf8Var);
        e1();
        J1();
        f1();
        MessageManager.getInstance().registerListener(this.Y);
        MessageManager.getInstance().registerListener(this.Z);
        yc8 yc8Var = this.q;
        if (yc8Var != null) {
            yc8Var.b0(this.d0);
        }
        this.n = new wc8(this);
        this.o = new te8();
    }

    public final void g2(BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2, boolean z3) {
        BotsDTO.BotListDTO.SkillDTO skillDTO2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{skillDTO, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (skillDTO != null) {
                skillDTO2 = skillDTO.copy();
            } else {
                skillDTO2 = null;
            }
            if (this.m != null && skillDTO2 != null) {
                boolean z5 = false;
                if (this.P == BotSourceType.TWO) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.m.E(true);
                this.m.F(!z4);
                String str = "";
                if (skillDTO2.getKeyboard() == 1) {
                    if (!TextUtils.isEmpty(skillDTO2.getKeyboardContent())) {
                        L1(skillDTO2.getKeyboardContent());
                    } else {
                        L1("");
                    }
                    if (!TextUtils.isEmpty(skillDTO2.getExp())) {
                        M1(skillDTO2.getExp());
                    } else if (z4) {
                        M1(this.j.getString(R.string.obfuscated_res_0x7f0f096e));
                    }
                    Z1(1, !TextUtils.isEmpty(this.g));
                    Q1(false);
                    R1(false);
                    O1(false);
                    this.m.l0(new r(this));
                    if (this.m.T() != null) {
                        GroupInputTool groupInputTool = this.m;
                        if (skillDTO2.getKeyboardType() == 1) {
                            z5 = true;
                        }
                        groupInputTool.g0(z5);
                        i2();
                    }
                    j2(skillDTO2, z3);
                } else {
                    if (this.m.T() != null) {
                        this.m.T().q();
                    }
                    this.m.l0(new s(this));
                    k2(skillDTO2, z3);
                }
                te8 te8Var = this.o;
                int Q0 = Q0();
                String name = skillDTO2.getName();
                long H0 = H0();
                String I0 = I0();
                long P0 = P0();
                BotsDTO.BotListDTO.UserDTO userDTO = this.K;
                if (userDTO != null) {
                    str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                }
                te8Var.a(1, Q0, name, H0, I0, P0, str);
            }
        }
    }

    public void A1(sf8 sf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sf8Var) == null) {
            this.A = sf8Var;
        }
    }

    public void B1(BotsDTO botsDTO) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, botsDTO) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.e0(botsDTO);
        }
    }

    public void C1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.G = str;
        }
    }

    public void G1(List<InputBanData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.V = list;
        }
    }

    public final void I1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z2) != null) || (groupInputTool = this.m) == null) {
            return;
        }
        if (z2) {
            groupInputTool.j0(1);
        } else {
            groupInputTool.j0(0);
        }
    }

    public void K1(String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && (editorTools = this.k) != null) {
            editorTools.D(new wi5(75, 3, str));
        }
    }

    public void L1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.g = str;
            if (!TextUtils.isEmpty(str)) {
                this.i = str;
            }
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.D(new wi5(6, 3, str));
            }
        }
    }

    public void M1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.v = str;
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.D(new wi5(71, 3, StringHelper.cutChineseAndEnglishWithEmoji(str, 28, "...")));
            }
        }
    }

    public void N1(PanelType panelType) {
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, panelType) == null) && (vc8Var = this.F) != null) {
            vc8Var.u(panelType);
        }
    }

    public void O1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z2) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.k0(z2);
        }
    }

    public void R1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) && this.k.o(6) != null) {
            if (!z2) {
                this.k.o(6).hide();
            } else {
                this.k.o(6).display();
            }
        }
    }

    public void S1(adc<PanelType, PanelType, Float, Float> adcVar) {
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, adcVar) == null) && (vc8Var = this.F) != null) {
            vc8Var.r(adcVar);
        }
    }

    public void T1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.W = i2;
        }
    }

    public void V1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
            this.f = view2;
        }
    }

    public final void W1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.H() != null) {
            this.m.H().d(z2);
        }
    }

    public void Z0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            y0();
            q0(str);
        }
    }

    public void a2(@Nullable ed8 ed8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, ed8Var) == null) {
            this.z = ed8Var;
        }
    }

    public final void c1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) {
            d1(false, z2, null);
        }
    }

    public void d2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, editorTools) == null) {
            this.k = editorTools;
        }
    }

    @Nullable
    public final od8 i0(@NonNull boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z2)) == null) {
            od8 od8Var = this.J;
            if (od8Var != null) {
                od8Var.a = this.K;
                od8Var.b = this.N;
                od8Var.c = this.L;
                od8Var.e(z2);
            }
            return this.J;
        }
        return (od8) invokeZ.objValue;
    }

    @NonNull
    public final SkillSugRequest j0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i2)) == null) {
            return new SkillSugRequest(i2, this.K.getUk(), H0(), P0());
        }
        return (SkillSugRequest) invokeI.objValue;
    }

    public final void k0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z2) == null) && O0() != null) {
            O0().v(new q(this, z2));
        }
    }

    public boolean m1(@NonNull List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, list)) == null) {
            if (list.isEmpty()) {
                return false;
            }
            return this.Q.a(list);
        }
        return invokeL.booleanValue;
    }

    public final void q2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z2) == null) {
            if (z2) {
                p0();
                U1(true);
                H1(true);
                v0();
                return;
            }
            s0(true, 1);
            int i2 = this.a;
            if (i2 == 0) {
                U1(false);
            } else if (i2 == 1) {
                H1(false);
            }
        }
    }

    public final void x0(@NonNull List<BotsDTO.BotListDTO.SkillDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, list) == null) {
            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list) {
                if (skillDTO != null && skillDTO.getType() == this.H) {
                    this.N = skillDTO;
                    return;
                }
            }
        }
    }

    public final void x1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z2) == null) {
            this.R = true;
            d1(true, false, new p(this, z2));
        }
    }

    public void Y1(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, userDTO, skillDTO) == null) {
            this.K = userDTO;
            this.N = skillDTO;
        }
    }

    public void f2(@NonNull String str, @NonNull nd8 nd8Var) {
        wc8 wc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048642, this, str, nd8Var) == null) && (wc8Var = this.n) != null) {
            wc8Var.b(str, nd8Var);
        }
    }

    public void p2(@Nullable pd8 pd8Var, @Nullable md8 md8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048673, this, pd8Var, md8Var) == null) {
            this.r = pd8Var;
            this.s = md8Var;
            uc8 uc8Var = this.p;
            if (uc8Var != null) {
                uc8Var.O(pd8Var, md8Var);
            }
            ce8 ce8Var = this.E;
            if (ce8Var != null) {
                ce8Var.r(this.r, this.s);
            }
        }
    }

    public void s2(@NonNull String str, @NonNull fd8 fd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048682, this, str, fd8Var) == null) {
            zc8 zc8Var = new zc8(this.c, str, "audio/amr");
            zc8Var.b(fd8Var);
            BIMManager.audioTrans(this.c, str, "audio/amr", "amr", 12, zc8Var);
        }
    }

    public void u1(@NonNull UserReplyInfoData userReplyInfoData, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048686, this, userReplyInfoData, obj) == null) {
            this.I = obj;
            y0();
            r0(userReplyInfoData);
            e0(userReplyInfoData);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            vc8 vc8Var = this.F;
            if (vc8Var != null) {
                vc8Var.P0().setIsUseMediaPlayer(false);
                this.F.l();
            }
            uc8 uc8Var = this.p;
            if (uc8Var != null) {
                uc8Var.A();
            }
            yc8 yc8Var = this.q;
            if (yc8Var != null) {
                yc8Var.R();
            }
            ce8 ce8Var = this.E;
            if (ce8Var != null) {
                ce8Var.p();
            }
            VoiceManager.setIsNeedBlackScreen(true);
            MessageManager.getInstance().unRegisterListener(this.f0);
            MessageManager.getInstance().unRegisterListener(this.Y);
            MessageManager.getInstance().unRegisterListener(this.Z);
        }
    }

    public String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            EditorTools editorTools = this.k;
            if (editorTools == null) {
                return "";
            }
            ij5 p2 = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p2 != null) {
                jj5 jj5Var = p2.m;
                if ((jj5Var instanceof View) && ((View) jj5Var).getVisibility() != 0) {
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

    public final void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.K != null && this.N != null) {
            se8.f().h(se8.f().c(this.K.getUk(), this.N.getType(), this.K.getNameShow(), this.N.getName(), this.K.getPortrait(), this.N.getDesc(), this.N.getFuncType()));
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            y0();
            if (n1()) {
                o0();
            }
            if (l1()) {
                n0();
            }
            u0();
            yc8 yc8Var = this.q;
            if (yc8Var != null && yc8Var.M()) {
                c1(true);
            }
            Z1(2, true);
            Q1(true);
            R1(true);
            this.U.clear();
            this.f1112T = false;
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048684, this) != null) || !k1()) {
            return;
        }
        b1();
        this.d.mIsFromIm = true;
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.c, this.d.toJsonString(), true, false);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setResourceType(1);
        albumFloatActivityConfig.setCanEditImage(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public final void v0() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && (groupInputTool = this.m) != null && groupInputTool.H() != null) {
            if (this.r != null && !this.m.c0() && StringUtils.isNull(this.g) && ListUtils.isNotEmpty(this.r.c())) {
                this.m.H().a(ViewState.VISIBLE);
            } else {
                this.m.H().a(ViewState.GONE);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.u = false;
            vc8 vc8Var = this.F;
            if (vc8Var != null) {
                vc8Var.m();
                this.F.p(this.u);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            this.u = true;
            vc8 vc8Var = this.F;
            if (vc8Var != null) {
                vc8Var.n();
                this.F.p(this.u);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            if (M0() != null && M0().P()) {
                return;
            }
            TbSingleton.getInstance().setRoomDraft(Long.valueOf(this.t), F0());
        }
    }

    public void B0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (skillDTO = this.N) != null && skillDTO.getItems() != null) {
            this.L.addAll(this.N.getItems());
        }
    }

    @Nullable
    public uc8 C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return (uc8) invokeV.objValue;
    }

    public ce8 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.E;
        }
        return (ce8) invokeV.objValue;
    }

    public final long H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            md8 md8Var = this.s;
            if (md8Var != null) {
                return md8Var.a();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            md8 md8Var = this.s;
            if (md8Var != null) {
                return md8Var.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List<InputBanData> J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.V;
        }
        return (List) invokeV.objValue;
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (TextUtils.isEmpty(this.g)) {
                return "";
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public GroupInputTool M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.m;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    public ToolState N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.b;
        }
        return (ToolState) invokeV.objValue;
    }

    @Nullable
    public de8 O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.B;
        }
        return (de8) invokeV.objValue;
    }

    public final long P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            pd8 pd8Var = this.r;
            if (pd8Var != null) {
                return pd8Var.d();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            BotSourceType botSourceType = this.P;
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
    public yc8 R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.q;
        }
        return (yc8) invokeV.objValue;
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
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

    public ee8 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.D;
        }
        return (ee8) invokeV.objValue;
    }

    @Nullable
    public fe8 U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.C;
        }
        return (fe8) invokeV.objValue;
    }

    @NonNull
    public qe8 V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.Q;
        }
        return (qe8) invokeV.objValue;
    }

    @Nullable
    public VoiceManager W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            vc8 vc8Var = this.F;
            if (vc8Var != null) {
                return vc8Var.P0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public BotSourceType X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.P;
        }
        return (BotSourceType) invokeV.objValue;
    }

    public void X1() {
        yc8 yc8Var;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (yc8Var = this.q) != null && yc8Var.M() && (arrayList = (ArrayList) this.q.C()) != null) {
            this.L = arrayList;
        }
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.n != null) {
            nd8 nd8Var = new nd8();
            nd8Var.b(false);
            f2("key_emotion_tool", nd8Var);
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.n != null) {
            nd8 nd8Var = new nd8();
            nd8Var.b(false);
            f2("key_keyboard", nd8Var);
            N1(PanelType.NONE);
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && this.p == null) {
            this.p = new uc8(this.c, this);
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            vc8 vc8Var = this.F;
            if (vc8Var != null) {
                vc8Var.i();
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                groupInputTool.n0(this.c0);
            }
        }
    }

    public final void g1() {
        de8 de8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (de8Var = this.B) != null) {
            de8Var.u(new h(this));
        }
    }

    public final GroupChatRobotTopHeadView h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool == null) {
                return null;
            }
            GroupChatRobotTopHeadView S = groupInputTool.S();
            this.O = S;
            S.setEventCallback(new m(this));
            return this.O;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public final void i1() {
        ee8 ee8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && (ee8Var = this.D) != null) {
            ee8Var.i(new j(this));
        }
    }

    public void i2() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (groupInputTool = this.m) != null && groupInputTool.T() != null) {
            this.m.T().l();
            N1(PanelType.INPUT_KEYBOARD);
        }
    }

    public final void j1() {
        fe8 fe8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && (fe8Var = this.C) != null) {
            fe8Var.i(new i(this));
        }
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            BdUtilHelper.showToast(this.c, TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            ee8 ee8Var = this.D;
            if (ee8Var != null && ee8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null) {
                return groupInputTool.C();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0() {
        ee8 ee8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048664, this) == null) && (ee8Var = this.D) != null) {
            ee8Var.k(null);
        }
    }

    public final boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            fe8 fe8Var = this.C;
            if (fe8Var != null && fe8Var.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o0() {
        fe8 fe8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && (fe8Var = this.C) != null) {
            fe8Var.j(null);
        }
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.P() && this.S) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048671, this) == null) && O0() != null) {
            O0().v(null);
        }
    }

    public /* synthetic */ CharSequence q1() {
        return this.g;
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            this.J.a();
            this.L.clear();
            this.K = null;
            this.N = null;
            this.I = null;
        }
    }

    public void v1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048688, this) == null) && (groupInputTool = this.m) != null) {
            groupInputTool.g0(false);
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            this.g = null;
            EditorTools editorTools = this.k;
            if (editorTools != null) {
                editorTools.D(new wi5(9, -1, Boolean.TRUE));
            }
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            try {
                z1();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void A0() {
        BotsDTO.BotListDTO.SkillDTO skillDTO;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (skillDTO = this.N) != null && skillDTO.isCanKeyboardInput()) {
            if (!TextUtils.isEmpty(this.N.getKeyboardContent())) {
                L1(this.N.getKeyboardContent());
            } else {
                L1("");
            }
        }
    }

    @NonNull
    public ld8 E0() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ld8 ld8Var = new ld8();
            ld8Var.g(P0());
            pd8 pd8Var = this.r;
            if (pd8Var != null) {
                i2 = pd8Var.a();
            } else {
                i2 = 0;
            }
            ld8Var.h(i2);
            ld8Var.e(H0());
            ld8Var.f(I0());
            return ld8Var;
        }
        return (ld8) invokeV.objValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            uc8 uc8Var = this.p;
            if (uc8Var == null || i31.h(uc8Var.v()) != 1 || !this.p.v().get(0).isRobot()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.W == 0) {
                return m2() + this.g;
            }
            return this.g + m2();
        }
        return (String) invokeV.objValue;
    }

    public final String m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (AtSelectData atSelectData : this.U) {
                sb.append("@");
                sb.append(atSelectData.getNameShow());
                sb.append(" ");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void o2() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            te8 te8Var = this.o;
            int Q0 = Q0();
            BotsDTO.BotListDTO.SkillDTO skillDTO = this.N;
            if (skillDTO != null) {
                str = skillDTO.getName();
            } else {
                str = StringUtil.NULL_STRING;
            }
            String str3 = str;
            long H0 = H0();
            String I0 = I0();
            long P0 = P0();
            BotsDTO.BotListDTO.UserDTO userDTO = this.K;
            if (userDTO != null) {
                str2 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str2 = "";
            }
            te8Var.a(2, Q0, str3, H0, I0, P0, str2);
        }
    }

    public final int D0(String str, AtSelectData atSelectData, Map<String, Integer> map, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048582, this, str, atSelectData, map, i2)) == null) {
            if (!map.containsValue(Integer.valueOf(i2))) {
                return i2;
            }
            return D0(str, atSelectData, map, str.indexOf("@" + atSelectData.getNameShow(), i2 + 1));
        }
        return invokeLLLI.intValue;
    }

    public void D1(@Nullable Object obj, @Nullable BotsDTO.BotListDTO.UserDTO userDTO, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{obj, userDTO, skillDTO, Boolean.valueOf(z2)}) == null) {
            this.I = obj;
            this.K = userDTO;
            this.N = skillDTO;
            od8 od8Var = this.J;
            if (od8Var != null) {
                od8Var.d(z2);
            }
        }
    }

    public void E1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.k != null) {
                this.k.D(new wi5(6, 3, optString));
            }
            this.g = optString;
            if (TextUtils.equals(jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY), TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.k != null) {
                this.k.D(new wi5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void Q1(boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.I() != null && (this.m.I().m instanceof EmotionNoLaunchView)) {
            ((EmotionNoLaunchView) this.m.I().m).setNeedHideForever(z2);
            if (!z2) {
                this.m.I().m.hide();
            } else {
                this.m.I().m.display();
            }
        }
    }

    public final void q0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048674, this, str) != null) || this.D == null) {
            return;
        }
        de8 de8Var = this.B;
        if (de8Var != null && de8Var.m()) {
            this.B.v(new b0(this, str));
            return;
        }
        GroupInputTool groupInputTool = this.m;
        if (groupInputTool != null && groupInputTool.P()) {
            s1(new c0(this, str));
            return;
        }
        this.D.l(null, str);
        W1(true);
        if (n1()) {
            this.C.k(false);
            this.a = 0;
        }
    }

    public final void r0(@NonNull UserReplyInfoData userReplyInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048677, this, userReplyInfoData) != null) || this.C == null) {
            return;
        }
        de8 de8Var = this.B;
        if (de8Var != null && de8Var.m()) {
            this.B.v(new z(this, userReplyInfoData));
            return;
        }
        GroupInputTool groupInputTool = this.m;
        if (groupInputTool != null && groupInputTool.P()) {
            s1(new a0(this, userReplyInfoData));
            return;
        }
        this.C.l(null, userReplyInfoData);
        W1(true);
        if (l1()) {
            this.D.j(false);
            this.a = 1;
        }
    }

    public void s1(@Nullable dd8 dd8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, dd8Var) == null) {
            d1(true, false, dd8Var);
            o2();
            y0();
            u0();
            I1(false);
            te8 te8Var = this.o;
            long H0 = H0();
            String I0 = I0();
            long P0 = P0();
            BotsDTO.BotListDTO.UserDTO userDTO = this.K;
            if (userDTO != null) {
                str = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            } else {
                str = "";
            }
            te8Var.b(2, H0, I0, P0, str);
            uc8 uc8Var = this.p;
            if (uc8Var != null) {
                uc8Var.G();
            }
        }
    }

    public final void H1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) && T0() != null) {
            if (z2) {
                if (T0().e()) {
                    T0().j(false);
                    this.a = 1;
                }
            } else if (!T0().g()) {
                T0().j(true);
            }
        }
    }

    public final void U1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z2) == null) && U0() != null) {
            if (z2) {
                if (U0().e()) {
                    U0().k(false);
                    this.a = 0;
                }
            } else if (!U0().g()) {
                U0().k(!z2);
            }
        }
    }

    public final void b2(boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048631, this, z2) != null) || this.O == null || !z2) {
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
        BotsDTO.BotListDTO.SkillDTO skillDTO = this.N;
        if (skillDTO != null) {
            str3 = skillDTO.getName();
        }
        this.O.setData(str, str2, str3);
        this.O.setVisibility(0);
    }

    public void e0(@NonNull UserReplyInfoData userReplyInfoData) {
        uc8 uc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048637, this, userReplyInfoData) != null) || (uc8Var = this.p) == null) {
            return;
        }
        uc8Var.G();
        this.p.k(new AtSelectData(userReplyInfoData.getmPortrait(), userReplyInfoData.getmNameShow(), String.valueOf(userReplyInfoData.getmUid()), userReplyInfoData.isRobot()), false);
    }

    public final void J1() {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (groupInputTool = this.m) != null && this.F != null) {
            this.B = groupInputTool.O();
            if (this.m.V() != null && this.m.M() != null) {
                GroupChatUserReplyView V = this.m.V();
                GroupInputTool groupInputTool2 = this.m;
                this.C = new fe8(V, groupInputTool2, groupInputTool2.M());
            }
            if (this.m.U() != null && this.m.M() != null) {
                GroupChatUserReplyView U = this.m.U();
                GroupInputTool groupInputTool3 = this.m;
                this.D = new ee8(U, groupInputTool3, groupInputTool3.M());
            }
            MessageManager.getInstance().registerListener(this.f0);
            g1();
            j1();
            i1();
            h1();
            if (this.m.T() != null) {
                this.F.q(this.m);
                d2(this.m.T());
                if (this.m.K() != null) {
                    V1(this.m.K());
                }
                if (this.t != 0 && !di.isEmpty(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.t)))) {
                    E1(TbSingleton.getInstance().getRoomDraft(Long.valueOf(this.t)));
                }
                uc8 uc8Var = this.p;
                if (uc8Var != null) {
                    uc8Var.J(this.m, this.k);
                    this.p.B();
                }
            }
        }
    }

    public final void z1() {
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
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            if (!this.w) {
                g0();
                b1();
            } else if (this.z == null) {
            } else {
                X1();
                od8 od8Var = this.J;
                if (od8Var != null) {
                    od8Var.a = this.K;
                    od8Var.b = this.N;
                    od8Var.c = this.L;
                }
                if (this.p != null) {
                    if (l1() && (list2 = this.U) != null && list2.size() > 0) {
                        t2 = this.U;
                        this.g = l2();
                    } else {
                        t2 = this.p.t();
                    }
                    List<AtSelectData> list3 = t2;
                    if (l1() && this.p.s() != null) {
                        n2 = h0(this.g, this.U);
                    } else {
                        this.p.y();
                        n2 = this.p.n();
                    }
                    if (!ListUtils.isEmpty(this.p.t())) {
                        this.o.c(H0(), P0());
                    }
                    map = n2;
                    list = list3;
                } else {
                    list = null;
                    map = null;
                }
                if (this.O != null && (skillDTO = this.N) != null && skillDTO.getName() != null) {
                    te8 te8Var = this.o;
                    int Q0 = Q0();
                    BotsDTO.BotListDTO.SkillDTO skillDTO2 = this.N;
                    if (skillDTO2 != null) {
                        str2 = skillDTO2.getName();
                    } else {
                        str2 = StringUtil.NULL_STRING;
                    }
                    String str4 = str2;
                    long H0 = H0();
                    String I0 = I0();
                    long P0 = P0();
                    BotsDTO.BotListDTO.UserDTO userDTO = this.K;
                    if (userDTO == null) {
                        str3 = "";
                    } else {
                        str3 = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                    }
                    te8Var.a(3, Q0, str4, H0, I0, P0, str3);
                }
                if (n1()) {
                    i2 = 1;
                } else if (l1()) {
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
                if (!ue8.a(this.L)) {
                    this.f1112T = true;
                    return;
                }
                ed8 ed8Var = this.z;
                String str5 = this.g;
                if (str5 == null) {
                    str = "";
                } else {
                    str = str5;
                }
                ed8Var.n(str, this.I, this.J, list, map, i2);
                g0();
                uc8 uc8Var = this.p;
                if (uc8Var != null) {
                    uc8Var.G();
                }
            }
        }
    }

    public void P1(BotSourceType botSourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{botSourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (n1()) {
                this.C.j(new n(this, botSourceType, z2, z3));
            } else if (l1()) {
                this.D.k(new o(this, botSourceType, z2, z3));
            } else {
                h2(botSourceType, z2, z3);
            }
        }
    }

    public void c2(int i2, @NonNull Object obj, @NonNull od8 od8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048633, this, i2, obj, od8Var) == null) {
            this.H = i2;
            this.I = obj;
            this.K = od8Var.a;
            if (this.M == null) {
                this.M = new ArrayList();
            }
            this.M.clear();
            BotsDTO.BotListDTO.SkillDTO skillDTO = od8Var.b;
            if (skillDTO != null && !ListUtils.isEmpty(skillDTO.getSubSkill())) {
                this.M.addAll(od8Var.b.getSubSkill());
                x0(this.M);
            }
            od8 od8Var2 = this.J;
            if (od8Var2 != null) {
                od8Var2.d(od8Var.c());
            }
        }
    }

    public final void d1(boolean z2, boolean z3, @Nullable dd8 dd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dd8Var}) == null) && this.q != null && this.m != null) {
            W1(true);
            if (this.m.H() != null) {
                this.m.H().c(ViewState.VISIBLE);
            }
            this.q.F(new u(this, z2, z3, dd8Var));
        }
    }

    public void Y0(List<PaddingContentData> list) {
        String type;
        AtData atData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, list) == null) && !list.isEmpty()) {
            this.U.clear();
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
                    this.U.add(new AtSelectData(str, atData.getAtName(), BIMManager.getBdUidFromBdUK(atData.getAtBaiduUk())));
                }
            }
        }
    }

    public final void w0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, imageFileInfo) == null) {
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
                Bitmap c2 = ry5.c(0, this.c, null, filePath, TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void y1(id5 id5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048694, this, id5Var) == null) && id5Var != null && id5Var.c() != null && id5Var.c().getRawBitmap() != null && this.F != null) {
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
            cy5.b(new c(this, id5Var), new d(this));
        }
    }

    public void Z1(int i2, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) && (groupInputTool = this.m) != null && groupInputTool.Q() != null && (this.m.Q().m instanceof SendNoLaunchView)) {
            if (i2 == 1) {
                ((SendNoLaunchView) this.m.Q().m).setIsSendIcon(true);
                ((SendNoLaunchView) this.m.Q().m).setSendVisibility(z2);
            } else if (i2 == 2) {
                ((SendNoLaunchView) this.m.Q().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.m.Q().m).setSendVisibility(false);
            } else if (i2 == 3) {
                ((SendNoLaunchView) this.m.Q().m).setIsSendIcon(false);
                ((SendNoLaunchView) this.m.Q().m).setSendVisibility(true);
            }
        }
    }

    public final void j2(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048654, this, skillDTO, z2) == null) && (groupInputTool = this.m) != null && groupInputTool.M() != null) {
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
            yc8 yc8Var = this.q;
            if (yc8Var == null) {
                yc8 yc8Var2 = new yc8(this.m.M(), this.b0, this.N, this.K);
                this.q = yc8Var2;
                yc8Var2.G(items, E0(), z2);
            } else {
                yc8Var.P(items, z2);
            }
            this.q.Y(this.l.getPageContext());
            this.q.X(this.X);
            this.q.H(this.A);
            i0(!ListUtils.isEmpty(items));
            Object obj = this.I;
            if (obj instanceof BaseItem) {
                this.q.Z((BaseItem) obj);
            }
            this.q.a0(j0(skillDTO.getType()));
            this.q.c0(z2, !ListUtils.isEmpty(items));
        }
    }

    public final void k2(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048657, this, skillDTO, z2) == null) {
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> items = skillDTO.getItems();
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.M() != null && !ListUtils.isEmpty(items)) {
                yc8 yc8Var = this.q;
                if (yc8Var == null) {
                    yc8 yc8Var2 = new yc8(this.m.M(), this.b0, this.N, this.K);
                    this.q = yc8Var2;
                    yc8Var2.G(items, E0(), z2);
                } else {
                    yc8Var.P(items, z2);
                }
                this.q.Y(this.l.getPageContext());
                this.q.X(this.X);
                this.q.H(this.A);
                i0(!ListUtils.isEmpty(items));
                Object obj = this.I;
                if (obj instanceof BaseItem) {
                    this.q.Z((BaseItem) obj);
                }
                this.q.a0(j0(skillDTO.getType()));
                this.q.e0(new t(this), this.d0, z2);
            }
        }
    }

    public void s0(boolean z2, int i2) {
        GroupInputTool groupInputTool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048680, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && (groupInputTool = this.m) != null && groupInputTool.T() != null && !this.m.a0() && this.B != null) {
            if (z2) {
                this.m.T().requestFocus();
            }
            if (!this.m.T().hasFocus()) {
                return;
            }
            boolean z3 = false;
            z3 = (i2 == 3 || i2 == 2) ? true : true;
            if (i2 != 2 && i2 != 3 && (TextUtils.isEmpty(this.g) || !"/".equals(this.g))) {
                this.B.v(null);
                return;
            }
            yc8 yc8Var = this.q;
            if (yc8Var != null && yc8Var.M() && this.P == BotSourceType.TWO) {
                return;
            }
            this.B.y(null, i2, Boolean.valueOf(z3));
        }
    }

    public void d0(@NonNull AtSelectData atSelectData, boolean z2, boolean z3) {
        uc8 uc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048634, this, new Object[]{atSelectData, Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || (uc8Var = this.p) == null) {
            return;
        }
        uc8Var.G();
        this.p.l(atSelectData, false, z2, z3);
    }

    public void e2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z2) == null) {
            this.w = z2;
            if (this.k != null) {
                if (SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_audio_switch", true)) {
                    this.k.setToolEnabled(z2, 6);
                }
                this.k.D(new wi5(72, 3, Boolean.valueOf(z2)));
                if (this.k.p(37) != null && (this.k.p(37).m instanceof EmotionNoLaunchView)) {
                    ((EmotionNoLaunchView) this.k.p(37).m).setEnabled(z2);
                }
                if (SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_picture_switch", true) && this.k.p(38) != null && (this.k.p(38).m instanceof SendNoLaunchView)) {
                    ((SendNoLaunchView) this.k.p(38).m).setIconEnable(z2);
                    ((SendNoLaunchView) this.k.p(38).m).setSendInterceptToastText(this.v, z2);
                }
            }
            uc8 uc8Var = this.p;
            if (uc8Var != null) {
                uc8Var.K(z2);
            }
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.L() != null && this.m.L().g() != null) {
                if (z2) {
                    this.m.L().g().setEnabled(true);
                    this.m.L().g().setOnClickListener(new f(this));
                    return;
                }
                this.m.L().g().setEnabled(false);
            }
        }
    }

    @NonNull
    public final Map<String, Integer> h0(@NonNull String str, @NonNull List<AtSelectData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048646, this, str, list)) == null) {
            HashMap hashMap = new HashMap();
            for (AtSelectData atSelectData : list) {
                int D0 = D0(str, atSelectData, hashMap, str.indexOf("@" + atSelectData.getNameShow()));
                if (D0 >= 0) {
                    hashMap.put(atSelectData.getUid(), Integer.valueOf(D0));
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public void r2(@NonNull String str, @NonNull cd8 cd8Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048679, this, str, cd8Var) != null) || StringUtils.isNull(str)) {
            return;
        }
        Bitmap reSizeBitmap = PicManager.getInstance().getReSizeBitmap(xh.d().c(str));
        if (reSizeBitmap != null) {
            BdImage bdImage = new BdImage(reSizeBitmap, false);
            int width = bdImage.getWidth();
            i3 = bdImage.getHeight();
            i2 = width;
        } else {
            i2 = 0;
            i3 = 0;
        }
        BIMManager.genBosObjectUrl(this.c, str, "image/jpeg", "jpg", 12, i2, i3, new l(this, cd8Var, str));
    }

    public final void h2(BotSourceType botSourceType, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{botSourceType, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.P = botSourceType;
            GroupInputTool groupInputTool = this.m;
            if (groupInputTool != null && groupInputTool.H() != null) {
                this.m.H().c(ViewState.GONE);
            }
            if (this.P == BotSourceType.TWO) {
                this.h = this.g;
                GroupInputTool groupInputTool2 = this.m;
                if (groupInputTool2 != null) {
                    if (groupInputTool2.D()) {
                        k0(z3);
                        return;
                    } else if (this.m.P()) {
                        x1(z3);
                        return;
                    }
                }
            }
            g2(this.N, z2, z3);
        }
    }

    public final void n2(int i2, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5, str6, iUploadTransferListener}) == null) {
            new AsyncUploadTask(this.c, i2, str, str2, str3, str4, str5, str6, iUploadTransferListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void p1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048672, this, str, str2) == null) {
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

    public void r1(int i2, int i3, @Nullable Intent intent) {
        vc8 vc8Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048678, this, i2, i3, intent) == null) && i3 == -1 && intent != null && (vc8Var = this.F) != null) {
            vc8Var.k(i2, i3, intent);
            if (i2 != 12010 && i2 != 12009 && i2 != 12002) {
                if (i2 == 12004) {
                    boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_AT_SELECT_BOT_DATA, false);
                    intent.getStringExtra(AtListActivityConfig.CALL_AT_LIST_SOURCE);
                    ArrayList<AtSelectData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    uc8 uc8Var = this.p;
                    if (uc8Var != null && parcelableArrayListExtra != null) {
                        uc8Var.N(parcelableArrayListExtra);
                        this.p.H(parcelableArrayListExtra, true);
                    }
                    if (this.B != null && booleanExtra) {
                        s0(false, 2);
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
                    p1(str, stringExtra);
                    return;
                }
                LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.e = localPicModel2;
                localPicModel2.setLoadDataCallBack(this.e0);
                this.e.getData();
                return;
            }
            LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            this.e = localPicModel3;
            localPicModel3.setLoadDataCallBack(this.e0);
            this.e.getData();
        }
    }

    public final void w1(boolean z2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048690, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.m != null) {
            if (!this.R) {
                u0();
            }
            boolean z4 = false;
            this.R = false;
            this.m.m0(false);
            this.m.g0(false);
            if (this.P == BotSourceType.TWO) {
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
                Z1(2, true);
            } else {
                Z1(3, true);
            }
            Q1(true);
            R1(true);
            O1(true);
            W1(true);
            if (this.m.T() != null && z2) {
                this.m.T().m();
            }
            if (this.P == BotSourceType.ONE && !TextUtils.isEmpty(this.G)) {
                M1(this.G);
            } else if (z4) {
                if (!z3 && !TextUtils.isEmpty(this.g)) {
                    L1(this.g);
                }
                if (!TextUtils.isEmpty(this.G)) {
                    M1(this.G);
                } else {
                    M1(this.j.getString(R.string.im_msg_input_hint));
                }
            }
        }
    }
}
