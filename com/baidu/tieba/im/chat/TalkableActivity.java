package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.ae;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, com.baidu.adp.widget.ListView.ab, ae, com.baidu.tbadk.core.dialog.l, com.baidu.tbadk.core.voice.o, com.baidu.tbadk.widget.richText.j {
    protected static final int RECORD_MOVE_OUTSIDE_RANGE = 5;
    private static final String REF_TYPE_IM = "2000801";
    protected static final String TIEBA_URL = "http://tieba.baidu.com/";
    private boolean isForeground;
    protected boolean mIsCurrentUser;
    private View mLastLongClickItem;
    private boolean mRecording;
    protected VoiceManager mVoiceManager;
    protected Handler handler = new Handler();
    protected AbsMsglistView mListView = null;
    protected MsglistModel mListModel = null;
    protected LocalPicModel mLocalPicModel = null;
    protected com.baidu.adp.base.i mLocalPicModelCallback = null;
    protected ct mSaveImageTask = null;
    protected com.baidu.tbadk.img.b<ChatMessage> mUploadProgressCallback = null;
    private long preTime = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    protected com.baidu.adp.base.i mMsgCallback = new cw(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void initCallback() {
        this.mLocalPicModelCallback = new cx(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.preTime = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.preTime = System.currentTimeMillis();
        }
        this.mUploadProgressCallback = new cy(this);
        initVoice();
        isExStorageOk();
        addGlobalLayoutListener();
        setSkinType(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12010 || i == 12009) {
                String stringExtra = intent.getStringExtra("file_name");
                String str = TbConfig.LOCAL_PIC_DIR;
                if (stringExtra == null) {
                    stringExtra = TbConfig.IMAGE_RESIZED_FILE;
                    str = null;
                }
                if (this.mLocalPicModel != null) {
                    this.mLocalPicModel.cancelLoadData();
                    this.mLocalPicModel = null;
                }
                this.mLocalPicModel = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.mLocalPicModel.setLoadDataCallBack(this.mLocalPicModelCallback);
                this.mLocalPicModel.getData();
                this.mListView.hideMore();
                return;
            }
            int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
            String string = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.send_msg);
            String string2 = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.cancel);
            if (i == 12002 && intent != null) {
                if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                    dealAlbumFromCamera(maxChatImageWidthInPx, string, string2);
                } else {
                    dealAlbumFromImage(intent, maxChatImageWidthInPx, string, string2);
                }
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tbadk.core.util.bb.a(getPageContext());
            } else if (i == 12009) {
                com.baidu.tbadk.core.util.bb.p(getPageContext().getPageActivity());
            }
        }
    }

    private void dealAlbumFromImage(Intent intent, int i, String str, String str2) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), 12002, 12009, null, null, null, null, i, str, str2, "", this.writeImagesInfo.getChosedFiles().get(0).getFilePath())));
                this.writeImagesInfo.clear();
            }
        }
    }

    private void dealAlbumFromCamera(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), 12001, 12010, null, null, null, null, i, str, str2, "")));
    }

    public void onItemViewLongClick(View view, int i, int i2, long j) {
        this.mLastLongClickItem = view;
        ChatMessage msg = this.mListModel.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.mIsCurrentUser = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11) {
                this.mListView.showDiaItemContentOperate(i2, getDialogOperationItems(i, this.mIsCurrentUser));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] getDialogOperationItems(int i, boolean z) {
        String string;
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.operate_copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_img_save));
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_delete));
                break;
            case 5:
                if (TbadkCoreApplication.m255getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.group_close_receiver);
                } else {
                    string = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.group_open_receiver);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isForeground = false;
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        if (this.mListView == null || this.mListView.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.mListView.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tbadk.core.voice.m)) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.m) findViewWithTag;
    }

    private void initVoice() {
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.mVoiceManager.setSpeakerphoneOn(!TbadkCoreApplication.m255getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public ListView getListView() {
        if (this.mListView == null) {
            return null;
        }
        return this.mListView.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onAtClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onLinkClicked(Context context, String str) {
        com.baidu.tbadk.core.util.bm.pV().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onSongClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoP2PClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.mListView != null) {
                saveDraft();
            }
            if (this.mListView != null && this.mListView.isMoreVisible()) {
                this.mListView.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected boolean saveDraft() {
        return this.mListModel.saveDraft(this.mListView.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isForeground = true;
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
            this.mVoiceManager.setSpeakerphoneOn(TbadkCoreApplication.m255getInst().isHeadsetModeOn() ? false : true);
        }
        if (this.mListView != null && this.mListView.getAdapter() != null) {
            this.mListView.getAdapter().clearStatContainer();
        }
    }

    private void stopVoice() {
        if (this.mVoiceManager != null) {
            this.mVoiceManager.stopPlay();
        }
    }

    public boolean isExStorageOk() {
        if (com.baidu.tbadk.core.util.s.bL()) {
            return true;
        }
        showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendTextMsg() {
        String beforeSendMsgText = this.mListView.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.mListView.afterSendMsgText();
            this.handler.postDelayed(new cz(this, beforeSendMsgText), 100L);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.mListView != null) {
            stopVoice();
            if (view == this.mListView.getBtnBack()) {
                saveDraft();
                this.mListView.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.mListView.getBtnImage()) {
                if (isExStorageOk()) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), "");
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            } else if (view == this.mListView.getBtnSend()) {
                sendTextMsg();
            } else if (view == this.mListView.getLayNewMsg()) {
                this.mListView.refreshGo2New(this.mListModel.getData());
                this.mListView.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mRecording && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.mListView.getBtnSendVoice()) {
            if (motionEvent.getAction() == 0) {
                if (this.mVoiceManager == null || !this.mVoiceManager.isAllowRecord()) {
                    return true;
                }
                this.mVoiceManager.startRecord(this.mListView, -1);
                this.mListView.closeRecordCancel();
                this.mListView.refreshSendVoiceText(true);
                this.mListView.startRecordVoice();
                this.mRecording = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (this.mVoiceManager != null) {
                        this.mVoiceManager.cancelRecord();
                    }
                    this.mListView.closeRecordCancel();
                } else if (!this.isForeground) {
                    if (this.mVoiceManager != null) {
                        this.mVoiceManager.cancelRecord();
                    }
                    this.mListView.stopRecordVoice();
                } else {
                    if (this.mVoiceManager != null) {
                        this.mVoiceManager.stopRecord();
                    }
                    this.mListView.stopRecordVoice();
                }
                this.mListView.refreshSendVoiceText(false);
                this.mRecording = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.mListView.showRecordCancel();
                    this.mListView.stopRecordVoice();
                    this.mRecording = false;
                    return true;
                }
                this.mListView.closeRecordCancel();
                this.mListView.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void sendBigEmotionMsg(com.baidu.tbadk.coreExtra.data.f fVar) {
        this.mListModel.sendBigEmotionMessage(fVar);
    }

    @Override // com.baidu.adp.widget.ListView.ae
    public void onScrollToTop() {
        prepage();
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        this.mListView.closeNewMsg();
    }

    private void prepage() {
        this.mListModel.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mListModel != null) {
            this.mListModel.onDestroy();
        }
        super.onDestroy();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        if (this.mSaveImageTask != null) {
            this.mSaveImageTask = null;
        }
        if (this.mLocalPicModel != null) {
            this.mLocalPicModel.cancelLoadData();
            this.mLocalPicModel = null;
        }
        if (this.mListView != null) {
            this.mListView.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.l
    public void itemClick(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        if (iVar == this.mListView.getMsgItemOperationDialog()) {
            int intValue = ((Integer) iVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    operateMsgItem(intValue, charSequence);
                    this.mListView.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void operateMsgItem(int i, String str) {
        ChatMessage msg = this.mListModel.getMsg(i);
        if (str.equals(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.operate_copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.copyToClipboard(msg.getContent());
                showToast(com.baidu.tieba.z.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.mListView.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_delete))) {
            if ((this.mLastLongClickItem instanceof ChatVoiceView) && ((ChatVoiceView) this.mLastLongClickItem).isPlaying() && this.mVoiceManager != null) {
                this.mVoiceManager.stopPlay();
            }
            this.mListModel.markDeleteMsg(i);
            showToast(com.baidu.tieba.z.op_result_deleted);
        } else if (str.equals(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_img_save))) {
            String s = com.baidu.tieba.im.util.i.s(msg.getContent(), true);
            if (s != null) {
                this.mSaveImageTask = new ct(s, this);
                this.mSaveImageTask.execute();
            }
        } else if (str.equals(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.group_open_receiver)) || str.equals(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.group_close_receiver))) {
            if (TbadkCoreApplication.m255getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.m255getInst().setHeadsetModeOn(false);
                this.mVoiceManager.setSpeakerphoneOn(true);
                this.mListView.closeReceiver();
                return;
            }
            TbadkCoreApplication.m255getInst().setHeadsetModeOn(true);
            this.mVoiceManager.setSpeakerphoneOn(false);
            this.mListView.showReceiver();
        }
    }

    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getContext());
                builder.setMessage(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.operation));
                builder.setPositiveButton(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.msg_resend), new da(this, i2));
                builder.setNegativeButton(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.delete), new db(this, i2));
                builder.create().show();
                return;
            case 2:
            case 3:
            case 4:
            case 7:
            case 9:
            default:
                return;
            case 5:
                if (!isExStorageOk() || (msg2 = this.mListModel.getMsg(i2)) == null || !com.baidu.tieba.im.util.i.q(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.mListModel.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.i.s(msg3) && (msg = this.mListModel.getMsg(i2)) != null && (content = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), com.baidu.adp.lib.g.c.toInt(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.g.c.a(optJSONObject.optString("groupId"), 0L), 2)));
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            case 10:
                ChatMessage msg4 = this.mListModel.getMsg(i2);
                if (msg4 != null && msg4.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar = new com.baidu.tieba.im.widget.a();
                    aVar.aL(msg4.getContent(), getClass().getName());
                    if (aVar.TM() == 1 && aVar.TN() != null) {
                        if (!TextUtils.isEmpty(((ShareFromPBMsgData) aVar.TN()).getThreadId()) || !TextUtils.isEmpty(((ShareFromPBMsgData) aVar.TN()).getPostId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar.TN()).getThreadId(), ((ShareFromPBMsgData) aVar.TN()).getPostId(), null)));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.i.ff()) {
                    showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.mListModel.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.aL(msg5.getContent(), getClass().getName());
                    if (aVar2.TM() == 1 && aVar2.TN() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001262, aVar2));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.i.ff()) {
                    showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.mListModel.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.aL(msg6.getContent(), getClass().getName());
                    if (aVar3.TM() == 1 && aVar3.TN() != null) {
                        String shareSourceUrl = ((ShareFromGameCenterMsgData) aVar3.TN()).getShareSourceUrl();
                        if (!TextUtils.isEmpty(shareSourceUrl) && shareSourceUrl.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, shareSourceUrl);
                            return;
                        }
                        String iu = com.baidu.tieba.tbadkCore.util.k.iu(shareSourceUrl);
                        sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(getPageContext().getPageActivity(), iu, REF_TYPE_IM)));
                        TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, iu);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.i.ff()) {
                    showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.mListModel.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        String optString = new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl");
                        if (!TextUtils.isEmpty(optString) && optString.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, optString);
                        } else {
                            String iu2 = com.baidu.tieba.tbadkCore.util.k.iu(optString);
                            sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(getPageContext().getPageActivity(), iu2, REF_TYPE_IM)));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, iu2);
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            case 14:
                ChatMessage msg8 = this.mListModel.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.chat.stranger.c gf = com.baidu.tieba.im.chat.stranger.b.gf(msg8.getContent());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(gf.threadId, gf.postId, null)));
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.mListModel.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.mListModel.deleteMsg(i);
    }
}
