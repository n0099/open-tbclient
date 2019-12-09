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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
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
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.y;
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
public abstract class TalkableActivity<T> extends BaseActivity<T> implements View.OnTouchListener, com.baidu.adp.lib.c.a, com.baidu.adp.lib.c.b, BdListView.e, BdListView.h, a.InterfaceC0055a, k.c, VoiceManager.c, com.baidu.tbadk.widget.richText.e {
    private boolean axQ;
    protected VoiceManager fuw;
    protected boolean gzI;
    private boolean gzJ;
    private View gzM;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    protected Handler handler = new Handler();
    protected AbsMsglistView gzD = null;
    protected MsglistModel gzE = null;
    protected LocalPicModel gzF = null;
    protected com.baidu.adp.base.d gzG = null;
    protected i gzH = null;
    protected a.InterfaceC0292a<ChatMessage> gzK = null;
    private long gzL = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean gzN = true;
    private CustomMessageListener gzO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.im.chat.TalkableActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(TalkableActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d gzP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.7
        /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.im.chat.TalkableActivity */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (TalkableActivity.this.gzD != null) {
                    TalkableActivity.this.gzD.displayNoNetwork();
                }
            } else if (TalkableActivity.this.gzD != null) {
                TalkableActivity.this.gzD.hideNoNetwork();
            }
            switch (TalkableActivity.this.gzE.getLoadDataMode()) {
                case 1:
                    if (TalkableActivity.this.gzL > -1) {
                        TalkableActivity.this.gzL = -1L;
                    }
                    TalkableActivity.this.gzD.closeProgress();
                    TalkableActivity.this.gzD.refreshGo2New(TalkableActivity.this.gzE.getData());
                    return;
                case 2:
                    TalkableActivity.this.gzD.refreshPrepage(TalkableActivity.this.gzE.getData());
                    return;
                case 3:
                    TalkableActivity.this.gzD.refreshCheckNew(TalkableActivity.this.gzE.getData());
                    return;
                case 4:
                    TalkableActivity.this.gzD.refreshGo2New(TalkableActivity.this.gzE.getData());
                    return;
                case 5:
                    TalkableActivity.this.gzD.refreshNormal(TalkableActivity.this.gzE.getData());
                    return;
                case 6:
                    TalkableActivity.this.gzD.refreshNormal(TalkableActivity.this.gzE.getData());
                    return;
                case 7:
                    TalkableActivity.this.gzD.refreshNormal(TalkableActivity.this.gzE.getData());
                    return;
                case 8:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        TalkableActivity.this.gzD.setDraft(str);
                        TalkableActivity.this.gzE.setDraft(str);
                        return;
                    }
                    return;
                case 9:
                    TalkableActivity.this.gzN = false;
                    TalkableActivity.this.finish();
                    return;
                case 10:
                    if (obj != null && (obj instanceof String)) {
                        TalkableActivity.this.gzD.refreshHeaderFooter((String) obj, true);
                        return;
                    }
                    return;
                case 11:
                    TbadkCoreApplication.getInst().login(TalkableActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TalkableActivity.this.getPageContext().getContext())));
                    TalkableActivity.this.gzN = false;
                    TalkableActivity.this.finish();
                    return;
                case 12:
                    TalkableActivity.this.gzD.refreshGo2New(TalkableActivity.this.gzE.getData());
                    return;
                case 13:
                    TalkableActivity.this.gzD.refreshNormal(TalkableActivity.this.gzE.getData());
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            TalkableActivity.this.gzD.refreshNormal(TalkableActivity.this.gzE.getData());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public void initCallback() {
        this.gzG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.chat.TalkableActivity.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
                    LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
                    if (TalkableActivity.this.gzE != null) {
                        TalkableActivity.this.gzE.sendPicMessage(responseData.getSPathGen(), responseData.getBitmap());
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
            this.gzL = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.gzL = System.currentTimeMillis();
        }
        this.gzK = new a.InterfaceC0292a<ChatMessage>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.img.a.InterfaceC0292a
            /* renamed from: a */
            public void onImageProgessInUI(int i, ChatMessage chatMessage) {
                TalkableActivity.this.gzD.updateAdapter(i, chatMessage);
            }
        };
        byk();
        bym();
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
                    if (this.gzF != null) {
                        this.gzF.cancelLoadData();
                        this.gzF = null;
                    }
                    String stringExtra2 = intent.getStringExtra("album_result");
                    if (stringExtra2 != null) {
                        this.writeImagesInfo.parseJson(stringExtra2);
                        if (this.writeImagesInfo != null && !v.isEmpty(this.writeImagesInfo.getChosedFiles()) && this.writeImagesInfo.getChosedFiles().get(0) != null && this.writeImagesInfo.getChosedFiles().get(0).getFilePath() != null) {
                            z.a(new y<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.3
                                @Override // com.baidu.tbadk.util.y
                                public Object doInBackground() {
                                    Bitmap resizeBitmap;
                                    try {
                                        Bitmap ImageResult = af.ImageResult(0, TalkableActivity.this.getPageContext().getContext(), null, TalkableActivity.this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), ar.amM().getPostImageSize());
                                        if (ImageResult != null && m.a(null, TbConfig.IMAGE_RESIZED_FILE, ImageResult, 85) != null && (resizeBitmap = BitmapHelper.resizeBitmap(ImageResult, 100)) != null) {
                                            if (m.a(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) != null) {
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                    return null;
                                }
                            }, new com.baidu.tbadk.util.j<Object>() { // from class: com.baidu.tieba.im.chat.TalkableActivity.4
                                @Override // com.baidu.tbadk.util.j
                                public void onReturnDataInUI(Object obj) {
                                    TalkableActivity.this.gzF = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                                    TalkableActivity.this.gzF.setLoadDataCallBack(TalkableActivity.this.gzG);
                                    TalkableActivity.this.gzF.getData();
                                    TalkableActivity.this.gzD.hideMore();
                                    TalkableActivity.this.writeImagesInfo.clear();
                                }
                            });
                            return;
                        }
                        this.gzF = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                        this.gzF.setLoadDataCallBack(this.gzG);
                        this.gzF.getData();
                        this.gzD.hideMore();
                        return;
                    }
                    this.gzF = new LocalPicModel(str2, str, null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY);
                    this.gzF.setLoadDataCallBack(this.gzG);
                    this.gzF.getData();
                    this.gzD.hideMore();
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
                takePhoto();
            } else if (i == 12009 && !WriteImageActivityConfig.isActivityInStack) {
                byo();
            }
        }
    }

    private void takePhoto() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
        }
        Activity pageActivity = getPageContext().getPageActivity();
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            al.c(getPageContext());
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteImageActivityConfig(getPageContext().getContext(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, null, null, null, i, str, str2, "")));
    }

    public void onItemViewLongClick(View view, int i, int i2, long j) {
        this.gzM = view;
        ChatMessage msg = this.gzE.getMsg(i2);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus().shortValue() != 1) {
            if (msg.getUserInfo() != null && currentAccountObj != null && !TextUtils.isEmpty(currentAccountObj.getID())) {
                this.gzI = msg.getUserInfo().getUserIdLong() == Long.parseLong(currentAccountObj.getID());
            }
            if (i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 15 || i == 11 || i == 17) {
                this.gzD.showDiaItemContentOperate(i2, G(i, this.gzI));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] G(int i, boolean z) {
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
            this.gzL = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.gzL = System.currentTimeMillis();
        }
        byk();
        bym();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fuw != null) {
            this.fuw.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gzJ = false;
        if (this.fuw != null) {
            this.fuw.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.gzO);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fuw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        if (this.gzD == null || this.gzD.getMsgListView() == null) {
            return null;
        }
        View findViewWithTag = this.gzD.getMsgListView().findViewWithTag(voiceModel);
        if (findViewWithTag == null || !(findViewWithTag instanceof VoiceManager.b)) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    private void byk() {
        if (this.fuw == null) {
            this.fuw = new VoiceManager();
            this.fuw.onCreate(getPageContext());
        }
        this.fuw.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.gzD == null) {
            return null;
        }
        return this.gzD.getMsgListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azO() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azP() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azQ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azR() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azS() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azT() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ai(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        ba.amO().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aj(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ak(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void o(Context context, String str, String str2) {
    }

    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (this.gzD != null && this.gzD.isMoreVisible()) {
                this.gzD.hideMore();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.gzN && this.gzD != null) {
            byl();
        }
        super.finish();
    }

    protected boolean byl() {
        return this.gzE.saveDraft(this.gzD.getDraft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fuw != null) {
            this.fuw.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gzJ = true;
        if (this.fuw != null) {
            this.fuw.onResume(getPageContext());
            this.fuw.setSpeakerphoneOn(TbadkCoreApplication.getInst().isHeadsetModeOn() ? false : true);
        }
        registerListener(this.gzO);
    }

    private void bki() {
        if (this.fuw != null) {
            this.fuw.stopPlay();
        }
    }

    public boolean bym() {
        if (m.checkSD()) {
            return true;
        }
        showToast(TbadkCoreApplication.getInst().getString(R.string.voice_error_sdcard));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byn() {
        final String beforeSendMsgText = this.gzD.beforeSendMsgText();
        if (!TextUtils.isEmpty(beforeSendMsgText)) {
            this.gzD.afterSendMsgText();
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.chat.TalkableActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TalkableActivity.this.gzE.sendTextMessage(beforeSendMsgText);
                }
            }, 100L);
        }
    }

    public void byo() {
        if (bym()) {
            this.writeImagesInfo.mIsFromIm = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, false);
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumActivityConfig.setResourceType(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gzD != null) {
            bki();
            if (view == this.gzD.getBtnBack()) {
                this.gzD.sendmsgCloseSoftkey();
                finish();
            } else if (view == this.gzD.getLayNewMsg()) {
                this.gzD.refreshGo2New(this.gzE.getData());
                this.gzD.closeNewMsg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.fuw != null) {
            this.fuw.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.axQ && motionEvent.getAction() == 261) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.gzD.getBtnSendVoice()) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.RECORD_AUDIO");
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return false;
            }
            com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (this.fuw == null || !recorderManager.lh()) {
                    return true;
                }
                recorderManager.a(this.gzD, -1);
                this.gzD.closeRecordCancel();
                this.gzD.refreshSendVoiceText(true);
                this.gzD.startRecordVoice();
                this.axQ = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    if (recorderManager != null) {
                        recorderManager.lg();
                    }
                    this.gzD.closeRecordCancel();
                } else if (!this.gzJ) {
                    if (recorderManager != null) {
                        recorderManager.lg();
                    }
                    this.gzD.stopRecordVoice();
                } else {
                    if (recorderManager != null) {
                        recorderManager.stopRecord();
                    }
                    this.gzD.stopRecordVoice();
                }
                this.gzD.refreshSendVoiceText(false);
                this.axQ = false;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() < l.dip2px(getPageContext().getContext(), 5.0f) * (-1)) {
                    this.gzD.showRecordCancel();
                    this.gzD.stopRecordVoice();
                    this.axQ = false;
                } else {
                    this.gzD.closeRecordCancel();
                    this.gzD.startRecordVoice();
                }
            }
            return true;
        }
        return false;
    }

    public void d(p pVar) {
        this.gzE.sendBigEmotionMessage(pVar);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.h
    public void onScrollToTop() {
        byp();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gzD.closeNewMsg();
    }

    private void byp() {
        this.gzE.loadPrepage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gzE != null) {
            this.gzE.onDestroy();
        }
        super.onDestroy();
        if (this.fuw != null) {
            this.fuw.onDestory(getPageContext());
        }
        if (this.gzH != null) {
            this.gzH = null;
        }
        if (this.gzF != null) {
            this.gzF.cancelLoadData();
            this.gzF = null;
        }
        if (this.gzD != null) {
            this.gzD.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.dialog.k.c
    public void a(k kVar, int i, View view) {
        if (this.gzD.getMsgItemOperationDialog() != null && kVar.getRootView() == this.gzD.getMsgItemOperationDialog().getContentView()) {
            int intValue = ((Integer) kVar.getRootView().getTag()).intValue();
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    am(intValue, charSequence);
                    this.gzD.getMsgItemOperationDialog().dismiss();
                }
            }
        }
    }

    protected void am(int i, String str) {
        ChatMessage msg = this.gzE.getMsg(i);
        if (str.equals(TbadkCoreApplication.getInst().getString(R.string.copy))) {
            if (msg != null && msg.getCacheData() != null) {
                com.baidu.adp.lib.util.a.copyToClipboard(msg.getContent());
                showToast((int) R.string.op_result_copied);
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.msg_at))) {
            if (msg != null && msg.getUserInfo() != null && msg.getUserInfo().getUserName() != null) {
                this.gzD.addAt2SendMsg(msg.getUserInfo().getUserName());
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.delete))) {
            if ((this.gzM instanceof ChatVoiceView) && ((ChatVoiceView) this.gzM).isPlaying() && this.fuw != null) {
                this.fuw.stopPlay();
            }
            this.gzE.markDeleteMsg(i);
            showToast((int) R.string.delete_success);
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.save))) {
            String ak = com.baidu.tieba.im.util.e.ak(msg.getContent(), true);
            if (ak != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                }
                this.mPermissionJudgement.clearRequestPermissionList();
                this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                    this.gzH = new i(ak, this);
                    this.gzH.execute();
                }
            }
        } else if (str.equals(TbadkCoreApplication.getInst().getString(R.string.group_open_receiver)) || str.equals(TbadkCoreApplication.getInst().getString(R.string.group_close_receiver))) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                TbadkCoreApplication.getInst().setHeadsetModeOn(false);
                this.fuw.setSpeakerphoneOn(true);
                this.gzD.closeReceiver();
                return;
            }
            TbadkCoreApplication.getInst().setHeadsetModeOn(true);
            this.fuw.setSpeakerphoneOn(false);
            this.gzD.showReceiver();
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
                aVar.nn(TbadkCoreApplication.getInst().getString(R.string.sure_to_resend_this_message));
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
                aVar.b(getPageContext()).akM();
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
                if (!bym() || (msg2 = this.gzE.getMsg(i2)) == null || !com.baidu.tieba.im.util.e.q(msg2)) {
                }
                return;
            case 6:
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName())));
                return;
            case 8:
                ChatMessage msg3 = this.gzE.getMsg(i2);
                if (msg3 != null && com.baidu.tieba.im.util.e.s(msg3) && (msg = this.gzE.getMsg(i2)) != null && (content2 = msg.getContent()) != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content2).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                        if (optJSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getContext(), com.baidu.adp.lib.g.b.toInt(optJSONObject.optString("activityId"), 0), com.baidu.adp.lib.g.b.toLong(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID), 0L), 2)));
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
                ChatMessage msg4 = this.gzE.getMsg(i2);
                if (msg4 != null && (content = msg4.getContent()) != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(jSONArray.length() - 1);
                        if (optJSONObject2 != null) {
                            ba.amO().b(getPageContext(), new String[]{optJSONObject2.optString("shareSourceUrl")});
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                    com.baidu.tieba.im.widget.a aVar2 = new com.baidu.tieba.im.widget.a();
                    aVar2.dg(msg4.getContent(), getClass().getName());
                    if (aVar2.getSubType() == 1 && aVar2.bEw() != null) {
                        String theNewThemeId = ((ShareFromPBMsgData) aVar2.bEw()).getTheNewThemeId();
                        if (!StringUtils.isNull(theNewThemeId)) {
                            long j2 = com.baidu.adp.lib.g.b.toLong(theNewThemeId, 0L);
                            if (j2 > 0) {
                                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbChosenActivityConfig(getPageContext().getContext(), j2, ((ShareFromPBMsgData) aVar2.bEw()).getImageUrl())));
                                return;
                            }
                            return;
                        } else if (!StringUtils.isNull(((ShareFromPBMsgData) aVar2.bEw()).getThreadId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromPBMsgData) aVar2.bEw()).getThreadId(), ((ShareFromPBMsgData) aVar2.bEw()).getPostId(), null)));
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
                ChatMessage msg5 = this.gzE.getMsg(i2);
                if (msg5 != null && msg5.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar3 = new com.baidu.tieba.im.widget.a();
                    aVar3.dg(msg5.getContent(), getClass().getName());
                    if (aVar3.getSubType() == 1 && aVar3.bEw() != null) {
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
                ChatMessage msg6 = this.gzE.getMsg(i2);
                if (msg6 != null && msg6.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar4 = new com.baidu.tieba.im.widget.a();
                    aVar4.dg(msg6.getContent(), getClass().getName());
                    if (aVar4.getSubType() == 1 && aVar4.bEw() != null) {
                        ba.amO().a(getPageContext(), new String[]{((ShareFromGameCenterMsgData) aVar4.bEw()).getShareSourceUrl()}, true);
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
                ChatMessage msg7 = this.gzE.getMsg(i2);
                if (msg7 != null && msg7.getContent() != null) {
                    try {
                        ba.amO().a(getPageContext(), new String[]{new JSONArray(msg7.getContent()).getJSONObject(0).optString("shareSourceUrl")}, true);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            case 15:
                ChatMessage msg8 = this.gzE.getMsg(i2);
                if (msg8 != null && msg8.getContent() != null) {
                    com.baidu.tieba.im.widget.a aVar5 = new com.baidu.tieba.im.widget.a();
                    aVar5.dg(msg8.getContent(), getClass().getName());
                    if (aVar5.getSubType() == 4 && aVar5.bEw() != null && !StringUtils.isNull(((ShareFromFrsMsgData) aVar5.bEw()).getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(getPageContext().getContext()).createNormalCfg(((ShareFromFrsMsgData) aVar5.bEw()).getName(), null)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSendMsg(int i) {
        this.gzE.reSendMsg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMsg(int i) {
        this.gzE.deleteMsg(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.fuw == null || this.fuw.getRecorderManager() == null) {
            return null;
        }
        return this.fuw.getRecorderManager();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getApplicationContext())) {
                al.c(getPageContext());
            } else {
                showToast((int) R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast((int) R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
