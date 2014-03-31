package com.baidu.tieba.im.randchat;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.model.bu;
import com.baidu.tieba.im.randchat.WaitingTipView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class WaittingActivity extends com.baidu.tbadk.a {
    private static /* synthetic */ int[] l;
    private f a;
    private bu b;
    private com.baidu.tieba.im.model.j c;
    private com.baidu.tbadk.coreExtra.c.b e;
    private com.baidu.tbadk.coreExtra.c.b f;
    private com.baidu.tieba.im.view.a d = null;
    private boolean g = false;
    private WaitingTipView.Type h = WaitingTipView.Type.ORIGINAL_ENTER;
    private com.baidu.adp.framework.c.a i = new h(this, 2001119);
    private com.baidu.adp.framework.c.g j = new p(this, 0);
    private BroadcastReceiver k = new q(this);

    private static /* synthetic */ int[] e() {
        int[] iArr = l;
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
            l = iArr;
        }
        return iArr;
    }

    public static void a(Context context, RandChatRoomData randChatRoomData, int i) {
        Intent intent = new Intent(context, WaittingActivity.class);
        intent.putExtra("randChatRoomData", randChatRoomData);
        intent.putExtra("startCount", i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new bu(this);
        this.b.a(getIntent());
        this.c = new com.baidu.tieba.im.model.j();
        this.c.setUniqueId(getUniqueId());
        this.a = new f(this);
        b();
        this.e = new n(this, 120000L, 120000L);
        this.e.a();
        this.e.b();
        this.f = new m(this, 100000000L, 1000L);
        c();
        this.b.a(this.j);
        this.b.a(this.i);
        this.c.registerListener(this.j);
        com.baidu.tbadk.core.g.b(this, "rand_chat_wait_page_start");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.k, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        unregisterReceiver(this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(WaittingActivity waittingActivity) {
        com.baidu.tbadk.core.g.a(waittingActivity, "rand_chat_wait_page_quit");
        waittingActivity.a.d().a();
        waittingActivity.showLoadingDialog(waittingActivity.getString(com.baidu.tieba.im.j.rand_chat_waiting_quit_loading));
        waittingActivity.b.a(waittingActivity.b.f().d(), false, 0);
    }

    private void a() {
        this.b.b(this.b.f().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.a.d().setShapeType(this.b.c());
        int bottomP = this.a.d().getBottomP();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.g().getLayoutParams();
        layoutParams.topMargin = bottomP;
        this.d = new com.baidu.tieba.im.view.a(this, com.baidu.tieba.im.k.NobackDialog);
        this.d.a(new r(this));
        a(this.b.f(), false);
        this.a.a(this);
        this.a.g().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(RandChatRoomData randChatRoomData) {
        UserData userData;
        return (randChatRoomData == null || randChatRoomData.j() == null || randChatRoomData.j().size() <= 0 || (userData = randChatRoomData.j().get(0)) == null || TbadkApplication.E() == null || !TbadkApplication.E().equals(String.valueOf(userData.getUserId()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RandChatRoomData randChatRoomData, boolean z) {
        a loadingView = this.a.d().getLoadingView();
        com.baidu.tieba.im.view.h chatterboxView = this.a.d().getChatterboxView();
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
    public void c() {
        List<UserData> j;
        this.b.a().clear();
        RandChatRoomData f = this.b.f();
        if (f != null && (j = f.j()) != null) {
            int size = j.size();
            if (size <= this.b.c()) {
                for (int i = 0; i < size; i++) {
                    this.a.d().a(i, j.get(i).getPortrait(), (e) null);
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
                a((String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(WaittingActivity waittingActivity, String str) {
        WaitingTipView g = waittingActivity.a.g();
        Object tag = g.getTag();
        if (tag != null && (tag instanceof String) && ((String) tag).equals(str)) {
            HeadImageView tipImageHead = g.getTipImageHead();
            com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(str);
            if (b != null) {
                tipImageHead.setImageBitmap(b.h());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(WaittingActivity waittingActivity, com.baidu.tieba.im.data.b bVar) {
        RandChatRoomData f;
        List<UserData> j;
        RandChatRoomData f2 = waittingActivity.b.f();
        if (bVar.b == f2.d() && bVar.g == waittingActivity.b.c()) {
            List<UserData> j2 = f2.j();
            if (j2 != null) {
                int size = j2.size();
                for (int i = 0; i < size; i++) {
                    UserData userData = j2.get(i);
                    if (userData != null && userData.getUserIdLong() == bVar.c) {
                        return;
                    }
                }
            }
            if (bVar.f != waittingActivity.b.d() + 1) {
                waittingActivity.a();
                return;
            }
            UserData a = a(bVar);
            String str = bVar.a;
            if (a != null && (f = waittingActivity.b.f()) != null && (j = f.j()) != null) {
                int size2 = j.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        if (size2 <= waittingActivity.b.c() - 1) {
                            j.add(a);
                            int d = waittingActivity.b.d();
                            waittingActivity.b.a(d + 1 <= waittingActivity.b.c() ? d + 1 : waittingActivity.b.c());
                            waittingActivity.a.d().a(size2, a.getPortrait(), new t(waittingActivity));
                            if (waittingActivity.b.d() < waittingActivity.b.c()) {
                                waittingActivity.a(WaitingTipView.Type.PERSON_ENTER, new Object[]{Integer.valueOf(waittingActivity.b.c() - waittingActivity.b.d()), a.getUserName(), a.getPortrait()});
                            }
                        }
                    } else if (j.get(i2) == null) {
                        j.set(i2, a);
                        int d2 = waittingActivity.b.d();
                        waittingActivity.b.a(d2 + 1 <= waittingActivity.b.c() ? d2 + 1 : waittingActivity.b.c());
                        waittingActivity.a.d().a(i2, a.getPortrait(), new s(waittingActivity));
                        if (waittingActivity.b.d() < waittingActivity.b.c()) {
                            waittingActivity.a(WaitingTipView.Type.PERSON_ENTER, new Object[]{Integer.valueOf(waittingActivity.b.c() - waittingActivity.b.d()), a.getUserName(), a.getPortrait()});
                        }
                    } else {
                        i2++;
                    }
                }
            }
            if (waittingActivity.b.d() == waittingActivity.b.c()) {
                waittingActivity.a((String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(WaittingActivity waittingActivity, com.baidu.tieba.im.data.b bVar) {
        RandChatRoomData f;
        List<UserData> j;
        boolean z;
        RandChatRoomData f2 = waittingActivity.b.f();
        if (bVar.b == f2.d()) {
            if (bVar.g == waittingActivity.b.c()) {
                if (bVar.f == waittingActivity.b.d() - 1) {
                    UserData a = a(bVar);
                    if (a != null && (f = waittingActivity.b.f()) != null && (j = f.j()) != null) {
                        int size = j.size();
                        int i = 0;
                        boolean z2 = false;
                        while (i < size) {
                            UserData userData = j.get(i);
                            if (userData == null || a.getUserId() != userData.getUserId()) {
                                z = z2;
                            } else if (i != 0) {
                                j.set(i, null);
                                int d = waittingActivity.b.d();
                                waittingActivity.b.a(d + (-1) >= 0 ? d - 1 : 0);
                                waittingActivity.a.d().a(i, (String) null, (e) null);
                                waittingActivity.a(WaitingTipView.Type.PERSON_LEAVE, new Object[]{a.getUserName(), a.getPortrait()});
                                z = z2;
                            } else {
                                z = true;
                            }
                            i++;
                            z2 = z;
                        }
                        if (z2) {
                            j.remove(0);
                            int d2 = waittingActivity.b.d();
                            waittingActivity.b.a(d2 + (-1) >= 0 ? d2 - 1 : 0);
                            waittingActivity.a.d().c();
                            Iterator<UserData> it = j.iterator();
                            while (it.hasNext() && it.next() == null) {
                                it.remove();
                            }
                            int size2 = j.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                UserData userData2 = j.get(i2);
                                if (userData2 != null) {
                                    waittingActivity.a.d().a(i2, userData2.getPortrait(), (e) null);
                                }
                            }
                            waittingActivity.a(WaitingTipView.Type.PERSON_LEAVE, new Object[]{a.getUserName(), a.getPortrait()});
                        }
                    }
                } else {
                    waittingActivity.a();
                }
            }
            waittingActivity.a(f2, true);
        }
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
        quitButton.setOnClickListener(new u(this));
        waitButton.setOnClickListener(new v(this));
        g.setVisibility(0);
        this.h = type;
        switch (e()[type.ordinal()]) {
            case 1:
                tipText.setText(getString(com.baidu.tieba.im.j.rand_chat_waiting_update_topic));
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.im.g.icon_choice_join));
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
            case 2:
                tipText.setText(getString(com.baidu.tieba.im.j.rand_chat_waiting_first_enter_success, new Object[]{Integer.valueOf(((Integer) objArr[0]).intValue())}));
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.im.g.icon_choice_join));
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
            case 3:
                int intValue = ((Integer) objArr[0]).intValue();
                String str = (String) objArr[1];
                String str2 = (String) objArr[2];
                SpannableString spannableString = new SpannableString(getString(com.baidu.tieba.im.j.rand_chat_waiting_other_enter_success, new Object[]{str, String.valueOf(intValue)}));
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.im.e.tip_view_text_name_color)), 0, str.length(), 34);
                tipText.setText(spannableString);
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(str2);
                if (b != null) {
                    tipImageHead.setImageBitmap(b.h());
                } else {
                    tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.im.g.icon_choice_date));
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
            case 4:
                tipText.setText(com.baidu.tieba.im.j.rand_chat_waiting_ready_chat);
                tipImageText.setBackgroundResource(com.baidu.tieba.im.g.bg_choice_join_s);
                tipImageText.setText(com.baidu.tieba.im.j.loading_view_ready);
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
            case 5:
                tipText.setText(com.baidu.tieba.im.j.rand_chat_waiting_drop_down_tip);
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
            case 6:
                String str3 = (String) objArr[0];
                String str4 = (String) objArr[1];
                SpannableString spannableString2 = new SpannableString(String.valueOf(str3) + getString(com.baidu.tieba.im.j.rand_chat_waiting_quit));
                spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.im.e.tip_view_text_name_color)), 0, str3.length(), 34);
                tipText.setText(spannableString2);
                com.baidu.adp.widget.ImageView.b b2 = com.baidu.tbadk.imageManager.e.a().b(str4);
                if (b2 != null) {
                    tipImageHead.setImageBitmap(b2.h());
                } else {
                    tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.im.g.icon_choice_date));
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
            case 7:
                long longValue = ((Long) objArr[0]).longValue();
                if (longValue < 60) {
                    tipText.setText(getString(com.baidu.tieba.im.j.rand_chat_waiting_wait_time_second, new Object[]{String.valueOf(longValue)}));
                } else {
                    tipText.setText(getString(com.baidu.tieba.im.j.rand_chat_waiting_wait_time_minute, new Object[]{String.valueOf(longValue / 60)}));
                }
                tipImageText.setBackgroundResource(com.baidu.tieba.im.g.bg_choice_join_n);
                tipImageText.setText(com.baidu.tieba.im.j.rand_chat_waiting_wait);
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
            case 8:
                g.setVisibility(8);
                return;
            case 9:
                tipText.setText(this.b.b());
                tipImageHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), com.baidu.tieba.im.g.icon_choice_date));
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
            default:
                return;
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new w(this), 50L);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.i();
        if (this.e != null) {
            this.e.a();
        }
        if (this.f != null) {
            this.f.a();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.h()) {
            d();
        } else if (view == this.a.f()) {
            com.baidu.tbadk.core.g.a(this, "rand_chat_wait_page_changebtn");
            k kVar = new k(this);
            new AlertDialog.Builder(this).setMessage(com.baidu.tieba.im.j.rand_chat_waiting_change_dialog).setPositiveButton(com.baidu.tieba.im.j.alert_yes_btn, kVar).setNeutralButton(com.baidu.tieba.im.j.alert_no_button, new l(this)).create().show();
        } else {
            com.baidu.tieba.im.view.h e = this.a.e();
            if (e != null && e.a(view) && this.d != null) {
                this.d.a(this.b.h());
                this.d.b(this.b.i());
                this.d.show();
            }
        }
    }

    public final void a(WaitingTipView.Type type, Object[] objArr) {
        LinkedList<Pair<WaitingTipView.Type, Object[]>> a = this.b.a();
        boolean isEmpty = a.isEmpty();
        a.addLast(new Pair<>(type, objArr));
        if (isEmpty) {
            this.f.a();
            this.f.b();
        }
    }

    private void d() {
        i iVar = new i(this);
        new AlertDialog.Builder(this).setTitle(com.baidu.tieba.im.j.del_post_tip).setMessage(com.baidu.tieba.im.j.rand_chat_waiting_quit_message).setPositiveButton(com.baidu.tieba.im.j.rand_chat_waiting_quit_yes, iVar).setNegativeButton(com.baidu.tieba.im.j.rand_chat_waiting_quit_no, new j(this)).create().show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(WaittingActivity waittingActivity) {
        if (waittingActivity.e != null) {
            waittingActivity.e.a();
            waittingActivity.e.b();
        }
        waittingActivity.a.d().a();
        waittingActivity.a.d().b();
        waittingActivity.a.d().c();
        waittingActivity.b(WaitingTipView.Type.CLEAR, (Object[]) null);
        com.baidu.tieba.im.f.h.a(String.valueOf(waittingActivity.b.f().d()));
        waittingActivity.showLoadingDialog(waittingActivity.getString(com.baidu.tieba.im.j.group_tab_enterchatroom_loading));
        waittingActivity.c.a(waittingActivity.b.f().d());
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.e != null) {
            this.e.a();
        }
        if (this.f != null) {
            this.f.a();
        }
        this.b.a(true);
        this.a.f().setEnabled(false);
        this.a.h().setEnabled(false);
        this.a.g().getQuitButton().setEnabled(false);
        this.a.d().getLoadingView().setVisibility(0);
        this.a.d().getChatterboxView().setVisibility(8);
        b(WaitingTipView.Type.PERSONS_READY, (Object[]) null);
        this.a.d().a(new o(this, str));
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.b.e()) {
                d();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static UserData a(com.baidu.tieba.im.data.b bVar) {
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
