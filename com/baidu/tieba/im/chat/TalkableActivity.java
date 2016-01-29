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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.d.a, com.baidu.adp.lib.d.b, BdListView.e, BdListView.h, c.b, VoiceManager.c, com.baidu.tbadk.widget.richText.l {
    protected boolean bPO;
    private boolean bPP;
    private View bPS;
    private boolean bPW;
    protected VoiceManager ben;
    protected Handler handler = new Handler();
    protected AbsMsglistView bPJ = null;
    protected MsglistModel bPK = null;
    protected LocalPicModel bPL = null;
    protected com.baidu.adp.base.g bPM = null;
    protected bo bPN = null;
    protected a.InterfaceC0053a<ChatMessage> bPQ = null;
    private long bPR = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean bPT = true;
    private CustomMessageListener bPU = new br(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    protected com.baidu.adp.base.g bPV = new bs(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void Za() {
        this.bPM = new bt(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackIsSupportNight(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.bPR = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.bPR = System.currentTimeMillis();
        }
        this.bPQ = new bu(this);
        Zb();
        Jp();
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
                if (this.bPL != null) {
                    this.bPL.cancelLoadData();
                    this.bPL = null;
                }
                this.bPL = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.bPL.setLoadDataCallBack(this.bPM);
                this.bPL.getData();
                this.bPJ.hideMore();
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
                com.baidu.tbadk.core.util.aq.c(getPageContext());
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                Ze();
            }
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
        this.bPS = view;
        ChatMessage msg = this.bPK.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.bPO = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11) {
                this.bPJ.showDiaItemContentOperate(i2, l(i, this.bPO));
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
            this.bPR = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.bPR = System.currentTimeMillis();
        }
        Zb();
        Jp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ben != null) {
            this.ben.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bPP = false;
        if (this.ben != null) {
            this.ben.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.bPU);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ben;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.bPJ == null || this.bPJ.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.bPJ.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void Zb() {
        this.ben = new VoiceManager();
        this.ben.onCreate(getPageContext());
        this.ben.setSpeakerphoneOn(!TbadkCoreApplication.m411getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public ListView getListView() {
        if (this.bPJ == null) {
            return null;
        }
        return this.bPJ.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public int Hr() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<ImageView> Hs() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<TextView> Ht() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<GifView> Hu() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<View> Hv() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<LinearLayout> Hw() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void H(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void I(Context context, String str) {
        com.baidu.tbadk.core.util.be.wt().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void J(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void K(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void L(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void M(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.bPJ != null && this.bPJ.isMoreVisible()) {
                this.bPJ.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.bPT && this.bPJ != null) {
            Zc();
        }
        super.finish();
    }

    protected boolean Zc() {
        return this.bPK.saveDraft(this.bPJ.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ben != null) {
            this.ben.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bPP = true;
        if (this.ben != null) {
            this.ben.onResume(getPageContext());
            this.ben.setSpeakerphoneOn(TbadkCoreApplication.m411getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.bPU);
    }

    private void Oy() {
        if (this.ben != null) {
            this.ben.stopPlay();
        }
    }

    public boolean Jp() {
        if (com.baidu.tbadk.core.util.m.fq()) {
            return true;
        }
        showToast(TbadkCoreApplication.m411getInst().getString(t.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zd() {
        String beforeSendMsgText = this.bPJ.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.bPJ.afterSendMsgText();
            this.handler.postDelayed(new bv(this, beforeSendMsgText), 100L);
        }
    }

    public void Ze() {
        if (Jp()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), "", false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.bPJ != null) {
            Oy();
            if (view == this.bPJ.getBtnBack()) {
                this.bPJ.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.bPJ.getLayNewMsg()) {
                this.bPJ.refreshGo2New(this.bPK.getData());
                this.bPJ.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.ben != null) {
            this.ben.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bPW && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.bPJ.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.ben == null || !recorderManager.ou()) {
                    return true;
                }
                recorderManager.a(this.bPJ, -1);
                this.bPJ.closeRecordCancel();
                this.bPJ.refreshSendVoiceText(true);
                this.bPJ.startRecordVoice();
                this.bPW = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.ot();
                    }
                    this.bPJ.closeRecordCancel();
                } else if (!this.bPP) {
                    if (recorderManager != null) {
                        recorderManager.ot();
                    }
                    this.bPJ.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.ov();
                    }
                    this.bPJ.stopRecordVoice();
                }
                this.bPJ.refreshSendVoiceText(false);
                this.bPW = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.bPJ.showRecordCancel();
                    this.bPJ.stopRecordVoice();
                    this.bPW = false;
                    return true;
                }
                this.bPJ.closeRecordCancel();
                this.bPJ.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.tbadk.coreExtra.data.h hVar) {
        this.bPK.sendBigEmotionMessage(hVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void nw() {
        Zf();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        this.bPJ.closeNewMsg();
    }

    private void Zf() {
        this.bPK.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bPK != null) {
            this.bPK.onDestroy();
        }
        super.onDestroy();
        if (this.ben != null) {
            this.ben.onDestory(getPageContext());
        }
        if (this.bPN != null) {
            this.bPN = null;
        }
        if (this.bPL != null) {
            this.bPL.cancelLoadData();
            this.bPL = null;
        }
        if (this.bPJ != null) {
            this.bPJ.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar == this.bPJ.getMsgItemOperationDialog()) {
            int intValue = ((Integer) cVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    D(intValue, charSequence);
                    this.bPJ.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void D(int i, String str) {
        ChatMessage msg = this.bPK.getMsg(i);
        if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.operate_copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aB(msg.getContent());
                showToast(t.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.bPJ.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.msg_delete))) {
            if ((this.bPS instanceof ChatVoiceView) && ((ChatVoiceView) this.bPS).isPlaying() && this.ben != null) {
                this.ben.stopPlay();
            }
            this.bPK.markDeleteMsg(i);
            showToast(t.j.op_result_deleted);
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.msg_img_save))) {
            String y = com.baidu.tieba.im.util.h.y(msg.getContent(), true);
            if (y != null) {
                this.bPN = new bo(y, this);
                this.bPN.execute();
            }
        } else if (str.equals(TbadkCoreApplication.m411getInst().getString(t.j.group_open_receiver)) || str.equals(TbadkCoreApplication.m411getInst().getString(t.j.group_close_receiver))) {
            if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.m411getInst().setHeadsetModeOn(false);
                this.ben.setSpeakerphoneOn(true);
                this.bPJ.closeReceiver();
                return;
            }
            TbadkCoreApplication.m411getInst().setHeadsetModeOn(true);
            this.ben.setSpeakerphoneOn(false);
            this.bPJ.showReceiver();
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
                aVar.cE(TbadkCoreApplication.m411getInst().getString(t.j.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.m411getInst().getString(t.j.msg_resend), new bw(this, i2));
                aVar.b(TbadkCoreApplication.m411getInst().getString(t.j.delete), new bx(this, i2));
                aVar.b(getPageContext()).uj();
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
                if (!Jp() || (msg2 = this.bPK.getMsg(i2)) == null || !com.baidu.tieba.im.util.h.r(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.bPK.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.h.t(msg3) && (msg = this.bPK.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.bPK.getMsg(i2);
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
                    aVar2.aT(msg4.getContent(), getClass().getName());
                    if (aVar2.afo() == 1 && aVar2.afp() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.afp()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.h.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.afp()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.afp()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.afp()).getThreadType() == 33) {
                                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.afp()).getThreadId()).rC()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.afp()).getThreadId(), ((ShareFromPBMsgData) aVar2.afp()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.i.iZ()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.bPK.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.aT(msg5.getContent(), getClass().getName());
                    if (aVar3.afo() == 1 && aVar3.afp() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.i.iZ()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.bPK.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.aT(msg6.getContent(), getClass().getName());
                    if (aVar4.afo() == 1 && aVar4.afp() != null) {
                        String shareSourceUrl = ((ShareFromGameCenterMsgData) aVar4.afp()).getShareSourceUrl();
                        if (!TextUtils.isEmpty(shareSourceUrl) && shareSourceUrl.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, shareSourceUrl);
                            return;
                        }
                        String mQ = com.baidu.tieba.tbadkCore.util.n.mQ(shareSourceUrl);
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), mQ, "2000801")));
                        TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, mQ);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.i.iZ()) {
                    showToast(TbadkCoreApplication.m411getInst().getString(t.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.bPK.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        String optString2 = new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl");
                        if (!TextUtils.isEmpty(optString2) && optString2.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getContext())));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, optString2);
                        } else {
                            String mQ2 = com.baidu.tieba.tbadkCore.util.n.mQ(optString2);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(getPageContext().getPageActivity(), mQ2, "2000801")));
                            TiebaStatic.eventStat(getPageContext().getContext(), "game_ck_tail", "click", 1, mQ2);
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.bPK.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.aT(msg8.getContent(), getClass().getName());
                    if (aVar5.afo() == 4 && aVar5.afp() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.afp()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.afp()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.bPK.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.bPK.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.ben == null || this.ben.getRecorderManager() == null) {
            return null;
        }
        return this.ben.getRecorderManager();
    }
}
