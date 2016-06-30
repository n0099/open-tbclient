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
import com.baidu.tbadk.core.atomData.EcommOrderDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.DealInfoIMData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
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
import com.baidu.tieba.u;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, a.InterfaceC0000a, com.baidu.adp.lib.d.a, com.baidu.adp.lib.d.b, BdListView.e, BdListView.h, c.b, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    protected com.baidu.adp.lib.f.b<View> aFl;
    protected VoiceManager bBm;
    protected boolean cFV;
    private boolean cFW;
    private View cFZ;
    private boolean cGd;
    protected Handler handler = new Handler();
    protected AbsMsglistView cFQ = null;
    protected MsglistModel cFR = null;
    protected LocalPicModel cFS = null;
    protected com.baidu.adp.base.g cFT = null;
    protected bp cFU = null;
    protected a.InterfaceC0044a<ChatMessage> cFX = null;
    private long cFY = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean cGa = true;
    private CustomMessageListener cGb = new bs(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    protected com.baidu.adp.base.g cGc = new bt(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void akH() {
        this.cFT = new bu(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackIsSupportNight(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.cFY = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.cFY = System.currentTimeMillis();
        }
        this.cFX = new bv(this);
        akI();
        akK();
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
                if (this.cFS != null) {
                    this.cFS.cancelLoadData();
                    this.cFS = null;
                }
                this.cFS = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.cFS.setLoadDataCallBack(this.cFT);
                this.cFS.getData();
                this.cFQ.hideMore();
                return;
            }
            int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
            String string = TbadkCoreApplication.m9getInst().getString(u.j.send_msg);
            String string2 = TbadkCoreApplication.m9getInst().getString(u.j.cancel);
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
                VM();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                akM();
            }
        }
    }

    private void VM() {
        if (!ag.c(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.au.c(getPageContext());
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
        this.cFZ = view;
        ChatMessage msg = this.cFR.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.cFV = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 16 || i == 17) {
                this.cFQ.showDiaItemContentOperate(i2, C(i, this.cFV));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] C(int i, boolean z) {
        String string;
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.operate_copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_img_save));
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 5:
                if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.m9getInst().getString(u.j.group_close_receiver);
                } else {
                    string = TbadkCoreApplication.m9getInst().getString(u.j.group_open_receiver);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 16:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.cFY = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.cFY = System.currentTimeMillis();
        }
        akI();
        akK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bBm != null) {
            this.bBm.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cFW = false;
        if (this.bBm != null) {
            this.bBm.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cGb);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bBm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.cFQ == null || this.cFQ.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.cFQ.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void akI() {
        this.bBm = new VoiceManager();
        this.bBm.onCreate(getPageContext());
        this.bBm.setSpeakerphoneOn(!TbadkCoreApplication.m9getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public ListView getListView() {
        if (this.cFQ == null) {
            return null;
        }
        return this.cFQ.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int Hg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> Hh() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Hi() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Hj() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hk() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> Hl() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        com.baidu.tbadk.core.util.bi.us().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void E(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void d(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.cFQ != null && this.cFQ.isMoreVisible()) {
                this.cFQ.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.cGa && this.cFQ != null) {
            akJ();
        }
        super.finish();
    }

    protected boolean akJ() {
        return this.cFR.saveDraft(this.cFQ.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bBm != null) {
            this.bBm.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cFW = true;
        if (this.bBm != null) {
            this.bBm.onResume(getPageContext());
            this.bBm.setSpeakerphoneOn(TbadkCoreApplication.m9getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.cGb);
    }

    private void UR() {
        if (this.bBm != null) {
            this.bBm.stopPlay();
        }
    }

    public boolean akK() {
        if (com.baidu.tbadk.core.util.m.bG()) {
            return true;
        }
        showToast(TbadkCoreApplication.m9getInst().getString(u.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akL() {
        String beforeSendMsgText = this.cFQ.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.cFQ.afterSendMsgText();
            this.handler.postDelayed(new bw(this, beforeSendMsgText), 100L);
        }
    }

    public void akM() {
        if (akK()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.cFQ != null) {
            UR();
            if (view == this.cFQ.getBtnBack()) {
                this.cFQ.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.cFQ.getLayNewMsg()) {
                this.cFQ.refreshGo2New(this.cFR.getData());
                this.cFQ.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.bBm != null) {
            this.bBm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cGd && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.cFQ.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.bBm == null || !recorderManager.kD()) {
                    return true;
                }
                recorderManager.a(this.cFQ, -1);
                this.cFQ.closeRecordCancel();
                this.cFQ.refreshSendVoiceText(true);
                this.cFQ.startRecordVoice();
                this.cGd = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.kC();
                    }
                    this.cFQ.closeRecordCancel();
                } else if (!this.cFW) {
                    if (recorderManager != null) {
                        recorderManager.kC();
                    }
                    this.cFQ.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.kE();
                    }
                    this.cFQ.stopRecordVoice();
                }
                this.cFQ.refreshSendVoiceText(false);
                this.cGd = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.cFQ.showRecordCancel();
                    this.cFQ.stopRecordVoice();
                    this.cGd = false;
                    return true;
                }
                this.cFQ.closeRecordCancel();
                this.cFQ.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.tbadk.coreExtra.data.i iVar) {
        this.cFR.sendBigEmotionMessage(iVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void jE() {
        akN();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        this.cFQ.closeNewMsg();
    }

    private void akN() {
        this.cFR.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cFR != null) {
            this.cFR.onDestroy();
        }
        super.onDestroy();
        if (this.bBm != null) {
            this.bBm.onDestory(getPageContext());
        }
        if (this.cFU != null) {
            this.cFU = null;
        }
        if (this.cFS != null) {
            this.cFS.cancelLoadData();
            this.cFS = null;
        }
        if (this.cFQ != null) {
            this.cFQ.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar == this.cFQ.getMsgItemOperationDialog()) {
            int intValue = ((Integer) cVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    y(intValue, charSequence);
                    this.cFQ.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void y(int i, String str) {
        ChatMessage msg = this.cFR.getMsg(i);
        if (str.equals(TbadkCoreApplication.m9getInst().getString(u.j.operate_copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aw(msg.getContent());
                showToast(u.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(u.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.cFQ.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(u.j.msg_delete))) {
            if ((this.cFZ instanceof ChatVoiceView) && ((ChatVoiceView) this.cFZ).isPlaying() && this.bBm != null) {
                this.bBm.stopPlay();
            }
            this.cFR.markDeleteMsg(i);
            showToast(u.j.op_result_deleted);
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(u.j.msg_img_save))) {
            String C = com.baidu.tieba.im.util.h.C(msg.getContent(), true);
            if (C != null) {
                this.cFU = new bp(C, this);
                this.cFU.execute();
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(u.j.group_open_receiver)) || str.equals(TbadkCoreApplication.m9getInst().getString(u.j.group_close_receiver))) {
            if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.m9getInst().setHeadsetModeOn(false);
                this.bBm.setSpeakerphoneOn(true);
                this.cFQ.closeReceiver();
                return;
            }
            TbadkCoreApplication.m9getInst().setHeadsetModeOn(true);
            this.bBm.setSpeakerphoneOn(false);
            this.cFQ.showReceiver();
        }
    }

    public void a(View view, int i, int i2, long j) {
        DealInfoIMData parseData;
        String content;
        ChatMessage msg;
        String content2;
        ChatMessage msg2;
        switch (i) {
            case 1:
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cz(TbadkCoreApplication.m9getInst().getString(u.j.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.m9getInst().getString(u.j.msg_resend), new bx(this, i2));
                aVar.b(TbadkCoreApplication.m9getInst().getString(u.j.delete), new by(this, i2));
                aVar.b(getPageContext()).rT();
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
                if (!akK() || (msg2 = this.cFR.getMsg(i2)) == null || !com.baidu.tieba.im.util.h.s(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.cFR.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.h.u(msg3) && (msg = this.cFR.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content2).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getContext(), com.baidu.adp.lib.h.b.g(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.h.b.c(optJSONObject.optString("groupId"), 0L), 2)));
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
                ChatMessage msg4 = this.cFR.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            optJSONObject2.optString("type");
                            String optString = optJSONObject2.optString("shareSourceUrl");
                            if (optString != null && optString.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=")) {
                                String substring = optString.substring("http://tieba.baidu.com/mo/q/hotMessage?topic_id=".length());
                                if (!com.baidu.tbadk.plugins.a.f(getPageContext()) && !TextUtils.isEmpty(substring)) {
                                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getContext()).createNormalConfig(substring, null, null)));
                                }
                            }
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bk(msg4.getContent(), getClass().getName());
                    if (aVar2.are() == 1 && aVar2.arf() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.arf()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.h.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.arf()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.arf()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.arf()).getThreadType() == 33) {
                                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.arf()).getThreadId()).ol()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.arf()).getThreadId(), ((ShareFromPBMsgData) aVar2.arf()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.i.fr()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(u.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.cFR.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bk(msg5.getContent(), getClass().getName());
                    if (aVar3.are() == 1 && aVar3.arf() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.i.fr()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(u.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.cFR.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bk(msg6.getContent(), getClass().getName());
                    if (aVar4.are() == 1 && aVar4.arf() != null) {
                        String shareSourceUrl = ((ShareFromGameCenterMsgData) aVar4.arf()).getShareSourceUrl();
                        if (!TextUtils.isEmpty(shareSourceUrl) && shareSourceUrl.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, shareSourceUrl);
                            return;
                        }
                        String pH = com.baidu.tieba.tbadkCore.util.n.pH(shareSourceUrl);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), pH, "2000801")));
                        TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, pH);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.i.fr()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(u.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.cFR.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        String optString2 = new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl");
                        if (!TextUtils.isEmpty(optString2) && optString2.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, optString2);
                        } else {
                            String pH2 = com.baidu.tieba.tbadkCore.util.n.pH(optString2);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), pH2, "2000801")));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, pH2);
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.cFR.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bk(msg8.getContent(), getClass().getName());
                    if (aVar5.are() == 4 && aVar5.arf() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.arf()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.arf()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
            case 16:
                String content3 = this.cFR.getMsg(i2).getContent();
                if (!StringUtils.isNull(content3) && (parseData = DealInfoIMData.parseData(content3)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommOrderDetailActivityConfig(getPageContext().getPageActivity(), parseData.orderId, false)));
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.cFR.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.cFR.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.bBm == null || this.bBm.getRecorderManager() == null) {
            return null;
        }
        return this.bBm.getRecorderManager();
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ag.Q(getApplicationContext())) {
                com.baidu.tbadk.core.util.au.c(getPageContext());
            } else {
                showToast(u.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ag.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(u.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hm() {
        if (this.aFl == null) {
            this.aFl = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 8);
        }
        return this.aFl;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fk(int i) {
        return null;
    }
}
