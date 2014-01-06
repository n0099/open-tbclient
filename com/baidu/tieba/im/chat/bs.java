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
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.baidu.tieba.editortool.EmotionTabHost;
import com.baidu.tieba.im.data.MsgPageData;
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
public class bs extends com.baidu.adp.a.e implements com.baidu.tieba.editortool.t, com.baidu.tieba.voice.ae {
    private static final String a = bs.class.getName();
    private LinearLayout A;
    private Button B;
    private Button C;
    private Button D;
    private EmotionTabHost E;
    private LinearLayout F;
    private TextView G;
    private ba H;
    private br I;
    private AlertDialog J;
    private AlertDialog K;
    private AlertDialog L;
    private AlertDialog M;
    private AlertDialog N;
    private FrameLayout O;
    private int P;
    private int Q;
    private int R;
    private Handler S;
    private ch T;
    private VoiceManager.VoiceModel U;
    private int V;
    private long W;
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

    public bs(ba baVar, boolean z, int i) {
        super(baVar);
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
        this.O = null;
        this.P = 0;
        this.Q = 5;
        this.R = 0;
        this.S = new bt(this);
        this.V = 0;
        this.W = 0L;
        this.H = baVar;
        this.R = i;
        baVar.setContentView(R.layout.msg_msglist_activity);
        a(baVar, z);
        a(baVar);
        b(baVar);
        c(baVar);
        d(baVar);
        e(baVar);
        g(baVar);
        h(baVar);
    }

    private void a(ba baVar, boolean z) {
        String string;
        this.d = (NavigationBar) baVar.findViewById(R.id.lay_title_bar);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, baVar);
        this.f = this.d.a("");
        baVar.getLayoutInflater();
        View inflate = LayoutInflater.from(this.H).inflate(R.layout.msg_chat_top_notify, (ViewGroup) null);
        this.h = (ImageView) inflate.findViewById(R.id.img_receiver);
        this.i = (ImageView) inflate.findViewById(R.id.img_close_notify);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        if (this.R == 0) {
            string = baVar.getString(R.string.msglist_groupinfo);
        } else {
            string = this.R == 1 ? baVar.getString(R.string.msglist_personInfo) : null;
        }
        if (string != null) {
            this.g = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string, baVar);
        }
        if (z) {
            H();
        } else {
            I();
        }
    }

    private void a(ba baVar) {
        this.j = (NoNetworkView) baVar.findViewById(R.id.view_no_network);
    }

    private void b(ba baVar) {
        this.k = (BdListView) baVar.findViewById(R.id.lis_msg);
        this.l = (ProgressBar) baVar.findViewById(R.id.msg_progress);
        this.l.setVisibility(8);
        this.I = new br(baVar, this.R);
        this.I.a((com.baidu.adp.lib.b.a) baVar);
        this.I.a((com.baidu.adp.lib.b.b) baVar);
        this.k.setAdapter((ListAdapter) this.I);
        this.k.setOnScrollListener(new bx(this));
        this.k.setOnSrollToTopListener(baVar);
        this.k.setOnSrollToBottomListener(baVar);
        this.k.setItemsCanFocus(true);
        this.k.setFocusable(false);
        this.k.setFocusableInTouchMode(false);
        this.k.setClickable(false);
        this.k.setOnTouchListener(new by(this));
        this.k.setKybdsScrollBottom(true);
        this.k.setRecyclerListener(new bz(this));
    }

    private void c(ba baVar) {
        this.m = (LinearLayout) baVar.findViewById(R.id.lay_msgsend_voice);
        this.m.setVisibility(8);
        this.n = (Button) baVar.findViewById(R.id.btn_msgsend_softkey);
        this.n.setOnClickListener(new ca(this));
        this.o = (Button) baVar.findViewById(R.id.btn_msgsend_more1);
        this.o.setOnClickListener(new cc(this));
        this.p = (RelativeLayout) baVar.findViewById(R.id.btn_msgsend_voice);
        this.p.setOnTouchListener(baVar);
        this.q = (TextView) baVar.findViewById(R.id.tex_send_voice);
        this.s = (LinearLayout) baVar.findViewById(R.id.lay_msgsend_voicelayer);
        this.s.setVisibility(8);
        this.r = (ImageView) baVar.findViewById(R.id.img_msgsend_recording);
        this.t = (LinearLayout) baVar.findViewById(R.id.lay_msgsend_voicelayer_short);
        this.u = (LinearLayout) baVar.findViewById(R.id.lay_msgsend_voicelayer_cancel);
    }

    private void d(ba baVar) {
        this.v = (LinearLayout) baVar.findViewById(R.id.lay_msgsend_text);
        this.v.setVisibility(0);
        this.w = (Button) baVar.findViewById(R.id.btn_msgsend_govoice);
        this.w.setOnClickListener(new cd(this));
        this.x = (Button) baVar.findViewById(R.id.btn_msgsend_more2);
        this.x.setOnClickListener(new ce(this));
        this.z = (EditText) baVar.findViewById(R.id.edt_msgsend_text);
        this.z.setCursorVisible(false);
        this.z.setFocusable(true);
        this.z.setFocusableInTouchMode(true);
        this.z.addTextChangedListener(new cg(this));
        this.z.setOnTouchListener(new bu(this));
        this.y = (Button) baVar.findViewById(R.id.btn_msgsend_send);
        this.y.setOnClickListener(baVar);
        this.y.setEnabled(false);
        this.y.setTextColor(this.H.getResources().getColorStateList(R.color.post_image_btn_color));
    }

    private void e(ba baVar) {
        this.A = (LinearLayout) baVar.findViewById(R.id.lay_msgsend_more);
        this.A.setVisibility(8);
        this.B = (Button) baVar.findViewById(R.id.btn_msgsend_camera);
        this.B.setOnClickListener(baVar);
        this.C = (Button) baVar.findViewById(R.id.btn_msgsend_image);
        this.C.setOnClickListener(baVar);
        this.D = (Button) baVar.findViewById(R.id.btn_msgsend_expression);
        f(baVar);
    }

    private void f(ba baVar) {
        this.E = (EmotionTabHost) baVar.findViewById(R.id.face_view);
        if (this.R == 0) {
            this.E.setFrom(3);
        } else {
            this.E.setFrom(2);
        }
        this.E.setOnDataSelected(this);
        this.E.setIsInChat(true);
        this.D.setOnClickListener(new bv(this));
    }

    private void g(ba baVar) {
        this.F = (LinearLayout) baVar.findViewById(R.id.lay_last_msg);
        this.G = (TextView) baVar.findViewById(R.id.text_last_msg);
        this.F.setOnClickListener(baVar);
    }

    private void h(ba baVar) {
        this.O = (FrameLayout) baVar.findViewById(R.id.lay_bottom_bar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        a(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.A.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.E.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.m.setVisibility(8);
        this.v.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.m.setVisibility(0);
        this.v.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        U();
        this.z.requestFocus();
        a(this.z, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.z.requestFocus();
        this.E.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        new Handler().postDelayed(new bw(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        List<com.baidu.tieba.im.message.b> b = this.I.b();
        if (b != null && b.size() > 0) {
            this.k.setSelection(b.size() - 1);
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.A.getVisibility() != 0) {
            if (this.E.getVisibility() == 0) {
                this.E.setVisibility(8);
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
    public boolean W() {
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
        N();
        O();
        P();
        R();
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
                com.baidu.adp.lib.h.e.b(a, "refreshCheckNew", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public BdListView g() {
        return this.k;
    }

    private boolean h(int i) {
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
        if (bVar != null && !com.baidu.tieba.im.d.d.d(bVar)) {
            String b = b(bVar);
            if (!TextUtils.isEmpty(b)) {
                this.F.setVisibility(0);
                this.G.setText(b);
            }
        }
    }

    private String b(com.baidu.tieba.im.message.b bVar) {
        return com.baidu.tieba.im.d.d.h(bVar);
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

    public void d(int i) {
        l(this.H);
        this.M.getListView().setTag(Integer.valueOf(i));
        this.M.show();
    }

    public void o() {
        this.l.setVisibility(8);
    }

    private void i(ba baVar) {
        if (this.J == null) {
            CharSequence[] charSequenceArr = {baVar.getString(R.string.operate_copy), baVar.getString(R.string.msg_at), baVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {baVar.getString(R.string.operate_copy), baVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(baVar);
            builder.setTitle(baVar.getString(R.string.operation));
            if (this.R == 0) {
                builder.setItems(charSequenceArr, baVar);
            } else {
                builder.setItems(charSequenceArr2, baVar);
            }
            this.J = builder.create();
            this.J.setCanceledOnTouchOutside(true);
        }
    }

    private void j(ba baVar) {
        if (this.K == null) {
            CharSequence[] charSequenceArr = {baVar.getString(R.string.msg_at), baVar.getString(R.string.msg_img_save), baVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {baVar.getString(R.string.msg_img_save), baVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(baVar);
            builder.setTitle(baVar.getString(R.string.operation));
            if (this.R == 0) {
                builder.setItems(charSequenceArr, baVar);
            } else {
                builder.setItems(charSequenceArr2, baVar);
            }
            this.K = builder.create();
            this.K.setCanceledOnTouchOutside(true);
        }
    }

    private void k(ba baVar) {
        if (this.L != null) {
            this.L = null;
        }
        boolean ak = TiebaApplication.g().ak();
        CharSequence[] charSequenceArr = {baVar.getString(R.string.group_close_receiver), baVar.getString(R.string.msg_at), baVar.getString(R.string.msg_delete)};
        CharSequence[] charSequenceArr2 = {baVar.getString(R.string.group_close_receiver), baVar.getString(R.string.msg_delete)};
        if (ak) {
            charSequenceArr[0] = baVar.getString(R.string.group_close_receiver);
            charSequenceArr2[0] = baVar.getString(R.string.group_close_receiver);
        } else {
            charSequenceArr[0] = baVar.getString(R.string.group_open_receiver);
            charSequenceArr2[0] = baVar.getString(R.string.group_open_receiver);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(baVar);
        builder.setTitle(baVar.getString(R.string.operation));
        if (this.R == 0) {
            builder.setItems(charSequenceArr, baVar);
        } else {
            builder.setItems(charSequenceArr2, baVar);
        }
        this.L = builder.create();
        this.L.setCanceledOnTouchOutside(true);
    }

    private void l(ba baVar) {
        if (this.M == null) {
            CharSequence[] charSequenceArr = {baVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {baVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(baVar);
            builder.setTitle(baVar.getString(R.string.operation));
            if (this.R == 0) {
                builder.setItems(charSequenceArr, baVar);
            } else {
                builder.setItems(charSequenceArr2, baVar);
            }
            this.M = builder.create();
            this.M.setCanceledOnTouchOutside(true);
        }
    }

    public void p() {
        this.j.setVisible(true);
    }

    public void q() {
        this.j.setVisible(false);
    }

    public boolean r() {
        return this.E.getVisibility() == 0 || this.A.getVisibility() == 0;
    }

    public void s() {
        if (this.E.getVisibility() == 0) {
            this.E.setVisibility(8);
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

    public AlertDialog C() {
        return this.M;
    }

    public LinearLayout D() {
        return this.F;
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(boolean z) {
        if (z) {
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void E() {
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
                this.S.sendMessageDelayed(this.S.obtainMessage(1), 500L);
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
    public void e(int i) {
    }

    @Override // com.baidu.tieba.voice.ae
    public void f(int i) {
        this.V = Math.max(i, this.V);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.W > 150) {
            this.V = 0;
            this.W = uptimeMillis;
        }
        this.P++;
        if (this.P % this.Q == 0) {
            this.P = 0;
            if (this.V < 2) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.V < 10) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.V < 20) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.V < 30) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.V < 40) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.V < 50) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(ch chVar) {
        this.T = chVar;
    }

    public void F() {
        this.h.setVisibility(8);
    }

    public void G() {
        this.h.setVisibility(0);
    }

    public void H() {
        this.i.setVisibility(8);
    }

    public void I() {
        this.i.setVisibility(0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.z.setText(jSONObject.getString("input_draft"));
                this.z.setSelection(this.z.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    Q();
                } else {
                    P();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String J() {
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

    public void K() {
        if (this.S != null) {
            this.S.removeMessages(1);
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

    public void g(int i) {
        this.d.c(0);
        this.j.a(0);
        this.E.b(0);
    }

    public com.baidu.tieba.util.i L() {
        if (this.I != null) {
            return this.I.c();
        }
        return null;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tieba.editortool.q)) {
                com.baidu.tieba.editortool.q qVar = (com.baidu.tieba.editortool.q) obj;
                WritableEmotionGroup.EmotionGroupType b = qVar.b();
                String a2 = qVar.a();
                if (b == WritableEmotionGroup.EmotionGroupType.LOCAL) {
                    if (a2 != null) {
                        this.z.getText().insert(this.z.getSelectionStart(), a2);
                    }
                } else if (a2 != null) {
                    this.H.a(qVar);
                }
            }
        } else if (i == 21 && this.z.getSelectionStart() > 0) {
            String substring = this.z.getText().toString().substring(0, this.z.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            if (matcher.find()) {
                this.z.getText().delete(this.z.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.z.getSelectionStart());
                return;
            }
            this.z.getText().delete(this.z.getSelectionStart() - 1, this.z.getSelectionStart());
        }
    }
}
