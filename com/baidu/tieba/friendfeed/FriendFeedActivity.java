package com.baidu.tieba.friendfeed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.al;
import com.baidu.tieba.tbadkCore.am;
import com.baidu.tieba.tbadkCore.ao;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FriendFeedActivity extends BaseActivity<FriendFeedActivity> implements View.OnClickListener, ab, com.baidu.tbadk.core.voice.o, am, com.baidu.tieba.tbadkCore.n {
    private ak aBC;
    private x aBD;
    private com.baidu.tieba.model.l aBE;
    private com.baidu.tieba.tbadkCore.location.d aBF;
    private FriendFeedThreadData aBH;
    private boolean aBI;
    private String aBJ;
    private String aBK;
    private FriendFeedThreadData aBL;
    private com.baidu.tieba.tbadkCore.f.a aBM;
    VoiceManager mVoiceManager;
    private boolean aBG = false;
    private WriteImagesInfo aql = new WriteImagesInfo();
    private final com.baidu.adp.lib.e.b<TbImageView> aBN = FrsCommonImageLayout.k(getPageContext().getPageActivity(), 6);
    private CustomMessageListener aBO = new a(this, 2004004);
    private final com.baidu.tieba.tbadkCore.f.b aBP = new h(this);
    private com.baidu.tieba.tbadkCore.location.i aBQ = new i(this);
    private com.baidu.tieba.tbadkCore.location.j aBR = new j(this);
    private final AbsListView.OnScrollListener aBS = new k(this);
    private final u aBT = new l(this);
    private final ao aBU = new ao(getPageContext(), new m(this));
    private final com.baidu.adp.framework.listener.e mListener = new n(this, 303003);
    private final CustomMessageListener mLoadCacheListener = new o(this, 2001172);

    static {
        TbadkApplication.getInst().RegisterIntent(FriendFeedActivityConfig.class, FriendFeedActivity.class);
        com.baidu.tieba.tbadkCore.a.a.a(303003, ResponseFriendFeedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001172, com.baidu.tieba.message.a.a.class);
        com.baidu.tieba.tbadkCore.location.d.aii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fp() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Fq() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(z.location_system_permission_prompt);
        } else if (!TbadkApplication.getInst().getLocationShared()) {
            Fr();
        } else if (this.aBF.aih()) {
            Fp();
        } else {
            this.aBF.eE(false);
            if (this.aBD.FF() != null) {
                this.aBD.FF().setLocationViewVisibility(0);
                this.aBD.FF().setLocationInfoViewState(1);
            }
            this.aBF.aif();
        }
    }

    private void Fr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.by(z.location_app_permission_prompt).a(z.isopen, new b(this)).b(z.cancel, new c(this)).b(getPageContext());
        aVar.nX();
    }

    private void Fs() {
        if (this.aBD.FF() != null) {
            if (this.aBF.aij()) {
                this.aBD.FF().setLocationViewVisibility(0);
                if (this.aBF.aih()) {
                    this.aBQ.a(com.baidu.tieba.tbadkCore.location.c.aic().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    this.aBD.FF().setLocationInfoViewState(1);
                    this.aBF.aif();
                    return;
                } else {
                    this.aBD.FF().setLocationInfoViewState(0);
                    return;
                }
            }
            this.aBD.FF().setLocationViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        f(true, null);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.aBE.saveInstance(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aql);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBK);
        bundle.putSerializable("reply_thread", this.aBL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aBI = true;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aBI = false;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aBM != null) {
            this.aBM.cancelLoadData();
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    private void initUI() {
        this.aBD = new x(getPageContext());
        BdListView bdListView = this.aBD.getBdListView();
        this.aBC = new ak(getPageContext());
        this.aBC.a(new d(this));
        bdListView.setPullRefresh(this.aBC);
        bdListView.setOnSrollToBottomListener(this);
        bdListView.setOnScrollListener(this.aBS);
        bdListView.setOnItemClickListener(new e(this));
        this.aBD.FI().a(this.aBT);
        this.aBD.setOnActionListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aBL.getFname());
            antiData.setBlock_forum_id(this.aBL.getFid());
            antiData.setUser_name(this.aBL.getAuthor().getUserName());
            antiData.setUser_id(this.aBL.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(String str) {
        if (this.aBM.Ft() == null) {
            WriteData Ft = Ft();
            Ft.setWriteImagesInfo(this.aql);
            this.aBM.eF(this.aql.size() > 0);
            this.aBM.c(Ft);
        }
        if (this.aBM.Ft() != null) {
            if (this.aBD.FF() != null) {
                this.aBM.Ft().setHasLocationData(this.aBD.FF().getLocationInfoViewState() == 2);
            }
            this.aBM.Ft().setIsFrsReply(true);
            this.aBM.Ft().setContent(this.aBD.FM());
            VoiceData.VoiceModel audioData = this.aBD.getAudioData();
            this.aBD.FO();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aBM.Ft().setVoice(audioData.getId());
                    this.aBM.Ft().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aBM.Ft().setVoice(null);
                    this.aBM.Ft().setVoiceDuringTime(-1);
                }
            } else {
                this.aBM.Ft().setVoice(null);
                this.aBM.Ft().setVoiceDuringTime(-1);
            }
            if (this.aBM.aiF()) {
                this.aBD.FL();
            }
        }
    }

    public WriteData Ft() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.aBL.getFid());
        writeData.setForumName(this.aBL.getFname());
        writeData.setThreadId(this.aBL.getTid());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            K(intent);
                            return;
                        } else {
                            J(intent);
                            return;
                        }
                    }
                    return;
                case 12004:
                    ArrayList<String> W = com.baidu.tieba.tbadkCore.util.i.W(intent);
                    if (W != null) {
                        this.aBD.A(W);
                        return;
                    }
                    return;
                case 12006:
                    WriteData Ft = this.aBM.Ft();
                    if (Ft != null) {
                        Ft.deleteUploadedTempImages();
                    }
                    this.aBM.c((WriteData) null);
                    this.aBM.eF(false);
                    this.aBD.bG(true);
                    al.b(this.aBL.getTid(), (WriteData) null);
                    this.aBD.a(this.aql, true);
                    this.aBL.setReply_num(this.aBL.getReply_num() + 1);
                    this.aBD.FK();
                    this.aBD.FH();
                    return;
                case 12012:
                    L(intent);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    Fu();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.aql.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12003:
                default:
                    return;
            }
        }
    }

    private void J(Intent intent) {
        a(intent, true);
    }

    private void K(Intent intent) {
        int size;
        M(intent);
        int size2 = this.aql.size() - 1;
        if (size2 > -1 && this.aql != null && this.aql.getChosedFiles() != null && (size = this.aql.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.aql, size2)));
        }
    }

    private void L(Intent intent) {
        a(intent, false);
    }

    private void Fu() {
        new g(this).execute(new Void[0]);
    }

    private void M(Intent intent) {
        this.aBK = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBK;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cb = com.baidu.tbadk.core.util.d.cb(str);
                if (cb != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, cb);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aBK, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aql.addChooseFile(imageFileInfo);
            this.aql.updateQuality();
            this.aBD.a(this.aql, true);
        }
        if (this.aBD.FF() != null && this.aql.getChosedFiles() != null && this.aql.getChosedFiles().size() > 0) {
            this.aBD.FF().hQ(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aql.parseJson(stringExtra);
                this.aql.updateQuality();
                if (this.aql.getChosedFiles() != null) {
                    this.aBD.a(this.aql, z);
                }
            }
            if (this.aBD.FF() != null && this.aql.getChosedFiles() != null && this.aql.getChosedFiles().size() > 0) {
                this.aBD.FF().hQ(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(int i) {
        ArrayList<FriendFeedThreadData> Fz = this.aBD.FI().Fz();
        if (Fz != null) {
            Iterator<FriendFeedThreadData> it = Fz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FriendFeedThreadData next = it.next();
                if (next == this.aBH) {
                    a(next, i);
                    this.aBH = null;
                    break;
                } else if (next.getId() != null && next.getId().equals(this.aBJ)) {
                    a(next, i);
                    this.aBJ = null;
                    break;
                }
            }
            this.aBD.FI().notifyDataSetChanged();
        }
    }

    private void a(FriendFeedThreadData friendFeedThreadData, int i) {
        if (i == 1) {
            PraiseData praise = friendFeedThreadData.getPraise();
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    friendFeedThreadData.setPraise(praiseData);
                    return;
                }
                friendFeedThreadData.getPraise().getUser().add(0, metaData);
                friendFeedThreadData.getPraise().setNum(friendFeedThreadData.getPraise().getNum() + 1);
                friendFeedThreadData.getPraise().setIsLike(i);
            }
        } else if (friendFeedThreadData.getPraise() != null) {
            friendFeedThreadData.getPraise().setIsLike(i);
            friendFeedThreadData.getPraise().setNum(friendFeedThreadData.getPraise().getNum() - 1);
            ArrayList<MetaData> user = friendFeedThreadData.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                        friendFeedThreadData.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aBD.FF() != null && this.aBD.FF().isVisible()) {
                Fv();
                this.aBD.FH();
            } else {
                closeActivity();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(z.login_to_use), true, 0)));
            return;
        }
        if (this.aBL != friendFeedThreadData && this.aBL != null) {
            Fv();
            this.aBD.fC(null);
            this.aql = new WriteImagesInfo();
            this.aql.setMaxImagesAllowed(10);
            this.aBD.a(this.aql, true);
            this.aBM.c((WriteData) null);
            this.aBM.eF(false);
            this.aBD.FN();
        }
        if (friendFeedThreadData != null) {
            al.a(friendFeedThreadData.getTid(), this);
        }
        this.aBL = friendFeedThreadData;
        this.aBD.a(i, friendFeedThreadData, i2);
        Fs();
    }

    private void Fv() {
        if (this.aBL != null) {
            WriteData Ft = this.aBM.Ft();
            if (Ft == null) {
                Ft = new WriteData(1);
                Ft.setThreadId(this.aBL.getTid());
                Ft.setWriteImagesInfo(this.aql);
            }
            Ft.setContent(this.aBD.FM());
            al.b(this.aBL.getTid(), Ft);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        this.aBD.FI().reset(z);
        this.aBD.getBdListView().jJ();
        this.aBE.setTimeline(null);
        if (z) {
            sendMessage(false);
        } else {
            sendMessage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(boolean z) {
        if (z) {
            this.aBE.z(60, this.aBE.getTimeline());
        } else {
            this.aBE.A(60, this.aBE.getTimeline());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.aBD.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return TextUtils.isEmpty(this.aBE.getTimeline());
    }

    public void initData(Bundle bundle) {
        this.aBE = new com.baidu.tieba.model.l(this);
        this.aBE.setUniqueId(getUniqueId());
        if (bundle != null) {
            this.aBE.initWithBundle(bundle);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.aBE.registerListener(this.mListener);
        this.aBE.registerListener(this.mLoadCacheListener);
        this.aBE.registerListener(this.aBO);
        this.aBU.setUniqueId(getUniqueId());
        this.aBU.registerListener();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aql = writeImagesInfo;
            }
            this.aBL = (FriendFeedThreadData) bundle.getSerializable("reply_thread");
            this.aBK = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aql.setMaxImagesAllowed(10);
        this.aBM = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aBM.a(this.aBP);
        this.aBF = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aBF.a(this.aBQ);
        this.aBF.a(this.aBR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aBD.onChangeSkinType(i);
        this.aBC.cs(i);
    }

    private void loadMore() {
        if (this.aBD.FI().FA()) {
            this.aBE.z(60, this.aBE.getTimeline());
        }
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        loadMore();
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> Fw() {
        return this.aBN;
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.aBL != null && writeData.getThreadId().equals(this.aBL.getTid())) {
            if (!bf.isEmpty(writeData.getContent())) {
                this.aBD.fC(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.aql.size() == 0) {
                this.aql.copyFrom(writeData.getWriteImagesInfo());
                this.aBD.a(this.aql, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
