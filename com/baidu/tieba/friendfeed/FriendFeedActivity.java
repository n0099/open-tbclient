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
import com.baidu.tbadk.core.util.az;
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
    private ac ayA;
    private com.baidu.tieba.location.d ayB;
    private FriendFeedThreadData ayD;
    private boolean ayE;
    private String ayF;
    private String ayG;
    private FriendFeedThreadData ayH;
    private ar ayI;
    VoiceManager ayx;
    private com.baidu.tbadk.core.view.y ayy;
    private y ayz;
    private boolean ayC = false;
    private WriteImagesInfo aib = new WriteImagesInfo();
    private final com.baidu.adp.lib.e.b<TbImageView> ayJ = FrsCommonImageLayout.l(this, 6);
    private CustomMessageListener ayK = new a(this, 2004004);
    private final as ayL = new i(this);
    private com.baidu.tieba.location.i ayM = new j(this);
    private com.baidu.tieba.location.j ayN = new k(this);
    private final AbsListView.OnScrollListener ayO = new l(this);
    private AlertDialog ayP = null;
    private final v ayQ = new m(this);
    private final df ayR = new df(this, new n(this));
    private final com.baidu.adp.framework.listener.e ayS = new o(this, 303003);
    private final CustomMessageListener ayT = new p(this, 2001172);

    static {
        TbadkApplication.m251getInst().RegisterIntent(FriendFeedActivityConfig.class, FriendFeedActivity.class);
        ai.a(303003, ResponseFriendFeedMessage.class, false, false);
        ai.b(2001172, com.baidu.tieba.message.a.a.class);
        com.baidu.tieba.location.d.Sx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ey() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
    }

    public void Ez() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this)) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            EA();
        } else if (this.ayB.Sw()) {
            Ey();
        } else {
            this.ayB.dx(false);
            if (this.ayz.EQ() != null) {
                this.ayz.EQ().setLocationViewVisibility(0);
                this.ayz.EQ().setLocationInfoViewState(1);
            }
            this.ayB.Su();
        }
    }

    private void EA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new b(this)).b(com.baidu.tieba.y.cancel, new c(this)).kT();
        aVar.kW();
    }

    private void EB() {
        if (this.ayz.EQ() != null) {
            if (this.ayB.Sy()) {
                this.ayz.EQ().setLocationViewVisibility(0);
                if (this.ayB.Sw()) {
                    this.ayM.a(com.baidu.tieba.location.c.Sr().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.m.isNetOk()) {
                    this.ayz.EQ().setLocationInfoViewState(1);
                    this.ayB.Su();
                    return;
                } else {
                    this.ayz.EQ().setLocationInfoViewState(0);
                    return;
                }
            }
            this.ayz.EQ().setLocationViewVisibility(8);
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
        this.ayA.saveInstance(bundle);
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onSaveInstanceState(this);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.aib);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayG);
        bundle.putSerializable("reply_thread", this.ayH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ayE = true;
        this.ayx = getVoiceManager();
        this.ayx.onResume(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ayE = false;
        this.ayx = getVoiceManager();
        this.ayx.onPause(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ayx = getVoiceManager();
        this.ayx.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ayI != null) {
            this.ayI.cancelLoadData();
        }
        this.ayx = getVoiceManager();
        this.ayx.onDestory(this);
    }

    private void initUI() {
        this.ayz = new y(this);
        BdListView ET = this.ayz.ET();
        this.ayy = new com.baidu.tbadk.core.view.y(this);
        this.ayy.a(new d(this));
        ET.setPullRefresh(this.ayy);
        ET.setOnSrollToBottomListener(this);
        ET.setOnScrollListener(this.ayO);
        ET.setOnItemClickListener(new e(this));
        this.ayz.ES().a(this.ayQ);
        this.ayz.setOnActionListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC() {
        this.ayx = getVoiceManager();
        this.ayx.stopPlay();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        if (this.ayx == null) {
            this.ayx = VoiceManager.instance();
        }
        return this.ayx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.ayH.getFname());
            antiData.setBlock_forum_id(this.ayH.getFid());
            antiData.setUser_name(this.ayH.getAuthor().getUserName());
            antiData.setUser_id(this.ayH.getAuthor().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.m.showToast(this, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ED() {
        if (this.ayP == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new g(this));
            this.ayP = builder.create();
            this.ayP.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        if (this.ayI.EE() == null) {
            WriteData EE = EE();
            EE.setWriteImagesInfo(this.aib);
            this.ayI.dI(this.aib.size() > 0);
            this.ayI.b(EE);
        }
        if (this.ayI.EE() != null) {
            if (this.ayz.EQ() != null) {
                this.ayI.EE().setHasLocationData(this.ayz.EQ().getLocationInfoViewState() == 2);
            }
            this.ayI.EE().setIsFrsReply(true);
            this.ayI.EE().setContent(this.ayz.EW());
            VoiceData.VoiceModel audioData = this.ayz.getAudioData();
            this.ayz.BS();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.ayI.EE().setVoice(audioData.getId());
                    this.ayI.EE().setVoiceDuringTime(audioData.duration);
                } else {
                    this.ayI.EE().setVoice(null);
                    this.ayI.EE().setVoiceDuringTime(-1);
                }
            } else {
                this.ayI.EE().setVoice(null);
                this.ayI.EE().setVoiceDuringTime(-1);
            }
            if (this.ayI.TU()) {
                this.ayz.EV();
            }
        }
    }

    public WriteData EE() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.ayH.getFid());
        writeData.setForumName(this.ayH.getFname());
        writeData.setThreadId(this.ayH.getTid());
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
                    int size2 = this.aib.size() - 1;
                    if (size2 > -1 && this.aib != null && this.aib.getChosedFiles() != null && (size = this.aib.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this, 12012, this.aib, size2)));
                        return;
                    }
                    return;
                case 12002:
                    e(intent);
                    return;
                case 12004:
                    ArrayList<String> p = com.baidu.tieba.util.i.p(intent);
                    if (p != null) {
                        this.ayz.p(p);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EE = this.ayI.EE();
                    if (EE != null) {
                        EE.deleteUploadedTempImages();
                    }
                    this.ayI.b((WriteData) null);
                    this.ayI.dI(false);
                    this.ayz.bQ(true);
                    com.baidu.tieba.util.l.b(this.ayH.getTid(), (WriteData) null);
                    this.ayz.a(this.aib, true);
                    this.ayH.setReply_num(this.ayH.getReply_num() + 1);
                    this.ayz.EU();
                    this.ayz.ER();
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
                    EF();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.aib.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
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

    private void EF() {
        new h(this).execute(new Void[0]);
    }

    private void g(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ayG;
        if (!TextUtils.isEmpty(str)) {
            try {
                int bl = com.baidu.tbadk.core.util.d.bl(str);
                if (bl != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.n(this)), com.baidu.adp.lib.util.m.dip2px(this, com.baidu.adp.lib.util.m.o(this)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, bl);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.ayG, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.aib.addChooseFile(imageFileInfo);
            this.aib.updateQuality();
            this.ayz.a(this.aib, true);
        }
        if (this.ayz.EQ() != null && this.aib.getChosedFiles() != null && this.aib.getChosedFiles().size() > 0) {
            this.ayz.EQ().er(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.aib.parseJson(stringExtra);
                this.aib.updateQuality();
                if (this.aib.getChosedFiles() != null) {
                    this.ayz.a(this.aib, z);
                }
            }
            if (this.ayz.EQ() != null && this.aib.getChosedFiles() != null && this.aib.getChosedFiles().size() > 0) {
                this.ayz.EQ().er(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(int i) {
        ArrayList<FriendFeedThreadData> EK = this.ayz.ES().EK();
        if (EK != null) {
            Iterator<FriendFeedThreadData> it = EK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FriendFeedThreadData next = it.next();
                if (next == this.ayD) {
                    a(next, i);
                    this.ayD = null;
                    break;
                } else if (next.getId() != null && next.getId().equals(this.ayF)) {
                    a(next, i);
                    this.ayF = null;
                    break;
                }
            }
            this.ayz.ES().notifyDataSetChanged();
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
            if (this.ayz.EQ() != null && this.ayz.EQ().isVisible()) {
                EG();
                this.ayz.ER();
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
        if (this.ayH != friendFeedThreadData && this.ayH != null) {
            EG();
            this.ayz.fc(null);
            this.aib = new WriteImagesInfo();
            this.aib.setMaxImagesAllowed(10);
            this.ayz.a(this.aib, true);
            this.ayI.b((WriteData) null);
            this.ayI.dI(false);
            this.ayz.BR();
        }
        if (friendFeedThreadData != null) {
            com.baidu.tieba.util.l.a(friendFeedThreadData.getTid(), this);
        }
        this.ayH = friendFeedThreadData;
        this.ayz.a(i, friendFeedThreadData, i2);
        EB();
    }

    private void EG() {
        if (this.ayH != null) {
            WriteData EE = this.ayI.EE();
            if (EE == null) {
                EE = new WriteData(1);
                EE.setThreadId(this.ayH.getTid());
                EE.setWriteImagesInfo(this.aib);
            }
            EE.setContent(this.ayz.EW());
            com.baidu.tieba.util.l.b(this.ayH.getTid(), EE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, String str) {
        this.ayz.ES().bM(z);
        this.ayz.ET().hO();
        this.ayA.setTimeline(null);
        if (z) {
            bK(false);
        } else {
            bK(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z) {
            this.ayA.p(60, this.ayA.getTimeline());
        } else {
            this.ayA.q(60, this.ayA.getTimeline());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.ayz.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return TextUtils.isEmpty(this.ayA.getTimeline());
    }

    public void d(Bundle bundle) {
        this.ayA = new ac(this);
        this.ayA.setUniqueId(getUniqueId());
        if (bundle != null) {
            this.ayA.initWithBundle(bundle);
        }
        this.ayx = getVoiceManager();
        this.ayx.onCreate(this);
        this.ayA.registerListener(this.ayS);
        this.ayA.registerListener(this.ayT);
        this.ayA.registerListener(this.ayK);
        this.ayR.setUniqueId(getUniqueId());
        this.ayR.registerListener();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            if (writeImagesInfo != null) {
                this.aib = writeImagesInfo;
            }
            this.ayH = (FriendFeedThreadData) bundle.getSerializable("reply_thread");
            this.ayG = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.aib.setMaxImagesAllowed(10);
        this.ayI = new ar(this);
        this.ayI.a(this.ayL);
        this.ayB = new com.baidu.tieba.location.d(this);
        this.ayB.a(this.ayM);
        this.ayB.a(this.ayN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ayz.onChangeSkinType(i);
        this.ayy.bM(i);
    }

    private void Ej() {
        if (this.ayz.ES().EL()) {
            this.ayA.p(60, this.ayA.getTimeline());
        }
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Ej();
    }

    @Override // com.baidu.tieba.view.q
    public com.baidu.adp.lib.e.b<TbImageView> EH() {
        return this.ayJ;
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (writeData != null && this.ayH != null && writeData.getThreadId().equals(this.ayH.getTid())) {
            if (!az.aA(writeData.getContent())) {
                this.ayz.fc(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.aib.size() == 0) {
                this.aib.copyFrom(writeData.getWriteImagesInfo());
                this.ayz.a(this.aib, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
