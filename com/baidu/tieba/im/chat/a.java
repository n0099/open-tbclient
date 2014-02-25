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
public abstract class a extends com.baidu.adp.a.e implements com.baidu.tieba.editortool.z, com.baidu.tieba.voice.ae {
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
    private ch M;
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

    protected abstract void b(cz czVar);

    protected abstract void c(cz czVar);

    protected abstract void d(cz czVar);

    protected abstract void e(cz czVar);

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
        f(msglistActivity);
        a(msglistActivity);
        b(msglistActivity);
        g(msglistActivity);
        h(msglistActivity);
        i(msglistActivity);
        j(msglistActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(cz czVar, boolean z) {
        this.a = (NavigationBar) czVar.findViewById(R.id.lay_title_bar);
        this.m = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, czVar);
        this.n = this.a.a("");
        czVar.getLayoutInflater();
        View inflate = LayoutInflater.from(this.L).inflate(R.layout.msg_chat_top_notify, (ViewGroup) null);
        this.o = (ImageView) inflate.findViewById(R.id.img_receiver);
        this.p = (ImageView) inflate.findViewById(R.id.img_close_notify);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        if (z) {
            K();
        } else {
            L();
        }
        this.K = (EggBreakerView) czVar.findViewById(R.id.egg_breaker);
    }

    private void f(cz czVar) {
        this.q = (NoNetworkView) czVar.findViewById(R.id.view_no_network);
    }

    public ch a() {
        return this.M;
    }

    private void a(MsglistActivity msglistActivity) {
        this.r = (BdListView) msglistActivity.findViewById(R.id.lis_msg);
        this.s = (ProgressBar) msglistActivity.findViewById(R.id.msg_progress);
        this.s.setVisibility(8);
        this.M = new ch(msglistActivity, this.j);
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
    }

    private void b(MsglistActivity msglistActivity) {
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
    }

    private void g(cz czVar) {
        this.C = (LinearLayout) czVar.findViewById(R.id.lay_msgsend_text);
        this.C.setVisibility(0);
        this.D = (ImageView) czVar.findViewById(R.id.btn_msgsend_govoice);
        this.D.setOnClickListener(new l(this));
        this.E = (ImageView) czVar.findViewById(R.id.btn_msgsend_more2);
        this.E.setOnClickListener(new m(this));
        this.G = (EditText) czVar.findViewById(R.id.edt_msgsend_text);
        this.G.setCursorVisible(false);
        this.G.setFocusable(true);
        this.G.setFocusableInTouchMode(true);
        this.G.addTextChangedListener(new o(this));
        this.G.setOnTouchListener(new c(this));
        this.F = (Button) czVar.findViewById(R.id.btn_msgsend_send);
        this.F.setOnClickListener(czVar);
        this.F.setEnabled(false);
        this.F.setTextColor(this.L.getResources().getColorStateList(R.color.post_image_btn_color));
    }

    private void h(cz czVar) {
        this.H = (ToolMoreView) czVar.findViewById(R.id.lay_msgsend_more);
        this.H.setVisibility(8);
        this.H.setOnClickListener(czVar);
        this.H.c();
        a(czVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(cz czVar) {
        this.e = (EmotionTabHost) czVar.findViewById(R.id.face_view);
        this.e.setOnDataSelected(this);
        this.e.setIsInChat(true);
        this.H.getFaceButton().setOnClickListener(new d(this));
    }

    private void i(cz czVar) {
        this.I = (LinearLayout) czVar.findViewById(R.id.lay_last_msg);
        this.J = (TextView) czVar.findViewById(R.id.text_last_msg);
        this.I.setOnClickListener(czVar);
    }

    private void j(cz czVar) {
        this.O = (FrameLayout) czVar.findViewById(R.id.lay_bottom_bar);
    }

    public FrameLayout e() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        a(this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.H.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.t.setVisibility(8);
        this.C.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.t.setVisibility(0);
        this.C.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Z();
        this.G.requestFocus();
        a(this.G, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        this.G.requestFocus();
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        new Handler().postDelayed(new e(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        List<com.baidu.tieba.im.message.b> b = this.M.b();
        if (b != null && b.size() > 0) {
            this.r.setSelection(b.size() - 1);
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        if (this.H.getVisibility() != 0) {
            if (this.e.getVisibility() == 0) {
                this.e.setVisibility(8);
                this.H.setVisibility(0);
                return;
            }
            this.H.setVisibility(0);
        }
    }

    public void a(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            this.M.a(i);
            this.M.a(msgPageData.getChatMessages());
            this.M.notifyDataSetInvalidated();
        }
    }

    public void a(String str, boolean z) {
        this.n.setText(str);
    }

    public void f() {
        this.M.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i) {
        try {
            com.baidu.adp.lib.util.f.a(k, "doRefresh", "selection:" + i);
            if (msgPageData != null) {
                this.M.a();
                this.M.a(msgPageData.getChatMessages());
                this.M.notifyDataSetChanged();
                if (i >= 0) {
                    this.r.setSelection(i);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(k, "doRefresh", e.getMessage());
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
                int i = 0;
                if (size > 0) {
                    i = size - 1;
                }
                b(msgPageData, i);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(k, "refreshGo2New", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public void c(MsgPageData msgPageData) {
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

    public String g() {
        String editable = this.G.getText().toString();
        if (TextUtils.isEmpty(editable)) {
            return null;
        }
        return editable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab() {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(k, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.G.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
    }

    public void h() {
        this.G.setText("");
    }

    public void a(String str) {
        String editable;
        String str2;
        if (this.G.getText().toString().equals("")) {
            str2 = "@" + str + " ";
        } else {
            str2 = String.valueOf(editable) + " @" + str + " ";
        }
        this.G.setText(str2);
        this.G.setSelection(str2.length());
        S();
        T();
        U();
        W();
    }

    public void a(boolean z) {
        if (z) {
            this.w.setBackgroundResource(R.drawable.but_talk_s);
            this.x.setText(this.L.getString(R.string.msglist_no_push));
            return;
        }
        this.w.setBackgroundResource(R.drawable.but_talk_n);
        this.x.setText(this.L.getString(R.string.msglist_push_talk));
    }

    public void d(MsgPageData msgPageData) {
        if (msgPageData != null) {
            try {
                com.baidu.adp.lib.util.f.a(k, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
                boolean z = false;
                if (msgPageData.getIsNewAdd()) {
                    z = h(msgPageData.getNewAddNum());
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
                com.baidu.adp.lib.util.f.b(k, "refreshCheckNew", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public BdListView i() {
        return this.r;
    }

    private boolean h(int i) {
        List<com.baidu.tieba.im.message.b> b = this.M.b();
        if (b == null) {
            return false;
        }
        if (b.size() <= i) {
            return true;
        }
        com.baidu.adp.lib.util.f.e("simon", "checkListAtNew", "lastVisiblePosition = " + this.r.getLastVisiblePosition());
        com.baidu.adp.lib.util.f.e("simon", "checkListAtNew", "data.size = " + b.size());
        com.baidu.adp.lib.util.f.e("simon", "checkListAtNew", "num = " + i);
        return this.r.getLastVisiblePosition() == (b.size() - (this.j == 2 ? 0 : 1)) - i;
    }

    public void j() {
        this.z.setVisibility(0);
    }

    public void k() {
        this.z.setVisibility(8);
    }

    public void l() {
        this.A.setVisibility(0);
    }

    public void m() {
        this.A.setVisibility(8);
    }

    public void n() {
        this.B.setVisibility(0);
    }

    public void o() {
        this.B.setVisibility(8);
    }

    private void a(com.baidu.tieba.im.message.b bVar) {
        if (bVar != null && !com.baidu.tieba.im.util.l.d(bVar)) {
            String b = b(bVar);
            if (!TextUtils.isEmpty(b)) {
                this.I.setVisibility(0);
                this.J.setText(b);
            }
        }
    }

    private String b(com.baidu.tieba.im.message.b bVar) {
        return com.baidu.tieba.im.util.l.i(bVar);
    }

    public void p() {
        if (this.I.getVisibility() == 0) {
            this.I.setVisibility(8);
            this.J.setText("");
        }
    }

    public void a(int i) {
        b((cz) this.L);
        this.f.getListView().setTag(Integer.valueOf(i));
        this.f.show();
    }

    public void b(int i) {
        c(this.L);
        this.g.getListView().setTag(Integer.valueOf(i));
        this.g.show();
    }

    public void c(int i) {
        d(this.L);
        this.h.getListView().setTag(Integer.valueOf(i));
        this.h.show();
    }

    public void d(int i) {
        e(this.L);
        this.i.getListView().setTag(Integer.valueOf(i));
        this.i.show();
    }

    public void q() {
        this.s.setVisibility(8);
    }

    public void r() {
        this.q.setVisible(true);
    }

    public void s() {
        this.q.setVisible(false);
    }

    public boolean t() {
        return this.e.getVisibility() == 0 || this.H.getVisibility() == 0;
    }

    public void u() {
        if (this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
        }
        if (this.H.getVisibility() == 0) {
            this.H.setVisibility(8);
        }
    }

    public ImageView v() {
        return this.m;
    }

    public Button w() {
        return this.F;
    }

    public View x() {
        return this.H.getFaceButton();
    }

    public View y() {
        return this.H.getCameraButton();
    }

    public View z() {
        return this.H.getImageButton();
    }

    public View A() {
        return this.c;
    }

    public RelativeLayout B() {
        return this.w;
    }

    public AlertDialog C() {
        return this.f;
    }

    public AlertDialog D() {
        return this.g;
    }

    public AlertDialog E() {
        return this.h;
    }

    public AlertDialog F() {
        return this.i;
    }

    public LinearLayout G() {
        return this.I;
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(boolean z) {
    }

    @Override // com.baidu.tieba.voice.ae
    public void H() {
    }

    @Override // com.baidu.tieba.voice.ae
    public void a(int i, String str) {
        if (!com.baidu.adp.lib.util.m.a(str)) {
            com.baidu.adp.lib.util.f.d("----record error. " + i + "---errMsg:" + str);
            if (i == 3) {
                this.L.showToast(str);
                k();
            } else if (i == 2) {
                o();
                m();
                l();
                this.R.sendMessageDelayed(this.R.obtainMessage(1), 500L);
            } else {
                this.L.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void a(String str, int i) {
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
    public void b(String str) {
        this.T = null;
        if (this.S != null) {
            this.S.a();
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void e(int i) {
    }

    @Override // com.baidu.tieba.voice.ae
    public void f(int i) {
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
            } else if (this.U < 30) {
                this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.U < 40) {
                this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.U < 50) {
                this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.y.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(p pVar) {
        this.S = pVar;
    }

    public void I() {
        this.o.setVisibility(8);
    }

    public void J() {
        this.o.setVisibility(0);
    }

    public void K() {
        this.p.setVisibility(8);
    }

    public void L() {
        this.p.setVisibility(0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.G.setText(jSONObject.getString("input_draft"));
                this.G.setSelection(this.G.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    V();
                } else {
                    U();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String M() {
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

    public void N() {
        if (this.R != null) {
            this.R.removeMessages(1);
        }
    }

    private void e(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
            com.baidu.adp.lib.util.f.e("++++++ num = " + size);
            int i = size - 100;
            com.baidu.adp.lib.util.f.e("++++++ removeCount= " + i);
            for (int i2 = 0; i2 < i; i2++) {
                msgPageData.getChatMessages().remove(0);
            }
        }
    }

    public void a(int i, com.baidu.tieba.im.message.b bVar) {
        bVar.a(i);
        this.M.a(bVar);
    }

    public void g(int i) {
        this.a.c(0);
        this.q.a(0);
        this.e.b(0);
        this.H.a(0);
    }

    public com.baidu.tieba.util.i O() {
        if (this.M != null) {
            return this.M.c();
        }
        return null;
    }

    @Override // com.baidu.tieba.editortool.z
    public void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tieba.editortool.w)) {
                com.baidu.tieba.editortool.w wVar = (com.baidu.tieba.editortool.w) obj;
                WritableEmotionGroup.EmotionGroupType b = wVar.b();
                String a = wVar.a();
                if (b == WritableEmotionGroup.EmotionGroupType.LOCAL) {
                    if (a != null) {
                        this.G.getText().insert(this.G.getSelectionStart(), a);
                    }
                } else if (a != null) {
                    this.L.a(wVar);
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

    public void P() {
        y().setEnabled(false);
        z().setEnabled(false);
        this.w.setEnabled(false);
        this.D.setEnabled(false);
        x().setEnabled(false);
        this.v.setEnabled(false);
        this.E.setEnabled(false);
        this.G.setEnabled(false);
        this.F.setEnabled(false);
    }

    public EggBreakerView Q() {
        return this.K;
    }
}
