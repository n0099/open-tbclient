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
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class h extends com.baidu.adp.a.f implements com.baidu.tbadk.core.voice.y, com.baidu.tbadk.editortool.x {
    private static final String l = h.class.getName();
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private ImageView E;
    private ImageView F;
    private Button G;
    private EditText H;
    private ToolMoreView I;
    private LinearLayout J;
    private TextView K;
    private cp L;
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
    protected AlertDialog j;
    protected boolean k;
    private final int m;
    private View n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private NoNetworkView r;
    private BdListView s;
    private ProgressBar t;
    private LinearLayout u;
    private ImageView v;
    private ImageView w;
    private RelativeLayout x;
    private TextView y;
    private ImageView z;

    protected abstract void b(dj djVar);

    protected abstract void c(dj djVar);

    protected abstract void d(dj djVar);

    protected abstract void e();

    protected abstract void e(dj djVar);

    protected abstract void f(dj djVar);

    public h(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity);
        this.m = 100;
        this.a = null;
        this.n = null;
        this.o = null;
        this.c = null;
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
        this.I = null;
        this.d = null;
        this.J = null;
        this.K = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.M = null;
        this.N = null;
        this.O = 0;
        this.P = 5;
        this.Q = new i(this);
        this.k = true;
        this.T = 0;
        this.U = 0L;
        this.e = msglistActivity;
        msglistActivity.setContentView(com.baidu.tieba.im.i.msg_msglist_activity);
        a(msglistActivity, z);
        this.r = (NoNetworkView) msglistActivity.findViewById(com.baidu.tieba.im.h.view_no_network);
        this.s = (BdListView) msglistActivity.findViewById(com.baidu.tieba.im.h.lis_msg);
        this.t = (ProgressBar) msglistActivity.findViewById(com.baidu.tieba.im.h.msg_progress);
        this.t.setVisibility(8);
        this.L = new cp(msglistActivity);
        e();
        this.L.a(this.k);
        this.L.a((com.baidu.adp.lib.b.a) msglistActivity);
        this.L.a((com.baidu.adp.lib.b.b) msglistActivity);
        this.s.setAdapter((ListAdapter) this.L);
        this.s.setOnScrollListener(new m(this));
        this.s.setOnSrollToTopListener(msglistActivity);
        this.s.setOnSrollToBottomListener(msglistActivity);
        this.s.setItemsCanFocus(true);
        this.s.setFocusable(false);
        this.s.setFocusableInTouchMode(false);
        this.s.setClickable(false);
        this.s.setOnTouchListener(new n(this));
        this.s.setKybdsScrollBottom(true);
        this.s.setRecyclerListener(new o(this));
        this.u = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_voice);
        this.u.setVisibility(8);
        this.v = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_softkey);
        this.v.setOnClickListener(new p(this));
        this.w = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_more1);
        this.w.setOnClickListener(new r(this));
        this.x = (RelativeLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_voice);
        this.x.setOnTouchListener(msglistActivity);
        this.y = (TextView) msglistActivity.findViewById(com.baidu.tieba.im.h.tex_send_voice);
        this.A = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_voicelayer);
        this.A.setVisibility(8);
        this.z = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.img_msgsend_recording);
        this.B = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_voicelayer_short);
        this.C = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_voicelayer_cancel);
        this.D = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_text);
        this.D.setVisibility(0);
        this.E = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_govoice);
        this.E.setOnClickListener(new s(this));
        this.F = (ImageView) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_more2);
        this.F.setOnClickListener(new t(this));
        this.H = (EditText) msglistActivity.findViewById(com.baidu.tieba.im.h.edt_msgsend_text);
        this.H.setCursorVisible(false);
        this.H.setFocusable(true);
        this.H.setFocusableInTouchMode(true);
        this.H.addTextChangedListener(new v(this));
        this.H.setOnTouchListener(new j(this));
        this.G = (Button) msglistActivity.findViewById(com.baidu.tieba.im.h.btn_msgsend_send);
        this.G.setOnClickListener(msglistActivity);
        this.G.setEnabled(false);
        this.G.setTextColor(this.e.getResources().getColorStateList(com.baidu.tieba.im.e.post_image_btn_color));
        this.I = (ToolMoreView) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_msgsend_more);
        this.I.setVisibility(8);
        this.I.setOnClickListener(msglistActivity);
        this.I.d();
        a(msglistActivity);
        this.J = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_last_msg);
        this.K = (TextView) msglistActivity.findViewById(com.baidu.tieba.im.h.text_last_msg);
        this.J.setOnClickListener(msglistActivity);
        this.N = (FrameLayout) msglistActivity.findViewById(com.baidu.tieba.im.h.lay_bottom_bar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(dj djVar, boolean z) {
        this.a = (NavigationBar) djVar.findViewById(com.baidu.tieba.im.h.lay_title_bar);
        this.n = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, djVar);
        this.o = this.a.a("");
        View inflate = LayoutInflater.from(this.e).inflate(com.baidu.tieba.im.i.msg_chat_top_notify, (ViewGroup) null);
        this.p = (ImageView) inflate.findViewById(com.baidu.tieba.im.h.img_receiver);
        this.q = (ImageView) inflate.findViewById(com.baidu.tieba.im.h.img_close_notify);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        if (z) {
            K();
        } else {
            L();
        }
    }

    public final cp d() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(dj djVar) {
        this.d = (EmotionTabHost) djVar.findViewById(com.baidu.tieba.im.h.face_view);
        this.d.setOnDataSelected(this);
        this.d.setIsInChat(true);
        this.I.getFaceButton().setOnClickListener(new k(this));
    }

    public final FrameLayout f() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.I.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.u.setVisibility(8);
        this.D.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.u.setVisibility(0);
        this.D.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        W();
        this.H.requestFocus();
        a(this.H, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(h hVar) {
        hVar.H.requestFocus();
        hVar.d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        List<com.baidu.tieba.im.message.a.a> b = this.L.b();
        if (b != null && b.size() > 0) {
            this.s.setSelection(b.size() - 1);
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(h hVar) {
        if (hVar.I.getVisibility() != 0) {
            if (hVar.d.getVisibility() == 0) {
                hVar.d.setVisibility(8);
            }
            hVar.I.setVisibility(0);
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
        this.o.setText(str);
    }

    public final void g() {
        this.L.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i) {
        try {
            com.baidu.adp.lib.util.f.a(l, "doRefresh", "selection:" + i);
            if (msgPageData != null) {
                this.L.a();
                this.L.a(msgPageData.getChatMessages());
                this.L.notifyDataSetChanged();
                if (i >= 0) {
                    this.s.setSelection(i);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(l, "doRefresh", e.getMessage());
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
                    com.baidu.adp.lib.util.f.b(l, "refreshGo2New", e.getMessage());
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
            com.baidu.adp.lib.util.f.a(l, "refreshPrepage", "new:" + msgPageData.getNewAddNum());
            int firstVisiblePosition = this.s.getFirstVisiblePosition();
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
            com.baidu.adp.lib.util.f.b(l, "refreshPrepage", e.getMessage());
            b(msgPageData, -1);
        }
    }

    public final String h() {
        String editable = this.H.getText().toString();
        if (TextUtils.isEmpty(editable)) {
            return null;
        }
        return editable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X() {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(l, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.H.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
    }

    public final void i() {
        this.H.setText("");
    }

    public final void b(String str) {
        String editable;
        String str2;
        if (this.H.getText().toString().equals("")) {
            str2 = "@" + str + " ";
        } else {
            str2 = String.valueOf(editable) + " @" + str + " ";
        }
        this.H.setText(str2);
        this.H.setSelection(str2.length());
        R();
        S();
        T();
        V();
    }

    public final void b(boolean z) {
        if (z) {
            this.x.setBackgroundResource(com.baidu.tieba.im.g.but_talk_s);
            this.y.setText(this.e.getString(com.baidu.tieba.im.j.msglist_no_push));
            return;
        }
        this.x.setBackgroundResource(com.baidu.tieba.im.g.but_talk_n);
        this.y.setText(this.e.getString(com.baidu.tieba.im.j.msglist_push_talk));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ab, code lost:
        if (r9.s.getLastVisiblePosition() != ((r3.size() - k()) - r2)) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(MsgPageData msgPageData) {
        boolean z = true;
        if (msgPageData != null) {
            try {
                com.baidu.adp.lib.util.f.a(l, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
                if (msgPageData.getIsNewAdd()) {
                    int newAddNum = msgPageData.getNewAddNum();
                    List<com.baidu.tieba.im.message.a.a> b = this.L.b();
                    if (b != null) {
                        if (b.size() > newAddNum) {
                            com.baidu.adp.lib.util.f.e("simon", "checkListAtNew", "lastVisiblePosition = " + this.s.getLastVisiblePosition());
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
                        this.J.setVisibility(0);
                        this.K.setText(h);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(l, "refreshCheckNew", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public final BdListView j() {
        return this.s;
    }

    protected int k() {
        return 1;
    }

    public final void l() {
        this.A.setVisibility(0);
    }

    public final void m() {
        this.A.setVisibility(8);
    }

    public final void n() {
        this.B.setVisibility(8);
    }

    public final void o() {
        this.C.setVisibility(0);
    }

    public final void p() {
        this.C.setVisibility(8);
    }

    public final void q() {
        if (this.J.getVisibility() == 0) {
            this.J.setVisibility(8);
            this.K.setText("");
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

    public final void g(int i) {
        f(this.e);
        if (this.j != null) {
            this.j.getListView().setTag(Integer.valueOf(i));
            this.j.show();
        }
    }

    public final void r() {
        this.t.setVisibility(8);
    }

    public final void s() {
        this.r.setVisible(true);
    }

    public final void t() {
        this.r.setVisible(false);
    }

    public final boolean u() {
        return this.d.getVisibility() == 0 || this.I.getVisibility() == 0;
    }

    public final void v() {
        if (this.d.getVisibility() == 0) {
            this.d.setVisibility(8);
        }
        if (this.I.getVisibility() == 0) {
            this.I.setVisibility(8);
        }
    }

    public final View w() {
        return this.n;
    }

    public final Button x() {
        return this.G;
    }

    public final View y() {
        return this.I.getCameraButton();
    }

    public final View z() {
        return this.I.getImageButton();
    }

    public final View A() {
        return this.c;
    }

    public final RelativeLayout B() {
        return this.x;
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

    public final AlertDialog G() {
        return this.j;
    }

    public final LinearLayout H() {
        return this.J;
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void a(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void a(int i, String str) {
        if (!com.baidu.adp.lib.util.o.a(str)) {
            com.baidu.adp.lib.util.f.d("----record error. " + i + "---errMsg:" + str);
            if (i == 3) {
                this.e.showToast(str);
                m();
            } else if (i == 2) {
                p();
                n();
                this.B.setVisibility(0);
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
                this.z.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_zero);
            } else if (this.T < 10) {
                this.z.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_one);
            } else if (this.T < 20) {
                this.z.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_two);
            } else {
                if (this.T >= 30) {
                    if (this.T < 40) {
                        this.z.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_four);
                        return;
                    } else if (this.T < 50) {
                        this.z.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_five);
                        return;
                    }
                }
                this.z.setImageResource(com.baidu.tieba.im.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    public final void a(w wVar) {
        this.R = wVar;
    }

    public final void I() {
        this.p.setVisibility(8);
    }

    public final void J() {
        this.p.setVisibility(0);
    }

    public final void K() {
        this.q.setVisibility(8);
    }

    public final void L() {
        this.q.setVisibility(0);
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.H.setText(jSONObject.getString("input_draft"));
                this.H.setSelection(this.H.getText().toString().length());
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

    public final String M() {
        String str;
        if (this.D.getVisibility() == 0) {
            str = "input_text";
        } else {
            str = "input_voice";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("input_draft", this.H.getText().toString());
        hashMap.put("input_status", str);
        return new Gson().toJson(hashMap);
    }

    public final void N() {
        if (this.Q != null) {
            this.Q.removeMessages(1);
        }
    }

    public final void a(int i, com.baidu.tieba.im.message.a.a aVar) {
        aVar.d(i);
        this.L.c();
    }

    public final void O() {
        this.a.b(0);
        this.r.a(0);
        this.d.b(0);
        this.I.a(0);
    }

    public final com.baidu.tbadk.editortool.ab P() {
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
                        this.H.getText().insert(this.H.getSelectionStart(), a);
                    }
                } else if (a != null) {
                    this.e.a(dVar);
                }
            }
        } else if (i == 21 && this.H.getSelectionStart() > 0) {
            String substring = this.H.getText().toString().substring(0, this.H.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            if (matcher.find()) {
                this.H.getText().delete(this.H.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.H.getSelectionStart());
                return;
            }
            this.H.getText().delete(this.H.getSelectionStart() - 1, this.H.getSelectionStart());
        }
    }

    public final void Q() {
        this.I.getCameraButton().setEnabled(false);
        this.I.getImageButton().setEnabled(false);
        this.x.setEnabled(false);
        this.E.setEnabled(false);
        this.I.getFaceButton().setEnabled(false);
        this.w.setEnabled(false);
        this.F.setEnabled(false);
        this.H.setEnabled(false);
        this.G.setEnabled(false);
    }
}
