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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a77;
import com.repackage.a9;
import com.repackage.ag;
import com.repackage.ai;
import com.repackage.c77;
import com.repackage.cd5;
import com.repackage.cw4;
import com.repackage.ef;
import com.repackage.ff;
import com.repackage.i45;
import com.repackage.jg;
import com.repackage.ji;
import com.repackage.mc5;
import com.repackage.mg;
import com.repackage.oq4;
import com.repackage.pc5;
import com.repackage.se5;
import com.repackage.si8;
import com.repackage.tb5;
import com.repackage.ve5;
import com.repackage.w25;
import com.repackage.y67;
import com.repackage.yi;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements VoiceManager.j, ve5, View.OnTouchListener, BdListView.s, BdListView.p, ff, ef, oq4.e, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View contentView;
    public Handler handler;
    public boolean isForeground;
    public boolean isNeedSaveDraft;
    public boolean mIsCurrentUser;
    public View mLastLongClickItem;
    public MsglistModel mListModel;
    public AbsMsglistView mListView;
    public LocalPicModel mLocalPicModel;
    public a9 mLocalPicModelCallback;
    public a9 mMsgCallback;
    public PermissionJudgePolicy mPermissionJudgement;
    public boolean mRecording;
    public TalkableActivity<T>.k mSaveImageTask;
    public a77 mSendCallBack;
    public w25.b<ChatMessage> mUploadProgressCallback;
    public VoiceManager mVoiceManager;
    public long preTime;
    public CustomMessageListener richTextIntentClickListener;
    public WriteImagesInfo writeImagesInfo;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    MsglistModel msglistModel = this.a.mListModel;
                    if (msglistModel != null) {
                        msglistModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap(), responseData.getExtraMap());
                        return;
                    }
                    return;
                }
                this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e61));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w25.b<ChatMessage> {
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
        @Override // com.repackage.w25.b
        /* renamed from: b */
        public void a(int i, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, chatMessage) == null) {
                this.a.mListView.updateAdapterProgress(i, chatMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ TalkableActivity d;

        /* loaded from: classes3.dex */
        public class a extends mc5<Object> {
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

            @Override // com.repackage.mc5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    d dVar = this.a;
                    dVar.d.dealImageForSend(dVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements tb5<Object> {
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

            @Override // com.repackage.tb5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.mLocalPicModel = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        d dVar = this.a;
                        dVar.d.mLocalPicModel = new LocalPicModel(dVar.b, dVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    TalkableActivity talkableActivity = this.a.d;
                    talkableActivity.mLocalPicModel.setLoadDataCallBack(talkableActivity.mLocalPicModelCallback);
                    this.a.d.mLocalPicModel.getData();
                    this.a.d.mListView.hideMore();
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
            pc5.b(new a(this), new b(this));
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof se5.a)) {
                se5.a aVar = (se5.a) customResponsedMessage.getData();
                se5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.b.mListModel.sendTextMessage(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends a9 {
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
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
        @Override // com.repackage.a9
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(Object obj) {
            AbsMsglistView absMsglistView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!ji.z()) {
                    AbsMsglistView absMsglistView2 = this.a.mListView;
                    if (absMsglistView2 != null) {
                        absMsglistView2.displayNoNetwork();
                    }
                } else {
                    AbsMsglistView absMsglistView3 = this.a.mListView;
                    if (absMsglistView3 != null) {
                        absMsglistView3.hideNoNetwork();
                    }
                }
                switch (this.a.mListModel.getLoadDataMode()) {
                    case 1:
                        if (this.a.preTime > -1) {
                            this.a.preTime = -1L;
                        }
                        AbsMsglistView absMsglistView4 = this.a.mListView;
                        if (absMsglistView4 != null) {
                            absMsglistView4.closeProgress();
                            TalkableActivity talkableActivity = this.a;
                            talkableActivity.mListView.refreshGo2New(talkableActivity.mListModel.getData());
                            break;
                        }
                        break;
                    case 2:
                        TalkableActivity talkableActivity2 = this.a;
                        AbsMsglistView absMsglistView5 = talkableActivity2.mListView;
                        if (absMsglistView5 != null) {
                            absMsglistView5.refreshPrepage(talkableActivity2.mListModel.getData());
                            break;
                        }
                        break;
                    case 3:
                        TalkableActivity talkableActivity3 = this.a;
                        AbsMsglistView absMsglistView6 = talkableActivity3.mListView;
                        if (absMsglistView6 != null) {
                            absMsglistView6.refreshCheckNew(talkableActivity3.mListModel.getData());
                            break;
                        }
                        break;
                    case 4:
                        this.a.removeIceBreakMsg();
                        TalkableActivity talkableActivity4 = this.a;
                        absMsglistView = talkableActivity4.mListView;
                        if (absMsglistView != null) {
                            absMsglistView.refreshGo2New(talkableActivity4.mListModel.getData());
                            break;
                        }
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 14:
                    case 15:
                        TalkableActivity talkableActivity5 = this.a;
                        AbsMsglistView absMsglistView7 = talkableActivity5.mListView;
                        if (absMsglistView7 != null) {
                            absMsglistView7.refreshNormal(talkableActivity5.mListModel.getData());
                            break;
                        }
                        break;
                    case 9:
                        AbsMsglistView absMsglistView8 = this.a.mListView;
                        if (absMsglistView8 != null && (obj instanceof String)) {
                            String str = (String) obj;
                            absMsglistView8.setDraft(str);
                            this.a.mListModel.setDraft(str);
                            break;
                        }
                        break;
                    case 10:
                        this.a.isNeedSaveDraft = false;
                        this.a.finish();
                        break;
                    case 11:
                        AbsMsglistView absMsglistView9 = this.a.mListView;
                        if (absMsglistView9 != null && (obj instanceof String)) {
                            absMsglistView9.refreshHeaderFooter((String) obj, true);
                            break;
                        }
                        break;
                    case 12:
                        TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getContext())));
                        this.a.isNeedSaveDraft = false;
                        this.a.finish();
                        break;
                    case 13:
                        TalkableActivity talkableActivity42 = this.a;
                        absMsglistView = talkableActivity42.mListView;
                        if (absMsglistView != null) {
                        }
                        break;
                }
                this.a.afterDataSet();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a77 {
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

        @Override // com.repackage.a77
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TalkableActivity talkableActivity = this.a;
                return talkableActivity.mVoiceManager != null && talkableActivity.getRecorderManager().f();
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.a77
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.isForeground : invokeV.booleanValue;
        }

        @Override // com.repackage.a77
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.getRecorderManager() == null) {
                return;
            }
            this.a.getRecorderManager().cancelRecord();
        }

        @Override // com.repackage.a77
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.mRecording = z;
            }
        }

        @Override // com.repackage.a77
        public void startRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.getRecorderManager() == null) {
                return;
            }
            this.a.getRecorderManager().c(this.a.mListView, -1);
            this.a.getRecorderManager().d(yi.b);
        }

        @Override // com.repackage.a77
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.getRecorderManager() == null) {
                return;
            }
            this.a.getRecorderManager().stopRecord();
        }
    }

    /* loaded from: classes3.dex */
    public class i extends mc5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cw4 a;
        public final /* synthetic */ TalkableActivity b;

        public i(TalkableActivity talkableActivity, cw4 cw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, cw4Var};
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
            this.a = cw4Var;
        }

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String d = i45.b.d(this.a.d(), true);
                boolean exists = new File(d).exists();
                if (!exists) {
                    d = d.replace(".gif", ".jpg");
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(d);
                imageFileInfo.setIsGif(exists);
                this.b.dealImageForSend(imageFileInfo);
                String b = i45.b.b(this.a.d());
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

    /* loaded from: classes3.dex */
    public class j implements tb5<Object> {
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

        @Override // com.repackage.tb5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.mLocalPicModel = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                if (obj instanceof Map) {
                    this.a.mLocalPicModel.setExtraMap((Map) obj);
                }
                TalkableActivity talkableActivity = this.a;
                talkableActivity.mLocalPicModel.setLoadDataCallBack(talkableActivity.mLocalPicModelCallback);
                this.a.mLocalPicModel.getData();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.c.mSaveImageTask = null;
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
                        return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1091);
                    }
                    return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1092);
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
                talkableActivity.mSaveImageTask = null;
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
        this.handler = new Handler();
        this.mListView = null;
        this.mListModel = null;
        this.mLocalPicModel = null;
        this.mLocalPicModelCallback = null;
        this.mSaveImageTask = null;
        this.mUploadProgressCallback = null;
        this.preTime = -1L;
        this.writeImagesInfo = new WriteImagesInfo(1);
        this.isNeedSaveDraft = true;
        this.richTextIntentClickListener = new e(this, 2001332);
        this.mMsgCallback = new g(this);
        this.mSendCallBack = new h(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealImageForSend(ImageFileInfo imageFileInfo) {
        Bitmap resizeBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, imageFileInfo) == null) {
            try {
                if (imageFileInfo.isGif()) {
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE);
                    FileHelper.saveGifByRelativePath(imageFileInfo.getFilePath(), null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    return;
                }
                Bitmap c2 = cd5.c(0, getPageContext().getContext(), null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 == null || FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) == null || (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) == null) {
                    return;
                }
                FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void deleteMsg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            this.mListModel.deleteMsg(i2);
        }
    }

    private void initVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.mVoiceManager == null) {
                VoiceManager voiceManager = new VoiceManager();
                this.mVoiceManager = voiceManager;
                voiceManager.onCreate(getPageContext());
            }
            this.mVoiceManager.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
        }
    }

    private void iteratorImageForSend(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, str, str2) == null) {
            Iterator<ImageFileInfo> it = this.writeImagesInfo.getChosedFiles().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2++;
                mg.a().postDelayed(new d(this, it.next(), str, str2), 100 * j2);
            }
            WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo.clear();
            }
        }
    }

    private void prepage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mListModel.loadPrepage();
        }
    }

    private void reSendMsg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i2) == null) {
            this.mListModel.reSendMsg(i2);
        }
    }

    private void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    private void takePhoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            Activity pageActivity = getPageContext().getPageActivity();
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return;
            }
            SelectImageHelper.takePhoto(getPageContext());
        }
    }

    public void afterDataSet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.mRecording && motionEvent.getAction() == 261) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.isNeedSaveDraft && this.mListView != null) {
                saveDraft();
            }
            super.finish();
        }
    }

    public String[] getDialogOperationItems(int i2, boolean z) {
        InterceptResult invokeCommon;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 == 1) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aef));
            } else if (i2 == 15) {
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aec));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
            } else if (i2 == 17) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
            } else if (i2 == 3) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f044a));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aec));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
            } else if (i2 == 4) {
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aec));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f108c));
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
            } else if (i2 != 5) {
                switch (i2) {
                    case 7:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aec));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
                        break;
                    case 8:
                    case 9:
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
                        break;
                    case 10:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aec));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
                        break;
                    case 11:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aec));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
                        break;
                }
            } else {
                if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e5);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07f1);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aec));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeCommon.objValue;
    }

    @Override // com.repackage.ve5
    public ag<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AbsMsglistView absMsglistView = this.mListView;
            if (absMsglistView == null) {
                return null;
            }
            return absMsglistView.getMsgListView();
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, voiceModel)) == null) {
            AbsMsglistView absMsglistView = this.mListView;
            if (absMsglistView == null || absMsglistView.getMsgListView() == null || (findViewWithTag = this.mListView.getMsgListView().findViewWithTag(voiceModel)) == null || !(findViewWithTag instanceof VoiceManager.i)) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public si8 getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return this.mVoiceManager.getRecorderManager();
        }
        return (si8) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ve5
    public ag<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public void initCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mLocalPicModelCallback = new b(this);
            this.mListView.setVoiceTouchCallback(this.mSendCallBack);
        }
    }

    public boolean isExStorageOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1567));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 == 0) {
                    if (i2 == 12010) {
                        takePhoto();
                    } else if (i2 != 12009 || WriteImageActivityConfig.isActivityInStack) {
                    } else {
                        openImageView();
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
                    LocalPicModel localPicModel = this.mLocalPicModel;
                    if (localPicModel != null) {
                        localPicModel.cancelLoadData();
                        this.mLocalPicModel = null;
                    }
                    String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        WriteImagesInfo writeImagesInfo = this.writeImagesInfo;
                        if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                            iteratorImageForSend(str, stringExtra);
                            return;
                        }
                        LocalPicModel localPicModel2 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.mLocalPicModel = localPicModel2;
                        localPicModel2.setLoadDataCallBack(this.mLocalPicModelCallback);
                        this.mLocalPicModel.getData();
                        this.mListView.hideMore();
                        return;
                    }
                    LocalPicModel localPicModel3 = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.mLocalPicModel = localPicModel3;
                    localPicModel3.setLoadDataCallBack(this.mLocalPicModelCallback);
                    this.mLocalPicModel.getData();
                    this.mListView.hideMore();
                }
            }
        }
    }

    @Override // com.repackage.ve5
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, str) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, view2) == null) || view2 == null || this.mListView == null) {
            return;
        }
        stopVoice();
        if (view2 == this.mListView.getBtnBack()) {
            this.mListView.sendmsgCloseSoftkey();
            finish();
        } else if (view2 == this.mListView.getLayNewMsg()) {
            this.mListView.refreshGo2New(this.mListModel.getData());
            this.mListView.closeNewMsg();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackIsSupportNight(false);
            this.contentView = findViewById(16908290);
            Intent intent = getIntent();
            if (intent != null) {
                this.preTime = intent.getLongExtra("TibaStatic.StartTime", -1L);
            } else {
                this.preTime = System.currentTimeMillis();
            }
            this.mUploadProgressCallback = new c(this);
            initVoice();
            isExStorageOk();
            addGlobalLayoutListener();
            setSkinType(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel != null) {
                msglistModel.onDestroy();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            if (this.mSaveImageTask != null) {
                this.mSaveImageTask = null;
            }
            LocalPicModel localPicModel = this.mLocalPicModel;
            if (localPicModel != null) {
                localPicModel.cancelLoadData();
                this.mLocalPicModel = null;
            }
            AbsMsglistView absMsglistView = this.mListView;
            if (absMsglistView != null) {
                absMsglistView.onDestory();
            }
        }
    }

    @Override // com.repackage.oq4.e
    public void onItemClick(oq4 oq4Var, int i2, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048600, this, oq4Var, i2, view2) == null) && this.mListView.getMsgItemOperationDialog() != null && oq4Var.e() == this.mListView.getMsgItemOperationDialog().f()) {
            int intValue = ((Integer) oq4Var.e().getTag()).intValue();
            if (view2 instanceof TextView) {
                String charSequence = ((TextView) view2).getText().toString();
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                operateMsgItem(intValue, charSequence);
                this.mListView.getMsgItemOperationDialog().dismiss();
            }
        }
    }

    public void onItemViewClick(View view2, int i2, int i3, long j2) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        String content2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (i2 == 1) {
                this.mListView.showDiaItemContentOperate(i3, getDialogOperationItems(i2, this.mIsCurrentUser));
            } else if (i2 == 8) {
                ChatMessage msg3 = this.mListModel.getMsg(i3);
                if (msg3 == null || !y67.v(msg3) || (msg = this.mListModel.getMsg(i3)) == null || (content = msg.getContent()) == null) {
                    return;
                }
                try {
                    JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), jg.e(optJSONObject.optString("activityId"), 0), jg.g(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID), 0L), 2)));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (i2 == 15) {
                ChatMessage msg4 = this.mListModel.getMsg(i3);
                if (msg4 == null || msg4.getContent() == null) {
                    return;
                }
                c77 c77Var = new c77();
                c77Var.c(msg4.getContent(), getClass().getName());
                if (c77Var.b() != 4 || c77Var.a() == null || StringUtils.isNull(((ShareFromFrsMsgData) c77Var.a()).getName())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) c77Var.a()).getName(), null)));
            } else if (i2 == 5) {
                if (isExStorageOk() && (msg2 = this.mListModel.getMsg(i3)) != null && y67.x(msg2)) {
                }
            } else if (i2 != 6) {
                switch (i2) {
                    case 10:
                        ChatMessage msg5 = this.mListModel.getMsg(i3);
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
                        c77 c77Var2 = new c77();
                        c77Var2.c(msg5.getContent(), getClass().getName());
                        if (c77Var2.b() == 1 && c77Var2.a() != null) {
                            String theNewThemeId = ((ShareFromPBMsgData) c77Var2.a()).getTheNewThemeId();
                            if (!StringUtils.isNull(theNewThemeId)) {
                                long g2 = jg.g(theNewThemeId, 0L);
                                if (g2 <= 0) {
                                    return;
                                }
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), g2, ((ShareFromPBMsgData) c77Var2.a()).getImageUrl())));
                                return;
                            } else if (StringUtils.isNull(((ShareFromPBMsgData) c77Var2.a()).getThreadId())) {
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) c77Var2.a()).getThreadId(), ((ShareFromPBMsgData) c77Var2.a()).getPostId(), null)));
                                return;
                            }
                        }
                        return;
                    case 11:
                        if (!ji.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f55));
                            return;
                        }
                        ChatMessage msg6 = this.mListModel.getMsg(i3);
                        if (msg6 == null || msg6.getContent() == null) {
                            return;
                        }
                        c77 c77Var3 = new c77();
                        c77Var3.c(msg6.getContent(), getClass().getName());
                        if (c77Var3.b() == 1 && c77Var3.a() != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, c77Var3));
                            return;
                        }
                        return;
                    case 12:
                        if (!ji.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f55));
                            return;
                        }
                        ChatMessage msg7 = this.mListModel.getMsg(i3);
                        if (msg7 == null || msg7.getContent() == null) {
                            return;
                        }
                        c77 c77Var4 = new c77();
                        c77Var4.c(msg7.getContent(), getClass().getName());
                        if (c77Var4.b() == 1 && c77Var4.a() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{((ShareFromGameCenterMsgData) c77Var4.a()).getShareSourceUrl()}, true);
                            return;
                        }
                        return;
                    case 13:
                        if (!ji.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f55));
                            return;
                        }
                        ChatMessage msg8 = this.mListModel.getMsg(i3);
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

    public void onItemViewLongClick(View view2, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            this.mLastLongClickItem = view2;
            ChatMessage msg = this.mListModel.getMsg(i3);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (msg == null || msg.getLocalData() == null) {
                return;
            }
            if (msg.getLocalData().getStatus().shortValue() == 1) {
                return;
            }
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.mIsCurrentUser = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10 || i2 == 15 || i2 == 11 || i2 == 17) {
                this.mListView.showDiaItemContentOperate(i3, getDialogOperationItems(i2, this.mIsCurrentUser));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, keyEvent)) == null) {
            if (4 == i2) {
                AbsMsglistView absMsglistView = this.mListView;
                if (absMsglistView != null && absMsglistView.isMoreVisible()) {
                    this.mListView.hideMore();
                    return true;
                }
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
        }
    }

    @Override // com.repackage.ve5
    public void onLinkClicked(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048605, this, context, str, z) == null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent != null) {
                this.preTime = intent.getLongExtra("TibaStatic.StartTime", -1L);
            } else {
                this.preTime = System.currentTimeMillis();
            }
            initVoice();
            isExStorageOk();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onPause();
            this.isForeground = false;
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
        }
    }

    @Override // com.repackage.ve5
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048609, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast((int) R.string.obfuscated_res_0x7f0f134d);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast((int) R.string.obfuscated_res_0x7f0f10a5);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onRestart();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            this.isForeground = true;
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
                this.mVoiceManager.setSpeakerphoneOn(true ^ TbadkCoreApplication.getInst().isHeadsetModeOn());
            }
            registerListener(this.richTextIntentClickListener);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.mListView.closeNewMsg();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.s
    public void onScrollToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            prepage();
        }
    }

    @Override // com.repackage.ve5
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, view2, motionEvent)) == null) {
            if (view2 == this.mListView.getBtnSendVoice()) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.mPermissionJudgement.clearRequestPermissionList();
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.RECORD_AUDIO");
                return this.mPermissionJudgement.startRequestPermission(pageActivity);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.ve5
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, context, str) == null) {
        }
    }

    @Override // com.repackage.ve5
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, context, str) == null) {
        }
    }

    public void openImageView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && isExStorageOk()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setResourceType(1);
            albumFloatActivityConfig.setCanEditImage(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void operateMsgItem(int i2, String str) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048622, this, i2, str) == null) {
            ChatMessage msg = this.mListModel.getMsg(i2);
            if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f044a))) {
                if (msg == null || msg.getCacheData() == null) {
                    return;
                }
                ai.a(msg.getContent());
                showToast((int) R.string.obfuscated_res_0x7f0f0ce2);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aec))) {
                if (msg == null || msg.getUserInfo() == null || msg.getUserInfo().getUserName() == null) {
                    return;
                }
                this.mListView.addAt2SendMsg(msg.getUserInfo().getUserName());
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4))) {
                View view2 = this.mLastLongClickItem;
                if ((view2 instanceof ChatVoiceView) && ((ChatVoiceView) view2).isPlaying() && (voiceManager = this.mVoiceManager) != null) {
                    voiceManager.stopPlay();
                }
                this.mListModel.markDeleteMsg(i2);
                showToast((int) R.string.obfuscated_res_0x7f0f04b2);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f108c))) {
                String h2 = y67.h(msg.getContent(), true);
                if (h2 == null) {
                    return;
                }
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.mPermissionJudgement.clearRequestPermissionList();
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                    return;
                }
                View view3 = this.mLastLongClickItem;
                if (view3 instanceof GifView) {
                    TalkableActivity<T>.k kVar = new k(this, h2, ((GifView) view3).getBdImage().k());
                    this.mSaveImageTask = kVar;
                    kVar.execute(new String[0]);
                }
            } else if (!str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07f1)) && !str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e5))) {
                if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aef))) {
                    reSendMsg(i2);
                }
            } else if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.mVoiceManager.setSpeakerphoneOn(true);
                this.mListView.closeReceiver();
            } else {
                TbadkCoreApplication.getInst().setHeadsetModeOn(true);
                this.mVoiceManager.setSpeakerphoneOn(false);
                this.mListView.showReceiver();
            }
        }
    }

    public void removeIceBreakMsg() {
        MsglistModel msglistModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (msglistModel = this.mListModel) == null || msglistModel.getData() == null || this.mListModel.getData().getChatMessages().size() <= 0) {
            return;
        }
        List<ChatMessage> chatMessages = this.mListModel.getData().getChatMessages();
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
        this.mListModel.getData().getChatMessages().remove(i2);
        AbsMsglistView absMsglistView = this.mListView;
        if (absMsglistView != null) {
            absMsglistView.refreshNormal(this.mListModel.getData());
        }
    }

    public boolean saveDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mListModel.saveDraft(this.mListView.getDraft()) : invokeV.booleanValue;
    }

    public void sendBigEmotionMsg(cw4 cw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, cw4Var) == null) || cw4Var == null || cw4Var.c() == null || cw4Var.c().p() == null) {
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return;
        }
        pc5.b(new i(this, cw4Var), new j(this));
    }

    public void sendTextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            String beforeSendMsgText = this.mListView.beforeSendMsgText();
            if (TextUtils.isEmpty(beforeSendMsgText)) {
                return;
            }
            this.mListView.afterSendMsgText();
            this.handler.postDelayed(new f(this, beforeSendMsgText), 100L);
        }
    }

    public void updatRecording(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.mRecording = z;
            AbsMsglistView absMsglistView = this.mListView;
            if (absMsglistView != null) {
                absMsglistView.setRecoding(z);
            }
        }
    }
}
