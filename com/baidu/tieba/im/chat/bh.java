package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.voice.VoiceManager;
import com.google.gson.Gson;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.a.e implements com.baidu.tieba.voice.af {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1435a = bh.class.getName();
    private Button A;
    private Button B;
    private Button C;
    private ab D;
    private LinearLayout E;
    private TextView F;
    private MsglistActivity G;
    private bg H;
    private int I;
    private AlertDialog J;
    private AlertDialog K;
    private AlertDialog L;
    private AlertDialog M;
    private FrameLayout N;
    private int O;
    private int P;
    private Handler Q;
    private bv R;
    private VoiceManager.VoiceModel S;
    private int T;
    private long U;
    private final int c;
    private ImageView d;
    private TextView e;
    private Button f;
    private ImageView g;
    private ImageView h;
    private NoNetworkView i;
    private BdListView j;
    private ProgressBar k;
    private LinearLayout l;
    private Button m;
    private Button n;
    private RelativeLayout o;
    private TextView p;
    private ImageView q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private Button v;
    private Button w;
    private Button x;
    private EditText y;
    private LinearLayout z;

    public bh(MsglistActivity msglistActivity, boolean z, boolean z2) {
        super(msglistActivity);
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
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = 0;
        this.P = 5;
        this.Q = new bi(this);
        this.T = 0;
        this.U = 0L;
        this.G = msglistActivity;
        msglistActivity.setContentView(R.layout.msg_msglist_activity);
        this.I = com.baidu.adp.lib.h.f.a(msglistActivity);
        a(msglistActivity, z2);
        a(msglistActivity);
        b(msglistActivity);
        c(msglistActivity);
        d(msglistActivity);
        e(msglistActivity);
        g(msglistActivity);
        b(msglistActivity, z);
    }

    private void a(MsglistActivity msglistActivity, boolean z) {
        this.d = (ImageView) msglistActivity.findViewById(R.id.img_title_back);
        this.d.setOnClickListener(msglistActivity);
        this.e = (TextView) msglistActivity.findViewById(R.id.tex_group_name);
        this.f = (Button) msglistActivity.findViewById(R.id.btn_groupInfo);
        this.f.setOnClickListener(msglistActivity);
        this.g = (ImageView) msglistActivity.findViewById(R.id.img_receiver);
        this.h = (ImageView) msglistActivity.findViewById(R.id.img_close_notify);
        if (z) {
            H();
        } else {
            I();
        }
    }

    private void a(MsglistActivity msglistActivity) {
        this.i = (NoNetworkView) msglistActivity.findViewById(R.id.view_no_network);
        this.i.a(0);
    }

    private void b(MsglistActivity msglistActivity) {
        this.j = (BdListView) msglistActivity.findViewById(R.id.lis_msg);
        this.k = (ProgressBar) msglistActivity.findViewById(R.id.msg_progress);
        this.k.setVisibility(8);
        this.H = new bg(msglistActivity);
        this.H.a((com.baidu.adp.lib.b.a) msglistActivity);
        this.H.a((com.baidu.adp.lib.b.b) msglistActivity);
        this.j.setAdapter((ListAdapter) this.H);
        this.j.setOnScrollListener(new bl(this));
        this.j.setOnSrollToTopListener(msglistActivity);
        this.j.setOnSrollToBottomListener(msglistActivity);
        this.j.setItemsCanFocus(true);
        this.j.setFocusable(false);
        this.j.setFocusableInTouchMode(false);
        this.j.setClickable(false);
        this.j.setOnTouchListener(new bm(this));
        this.j.setKybdsScrollBottom(true);
        this.j.setRecyclerListener(new bn(this));
    }

    private void c(MsglistActivity msglistActivity) {
        this.l = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voice);
        this.l.setVisibility(8);
        this.m = (Button) msglistActivity.findViewById(R.id.btn_msgsend_softkey);
        this.m.setOnClickListener(new bo(this));
        this.n = (Button) msglistActivity.findViewById(R.id.btn_msgsend_more1);
        this.n.setOnClickListener(new bq(this));
        this.o = (RelativeLayout) msglistActivity.findViewById(R.id.btn_msgsend_voice);
        this.o.setOnTouchListener(msglistActivity);
        this.p = (TextView) msglistActivity.findViewById(R.id.tex_send_voice);
        this.r = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer);
        this.r.setVisibility(8);
        this.q = (ImageView) msglistActivity.findViewById(R.id.img_msgsend_recording);
        this.s = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer_short);
        this.t = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer_cancel);
    }

    private void d(MsglistActivity msglistActivity) {
        this.u = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_text);
        this.u.setVisibility(0);
        this.v = (Button) msglistActivity.findViewById(R.id.btn_msgsend_govoice);
        this.v.setOnClickListener(new br(this));
        this.w = (Button) msglistActivity.findViewById(R.id.btn_msgsend_more2);
        this.w.setOnClickListener(new bs(this));
        this.y = (EditText) msglistActivity.findViewById(R.id.edt_msgsend_text);
        this.y.setFocusable(true);
        this.y.setFocusableInTouchMode(true);
        this.y.addTextChangedListener(new bu(this));
        this.y.setOnTouchListener(new bj(this));
        this.x = (Button) msglistActivity.findViewById(R.id.btn_msgsend_send);
        this.x.setOnClickListener(msglistActivity);
        this.x.setEnabled(false);
        this.x.setTextColor(this.G.getResources().getColorStateList(R.color.post_image_btn_color));
    }

    private void e(MsglistActivity msglistActivity) {
        this.z = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_more);
        this.z.setVisibility(8);
        this.A = (Button) msglistActivity.findViewById(R.id.btn_msgsend_camera);
        this.A.setOnClickListener(msglistActivity);
        this.B = (Button) msglistActivity.findViewById(R.id.btn_msgsend_image);
        this.B.setOnClickListener(msglistActivity);
        this.C = (Button) msglistActivity.findViewById(R.id.btn_msgsend_expression);
        f(msglistActivity);
    }

    private void f(MsglistActivity msglistActivity) {
        this.D = new ab(msglistActivity, this.y);
        this.C.setOnClickListener(new bk(this));
    }

    private void g(MsglistActivity msglistActivity) {
        this.E = (LinearLayout) msglistActivity.findViewById(R.id.lay_last_msg);
        this.F = (TextView) msglistActivity.findViewById(R.id.text_last_msg);
        this.E.setOnClickListener(msglistActivity);
    }

    private void b(MsglistActivity msglistActivity, boolean z) {
        this.N = (FrameLayout) msglistActivity.findViewById(R.id.lay_bottom_bar);
        if (z) {
            E();
        } else {
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.y.clearFocus();
        a(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.z.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.D.a(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.l.setVisibility(8);
        this.u.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.l.setVisibility(0);
        this.u.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        S();
        this.y.requestFocus();
        a(this.y, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.y.requestFocus();
        this.D.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        List<ChatMessage> b = this.H.b();
        if (b != null && b.size() > 0) {
            this.j.setSelection(b.size() - 1);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.z.getVisibility() != 0) {
            if (this.D.a() == 0) {
                this.D.a(8);
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(0);
        }
    }

    public void a(MsgPageData msgPageData, GroupData groupData) {
        if (msgPageData != null && groupData != null) {
            this.H.a(groupData.getGroupId());
            this.H.a(msgPageData.getChatMessages());
            this.H.notifyDataSetInvalidated();
            a(groupData.getName(), true);
        }
    }

    public void a(String str, boolean z) {
        int i = 184;
        if (this.g.getVisibility() == 0 && this.h.getVisibility() == 0) {
            i = 204;
        }
        this.e.setText(com.baidu.adp.lib.h.f.a(this.e.getPaint(), str, this.I - com.baidu.adp.lib.h.f.a(this.G, i)));
        if (z) {
        }
    }

    private void a(MsgPageData msgPageData, int i) {
        try {
            com.baidu.adp.lib.h.d.a(f1435a, "doRefresh", "selection:" + i);
            if (msgPageData != null) {
                this.H.a();
                this.H.a(msgPageData.getChatMessages());
                this.H.notifyDataSetChanged();
                if (i >= 0) {
                    this.j.setSelection(i);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.b(f1435a, "doRefresh", e.getMessage());
        }
    }

    public void a(MsgPageData msgPageData) {
        a(msgPageData, -1);
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
                a(msgPageData, i);
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.b(f1435a, "refreshGo2New", e.getMessage());
                a(msgPageData, -1);
            }
        }
    }

    public void c(MsgPageData msgPageData) {
        try {
            com.baidu.adp.lib.h.d.a(f1435a, "refreshPrepage", "new:" + msgPageData.getNewAddNum());
            int firstVisiblePosition = this.j.getFirstVisiblePosition();
            if (msgPageData.getIsNewAdd()) {
                a(msgPageData, firstVisiblePosition + msgPageData.getNewAddNum());
            } else {
                a(msgPageData, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.b(f1435a, "refreshPrepage", e.getMessage());
            a(msgPageData, -1);
        }
    }

    public String a() {
        String d = d(this.y.getText().toString());
        if (TextUtils.isEmpty(d)) {
            return null;
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U() {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.b(f1435a, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.y.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
    }

    private String d(String str) {
        try {
            return Pattern.compile("\n+").matcher(str.trim()).replaceAll("\n");
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.b(f1435a, "checkTextNum", e.getMessage());
            return null;
        }
    }

    public void e() {
        this.y.setText("");
    }

    public void a(int i, String str) {
        if (str != null) {
            com.baidu.adp.lib.h.f.a(this.G, str);
            return;
        }
        String a2 = com.baidu.tieba.im.d.e.a(i);
        if (a2 != null && a2.length() > 0) {
            com.baidu.adp.lib.h.f.a(this.G, a2);
        }
    }

    public void a(String str) {
        String str2;
        String obj = this.y.getText().toString();
        if (obj.equals("")) {
            str2 = "@" + str + " ";
        } else {
            str2 = obj + " @" + str + " ";
        }
        this.y.setText(str2);
        this.y.setSelection(str2.length());
        M();
        N();
        O();
        Q();
    }

    public void a(boolean z) {
        if (z) {
            this.o.setBackgroundResource(R.drawable.but_posts_talk_s);
            this.p.setTextColor(Color.parseColor("#ffe7edf6"));
            this.p.setText(this.G.getString(R.string.msglist_no_push));
            return;
        }
        this.o.setBackgroundResource(R.drawable.but_posts_talk_n);
        this.p.setTextColor(Color.parseColor("#ff222e3e"));
        this.p.setText(this.G.getString(R.string.msglist_push_talk));
    }

    public void d(MsgPageData msgPageData) {
        if (msgPageData != null) {
            try {
                com.baidu.adp.lib.h.d.a(f1435a, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
                boolean z = false;
                if (msgPageData.getIsNewAdd()) {
                    z = f(msgPageData.getNewAddNum());
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
                com.baidu.adp.lib.h.d.b(f1435a, "refreshCheckNew", e.getMessage());
                a(msgPageData, -1);
            }
        }
    }

    public BdListView f() {
        return this.j;
    }

    private boolean f(int i) {
        List<ChatMessage> b = this.H.b();
        if (b == null) {
            return false;
        }
        return b.size() <= i || this.j.getLastVisiblePosition() == (b.size() + (-1)) - i;
    }

    public void g() {
        this.r.setVisibility(0);
    }

    public void h() {
        this.r.setVisibility(8);
    }

    public void i() {
        this.s.setVisibility(0);
    }

    public void j() {
        this.s.setVisibility(8);
    }

    public void k() {
        this.t.setVisibility(0);
    }

    public void l() {
        this.t.setVisibility(8);
    }

    private void a(ChatMessage chatMessage) {
        if (chatMessage != null && !com.baidu.tieba.im.d.c.c(chatMessage)) {
            String b = b(chatMessage);
            if (!TextUtils.isEmpty(b)) {
                this.E.setVisibility(0);
                this.F.setText(b);
            }
        }
    }

    private String b(ChatMessage chatMessage) {
        return com.baidu.tieba.im.d.c.g(chatMessage);
    }

    public void m() {
        if (this.E.getVisibility() == 0) {
            this.E.setVisibility(8);
            this.F.setText("");
        }
    }

    public void a(int i) {
        h(this.G);
        this.J.getListView().setTag(Integer.valueOf(i));
        this.J.show();
    }

    public void b(int i) {
        i(this.G);
        this.K.getListView().setTag(Integer.valueOf(i));
        this.K.show();
    }

    public void c(int i) {
        j(this.G);
        this.L.getListView().setTag(Integer.valueOf(i));
        this.L.show();
    }

    public void n() {
        this.k.setVisibility(8);
    }

    private void h(MsglistActivity msglistActivity) {
        if (this.J == null) {
            CharSequence[] charSequenceArr = {msglistActivity.getString(R.string.operate_copy), msglistActivity.getString(R.string.msg_at)};
            AlertDialog.Builder builder = new AlertDialog.Builder(msglistActivity);
            builder.setTitle(msglistActivity.getString(R.string.operation));
            builder.setItems(charSequenceArr, msglistActivity);
            this.J = builder.create();
            this.J.setCanceledOnTouchOutside(true);
        }
    }

    private void i(MsglistActivity msglistActivity) {
        if (this.K == null) {
            CharSequence[] charSequenceArr = {msglistActivity.getString(R.string.msg_at), msglistActivity.getString(R.string.msg_img_save)};
            AlertDialog.Builder builder = new AlertDialog.Builder(msglistActivity);
            builder.setTitle(msglistActivity.getString(R.string.operation));
            builder.setItems(charSequenceArr, msglistActivity);
            this.K = builder.create();
            this.K.setCanceledOnTouchOutside(true);
        }
    }

    private void j(MsglistActivity msglistActivity) {
        if (this.L != null) {
            this.L = null;
        }
        boolean ap = TiebaApplication.g().ap();
        CharSequence[] charSequenceArr = {msglistActivity.getString(R.string.group_close_receiver), msglistActivity.getString(R.string.msg_at)};
        if (ap) {
            charSequenceArr[0] = msglistActivity.getString(R.string.group_close_receiver);
        } else {
            charSequenceArr[0] = msglistActivity.getString(R.string.group_open_receiver);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(msglistActivity);
        builder.setTitle(msglistActivity.getString(R.string.operation));
        builder.setItems(charSequenceArr, msglistActivity);
        this.L = builder.create();
        this.L.setCanceledOnTouchOutside(true);
    }

    public void o() {
        this.i.setVisible(true);
    }

    public void p() {
        this.i.setVisible(false);
    }

    public boolean q() {
        return this.D.a() == 0 || this.z.getVisibility() == 0;
    }

    public void r() {
        if (this.D.a() == 0) {
            this.D.a(8);
        }
        if (this.z.getVisibility() == 0) {
            this.z.setVisibility(8);
        }
    }

    public ImageView s() {
        return this.d;
    }

    public Button t() {
        return this.x;
    }

    public Button u() {
        return this.A;
    }

    public Button v() {
        return this.B;
    }

    public Button w() {
        return this.f;
    }

    public RelativeLayout x() {
        return this.o;
    }

    public AlertDialog y() {
        return this.J;
    }

    public AlertDialog z() {
        return this.K;
    }

    public AlertDialog A() {
        return this.L;
    }

    public LinearLayout B() {
        return this.E;
    }

    @Override // com.baidu.tieba.voice.af
    public void b(boolean z) {
        if (z) {
        }
    }

    @Override // com.baidu.tieba.voice.af
    public void C() {
    }

    @Override // com.baidu.tieba.voice.af
    public void b(int i, String str) {
        if (!com.baidu.adp.lib.h.h.a(str)) {
            com.baidu.adp.lib.h.d.c("----record error. " + i + "---errMsg:" + str);
            if (i == 3) {
                this.G.a(str);
                h();
            } else if (i == 2) {
                l();
                j();
                i();
                this.Q.sendMessageDelayed(this.Q.obtainMessage(1), 500L);
            } else {
                this.G.a(str);
            }
        }
    }

    @Override // com.baidu.tieba.voice.af
    public void a(String str, int i) {
        VoiceManager.VoiceModel voiceModel = new VoiceManager.VoiceModel();
        voiceModel.duration = i;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.S = voiceModel;
        if (this.R != null) {
            this.R.a(voiceModel);
        }
    }

    @Override // com.baidu.tieba.voice.af
    public void b(String str) {
        this.S = null;
        if (this.R != null) {
            this.R.a();
        }
    }

    @Override // com.baidu.tieba.voice.af
    public void d(int i) {
    }

    @Override // com.baidu.tieba.voice.af
    public void e(int i) {
        this.T = Math.max(i, this.T);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.U > 150) {
            this.T = 0;
            this.U = uptimeMillis;
        }
        this.O++;
        if (this.O % this.P == 0) {
            this.O = 0;
            if (this.T < 2) {
                this.q.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.T < 10) {
                this.q.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.T < 20) {
                this.q.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.T < 30) {
                this.q.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.T < 40) {
                this.q.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.T < 50) {
                this.q.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.q.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(bv bvVar) {
        this.R = bvVar;
    }

    public void D() {
        this.N.setVisibility(8);
        N();
        M();
        L();
    }

    public void E() {
        this.N.setVisibility(0);
    }

    public void F() {
        this.g.setVisibility(8);
    }

    public void G() {
        this.g.setVisibility(0);
    }

    public void H() {
        this.h.setVisibility(8);
    }

    public void I() {
        this.h.setVisibility(0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.y.setText(jSONObject.getString("input_draft"));
                this.y.setSelection(this.y.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    P();
                } else {
                    O();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String J() {
        String str;
        if (this.u.getVisibility() == 0) {
            str = "input_text";
        } else {
            str = "input_voice";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("input_draft", this.y.getText().toString());
        hashMap.put("input_status", str);
        return new Gson().toJson(hashMap);
    }

    public void K() {
        if (this.Q != null) {
            this.Q.removeMessages(1);
        }
    }

    private void e(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
            com.baidu.adp.lib.h.d.d("++++++ num = " + size);
            int i = size - 100;
            com.baidu.adp.lib.h.d.d("++++++ removeCount= " + i);
            for (int i2 = 0; i2 < i; i2++) {
                msgPageData.getChatMessages().remove(0);
            }
        }
    }
}
