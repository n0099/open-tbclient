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
    private String aHA;
    private FriendFeedThreadData aHB;
    private com.baidu.tieba.tbadkCore.writeModel.a aHC;
    private ag aHs;
    private y aHt;
    private com.baidu.tieba.friendFeed.a.a aHu;
    private com.baidu.tieba.tbadkCore.location.e aHv;
    private FriendFeedThreadData aHx;
    private boolean aHy;
    private String aHz;
    VoiceManager mVoiceManager;
    private boolean aHw = false;
    private WriteImagesInfo aHD = new WriteImagesInfo();
    private final com.baidu.adp.lib.e.b<TbImageView> aHE = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 6);
    private CustomMessageListener aHF = new a(this, 2004004);
    private final com.baidu.tieba.tbadkCore.writeModel.d aHG = new h(this);
    private com.baidu.tieba.tbadkCore.location.j aHH = new i(this);
    private com.baidu.tieba.tbadkCore.location.k aHI = new j(this);
    private final AbsListView.OnScrollListener aHJ = new k(this);
    private final v aHK = new l(this);
    private final ar aHL = new ar(getPageContext(), new m(this));
    private final com.baidu.adp.framework.listener.e mListener = new n(this, 303003);
    private final CustomMessageListener mLoadCacheListener = new o(this, 2001172);

    /* JADX INFO: Access modifiers changed from: private */
    public void II() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void IJ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkApplication.getInst().getLocationShared()) {
            IK();
        } else if (this.aHv.ang()) {
            II();
        } else {
            this.aHv.eR(false);
            if (this.aHt.IY() != null) {
                this.aHt.IY().setLocationViewVisibility(0);
                this.aHt.IY().setLocationInfoViewState(1);
            }
            this.aHv.ane();
        }
    }

    private void IK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bx(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new b(this)).b(com.baidu.tieba.y.cancel, new c(this)).b(getPageContext());
        aVar.re();
    }

    private void IL() {
        if (this.aHt.IY() != null) {
            if (this.aHv.ani()) {
                this.aHt.IY().setLocationViewVisibility(0);
                if (this.aHv.ang()) {
                    this.aHH.a(com.baidu.tieba.tbadkCore.location.d.anb().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.n.isNetOk()) {
                    this.aHt.IY().setLocationInfoViewState(1);
                    this.aHv.ane();
                    return;
                } else {
                    this.aHt.IY().setLocationInfoViewState(0);
                    return;
                }
            }
            this.aHt.IY().setLocationViewVisibility(8);
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
        this.aHu.saveInstance(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aHD);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aHA);
        bundle.putSerializable("reply_thread", this.aHB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aHy = true;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aHy = false;
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
        if (this.aHC != null) {
            this.aHC.cancelLoadData();
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    private void initUI() {
        this.aHt = new y(getPageContext());
        BdListView bdListView = this.aHt.getBdListView();
        this.aHs = new ag(getPageContext());
        this.aHs.a(new d(this));
        bdListView.setPullRefresh(this.aHs);
        bdListView.setOnScrollListener(this.aHJ);
        bdListView.setOnItemClickListener(new e(this));
        this.aHt.Jb().a(this.aHK);
        this.aHt.setOnActionListener(new f(this));
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
            antiData.setBlock_forum_name(this.aHB.getFname());
            antiData.setBlock_forum_id(this.aHB.getFid());
            antiData.setUser_name(this.aHB.getAuthor().getUserName());
            antiData.setUser_id(this.aHB.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        if (this.aHC.IM() == null) {
            WriteData IM = IM();
            IM.setWriteImagesInfo(this.aHD);
            this.aHC.eS(this.aHD.size() > 0);
            this.aHC.c(IM);
        }
        if (this.aHC.IM() != null) {
            if (this.aHt.IY() != null) {
                this.aHC.IM().setHasLocationData(this.aHt.IY().getLocationInfoViewState() == 2);
            }
            this.aHC.IM().setIsFrsReply(true);
            this.aHC.IM().setContent(this.aHt.Jf());
            VoiceData.VoiceModel audioData = this.aHt.getAudioData();
            this.aHt.Jh();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aHC.IM().setVoice(audioData.getId());
                    this.aHC.IM().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aHC.IM().setVoice(null);
                    this.aHC.IM().setVoiceDuringTime(-1);
                }
            } else {
                this.aHC.IM().setVoice(null);
                this.aHC.IM().setVoiceDuringTime(-1);
            }
            if (this.aHC.anA()) {
                this.aHt.Je();
            }
        }
    }

    public WriteData IM() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.aHB.getFid());
        writeData.setForumName(this.aHB.getFname());
        writeData.setThreadId(this.aHB.getTid());
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
                        this.aHt.v(V);
                        return;
                    }
                    return;
                case 12006:
                    WriteData IM = this.aHC.IM();
                    if (IM != null) {
                        IM.deleteUploadedTempImages();
                    }
                    this.aHC.c((WriteData) null);
                    this.aHC.eS(false);
                    this.aHt.bK(true);
                    ao.b(this.aHB.getTid(), (WriteData) null);
                    this.aHt.a(this.aHD, true);
                    this.aHB.setReply_num(this.aHB.getReply_num() + 1);
                    this.aHt.Jd();
                    this.aHt.Ja();
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
                    IN();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.aHD.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
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
        int size2 = this.aHD.size() - 1;
        if (size2 > -1 && this.aHD != null && this.aHD.getChosedFiles() != null && (size = this.aHD.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.aHD, size2)));
        }
    }

    private void K(Intent intent) {
        a(intent, false);
    }

    private void IN() {
        new g(this).execute(new Void[0]);
    }

    private void L(Intent intent) {
        this.aHA = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aHA;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cf = com.baidu.tbadk.core.util.c.cf(str);
                if (cf != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cf);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aHA, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aHD.addChooseFile(imageFileInfo);
            this.aHD.updateQuality();
            this.aHt.a(this.aHD, true);
        }
        if (this.aHt.IY() != null && this.aHD.getChosedFiles() != null && this.aHD.getChosedFiles().size() > 0) {
            this.aHt.IY().io(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aHD.parseJson(stringExtra);
                this.aHD.updateQuality();
                if (this.aHD.getChosedFiles() != null) {
                    this.aHt.a(this.aHD, z);
                }
            }
            if (this.aHt.IY() != null && this.aHD.getChosedFiles() != null && this.aHD.getChosedFiles().size() > 0) {
                this.aHt.IY().io(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        ArrayList<FriendFeedThreadData> IS = this.aHt.Jb().IS();
        if (IS != null) {
            Iterator<FriendFeedThreadData> it = IS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FriendFeedThreadData next = it.next();
                if (next == this.aHx) {
                    a(next, i);
                    this.aHx = null;
                    break;
                } else if (next.getId() != null && next.getId().equals(this.aHz)) {
                    a(next, i);
                    this.aHz = null;
                    break;
                }
            }
            this.aHt.Jb().notifyDataSetChanged();
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
            if (this.aHt.IY() != null && this.aHt.IY().isVisible()) {
                IO();
                this.aHt.Ja();
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
        if (this.aHB != friendFeedThreadData && this.aHB != null) {
            IO();
            this.aHt.fG(null);
            this.aHD = new WriteImagesInfo();
            this.aHD.setMaxImagesAllowed(10);
            this.aHt.a(this.aHD, true);
            this.aHC.c((WriteData) null);
            this.aHC.eS(false);
            this.aHt.Jg();
        }
        if (friendFeedThreadData != null) {
            ao.a(friendFeedThreadData.getTid(), this);
        }
        this.aHB = friendFeedThreadData;
        this.aHt.a(i, friendFeedThreadData, i2);
        IL();
    }

    private void IO() {
        if (this.aHB != null) {
            WriteData IM = this.aHC.IM();
            if (IM == null) {
                IM = new WriteData(1);
                IM.setThreadId(this.aHB.getTid());
                IM.setWriteImagesInfo(this.aHD);
            }
            IM.setContent(this.aHt.Jf());
            ao.b(this.aHB.getTid(), IM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        this.aHt.Jb().reset(z);
        this.aHt.getBdListView().mX();
        this.aHu.setTimeline(null);
        if (z) {
            sendMessage(false);
        } else {
            sendMessage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(boolean z) {
        if (z) {
            this.aHu.s(60, this.aHu.getTimeline());
        } else {
            this.aHu.t(60, this.aHu.getTimeline());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.aHt.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return TextUtils.isEmpty(this.aHu.getTimeline());
    }

    public void initData(Bundle bundle) {
        this.aHu = new com.baidu.tieba.friendFeed.a.a(this);
        this.aHu.setUniqueId(getUniqueId());
        if (bundle != null) {
            this.aHu.initWithBundle(bundle);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.aHu.registerListener(this.mListener);
        this.aHu.registerListener(this.mLoadCacheListener);
        this.aHu.registerListener(this.aHF);
        this.aHL.setUniqueId(getUniqueId());
        this.aHL.registerListener();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aHD = writeImagesInfo;
            }
            this.aHB = (FriendFeedThreadData) bundle.getSerializable("reply_thread");
            this.aHA = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aHD.setMaxImagesAllowed(10);
        this.aHC = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aHC.a(this.aHG);
        this.aHv = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aHv.a(this.aHH);
        this.aHv.a(this.aHI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aHt.onChangeSkinType(i);
        this.aHs.ct(i);
    }

    public void loadMore() {
        if (this.aHt.Jb().IT()) {
            this.aHu.s(60, this.aHu.getTimeline());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> IP() {
        return this.aHE;
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null && this.aHB != null && writeData.getThreadId().equals(this.aHB.getTid())) {
            if (!bd.isEmpty(writeData.getContent())) {
                this.aHt.fG(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.aHD.size() == 0) {
                this.aHD.copyFrom(writeData.getWriteImagesInfo());
                this.aHt.a(this.aHD, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
