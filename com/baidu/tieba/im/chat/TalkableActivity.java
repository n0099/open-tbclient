package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
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
import com.baidu.tieba.im.groupActivity.GroupActivityActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity extends BaseActivity implements View.OnTouchListener, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, com.baidu.adp.widget.ListView.aa, com.baidu.adp.widget.ListView.ad, com.baidu.tbadk.core.voice.o, com.baidu.tbadk.widget.richText.j {
    private static String aPY = "tbgametype";
    protected boolean aPU;
    private boolean aPV;
    private View aPZ;
    private boolean aQb;
    protected VoiceManager ayo;
    protected Handler handler = new Handler();
    protected AbsMsglistView aPP = null;
    protected MsglistModel aPQ = null;
    protected LocalPicModel aPR = null;
    protected com.baidu.adp.base.h aPS = null;
    protected dk aPT = null;
    protected com.baidu.tbadk.img.b<ChatMessage> aPW = null;
    private long aPX = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    protected com.baidu.adp.base.h aQa = new dn(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kc() {
        this.aPS = new Cdo(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.aPX = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aPX = System.currentTimeMillis();
        }
        this.aPW = new dp(this);
        Kd();
        Kf();
        addGlobalLayoutListener();
        setSkinType(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12010 || i == 12009) {
                String stringExtra2 = intent.getStringExtra("file_name");
                String str = TbConfig.LOCAL_PIC_DIR;
                if (stringExtra2 == null) {
                    stringExtra2 = TbConfig.IMAGE_RESIZED_FILE;
                    str = null;
                }
                if (this.aPR != null) {
                    this.aPR.cancelLoadData();
                    this.aPR = null;
                }
                this.aPR = new LocalPicModel(str, stringExtra2, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.aPR.setLoadDataCallBack(this.aPS);
                this.aPR.getData();
                this.aPP.hideMore();
                return;
            }
            int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(this);
            String string = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.send_msg);
            String string2 = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.cancel);
            if (i == 12002) {
                if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
                    this.writeImagesInfo.parseJson(stringExtra);
                    this.writeImagesInfo.updateQuality();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(this, 12002, 12009, null, null, null, null, maxChatImageWidthInPx, string, string2, "", this.writeImagesInfo.getChosedFiles().get(0).getFilePath())));
                        this.writeImagesInfo.clear();
                    }
                }
            } else if (i == 12001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(this, 12001, 12010, null, null, null, null, maxChatImageWidthInPx, string, string2, "")));
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                com.baidu.tbadk.core.util.av.h(this);
            } else if (i == 12009) {
                com.baidu.tbadk.core.util.av.i(this);
            }
        }
    }

    public void b(View view, int i, int i2, long j) {
        this.aPZ = view;
        ChatMessage msg = this.aPQ.getMsg(i2);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.aPU = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11) {
                this.aPP.showDiaItemContentOperate(i2, o(i, this.aPU));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] o(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.operate_copy));
                if (!z) {
                    arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_img_save));
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_delete));
                break;
            case 5:
                arrayList.add(TbadkApplication.m251getInst().isHeadsetModeOn() ? TbadkApplication.m251getInst().getString(com.baidu.tieba.y.group_close_receiver) : TbadkApplication.m251getInst().getString(com.baidu.tieba.y.group_open_receiver));
                if (!z) {
                    arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.aPX = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aPX = System.currentTimeMillis();
        }
        Kd();
        Kf();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.ayo != null) {
            this.ayo.onStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aPV = false;
        if (this.ayo != null) {
            this.ayo.onPause(this);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        return this.ayo;
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        if (this.aPP == null || this.aPP.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.aPP.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof com.baidu.tbadk.core.voice.m)) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.m) findViewWithTag;
    }

    private void Kd() {
        this.ayo = new VoiceManager();
        this.ayo.onCreate(this);
        this.ayo.setSpeakerphoneOn(!TbadkApplication.m251getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public ListView getListView() {
        if (this.aPP == null) {
            return null;
        }
        return this.aPP.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int vN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> vO() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> vP() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> vQ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> vR() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> vS() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void s(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void t(Context context, String str) {
        com.baidu.tbadk.core.util.bf.mR().b(context, new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void u(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void v(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void w(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.aPP != null) {
                Ke();
            }
            if (this.aPP != null && this.aPP.isMoreVisible()) {
                this.aPP.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected boolean Ke() {
        return this.aPQ.saveDraft(this.aPP.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ayo != null) {
            this.ayo.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aPV = true;
        if (this.ayo != null) {
            this.ayo.onResume(this);
            this.ayo.setSpeakerphoneOn(TbadkApplication.m251getInst().isHeadsetModeOn() ? false : true);
        }
    }

    private void EA() {
        if (this.ayo != null) {
            this.ayo.stopPlay();
        }
    }

    public boolean Kf() {
        if (com.baidu.tbadk.core.util.s.bm()) {
            return true;
        }
        showToast(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.voice_error_sdcard));
        return false;
    }

    protected void Kg() {
        String beforeSendMsgText = this.aPP.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.aPP.afterSendMsgText();
            this.handler.postDelayed(new dq(this, beforeSendMsgText), 100L);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.aPP != null) {
            EA();
            if (view == this.aPP.getBtnBack()) {
                Ke();
                this.aPP.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.aPP.getBtnCamera()) {
                if (Kf()) {
                    com.baidu.tbadk.core.util.av.h(this);
                }
            } else if (view == this.aPP.getBtnImage()) {
                if (Kf()) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this, this.writeImagesInfo.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            } else if (view == this.aPP.getBtnSend()) {
                Kg();
            } else if (view == this.aPP.getLayNewMsg()) {
                this.aPP.refreshGo2New(this.aPQ.getData());
                this.aPP.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.ayo != null) {
            this.ayo.onSaveInstanceState(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aQb && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.aPP.getBtnSendVoice()) {
            if (motionEvent.getAction() == 0) {
                if (this.ayo == null || !this.ayo.isAllowRecord()) {
                    return true;
                }
                this.ayo.startRecord(this.aPP, -1);
                this.aPP.closeRecordCancel();
                this.aPP.refreshSendVoiceText(true);
                this.aPP.startRecordVoice();
                this.aQb = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.m.dip2px(this, 5.0f) * (-1)) {
                    if (this.ayo != null) {
                        this.ayo.cancelRecord();
                    }
                    this.aPP.closeRecordCancel();
                } else if (!this.aPV) {
                    if (this.ayo != null) {
                        this.ayo.cancelRecord();
                    }
                    this.aPP.stopRecordVoice();
                } else {
                    if (this.ayo != null) {
                        this.ayo.stopRecord();
                    }
                    this.aPP.stopRecordVoice();
                }
                this.aPP.refreshSendVoiceText(false);
                this.aQb = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.m.dip2px(this, 5.0f) * (-1)) {
                    this.aPP.showRecordCancel();
                    this.aPP.stopRecordVoice();
                    this.aQb = false;
                    return true;
                }
                this.aPP.closeRecordCancel();
                this.aPP.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        this.aPQ.sendBigEmotionMessage(dVar);
    }

    @Override // com.baidu.adp.widget.ListView.ad
    public void hR() {
        Kh();
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        this.aPP.closeNewMsg();
    }

    private void Kh() {
        this.aPQ.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aPQ != null) {
            this.aPQ.onDestroy();
        }
        super.onDestroy();
        if (this.ayo != null) {
            this.ayo.onDestory(this);
        }
        if (this.aPT != null) {
            this.aPT = null;
        }
        if (this.aPR != null) {
            this.aPR.cancelLoadData();
            this.aPR = null;
        }
        if (this.aPP != null) {
            this.aPP.onDestory();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.aPP.getMsgItemOperationDialog()) {
            ListView listView = ((AlertDialog) dialogInterface).getListView();
            int intValue = ((Integer) listView.getTag()).intValue();
            View childAt = listView.getChildAt(i);
            if (childAt != null && (childAt instanceof TextView)) {
                String charSequence = ((TextView) childAt).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    l(intValue, charSequence);
                }
            }
        }
    }

    protected void l(int i, String str) {
        ChatMessage msg = this.aPQ.getMsg(i);
        if (str.equals(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.operate_copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.an(msg.getContent());
                showToast(com.baidu.tieba.y.op_result_copied);
            }
        } else if (str.equals(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.aPP.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_delete))) {
            if ((this.aPZ instanceof ChatVoiceView) && ((ChatVoiceView) this.aPZ).isPlaying() && this.ayo != null) {
                this.ayo.stopPlay();
            }
            this.aPQ.markDeleteMsg(i);
            showToast(com.baidu.tieba.y.op_result_deleted);
        } else if (str.equals(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_img_save))) {
            String v = com.baidu.tieba.im.util.i.v(msg.getContent(), true);
            if (v != null) {
                this.aPT = new dk(v, this);
                this.aPT.execute();
            }
        } else if (str.equals(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.group_open_receiver)) || str.equals(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.group_close_receiver))) {
            if (TbadkApplication.m251getInst().isHeadsetModeOn()) {
                TbadkApplication.m251getInst().setHeadsetModeOn(false);
                this.ayo.setSpeakerphoneOn(true);
                this.aPP.closeReceiver();
                return;
            }
            TbadkApplication.m251getInst().setHeadsetModeOn(true);
            this.ayo.setSpeakerphoneOn(false);
            this.aPP.showReceiver();
        }
    }

    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        switch (i) {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.operation));
                builder.setPositiveButton(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.msg_resend), new dr(this, i2));
                builder.setNegativeButton(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.delete), new ds(this, i2));
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
                if (!Kf() || (msg2 = this.aPQ.getMsg(i2)) == null || !com.baidu.tieba.im.util.i.r(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, TbadkApplication.getCurrentAccount(), TbadkApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.aPQ.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.i.t(msg3) && (msg = this.aPQ.getMsg(i2)) != null && (content = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            GroupActivityActivity.a(this, com.baidu.adp.lib.g.c.f(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.g.c.a(optJSONObject.optString("groupId"), 0L), 2);
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
                ChatMessage msg4 = this.aPQ.getMsg(i2);
                if (msg4 != null && msg4.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar = new com.baidu.tieba.im.widget.a();
                    aVar.aw(msg4.getContent(), getClass().getName());
                    if (aVar.RV() == 1 && aVar.RW() != null) {
                        if (!TextUtils.isEmpty(((ShareFromPBMsgData) aVar.RW()).getThreadId()) || !TextUtils.isEmpty(((ShareFromPBMsgData) aVar.RW()).getPostId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this).createNormalCfg(((ShareFromPBMsgData) aVar.RW()).getThreadId(), ((ShareFromPBMsgData) aVar.RW()).getPostId(), null)));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.j.fh()) {
                    showToast(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.aPQ.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.aw(msg5.getContent(), getClass().getName());
                    if (aVar2.RV() == 1 && aVar2.RW() != null) {
                        String dm = com.baidu.tbadk.game.a.dm(((ShareFromGameCenterMsgData) aVar2.RW()).getShareSourceUrl());
                        String str = (TextUtils.isEmpty(dm) || !dm.equalsIgnoreCase("default")) ? dm : "";
                        String shareUrl = ((ShareFromGameCenterMsgData) aVar2.RW()).getShareUrl();
                        if (!TextUtils.isEmpty(shareUrl)) {
                            TiebaStatic.eventStat(this, "game_ck_link", "click", 1, str);
                            if (shareUrl.equalsIgnoreCase("default")) {
                                sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(this)));
                                return;
                            } else if (com.baidu.tbadk.game.a.dl(shareUrl) == 2) {
                                if (fB(shareUrl)) {
                                    com.baidu.tbadk.game.a.a(getApplicationContext(), null, shareUrl, str);
                                    return;
                                } else {
                                    TbWebViewActivity.startActivity(this, shareUrl);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.fh()) {
                    showToast(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.aPQ.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.aw(msg6.getContent(), getClass().getName());
                    if (aVar3.RV() == 1 && aVar3.RW() != null) {
                        String shareSourceUrl = ((ShareFromGameCenterMsgData) aVar3.RW()).getShareSourceUrl();
                        if (!TextUtils.isEmpty(shareSourceUrl) && shareSourceUrl.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(this)));
                            TiebaStatic.eventStat(this, "game_ck_tail", "click", 1, shareSourceUrl);
                            return;
                        }
                        String dm2 = com.baidu.tbadk.game.a.dm(shareSourceUrl);
                        sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this, dm2)));
                        TiebaStatic.eventStat(this, "game_ck_tail", "click", 1, dm2);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.fh()) {
                    showToast(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.aPQ.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        String optString = new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl");
                        if (!TextUtils.isEmpty(optString) && optString.equalsIgnoreCase("default")) {
                            sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(this)));
                            TiebaStatic.eventStat(this, "game_ck_tail", "click", 1, optString);
                        } else {
                            String dm3 = com.baidu.tbadk.game.a.dm(optString);
                            sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this, dm3)));
                            TiebaStatic.eventStat(this, "game_ck_tail", "click", 1, dm3);
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
        }
    }

    public boolean fB(String str) {
        Map<String, String> bT;
        if (!TextUtils.isEmpty(str) && (bT = com.baidu.tbadk.core.util.bf.bT(com.baidu.tbadk.core.util.bf.bU(str))) != null) {
            String str2 = bT.get(aPY);
            return !TextUtils.isEmpty(str2) && str2.equals("1");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.aPQ.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.aPQ.deleteMsg(i);
    }
}
