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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.b.a.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.widget.richText.b;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, b, BdListView.e, BdListView.h, a.InterfaceC0022a, b.InterfaceC0046b, VoiceManager.c, com.baidu.tbadk.widget.richText.d {
    protected com.baidu.adp.lib.e.b<View> aRd;
    protected VoiceManager cpV;
    protected boolean drI;
    private boolean drJ;
    private View drM;
    private boolean drQ;
    protected Handler handler = new Handler();
    protected AbsMsglistView drD = null;
    protected MsglistModel drE = null;
    protected LocalPicModel drF = null;
    protected com.baidu.adp.base.d drG = null;
    protected i drH = null;
    protected a.InterfaceC0060a<ChatMessage> drK = null;
    private long drL = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean drN = true;
    private CustomMessageListener drO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d drP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (!com.baidu.adp.lib.util.i.hi()) {
                if (TalkableActivity.this.drD != null) {
                    TalkableActivity.this.drD.displayNoNetwork();
                }
            } else if (TalkableActivity.this.drD != null) {
                TalkableActivity.this.drD.hideNoNetwork();
            }
            switch (TalkableActivity.this.drE.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.drL > -1) {
                        TalkableActivity.this.drL = -1L;
                    }
                    TalkableActivity.this.drD.closeProgress();
                    TalkableActivity.this.drD.refreshGo2New(TalkableActivity.this.drE.getData());
                    return;
                case 2:
                    TalkableActivity.this.drD.refreshPrepage(TalkableActivity.this.drE.getData());
                    return;
                case 3:
                    TalkableActivity.this.drD.refreshCheckNew(TalkableActivity.this.drE.getData());
                    return;
                case 4:
                    TalkableActivity.this.drD.refreshGo2New(TalkableActivity.this.drE.getData());
                    return;
                case 5:
                    TalkableActivity.this.drD.refreshNormal(TalkableActivity.this.drE.getData());
                    return;
                case 6:
                    TalkableActivity.this.drD.refreshNormal(TalkableActivity.this.drE.getData());
                    return;
                case 7:
                    TalkableActivity.this.drD.refreshNormal(TalkableActivity.this.drE.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.drD.setDraft(str);
                        TalkableActivity.this.drE.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.drN = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.drD.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                    TalkableActivity.this.drN = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.drD.refreshGo2New(TalkableActivity.this.drE.getData());
                    return;
                case 13:
                    TalkableActivity.this.drD.refreshNormal(TalkableActivity.this.drE.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.drD.refreshNormal(TalkableActivity.this.drE.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void auq() {
        this.drG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.drE != null) {
                        TalkableActivity.this.drE.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                        return;
                    }
                    return;
                }
                TalkableActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.l.pic_parser_error));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackIsSupportNight(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.drL = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.drL = System.currentTimeMillis();
        }
        this.drK = new a.InterfaceC0060a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0060a
            public void a(int i, ChatMessage chatMessage) {
                TalkableActivity.this.drD.updateAdapter(i, chatMessage);
            }
        };
        aur();
        aut();
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
                if (this.drF != null) {
                    this.drF.cancelLoadData();
                    this.drF = null;
                }
                this.drF = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.drF.setLoadDataCallBack(this.drG);
                this.drF.getData();
                this.drD.hideMore();
                return;
            }
            int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
            String string = TbadkCoreApplication.getInst().getString(d.l.send_msg);
            String string2 = TbadkCoreApplication.getInst().getString(d.l.cancel);
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
                ahs();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                auv();
            }
        }
    }

    private void ahs() {
        if (!ab.d(getPageContext().getPageActivity(), 1)) {
            ai.c(getPageContext());
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
        this.drM = view;
        ChatMessage msg = this.drE.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.drI = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.drD.showDiaItemContentOperate(i2, t(i, this.drI));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] t(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.save));
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
            case 5:
                arrayList.add(TbadkCoreApplication.getInst().isHeadsetModeOn() ? TbadkCoreApplication.getInst().getString(d.l.group_close_receiver) : TbadkCoreApplication.getInst().getString(d.l.group_open_receiver));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.l.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.l.delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.drL = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.drL = System.currentTimeMillis();
        }
        aur();
        aut();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cpV != null) {
            this.cpV.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.drJ = false;
        if (this.cpV != null) {
            this.cpV.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.drO);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cpV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.drD == null || this.drD.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.drD.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void aur() {
        if (this.cpV == null) {
            this.cpV = new VoiceManager();
            this.cpV.onCreate(getPageContext());
        }
        this.cpV.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.drD == null) {
            return null;
        }
        return this.drD.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IZ() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ja() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Jb() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jc() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jd() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Je() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        au.wd().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.drD != null && this.drD.isMoreVisible()) {
                this.drD.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.drN && this.drD != null) {
            aus();
        }
        super.finish();
    }

    protected boolean aus() {
        return this.drE.saveDraft(this.drD.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cpV != null) {
            this.cpV.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.drJ = true;
        if (this.cpV != null) {
            this.cpV.onResume(getPageContext());
            this.cpV.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.drO);
    }

    private void ahn() {
        if (this.cpV != null) {
            this.cpV.stopPlay();
        }
    }

    public boolean aut() {
        if (k.dH()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(d.l.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auu() {
        final String beforeSendMsgText = this.drD.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.drD.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.drE.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void auv() {
        if (aut()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.drD != null) {
            ahn();
            if (view == this.drD.getBtnBack()) {
                this.drD.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.drD.getLayNewMsg()) {
                this.drD.refreshGo2New(this.drE.getData());
                this.drD.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.cpV != null) {
            this.cpV.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.drQ && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.drD.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.cpV == null || !recorderManager.lJ()) {
                    return true;
                }
                recorderManager.a(this.drD, -1);
                this.drD.closeRecordCancel();
                this.drD.refreshSendVoiceText(true);
                this.drD.startRecordVoice();
                this.drQ = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.lI();
                    }
                    this.drD.closeRecordCancel();
                } else if (!this.drJ) {
                    if (recorderManager != null) {
                        recorderManager.lI();
                    }
                    this.drD.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.drD.stopRecordVoice();
                }
                this.drD.refreshSendVoiceText(false);
                this.drQ = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.drD.showRecordCancel();
                    this.drD.stopRecordVoice();
                    this.drQ = false;
                    return true;
                }
                this.drD.closeRecordCancel();
                this.drD.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void a(l lVar) {
        this.drE.sendBigEmotionMessage(lVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        auw();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.drD.closeNewMsg();
    }

    private void auw() {
        this.drE.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.drE != null) {
            this.drE.onDestroy();
        }
        super.onDestroy();
        if (this.cpV != null) {
            this.cpV.onDestory(getPageContext());
        }
        if (this.drH != null) {
            this.drH = null;
        }
        if (this.drF != null) {
            this.drF.cancelLoadData();
            this.drF = null;
        }
        if (this.drD != null) {
            this.drD.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
        if (bVar == this.drD.getMsgItemOperationDialog()) {
            int intValue = ((Integer) bVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    D(intValue, charSequence);
                    this.drD.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void D(int i, String str) {
        ChatMessage msg = this.drE.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(d.l.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aw(msg.getContent());
                showToast(d.l.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.l.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.drD.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.l.delete))) {
            if ((this.drM instanceof ChatVoiceView) && ((ChatVoiceView) this.drM).isPlaying() && this.cpV != null) {
                this.cpV.stopPlay();
            }
            this.drE.markDeleteMsg(i);
            showToast(d.l.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.l.save))) {
            String N = com.baidu.tieba.im.util.e.N(msg.getContent(), true);
            if (N != null) {
                this.drH = new i(N, this);
                this.drH.execute();
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.l.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(d.l.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.cpV.setSpeakerphoneOn(true);
                this.drD.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.cpV.setSpeakerphoneOn(false);
            this.drD.showReceiver();
        }
    }

    public void a(View view, int i, final int i2, long j) {
        String content;
        ChatMessage msg;
        String content2;
        ChatMessage msg2;
        switch (i) {
            case 1:
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cM(TbadkCoreApplication.getInst().getString(d.l.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.getInst().getString(d.l.msg_resend), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.reSendMsg(i2);
                    }
                });
                aVar.b(TbadkCoreApplication.getInst().getString(d.l.delete), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.deleteMsg(i2);
                    }
                });
                aVar.b(getPageContext()).to();
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
                if (!aut() || (msg2 = this.drE.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.t(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.drE.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.v(msg3) && (msg = this.drE.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.drE.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            au.wd().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bv(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.aAO() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.aAO()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.aAO()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.aAO()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.aAO()).getThreadType() == 33) {
                                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.aAO()).getThreadId()).pi()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.aAO()).getThreadId(), ((ShareFromPBMsgData) aVar2.aAO()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.i.hi()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.drE.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bv(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.aAO() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.i.hi()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.drE.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bv(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.aAO() != null) {
                        au.wd().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.aAO()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.i.hi()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.drE.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        au.wd().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.drE.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bv(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.aAO() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.aAO()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.aAO()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.drE.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.drE.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.cpV == null || this.cpV.getRecorderManager() == null) {
            return null;
        }
        return this.cpV.getRecorderManager();
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aK(getApplicationContext())) {
                ai.c(getPageContext());
            } else {
                showToast(d.l.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jf() {
        if (this.aRd == null) {
            this.aRd = com.baidu.tieba.graffiti.c.p(getPageContext().getPageActivity(), 8);
        }
        return this.aRd;
    }
}
