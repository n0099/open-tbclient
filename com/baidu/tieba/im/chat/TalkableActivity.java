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
    protected com.baidu.adp.lib.f.b<View> aIJ;
    protected VoiceManager bja;
    protected boolean cag;
    private boolean cah;
    private View cak;
    private boolean cao;
    protected Handler handler = new Handler();
    protected AbsMsglistView cab = null;
    protected MsglistModel cac = null;
    protected LocalPicModel cad = null;
    protected com.baidu.adp.base.g cae = null;
    protected bo caf = null;
    protected a.InterfaceC0053a<ChatMessage> cai = null;
    private long caj = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean cal = true;
    private CustomMessageListener cam = new br(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    protected com.baidu.adp.base.g can = new bs(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void act() {
        this.cae = new bt(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackIsSupportNight(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.caj = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.caj = System.currentTimeMillis();
        }
        this.cai = new bu(this);
        acu();
        KK();
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
                if (this.cad != null) {
                    this.cad.cancelLoadData();
                    this.cad = null;
                }
                this.cad = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.cad.setLoadDataCallBack(this.cae);
                this.cad.getData();
                this.cab.hideMore();
                return;
            }
            int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
            String string = TbadkCoreApplication.m411getInst().getString(t.j.send_msg);
            String string2 = TbadkCoreApplication.m411getInst().getString(t.j.cancel);
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
                Rh();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                acx();
            }
        }
    }

    private void Rh() {
        if (!ag.c(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.as.c(getPageContext());
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
        this.cak = view;
        ChatMessage msg = this.cac.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.cag = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11) {
                this.cab.showDiaItemContentOperate(i2, l(i, this.cag));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] l(int i, boolean z) {
        String string;
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.operate_copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_img_save));
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete));
                break;
            case 5:
                if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
                    string = TbadkCoreApplication.m411getInst().getString(t.j.group_close_receiver);
                } else {
                    string = TbadkCoreApplication.m411getInst().getString(t.j.group_open_receiver);
                }
                arrayList.add(string);
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.caj = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.caj = System.currentTimeMillis();
        }
        acu();
        KK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bja != null) {
            this.bja.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cah = false;
        if (this.bja != null) {
            this.bja.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cam);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bja;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.cab == null || this.cab.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.cab.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void acu() {
        this.bja = new VoiceManager();
        this.bja.onCreate(getPageContext());
        this.bja.setSpeakerphoneOn(!TbadkCoreApplication.m411getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public ListView getListView() {
        if (this.cab == null) {
            return null;
        }
        return this.cab.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int IN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> IO() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IP() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> IQ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IR() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> IS() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void z(Context context, String str) {
        com.baidu.tbadk.core.util.bg.wM().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void d(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.cab != null && this.cab.isMoreVisible()) {
                this.cab.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.cal && this.cab != null) {
            acv();
        }
        super.finish();
    }

    protected boolean acv() {
        return this.cac.saveDraft(this.cab.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bja != null) {
            this.bja.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cah = true;
        if (this.bja != null) {
            this.bja.onResume(getPageContext());
            this.bja.setSpeakerphoneOn(TbadkCoreApplication.m411getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.cam);
    }

    private void Qn() {
        if (this.bja != null) {
            this.bja.stopPlay();
        }
    }

    public boolean KK() {
        if (com.baidu.tbadk.core.util.m.fr()) {
            return true;
        }
        showToast(TbadkCoreApplication.m411getInst().getString(t.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acw() {
        String beforeSendMsgText = this.cab.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.cab.afterSendMsgText();
            this.handler.postDelayed(new bv(this, beforeSendMsgText), 100L);
        }
    }

    public void acx() {
        if (KK()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.cab != null) {
            Qn();
            if (view == this.cab.getBtnBack()) {
                this.cab.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.cab.getLayNewMsg()) {
                this.cab.refreshGo2New(this.cac.getData());
                this.cab.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.bja != null) {
            this.bja.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cao && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.cab.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.bja == null || !recorderManager.on()) {
                    return true;
                }
                recorderManager.a(this.cab, -1);
                this.cab.closeRecordCancel();
                this.cab.refreshSendVoiceText(true);
                this.cab.startRecordVoice();
                this.cao = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.om();
                    }
                    this.cab.closeRecordCancel();
                } else if (!this.cah) {
                    if (recorderManager != null) {
                        recorderManager.om();
                    }
                    this.cab.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.oo();
                    }
                    this.cab.stopRecordVoice();
                }
                this.cab.refreshSendVoiceText(false);
                this.cao = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.cab.showRecordCancel();
                    this.cab.stopRecordVoice();
                    this.cao = false;
                    return true;
                }
                this.cab.closeRecordCancel();
                this.cab.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.tbadk.coreExtra.data.h hVar) {
        this.cac.sendBigEmotionMessage(hVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void nn() {
        acy();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        this.cab.closeNewMsg();
    }

    private void acy() {
        this.cac.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cac != null) {
            this.cac.onDestroy();
        }
        super.onDestroy();
        if (this.bja != null) {
            this.bja.onDestory(getPageContext());
        }
        if (this.caf != null) {
            this.caf = null;
        }
        if (this.cad != null) {
            this.cad.cancelLoadData();
            this.cad = null;
        }
        if (this.cab != null) {
            this.cab.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar == this.cab.getMsgItemOperationDialog()) {
            int intValue = ((Integer) cVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    v(intValue, charSequence);
                    this.cab.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void v(int i, String str) {
        ChatMessage msg = this.cac.getMsg(i);
        if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.operate_copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aD(msg.getContent());
                showToast(t.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.cab.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete))) {
            if ((this.cak instanceof ChatVoiceView) && ((ChatVoiceView) this.cak).isPlaying() && this.bja != null) {
                this.bja.stopPlay();
            }
            this.cac.markDeleteMsg(i);
            showToast(t.j.op_result_deleted);
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.msg_img_save))) {
            String z = com.baidu.tieba.im.util.h.z(msg.getContent(), true);
            if (z != null) {
                this.caf = new bo(z, this);
                this.caf.execute();
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.group_open_receiver)) || str.equals(TbadkCoreApplication.m411getInst().getString(t.j.group_close_receiver))) {
            if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.m411getInst().setHeadsetModeOn(false);
                this.bja.setSpeakerphoneOn(true);
                this.cab.closeReceiver();
                return;
            }
            TbadkCoreApplication.m411getInst().setHeadsetModeOn(true);
            this.bja.setSpeakerphoneOn(false);
            this.cab.showReceiver();
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
                aVar.cC(TbadkCoreApplication.m411getInst().getString(t.j.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.m411getInst().getString(t.j.msg_resend), new bw(this, i2));
                aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.delete), new bx(this, i2));
                aVar.b(getPageContext()).up();
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
                if (!KK() || (msg2 = this.cac.getMsg(i2)) == null || !com.baidu.tieba.im.util.h.r(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.cac.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.h.t(msg3) && (msg = this.cac.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.cac.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            optJSONObject2.optString("type");
                            String optString = optJSONObject2.optString("shareSourceUrl");
                            if (optString != null && optString.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=")) {
                                String substring = optString.substring("http://tieba.baidu.com/mo/q/hotMessage?topic_id=".length());
                                if (!TextUtils.isEmpty(substring)) {
                                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getPageContext().getContext()).createNormalConfig(substring, null, null)));
                                }
                            }
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bg(msg4.getContent(), getClass().getName());
                    if (aVar2.aiI() == 1 && aVar2.aiJ() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.aiJ()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.h.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.aiJ()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.aiJ()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.aiJ()).getThreadType() == 33) {
                                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.aiJ()).getThreadId()).qT()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.aiJ()).getThreadId(), ((ShareFromPBMsgData) aVar2.aiJ()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.i.jf()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.cac.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bg(msg5.getContent(), getClass().getName());
                    if (aVar3.aiI() == 1 && aVar3.aiJ() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.i.jf()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.cac.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bg(msg6.getContent(), getClass().getName());
                    if (aVar4.aiI() == 1 && aVar4.aiJ() != null) {
                        String shareSourceUrl = ((ShareFromGameCenterMsgData) aVar4.aiJ()).getShareSourceUrl();
                        if (!TextUtils.isEmpty(shareSourceUrl) && shareSourceUrl.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, shareSourceUrl);
                            return;
                        }
                        String oc = com.baidu.tieba.tbadkCore.util.n.oc(shareSourceUrl);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), oc, "2000801")));
                        TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, oc);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.i.jf()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.cac.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        String optString2 = new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl");
                        if (!TextUtils.isEmpty(optString2) && optString2.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, optString2);
                        } else {
                            String oc2 = com.baidu.tieba.tbadkCore.util.n.oc(optString2);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), oc2, "2000801")));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, oc2);
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.cac.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bg(msg8.getContent(), getClass().getName());
                    if (aVar5.aiI() == 4 && aVar5.aiJ() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.aiJ()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.aiJ()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.cac.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.cac.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.bja == null || this.bja.getRecorderManager() == null) {
            return null;
        }
        return this.bja.getRecorderManager();
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ag.S(getApplicationContext())) {
                com.baidu.tbadk.core.util.as.c(getPageContext());
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
    public com.baidu.adp.lib.f.b<View> IT() {
        if (this.aIJ == null) {
            this.aIJ = com.baidu.tieba.graffiti.e.j(getPageContext().getPageActivity(), 8);
        }
        return this.aIJ;
    }
}
