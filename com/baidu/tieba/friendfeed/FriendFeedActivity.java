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
    private x aBA;
    private com.baidu.tieba.model.l aBB;
    private com.baidu.tieba.tbadkCore.location.d aBC;
    private FriendFeedThreadData aBE;
    private boolean aBF;
    private String aBG;
    private String aBH;
    private FriendFeedThreadData aBI;
    private com.baidu.tieba.tbadkCore.f.a aBJ;
    private ak aBz;
    VoiceManager mVoiceManager;
    private boolean aBD = false;
    private WriteImagesInfo aqi = new WriteImagesInfo();
    private final com.baidu.adp.lib.e.b<TbImageView> aBK = FrsCommonImageLayout.k(getPageContext().getPageActivity(), 6);
    private CustomMessageListener aBL = new a(this, 2004004);
    private final com.baidu.tieba.tbadkCore.f.b aBM = new h(this);
    private com.baidu.tieba.tbadkCore.location.i aBN = new i(this);
    private com.baidu.tieba.tbadkCore.location.j aBO = new j(this);
    private final AbsListView.OnScrollListener aBP = new k(this);
    private final u aBQ = new l(this);
    private final ao aBR = new ao(getPageContext(), new m(this));
    private final com.baidu.adp.framework.listener.e mListener = new n(this, 303003);
    private final CustomMessageListener mLoadCacheListener = new o(this, 2001172);

    static {
        TbadkApplication.getInst().RegisterIntent(FriendFeedActivityConfig.class, FriendFeedActivity.class);
        com.baidu.tieba.tbadkCore.a.a.a(303003, ResponseFriendFeedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001172, com.baidu.tieba.message.a.a.class);
        com.baidu.tieba.tbadkCore.location.d.aid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Fk() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(z.location_system_permission_prompt);
        } else if (!TbadkApplication.getInst().getLocationShared()) {
            Fl();
        } else if (this.aBC.aic()) {
            Fj();
        } else {
            this.aBC.eE(false);
            if (this.aBA.Fz() != null) {
                this.aBA.Fz().setLocationViewVisibility(0);
                this.aBA.Fz().setLocationInfoViewState(1);
            }
            this.aBC.aia();
        }
    }

    private void Fl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.by(z.location_app_permission_prompt).a(z.isopen, new b(this)).b(z.cancel, new c(this)).b(getPageContext());
        aVar.nQ();
    }

    private void Fm() {
        if (this.aBA.Fz() != null) {
            if (this.aBC.aie()) {
                this.aBA.Fz().setLocationViewVisibility(0);
                if (this.aBC.aic()) {
                    this.aBN.a(com.baidu.tieba.tbadkCore.location.c.ahX().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    this.aBA.Fz().setLocationInfoViewState(1);
                    this.aBC.aia();
                    return;
                } else {
                    this.aBA.Fz().setLocationInfoViewState(0);
                    return;
                }
            }
            this.aBA.Fz().setLocationViewVisibility(8);
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
        this.aBB.saveInstance(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aqi);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBH);
        bundle.putSerializable("reply_thread", this.aBI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aBF = true;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aBF = false;
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
        if (this.aBJ != null) {
            this.aBJ.cancelLoadData();
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    private void initUI() {
        this.aBA = new x(getPageContext());
        BdListView bdListView = this.aBA.getBdListView();
        this.aBz = new ak(getPageContext());
        this.aBz.a(new d(this));
        bdListView.setPullRefresh(this.aBz);
        bdListView.setOnSrollToBottomListener(this);
        bdListView.setOnScrollListener(this.aBP);
        bdListView.setOnItemClickListener(new e(this));
        this.aBA.FC().a(this.aBQ);
        this.aBA.setOnActionListener(new f(this));
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
            antiData.setBlock_forum_name(this.aBI.getFname());
            antiData.setBlock_forum_id(this.aBI.getFid());
            antiData.setUser_name(this.aBI.getAuthor().getUserName());
            antiData.setUser_id(this.aBI.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(String str) {
        if (this.aBJ.Fn() == null) {
            WriteData Fn = Fn();
            Fn.setWriteImagesInfo(this.aqi);
            this.aBJ.eF(this.aqi.size() > 0);
            this.aBJ.c(Fn);
        }
        if (this.aBJ.Fn() != null) {
            if (this.aBA.Fz() != null) {
                this.aBJ.Fn().setHasLocationData(this.aBA.Fz().getLocationInfoViewState() == 2);
            }
            this.aBJ.Fn().setIsFrsReply(true);
            this.aBJ.Fn().setContent(this.aBA.FG());
            VoiceData.VoiceModel audioData = this.aBA.getAudioData();
            this.aBA.FI();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aBJ.Fn().setVoice(audioData.getId());
                    this.aBJ.Fn().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aBJ.Fn().setVoice(null);
                    this.aBJ.Fn().setVoiceDuringTime(-1);
                }
            } else {
                this.aBJ.Fn().setVoice(null);
                this.aBJ.Fn().setVoiceDuringTime(-1);
            }
            if (this.aBJ.aiA()) {
                this.aBA.FF();
            }
        }
    }

    public WriteData Fn() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.aBI.getFid());
        writeData.setForumName(this.aBI.getFname());
        writeData.setThreadId(this.aBI.getTid());
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
                        this.aBA.A(W);
                        return;
                    }
                    return;
                case 12006:
                    WriteData Fn = this.aBJ.Fn();
                    if (Fn != null) {
                        Fn.deleteUploadedTempImages();
                    }
                    this.aBJ.c((WriteData) null);
                    this.aBJ.eF(false);
                    this.aBA.bG(true);
                    al.b(this.aBI.getTid(), (WriteData) null);
                    this.aBA.a(this.aqi, true);
                    this.aBI.setReply_num(this.aBI.getReply_num() + 1);
                    this.aBA.FE();
                    this.aBA.FB();
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
                    Fo();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.aqi.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
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
        int size2 = this.aqi.size() - 1;
        if (size2 > -1 && this.aqi != null && this.aqi.getChosedFiles() != null && (size = this.aqi.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.aqi, size2)));
        }
    }

    private void L(Intent intent) {
        a(intent, false);
    }

    private void Fo() {
        new g(this).execute(new Void[0]);
    }

    private void M(Intent intent) {
        this.aBH = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBH;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bY = com.baidu.tbadk.core.util.d.bY(str);
                if (bY != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.d.b(str, com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.d.h(b, bY);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.aBH, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aqi.addChooseFile(imageFileInfo);
            this.aqi.updateQuality();
            this.aBA.a(this.aqi, true);
        }
        if (this.aBA.Fz() != null && this.aqi.getChosedFiles() != null && this.aqi.getChosedFiles().size() > 0) {
            this.aBA.Fz().hQ(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aqi.parseJson(stringExtra);
                this.aqi.updateQuality();
                if (this.aqi.getChosedFiles() != null) {
                    this.aBA.a(this.aqi, z);
                }
            }
            if (this.aBA.Fz() != null && this.aqi.getChosedFiles() != null && this.aqi.getChosedFiles().size() > 0) {
                this.aBA.Fz().hQ(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(int i) {
        ArrayList<FriendFeedThreadData> Ft = this.aBA.FC().Ft();
        if (Ft != null) {
            Iterator<FriendFeedThreadData> it = Ft.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FriendFeedThreadData next = it.next();
                if (next == this.aBE) {
                    a(next, i);
                    this.aBE = null;
                    break;
                } else if (next.getId() != null && next.getId().equals(this.aBG)) {
                    a(next, i);
                    this.aBG = null;
                    break;
                }
            }
            this.aBA.FC().notifyDataSetChanged();
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
            if (this.aBA.Fz() != null && this.aBA.Fz().isVisible()) {
                Fp();
                this.aBA.FB();
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
        if (this.aBI != friendFeedThreadData && this.aBI != null) {
            Fp();
            this.aBA.fz(null);
            this.aqi = new WriteImagesInfo();
            this.aqi.setMaxImagesAllowed(10);
            this.aBA.a(this.aqi, true);
            this.aBJ.c((WriteData) null);
            this.aBJ.eF(false);
            this.aBA.FH();
        }
        if (friendFeedThreadData != null) {
            al.a(friendFeedThreadData.getTid(), this);
        }
        this.aBI = friendFeedThreadData;
        this.aBA.a(i, friendFeedThreadData, i2);
        Fm();
    }

    private void Fp() {
        if (this.aBI != null) {
            WriteData Fn = this.aBJ.Fn();
            if (Fn == null) {
                Fn = new WriteData(1);
                Fn.setThreadId(this.aBI.getTid());
                Fn.setWriteImagesInfo(this.aqi);
            }
            Fn.setContent(this.aBA.FG());
            al.b(this.aBI.getTid(), Fn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        this.aBA.FC().reset(z);
        this.aBA.getBdListView().jC();
        this.aBB.setTimeline(null);
        if (z) {
            sendMessage(false);
        } else {
            sendMessage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(boolean z) {
        if (z) {
            this.aBB.z(60, this.aBB.getTimeline());
        } else {
            this.aBB.A(60, this.aBB.getTimeline());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.aBA.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return TextUtils.isEmpty(this.aBB.getTimeline());
    }

    public void initData(Bundle bundle) {
        this.aBB = new com.baidu.tieba.model.l(this);
        this.aBB.setUniqueId(getUniqueId());
        if (bundle != null) {
            this.aBB.initWithBundle(bundle);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.aBB.registerListener(this.mListener);
        this.aBB.registerListener(this.mLoadCacheListener);
        this.aBB.registerListener(this.aBL);
        this.aBR.setUniqueId(getUniqueId());
        this.aBR.registerListener();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aqi = writeImagesInfo;
            }
            this.aBI = (FriendFeedThreadData) bundle.getSerializable("reply_thread");
            this.aBH = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aqi.setMaxImagesAllowed(10);
        this.aBJ = new com.baidu.tieba.tbadkCore.f.a(this);
        this.aBJ.a(this.aBM);
        this.aBC = new com.baidu.tieba.tbadkCore.location.d(this);
        this.aBC.a(this.aBN);
        this.aBC.a(this.aBO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aBA.onChangeSkinType(i);
        this.aBz.cs(i);
    }

    private void loadMore() {
        if (this.aBA.FC().Fu()) {
            this.aBB.z(60, this.aBB.getTimeline());
        }
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        loadMore();
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> Fq() {
        return this.aBK;
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.aBI != null && writeData.getThreadId().equals(this.aBI.getTid())) {
            if (!bf.isEmpty(writeData.getContent())) {
                this.aBA.fz(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.aqi.size() == 0) {
                this.aqi.copyFrom(writeData.getWriteImagesInfo());
                this.aBA.a(this.aqi, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
