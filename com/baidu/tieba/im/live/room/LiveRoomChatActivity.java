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
import com.baidu.tbadk.core.atomData.ce;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
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
    public bq o;
    private LiveRoomChatView p;
    private LiveMsglistModel q;
    private RequestRemoveMembersMessage w;
    private String x;
    private LiveRoomChatActivity y;
    public String a = null;
    private boolean r = false;
    private boolean s = false;
    private String t = null;
    private AlertDialog u = null;
    private boolean v = false;
    private Handler z = null;
    private boolean A = false;
    private int B = -1;
    private com.baidu.adp.framework.listener.d C = new f(this, 103112);
    private final CustomMessageListener D = new q(this, 2001121);
    private final CustomMessageListener E = new ab(this, 2001161);
    private final CustomMessageListener F = new ad(this, 2001170);
    private final CustomMessageListener G = new ae(this, 2001163);
    private final CustomMessageListener H = new af(this, 2001169);
    private final CustomMessageListener I = new ag(this, 2001166);
    private com.baidu.adp.framework.listener.d J = new ah(this, 107108);
    private com.baidu.adp.framework.listener.d K = new ai(this, 107103);
    private final com.baidu.adp.framework.listener.d L = new g(this, 0);
    private final com.baidu.adp.framework.listener.d M = new h(this, 0);
    private final com.baidu.adp.framework.listener.d N = new i(this, 107109);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.al.class, LiveRoomChatActivity.class);
        m = "";
        O = "http";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LiveMsglistModel v() {
        if (this.q == null) {
            this.q = (LiveMsglistModel) this.e;
        }
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LiveRoomChatView x() {
        if (this.p == null) {
            this.p = (LiveRoomChatView) this.d;
        }
        return this.p;
    }

    public void w() {
        if (v().r) {
            com.baidu.tieba.im.live.d.b().a(String.valueOf(v().b.groupId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4, boolean z) {
        BdNetUtil.NetworkStateInfo statusInfo = BdNetUtil.getStatusInfo();
        if (statusInfo == BdNetUtil.NetworkStateInfo.UNAVAIL) {
            showToast(com.baidu.tieba.x.neterror);
        } else if (statusInfo != BdNetUtil.NetworkStateInfo.WIFI) {
            if (this.u == null || !this.u.isShowing()) {
                this.u = new AlertDialog.Builder(this).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(v().r ? com.baidu.tieba.x.live_chat_room_nonwifi_prompts_pub : com.baidu.tieba.x.live_chat_room_nonwifi_prompts_play).setPositiveButton(v().r ? com.baidu.tieba.x.live_chat_room_nonwifi_prompts_pub_yes : com.baidu.tieba.x.live_chat_room_nonwifi_prompts_play_yes, new j(this, str, str2, str3, str4, z)).setNegativeButton(v().r ? com.baidu.tieba.x.live_chat_room_nonwifi_prompts_pub_no : com.baidu.tieba.x.live_chat_room_nonwifi_prompts_play_no, new k(this)).create();
                com.baidu.adp.lib.e.d.a(this.u, this);
            }
        } else {
            a(str, str2, str3, str4, z);
        }
    }

    public void a(String str, String str2, String str3, String str4, boolean z) {
        if (com.baidu.tieba.im.live.d.b().g() == -1) {
            this.t = str2;
        } else {
            com.baidu.tieba.im.live.d.b().a(v().r ? v().b.streamId : null, String.valueOf(v().b.groupId), String.valueOf(v().b.deviceId), v().b.playUrl, z);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        if (x().T()) {
            super.b(view, i, i2, j);
            return;
        }
        super.b(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage b2 = this.e.b(i2);
                if (b2 != null && b2.getUserInfo() != null && b2.getUserInfo().getUserName() != null) {
                    this.d.b(b2.getUserInfo().getUserName());
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
            if (x() != null && !x().ah()) {
                x().ak();
                return true;
            }
            boolean z2 = x() != null && x().U() == 3;
            if (v() != null && v().r) {
                z = true;
            }
            if (z || !z2) {
                y();
                return super.onKeyDown(i, keyEvent);
            }
            D();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void u() {
        super.u();
        if (!x().ah()) {
            x().ak();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Intent intent = new Intent();
        if (v() != null) {
            intent.putExtra("subcribed", v().f);
        }
        setResult(-1, intent);
    }

    private void a(ChatMessage chatMessage) {
        com.baidu.tieba.im.d.b.c(this, new l(this, chatMessage));
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    protected void c() {
        GroupData c;
        super.c();
        if ((this.e instanceof LiveMsglistModel) && (c = v().c()) != null) {
            if (c != null) {
                String name = c.getName();
                if (!TextUtils.isEmpty(name)) {
                    this.d.a(name, true);
                }
            }
            com.baidu.tieba.im.e.a(new m(this, c), new n(this, c));
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
        if (!this.v && v().b != null && (x().U() == 3 || x().U() == 5 || x().U() == 4 || com.baidu.tieba.im.live.d.b().r() == 2 || com.baidu.tieba.im.live.d.b().r() == 1)) {
            b(com.baidu.tieba.x.live_room_notify);
        }
        b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.baidu.tieba.im.live.p.a().a(this, v().r, i, v().j, v().c(), v().e, v().b.playUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b = true;
        com.baidu.tbadk.coreExtra.messageCenter.a.a().a(m);
        if (this.r) {
            com.baidu.tbadk.core.util.ap.a(this, 20);
        }
        if (this.r && com.baidu.tieba.im.live.d.b().g() == 0 && x().U() == 3) {
            b(v().b.streamId, String.valueOf(v().b.groupId), String.valueOf(v().b.deviceId), v().b.playUrl, false);
        }
        if (this.z == null) {
            this.z = new Handler();
        }
        this.z.postDelayed(new o(this), 100L);
    }

    private void z() {
        if (!com.baidu.tbadk.pluginArch.o.b()) {
            com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("live");
            if (a == null) {
                ConfigInfos.PluginConfig b2 = com.baidu.tbadk.pluginArch.d.a().b("live");
                if (b2 == null) {
                    showToast(com.baidu.tieba.x.plugin_config_not_found);
                    return;
                } else {
                    sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bl(this, b2, 23006)));
                    return;
                }
            } else if (!a.c()) {
                com.baidu.tbadk.coreExtra.c.a.a(this, com.baidu.tieba.x.plugin_live_not_install, new p(this), new r(this));
                return;
            }
        }
        if (com.baidu.tieba.im.live.d.b().r() == 1) {
            if (com.baidu.tieba.im.live.d.b().i() == null || !com.baidu.tieba.im.live.d.b().i().equals(String.valueOf(v().c().getGroupId()))) {
                com.baidu.adp.lib.e.d.a(new AlertDialog.Builder(this.y).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.x.live_check_group).setPositiveButton(com.baidu.tieba.x.cancel, new s(this)).setNegativeButton(com.baidu.tieba.x.confirm, new t(this)).create(), this);
                return;
            } else {
                A();
                return;
            }
        }
        A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        this.q = null;
        this.p = null;
        super.onNewIntent(intent);
        this.y = this;
        v().a(getIntent(), (Bundle) null);
        z();
        x().j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.y = this;
        v().a(getIntent(), bundle);
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
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
        registerListener(107105, this.M);
        registerListener(107107, this.L);
        B();
        String i = com.baidu.tieba.im.live.d.b().i();
        if (!StringUtils.isNull(i)) {
            if (!i.equals(String.valueOf(v().c().getGroupId()))) {
                com.baidu.tieba.im.live.d.b().s();
            } else if (com.baidu.tieba.im.live.d.b().q() == 3) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).aa().c(true);
                }
                com.baidu.tieba.im.live.d.b().a(this);
                this.x = StringUtils.translateSecondsToString(com.baidu.tieba.im.live.d.b().t());
                x().S().setRecordTime(this.x);
                x().S().a();
            }
        }
        if (this.d != null) {
            this.d.B().setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        RequestJoinLiveGroupMessage requestJoinLiveGroupMessage = new RequestJoinLiveGroupMessage();
        requestJoinLiveGroupMessage.groupId = v().c().getGroupId();
        sendMessage(requestJoinLiveGroupMessage);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void o() {
        this.d = new LiveRoomChatView(this, this.e.j());
        this.d.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
        if (this.e instanceof LiveMsglistModel) {
            int i = 0;
            if (v().c() != null) {
                i = v().c().getGroupId();
                this.d.a(v().c().getName(), true);
            }
            this.d.a(v().i(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m = "";
        com.baidu.tieba.im.live.d.b().a((com.baidu.tieba.im.live.n) null);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x00c1: IGET  (r6v12 java.lang.Integer A[REMOVE]) = 
      (wrap: protobuf.LiveGroupInfo : 0x00bf: IGET  (r6v11 protobuf.LiveGroupInfo A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.LiveMsglistModel : 0x00bb: INVOKE  (r6v10 com.baidu.tieba.im.model.LiveMsglistModel A[REMOVE]) = (r20v0 'this' com.baidu.tieba.im.live.room.LiveRoomChatActivity A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.baidu.tieba.im.live.room.LiveRoomChatActivity.v():com.baidu.tieba.im.model.LiveMsglistModel)
     com.baidu.tieba.im.model.LiveMsglistModel.b protobuf.LiveGroupInfo)
     protobuf.LiveGroupInfo.groupId java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x02bd: IGET  (r6v9 java.lang.Integer A[REMOVE]) = 
      (wrap: protobuf.LiveGroupInfo : 0x02bb: IGET  (r6v8 protobuf.LiveGroupInfo A[REMOVE]) = 
      (wrap: com.baidu.tieba.im.model.LiveMsglistModel : 0x02b7: INVOKE  (r6v7 com.baidu.tieba.im.model.LiveMsglistModel A[REMOVE]) = (r20v0 'this' com.baidu.tieba.im.live.room.LiveRoomChatActivity A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.baidu.tieba.im.live.room.LiveRoomChatActivity.v():com.baidu.tieba.im.model.LiveMsglistModel)
     com.baidu.tieba.im.model.LiveMsglistModel.b protobuf.LiveGroupInfo)
     protobuf.LiveGroupInfo.groupId java.lang.Integer)] */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.B()) {
            y();
        }
        super.onClick(view);
        if (view == x().Z()) {
            x().f(v().f);
        } else if (view == x().aa().b()) {
            x().A();
            if (this.n) {
                x().A();
                this.o = new bq(this, this.y, com.baidu.tieba.y.NewUserDialog);
                this.o.show();
                return;
            }
            showToast(com.baidu.tieba.x.reminder_notice_only_one);
        } else if (view == x().aa().c()) {
            x().A();
            G();
        } else if (view == x().aa().d()) {
            x().A();
            if (v().b != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ai(this, new StringBuilder().append(v().b.groupId).toString())));
            }
        } else if (view == x().aa().e()) {
            x().A();
            TiebaStatic.eventStat(getBaseContext(), "livem_record_bt", "click");
            int q = com.baidu.tieba.im.live.d.b().q();
            if (q == 2) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).aa().c(true);
                }
                showToast(com.baidu.tieba.x.live_chat_room_recordstarted);
                com.baidu.tieba.im.live.d.b().a(this);
                com.baidu.tieba.im.live.d.b().b(com.baidu.tieba.im.live.d.b().i());
                x().S().c();
                x().S().a();
            } else if (q == 3) {
                if (this.d != null) {
                    ((LiveRoomChatView) this.d).aa().c(false);
                }
                showToast(com.baidu.tieba.x.live_chat_room_recordstopped);
                x().S().b();
                com.baidu.tieba.im.live.d.b().a((com.baidu.tieba.im.live.n) null);
                com.baidu.tieba.im.live.d.b().c(com.baidu.tieba.im.live.d.b().i());
            } else {
                showToast(com.baidu.tieba.x.live_chat_room_recordnotready);
            }
        } else if (view == x().aa().f()) {
            x().A();
            if (v().r) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ap(this.y, v().c().getGroupId())));
            }
        } else if (view == x().aa().g()) {
            x().A();
            E();
        } else if (view == x().aa().h()) {
            if (v() != null && v().b != null && v().b.groupId != null) {
                RequestSubscribeLiveGroupMessage requestSubscribeLiveGroupMessage = new RequestSubscribeLiveGroupMessage();
                requestSubscribeLiveGroupMessage.setGroupId(v().b.groupId.intValue());
                if (v().f) {
                    requestSubscribeLiveGroupMessage.setSubscribe(0);
                } else {
                    requestSubscribeLiveGroupMessage.setSubscribe(1);
                }
                MessageManager.getInstance().sendMessage(requestSubscribeLiveGroupMessage);
            }
        } else if (view == x().aa().i()) {
            x().A();
            if (v() != null && v().b != null && v().b.groupId != null) {
                G();
            }
        } else if (view == x().aa().j()) {
            x().A();
            if (v().b != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ai(this, new StringBuilder().append(v().b.groupId).toString())));
            }
        } else if (view == x().aa().k()) {
            x().A();
            if (v().b != null) {
                TiebaStatic.eventStat(getBaseContext(), "livem_brief", "click");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.an(this, v().b.groupId.intValue(), v().b.publisherId.intValue(), v().b.publisherName)));
            }
        } else if (view == x().aa().l()) {
            x().A();
            E();
        } else if (view == x().ac()) {
            x().aj();
        } else if (view == x().ad() || view == x().S().getHeaderImage()) {
            if (!com.baidu.adp.lib.util.j.c()) {
                showToast(com.baidu.tieba.x.neterror);
            } else if (v().r && v().b != null) {
                x().d(5);
                w();
            }
        } else if (view == x().ae() || view == x().S().getAnchorImg() || view == x().S().getLiveStopView() || view == x().S().getLiveStopHost()) {
            if (v().r && v().b != null) {
                this.s = view == x().S().getAnchorImg() || (view == x().ae() && x().S().getAnchorImg().isShown());
                BdNetUtil.NetworkStateInfo statusInfo = BdNetUtil.getStatusInfo();
                if (statusInfo == BdNetUtil.NetworkStateInfo.UNAVAIL) {
                    showToast(com.baidu.tieba.x.neterror);
                } else if (statusInfo != BdNetUtil.NetworkStateInfo.WIFI) {
                    if (this.u == null || !this.u.isShowing()) {
                        this.u = new AlertDialog.Builder(this).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.x.live_chat_room_nonwifi_prompts_pub).setPositiveButton(com.baidu.tieba.x.live_chat_room_nonwifi_prompts_pub_yes, new u(this)).setNegativeButton(com.baidu.tieba.x.live_chat_room_nonwifi_prompts_pub_no, new v(this)).create();
                        com.baidu.adp.lib.e.d.a(this.u, this);
                    }
                } else {
                    C();
                }
            }
        } else if (view == x().X().getForcastBtn()) {
            ce ceVar = new ce(this, 0, String.valueOf(v().b.forumId), v().e, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            ceVar.a(v().b.groupId.intValue(), v().m, v().j, v().h, v().i, v().b.publisherName, v().l, v().k);
            com.baidu.tbadk.core.f.a(this.y, "pub_notice_bt");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, ceVar));
        } else if (x().X().getLiveRoomCloseBtn() == view) {
            x().X().setVisibility(8);
        } else if (x().S().getSettingButton() == view || x().S().getNoteLayout() == view) {
            if (v().r) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ap(this.y, v().c().getGroupId())));
            }
        } else if (x().S().getmLiveRoomLike() == view) {
            if (x().S().d() && v().b != null) {
                RequestIncrLiveGroupLikeMessage requestIncrLiveGroupLikeMessage = new RequestIncrLiveGroupLikeMessage();
                requestIncrLiveGroupLikeMessage.groupId = v().b.groupId.intValue();
                if (x().S().getIsLike() == 1) {
                    requestIncrLiveGroupLikeMessage.type = 2;
                } else {
                    requestIncrLiveGroupLikeMessage.type = 1;
                }
                sendMessage(requestIncrLiveGroupLikeMessage);
            }
        } else if (x().Y().getRoot() == view && v().b != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.aj(this, v().b.name, v().b.groupId.intValue(), v().i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.s) {
            ImageView anchorImg = x().S().getAnchorImg();
            anchorImg.clearAnimation();
            anchorImg.setBackgroundDrawable(null);
            anchorImg.setImageResource(com.baidu.tieba.o.counter_animation);
            anchorImg.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.o.live_animation_scale));
            ((AnimationDrawable) anchorImg.getDrawable()).start();
            this.A = true;
            if (this.z == null) {
                this.z = new Handler();
            }
            this.z.postDelayed(new w(this), 3000L);
        } else if (!this.A) {
            x().d(3);
            a(v().b.streamId, String.valueOf(v().b.groupId), String.valueOf(v().b.deviceId), v().b.playUrl, false);
        }
    }

    private void D() {
        com.baidu.adp.lib.e.d.a(new AlertDialog.Builder(this.y).setTitle("").setIcon((Drawable) null).setCancelable(true).setMessage(com.baidu.tieba.x.live_room_dialog_back_info).setPositiveButton(com.baidu.tieba.x.live_room_dialog_back_no, new x(this)).setNegativeButton(com.baidu.tieba.x.live_room_dialog_back_yes, new y(this)).create(), this);
    }

    private void E() {
        com.baidu.adp.lib.e.d.a(new AlertDialog.Builder(this.y).setTitle("").setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.x.live_exit_group).setPositiveButton(com.baidu.tieba.x.cancel, new z(this)).setNegativeButton(com.baidu.tieba.x.confirm, new aa(this)).create(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        LivePlayingStatusMgr.a().d();
        this.v = true;
        com.baidu.tieba.im.live.d.b().s();
        if (v().b == null) {
            finish();
            return;
        }
        showProgressBar();
        y();
        this.w = new RequestRemoveMembersMessage();
        this.w.setGroupId(v().b.groupId.intValue());
        this.w.setUserIds(TbadkApplication.getCurrentAccount());
        sendMessage(this.w);
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
    protected boolean a(com.baidu.tieba.im.chat.bt btVar) {
        return true;
    }

    private void G() {
        if (this.e instanceof LiveMsglistModel) {
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.a = MessageFormat.format(getString(com.baidu.tieba.x.im_share_title), v().j);
            hVar.b = MessageFormat.format(getString(com.baidu.tieba.x.im_live_share_content), v().j);
            hVar.c = String.valueOf(com.baidu.tbadk.k.i) + v().b.groupId;
            try {
                hVar.d = Uri.parse(String.valueOf(TbConfig.PHOTO_BIG_ADDRESS) + v().b.publisherPortrait);
            } catch (Throwable th) {
            }
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
            dVar.b(false);
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
            dVar.a(3, a(v().j, v().b.groupId.intValue(), String.valueOf(TbConfig.PHOTO_BIG_ADDRESS) + v().b.publisherPortrait), true);
            dVar.a();
        }
    }

    private com.baidu.tbadk.coreExtra.share.h a(String str, int i, String str2) {
        com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
        hVar.a = MessageFormat.format(getString(com.baidu.tieba.x.im_share_title), str);
        hVar.b = MessageFormat.format(getString(com.baidu.tieba.x.im_live_share_content), str, String.valueOf(i));
        hVar.c = String.valueOf(com.baidu.tbadk.k.i) + i;
        if (str2 != null) {
            if (!str2.equals("")) {
                if (str2.startsWith(O)) {
                    hVar.d = Uri.parse(str2);
                } else {
                    hVar.a(com.baidu.tbadk.core.util.s.c(null, TbConfig.GROUP_HEAD_FILE));
                }
                return hVar;
            }
        }
        hVar.a(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.t.icon));
        return hVar;
    }

    @Override // com.baidu.tieba.im.live.n
    public void a(int i) {
        if (i > 14340) {
            showToast("");
        }
        this.x = StringUtils.translateSecondsToString(i);
        runOnUiThread(new ac(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public String[] a(int i, boolean z) {
        boolean T = x().T();
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 3:
                arrayList.add(getString(com.baidu.tieba.x.operate_copy));
                if (!z && !T) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_mute));
                    break;
                }
                break;
            case 4:
                if (!z && !T) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_img_save));
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_mute));
                    break;
                }
                break;
            case 5:
                arrayList.add(TbadkApplication.m252getInst().isHeadsetModeOn() ? getString(com.baidu.tieba.x.group_close_receiver) : getString(com.baidu.tieba.x.group_open_receiver));
                if (!z && !T) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_mute));
                    break;
                }
                break;
            case 7:
                if (!z && !T) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_at));
                }
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                if (a(z)) {
                    arrayList.add(getString(com.baidu.tieba.x.msg_mute));
                    break;
                }
                break;
            case 8:
                arrayList.add(getString(com.baidu.tieba.x.msg_delete));
                break;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void a(int i, String str) {
        ChatMessage b2 = this.e.b(i);
        if (str.equals(getString(com.baidu.tieba.x.msg_mute))) {
            a(b2);
        } else {
            super.a(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12010 || i == 12009) {
                x().ak();
            }
            if (i == 23005 || i == 23006) {
                sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.al(this, this.q.c().getGroupId())));
            }
        }
        if (intent != null && i2 == 10) {
            String stringExtra = intent.getStringExtra("name");
            String stringExtra2 = intent.getStringExtra("intro");
            String stringExtra3 = intent.getStringExtra("portraitId");
            x().d(stringExtra);
            x().e(stringExtra2);
            x().g(stringExtra3);
        }
    }

    private boolean a(boolean z) {
        return v().r && !z;
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    protected void b(Bundle bundle) {
        super.b(bundle);
        H();
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    protected void a(Intent intent) {
        super.a(intent);
        H();
    }

    private void H() {
        GroupData c = v().c();
        if (c != null) {
            m = String.valueOf(c.getGroupId());
        } else {
            m = "";
        }
    }
}
