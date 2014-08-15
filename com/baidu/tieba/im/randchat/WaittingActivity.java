package com.baidu.tieba.im.randchat;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.bf;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.baidu.tieba.x;
import com.baidu.tieba.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WaittingActivity extends BaseActivity {
    private static /* synthetic */ int[] m;
    private f a;
    private bf b;
    private com.baidu.tieba.im.model.h c;
    private com.baidu.tbadk.coreExtra.c.c e;
    private com.baidu.tbadk.coreExtra.c.c f;
    private boolean h;
    private com.baidu.tieba.im.view.a d = null;
    private boolean g = false;
    private WaitingTipView.Type i = WaitingTipView.Type.ORIGINAL_ENTER;
    private CustomMessageListener j = new h(this, 2001119);
    private com.baidu.adp.framework.listener.d k = new p(this, 0);
    private BroadcastReceiver l = new q(this);

    static /* synthetic */ int[] a() {
        int[] iArr = m;
        if (iArr == null) {
            iArr = new int[WaitingTipView.Type.valuesCustom().length];
            try {
                iArr[WaitingTipView.Type.CLEAR.ordinal()] = 8;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WaitingTipView.Type.ORIGINAL_ENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WaitingTipView.Type.PERSONS_READY.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WaitingTipView.Type.PERSON_ENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WaitingTipView.Type.PERSON_LEAVE.ordinal()] = 6;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[WaitingTipView.Type.TOPIC_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[WaitingTipView.Type.WAIT_LONG.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[WaitingTipView.Type.WAIT_TIP.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[WaitingTipView.Type.WAIT_TIP_RAND.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            m = iArr;
        }
        return iArr;
    }

    public static void a(Context context, RandChatRoomData randChatRoomData, int i) {
        Intent intent = new Intent(context, WaittingActivity.class);
        intent.putExtra("randChatRoomData", randChatRoomData);
        intent.putExtra("startCount", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
        h();
        i();
        o();
        n();
        j();
        this.b.a(this.k);
        this.b.a(this.j);
        this.c.registerListener(this.k);
        com.baidu.tbadk.core.f.b(this, "rand_chat_wait_page_start");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        c();
    }

    private void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.l, intentFilter);
    }

    private void c() {
        unregisterReceiver(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.h = true;
        com.baidu.tbadk.core.f.a(this, "rand_chat_wait_page_quit");
        this.a.b().a();
        showLoadingDialog(getString(x.rand_chat_waiting_quit_loading));
        this.b.a(this.b.f().d(), false, 0);
    }

    private void e() {
        this.b.b(this.b.f().d());
    }

    private void f() {
        showLoadingDialog(getString(x.group_tab_enterchatroom_loading));
        this.c.a(this.b.f().d(), false);
    }

    private void g() {
        this.b = new bf(this);
        this.b.a(getIntent());
        this.c = new com.baidu.tieba.im.model.h(this);
        this.c.setUniqueId(getUniqueId());
    }

    private void h() {
        this.a = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.a.b().setShapeType(this.b.c());
        int bottomP = this.a.b().getBottomP();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.e().getLayoutParams();
        layoutParams.topMargin = bottomP;
        this.d = new com.baidu.tieba.im.view.a(this, y.NobackDialog);
        this.d.a(new r(this));
        a(this.b.f(), false);
        this.a.a(this);
        this.a.e().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RandChatRoomData randChatRoomData) {
        UserData userData;
        return (randChatRoomData == null || randChatRoomData.j() == null || randChatRoomData.j().size() <= 0 || (userData = randChatRoomData.j().get(0)) == null || TbadkApplication.getCurrentAccount() == null || !TbadkApplication.getCurrentAccount().equals(String.valueOf(userData.getUserId()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RandChatRoomData randChatRoomData, boolean z) {
        a loadingView = this.a.b().getLoadingView();
        com.baidu.tieba.im.view.h chatterboxView = this.a.b().getChatterboxView();
        if (this.i == WaitingTipView.Type.PERSONS_READY) {
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
    public void j() {
        List<UserData> j;
        this.b.a().clear();
        RandChatRoomData f = this.b.f();
        if (f != null && (j = f.j()) != null) {
            int size = j.size();
            if (size <= this.b.c()) {
                for (int i = 0; i < size; i++) {
                    this.a.b().a(i, j.get(i).getPortrait(), (e) null);
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
                if (userData2 == null || userData.getUserId() == null || !userData.getUserId().equals(userData2.getUserId())) {
                    z = z2;
                } else if (i != 0) {
                    j.set(i, null);
                    int d = this.b.d();
                    this.b.a(d + (-1) >= 0 ? d - 1 : 0);
                    this.a.b().a(i, (String) null, (e) null);
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
                this.a.b().c();
                Iterator<UserData> it = j.iterator();
                while (it.hasNext() && it.next() == null) {
                    it.remove();
                }
                int size2 = j.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    UserData userData3 = j.get(i2);
                    if (userData3 != null) {
                        this.a.b().a(i2, userData3.getPortrait(), (e) null);
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
                    this.a.b().a(i, userData.getPortrait(), new s(this));
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
                this.a.b().a(size, userData.getPortrait(), new t(this));
                if (this.b.d() < this.b.c()) {
                    a(WaitingTipView.Type.PERSON_ENTER, new Object[]{Integer.valueOf(this.b.c() - this.b.d()), userData.getUserName(), userData.getPortrait()});
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.baidu.adp.widget.a.a aVar;
        WaitingTipView e = this.a.e();
        Object tag = e.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            HeadImageView tipImageHead = e.getTipImageHead();
            Object a = com.baidu.adp.lib.resourceLoader.d.a().a(str, 12, new Object[0]);
            if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                aVar = null;
            } else {
                aVar = (com.baidu.adp.widget.a.a) a;
            }
            if (aVar != null) {
                tipImageHead.setImageBitmap(aVar.h());
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
                    if (userData != null && userData.getUserIdLong() == bVar.c) {
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
            e();
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
                    e();
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
        com.baidu.adp.widget.a.a aVar;
        com.baidu.adp.widget.a.a aVar2;
        WaitingTipView e = this.a.e();
        e.setTag(null);
        CircleBgView circelBgView = e.getCircelBgView();
        TextView tipText = e.getTipText();
        HeadImageView tipImageHead = e.getTipImageHead();
        TextView tipImageText = e.getTipImageText();
        Button waitButton = e.getWaitButton();
        Button quitButton = e.getQuitButton();
        quitButton.setOnClickListener(new u(this));
        waitButton.setOnClickListener(new v(this));
        e.setVisibility(0);
        this.i = type;
        switch (a()[type.ordinal()]) {
            case 1:
                tipText.setText(getString(x.rand_chat_waiting_update_topic));
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.t.icon_choice_join));
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                e.a(tipImageHead, false);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case 2:
                tipText.setText(getString(x.rand_chat_waiting_first_enter_success, new Object[]{Integer.valueOf(((Integer) objArr[0]).intValue())}));
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.t.icon_choice_join));
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                e.a(tipImageHead, false);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case 3:
                int intValue = ((Integer) objArr[0]).intValue();
                String str = (String) objArr[1];
                String str2 = (String) objArr[2];
                SpannableString spannableString = new SpannableString(getString(x.rand_chat_waiting_other_enter_success, new Object[]{str, String.valueOf(intValue)}));
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.r.tip_view_text_name_color)), 0, str.length(), 34);
                tipText.setText(spannableString);
                Object a = com.baidu.adp.lib.resourceLoader.d.a().a(str2, 12, new Object[0]);
                if (a == null || !(a instanceof com.baidu.adp.widget.a.a)) {
                    aVar2 = null;
                } else {
                    aVar2 = (com.baidu.adp.widget.a.a) a;
                }
                if (aVar2 != null) {
                    tipImageHead.setImageBitmap(aVar2.h());
                } else {
                    tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.t.icon_choice_date));
                    e.setTag(str2);
                }
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(true);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                e.a(tipImageHead, true);
                waitButton.setVisibility(8);
                tipImageText.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case 4:
                tipText.setText(x.rand_chat_waiting_ready_chat);
                tipImageText.setBackgroundResource(com.baidu.tieba.t.bg_choice_join_s);
                tipImageText.setText(x.loading_view_ready);
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(8);
                tipImageText.setVisibility(0);
                e.a(tipImageHead, false);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case 5:
                tipText.setText(x.rand_chat_waiting_drop_down_tip);
                tipText.setVisibility(0);
                circelBgView.setVisibility(8);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(8);
                e.a(tipImageHead, false);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(0);
                quitButton.setVisibility(0);
                return;
            case 6:
                String str3 = (String) objArr[0];
                String str4 = (String) objArr[1];
                SpannableString spannableString2 = new SpannableString(String.valueOf(str3) + getString(x.rand_chat_waiting_quit));
                spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.r.tip_view_text_name_color)), 0, str3.length(), 34);
                tipText.setText(spannableString2);
                Object a2 = com.baidu.adp.lib.resourceLoader.d.a().a(str4, 12, new Object[0]);
                if (a2 == null || !(a2 instanceof com.baidu.adp.widget.a.a)) {
                    aVar = null;
                } else {
                    aVar = (com.baidu.adp.widget.a.a) a2;
                }
                if (aVar != null) {
                    tipImageHead.setImageBitmap(aVar.h());
                } else {
                    tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.t.icon_choice_date));
                    e.setTag(str4);
                }
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(true);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                e.a(tipImageHead, true);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case 7:
                long longValue = ((Long) objArr[0]).longValue();
                if (longValue < 60) {
                    tipText.setText(getString(x.rand_chat_waiting_wait_time_second, new Object[]{String.valueOf(longValue)}));
                } else {
                    tipText.setText(getString(x.rand_chat_waiting_wait_time_minute, new Object[]{String.valueOf(longValue / 60)}));
                }
                tipImageText.setBackgroundResource(com.baidu.tieba.t.bg_choice_join_n);
                tipImageText.setText(x.rand_chat_waiting_wait);
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(8);
                tipImageText.setVisibility(0);
                e.a(tipImageHead, false);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            case 8:
                e.setVisibility(8);
                return;
            case 9:
                tipText.setText(this.b.b());
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.t.icon_choice_date));
                tipText.setVisibility(0);
                circelBgView.setVisibility(0);
                circelBgView.setHasBg(false);
                circelBgView.invalidate();
                tipImageHead.setVisibility(0);
                e.a(tipImageHead, false);
                tipImageText.setVisibility(8);
                waitButton.setVisibility(8);
                quitButton.setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new w(this), 50L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.g();
        if (this.e != null) {
            this.e.a();
        }
        if (this.f != null) {
            this.f.a();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.f()) {
            k();
        } else if (view == this.a.d()) {
            com.baidu.tbadk.core.f.a(this, "rand_chat_wait_page_changebtn");
            l();
        } else {
            com.baidu.tieba.im.view.h c = this.a.c();
            if (c != null && c.a(view) && this.d != null) {
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
            this.f.a();
            this.f.b();
        }
    }

    private void k() {
        com.baidu.tieba.im.d.b.a((Context) this, (DialogInterface.OnClickListener) new i(this), (DialogInterface.OnClickListener) new j(this));
    }

    private void l() {
        com.baidu.tieba.im.d.b.b((Context) this, (DialogInterface.OnClickListener) new k(this), (DialogInterface.OnClickListener) new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.e != null) {
            this.e.a();
            this.e.b();
        }
        this.a.b().a();
        this.a.b().b();
        this.a.b().c();
        b(WaitingTipView.Type.CLEAR, (Object[]) null);
        f();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a(i);
    }

    private void n() {
        this.f = new m(this, 100000000L, 1000L);
    }

    private void o() {
        this.e = new n(this, 120000L, 120000L);
        this.e.a();
        this.e.b();
    }

    private void b(String str) {
        if (this.e != null) {
            this.e.a();
        }
        if (this.f != null) {
            this.f.a();
        }
        if (!this.h) {
            this.b.a(true);
            this.a.d().setEnabled(false);
            this.a.f().setEnabled(false);
            this.a.e().getQuitButton().setEnabled(false);
            this.a.b().getLoadingView().setVisibility(0);
            this.a.b().getChatterboxView().setVisibility(8);
            b(WaitingTipView.Type.PERSONS_READY, (Object[]) null);
            this.a.b().a(new o(this, str));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.b.e()) {
                k();
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
        userData.setUserIdLong(bVar.c);
        userData.setPortrait(bVar.e);
        userData.setUserName(bVar.d);
        return userData;
    }
}
