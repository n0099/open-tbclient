package com.baidu.tieba.friendfeed;

import android.app.AlertDialog;
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
import com.baidu.tbadk.core.util.ba;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FriendFeedActivity extends BaseActivity<FriendFeedActivity> implements View.OnClickListener, ab, com.baidu.tbadk.core.voice.o, am, com.baidu.tieba.tbadkCore.n {
    private ak aAA;
    private y aAB;
    private com.baidu.tieba.model.l aAC;
    private com.baidu.tieba.tbadkCore.location.d aAD;
    private FriendFeedThreadData aAF;
    private boolean aAG;
    private String aAH;
    private String aAI;
    private FriendFeedThreadData aAJ;
    private com.baidu.tieba.tbadkCore.f.a aAK;
    VoiceManager mVoiceManager;
    private boolean aAE = false;
    private WriteImagesInfo apq = new WriteImagesInfo();
    private final com.baidu.adp.lib.e.b<TbImageView> aAL = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 6);
    private CustomMessageListener aAM = new a(this, 2004004);
    private final com.baidu.tieba.tbadkCore.f.b aAN = new i(this);
    private com.baidu.tieba.tbadkCore.location.i aAO = new j(this);
    private com.baidu.tieba.tbadkCore.location.j aAP = new k(this);
    private final AbsListView.OnScrollListener aAQ = new l(this);
    private AlertDialog aAR = null;
    private final v aAS = new m(this);
    private final ao aAT = new ao(getPageContext(), new n(this));
    private final com.baidu.adp.framework.listener.e mListener = new o(this, 303003);
    private final CustomMessageListener mLoadCacheListener = new p(this, 2001172);

    static {
        TbadkApplication.getInst().RegisterIntent(FriendFeedActivityConfig.class, FriendFeedActivity.class);
        com.baidu.tieba.tbadkCore.a.a.a(303003, ResponseFriendFeedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001172, com.baidu.tieba.message.a.a.class);
        com.baidu.tieba.tbadkCore.location.d.ahE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void ER() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
        } else if (!TbadkApplication.getInst().getLocationShared()) {
            ES();
        } else if (this.aAD.ahD()) {
            EQ();
        } else {
            this.aAD.ex(false);
            if (this.aAB.Fh() != null) {
                this.aAB.Fh().setLocationViewVisibility(0);
                this.aAB.Fh().setLocationInfoViewState(1);
            }
            this.aAD.ahB();
        }
    }

    private void ES() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bt(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new b(this)).b(com.baidu.tieba.z.cancel, new c(this)).b(getPageContext());
        aVar.nU();
    }

    private void ET() {
        if (this.aAB.Fh() != null) {
            if (this.aAD.ahF()) {
                this.aAB.Fh().setLocationViewVisibility(0);
                if (this.aAD.ahD()) {
                    this.aAO.a(com.baidu.tieba.tbadkCore.location.c.ahy().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    this.aAB.Fh().setLocationInfoViewState(1);
                    this.aAD.ahB();
                    return;
                } else {
                    this.aAB.Fh().setLocationInfoViewState(0);
                    return;
                }
            }
            this.aAB.Fh().setLocationViewVisibility(8);
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
        this.aAC.saveInstance(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.apq);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAI);
        bundle.putSerializable("reply_thread", this.aAJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aAG = true;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aAG = false;
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
        if (this.aAK != null) {
            this.aAK.cancelLoadData();
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    private void initUI() {
        this.aAB = new y(getPageContext());
        BdListView bdListView = this.aAB.getBdListView();
        this.aAA = new ak(getPageContext().getPageActivity());
        this.aAA.a(new d(this));
        bdListView.setPullRefresh(this.aAA);
        bdListView.setOnSrollToBottomListener(this);
        bdListView.setOnScrollListener(this.aAQ);
        bdListView.setOnItemClickListener(new e(this));
        this.aAB.Fk().a(this.aAS);
        this.aAB.setOnActionListener(new f(this));
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
            antiData.setBlock_forum_name(this.aAJ.getFname());
            antiData.setBlock_forum_id(this.aAJ.getFid());
            antiData.setUser_name(this.aAJ.getAuthor().getUserName());
            antiData.setUser_id(this.aAJ.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EU() {
        if (this.aAR == null) {
            String[] strArr = {getPageContext().getString(com.baidu.tieba.z.take_photo), getPageContext().getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            builder.setTitle(getPageContext().getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new g(this));
            this.aAR = builder.create();
            this.aAR.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(String str) {
        if (this.aAK.EV() == null) {
            WriteData EV = EV();
            EV.setWriteImagesInfo(this.apq);
            this.aAK.ey(this.apq.size() > 0);
            this.aAK.c(EV);
        }
        if (this.aAK.EV() != null) {
            if (this.aAB.Fh() != null) {
                this.aAK.EV().setHasLocationData(this.aAB.Fh().getLocationInfoViewState() == 2);
            }
            this.aAK.EV().setIsFrsReply(true);
            this.aAK.EV().setContent(this.aAB.Fo());
            VoiceData.VoiceModel audioData = this.aAB.getAudioData();
            this.aAB.Fq();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aAK.EV().setVoice(audioData.getId());
                    this.aAK.EV().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aAK.EV().setVoice(null);
                    this.aAK.EV().setVoiceDuringTime(-1);
                }
            } else {
                this.aAK.EV().setVoice(null);
                this.aAK.EV().setVoiceDuringTime(-1);
            }
            if (this.aAK.aib()) {
                this.aAB.Fn();
            }
        }
    }

    public WriteData EV() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.aAJ.getFid());
        writeData.setForumName(this.aAJ.getFname());
        writeData.setThreadId(this.aAJ.getTid());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    L(intent);
                    int size2 = this.apq.size() - 1;
                    if (size2 > -1 && this.apq != null && this.apq.getChosedFiles() != null && (size = this.apq.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.apq, size2)));
                        return;
                    }
                    return;
                case 12002:
                    J(intent);
                    return;
                case 12004:
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.i.T(intent);
                    if (T != null) {
                        this.aAB.z(T);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EV = this.aAK.EV();
                    if (EV != null) {
                        EV.deleteUploadedTempImages();
                    }
                    this.aAK.c((WriteData) null);
                    this.aAK.ey(false);
                    this.aAB.bD(true);
                    al.b(this.aAJ.getTid(), (WriteData) null);
                    this.aAB.a(this.apq, true);
                    this.aAJ.setReply_num(this.aAJ.getReply_num() + 1);
                    this.aAB.Fm();
                    this.aAB.Fj();
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
                    EW();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.apq.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
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
        a(intent, false);
    }

    private void EW() {
        new h(this).execute(new Void[0]);
    }

    private void L(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cd = com.baidu.tbadk.core.util.d.cd(str);
                if (cd != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, cd);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aAI, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.apq.addChooseFile(imageFileInfo);
            this.apq.updateQuality();
            this.aAB.a(this.apq, true);
        }
        if (this.aAB.Fh() != null && this.apq.getChosedFiles() != null && this.apq.getChosedFiles().size() > 0) {
            this.aAB.Fh().hH(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.apq.parseJson(stringExtra);
                this.apq.updateQuality();
                if (this.apq.getChosedFiles() != null) {
                    this.aAB.a(this.apq, z);
                }
            }
            if (this.aAB.Fh() != null && this.apq.getChosedFiles() != null && this.apq.getChosedFiles().size() > 0) {
                this.aAB.Fh().hH(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(int i) {
        ArrayList<FriendFeedThreadData> Fb = this.aAB.Fk().Fb();
        if (Fb != null) {
            Iterator<FriendFeedThreadData> it = Fb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FriendFeedThreadData next = it.next();
                if (next == this.aAF) {
                    a(next, i);
                    this.aAF = null;
                    break;
                } else if (next.getId() != null && next.getId().equals(this.aAH)) {
                    a(next, i);
                    this.aAH = null;
                    break;
                }
            }
            this.aAB.Fk().notifyDataSetChanged();
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
            if (this.aAB.Fh() != null && this.aAB.Fh().isVisible()) {
                EX();
                this.aAB.Fj();
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
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 0)));
            return;
        }
        if (this.aAJ != friendFeedThreadData && this.aAJ != null) {
            EX();
            this.aAB.fx(null);
            this.apq = new WriteImagesInfo();
            this.apq.setMaxImagesAllowed(10);
            this.aAB.a(this.apq, true);
            this.aAK.c((WriteData) null);
            this.aAK.ey(false);
            this.aAB.Fp();
        }
        if (friendFeedThreadData != null) {
            al.a(friendFeedThreadData.getTid(), this);
        }
        this.aAJ = friendFeedThreadData;
        this.aAB.a(i, friendFeedThreadData, i2);
        ET();
    }

    private void EX() {
        if (this.aAJ != null) {
            WriteData EV = this.aAK.EV();
            if (EV == null) {
                EV = new WriteData(1);
                EV.setThreadId(this.aAJ.getTid());
                EV.setWriteImagesInfo(this.apq);
            }
            EV.setContent(this.aAB.Fo());
            al.b(this.aAJ.getTid(), EV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        this.aAB.Fk().reset(z);
        this.aAB.getBdListView().jK();
        this.aAC.setTimeline(null);
        if (z) {
            sendMessage(false);
        } else {
            sendMessage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(boolean z) {
        if (z) {
            this.aAC.z(60, this.aAC.getTimeline());
        } else {
            this.aAC.A(60, this.aAC.getTimeline());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.aAB.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return TextUtils.isEmpty(this.aAC.getTimeline());
    }

    public void initData(Bundle bundle) {
        this.aAC = new com.baidu.tieba.model.l(this);
        this.aAC.setUniqueId(getUniqueId());
        if (bundle != null) {
            this.aAC.initWithBundle(bundle);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.aAC.registerListener(this.mListener);
        this.aAC.registerListener(this.mLoadCacheListener);
        this.aAC.registerListener(this.aAM);
        this.aAT.setUniqueId(getUniqueId());
        this.aAT.registerListener();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.apq = writeImagesInfo;
            }
            this.aAJ = (FriendFeedThreadData) bundle.getSerializable("reply_thread");
            this.aAI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.apq.setMaxImagesAllowed(10);
        this.aAK = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aAK.a(this.aAN);
        this.aAD = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aAD.a(this.aAO);
        this.aAD.a(this.aAP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aAB.onChangeSkinType(i);
        this.aAA.cl(i);
    }

    private void loadMore() {
        if (this.aAB.Fk().Fc()) {
            this.aAC.z(60, this.aAC.getTimeline());
        }
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        loadMore();
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> EY() {
        return this.aAL;
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.aAJ != null && writeData.getThreadId().equals(this.aAJ.getTid())) {
            if (!ba.isEmpty(writeData.getContent())) {
                this.aAB.fx(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.apq.size() == 0) {
                this.apq.copyFrom(writeData.getWriteImagesInfo());
                this.aAB.a(this.apq, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
