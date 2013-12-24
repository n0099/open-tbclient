package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.Context;
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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.a.e implements com.baidu.tieba.voice.ae {
    private static final String a = bu.class.getName();
    private LinearLayout A;
    private Button B;
    private Button C;
    private Button D;
    private aj E;
    private LinearLayout F;
    private TextView G;
    private bc H;
    private bt I;
    private AlertDialog J;
    private AlertDialog K;
    private AlertDialog L;
    private AlertDialog M;
    private FrameLayout N;
    private int O;
    private int P;
    private int Q;
    private Handler R;
    private cj S;
    private VoiceManager.VoiceModel T;
    private int U;
    private long V;
    private final int c;
    private NavigationBar d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private ImageView i;
    private NoNetworkView j;
    private BdListView k;
    private ProgressBar l;
    private LinearLayout m;
    private Button n;
    private Button o;
    private RelativeLayout p;
    private TextView q;
    private ImageView r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private Button w;
    private Button x;
    private Button y;
    private EditText z;

    public bu(bc bcVar, boolean z, int i) {
        super(bcVar);
        this.c = 100;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
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
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = 0;
        this.P = 5;
        this.Q = 0;
        this.R = new bv(this);
        this.U = 0;
        this.V = 0L;
        this.H = bcVar;
        this.Q = i;
        bcVar.setContentView(R.layout.msg_msglist_activity);
        a(bcVar, z);
        a(bcVar);
        b(bcVar);
        c(bcVar);
        d(bcVar);
        e(bcVar);
        g(bcVar);
        h(bcVar);
    }

    private void a(bc bcVar, boolean z) {
        String string;
        this.d = (NavigationBar) bcVar.findViewById(R.id.lay_title_bar);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, bcVar);
        this.f = this.d.a("");
        bcVar.getLayoutInflater();
        View inflate = LayoutInflater.from(this.H).inflate(R.layout.msg_chat_top_notify, (ViewGroup) null);
        this.h = (ImageView) inflate.findViewById(R.id.img_receiver);
        this.i = (ImageView) inflate.findViewById(R.id.img_close_notify);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        if (this.Q == 0) {
            string = bcVar.getString(R.string.msglist_groupinfo);
        } else {
            string = this.Q == 1 ? bcVar.getString(R.string.msglist_personInfo) : null;
        }
        if (string != null) {
            this.g = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string, bcVar);
        }
        if (z) {
            G();
        } else {
            H();
        }
    }

    private void a(bc bcVar) {
        this.j = (NoNetworkView) bcVar.findViewById(R.id.view_no_network);
    }

    private void b(bc bcVar) {
        this.k = (BdListView) bcVar.findViewById(R.id.lis_msg);
        this.l = (ProgressBar) bcVar.findViewById(R.id.msg_progress);
        this.l.setVisibility(8);
        this.I = new bt(bcVar, this.Q);
        this.I.a((com.baidu.adp.lib.b.a) bcVar);
        this.I.a((com.baidu.adp.lib.b.b) bcVar);
        this.k.setAdapter((ListAdapter) this.I);
        this.k.setOnScrollListener(new bz(this));
        this.k.setOnSrollToTopListener(bcVar);
        this.k.setOnSrollToBottomListener(bcVar);
        this.k.setItemsCanFocus(true);
        this.k.setFocusable(false);
        this.k.setFocusableInTouchMode(false);
        this.k.setClickable(false);
        this.k.setOnTouchListener(new ca(this));
        this.k.setKybdsScrollBottom(true);
        this.k.setRecyclerListener(new cb(this));
    }

    private void c(bc bcVar) {
        this.m = (LinearLayout) bcVar.findViewById(R.id.lay_msgsend_voice);
        this.m.setVisibility(8);
        this.n = (Button) bcVar.findViewById(R.id.btn_msgsend_softkey);
        this.n.setOnClickListener(new cc(this));
        this.o = (Button) bcVar.findViewById(R.id.btn_msgsend_more1);
        this.o.setOnClickListener(new ce(this));
        this.p = (RelativeLayout) bcVar.findViewById(R.id.btn_msgsend_voice);
        this.p.setOnTouchListener(bcVar);
        this.q = (TextView) bcVar.findViewById(R.id.tex_send_voice);
        this.s = (LinearLayout) bcVar.findViewById(R.id.lay_msgsend_voicelayer);
        this.s.setVisibility(8);
        this.r = (ImageView) bcVar.findViewById(R.id.img_msgsend_recording);
        this.t = (LinearLayout) bcVar.findViewById(R.id.lay_msgsend_voicelayer_short);
        this.u = (LinearLayout) bcVar.findViewById(R.id.lay_msgsend_voicelayer_cancel);
    }

    private void d(bc bcVar) {
        this.v = (LinearLayout) bcVar.findViewById(R.id.lay_msgsend_text);
        this.v.setVisibility(0);
        this.w = (Button) bcVar.findViewById(R.id.btn_msgsend_govoice);
        this.w.setOnClickListener(new cf(this));
        this.x = (Button) bcVar.findViewById(R.id.btn_msgsend_more2);
        this.x.setOnClickListener(new cg(this));
        this.z = (EditText) bcVar.findViewById(R.id.edt_msgsend_text);
        this.z.setFocusable(true);
        this.z.setFocusableInTouchMode(true);
        this.z.addTextChangedListener(new ci(this));
        this.z.setOnTouchListener(new bw(this));
        this.y = (Button) bcVar.findViewById(R.id.btn_msgsend_send);
        this.y.setOnClickListener(bcVar);
        this.y.setEnabled(false);
        this.y.setTextColor(this.H.getResources().getColorStateList(R.color.post_image_btn_color));
    }

    private void e(bc bcVar) {
        this.A = (LinearLayout) bcVar.findViewById(R.id.lay_msgsend_more);
        this.A.setVisibility(8);
        this.B = (Button) bcVar.findViewById(R.id.btn_msgsend_camera);
        this.B.setOnClickListener(bcVar);
        this.C = (Button) bcVar.findViewById(R.id.btn_msgsend_image);
        this.C.setOnClickListener(bcVar);
        this.D = (Button) bcVar.findViewById(R.id.btn_msgsend_expression);
        f(bcVar);
    }

    private void f(bc bcVar) {
        this.E = new aj(bcVar, this.z);
        this.D.setOnClickListener(new bx(this));
    }

    private void g(bc bcVar) {
        this.F = (LinearLayout) bcVar.findViewById(R.id.lay_last_msg);
        this.G = (TextView) bcVar.findViewById(R.id.text_last_msg);
        this.F.setOnClickListener(bcVar);
    }

    private void h(bc bcVar) {
        this.N = (FrameLayout) bcVar.findViewById(R.id.lay_bottom_bar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        a(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.A.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.E.a(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.m.setVisibility(8);
        this.v.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.m.setVisibility(0);
        this.v.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        S();
        this.z.requestFocus();
        a(this.z, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.z.requestFocus();
        this.E.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        new Handler().postDelayed(new by(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        List<com.baidu.tieba.im.message.b> b = this.I.b();
        if (b != null && b.size() > 0) {
            this.k.setSelection(b.size() - 1);
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.A.getVisibility() != 0) {
            if (this.E.a() == 0) {
                this.E.a(8);
                this.A.setVisibility(0);
                return;
            }
            this.A.setVisibility(0);
        }
    }

    public void a(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            this.I.a(i);
            this.I.a(msgPageData.getChatMessages());
            this.I.notifyDataSetInvalidated();
        }
    }

    public void a(String str, boolean z) {
        this.f.setText(str);
        if (z) {
        }
    }

    public void a() {
        this.I.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i) {
        try {
            com.baidu.adp.lib.h.e.a(a, "doRefresh", "selection:" + i);
            if (msgPageData != null) {
                this.I.a();
                this.I.a(msgPageData.getChatMessages());
                this.I.notifyDataSetChanged();
                if (i >= 0) {
                    this.k.setSelection(i);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(a, "doRefresh", e.getMessage());
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
                com.baidu.adp.lib.h.e.b(a, "refreshGo2New", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public void c(MsgPageData msgPageData) {
        try {
            com.baidu.adp.lib.h.e.a(a, "refreshPrepage", "new:" + msgPageData.getNewAddNum());
            int firstVisiblePosition = this.k.getFirstVisiblePosition();
            com.baidu.adp.lib.h.e.d("pos" + firstVisiblePosition);
            if (msgPageData.getIsNewAdd()) {
                int newAddNum = msgPageData.getNewAddNum();
                com.baidu.adp.lib.h.e.d("num new " + newAddNum);
                int i = firstVisiblePosition + newAddNum;
                com.baidu.adp.lib.h.e.d("pos2" + i);
                b(msgPageData, i);
            } else {
                b(msgPageData, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(a, "refreshPrepage", e.getMessage());
            b(msgPageData, -1);
        }
    }

    public String e() {
        String obj = this.z.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U() {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(a, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.z.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
    }

    public void f() {
        this.z.setText("");
    }

    public void a(int i, String str) {
        if (str != null) {
            com.baidu.adp.lib.h.g.a((Context) this.H, str);
            return;
        }
        String a2 = com.baidu.tieba.im.d.f.a(i);
        if (a2 != null && a2.length() > 0) {
            com.baidu.adp.lib.h.g.a((Context) this.H, a2);
        }
    }

    public void a(String str) {
        String str2;
        String obj = this.z.getText().toString();
        if (obj.equals("")) {
            str2 = "@" + str + " ";
        } else {
            str2 = obj + " @" + str + " ";
        }
        this.z.setText(str2);
        this.z.setSelection(str2.length());
        L();
        M();
        N();
        P();
    }

    public void a(boolean z) {
        if (z) {
            this.p.setBackgroundResource(R.drawable.but_talk_s);
            this.q.setText(this.H.getString(R.string.msglist_no_push));
            return;
        }
        this.p.setBackgroundResource(R.drawable.but_talk_n);
        this.q.setText(this.H.getString(R.string.msglist_push_talk));
    }

    public void d(MsgPageData msgPageData) {
        if (msgPageData != null) {
            try {
                com.baidu.adp.lib.h.e.a(a, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
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
                com.baidu.adp.lib.h.e.b(a, "refreshCheckNew", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public BdListView g() {
        return this.k;
    }

    private boolean g(int i) {
        List<com.baidu.tieba.im.message.b> b = this.I.b();
        if (b == null) {
            return false;
        }
        return b.size() <= i || this.k.getLastVisiblePosition() == (b.size() + (-1)) - i;
    }

    public void h() {
        this.s.setVisibility(0);
    }

    public void i() {
        this.s.setVisibility(8);
    }

    public void j() {
        this.t.setVisibility(0);
    }

    public void k() {
        this.t.setVisibility(8);
    }

    public void l() {
        this.u.setVisibility(0);
    }

    public void m() {
        this.u.setVisibility(8);
    }

    private void a(com.baidu.tieba.im.message.b bVar) {
        if (bVar != null && !com.baidu.tieba.im.d.d.c(bVar)) {
            String b = b(bVar);
            if (!TextUtils.isEmpty(b)) {
                this.F.setVisibility(0);
                this.G.setText(b);
            }
        }
    }

    private String b(com.baidu.tieba.im.message.b bVar) {
        return com.baidu.tieba.im.d.d.g(bVar);
    }

    public void n() {
        if (this.F.getVisibility() == 0) {
            this.F.setVisibility(8);
            this.G.setText("");
        }
    }

    public void a(int i) {
        i(this.H);
        this.J.getListView().setTag(Integer.valueOf(i));
        this.J.show();
    }

    public void b(int i) {
        j(this.H);
        this.K.getListView().setTag(Integer.valueOf(i));
        this.K.show();
    }

    public void c(int i) {
        k(this.H);
        this.L.getListView().setTag(Integer.valueOf(i));
        this.L.show();
    }

    public void o() {
        this.l.setVisibility(8);
    }

    private void i(bc bcVar) {
        if (this.J == null) {
            CharSequence[] charSequenceArr = {bcVar.getString(R.string.operate_copy), bcVar.getString(R.string.msg_at), bcVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {bcVar.getString(R.string.operate_copy), bcVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(bcVar);
            builder.setTitle(bcVar.getString(R.string.operation));
            if (this.Q == 0) {
                builder.setItems(charSequenceArr, bcVar);
            } else {
                builder.setItems(charSequenceArr2, bcVar);
            }
            this.J = builder.create();
            this.J.setCanceledOnTouchOutside(true);
        }
    }

    private void j(bc bcVar) {
        if (this.K == null) {
            CharSequence[] charSequenceArr = {bcVar.getString(R.string.msg_at), bcVar.getString(R.string.msg_img_save), bcVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {bcVar.getString(R.string.msg_img_save), bcVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(bcVar);
            builder.setTitle(bcVar.getString(R.string.operation));
            if (this.Q == 0) {
                builder.setItems(charSequenceArr, bcVar);
            } else {
                builder.setItems(charSequenceArr2, bcVar);
            }
            this.K = builder.create();
            this.K.setCanceledOnTouchOutside(true);
        }
    }

    private void k(bc bcVar) {
        if (this.L != null) {
            this.L = null;
        }
        boolean ak = TiebaApplication.h().ak();
        CharSequence[] charSequenceArr = {bcVar.getString(R.string.group_close_receiver), bcVar.getString(R.string.msg_at), bcVar.getString(R.string.msg_delete)};
        CharSequence[] charSequenceArr2 = {bcVar.getString(R.string.group_close_receiver), bcVar.getString(R.string.msg_delete)};
        if (ak) {
            charSequenceArr[0] = bcVar.getString(R.string.group_close_receiver);
            charSequenceArr2[0] = bcVar.getString(R.string.group_close_receiver);
        } else {
            charSequenceArr[0] = bcVar.getString(R.string.group_open_receiver);
            charSequenceArr2[0] = bcVar.getString(R.string.group_open_receiver);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(bcVar);
        builder.setTitle(bcVar.getString(R.string.operation));
        if (this.Q == 0) {
            builder.setItems(charSequenceArr, bcVar);
        } else {
            builder.setItems(charSequenceArr2, bcVar);
        }
        this.L = builder.create();
        this.L.setCanceledOnTouchOutside(true);
    }

    public void p() {
        this.j.setVisible(true);
    }

    public void q() {
        this.j.setVisible(false);
    }

    public boolean r() {
        return this.E.a() == 0 || this.A.getVisibility() == 0;
    }

    public void s() {
        if (this.E.a() == 0) {
            this.E.a(8);
        }
        if (this.A.getVisibility() == 0) {
            this.A.setVisibility(8);
        }
    }

    public ImageView t() {
        return this.e;
    }

    public Button u() {
        return this.y;
    }

    public Button v() {
        return this.B;
    }

    public Button w() {
        return this.C;
    }

    public TextView x() {
        return this.g;
    }

    public RelativeLayout y() {
        return this.p;
    }

    public AlertDialog z() {
        return this.J;
    }

    public AlertDialog A() {
        return this.K;
    }

    public AlertDialog B() {
        return this.L;
    }

    public LinearLayout C() {
        return this.F;
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(boolean z) {
        if (z) {
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void D() {
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(int i, String str) {
        if (!com.baidu.adp.lib.h.m.a(str)) {
            com.baidu.adp.lib.h.e.c("----record error. " + i + "---errMsg:" + str);
            if (i == 3) {
                this.H.showToast(str);
                i();
            } else if (i == 2) {
                m();
                k();
                j();
                this.R.sendMessageDelayed(this.R.obtainMessage(1), 500L);
            } else {
                this.H.showToast(str);
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
    public void d(int i) {
    }

    @Override // com.baidu.tieba.voice.ae
    public void e(int i) {
        this.U = Math.max(i, this.U);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.V > 150) {
            this.U = 0;
            this.V = uptimeMillis;
        }
        this.O++;
        if (this.O % this.P == 0) {
            this.O = 0;
            if (this.U < 2) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.U < 10) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.U < 20) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.U < 30) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.U < 40) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.U < 50) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(cj cjVar) {
        this.S = cjVar;
    }

    public void E() {
        this.h.setVisibility(8);
    }

    public void F() {
        this.h.setVisibility(0);
    }

    public void G() {
        this.i.setVisibility(8);
    }

    public void H() {
        this.i.setVisibility(0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.z.setText(jSONObject.getString("input_draft"));
                this.z.setSelection(this.z.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    O();
                } else {
                    N();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String I() {
        String str;
        if (this.v.getVisibility() == 0) {
            str = "input_text";
        } else {
            str = "input_voice";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("input_draft", this.z.getText().toString());
        hashMap.put("input_status", str);
        return new Gson().toJson(hashMap);
    }

    public void J() {
        if (this.R != null) {
            this.R.removeMessages(1);
        }
    }

    private void e(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
            com.baidu.adp.lib.h.e.d("++++++ num = " + size);
            int i = size - 100;
            com.baidu.adp.lib.h.e.d("++++++ removeCount= " + i);
            for (int i2 = 0; i2 < i; i2++) {
                msgPageData.getChatMessages().remove(0);
            }
        }
    }

    public void a(int i, com.baidu.tieba.im.message.b bVar) {
        bVar.a(i);
        this.I.a(bVar);
    }

    public void f(int i) {
        this.d.c(0);
        this.j.a(0);
    }
}
