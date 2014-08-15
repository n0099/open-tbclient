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
    private ImageView D;
    private Button E;
    private ToolMoreView F;
    private LinearLayout G;
    private TextView H;
    private cq I;
    private final AlertDialog J;
    private int K;
    private final Handler L;
    private v M;
    private VoiceData.VoiceModel N;
    private int O;
    private long P;
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
    private View l;
    private TextView m;
    private ImageView n;
    private ImageView o;
    private NoNetworkView p;
    private FrameLayout q;
    private BdListView r;
    private ProgressBar s;
    private LinearLayout t;
    private ImageView u;
    private ImageView v;
    private RelativeLayout w;
    private TextView x;
    private ImageView y;
    private LinearLayout z;

    protected abstract void d();

    public g(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity);
        this.a = null;
        this.l = null;
        this.m = null;
        this.b = null;
        this.n = null;
        this.o = null;
        this.p = null;
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
        this.c = null;
        this.D = null;
        this.E = null;
        this.d = null;
        this.F = null;
        this.e = null;
        this.G = null;
        this.H = null;
        this.f = null;
        this.h = null;
        this.J = null;
        this.i = null;
        this.K = 0;
        this.L = new h(this);
        this.j = true;
        this.k = null;
        this.O = 0;
        this.P = 0L;
        this.f = msglistActivity;
        msglistActivity.setContentView(com.baidu.tieba.v.msg_msglist_activity);
        this.k = (KeyboardLayout) msglistActivity.findViewById(com.baidu.tieba.u.msg_root_view);
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
        this.a = (NavigationBar) talkableActivity.findViewById(com.baidu.tieba.u.lay_title_bar);
        this.l = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.m = this.a.a("");
        View inflate = LayoutInflater.from(this.f).inflate(com.baidu.tieba.v.msg_chat_top_notify, (ViewGroup) null);
        this.n = (ImageView) inflate.findViewById(com.baidu.tieba.u.img_receiver);
        this.o = (ImageView) inflate.findViewById(com.baidu.tieba.u.img_close_notify);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, (View.OnClickListener) null);
        this.g = (FrameLayout) talkableActivity.findViewById(com.baidu.tieba.u.layout_bottom_input);
        if (z) {
            M();
        } else {
            N();
        }
    }

    private void c(TalkableActivity talkableActivity) {
        this.p = (NoNetworkView) talkableActivity.findViewById(com.baidu.tieba.u.view_no_network);
    }

    public cq a() {
        return this.I;
    }

    public void c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MsglistActivity msglistActivity) {
        this.q = (FrameLayout) msglistActivity.findViewById(com.baidu.tieba.u.layout_main);
        this.r = (BdListView) msglistActivity.findViewById(com.baidu.tieba.u.lis_msg);
        this.s = (ProgressBar) msglistActivity.findViewById(com.baidu.tieba.u.msg_progress);
        this.s.setVisibility(8);
        this.I = new cq(msglistActivity);
        d();
        this.I.a(this.j);
        this.I.a((com.baidu.adp.lib.b.a) msglistActivity);
        this.I.a((com.baidu.adp.lib.b.b) msglistActivity);
        this.r.setAdapter((ListAdapter) this.I);
        this.r.setOnScrollListener(new l(this));
        this.r.setOnSrollToTopListener(msglistActivity);
        this.r.setOnSrollToBottomListener(msglistActivity);
        this.r.setItemsCanFocus(true);
        this.r.setFocusable(false);
        this.r.setFocusableInTouchMode(false);
        this.r.setClickable(false);
        this.r.setOnTouchListener(new m(this));
        this.r.setKybdsScrollBottom(true);
        this.r.setRecyclerListener(new n(this));
    }

    private void b(MsglistActivity msglistActivity) {
        this.t = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.u.lay_msgsend_voice);
        this.t.setVisibility(8);
        this.u = (ImageView) msglistActivity.findViewById(com.baidu.tieba.u.btn_msgsend_softkey);
        this.u.setOnClickListener(new o(this));
        this.v = (ImageView) msglistActivity.findViewById(com.baidu.tieba.u.btn_msgsend_more1);
        this.v.setOnClickListener(new q(this));
        this.w = (RelativeLayout) msglistActivity.findViewById(com.baidu.tieba.u.btn_msgsend_voice);
        this.w.setOnTouchListener(msglistActivity);
        this.x = (TextView) msglistActivity.findViewById(com.baidu.tieba.u.tex_send_voice);
        this.z = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.u.lay_msgsend_voicelayer);
        this.z.setVisibility(8);
        this.y = (ImageView) msglistActivity.findViewById(com.baidu.tieba.u.img_msgsend_recording);
        this.A = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.u.lay_msgsend_voicelayer_short);
        this.B = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.u.lay_msgsend_voicelayer_cancel);
    }

    private void d(TalkableActivity talkableActivity) {
        this.C = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.u.lay_msgsend_text);
        this.C.setVisibility(0);
        this.c = (ImageView) talkableActivity.findViewById(com.baidu.tieba.u.btn_msgsend_govoice);
        this.c.setOnClickListener(new r(this));
        this.D = (ImageView) talkableActivity.findViewById(com.baidu.tieba.u.btn_msgsend_more2);
        this.D.setOnClickListener(new s(this));
        this.d = (EditText) talkableActivity.findViewById(com.baidu.tieba.u.edt_msgsend_text);
        this.d.setCursorVisible(false);
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.addTextChangedListener(new u(this));
        this.d.setOnTouchListener(new i(this));
        this.E = (Button) talkableActivity.findViewById(com.baidu.tieba.u.btn_msgsend_send);
        this.E.setOnClickListener(talkableActivity);
        this.E.setEnabled(false);
        this.E.setTextColor(this.f.getResources().getColorStateList(com.baidu.tieba.r.post_image_btn_color));
    }

    private void e(TalkableActivity talkableActivity) {
        this.F = (ToolMoreView) talkableActivity.findViewById(com.baidu.tieba.u.lay_msgsend_more);
        this.F.setVisibility(8);
        this.F.setOnClickListener(talkableActivity);
        this.F.f();
        a(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TalkableActivity talkableActivity) {
        this.e = (EmotionTabHost) talkableActivity.findViewById(com.baidu.tieba.u.face_view);
        this.e.setOnDataSelected(this);
        this.e.setIsInChat(true);
        this.F.getFaceButton().setOnClickListener(new j(this));
    }

    private void f(TalkableActivity talkableActivity) {
        this.G = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.u.lay_last_msg);
        this.H = (TextView) talkableActivity.findViewById(com.baidu.tieba.u.text_last_msg);
        this.G.setOnClickListener(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(TalkableActivity talkableActivity) {
        this.i = (ViewGroup) talkableActivity.findViewById(com.baidu.tieba.u.lay_bottom_bar);
    }

    public ViewGroup e() {
        return this.i;
    }

    public void f() {
        HidenSoftKeyPad(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.F.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        this.e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.t.setVisibility(8);
        this.C.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.t.setVisibility(0);
        this.C.setVisibility(8);
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
        List<ChatMessage> b = this.I.b();
        if (b != null && b.size() > 0) {
            this.r.setSelection(b.size() - 1);
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (this.F.getVisibility() != 0) {
            if (this.e.getVisibility() == 0) {
                this.e.setVisibility(8);
                this.F.setVisibility(0);
                return;
            }
            this.F.setVisibility(0);
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
        this.m.setText(str);
    }

    public void j() {
        this.I.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            try {
                this.I.a();
                this.I.a(msgPageData.getChatMessages());
                this.I.notifyDataSetChanged();
                if (i >= 0) {
                    this.r.setSelection(i);
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
            int firstVisiblePosition = this.r.getFirstVisiblePosition();
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
            this.w.setBackgroundResource(com.baidu.tieba.t.but_talk_s);
            this.x.setText(this.f.getString(com.baidu.tieba.x.msglist_no_push));
            return;
        }
        this.w.setBackgroundResource(com.baidu.tieba.t.but_talk_n);
        this.x.setText(this.f.getString(com.baidu.tieba.x.msglist_push_talk));
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
        return this.r;
    }

    private boolean d(int i) {
        List<ChatMessage> b = this.I.b();
        if (b == null) {
            return false;
        }
        if (b.size() <= i) {
            return true;
        }
        return this.r.getLastVisiblePosition() == (b.size() - n()) - i;
    }

    protected int n() {
        return 1;
    }

    public FrameLayout o() {
        return this.q;
    }

    public void p() {
        this.z.setVisibility(0);
    }

    public void q() {
        this.z.setVisibility(8);
    }

    public void r() {
        this.A.setVisibility(0);
    }

    public void s() {
        this.A.setVisibility(8);
    }

    public void t() {
        this.B.setVisibility(0);
    }

    public void u() {
        this.B.setVisibility(8);
    }

    private void a(ChatMessage chatMessage) {
        if (chatMessage != null && !com.baidu.tieba.im.d.j.e(chatMessage)) {
            String b = b(chatMessage);
            if (!TextUtils.isEmpty(b)) {
                this.G.setVisibility(0);
                this.H.setText(b);
            }
        }
    }

    private String b(ChatMessage chatMessage) {
        return com.baidu.tieba.im.d.j.j(chatMessage);
    }

    public void v() {
        if (this.G.getVisibility() == 0) {
            this.G.setVisibility(8);
            this.H.setText("");
        }
    }

    public void a(int i, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            a(this.f, strArr);
            this.h.getListView().setTag(Integer.valueOf(i));
            com.baidu.adp.lib.e.d.a(this.h, this.f);
        }
    }

    private void a(TalkableActivity talkableActivity, String[] strArr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(talkableActivity);
        builder.setTitle(talkableActivity.getString(com.baidu.tieba.x.operation));
        builder.setItems(strArr, talkableActivity);
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    public void w() {
        this.s.setVisibility(8);
    }

    public void x() {
        this.p.a(true);
    }

    public void y() {
        this.p.a(false);
    }

    public boolean z() {
        return this.e.getVisibility() == 0 || this.F.getVisibility() == 0;
    }

    public void A() {
        if (this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
        }
        if (this.F.getVisibility() == 0) {
            this.F.setVisibility(8);
        }
    }

    public View B() {
        return this.l;
    }

    public Button C() {
        return this.E;
    }

    public View D() {
        return this.F.getFaceButton();
    }

    public View E() {
        return this.F.getCameraButton();
    }

    public View F() {
        return this.F.getImageButton();
    }

    public View G() {
        return this.b;
    }

    public RelativeLayout H() {
        return this.w;
    }

    public AlertDialog I() {
        return this.h;
    }

    public LinearLayout J() {
        return this.G;
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
                this.L.sendMessageDelayed(this.L.obtainMessage(1), 500L);
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
        this.N = voiceModel;
        if (this.M != null) {
            this.M.a(voiceModel);
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void a(String str) {
        this.N = null;
        if (this.M != null) {
            this.M.a();
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void b(int i) {
    }

    @Override // com.baidu.tbadk.core.voice.z
    public void c(int i) {
        this.O = Math.max(i, this.O);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.P > 150) {
            this.O = 0;
            this.P = uptimeMillis;
        }
        this.K++;
        if (this.K % 5 == 0) {
            this.K = 0;
            if (this.O < 2) {
                this.y.setImageResource(com.baidu.tieba.t.icon_chat_talk_sound_up_zero);
            } else if (this.O < 10) {
                this.y.setImageResource(com.baidu.tieba.t.icon_chat_talk_sound_up_one);
            } else if (this.O < 20) {
                this.y.setImageResource(com.baidu.tieba.t.icon_chat_talk_sound_up_two);
            } else if (this.O < 30) {
                this.y.setImageResource(com.baidu.tieba.t.icon_chat_talk_sound_up_three);
            } else if (this.O < 40) {
                this.y.setImageResource(com.baidu.tieba.t.icon_chat_talk_sound_up_four);
            } else if (this.O < 50) {
                this.y.setImageResource(com.baidu.tieba.t.icon_chat_talk_sound_up_five);
            } else {
                this.y.setImageResource(com.baidu.tieba.t.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(v vVar) {
        this.M = vVar;
    }

    public void K() {
        this.n.setVisibility(8);
    }

    public void L() {
        this.n.setVisibility(0);
    }

    public void M() {
        this.o.setVisibility(8);
    }

    public void N() {
        this.o.setVisibility(0);
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
        if (this.C.getVisibility() == 0) {
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
        if (this.L != null) {
            this.L.removeMessages(1);
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
        this.I.a(chatMessage);
    }

    public void a(int i) {
        this.a.c(0);
        this.p.a(0);
        this.e.b(0);
        this.F.a(0);
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
        this.w.setEnabled(false);
        this.c.setEnabled(false);
        D().setEnabled(false);
        this.v.setEnabled(false);
        this.D.setEnabled(false);
        this.d.setEnabled(false);
        this.E.setEnabled(false);
    }
}
