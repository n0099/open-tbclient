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
import com.baidu.adp.lib.util.BdLog;
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
public abstract class g extends com.baidu.adp.base.c implements com.baidu.tbadk.core.voice.y, com.baidu.tbadk.editortool.x {
    private static final String k = g.class.getName();
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private ImageView D;
    private Button E;
    private ToolMoreView F;
    private LinearLayout G;
    private TextView H;
    private cm I;
    private final AlertDialog J;
    private FrameLayout K;
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
    protected boolean i;
    protected KeyboardLayout j;
    private final int l;
    private View m;
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
        this.K = null;
        this.L = 0;
        this.M = 5;
        this.N = new h(this);
        this.i = true;
        this.j = null;
        this.Q = 0;
        this.R = 0L;
        this.f = msglistActivity;
        msglistActivity.setContentView(com.baidu.tieba.w.msg_msglist_activity);
        this.j = (KeyboardLayout) msglistActivity.findViewById(com.baidu.tieba.v.msg_root_view);
        a(msglistActivity, z);
        b((TalkableActivity) msglistActivity);
        a(msglistActivity);
        b(msglistActivity);
        c(msglistActivity);
        d(msglistActivity);
        e(msglistActivity);
        f(msglistActivity);
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
        this.g = (FrameLayout) talkableActivity.findViewById(com.baidu.tieba.v.lay_bottom_bar);
        if (z) {
            L();
        } else {
            M();
        }
    }

    private void b(TalkableActivity talkableActivity) {
        this.q = (NoNetworkView) talkableActivity.findViewById(com.baidu.tieba.v.view_no_network);
    }

    public cm a() {
        return this.I;
    }

    public void c() {
    }

    private void a(MsglistActivity msglistActivity) {
        this.r = (BdListView) msglistActivity.findViewById(com.baidu.tieba.v.lis_msg);
        this.s = (ProgressBar) msglistActivity.findViewById(com.baidu.tieba.v.msg_progress);
        this.s.setVisibility(8);
        this.I = new cm(msglistActivity);
        d();
        this.I.a(this.i);
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
        this.t = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.v.lay_msgsend_voice);
        this.t.setVisibility(8);
        this.u = (ImageView) msglistActivity.findViewById(com.baidu.tieba.v.btn_msgsend_softkey);
        this.u.setOnClickListener(new o(this));
        this.v = (ImageView) msglistActivity.findViewById(com.baidu.tieba.v.btn_msgsend_more1);
        this.v.setOnClickListener(new q(this));
        this.w = (RelativeLayout) msglistActivity.findViewById(com.baidu.tieba.v.btn_msgsend_voice);
        this.w.setOnTouchListener(msglistActivity);
        this.x = (TextView) msglistActivity.findViewById(com.baidu.tieba.v.tex_send_voice);
        this.z = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer);
        this.z.setVisibility(8);
        this.y = (ImageView) msglistActivity.findViewById(com.baidu.tieba.v.img_msgsend_recording);
        this.A = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer_short);
        this.B = (LinearLayout) msglistActivity.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer_cancel);
    }

    private void c(TalkableActivity talkableActivity) {
        this.C = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.v.lay_msgsend_text);
        this.C.setVisibility(0);
        this.c = (ImageView) talkableActivity.findViewById(com.baidu.tieba.v.btn_msgsend_govoice);
        this.c.setOnClickListener(new r(this));
        this.D = (ImageView) talkableActivity.findViewById(com.baidu.tieba.v.btn_msgsend_more2);
        this.D.setOnClickListener(new s(this));
        this.d = (EditText) talkableActivity.findViewById(com.baidu.tieba.v.edt_msgsend_text);
        this.d.setCursorVisible(false);
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.addTextChangedListener(new u(this));
        this.d.setOnTouchListener(new i(this));
        this.E = (Button) talkableActivity.findViewById(com.baidu.tieba.v.btn_msgsend_send);
        this.E.setOnClickListener(talkableActivity);
        this.E.setEnabled(false);
        this.E.setTextColor(this.f.getResources().getColorStateList(com.baidu.tieba.s.post_image_btn_color));
    }

    private void d(TalkableActivity talkableActivity) {
        this.F = (ToolMoreView) talkableActivity.findViewById(com.baidu.tieba.v.lay_msgsend_more);
        this.F.setVisibility(8);
        this.F.setOnClickListener(talkableActivity);
        this.F.e();
        a(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TalkableActivity talkableActivity) {
        this.e = (EmotionTabHost) talkableActivity.findViewById(com.baidu.tieba.v.face_view);
        this.e.setOnDataSelected(this);
        this.e.setIsInChat(true);
        this.F.getFaceButton().setOnClickListener(new j(this));
    }

    private void e(TalkableActivity talkableActivity) {
        this.G = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.v.lay_last_msg);
        this.H = (TextView) talkableActivity.findViewById(com.baidu.tieba.v.text_last_msg);
        this.G.setOnClickListener(talkableActivity);
    }

    private void f(TalkableActivity talkableActivity) {
        this.K = (FrameLayout) talkableActivity.findViewById(com.baidu.tieba.v.lay_bottom_bar);
    }

    public FrameLayout e() {
        return this.K;
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
    public void R() {
        this.t.setVisibility(8);
        this.C.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.t.setVisibility(0);
        this.C.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        V();
        this.d.requestFocus();
        ShowSoftKeyPadDelay(this.d, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        this.d.requestFocus();
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        new Handler().postDelayed(new k(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        List<ChatMessage> b = this.I.b();
        if (b != null && b.size() > 0) {
            this.r.setSelection(b.size() - 1);
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
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
        this.n.setText(str);
    }

    public void j() {
        this.I.notifyDataSetChanged();
    }

    private void b(MsgPageData msgPageData, int i) {
        try {
            BdLog.i(k, "doRefresh", "selection:" + i);
            if (msgPageData != null) {
                this.I.a();
                this.I.a(msgPageData.getChatMessages());
                this.I.notifyDataSetChanged();
                if (i >= 0) {
                    this.r.setSelection(i);
                }
            }
        } catch (Exception e) {
            BdLog.e(k, "doRefresh", e.getMessage());
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
                BdLog.e(k, "refreshGo2New", e.getMessage());
                b(msgPageData, -1);
            }
        }
    }

    public void c(MsgPageData msgPageData) {
        try {
            BdLog.i(k, "refreshPrepage", "new:" + msgPageData.getNewAddNum());
            int firstVisiblePosition = this.r.getFirstVisiblePosition();
            BdLog.d("pos" + firstVisiblePosition);
            if (msgPageData.getIsNewAdd()) {
                int newAddNum = msgPageData.getNewAddNum();
                BdLog.d("num new " + newAddNum);
                int i = firstVisiblePosition + newAddNum;
                BdLog.d("pos2" + i);
                b(msgPageData, i);
            } else {
                b(msgPageData, -1);
            }
        } catch (Exception e) {
            BdLog.e(k, "refreshPrepage", e.getMessage());
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
    public boolean X() {
        try {
        } catch (Exception e) {
            BdLog.e(k, "checkTextNum", e.getMessage());
        }
        if (Pattern.compile("\\s*|\t|\r|\n").matcher(this.d.getText().toString()).replaceAll("").length() == 0) {
            return false;
        }
        return true;
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
        R();
        i();
    }

    public void b(boolean z) {
        if (z) {
            this.w.setBackgroundResource(com.baidu.tieba.u.but_talk_s);
            this.x.setText(this.f.getString(com.baidu.tieba.y.msglist_no_push));
            return;
        }
        this.w.setBackgroundResource(com.baidu.tieba.u.but_talk_n);
        this.x.setText(this.f.getString(com.baidu.tieba.y.msglist_push_talk));
    }

    public void d(MsgPageData msgPageData) {
        if (msgPageData != null) {
            try {
                BdLog.i(k, "refreshCheckNew", "new:" + msgPageData.getNewAddNum());
                boolean z = false;
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
                BdLog.e(k, "refreshCheckNew", e.getMessage());
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
        BdLog.d("simon", "checkListAtNew", "lastVisiblePosition = " + this.r.getLastVisiblePosition());
        BdLog.d("simon", "checkListAtNew", "data.size = " + b.size());
        BdLog.d("simon", "checkListAtNew", "num = " + i);
        return this.r.getLastVisiblePosition() == (b.size() - n()) - i;
    }

    protected int n() {
        return 1;
    }

    public void o() {
        this.z.setVisibility(0);
    }

    public void p() {
        this.z.setVisibility(8);
    }

    public void q() {
        this.A.setVisibility(0);
    }

    public void r() {
        this.A.setVisibility(8);
    }

    public void s() {
        this.B.setVisibility(0);
    }

    public void t() {
        this.B.setVisibility(8);
    }

    private void a(ChatMessage chatMessage) {
        if (chatMessage != null && !com.baidu.tieba.im.f.r.d(chatMessage)) {
            String b = b(chatMessage);
            if (!TextUtils.isEmpty(b)) {
                this.G.setVisibility(0);
                this.H.setText(b);
            }
        }
    }

    private String b(ChatMessage chatMessage) {
        return com.baidu.tieba.im.f.r.i(chatMessage);
    }

    public void u() {
        if (this.G.getVisibility() == 0) {
            this.G.setVisibility(8);
            this.H.setText("");
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

    public void v() {
        this.s.setVisibility(8);
    }

    public void w() {
        this.q.setVisible(true);
    }

    public void x() {
        this.q.setVisible(false);
    }

    public boolean y() {
        return this.e.getVisibility() == 0 || this.F.getVisibility() == 0;
    }

    public void z() {
        if (this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
        }
        if (this.F.getVisibility() == 0) {
            this.F.setVisibility(8);
        }
    }

    public View A() {
        return this.m;
    }

    public Button B() {
        return this.E;
    }

    public View C() {
        return this.F.getFaceButton();
    }

    public View D() {
        return this.F.getCameraButton();
    }

    public View E() {
        return this.F.getImageButton();
    }

    public View F() {
        return this.b;
    }

    public RelativeLayout G() {
        return this.w;
    }

    public AlertDialog H() {
        return this.h;
    }

    public LinearLayout I() {
        return this.G;
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void b() {
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(int i, String str) {
        if (!StringUtils.isNull(str)) {
            BdLog.i("----record error. " + i + "---errMsg:" + str);
            if (i == 3) {
                this.f.showToast(str);
                p();
            } else if (i == 2) {
                t();
                r();
                q();
                this.N.sendMessageDelayed(this.N.obtainMessage(1), 500L);
            } else {
                this.f.showToast(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
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

    @Override // com.baidu.tbadk.core.voice.y
    public void a(String str) {
        this.P = null;
        if (this.O != null) {
            this.O.a();
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void b(int i) {
    }

    @Override // com.baidu.tbadk.core.voice.y
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
                this.y.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_zero);
            } else if (this.Q < 10) {
                this.y.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_one);
            } else if (this.Q < 20) {
                this.y.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_two);
            } else if (this.Q < 30) {
                this.y.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_three);
            } else if (this.Q < 40) {
                this.y.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_four);
            } else if (this.Q < 50) {
                this.y.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_five);
            } else {
                this.y.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_three);
            }
        }
    }

    public void a(v vVar) {
        this.O = vVar;
    }

    public void J() {
        this.o.setVisibility(8);
    }

    public void K() {
        this.o.setVisibility(0);
    }

    public void L() {
        this.p.setVisibility(8);
    }

    public void M() {
        this.p.setVisibility(0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.d.setText(jSONObject.getString("input_draft"));
                this.d.setSelection(this.d.getText().toString().length());
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

    public String N() {
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

    public void O() {
        if (this.N != null) {
            this.N.removeMessages(1);
        }
    }

    private void e(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
            BdLog.d("++++++ num = " + size);
            int i = size - 100;
            BdLog.d("++++++ removeCount= " + i);
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
        this.q.a(0);
        this.e.b(0);
        this.F.a(0);
    }

    protected void P() {
    }

    @Override // com.baidu.tbadk.editortool.x
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
                    P();
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

    public void Q() {
        D().setEnabled(false);
        E().setEnabled(false);
        this.w.setEnabled(false);
        this.c.setEnabled(false);
        C().setEnabled(false);
        this.v.setEnabled(false);
        this.D.setEnabled(false);
        this.d.setEnabled(false);
        this.E.setEnabled(false);
    }
}
