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
import com.baidu.tieba.t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, a.InterfaceC0000a, com.baidu.adp.lib.d.a, com.baidu.adp.lib.d.b, BdListView.e, BdListView.h, c.b, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    protected com.baidu.adp.lib.f.b<View> aJo;
    protected VoiceManager bQi;
    protected boolean cUp;
    private boolean cUq;
    private View cUt;
    private boolean cUx;
    protected Handler handler = new Handler();
    protected AbsMsglistView cUk = null;
    protected MsglistModel cUl = null;
    protected LocalPicModel cUm = null;
    protected com.baidu.adp.base.g cUn = null;
    protected bp cUo = null;
    protected a.InterfaceC0045a<ChatMessage> cUr = null;
    private long cUs = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean cUu = true;
    private CustomMessageListener cUv = new bs(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    protected com.baidu.adp.base.g cUw = new bt(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqg() {
        this.cUn = new bu(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackIsSupportNight(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.cUs = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.cUs = System.currentTimeMillis();
        }
        this.cUr = new bv(this);
        aqh();
        aqj();
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
                if (this.cUm != null) {
                    this.cUm.cancelLoadData();
                    this.cUm = null;
                }
                this.cUm = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.cUm.setLoadDataCallBack(this.cUn);
                this.cUm.getData();
                this.cUk.hideMore();
                return;
            }
            int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
            String string = TbadkCoreApplication.m9getInst().getString(t.j.send_msg);
            String string2 = TbadkCoreApplication.m9getInst().getString(t.j.cancel);
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
                abc();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                aql();
            }
        }
    }

    private void abc() {
        if (!ag.d(getPageContext().getPageActivity(), 1)) {
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
        this.cUt = view;
        ChatMessage msg = this.cUl.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.cUp = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 16 || i == 17) {
                this.cUk.showDiaItemContentOperate(i2, D(i, this.cUp));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] D(int i, boolean z) {
        String string;
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.operate_copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_img_save));
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 5:
                if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.m9getInst().getString(t.j.group_close_receiver);
                } else {
                    string = TbadkCoreApplication.m9getInst().getString(t.j.group_open_receiver);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 16:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.cUs = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.cUs = System.currentTimeMillis();
        }
        aqh();
        aqj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bQi != null) {
            this.bQi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cUq = false;
        if (this.bQi != null) {
            this.bQi.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cUv);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bQi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.cUk == null || this.cUk.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.cUk.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void aqh() {
        if (this.bQi == null) {
            this.bQi = new VoiceManager();
            this.bQi.onCreate(getPageContext());
        }
        this.bQi.setSpeakerphoneOn(!TbadkCoreApplication.m9getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public ListView getListView() {
        if (this.cUk == null) {
            return null;
        }
        return this.cUk.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int ID() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> IE() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IF() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> IG() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IH() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> II() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        com.baidu.tbadk.core.util.bi.vx().c(getPageContext(), new String[]{str});
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
            if (this.cUk != null && this.cUk.isMoreVisible()) {
                this.cUk.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.cUu && this.cUk != null) {
            aqi();
        }
        super.finish();
    }

    protected boolean aqi() {
        return this.cUl.saveDraft(this.cUk.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bQi != null) {
            this.bQi.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cUq = true;
        if (this.bQi != null) {
            this.bQi.onResume(getPageContext());
            this.bQi.setSpeakerphoneOn(TbadkCoreApplication.m9getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.cUv);
    }

    private void aaO() {
        if (this.bQi != null) {
            this.bQi.stopPlay();
        }
    }

    public boolean aqj() {
        if (com.baidu.tbadk.core.util.m.cA()) {
            return true;
        }
        showToast(TbadkCoreApplication.m9getInst().getString(t.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqk() {
        String beforeSendMsgText = this.cUk.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.cUk.afterSendMsgText();
            this.handler.postDelayed(new bw(this, beforeSendMsgText), 100L);
        }
    }

    public void aql() {
        if (aqj()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.cUk != null) {
            aaO();
            if (view == this.cUk.getBtnBack()) {
                this.cUk.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.cUk.getLayNewMsg()) {
                this.cUk.refreshGo2New(this.cUl.getData());
                this.cUk.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.bQi != null) {
            this.bQi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cUx && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.cUk.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.bQi == null || !recorderManager.lu()) {
                    return true;
                }
                recorderManager.a(this.cUk, -1);
                this.cUk.closeRecordCancel();
                this.cUk.refreshSendVoiceText(true);
                this.cUk.startRecordVoice();
                this.cUx = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.lt();
                    }
                    this.cUk.closeRecordCancel();
                } else if (!this.cUq) {
                    if (recorderManager != null) {
                        recorderManager.lt();
                    }
                    this.cUk.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.lv();
                    }
                    this.cUk.stopRecordVoice();
                }
                this.cUk.refreshSendVoiceText(false);
                this.cUx = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.cUk.showRecordCancel();
                    this.cUk.stopRecordVoice();
                    this.cUx = false;
                    return true;
                }
                this.cUk.closeRecordCancel();
                this.cUk.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.tbadk.coreExtra.data.l lVar) {
        this.cUl.sendBigEmotionMessage(lVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void ky() {
        aqm();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        this.cUk.closeNewMsg();
    }

    private void aqm() {
        this.cUl.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cUl != null) {
            this.cUl.onDestroy();
        }
        super.onDestroy();
        if (this.bQi != null) {
            this.bQi.onDestory(getPageContext());
        }
        if (this.cUo != null) {
            this.cUo = null;
        }
        if (this.cUm != null) {
            this.cUm.cancelLoadData();
            this.cUm = null;
        }
        if (this.cUk != null) {
            this.cUk.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar == this.cUk.getMsgItemOperationDialog()) {
            int intValue = ((Integer) cVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    x(intValue, charSequence);
                    this.cUk.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void x(int i, String str) {
        ChatMessage msg = this.cUl.getMsg(i);
        if (str.equals(TbadkCoreApplication.m9getInst().getString(t.j.operate_copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.az(msg.getContent());
                showToast(t.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(t.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.cUk.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(t.j.msg_delete))) {
            if ((this.cUt instanceof ChatVoiceView) && ((ChatVoiceView) this.cUt).isPlaying() && this.bQi != null) {
                this.bQi.stopPlay();
            }
            this.cUl.markDeleteMsg(i);
            showToast(t.j.op_result_deleted);
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(t.j.msg_img_save))) {
            String G = com.baidu.tieba.im.util.h.G(msg.getContent(), true);
            if (G != null) {
                this.cUo = new bp(G, this);
                this.cUo.execute();
            }
        } else if (str.equals(TbadkCoreApplication.m9getInst().getString(t.j.group_open_receiver)) || str.equals(TbadkCoreApplication.m9getInst().getString(t.j.group_close_receiver))) {
            if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.m9getInst().setHeadsetModeOn(false);
                this.bQi.setSpeakerphoneOn(true);
                this.cUk.closeReceiver();
                return;
            }
            TbadkCoreApplication.m9getInst().setHeadsetModeOn(true);
            this.bQi.setSpeakerphoneOn(false);
            this.cUk.showReceiver();
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
                aVar.cB(TbadkCoreApplication.m9getInst().getString(t.j.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.m9getInst().getString(t.j.msg_resend), new bx(this, i2));
                aVar.b(TbadkCoreApplication.m9getInst().getString(t.j.delete), new by(this, i2));
                aVar.b(getPageContext()).sX();
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
                if (!aqj() || (msg2 = this.cUl.getMsg(i2)) == null || !com.baidu.tieba.im.util.h.s(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.cUl.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.h.u(msg3) && (msg = this.cUl.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.cUl.getMsg(i2);
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
                    aVar2.bm(msg4.getContent(), getClass().getName());
                    if (aVar2.awE() == 1 && aVar2.awF() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.awF()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.h.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.awF()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.awF()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.awF()).getThreadType() == 33) {
                                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.awF()).getThreadId()).oW()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.awF()).getThreadId(), ((ShareFromPBMsgData) aVar2.awF()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.i.gm()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.cUl.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bm(msg5.getContent(), getClass().getName());
                    if (aVar3.awE() == 1 && aVar3.awF() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.i.gm()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.cUl.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bm(msg6.getContent(), getClass().getName());
                    if (aVar4.awE() == 1 && aVar4.awF() != null) {
                        String shareSourceUrl = ((ShareFromGameCenterMsgData) aVar4.awF()).getShareSourceUrl();
                        if (!TextUtils.isEmpty(shareSourceUrl) && shareSourceUrl.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, shareSourceUrl);
                            return;
                        }
                        String rb = com.baidu.tieba.tbadkCore.util.n.rb(shareSourceUrl);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), rb, "2000801")));
                        TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, rb);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.i.gm()) {
                    showToast(TbadkCoreApplication.m9getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.cUl.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        String optString2 = new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl");
                        if (!TextUtils.isEmpty(optString2) && optString2.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, optString2);
                        } else {
                            String rb2 = com.baidu.tieba.tbadkCore.util.n.rb(optString2);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), rb2, "2000801")));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, rb2);
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.cUl.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bm(msg8.getContent(), getClass().getName());
                    if (aVar5.awE() == 4 && aVar5.awF() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.awF()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.awF()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
            case 16:
                String content3 = this.cUl.getMsg(i2).getContent();
                if (!StringUtils.isNull(content3) && (parseData = DealInfoIMData.parseData(content3)) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EcommOrderDetailActivityConfig(getPageContext().getPageActivity(), parseData.orderId, false)));
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.cUl.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.cUl.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.bQi == null || this.bQi.getRecorderManager() == null) {
            return null;
        }
        return this.bQi.getRecorderManager();
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ag.aa(getApplicationContext())) {
                com.baidu.tbadk.core.util.au.c(getPageContext());
            } else {
                showToast(t.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ag.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(t.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IJ() {
        if (this.aJo == null) {
            this.aJo = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 8);
        }
        return this.aJo;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fz(int i) {
        return null;
    }
}
