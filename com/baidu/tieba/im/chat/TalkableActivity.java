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
import com.baidu.f.a.a;
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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, BdListView.e, BdListView.h, a.InterfaceC0073a, b.InterfaceC0124b, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private boolean bPi;
    private com.baidu.tbadk.core.util.b.a buX;
    protected VoiceManager dAm;
    protected boolean eAN;
    private View eAQ;
    private boolean eAU;
    protected Handler handler = new Handler();
    protected AbsMsglistView eAI = null;
    protected MsglistModel eAJ = null;
    protected LocalPicModel eAK = null;
    protected com.baidu.adp.base.d eAL = null;
    protected i eAM = null;
    protected a.InterfaceC0138a<ChatMessage> eAO = null;
    private long eAP = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eAR = true;
    private CustomMessageListener eAS = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d eAT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (!com.baidu.adp.lib.util.j.kX()) {
                if (TalkableActivity.this.eAI != null) {
                    TalkableActivity.this.eAI.displayNoNetwork();
                }
            } else if (TalkableActivity.this.eAI != null) {
                TalkableActivity.this.eAI.hideNoNetwork();
            }
            switch (TalkableActivity.this.eAJ.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.eAP > -1) {
                        TalkableActivity.this.eAP = -1L;
                    }
                    TalkableActivity.this.eAI.closeProgress();
                    TalkableActivity.this.eAI.refreshGo2New(TalkableActivity.this.eAJ.getData());
                    return;
                case 2:
                    TalkableActivity.this.eAI.refreshPrepage(TalkableActivity.this.eAJ.getData());
                    return;
                case 3:
                    TalkableActivity.this.eAI.refreshCheckNew(TalkableActivity.this.eAJ.getData());
                    return;
                case 4:
                    TalkableActivity.this.eAI.refreshGo2New(TalkableActivity.this.eAJ.getData());
                    return;
                case 5:
                    TalkableActivity.this.eAI.refreshNormal(TalkableActivity.this.eAJ.getData());
                    return;
                case 6:
                    TalkableActivity.this.eAI.refreshNormal(TalkableActivity.this.eAJ.getData());
                    return;
                case 7:
                    TalkableActivity.this.eAI.refreshNormal(TalkableActivity.this.eAJ.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.eAI.setDraft(str);
                        TalkableActivity.this.eAJ.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.eAR = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.eAI.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.eAR = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.eAI.refreshGo2New(TalkableActivity.this.eAJ.getData());
                    return;
                case 13:
                    TalkableActivity.this.eAI.refreshNormal(TalkableActivity.this.eAJ.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.eAI.refreshNormal(TalkableActivity.this.eAJ.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void aNa() {
        this.eAL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.eAJ != null) {
                        TalkableActivity.this.eAJ.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                        return;
                    }
                    return;
                }
                TalkableActivity.this.showToast(TbadkCoreApplication.getInst().getString(e.j.pic_parser_error));
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
            this.eAP = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.eAP = System.currentTimeMillis();
        }
        this.eAO = new a.InterfaceC0138a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0138a
            /* renamed from: a */
            public void b(int i, ChatMessage chatMessage) {
                TalkableActivity.this.eAI.updateAdapter(i, chatMessage);
            }
        };
        aNb();
        aNd();
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
                    if (this.eAK != null) {
                        this.eAK.cancelLoadData();
                        this.eAK = null;
                    }
                    String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !v.J(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            x.a(new w<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.w
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap a = ad.a(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), aq.CG().CM());
                                        if (a != null && l.a((String) null, TbConfig.IMAGE_RESIZED_FILE, a, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(a, 100)) != null) {
                                            if (l.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new com.baidu.tbadk.util.h<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                                @Override // com.baidu.tbadk.util.h
                                public void onReturnDataInUI(Object obj) {
                                    TalkableActivity.this.eAK = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.eAK.setLoadDataCallBack(TalkableActivity.this.eAL);
                                    TalkableActivity.this.eAK.getData();
                                    TalkableActivity.this.eAI.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.eAK = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.eAK.setLoadDataCallBack(this.eAL);
                        this.eAK.getData();
                        this.eAI.hideMore();
                        return;
                    }
                    this.eAK = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.eAK.setLoadDataCallBack(this.eAL);
                    this.eAK.getData();
                    this.eAI.hideMore();
                    return;
                }
                int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                String string = TbadkCoreApplication.getInst().getString(e.j.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(e.j.cancel);
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            e(maxChatImageWidthInPx, string, string2);
                        } else {
                            a(intent, maxChatImageWidthInPx, string, string2);
                        }
                    }
                } else if (i == 12001) {
                    e(maxChatImageWidthInPx, string, string2);
                }
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                takePhoto();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                aNf();
            }
        }
    }

    private void takePhoto() {
        if (this.buX == null) {
            this.buX = new com.baidu.tbadk.core.util.b.a();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.buX.Di();
        this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.buX.z(pageActivity)) {
            ak.b(getPageContext());
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

    private void e(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), 12001, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, null, null, null, i, str, str2, "")));
    }

    public void b(View view, int i, int i2, long j) {
        this.eAQ = view;
        ChatMessage msg = this.eAJ.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.eAN = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.eAI.showDiaItemContentOperate(i2, u(i, this.eAN));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] u(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(e.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(e.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.save));
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
            case 5:
                arrayList.add(TbadkCoreApplication.getInst().isHeadsetModeOn() ? TbadkCoreApplication.getInst().getString(e.j.group_close_receiver) : TbadkCoreApplication.getInst().getString(e.j.group_open_receiver));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(e.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(e.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(e.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(e.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(e.j.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.getInst().getString(e.j.delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.eAP = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.eAP = System.currentTimeMillis();
        }
        aNb();
        aNd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dAm != null) {
            this.dAm.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bPi = false;
        if (this.dAm != null) {
            this.dAm.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eAS);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dAm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.eAI == null || this.eAI.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.eAI.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void aNb() {
        if (this.dAm == null) {
            this.dAm = new VoiceManager();
            this.dAm.onCreate(getPageContext());
        }
        this.dAm.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.eAI == null) {
            return null;
        }
        return this.eAI.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int Rr() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> Rs() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> Rt() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> Ru() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> Rv() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Rw() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Rx() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        ay.CU().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void i(Context context, String str, String str2) {
    }

    public void aq(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.eAI != null && this.eAI.isMoreVisible()) {
                this.eAI.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.eAR && this.eAI != null) {
            aNc();
        }
        super.finish();
    }

    protected boolean aNc() {
        return this.eAJ.saveDraft(this.eAI.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bPi = true;
        if (this.dAm != null) {
            this.dAm.onResume(getPageContext());
            this.dAm.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.eAS);
    }

    private void azQ() {
        if (this.dAm != null) {
            this.dAm.stopPlay();
        }
    }

    public boolean aNd() {
        if (l.hB()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(e.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aNe() {
        final String beforeSendMsgText = this.eAI.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.eAI.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.eAJ.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void aNf() {
        if (aNd()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.eAI != null) {
            azQ();
            if (view == this.eAI.getBtnBack()) {
                this.eAI.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.eAI.getLayNewMsg()) {
                this.eAI.refreshGo2New(this.eAJ.getData());
                this.eAI.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.dAm != null) {
            this.dAm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eAU && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.eAI.getBtnSendVoice()) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.buX == null) {
                this.buX = new com.baidu.tbadk.core.util.b.a();
            }
            this.buX.Di();
            this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.buX.c(pageActivity, "android.permission.RECORD_AUDIO");
            if (this.buX.z(pageActivity)) {
                return false;
            }
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.dAm == null || !recorderManager.pT()) {
                    return true;
                }
                recorderManager.a(this.eAI, -1);
                this.eAI.closeRecordCancel();
                this.eAI.refreshSendVoiceText(true);
                this.eAI.startRecordVoice();
                this.eAU = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.pS();
                    }
                    this.eAI.closeRecordCancel();
                } else if (!this.bPi) {
                    if (recorderManager != null) {
                        recorderManager.pS();
                    }
                    this.eAI.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.eAI.stopRecordVoice();
                }
                this.eAI.refreshSendVoiceText(false);
                this.eAU = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.eAI.showRecordCancel();
                    this.eAI.stopRecordVoice();
                    this.eAU = false;
                } else {
                    this.eAI.closeRecordCancel();
                    this.eAI.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void c(o oVar) {
        this.eAJ.sendBigEmotionMessage(oVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        aNg();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.eAI.closeNewMsg();
    }

    private void aNg() {
        this.eAJ.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eAJ != null) {
            this.eAJ.onDestroy();
        }
        super.onDestroy();
        if (this.dAm != null) {
            this.dAm.onDestory(getPageContext());
        }
        if (this.eAM != null) {
            this.eAM = null;
        }
        if (this.eAK != null) {
            this.eAK.cancelLoadData();
            this.eAK = null;
        }
        if (this.eAI != null) {
            this.eAI.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
        if (bVar == this.eAI.getMsgItemOperationDialog()) {
            int intValue = ((Integer) bVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    T(intValue, charSequence);
                    this.eAI.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void T(int i, String str) {
        ChatMessage msg = this.eAJ.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(e.j.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.bg(msg.getContent());
                showToast(e.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(e.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.eAI.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(e.j.delete))) {
            if ((this.eAQ instanceof ChatVoiceView) && ((ChatVoiceView) this.eAQ).isPlaying() && this.dAm != null) {
                this.dAm.stopPlay();
            }
            this.eAJ.markDeleteMsg(i);
            showToast(e.j.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(e.j.save))) {
            String N = com.baidu.tieba.im.util.e.N(msg.getContent(), true);
            if (N != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.buX == null) {
                    this.buX = new com.baidu.tbadk.core.util.b.a();
                }
                this.buX.Di();
                this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.buX.z(pageActivity)) {
                    this.eAM = new i(N, this);
                    this.eAM.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(e.j.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(e.j.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.dAm.setSpeakerphoneOn(true);
                this.eAI.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.dAm.setSpeakerphoneOn(false);
            this.eAI.showReceiver();
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
                aVar.ej(TbadkCoreApplication.getInst().getString(e.j.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.getInst().getString(e.j.msg_resend), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.reSendMsg(i2);
                    }
                });
                aVar.b(TbadkCoreApplication.getInst().getString(e.j.delete), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.9
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.deleteMsg(i2);
                    }
                });
                aVar.b(getPageContext()).Au();
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
                if (!aNd() || (msg2 = this.eAJ.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.v(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.eAJ.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.x(msg3) && (msg = this.eAJ.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.eAJ.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            ay.CU().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bR(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.aTo() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.aTo()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long d = com.baidu.adp.lib.g.b.d(theNewThemeId, 0L);
                            if (d > 0) {
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), d, ((ShareFromPBMsgData) aVar2.aTo()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.aTo()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.aTo()).getThreadId(), ((ShareFromPBMsgData) aVar2.aTo()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.j.kX()) {
                    showToast(TbadkCoreApplication.getInst().getString(e.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.eAJ.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bR(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.aTo() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.kX()) {
                    showToast(TbadkCoreApplication.getInst().getString(e.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.eAJ.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bR(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.aTo() != null) {
                        ay.CU().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.aTo()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.kX()) {
                    showToast(TbadkCoreApplication.getInst().getString(e.j.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.eAJ.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        ay.CU().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.eAJ.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bR(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.aTo() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.aTo()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.aTo()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.eAJ.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.eAJ.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.dAm == null || this.dAm.getRecorderManager() == null) {
            return null;
        }
        return this.dAm.getRecorderManager();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aX(getApplicationContext())) {
                ak.b(getPageContext());
            } else {
                showToast(e.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(e.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
