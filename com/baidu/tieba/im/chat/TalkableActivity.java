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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
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
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.i0.b0.a;
import d.a.i0.b1.m.f;
import d.a.i0.r.s.a;
import d.a.i0.r.s.l;
import d.a.i0.s.c.v;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.i0.z0.n;
import d.a.i0.z0.p0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements VoiceManager.j, d.a.i0.b1.m.h, View.OnTouchListener, BdListView.s, BdListView.p, d.a.c.e.h.b, d.a.c.e.h.a, l.e, ActivityCompat.OnRequestPermissionsResultCallback {
    public static final int RECORD_MOVE_OUTSIDE_RANGE = 5;
    public boolean isForeground;
    public j mImageSendAuthInIM;
    public boolean mIsCurrentUser;
    public View mLastLongClickItem;
    public PermissionJudgePolicy mPermissionJudgement;
    public boolean mRecording;
    public VoiceManager mVoiceManager;
    public Handler handler = new Handler();
    public AbsMsglistView mListView = null;
    public MsglistModel mListModel = null;
    public LocalPicModel mLocalPicModel = null;
    public d.a.c.a.e mLocalPicModelCallback = null;
    public d.a.j0.e1.f.g mSaveImageTask = null;
    public a.b<ChatMessage> mUploadProgressCallback = null;
    public long preTime = -1;
    public WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    public boolean isNeedSaveDraft = true;
    public CustomMessageListener richTextIntentClickListener = new e(2001332);
    public d.a.c.a.e mMsgCallback = new g();

    /* loaded from: classes4.dex */
    public class a extends d.a.c.a.e {
        public a() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                MsglistModel msglistModel = TalkableActivity.this.mListModel;
                if (msglistModel != null) {
                    msglistModel.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                    return;
                }
                return;
            }
            TalkableActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b<ChatMessage> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.b0.a.b
        /* renamed from: b */
        public void a(int i2, ChatMessage chatMessage) {
            TalkableActivity.this.mListView.updateAdapter(i2, chatMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Object> {
        public c() {
        }

        @Override // d.a.i0.z0.f0
        public Object doInBackground() {
            Bitmap resizeBitmap;
            try {
                Bitmap c2 = p0.c(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), TbImageHelper.getInstance().getPostImageSize());
                if (c2 != null && FileHelper.SaveFile(null, TbConfig.IMAGE_RESIZED_FILE, c2, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 100)) != null) {
                    FileHelper.SaveFile(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85);
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements n<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17767a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17768b;

        public d(String str, String str2) {
            this.f17767a = str;
            this.f17768b = str2;
        }

        @Override // d.a.i0.z0.n
        public void onReturnDataInUI(Object obj) {
            TalkableActivity.this.mLocalPicModel = new LocalPicModel(this.f17767a, this.f17768b, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
            TalkableActivity talkableActivity = TalkableActivity.this;
            talkableActivity.mLocalPicModel.setLoadDataCallBack(talkableActivity.mLocalPicModelCallback);
            TalkableActivity.this.mLocalPicModel.getData();
            TalkableActivity.this.mListView.hideMore();
            TalkableActivity.this.writeImagesInfo.clear();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            d.a.i0.b1.m.f.b(TalkableActivity.this.getPageContext(), aVar.f48276a, aVar.f48277b, aVar.f48278c);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17771e;

        public f(String str) {
            this.f17771e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TalkableActivity.this.mListModel.sendTextMessage(this.f17771e);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends d.a.c.a.e {
        public g() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (!d.a.c.e.p.j.z()) {
                AbsMsglistView absMsglistView = TalkableActivity.this.mListView;
                if (absMsglistView != null) {
                    absMsglistView.displayNoNetwork();
                }
            } else {
                AbsMsglistView absMsglistView2 = TalkableActivity.this.mListView;
                if (absMsglistView2 != null) {
                    absMsglistView2.hideNoNetwork();
                }
            }
            switch (TalkableActivity.this.mListModel.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.preTime > -1) {
                        TalkableActivity.this.preTime = -1L;
                    }
                    TalkableActivity.this.mListView.closeProgress();
                    TalkableActivity talkableActivity = TalkableActivity.this;
                    talkableActivity.mListView.refreshGo2New(talkableActivity.mListModel.getData());
                    return;
                case 2:
                    TalkableActivity talkableActivity2 = TalkableActivity.this;
                    talkableActivity2.mListView.refreshPrepage(talkableActivity2.mListModel.getData());
                    return;
                case 3:
                    TalkableActivity talkableActivity3 = TalkableActivity.this;
                    talkableActivity3.mListView.refreshCheckNew(talkableActivity3.mListModel.getData());
                    return;
                case 4:
                    TalkableActivity talkableActivity4 = TalkableActivity.this;
                    talkableActivity4.mListView.refreshGo2New(talkableActivity4.mListModel.getData());
                    return;
                case 5:
                    TalkableActivity talkableActivity5 = TalkableActivity.this;
                    talkableActivity5.mListView.refreshNormal(talkableActivity5.mListModel.getData());
                    return;
                case 6:
                    TalkableActivity talkableActivity6 = TalkableActivity.this;
                    talkableActivity6.mListView.refreshNormal(talkableActivity6.mListModel.getData());
                    return;
                case 7:
                    TalkableActivity talkableActivity7 = TalkableActivity.this;
                    talkableActivity7.mListView.refreshNormal(talkableActivity7.mListModel.getData());
                    return;
                case 8:
                    if (obj == null || !(obj instanceof String)) {
                        return;
                    }
                    String str = (String) obj;
                    TalkableActivity.this.mListView.setDraft(str);
                    TalkableActivity.this.mListModel.setDraft(str);
                    return;
                case 9:
                    TalkableActivity.this.isNeedSaveDraft = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj == null || !(obj instanceof String)) {
                        return;
                    }
                    TalkableActivity.this.mListView.refreshHeaderFooter((String) obj, true);
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.isNeedSaveDraft = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity talkableActivity8 = TalkableActivity.this;
                    talkableActivity8.mListView.refreshGo2New(talkableActivity8.mListModel.getData());
                    return;
                case 13:
                    TalkableActivity talkableActivity9 = TalkableActivity.this;
                    talkableActivity9.mListView.refreshNormal(talkableActivity9.mListModel.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity talkableActivity10 = TalkableActivity.this;
            talkableActivity10.mListView.refreshNormal(talkableActivity10.mListModel.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17774e;

        public h(int i2) {
            this.f17774e = i2;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            TalkableActivity.this.reSendMsg(this.f17774e);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17776e;

        public i(int i2) {
            this.f17776e = i2;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            TalkableActivity.this.deleteMsg(this.f17776e);
        }
    }

    /* loaded from: classes4.dex */
    public interface j {
    }

    private void dealAlbumFromCamera(int i2, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), 12001, 12010, null, null, null, null, i2, str, str2, "")));
    }

    private void dealAlbumFromImage(Intent intent, int i2, String str, String str2) {
        String stringExtra;
        WriteImagesInfo writeImagesInfo;
        if (intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null || (writeImagesInfo = this.writeImagesInfo) == null) {
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
        this.mListModel.deleteMsg(i2);
    }

    private void initVoice() {
        if (this.mVoiceManager == null) {
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
        }
        this.mVoiceManager.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    private void prepage() {
        this.mListModel.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i2) {
        this.mListModel.reSendMsg(i2);
    }

    private void stopVoice() {
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
    }

    private void takePhoto() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mRecording && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.isNeedSaveDraft && this.mListView != null) {
            saveDraft();
        }
        super.finish();
    }

    public String[] getDialogOperationItems(int i2, boolean z) {
        String string;
        ArrayList arrayList = new ArrayList();
        if (i2 == 3) {
            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.copy));
            if (!z) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
            }
            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
        } else if (i2 == 4) {
            if (!z) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
            }
            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.save));
            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
        } else if (i2 == 5) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                string = TbadkCoreApplication.getInst().getString(R.string.group_close_receiver);
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.group_open_receiver);
            }
            arrayList.add(string);
            if (!z) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
            }
            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
        } else if (i2 == 15) {
            if (!z) {
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
            }
            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
        } else if (i2 != 17) {
            switch (i2) {
                case 7:
                    if (!z) {
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                    }
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                    break;
                case 8:
                case 9:
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                    break;
                case 10:
                    if (!z) {
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                    }
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                    break;
                case 11:
                    if (!z) {
                        arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                    }
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                    break;
            }
        } else {
            arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        return null;
    }

    @Override // d.a.i0.b1.m.h
    public ListView getListView() {
        AbsMsglistView absMsglistView = this.mListView;
        if (absMsglistView == null) {
            return null;
        }
        return absMsglistView.getMsgListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        View findViewWithTag;
        AbsMsglistView absMsglistView = this.mListView;
        if (absMsglistView == null || absMsglistView.getMsgListView() == null || (findViewWithTag = this.mListView.getMsgListView().findViewWithTag(voiceData$VoiceModel)) == null || !(findViewWithTag instanceof VoiceManager.i)) {
            return null;
        }
        return (VoiceManager.i) findViewWithTag;
    }

    public d.a.j0.d3.p0.a getRecorderManager() {
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return this.mVoiceManager.getRecorderManager();
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        return null;
    }

    @Override // d.a.i0.b1.m.h
    public int getRichTextViewId() {
        return 0;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        return null;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        return null;
    }

    public void initCallback() {
        this.mLocalPicModelCallback = new a();
    }

    public boolean isExStorageOk() {
        if (FileHelper.checkSD()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
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
                String string = TbadkCoreApplication.getInst().getString(R.string.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(R.string.cancel);
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
                    h0.b(new c(), new d(str, stringExtra));
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

    @Override // d.a.i0.b1.m.h
    public void onAtClicked(Context context, String str) {
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null || this.mListView == null) {
            return;
        }
        stopVoice();
        if (view == this.mListView.getBtnBack()) {
            this.mListView.sendmsgCloseSoftkey();
            finish();
        } else if (view == this.mListView.getLayNewMsg()) {
            this.mListView.refreshGo2New(this.mListModel.getData());
            this.mListView.closeNewMsg();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackIsSupportNight(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.preTime = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.preTime = System.currentTimeMillis();
        }
        this.mUploadProgressCallback = new b();
        initVoice();
        isExStorageOk();
        addGlobalLayoutListener();
        setSkinType(0);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
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

    @Override // d.a.i0.r.s.l.e
    public void onItemClick(l lVar, int i2, View view) {
        if (this.mListView.getMsgItemOperationDialog() != null && lVar.f() == this.mListView.getMsgItemOperationDialog().f()) {
            int intValue = ((Integer) lVar.f().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                operateMsgItem(intValue, charSequence);
                this.mListView.getMsgItemOperationDialog().dismiss();
            }
        }
    }

    public void onItemViewClick(View view, int i2, int i3, long j2) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        String content2;
        if (i2 == 1) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.sure_to_resend_this_message));
            aVar.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.msg_resend), new h(i3));
            aVar.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.delete), new i(i3));
            aVar.create(getPageContext()).show();
        } else if (i2 == 8) {
            ChatMessage msg3 = this.mListModel.getMsg(i3);
            if (msg3 == null || !d.a.j0.e1.w.c.r(msg3) || (msg = this.mListModel.getMsg(i3)) == null || (content = msg.getContent()) == null) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), d.a.c.e.m.b.d(optJSONObject.optString("activityId"), 0), d.a.c.e.m.b.f(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID), 0L), 2)));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (i2 == 15) {
            ChatMessage msg4 = this.mListModel.getMsg(i3);
            if (msg4 == null || msg4.getContent() == null) {
                return;
            }
            d.a.j0.e1.y.a aVar2 = new d.a.j0.e1.y.a();
            aVar2.c(msg4.getContent(), getClass().getName());
            if (aVar2.b() != 4 || aVar2.a() == null || StringUtils.isNull(((ShareFromFrsMsgData) aVar2.a()).getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar2.a()).getName(), null)));
        } else if (i2 == 5) {
            if (isExStorageOk() && (msg2 = this.mListModel.getMsg(i3)) != null && d.a.j0.e1.w.c.t(msg2)) {
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
                    d.a.j0.e1.y.a aVar3 = new d.a.j0.e1.y.a();
                    aVar3.c(msg5.getContent(), getClass().getName());
                    if (aVar3.b() == 1 && aVar3.a() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar3.a()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long f2 = d.a.c.e.m.b.f(theNewThemeId, 0L);
                            if (f2 <= 0) {
                                return;
                            }
                            sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), f2, ((ShareFromPBMsgData) aVar3.a()).getImageUrl())));
                            return;
                        } else if (StringUtils.isNull(((ShareFromPBMsgData) aVar3.a()).getThreadId())) {
                            return;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar3.a()).getThreadId(), ((ShareFromPBMsgData) aVar3.a()).getPostId(), null)));
                            return;
                        }
                    }
                    return;
                case 11:
                    if (!d.a.c.e.p.j.z()) {
                        showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                        return;
                    }
                    ChatMessage msg6 = this.mListModel.getMsg(i3);
                    if (msg6 == null || msg6.getContent() == null) {
                        return;
                    }
                    d.a.j0.e1.y.a aVar4 = new d.a.j0.e1.y.a();
                    aVar4.c(msg6.getContent(), getClass().getName());
                    if (aVar4.b() == 1 && aVar4.a() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, aVar4));
                        return;
                    }
                    return;
                case 12:
                    if (!d.a.c.e.p.j.z()) {
                        showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                        return;
                    }
                    ChatMessage msg7 = this.mListModel.getMsg(i3);
                    if (msg7 == null || msg7.getContent() == null) {
                        return;
                    }
                    d.a.j0.e1.y.a aVar5 = new d.a.j0.e1.y.a();
                    aVar5.c(msg7.getContent(), getClass().getName());
                    if (aVar5.b() == 1 && aVar5.a() != null) {
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar5.a()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                case 13:
                    if (!d.a.c.e.p.j.z()) {
                        showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
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
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
        }
    }

    public void onItemViewLongClick(View view, int i2, int i3, long j2) {
        this.mLastLongClickItem = view;
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
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

    public void onLinkButtonClicked(Context context, String str) {
    }

    @Override // d.a.i0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z) {
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.preTime = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.preTime = System.currentTimeMillis();
        }
        initVoice();
        isExStorageOk();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isForeground = false;
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    @Override // d.a.i0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (PermissionUtil.checkCamera(getApplicationContext())) {
                SelectImageHelper.takePhoto(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (!transformPermissionResult.containsKey(StorageUtils.EXTERNAL_STORAGE_PERMISSION) || transformPermissionResult.get(StorageUtils.EXTERNAL_STORAGE_PERMISSION).booleanValue()) {
                return;
            }
            showToast(R.string.sdcard_permission_denied_advert_for_camera);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isForeground = true;
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
            this.mVoiceManager.setSpeakerphoneOn(true ^ TbadkCoreApplication.getInst().isHeadsetModeOn());
        }
        registerListener(this.richTextIntentClickListener);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        this.mListView.closeNewMsg();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.s
    public void onScrollToTop() {
        prepage();
    }

    @Override // d.a.i0.b1.m.h
    public void onSongClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.mListView.getBtnSendVoice()) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            this.mPermissionJudgement.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return false;
            }
            d.a.j0.d3.p0.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.mVoiceManager == null || !recorderManager.f()) {
                    return true;
                }
                recorderManager.b(this.mListView, -1);
                this.mListView.closeRecordCancel();
                this.mListView.refreshSendVoiceText(true);
                this.mListView.startRecordVoice();
                this.mRecording = true;
            } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (motionEvent.getAction() == 2) {
                    if (motionEvent.getY() < d.a.c.e.p.l.e(getPageContext().getContext(), 5.0f) * (-1)) {
                        this.mListView.showRecordCancel();
                        this.mListView.stopRecordVoice();
                        this.mRecording = false;
                    } else {
                        this.mListView.closeRecordCancel();
                        this.mListView.startRecordVoice();
                    }
                }
            } else {
                if (motionEvent.getY() < d.a.c.e.p.l.e(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.d();
                    }
                    this.mListView.closeRecordCancel();
                } else if (!this.isForeground) {
                    if (recorderManager != null) {
                        recorderManager.d();
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

    @Override // d.a.i0.b1.m.h
    public void onVideoClicked(Context context, String str) {
    }

    @Override // d.a.i0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
    }

    public void openImageView() {
        if (isExStorageOk()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    public void operateMsgItem(int i2, String str) {
        VoiceManager voiceManager;
        ChatMessage msg = this.mListModel.getMsg(i2);
        if (str.equals(TbadkCoreApplication.getInst().getString(R.string.copy))) {
            if (msg == null || msg.getCacheData() == null) {
                return;
            }
            d.a.c.e.p.a.a(msg.getContent());
            showToast(R.string.op_result_copied);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.msg_at))) {
            if (msg == null || msg.getUserInfo() == null || msg.getUserInfo().getUserName() == null) {
                return;
            }
            this.mListView.addAt2SendMsg(msg.getUserInfo().getUserName());
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.delete))) {
            View view = this.mLastLongClickItem;
            if ((view instanceof ChatVoiceView) && ((ChatVoiceView) view).isPlaying() && (voiceManager = this.mVoiceManager) != null) {
                voiceManager.stopPlay();
            }
            this.mListModel.markDeleteMsg(i2);
            showToast(R.string.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.save))) {
            String f2 = d.a.j0.e1.w.c.f(msg.getContent(), true);
            if (f2 == null) {
                return;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return;
            }
            d.a.j0.e1.f.g gVar = new d.a.j0.e1.f.g(f2, this);
            this.mSaveImageTask = gVar;
            gVar.c();
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(R.string.group_close_receiver))) {
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

    public boolean saveDraft() {
        return this.mListModel.saveDraft(this.mListView.getDraft());
    }

    public void sendBigEmotionMsg(v vVar) {
        this.mListModel.sendBigEmotionMessage(vVar);
    }

    public void sendTextMsg() {
        String beforeSendMsgText = this.mListView.beforeSendMsgText();
        if (TextUtils.isEmpty(beforeSendMsgText)) {
            return;
        }
        this.mListView.afterSendMsgText();
        this.handler.postDelayed(new f(beforeSendMsgText), 100L);
    }

    public void setImageSendAuthInIM(j jVar) {
        this.mImageSendAuthInIM = jVar;
    }

    public void setListModel(MsglistModel msglistModel) {
        this.mListModel = msglistModel;
    }

    public void setMsgListView(AbsMsglistView absMsglistView) {
        this.mListView = absMsglistView;
    }
}
