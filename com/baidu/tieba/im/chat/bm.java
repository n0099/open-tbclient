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
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.ChatMessage;
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
public class bm extends com.baidu.adp.a.e implements com.baidu.tieba.voice.ae {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1571a = bm.class.getName();
    private LinearLayout A;
    private Button B;
    private Button C;
    private Button D;
    private ad E;
    private LinearLayout F;
    private TextView G;
    private MsglistActivity H;
    private bl I;
    private AlertDialog J;
    private AlertDialog K;
    private AlertDialog L;
    private AlertDialog M;
    private FrameLayout N;
    private int O;
    private int P;
    private Handler Q;
    private ca R;
    private VoiceManager.VoiceModel S;
    private int T;
    private long U;
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

    public bm(MsglistActivity msglistActivity, boolean z) {
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
        this.H = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = 0;
        this.P = 5;
        this.Q = new bn(this);
        this.T = 0;
        this.U = 0L;
        this.H = msglistActivity;
        msglistActivity.setContentView(R.layout.msg_msglist_activity);
        a(msglistActivity, z);
        a(msglistActivity);
        b(msglistActivity);
        c(msglistActivity);
        d(msglistActivity);
        e(msglistActivity);
        g(msglistActivity);
        h(msglistActivity);
    }

    private void a(MsglistActivity msglistActivity, boolean z) {
        this.d = (NavigationBar) msglistActivity.findViewById(R.id.lay_title_bar);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, msglistActivity);
        this.f = this.d.a("");
        msglistActivity.getLayoutInflater();
        View inflate = LayoutInflater.from(this.H).inflate(R.layout.msg_chat_top_notify, (ViewGroup) null);
        this.h = (ImageView) inflate.findViewById(R.id.img_receiver);
        this.i = (ImageView) inflate.findViewById(R.id.img_close_notify);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        this.g = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, msglistActivity.getString(R.string.msglist_groupinfo), msglistActivity);
        if (z) {
            F();
        } else {
            G();
        }
    }

    private void a(MsglistActivity msglistActivity) {
        this.j = (NoNetworkView) msglistActivity.findViewById(R.id.view_no_network);
    }

    private void b(MsglistActivity msglistActivity) {
        this.k = (BdListView) msglistActivity.findViewById(R.id.lis_msg);
        this.l = (ProgressBar) msglistActivity.findViewById(R.id.msg_progress);
        this.l.setVisibility(8);
        this.I = new bl(msglistActivity);
        this.I.a((com.baidu.adp.lib.b.a) msglistActivity);
        this.I.a((com.baidu.adp.lib.b.b) msglistActivity);
        this.k.setAdapter((ListAdapter) this.I);
        this.k.setOnScrollListener(new bq(this));
        this.k.setOnSrollToTopListener(msglistActivity);
        this.k.setOnSrollToBottomListener(msglistActivity);
        this.k.setItemsCanFocus(true);
        this.k.setFocusable(false);
        this.k.setFocusableInTouchMode(false);
        this.k.setClickable(false);
        this.k.setOnTouchListener(new br(this));
        this.k.setKybdsScrollBottom(true);
        this.k.setRecyclerListener(new bs(this));
    }

    private void c(MsglistActivity msglistActivity) {
        this.m = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voice);
        this.m.setVisibility(8);
        this.n = (Button) msglistActivity.findViewById(R.id.btn_msgsend_softkey);
        this.n.setOnClickListener(new bt(this));
        this.o = (Button) msglistActivity.findViewById(R.id.btn_msgsend_more1);
        this.o.setOnClickListener(new bv(this));
        this.p = (RelativeLayout) msglistActivity.findViewById(R.id.btn_msgsend_voice);
        this.p.setOnTouchListener(msglistActivity);
        this.q = (TextView) msglistActivity.findViewById(R.id.tex_send_voice);
        this.s = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer);
        this.s.setVisibility(8);
        this.r = (ImageView) msglistActivity.findViewById(R.id.img_msgsend_recording);
        this.t = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer_short);
        this.u = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_voicelayer_cancel);
    }

    private void d(MsglistActivity msglistActivity) {
        this.v = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_text);
        this.v.setVisibility(0);
        this.w = (Button) msglistActivity.findViewById(R.id.btn_msgsend_govoice);
        this.w.setOnClickListener(new bw(this));
        this.x = (Button) msglistActivity.findViewById(R.id.btn_msgsend_more2);
        this.x.setOnClickListener(new bx(this));
        this.z = (EditText) msglistActivity.findViewById(R.id.edt_msgsend_text);
        this.z.setFocusable(true);
        this.z.setFocusableInTouchMode(true);
        this.z.addTextChangedListener(new bz(this));
        this.z.setOnTouchListener(new bo(this));
        this.y = (Button) msglistActivity.findViewById(R.id.btn_msgsend_send);
        this.y.setOnClickListener(msglistActivity);
        this.y.setEnabled(false);
        this.y.setTextColor(this.H.getResources().getColorStateList(R.color.post_image_btn_color));
    }

    private void e(MsglistActivity msglistActivity) {
        this.A = (LinearLayout) msglistActivity.findViewById(R.id.lay_msgsend_more);
        this.A.setVisibility(8);
        this.B = (Button) msglistActivity.findViewById(R.id.btn_msgsend_camera);
        this.B.setOnClickListener(msglistActivity);
        this.C = (Button) msglistActivity.findViewById(R.id.btn_msgsend_image);
        this.C.setOnClickListener(msglistActivity);
        this.D = (Button) msglistActivity.findViewById(R.id.btn_msgsend_expression);
        f(msglistActivity);
    }

    private void f(MsglistActivity msglistActivity) {
        this.E = new ad(msglistActivity, this.z);
        this.D.setOnClickListener(new bp(this));
    }

    private void g(MsglistActivity msglistActivity) {
        this.F = (LinearLayout) msglistActivity.findViewById(R.id.lay_last_msg);
        this.G = (TextView) msglistActivity.findViewById(R.id.text_last_msg);
        this.F.setOnClickListener(msglistActivity);
    }

    private void h(MsglistActivity msglistActivity) {
        this.N = (FrameLayout) msglistActivity.findViewById(R.id.lay_bottom_bar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        a(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.A.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.E.a(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.m.setVisibility(8);
        this.v.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.m.setVisibility(0);
        this.v.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Q();
        this.z.requestFocus();
        a(this.z, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.z.requestFocus();
        this.E.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        List<ChatMessage> b = this.I.b();
        if (b != null && b.size() > 0) {
            this.k.setSelection(b.size() - 1);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (this.A.getVisibility() != 0) {
            if (this.E.a() == 0) {
                this.E.a(8);
                this.A.setVisibility(0);
                return;
            }
            this.A.setVisibility(0);
        }
    }

    public void a(MsgPageData msgPageData, GroupData groupData) {
        if (msgPageData != null && groupData != null) {
            this.I.a(groupData.getGroupId());
            this.I.a(msgPageData.getChatMessages());
            this.I.notifyDataSetInvalidated();
            a(groupData.getName(), true);
        }
    }

    public void a(String str, boolean z) {
        this.f.setText(str);
        if (z) {
        }
    }

    private void a(MsgPageData msgPageData, int i) {
        try {
            com.baidu.adp.lib.h.e.a(f1571a, "doRefresh", "selection:" + i);
            if (msgPageData != null) {
                this.I.a();
                this.I.a(msgPageData.getChatMessages());
                this.I.notifyDataSetChanged();
                if (i >= 0) {
                    this.k.setSelection(i);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(f1571a, "doRefresh", e.getMessage());
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
                com.baidu.adp.lib.h.e.b(f1571a, "refreshGo2New", e.getMessage());
                a(msgPageData, -1);
            }
        }
    }

    public void c(MsgPageData msgPageData) {
        try {
            com.baidu.adp.lib.h.e.a(f1571a, "refreshPrepage", "new:" + msgPageData.getNewAddNum());
            int firstVisiblePosition = this.k.getFirstVisiblePosition();
            com.baidu.adp.lib.h.e.d("pos" + firstVisiblePosition);
            if (msgPageData.getIsNewAdd()) {
                int newAddNum = msgPageData.getNewAddNum();
                com.baidu.adp.lib.h.e.d("num new " + newAddNum);
                int i = firstVisiblePosition + newAddNum;
                com.baidu.adp.lib.h.e.d("pos2" + i);
                a(msgPageData, i);
            } else {
                a(msgPageData, -1);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(f1571a, "refreshPrepage", e.getMessage());
            a(msgPageData, -1);
        }
    }

    public String a() {
        String d = d(this.z.getText().toString());
        if (TextUtils.isEmpty(d)) {
            return null;
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S() {
        try {
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(f1571a, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.z.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
    }

    private String d(String str) {
        try {
            return Pattern.compile("\n+").matcher(str.trim()).replaceAll("\n");
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(f1571a, "checkTextNum", e.getMessage());
            return null;
        }
    }

    public void e() {
        this.z.setText("");
    }

    public void a(int i, String str) {
        if (str != null) {
            com.baidu.adp.lib.h.g.a((Context) this.H, str);
            return;
        }
        String a2 = com.baidu.tieba.im.e.f.a(i);
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
        K();
        L();
        M();
        O();
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
                com.baidu.adp.lib.h.e.a(f1571a, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
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
                com.baidu.adp.lib.h.e.b(f1571a, "refreshCheckNew", e.getMessage());
                a(msgPageData, -1);
            }
        }
    }

    public BdListView f() {
        return this.k;
    }

    private boolean g(int i) {
        List<ChatMessage> b = this.I.b();
        if (b == null) {
            return false;
        }
        return b.size() <= i || this.k.getLastVisiblePosition() == (b.size() + (-1)) - i;
    }

    public void g() {
        this.s.setVisibility(0);
    }

    public void h() {
        this.s.setVisibility(8);
    }

    public void i() {
        this.t.setVisibility(0);
    }

    public void j() {
        this.t.setVisibility(8);
    }

    public void k() {
        this.u.setVisibility(0);
    }

    public void l() {
        this.u.setVisibility(8);
    }

    private void a(ChatMessage chatMessage) {
        if (chatMessage != null && !com.baidu.tieba.im.e.d.c(chatMessage)) {
            String b = b(chatMessage);
            if (!TextUtils.isEmpty(b)) {
                this.F.setVisibility(0);
                this.G.setText(b);
            }
        }
    }

    private String b(ChatMessage chatMessage) {
        return com.baidu.tieba.im.e.d.g(chatMessage);
    }

    public void m() {
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

    public void n() {
        this.l.setVisibility(8);
    }

    private void i(MsglistActivity msglistActivity) {
        if (this.J == null) {
            CharSequence[] charSequenceArr = {msglistActivity.getString(R.string.operate_copy), msglistActivity.getString(R.string.msg_at), msglistActivity.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(msglistActivity);
            builder.setTitle(msglistActivity.getString(R.string.operation));
            builder.setItems(charSequenceArr, msglistActivity);
            this.J = builder.create();
            this.J.setCanceledOnTouchOutside(true);
        }
    }

    private void j(MsglistActivity msglistActivity) {
        if (this.K == null) {
            CharSequence[] charSequenceArr = {msglistActivity.getString(R.string.msg_at), msglistActivity.getString(R.string.msg_img_save), msglistActivity.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(msglistActivity);
            builder.setTitle(msglistActivity.getString(R.string.operation));
            builder.setItems(charSequenceArr, msglistActivity);
            this.K = builder.create();
            this.K.setCanceledOnTouchOutside(true);
        }
    }

    private void k(MsglistActivity msglistActivity) {
        if (this.L != null) {
            this.L = null;
        }
        boolean ak = TiebaApplication.h().ak();
        CharSequence[] charSequenceArr = {msglistActivity.getString(R.string.group_close_receiver), msglistActivity.getString(R.string.msg_at), msglistActivity.getString(R.string.msg_delete)};
        if (ak) {
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
        this.j.setVisible(true);
    }

    public void p() {
        this.j.setVisible(false);
    }

    public boolean q() {
        return this.E.a() == 0 || this.A.getVisibility() == 0;
    }

    public void r() {
        if (this.E.a() == 0) {
            this.E.a(8);
        }
        if (this.A.getVisibility() == 0) {
            this.A.setVisibility(8);
        }
    }

    public ImageView s() {
        return this.e;
    }

    public Button t() {
        return this.y;
    }

    public Button u() {
        return this.B;
    }

    public Button v() {
        return this.C;
    }

    public TextView w() {
        return this.g;
    }

    public RelativeLayout x() {
        return this.p;
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
        return this.F;
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(boolean z) {
        if (z) {
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void C() {
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(int i, String str) {
        if (!com.baidu.adp.lib.h.l.a(str)) {
            com.baidu.adp.lib.h.e.c("----record error. " + i + "---errMsg:" + str);
            if (i == 3) {
                this.H.showToast(str);
                h();
            } else if (i == 2) {
                l();
                j();
                i();
                this.Q.sendMessageDelayed(this.Q.obtainMessage(1), 500L);
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
        this.S = voiceModel;
        if (this.R != null) {
            this.R.a(voiceModel);
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(String str) {
        this.S = null;
        if (this.R != null) {
            this.R.a();
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void d(int i) {
    }

    @Override // com.baidu.tieba.voice.ae
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
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.T < 10) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.T < 20) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.T < 30) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.T < 40) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.T < 50) {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.r.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(ca caVar) {
        this.R = caVar;
    }

    public void D() {
        this.h.setVisibility(8);
    }

    public void E() {
        this.h.setVisibility(0);
    }

    public void F() {
        this.i.setVisibility(8);
    }

    public void G() {
        this.i.setVisibility(0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.z.setText(jSONObject.getString("input_draft"));
                this.z.setSelection(this.z.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    N();
                } else {
                    M();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String H() {
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

    public void I() {
        if (this.Q != null) {
            this.Q.removeMessages(1);
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

    public void a(int i, ChatMessage chatMessage) {
        chatMessage.setProgressValue(i);
        this.I.a(chatMessage);
    }

    public void f(int i) {
        this.d.c(0);
        this.j.a(0);
    }
}
