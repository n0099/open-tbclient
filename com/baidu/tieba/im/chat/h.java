package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.editortool.ToolMoreView;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.widget.EggBreakerView;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class h extends com.baidu.adp.a.f implements com.baidu.tbadk.core.voice.y, com.baidu.tbadk.editortool.x {
    private static final String k = h.class.getName();
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private ImageView D;
    private ImageView E;
    private Button F;
    private EditText G;
    private ToolMoreView H;
    private LinearLayout I;
    private TextView J;
    private EggBreakerView K;
    private ct L;
    private final AlertDialog M;
    private FrameLayout N;
    private int O;
    private final int P;
    private final Handler Q;
    private w R;
    private VoiceData.VoiceModel S;
    private int T;
    private long U;
    protected NavigationBar a;
    protected View c;
    protected EmotionTabHost d;
    protected MsglistActivity e;
    protected AlertDialog f;
    protected AlertDialog g;
    protected AlertDialog h;
    protected AlertDialog i;
    protected boolean j;
    private final int l;
    private View m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private NoNetworkView q;
    private BdListView r;
    private ProgressBar s;
    private LinearLayout t;
    private ImageView u;
    private ImageView v;
    private RelativeLayout w;
    private TextView x;
    private ImageView y;
    private LinearLayout z;

    protected abstract void b(dn dnVar);

    protected abstract void c(dn dnVar);

    protected abstract void d(dn dnVar);

    protected abstract void e();

    protected abstract void e(dn dnVar);

    public h(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity);
        this.l = 100;
        this.a = null;
        this.m = null;
        this.n = null;
        this.c = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.d = null;
        this.I = null;
        this.J = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.M = null;
        this.N = null;
        this.O = 0;
        this.P = 5;
        this.Q = new i(this);
        this.j = true;
        this.T = 0;
        this.U = 0L;
        this.e = msglistActivity;
        msglistActivity.setContentView(com.baidu.tieba.im.i.msg_msglist_activity);
        a(msglistActivity, z);
        this.q = (NoNetworkView) msglistActivity.findViewById(com.baidu.tieba.im.h.view_no_network);
        this.r = (BdListView) msglistActivity.findViewById(com.baidu.tieba.im.h.lis_msg);
        this.s = (ProgressBar) msglistActivity.findViewById(com.baidu.tieba.im.h.msg_progress);
        this.s.setVisibility(8);
        this.L = new ct(msglistActivity);
        e();
        this.L.a(this.j);
        this.L.a((com.baidu.adp.lib.b.a) msglistActivity);
        this.L.a((com.baidu.adp.lib.b.b) msglistActivity);
        this.r.setAdapter((ListAdapter) this.L);
        this.r.setOnScrollListener(new m(this));
        this.r.setOnSrollToTopListener(msglistActivity);
        this.r.setOnSrollToBottomListener(msglistActivity);
        this.r.setItemsCanFocus(true);
        this.r.setFocusable(false);
        this.r.setFocusableInTouchMode(false);
        this.r.setClickable(false);
        this.r.setOnTouchListener(new n(this));
        this.r.setKybdsScrollBottom(true);
        this.r.setRecyclerListener(new o(this));
        this.t = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_voice);
        this.t.setVisibility(8);
        this.u = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_softkey);
        this.u.setOnClickListener(new p(this));
        this.v = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_more1);
        this.v.setOnClickListener(new r(this));
        this.w = (RelativeLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_voice);
        this.w.setOnTouchListener(msglistActivity);
        this.x = (TextView) msglistActivity.findViewById(com.baidu.tieba.im.h.tex_send_voice);
        this.z = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_voicelayer);
        this.z.setVisibility(8);
        this.y = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.img_msgsend_recording);
        this.A = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_voicelayer_short);
        this.B = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_voicelayer_cancel);
        this.C = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_text);
        this.C.setVisibility(0);
        this.D = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_govoice);
        this.D.setOnClickListener(new s(this));
        this.E = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_more2);
        this.E.setOnClickListener(new t(this));
        this.G = (EditText) msglistActivity.findViewById(com.baidu.tieba.im.h.edt_msgsend_text);
        this.G.setCursorVisible(false);
        this.G.setFocusable(true);
        this.G.setFocusableInTouchMode(true);
        this.G.addTextChangedListener(new v(this));
        this.G.setOnTouchListener(new j(this));
        this.F = (Button) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_send);
        this.F.setOnClickListener(msglistActivity);
        this.F.setEnabled(false);
        this.F.setTextColor(this.e.getResources().getColorStateList(com.baidu.tieba.im.e.post_image_btn_color));
        this.H = (ToolMoreView) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_more);
        this.H.setVisibility(8);
        this.H.setOnClickListener(msglistActivity);
        this.H.d();
        a(msglistActivity);
        this.I = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_last_msg);
        this.J = (TextView) msglistActivity.findViewById(com.baidu.tieba.im.h.text_last_msg);
        this.I.setOnClickListener(msglistActivity);
        this.N = (FrameLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_bottom_bar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(dn dnVar, boolean z) {
        this.a = (NavigationBar) dnVar.findViewById(com.baidu.tieba.im.h.lay_title_bar);
        this.m = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, dnVar);
        this.n = this.a.a("");
        View inflate = LayoutInflater.from(this.e).inflate(com.baidu.tieba.im.i.msg_chat_top_notify, (ViewGroup) null);
        this.o = (ImageView) inflate.findViewById(com.baidu.tieba.im.h.img_receiver);
        this.p = (ImageView) inflate.findViewById(com.baidu.tieba.im.h.img_close_notify);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        if (z) {
            J();
        } else {
            K();
        }
        this.K = (EggBreakerView) dnVar.findViewById(com.baidu.tieba.im.h.egg_breaker);
    }

    public final ct d() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(dn dnVar) {
        this.d = (EmotionTabHost) dnVar.findViewById(com.baidu.tieba.im.h.face_view);
        this.d.setOnDataSelected(this);
        this.d.setIsInChat(true);
        this.H.getFaceButton().setOnClickListener(new k(this));
    }

    public final FrameLayout f() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.H.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.t.setVisibility(8);
        this.C.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.t.setVisibility(0);
        this.C.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        W();
        this.G.requestFocus();
        a(this.G, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(h hVar) {
        hVar.G.requestFocus();
        hVar.d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        List<com.baidu.tieba.im.message.a.a> b = this.L.b();
        if (b != null && b.size() > 0) {
            this.r.setSelection(b.size() - 1);
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(h hVar) {
        if (hVar.H.getVisibility() != 0) {
            if (hVar.d.getVisibility() == 0) {
                hVar.d.setVisibility(8);
            }
            hVar.H.setVisibility(0);
        }
    }

    public final void a(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            this.L.a(i);
            this.L.a(msgPageData.getChatMessages());
            this.L.notifyDataSetInvalidated();
        }
    }

    public final void a(String str) {
        this.n.setText(str);
    }

    public final void g() {
        this.L.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i) {
        try {
            com.baidu.adp.lib.util.f.a(k, "doRefresh", "selection:" + i);
            if (msgPageData != null) {
                this.L.a();
                this.L.a(msgPageData.getChatMessages());
                this.L.notifyDataSetChanged();
                if (i >= 0) {
                    this.r.setSelection(i);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(k, "doRefresh", e.getMessage());
        }
    }

    public final void a(MsgPageData msgPageData) {
        b(msgPageData, -1);
    }

    public final void b(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null) {
            if (msgPageData != null) {
                try {
                    if (msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
                        com.baidu.adp.lib.util.f.e("++++++ num = " + size);
                        int i = size - 100;
                        com.baidu.adp.lib.util.f.e("++++++ removeCount= " + i);
                        for (int i2 = 0; i2 < i; i2++) {
                            msgPageData.getChatMessages().remove(0);
                        }
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b(k, "refreshGo2New", e.getMessage());
                    b(msgPageData, -1);
                    return;
                }
            }
            int size2 = msgPageData.getChatMessages().size();
            b(msgPageData, size2 > 0 ? size2 - 1 : 0);
        }
    }

    public final void c(MsgPageData msgPageData) {
        try {
            com.baidu.adp.lib.util.f.a(k, "refreshPrepage", "new:" + msgPageData.getNewAddNum());
            int firstVisiblePosition = this.r.getFirstVisiblePosition();
            com.baidu.adp.lib.util.f.e("pos" + firstVisiblePosition);
            if (msgPageData.getIsNewAdd()) {
                int newAddNum = msgPageData.getNewAddNum();
                com.baidu.adp.lib.util.f.e("num new " + newAddNum);
                int i = firstVisiblePosition + newAddNum;
                com.baidu.adp.lib.util.f.e("pos2" + i);
                b(msgPageData, i);
            } else {
                b(msgPageData, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(k, "refreshPrepage", e.getMessage());
            b(msgPageData, -1);
        }
    }

    public final String h() {
        String editable = this.G.getText().toString();
        if (TextUtils.isEmpty(editable)) {
            return null;
        }
        return editable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X() {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(k, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.G.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
    }

    public final void i() {
        this.G.setText("");
    }

    public final void b(String str) {
        String editable;
        String str2;
        if (this.G.getText().toString().equals("")) {
            str2 = "@" + str + " ";
        } else {
            str2 = String.valueOf(editable) + " @" + str + " ";
        }
        this.G.setText(str2);
        this.G.setSelection(str2.length());
        R();
        S();
        T();
        V();
    }

    public final void b(boolean z) {
        if (z) {
            this.w.setBackgroundResource(com.baidu.tieba.im.g.but_talk_s);
            this.x.setText(this.e.getString(com.baidu.tieba.im.j.msglist_no_push));
            return;
        }
        this.w.setBackgroundResource(com.baidu.tieba.im.g.but_talk_n);
        this.x.setText(this.e.getString(com.baidu.tieba.im.j.msglist_push_talk));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ab, code lost:
        if (r9.r.getLastVisiblePosition() != ((r3.size() - k()) - r2)) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(MsgPageData msgPageData) {
        boolean z = true;
        if (msgPageData != null) {
            try {
                com.baidu.adp.lib.util.f.a(k, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
                if (msgPageData.getIsNewAdd()) {
                    int newAddNum = msgPageData.getNewAddNum();
                    List<com.baidu.tieba.im.message.a.a> b = this.L.b();
                    if (b != null) {
                        if (b.size() > newAddNum) {
                            com.baidu.adp.lib.util.f.e("simon", "checkListAtNew", "lastVisiblePosition = " + this.r.getLastVisiblePosition());
                            com.baidu.adp.lib.util.f.e("simon", "checkListAtNew", "data.size = " + b.size());
                            com.baidu.adp.lib.util.f.e("simon", "checkListAtNew", "num = " + newAddNum);
                        }
                    }
                    z = false;
                } else {
                    z = false;
                }
                if (z) {
                    b(msgPageData);
                    return;
                }
                b(msgPageData, -1);
                if (msgPageData.getNewAddNum() > 0 && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() > 0) {
                    com.baidu.tieba.im.message.a.a aVar = msgPageData.getChatMessages().get(msgPageData.getChatMessages().size() - 1);
                    if (aVar == null || com.baidu.tieba.im.f.q.d(aVar)) {
                        return;
                    }
                    String h = com.baidu.tieba.im.f.q.h(aVar);
                    if (!TextUtils.isEmpty(h)) {
                        this.I.setVisibility(0);
                        this.J.setText(h);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(k, "refreshCheckNew", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public final BdListView j() {
        return this.r;
    }

    protected int k() {
        return 1;
    }

    public final void l() {
        this.z.setVisibility(0);
    }

    public final void m() {
        this.z.setVisibility(8);
    }

    public final void n() {
        this.A.setVisibility(8);
    }

    public final void o() {
        this.B.setVisibility(0);
    }

    public final void p() {
        this.B.setVisibility(8);
    }

    public final void q() {
        if (this.I.getVisibility() == 0) {
            this.I.setVisibility(8);
            this.J.setText("");
        }
    }

    public final void a(int i) {
        b(this.e);
        this.f.getListView().setTag(Integer.valueOf(i));
        this.f.show();
    }

    public final void d(int i) {
        c(this.e);
        this.g.getListView().setTag(Integer.valueOf(i));
        this.g.show();
    }

    public final void e(int i) {
        d(this.e);
        this.h.getListView().setTag(Integer.valueOf(i));
        this.h.show();
    }

    public final void f(int i) {
        e(this.e);
        if (this.i != null) {
            this.i.getListView().setTag(Integer.valueOf(i));
            this.i.show();
        }
    }

    public final void r() {
        this.s.setVisibility(8);
    }

    public final void s() {
        this.q.setVisible(true);
    }

    public final void t() {
        this.q.setVisible(false);
    }

    public final boolean u() {
        return this.d.getVisibility() == 0 || this.H.getVisibility() == 0;
    }

    public final void v() {
        if (this.d.getVisibility() == 0) {
            this.d.setVisibility(8);
        }
        if (this.H.getVisibility() == 0) {
            this.H.setVisibility(8);
        }
    }

    public final View w() {
        return this.m;
    }

    public final Button x() {
        return this.F;
    }

    public final View y() {
        return this.H.getCameraButton();
    }

    public final View z() {
        return this.H.getImageButton();
    }

    public final View A() {
        return this.c;
    }

    public final RelativeLayout B() {
        return this.w;
    }

    public final AlertDialog C() {
        return this.f;
    }

    public final AlertDialog D() {
        return this.g;
    }

    public final AlertDialog E() {
        return this.h;
    }

    public final AlertDialog F() {
        return this.i;
    }

    public final LinearLayout G() {
        return this.I;
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void a(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void a(int i, String str) {
        if (!com.baidu.adp.lib.util.n.a(str)) {
            com.baidu.adp.lib.util.f.d("----record error. " + i + "---errMsg:" + str);
            if (i == 3) {
                this.e.showToast(str);
                m();
            } else if (i == 2) {
                p();
                n();
                this.A.setVisibility(0);
                this.Q.sendMessageDelayed(this.Q.obtainMessage(1), 500L);
            } else {
                this.e.showToast(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void a(String str, int i) {
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.S = voiceModel;
        if (this.R != null) {
            this.R.a(voiceModel);
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void a() {
        this.S = null;
        if (this.R != null) {
            w wVar = this.R;
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void b(int i) {
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void c(int i) {
        this.T = Math.max(i, this.T);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.U > 150) {
            this.T = 0;
            this.U = uptimeMillis;
        }
        this.O++;
        if (this.O % 5 == 0) {
            this.O = 0;
            if (this.T < 2) {
                this.y.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_zero);
            } else if (this.T < 10) {
                this.y.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_one);
            } else if (this.T < 20) {
                this.y.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_two);
            } else {
                if (this.T >= 30) {
                    if (this.T < 40) {
                        this.y.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_four);
                        return;
                    } else if (this.T < 50) {
                        this.y.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_five);
                        return;
                    }
                }
                this.y.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    public final void a(w wVar) {
        this.R = wVar;
    }

    public final void H() {
        this.o.setVisibility(8);
    }

    public final void I() {
        this.o.setVisibility(0);
    }

    public final void J() {
        this.p.setVisibility(8);
    }

    public final void K() {
        this.p.setVisibility(0);
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.G.setText(jSONObject.getString("input_draft"));
                this.G.setSelection(this.G.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    U();
                } else {
                    T();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final String L() {
        String str;
        if (this.C.getVisibility() == 0) {
            str = "input_text";
        } else {
            str = "input_voice";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("input_draft", this.G.getText().toString());
        hashMap.put("input_status", str);
        return new Gson().toJson(hashMap);
    }

    public final void M() {
        if (this.Q != null) {
            this.Q.removeMessages(1);
        }
    }

    public final void a(int i, com.baidu.tieba.im.message.a.a aVar) {
        aVar.d(i);
        this.L.c();
    }

    public final void N() {
        this.a.b(0);
        this.q.a(0);
        this.d.b(0);
        this.H.a(0);
    }

    public final com.baidu.tbadk.editortool.aa O() {
        if (this.L != null) {
            return this.L.d();
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.x
    public final void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.d)) {
                com.baidu.tbadk.coreExtra.data.d dVar = (com.baidu.tbadk.coreExtra.data.d) obj;
                EmotionGroupType b = dVar.b();
                String a = dVar.a();
                if (b == EmotionGroupType.LOCAL) {
                    if (a != null) {
                        this.G.getText().insert(this.G.getSelectionStart(), a);
                    }
                } else if (a != null) {
                    this.e.a(dVar);
                }
            }
        } else if (i == 21 && this.G.getSelectionStart() > 0) {
            String substring = this.G.getText().toString().substring(0, this.G.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            if (matcher.find()) {
                this.G.getText().delete(this.G.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.G.getSelectionStart());
                return;
            }
            this.G.getText().delete(this.G.getSelectionStart() - 1, this.G.getSelectionStart());
        }
    }

    public final void P() {
        this.H.getCameraButton().setEnabled(false);
        this.H.getImageButton().setEnabled(false);
        this.w.setEnabled(false);
        this.D.setEnabled(false);
        this.H.getFaceButton().setEnabled(false);
        this.v.setEnabled(false);
        this.E.setEnabled(false);
        this.G.setEnabled(false);
        this.F.setEnabled(false);
    }

    public final EggBreakerView Q() {
        return this.K;
    }
}
