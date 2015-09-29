package com.baidu.tieba.im.chat;

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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.a;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, BdListView.e, BdListView.h, c.b, VoiceManager.c, com.baidu.tbadk.widget.richText.i {
    protected static final int RECORD_MOVE_OUTSIDE_RANGE = 5;
    private static final String REF_TYPE_IM = "2000801";
    protected static final String TIEBA_URL = "http://tieba.baidu.com/";
    private boolean isForeground;
    private a mImageSendAuthInIM;
    protected boolean mIsCurrentUser;
    private View mLastLongClickItem;
    private boolean mRecording;
    protected VoiceManager mVoiceManager;
    protected Handler handler = new Handler();
    protected AbsMsglistView mListView = null;
    protected MsglistModel mListModel = null;
    protected LocalPicModel mLocalPicModel = null;
    protected com.baidu.adp.base.g mLocalPicModelCallback = null;
    protected bo mSaveImageTask = null;
    protected a.InterfaceC0050a<ChatMessage> mUploadProgressCallback = null;
    private long preTime = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean isNeedSaveDraft = true;
    private CustomMessageListener richTextIntentClickListener = new br(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    protected com.baidu.adp.base.g mMsgCallback = new bs(this);

    /* loaded from: classes.dex */
    public interface a {
    }

    public void setImageSendAuthInIM(a aVar) {
        this.mImageSendAuthInIM = aVar;
    }

    protected void setMsgListView(AbsMsglistView absMsglistView) {
        this.mListView = absMsglistView;
    }

    protected void setListModel(MsglistModel msglistModel) {
        this.mListModel = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initCallback() {
        this.mLocalPicModelCallback = new bt(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        this.mUploadProgressCallback = new bu(this);
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
            String string = TbadkCoreApplication.m411getInst().getString(i.h.send_msg);
            String string2 = TbadkCoreApplication.m411getInst().getString(i.h.cancel);
            if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        dealAlbumFromCamera(maxChatImageWidthInPx, string, string2);
                    } else {
                        dealAlbumFromImage(intent, maxChatImageWidthInPx, string, string2);
                    }
                }
            } else if (i == 12001) {
                dealAlbumFromCamera(maxChatImageWidthInPx, string, string2);
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tbadk.core.util.al.c(getPageContext());
            } else if (i == 12009) {
                openImageView();
            }
        }
    }

    private void dealAlbumFromImage(Intent intent, int i, String str, String str2) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteImageActivityConfig(getPageContext().getContext(), 12002, 12009, null, null, null, null, i, str, str2, "", this.writeImagesInfo.getChosedFiles().get(0).getFilePath())));
                this.writeImagesInfo.clear();
            }
        }
    }

    private void dealAlbumFromCamera(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteImageActivityConfig(getPageContext().getContext(), 12001, 12010, null, null, null, null, i, str, str2, "")));
    }

    public void onItemViewLongClick(View view, int i, int i2, long j) {
        this.mLastLongClickItem = view;
        ChatMessage msg = this.mListModel.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.mIsCurrentUser = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11) {
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
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.operate_copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_img_save));
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete));
                break;
            case 5:
                if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.m411getInst().getString(i.h.group_close_receiver);
                } else {
                    string = TbadkCoreApplication.m411getInst().getString(i.h.group_open_receiver);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete));
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
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
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        if (this.mListView == null || this.mListView.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.mListView.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void initVoice() {
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.mVoiceManager.setSpeakerphoneOn(!TbadkCoreApplication.m411getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.mListView == null) {
            return null;
        }
        return this.mListView.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int getRichTextViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onAtClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onLinkClicked(Context context, String str) {
        com.baidu.tbadk.core.util.ay.uV().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onVideoClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onSongClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onVideoP2PClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.mListView != null && this.mListView.isMoreVisible()) {
                this.mListView.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.isNeedSaveDraft && this.mListView != null) {
            saveDraft();
        }
        super.finish();
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
            this.mVoiceManager.setSpeakerphoneOn(TbadkCoreApplication.m411getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.richTextIntentClickListener);
    }

    private void stopVoice() {
        if (this.mVoiceManager != null) {
            this.mVoiceManager.stopPlay();
        }
    }

    public boolean isExStorageOk() {
        if (com.baidu.tbadk.core.util.n.fi()) {
            return true;
        }
        showToast(TbadkCoreApplication.m411getInst().getString(i.h.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendTextMsg() {
        String beforeSendMsgText = this.mListView.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.mListView.afterSendMsgText();
            this.handler.postDelayed(new bv(this, beforeSendMsgText), 100L);
        }
    }

    public void openImageView() {
        if (isExStorageOk()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), "", false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.mListView != null) {
            stopVoice();
            if (view == this.mListView.getBtnBack()) {
                this.mListView.sendmsgCloseSoftkey();
                finish();
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
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.mVoiceManager == null || !recorderManager.ou()) {
                    return true;
                }
                recorderManager.a(this.mListView, -1);
                this.mListView.closeRecordCancel();
                this.mListView.refreshSendVoiceText(true);
                this.mListView.startRecordVoice();
                this.mRecording = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.ot();
                    }
                    this.mListView.closeRecordCancel();
                } else if (!this.isForeground) {
                    if (recorderManager != null) {
                        recorderManager.ot();
                    }
                    this.mListView.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.ov();
                    }
                    this.mListView.stopRecordVoice();
                }
                this.mListView.refreshSendVoiceText(false);
                this.mRecording = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
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

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        prepage();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
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

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar == this.mListView.getMsgItemOperationDialog()) {
            int intValue = ((Integer) cVar.getRootView().getTag()).intValue();
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
        if (str.equals(TbadkCoreApplication.m411getInst().getString(i.h.operate_copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aA(msg.getContent());
                showToast(i.h.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(i.h.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.mListView.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(i.h.msg_delete))) {
            if ((this.mLastLongClickItem instanceof ChatVoiceView) && ((ChatVoiceView) this.mLastLongClickItem).isPlaying() && this.mVoiceManager != null) {
                this.mVoiceManager.stopPlay();
            }
            this.mListModel.markDeleteMsg(i);
            showToast(i.h.op_result_deleted);
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(i.h.msg_img_save))) {
            String x = com.baidu.tieba.im.util.h.x(msg.getContent(), true);
            if (x != null) {
                this.mSaveImageTask = new bo(x, this);
                this.mSaveImageTask.execute();
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(i.h.group_open_receiver)) || str.equals(TbadkCoreApplication.m411getInst().getString(i.h.group_close_receiver))) {
            if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.m411getInst().setHeadsetModeOn(false);
                this.mVoiceManager.setSpeakerphoneOn(true);
                this.mListView.closeReceiver();
                return;
            }
            TbadkCoreApplication.m411getInst().setHeadsetModeOn(true);
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
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ct(TbadkCoreApplication.m411getInst().getString(i.h.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.msg_resend), new bw(this, i2));
                aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.delete), new bx(this, i2));
                aVar.b(getPageContext()).sR();
                return;
            case 2:
            case 3:
            case 4:
            case 7:
            case 9:
            case 14:
            default:
                return;
            case 5:
                if (!isExStorageOk() || (msg2 = this.mListModel.getMsg(i2)) == null || !com.baidu.tieba.im.util.h.r(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.mListModel.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.h.t(msg3) && (msg = this.mListModel.getMsg(i2)) != null && (content = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getContext(), com.baidu.adp.lib.g.b.g(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.g.b.c(optJSONObject.optString("groupId"), 0L), 2)));
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
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.aP(msg4.getContent(), getClass().getName());
                    if (aVar2.XA() == 1 && aVar2.XB() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.XB()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.XB()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.XB()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.XB()).getThreadId(), ((ShareFromPBMsgData) aVar2.XB()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.i.iM()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(i.h.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.mListModel.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.aP(msg5.getContent(), getClass().getName());
                    if (aVar3.XA() == 1 && aVar3.XB() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.i.iM()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(i.h.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.mListModel.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.aP(msg6.getContent(), getClass().getName());
                    if (aVar4.XA() == 1 && aVar4.XB() != null) {
                        String shareSourceUrl = ((ShareFromGameCenterMsgData) aVar4.XB()).getShareSourceUrl();
                        if (!TextUtils.isEmpty(shareSourceUrl) && shareSourceUrl.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, shareSourceUrl);
                            return;
                        }
                        String lF = com.baidu.tieba.tbadkCore.util.n.lF(shareSourceUrl);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), lF, REF_TYPE_IM)));
                        TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, lF);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.i.iM()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(i.h.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.mListModel.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        String optString = new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl");
                        if (!TextUtils.isEmpty(optString) && optString.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, optString);
                        } else {
                            String lF2 = com.baidu.tieba.tbadkCore.util.n.lF(optString);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), lF2, REF_TYPE_IM)));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, lF2);
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.mListModel.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.aP(msg8.getContent(), getClass().getName());
                    if (aVar5.XA() == 4 && aVar5.XB() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.XB()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.XB()).getName(), null)));
                        return;
                    }
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

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.mVoiceManager == null || this.mVoiceManager.getRecorderManager() == null) {
            return null;
        }
        return this.mVoiceManager.getRecorderManager();
    }
}
