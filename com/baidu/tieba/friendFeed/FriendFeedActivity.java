package com.baidu.tieba.friendFeed;

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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.ao;
import com.baidu.tieba.tbadkCore.ap;
import com.baidu.tieba.tbadkCore.ar;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FriendFeedActivity extends BaseActivity<FriendFeedActivity> implements View.OnClickListener, com.baidu.tbadk.core.voice.j, ap, com.baidu.tieba.tbadkCore.n {
    private ag aHA;
    private y aHB;
    private com.baidu.tieba.friendFeed.a.a aHC;
    private com.baidu.tieba.tbadkCore.location.e aHD;
    private FriendFeedThreadData aHF;
    private boolean aHG;
    private String aHH;
    private String aHI;
    private FriendFeedThreadData aHJ;
    private com.baidu.tieba.tbadkCore.writeModel.a aHK;
    VoiceManager mVoiceManager;
    private boolean aHE = false;
    private WriteImagesInfo aHL = new WriteImagesInfo();
    private final com.baidu.adp.lib.e.b<TbImageView> aHM = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 6);
    private CustomMessageListener aHN = new a(this, 2004004);
    private final com.baidu.tieba.tbadkCore.writeModel.d aHO = new h(this);
    private com.baidu.tieba.tbadkCore.location.j aHP = new i(this);
    private com.baidu.tieba.tbadkCore.location.k aHQ = new j(this);
    private final AbsListView.OnScrollListener aHR = new k(this);
    private final v aHS = new l(this);
    private final ar aHT = new ar(getPageContext(), new m(this));
    private final com.baidu.adp.framework.listener.e mListener = new n(this, 303003);
    private final CustomMessageListener mLoadCacheListener = new o(this, 2001172);

    /* JADX INFO: Access modifiers changed from: private */
    public void IO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void IP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkApplication.getInst().getLocationShared()) {
            IQ();
        } else if (this.aHD.anv()) {
            IO();
        } else {
            this.aHD.eP(false);
            if (this.aHB.Je() != null) {
                this.aHB.Je().setLocationViewVisibility(0);
                this.aHB.Je().setLocationInfoViewState(1);
            }
            this.aHD.ant();
        }
    }

    private void IQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bx(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new b(this)).b(com.baidu.tieba.y.cancel, new c(this)).b(getPageContext());
        aVar.re();
    }

    private void IR() {
        if (this.aHB.Je() != null) {
            if (this.aHD.anx()) {
                this.aHB.Je().setLocationViewVisibility(0);
                if (this.aHD.anv()) {
                    this.aHP.a(com.baidu.tieba.tbadkCore.location.d.anq().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.n.isNetOk()) {
                    this.aHB.Je().setLocationInfoViewState(1);
                    this.aHD.ant();
                    return;
                } else {
                    this.aHB.Je().setLocationInfoViewState(0);
                    return;
                }
            }
            this.aHB.Je().setLocationViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        g(true, null);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.aHC.saveInstance(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aHL);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aHI);
        bundle.putSerializable("reply_thread", this.aHJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aHG = true;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aHG = false;
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
        if (this.aHK != null) {
            this.aHK.cancelLoadData();
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    private void initUI() {
        this.aHB = new y(getPageContext());
        BdListView bdListView = this.aHB.getBdListView();
        this.aHA = new ag(getPageContext());
        this.aHA.a(new d(this));
        bdListView.setPullRefresh(this.aHA);
        bdListView.setOnScrollListener(this.aHR);
        bdListView.setOnItemClickListener(new e(this));
        this.aHB.Jh().a(this.aHS);
        this.aHB.setOnActionListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aHJ.getFname());
            antiData.setBlock_forum_id(this.aHJ.getFid());
            antiData.setUser_name(this.aHJ.getAuthor().getUserName());
            antiData.setUser_id(this.aHJ.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(String str) {
        if (this.aHK.IS() == null) {
            WriteData IS = IS();
            IS.setWriteImagesInfo(this.aHL);
            this.aHK.eQ(this.aHL.size() > 0);
            this.aHK.c(IS);
        }
        if (this.aHK.IS() != null) {
            if (this.aHB.Je() != null) {
                this.aHK.IS().setHasLocationData(this.aHB.Je().getLocationInfoViewState() == 2);
            }
            this.aHK.IS().setIsFrsReply(true);
            this.aHK.IS().setContent(this.aHB.Jl());
            VoiceData.VoiceModel audioData = this.aHB.getAudioData();
            this.aHB.Jn();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aHK.IS().setVoice(audioData.getId());
                    this.aHK.IS().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aHK.IS().setVoice(null);
                    this.aHK.IS().setVoiceDuringTime(-1);
                }
            } else {
                this.aHK.IS().setVoice(null);
                this.aHK.IS().setVoiceDuringTime(-1);
            }
            if (this.aHK.anP()) {
                this.aHB.Jk();
            }
        }
    }

    public WriteData IS() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.aHJ.getFid());
        writeData.setForumName(this.aHJ.getFname());
        writeData.setThreadId(this.aHJ.getTid());
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
                            J(intent);
                            return;
                        } else {
                            I(intent);
                            return;
                        }
                    }
                    return;
                case 12004:
                    ArrayList<String> V = com.baidu.tieba.tbadkCore.util.i.V(intent);
                    if (V != null) {
                        this.aHB.v(V);
                        return;
                    }
                    return;
                case 12006:
                    WriteData IS = this.aHK.IS();
                    if (IS != null) {
                        IS.deleteUploadedTempImages();
                    }
                    this.aHK.c((WriteData) null);
                    this.aHK.eQ(false);
                    this.aHB.bK(true);
                    ao.b(this.aHJ.getTid(), (WriteData) null);
                    this.aHB.a(this.aHL, true);
                    this.aHJ.setReply_num(this.aHJ.getReply_num() + 1);
                    this.aHB.Jj();
                    this.aHB.Jg();
                    return;
                case 12012:
                    K(intent);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    IT();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.aHL.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12003:
                default:
                    return;
            }
        }
    }

    private void I(Intent intent) {
        a(intent, true);
    }

    private void J(Intent intent) {
        int size;
        L(intent);
        int size2 = this.aHL.size() - 1;
        if (size2 > -1 && this.aHL != null && this.aHL.getChosedFiles() != null && (size = this.aHL.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.aHL, size2)));
        }
    }

    private void K(Intent intent) {
        a(intent, false);
    }

    private void IT() {
        new g(this).execute(new Void[0]);
    }

    private void L(Intent intent) {
        this.aHI = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aHI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cf = com.baidu.tbadk.core.util.c.cf(str);
                if (cf != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cf);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aHI, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aHL.addChooseFile(imageFileInfo);
            this.aHL.updateQuality();
            this.aHB.a(this.aHL, true);
        }
        if (this.aHB.Je() != null && this.aHL.getChosedFiles() != null && this.aHL.getChosedFiles().size() > 0) {
            this.aHB.Je().ir(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aHL.parseJson(stringExtra);
                this.aHL.updateQuality();
                if (this.aHL.getChosedFiles() != null) {
                    this.aHB.a(this.aHL, z);
                }
            }
            if (this.aHB.Je() != null && this.aHL.getChosedFiles() != null && this.aHL.getChosedFiles().size() > 0) {
                this.aHB.Je().ir(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        ArrayList<FriendFeedThreadData> IY = this.aHB.Jh().IY();
        if (IY != null) {
            Iterator<FriendFeedThreadData> it = IY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FriendFeedThreadData next = it.next();
                if (next == this.aHF) {
                    a(next, i);
                    this.aHF = null;
                    break;
                } else if (next.getId() != null && next.getId().equals(this.aHH)) {
                    a(next, i);
                    this.aHH = null;
                    break;
                }
            }
            this.aHB.Jh().notifyDataSetChanged();
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
            if (this.aHB.Je() != null && this.aHB.Je().isVisible()) {
                IU();
                this.aHB.Jg();
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
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, 0)));
            return;
        }
        if (this.aHJ != friendFeedThreadData && this.aHJ != null) {
            IU();
            this.aHB.fJ(null);
            this.aHL = new WriteImagesInfo();
            this.aHL.setMaxImagesAllowed(10);
            this.aHB.a(this.aHL, true);
            this.aHK.c((WriteData) null);
            this.aHK.eQ(false);
            this.aHB.Jm();
        }
        if (friendFeedThreadData != null) {
            ao.a(friendFeedThreadData.getTid(), this);
        }
        this.aHJ = friendFeedThreadData;
        this.aHB.a(i, friendFeedThreadData, i2);
        IR();
    }

    private void IU() {
        if (this.aHJ != null) {
            WriteData IS = this.aHK.IS();
            if (IS == null) {
                IS = new WriteData(1);
                IS.setThreadId(this.aHJ.getTid());
                IS.setWriteImagesInfo(this.aHL);
            }
            IS.setContent(this.aHB.Jl());
            ao.b(this.aHJ.getTid(), IS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        this.aHB.Jh().reset(z);
        this.aHB.getBdListView().mX();
        this.aHC.setTimeline(null);
        if (z) {
            sendMessage(false);
        } else {
            sendMessage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(boolean z) {
        if (z) {
            this.aHC.s(60, this.aHC.getTimeline());
        } else {
            this.aHC.t(60, this.aHC.getTimeline());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.aHB.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return TextUtils.isEmpty(this.aHC.getTimeline());
    }

    public void initData(Bundle bundle) {
        this.aHC = new com.baidu.tieba.friendFeed.a.a(this);
        this.aHC.setUniqueId(getUniqueId());
        if (bundle != null) {
            this.aHC.initWithBundle(bundle);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.aHC.registerListener(this.mListener);
        this.aHC.registerListener(this.mLoadCacheListener);
        this.aHC.registerListener(this.aHN);
        this.aHT.setUniqueId(getUniqueId());
        this.aHT.registerListener();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aHL = writeImagesInfo;
            }
            this.aHJ = (FriendFeedThreadData) bundle.getSerializable("reply_thread");
            this.aHI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aHL.setMaxImagesAllowed(10);
        this.aHK = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aHK.a(this.aHO);
        this.aHD = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aHD.a(this.aHP);
        this.aHD.a(this.aHQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aHB.onChangeSkinType(i);
        this.aHA.ct(i);
    }

    public void loadMore() {
        if (this.aHB.Jh().IZ()) {
            this.aHC.s(60, this.aHC.getTimeline());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> IV() {
        return this.aHM;
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null && this.aHJ != null && writeData.getThreadId().equals(this.aHJ.getTid())) {
            if (!bd.isEmpty(writeData.getContent())) {
                this.aHB.fJ(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.aHL.size() == 0) {
                this.aHL.copyFrom(writeData.getWriteImagesInfo());
                this.aHB.a(this.aHL, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
