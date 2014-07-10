package com.baidu.tieba.friendfeed;

import android.app.Activity;
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
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bx;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.aa;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.Cdo;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FriendFeedActivity extends BaseActivity implements View.OnClickListener, x, aa, com.baidu.tieba.util.n, com.baidu.tieba.view.s {
    VoiceManager a;
    private com.baidu.tbadk.core.view.q b;
    private t c;
    private com.baidu.tieba.model.aa d;
    private FriendFeedThreadData f;
    private boolean g;
    private String h;
    private FriendFeedThreadData i;
    private aq j;
    private boolean e = false;
    private WriteImagesInfo k = new WriteImagesInfo();
    private final com.baidu.adp.lib.d.b<TbImageView> l = FrsCommonImageLayout.a(this, 6);
    private final ar m = new a(this);
    private final AbsListView.OnScrollListener n = new d(this);
    private AlertDialog o = null;
    private final q p = new e(this);
    private final Cdo q = new Cdo(new f(this));
    private final com.baidu.adp.framework.listener.b r = new g(this, 303003);
    private final CustomMessageListener s = new h(this, 2001172);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.q.class, FriendFeedActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        f();
        a(true, (String) null);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.d.b(bundle);
        this.a = d();
        if (this.a != null) {
            this.a.onSaveInstanceState(this);
        }
        bundle.putSerializable("write_images", this.k);
        bundle.putString("photo_name", this.h);
        bundle.putSerializable("reply_thread", this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.g = true;
        this.a = d();
        this.a.onResume(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.g = false;
        this.a = d();
        this.a.onPause(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.a = d();
        this.a.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.a = d();
        if (this.a != null) {
            this.a.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.j != null) {
            this.j.cancelLoadData();
        }
        this.a = d();
        this.a.onDestory(this);
    }

    private void f() {
        this.c = new t(this);
        BdListView d = this.c.d();
        this.b = new com.baidu.tbadk.core.view.q(this);
        this.b.a(new i(this));
        d.setPullRefresh(this.b);
        d.setOnSrollToBottomListener(this);
        d.setOnScrollListener(this.n);
        d.setOnItemClickListener(new j(this));
        this.c.c().a(this.p);
        this.c.a(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.a = d();
        this.a.stopPlay();
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public VoiceManager d() {
        if (this.a == null) {
            this.a = VoiceManager.instance();
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.i.getFname());
            antiData.setBlock_forum_id(this.i.getFid());
            antiData.setUser_name(this.i.getAuthor().getUserName());
            antiData.setUser_id(this.i.getAuthor().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.j.a((Context) this, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.o == null) {
            String[] strArr = {getString(y.take_photo), getString(y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(y.operation));
            builder.setItems(strArr, new b(this));
            this.o = builder.create();
            this.o.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.j.a() == null) {
            WriteData c = c();
            c.setWriteImagesInfo(this.k);
            this.j.a(this.k.size() > 0);
            this.j.a(c);
        }
        if (this.j.a() != null) {
            this.j.a().setIsFrsReply(true);
            this.j.a().setContent(this.c.h());
            VoiceData.VoiceModel i = this.c.i();
            this.c.k();
            if (i != null) {
                if (i.getId() != null) {
                    this.j.a().setVoice(i.getId());
                    this.j.a().setVoiceDuringTime(i.duration);
                } else {
                    this.j.a().setVoice(null);
                    this.j.a().setVoiceDuringTime(-1);
                }
            } else {
                this.j.a().setVoice(null);
                this.j.a().setVoiceDuringTime(-1);
            }
            if (this.j.b()) {
                this.c.g();
            }
        }
    }

    public WriteData c() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.i.getFid());
        writeData.setForumName(this.i.getFname());
        writeData.setThreadId(this.i.getTid());
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
                    c(intent);
                    int size2 = this.k.size() - 1;
                    if (size2 > -1 && this.k != null && this.k.getChosedFiles() != null && (size = this.k.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bx(this, 12012, this.k, size2)));
                        return;
                    }
                    return;
                case 12002:
                    a(intent);
                    return;
                case 12004:
                    ArrayList<String> a = com.baidu.tieba.util.i.a(intent);
                    if (a != null) {
                        this.c.a(a);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a2 = this.j.a();
                    if (a2 != null) {
                        a2.deleteUploadedTempImages();
                    }
                    this.j.a((WriteData) null);
                    this.j.a(false);
                    this.c.b(true);
                    com.baidu.tieba.util.m.b(this.i.getTid(), (WriteData) null);
                    this.c.a(this.k, true);
                    this.i.setReply_num(this.i.getReply_num() + 1);
                    this.c.f();
                    this.c.a();
                    return;
                case 12012:
                    b(intent);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    h();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.k.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case 12003:
                default:
                    return;
            }
        }
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        a(intent, false);
    }

    private void h() {
        new c(this).execute(new Void[0]);
    }

    private void c(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.h;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.h.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.h.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                    Bitmap e = com.baidu.tbadk.core.util.h.e(a, b);
                    if (a != e) {
                        a.recycle();
                    }
                    z.a(TbConfig.LOCAL_CAMERA_DIR, this.h, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.k.addChooseFile(imageFileInfo);
            this.k.updateQuality();
            this.c.a(this.k, true);
        }
        if (this.k.getChosedFiles() != null && this.k.getChosedFiles().size() > 0) {
            this.c.a.b(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.k.parseJson(stringExtra);
                this.k.updateQuality();
                if (this.k.getChosedFiles() != null) {
                    this.c.a(this.k, z);
                }
            }
            if (this.k.getChosedFiles() != null && this.k.getChosedFiles().size() > 0) {
                this.c.a.b(23);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        ArrayList<FriendFeedThreadData> a = this.c.c().a();
        if (a != null) {
            Iterator<FriendFeedThreadData> it = a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FriendFeedThreadData next = it.next();
                if (next == this.f) {
                    if (i == 1) {
                        PraiseData praise = next.getPraise();
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
                                next.setPraise(praiseData);
                            } else {
                                next.getPraise().getUser().add(0, metaData);
                                next.getPraise().setNum(next.getPraise().getNum() + 1);
                                next.getPraise().setIsLike(i);
                            }
                        }
                    } else if (next.getPraise() != null) {
                        next.getPraise().setIsLike(i);
                        next.getPraise().setNum(next.getPraise().getNum() - 1);
                        ArrayList<MetaData> user = next.getPraise().getUser();
                        if (user != null) {
                            Iterator<MetaData> it2 = user.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                MetaData next2 = it2.next();
                                if (next2.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                                    next.getPraise().getUser().remove(next2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.c.c().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.c.a.p()) {
                i();
                this.c.a();
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
            LoginActivity.a((Activity) this, getString(y.login_to_use), true, 0);
            return;
        }
        if (this.i != friendFeedThreadData && this.i != null) {
            i();
            this.c.a((String) null);
            this.k = new WriteImagesInfo();
            this.k.setMaxImagesAllowed(10);
            this.c.a(this.k, true);
            this.j.a((WriteData) null);
            this.j.a(false);
            this.c.j();
            com.baidu.tieba.util.m.a(friendFeedThreadData.getTid(), this);
        }
        this.i = friendFeedThreadData;
        this.c.a(i, friendFeedThreadData, i2);
    }

    private void i() {
        if (this.i != null) {
            WriteData a = this.j.a();
            if (a == null) {
                a = new WriteData(1);
                a.setThreadId(this.i.getTid());
                a.setWriteImagesInfo(this.k);
            }
            a.setContent(this.c.h());
            com.baidu.tieba.util.m.b(this.i.getTid(), a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        this.c.c().b(z);
        this.c.d().e();
        this.d.a((String) null);
        if (z) {
            a(false);
        } else {
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.d.a(20, this.d.a());
        } else {
            this.d.b(20, this.d.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (k()) {
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return TextUtils.isEmpty(this.d.a());
    }

    public void a(Bundle bundle) {
        this.d = new com.baidu.tieba.model.aa(this);
        this.d.setUniqueId(getUniqueId());
        if (bundle != null) {
            this.d.a(bundle);
        }
        this.a = d();
        this.a.onCreate(this);
        this.d.registerListener(this.r);
        this.d.registerListener(this.s);
        this.q.setUniqueId(getUniqueId());
        this.q.a();
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            if (writeImagesInfo != null) {
                this.k = writeImagesInfo;
            }
            this.i = (FriendFeedThreadData) bundle.getSerializable("reply_thread");
            this.h = bundle.getString("photo_name");
        }
        this.k.setMaxImagesAllowed(10);
        this.j = new aq();
        this.j.a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.c.a(i);
        this.b.a(i);
    }

    private void l() {
        if (this.c.c().b()) {
            this.d.a(20, this.d.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        l();
    }

    @Override // com.baidu.tieba.view.s
    public com.baidu.adp.lib.d.b<TbImageView> e() {
        return this.l;
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null && this.i != null && writeData.getThreadId().equals(this.i.getTid())) {
            if (!bm.c(writeData.getContent()) && bm.c(this.c.h())) {
                this.c.a(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.k.size() == 0) {
                this.k.copyFrom(writeData.getWriteImagesInfo());
                this.c.a(this.k, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
