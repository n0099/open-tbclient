package com.baidu.tieba.friendfeed;

import android.app.Activity;
import android.app.AlertDialog;
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
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.model.ac;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.model.as;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.view.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FriendFeedActivity extends BaseActivity implements View.OnClickListener, aa, com.baidu.tbadk.core.voice.o, com.baidu.tieba.util.m, com.baidu.tieba.view.q {
    VoiceManager ayo;
    private com.baidu.tbadk.core.view.y ayp;
    private y ayq;
    private ac ayr;
    private com.baidu.tieba.location.d ays;
    private FriendFeedThreadData ayu;
    private boolean ayv;
    private String ayw;
    private String ayx;
    private FriendFeedThreadData ayy;
    private ar ayz;
    private boolean ayt = false;
    private WriteImagesInfo ahS = new WriteImagesInfo();
    private final com.baidu.adp.lib.e.b<TbImageView> ayA = FrsCommonImageLayout.l(this, 6);
    private CustomMessageListener ayB = new a(this, 2004004);
    private final as ayC = new i(this);
    private com.baidu.tieba.location.i ayD = new j(this);
    private com.baidu.tieba.location.j ayE = new k(this);
    private final AbsListView.OnScrollListener ayF = new l(this);
    private AlertDialog ayG = null;
    private final v ayH = new m(this);
    private final df ayI = new df(this, new n(this));
    private final com.baidu.adp.framework.listener.e ayJ = new o(this, 303003);
    private final CustomMessageListener ayK = new p(this, 2001172);

    static {
        TbadkApplication.m251getInst().RegisterIntent(FriendFeedActivityConfig.class, FriendFeedActivity.class);
        ai.a(303003, ResponseFriendFeedMessage.class, false, false);
        ai.b(2001172, com.baidu.tieba.message.a.a.class);
        com.baidu.tieba.location.d.Su();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ew() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
    }

    public void Ex() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this)) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            Ey();
        } else if (this.ays.St()) {
            Ew();
        } else {
            this.ays.dx(false);
            if (this.ayq.EO() != null) {
                this.ayq.EO().setLocationViewVisibility(0);
                this.ayq.EO().setLocationInfoViewState(1);
            }
            this.ays.Sr();
        }
    }

    private void Ey() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new b(this)).b(com.baidu.tieba.y.cancel, new c(this)).kT();
        aVar.kW();
    }

    private void Ez() {
        if (this.ayq.EO() != null) {
            if (this.ays.Sv()) {
                this.ayq.EO().setLocationViewVisibility(0);
                if (this.ays.St()) {
                    this.ayD.a(com.baidu.tieba.location.c.So().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.m.isNetOk()) {
                    this.ayq.EO().setLocationInfoViewState(1);
                    this.ays.Sr();
                    return;
                } else {
                    this.ayq.EO().setLocationInfoViewState(0);
                    return;
                }
            }
            this.ayq.EO().setLocationViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d(bundle);
        initUI();
        c(true, (String) null);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ayr.saveInstance(bundle);
        this.ayo = getVoiceManager();
        if (this.ayo != null) {
            this.ayo.onSaveInstanceState(this);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.ahS);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayx);
        bundle.putSerializable("reply_thread", this.ayy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ayv = true;
        this.ayo = getVoiceManager();
        this.ayo.onResume(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ayv = false;
        this.ayo = getVoiceManager();
        this.ayo.onPause(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ayo = getVoiceManager();
        this.ayo.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ayo = getVoiceManager();
        if (this.ayo != null) {
            this.ayo.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ayz != null) {
            this.ayz.cancelLoadData();
        }
        this.ayo = getVoiceManager();
        this.ayo.onDestory(this);
    }

    private void initUI() {
        this.ayq = new y(this);
        BdListView ER = this.ayq.ER();
        this.ayp = new com.baidu.tbadk.core.view.y(this);
        this.ayp.a(new d(this));
        ER.setPullRefresh(this.ayp);
        ER.setOnSrollToBottomListener(this);
        ER.setOnScrollListener(this.ayF);
        ER.setOnItemClickListener(new e(this));
        this.ayq.EQ().a(this.ayH);
        this.ayq.setOnActionListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EA() {
        this.ayo = getVoiceManager();
        this.ayo.stopPlay();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        if (this.ayo == null) {
            this.ayo = VoiceManager.instance();
        }
        return this.ayo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.ayy.getFname());
            antiData.setBlock_forum_id(this.ayy.getFid());
            antiData.setUser_name(this.ayy.getAuthor().getUserName());
            antiData.setUser_id(this.ayy.getAuthor().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.m.showToast(this, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EB() {
        if (this.ayG == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new g(this));
            this.ayG = builder.create();
            this.ayG.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        if (this.ayz.EC() == null) {
            WriteData EC = EC();
            EC.setWriteImagesInfo(this.ahS);
            this.ayz.dI(this.ahS.size() > 0);
            this.ayz.b(EC);
        }
        if (this.ayz.EC() != null) {
            if (this.ayq.EO() != null) {
                this.ayz.EC().setHasLocationData(this.ayq.EO().getLocationInfoViewState() == 2);
            }
            this.ayz.EC().setIsFrsReply(true);
            this.ayz.EC().setContent(this.ayq.EU());
            VoiceData.VoiceModel audioData = this.ayq.getAudioData();
            this.ayq.BQ();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.ayz.EC().setVoice(audioData.getId());
                    this.ayz.EC().setVoiceDuringTime(audioData.duration);
                } else {
                    this.ayz.EC().setVoice(null);
                    this.ayz.EC().setVoiceDuringTime(-1);
                }
            } else {
                this.ayz.EC().setVoice(null);
                this.ayz.EC().setVoiceDuringTime(-1);
            }
            if (this.ayz.TR()) {
                this.ayq.ET();
            }
        }
    }

    public WriteData EC() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.ayy.getFid());
        writeData.setForumName(this.ayy.getFname());
        writeData.setThreadId(this.ayy.getTid());
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
                    g(intent);
                    int size2 = this.ahS.size() - 1;
                    if (size2 > -1 && this.ahS != null && this.ahS.getChosedFiles() != null && (size = this.ahS.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this, 12012, this.ahS, size2)));
                        return;
                    }
                    return;
                case 12002:
                    e(intent);
                    return;
                case 12004:
                    ArrayList<String> p = com.baidu.tieba.util.i.p(intent);
                    if (p != null) {
                        this.ayq.o(p);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EC = this.ayz.EC();
                    if (EC != null) {
                        EC.deleteUploadedTempImages();
                    }
                    this.ayz.b((WriteData) null);
                    this.ayz.dI(false);
                    this.ayq.bQ(true);
                    com.baidu.tieba.util.l.b(this.ayy.getTid(), (WriteData) null);
                    this.ayq.a(this.ahS, true);
                    this.ayy.setReply_num(this.ayy.getReply_num() + 1);
                    this.ayq.ES();
                    this.ayq.EP();
                    return;
                case 12012:
                    f(intent);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    ED();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.ahS.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12003:
                default:
                    return;
            }
        }
    }

    private void e(Intent intent) {
        a(intent, true);
    }

    private void f(Intent intent) {
        a(intent, false);
    }

    private void ED() {
        new h(this).execute(new Void[0]);
    }

    private void g(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ayx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bl = com.baidu.tbadk.core.util.d.bl(str);
                if (bl != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.n(this)), com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.o(this)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, bl);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ayx, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.ahS.addChooseFile(imageFileInfo);
            this.ahS.updateQuality();
            this.ayq.a(this.ahS, true);
        }
        if (this.ayq.EO() != null && this.ahS.getChosedFiles() != null && this.ahS.getChosedFiles().size() > 0) {
            this.ayq.EO().er(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.ahS.parseJson(stringExtra);
                this.ahS.updateQuality();
                if (this.ahS.getChosedFiles() != null) {
                    this.ayq.a(this.ahS, z);
                }
            }
            if (this.ayq.EO() != null && this.ahS.getChosedFiles() != null && this.ahS.getChosedFiles().size() > 0) {
                this.ayq.EO().er(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(int i) {
        ArrayList<FriendFeedThreadData> EI = this.ayq.EQ().EI();
        if (EI != null) {
            Iterator<FriendFeedThreadData> it = EI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FriendFeedThreadData next = it.next();
                if (next == this.ayu) {
                    a(next, i);
                    this.ayu = null;
                    break;
                } else if (next.getId() != null && next.getId().equals(this.ayw)) {
                    a(next, i);
                    this.ayw = null;
                    break;
                }
            }
            this.ayq.EQ().notifyDataSetChanged();
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
            if (this.ayq.EO() != null && this.ayq.EO().isVisible()) {
                EE();
                this.ayq.EP();
            } else {
                closeActivity();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void a(int i, FriendFeedThreadData friendFeedThreadData, int i2) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 0);
            return;
        }
        if (this.ayy != friendFeedThreadData && this.ayy != null) {
            EE();
            this.ayq.fc(null);
            this.ahS = new WriteImagesInfo();
            this.ahS.setMaxImagesAllowed(10);
            this.ayq.a(this.ahS, true);
            this.ayz.b((WriteData) null);
            this.ayz.dI(false);
            this.ayq.BP();
        }
        if (friendFeedThreadData != null) {
            com.baidu.tieba.util.l.a(friendFeedThreadData.getTid(), this);
        }
        this.ayy = friendFeedThreadData;
        this.ayq.a(i, friendFeedThreadData, i2);
        Ez();
    }

    private void EE() {
        if (this.ayy != null) {
            WriteData EC = this.ayz.EC();
            if (EC == null) {
                EC = new WriteData(1);
                EC.setThreadId(this.ayy.getTid());
                EC.setWriteImagesInfo(this.ahS);
            }
            EC.setContent(this.ayq.EU());
            com.baidu.tieba.util.l.b(this.ayy.getTid(), EC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, String str) {
        this.ayq.EQ().bM(z);
        this.ayq.ER().hO();
        this.ayr.setTimeline(null);
        if (z) {
            bK(false);
        } else {
            bK(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z) {
            this.ayr.p(60, this.ayr.getTimeline());
        } else {
            this.ayr.q(60, this.ayr.getTimeline());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.ayq.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return TextUtils.isEmpty(this.ayr.getTimeline());
    }

    public void d(Bundle bundle) {
        this.ayr = new ac(this);
        this.ayr.setUniqueId(getUniqueId());
        if (bundle != null) {
            this.ayr.initWithBundle(bundle);
        }
        this.ayo = getVoiceManager();
        this.ayo.onCreate(this);
        this.ayr.registerListener(this.ayJ);
        this.ayr.registerListener(this.ayK);
        this.ayr.registerListener(this.ayB);
        this.ayI.setUniqueId(getUniqueId());
        this.ayI.registerListener();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.ahS = writeImagesInfo;
            }
            this.ayy = (FriendFeedThreadData) bundle.getSerializable("reply_thread");
            this.ayx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.ahS.setMaxImagesAllowed(10);
        this.ayz = new ar(this);
        this.ayz.a(this.ayC);
        this.ays = new com.baidu.tieba.location.d(this);
        this.ays.a(this.ayD);
        this.ays.a(this.ayE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ayq.onChangeSkinType(i);
        this.ayp.bM(i);
    }

    private void Eh() {
        if (this.ayq.EQ().EJ()) {
            this.ayr.p(60, this.ayr.getTimeline());
        }
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Eh();
    }

    @Override // com.baidu.tieba.view.q
    public com.baidu.adp.lib.e.b<TbImageView> EF() {
        return this.ayA;
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (writeData != null && this.ayy != null && writeData.getThreadId().equals(this.ayy.getTid())) {
            if (!ay.aA(writeData.getContent())) {
                this.ayq.fc(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.ahS.size() == 0) {
                this.ahS.copyFrom(writeData.getWriteImagesInfo());
                this.ayq.a(this.ahS, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
