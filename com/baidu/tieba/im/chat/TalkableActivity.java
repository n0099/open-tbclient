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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.m.a.a;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.al;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, BdListView.e, BdListView.h, a.InterfaceC0250a, k.c, VoiceManager.c, com.baidu.tbadk.widget.richText.i {
    private boolean bXB;
    protected VoiceManager iHo;
    private boolean isForeground;
    protected boolean jWJ;
    private View jWM;
    private PermissionJudgePolicy mPermissionJudgement;
    protected Handler handler = new Handler();
    protected AbsMsglistView jWE = null;
    protected MsglistModel jWF = null;
    protected LocalPicModel jWG = null;
    protected com.baidu.adp.base.d jWH = null;
    protected i jWI = null;
    protected a.InterfaceC0594a<ChatMessage> jWK = null;
    private long jWL = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean jWN = true;
    private CustomMessageListener jWO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d jWP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (TalkableActivity.this.jWE != null) {
                    TalkableActivity.this.jWE.displayNoNetwork();
                }
            } else if (TalkableActivity.this.jWE != null) {
                TalkableActivity.this.jWE.hideNoNetwork();
            }
            switch (TalkableActivity.this.jWF.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.jWL > -1) {
                        TalkableActivity.this.jWL = -1L;
                    }
                    TalkableActivity.this.jWE.closeProgress();
                    TalkableActivity.this.jWE.refreshGo2New(TalkableActivity.this.jWF.getData());
                    return;
                case 2:
                    TalkableActivity.this.jWE.refreshPrepage(TalkableActivity.this.jWF.getData());
                    return;
                case 3:
                    TalkableActivity.this.jWE.refreshCheckNew(TalkableActivity.this.jWF.getData());
                    return;
                case 4:
                    TalkableActivity.this.jWE.refreshGo2New(TalkableActivity.this.jWF.getData());
                    return;
                case 5:
                    TalkableActivity.this.jWE.refreshNormal(TalkableActivity.this.jWF.getData());
                    return;
                case 6:
                    TalkableActivity.this.jWE.refreshNormal(TalkableActivity.this.jWF.getData());
                    return;
                case 7:
                    TalkableActivity.this.jWE.refreshNormal(TalkableActivity.this.jWF.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.jWE.setDraft(str);
                        TalkableActivity.this.jWF.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.jWN = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.jWE.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.jWN = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.jWE.refreshGo2New(TalkableActivity.this.jWF.getData());
                    return;
                case 13:
                    TalkableActivity.this.jWE.refreshNormal(TalkableActivity.this.jWF.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.jWE.refreshNormal(TalkableActivity.this.jWF.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void bTX() {
        this.jWH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.jWF != null) {
                        TalkableActivity.this.jWF.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
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
            this.jWL = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.jWL = System.currentTimeMillis();
        }
        this.jWK = new a.InterfaceC0594a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0594a
            /* renamed from: a */
            public void onImageProgessInUI(int i, ChatMessage chatMessage) {
                TalkableActivity.this.jWE.updateAdapter(i, chatMessage);
            }
        };
        cOT();
        cOV();
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
                    if (this.jWG != null) {
                        this.jWG.cancelLoadData();
                        this.jWG = null;
                    }
                    String stringExtra2 = intent.getStringExtra("album_result");
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !y.isEmpty(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            ae.a(new ad<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.ad
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap ImageResult = al.ImageResult(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), au.bro().getPostImageSize());
                                        if (ImageResult != null && n.a(null, TbConfig.IMAGE_RESIZED_FILE, ImageResult, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(ImageResult, 100)) != null) {
                                            if (n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new m<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                                @Override // com.baidu.tbadk.util.m
                                public void onReturnDataInUI(Object obj) {
                                    TalkableActivity.this.jWG = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.jWG.setLoadDataCallBack(TalkableActivity.this.jWH);
                                    TalkableActivity.this.jWG.getData();
                                    TalkableActivity.this.jWE.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.jWG = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.jWG.setLoadDataCallBack(this.jWH);
                        this.jWG.getData();
                        this.jWE.hideMore();
                        return;
                    }
                    this.jWG = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.jWG.setLoadDataCallBack(this.jWH);
                    this.jWG.getData();
                    this.jWE.hideMore();
                    return;
                }
                int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                String string = TbadkCoreApplication.getInst().getString(R.string.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(R.string.cancel);
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            j(maxChatImageWidthInPx, string, string2);
                        } else {
                            a(intent, maxChatImageWidthInPx, string, string2);
                        }
                    }
                } else if (i == 12001) {
                    j(maxChatImageWidthInPx, string, string2);
                }
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                cyR();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                cOX();
            }
        }
    }

    private void cyR() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            ao.g(getPageContext());
        }
    }

    private void a(Intent intent, int i, String str, String str2) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null && this.writeImagesInfo != null) {
            this.writeImagesInfo.mIsFromIm = true;
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, this.writeImagesInfo, 0)));
                this.writeImagesInfo.clear();
            }
        }
    }

    private void j(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteImageActivityConfig(getPageContext().getContext(), RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, null, null, null, i, str, str2, "")));
    }

    public void onItemViewLongClick(View view, int i, int i2, long j) {
        this.jWM = view;
        ChatMessage msg = this.jWF.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.jWJ = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.jWE.showDiaItemContentOperate(i2, Y(i, this.jWJ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] Y(int i, boolean z) {
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
            this.jWL = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.jWL = System.currentTimeMillis();
        }
        cOT();
        cOV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isForeground = false;
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jWO);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iHo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        if (this.jWE == null || this.jWE.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.jWE.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void cOT() {
        if (this.iHo == null) {
            this.iHo = new VoiceManager();
            this.iHo.onCreate(getPageContext());
        }
        this.iHo.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.jWE == null) {
            return null;
        }
        return this.jWE.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bGt() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bGu() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bGv() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bGw() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bGx() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bGy() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bGz() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        be.brr().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void u(Context context, String str, String str2) {
    }

    public void aB(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.jWE != null && this.jWE.isMoreVisible()) {
                this.jWE.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.jWN && this.jWE != null) {
            cOU();
        }
        super.finish();
    }

    protected boolean cOU() {
        return this.jWF.saveDraft(this.jWE.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isForeground = true;
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
            this.iHo.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.jWO);
    }

    private void cyK() {
        if (this.iHo != null) {
            this.iHo.stopPlay();
        }
    }

    public boolean cOV() {
        if (n.checkSD()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cOW() {
        final String beforeSendMsgText = this.jWE.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.jWE.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.jWF.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void cOX() {
        if (cOV()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.jWE != null) {
            cyK();
            if (view == this.jWE.getBtnBack()) {
                this.jWE.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.jWE.getLayNewMsg()) {
                this.jWE.refreshGo2New(this.jWF.getData());
                this.jWE.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.iHo != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bXB && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.jWE.getBtnSendVoice()) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgement.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return false;
            }
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.iHo == null || !recorderManager.su()) {
                    return true;
                }
                recorderManager.a(this.jWE, -1);
                this.jWE.closeRecordCancel();
                this.jWE.refreshSendVoiceText(true);
                this.jWE.startRecordVoice();
                this.bXB = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.st();
                    }
                    this.jWE.closeRecordCancel();
                } else if (!this.isForeground) {
                    if (recorderManager != null) {
                        recorderManager.st();
                    }
                    this.jWE.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.jWE.stopRecordVoice();
                }
                this.jWE.refreshSendVoiceText(false);
                this.bXB = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.jWE.showRecordCancel();
                    this.jWE.stopRecordVoice();
                    this.bXB = false;
                } else {
                    this.jWE.closeRecordCancel();
                    this.jWE.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void d(u uVar) {
        this.jWF.sendBigEmotionMessage(uVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        cOY();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.jWE.closeNewMsg();
    }

    private void cOY() {
        this.jWF.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jWF != null) {
            this.jWF.onDestroy();
        }
        super.onDestroy();
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
        if (this.jWI != null) {
            this.jWI = null;
        }
        if (this.jWG != null) {
            this.jWG.cancelLoadData();
            this.jWG = null;
        }
        if (this.jWE != null) {
            this.jWE.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.k.c
    public void a(k kVar, int i, View view) {
        if (this.jWE.getMsgItemOperationDialog() != null && kVar.getRootView() == this.jWE.getMsgItemOperationDialog().getContentView()) {
            int intValue = ((Integer) kVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    bx(intValue, charSequence);
                    this.jWE.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void bx(int i, String str) {
        ChatMessage msg = this.jWF.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(R.string.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.copyToClipboard(msg.getContent());
                showToast(R.string.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.jWE.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.delete))) {
            if ((this.jWM instanceof ChatVoiceView) && ((ChatVoiceView) this.jWM).isPlaying() && this.iHo != null) {
                this.iHo.stopPlay();
            }
            this.jWF.markDeleteMsg(i);
            showToast(R.string.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.save))) {
            String aR = com.baidu.tieba.im.util.e.aR(msg.getContent(), true);
            if (aR != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.mPermissionJudgement.clearRequestPermissionList();
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                    this.jWI = new i(aR, this);
                    this.jWI.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(R.string.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.iHo.setSpeakerphoneOn(true);
                this.jWE.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.iHo.setSpeakerphoneOn(false);
            this.jWE.showReceiver();
        }
    }

    public void onItemViewClick(View view, int i, final int i2, long j) {
        String content;
        ChatMessage msg;
        String content2;
        ChatMessage msg2;
        switch (i) {
            case 1:
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Bo(TbadkCoreApplication.getInst().getString(R.string.sure_to_resend_this_message));
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
                aVar.b(getPageContext()).bpc();
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
                if (!cOV() || (msg2 = this.jWF.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.q(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.jWF.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.s(msg3) && (msg = this.jWF.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content2).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                        if (optJSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getContext(), com.baidu.adp.lib.f.b.toInt(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.f.b.toLong(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID), 0L), 2)));
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
                ChatMessage msg4 = this.jWF.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            be.brr().b(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.fx(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.cVz() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.cVz()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long j2 = com.baidu.adp.lib.f.b.toLong(theNewThemeId, 0L);
                            if (j2 > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), j2, ((ShareFromPBMsgData) aVar2.cVz()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.cVz()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.cVz()).getThreadId(), ((ShareFromPBMsgData) aVar2.cVz()).getPostId(), null)));
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 11:
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg5 = this.jWF.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.fx(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.cVz() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_SHARE_ITEM_CLICK, aVar3));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg6 = this.jWF.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.fx(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.cVz() != null) {
                        be.brr().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.cVz()).getShareSourceUrl()}, true);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    showToast(TbadkCoreApplication.getInst().getString(R.string.rand_chat_waiting_net_error));
                    return;
                }
                ChatMessage msg7 = this.jWF.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        be.brr().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.jWF.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.fx(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.cVz() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.cVz()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.cVz()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.jWF.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.jWF.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.iHo == null || this.iHo.getRecorderManager() == null) {
            return null;
        }
        return this.iHo.getRecorderManager();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ae.checkCamera(getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = com.baidu.tbadk.core.util.ae.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
