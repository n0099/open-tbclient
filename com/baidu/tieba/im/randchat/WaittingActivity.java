package com.baidu.tieba.im.randchat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.as;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.model.ar;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.baidu.tieba.util.bv;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WaittingActivity extends com.baidu.tieba.j {
    private f a;
    private ar b;
    private com.baidu.tieba.im.model.c c;
    private bv e;
    private bv f;
    private com.baidu.tieba.view.h d = null;
    private boolean g = false;
    private WaitingTipView.Type h = WaitingTipView.Type.ORIGINAL_ENTER;
    private com.baidu.tieba.im.messageCenter.g i = new p(this);
    private BroadcastReceiver j = new l(this);

    public static void a(Context context, RandChatRoomData randChatRoomData, int i) {
        Intent intent = new Intent(context, WaittingActivity.class);
        intent.putExtra("randChatRoomData", randChatRoomData);
        intent.putExtra("startCount", i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
        g();
        h();
        n();
        m();
        i();
        this.b.a(this.i);
        this.c.a(this.i);
        as.b(this, "rand_chat_wait_page_start");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        b();
    }

    private void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.j, intentFilter);
    }

    private void b() {
        unregisterReceiver(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        as.a(this, "rand_chat_wait_page_quit");
        this.a.a().a();
        showLoadingDialog(getString(R.string.rand_chat_waiting_quit_loading));
        this.b.a(this.b.f().d(), false, 0);
    }

    private void d() {
        this.b.b(this.b.f().d());
    }

    private void e() {
        com.baidu.tieba.im.d.c.a(String.valueOf(this.b.f().d()));
        showLoadingDialog(getString(R.string.group_tab_enterchatroom_loading));
        this.c.a(this.b.f().d());
    }

    private void f() {
        this.b = new ar(this);
        this.b.a(getIntent());
        this.c = new com.baidu.tieba.im.model.c();
    }

    private void g() {
        this.a = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.a.a().setShapeType(this.b.c());
        int bottomP = this.a.a().getBottomP();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.g().getLayoutParams();
        layoutParams.topMargin = bottomP;
        this.d = new com.baidu.tieba.view.h(this, R.style.NobackDialog);
        this.d.a(new g(this));
        a(this.b.f(), false);
        this.a.a(this);
        this.a.g().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RandChatRoomData randChatRoomData) {
        UserData userData;
        return (randChatRoomData == null || randChatRoomData.j() == null || randChatRoomData.j().size() <= 0 || (userData = randChatRoomData.j().get(0)) == null || TiebaApplication.A() == null || !TiebaApplication.A().equals(String.valueOf(userData.getUserId()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RandChatRoomData randChatRoomData, boolean z) {
        a loadingView = this.a.a().getLoadingView();
        com.baidu.tieba.view.o chatterboxView = this.a.a().getChatterboxView();
        if (this.h == WaitingTipView.Type.PERSONS_READY) {
            if (loadingView != null) {
                loadingView.setVisibility(0);
            }
            if (chatterboxView != null) {
                chatterboxView.setVisibility(8);
                return;
            }
            return;
        }
        if (chatterboxView != null) {
            chatterboxView.setVisibility(0);
        }
        if (randChatRoomData != null) {
            boolean a = a(randChatRoomData);
            String h = this.b.h();
            if (!z) {
                h = randChatRoomData.a();
            }
            if (TextUtils.isEmpty(h)) {
                if (a) {
                    if (loadingView != null) {
                        loadingView.setVisibility(8);
                    }
                } else if (loadingView != null) {
                    loadingView.setVisibility(0);
                }
            } else if (loadingView != null) {
                loadingView.setVisibility(8);
            }
            if (chatterboxView != null) {
                chatterboxView.a(a, !z);
            }
            if (!z) {
                if (chatterboxView != null) {
                    chatterboxView.setTitle(randChatRoomData.a());
                }
            } else if (chatterboxView != null) {
                chatterboxView.setTitle(this.b.h());
            }
            this.d.a(randChatRoomData.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        List<UserData> j;
        this.b.a().clear();
        RandChatRoomData f = this.b.f();
        if (f != null && (j = f.j()) != null) {
            int size = j.size();
            if (size <= this.b.c()) {
                for (int i = 0; i < size; i++) {
                    this.a.a().a(i, j.get(i).getPortrait(), (e) null);
                }
                a(WaitingTipView.Type.ORIGINAL_ENTER, new Object[]{Integer.valueOf(this.b.c() - this.b.d())});
                long i2 = f.i();
                if (i2 > 0) {
                    a(WaitingTipView.Type.WAIT_TIP, new Object[]{Long.valueOf(i2)});
                } else {
                    a(WaitingTipView.Type.WAIT_TIP_RAND, (Object[]) null);
                }
            }
            if (this.b.d() == this.b.c()) {
                b((String) null);
            }
        }
    }

    private void a(UserData userData) {
        RandChatRoomData f;
        List<UserData> j;
        boolean z;
        if (userData != null && (f = this.b.f()) != null && (j = f.j()) != null) {
            int size = j.size();
            int i = 0;
            boolean z2 = false;
            while (i < size) {
                UserData userData2 = j.get(i);
                if (userData2 == null || userData.getUserId() != userData2.getUserId()) {
                    z = z2;
                } else if (i != 0) {
                    j.set(i, null);
                    int d = this.b.d();
                    this.b.a(d + (-1) >= 0 ? d - 1 : 0);
                    this.a.a().a(i, (String) null, (e) null);
                    a(WaitingTipView.Type.PERSON_LEAVE, new Object[]{userData.getUserName(), userData.getPortrait()});
                    z = z2;
                } else {
                    z = true;
                }
                i++;
                z2 = z;
            }
            if (z2) {
                j.remove(0);
                int d2 = this.b.d();
                this.b.a(d2 + (-1) >= 0 ? d2 - 1 : 0);
                this.a.a().c();
                Iterator<UserData> it = j.iterator();
                while (it.hasNext() && it.next() == null) {
                    it.remove();
                }
                int size2 = j.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    UserData userData3 = j.get(i2);
                    if (userData3 != null) {
                        this.a.a().a(i2, userData3.getPortrait(), (e) null);
                    }
                }
                a(WaitingTipView.Type.PERSON_LEAVE, new Object[]{userData.getUserName(), userData.getPortrait()});
            }
        }
    }

    private void a(UserData userData, String str) {
        RandChatRoomData f;
        List<UserData> j;
        if (userData != null && (f = this.b.f()) != null && (j = f.j()) != null) {
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (j.get(i) == null) {
                    j.set(i, userData);
                    int d = this.b.d();
                    this.b.a(d + 1 <= this.b.c() ? d + 1 : this.b.c());
                    this.a.a().a(i, userData.getPortrait(), new n(this));
                    if (this.b.d() < this.b.c()) {
                        a(WaitingTipView.Type.PERSON_ENTER, new Object[]{Integer.valueOf(this.b.c() - this.b.d()), userData.getUserName(), userData.getPortrait()});
                        return;
                    }
                    return;
                }
            }
            if (size <= this.b.c() - 1) {
                j.add(userData);
                int d2 = this.b.d();
                this.b.a(d2 + 1 <= this.b.c() ? d2 + 1 : this.b.c());
                this.a.a().a(size, userData.getPortrait(), new o(this));
                if (this.b.d() < this.b.c()) {
                    a(WaitingTipView.Type.PERSON_ENTER, new Object[]{Integer.valueOf(this.b.c() - this.b.d()), userData.getUserName(), userData.getPortrait()});
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        WaitingTipView g = this.a.g();
        Object tag = g.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            HeadImageView tipImageHead = g.getTipImageHead();
            com.baidu.adp.widget.ImageView.d b = com.baidu.tbadk.imageManager.d.a().b(str);
            if (b != null) {
                tipImageHead.setImageBitmap(b.h());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.data.b bVar) {
        RandChatRoomData f = this.b.f();
        if (bVar.b == f.d() && bVar.g == this.b.c()) {
            List<UserData> j = f.j();
            if (j != null) {
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    UserData userData = j.get(i);
                    if (userData != null && userData.getUserId() == bVar.c) {
                        return;
                    }
                }
            }
            if (bVar.f == this.b.d() + 1) {
                a(d(bVar), bVar.a);
                if (this.b.d() == this.b.c()) {
                    b((String) null);
                    return;
                }
                return;
            }
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.data.b bVar) {
        RandChatRoomData f = this.b.f();
        if (bVar.b == f.d()) {
            if (bVar.g == this.b.c()) {
                if (bVar.f == this.b.d() - 1) {
                    a(d(bVar));
                } else {
                    d();
                }
            }
            a(f, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.data.b bVar) {
        b(bVar.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(WaitingTipView.Type type, Object[] objArr) {
        WaitingTipView g = this.a.g();
        g.setTag(null);
        CircleBgView circelBgView = g.getCircelBgView();
        TextView tipText = g.getTipText();
        HeadImageView tipImageHead = g.getTipImageHead();
        TextView tipImageText = g.getTipImageText();
        Button waitButton = g.getWaitButton();
        Button quitButton = g.getQuitButton();
        quitButton.setOnClickListener(new q(this));
        waitButton.setOnClickListener(new r(this));
        g.setVisibility(0);
        this.h = type;
        switch (type) {
            case TOPIC_UPDATE:
                tipText.setText(getString(R.string.rand_chat_waiting_update_topic));
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_choice_join));
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                g.a(tipImageHead, false);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case ORIGINAL_ENTER:
                tipText.setText(getString(R.string.rand_chat_waiting_first_enter_success, new Object[]{Integer.valueOf(((Integer) objArr[0]).intValue())}));
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_choice_join));
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                g.a(tipImageHead, false);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case PERSON_ENTER:
                int intValue = ((Integer) objArr[0]).intValue();
                String str = (String) objArr[1];
                String str2 = (String) objArr[2];
                SpannableString spannableString = new SpannableString(getString(R.string.rand_chat_waiting_other_enter_success, new Object[]{str, String.valueOf(intValue)}));
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tip_view_text_name_color)), 0, str.length(), 34);
                tipText.setText(spannableString);
                com.baidu.adp.widget.ImageView.d b = com.baidu.tbadk.imageManager.d.a().b(str2);
                if (b != null) {
                    tipImageHead.setImageBitmap(b.h());
                } else {
                    tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_choice_date));
                    g.setTag(str2);
                }
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(true);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                g.a(tipImageHead, true);
                waitButton.setVisibility(8);
                tipImageText.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case PERSONS_READY:
                tipText.setText((int) R.string.rand_chat_waiting_ready_chat);
                tipImageText.setBackgroundResource(R.drawable.bg_choice_join_s);
                tipImageText.setText(R.string.loading_view_ready);
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(8);
                tipImageText.setVisibility(0);
                g.a(tipImageHead, false);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case WAIT_LONG:
                tipText.setText((int) R.string.rand_chat_waiting_drop_down_tip);
                tipText.setVisibility(0);
                circelBgView.setVisibility(8);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(8);
                g.a(tipImageHead, false);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(0);
                quitButton.setVisibility(0);
                return;
            case PERSON_LEAVE:
                String str3 = (String) objArr[0];
                String str4 = (String) objArr[1];
                SpannableString spannableString2 = new SpannableString(str3 + getString(R.string.rand_chat_waiting_quit));
                spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tip_view_text_name_color)), 0, str3.length(), 34);
                tipText.setText(spannableString2);
                com.baidu.adp.widget.ImageView.d b2 = com.baidu.tbadk.imageManager.d.a().b(str4);
                if (b2 != null) {
                    tipImageHead.setImageBitmap(b2.h());
                } else {
                    tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_choice_date));
                    g.setTag(str4);
                }
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(true);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                g.a(tipImageHead, true);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case WAIT_TIP:
                long longValue = ((Long) objArr[0]).longValue();
                if (longValue < 60) {
                    tipText.setText(getString(R.string.rand_chat_waiting_wait_time_second, new Object[]{String.valueOf(longValue)}));
                } else {
                    tipText.setText(getString(R.string.rand_chat_waiting_wait_time_minute, new Object[]{String.valueOf(longValue / 60)}));
                }
                tipImageText.setBackgroundResource(R.drawable.bg_choice_join_n);
                tipImageText.setText(R.string.rand_chat_waiting_wait);
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(8);
                tipImageText.setVisibility(0);
                g.a(tipImageHead, false);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case WAIT_TIP_RAND:
                tipText.setText(this.b.b());
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_choice_date));
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                g.a(tipImageHead, false);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case CLEAR:
                g.setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.i();
        this.b.b(this.i);
        this.c.b(this.i);
        if (this.e != null) {
            this.e.b();
        }
        if (this.f != null) {
            this.f.b();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.h()) {
            j();
        } else if (view == this.a.f()) {
            as.a(this, "rand_chat_wait_page_change_button");
            k();
        } else {
            com.baidu.tieba.view.o e = this.a.e();
            if (e != null && e.a(view) && this.d != null) {
                this.d.a(this.b.h());
                this.d.b(this.b.i());
                this.d.show();
            }
        }
    }

    public void a(WaitingTipView.Type type, Object[] objArr) {
        LinkedList<Pair<WaitingTipView.Type, Object[]>> a = this.b.a();
        boolean isEmpty = a.isEmpty();
        a.addLast(new Pair<>(type, objArr));
        if (isEmpty) {
            this.f.b();
            this.f.c();
        }
    }

    private void j() {
        com.baidu.tieba.im.d.b.a((Context) this, (DialogInterface.OnClickListener) new s(this), (DialogInterface.OnClickListener) new t(this));
    }

    private void k() {
        com.baidu.tieba.im.d.b.b((Context) this, (DialogInterface.OnClickListener) new u(this), (DialogInterface.OnClickListener) new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.e != null) {
            this.e.b();
            this.e.c();
        }
        this.a.a().a();
        this.a.a().b();
        this.a.a().c();
        b(WaitingTipView.Type.CLEAR, (Object[]) null);
        e();
    }

    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.a.a(i);
    }

    private void m() {
        this.f = new i(this, 100000000L, 1000L);
    }

    private void n() {
        this.e = new j(this, 120000L, 120000L);
        this.e.b();
        this.e.c();
    }

    private void b(String str) {
        if (this.e != null) {
            this.e.b();
        }
        if (this.f != null) {
            this.f.b();
        }
        this.b.a(true);
        this.a.f().setEnabled(false);
        this.a.h().setEnabled(false);
        this.a.g().getQuitButton().setEnabled(false);
        this.a.a().getLoadingView().setVisibility(0);
        this.a.a().getChatterboxView().setVisibility(8);
        b(WaitingTipView.Type.PERSONS_READY, (Object[]) null);
        this.a.a().a(new k(this, str));
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.b.e()) {
                j();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private UserData d(com.baidu.tieba.im.data.b bVar) {
        if (bVar == null) {
            return null;
        }
        UserData userData = new UserData();
        userData.setUserId(bVar.c);
        userData.setPortrait(bVar.e);
        userData.setUserName(bVar.d);
        return userData;
    }
}
