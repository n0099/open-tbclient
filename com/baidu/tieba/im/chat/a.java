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
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.baidu.tieba.editortool.EmotionTabHost;
import com.baidu.tieba.editortool.ToolMoreView;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.widget.EggBreakerView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.adp.a.e implements com.baidu.tieba.editortool.aa, com.baidu.tieba.voice.ae {
    private static final String k = a.class.getName();
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
    private MsglistActivity L;
    private cg M;
    private AlertDialog N;
    private FrameLayout O;
    private int P;
    private int Q;
    private Handler R;
    private p S;
    private VoiceManager.VoiceModel T;
    private int U;
    private long V;
    protected NavigationBar a;
    protected View c;
    protected ImageView d;
    protected EmotionTabHost e;
    protected AlertDialog f;
    protected AlertDialog g;
    protected AlertDialog h;
    protected AlertDialog i;
    protected int j;
    private final int l;
    private ImageView m;
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

    protected abstract void b(cy cyVar);

    protected abstract void c(cy cyVar);

    protected abstract void d(cy cyVar);

    protected abstract void e(cy cyVar);

    public a(MsglistActivity msglistActivity, boolean z, int i) {
        super(msglistActivity);
        this.l = 100;
        this.a = null;
        this.m = null;
        this.n = null;
        this.c = null;
        this.d = null;
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
        this.e = null;
        this.I = null;
        this.J = null;
        this.L = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.N = null;
        this.O = null;
        this.P = 0;
        this.Q = 5;
        this.j = 0;
        this.R = new b(this);
        this.U = 0;
        this.V = 0L;
        this.L = msglistActivity;
        this.j = i;
        msglistActivity.setContentView(R.layout.msg_msglist_activity);
        a(msglistActivity, z);
        this.q = (NoNetworkView) msglistActivity.findViewById(R.id.view_no_network);
        this.r = (BdListView) msglistActivity.findViewById(R.id.lis_msg);
        this.s = (ProgressBar) msglistActivity.findViewById(R.id.msg_progress);
        this.s.setVisibility(8);
        this.M = new cg(msglistActivity, this.j);
        this.M.a((com.baidu.adp.lib.b.a) msglistActivity);
        this.M.a((com.baidu.adp.lib.b.b) msglistActivity);
        this.r.setAdapter((ListAdapter) this.M);
        this.r.setOnScrollListener(new f(this));
        this.r.setOnSrollToTopListener(msglistActivity);
        this.r.setOnSrollToBottomListener(msglistActivity);
        this.r.setItemsCanFocus(true);
        this.r.setFocusable(false);
        this.r.setFocusableInTouchMode(false);
        this.r.setClickable(false);
        this.r.setOnTouchListener(new g(this));
        this.r.setKybdsScrollBottom(true);
        this.r.setRecyclerListener(new h(this));
        this.t = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voice);
        this.t.setVisibility(8);
        this.u = (ImageView) msglistActivity.findViewById(R.id.btn_msgsend_softkey);
        this.u.setOnClickListener(new i(this));
        this.v = (ImageView) msglistActivity.findViewById(R.id.btn_msgsend_more1);
        this.v.setOnClickListener(new k(this));
        this.w = (RelativeLayout) msglistActivity.findViewById(R.id.btn_msgsend_voice);
        this.w.setOnTouchListener(msglistActivity);
        this.x = (TextView) msglistActivity.findViewById(R.id.tex_send_voice);
        this.z = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer);
        this.z.setVisibility(8);
        this.y = (ImageView) msglistActivity.findViewById(R.id.img_msgsend_recording);
        this.A = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer_short);
        this.B = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer_cancel);
        this.C = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_text);
        this.C.setVisibility(0);
        this.D = (ImageView) msglistActivity.findViewById(R.id.btn_msgsend_govoice);
        this.D.setOnClickListener(new l(this));
        this.E = (ImageView) msglistActivity.findViewById(R.id.btn_msgsend_more2);
        this.E.setOnClickListener(new m(this));
        this.G = (EditText) msglistActivity.findViewById(R.id.edt_msgsend_text);
        this.G.setCursorVisible(false);
        this.G.setFocusable(true);
        this.G.setFocusableInTouchMode(true);
        this.G.addTextChangedListener(new o(this));
        this.G.setOnTouchListener(new c(this));
        this.F = (Button) msglistActivity.findViewById(R.id.btn_msgsend_send);
        this.F.setOnClickListener(msglistActivity);
        this.F.setEnabled(false);
        this.F.setTextColor(this.L.getResources().getColorStateList(R.color.post_image_btn_color));
        this.H = (ToolMoreView) msglistActivity.findViewById(R.id.lay_msgsend_more);
        this.H.setVisibility(8);
        this.H.setOnClickListener(msglistActivity);
        this.H.b();
        a(msglistActivity);
        this.I = (LinearLayout) msglistActivity.findViewById(R.id.lay_last_msg);
        this.J = (TextView) msglistActivity.findViewById(R.id.text_last_msg);
        this.I.setOnClickListener(msglistActivity);
        this.O = (FrameLayout) msglistActivity.findViewById(R.id.lay_bottom_bar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(cy cyVar, boolean z) {
        this.a = (NavigationBar) cyVar.findViewById(R.id.lay_title_bar);
        this.m = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, cyVar);
        this.n = this.a.a("");
        cyVar.getLayoutInflater();
        View inflate = LayoutInflater.from(this.L).inflate(R.layout.msg_chat_top_notify, (ViewGroup) null);
        this.o = (ImageView) inflate.findViewById(R.id.img_receiver);
        this.p = (ImageView) inflate.findViewById(R.id.img_close_notify);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        if (z) {
            H();
        } else {
            I();
        }
        this.K = (EggBreakerView) cyVar.findViewById(R.id.egg_breaker);
    }

    public final cg a() {
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(cy cyVar) {
        this.e = (EmotionTabHost) cyVar.findViewById(R.id.face_view);
        this.e.setOnDataSelected(this);
        this.e.setIsInChat(true);
        this.H.getFaceButton().setOnClickListener(new d(this));
    }

    public final FrameLayout d() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.H.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.t.setVisibility(8);
        this.C.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.t.setVisibility(0);
        this.C.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        U();
        this.G.requestFocus();
        a(this.G, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(a aVar) {
        aVar.G.requestFocus();
        aVar.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        List<com.baidu.tieba.im.message.b> b = this.M.b();
        if (b != null && b.size() > 0) {
            this.r.setSelection(b.size() - 1);
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(a aVar) {
        if (aVar.H.getVisibility() != 0) {
            if (aVar.e.getVisibility() == 0) {
                aVar.e.setVisibility(8);
            }
            aVar.H.setVisibility(0);
        }
    }

    public final void a(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            this.M.a(i);
            this.M.a(msgPageData.getChatMessages());
            this.M.notifyDataSetInvalidated();
        }
    }

    public final void a(String str) {
        this.n.setText(str);
    }

    public final void e() {
        this.M.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i) {
        try {
            com.baidu.adp.lib.util.e.a(k, "doRefresh", "selection:" + i);
            if (msgPageData != null) {
                this.M.a();
                this.M.a(msgPageData.getChatMessages());
                this.M.notifyDataSetChanged();
                if (i >= 0) {
                    this.r.setSelection(i);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(k, "doRefresh", e.getMessage());
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
                        com.baidu.adp.lib.util.e.e("++++++ num = " + size);
                        int i = size - 100;
                        com.baidu.adp.lib.util.e.e("++++++ removeCount= " + i);
                        for (int i2 = 0; i2 < i; i2++) {
                            msgPageData.getChatMessages().remove(0);
                        }
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b(k, "refreshGo2New", e.getMessage());
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
            com.baidu.adp.lib.util.e.a(k, "refreshPrepage", "new:" + msgPageData.getNewAddNum());
            int firstVisiblePosition = this.r.getFirstVisiblePosition();
            com.baidu.adp.lib.util.e.e("pos" + firstVisiblePosition);
            if (msgPageData.getIsNewAdd()) {
                int newAddNum = msgPageData.getNewAddNum();
                com.baidu.adp.lib.util.e.e("num new " + newAddNum);
                int i = firstVisiblePosition + newAddNum;
                com.baidu.adp.lib.util.e.e("pos2" + i);
                b(msgPageData, i);
            } else {
                b(msgPageData, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(k, "refreshPrepage", e.getMessage());
            b(msgPageData, -1);
        }
    }

    public final String f() {
        String editable = this.G.getText().toString();
        if (TextUtils.isEmpty(editable)) {
            return null;
        }
        return editable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V() {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(k, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.G.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
    }

    public final void g() {
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
        P();
        Q();
        R();
        T();
    }

    public final void a(boolean z) {
        if (z) {
            this.w.setBackgroundResource(R.drawable.but_talk_s);
            this.x.setText(this.L.getString(R.string.msglist_no_push));
            return;
        }
        this.w.setBackgroundResource(R.drawable.but_talk_n);
        this.x.setText(this.L.getString(R.string.msglist_push_talk));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ad, code lost:
        if (r9.r.getLastVisiblePosition() != ((r4.size() - (r9.j == 2 ? 0 : 1)) - r3)) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(MsgPageData msgPageData) {
        boolean z = true;
        if (msgPageData != null) {
            try {
                com.baidu.adp.lib.util.e.a(k, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
                if (msgPageData.getIsNewAdd()) {
                    int newAddNum = msgPageData.getNewAddNum();
                    List<com.baidu.tieba.im.message.b> b = this.M.b();
                    if (b != null) {
                        if (b.size() > newAddNum) {
                            com.baidu.adp.lib.util.e.e("simon", "checkListAtNew", "lastVisiblePosition = " + this.r.getLastVisiblePosition());
                            com.baidu.adp.lib.util.e.e("simon", "checkListAtNew", "data.size = " + b.size());
                            com.baidu.adp.lib.util.e.e("simon", "checkListAtNew", "num = " + newAddNum);
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
                    com.baidu.tieba.im.message.b bVar = msgPageData.getChatMessages().get(msgPageData.getChatMessages().size() - 1);
                    if (bVar == null || com.baidu.tieba.im.util.l.d(bVar)) {
                        return;
                    }
                    String h = com.baidu.tieba.im.util.l.h(bVar);
                    if (!TextUtils.isEmpty(h)) {
                        this.I.setVisibility(0);
                        this.J.setText(h);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(k, "refreshCheckNew", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public final BdListView h() {
        return this.r;
    }

    public final void i() {
        this.z.setVisibility(0);
    }

    public final void j() {
        this.z.setVisibility(8);
    }

    public final void k() {
        this.A.setVisibility(8);
    }

    public final void l() {
        this.B.setVisibility(0);
    }

    public final void m() {
        this.B.setVisibility(8);
    }

    public final void n() {
        if (this.I.getVisibility() == 0) {
            this.I.setVisibility(8);
            this.J.setText("");
        }
    }

    public final void a(int i) {
        b(this.L);
        this.f.getListView().setTag(Integer.valueOf(i));
        this.f.show();
    }

    public final void b(int i) {
        c(this.L);
        this.g.getListView().setTag(Integer.valueOf(i));
        this.g.show();
    }

    public final void c(int i) {
        d(this.L);
        this.h.getListView().setTag(Integer.valueOf(i));
        this.h.show();
    }

    public final void d(int i) {
        e(this.L);
        this.i.getListView().setTag(Integer.valueOf(i));
        this.i.show();
    }

    public final void o() {
        this.s.setVisibility(8);
    }

    public final void p() {
        this.q.setVisible(true);
    }

    public final void q() {
        this.q.setVisible(false);
    }

    public final boolean r() {
        return this.e.getVisibility() == 0 || this.H.getVisibility() == 0;
    }

    public final void s() {
        if (this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
        }
        if (this.H.getVisibility() == 0) {
            this.H.setVisibility(8);
        }
    }

    public final ImageView t() {
        return this.m;
    }

    public final Button u() {
        return this.F;
    }

    public final View v() {
        return this.H.getCameraButton();
    }

    public final View w() {
        return this.H.getImageButton();
    }

    public final View x() {
        return this.c;
    }

    public final RelativeLayout y() {
        return this.w;
    }

    public final AlertDialog z() {
        return this.f;
    }

    public final AlertDialog A() {
        return this.g;
    }

    public final AlertDialog B() {
        return this.h;
    }

    public final AlertDialog C() {
        return this.i;
    }

    public final LinearLayout D() {
        return this.I;
    }

    @Override // com.baidu.tieba.voice.ae
    public final void b(boolean z) {
    }

    @Override // com.baidu.tieba.voice.ae
    public final void a(int i, String str) {
        if (!com.baidu.adp.lib.util.k.a(str)) {
            com.baidu.adp.lib.util.e.d("----record error. " + i + "---errMsg:" + str);
            if (i == 3) {
                this.L.showToast(str);
                j();
            } else if (i == 2) {
                m();
                k();
                this.A.setVisibility(0);
                this.R.sendMessageDelayed(this.R.obtainMessage(1), 500L);
            } else {
                this.L.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public final void a(String str, int i) {
        VoiceManager.VoiceModel voiceModel = new VoiceManager.VoiceModel();
        voiceModel.duration = i;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.T = voiceModel;
        if (this.S != null) {
            this.S.a(voiceModel);
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public final void E() {
        this.T = null;
        if (this.S != null) {
            p pVar = this.S;
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public final void e(int i) {
    }

    @Override // com.baidu.tieba.voice.ae
    public final void f(int i) {
        this.U = Math.max(i, this.U);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.V > 150) {
            this.U = 0;
            this.V = uptimeMillis;
        }
        this.P++;
        if (this.P % this.Q == 0) {
            this.P = 0;
            if (this.U < 2) {
                this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.U < 10) {
                this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.U < 20) {
                this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else {
                if (this.U >= 30) {
                    if (this.U < 40) {
                        this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
                        return;
                    } else if (this.U < 50) {
                        this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
                        return;
                    }
                }
                this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    public final void a(p pVar) {
        this.S = pVar;
    }

    public final void F() {
        this.o.setVisibility(8);
    }

    public final void G() {
        this.o.setVisibility(0);
    }

    public final void H() {
        this.p.setVisibility(8);
    }

    public final void I() {
        this.p.setVisibility(0);
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.G.setText(jSONObject.getString("input_draft"));
                this.G.setSelection(this.G.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    S();
                } else {
                    R();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final String J() {
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

    public final void K() {
        if (this.R != null) {
            this.R.removeMessages(1);
        }
    }

    public final void a(int i, com.baidu.tieba.im.message.b bVar) {
        bVar.a(i);
        this.M.c();
    }

    public final void L() {
        this.a.b(0);
        this.q.a(0);
        this.e.b(0);
        this.H.a(0);
    }

    public final com.baidu.tieba.util.i M() {
        if (this.M != null) {
            return this.M.d();
        }
        return null;
    }

    @Override // com.baidu.tieba.editortool.aa
    public final void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tieba.editortool.x)) {
                com.baidu.tieba.editortool.x xVar = (com.baidu.tieba.editortool.x) obj;
                WritableEmotionGroup.EmotionGroupType b = xVar.b();
                String a = xVar.a();
                if (b == WritableEmotionGroup.EmotionGroupType.LOCAL) {
                    if (a != null) {
                        this.G.getText().insert(this.G.getSelectionStart(), a);
                    }
                } else if (a != null) {
                    this.L.a(xVar);
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

    public final void N() {
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

    public final EggBreakerView O() {
        return this.K;
    }
}
