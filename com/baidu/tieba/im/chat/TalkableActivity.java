package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.e.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.f;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, BdListView.e, BdListView.h, a.InterfaceC0062a, b.InterfaceC0101b, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private boolean bAQ;
    private com.baidu.tbadk.core.util.b.a bkZ;
    protected VoiceManager dmn;
    protected boolean elC;
    private View elF;
    private boolean elJ;
    protected Handler handler = new Handler();
    protected AbsMsglistView elx = null;
    protected MsglistModel ely = null;
    protected LocalPicModel elz = null;
    protected com.baidu.adp.base.d elA = null;
    protected i elB = null;
    protected a.InterfaceC0114a<ChatMessage> elD = null;
    private long elE = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean elG = true;
    private CustomMessageListener elH = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d elI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (!com.baidu.adp.lib.util.j.jE()) {
                if (TalkableActivity.this.elx != null) {
                    TalkableActivity.this.elx.displayNoNetwork();
                }
            } else if (TalkableActivity.this.elx != null) {
                TalkableActivity.this.elx.hideNoNetwork();
            }
            switch (TalkableActivity.this.ely.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.elE > -1) {
                        TalkableActivity.this.elE = -1L;
                    }
                    TalkableActivity.this.elx.closeProgress();
                    TalkableActivity.this.elx.refreshGo2New(TalkableActivity.this.ely.getData());
                    return;
                case 2:
                    TalkableActivity.this.elx.refreshPrepage(TalkableActivity.this.ely.getData());
                    return;
                case 3:
                    TalkableActivity.this.elx.refreshCheckNew(TalkableActivity.this.ely.getData());
                    return;
                case 4:
                    TalkableActivity.this.elx.refreshGo2New(TalkableActivity.this.ely.getData());
                    return;
                case 5:
                    TalkableActivity.this.elx.refreshNormal(TalkableActivity.this.ely.getData());
                    return;
                case 6:
                    TalkableActivity.this.elx.refreshNormal(TalkableActivity.this.ely.getData());
                    return;
                case 7:
                    TalkableActivity.this.elx.refreshNormal(TalkableActivity.this.ely.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.elx.setDraft(str);
                        TalkableActivity.this.ely.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.elG = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.elx.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.elG = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.elx.refreshGo2New(TalkableActivity.this.ely.getData());
                    return;
                case 13:
                    TalkableActivity.this.elx.refreshNormal(TalkableActivity.this.ely.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.elx.refreshNormal(TalkableActivity.this.ely.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void aHu() {
        this.elA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.ely != null) {
                        TalkableActivity.this.ely.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                        return;
                    }
                    return;
                }
                TalkableActivity.this.showToast(TbadkCoreApplication.getInst().getString(f.j.pic_parser_error));
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
            this.elE = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.elE = System.currentTimeMillis();
        }
        this.elD = new a.InterfaceC0114a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0114a
            /* renamed from: a */
            public void b(int i, ChatMessage chatMessage) {
                TalkableActivity.this.elx.updateAdapter(i, chatMessage);
            }
        };
        aHv();
        aHx();
        addGlobalLayoutListener();
        setSkinType(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        final String str;
        final String str2;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (intent != null) {
                if (i == 12010 || i == 12009 || (!StringUtils.isNull(intent.getStringExtra("file_name")) && i == 12002)) {
                    String stringExtra = intent.getStringExtra("file_name");
                    if (stringExtra != null) {
                        str = stringExtra;
                        str2 = TbConfig.LOCAL_PIC_DIR;
                    } else {
                        str2 = null;
                        str = TbConfig.IMAGE_RESIZED_FILE;
                    }
                    if (this.elz != null) {
                        this.elz.cancelLoadData();
                        this.elz = null;
                    }
                    String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !w.z(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            v.a(new u<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.u
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap a = ab.a(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), ar.zu().zA());
                                        if (a != null && l.a((String) null, TbConfig.IMAGE_RESIZED_FILE, a, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(a, 100)) != null) {
                                            if (l.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new com.baidu.tbadk.util.g<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                                @Override // com.baidu.tbadk.util.g
                                public void onReturnDataInUI(Object obj) {
                                    TalkableActivity.this.elz = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.elz.setLoadDataCallBack(TalkableActivity.this.elA);
                                    TalkableActivity.this.elz.getData();
                                    TalkableActivity.this.elx.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.elz = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.elz.setLoadDataCallBack(this.elA);
                        this.elz.getData();
                        this.elx.hideMore();
                        return;
                    }
                    this.elz = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.elz.setLoadDataCallBack(this.elA);
                    this.elz.getData();
                    this.elx.hideMore();
                    return;
                }
                int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                String string = TbadkCoreApplication.getInst().getString(f.j.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(f.j.cancel);
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            c(maxChatImageWidthInPx, string, string2);
                        } else {
                            a(intent, maxChatImageWidthInPx, string, string2);
                        }
                    }
                } else if (i == 12001) {
                    c(maxChatImageWidthInPx, string, string2);
                }
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                takePhoto();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                aHz();
            }
        }
    }

    private void takePhoto() {
        if (this.bkZ == null) {
            this.bkZ = new com.baidu.tbadk.core.util.b.a();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.bkZ.zW();
        this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.bkZ.u(pageActivity)) {
            al.b(getPageContext());
        }
    }

    private void a(Intent intent, int i, String str, String str2) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null && this.writeImagesInfo != null) {
            this.writeImagesInfo.mIsFromIm = true;
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, this.writeImagesInfo, 0)));
                this.writeImagesInfo.clear();
            }
        }
    }

    private void c(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), 12001, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, null, null, null, i, str, str2, "")));
    }

    public void b(View view, int i, int i2, long j) {
        this.elF = view;
        ChatMessage msg = this.ely.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.elC = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.elx.showDiaItemContentOperate(i2, t(i, this.elC));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] t(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(f.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(f.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.save));
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
            case 5:
                arrayList.add(TbadkCoreApplication.getInst().isHeadsetModeOn() ? TbadkCoreApplication.getInst().getString(f.j.group_close_receiver) : TbadkCoreApplication.getInst().getString(f.j.group_open_receiver));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(f.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(f.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(f.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(f.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(f.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.getInst().getString(f.j.delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.elE = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.elE = System.currentTimeMillis();
        }
        aHv();
        aHx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bAQ = false;
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.elH);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dmn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.elx == null || this.elx.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.elx.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void aHv() {
        if (this.dmn == null) {
            this.dmn = new VoiceManager();
            this.dmn.onCreate(getPageContext());
        }
        this.dmn.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.elx == null) {
            return null;
        }
        return this.elx.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Od() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Oe() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Of() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Og() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Oh() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Oi() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Oj() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        az.zI().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void h(Context context, String str, String str2) {
    }

    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.elx != null && this.elx.isMoreVisible()) {
                this.elx.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.elG && this.elx != null) {
            aHw();
        }
        super.finish();
    }

    protected boolean aHw() {
        return this.ely.saveDraft(this.elx.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bAQ = true;
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
            this.dmn.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.elH);
    }

    private void auA() {
        if (this.dmn != null) {
            this.dmn.stopPlay();
        }
    }

    public boolean aHx() {
        if (l.gd()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(f.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aHy() {
        final String beforeSendMsgText = this.elx.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.elx.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.ely.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void aHz() {
        if (aHx()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.elx != null) {
            auA();
            if (view == this.elx.getBtnBack()) {
                this.elx.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.elx.getLayNewMsg()) {
                this.elx.refreshGo2New(this.ely.getData());
                this.elx.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.dmn != null) {
            this.dmn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.elJ && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.elx.getBtnSendVoice()) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bkZ == null) {
                this.bkZ = new com.baidu.tbadk.core.util.b.a();
            }
            this.bkZ.zW();
            this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.bkZ.c(pageActivity, "android.permission.RECORD_AUDIO");
            if (this.bkZ.u(pageActivity)) {
                return false;
            }
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.dmn == null || !recorderManager.oF()) {
                    return true;
                }
                recorderManager.a(this.elx, -1);
                this.elx.closeRecordCancel();
                this.elx.refreshSendVoiceText(true);
                this.elx.startRecordVoice();
                this.elJ = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.oE();
                    }
                    this.elx.closeRecordCancel();
                } else if (!this.bAQ) {
                    if (recorderManager != null) {
                        recorderManager.oE();
                    }
                    this.elx.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.elx.stopRecordVoice();
                }
                this.elx.refreshSendVoiceText(false);
                this.elJ = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.elx.showRecordCancel();
                    this.elx.stopRecordVoice();
                    this.elJ = false;
                } else {
                    this.elx.closeRecordCancel();
                    this.elx.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void c(n nVar) {
        this.ely.sendBigEmotionMessage(nVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        aHA();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.elx.closeNewMsg();
    }

    private void aHA() {
        this.ely.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ely != null) {
            this.ely.onDestroy();
        }
        super.onDestroy();
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
        if (this.elB != null) {
            this.elB = null;
        }
        if (this.elz != null) {
            this.elz.cancelLoadData();
            this.elz = null;
        }
        if (this.elx != null) {
            this.elx.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
        if (bVar == this.elx.getMsgItemOperationDialog()) {
            int intValue = ((Integer) bVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    T(intValue, charSequence);
                    this.elx.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void T(int i, String str) {
        ChatMessage msg = this.ely.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(f.j.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aQ(msg.getContent());
                showToast(f.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(f.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.elx.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(f.j.delete))) {
            if ((this.elF instanceof ChatVoiceView) && ((ChatVoiceView) this.elF).isPlaying() && this.dmn != null) {
                this.dmn.stopPlay();
            }
            this.ely.markDeleteMsg(i);
            showToast(f.j.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(f.j.save))) {
            String F = com.baidu.tieba.im.util.e.F(msg.getContent(), true);
            if (F != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.bkZ == null) {
                    this.bkZ = new com.baidu.tbadk.core.util.b.a();
                }
                this.bkZ.zW();
                this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.bkZ.u(pageActivity)) {
                    this.elB = new i(F, this);
                    this.elB.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(f.j.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(f.j.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.dmn.setSpeakerphoneOn(true);
                this.elx.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.dmn.setSpeakerphoneOn(false);
            this.elx.showReceiver();
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
                aVar.dB(TbadkCoreApplication.getInst().getString(f.j.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.getInst().getString(f.j.msg_resend), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.reSendMsg(i2);
                    }
                });
                aVar.b(TbadkCoreApplication.getInst().getString(f.j.delete), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.9
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.deleteMsg(i2);
                    }
                });
                aVar.b(getPageContext()).xe();
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
                if (!aHx() || (msg2 = this.ely.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.v(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.ely.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.x(msg3) && (msg = this.ely.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content2).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), com.baidu.adp.lib.g.b.g(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.g.b.c(optJSONObject.optString("groupId"), 0L), 2)));
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
                ChatMessage msg4 = this.ely.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            az.zI().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bx(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.aNL() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.aNL()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.aNL()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.aNL()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.aNL()).getThreadId(), ((ShareFromPBMsgData) aVar2.aNL()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.j.jE()) {
                    showToast(TbadkCoreApplication.getInst().getString(f.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.ely.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bx(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.aNL() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.jE()) {
                    showToast(TbadkCoreApplication.getInst().getString(f.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.ely.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bx(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.aNL() != null) {
                        az.zI().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.aNL()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.jE()) {
                    showToast(TbadkCoreApplication.getInst().getString(f.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.ely.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        az.zI().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.ely.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bx(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.aNL() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.aNL()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.aNL()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.ely.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.ely.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.dmn == null || this.dmn.getRecorderManager() == null) {
            return null;
        }
        return this.dmn.getRecorderManager();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(f.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(f.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
