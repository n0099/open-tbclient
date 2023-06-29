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
import com.baidu.spswitch.utils.EmotionUbcHelper;
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
import com.baidu.tieba.ay4;
import com.baidu.tieba.b26;
import com.baidu.tieba.e26;
import com.baidu.tieba.f6a;
import com.baidu.tieba.gc8;
import com.baidu.tieba.gd5;
import com.baidu.tieba.hm5;
import com.baidu.tieba.ic8;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.in;
import com.baidu.tieba.k9;
import com.baidu.tieba.lc8;
import com.baidu.tieba.lj;
import com.baidu.tieba.mg;
import com.baidu.tieba.ni;
import com.baidu.tieba.no5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.pf;
import com.baidu.tieba.qf;
import com.baidu.tieba.r55;
import com.baidu.tieba.sx5;
import com.baidu.tieba.v98;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.ww5;
import com.baidu.tieba.wx5;
import com.baidu.tieba.yg;
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
/* loaded from: classes6.dex */
public abstract class TalkableActivity<T> extends BaseFragmentActivity implements VoiceManager.j, e26, View.OnTouchListener, BdListView.s, BdListView.p, qf, pf, r55.f, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public AbsMsglistView b;
    public MsglistModel c;
    public LocalPicModel d;
    public k9 e;
    public VoiceManager f;
    public TalkableActivity<T>.k g;
    public boolean h;
    public boolean i;
    public hm5.b<ChatMessage> j;
    public long k;
    public View l;
    public WriteImagesInfo m;
    public PermissionJudgePolicy n;
    public View o;
    public boolean p;
    public CustomMessageListener q;
    public k9 r;
    public boolean s;
    public ic8 t;

    @Override // com.baidu.tieba.e26
    public mg<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e26
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.e26
    public mg<TiebaPlusRecommendCard> G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e26
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.e26
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.e26
    public mg<RelativeLayout> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e26
    public mg<FestivalTipView> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e26
    public mg<ImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e26
    public mg<View> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e26
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.e26
    public mg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e26
    public void e0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.e26
    public void i1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.e26
    public void j0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.e26
    public mg<ItemCardView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e26
    public mg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return null;
        }
        return (mg) invokeV.objValue;
    }

    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ TalkableActivity d;

        /* loaded from: classes6.dex */
        public class a extends sx5<Object> {
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

            @Override // com.baidu.tieba.sx5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    d dVar = this.a;
                    dVar.d.A1(dVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ww5<Object> {
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

            @Override // com.baidu.tieba.ww5
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (imageFileInfo = this.a) != null && imageFileInfo.getFilePath() != null) {
                wx5.b(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class b extends k9 {
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

        @Override // com.baidu.tieba.k9
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
                this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements hm5.b<ChatMessage> {
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
        @Override // com.baidu.tieba.hm5.b
        /* renamed from: b */
        public void a(int i, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, chatMessage) == null) {
                this.a.b.updateAdapterProgress(i, chatMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b26.a)) {
                b26.a aVar = (b26.a) customResponsedMessage.getData();
                b26.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class g extends k9 {
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
        @Override // com.baidu.tieba.k9
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
                            this.a.P1();
                            break;
                        }
                        break;
                    case 4:
                        this.a.O1();
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
                this.a.z1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ic8 {
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

        @Override // com.baidu.tieba.ic8
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            this.a.s = z;
        }

        @Override // com.baidu.tieba.ic8
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TalkableActivity talkableActivity = this.a;
                if (talkableActivity.f != null && talkableActivity.D1().f()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ic8
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.D1() != null) {
                this.a.D1().cancelRecord();
            }
        }

        @Override // com.baidu.tieba.ic8
        public boolean isForeground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                return invokeV.booleanValue;
            }
            return this.a.i;
        }

        @Override // com.baidu.tieba.ic8
        public void startRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.D1() != null) {
                this.a.D1().c(this.a.b, -1);
                this.a.D1().d(lj.b);
            }
        }

        @Override // com.baidu.tieba.ic8
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.D1() != null) {
                this.a.D1().stopRecord();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends sx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd5 a;
        public final /* synthetic */ TalkableActivity b;

        public i(TalkableActivity talkableActivity, gd5 gd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, gd5Var};
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
            this.a = gd5Var;
        }

        @Override // com.baidu.tieba.sx5
        public Object doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = no5.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.A1(imageFileInfo);
                String b = no5.b.b(this.a.d());
                int i = a.a[this.a.getType().ordinal()];
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
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ww5<Object> {
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

        @Override // com.baidu.tieba.ww5
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

    /* loaded from: classes6.dex */
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
                        return this.c.getPageContext().getString(R.string.save_fail);
                    }
                    return this.c.getPageContext().getString(R.string.save_image_to_album);
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

    public void K1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || !I1()) {
            return;
        }
        this.m.mIsFromIm = true;
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.m.toJsonString(), true, false);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setResourceType(1);
        albumFloatActivityConfig.setCanEditImage(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            String beforeSendMsgText = this.b.beforeSendMsgText();
            if (TextUtils.isEmpty(beforeSendMsgText)) {
                return;
            }
            if (!beforeSendMsgText.contains("ܷ") && !beforeSendMsgText.contains("ܶ")) {
                this.b.afterSendMsgText();
                this.a.postDelayed(new f(this, beforeSendMsgText), 100L);
                return;
            }
            showToast(getResources().getString(R.string.post_char_no_support));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048622, this, i2, keyEvent)) == null) {
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

    public final void N1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.c.reSendMsg(i2);
        }
    }

    public void T1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.s = z;
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView != null) {
                absMsglistView.setRecoding(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, motionEvent)) == null) {
            if (this.s && motionEvent.getAction() == 261) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent != null) {
                this.k = intent.getLongExtra("TibaStatic.StartTime", -1L);
            } else {
                this.k = System.currentTimeMillis();
            }
            H1();
            I1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, bundle) == null) && (voiceManager = this.f) != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    public final void A1(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = ny5.c(0, getPageContext().getContext(), null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void R1(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, gd5Var) == null) && gd5Var != null && gd5Var.c() != null && gd5Var.c().p() != null) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.n == null) {
                this.n = new PermissionJudgePolicy();
            }
            this.n.clearRequestPermissionList();
            this.n.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.n.startRequestPermission(pageActivity)) {
                return;
            }
            wx5.b(new i(this, gd5Var), new j(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
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
            H1();
            I1();
            addGlobalLayoutListener();
            setSkinType(0);
        }
    }

    public String[] C1(int i2, boolean z) {
        InterceptResult invokeCommon;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 != 1) {
                if (i2 != 15) {
                    if (i2 != 17) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    switch (i2) {
                                        case 7:
                                            if (!z) {
                                                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                                            }
                                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                                            break;
                                        case 8:
                                        case 9:
                                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                                            break;
                                        case 10:
                                            if (!z) {
                                                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                                            }
                                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                                            break;
                                        case 11:
                                            if (!z) {
                                                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                                            }
                                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                                            break;
                                    }
                                } else {
                                    if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                                        string = TbadkCoreApplication.getInst().getString(R.string.group_close_receiver);
                                    } else {
                                        string = TbadkCoreApplication.getInst().getString(R.string.group_open_receiver);
                                    }
                                    arrayList.add(string);
                                    if (!z) {
                                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                                    }
                                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                                }
                            } else {
                                if (!z) {
                                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                                }
                                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f12b4));
                                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                            }
                        } else {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04de));
                            if (!z) {
                                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                            }
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                        }
                    } else {
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                    }
                } else {
                    if (!z) {
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                    }
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543));
                }
            } else {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_resend));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeCommon.objValue;
    }

    public void L1(int i2, String str) {
        in bdImage;
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, str) == null) {
            ChatMessage msg = this.c.getMsg(i2);
            if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04de))) {
                if (msg != null && msg.getCacheData() != null) {
                    ni.a(msg.getContent());
                    showToast((int) R.string.op_result_copied);
                }
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.msg_at))) {
                if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                    this.b.addAt2SendMsg(msg.getUserInfo().getUserName());
                }
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0543))) {
                View view2 = this.l;
                if ((view2 instanceof ChatVoiceView) && ((ChatVoiceView) view2).isPlaying() && (voiceManager = this.f) != null) {
                    voiceManager.stopPlay();
                }
                this.c.markDeleteMsg(i2);
                showToast((int) R.string.delete_success);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f12b4))) {
                String str2 = null;
                if (msg != null) {
                    str2 = gc8.k(msg.getContent(), true);
                }
                if (str2 == null) {
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
                if ((view3 instanceof GifView) && (bdImage = ((GifView) view3).getBdImage()) != null) {
                    TalkableActivity<T>.k kVar = new k(this, str2, bdImage.k());
                    this.g = kVar;
                    kVar.execute(new String[0]);
                }
            } else if (!str.equals(TbadkCoreApplication.getInst().getString(R.string.group_open_receiver)) && !str.equals(TbadkCoreApplication.getInst().getString(R.string.group_close_receiver))) {
                if (str.equals(TbadkCoreApplication.getInst().getString(R.string.msg_resend))) {
                    N1(i2);
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

    public void D(View view2, int i2, int i3, long j2) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        String content2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (i2 != 1) {
                if (i2 != 8) {
                    if (i2 != 15) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                switch (i2) {
                                    case 10:
                                        ChatMessage msg3 = this.c.getMsg(i3);
                                        if (msg3 == null || (content2 = msg3.getContent()) == null) {
                                            return;
                                        }
                                        try {
                                            JSONArray jSONArray = new JSONArray(content2);
                                            JSONObject optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1);
                                            if (optJSONObject != null) {
                                                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{optJSONObject.optString("shareSourceUrl")});
                                            }
                                        } catch (Exception e2) {
                                            BdLog.e(e2.toString());
                                        }
                                        lc8 lc8Var = new lc8();
                                        lc8Var.c(msg3.getContent(), getClass().getName());
                                        if (lc8Var.b() != 1 || lc8Var.a() == null) {
                                            return;
                                        }
                                        String theNewThemeId = ((ShareFromPBMsgData) lc8Var.a()).getTheNewThemeId();
                                        if (!StringUtils.isNull(theNewThemeId)) {
                                            long g2 = vg.g(theNewThemeId, 0L);
                                            if (g2 <= 0) {
                                                return;
                                            }
                                            sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), g2, ((ShareFromPBMsgData) lc8Var.a()).getImageUrl())));
                                            return;
                                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) lc8Var.a()).getThreadId())) {
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) lc8Var.a()).getThreadId(), ((ShareFromPBMsgData) lc8Var.a()).getPostId(), null)));
                                            return;
                                        } else {
                                            return;
                                        }
                                    case 11:
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                                            return;
                                        }
                                        ChatMessage msg4 = this.c.getMsg(i3);
                                        if (msg4 == null || msg4.getContent() == null) {
                                            return;
                                        }
                                        lc8 lc8Var2 = new lc8();
                                        lc8Var2.c(msg4.getContent(), getClass().getName());
                                        if (lc8Var2.b() != 1 || lc8Var2.a() == null) {
                                            return;
                                        }
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, lc8Var2));
                                        return;
                                    case 12:
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                                            return;
                                        }
                                        ChatMessage msg5 = this.c.getMsg(i3);
                                        if (msg5 == null || msg5.getContent() == null) {
                                            return;
                                        }
                                        lc8 lc8Var3 = new lc8();
                                        lc8Var3.c(msg5.getContent(), getClass().getName());
                                        if (lc8Var3.b() != 1 || lc8Var3.a() == null) {
                                            return;
                                        }
                                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{((ShareFromGameCenterMsgData) lc8Var3.a()).getShareSourceUrl()}, true);
                                        return;
                                    case 13:
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                                            return;
                                        }
                                        ChatMessage msg6 = this.c.getMsg(i3);
                                        if (msg6 == null || msg6.getContent() == null) {
                                            return;
                                        }
                                        try {
                                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{new JSONArray(msg6.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                                            return;
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                            return;
                                        }
                                    default:
                                        return;
                                }
                            } else if (!getIntent().getBooleanExtra(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, false)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                                return;
                            } else {
                                return;
                            }
                        } else if (I1() && (msg2 = this.c.getMsg(i3)) != null && !gc8.C(msg2)) {
                            return;
                        } else {
                            return;
                        }
                    }
                    ChatMessage msg7 = this.c.getMsg(i3);
                    if (msg7 == null || msg7.getContent() == null) {
                        return;
                    }
                    lc8 lc8Var4 = new lc8();
                    lc8Var4.c(msg7.getContent(), getClass().getName());
                    if (lc8Var4.b() == 4 && lc8Var4.a() != null && !StringUtils.isNull(((ShareFromFrsMsgData) lc8Var4.a()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) lc8Var4.a()).getName(), null)));
                        return;
                    }
                    return;
                }
                ChatMessage msg8 = this.c.getMsg(i3);
                if (msg8 == null || !gc8.A(msg8) || (msg = this.c.getMsg(i3)) == null || (content = msg.getContent()) == null) {
                    return;
                }
                try {
                    JSONObject optJSONObject2 = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), vg.e(optJSONObject2.optString("activityId"), 0), vg.g(optJSONObject2.optString(TbEnum.SystemMessage.KEY_GROUP_ID), 0L), 2)));
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            } else if (!v98.a(this)) {
                this.b.showDiaItemContentOperate(i3, C1(i2, this.h));
            }
        }
    }

    public f6a D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            VoiceManager voiceManager = this.f;
            if (voiceManager != null && voiceManager.getRecorderManager() != null) {
                return this.f.getRecorderManager();
            }
            return null;
        }
        return (f6a) invokeV.objValue;
    }

    public MsglistModel E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (MsglistModel) invokeV.objValue;
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e = new b(this);
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView != null) {
                absMsglistView.setVoiceTouchCallback(this.t);
            }
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f == null) {
                VoiceManager voiceManager = new VoiceManager();
                this.f = voiceManager;
                voiceManager.onCreate(getPageContext());
            }
            this.f.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
        }
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            showToast(TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c.loadPrepage();
        }
    }

    public final void N() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (voiceManager = this.f) != null) {
            voiceManager.stopPlay();
        }
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.c.saveDraft(this.b.getDraft());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.p && this.b != null) {
                Q1();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tieba.e26
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView == null) {
                return null;
            }
            return absMsglistView.getMsgListView();
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onPause();
            this.i = false;
            VoiceManager voiceManager = this.f;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onRestart();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.b.closeNewMsg();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.s
    public void onScrollToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            M1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.f;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.f;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void J1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.m.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                yg.a().postDelayed(new d(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.m;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    @Override // com.baidu.tieba.r55.f
    public void M0(r55 r55Var, int i2, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048592, this, r55Var, i2, view2) == null) && this.b.getMsgItemOperationDialog() != null && r55Var.e() == this.b.getMsgItemOperationDialog().f()) {
            int intValue = ((Integer) r55Var.e().getTag()).intValue();
            if (!(view2 instanceof TextView)) {
                return;
            }
            String charSequence = ((TextView) view2).getText().toString();
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            L1(intValue, charSequence);
            this.b.getMsgItemOperationDialog().dismiss();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048625, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast((int) R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast((int) R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    public void O1() {
        MsglistModel msglistModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (msglistModel = this.c) != null && msglistModel.getData() != null && this.c.getData().getChatMessages().size() > 0) {
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
            if (i2 >= 0 && i2 < chatMessages.size()) {
                this.c.getData().getChatMessages().remove(i2);
                AbsMsglistView absMsglistView = this.b;
                if (absMsglistView != null) {
                    absMsglistView.refreshNormal(this.c.getData());
                }
            }
        }
    }

    public void P1() {
        MsglistModel msglistModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (msglistModel = this.c) != null && msglistModel.getData() != null && this.c.getData().getChatMessages().size() > 0) {
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
            if (i2 >= 0 && i2 < chatMessages.size()) {
                this.c.getData().getChatMessages().remove(i2);
                AbsMsglistView absMsglistView = this.b;
                if (absMsglistView != null) {
                    absMsglistView.refreshNormal(this.c.getData());
                }
            }
        }
    }

    @Override // com.baidu.tieba.qf
    public void Q(View view2, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            this.l = view2;
            ChatMessage msg = this.c.getMsg(i3);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (msg != null && msg.getLocalData() != null) {
                boolean z = true;
                if (msg.getLocalData().getStatus().shortValue() != 1) {
                    if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                        if (msg.getUserInfo().getUserIdLong() != Long.parseLong(currentAccountObj.getID())) {
                            z = false;
                        }
                        this.h = z;
                    }
                    if (i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10 || i2 == 15 || i2 == 11 || i2 == 17) {
                        this.b.showDiaItemContentOperate(i3, C1(i2, this.h));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.e26
    public void Z(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048608, this, context, str, z) == null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{ay4.k(str)});
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, voiceModel)) == null) {
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView == null || absMsglistView.getMsgListView() == null || (findViewWithTag = this.b.getMsgListView().findViewWithTag(voiceModel)) == null || !(findViewWithTag instanceof VoiceManager.i)) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, view2) == null) && view2 != null && this.b != null) {
            N();
            if (view2 == this.b.getBtnBack()) {
                this.b.sendmsgCloseSoftkey();
                finish();
            } else if (view2 == this.b.getLayNewMsg()) {
                this.b.refreshGo2New(this.c.getData());
                this.b.closeNewMsg();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048618, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (intent == null) {
                    return;
                }
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
                            J1(str, stringExtra);
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
            } else if (i3 == 0) {
                if (i2 == 12010) {
                    takePhoto();
                } else if (i2 == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                    K1();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
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

    public final void takePhoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, view2, motionEvent)) == null) {
            if (view2 == this.b.getBtnSendVoice()) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.n == null) {
                    this.n = new PermissionJudgePolicy();
                }
                this.n.clearRequestPermissionList();
                this.n.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                this.n.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                if (this.n.startRequestPermission(pageActivity)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
