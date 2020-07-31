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
import com.baidu.i.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.aj;
import com.baidu.tbadk.util.l;
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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.b.a, com.baidu.adp.lib.b.b, BdListView.e, BdListView.h, a.InterfaceC0153a, k.c, VoiceManager.c, com.baidu.tbadk.widget.richText.i {
    private boolean btI;
    protected VoiceManager hFy;
    protected boolean iRF;
    private View iRI;
    private boolean isForeground;
    private PermissionJudgePolicy mPermissionJudgement;
    protected Handler handler = new Handler();
    protected AbsMsglistView iRA = null;
    protected MsglistModel iRB = null;
    protected LocalPicModel iRC = null;
    protected com.baidu.adp.base.d iRD = null;
    protected i iRE = null;
    protected a.InterfaceC0509a<ChatMessage> iRG = null;
    private long iRH = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean iRJ = true;
    private CustomMessageListener iRK = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d iRL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (TalkableActivity.this.iRA != null) {
                    TalkableActivity.this.iRA.displayNoNetwork();
                }
            } else if (TalkableActivity.this.iRA != null) {
                TalkableActivity.this.iRA.hideNoNetwork();
            }
            switch (TalkableActivity.this.iRB.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.iRH > -1) {
                        TalkableActivity.this.iRH = -1L;
                    }
                    TalkableActivity.this.iRA.closeProgress();
                    TalkableActivity.this.iRA.refreshGo2New(TalkableActivity.this.iRB.getData());
                    return;
                case 2:
                    TalkableActivity.this.iRA.refreshPrepage(TalkableActivity.this.iRB.getData());
                    return;
                case 3:
                    TalkableActivity.this.iRA.refreshCheckNew(TalkableActivity.this.iRB.getData());
                    return;
                case 4:
                    TalkableActivity.this.iRA.refreshGo2New(TalkableActivity.this.iRB.getData());
                    return;
                case 5:
                    TalkableActivity.this.iRA.refreshNormal(TalkableActivity.this.iRB.getData());
                    return;
                case 6:
                    TalkableActivity.this.iRA.refreshNormal(TalkableActivity.this.iRB.getData());
                    return;
                case 7:
                    TalkableActivity.this.iRA.refreshNormal(TalkableActivity.this.iRB.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.iRA.setDraft(str);
                        TalkableActivity.this.iRB.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.iRJ = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.iRA.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.iRJ = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.iRA.refreshGo2New(TalkableActivity.this.iRB.getData());
                    return;
                case 13:
                    TalkableActivity.this.iRA.refreshNormal(TalkableActivity.this.iRB.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.iRA.refreshNormal(TalkableActivity.this.iRB.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBE() {
        this.iRD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.iRB != null) {
                        TalkableActivity.this.iRB.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
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
            this.iRH = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.iRH = System.currentTimeMillis();
        }
        this.iRG = new a.InterfaceC0509a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0509a
            /* renamed from: a */
            public void onImageProgessInUI(int i, ChatMessage chatMessage) {
                TalkableActivity.this.iRA.updateAdapter(i, chatMessage);
            }
        };
        crc();
        cre();
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
                    if (this.iRC != null) {
                        this.iRC.cancelLoadData();
                        this.iRC = null;
                    }
                    String stringExtra2 = intent.getStringExtra("album_result");
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !x.isEmpty(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            ad.a(new ac<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.ac
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap ImageResult = aj.ImageResult(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), at.baS().getPostImageSize());
                                        if (ImageResult != null && n.a(null, TbConfig.IMAGE_RESIZED_FILE, ImageResult, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(ImageResult, 100)) != null) {
                                            if (n.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new l<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                                @Override // com.baidu.tbadk.util.l
                                public void onReturnDataInUI(Object obj) {
                                    TalkableActivity.this.iRC = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.iRC.setLoadDataCallBack(TalkableActivity.this.iRD);
                                    TalkableActivity.this.iRC.getData();
                                    TalkableActivity.this.iRA.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.iRC = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.iRC.setLoadDataCallBack(this.iRD);
                        this.iRC.getData();
                        this.iRA.hideMore();
                        return;
                    }
                    this.iRC = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.iRC.setLoadDataCallBack(this.iRD);
                    this.iRC.getData();
                    this.iRA.hideMore();
                    return;
                }
                int maxChatImageWidthInPx = TiebaIMConfig.getMaxChatImageWidthInPx(getPageContext().getContext());
                String string = TbadkCoreApplication.getInst().getString(R.string.send_msg);
                String string2 = TbadkCoreApplication.getInst().getString(R.string.cancel);
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            i(maxChatImageWidthInPx, string, string2);
                        } else {
                            a(intent, maxChatImageWidthInPx, string, string2);
                        }
                    }
                } else if (i == 12001) {
                    i(maxChatImageWidthInPx, string, string2);
                }
            }
        } else if (i2 == 0) {
            if (i == 12010) {
                ccb();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                crg();
            }
        }
    }

    private void ccb() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            an.g(getPageContext());
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

    private void i(int i, String str, String str2) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteImageActivityConfig(getPageContext().getContext(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, null, null, null, i, str, str2, "")));
    }

    public void onItemViewLongClick(View view, int i, int i2, long j) {
        this.iRI = view;
        ChatMessage msg = this.iRB.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.iRF = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.iRA.showDiaItemContentOperate(i2, T(i, this.iRF));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] T(int i, boolean z) {
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
            this.iRH = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.iRH = System.currentTimeMillis();
        }
        crc();
        cre();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isForeground = false;
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.iRK);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hFy;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        if (this.iRA == null || this.iRA.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.iRA.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void crc() {
        if (this.hFy == null) {
            this.hFy = new VoiceManager();
            this.hFy.onCreate(getPageContext());
        }
        this.hFy.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.iRA == null) {
            return null;
        }
        return this.iRA.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bpt() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bpu() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bpv() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bpw() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bpx() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bpy() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bpz() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        bd.baV().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
    }

    public void aq(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.iRA != null && this.iRA.isMoreVisible()) {
                this.iRA.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.iRJ && this.iRA != null) {
            crd();
        }
        super.finish();
    }

    protected boolean crd() {
        return this.iRB.saveDraft(this.iRA.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isForeground = true;
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
            this.hFy.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.iRK);
    }

    private void cbU() {
        if (this.hFy != null) {
            this.hFy.stopPlay();
        }
    }

    public boolean cre() {
        if (n.checkSD()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void crf() {
        final String beforeSendMsgText = this.iRA.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.iRA.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.iRB.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void crg() {
        if (cre()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.iRA != null) {
            cbU();
            if (view == this.iRA.getBtnBack()) {
                this.iRA.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.iRA.getLayNewMsg()) {
                this.iRA.refreshGo2New(this.iRB.getData());
                this.iRA.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.hFy != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.btI && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.iRA.getBtnSendVoice()) {
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
                if (this.hFy == null || !recorderManager.qQ()) {
                    return true;
                }
                recorderManager.a(this.iRA, -1);
                this.iRA.closeRecordCancel();
                this.iRA.refreshSendVoiceText(true);
                this.iRA.startRecordVoice();
                this.btI = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.qP();
                    }
                    this.iRA.closeRecordCancel();
                } else if (!this.isForeground) {
                    if (recorderManager != null) {
                        recorderManager.qP();
                    }
                    this.iRA.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.iRA.stopRecordVoice();
                }
                this.iRA.refreshSendVoiceText(false);
                this.btI = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < com.baidu.adp.lib.util.l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.iRA.showRecordCancel();
                    this.iRA.stopRecordVoice();
                    this.btI = false;
                } else {
                    this.iRA.closeRecordCancel();
                    this.iRA.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void d(q qVar) {
        this.iRB.sendBigEmotionMessage(qVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        crh();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.iRA.closeNewMsg();
    }

    private void crh() {
        this.iRB.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iRB != null) {
            this.iRB.onDestroy();
        }
        super.onDestroy();
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
        if (this.iRE != null) {
            this.iRE = null;
        }
        if (this.iRC != null) {
            this.iRC.cancelLoadData();
            this.iRC = null;
        }
        if (this.iRA != null) {
            this.iRA.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.k.c
    public void a(k kVar, int i, View view) {
        if (this.iRA.getMsgItemOperationDialog() != null && kVar.getRootView() == this.iRA.getMsgItemOperationDialog().getContentView()) {
            int intValue = ((Integer) kVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    bh(intValue, charSequence);
                    this.iRA.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void bh(int i, String str) {
        ChatMessage msg = this.iRB.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(R.string.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.copyToClipboard(msg.getContent());
                showToast(R.string.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.iRA.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.delete))) {
            if ((this.iRI instanceof ChatVoiceView) && ((ChatVoiceView) this.iRI).isPlaying() && this.hFy != null) {
                this.hFy.stopPlay();
            }
            this.iRB.markDeleteMsg(i);
            showToast(R.string.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.save))) {
            String aH = com.baidu.tieba.im.util.e.aH(msg.getContent(), true);
            if (aH != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.mPermissionJudgement.clearRequestPermissionList();
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                    this.iRE = new i(aH, this);
                    this.iRE.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(R.string.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.hFy.setSpeakerphoneOn(true);
                this.iRA.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.hFy.setSpeakerphoneOn(false);
            this.iRA.showReceiver();
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
                aVar.xl(TbadkCoreApplication.getInst().getString(R.string.sure_to_resend_this_message));
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
                aVar.b(getPageContext()).aYL();
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
                if (!cre() || (msg2 = this.iRB.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.q(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.iRB.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.s(msg3) && (msg = this.iRB.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
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
                ChatMessage msg4 = this.iRB.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            bd.baV().b(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.eG(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.cxL() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.cxL()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long j2 = com.baidu.adp.lib.f.b.toLong(theNewThemeId, 0L);
                            if (j2 > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), j2, ((ShareFromPBMsgData) aVar2.cxL()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.cxL()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.cxL()).getThreadId(), ((ShareFromPBMsgData) aVar2.cxL()).getPostId(), null)));
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
                ChatMessage msg5 = this.iRB.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.eG(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.cxL() != null) {
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
                ChatMessage msg6 = this.iRB.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.eG(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.cxL() != null) {
                        bd.baV().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.cxL()).getShareSourceUrl()}, true);
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
                ChatMessage msg7 = this.iRB.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        bd.baV().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.iRB.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.eG(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.cxL() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.cxL()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.cxL()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.iRB.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.iRB.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.hFy == null || this.hFy.getRecorderManager() == null) {
            return null;
        }
        return this.hFy.getRecorderManager();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ad.checkCamera(getApplicationContext())) {
                an.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = com.baidu.tbadk.core.util.ad.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
