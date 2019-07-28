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
import com.baidu.e.a.a;
import com.baidu.sapi2.utils.SapiGIDEvent;
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
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
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
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, BdListView.e, BdListView.h, a.InterfaceC0041a, k.c, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private boolean aeK;
    private boolean dwr;
    protected VoiceManager ftO;
    protected boolean gzS;
    private View gzV;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    protected Handler handler = new Handler();
    protected AbsMsglistView gzN = null;
    protected MsglistModel gzO = null;
    protected LocalPicModel gzP = null;
    protected com.baidu.adp.base.d gzQ = null;
    protected i gzR = null;
    protected a.InterfaceC0256a<ChatMessage> gzT = null;
    private long gzU = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean gzW = true;
    private CustomMessageListener gzX = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d gzY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                if (TalkableActivity.this.gzN != null) {
                    TalkableActivity.this.gzN.displayNoNetwork();
                }
            } else if (TalkableActivity.this.gzN != null) {
                TalkableActivity.this.gzN.hideNoNetwork();
            }
            switch (TalkableActivity.this.gzO.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.gzU > -1) {
                        TalkableActivity.this.gzU = -1L;
                    }
                    TalkableActivity.this.gzN.closeProgress();
                    TalkableActivity.this.gzN.refreshGo2New(TalkableActivity.this.gzO.getData());
                    return;
                case 2:
                    TalkableActivity.this.gzN.refreshPrepage(TalkableActivity.this.gzO.getData());
                    return;
                case 3:
                    TalkableActivity.this.gzN.refreshCheckNew(TalkableActivity.this.gzO.getData());
                    return;
                case 4:
                    TalkableActivity.this.gzN.refreshGo2New(TalkableActivity.this.gzO.getData());
                    return;
                case 5:
                    TalkableActivity.this.gzN.refreshNormal(TalkableActivity.this.gzO.getData());
                    return;
                case 6:
                    TalkableActivity.this.gzN.refreshNormal(TalkableActivity.this.gzO.getData());
                    return;
                case 7:
                    TalkableActivity.this.gzN.refreshNormal(TalkableActivity.this.gzO.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.gzN.setDraft(str);
                        TalkableActivity.this.gzO.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.gzW = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.gzN.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.gzW = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.gzN.refreshGo2New(TalkableActivity.this.gzO.getData());
                    return;
                case 13:
                    TalkableActivity.this.gzN.refreshNormal(TalkableActivity.this.gzO.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.gzN.refreshNormal(TalkableActivity.this.gzO.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAz() {
        this.gzQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.gzO != null) {
                        TalkableActivity.this.gzO.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
                        return;
                    }
                    return;
                }
                TalkableActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.pic_parser_error));
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
            this.gzU = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.gzU = System.currentTimeMillis();
        }
        this.gzT = new a.InterfaceC0256a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0256a
            /* renamed from: a */
            public void d(int i, ChatMessage chatMessage) {
                TalkableActivity.this.gzN.updateAdapter(i, chatMessage);
            }
        };
        bAA();
        bAC();
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
                    if (this.gzP != null) {
                        this.gzP.cancelLoadData();
                        this.gzP = null;
                    }
                    String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !v.aa(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            aa.a(new z<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.z
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap a = ag.a(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), as.ajo().aju());
                                        if (a != null && m.a((String) null, TbConfig.IMAGE_RESIZED_FILE, a, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(a, 100)) != null) {
                                            if (m.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new com.baidu.tbadk.util.k<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                                @Override // com.baidu.tbadk.util.k
                                public void onReturnDataInUI(Object obj) {
                                    TalkableActivity.this.gzP = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.gzP.setLoadDataCallBack(TalkableActivity.this.gzQ);
                                    TalkableActivity.this.gzP.getData();
                                    TalkableActivity.this.gzN.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.gzP = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.gzP.setLoadDataCallBack(this.gzQ);
                        this.gzP.getData();
                        this.gzN.hideMore();
                        return;
                    }
                    this.gzP = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.gzP.setLoadDataCallBack(this.gzQ);
                    this.gzP.getData();
                    this.gzN.hideMore();
                    return;
                }
                int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                String string = TbadkCoreApplication.getInst().getString(R.string.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(R.string.cancel);
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            h(maxChatImageWidthInPx, string, string2);
                        } else {
                            a(intent, maxChatImageWidthInPx, string, string2);
                        }
                    }
                } else if (i == 12001) {
                    h(maxChatImageWidthInPx, string, string2);
                }
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                takePhoto();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                bAE();
            }
        }
    }

    private void takePhoto() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.mPermissionJudgement.ajQ();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.ad(pageActivity)) {
            al.c(getPageContext());
        }
    }

    private void a(Intent intent, int i, String str, String str2) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null && this.writeImagesInfo != null) {
            this.writeImagesInfo.mIsFromIm = true;
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12009, this.writeImagesInfo, 0)));
                this.writeImagesInfo.clear();
            }
        }
    }

    private void h(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteImageActivityConfig(getPageContext().getContext(), SapiGIDEvent.TIME_FREQ, 12010, null, null, null, null, i, str, str2, "")));
    }

    public void b(View view, int i, int i2, long j) {
        this.gzV = view;
        ChatMessage msg = this.gzO.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.gzS = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.gzN.showDiaItemContentOperate(i2, H(i, this.gzS));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] H(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.copy));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
            case 4:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.save));
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
            case 5:
                arrayList.add(TbadkCoreApplication.getInst().isHeadsetModeOn() ? TbadkCoreApplication.getInst().getString(R.string.group_close_receiver) : TbadkCoreApplication.getInst().getString(R.string.group_open_receiver));
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
            case 7:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
            case 8:
            case 9:
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
            case 10:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
            case 11:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
            case 15:
                if (!z) {
                    arrayList.add(TbadkCoreApplication.getInst().getString(R.string.msg_at));
                }
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
            case 17:
                arrayList.add(TbadkCoreApplication.getInst().getString(R.string.delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.gzU = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.gzU = System.currentTimeMillis();
        }
        bAA();
        bAC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ftO != null) {
            this.ftO.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dwr = false;
        if (this.ftO != null) {
            this.ftO.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gzX);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ftO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.gzN == null || this.gzN.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.gzN.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void bAA() {
        if (this.ftO == null) {
            this.ftO = new VoiceManager();
            this.ftO.onCreate(getPageContext());
        }
        this.ftO.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.gzN == null) {
            return null;
        }
        return this.gzN.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azs() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azt() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azu() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azv() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azw() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azx() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azy() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        bb.ajC().c(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void n(Context context, String str, String str2) {
    }

    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.gzN != null && this.gzN.isMoreVisible()) {
                this.gzN.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gzW && this.gzN != null) {
            bAB();
        }
        super.finish();
    }

    protected boolean bAB() {
        return this.gzO.saveDraft(this.gzN.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dwr = true;
        if (this.ftO != null) {
            this.ftO.onResume(getPageContext());
            this.ftO.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.gzX);
    }

    private void bmj() {
        if (this.ftO != null) {
            this.ftO.stopPlay();
        }
    }

    public boolean bAC() {
        if (m.gB()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAD() {
        final String beforeSendMsgText = this.gzN.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.gzN.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.gzO.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void bAE() {
        if (bAC()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gzN != null) {
            bmj();
            if (view == this.gzN.getBtnBack()) {
                this.gzN.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.gzN.getLayNewMsg()) {
                this.gzN.refreshGo2New(this.gzO.getData());
                this.gzN.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.ftO != null) {
            this.ftO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aeK && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.gzN.getBtnSendVoice()) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.ajQ();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgement.e(pageActivity, "android.permission.RECORD_AUDIO");
            if (this.mPermissionJudgement.ad(pageActivity)) {
                return false;
            }
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.ftO == null || !recorderManager.qn()) {
                    return true;
                }
                recorderManager.a(this.gzN, -1);
                this.gzN.closeRecordCancel();
                this.gzN.refreshSendVoiceText(true);
                this.gzN.startRecordVoice();
                this.aeK = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.qm();
                    }
                    this.gzN.closeRecordCancel();
                } else if (!this.dwr) {
                    if (recorderManager != null) {
                        recorderManager.qm();
                    }
                    this.gzN.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.gzN.stopRecordVoice();
                }
                this.gzN.refreshSendVoiceText(false);
                this.aeK = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.gzN.showRecordCancel();
                    this.gzN.stopRecordVoice();
                    this.aeK = false;
                } else {
                    this.gzN.closeRecordCancel();
                    this.gzN.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void d(p pVar) {
        this.gzO.sendBigEmotionMessage(pVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        bAF();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gzN.closeNewMsg();
    }

    private void bAF() {
        this.gzO.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gzO != null) {
            this.gzO.onDestroy();
        }
        super.onDestroy();
        if (this.ftO != null) {
            this.ftO.onDestory(getPageContext());
        }
        if (this.gzR != null) {
            this.gzR = null;
        }
        if (this.gzP != null) {
            this.gzP.cancelLoadData();
            this.gzP = null;
        }
        if (this.gzN != null) {
            this.gzN.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.k.c
    public void a(k kVar, int i, View view) {
        if (this.gzN.getMsgItemOperationDialog() != null && kVar.getRootView() == this.gzN.getMsgItemOperationDialog().getContentView()) {
            int intValue = ((Integer) kVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    an(intValue, charSequence);
                    this.gzN.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void an(int i, String str) {
        ChatMessage msg = this.gzO.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(R.string.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.aS(msg.getContent());
                showToast((int) R.string.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.gzN.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.delete))) {
            if ((this.gzV instanceof ChatVoiceView) && ((ChatVoiceView) this.gzV).isPlaying() && this.ftO != null) {
                this.ftO.stopPlay();
            }
            this.gzO.markDeleteMsg(i);
            showToast((int) R.string.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.save))) {
            String ao = com.baidu.tieba.im.util.e.ao(msg.getContent(), true);
            if (ao != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                }
                this.mPermissionJudgement.ajQ();
                this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.mPermissionJudgement.ad(pageActivity)) {
                    this.gzR = new i(ao, this);
                    this.gzR.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(R.string.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.ftO.setSpeakerphoneOn(true);
                this.gzN.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.ftO.setSpeakerphoneOn(false);
            this.gzN.showReceiver();
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
                aVar.mO(TbadkCoreApplication.getInst().getString(R.string.sure_to_resend_this_message));
                aVar.a(TbadkCoreApplication.getInst().getString(R.string.msg_resend), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.reSendMsg(i2);
                    }
                });
                aVar.b(TbadkCoreApplication.getInst().getString(R.string.delete), new a.b() { // from class: com.baidu.tieba.im.chat.TalkableActivity.9
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        TalkableActivity.this.deleteMsg(i2);
                    }
                });
                aVar.b(getPageContext()).agI();
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
                if (!bAC() || (msg2 = this.gzO.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.v(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.gzO.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.x(msg3) && (msg = this.gzO.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content2).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getContext(), com.baidu.adp.lib.g.b.f(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.g.b.c(optJSONObject.optString("groupId"), 0L), 2)));
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
                ChatMessage msg4 = this.gzO.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            bb.ajC().c(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.dt(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.bGL() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.bGL()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long c = com.baidu.adp.lib.g.b.c(theNewThemeId, 0L);
                            if (c > 0) {
                                sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(getPageContext().getContext(), c, ((ShareFromPBMsgData) aVar2.bGL()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.bGL()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.bGL()).getThreadId(), ((ShareFromPBMsgData) aVar2.bGL()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.j.kc()) {
                    showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.gzO.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.dt(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.bGL() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001255, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.kc()) {
                    showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.gzO.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.dt(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.bGL() != null) {
                        bb.ajC().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.bGL()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.kc()) {
                    showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.gzO.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        bb.ajC().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.gzO.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.dt(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.bGL() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.bGL()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.bGL()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.gzO.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.gzO.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.ftO == null || this.ftO.getRecorderManager() == null) {
            return null;
        }
        return this.ftO.getRecorderManager();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cy(getApplicationContext())) {
                al.c(getPageContext());
            } else {
                showToast((int) R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast((int) R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
