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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.voice.VoiceManager;
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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, b, BdListView.e, BdListView.h, a.InterfaceC0022a, b.InterfaceC0047b, VoiceManager.c, com.baidu.tbadk.widget.richText.d {
    protected VoiceManager cqg;
    protected boolean dnK;
    private boolean dnL;
    private View dnO;
    private boolean dnS;
    protected Handler handler = new Handler();
    protected AbsMsglistView dnF = null;
    protected MsglistModel dnG = null;
    protected LocalPicModel dnH = null;
    protected com.baidu.adp.base.d dnI = null;
    protected i dnJ = null;
    protected a.InterfaceC0059a<ChatMessage> dnM = null;
    private long dnN = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean dnP = true;
    private CustomMessageListener dnQ = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a)) {
                b.a aVar = (b.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.b.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d dnR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                if (TalkableActivity.this.dnF != null) {
                    TalkableActivity.this.dnF.displayNoNetwork();
                }
            } else if (TalkableActivity.this.dnF != null) {
                TalkableActivity.this.dnF.hideNoNetwork();
            }
            switch (TalkableActivity.this.dnG.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.dnN > -1) {
                        TalkableActivity.this.dnN = -1L;
                    }
                    TalkableActivity.this.dnF.closeProgress();
                    TalkableActivity.this.dnF.refreshGo2New(TalkableActivity.this.dnG.getData());
                    return;
                case 2:
                    TalkableActivity.this.dnF.refreshPrepage(TalkableActivity.this.dnG.getData());
                    return;
                case 3:
                    TalkableActivity.this.dnF.refreshCheckNew(TalkableActivity.this.dnG.getData());
                    return;
                case 4:
                    TalkableActivity.this.dnF.refreshGo2New(TalkableActivity.this.dnG.getData());
                    return;
                case 5:
                    TalkableActivity.this.dnF.refreshNormal(TalkableActivity.this.dnG.getData());
                    return;
                case 6:
                    TalkableActivity.this.dnF.refreshNormal(TalkableActivity.this.dnG.getData());
                    return;
                case 7:
                    TalkableActivity.this.dnF.refreshNormal(TalkableActivity.this.dnG.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.dnF.setDraft(str);
                        TalkableActivity.this.dnG.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.dnP = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.dnF.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                    TalkableActivity.this.dnP = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.dnF.refreshGo2New(TalkableActivity.this.dnG.getData());
                    return;
                case 13:
                    TalkableActivity.this.dnF.refreshNormal(TalkableActivity.this.dnG.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.dnF.refreshNormal(TalkableActivity.this.dnG.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void asW() {
        this.dnI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.dnG != null) {
                        TalkableActivity.this.dnG.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
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
            this.dnN = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.dnN = System.currentTimeMillis();
        }
        this.dnM = new a.InterfaceC0059a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0059a
            /* renamed from: a */
            public void b(int i, ChatMessage chatMessage) {
                TalkableActivity.this.dnF.updateAdapter(i, chatMessage);
            }
        };
        asX();
        asZ();
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
                if (this.dnH != null) {
                    this.dnH.cancelLoadData();
                    this.dnH = null;
                }
                this.dnH = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.dnH.setLoadDataCallBack(this.dnI);
                this.dnH.getData();
                this.dnF.hideMore();
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
                ahh();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                atb();
            }
        }
    }

    private void ahh() {
        if (!ab.e(getPageContext().getPageActivity(), 1)) {
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
        this.dnO = view;
        ChatMessage msg = this.dnG.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.dnK = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.dnF.showDiaItemContentOperate(i2, q(i, this.dnK));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] q(int i, boolean z) {
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
            this.dnN = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.dnN = System.currentTimeMillis();
        }
        asX();
        asZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cqg != null) {
            this.cqg.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dnL = false;
        if (this.cqg != null) {
            this.cqg.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dnQ);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cqg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.dnF == null || this.dnF.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.dnF.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void asX() {
        if (this.cqg == null) {
            this.cqg = new VoiceManager();
            this.cqg.onCreate(getPageContext());
        }
        this.cqg.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.dnF == null) {
            return null;
        }
        return this.dnF.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Jc() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Jd() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Je() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Jf() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Jg() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Jh() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<RelativeLayout> Ji() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void U(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void V(Context context, String str) {
        av.vA().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.dnF != null && this.dnF.isMoreVisible()) {
                this.dnF.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dnP && this.dnF != null) {
            asY();
        }
        super.finish();
    }

    protected boolean asY() {
        return this.dnG.saveDraft(this.dnF.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cqg != null) {
            this.cqg.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dnL = true;
        if (this.cqg != null) {
            this.cqg.onResume(getPageContext());
            this.cqg.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.dnQ);
    }

    private void ahc() {
        if (this.cqg != null) {
            this.cqg.stopPlay();
        }
    }

    public boolean asZ() {
        if (k.dG()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(d.l.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ata() {
        final String beforeSendMsgText = this.dnF.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.dnF.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.dnG.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void atb() {
        if (asZ()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.dnF != null) {
            ahc();
            if (view == this.dnF.getBtnBack()) {
                this.dnF.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.dnF.getLayNewMsg()) {
                this.dnF.refreshGo2New(this.dnG.getData());
                this.dnF.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.cqg != null) {
            this.cqg.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dnS && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.dnF.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.cqg == null || !recorderManager.lL()) {
                    return true;
                }
                recorderManager.a(this.dnF, -1);
                this.dnF.closeRecordCancel();
                this.dnF.refreshSendVoiceText(true);
                this.dnF.startRecordVoice();
                this.dnS = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.lK();
                    }
                    this.dnF.closeRecordCancel();
                } else if (!this.dnL) {
                    if (recorderManager != null) {
                        recorderManager.lK();
                    }
                    this.dnF.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.dnF.stopRecordVoice();
                }
                this.dnF.refreshSendVoiceText(false);
                this.dnS = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.dnF.showRecordCancel();
                    this.dnF.stopRecordVoice();
                    this.dnS = false;
                    return true;
                }
                this.dnF.closeRecordCancel();
                this.dnF.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void c(com.baidu.tbadk.coreExtra.data.l lVar) {
        this.dnG.sendBigEmotionMessage(lVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        atc();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dnF.closeNewMsg();
    }

    private void atc() {
        this.dnG.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dnG != null) {
            this.dnG.onDestroy();
        }
        super.onDestroy();
        if (this.cqg != null) {
            this.cqg.onDestory(getPageContext());
        }
        if (this.dnJ != null) {
            this.dnJ = null;
        }
        if (this.dnH != null) {
            this.dnH.cancelLoadData();
            this.dnH = null;
        }
        if (this.dnF != null) {
            this.dnF.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
        if (bVar == this.dnF.getMsgItemOperationDialog()) {
            int intValue = ((Integer) bVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    C(intValue, charSequence);
                    this.dnF.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void C(int i, String str) {
        ChatMessage msg = this.dnG.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(d.l.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aw(msg.getContent());
                showToast(d.l.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.l.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.dnF.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.l.delete))) {
            if ((this.dnO instanceof ChatVoiceView) && ((ChatVoiceView) this.dnO).isPlaying() && this.cqg != null) {
                this.cqg.stopPlay();
            }
            this.dnG.markDeleteMsg(i);
            showToast(d.l.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.l.save))) {
            String K = com.baidu.tieba.im.util.e.K(msg.getContent(), true);
            if (K != null) {
                this.dnJ = new i(K, this);
                this.dnJ.execute();
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.l.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(d.l.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.cqg.setSpeakerphoneOn(true);
                this.dnF.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.cqg.setSpeakerphoneOn(false);
            this.dnF.showReceiver();
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
                aVar.cL(TbadkCoreApplication.getInst().getString(d.l.sure_to_resend_this_message));
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
                aVar.b(getPageContext()).tb();
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
                if (!asZ() || (msg2 = this.dnG.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.t(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.dnG.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.v(msg3) && (msg = this.dnG.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.dnG.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            av.vA().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bn(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.azu() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.azu()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.azu()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.azu()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.azu()).getThreadType() == 33) {
                                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.azu()).getThreadId()).pc()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.azu()).getThreadId(), ((ShareFromPBMsgData) aVar2.azu()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.j.hh()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.dnG.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bn(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.azu() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.hh()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.dnG.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bn(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.azu() != null) {
                        av.vA().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.azu()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.hh()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.l.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.dnG.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        av.vA().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.dnG.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bn(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.azu() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.azu()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.azu()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.dnG.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.dnG.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.cqg == null || this.cqg.getRecorderManager() == null) {
            return null;
        }
        return this.cqg.getRecorderManager();
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aJ(getApplicationContext())) {
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
}
