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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
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
import com.kuaishou.weapon.un.w0;
import com.repackage.a9;
import com.repackage.ad5;
import com.repackage.ax4;
import com.repackage.b97;
import com.repackage.c57;
import com.repackage.dd5;
import com.repackage.dg;
import com.repackage.di;
import com.repackage.dr4;
import com.repackage.ef;
import com.repackage.ff;
import com.repackage.ff5;
import com.repackage.ic5;
import com.repackage.if5;
import com.repackage.j35;
import com.repackage.mg;
import com.repackage.mi;
import com.repackage.nm8;
import com.repackage.oi;
import com.repackage.or4;
import com.repackage.pd5;
import com.repackage.x87;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements VoiceManager.j, if5, View.OnTouchListener, BdListView.s, BdListView.p, ff, ef, or4.e, ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RECORD_MOVE_OUTSIDE_RANGE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler handler;
    public boolean isForeground;
    public boolean isNeedSaveDraft;
    public j mImageSendAuthInIM;
    public boolean mIsCurrentUser;
    public View mLastLongClickItem;
    public MsglistModel mListModel;
    public AbsMsglistView mListView;
    public LocalPicModel mLocalPicModel;
    public a9 mLocalPicModelCallback;
    public a9 mMsgCallback;
    public PermissionJudgePolicy mPermissionJudgement;
    public boolean mRecording;
    public c57 mSaveImageTask;
    public j35.b<ChatMessage> mUploadProgressCallback;
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
                this.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e40));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements j35.b<ChatMessage> {
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
        @Override // com.repackage.j35.b
        /* renamed from: b */
        public void a(int i, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, chatMessage) == null) {
                this.a.mListView.updateAdapter(i, chatMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ad5<Object> {
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

        @Override // com.repackage.ad5
        public Object doInBackground() {
            InterceptResult invokeV;
            Bitmap resizeBitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    Bitmap c = pd5.c(0, this.a.getPageContext().getContext(), null, this.a.writeImagesInfo.getChosedFiles().get(0).getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                    if (c != null && FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c, 100)) != null) {
                        FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                    }
                } catch (Exception unused) {
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ic5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TalkableActivity c;

        public d(TalkableActivity talkableActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, str, str2};
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
            this.a = str;
            this.b = str2;
        }

        @Override // com.repackage.ic5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.c.mLocalPicModel = new LocalPicModel(this.a, this.b, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                TalkableActivity talkableActivity = this.c;
                talkableActivity.mLocalPicModel.setLoadDataCallBack(talkableActivity.mLocalPicModelCallback);
                this.c.mLocalPicModel.getData();
                this.c.mListView.hideMore();
                this.c.writeImagesInfo.clear();
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ff5.a)) {
                ff5.a aVar = (ff5.a) customResponsedMessage.getData();
                ff5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!mi.z()) {
                    AbsMsglistView absMsglistView = this.a.mListView;
                    if (absMsglistView != null) {
                        absMsglistView.displayNoNetwork();
                    }
                } else {
                    AbsMsglistView absMsglistView2 = this.a.mListView;
                    if (absMsglistView2 != null) {
                        absMsglistView2.hideNoNetwork();
                    }
                }
                switch (this.a.mListModel.getLoadDataMode()) {
                    case 1:
                        if (this.a.preTime > -1) {
                            this.a.preTime = -1L;
                        }
                        AbsMsglistView absMsglistView3 = this.a.mListView;
                        if (absMsglistView3 != null) {
                            absMsglistView3.closeProgress();
                            TalkableActivity talkableActivity = this.a;
                            talkableActivity.mListView.refreshGo2New(talkableActivity.mListModel.getData());
                            return;
                        }
                        return;
                    case 2:
                        TalkableActivity talkableActivity2 = this.a;
                        AbsMsglistView absMsglistView4 = talkableActivity2.mListView;
                        if (absMsglistView4 != null) {
                            absMsglistView4.refreshPrepage(talkableActivity2.mListModel.getData());
                            return;
                        }
                        return;
                    case 3:
                        TalkableActivity talkableActivity3 = this.a;
                        AbsMsglistView absMsglistView5 = talkableActivity3.mListView;
                        if (absMsglistView5 != null) {
                            absMsglistView5.refreshCheckNew(talkableActivity3.mListModel.getData());
                            return;
                        }
                        return;
                    case 4:
                    case 12:
                        TalkableActivity talkableActivity4 = this.a;
                        AbsMsglistView absMsglistView6 = talkableActivity4.mListView;
                        if (absMsglistView6 != null) {
                            absMsglistView6.refreshGo2New(talkableActivity4.mListModel.getData());
                            return;
                        }
                        return;
                    case 5:
                    case 6:
                    case 7:
                    case 13:
                    case 14:
                        TalkableActivity talkableActivity5 = this.a;
                        AbsMsglistView absMsglistView7 = talkableActivity5.mListView;
                        if (absMsglistView7 != null) {
                            absMsglistView7.refreshNormal(talkableActivity5.mListModel.getData());
                            return;
                        }
                        return;
                    case 8:
                        AbsMsglistView absMsglistView8 = this.a.mListView;
                        if (absMsglistView8 == null || !(obj instanceof String)) {
                            return;
                        }
                        String str = (String) obj;
                        absMsglistView8.setDraft(str);
                        this.a.mListModel.setDraft(str);
                        return;
                    case 9:
                        this.a.isNeedSaveDraft = false;
                        this.a.finish();
                        return;
                    case 10:
                        AbsMsglistView absMsglistView9 = this.a.mListView;
                        if (absMsglistView9 == null || !(obj instanceof String)) {
                            return;
                        }
                        absMsglistView9.refreshHeaderFooter((String) obj, true);
                        return;
                    case 11:
                        TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getContext())));
                        this.a.isNeedSaveDraft = false;
                        this.a.finish();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ TalkableActivity b;

        public h(TalkableActivity talkableActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = talkableActivity;
            this.a = i;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
                this.b.reSendMsg(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ TalkableActivity b;

        public i(TalkableActivity talkableActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {talkableActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = talkableActivity;
            this.a = i;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
                this.b.deleteMsg(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
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
    }

    private void dealAlbumFromCamera(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65543, this, i2, str, str2) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), w0.I5, 12010, null, null, null, null, i2, str, str2, "")));
        }
    }

    private void dealAlbumFromImage(Intent intent, int i2, String str, String str2) {
        String stringExtra;
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65544, this, intent, i2, str, str2) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null || (writeImagesInfo = this.writeImagesInfo) == null) {
            return;
        }
        writeImagesInfo.mIsFromIm = true;
        writeImagesInfo.parseJson(stringExtra);
        this.writeImagesInfo.updateQuality();
        if (this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.getChosedFiles().size() <= 0) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12009, this.writeImagesInfo, 0)));
        this.writeImagesInfo.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            this.mListModel.deleteMsg(i2);
        }
    }

    private void initVoice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (this.mVoiceManager == null) {
                VoiceManager voiceManager = new VoiceManager();
                this.mVoiceManager = voiceManager;
                voiceManager.onCreate(getPageContext());
            }
            this.mVoiceManager.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
        }
    }

    private void prepage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mListModel.loadPrepage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i2) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (i2 == 3) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f043c));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad8));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
            } else if (i2 == 4) {
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad8));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1065));
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
            } else if (i2 == 5) {
                if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07d7);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e3);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad8));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
            } else if (i2 == 15) {
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad8));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
            } else if (i2 != 17) {
                switch (i2) {
                    case 7:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad8));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
                        break;
                    case 8:
                    case 9:
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
                        break;
                    case 10:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad8));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
                        break;
                    case 11:
                        if (!z) {
                            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad8));
                        }
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
                        break;
                }
            } else {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeCommon.objValue;
    }

    @Override // com.repackage.if5
    public dg<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, voiceModel)) == null) {
            AbsMsglistView absMsglistView = this.mListView;
            if (absMsglistView == null || absMsglistView.getMsgListView() == null || (findViewWithTag = this.mListView.getMsgListView().findViewWithTag(voiceModel)) == null || !(findViewWithTag instanceof VoiceManager.i)) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public nm8 getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return this.mVoiceManager.getRecorderManager();
        }
        return (nm8) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.if5
    public dg<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    public void initCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mLocalPicModelCallback = new a(this);
        }
    }

    public boolean isExStorageOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (FileHelper.checkSD()) {
                return true;
            }
            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1525));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, intent) == null) {
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
                if (i2 != 12010 && i2 != 12009 && (StringUtils.isNull(intent.getStringExtra("file_name")) || i2 != 12002)) {
                    int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                    String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10e8);
                    String string2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036e);
                    if (i2 != 12002) {
                        if (i2 == 12001) {
                            dealAlbumFromCamera(maxChatImageWidthInPx, string, string2);
                            return;
                        }
                        return;
                    } else if (intent == null) {
                        return;
                    } else {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            dealAlbumFromCamera(maxChatImageWidthInPx, string, string2);
                            return;
                        } else {
                            dealAlbumFromImage(intent, maxChatImageWidthInPx, string, string2);
                            return;
                        }
                    }
                }
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
                    if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                        dd5.b(new c(this), new d(this, str, stringExtra));
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

    @Override // com.repackage.if5
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, context, str) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, view2) == null) || view2 == null || this.mListView == null) {
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
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackIsSupportNight(false);
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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

    @Override // com.repackage.or4.e
    public void onItemClick(or4 or4Var, int i2, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048599, this, or4Var, i2, view2) == null) && this.mListView.getMsgItemOperationDialog() != null && or4Var.e() == this.mListView.getMsgItemOperationDialog().f()) {
            int intValue = ((Integer) or4Var.e().getTag()).intValue();
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
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (i2 == 1) {
                dr4 dr4Var = new dr4(getPageContext().getPageActivity());
                dr4Var.setMessage(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1203));
                dr4Var.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0adc), new h(this, i3));
                dr4Var.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495), new i(this, i3));
                dr4Var.create(getPageContext()).show();
            } else if (i2 == 8) {
                ChatMessage msg3 = this.mListModel.getMsg(i3);
                if (msg3 == null || !x87.r(msg3) || (msg = this.mListModel.getMsg(i3)) == null || (content = msg.getContent()) == null) {
                    return;
                }
                try {
                    JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), mg.e(optJSONObject.optString("activityId"), 0), mg.g(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID), 0L), 2)));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (i2 == 15) {
                ChatMessage msg4 = this.mListModel.getMsg(i3);
                if (msg4 == null || msg4.getContent() == null) {
                    return;
                }
                b97 b97Var = new b97();
                b97Var.c(msg4.getContent(), getClass().getName());
                if (b97Var.b() != 4 || b97Var.a() == null || StringUtils.isNull(((ShareFromFrsMsgData) b97Var.a()).getName())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) b97Var.a()).getName(), null)));
            } else if (i2 == 5) {
                if (isExStorageOk() && (msg2 = this.mListModel.getMsg(i3)) != null && x87.t(msg2)) {
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
                        b97 b97Var2 = new b97();
                        b97Var2.c(msg5.getContent(), getClass().getName());
                        if (b97Var2.b() == 1 && b97Var2.a() != null) {
                            String theNewThemeId = ((ShareFromPBMsgData) b97Var2.a()).getTheNewThemeId();
                            if (!StringUtils.isNull(theNewThemeId)) {
                                long g2 = mg.g(theNewThemeId, 0L);
                                if (g2 <= 0) {
                                    return;
                                }
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), g2, ((ShareFromPBMsgData) b97Var2.a()).getImageUrl())));
                                return;
                            } else if (StringUtils.isNull(((ShareFromPBMsgData) b97Var2.a()).getThreadId())) {
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) b97Var2.a()).getThreadId(), ((ShareFromPBMsgData) b97Var2.a()).getPostId(), null)));
                                return;
                            }
                        }
                        return;
                    case 11:
                        if (!mi.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f2a));
                            return;
                        }
                        ChatMessage msg6 = this.mListModel.getMsg(i3);
                        if (msg6 == null || msg6.getContent() == null) {
                            return;
                        }
                        b97 b97Var3 = new b97();
                        b97Var3.c(msg6.getContent(), getClass().getName());
                        if (b97Var3.b() == 1 && b97Var3.a() != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, b97Var3));
                            return;
                        }
                        return;
                    case 12:
                        if (!mi.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f2a));
                            return;
                        }
                        ChatMessage msg7 = this.mListModel.getMsg(i3);
                        if (msg7 == null || msg7.getContent() == null) {
                            return;
                        }
                        b97 b97Var4 = new b97();
                        b97Var4.c(msg7.getContent(), getClass().getName());
                        if (b97Var4.b() == 1 && b97Var4.a() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{((ShareFromGameCenterMsgData) b97Var4.a()).getShareSourceUrl()}, true);
                            return;
                        }
                        return;
                    case 13:
                        if (!mi.z()) {
                            showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f2a));
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
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeLL(1048603, this, context, str) == null) {
        }
    }

    @Override // com.repackage.if5
    public void onLinkClicked(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048604, this, context, str, z) == null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, intent) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            this.isForeground = false;
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
        }
    }

    @Override // com.repackage.if5
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048607, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048608, this, i2, strArr, iArr) == null) && i2 == 1) {
            if (PermissionUtil.checkCamera(getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast((int) R.string.obfuscated_res_0x7f0f131a);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                return;
            }
            showToast((int) R.string.obfuscated_res_0x7f0f107e);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onRestart();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.mListView.closeNewMsg();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.s
    public void onScrollToTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            prepage();
        }
    }

    @Override // com.repackage.if5
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, view2, motionEvent)) == null) {
            if (view2 == this.mListView.getBtnSendVoice()) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.mPermissionJudgement.clearRequestPermissionList();
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.RECORD_AUDIO");
                if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                    return false;
                }
                nm8 recorderManager = getRecorderManager();
                if (motionEvent.getAction() == 0) {
                    if (this.mVoiceManager == null || !recorderManager.e()) {
                        return true;
                    }
                    recorderManager.c(this.mListView, -1);
                    this.mListView.closeRecordCancel();
                    this.mListView.refreshSendVoiceText(true);
                    this.mListView.startRecordVoice();
                    this.mRecording = true;
                } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    if (motionEvent.getAction() == 2) {
                        if (motionEvent.getY() < oi.d(getPageContext().getContext(), 5.0f) * (-1)) {
                            this.mListView.showRecordCancel();
                            this.mListView.stopRecordVoice();
                            this.mRecording = false;
                        } else {
                            this.mListView.closeRecordCancel();
                            this.mListView.startRecordVoice();
                        }
                    }
                } else {
                    if (motionEvent.getY() < oi.d(getPageContext().getContext(), 5.0f) * (-1)) {
                        if (recorderManager != null) {
                            recorderManager.cancelRecord();
                        }
                        this.mListView.closeRecordCancel();
                    } else if (!this.isForeground) {
                        if (recorderManager != null) {
                            recorderManager.cancelRecord();
                        }
                        this.mListView.stopRecordVoice();
                    } else {
                        if (recorderManager != null) {
                            recorderManager.stopRecord();
                        }
                        this.mListView.stopRecordVoice();
                    }
                    this.mListView.refreshSendVoiceText(false);
                    this.mRecording = false;
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.if5
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, context, str) == null) {
        }
    }

    @Override // com.repackage.if5
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, context, str) == null) {
        }
    }

    public void openImageView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && isExStorageOk()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    public void operateMsgItem(int i2, String str) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048621, this, i2, str) == null) {
            ChatMessage msg = this.mListModel.getMsg(i2);
            if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f043c))) {
                if (msg == null || msg.getCacheData() == null) {
                    return;
                }
                di.a(msg.getContent());
                showToast((int) R.string.obfuscated_res_0x7f0f0cc4);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad8))) {
                if (msg == null || msg.getUserInfo() == null || msg.getUserInfo().getUserName() == null) {
                    return;
                }
                this.mListView.addAt2SendMsg(msg.getUserInfo().getUserName());
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495))) {
                View view2 = this.mLastLongClickItem;
                if ((view2 instanceof ChatVoiceView) && ((ChatVoiceView) view2).isPlaying() && (voiceManager = this.mVoiceManager) != null) {
                    voiceManager.stopPlay();
                }
                this.mListModel.markDeleteMsg(i2);
                showToast((int) R.string.obfuscated_res_0x7f0f04a3);
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1065))) {
                String f2 = x87.f(msg.getContent(), true);
                if (f2 == null) {
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
                c57 c57Var = new c57(f2, this);
                this.mSaveImageTask = c57Var;
                c57Var.c();
            } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e3)) || str.equals(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07d7))) {
                if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                    TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                    this.mVoiceManager.setSpeakerphoneOn(true);
                    this.mListView.closeReceiver();
                    return;
                }
                TbadkCoreApplication.getInst().setHeadsetModeOn(true);
                this.mVoiceManager.setSpeakerphoneOn(false);
                this.mListView.showReceiver();
            }
        }
    }

    public boolean saveDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mListModel.saveDraft(this.mListView.getDraft()) : invokeV.booleanValue;
    }

    public void sendBigEmotionMsg(ax4 ax4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, ax4Var) == null) {
            this.mListModel.sendBigEmotionMessage(ax4Var);
        }
    }

    public void sendTextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            String beforeSendMsgText = this.mListView.beforeSendMsgText();
            if (TextUtils.isEmpty(beforeSendMsgText)) {
                return;
            }
            this.mListView.afterSendMsgText();
            this.handler.postDelayed(new f(this, beforeSendMsgText), 100L);
        }
    }

    public void setImageSendAuthInIM(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jVar) == null) {
            this.mImageSendAuthInIM = jVar;
        }
    }

    public void setListModel(MsglistModel msglistModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, msglistModel) == null) {
            this.mListModel = msglistModel;
        }
    }

    public void setMsgListView(AbsMsglistView absMsglistView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, absMsglistView) == null) {
            this.mListView = absMsglistView;
        }
    }
}
