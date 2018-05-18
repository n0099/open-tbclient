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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, BdListView.e, BdListView.h, a.InterfaceC0045a, b.InterfaceC0086b, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private com.baidu.tbadk.core.util.b.a baE;
    private boolean bqx;
    protected VoiceManager cYn;
    protected boolean dSJ;
    private View dSM;
    private boolean dSQ;
    protected Handler handler = new Handler();
    protected AbsMsglistView dSE = null;
    protected MsglistModel dSF = null;
    protected LocalPicModel dSG = null;
    protected com.baidu.adp.base.d dSH = null;
    protected i dSI = null;
    protected a.InterfaceC0099a<ChatMessage> dSK = null;
    private long dSL = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean dSN = true;
    private CustomMessageListener dSO = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d dSP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (!com.baidu.adp.lib.util.j.gP()) {
                if (TalkableActivity.this.dSE != null) {
                    TalkableActivity.this.dSE.displayNoNetwork();
                }
            } else if (TalkableActivity.this.dSE != null) {
                TalkableActivity.this.dSE.hideNoNetwork();
            }
            switch (TalkableActivity.this.dSF.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.dSL > -1) {
                        TalkableActivity.this.dSL = -1L;
                    }
                    TalkableActivity.this.dSE.closeProgress();
                    TalkableActivity.this.dSE.refreshGo2New(TalkableActivity.this.dSF.getData());
                    return;
                case 2:
                    TalkableActivity.this.dSE.refreshPrepage(TalkableActivity.this.dSF.getData());
                    return;
                case 3:
                    TalkableActivity.this.dSE.refreshCheckNew(TalkableActivity.this.dSF.getData());
                    return;
                case 4:
                    TalkableActivity.this.dSE.refreshGo2New(TalkableActivity.this.dSF.getData());
                    return;
                case 5:
                    TalkableActivity.this.dSE.refreshNormal(TalkableActivity.this.dSF.getData());
                    return;
                case 6:
                    TalkableActivity.this.dSE.refreshNormal(TalkableActivity.this.dSF.getData());
                    return;
                case 7:
                    TalkableActivity.this.dSE.refreshNormal(TalkableActivity.this.dSF.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.dSE.setDraft(str);
                        TalkableActivity.this.dSF.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.dSN = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.dSE.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                    TalkableActivity.this.dSN = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.dSE.refreshGo2New(TalkableActivity.this.dSF.getData());
                    return;
                case 13:
                    TalkableActivity.this.dSE.refreshNormal(TalkableActivity.this.dSF.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.dSE.refreshNormal(TalkableActivity.this.dSF.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAU() {
        this.dSH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.dSF != null) {
                        TalkableActivity.this.dSF.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                        return;
                    }
                    return;
                }
                TalkableActivity.this.showToast(TbadkCoreApplication.getInst().getString(d.k.pic_parser_error));
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
            this.dSL = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.dSL = System.currentTimeMillis();
        }
        this.dSK = new a.InterfaceC0099a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0099a
            /* renamed from: a */
            public void b(int i, ChatMessage chatMessage) {
                TalkableActivity.this.dSE.updateAdapter(i, chatMessage);
            }
        };
        aAV();
        aAX();
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
                    if (this.dSG != null) {
                        this.dSG.cancelLoadData();
                        this.dSG = null;
                    }
                    String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !v.w(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.u
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap a = ab.a(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), ap.vP().vV());
                                        if (a != null && k.a((String) null, TbConfig.IMAGE_RESIZED_FILE, a, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(a, 100)) != null) {
                                            if (k.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new com.baidu.tbadk.util.h<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                                @Override // com.baidu.tbadk.util.h
                                public void onReturnDataInUI(Object obj) {
                                    TalkableActivity.this.dSG = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.dSG.setLoadDataCallBack(TalkableActivity.this.dSH);
                                    TalkableActivity.this.dSG.getData();
                                    TalkableActivity.this.dSE.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.dSG = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.dSG.setLoadDataCallBack(this.dSH);
                        this.dSG.getData();
                        this.dSE.hideMore();
                        return;
                    }
                    this.dSG = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.dSG.setLoadDataCallBack(this.dSH);
                    this.dSG.getData();
                    this.dSE.hideMore();
                    return;
                }
                int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                String string = TbadkCoreApplication.getInst().getString(d.k.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(d.k.cancel);
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
                aAZ();
            }
        }
    }

    private void takePhoto() {
        if (this.baE == null) {
            this.baE = new com.baidu.tbadk.core.util.b.a();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.baE.wt();
        this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.baE.v(pageActivity)) {
            aj.b(getPageContext());
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, null, null, null, i, str, str2, "")));
    }

    public void b(View view2, int i, int i2, long j) {
        this.dSM = view2;
        ChatMessage msg = this.dSF.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.dSJ = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.dSE.showDiaItemContentOperate(i2, u(i, this.dSJ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] u(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.k.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.k.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.save));
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
            case 5:
                arrayList.add(TbadkCoreApplication.getInst().isHeadsetModeOn() ? TbadkCoreApplication.getInst().getString(d.k.group_close_receiver) : TbadkCoreApplication.getInst().getString(d.k.group_open_receiver));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.k.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.k.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.k.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.k.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(d.k.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.getInst().getString(d.k.delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.dSL = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.dSL = System.currentTimeMillis();
        }
        aAV();
        aAX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cYn != null) {
            this.cYn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bqx = false;
        if (this.cYn != null) {
            this.cYn.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dSO);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cYn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.dSE == null || this.dSE.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.dSE.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void aAV() {
        if (this.cYn == null) {
            this.cYn = new VoiceManager();
            this.cYn.onCreate(getPageContext());
        }
        this.cYn.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.dSE == null) {
            return null;
        }
        return this.dSE.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Km() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Kn() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Ko() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Kp() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Kq() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Kr() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Ks() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void S(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void T(Context context, String str) {
        ax.wf().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void U(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void g(Context context, String str, String str2) {
    }

    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.dSE != null && this.dSE.isMoreVisible()) {
                this.dSE.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dSN && this.dSE != null) {
            aAW();
        }
        super.finish();
    }

    protected boolean aAW() {
        return this.dSF.saveDraft(this.dSE.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cYn != null) {
            this.cYn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bqx = true;
        if (this.cYn != null) {
            this.cYn.onResume(getPageContext());
            this.cYn.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.dSO);
    }

    private void apB() {
        if (this.cYn != null) {
            this.cYn.stopPlay();
        }
    }

    public boolean aAX() {
        if (k.m15do()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(d.k.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aAY() {
        final String beforeSendMsgText = this.dSE.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.dSE.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.dSF.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void aAZ() {
        if (aAX()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null && this.dSE != null) {
            apB();
            if (view2 == this.dSE.getBtnBack()) {
                this.dSE.sendmsgCloseSoftkey();
                finish();
            } else if (view2 == this.dSE.getLayNewMsg()) {
                this.dSE.refreshGo2New(this.dSF.getData());
                this.dSE.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.cYn != null) {
            this.cYn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dSQ && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (view2 == this.dSE.getBtnSendVoice()) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.baE == null) {
                this.baE = new com.baidu.tbadk.core.util.b.a();
            }
            this.baE.wt();
            this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.baE.c(pageActivity, "android.permission.RECORD_AUDIO");
            if (this.baE.v(pageActivity)) {
                return false;
            }
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.cYn == null || !recorderManager.lP()) {
                    return true;
                }
                recorderManager.a(this.dSE, -1);
                this.dSE.closeRecordCancel();
                this.dSE.refreshSendVoiceText(true);
                this.dSE.startRecordVoice();
                this.dSQ = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.lO();
                    }
                    this.dSE.closeRecordCancel();
                } else if (!this.bqx) {
                    if (recorderManager != null) {
                        recorderManager.lO();
                    }
                    this.dSE.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.dSE.stopRecordVoice();
                }
                this.dSE.refreshSendVoiceText(false);
                this.dSQ = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.dSE.showRecordCancel();
                    this.dSE.stopRecordVoice();
                    this.dSQ = false;
                } else {
                    this.dSE.closeRecordCancel();
                    this.dSE.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void c(n nVar) {
        this.dSF.sendBigEmotionMessage(nVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        aBa();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dSE.closeNewMsg();
    }

    private void aBa() {
        this.dSF.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dSF != null) {
            this.dSF.onDestroy();
        }
        super.onDestroy();
        if (this.cYn != null) {
            this.cYn.onDestory(getPageContext());
        }
        if (this.dSI != null) {
            this.dSI = null;
        }
        if (this.dSG != null) {
            this.dSG.cancelLoadData();
            this.dSG = null;
        }
        if (this.dSE != null) {
            this.dSE.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
        if (bVar == this.dSE.getMsgItemOperationDialog()) {
            int intValue = ((Integer) bVar.getRootView().getTag()).intValue();
            if (view2 instanceof TextView) {
                String charSequence = ((TextView) view2).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    U(intValue, charSequence);
                    this.dSE.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void U(int i, String str) {
        ChatMessage msg = this.dSF.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(d.k.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aB(msg.getContent());
                showToast(d.k.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.k.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.dSE.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.k.delete))) {
            if ((this.dSM instanceof ChatVoiceView) && ((ChatVoiceView) this.dSM).isPlaying() && this.cYn != null) {
                this.cYn.stopPlay();
            }
            this.dSF.markDeleteMsg(i);
            showToast(d.k.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.k.save))) {
            String F = com.baidu.tieba.im.util.e.F(msg.getContent(), true);
            if (F != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.baE == null) {
                    this.baE = new com.baidu.tbadk.core.util.b.a();
                }
                this.baE.wt();
                this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.baE.v(pageActivity)) {
                    this.dSI = new i(F, this);
                    this.dSI.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.k.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(d.k.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.cYn.setSpeakerphoneOn(true);
                this.dSE.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.cYn.setSpeakerphoneOn(false);
            this.dSE.showReceiver();
        }
    }

    public void a(View view2, int i, final int i2, long j) {
        String content;
        ChatMessage msg;
        String content2;
        ChatMessage msg2;
        switch (i) {
            case 1:
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.dc(TbadkCoreApplication.getInst().getString(d.k.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.getInst().getString(d.k.msg_resend), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.reSendMsg(i2);
                    }
                });
                aVar.b(TbadkCoreApplication.getInst().getString(d.k.delete), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.9
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.deleteMsg(i2);
                    }
                });
                aVar.b(getPageContext()).tC();
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
                if (!aAX() || (msg2 = this.dSF.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.v(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.dSF.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.x(msg3) && (msg = this.dSF.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.dSF.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            ax.wf().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bo(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.aHn() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.aHn()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.aHn()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.aHn()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.aHn()).getThreadId(), ((ShareFromPBMsgData) aVar2.aHn()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.j.gP()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.k.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.dSF.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bo(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.aHn() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.gP()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.k.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.dSF.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bo(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.aHn() != null) {
                        ax.wf().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.aHn()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.gP()) {
                    showToast(TbadkCoreApplication.getInst().getString(d.k.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.dSF.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        ax.wf().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.dSF.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bo(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.aHn() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.aHn()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.aHn()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.dSF.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.dSF.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.cYn == null || this.cYn.getRecorderManager() == null) {
            return null;
        }
        return this.cYn.getRecorderManager();
    }

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0045a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ab.aD(getApplicationContext())) {
                aj.b(getPageContext());
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = com.baidu.tbadk.core.util.ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
