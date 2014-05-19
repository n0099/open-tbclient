package com.baidu.tieba.im.live.room;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.LocalViewSize;
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
public class LiveRoomChatActivity extends CommonGroupChatActiviy implements com.baidu.tieba.im.live.k {
    private static String N;
    private static String O;
    public boolean n;
    public bo o;
    private LiveRoomChatView p;
    private LiveMsglistModel q;
    private com.baidu.tbadk.core.util.b r;
    private String w;
    private LiveRoomChatActivity x;
    public String m = null;
    private boolean s = false;
    private boolean t = false;
    private AlertDialog u = null;
    private boolean v = false;
    private Handler y = null;
    private boolean z = false;
    private int A = -1;
    private com.baidu.adp.framework.listener.b B = new g(this, MessageTypes.CMD_REMOVE_MEMBERS);
    private final CustomMessageListener C = new r(this, MessageTypes.CMD_NETWORK_CHANGE);
    private final CustomMessageListener D = new z(this, MessageTypes.CMD_LIVE_STATUS_CHANGE);
    private final CustomMessageListener E = new aa(this, MessageTypes.CMD_LIVE_PUBLISH_SAY);
    private final CustomMessageListener F = new ab(this, MessageTypes.CMD_LIVE_ERROR);
    private final CustomMessageListener G = new ac(this, MessageTypes.CMD_LIVE_USER_MUTE);
    private final CustomMessageListener H = new ad(this, MessageTypes.CMD_LIVE_CHAT_ROOM_EVENT);
    private com.baidu.adp.framework.listener.b I = new ae(this, MessageTypes.CMD_INCR_LIVE_GROUP_LIKE);
    private com.baidu.adp.framework.listener.b J = new af(this, MessageTypes.CMD_JOIN_LIVE_GROUP);
    private final com.baidu.adp.framework.listener.b K = new h(this, 0);
    private final com.baidu.adp.framework.listener.b L = new i(this, 0);
    private final com.baidu.adp.framework.listener.b M = new j(this, MessageTypes.CMD_LIVE_GROUP_OWNER_GAG);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.ae.class, LiveRoomChatActivity.class);
        N = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/p/groupShareImg?group_id=";
        O = "http";
    }

    public com.baidu.tbadk.core.util.b w() {
        if (this.r == null) {
            this.r = new com.baidu.tbadk.core.util.b(this);
            this.r.d(true);
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
            com.baidu.tieba.im.live.b.b().a(String.valueOf(x().b.groupId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4, boolean z) {
        BdNetUtil.NetworkStateInfo a = BdNetUtil.a();
        if (a == BdNetUtil.NetworkStateInfo.UNAVAIL) {
            showToast(com.baidu.tieba.u.neterror);
        } else if (a != BdNetUtil.NetworkStateInfo.WIFI) {
            if (this.u == null || !this.u.isShowing()) {
                this.u = new AlertDialog.Builder(this).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(x().r ? com.baidu.tieba.u.live_chat_room_nonwifi_prompts_pub : com.baidu.tieba.u.live_chat_room_nonwifi_prompts_play).setPositiveButton(x().r ? com.baidu.tieba.u.live_chat_room_nonwifi_prompts_pub_yes : com.baidu.tieba.u.live_chat_room_nonwifi_prompts_play_yes, new k(this, str, str2, str3, str4, z)).setNegativeButton(x().r ? com.baidu.tieba.u.live_chat_room_nonwifi_prompts_pub_no : com.baidu.tieba.u.live_chat_room_nonwifi_prompts_play_no, new l(this)).create();
                this.u.show();
            }
        } else {
            BdLog.d("checkNetworkThenPlayOrRecord groupId =" + str2);
            a(str, str2, str3, str4, z);
        }
    }

    public void a(String str, String str2, String str3, String str4, boolean z) {
        com.baidu.tieba.im.live.b.b().a(x().r ? x().b.streamId : null, String.valueOf(x().b.groupId), String.valueOf(x().b.deviceId), x().b.playUrl, z);
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.dd, com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        if (z().R()) {
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

    @Override // com.baidu.tieba.im.chat.dd, com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!z().af()) {
                z().ai();
                return false;
            }
            A();
            return super.onKeyDown(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dd
    public void u() {
        super.u();
        if (!z().af()) {
            z().ai();
        }
    }

    private void A() {
        Intent intent = new Intent();
        intent.putExtra("subcribed", x().f);
        setResult(-1, intent);
    }

    private void a(ChatMessage chatMessage) {
        com.baidu.tieba.im.f.b.c(this, new m(this, chatMessage));
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void c() {
        GroupData b;
        super.c();
        if ((this.e instanceof LiveMsglistModel) && (b = x().b()) != null) {
            if (b != null) {
                String name = b.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.d.a(name, true);
                }
            }
            com.baidu.tieba.im.i.a(new n(this, b), new o(this, b));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void m() {
        super.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dd, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.A = ((LiveRoomChatView) this.d).ag();
        super.onPause();
        if (!this.v && x().b != null && (z().S() == 3 || z().S() == 5 || z().S() == 4)) {
            b(com.baidu.tieba.u.live_room_notify);
        }
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        try {
            Notification notification = new Notification(com.baidu.tieba.q.icon, x().j, System.currentTimeMillis());
            notification.flags = 34;
            Intent intent = new Intent(this, LiveRoomChatActivity.class);
            intent.setFlags(335544320);
            intent.putExtra("gid", x().b().getGroupId());
            intent.putExtra("group", x().b());
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, x().e);
            notification.setLatestEventInfo(this, x().j, getResources().getString(i), PendingIntent.getActivity(this, com.baidu.tieba.u.app_name, intent, 134217728));
            ((NotificationManager) getSystemService("notification")).notify(20, notification);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dd, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(b);
        if (!TextUtils.isEmpty(b)) {
            com.baidu.tieba.im.model.r.a(b);
        }
        try {
            if (this.s) {
                ((NotificationManager) getSystemService("notification")).cancel(20);
            }
        } catch (Exception e) {
        }
        if (this.s && com.baidu.tieba.im.live.b.b().g() == 0 && z().S() == 3) {
            b(x().b.streamId, String.valueOf(x().b.groupId), String.valueOf(x().b.deviceId), x().b.playUrl, false);
        }
        if (this.y == null) {
            this.y = new Handler();
        }
        this.y.postDelayed(new p(this), 100L);
    }

    private void B() {
        if (com.baidu.tieba.im.live.b.b().q() == 1) {
            if (com.baidu.tieba.im.live.b.b().i() == null || !com.baidu.tieba.im.live.b.b().i().equals(String.valueOf(x().b().getGroupId()))) {
                new AlertDialog.Builder(this.x).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.u.live_check_group).setPositiveButton(com.baidu.tieba.u.cancel, new q(this)).setNegativeButton(com.baidu.tieba.u.confirm, new s(this)).create().show();
                return;
            } else {
                C();
                return;
            }
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dd, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.q = null;
        this.p = null;
        this.x = this;
        x().a(getIntent(), (Bundle) null);
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dd, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x = this;
        x().a(getIntent(), bundle);
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        registerListener(this.F);
        registerListener(this.C);
        registerListener(this.D);
        registerListener(this.H);
        registerListener(this.I);
        registerListener(this.J);
        registerListener(this.B);
        registerListener(this.M);
        registerListener(this.G);
        registerListener(this.E);
        com.baidu.tieba.im.live.b.b().c();
        showProgressBar();
        MessageManager.getInstance().registerListener(MessageTypes.CMD_SUBSCRIBE_LIVE_GROUP, this.L);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_SEND_FORE_NOTICE, this.K);
        D();
        String i = com.baidu.tieba.im.live.b.b().i();
        if (!StringUtils.isNull(i)) {
            if (!i.equals(String.valueOf(x().b().getGroupId()))) {
                BdLog.d("initActivity not my live");
                com.baidu.tieba.im.live.b.b().r();
            } else if (com.baidu.tieba.im.live.b.b().p() == 3) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).Y().c(true);
                }
                com.baidu.tieba.im.live.b.b().a(this);
                this.w = StringUtils.translateSecondsToString(com.baidu.tieba.im.live.b.b().s());
                z().Q().setRecordTime(this.w);
                z().Q().a();
            }
        }
        if (this.d != null) {
            this.d.A().setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        RequestJoinLiveGroupMessage requestJoinLiveGroupMessage = new RequestJoinLiveGroupMessage();
        requestJoinLiveGroupMessage.groupId = x().b().getGroupId();
        sendMessage(requestJoinLiveGroupMessage);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        this.d = new LiveRoomChatView(this, this.e.i());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.e instanceof LiveMsglistModel) {
            int i = 0;
            if (x().b() != null) {
                i = x().b().getGroupId();
                this.d.a(x().b().getName(), true);
            }
            this.d.a(x().h(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.dd, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.L);
        MessageManager.getInstance().unRegisterListener(this.K);
        MessageManager.getInstance().unRegisterListener(this.E);
        super.onDestroy();
        if (this.r != null) {
            this.r.d();
        }
        com.baidu.tieba.im.live.b.b().a((com.baidu.tieba.im.live.k) null);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x00c1: IGET  (r6v12 java.lang.Integer A[REMOVE]) = 
      (wrap: protobuf.LiveGroupInfo : 0x00bf: IGET  (r6v11 protobuf.LiveGroupInfo A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.LiveMsglistModel : 0x00bb: INVOKE  (r6v10 com.baidu.tieba.im.model.LiveMsglistModel A[REMOVE]) = (r19v0 'this' com.baidu.tieba.im.live.room.LiveRoomChatActivity A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.baidu.tieba.im.live.room.LiveRoomChatActivity.x():com.baidu.tieba.im.model.LiveMsglistModel)
     com.baidu.tieba.im.model.LiveMsglistModel.b protobuf.LiveGroupInfo)
     protobuf.LiveGroupInfo.groupId java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x02bd: IGET  (r6v9 java.lang.Integer A[REMOVE]) = 
      (wrap: protobuf.LiveGroupInfo : 0x02bb: IGET  (r6v8 protobuf.LiveGroupInfo A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.LiveMsglistModel : 0x02b7: INVOKE  (r6v7 com.baidu.tieba.im.model.LiveMsglistModel A[REMOVE]) = (r19v0 'this' com.baidu.tieba.im.live.room.LiveRoomChatActivity A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.baidu.tieba.im.live.room.LiveRoomChatActivity.x():com.baidu.tieba.im.model.LiveMsglistModel)
     com.baidu.tieba.im.model.LiveMsglistModel.b protobuf.LiveGroupInfo)
     protobuf.LiveGroupInfo.groupId java.lang.Integer)] */
    @Override // com.baidu.tieba.im.chat.dd, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.A()) {
            A();
        }
        super.onClick(view);
        if (view == z().X()) {
            z().f(x().f);
        } else if (view == z().Y().b()) {
            z().z();
            if (this.n) {
                z().z();
                this.o = new bo(this, this.x, com.baidu.tieba.v.NewUserDialog);
                this.o.show();
                return;
            }
            showToast(com.baidu.tieba.u.reminder_notice_only_one);
        } else if (view == z().Y().c()) {
            z().z();
            H();
        } else if (view == z().Y().d()) {
            z().z();
            if (x().b != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ab(this, new StringBuilder().append(x().b.groupId).toString())));
            }
        } else if (view == z().Y().e()) {
            z().z();
            TiebaStatic.eventStat(getBaseContext(), "livem_record_bt", "click");
            int p = com.baidu.tieba.im.live.b.b().p();
            if (p == 2) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).Y().c(true);
                }
                showToast(com.baidu.tieba.u.live_chat_room_recordstarted);
                com.baidu.tieba.im.live.b.b().a(this);
                com.baidu.tieba.im.live.b.b().b(com.baidu.tieba.im.live.b.b().i());
                z().Q().c();
                z().Q().a();
            } else if (p == 3) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).Y().c(false);
                }
                showToast(com.baidu.tieba.u.live_chat_room_recordstopped);
                z().Q().b();
                com.baidu.tieba.im.live.b.b().a((com.baidu.tieba.im.live.k) null);
                com.baidu.tieba.im.live.b.b().c(com.baidu.tieba.im.live.b.b().i());
            } else {
                showToast(com.baidu.tieba.u.live_chat_room_recordnotready);
            }
        } else if (view == z().Y().f()) {
            z().z();
            if (x().r) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ai(this.x, x().b().getGroupId())));
            }
        } else if (view == z().Y().g()) {
            z().z();
            F();
        } else if (view == z().Y().h()) {
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
        } else if (view == z().Y().i()) {
            z().z();
            if (x() != null && x().b != null && x().b.groupId != null) {
                H();
            }
        } else if (view == z().Y().j()) {
            z().z();
            if (x().b != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ab(this, new StringBuilder().append(x().b.groupId).toString())));
            }
        } else if (view == z().Y().k()) {
            z().z();
            if (x().b != null) {
                TiebaStatic.eventStat(getBaseContext(), "livem_brief", "click");
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ag(this, x().b.groupId.intValue(), x().b.publisherId.intValue(), x().b.publisherName)));
            }
        } else if (view == z().Y().l()) {
            z().z();
            F();
        } else if (view == z().aa()) {
            z().ah();
        } else if (view == z().ab() || view == z().Q().getHeaderImage()) {
            if (!com.baidu.adp.lib.util.h.d()) {
                showToast(com.baidu.tieba.u.neterror);
            } else if (x().r && x().b != null) {
                z().d(5);
                y();
            }
        } else if (view == z().ac() || view == z().Q().getAnchorImg() || view == z().Q().getLiveStopView() || view == z().Q().getLiveStopHost()) {
            if (x().r && x().b != null) {
                this.t = view == z().Q().getAnchorImg() || (view == z().ac() && z().Q().getAnchorImg().isShown());
                BdNetUtil.NetworkStateInfo a = BdNetUtil.a();
                if (a == BdNetUtil.NetworkStateInfo.UNAVAIL) {
                    showToast(com.baidu.tieba.u.neterror);
                } else if (a != BdNetUtil.NetworkStateInfo.WIFI) {
                    if (this.u == null || !this.u.isShowing()) {
                        this.u = new AlertDialog.Builder(this).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.u.live_chat_room_nonwifi_prompts_pub).setPositiveButton(com.baidu.tieba.u.live_chat_room_nonwifi_prompts_pub_yes, new t(this)).setNegativeButton(com.baidu.tieba.u.live_chat_room_nonwifi_prompts_pub_no, new u(this)).create();
                        this.u.show();
                    }
                } else {
                    E();
                }
            }
        } else if (view == z().V().getForcastBtn()) {
            com.baidu.tbadk.core.atomData.bh bhVar = new com.baidu.tbadk.core.atomData.bh(this, 0, String.valueOf(x().b.forumId), x().e, null, null, 0, null, 13003, false, false, null, false, false, null, null, null);
            bhVar.a(x().b.groupId.intValue(), x().m, x().j, x().h, x().i, x().b.publisherName, x().l, x().k);
            com.baidu.tbadk.core.g.a(this.x, "pub_notice_bt");
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, bhVar));
        } else if (z().V().getLiveRoomCloseBtn() == view) {
            z().V().setVisibility(8);
        } else if (z().Q().getSettingButton() == view || z().Q().getNoteLayout() == view) {
            if (x().r) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ai(this.x, x().b().getGroupId())));
            }
        } else if (z().Q().getmLiveRoomLike() == view) {
            if (z().Q().d() && x().b != null) {
                RequestIncrLiveGroupLikeMessage requestIncrLiveGroupLikeMessage = new RequestIncrLiveGroupLikeMessage();
                requestIncrLiveGroupLikeMessage.groupId = x().b.groupId.intValue();
                if (z().Q().getIsLike() == 1) {
                    requestIncrLiveGroupLikeMessage.type = 2;
                } else {
                    requestIncrLiveGroupLikeMessage.type = 1;
                }
                sendMessage(requestIncrLiveGroupLikeMessage);
            }
        } else if (z().W().getRoot() == view && x().b != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ac(this, x().b.name, x().b.groupId.intValue(), x().i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.t) {
            ImageView anchorImg = z().Q().getAnchorImg();
            anchorImg.clearAnimation();
            anchorImg.setBackgroundDrawable(null);
            anchorImg.setImageResource(com.baidu.tieba.l.counter_animation);
            anchorImg.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.l.live_animation_scale));
            ((AnimationDrawable) anchorImg.getDrawable()).start();
            this.z = true;
            if (this.y == null) {
                this.y = new Handler();
            }
            this.y.postDelayed(new v(this), 3000L);
        } else if (!this.z) {
            z().d(3);
            a(x().b.streamId, String.valueOf(x().b.groupId), String.valueOf(x().b.deviceId), x().b.playUrl, false);
        }
    }

    private void F() {
        new AlertDialog.Builder(this.x).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.u.live_exit_group).setPositiveButton(com.baidu.tieba.u.cancel, new w(this)).setNegativeButton(com.baidu.tieba.u.confirm, new x(this)).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        LivePlayingStatusMgr.a().d();
        this.v = true;
        BdLog.d("doExitGroup");
        com.baidu.tieba.im.live.b.b().r();
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
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected boolean p() {
        return true;
    }

    private void H() {
        if (this.e instanceof LiveMsglistModel) {
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.a = MessageFormat.format(getString(com.baidu.tieba.u.im_share_title), x().j);
            fVar.b = MessageFormat.format(getString(com.baidu.tieba.u.im_live_share_content), x().j);
            fVar.c = String.valueOf(com.baidu.tbadk.h.h) + x().b.groupId;
            try {
                fVar.d = Uri.parse(String.valueOf(N) + x().b.groupId + "&w=" + LocalViewSize.a().b());
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
            dVar.a(fVar, true);
            SparseArray<String> sparseArray = new SparseArray<>(7);
            sparseArray.put(5, "livem_to_qq");
            sparseArray.put(4, "livem_to_qzone");
            sparseArray.put(7, "livem_to_renren");
            sparseArray.put(6, "livem_to_sina");
            sparseArray.put(3, "livem_to_weixin");
            sparseArray.put(2, "livem_to_friend");
            dVar.a(sparseArray);
            dVar.a(3, a(x().j, x().b.groupId.intValue(), x().l), true);
            dVar.a();
        }
    }

    private com.baidu.tbadk.coreExtra.share.f a(String str, int i, String str2) {
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        fVar.a = MessageFormat.format(getString(com.baidu.tieba.u.im_share_title), str);
        fVar.b = MessageFormat.format(getString(com.baidu.tieba.u.im_live_share_content), str, String.valueOf(i));
        fVar.c = String.valueOf(com.baidu.tbadk.h.h) + i;
        if (str2 != null) {
            try {
            } catch (Throwable th) {
                BdLog.e(th.toString());
            }
            if (!str2.equals("")) {
                if (str2.startsWith(O)) {
                    fVar.d = Uri.parse(str2);
                } else {
                    fVar.a(com.baidu.tbadk.core.util.x.c(null, TbConfig.GROUP_HEAD_FILE));
                }
                return fVar;
            }
        }
        fVar.a(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.q.icon));
        return fVar;
    }

    @Override // com.baidu.tieba.im.live.k
    public void a(int i) {
        if (i > 14340) {
            showToast("");
        }
        this.w = StringUtils.translateSecondsToString(i);
        runOnUiThread(new y(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dd
    public String[] a(int i, boolean z) {
        boolean R = z().R();
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(getString(com.baidu.tieba.u.operate_copy));
                if (!z && !R) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_mute));
                    break;
                }
                break;
            case 4:
                if (!z && !R) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.u.msg_img_save));
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_mute));
                    break;
                }
                break;
            case 5:
                arrayList.add(TbadkApplication.m252getInst().isHeadsetModeOn() ? getString(com.baidu.tieba.u.group_close_receiver) : getString(com.baidu.tieba.u.group_open_receiver));
                if (!z && !R) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_mute));
                    break;
                }
                break;
            case 7:
                if (!z && !R) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.u.msg_mute));
                    break;
                }
                break;
            case 8:
                arrayList.add(getString(com.baidu.tieba.u.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dd
    public void a(int i, String str) {
        ChatMessage a = this.e.a(i);
        if (str.equals(getString(com.baidu.tieba.u.msg_mute))) {
            a(a);
        } else {
            super.a(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.dd, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12010 || i == 12009) {
                z().ai();
            }
        }
    }

    private boolean a(boolean z) {
        return x().r && !z;
    }
}
