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
    protected boolean gcB;
    private View gcE;
    private boolean gcI;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    protected Handler handler = new Handler();
    protected AbsMsglistView gcw = null;
    protected MsglistModel gcx = null;
    protected LocalPicModel gcy = null;
    protected com.baidu.adp.base.d gcz = null;
    protected i gcA = null;
    protected a.InterfaceC0205a<ChatMessage> gcC = null;
    private long gcD = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean gcF = true;
    private CustomMessageListener gcG = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d gcH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                if (TalkableActivity.this.gcw != null) {
                    TalkableActivity.this.gcw.displayNoNetwork();
                }
            } else if (TalkableActivity.this.gcw != null) {
                TalkableActivity.this.gcw.hideNoNetwork();
            }
            switch (TalkableActivity.this.gcx.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.gcD > -1) {
                        TalkableActivity.this.gcD = -1L;
                    }
                    TalkableActivity.this.gcw.closeProgress();
                    TalkableActivity.this.gcw.refreshGo2New(TalkableActivity.this.gcx.getData());
                    return;
                case 2:
                    TalkableActivity.this.gcw.refreshPrepage(TalkableActivity.this.gcx.getData());
                    return;
                case 3:
                    TalkableActivity.this.gcw.refreshCheckNew(TalkableActivity.this.gcx.getData());
                    return;
                case 4:
                    TalkableActivity.this.gcw.refreshGo2New(TalkableActivity.this.gcx.getData());
                    return;
                case 5:
                    TalkableActivity.this.gcw.refreshNormal(TalkableActivity.this.gcx.getData());
                    return;
                case 6:
                    TalkableActivity.this.gcw.refreshNormal(TalkableActivity.this.gcx.getData());
                    return;
                case 7:
                    TalkableActivity.this.gcw.refreshNormal(TalkableActivity.this.gcx.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.gcw.setDraft(str);
                        TalkableActivity.this.gcx.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.gcF = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.gcw.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.gcF = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.gcw.refreshGo2New(TalkableActivity.this.gcx.getData());
                    return;
                case 13:
                    TalkableActivity.this.gcw.refreshNormal(TalkableActivity.this.gcx.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.gcw.refreshNormal(TalkableActivity.this.gcx.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqj() {
        this.gcz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.gcx != null) {
                        TalkableActivity.this.gcx.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
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
            this.gcD = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.gcD = System.currentTimeMillis();
        }
        this.gcC = new a.InterfaceC0205a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0205a
            /* renamed from: a */
            public void d(int i, ChatMessage chatMessage) {
                TalkableActivity.this.gcw.updateAdapter(i, chatMessage);
            }
        };
        bqk();
        bqm();
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
                    if (this.gcy != null) {
                        this.gcy.cancelLoadData();
                        this.gcy = null;
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
                                    TalkableActivity.this.gcy = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.gcy.setLoadDataCallBack(TalkableActivity.this.gcz);
                                    TalkableActivity.this.gcy.getData();
                                    TalkableActivity.this.gcw.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.gcy = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.gcy.setLoadDataCallBack(this.gcz);
                        this.gcy.getData();
                        this.gcw.hideMore();
                        return;
                    }
                    this.gcy = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.gcy.setLoadDataCallBack(this.gcz);
                    this.gcy.getData();
                    this.gcw.hideMore();
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
                bqo();
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
        this.gcE = view;
        ChatMessage msg = this.gcx.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.gcB = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.gcw.showDiaItemContentOperate(i2, A(i, this.gcB));
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
            this.gcD = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.gcD = System.currentTimeMillis();
        }
        bqk();
        bqm();
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
        MessageManager.getInstance().unRegisterListener(this.gcG);
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
        if (this.gcw == null || this.gcw.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.gcw.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void bqk() {
        if (this.eYS == null) {
            this.eYS = new VoiceManager();
            this.eYS.onCreate(getPageContext());
        }
        this.eYS.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.gcw == null) {
            return null;
        }
        return this.gcw.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ate() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> atf() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> atg() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ath() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ati() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> atj() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> atk() {
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
            if (this.gcw != null && this.gcw.isMoreVisible()) {
                this.gcw.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gcF && this.gcw != null) {
            bql();
        }
        super.finish();
    }

    protected boolean bql() {
        return this.gcx.saveDraft(this.gcw.getDraft());
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
        registerListener(this.gcG);
    }

    private void bcN() {
        if (this.eYS != null) {
            this.eYS.stopPlay();
        }
    }

    public boolean bqm() {
        if (m.hy()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(d.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqn() {
        final String beforeSendMsgText = this.gcw.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.gcw.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.gcx.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void bqo() {
        if (bqm()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gcw != null) {
            bcN();
            if (view == this.gcw.getBtnBack()) {
                this.gcw.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.gcw.getLayNewMsg()) {
                this.gcw.refreshGo2New(this.gcx.getData());
                this.gcw.closeNewMsg();
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
        if (this.gcI && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.gcw.getBtnSendVoice()) {
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
                recorderManager.a(this.gcw, -1);
                this.gcw.closeRecordCancel();
                this.gcw.refreshSendVoiceText(true);
                this.gcw.startRecordVoice();
                this.gcI = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.qV();
                    }
                    this.gcw.closeRecordCancel();
                } else if (!this.djC) {
                    if (recorderManager != null) {
                        recorderManager.qV();
                    }
                    this.gcw.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.gcw.stopRecordVoice();
                }
                this.gcw.refreshSendVoiceText(false);
                this.gcI = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.gcw.showRecordCancel();
                    this.gcw.stopRecordVoice();
                    this.gcI = false;
                } else {
                    this.gcw.closeRecordCancel();
                    this.gcw.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void d(p pVar) {
        this.gcx.sendBigEmotionMessage(pVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        bqp();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gcw.closeNewMsg();
    }

    private void bqp() {
        this.gcx.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gcx != null) {
            this.gcx.onDestroy();
        }
        super.onDestroy();
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
        if (this.gcA != null) {
            this.gcA = null;
        }
        if (this.gcy != null) {
            this.gcy.cancelLoadData();
            this.gcy = null;
        }
        if (this.gcw != null) {
            this.gcw.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.i.c
    public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
        if (this.gcw.getMsgItemOperationDialog() != null && iVar.getRootView() == this.gcw.getMsgItemOperationDialog().getContentView()) {
            int intValue = ((Integer) iVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    ai(intValue, charSequence);
                    this.gcw.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void ai(int i, String str) {
        ChatMessage msg = this.gcx.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(d.j.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.bh(msg.getContent());
                showToast(d.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.gcw.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.delete))) {
            if ((this.gcE instanceof ChatVoiceView) && ((ChatVoiceView) this.gcE).isPlaying() && this.eYS != null) {
                this.eYS.stopPlay();
            }
            this.gcx.markDeleteMsg(i);
            showToast(d.j.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.save))) {
            String ai = com.baidu.tieba.im.util.e.ai(msg.getContent(), true);
            if (ai != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                }
                this.mPermissionJudgement.adQ();
                this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.mPermissionJudgement.Y(pageActivity)) {
                    this.gcA = new i(ai, this);
                    this.gcA.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(d.j.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.eYS.setSpeakerphoneOn(true);
                this.gcw.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.eYS.setSpeakerphoneOn(false);
            this.gcw.showReceiver();
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
                if (!bqm() || (msg2 = this.gcx.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.v(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.gcx.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.x(msg3) && (msg = this.gcx.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.gcx.getMsg(i2);
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
                    if (aVar2.getSubType() == 1 && aVar2.bww() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.bww()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long d = com.baidu.adp.lib.g.b.d(theNewThemeId, 0L);
                            if (d > 0) {
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), d, ((ShareFromPBMsgData) aVar2.bww()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.bww()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.bww()).getThreadId(), ((ShareFromPBMsgData) aVar2.bww()).getPostId(), null)));
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
                ChatMessage msg5 = this.gcx.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.df(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.bww() != null) {
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
                ChatMessage msg6 = this.gcx.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.df(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.bww() != null) {
                        ba.adD().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.bww()).getShareSourceUrl()}, true);
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
                ChatMessage msg7 = this.gcx.getMsg(i2);
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
                ChatMessage msg8 = this.gcx.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.df(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.bww() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.bww()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.bww()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.gcx.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.gcx.deleteMsg(i);
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
