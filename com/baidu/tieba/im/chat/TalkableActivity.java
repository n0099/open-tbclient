package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.ap8;
import com.baidu.tieba.dh;
import com.baidu.tieba.di5;
import com.baidu.tieba.dp4;
import com.baidu.tieba.e15;
import com.baidu.tieba.gh;
import com.baidu.tieba.hi5;
import com.baidu.tieba.ih5;
import com.baidu.tieba.il5;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.j85;
import com.baidu.tieba.ja7;
import com.baidu.tieba.ll5;
import com.baidu.tieba.q9;
import com.baidu.tieba.sj;
import com.baidu.tieba.tc7;
import com.baidu.tieba.ug;
import com.baidu.tieba.ui;
import com.baidu.tieba.ui5;
import com.baidu.tieba.v95;
import com.baidu.tieba.vc7;
import com.baidu.tieba.xc7;
import com.baidu.tieba.xf;
import com.baidu.tieba.yf;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class TalkableActivity<T> extends BaseFragmentActivity implements VoiceManager.j, ll5, View.OnTouchListener, BdListView.s, BdListView.p, yf, xf, yu4.e, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public AbsMsglistView b;
    public MsglistModel c;
    public LocalPicModel d;
    public q9 e;
    public VoiceManager f;
    public TalkableActivity<T>.k g;
    public boolean h;
    public boolean i;
    public j85.b<ChatMessage> j;
    public long k;
    public View l;
    public WriteImagesInfo m;
    public PermissionJudgePolicy n;
    public View o;
    public boolean p;
    public CustomMessageListener q;
    public q9 r;
    public boolean s;
    public vc7 t;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1565992047, "Lcom/baidu/tieba/im/chat/TalkableActivity$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1565992047, "Lcom/baidu/tieba/im/chat/TalkableActivity$a;");
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

    /* loaded from: classes4.dex */
    public class b extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        public b(TalkableActivity talkableActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = talkableActivity;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    MsglistModel msglistModel = this.a.c;
                    if (msglistModel != null) {
                        msglistModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap(), responseData.getExtraMap());
                        return;
                    }
                    return;
                }
                this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e99));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements j85.b<ChatMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        public c(TalkableActivity talkableActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = talkableActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j85.b
        /* renamed from: b */
        public void a(int i, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, chatMessage) == null) {
                this.a.b.updateAdapterProgress(i, chatMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ TalkableActivity d;

        /* loaded from: classes4.dex */
        public class a extends di5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.di5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    d dVar = this.a;
                    dVar.d.V0(dVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ih5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.ih5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        d dVar = this.a;
                        dVar.d.d = new LocalPicModel(dVar.b, dVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    TalkableActivity talkableActivity = this.a.d;
                    talkableActivity.d.setLoadDataCallBack(talkableActivity.e);
                    this.a.d.d.getData();
                    this.a.d.b.hideMore();
                }
            }
        }

        public d(TalkableActivity talkableActivity, ImageFileInfo imageFileInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, imageFileInfo, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = talkableActivity;
            this.a = imageFileInfo;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageFileInfo imageFileInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (imageFileInfo = this.a) == null || imageFileInfo.getFilePath() == null) {
                return;
            }
            hi5.b(new a(this), new b(this));
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(TalkableActivity talkableActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, Integer.valueOf(i)};
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
            this.a = talkableActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof il5.a)) {
                il5.a aVar = (il5.a) customResponsedMessage.getData();
                il5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ TalkableActivity b;

        public f(TalkableActivity talkableActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = talkableActivity;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.sendTextMessage(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        public g(TalkableActivity talkableActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = talkableActivity;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
        @Override // com.baidu.tieba.q9
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(Object obj) {
            AbsMsglistView absMsglistView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    AbsMsglistView absMsglistView2 = this.a.b;
                    if (absMsglistView2 != null) {
                        absMsglistView2.displayNoNetwork();
                    }
                } else {
                    AbsMsglistView absMsglistView3 = this.a.b;
                    if (absMsglistView3 != null) {
                        absMsglistView3.hideNoNetwork();
                    }
                }
                switch (this.a.c.getLoadDataMode()) {
                    case 1:
                        if (this.a.k > -1) {
                            this.a.k = -1L;
                        }
                        AbsMsglistView absMsglistView4 = this.a.b;
                        if (absMsglistView4 != null) {
                            absMsglistView4.closeProgress();
                            TalkableActivity talkableActivity = this.a;
                            talkableActivity.b.refreshGo2New(talkableActivity.c.getData());
                            break;
                        }
                        break;
                    case 2:
                        TalkableActivity talkableActivity2 = this.a;
                        AbsMsglistView absMsglistView5 = talkableActivity2.b;
                        if (absMsglistView5 != null) {
                            absMsglistView5.refreshPrepage(talkableActivity2.c.getData());
                            break;
                        }
                        break;
                    case 3:
                        TalkableActivity talkableActivity3 = this.a;
                        AbsMsglistView absMsglistView6 = talkableActivity3.b;
                        if (absMsglistView6 != null) {
                            absMsglistView6.refreshCheckNew(talkableActivity3.c.getData());
                            this.a.m1();
                            break;
                        }
                        break;
                    case 4:
                        this.a.l1();
                        TalkableActivity talkableActivity4 = this.a;
                        absMsglistView = talkableActivity4.b;
                        if (absMsglistView != null) {
                            absMsglistView.refreshGo2New(talkableActivity4.c.getData());
                            break;
                        }
                        break;
                    case 5:
                    case 7:
                    case 8:
                    case 14:
                    case 15:
                        TalkableActivity talkableActivity5 = this.a;
                        AbsMsglistView absMsglistView7 = talkableActivity5.b;
                        if (absMsglistView7 != null) {
                            absMsglistView7.refreshNormal(talkableActivity5.c.getData());
                            break;
                        }
                        break;
                    case 6:
                        TalkableActivity talkableActivity6 = this.a;
                        AbsMsglistView absMsglistView8 = talkableActivity6.b;
                        if (absMsglistView8 != null) {
                            absMsglistView8.refreshNormal(talkableActivity6.c.getData());
                            this.a.b.setSelectionFocusDown();
                            break;
                        }
                        break;
                    case 9:
                        AbsMsglistView absMsglistView9 = this.a.b;
                        if (absMsglistView9 != null && (obj instanceof String)) {
                            String str = (String) obj;
                            absMsglistView9.setDraft(str);
                            this.a.c.setDraft(str);
                            break;
                        }
                        break;
                    case 10:
                        this.a.p = false;
                        this.a.finish();
                        break;
                    case 11:
                        AbsMsglistView absMsglistView10 = this.a.b;
                        if (absMsglistView10 != null && (obj instanceof String)) {
                            absMsglistView10.refreshHeaderFooter((String) obj, true);
                            break;
                        }
                        break;
                    case 12:
                        TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getContext())));
                        this.a.p = false;
                        this.a.finish();
                        break;
                    case 13:
                        TalkableActivity talkableActivity42 = this.a;
                        absMsglistView = talkableActivity42.b;
                        if (absMsglistView != null) {
                        }
                        break;
                }
                this.a.U0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements vc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        public h(TalkableActivity talkableActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = talkableActivity;
        }

        @Override // com.baidu.tieba.vc7
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TalkableActivity talkableActivity = this.a;
                return talkableActivity.f != null && talkableActivity.Z0().f();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vc7
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.Z0() == null) {
                return;
            }
            this.a.Z0().cancelRecord();
        }

        @Override // com.baidu.tieba.vc7
        public boolean isForeground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.i : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vc7
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.s = z;
            }
        }

        @Override // com.baidu.tieba.vc7
        public void startRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.Z0() == null) {
                return;
            }
            this.a.Z0().c(this.a.b, -1);
            this.a.Z0().d(sj.b);
        }

        @Override // com.baidu.tieba.vc7
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.Z0() == null) {
                return;
            }
            this.a.Z0().stopRecord();
        }
    }

    /* loaded from: classes4.dex */
    public class i extends di5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e15 a;
        public final /* synthetic */ TalkableActivity b;

        public i(TalkableActivity talkableActivity, e15 e15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, e15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = talkableActivity;
            this.a = e15Var;
        }

        @Override // com.baidu.tieba.di5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = v95.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.V0(imageFileInfo);
                String b = v95.b.b(this.a.d());
                int i = a.a[this.a.getType().ordinal()];
                String str = i != 1 ? i != 2 ? i != 3 ? "-1" : "3" : "2" : "1";
                HashMap hashMap = new HashMap();
                hashMap.put("meme_id", b);
                hashMap.put("meme_type", str);
                return hashMap;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ih5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        public j(TalkableActivity talkableActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = talkableActivity;
        }

        @Override // com.baidu.tieba.ih5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.d = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                if (obj instanceof Map) {
                    this.a.d.setExtraMap((Map) obj);
                }
                TalkableActivity talkableActivity = this.a;
                talkableActivity.d.setLoadDataCallBack(talkableActivity.e);
                this.a.d.getData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ TalkableActivity c;

        public k(TalkableActivity talkableActivity, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = talkableActivity;
            this.a = null;
            this.b = null;
            this.a = str;
            this.b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g = null;
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                int saveImageFileByUser = FileHelper.saveImageFileByUser(this.a, this.b, this.c.getPageContext().getPageActivity());
                if (saveImageFileByUser != -2) {
                    if (saveImageFileByUser != 0) {
                        return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a9);
                    }
                    return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10aa);
                }
                return FileHelper.getSdErrorString();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                super.onPostExecute((k) str);
                TalkableActivity talkableActivity = this.c;
                talkableActivity.g = null;
                talkableActivity.showToast(str);
            }
        }
    }

    public TalkableActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.j = null;
        this.k = -1L;
        this.m = new WriteImagesInfo(1);
        this.p = true;
        this.q = new e(this, 2001332);
        this.r = new g(this);
        this.t = new h(this);
    }

    @Override // com.baidu.tieba.ll5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ll5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ll5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ll5
    public ug<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ll5
    public ug<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ll5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ll5
    public void R(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, context, str, z) == null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{dp4.k(str)});
        }
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ll5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, context, str, str2) == null) {
        }
    }

    public final void V0(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = ui5.c(0, getPageContext().getContext(), null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 == null || FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) == null || (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) == null) {
                    return;
                }
                FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public String[] W0(int i2, boolean z) {
        InterceptResult invokeCommon;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 == 1) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0d));
            } else if (i2 == 15) {
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0a));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
            } else if (i2 == 17) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
            } else if (i2 == 3) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0452));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0a));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
            } else if (i2 == 4) {
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0a));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10a2));
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
            } else if (i2 != 5) {
                switch (i2) {
                    case 7:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0a));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
                        break;
                    case 8:
                    case 9:
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
                        break;
                    case 10:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0a));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
                        break;
                    case 11:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0a));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
                        break;
                }
            } else {
                if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f080f);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f081b);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0a));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeCommon.objValue;
    }

    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public ap8 Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            VoiceManager voiceManager = this.f;
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return this.f.getRecorderManager();
        }
        return (ap8) invokeV.objValue;
    }

    public MsglistModel a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c : (MsglistModel) invokeV.objValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.e = new b(this);
            this.b.setVoiceTouchCallback(this.t);
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f == null) {
                VoiceManager voiceManager = new VoiceManager();
                this.f = voiceManager;
                voiceManager.onCreate(getPageContext());
            }
            this.f.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
        }
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f158e));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            if (this.s && motionEvent.getAction() == 261) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ll5
    public ug<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, voiceModel)) == null) {
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView == null || absMsglistView.getMsgListView() == null || (findViewWithTag = this.b.getMsgListView().findViewWithTag(voiceModel)) == null || !(findViewWithTag instanceof VoiceManager.i)) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void f1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.m.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                gh.a().postDelayed(new d(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.m;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.p && this.b != null) {
                n1();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tieba.ll5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ll5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView == null) {
                return null;
            }
            return absMsglistView.getMsgListView();
        }
        return (ListView) invokeV.objValue;
    }

    public void h1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && d1()) {
            this.m.mIsFromIm = true;
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.m.toJsonString(), true, false);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setResourceType(1);
            albumFloatActivityConfig.setCanEditImage(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void i1(int i2, String str) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i2, str) == null) {
            ChatMessage msg = this.c.getMsg(i2);
            if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0452))) {
                if (msg == null || msg.getCacheData() == null) {
                    return;
                }
                ui.a(msg.getContent());
                showToast((int) R.string.obfuscated_res_0x7f0f0d0b);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0a))) {
                if (msg == null || msg.getUserInfo() == null || msg.getUserInfo().getUserName() == null) {
                    return;
                }
                this.b.addAt2SendMsg(msg.getUserInfo().getUserName());
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0))) {
                View view2 = this.l;
                if ((view2 instanceof ChatVoiceView) && ((ChatVoiceView) view2).isPlaying() && (voiceManager = this.f) != null) {
                    voiceManager.stopPlay();
                }
                this.c.markDeleteMsg(i2);
                showToast((int) R.string.obfuscated_res_0x7f0f04be);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10a2))) {
                String i3 = tc7.i(msg.getContent(), true);
                if (i3 == null) {
                    return;
                }
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.n == null) {
                    this.n = new PermissionJudgePolicy();
                }
                this.n.clearRequestPermissionList();
                this.n.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.n.startRequestPermission(pageActivity)) {
                    return;
                }
                View view3 = this.l;
                if (view3 instanceof GifView) {
                    TalkableActivity<T>.k kVar = new k(this, i3, ((GifView) view3).getBdImage().k());
                    this.g = kVar;
                    kVar.execute(new String[0]);
                }
            } else if (!str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f081b)) && !str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f080f))) {
                if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b0d))) {
                    k1(i2);
                }
            } else if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.f.setSpeakerphoneOn(true);
                this.b.closeReceiver();
            } else {
                TbadkCoreApplication.getInst().setHeadsetModeOn(true);
                this.f.setSpeakerphoneOn(false);
                this.b.showReceiver();
            }
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.c.loadPrepage();
        }
    }

    public final void k1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.c.reSendMsg(i2);
        }
    }

    public void l1() {
        MsglistModel msglistModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (msglistModel = this.c) == null || msglistModel.getData() == null || this.c.getData().getChatMessages().size() <= 0) {
            return;
        }
        List<ChatMessage> chatMessages = this.c.getData().getChatMessages();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= chatMessages.size()) {
                break;
            } else if (chatMessages.get(i3).getType() == ChatMessage.TYPE_MSG_ICE_BREAK) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 < 0 || i2 >= chatMessages.size()) {
            return;
        }
        this.c.getData().getChatMessages().remove(i2);
        AbsMsglistView absMsglistView = this.b;
        if (absMsglistView != null) {
            absMsglistView.refreshNormal(this.c.getData());
        }
    }

    public void m1() {
        MsglistModel msglistModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (msglistModel = this.c) == null || msglistModel.getData() == null || this.c.getData().getChatMessages().size() <= 0) {
            return;
        }
        List<ChatMessage> chatMessages = this.c.getData().getChatMessages();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= chatMessages.size()) {
                break;
            } else if (chatMessages.get(i3).getType() == ChatMessage.TYPE_MSG_STRANGER_TIP) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 < 0 || i2 >= chatMessages.size()) {
            return;
        }
        this.c.getData().getChatMessages().remove(i2);
        AbsMsglistView absMsglistView = this.b;
        if (absMsglistView != null) {
            absMsglistView.refreshNormal(this.c.getData());
        }
    }

    @Override // com.baidu.tieba.yu4.e
    public void n0(yu4 yu4Var, int i2, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048608, this, yu4Var, i2, view2) == null) && this.b.getMsgItemOperationDialog() != null && yu4Var.e() == this.b.getMsgItemOperationDialog().f()) {
            int intValue = ((Integer) yu4Var.e().getTag()).intValue();
            if (view2 instanceof TextView) {
                String charSequence = ((TextView) view2).getText().toString();
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                i1(intValue, charSequence);
                this.b.getMsgItemOperationDialog().dismiss();
            }
        }
    }

    public boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.c.saveDraft(this.b.getDraft()) : invokeV.booleanValue;
    }

    public void o1(e15 e15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, e15Var) == null) || e15Var == null || e15Var.c() == null || e15Var.c().p() == null) {
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.n == null) {
            this.n = new PermissionJudgePolicy();
        }
        this.n.clearRequestPermissionList();
        this.n.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.n.startRequestPermission(pageActivity)) {
            return;
        }
        hi5.b(new i(this, e15Var), new j(this));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 == 0) {
                    if (i2 == 12010) {
                        takePhoto();
                    } else if (i2 != 12009 || WriteImageActivityConfig.isActivityInStack) {
                    } else {
                        h1();
                    }
                }
            } else if (intent == null) {
            } else {
                if (i2 == 12010 || i2 == 12009 || i2 == 12002) {
                    String stringExtra = intent.getStringExtra("file_name");
                    if (stringExtra == null) {
                        stringExtra = TbConfig.IMAGE_RESIZED_FILE;
                        str = null;
                    } else {
                        str = TbConfig.LOCAL_PIC_DIR;
                    }
                    LocalPicModel localPicModel = this.d;
                    if (localPicModel != null) {
                        localPicModel.cancelLoadData();
                        this.d = null;
                    }
                    String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                    if (stringExtra2 != null) {
                        this.m.parseJson(stringExtra2);
                        WriteImagesInfo writeImagesInfo = this.m;
                        if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                            f1(str, stringExtra);
                            return;
                        }
                        LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.d = localPicModel2;
                        localPicModel2.setLoadDataCallBack(this.e);
                        this.d.getData();
                        this.b.hideMore();
                        return;
                    }
                    LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.d = localPicModel3;
                    localPicModel3.setLoadDataCallBack(this.e);
                    this.d.getData();
                    this.b.hideMore();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, view2) == null) || view2 == null || this.b == null) {
            return;
        }
        x();
        if (view2 == this.b.getBtnBack()) {
            this.b.sendmsgCloseSoftkey();
            finish();
        } else if (view2 == this.b.getLayNewMsg()) {
            this.b.refreshGo2New(this.c.getData());
            this.b.closeNewMsg();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackIsSupportNight(false);
            this.o = findViewById(16908290);
            Intent intent = getIntent();
            if (intent != null) {
                this.k = intent.getLongExtra("TibaStatic.StartTime", -1L);
            } else {
                this.k = System.currentTimeMillis();
            }
            this.j = new c(this);
            c1();
            d1();
            addGlobalLayoutListener();
            setSkinType(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            MsglistModel msglistModel = this.c;
            if (msglistModel != null) {
                msglistModel.onDestroy();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.f;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            if (this.g != null) {
                this.g = null;
            }
            LocalPicModel localPicModel = this.d;
            if (localPicModel != null) {
                localPicModel.cancelLoadData();
                this.d = null;
            }
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView != null) {
                absMsglistView.onDestory();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i2, keyEvent)) == null) {
            if (4 == i2) {
                AbsMsglistView absMsglistView = this.b;
                if (absMsglistView != null && absMsglistView.isMoreVisible()) {
                    this.b.hideMore();
                    return true;
                }
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent != null) {
                this.k = intent.getLongExtra("TibaStatic.StartTime", -1L);
            } else {
                this.k = System.currentTimeMillis();
            }
            c1();
            d1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPause();
            this.i = false;
            VoiceManager voiceManager = this.f;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048618, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast((int) R.string.obfuscated_res_0x7f0f1361);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast((int) R.string.obfuscated_res_0x7f0f10bd);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onRestart();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onResume();
            this.i = true;
            VoiceManager voiceManager = this.f;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
                this.f.setSpeakerphoneOn(true ^ TbadkCoreApplication.getInst().isHeadsetModeOn());
            }
            registerListener(this.q);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) || (voiceManager = this.f) == null) {
            return;
        }
        voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.b.closeNewMsg();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.s
    public void onScrollToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            j1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.f;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.f;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048626, this, view2, motionEvent)) == null) {
            if (view2 == this.b.getBtnSendVoice()) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.n == null) {
                    this.n = new PermissionJudgePolicy();
                }
                this.n.clearRequestPermissionList();
                this.n.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                this.n.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                return this.n.startRequestPermission(pageActivity);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            String beforeSendMsgText = this.b.beforeSendMsgText();
            if (TextUtils.isEmpty(beforeSendMsgText)) {
                return;
            }
            if (!beforeSendMsgText.contains("ܷ") && !beforeSendMsgText.contains("ܶ")) {
                this.b.afterSendMsgText();
                this.a.postDelayed(new f(this, beforeSendMsgText), 100L);
                return;
            }
            showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0ef0));
        }
    }

    public void q(View view2, int i2, int i3, long j2) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        String content2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (i2 == 1) {
                if (ja7.a(this)) {
                    return;
                }
                this.b.showDiaItemContentOperate(i3, W0(i2, this.h));
            } else if (i2 == 8) {
                ChatMessage msg3 = this.c.getMsg(i3);
                if (msg3 == null || !tc7.x(msg3) || (msg = this.c.getMsg(i3)) == null || (content = msg.getContent()) == null) {
                    return;
                }
                try {
                    JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), dh.e(optJSONObject.optString("activityId"), 0), dh.g(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID), 0L), 2)));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (i2 == 15) {
                ChatMessage msg4 = this.c.getMsg(i3);
                if (msg4 == null || msg4.getContent() == null) {
                    return;
                }
                xc7 xc7Var = new xc7();
                xc7Var.c(msg4.getContent(), getClass().getName());
                if (xc7Var.b() != 4 || xc7Var.a() == null || StringUtils.isNull(((ShareFromFrsMsgData) xc7Var.a()).getName())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) xc7Var.a()).getName(), null)));
            } else if (i2 == 5) {
                if (!d1() || (msg2 = this.c.getMsg(i3)) == null || tc7.z(msg2)) {
                }
            } else if (i2 != 6) {
                switch (i2) {
                    case 10:
                        ChatMessage msg5 = this.c.getMsg(i3);
                        if (msg5 == null || (content2 = msg5.getContent()) == null) {
                            return;
                        }
                        try {
                            JSONArray jSONArray = new JSONArray(content2);
                            JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                            if (optJSONObject2 != null) {
                                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                            }
                        } catch (Exception e3) {
                            BdLog.e(e3.toString());
                        }
                        xc7 xc7Var2 = new xc7();
                        xc7Var2.c(msg5.getContent(), getClass().getName());
                        if (xc7Var2.b() == 1 && xc7Var2.a() != null) {
                            String theNewThemeId = ((ShareFromPBMsgData) xc7Var2.a()).getTheNewThemeId();
                            if (!StringUtils.isNull(theNewThemeId)) {
                                long g2 = dh.g(theNewThemeId, 0L);
                                if (g2 <= 0) {
                                    return;
                                }
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), g2, ((ShareFromPBMsgData) xc7Var2.a()).getImageUrl())));
                                return;
                            } else if (StringUtils.isNull(((ShareFromPBMsgData) xc7Var2.a()).getThreadId())) {
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) xc7Var2.a()).getThreadId(), ((ShareFromPBMsgData) xc7Var2.a()).getPostId(), null)));
                                return;
                            }
                        }
                        return;
                    case 11:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f9a));
                            return;
                        }
                        ChatMessage msg6 = this.c.getMsg(i3);
                        if (msg6 == null || msg6.getContent() == null) {
                            return;
                        }
                        xc7 xc7Var3 = new xc7();
                        xc7Var3.c(msg6.getContent(), getClass().getName());
                        if (xc7Var3.b() == 1 && xc7Var3.a() != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, xc7Var3));
                            return;
                        }
                        return;
                    case 12:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f9a));
                            return;
                        }
                        ChatMessage msg7 = this.c.getMsg(i3);
                        if (msg7 == null || msg7.getContent() == null) {
                            return;
                        }
                        xc7 xc7Var4 = new xc7();
                        xc7Var4.c(msg7.getContent(), getClass().getName());
                        if (xc7Var4.b() == 1 && xc7Var4.a() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{((ShareFromGameCenterMsgData) xc7Var4.a()).getShareSourceUrl()}, true);
                            return;
                        }
                        return;
                    case 13:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f9a));
                            return;
                        }
                        ChatMessage msg8 = this.c.getMsg(i3);
                        if (msg8 == null || msg8.getContent() == null) {
                            return;
                        }
                        try {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{new JSONArray(msg8.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                            return;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } else if (getIntent().getBooleanExtra(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, false)) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
            }
        }
    }

    public void q1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.s = z;
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView != null) {
                absMsglistView.setRecoding(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f : (VoiceManager) invokeV.objValue;
    }

    public final void takePhoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.n == null) {
                this.n = new PermissionJudgePolicy();
            }
            Activity pageActivity = getPageContext().getPageActivity();
            this.n.clearRequestPermissionList();
            this.n.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.n.startRequestPermission(pageActivity)) {
                return;
            }
            SelectImageHelper.takePhoto(getPageContext());
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<GifView> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public final void x() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (voiceManager = this.f) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void y(View view2, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            this.l = view2;
            ChatMessage msg = this.c.getMsg(i3);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (msg == null || msg.getLocalData() == null) {
                return;
            }
            if (msg.getLocalData().getStatus().shortValue() == 1) {
                return;
            }
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.h = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10 || i2 == 15 || i2 == 11 || i2 == 17) {
                this.b.showDiaItemContentOperate(i3, W0(i2, this.h));
            }
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ll5
    public ug<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }
}
