package com.baidu.tieba.im.chat;

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
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.m;
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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, b, BdListView.e, BdListView.h, a.InterfaceC0022a, b.InterfaceC0047b, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    protected VoiceManager cGZ;
    protected boolean dDH;
    private boolean dDI;
    private View dDL;
    private boolean dDP;
    protected Handler handler = new Handler();
    protected AbsMsglistView dDC = null;
    protected MsglistModel dDD = null;
    protected LocalPicModel dDE = null;
    protected com.baidu.adp.base.d dDF = null;
    protected i dDG = null;
    protected a.InterfaceC0059a<ChatMessage> dDJ = null;
    private long dDK = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean dDM = true;
    private CustomMessageListener dDN = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d dDO = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                if (TalkableActivity.this.dDC != null) {
                    TalkableActivity.this.dDC.displayNoNetwork();
                }
            } else if (TalkableActivity.this.dDC != null) {
                TalkableActivity.this.dDC.hideNoNetwork();
            }
            switch (TalkableActivity.this.dDD.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.dDK > -1) {
                        TalkableActivity.this.dDK = -1L;
                    }
                    TalkableActivity.this.dDC.closeProgress();
                    TalkableActivity.this.dDC.refreshGo2New(TalkableActivity.this.dDD.getData());
                    return;
                case 2:
                    TalkableActivity.this.dDC.refreshPrepage(TalkableActivity.this.dDD.getData());
                    return;
                case 3:
                    TalkableActivity.this.dDC.refreshCheckNew(TalkableActivity.this.dDD.getData());
                    return;
                case 4:
                    TalkableActivity.this.dDC.refreshGo2New(TalkableActivity.this.dDD.getData());
                    return;
                case 5:
                    TalkableActivity.this.dDC.refreshNormal(TalkableActivity.this.dDD.getData());
                    return;
                case 6:
                    TalkableActivity.this.dDC.refreshNormal(TalkableActivity.this.dDD.getData());
                    return;
                case 7:
                    TalkableActivity.this.dDC.refreshNormal(TalkableActivity.this.dDD.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.dDC.setDraft(str);
                        TalkableActivity.this.dDD.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.dDM = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.dDC.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext(), TbadkCoreApplication.getCurrentAccountName())));
                    TalkableActivity.this.dDM = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.dDC.refreshGo2New(TalkableActivity.this.dDD.getData());
                    return;
                case 13:
                    TalkableActivity.this.dDC.refreshNormal(TalkableActivity.this.dDD.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.dDC.refreshNormal(TalkableActivity.this.dDD.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void axi() {
        this.dDF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.dDD != null) {
                        TalkableActivity.this.dDD.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
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
            this.dDK = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.dDK = System.currentTimeMillis();
        }
        this.dDJ = new a.InterfaceC0059a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0059a
            /* renamed from: a */
            public void b(int i, ChatMessage chatMessage) {
                TalkableActivity.this.dDC.updateAdapter(i, chatMessage);
            }
        };
        axj();
        axl();
        addGlobalLayoutListener();
        setSkinType(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
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
                    if (this.dDE != null) {
                        this.dDE.cancelLoadData();
                        this.dDE = null;
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
                                        Bitmap a = ab.a(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), an.vv().vB());
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
                                    TalkableActivity.this.dDE = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.dDE.setLoadDataCallBack(TalkableActivity.this.dDF);
                                    TalkableActivity.this.dDE.getData();
                                    TalkableActivity.this.dDC.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.dDE = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.dDE.setLoadDataCallBack(this.dDF);
                        this.dDE.getData();
                        this.dDC.hideMore();
                        return;
                    }
                    this.dDE = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.dDE.setLoadDataCallBack(this.dDF);
                    this.dDE.getData();
                    this.dDC.hideMore();
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
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                alx();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                axn();
            }
        }
    }

    private void alx() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            ai.c(getPageContext());
        }
    }

    private void a(Intent intent, int i, String str, String str2) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null && this.writeImagesInfo != null) {
            this.writeImagesInfo.mIsFromIm = true;
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12009, this.writeImagesInfo, 0)));
                this.writeImagesInfo.clear();
            }
        }
    }

    private void d(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteImageActivityConfig(getPageContext().getContext(), 12001, 12010, null, null, null, null, i, str, str2, "")));
    }

    public void b(View view, int i, int i2, long j) {
        this.dDL = view;
        ChatMessage msg = this.dDD.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.dDH = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.dDC.showDiaItemContentOperate(i2, r(i, this.dDH));
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
            this.dDK = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.dDK = System.currentTimeMillis();
        }
        axj();
        axl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cGZ != null) {
            this.cGZ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dDI = false;
        if (this.cGZ != null) {
            this.cGZ.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dDN);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cGZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.dDC == null || this.dDC.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.dDC.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void axj() {
        if (this.cGZ == null) {
            this.cGZ = new VoiceManager();
            this.cGZ.onCreate(getPageContext());
        }
        this.cGZ.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.dDC == null) {
            return null;
        }
        return this.dDC.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int JV() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> JW() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> JX() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> JY() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> JZ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> Ka() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> Kb() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void V(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void W(Context context, String str) {
        av.vL().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void Z(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.dDC != null && this.dDC.isMoreVisible()) {
                this.dDC.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.dDM && this.dDC != null) {
            axk();
        }
        super.finish();
    }

    protected boolean axk() {
        return this.dDD.saveDraft(this.dDC.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cGZ != null) {
            this.cGZ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dDI = true;
        if (this.cGZ != null) {
            this.cGZ.onResume(getPageContext());
            this.cGZ.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.dDN);
    }

    private void als() {
        if (this.cGZ != null) {
            this.cGZ.stopPlay();
        }
    }

    public boolean axl() {
        if (k.dG()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(d.j.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void axm() {
        final String beforeSendMsgText = this.dDC.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.dDC.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.dDD.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void axn() {
        if (axl()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setImResource(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.dDC != null) {
            als();
            if (view == this.dDC.getBtnBack()) {
                this.dDC.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.dDC.getLayNewMsg()) {
                this.dDC.refreshGo2New(this.dDD.getData());
                this.dDC.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.cGZ != null) {
            this.cGZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dDP && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.dDC.getBtnSendVoice()) {
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.cGZ == null || !recorderManager.lH()) {
                    return true;
                }
                recorderManager.a(this.dDC, -1);
                this.dDC.closeRecordCancel();
                this.dDC.refreshSendVoiceText(true);
                this.dDC.startRecordVoice();
                this.dDP = true;
                return true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.lG();
                    }
                    this.dDC.closeRecordCancel();
                } else if (!this.dDI) {
                    if (recorderManager != null) {
                        recorderManager.lG();
                    }
                    this.dDC.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.dDC.stopRecordVoice();
                }
                this.dDC.refreshSendVoiceText(false);
                this.dDP = false;
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.dDC.showRecordCancel();
                    this.dDC.stopRecordVoice();
                    this.dDP = false;
                    return true;
                }
                this.dDC.closeRecordCancel();
                this.dDC.startRecordVoice();
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void c(m mVar) {
        this.dDD.sendBigEmotionMessage(mVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        axo();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dDC.closeNewMsg();
    }

    private void axo() {
        this.dDD.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dDD != null) {
            this.dDD.onDestroy();
        }
        super.onDestroy();
        if (this.cGZ != null) {
            this.cGZ.onDestory(getPageContext());
        }
        if (this.dDG != null) {
            this.dDG = null;
        }
        if (this.dDE != null) {
            this.dDE.cancelLoadData();
            this.dDE = null;
        }
        if (this.dDC != null) {
            this.dDC.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
    public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
        if (bVar == this.dDC.getMsgItemOperationDialog()) {
            int intValue = ((Integer) bVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    H(intValue, charSequence);
                    this.dDC.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void H(int i, String str) {
        ChatMessage msg = this.dDD.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(d.j.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aw(msg.getContent());
                showToast(d.j.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.dDC.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.delete))) {
            if ((this.dDL instanceof ChatVoiceView) && ((ChatVoiceView) this.dDL).isPlaying() && this.cGZ != null) {
                this.cGZ.stopPlay();
            }
            this.dDD.markDeleteMsg(i);
            showToast(d.j.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.save))) {
            String J = com.baidu.tieba.im.util.e.J(msg.getContent(), true);
            if (J != null) {
                this.dDG = new i(J, this);
                this.dDG.execute();
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(d.j.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(d.j.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.cGZ.setSpeakerphoneOn(true);
                this.dDC.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.cGZ.setSpeakerphoneOn(false);
            this.dDC.showReceiver();
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
                aVar.b(getPageContext()).tk();
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
                if (!axl() || (msg2 = this.dDD.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.u(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.dDD.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.w(msg3) && (msg = this.dDD.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.dDD.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            av.vL().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.bm(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.aDt() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.aDt()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.aDt()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.aDt()).getThreadId())) {
                            if (((ShareFromPBMsgData) aVar2.aDt()).getThreadType() == 33) {
                                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getContext(), ((ShareFromPBMsgData) aVar2.aDt()).getThreadId()).pp()));
                                    return;
                                }
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.aDt()).getThreadId(), ((ShareFromPBMsgData) aVar2.aDt()).getPostId(), null)));
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
                ChatMessage msg5 = this.dDD.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.bm(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.aDt() != null) {
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
                ChatMessage msg6 = this.dDD.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.bm(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.aDt() != null) {
                        av.vL().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.aDt()).getShareSourceUrl()}, true);
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
                ChatMessage msg7 = this.dDD.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        av.vL().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.dDD.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.bm(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.aDt() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.aDt()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.aDt()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.dDD.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.dDD.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.cGZ == null || this.cGZ.getRecorderManager() == null) {
            return null;
        }
        return this.cGZ.getRecorderManager();
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ab.aL(getApplicationContext())) {
                ai.c(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = com.baidu.tbadk.core.util.ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
