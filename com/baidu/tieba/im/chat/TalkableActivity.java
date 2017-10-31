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
import com.baidu.tbadk.widget.richText.c;
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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, b, BdListView.e, BdListView.h, a.InterfaceC0022a, b.InterfaceC0047b, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    protected VoiceManager cxA;
    protected boolean dvA;
    private boolean dvB;
    private View dvE;
    private boolean dvI;
    protected Handler handler = new Handler();
    protected AbsMsglistView dvv = null;
    protected MsglistModel dvw = null;
    protected LocalPicModel dvx = null;
    protected com.baidu.adp.base.d dvy = null;
    protected i dvz = null;
    protected a.InterfaceC0059a<ChatMessage> dvC = null;
    private long dvD = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean dvF = true;
    private CustomMessageListener dvG = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d dvH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                if (TalkableActivity.this.dvv != null) {
                    TalkableActivity.this.dvv.displayNoNetwork();
                }
            } else if (TalkableActivity.this.dvv != null) {
                TalkableActivity.this.dvv.hideNoNetwork();
            }
            switch (TalkableActivity.this.dvw.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.dvD > -1) {
                        TalkableActivity.this.dvD = -1L;
                    }
                    TalkableActivity.this.dvv.closeProgress();
                    TalkableActivity.this.dvv.refreshGo2New(TalkableActivity.this.dvw.getData());
                    return;
                case 2:
                    TalkableActivity.this.dvv.refreshPrepage(TalkableActivity.this.dvw.getData());
                    return;
                case 3:
                    TalkableActivity.this.dvv.refreshCheckNew(TalkableActivity.this.dvw.getData());
                    return;
                case 4:
                    TalkableActivity.this.dvv.refreshGo2New(TalkableActivity.this.dvw.getData());
                    return;
                case 5:
                    TalkableActivity.this.dvv.refreshNormal(TalkableActivity.this.dvw.getData());
                    return;
                case 6:
                    TalkableActivity.this.dvv.refreshNormal(TalkableActivity.this.dvw.getData());
                    return;
                case 7:
                    TalkableActivity.this.dvv.refreshNormal(TalkableActivity.this.dvw.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.dvv.setDraft(str);
                        TalkableActivity.this.dvw.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.dvF = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.dvv.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                    TalkableActivity.this.dvF = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.dvv.refreshGo2New(TalkableActivity.this.dvw.getData());
                    return;
                case 13:
                    TalkableActivity.this.dvv.refreshNormal(TalkableActivity.this.dvw.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.dvv.refreshNormal(TalkableActivity.this.dvw.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void avr() {
        this.dvy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.dvw != null) {
                        TalkableActivity.this.dvw.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                        return;
                    }
                    return;
                }
                TalkableActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.j.pic_parser_error));
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
            this.dvD = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.dvD = System.currentTimeMillis();
        }
        this.dvC = new a.InterfaceC0059a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0059a
            /* renamed from: a */
            public void b(int i, ChatMessage chatMessage) {
                TalkableActivity.this.dvv.updateAdapter(i, chatMessage);
            }
        };
        avs();
        avu();
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
                if (this.dvx != null) {
                    this.dvx.cancelLoadData();
                    this.dvx = null;
                }
                this.dvx = new LocalPicModel(str, stringExtra, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                this.dvx.setLoadDataCallBack(this.dvy);
                this.dvx.getData();
                this.dvv.hideMore();
                return;
            }
            int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
            String string = TbadkCoreApplication.getInst().getString(d.j.send_msg);
            String string2 = TbadkCoreApplication.getInst().getString(d.j.cancel);
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
                ajp();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                avw();
            }
        }
    }

    private void ajp() {
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
        this.dvE = view;
        ChatMessage msg = this.dvw.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.dvA = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.dvv.showDiaItemContentOperate(i2, r(i, this.dvA));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] r(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.save));
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
            case 5:
                arrayList.add(TbadkCoreApplication.getInst().isHeadsetModeOn() ? TbadkCoreApplication.getInst().getString(d.j.group_close_receiver) : TbadkCoreApplication.getInst().getString(d.j.group_open_receiver));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.j.delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.dvD = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.dvD = System.currentTimeMillis();
        }
        avs();
        avu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cxA != null) {
            this.cxA.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dvB = false;
        if (this.cxA != null) {
            this.cxA.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dvG);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cxA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.dvv == null || this.dvv.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.dvv.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void avs() {
        if (this.cxA == null) {
            this.cxA = new VoiceManager();
            this.cxA.onCreate(getPageContext());
        }
        this.cxA.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.dvv == null) {
            return null;
        }
        return this.dvv.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Jn() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Jo() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Jp() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Jq() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Jr() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Js() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Jt() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
        av.vI().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.dvv != null && this.dvv.isMoreVisible()) {
                this.dvv.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dvF && this.dvv != null) {
            avt();
        }
        super.finish();
    }

    protected boolean avt() {
        return this.dvw.saveDraft(this.dvv.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cxA != null) {
            this.cxA.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dvB = true;
        if (this.cxA != null) {
            this.cxA.onResume(getPageContext());
            this.cxA.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.dvG);
    }

    private void ajk() {
        if (this.cxA != null) {
            this.cxA.stopPlay();
        }
    }

    public boolean avu() {
        if (k.dG()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(d.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avv() {
        final String beforeSendMsgText = this.dvv.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.dvv.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.dvw.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void avw() {
        if (avu()) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.dvv != null) {
            ajk();
            if (view == this.dvv.getBtnBack()) {
                this.dvv.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.dvv.getLayNewMsg()) {
                this.dvv.refreshGo2New(this.dvw.getData());
                this.dvv.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.cxA != null) {
            this.cxA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dvI && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.dvv.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.cxA == null || !recorderManager.lF()) {
                    return true;
                }
                recorderManager.a(this.dvv, -1);
                this.dvv.closeRecordCancel();
                this.dvv.refreshSendVoiceText(true);
                this.dvv.startRecordVoice();
                this.dvI = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.lE();
                    }
                    this.dvv.closeRecordCancel();
                } else if (!this.dvB) {
                    if (recorderManager != null) {
                        recorderManager.lE();
                    }
                    this.dvv.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.dvv.stopRecordVoice();
                }
                this.dvv.refreshSendVoiceText(false);
                this.dvI = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.dvv.showRecordCancel();
                    this.dvv.stopRecordVoice();
                    this.dvI = false;
                    return true;
                }
                this.dvv.closeRecordCancel();
                this.dvv.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void c(com.baidu.tbadk.coreExtra.data.l lVar) {
        this.dvw.sendBigEmotionMessage(lVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        avx();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dvv.closeNewMsg();
    }

    private void avx() {
        this.dvw.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dvw != null) {
            this.dvw.onDestroy();
        }
        super.onDestroy();
        if (this.cxA != null) {
            this.cxA.onDestory(getPageContext());
        }
        if (this.dvz != null) {
            this.dvz = null;
        }
        if (this.dvx != null) {
            this.dvx.cancelLoadData();
            this.dvx = null;
        }
        if (this.dvv != null) {
            this.dvv.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
        if (bVar == this.dvv.getMsgItemOperationDialog()) {
            int intValue = ((Integer) bVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    E(intValue, charSequence);
                    this.dvv.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void E(int i, String str) {
        ChatMessage msg = this.dvw.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(d.j.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aw(msg.getContent());
                showToast(d.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.dvv.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.delete))) {
            if ((this.dvE instanceof ChatVoiceView) && ((ChatVoiceView) this.dvE).isPlaying() && this.cxA != null) {
                this.cxA.stopPlay();
            }
            this.dvw.markDeleteMsg(i);
            showToast(d.j.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.save))) {
            String I = com.baidu.tieba.im.util.e.I(msg.getContent(), true);
            if (I != null) {
                this.dvz = new i(I, this);
                this.dvz.execute();
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(d.j.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.cxA.setSpeakerphoneOn(true);
                this.dvv.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.cxA.setSpeakerphoneOn(false);
            this.dvv.showReceiver();
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
                aVar.cS(TbadkCoreApplication.getInst().getString(d.j.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.getInst().getString(d.j.msg_resend), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.reSendMsg(i2);
                    }
                });
                aVar.b(TbadkCoreApplication.getInst().getString(d.j.delete), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.deleteMsg(i2);
                    }
                });
                aVar.b(getPageContext()).th();
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
                if (!avu() || (msg2 = this.dvw.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.u(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.dvw.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.w(msg3) && (msg = this.dvw.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.dvw.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            av.vI().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bi(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.aBP() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.aBP()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.aBP()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.aBP()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.aBP()).getThreadType() == 33) {
                                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.aBP()).getThreadId()).pi()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.aBP()).getThreadId(), ((ShareFromPBMsgData) aVar2.aBP()).getPostId(), null)));
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
                    showToast(TbadkCoreApplication.getInst().getString(d.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.dvw.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bi(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.aBP() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.hh()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.dvw.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bi(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.aBP() != null) {
                        av.vI().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.aBP()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.hh()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.dvw.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        av.vI().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.dvw.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bi(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.aBP() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.aBP()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.aBP()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.dvw.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.dvw.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.cxA == null || this.cxA.getRecorderManager() == null) {
            return null;
        }
        return this.cxA.getRecorderManager();
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aJ(getApplicationContext())) {
                ai.c(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
