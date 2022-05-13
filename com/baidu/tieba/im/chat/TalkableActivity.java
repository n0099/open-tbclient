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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a45;
import com.repackage.a9;
import com.repackage.a97;
import com.repackage.aj;
import com.repackage.bg;
import com.repackage.bg5;
import com.repackage.bi;
import com.repackage.c97;
import com.repackage.ef;
import com.repackage.ff;
import com.repackage.h97;
import com.repackage.ie5;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.mx4;
import com.repackage.ng;
import com.repackage.rl8;
import com.repackage.sd5;
import com.repackage.vd5;
import com.repackage.yf5;
import com.repackage.yr4;
import com.repackage.zc5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements VoiceManager.j, bg5, View.OnTouchListener, BdListView.s, BdListView.p, ff, ef, yr4.e, ActivityCompat.OnRequestPermissionsResultCallback {
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
    public TalkableActivity<T>.h mSaveImageTask;
    public c97 mSendCallBack;
    public a45.b<ChatMessage> mUploadProgressCallback;
    public VoiceManager mVoiceManager;
    public long preTime;
    public CustomMessageListener richTextIntentClickListener;
    public WriteImagesInfo writeImagesInfo;

    /* loaded from: classes3.dex */
    public class a extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        public a(TalkableActivity talkableActivity) {
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
                        msglistModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                        return;
                    }
                    return;
                }
                this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e5d));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a45.b<ChatMessage> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.a45.b
        /* renamed from: b */
        public void a(int i, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, chatMessage) == null) {
                this.a.mListView.updateAdapterProgress(i, chatMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ TalkableActivity d;

        /* loaded from: classes3.dex */
        public class a extends sd5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.repackage.sd5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    c cVar = this.a;
                    cVar.d.dealImageForSend(cVar.a);
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements zc5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.repackage.zc5
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    if (this.a.a.isGif()) {
                        this.a.d.mLocalPicModel = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    } else {
                        c cVar = this.a;
                        cVar.d.mLocalPicModel = new LocalPicModel(cVar.b, cVar.c, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    }
                    TalkableActivity talkableActivity = this.a.d;
                    talkableActivity.mLocalPicModel.setLoadDataCallBack(talkableActivity.mLocalPicModelCallback);
                    this.a.d.mLocalPicModel.getData();
                    this.a.d.mListView.hideMore();
                }
            }
        }

        public c(TalkableActivity talkableActivity, ImageFileInfo imageFileInfo, String str, String str2) {
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
            vd5.b(new a(this), new b(this));
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TalkableActivity talkableActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yf5.a)) {
                yf5.a aVar = (yf5.a) customResponsedMessage.getData();
                yf5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ TalkableActivity b;

        public e(TalkableActivity talkableActivity, String str) {
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
    public class f extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TalkableActivity a;

        public f(TalkableActivity talkableActivity) {
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
                if (!ki.z()) {
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
                    case 13:
                    case 14:
                        TalkableActivity talkableActivity5 = this.a;
                        AbsMsglistView absMsglistView7 = talkableActivity5.mListView;
                        if (absMsglistView7 != null) {
                            absMsglistView7.refreshNormal(talkableActivity5.mListModel.getData());
                            break;
                        }
                        break;
                    case 8:
                        AbsMsglistView absMsglistView8 = this.a.mListView;
                        if (absMsglistView8 != null && (obj instanceof String)) {
                            String str = (String) obj;
                            absMsglistView8.setDraft(str);
                            this.a.mListModel.setDraft(str);
                            break;
                        }
                        break;
                    case 9:
                        this.a.isNeedSaveDraft = false;
                        this.a.finish();
                        break;
                    case 10:
                        AbsMsglistView absMsglistView9 = this.a.mListView;
                        if (absMsglistView9 != null && (obj instanceof String)) {
                            absMsglistView9.refreshHeaderFooter((String) obj, true);
                            break;
                        }
                        break;
                    case 11:
                        TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getContext())));
                        this.a.isNeedSaveDraft = false;
                        this.a.finish();
                        break;
                    case 12:
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
    public class g implements c97 {
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

        @Override // com.repackage.c97
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TalkableActivity talkableActivity = this.a;
                return talkableActivity.mVoiceManager != null && talkableActivity.getRecorderManager().f();
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.c97
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.isForeground : invokeV.booleanValue;
        }

        @Override // com.repackage.c97
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.getRecorderManager() == null) {
                return;
            }
            this.a.getRecorderManager().cancelRecord();
        }

        @Override // com.repackage.c97
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.mRecording = z;
            }
        }

        @Override // com.repackage.c97
        public void startRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.getRecorderManager() == null) {
                return;
            }
            this.a.getRecorderManager().c(this.a.mListView, -1);
            this.a.getRecorderManager().d(aj.b);
        }

        @Override // com.repackage.c97
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.getRecorderManager() == null) {
                return;
            }
            this.a.getRecorderManager().stopRecord();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ TalkableActivity c;

        public h(TalkableActivity talkableActivity, String str, byte[] bArr) {
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
                        return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1081);
                    }
                    return this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1082);
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
                super.onPostExecute((h) str);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.richTextIntentClickListener = new d(this, 2001332);
        this.mMsgCallback = new f(this);
        this.mSendCallBack = new g(this);
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
                Bitmap c2 = ie5.c(0, getPageContext().getContext(), null, imageFileInfo.getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 == null || FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) == null || (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) == null) {
                    return;
                }
                FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void deleteMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            this.mListModel.deleteMsg(i);
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
            long j = 0;
            while (it.hasNext()) {
                j++;
                ng.a().postDelayed(new c(this, it.next(), str, str2), 100 * j);
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

    private void reSendMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i) == null) {
            this.mListModel.reSendMsg(i);
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

    public String[] getDialogOperationItems(int i, boolean z) {
        InterceptResult invokeCommon;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (i == 1) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae9));
            } else if (i == 15) {
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae6));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
            } else if (i == 17) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
            } else if (i == 3) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0444));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae6));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
            } else if (i == 4) {
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae6));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f107c));
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
            } else if (i != 5) {
                switch (i) {
                    case 7:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae6));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
                        break;
                    case 8:
                    case 9:
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
                        break;
                    case 10:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae6));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
                        break;
                    case 11:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae6));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
                        break;
                }
            } else {
                if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07df);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07eb);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae6));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeCommon.objValue;
    }

    @Override // com.repackage.bg5
    public bg<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
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

    public rl8 getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return this.mVoiceManager.getRecorderManager();
        }
        return (rl8) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.bg5
    public bg<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public void initCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mLocalPicModelCallback = new a(this);
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
            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1550));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1) {
                if (i2 == 0) {
                    if (i == 12010) {
                        takePhoto();
                    } else if (i != 12009 || WriteImageActivityConfig.isActivityInStack) {
                    } else {
                        openImageView();
                    }
                }
            } else if (intent == null) {
            } else {
                if (i == 12010 || i == 12009 || i == 12002) {
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

    @Override // com.repackage.bg5
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
            this.mUploadProgressCallback = new b(this);
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

    @Override // com.repackage.yr4.e
    public void onItemClick(yr4 yr4Var, int i, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048600, this, yr4Var, i, view2) == null) && this.mListView.getMsgItemOperationDialog() != null && yr4Var.e() == this.mListView.getMsgItemOperationDialog().f()) {
            int intValue = ((Integer) yr4Var.e().getTag()).intValue();
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

    public void onItemViewClick(View view2, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        String content2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (i == 1) {
                this.mListView.showDiaItemContentOperate(i2, getDialogOperationItems(i, this.mIsCurrentUser));
            } else if (i == 8) {
                ChatMessage msg3 = this.mListModel.getMsg(i2);
                if (msg3 == null || !a97.v(msg3) || (msg = this.mListModel.getMsg(i2)) == null || (content = msg.getContent()) == null) {
                    return;
                }
                try {
                    JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), kg.e(optJSONObject.optString("activityId"), 0), kg.g(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID), 0L), 2)));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (i == 15) {
                ChatMessage msg4 = this.mListModel.getMsg(i2);
                if (msg4 == null || msg4.getContent() == null) {
                    return;
                }
                h97 h97Var = new h97();
                h97Var.c(msg4.getContent(), getClass().getName());
                if (h97Var.b() != 4 || h97Var.a() == null || StringUtils.isNull(((ShareFromFrsMsgData) h97Var.a()).getName())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) h97Var.a()).getName(), null)));
            } else if (i == 5) {
                if (isExStorageOk() && (msg2 = this.mListModel.getMsg(i2)) != null && a97.x(msg2)) {
                }
            } else if (i != 6) {
                switch (i) {
                    case 10:
                        ChatMessage msg5 = this.mListModel.getMsg(i2);
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
                        h97 h97Var2 = new h97();
                        h97Var2.c(msg5.getContent(), getClass().getName());
                        if (h97Var2.b() == 1 && h97Var2.a() != null) {
                            String theNewThemeId = ((ShareFromPBMsgData) h97Var2.a()).getTheNewThemeId();
                            if (!StringUtils.isNull(theNewThemeId)) {
                                long g2 = kg.g(theNewThemeId, 0L);
                                if (g2 <= 0) {
                                    return;
                                }
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), g2, ((ShareFromPBMsgData) h97Var2.a()).getImageUrl())));
                                return;
                            } else if (StringUtils.isNull(((ShareFromPBMsgData) h97Var2.a()).getThreadId())) {
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) h97Var2.a()).getThreadId(), ((ShareFromPBMsgData) h97Var2.a()).getPostId(), null)));
                                return;
                            }
                        }
                        return;
                    case 11:
                        if (!ki.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f46));
                            return;
                        }
                        ChatMessage msg6 = this.mListModel.getMsg(i2);
                        if (msg6 == null || msg6.getContent() == null) {
                            return;
                        }
                        h97 h97Var3 = new h97();
                        h97Var3.c(msg6.getContent(), getClass().getName());
                        if (h97Var3.b() == 1 && h97Var3.a() != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, h97Var3));
                            return;
                        }
                        return;
                    case 12:
                        if (!ki.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f46));
                            return;
                        }
                        ChatMessage msg7 = this.mListModel.getMsg(i2);
                        if (msg7 == null || msg7.getContent() == null) {
                            return;
                        }
                        h97 h97Var4 = new h97();
                        h97Var4.c(msg7.getContent(), getClass().getName());
                        if (h97Var4.b() == 1 && h97Var4.a() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{((ShareFromGameCenterMsgData) h97Var4.a()).getShareSourceUrl()}, true);
                            return;
                        }
                        return;
                    case 13:
                        if (!ki.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f46));
                            return;
                        }
                        ChatMessage msg8 = this.mListModel.getMsg(i2);
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

    public void onItemViewLongClick(View view2, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.mLastLongClickItem = view2;
            ChatMessage msg = this.mListModel.getMsg(i2);
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
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.mListView.showDiaItemContentOperate(i2, getDialogOperationItems(i, this.mIsCurrentUser));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i, keyEvent)) == null) {
            if (4 == i) {
                AbsMsglistView absMsglistView = this.mListView;
                if (absMsglistView != null && absMsglistView.isMoreVisible()) {
                    this.mListView.hideMore();
                    return true;
                }
                finish();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
        }
    }

    @Override // com.repackage.bg5
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

    @Override // com.repackage.bg5
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048609, this, i, strArr, iArr) == null) && i == 1) {
            if (PermissionUtil.checkCamera(getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast((int) R.string.obfuscated_res_0x7f0f133b);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast((int) R.string.obfuscated_res_0x7f0f1095);
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

    @Override // com.repackage.bg5
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

    @Override // com.repackage.bg5
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, context, str) == null) {
        }
    }

    @Override // com.repackage.bg5
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

    public void operateMsgItem(int i, String str) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048622, this, i, str) == null) {
            ChatMessage msg = this.mListModel.getMsg(i);
            if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0444))) {
                if (msg == null || msg.getCacheData() == null) {
                    return;
                }
                bi.a(msg.getContent());
                showToast((int) R.string.obfuscated_res_0x7f0f0cde);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae6))) {
                if (msg == null || msg.getUserInfo() == null || msg.getUserInfo().getUserName() == null) {
                    return;
                }
                this.mListView.addAt2SendMsg(msg.getUserInfo().getUserName());
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d))) {
                View view2 = this.mLastLongClickItem;
                if ((view2 instanceof ChatVoiceView) && ((ChatVoiceView) view2).isPlaying() && (voiceManager = this.mVoiceManager) != null) {
                    voiceManager.stopPlay();
                }
                this.mListModel.markDeleteMsg(i);
                showToast((int) R.string.obfuscated_res_0x7f0f04ab);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f107c))) {
                String h2 = a97.h(msg.getContent(), true);
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
                    TalkableActivity<T>.h hVar = new h(this, h2, ((GifView) view3).getBdImage().k());
                    this.mSaveImageTask = hVar;
                    hVar.execute(new String[0]);
                }
            } else if (!str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07eb)) && !str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07df))) {
                if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ae9))) {
                    reSendMsg(i);
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
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= chatMessages.size()) {
                break;
            } else if (chatMessages.get(i2).getType() == ChatMessage.TYPE_MSG_ICE_BREAK) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i < 0 || i >= chatMessages.size()) {
            return;
        }
        this.mListModel.getData().getChatMessages().remove(i);
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

    public void sendBigEmotionMsg(mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, mx4Var) == null) || mx4Var == null || mx4Var.c() == null || mx4Var.c().p() == null) {
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
        FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, mx4Var.c().p(), 85);
        FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, mx4Var.c().p(), 85);
        LocalPicModel localPicModel = new LocalPicModel(null, TbConfig.IMAGE_RESIZED_FILE, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
        this.mLocalPicModel = localPicModel;
        localPicModel.setLoadDataCallBack(this.mLocalPicModelCallback);
        this.mLocalPicModel.getData();
    }

    public void sendTextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            String beforeSendMsgText = this.mListView.beforeSendMsgText();
            if (TextUtils.isEmpty(beforeSendMsgText)) {
                return;
            }
            this.mListView.afterSendMsgText();
            this.handler.postDelayed(new e(this, beforeSendMsgText), 100L);
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
