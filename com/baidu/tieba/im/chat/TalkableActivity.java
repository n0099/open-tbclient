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
import com.baidu.n.a.a;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, BdListView.e, BdListView.h, a.InterfaceC0276a, k.c, VoiceManager.c, com.baidu.tbadk.widget.richText.h {
    private boolean cbg;
    protected VoiceManager iSW;
    private boolean isForeground;
    protected boolean klb;
    private View kle;
    private PermissionJudgePolicy mPermissionJudgement;
    protected Handler handler = new Handler();
    protected AbsMsglistView kkW = null;
    protected MsglistModel kkX = null;
    protected LocalPicModel kkY = null;
    protected com.baidu.adp.base.d kkZ = null;
    protected i kla = null;
    protected a.InterfaceC0606a<ChatMessage> klc = null;
    private long kld = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean klf = true;
    private CustomMessageListener jhd = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d klg = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (TalkableActivity.this.kkW != null) {
                    TalkableActivity.this.kkW.displayNoNetwork();
                }
            } else if (TalkableActivity.this.kkW != null) {
                TalkableActivity.this.kkW.hideNoNetwork();
            }
            switch (TalkableActivity.this.kkX.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.kld > -1) {
                        TalkableActivity.this.kld = -1L;
                    }
                    TalkableActivity.this.kkW.closeProgress();
                    TalkableActivity.this.kkW.refreshGo2New(TalkableActivity.this.kkX.getData());
                    return;
                case 2:
                    TalkableActivity.this.kkW.refreshPrepage(TalkableActivity.this.kkX.getData());
                    return;
                case 3:
                    TalkableActivity.this.kkW.refreshCheckNew(TalkableActivity.this.kkX.getData());
                    return;
                case 4:
                    TalkableActivity.this.kkW.refreshGo2New(TalkableActivity.this.kkX.getData());
                    return;
                case 5:
                    TalkableActivity.this.kkW.refreshNormal(TalkableActivity.this.kkX.getData());
                    return;
                case 6:
                    TalkableActivity.this.kkW.refreshNormal(TalkableActivity.this.kkX.getData());
                    return;
                case 7:
                    TalkableActivity.this.kkW.refreshNormal(TalkableActivity.this.kkX.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.kkW.setDraft(str);
                        TalkableActivity.this.kkX.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.klf = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.kkW.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.klf = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.kkW.refreshGo2New(TalkableActivity.this.kkX.getData());
                    return;
                case 13:
                    TalkableActivity.this.kkW.refreshNormal(TalkableActivity.this.kkX.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.kkW.refreshNormal(TalkableActivity.this.kkX.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXb() {
        this.kkZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.kkX != null) {
                        TalkableActivity.this.kkX.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
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
            this.kld = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.kld = System.currentTimeMillis();
        }
        this.klc = new a.InterfaceC0606a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0606a
            /* renamed from: a */
            public void onImageProgessInUI(int i, ChatMessage chatMessage) {
                TalkableActivity.this.kkW.updateAdapter(i, chatMessage);
            }
        };
        cTO();
        cTQ();
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
                    if (this.kkY != null) {
                        this.kkY.cancelLoadData();
                        this.kkY = null;
                    }
                    String stringExtra2 = intent.getStringExtra("album_result");
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !y.isEmpty(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            ad.a(new ac<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.ac
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap ImageResult = al.ImageResult(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), av.btX().getPostImageSize());
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
                                    TalkableActivity.this.kkY = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.kkY.setLoadDataCallBack(TalkableActivity.this.kkZ);
                                    TalkableActivity.this.kkY.getData();
                                    TalkableActivity.this.kkW.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.kkY = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.kkY.setLoadDataCallBack(this.kkZ);
                        this.kkY.getData();
                        this.kkW.hideMore();
                        return;
                    }
                    this.kkY = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.kkY.setLoadDataCallBack(this.kkZ);
                    this.kkY.getData();
                    this.kkW.hideMore();
                    return;
                }
                int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                String string = TbadkCoreApplication.getInst().getString(R.string.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(R.string.cancel);
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            l(maxChatImageWidthInPx, string, string2);
                        } else {
                            a(intent, maxChatImageWidthInPx, string, string2);
                        }
                    }
                } else if (i == 12001) {
                    l(maxChatImageWidthInPx, string, string2);
                }
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                cCM();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                cTS();
            }
        }
    }

    private void cCM() {
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

    private void l(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteImageActivityConfig(getPageContext().getContext(), RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, null, null, null, i, str, str2, "")));
    }

    public void onItemViewLongClick(View view, int i, int i2, long j) {
        this.kle = view;
        ChatMessage msg = this.kkX.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.klb = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.kkW.showDiaItemContentOperate(i2, Y(i, this.klb));
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
            this.kld = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.kld = System.currentTimeMillis();
        }
        cTO();
        cTQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iSW != null) {
            this.iSW.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isForeground = false;
        if (this.iSW != null) {
            this.iSW.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jhd);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iSW;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        if (this.kkW == null || this.kkW.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.kkW.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void cTO() {
        if (this.iSW == null) {
            this.iSW = new VoiceManager();
            this.iSW.onCreate(getPageContext());
        }
        this.iSW.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.kkW == null) {
            return null;
        }
        return this.kkW.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bJm() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bJn() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bJo() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bJp() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bJq() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bJr() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bJs() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        bf.bua().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    public void aB(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.kkW != null && this.kkW.isMoreVisible()) {
                this.kkW.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.klf && this.kkW != null) {
            cTP();
        }
        super.finish();
    }

    protected boolean cTP() {
        return this.kkX.saveDraft(this.kkW.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iSW != null) {
            this.iSW.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isForeground = true;
        if (this.iSW != null) {
            this.iSW.onResume(getPageContext());
            this.iSW.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.jhd);
    }

    private void cCF() {
        if (this.iSW != null) {
            this.iSW.stopPlay();
        }
    }

    public boolean cTQ() {
        if (n.checkSD()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cTR() {
        final String beforeSendMsgText = this.kkW.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.kkW.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.kkX.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void cTS() {
        if (cTQ()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.kkW != null) {
            cCF();
            if (view == this.kkW.getBtnBack()) {
                this.kkW.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.kkW.getLayNewMsg()) {
                this.kkW.refreshGo2New(this.kkX.getData());
                this.kkW.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.iSW != null) {
            this.iSW.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cbg && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.kkW.getBtnSendVoice()) {
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
                if (this.iSW == null || !recorderManager.sx()) {
                    return true;
                }
                recorderManager.a(this.kkW, -1);
                this.kkW.closeRecordCancel();
                this.kkW.refreshSendVoiceText(true);
                this.kkW.startRecordVoice();
                this.cbg = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.sw();
                    }
                    this.kkW.closeRecordCancel();
                } else if (!this.isForeground) {
                    if (recorderManager != null) {
                        recorderManager.sw();
                    }
                    this.kkW.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.kkW.stopRecordVoice();
                }
                this.kkW.refreshSendVoiceText(false);
                this.cbg = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.kkW.showRecordCancel();
                    this.kkW.stopRecordVoice();
                    this.cbg = false;
                } else {
                    this.kkW.closeRecordCancel();
                    this.kkW.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void d(u uVar) {
        this.kkX.sendBigEmotionMessage(uVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        cTT();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.kkW.closeNewMsg();
    }

    private void cTT() {
        this.kkX.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kkX != null) {
            this.kkX.onDestroy();
        }
        super.onDestroy();
        if (this.iSW != null) {
            this.iSW.onDestory(getPageContext());
        }
        if (this.kla != null) {
            this.kla = null;
        }
        if (this.kkY != null) {
            this.kkY.cancelLoadData();
            this.kkY = null;
        }
        if (this.kkW != null) {
            this.kkW.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.k.c
    public void a(k kVar, int i, View view) {
        if (this.kkW.getMsgItemOperationDialog() != null && kVar.getRootView() == this.kkW.getMsgItemOperationDialog().getContentView()) {
            int intValue = ((Integer) kVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    bv(intValue, charSequence);
                    this.kkW.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void bv(int i, String str) {
        ChatMessage msg = this.kkX.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(R.string.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.copyToClipboard(msg.getContent());
                showToast(R.string.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.kkW.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.delete))) {
            if ((this.kle instanceof ChatVoiceView) && ((ChatVoiceView) this.kle).isPlaying() && this.iSW != null) {
                this.iSW.stopPlay();
            }
            this.kkX.markDeleteMsg(i);
            showToast(R.string.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.save))) {
            String aS = com.baidu.tieba.im.util.e.aS(msg.getContent(), true);
            if (aS != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.mPermissionJudgement.clearRequestPermissionList();
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                    this.kla = new i(aS, this);
                    this.kla.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(R.string.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.iSW.setSpeakerphoneOn(true);
                this.kkW.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.iSW.setSpeakerphoneOn(false);
            this.kkW.showReceiver();
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
                aVar.Bq(TbadkCoreApplication.getInst().getString(R.string.sure_to_resend_this_message));
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
                aVar.b(getPageContext()).brv();
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
                if (!cTQ() || (msg2 = this.kkX.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.q(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.kkX.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.s(msg3) && (msg = this.kkX.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.kkX.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            bf.bua().b(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.fC(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.das() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.das()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long j2 = com.baidu.adp.lib.f.b.toLong(theNewThemeId, 0L);
                            if (j2 > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), j2, ((ShareFromPBMsgData) aVar2.das()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.das()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.das()).getThreadId(), ((ShareFromPBMsgData) aVar2.das()).getPostId(), null)));
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
                ChatMessage msg5 = this.kkX.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.fC(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.das() != null) {
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
                ChatMessage msg6 = this.kkX.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.fC(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.das() != null) {
                        bf.bua().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.das()).getShareSourceUrl()}, true);
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
                ChatMessage msg7 = this.kkX.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        bf.bua().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.kkX.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.fC(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.das() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.das()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.das()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.kkX.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.kkX.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.iSW == null || this.iSW.getRecorderManager() == null) {
            return null;
        }
        return this.iSW.getRecorderManager();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
