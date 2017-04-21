package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.a.a.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, a.InterfaceC0000a, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, BdListView.e, BdListView.h, c.b, VoiceManager.c, com.baidu.tbadk.widget.richText.d {
    protected com.baidu.adp.lib.e.b<View> aNu;
    protected VoiceManager bOT;
    protected boolean cQP;
    private boolean cQQ;
    private View cQT;
    private boolean cQX;
    protected Handler handler = new Handler();
    protected AbsMsglistView cQK = null;
    protected MsglistModel cQL = null;
    protected LocalPicModel cQM = null;
    protected com.baidu.adp.base.f cQN = null;
    protected bo cQO = null;
    protected a.InterfaceC0042a<ChatMessage> cQR = null;
    private long cQS = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean cQU = true;
    private CustomMessageListener cQV = new br(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    protected com.baidu.adp.base.f cQW = new bs(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoz() {
        this.cQN = new bt(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackIsSupportNight(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.cQS = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.cQS = System.currentTimeMillis();
        }
        this.cQR = new bu(this);
        aoA();
        aoC();
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
                if (this.cQM != null) {
                    this.cQM.cancelLoadData();
                    this.cQM = null;
                }
                this.cQM = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.cQM.setLoadDataCallBack(this.cQN);
                this.cQM.getData();
                this.cQK.hideMore();
                return;
            }
            int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
            String string = TbadkCoreApplication.m9getInst().getString(w.l.send_msg);
            String string2 = TbadkCoreApplication.m9getInst().getString(w.l.cancel);
            if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        d(maxChatImageWidthInPx, string, string2);
                    } else {
                        a(intent, maxChatImageWidthInPx, string, string2);
                    }
                }
            } else if (i == 12001) {
                d(maxChatImageWidthInPx, string, string2);
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                Qz();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                aoE();
            }
        }
    }

    private void Qz() {
        if (!ae.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ap.c(getPageContext());
        }
    }

    private void a(Intent intent, int i, String str, String str2) {
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

    private void d(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteImageActivityConfig(getPageContext().getContext(), 12001, 12010, null, null, null, null, i, str, str2, "")));
    }

    public void b(View view, int i, int i2, long j) {
        this.cQT = view;
        ChatMessage msg = this.cQL.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.cQP = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.cQK.showDiaItemContentOperate(i2, r(i, this.cQP));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] r(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.save));
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
            case 5:
                arrayList.add(TbadkCoreApplication.m9getInst().isHeadsetModeOn() ? TbadkCoreApplication.m9getInst().getString(w.l.group_close_receiver) : TbadkCoreApplication.m9getInst().getString(w.l.group_open_receiver));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(w.l.delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.cQS = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.cQS = System.currentTimeMillis();
        }
        aoA();
        aoC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bOT != null) {
            this.bOT.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cQQ = false;
        if (this.bOT != null) {
            this.bOT.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cQV);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bOT;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.cQK == null || this.cQK.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.cQK.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void aoA() {
        if (this.bOT == null) {
            this.bOT = new VoiceManager();
            this.bOT.onCreate(getPageContext());
        }
        this.bOT.setSpeakerphoneOn(!TbadkCoreApplication.m9getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.cQK == null) {
            return null;
        }
        return this.cQK.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void f(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.cQK != null && this.cQK.isMoreVisible()) {
                this.cQK.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.cQU && this.cQK != null) {
            aoB();
        }
        super.finish();
    }

    protected boolean aoB() {
        return this.cQL.saveDraft(this.cQK.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bOT != null) {
            this.bOT.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cQQ = true;
        if (this.bOT != null) {
            this.bOT.onResume(getPageContext());
            this.bOT.setSpeakerphoneOn(TbadkCoreApplication.m9getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.cQV);
    }

    private void aaq() {
        if (this.bOT != null) {
            this.bOT.stopPlay();
        }
    }

    public boolean aoC() {
        if (com.baidu.tbadk.core.util.l.dH()) {
            return true;
        }
        showToast(TbadkCoreApplication.m9getInst().getString(w.l.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoD() {
        String beforeSendMsgText = this.cQK.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.cQK.afterSendMsgText();
            this.handler.postDelayed(new bv(this, beforeSendMsgText), 100L);
        }
    }

    public void aoE() {
        if (aoC()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.cQK != null) {
            aaq();
            if (view == this.cQK.getBtnBack()) {
                this.cQK.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.cQK.getLayNewMsg()) {
                this.cQK.refreshGo2New(this.cQL.getData());
                this.cQK.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.bOT != null) {
            this.bOT.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cQX && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.cQK.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.bOT == null || !recorderManager.mo()) {
                    return true;
                }
                recorderManager.a(this.cQK, -1);
                this.cQK.closeRecordCancel();
                this.cQK.refreshSendVoiceText(true);
                this.cQK.startRecordVoice();
                this.cQX = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.mn();
                    }
                    this.cQK.closeRecordCancel();
                } else if (!this.cQQ) {
                    if (recorderManager != null) {
                        recorderManager.mn();
                    }
                    this.cQK.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.cQK.stopRecordVoice();
                }
                this.cQK.refreshSendVoiceText(false);
                this.cQX = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.cQK.showRecordCancel();
                    this.cQK.stopRecordVoice();
                    this.cQX = false;
                    return true;
                }
                this.cQK.closeRecordCancel();
                this.cQK.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.tbadk.coreExtra.data.l lVar) {
        this.cQL.sendBigEmotionMessage(lVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void lp() {
        aoF();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lo() {
        this.cQK.closeNewMsg();
    }

    private void aoF() {
        this.cQL.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cQL != null) {
            this.cQL.onDestroy();
        }
        super.onDestroy();
        if (this.bOT != null) {
            this.bOT.onDestory(getPageContext());
        }
        if (this.cQO != null) {
            this.cQO = null;
        }
        if (this.cQM != null) {
            this.cQM.cancelLoadData();
            this.cQM = null;
        }
        if (this.cQK != null) {
            this.cQK.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar == this.cQK.getMsgItemOperationDialog()) {
            int intValue = ((Integer) cVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    z(intValue, charSequence);
                    this.cQK.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void z(int i, String str) {
        ChatMessage msg = this.cQL.getMsg(i);
        if (str.equals(TbadkCoreApplication.m9getInst().getString(w.l.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.ao(msg.getContent());
                showToast(w.l.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(w.l.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.cQK.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(w.l.delete))) {
            if ((this.cQT instanceof ChatVoiceView) && ((ChatVoiceView) this.cQT).isPlaying() && this.bOT != null) {
                this.bOT.stopPlay();
            }
            this.cQL.markDeleteMsg(i);
            showToast(w.l.delete_success);
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(w.l.save))) {
            String I = com.baidu.tieba.im.util.h.I(msg.getContent(), true);
            if (I != null) {
                this.cQO = new bo(I, this);
                this.cQO.execute();
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(w.l.group_open_receiver)) || str.equals(TbadkCoreApplication.m9getInst().getString(w.l.group_close_receiver))) {
            if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.m9getInst().setHeadsetModeOn(false);
                this.bOT.setSpeakerphoneOn(true);
                this.cQK.closeReceiver();
                return;
            }
            TbadkCoreApplication.m9getInst().setHeadsetModeOn(true);
            this.bOT.setSpeakerphoneOn(false);
            this.cQK.showReceiver();
        }
    }

    public void a(View view, int i, int i2, long j) {
        String content;
        ChatMessage msg;
        String content2;
        ChatMessage msg2;
        switch (i) {
            case 1:
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cE(TbadkCoreApplication.m9getInst().getString(w.l.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.m9getInst().getString(w.l.msg_resend), new bw(this, i2));
                aVar.b(TbadkCoreApplication.m9getInst().getString(w.l.delete), new bx(this, i2));
                aVar.b(getPageContext()).tQ();
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
                if (!aoC() || (msg2 = this.cQL.getMsg(i2)) == null || !com.baidu.tieba.im.util.h.s(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.cQL.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.h.u(msg3) && (msg = this.cQL.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content2).optJSONObject("eventParam");
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
                ChatMessage msg4 = this.cQL.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bk(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.auU() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.auU()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.auU()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.auU()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.auU()).getThreadType() == 33) {
                                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.auU()).getThreadId()).pE()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.auU()).getThreadId(), ((ShareFromPBMsgData) aVar2.auU()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.i.hk()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(w.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.cQL.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bk(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.auU() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.i.hk()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(w.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.cQL.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bk(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.auU() != null) {
                        com.baidu.tbadk.core.util.bb.wn().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.auU()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.i.hk()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(w.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.cQL.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        com.baidu.tbadk.core.util.bb.wn().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.cQL.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bk(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.auU() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.auU()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.auU()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.cQL.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.cQL.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.bOT == null || this.bOT.getRecorderManager() == null) {
            return null;
        }
        return this.bOT.getRecorderManager();
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.aA(getApplicationContext())) {
                com.baidu.tbadk.core.util.ap.c(getPageContext());
            } else {
                showToast(w.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ae.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(w.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aNu == null) {
            this.aNu = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 8);
        }
        return this.aNu;
    }
}
