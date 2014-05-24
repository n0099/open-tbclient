package com.baidu.tieba.im.live.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.newwidget.animation.CircleRippleView;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag extends RelativeLayout {
    private View A;
    private int B;
    private boolean C;
    private int D;
    private View E;
    public TextView a;
    public View b;
    public TbImageView c;
    com.baidu.tbadk.editortool.ab d;
    @SuppressLint({"HandlerLeak"})
    public final Handler e;
    private View f;
    private LiveRoomChatActivity g;
    private LayoutInflater h;
    private TextView i;
    private ImageView j;
    private TextView k;
    private int l;
    private LinearLayout m;
    private ImageView n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private CircleRippleView r;
    private TextView s;
    private ImageView t;
    private ImageView u;
    private ProgressBar v;
    private View w;
    private long x;
    private boolean y;
    private HeadImageView z;

    public ag(Context context) {
        super(context);
        this.l = 0;
        this.r = null;
        this.x = 0L;
        this.y = true;
        this.B = 2;
        this.C = false;
        this.D = 5;
        this.e = new ah(this);
        a(context);
    }

    private void a(Context context) {
        this.g = (LiveRoomChatActivity) context;
        this.d = new com.baidu.tbadk.editortool.ab(context);
        this.d.d(true);
        this.h = (LayoutInflater) context.getSystemService("layout_inflater");
        this.w = this.h.inflate(com.baidu.tieba.w.live_room_chat_header, (ViewGroup) this, true);
        this.f = this.w.findViewById(com.baidu.tieba.v.header_root);
        this.v = (ProgressBar) this.w.findViewById(com.baidu.tieba.v.progressBar);
        this.q = (ImageView) this.w.findViewById(com.baidu.tieba.v.live_normal_bg);
        this.r = (CircleRippleView) this.w.findViewById(com.baidu.tieba.v.live_room_ripple_view);
        this.z = (HeadImageView) this.w.findViewById(com.baidu.tieba.v.header_view);
        this.z.setAutoChangeStyle(false);
        this.z.setDrawBorder(false);
        this.z.setIsRound(true);
        this.z.setDefaultResource(com.baidu.tieba.u.pic_default_head);
        this.z.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.z.setGifIconSupport(false);
        this.p = (ImageView) this.w.findViewById(com.baidu.tieba.v.live_stop_bg);
        this.i = (TextView) this.w.findViewById(com.baidu.tieba.v.live_listener_count);
        this.j = (ImageView) this.w.findViewById(com.baidu.tieba.v.live_record_icon);
        this.k = (TextView) this.w.findViewById(com.baidu.tieba.v.live_record_time);
        this.t = (ImageView) this.w.findViewById(com.baidu.tieba.v.live_small_set);
        this.t.setOnClickListener(this.g);
        this.u = (ImageView) this.w.findViewById(com.baidu.tieba.v.live_room_like);
        this.u.setOnTouchListener(new am(this, null));
        this.n = (ImageView) this.w.findViewById(com.baidu.tieba.v.live_room_anchor_portrait);
        this.m = (LinearLayout) this.w.findViewById(com.baidu.tieba.v.live_room_anchor_portrait_ll);
        this.s = (TextView) this.w.findViewById(com.baidu.tieba.v.live_chat_room_note);
        this.A = this.w.findViewById(com.baidu.tieba.v.live_stop_host);
        this.o = (TextView) this.w.findViewById(com.baidu.tieba.v.live_stop);
        this.E = this.w.findViewById(com.baidu.tieba.v.live_chat_note_layout);
        this.a = (TextView) this.w.findViewById(com.baidu.tieba.v.publish_show_text);
        this.b = this.w.findViewById(com.baidu.tieba.v.image_show_layout);
        this.c = (TbImageView) this.w.findViewById(com.baidu.tieba.v.image_show);
    }

    public void a(ChatMessage chatMessage) {
        switch (chatMessage.getMsgType()) {
            case 1:
                this.b.setVisibility(8);
                this.E.setVisibility(8);
                this.a.setVisibility(0);
                this.a.setText(chatMessage.getContent());
                break;
            case 2:
                this.a.setVisibility(8);
                a(getContext(), this.c, this.b, chatMessage);
                break;
            case 3:
                BdLog.e("发的语音类型， 不支持");
                break;
            case 4:
                this.b.setVisibility(8);
                this.E.setVisibility(8);
                String b = b(chatMessage);
                this.a.setVisibility(0);
                this.a.setText(b);
                break;
        }
        this.e.removeMessages(1);
        this.e.sendEmptyMessageDelayed(1, 10000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(ChatMessage chatMessage) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        String content = chatMessage.getContent();
        try {
            jSONArray = new JSONArray(content);
        } catch (JSONException e) {
            try {
                jSONObject = new JSONObject(content);
            } catch (JSONException e2) {
            }
        }
        if (jSONArray.length() > 0) {
            jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject == null) {
                return jSONObject.optString("face_name");
            }
            return null;
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a2 A[Catch: Exception -> 0x004d, TryCatch #1 {Exception -> 0x004d, blocks: (B:77:0x0019, B:79:0x0035, B:83:0x0069, B:85:0x0075, B:86:0x0089, B:88:0x008f, B:90:0x0098, B:92:0x00a2, B:93:0x00ad, B:95:0x00b0, B:96:0x00bb, B:98:0x00f4, B:99:0x00fa, B:119:0x0171, B:100:0x0104, B:112:0x014f), top: B:125:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00b0 A[Catch: Exception -> 0x004d, TryCatch #1 {Exception -> 0x004d, blocks: (B:77:0x0019, B:79:0x0035, B:83:0x0069, B:85:0x0075, B:86:0x0089, B:88:0x008f, B:90:0x0098, B:92:0x00a2, B:93:0x00ad, B:95:0x00b0, B:96:0x00bb, B:98:0x00f4, B:99:0x00fa, B:119:0x0171, B:100:0x0104, B:112:0x014f), top: B:125:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f4 A[Catch: Exception -> 0x004d, TryCatch #1 {Exception -> 0x004d, blocks: (B:77:0x0019, B:79:0x0035, B:83:0x0069, B:85:0x0075, B:86:0x0089, B:88:0x008f, B:90:0x0098, B:92:0x00a2, B:93:0x00ad, B:95:0x00b0, B:96:0x00bb, B:98:0x00f4, B:99:0x00fa, B:119:0x0171, B:100:0x0104, B:112:0x014f), top: B:125:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, TbImageView tbImageView, View view, ChatMessage chatMessage) {
        com.baidu.adp.widget.a.a aVar;
        String optString;
        String[] split;
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0 && tbImageView != null && view != null) {
            try {
                view.setVisibility(8);
                tbImageView.setOnClickListener(null);
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String a = com.baidu.tieba.im.f.r.a(jSONObject, true);
                if (a == null) {
                    BdLog.e("invalid small pic in content:" + chatMessage.getContent());
                    return;
                }
                tbImageView.setTag(a);
                if (a.startsWith("http")) {
                    com.baidu.tbadk.editortool.ab abVar = new com.baidu.tbadk.editortool.ab(context);
                    abVar.d(true);
                    aVar = abVar.a(a, false, true, (com.baidu.tbadk.imageManager.d) new ai(this, tbImageView, view));
                } else {
                    view.setVisibility(0);
                    try {
                        aVar = com.baidu.tbadk.imageManager.e.a().c(a);
                        try {
                            if (aVar == null) {
                                Bitmap a2 = com.baidu.tbadk.core.util.g.a(com.baidu.tbadk.core.util.aw.a().a(com.baidu.adp.lib.util.b.a().a(a)), 10.0f, true);
                                if (a2 != null) {
                                    aVar = new com.baidu.adp.widget.a.a(a2, false);
                                    if (chatMessage.getWidth() < 1) {
                                        chatMessage.setWidth(aVar.c());
                                        chatMessage.setHeight(aVar.d());
                                    }
                                    com.baidu.tbadk.imageManager.e.a().b(a, aVar);
                                } else {
                                    aVar = null;
                                }
                            } else if (chatMessage.getWidth() < 1) {
                                chatMessage.setWidth(aVar.c());
                                chatMessage.setHeight(aVar.d());
                            }
                        } catch (Exception e) {
                            e = e;
                            BdLog.e("codec", "showPic", e);
                            if (chatMessage.getWidth() < 1) {
                                split = optString.split(",");
                                if (split.length > 0) {
                                }
                                if (split.length > 1) {
                                }
                            }
                            LocalViewSize.a();
                            LocalViewSize.ImageSize a3 = LocalViewSize.a().a(getMsgSPicMaxSize(), chatMessage.getHeight(), chatMessage.getWidth());
                            com.baidu.tbadk.core.util.resourceLoader.b a4 = a(a3.width, a3.height, true);
                            a3.height = a4.c;
                            a3.width = a4.b;
                            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                            layoutParams.height = a3.height;
                            layoutParams.width = a3.width;
                            tbImageView.setLayoutParams(layoutParams);
                            if (aVar == null) {
                            }
                            tbImageView.setOnClickListener(new aj(this, chatMessage));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        aVar = null;
                    }
                }
                if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("big_size")) != null) {
                    split = optString.split(",");
                    if (split.length > 0) {
                        chatMessage.setWidth(com.baidu.adp.lib.f.b.a(split[0], 0));
                    }
                    if (split.length > 1) {
                        chatMessage.setHeight(com.baidu.adp.lib.f.b.a(split[1], 0));
                    }
                }
                LocalViewSize.a();
                LocalViewSize.ImageSize a32 = LocalViewSize.a().a(getMsgSPicMaxSize(), chatMessage.getHeight(), chatMessage.getWidth());
                com.baidu.tbadk.core.util.resourceLoader.b a42 = a(a32.width, a32.height, true);
                a32.height = a42.c;
                a32.width = a42.b;
                ViewGroup.LayoutParams layoutParams2 = tbImageView.getLayoutParams();
                layoutParams2.height = a32.height;
                layoutParams2.width = a32.width;
                tbImageView.setLayoutParams(layoutParams2);
                if (aVar == null) {
                    tbImageView.f();
                    aVar.a(tbImageView);
                } else {
                    tbImageView.setImageBitmap(null);
                    tbImageView.setTag(a);
                }
                tbImageView.setOnClickListener(new aj(this, chatMessage));
            } catch (Exception e3) {
                BdLog.e("error:" + e3.getMessage());
                e3.printStackTrace();
            }
        }
    }

    private com.baidu.tbadk.core.util.resourceLoader.b a(int i, int i2, boolean z) {
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7 = 70;
        LocalViewSize.ImageSize msgSPicMaxSize = getMsgSPicMaxSize();
        if (msgSPicMaxSize.height >= msgSPicMaxSize.width) {
            i3 = msgSPicMaxSize.height;
        } else {
            i3 = msgSPicMaxSize.width;
        }
        if (z) {
            if (i / i2 >= 3) {
                z2 = true;
                i4 = i / 2;
                i5 = i;
            } else if (i2 / i >= 3) {
                i5 = i2 / 2;
                z2 = true;
                i4 = i2;
            }
            if (i5 <= i4 && i5 > i3) {
                i4 = (int) (i4 / (i5 / i3));
            } else if (i4 > i5 || i4 <= i3) {
                i3 = i5;
            } else {
                int i8 = i3;
                i3 = (int) (i5 / (i4 / i3));
                i4 = i8;
            }
            if (z2 && i <= i3 && i2 <= i4) {
                i3 = (int) (i3 * 0.9d);
                i4 = (int) (i4 * 0.9d);
            }
            if (i3 < 70 || i4 >= 70) {
                i7 = i4;
                i6 = i3;
            } else {
                i6 = 70;
            }
            return new com.baidu.tbadk.core.util.resourceLoader.b(i6, i7, z2);
        }
        z2 = false;
        i4 = i2;
        i5 = i;
        if (i5 <= i4) {
        }
        if (i4 > i5) {
        }
        i3 = i5;
        if (z2) {
            i3 = (int) (i3 * 0.9d);
            i4 = (int) (i4 * 0.9d);
        }
        if (i3 < 70) {
        }
        i7 = i4;
        i6 = i3;
        return new com.baidu.tbadk.core.util.resourceLoader.b(i6, i7, z2);
    }

    private LocalViewSize.ImageSize getMsgSPicMaxSize() {
        int i;
        int b = com.baidu.adp.lib.util.k.b(getContext());
        if (b < 240) {
            i = b / 3;
        } else if (b <= 320) {
            i = 90;
        } else if (b <= 480) {
            i = 180;
        } else if (b <= 720) {
            i = 280;
        } else {
            i = b / 3;
        }
        LocalViewSize.ImageSize imageSize = new LocalViewSize.ImageSize();
        imageSize.height = i;
        imageSize.width = i;
        return imageSize;
    }

    public View getNoteLayout() {
        return this.E;
    }

    public void setHeaderBackground(Drawable drawable) {
        if (drawable != null) {
            this.f.setBackgroundDrawable(drawable);
        }
    }

    public void setUserCount(int i) {
        this.i.setText(String.valueOf(i));
    }

    public void setIsHost(boolean z) {
        this.C = z;
    }

    public void a(int i, boolean z) {
        this.D = i;
        if (this.C) {
            if (this.D == 1) {
                h();
                g();
            } else if (this.D == 3) {
                h();
                j();
            } else if (this.D == 5) {
                h();
                m();
            } else if (this.D == 6) {
                h();
                g();
            }
        } else if (this.D == 1) {
            h();
            l();
        } else if (this.D == 3) {
            h();
            j();
        } else if (this.D == 5) {
            h();
            m();
        } else if (this.D == 6) {
            h();
            k();
        }
    }

    private void g() {
        this.n.setBackgroundDrawable(this.g.getResources().getDrawable(com.baidu.tieba.u.icon_live_voice_selector));
        this.m.setVisibility(0);
        this.n.setVisibility(0);
    }

    private void h() {
        this.v.setVisibility(8);
        this.A.setVisibility(8);
        this.o.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.p.setVisibility(8);
        this.z.setVisibility(8);
        this.q.setVisibility(8);
        this.r.b();
    }

    private void i() {
        this.z.setVisibility(0);
        this.q.setVisibility(0);
        this.r.a();
    }

    private void j() {
        h();
        i();
    }

    private void k() {
        this.r.b();
        this.o.setText(this.g.getResources().getString(com.baidu.tieba.y.live_room_end));
        this.z.setVisibility(0);
        this.o.setVisibility(0);
        this.p.setVisibility(0);
    }

    private void l() {
        h();
        this.o.setText(this.g.getResources().getString(com.baidu.tieba.y.live_room_not_start));
        if (this.C) {
            this.A.setVisibility(0);
            this.z.setVisibility(0);
            this.p.setVisibility(0);
        } else {
            this.z.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }
        this.r.b();
    }

    private void m() {
        h();
        this.o.setText(this.g.getResources().getString(com.baidu.tieba.y.live_room_pause));
        if (this.C) {
            this.A.setVisibility(0);
            this.z.setVisibility(0);
            this.p.setVisibility(0);
        } else {
            this.z.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }
        this.r.b();
    }

    public ImageView getmLiveRoomLike() {
        return this.u;
    }

    public ImageView getAnchorImg() {
        return this.n;
    }

    public View getLiveStopView() {
        return this.o;
    }

    public View getLiveStopHost() {
        return this.A;
    }

    public void setHeaderImage(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.a(this.z);
        }
    }

    public HeadImageView getHeaderImage() {
        return this.z;
    }

    public void a() {
        this.j.setVisibility(0);
        this.k.setVisibility(0);
    }

    public void b() {
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void setRecordTime(CharSequence charSequence) {
        int measureText;
        if (charSequence != null) {
            TextPaint paint = this.k.getPaint();
            if (charSequence.length() != this.l) {
                if (charSequence.length() <= 5) {
                    measureText = (int) paint.measureText("00:00");
                } else {
                    measureText = (int) paint.measureText("00:00:00");
                }
                this.k.setWidth(measureText);
            }
            this.k.setText(charSequence);
        }
    }

    public void c() {
        int measureText;
        String string = this.g.getString(com.baidu.tieba.y.live_chat_room_default_time);
        TextPaint paint = this.k.getPaint();
        if (string.length() != this.l) {
            if (string.length() <= 5) {
                measureText = (int) paint.measureText("00:00");
            } else {
                measureText = (int) paint.measureText("00:00:00");
            }
            this.k.setWidth(measureText);
        }
        this.k.setText(string);
    }

    public ImageView getSettingButton() {
        return this.t;
    }

    public int getIsLike() {
        return this.B;
    }

    public void setData(int i) {
        this.B = i;
        if (this.B == 1) {
            this.y = false;
            f();
            return;
        }
        this.y = true;
        e();
    }

    public boolean d() {
        return this.y;
    }

    public void e() {
        this.u.setBackgroundDrawable(this.g.getResources().getDrawable(com.baidu.tieba.u.btn_live_no_praise_selector));
    }

    public void f() {
        this.u.setBackgroundDrawable(this.g.getResources().getDrawable(com.baidu.tieba.u.btn_live_praise_selector));
    }

    public void a(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.g, com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new ak(this), 200L);
        }
    }

    public void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.g, com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new al(this), 600L);
        }
    }

    public void a(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.g, com.baidu.tieba.p.praise_animation_scale1));
    }

    public void setNoteText(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.C) {
                this.s.setText(this.g.getString(com.baidu.tieba.y.live_group_note));
                return;
            } else {
                this.s.setText("");
                return;
            }
        }
        this.s.setText(String.format(this.g.getString(com.baidu.tieba.y.live_chat_room_note), str));
    }
}
