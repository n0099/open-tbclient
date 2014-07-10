package com.baidu.tieba.im.live.room;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bv;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tieba.im.chat.CommonGroupChatActiviy;
import com.baidu.tieba.im.message.RequestIncrLiveGroupLikeMessage;
import com.baidu.tieba.im.message.RequestJoinLiveGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.RequestSubscribeLiveGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LiveMsglistModel;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LiveRoomChatActivity extends CommonGroupChatActiviy implements com.baidu.tieba.im.live.n {
    private static String O;
    public static boolean b;
    public static String m;
    public boolean n;
    public bp o;
    private LiveRoomChatView p;
    private LiveMsglistModel q;
    private com.baidu.tbadk.core.util.b r;
    private String x;
    private LiveRoomChatActivity y;
    public String a = null;
    private boolean s = false;
    private boolean t = false;
    private String u = null;
    private AlertDialog v = null;
    private boolean w = false;
    private Handler z = null;
    private boolean A = false;
    private int B = -1;
    private com.baidu.adp.framework.listener.b C = new f(this, 103112);
    private final CustomMessageListener D = new q(this, 2001121);
    private final CustomMessageListener E = new aa(this, 2001161);
    private final CustomMessageListener F = new ab(this, 2001170);
    private final CustomMessageListener G = new ac(this, 2001163);
    private final CustomMessageListener H = new ad(this, 2001169);
    private final CustomMessageListener I = new ae(this, 2001166);
    private com.baidu.adp.framework.listener.b J = new af(this, 107108);
    private com.baidu.adp.framework.listener.b K = new ag(this, 107103);
    private final com.baidu.adp.framework.listener.b L = new g(this, 0);
    private final com.baidu.adp.framework.listener.b M = new h(this, 0);
    private final com.baidu.adp.framework.listener.b N = new i(this, 107109);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.ai.class, LiveRoomChatActivity.class);
        m = "";
        O = "http";
    }

    public com.baidu.tbadk.core.util.b w() {
        if (this.r == null) {
            this.r = new com.baidu.tbadk.core.util.b(this);
            this.r.b(true);
        }
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LiveMsglistModel x() {
        if (this.q == null) {
            this.q = (LiveMsglistModel) this.e;
        }
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LiveRoomChatView z() {
        if (this.p == null) {
            this.p = (LiveRoomChatView) this.d;
        }
        return this.p;
    }

    public void y() {
        if (x().r) {
            com.baidu.tieba.im.live.d.b().a(String.valueOf(x().b.groupId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4, boolean z) {
        BdNetUtil.NetworkStateInfo statusInfo = BdNetUtil.getStatusInfo();
        if (statusInfo == BdNetUtil.NetworkStateInfo.UNAVAIL) {
            showToast(com.baidu.tieba.y.neterror);
        } else if (statusInfo != BdNetUtil.NetworkStateInfo.WIFI) {
            if (this.v == null || !this.v.isShowing()) {
                this.v = new AlertDialog.Builder(this).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(x().r ? com.baidu.tieba.y.live_chat_room_nonwifi_prompts_pub : com.baidu.tieba.y.live_chat_room_nonwifi_prompts_play).setPositiveButton(x().r ? com.baidu.tieba.y.live_chat_room_nonwifi_prompts_pub_yes : com.baidu.tieba.y.live_chat_room_nonwifi_prompts_play_yes, new j(this, str, str2, str3, str4, z)).setNegativeButton(x().r ? com.baidu.tieba.y.live_chat_room_nonwifi_prompts_pub_no : com.baidu.tieba.y.live_chat_room_nonwifi_prompts_play_no, new k(this)).create();
                this.v.show();
            }
        } else {
            a(str, str2, str3, str4, z);
        }
    }

    public void a(String str, String str2, String str3, String str4, boolean z) {
        if (com.baidu.tieba.im.live.d.b().g() == -1) {
            this.u = str2;
        } else {
            com.baidu.tieba.im.live.d.b().a(x().r ? x().b.streamId : null, String.valueOf(x().b.groupId), String.valueOf(x().b.deviceId), x().b.playUrl, z);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        if (z().T()) {
            super.b(view, i, i2, j);
            return;
        }
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage a = this.e.a(i2);
                if (a != null && a.getUserInfo() != null && a.getUserInfo().getUserName() != null) {
                    this.d.b(a.getUserInfo().getUserName());
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i == 4) {
            if (z() != null && !z().ah()) {
                z().ak();
                return true;
            }
            boolean z2 = z() != null && z().U() == 3;
            if (x() != null && x().r) {
                z = true;
            }
            if (z || !z2) {
                A();
                return super.onKeyDown(i, keyEvent);
            }
            F();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void u() {
        super.u();
        if (!z().ah()) {
            z().ak();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Intent intent = new Intent();
        if (x() != null) {
            intent.putExtra("subcribed", x().f);
        }
        setResult(-1, intent);
    }

    private void a(ChatMessage chatMessage) {
        com.baidu.tieba.im.e.b.c(this, new l(this, chatMessage));
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void c() {
        GroupData c;
        super.c();
        if ((this.e instanceof LiveMsglistModel) && (c = x().c()) != null) {
            if (c != null) {
                String name = c.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.d.a(name, true);
                }
            }
            com.baidu.tieba.im.i.a(new m(this, c), new n(this, c));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void m() {
        super.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.B = ((LiveRoomChatView) this.d).ai();
        super.onPause();
        if (!this.w && x().b != null && (z().U() == 3 || z().U() == 5 || z().U() == 4 || com.baidu.tieba.im.live.d.b().r() == 2 || com.baidu.tieba.im.live.d.b().r() == 1)) {
            b(com.baidu.tieba.y.live_room_notify);
        }
        b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.baidu.tieba.im.live.p.a().a(this, x().r, i, x().j, x().c(), x().e, x().b.playUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(m);
        if (!TextUtils.isEmpty(m)) {
            com.baidu.tieba.im.model.p.a(m);
        }
        if (this.s) {
            com.baidu.tbadk.core.util.bb.a(this, 20);
        }
        if (this.s && com.baidu.tieba.im.live.d.b().g() == 0 && z().U() == 3) {
            b(x().b.streamId, String.valueOf(x().b.groupId), String.valueOf(x().b.deviceId), x().b.playUrl, false);
        }
        if (this.z == null) {
            this.z = new Handler();
        }
        this.z.postDelayed(new o(this), 100L);
    }

    private void B() {
        if (com.baidu.tieba.im.live.d.b().r() == 1) {
            if (com.baidu.tieba.im.live.d.b().i() == null || !com.baidu.tieba.im.live.d.b().i().equals(String.valueOf(x().c().getGroupId()))) {
                new AlertDialog.Builder(this.y).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.live_check_group).setPositiveButton(com.baidu.tieba.y.cancel, new p(this)).setNegativeButton(com.baidu.tieba.y.confirm, new r(this)).create().show();
                return;
            } else {
                C();
                return;
            }
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        this.q = null;
        this.p = null;
        super.onNewIntent(intent);
        this.y = this;
        x().a(getIntent(), (Bundle) null);
        B();
        z().j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.y = this;
        x().a(getIntent(), bundle);
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        registerListener(this.G);
        registerListener(this.D);
        registerListener(this.E);
        registerListener(this.I);
        registerListener(this.J);
        registerListener(this.K);
        registerListener(this.C);
        registerListener(this.N);
        registerListener(this.H);
        registerListener(this.F);
        com.baidu.tieba.im.live.d.b().c();
        showProgressBar();
        MessageManager.getInstance().registerListener(107105, this.M);
        MessageManager.getInstance().registerListener(107107, this.L);
        D();
        String i = com.baidu.tieba.im.live.d.b().i();
        if (!StringUtils.isNull(i)) {
            if (!i.equals(String.valueOf(x().c().getGroupId()))) {
                com.baidu.tieba.im.live.d.b().s();
            } else if (com.baidu.tieba.im.live.d.b().q() == 3) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).aa().c(true);
                }
                com.baidu.tieba.im.live.d.b().a(this);
                this.x = StringUtils.translateSecondsToString(com.baidu.tieba.im.live.d.b().t());
                z().S().setRecordTime(this.x);
                z().S().a();
            }
        }
        if (this.d != null) {
            this.d.B().setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        RequestJoinLiveGroupMessage requestJoinLiveGroupMessage = new RequestJoinLiveGroupMessage();
        requestJoinLiveGroupMessage.groupId = x().c().getGroupId();
        sendMessage(requestJoinLiveGroupMessage);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        this.d = new LiveRoomChatView(this, this.e.i());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.e instanceof LiveMsglistModel) {
            int i = 0;
            if (x().c() != null) {
                i = x().c().getGroupId();
                this.d.a(x().c().getName(), true);
            }
            this.d.a(x().h(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.M);
        MessageManager.getInstance().unRegisterListener(this.L);
        MessageManager.getInstance().unRegisterListener(this.F);
        super.onDestroy();
        if (this.r != null) {
            this.r.d();
        }
        m = "";
        com.baidu.tieba.im.live.d.b().a((com.baidu.tieba.im.live.n) null);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x00c1: IGET  (r6v12 java.lang.Integer A[REMOVE]) = 
      (wrap: protobuf.LiveGroupInfo : 0x00bf: IGET  (r6v11 protobuf.LiveGroupInfo A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.LiveMsglistModel : 0x00bb: INVOKE  (r6v10 com.baidu.tieba.im.model.LiveMsglistModel A[REMOVE]) = (r20v0 'this' com.baidu.tieba.im.live.room.LiveRoomChatActivity A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.baidu.tieba.im.live.room.LiveRoomChatActivity.x():com.baidu.tieba.im.model.LiveMsglistModel)
     com.baidu.tieba.im.model.LiveMsglistModel.b protobuf.LiveGroupInfo)
     protobuf.LiveGroupInfo.groupId java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x02bd: IGET  (r6v9 java.lang.Integer A[REMOVE]) = 
      (wrap: protobuf.LiveGroupInfo : 0x02bb: IGET  (r6v8 protobuf.LiveGroupInfo A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.LiveMsglistModel : 0x02b7: INVOKE  (r6v7 com.baidu.tieba.im.model.LiveMsglistModel A[REMOVE]) = (r20v0 'this' com.baidu.tieba.im.live.room.LiveRoomChatActivity A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.baidu.tieba.im.live.room.LiveRoomChatActivity.x():com.baidu.tieba.im.model.LiveMsglistModel)
     com.baidu.tieba.im.model.LiveMsglistModel.b protobuf.LiveGroupInfo)
     protobuf.LiveGroupInfo.groupId java.lang.Integer)] */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.B()) {
            A();
        }
        super.onClick(view);
        if (view == z().Z()) {
            z().f(x().f);
        } else if (view == z().aa().b()) {
            z().A();
            if (this.n) {
                z().A();
                this.o = new bp(this, this.y, com.baidu.tieba.z.NewUserDialog);
                this.o.show();
                return;
            }
            showToast(com.baidu.tieba.y.reminder_notice_only_one);
        } else if (view == z().aa().c()) {
            z().A();
            I();
        } else if (view == z().aa().d()) {
            z().A();
            if (x().b != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.af(this, new StringBuilder().append(x().b.groupId).toString())));
            }
        } else if (view == z().aa().e()) {
            z().A();
            TiebaStatic.eventStat(getBaseContext(), "livem_record_bt", "click");
            int q = com.baidu.tieba.im.live.d.b().q();
            if (q == 2) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).aa().c(true);
                }
                showToast(com.baidu.tieba.y.live_chat_room_recordstarted);
                com.baidu.tieba.im.live.d.b().a(this);
                com.baidu.tieba.im.live.d.b().b(com.baidu.tieba.im.live.d.b().i());
                z().S().c();
                z().S().a();
            } else if (q == 3) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).aa().c(false);
                }
                showToast(com.baidu.tieba.y.live_chat_room_recordstopped);
                z().S().b();
                com.baidu.tieba.im.live.d.b().a((com.baidu.tieba.im.live.n) null);
                com.baidu.tieba.im.live.d.b().c(com.baidu.tieba.im.live.d.b().i());
            } else {
                showToast(com.baidu.tieba.y.live_chat_room_recordnotready);
            }
        } else if (view == z().aa().f()) {
            z().A();
            if (x().r) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.am(this.y, x().c().getGroupId())));
            }
        } else if (view == z().aa().g()) {
            z().A();
            G();
        } else if (view == z().aa().h()) {
            if (x() != null && x().b != null && x().b.groupId != null) {
                RequestSubscribeLiveGroupMessage requestSubscribeLiveGroupMessage = new RequestSubscribeLiveGroupMessage();
                requestSubscribeLiveGroupMessage.setGroupId(x().b.groupId.intValue());
                if (x().f) {
                    requestSubscribeLiveGroupMessage.setSubscribe(0);
                } else {
                    requestSubscribeLiveGroupMessage.setSubscribe(1);
                }
                MessageManager.getInstance().sendMessage(requestSubscribeLiveGroupMessage);
            }
        } else if (view == z().aa().i()) {
            z().A();
            if (x() != null && x().b != null && x().b.groupId != null) {
                I();
            }
        } else if (view == z().aa().j()) {
            z().A();
            if (x().b != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.af(this, new StringBuilder().append(x().b.groupId).toString())));
            }
        } else if (view == z().aa().k()) {
            z().A();
            if (x().b != null) {
                TiebaStatic.eventStat(getBaseContext(), "livem_brief", "click");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ak(this, x().b.groupId.intValue(), x().b.publisherId.intValue(), x().b.publisherName)));
            }
        } else if (view == z().aa().l()) {
            z().A();
            G();
        } else if (view == z().ac()) {
            z().aj();
        } else if (view == z().ad() || view == z().S().getHeaderImage()) {
            if (!com.baidu.adp.lib.util.j.c()) {
                showToast(com.baidu.tieba.y.neterror);
            } else if (x().r && x().b != null) {
                z().d(5);
                y();
            }
        } else if (view == z().ae() || view == z().S().getAnchorImg() || view == z().S().getLiveStopView() || view == z().S().getLiveStopHost()) {
            if (x().r && x().b != null) {
                this.t = view == z().S().getAnchorImg() || (view == z().ae() && z().S().getAnchorImg().isShown());
                BdNetUtil.NetworkStateInfo statusInfo = BdNetUtil.getStatusInfo();
                if (statusInfo == BdNetUtil.NetworkStateInfo.UNAVAIL) {
                    showToast(com.baidu.tieba.y.neterror);
                } else if (statusInfo != BdNetUtil.NetworkStateInfo.WIFI) {
                    if (this.v == null || !this.v.isShowing()) {
                        this.v = new AlertDialog.Builder(this).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.live_chat_room_nonwifi_prompts_pub).setPositiveButton(com.baidu.tieba.y.live_chat_room_nonwifi_prompts_pub_yes, new s(this)).setNegativeButton(com.baidu.tieba.y.live_chat_room_nonwifi_prompts_pub_no, new t(this)).create();
                        this.v.show();
                    }
                } else {
                    E();
                }
            }
        } else if (view == z().X().getForcastBtn()) {
            bv bvVar = new bv(this, 0, String.valueOf(x().b.forumId), x().e, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            bvVar.a(x().b.groupId.intValue(), x().m, x().j, x().h, x().i, x().b.publisherName, x().l, x().k);
            com.baidu.tbadk.core.f.a(this.y, "pub_notice_bt");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bvVar));
        } else if (z().X().getLiveRoomCloseBtn() == view) {
            z().X().setVisibility(8);
        } else if (z().S().getSettingButton() == view || z().S().getNoteLayout() == view) {
            if (x().r) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.am(this.y, x().c().getGroupId())));
            }
        } else if (z().S().getmLiveRoomLike() == view) {
            if (z().S().d() && x().b != null) {
                RequestIncrLiveGroupLikeMessage requestIncrLiveGroupLikeMessage = new RequestIncrLiveGroupLikeMessage();
                requestIncrLiveGroupLikeMessage.groupId = x().b.groupId.intValue();
                if (z().S().getIsLike() == 1) {
                    requestIncrLiveGroupLikeMessage.type = 2;
                } else {
                    requestIncrLiveGroupLikeMessage.type = 1;
                }
                sendMessage(requestIncrLiveGroupLikeMessage);
            }
        } else if (z().Y().getRoot() == view && x().b != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ag(this, x().b.name, x().b.groupId.intValue(), x().i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.t) {
            ImageView anchorImg = z().S().getAnchorImg();
            anchorImg.clearAnimation();
            anchorImg.setBackgroundDrawable(null);
            anchorImg.setImageResource(com.baidu.tieba.p.counter_animation);
            anchorImg.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.live_animation_scale));
            ((AnimationDrawable) anchorImg.getDrawable()).start();
            this.A = true;
            if (this.z == null) {
                this.z = new Handler();
            }
            this.z.postDelayed(new u(this), 3000L);
        } else if (!this.A) {
            z().d(3);
            a(x().b.streamId, String.valueOf(x().b.groupId), String.valueOf(x().b.deviceId), x().b.playUrl, false);
        }
    }

    private void F() {
        new AlertDialog.Builder(this.y).setTitle("").setIcon((Drawable) null).setCancelable(true).setMessage(com.baidu.tieba.y.live_room_dialog_back_info).setPositiveButton(com.baidu.tieba.y.live_room_dialog_back_no, new v(this)).setNegativeButton(com.baidu.tieba.y.live_room_dialog_back_yes, new w(this)).create().show();
    }

    private void G() {
        new AlertDialog.Builder(this.y).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.live_exit_group).setPositiveButton(com.baidu.tieba.y.cancel, new x(this)).setNegativeButton(com.baidu.tieba.y.confirm, new y(this)).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        LivePlayingStatusMgr.a().d();
        this.w = true;
        com.baidu.tieba.im.live.d.b().s();
        if (x().b == null) {
            finish();
            return;
        }
        showProgressBar();
        A();
        RequestRemoveMembersMessage requestRemoveMembersMessage = new RequestRemoveMembersMessage();
        requestRemoveMembersMessage.setGroupId(x().b.groupId.intValue());
        requestRemoveMembersMessage.setUserIds(TbadkApplication.getCurrentAccount());
        sendMessage(requestRemoveMembersMessage);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean c(Bundle bundle) {
        try {
            this.e = new LiveMsglistModel(this);
            this.e.setLoadDataCallBack(this.l);
            if (bundle != null) {
                a(bundle);
            } else {
                k();
            }
            return l();
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean a(com.baidu.tieba.im.chat.bv bvVar) {
        return true;
    }

    private void I() {
        if (this.e instanceof LiveMsglistModel) {
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.a = MessageFormat.format(getString(com.baidu.tieba.y.im_share_title), x().j);
            hVar.b = MessageFormat.format(getString(com.baidu.tieba.y.im_live_share_content), x().j);
            hVar.c = String.valueOf(com.baidu.tbadk.k.h) + x().b.groupId;
            try {
                hVar.d = Uri.parse(String.valueOf(TbConfig.PHOTO_BIG_ADDRESS) + x().b.publisherPortrait);
            } catch (Throwable th) {
            }
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
            dVar.a(false);
            dVar.a(hVar, true);
            SparseArray<String> sparseArray = new SparseArray<>(7);
            sparseArray.put(5, "livem_to_qq");
            sparseArray.put(4, "livem_to_qzone");
            sparseArray.put(7, "livem_to_renren");
            sparseArray.put(6, "livem_to_sina");
            sparseArray.put(3, "livem_to_weixin");
            sparseArray.put(2, "livem_to_friend");
            dVar.a(sparseArray);
            dVar.a(3, a(x().j, x().b.groupId.intValue(), String.valueOf(TbConfig.PHOTO_BIG_ADDRESS) + x().b.publisherPortrait), true);
            dVar.a();
        }
    }

    private com.baidu.tbadk.coreExtra.share.h a(String str, int i, String str2) {
        com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
        hVar.a = MessageFormat.format(getString(com.baidu.tieba.y.im_share_title), str);
        hVar.b = MessageFormat.format(getString(com.baidu.tieba.y.im_live_share_content), str, String.valueOf(i));
        hVar.c = String.valueOf(com.baidu.tbadk.k.h) + i;
        if (str2 != null) {
            if (!str2.equals("")) {
                if (str2.startsWith(O)) {
                    hVar.d = Uri.parse(str2);
                } else {
                    hVar.a(com.baidu.tbadk.core.util.z.c(null, TbConfig.GROUP_HEAD_FILE));
                }
                return hVar;
            }
        }
        hVar.a(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.u.icon));
        return hVar;
    }

    @Override // com.baidu.tieba.im.live.n
    public void a(int i) {
        if (i > 14340) {
            showToast("");
        }
        this.x = StringUtils.translateSecondsToString(i);
        runOnUiThread(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public String[] a(int i, boolean z) {
        boolean T = z().T();
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(getString(com.baidu.tieba.y.operate_copy));
                if (!z && !T) {
                    arrayList.add(getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.y.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.y.msg_mute));
                    break;
                }
                break;
            case 4:
                if (!z && !T) {
                    arrayList.add(getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.y.msg_img_save));
                arrayList.add(getString(com.baidu.tieba.y.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.y.msg_mute));
                    break;
                }
                break;
            case 5:
                arrayList.add(TbadkApplication.m252getInst().isHeadsetModeOn() ? getString(com.baidu.tieba.y.group_close_receiver) : getString(com.baidu.tieba.y.group_open_receiver));
                if (!z && !T) {
                    arrayList.add(getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.y.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.y.msg_mute));
                    break;
                }
                break;
            case 7:
                if (!z && !T) {
                    arrayList.add(getString(com.baidu.tieba.y.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.y.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.y.msg_mute));
                    break;
                }
                break;
            case 8:
                arrayList.add(getString(com.baidu.tieba.y.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void a(int i, String str) {
        ChatMessage a = this.e.a(i);
        if (str.equals(getString(com.baidu.tieba.y.msg_mute))) {
            a(a);
        } else {
            super.a(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && (i == 12010 || i == 12009)) {
            z().ak();
        }
        if (intent != null && i2 == 10) {
            String stringExtra = intent.getStringExtra("name");
            String stringExtra2 = intent.getStringExtra("intro");
            String stringExtra3 = intent.getStringExtra("portraitId");
            z().d(stringExtra);
            z().e(stringExtra2);
            z().g(stringExtra3);
        }
    }

    private boolean a(boolean z) {
        return x().r && !z;
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    protected void b(Bundle bundle) {
        super.b(bundle);
        J();
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    protected void a(Intent intent) {
        super.a(intent);
        J();
    }

    private void J() {
        GroupData c = x().c();
        if (c != null) {
            m = String.valueOf(c.getGroupId());
        } else {
            m = "";
        }
    }
}
