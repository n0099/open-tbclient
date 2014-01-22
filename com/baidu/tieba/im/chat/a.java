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
public abstract class a extends com.baidu.adp.a.e implements com.baidu.tieba.editortool.t, com.baidu.tieba.voice.ae {
    private static final String i = a.class.getName();
    private LinearLayout A;
    private Button B;
    private Button C;
    private Button D;
    private EditText E;
    private LinearLayout F;
    private Button G;
    private Button H;
    private Button I;
    private LinearLayout J;
    private TextView K;
    private EggBreakerView L;
    private MsglistActivity M;
    private bz N;
    private AlertDialog O;
    private FrameLayout P;
    private int Q;
    private int R;
    private Handler S;
    private p T;
    private VoiceManager.VoiceModel U;
    private int V;
    private long W;
    protected NavigationBar a;
    protected TextView c;
    protected EmotionTabHost d;
    protected AlertDialog e;
    protected AlertDialog f;
    protected AlertDialog g;
    protected int h;
    private final int j;
    private ImageView k;
    private TextView l;
    private ImageView m;
    private ImageView n;
    private NoNetworkView o;
    private BdListView p;
    private ProgressBar q;
    private LinearLayout r;
    private Button s;
    private Button t;
    private RelativeLayout u;
    private TextView v;
    private ImageView w;
    private LinearLayout x;
    private LinearLayout y;
    private LinearLayout z;

    protected abstract void b(cp cpVar);

    protected abstract void c(cp cpVar);

    protected abstract void d(cp cpVar);

    public a(MsglistActivity msglistActivity, boolean z, int i2) {
        super(msglistActivity);
        this.j = 100;
        this.a = null;
        this.k = null;
        this.l = null;
        this.c = null;
        this.m = null;
        this.n = null;
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
        this.I = null;
        this.d = null;
        this.J = null;
        this.K = null;
        this.M = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.O = null;
        this.P = null;
        this.Q = 0;
        this.R = 5;
        this.h = 0;
        this.S = new b(this);
        this.V = 0;
        this.W = 0L;
        this.M = msglistActivity;
        this.h = i2;
        msglistActivity.setContentView(R.layout.msg_msglist_activity);
        a(msglistActivity, z);
        e(msglistActivity);
        a(msglistActivity);
        b(msglistActivity);
        f(msglistActivity);
        g(msglistActivity);
        h(msglistActivity);
        i(msglistActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(cp cpVar, boolean z) {
        this.a = (NavigationBar) cpVar.findViewById(R.id.lay_title_bar);
        this.k = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, cpVar);
        this.l = this.a.a("");
        cpVar.getLayoutInflater();
        View inflate = LayoutInflater.from(this.M).inflate(R.layout.msg_chat_top_notify, (ViewGroup) null);
        this.m = (ImageView) inflate.findViewById(R.id.img_receiver);
        this.n = (ImageView) inflate.findViewById(R.id.img_close_notify);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        if (z) {
            I();
        } else {
            J();
        }
        this.L = (EggBreakerView) cpVar.findViewById(R.id.egg_breaker);
    }

    private void e(cp cpVar) {
        this.o = (NoNetworkView) cpVar.findViewById(R.id.view_no_network);
    }

    public bz a() {
        return this.N;
    }

    private void a(MsglistActivity msglistActivity) {
        this.p = (BdListView) msglistActivity.findViewById(R.id.lis_msg);
        this.q = (ProgressBar) msglistActivity.findViewById(R.id.msg_progress);
        this.q.setVisibility(8);
        this.N = new bz(msglistActivity, this.h);
        this.N.a((com.baidu.adp.lib.b.a) msglistActivity);
        this.N.a((com.baidu.adp.lib.b.b) msglistActivity);
        this.p.setAdapter((ListAdapter) this.N);
        this.p.setOnScrollListener(new f(this));
        this.p.setOnSrollToTopListener(msglistActivity);
        this.p.setOnSrollToBottomListener(msglistActivity);
        this.p.setItemsCanFocus(true);
        this.p.setFocusable(false);
        this.p.setFocusableInTouchMode(false);
        this.p.setClickable(false);
        this.p.setOnTouchListener(new g(this));
        this.p.setKybdsScrollBottom(true);
        this.p.setRecyclerListener(new h(this));
    }

    private void b(MsglistActivity msglistActivity) {
        this.r = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voice);
        this.r.setVisibility(8);
        this.s = (Button) msglistActivity.findViewById(R.id.btn_msgsend_softkey);
        this.s.setOnClickListener(new i(this));
        this.t = (Button) msglistActivity.findViewById(R.id.btn_msgsend_more1);
        this.t.setOnClickListener(new k(this));
        this.u = (RelativeLayout) msglistActivity.findViewById(R.id.btn_msgsend_voice);
        this.u.setOnTouchListener(msglistActivity);
        this.v = (TextView) msglistActivity.findViewById(R.id.tex_send_voice);
        this.x = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer);
        this.x.setVisibility(8);
        this.w = (ImageView) msglistActivity.findViewById(R.id.img_msgsend_recording);
        this.y = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer_short);
        this.z = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer_cancel);
    }

    private void f(cp cpVar) {
        this.A = (LinearLayout) cpVar.findViewById(R.id.lay_msgsend_text);
        this.A.setVisibility(0);
        this.B = (Button) cpVar.findViewById(R.id.btn_msgsend_govoice);
        this.B.setOnClickListener(new l(this));
        this.C = (Button) cpVar.findViewById(R.id.btn_msgsend_more2);
        this.C.setOnClickListener(new m(this));
        this.E = (EditText) cpVar.findViewById(R.id.edt_msgsend_text);
        this.E.setCursorVisible(false);
        this.E.setFocusable(true);
        this.E.setFocusableInTouchMode(true);
        this.E.addTextChangedListener(new o(this));
        this.E.setOnTouchListener(new c(this));
        this.D = (Button) cpVar.findViewById(R.id.btn_msgsend_send);
        this.D.setOnClickListener(cpVar);
        this.D.setEnabled(false);
        this.D.setTextColor(this.M.getResources().getColorStateList(R.color.post_image_btn_color));
    }

    private void g(cp cpVar) {
        this.F = (LinearLayout) cpVar.findViewById(R.id.lay_msgsend_more);
        this.F.setVisibility(8);
        this.G = (Button) cpVar.findViewById(R.id.btn_msgsend_camera);
        this.G.setOnClickListener(cpVar);
        this.H = (Button) cpVar.findViewById(R.id.btn_msgsend_image);
        this.H.setOnClickListener(cpVar);
        this.I = (Button) cpVar.findViewById(R.id.btn_msgsend_expression);
        a(cpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(cp cpVar) {
        this.d = (EmotionTabHost) cpVar.findViewById(R.id.face_view);
        this.d.setOnDataSelected(this);
        this.d.setIsInChat(true);
        this.I.setOnClickListener(new d(this));
    }

    private void h(cp cpVar) {
        this.J = (LinearLayout) cpVar.findViewById(R.id.lay_last_msg);
        this.K = (TextView) cpVar.findViewById(R.id.text_last_msg);
        this.J.setOnClickListener(cpVar);
    }

    private void i(cp cpVar) {
        this.P = (FrameLayout) cpVar.findViewById(R.id.lay_bottom_bar);
    }

    public FrameLayout e() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.F.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.r.setVisibility(8);
        this.A.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.r.setVisibility(0);
        this.A.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        X();
        this.E.requestFocus();
        a(this.E, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.E.requestFocus();
        this.d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        new Handler().postDelayed(new e(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        List<com.baidu.tieba.im.message.b> b = this.N.b();
        if (b != null && b.size() > 0) {
            this.p.setSelection(b.size() - 1);
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (this.F.getVisibility() != 0) {
            if (this.d.getVisibility() == 0) {
                this.d.setVisibility(8);
                this.F.setVisibility(0);
                return;
            }
            this.F.setVisibility(0);
        }
    }

    public void a(MsgPageData msgPageData, int i2) {
        if (msgPageData != null) {
            this.N.a(i2);
            this.N.a(msgPageData.getChatMessages());
            this.N.notifyDataSetInvalidated();
        }
    }

    public void a(String str, boolean z) {
        this.l.setText(str);
        if (z) {
        }
    }

    public void f() {
        this.N.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i2) {
        try {
            com.baidu.adp.lib.g.e.a(i, "doRefresh", "selection:" + i2);
            if (msgPageData != null) {
                this.N.a();
                this.N.a(msgPageData.getChatMessages());
                this.N.notifyDataSetChanged();
                if (i2 >= 0) {
                    this.p.setSelection(i2);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(i, "doRefresh", e.getMessage());
        }
    }

    public void a(MsgPageData msgPageData) {
        b(msgPageData, -1);
    }

    public void b(MsgPageData msgPageData) {
        if (msgPageData != null) {
            try {
                e(msgPageData);
                int size = msgPageData.getChatMessages().size();
                int i2 = 0;
                if (size > 0) {
                    i2 = size - 1;
                }
                b(msgPageData, i2);
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(i, "refreshGo2New", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public void c(MsgPageData msgPageData) {
        try {
            com.baidu.adp.lib.g.e.a(i, "refreshPrepage", "new:" + msgPageData.getNewAddNum());
            int firstVisiblePosition = this.p.getFirstVisiblePosition();
            com.baidu.adp.lib.g.e.d("pos" + firstVisiblePosition);
            if (msgPageData.getIsNewAdd()) {
                int newAddNum = msgPageData.getNewAddNum();
                com.baidu.adp.lib.g.e.d("num new " + newAddNum);
                int i2 = firstVisiblePosition + newAddNum;
                com.baidu.adp.lib.g.e.d("pos2" + i2);
                b(msgPageData, i2);
            } else {
                b(msgPageData, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(i, "refreshPrepage", e.getMessage());
            b(msgPageData, -1);
        }
    }

    public String g() {
        String obj = this.E.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z() {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(i, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.E.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
    }

    public void h() {
        this.E.setText("");
    }

    public void a(String str) {
        String str2;
        String obj = this.E.getText().toString();
        if (obj.equals("")) {
            str2 = "@" + str + " ";
        } else {
            str2 = obj + " @" + str + " ";
        }
        this.E.setText(str2);
        this.E.setSelection(str2.length());
        Q();
        R();
        S();
        U();
    }

    public void a(boolean z) {
        if (z) {
            this.u.setBackgroundResource(R.drawable.but_talk_s);
            this.v.setText(this.M.getString(R.string.msglist_no_push));
            return;
        }
        this.u.setBackgroundResource(R.drawable.but_talk_n);
        this.v.setText(this.M.getString(R.string.msglist_push_talk));
    }

    public void d(MsgPageData msgPageData) {
        if (msgPageData != null) {
            try {
                com.baidu.adp.lib.g.e.a(i, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
                boolean z = false;
                if (msgPageData.getIsNewAdd()) {
                    z = g(msgPageData.getNewAddNum());
                }
                if (z) {
                    b(msgPageData);
                    return;
                }
                a(msgPageData);
                if (msgPageData.getNewAddNum() > 0 && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() > 0) {
                    a(msgPageData.getChatMessages().get(msgPageData.getChatMessages().size() - 1));
                }
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(i, "refreshCheckNew", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public BdListView i() {
        return this.p;
    }

    private boolean g(int i2) {
        List<com.baidu.tieba.im.message.b> b = this.N.b();
        if (b == null) {
            return false;
        }
        if (b.size() <= i2) {
            return true;
        }
        com.baidu.adp.lib.g.e.e("simon", "checkListAtNew", "lastVisiblePosition = " + this.p.getLastVisiblePosition());
        com.baidu.adp.lib.g.e.e("simon", "checkListAtNew", "data.size = " + b.size());
        com.baidu.adp.lib.g.e.e("simon", "checkListAtNew", "num = " + i2);
        return this.p.getLastVisiblePosition() == (b.size() - (this.h == 2 ? 0 : 1)) - i2;
    }

    public void j() {
        this.x.setVisibility(0);
    }

    public void k() {
        this.x.setVisibility(8);
    }

    public void l() {
        this.y.setVisibility(0);
    }

    public void m() {
        this.y.setVisibility(8);
    }

    public void n() {
        this.z.setVisibility(0);
    }

    public void o() {
        this.z.setVisibility(8);
    }

    private void a(com.baidu.tieba.im.message.b bVar) {
        if (bVar != null && !com.baidu.tieba.im.d.d.d(bVar)) {
            String b = b(bVar);
            if (!TextUtils.isEmpty(b)) {
                this.J.setVisibility(0);
                this.K.setText(b);
            }
        }
    }

    private String b(com.baidu.tieba.im.message.b bVar) {
        return com.baidu.tieba.im.d.d.h(bVar);
    }

    public void p() {
        if (this.J.getVisibility() == 0) {
            this.J.setVisibility(8);
            this.K.setText("");
        }
    }

    public void a(int i2) {
        b((cp) this.M);
        this.e.getListView().setTag(Integer.valueOf(i2));
        this.e.show();
    }

    public void b(int i2) {
        c(this.M);
        this.f.getListView().setTag(Integer.valueOf(i2));
        this.f.show();
    }

    public void c(int i2) {
        d(this.M);
        this.g.getListView().setTag(Integer.valueOf(i2));
        this.g.show();
    }

    public void q() {
        this.q.setVisibility(8);
    }

    public void r() {
        this.o.setVisible(true);
    }

    public void s() {
        this.o.setVisible(false);
    }

    public boolean t() {
        return this.d.getVisibility() == 0 || this.F.getVisibility() == 0;
    }

    public void u() {
        if (this.d.getVisibility() == 0) {
            this.d.setVisibility(8);
        }
        if (this.F.getVisibility() == 0) {
            this.F.setVisibility(8);
        }
    }

    public ImageView v() {
        return this.k;
    }

    public Button w() {
        return this.D;
    }

    public Button x() {
        return this.G;
    }

    public Button y() {
        return this.H;
    }

    public TextView z() {
        return this.c;
    }

    public RelativeLayout A() {
        return this.u;
    }

    public AlertDialog B() {
        return this.e;
    }

    public AlertDialog C() {
        return this.f;
    }

    public AlertDialog D() {
        return this.g;
    }

    public LinearLayout E() {
        return this.J;
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(boolean z) {
        if (z) {
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void F() {
    }

    @Override // com.baidu.tieba.voice.ae
    public void a(int i2, String str) {
        if (!com.baidu.adp.lib.g.m.a(str)) {
            com.baidu.adp.lib.g.e.c("----record error. " + i2 + "---errMsg:" + str);
            if (i2 == 3) {
                this.M.showToast(str);
                k();
            } else if (i2 == 2) {
                o();
                m();
                l();
                this.S.sendMessageDelayed(this.S.obtainMessage(1), 500L);
            } else {
                this.M.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void a(String str, int i2) {
        VoiceManager.VoiceModel voiceModel = new VoiceManager.VoiceModel();
        voiceModel.duration = i2;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.U = voiceModel;
        if (this.T != null) {
            this.T.a(voiceModel);
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(String str) {
        this.U = null;
        if (this.T != null) {
            this.T.a();
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void d(int i2) {
    }

    @Override // com.baidu.tieba.voice.ae
    public void e(int i2) {
        this.V = Math.max(i2, this.V);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.W > 150) {
            this.V = 0;
            this.W = uptimeMillis;
        }
        this.Q++;
        if (this.Q % this.R == 0) {
            this.Q = 0;
            if (this.V < 2) {
                this.w.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.V < 10) {
                this.w.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.V < 20) {
                this.w.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.V < 30) {
                this.w.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.V < 40) {
                this.w.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.V < 50) {
                this.w.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.w.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(p pVar) {
        this.T = pVar;
    }

    public void G() {
        this.m.setVisibility(8);
    }

    public void H() {
        this.m.setVisibility(0);
    }

    public void I() {
        this.n.setVisibility(8);
    }

    public void J() {
        this.n.setVisibility(0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.E.setText(jSONObject.getString("input_draft"));
                this.E.setSelection(this.E.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    T();
                } else {
                    S();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String K() {
        String str;
        if (this.A.getVisibility() == 0) {
            str = "input_text";
        } else {
            str = "input_voice";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("input_draft", this.E.getText().toString());
        hashMap.put("input_status", str);
        return new Gson().toJson(hashMap);
    }

    public void L() {
        if (this.S != null) {
            this.S.removeMessages(1);
        }
    }

    private void e(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
            com.baidu.adp.lib.g.e.d("++++++ num = " + size);
            int i2 = size - 100;
            com.baidu.adp.lib.g.e.d("++++++ removeCount= " + i2);
            for (int i3 = 0; i3 < i2; i3++) {
                msgPageData.getChatMessages().remove(0);
            }
        }
    }

    public void a(int i2, com.baidu.tieba.im.message.b bVar) {
        bVar.a(i2);
        this.N.a(bVar);
    }

    public void f(int i2) {
        this.a.c(0);
        this.o.a(0);
        this.d.b(0);
    }

    public com.baidu.tieba.util.i M() {
        if (this.N != null) {
            return this.N.c();
        }
        return null;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i2, Object obj) {
        if (i2 == 20) {
            if (obj != null && (obj instanceof com.baidu.tieba.editortool.q)) {
                com.baidu.tieba.editortool.q qVar = (com.baidu.tieba.editortool.q) obj;
                WritableEmotionGroup.EmotionGroupType b = qVar.b();
                String a = qVar.a();
                if (b == WritableEmotionGroup.EmotionGroupType.LOCAL) {
                    if (a != null) {
                        this.E.getText().insert(this.E.getSelectionStart(), a);
                    }
                } else if (a != null) {
                    this.M.a(qVar);
                }
            }
        } else if (i2 == 21 && this.E.getSelectionStart() > 0) {
            String substring = this.E.getText().toString().substring(0, this.E.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            if (matcher.find()) {
                this.E.getText().delete(this.E.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.E.getSelectionStart());
                return;
            }
            this.E.getText().delete(this.E.getSelectionStart() - 1, this.E.getSelectionStart());
        }
    }

    public void N() {
        this.G.setEnabled(false);
        this.H.setEnabled(false);
        this.u.setEnabled(false);
        this.B.setEnabled(false);
        this.I.setEnabled(false);
        this.t.setEnabled(false);
        this.C.setEnabled(false);
        this.E.setEnabled(false);
        this.D.setEnabled(false);
    }

    public EggBreakerView O() {
        return this.L;
    }
}
