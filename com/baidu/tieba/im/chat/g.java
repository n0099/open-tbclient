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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.editortool.ToolMoreView;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.adp.base.f implements com.baidu.tbadk.core.voice.z, com.baidu.tbadk.editortool.w {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private ImageView E;
    private Button F;
    private ToolMoreView G;
    private LinearLayout H;
    private TextView I;
    private cp J;
    private final AlertDialog K;
    private int L;
    private final int M;
    private final Handler N;
    private v O;
    private VoiceData.VoiceModel P;
    private int Q;
    private long R;
    protected NavigationBar a;
    protected View b;
    protected ImageView c;
    protected EditText d;
    protected EmotionTabHost e;
    protected MsglistActivity f;
    protected FrameLayout g;
    protected AlertDialog h;
    protected ViewGroup i;
    protected boolean j;
    protected KeyboardLayout k;
    private final int l;
    private View m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private NoNetworkView q;
    private FrameLayout r;
    private BdListView s;
    private ProgressBar t;
    private LinearLayout u;
    private ImageView v;
    private ImageView w;
    private RelativeLayout x;
    private TextView y;
    private ImageView z;

    protected abstract void d();

    public g(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity);
        this.l = 100;
        this.a = null;
        this.m = null;
        this.n = null;
        this.b = null;
        this.o = null;
        this.p = null;
        this.q = null;
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
        this.c = null;
        this.E = null;
        this.F = null;
        this.d = null;
        this.G = null;
        this.e = null;
        this.H = null;
        this.I = null;
        this.f = null;
        this.h = null;
        this.K = null;
        this.i = null;
        this.L = 0;
        this.M = 5;
        this.N = new h(this);
        this.j = true;
        this.k = null;
        this.Q = 0;
        this.R = 0L;
        this.f = msglistActivity;
        msglistActivity.setContentView(com.baidu.tieba.w.msg_msglist_activity);
        this.k = (KeyboardLayout) msglistActivity.findViewById(com.baidu.tieba.v.msg_root_view);
        a(msglistActivity, z);
        c(msglistActivity);
        a(msglistActivity);
        b(msglistActivity);
        d(msglistActivity);
        e(msglistActivity);
        f(msglistActivity);
        b((TalkableActivity) msglistActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TalkableActivity talkableActivity, boolean z) {
        this.a = (NavigationBar) talkableActivity.findViewById(com.baidu.tieba.v.lay_title_bar);
        this.m = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.n = this.a.a("");
        View inflate = LayoutInflater.from(this.f).inflate(com.baidu.tieba.w.msg_chat_top_notify, (ViewGroup) null);
        this.o = (ImageView) inflate.findViewById(com.baidu.tieba.v.img_receiver);
        this.p = (ImageView) inflate.findViewById(com.baidu.tieba.v.img_close_notify);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        this.g = (FrameLayout) talkableActivity.findViewById(com.baidu.tieba.v.layout_bottom_input);
        if (z) {
            M();
        } else {
            N();
        }
    }

    private void c(TalkableActivity talkableActivity) {
        this.q = (NoNetworkView) talkableActivity.findViewById(com.baidu.tieba.v.view_no_network);
    }

    public cp a() {
        return this.J;
    }

    public void c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MsglistActivity msglistActivity) {
        this.r = (FrameLayout) msglistActivity.findViewById(com.baidu.tieba.v.layout_main);
        this.s = (BdListView) msglistActivity.findViewById(com.baidu.tieba.v.lis_msg);
        this.t = (ProgressBar) msglistActivity.findViewById(com.baidu.tieba.v.msg_progress);
        this.t.setVisibility(8);
        this.J = new cp(msglistActivity);
        d();
        this.J.a(this.j);
        this.J.a((com.baidu.adp.lib.b.a) msglistActivity);
        this.J.a((com.baidu.adp.lib.b.b) msglistActivity);
        this.s.setAdapter((ListAdapter) this.J);
        this.s.setOnScrollListener(new l(this));
        this.s.setOnSrollToTopListener(msglistActivity);
        this.s.setOnSrollToBottomListener(msglistActivity);
        this.s.setItemsCanFocus(true);
        this.s.setFocusable(false);
        this.s.setFocusableInTouchMode(false);
        this.s.setClickable(false);
        this.s.setOnTouchListener(new m(this));
        this.s.setKybdsScrollBottom(true);
        this.s.setRecyclerListener(new n(this));
    }

    private void b(MsglistActivity msglistActivity) {
        this.u = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.v.lay_msgsend_voice);
        this.u.setVisibility(8);
        this.v = (ImageView) msglistActivity.findViewById(com.baidu.tieba.v.btn_msgsend_softkey);
        this.v.setOnClickListener(new o(this));
        this.w = (ImageView) msglistActivity.findViewById(com.baidu.tieba.v.btn_msgsend_more1);
        this.w.setOnClickListener(new q(this));
        this.x = (RelativeLayout) msglistActivity.findViewById(com.baidu.tieba.v.btn_msgsend_voice);
        this.x.setOnTouchListener(msglistActivity);
        this.y = (TextView) msglistActivity.findViewById(com.baidu.tieba.v.tex_send_voice);
        this.A = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer);
        this.A.setVisibility(8);
        this.z = (ImageView) msglistActivity.findViewById(com.baidu.tieba.v.img_msgsend_recording);
        this.B = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer_short);
        this.C = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer_cancel);
    }

    private void d(TalkableActivity talkableActivity) {
        this.D = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.v.lay_msgsend_text);
        this.D.setVisibility(0);
        this.c = (ImageView) talkableActivity.findViewById(com.baidu.tieba.v.btn_msgsend_govoice);
        this.c.setOnClickListener(new r(this));
        this.E = (ImageView) talkableActivity.findViewById(com.baidu.tieba.v.btn_msgsend_more2);
        this.E.setOnClickListener(new s(this));
        this.d = (EditText) talkableActivity.findViewById(com.baidu.tieba.v.edt_msgsend_text);
        this.d.setCursorVisible(false);
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.addTextChangedListener(new u(this));
        this.d.setOnTouchListener(new i(this));
        this.F = (Button) talkableActivity.findViewById(com.baidu.tieba.v.btn_msgsend_send);
        this.F.setOnClickListener(talkableActivity);
        this.F.setEnabled(false);
        this.F.setTextColor(this.f.getResources().getColorStateList(com.baidu.tieba.s.post_image_btn_color));
    }

    private void e(TalkableActivity talkableActivity) {
        this.G = (ToolMoreView) talkableActivity.findViewById(com.baidu.tieba.v.lay_msgsend_more);
        this.G.setVisibility(8);
        this.G.setOnClickListener(talkableActivity);
        this.G.f();
        a(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TalkableActivity talkableActivity) {
        this.e = (EmotionTabHost) talkableActivity.findViewById(com.baidu.tieba.v.face_view);
        this.e.setOnDataSelected(this);
        this.e.setIsInChat(true);
        this.G.getFaceButton().setOnClickListener(new j(this));
    }

    private void f(TalkableActivity talkableActivity) {
        this.H = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.v.lay_last_msg);
        this.I = (TextView) talkableActivity.findViewById(com.baidu.tieba.v.text_last_msg);
        this.H.setOnClickListener(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(TalkableActivity talkableActivity) {
        this.i = (ViewGroup) talkableActivity.findViewById(com.baidu.tieba.v.lay_bottom_bar);
    }

    public ViewGroup e() {
        return this.i;
    }

    public void f() {
        HidenSoftKeyPad(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.G.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        this.e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.u.setVisibility(8);
        this.D.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.u.setVisibility(0);
        this.D.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        W();
        this.d.requestFocus();
        ShowSoftKeyPadDelay(this.d, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.d.requestFocus();
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        new Handler().postDelayed(new k(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        List<ChatMessage> b = this.J.b();
        if (b != null && b.size() > 0) {
            this.s.setSelection(b.size() - 1);
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (this.G.getVisibility() != 0) {
            if (this.e.getVisibility() == 0) {
                this.e.setVisibility(8);
                this.G.setVisibility(0);
                return;
            }
            this.G.setVisibility(0);
        }
    }

    public void a(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            this.J.a(i);
            this.J.a(msgPageData.getChatMessages());
            this.J.notifyDataSetInvalidated();
        }
    }

    public void a(String str, boolean z) {
        this.n.setText(str);
    }

    public void j() {
        this.J.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            try {
                this.J.a();
                this.J.a(msgPageData.getChatMessages());
                this.J.notifyDataSetChanged();
                if (i >= 0) {
                    this.s.setSelection(i);
                }
            } catch (Exception e) {
            }
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
                b(msgPageData, -1);
            }
        }
    }

    public void c(MsgPageData msgPageData) {
        try {
            int firstVisiblePosition = this.s.getFirstVisiblePosition();
            if (msgPageData.getIsNewAdd()) {
                b(msgPageData, firstVisiblePosition + msgPageData.getNewAddNum());
            } else {
                b(msgPageData, -1);
            }
        } catch (Exception e) {
            b(msgPageData, -1);
        }
    }

    public String k() {
        String editable = this.d.getText().toString();
        if (TextUtils.isEmpty(editable)) {
            return null;
        }
        return editable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y() {
        return Pattern.compile("\\s*|\t|\r|\n").matcher(this.d.getText().toString()).replaceAll("").length() != 0;
    }

    public void l() {
        this.d.setText("");
    }

    public void b(String str) {
        String editable;
        String str2;
        if (this.d.getText().toString().equals("")) {
            str2 = "@" + str + " ";
        } else {
            str2 = String.valueOf(editable) + " @" + str + " ";
        }
        this.d.setText(str2);
        this.d.setSelection(str2.length());
        g();
        h();
        S();
        i();
    }

    public void b(boolean z) {
        if (z) {
            this.x.setBackgroundResource(com.baidu.tieba.u.but_talk_s);
            this.y.setText(this.f.getString(com.baidu.tieba.y.msglist_no_push));
            return;
        }
        this.x.setBackgroundResource(com.baidu.tieba.u.but_talk_n);
        this.y.setText(this.f.getString(com.baidu.tieba.y.msglist_push_talk));
    }

    public void d(MsgPageData msgPageData) {
        if (msgPageData != null) {
            boolean z = false;
            try {
                if (msgPageData.getIsNewAdd()) {
                    z = d(msgPageData.getNewAddNum());
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
                b(msgPageData, -1);
            }
        }
    }

    public BdListView m() {
        return this.s;
    }

    private boolean d(int i) {
        List<ChatMessage> b = this.J.b();
        if (b == null) {
            return false;
        }
        if (b.size() <= i) {
            return true;
        }
        return this.s.getLastVisiblePosition() == (b.size() - n()) - i;
    }

    protected int n() {
        return 1;
    }

    public FrameLayout o() {
        return this.r;
    }

    public void p() {
        this.A.setVisibility(0);
    }

    public void q() {
        this.A.setVisibility(8);
    }

    public void r() {
        this.B.setVisibility(0);
    }

    public void s() {
        this.B.setVisibility(8);
    }

    public void t() {
        this.C.setVisibility(0);
    }

    public void u() {
        this.C.setVisibility(8);
    }

    private void a(ChatMessage chatMessage) {
        if (chatMessage != null && !com.baidu.tieba.im.e.r.d(chatMessage)) {
            String b = b(chatMessage);
            if (!TextUtils.isEmpty(b)) {
                this.H.setVisibility(0);
                this.I.setText(b);
            }
        }
    }

    private String b(ChatMessage chatMessage) {
        return com.baidu.tieba.im.e.r.i(chatMessage);
    }

    public void v() {
        if (this.H.getVisibility() == 0) {
            this.H.setVisibility(8);
            this.I.setText("");
        }
    }

    public void a(int i, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            a(this.f, strArr);
            this.h.getListView().setTag(Integer.valueOf(i));
            this.h.show();
        }
    }

    private void a(TalkableActivity talkableActivity, String[] strArr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(talkableActivity);
        builder.setTitle(talkableActivity.getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, talkableActivity);
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    public void w() {
        this.t.setVisibility(8);
    }

    public void x() {
        this.q.a(true);
    }

    public void y() {
        this.q.a(false);
    }

    public boolean z() {
        return this.e.getVisibility() == 0 || this.G.getVisibility() == 0;
    }

    public void A() {
        if (this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
        }
        if (this.G.getVisibility() == 0) {
            this.G.setVisibility(8);
        }
    }

    public View B() {
        return this.m;
    }

    public Button C() {
        return this.F;
    }

    public View D() {
        return this.G.getFaceButton();
    }

    public View E() {
        return this.G.getCameraButton();
    }

    public View F() {
        return this.G.getImageButton();
    }

    public View G() {
        return this.b;
    }

    public RelativeLayout H() {
        return this.x;
    }

    public AlertDialog I() {
        return this.h;
    }

    public LinearLayout J() {
        return this.H;
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void a(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void b() {
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void a(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.f.showToast(str);
                q();
            } else if (i == 2) {
                u();
                s();
                r();
                this.N.sendMessageDelayed(this.N.obtainMessage(1), 500L);
            } else {
                this.f.showToast(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void a(String str, int i) {
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.P = voiceModel;
        if (this.O != null) {
            this.O.a(voiceModel);
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void a(String str) {
        this.P = null;
        if (this.O != null) {
            this.O.a();
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void b(int i) {
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void c(int i) {
        this.Q = Math.max(i, this.Q);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.R > 150) {
            this.Q = 0;
            this.R = uptimeMillis;
        }
        this.L++;
        if (this.L % 5 == 0) {
            this.L = 0;
            if (this.Q < 2) {
                this.z.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_zero);
            } else if (this.Q < 10) {
                this.z.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_one);
            } else if (this.Q < 20) {
                this.z.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_two);
            } else if (this.Q < 30) {
                this.z.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_three);
            } else if (this.Q < 40) {
                this.z.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_four);
            } else if (this.Q < 50) {
                this.z.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_five);
            } else {
                this.z.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(v vVar) {
        this.O = vVar;
    }

    public void K() {
        this.o.setVisibility(8);
    }

    public void L() {
        this.o.setVisibility(0);
    }

    public void M() {
        this.p.setVisibility(8);
    }

    public void N() {
        this.p.setVisibility(0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.d.setText(jSONObject.getString("input_draft"));
                this.d.setSelection(this.d.getText().toString().length());
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

    public String O() {
        String str;
        if (this.D.getVisibility() == 0) {
            str = "input_text";
        } else {
            str = "input_voice";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("input_draft", this.d.getText().toString());
        hashMap.put("input_status", str);
        return new Gson().toJson(hashMap);
    }

    public void P() {
        if (this.N != null) {
            this.N.removeMessages(1);
        }
    }

    private void e(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
            int i = size - 100;
            for (int i2 = 0; i2 < i; i2++) {
                msgPageData.getChatMessages().remove(0);
            }
        }
    }

    public void a(int i, ChatMessage chatMessage) {
        chatMessage.setProgressValue(i);
        this.J.a(chatMessage);
    }

    public void a(int i) {
        this.a.c(0);
        this.q.a(0);
        this.e.b(0);
        this.G.a(0);
    }

    protected void Q() {
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.d)) {
                com.baidu.tbadk.coreExtra.data.d dVar = (com.baidu.tbadk.coreExtra.data.d) obj;
                EmotionGroupType b = dVar.b();
                String a = dVar.a();
                if (b == EmotionGroupType.LOCAL) {
                    if (a != null) {
                        this.d.getText().insert(this.d.getSelectionStart(), a);
                    }
                } else if (a != null) {
                    this.f.a(dVar);
                    Q();
                }
            }
        } else if (i == 21 && this.d.getSelectionStart() > 0) {
            String substring = this.d.getText().toString().substring(0, this.d.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            if (matcher.find()) {
                this.d.getText().delete(this.d.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.d.getSelectionStart());
                return;
            }
            this.d.getText().delete(this.d.getSelectionStart() - 1, this.d.getSelectionStart());
        }
    }

    public void R() {
        E().setEnabled(false);
        F().setEnabled(false);
        this.x.setEnabled(false);
        this.c.setEnabled(false);
        D().setEnabled(false);
        this.w.setEnabled(false);
        this.E.setEnabled(false);
        this.d.setEnabled(false);
        this.F.setEnabled(false);
    }
}
