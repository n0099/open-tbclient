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
import com.baidu.adp.lib.c.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, b, BdListView.e, BdListView.h, a.InterfaceC0040a, i.c, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private boolean djC;
    protected VoiceManager eYS;
    protected boolean gcA;
    private View gcD;
    private boolean gcH;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    protected Handler handler = new Handler();
    protected AbsMsglistView gcv = null;
    protected MsglistModel gcw = null;
    protected LocalPicModel gcx = null;
    protected com.baidu.adp.base.d gcy = null;
    protected i gcz = null;
    protected a.InterfaceC0205a<ChatMessage> gcB = null;
    private long gcC = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean gcE = true;
    private CustomMessageListener gcF = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d gcG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                if (TalkableActivity.this.gcv != null) {
                    TalkableActivity.this.gcv.displayNoNetwork();
                }
            } else if (TalkableActivity.this.gcv != null) {
                TalkableActivity.this.gcv.hideNoNetwork();
            }
            switch (TalkableActivity.this.gcw.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.gcC > -1) {
                        TalkableActivity.this.gcC = -1L;
                    }
                    TalkableActivity.this.gcv.closeProgress();
                    TalkableActivity.this.gcv.refreshGo2New(TalkableActivity.this.gcw.getData());
                    return;
                case 2:
                    TalkableActivity.this.gcv.refreshPrepage(TalkableActivity.this.gcw.getData());
                    return;
                case 3:
                    TalkableActivity.this.gcv.refreshCheckNew(TalkableActivity.this.gcw.getData());
                    return;
                case 4:
                    TalkableActivity.this.gcv.refreshGo2New(TalkableActivity.this.gcw.getData());
                    return;
                case 5:
                    TalkableActivity.this.gcv.refreshNormal(TalkableActivity.this.gcw.getData());
                    return;
                case 6:
                    TalkableActivity.this.gcv.refreshNormal(TalkableActivity.this.gcw.getData());
                    return;
                case 7:
                    TalkableActivity.this.gcv.refreshNormal(TalkableActivity.this.gcw.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.gcv.setDraft(str);
                        TalkableActivity.this.gcw.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.gcE = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.gcv.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.gcE = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.gcv.refreshGo2New(TalkableActivity.this.gcw.getData());
                    return;
                case 13:
                    TalkableActivity.this.gcv.refreshNormal(TalkableActivity.this.gcw.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.gcv.refreshNormal(TalkableActivity.this.gcw.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqi() {
        this.gcy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.gcw != null) {
                        TalkableActivity.this.gcw.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
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
            this.gcC = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.gcC = System.currentTimeMillis();
        }
        this.gcB = new a.InterfaceC0205a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0205a
            /* renamed from: a */
            public void d(int i, ChatMessage chatMessage) {
                TalkableActivity.this.gcv.updateAdapter(i, chatMessage);
            }
        };
        bqj();
        bql();
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
                    if (this.gcx != null) {
                        this.gcx.cancelLoadData();
                        this.gcx = null;
                    }
                    String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !v.T(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            aa.a(new z<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.z
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap a = ag.a(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), ar.adp().adv());
                                        if (a != null && m.a((String) null, TbConfig.IMAGE_RESIZED_FILE, a, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(a, 100)) != null) {
                                            if (m.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new k<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                                @Override // com.baidu.tbadk.util.k
                                public void onReturnDataInUI(Object obj) {
                                    TalkableActivity.this.gcx = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.gcx.setLoadDataCallBack(TalkableActivity.this.gcy);
                                    TalkableActivity.this.gcx.getData();
                                    TalkableActivity.this.gcv.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.gcx = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.gcx.setLoadDataCallBack(this.gcy);
                        this.gcx.getData();
                        this.gcv.hideMore();
                        return;
                    }
                    this.gcx = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.gcx.setLoadDataCallBack(this.gcy);
                    this.gcx.getData();
                    this.gcv.hideMore();
                    return;
                }
                int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                String string = TbadkCoreApplication.getInst().getString(d.j.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(d.j.cancel);
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            f(maxChatImageWidthInPx, string, string2);
                        } else {
                            a(intent, maxChatImageWidthInPx, string, string2);
                        }
                    }
                } else if (i == 12001) {
                    f(maxChatImageWidthInPx, string, string2);
                }
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                takePhoto();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                bqn();
            }
        }
    }

    private void takePhoto() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.mPermissionJudgement.adQ();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.Y(pageActivity)) {
            ak.c(getPageContext());
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

    private void f(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), 12001, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, null, null, null, i, str, str2, "")));
    }

    @Override // com.baidu.adp.lib.c.b
    public void b(View view, int i, int i2, long j) {
        this.gcD = view;
        ChatMessage msg = this.gcw.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.gcA = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.gcv.showDiaItemContentOperate(i2, A(i, this.gcA));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] A(int i, boolean z) {
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
            this.gcC = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.gcC = System.currentTimeMillis();
        }
        bqj();
        bql();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.eYS != null) {
            this.eYS.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.djC = false;
        if (this.eYS != null) {
            this.eYS.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gcF);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eYS;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.gcv == null || this.gcv.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.gcv.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void bqj() {
        if (this.eYS == null) {
            this.eYS = new VoiceManager();
            this.eYS.onCreate(getPageContext());
        }
        this.eYS.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.gcv == null) {
            return null;
        }
        return this.gcv.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int atd() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ate() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atf() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> atg() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ath() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ati() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atj() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        ba.adD().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aB(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aC(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void k(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aD(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.gcv != null && this.gcv.isMoreVisible()) {
                this.gcv.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gcE && this.gcv != null) {
            bqk();
        }
        super.finish();
    }

    protected boolean bqk() {
        return this.gcw.saveDraft(this.gcv.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.djC = true;
        if (this.eYS != null) {
            this.eYS.onResume(getPageContext());
            this.eYS.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.gcF);
    }

    private void bcM() {
        if (this.eYS != null) {
            this.eYS.stopPlay();
        }
    }

    public boolean bql() {
        if (m.hy()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(d.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqm() {
        final String beforeSendMsgText = this.gcv.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.gcv.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.gcw.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void bqn() {
        if (bql()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gcv != null) {
            bcM();
            if (view == this.gcv.getBtnBack()) {
                this.gcv.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.gcv.getLayNewMsg()) {
                this.gcv.refreshGo2New(this.gcw.getData());
                this.gcv.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.eYS != null) {
            this.eYS.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.gcH && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.gcv.getBtnSendVoice()) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.adQ();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgement.e(pageActivity, "android.permission.RECORD_AUDIO");
            if (this.mPermissionJudgement.Y(pageActivity)) {
                return false;
            }
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.eYS == null || !recorderManager.qW()) {
                    return true;
                }
                recorderManager.a(this.gcv, -1);
                this.gcv.closeRecordCancel();
                this.gcv.refreshSendVoiceText(true);
                this.gcv.startRecordVoice();
                this.gcH = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.qV();
                    }
                    this.gcv.closeRecordCancel();
                } else if (!this.djC) {
                    if (recorderManager != null) {
                        recorderManager.qV();
                    }
                    this.gcv.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.gcv.stopRecordVoice();
                }
                this.gcv.refreshSendVoiceText(false);
                this.gcH = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.gcv.showRecordCancel();
                    this.gcv.stopRecordVoice();
                    this.gcH = false;
                } else {
                    this.gcv.closeRecordCancel();
                    this.gcv.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void d(p pVar) {
        this.gcw.sendBigEmotionMessage(pVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        bqo();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gcv.closeNewMsg();
    }

    private void bqo() {
        this.gcw.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gcw != null) {
            this.gcw.onDestroy();
        }
        super.onDestroy();
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
        if (this.gcz != null) {
            this.gcz = null;
        }
        if (this.gcx != null) {
            this.gcx.cancelLoadData();
            this.gcx = null;
        }
        if (this.gcv != null) {
            this.gcv.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.i.c
    public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        if (this.gcv.getMsgItemOperationDialog() != null && iVar.getRootView() == this.gcv.getMsgItemOperationDialog().getContentView()) {
            int intValue = ((Integer) iVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    ai(intValue, charSequence);
                    this.gcv.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void ai(int i, String str) {
        ChatMessage msg = this.gcw.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(d.j.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.bh(msg.getContent());
                showToast(d.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.gcv.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.delete))) {
            if ((this.gcD instanceof ChatVoiceView) && ((ChatVoiceView) this.gcD).isPlaying() && this.eYS != null) {
                this.eYS.stopPlay();
            }
            this.gcw.markDeleteMsg(i);
            showToast(d.j.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.save))) {
            String ah = com.baidu.tieba.im.util.e.ah(msg.getContent(), true);
            if (ah != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                }
                this.mPermissionJudgement.adQ();
                this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.mPermissionJudgement.Y(pageActivity)) {
                    this.gcz = new i(ah, this);
                    this.gcz.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(d.j.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.eYS.setSpeakerphoneOn(true);
                this.gcv.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.eYS.setSpeakerphoneOn(false);
            this.gcv.showReceiver();
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
                aVar.ly(TbadkCoreApplication.getInst().getString(d.j.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.getInst().getString(d.j.msg_resend), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.reSendMsg(i2);
                    }
                });
                aVar.b(TbadkCoreApplication.getInst().getString(d.j.delete), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.9
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.deleteMsg(i2);
                    }
                });
                aVar.b(getPageContext()).aaZ();
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
                if (!bql() || (msg2 = this.gcw.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.v(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.gcw.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.x(msg3) && (msg = this.gcw.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content2).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), com.baidu.adp.lib.g.b.l(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.g.b.d(optJSONObject.optString("groupId"), 0L), 2)));
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
                ChatMessage msg4 = this.gcw.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            ba.adD().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.df(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.bwv() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.bwv()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long d = com.baidu.adp.lib.g.b.d(theNewThemeId, 0L);
                            if (d > 0) {
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), d, ((ShareFromPBMsgData) aVar2.bwv()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.bwv()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.bwv()).getThreadId(), ((ShareFromPBMsgData) aVar2.bwv()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.j.kY()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.gcw.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.df(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.bwv() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.kY()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.gcw.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.df(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.bwv() != null) {
                        ba.adD().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.bwv()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.kY()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.gcw.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        ba.adD().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.gcw.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.df(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.bwv() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.bwv()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.bwv()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.gcw.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.gcw.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.eYS == null || this.eYS.getRecorderManager() == null) {
            return null;
        }
        return this.eYS.getRecorderManager();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cS(getApplicationContext())) {
                ak.c(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
