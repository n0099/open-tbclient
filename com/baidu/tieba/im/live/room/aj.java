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
import com.baidu.adp.newwidget.animation.CircleRippleView;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj extends RelativeLayout {
    private int A;
    private boolean B;
    private int C;
    private View D;
    public TextView a;
    public View b;
    public TbImageView c;
    @SuppressLint({"HandlerLeak"})
    public final Handler d;
    private View e;
    private LiveRoomChatActivity f;
    private LayoutInflater g;
    private TextView h;
    private ImageView i;
    private TextView j;
    private int k;
    private LinearLayout l;
    private ImageView m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private CircleRippleView q;
    private TextView r;
    private ImageView s;
    private ImageView t;
    private ProgressBar u;
    private View v;
    private long w;
    private boolean x;
    private HeadImageView y;
    private View z;

    public aj(Context context) {
        super(context);
        this.k = 0;
        this.q = null;
        this.w = 0L;
        this.x = true;
        this.A = 2;
        this.B = false;
        this.C = 5;
        this.d = new ak(this);
        a(context);
    }

    private void a(Context context) {
        this.f = (LiveRoomChatActivity) context;
        this.g = (LayoutInflater) context.getSystemService("layout_inflater");
        this.v = this.g.inflate(com.baidu.tieba.v.live_room_chat_header, (ViewGroup) this, true);
        this.e = this.v.findViewById(com.baidu.tieba.u.header_root);
        this.u = (ProgressBar) this.v.findViewById(com.baidu.tieba.u.progressBar);
        this.p = (ImageView) this.v.findViewById(com.baidu.tieba.u.live_normal_bg);
        this.q = (CircleRippleView) this.v.findViewById(com.baidu.tieba.u.live_room_ripple_view);
        this.y = (HeadImageView) this.v.findViewById(com.baidu.tieba.u.header_view);
        this.y.setAutoChangeStyle(false);
        this.y.setDrawBorder(false);
        this.y.setIsRound(true);
        this.y.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.y.setGifIconSupport(false);
        this.o = (ImageView) this.v.findViewById(com.baidu.tieba.u.live_stop_bg);
        this.h = (TextView) this.v.findViewById(com.baidu.tieba.u.live_listener_count);
        this.i = (ImageView) this.v.findViewById(com.baidu.tieba.u.live_record_icon);
        this.j = (TextView) this.v.findViewById(com.baidu.tieba.u.live_record_time);
        this.s = (ImageView) this.v.findViewById(com.baidu.tieba.u.live_small_set);
        this.s.setOnClickListener(this.f);
        this.t = (ImageView) this.v.findViewById(com.baidu.tieba.u.live_room_like);
        this.t.setOnTouchListener(new ap(this, null));
        this.m = (ImageView) this.v.findViewById(com.baidu.tieba.u.live_room_anchor_portrait);
        this.l = (LinearLayout) this.v.findViewById(com.baidu.tieba.u.live_room_anchor_portrait_ll);
        this.r = (TextView) this.v.findViewById(com.baidu.tieba.u.live_chat_room_note);
        this.z = this.v.findViewById(com.baidu.tieba.u.live_stop_host);
        this.n = (TextView) this.v.findViewById(com.baidu.tieba.u.live_stop);
        this.D = this.v.findViewById(com.baidu.tieba.u.live_chat_note_layout);
        this.a = (TextView) this.v.findViewById(com.baidu.tieba.u.publish_show_text);
        this.b = this.v.findViewById(com.baidu.tieba.u.image_show_layout);
        this.c = (TbImageView) this.v.findViewById(com.baidu.tieba.u.image_show);
    }

    public void a(ChatMessage chatMessage) {
        switch (chatMessage.getMsgType()) {
            case 1:
                this.b.setVisibility(8);
                this.D.setVisibility(8);
                this.a.setVisibility(0);
                this.a.setText(chatMessage.getContent());
                break;
            case 2:
                this.a.setVisibility(8);
                a(getContext(), this.c, this.b, chatMessage);
                break;
            case 4:
                this.b.setVisibility(8);
                this.D.setVisibility(8);
                String b = b(chatMessage);
                this.a.setVisibility(0);
                this.a.setText(b);
                break;
        }
        this.d.removeMessages(1);
        this.d.sendEmptyMessageDelayed(1, 10000L);
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

    private void a(Context context, TbImageView tbImageView, View view, ChatMessage chatMessage) {
        com.baidu.adp.widget.a.a aVar;
        String optString;
        if (chatMessage.getContent() != null && chatMessage.getContent().length() != 0 && tbImageView != null && view != null) {
            try {
                view.setVisibility(8);
                tbImageView.setOnClickListener(null);
                JSONObject jSONObject = new JSONArray(chatMessage.getContent()).getJSONObject(0);
                String a = com.baidu.tieba.im.d.j.a(jSONObject, true);
                if (a != null) {
                    tbImageView.setTag(a);
                    if (a.startsWith("http")) {
                        tbImageView.setEvent(new al(this, view));
                        tbImageView.a(a, 10, false);
                        aVar = null;
                    } else {
                        view.setVisibility(0);
                        try {
                            aVar = com.baidu.tbadk.imageManager.e.a().c(a);
                            try {
                                if (aVar == null) {
                                    Bitmap a2 = com.baidu.tbadk.core.util.d.a(com.baidu.tbadk.core.util.ar.a().a(com.baidu.adp.lib.util.b.a().a(a)), 10.0f, true);
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
                            }
                        } catch (Exception e2) {
                            aVar = null;
                        }
                    }
                    if (chatMessage.getWidth() < 1 && (optString = jSONObject.optString("big_size")) != null) {
                        String[] split = optString.split(",");
                        if (split.length > 0) {
                            chatMessage.setWidth(com.baidu.adp.lib.e.b.a(split[0], 0));
                        }
                        if (split.length > 1) {
                            chatMessage.setHeight(com.baidu.adp.lib.e.b.a(split[1], 0));
                        }
                    }
                    LocalViewSize.a();
                    LocalViewSize.ImageSize a3 = LocalViewSize.a().a(getMsgSPicMaxSize(), chatMessage.getHeight(), chatMessage.getWidth());
                    com.baidu.tbadk.core.util.a.a a4 = a(a3.width, a3.height, true);
                    a3.height = a4.c;
                    a3.width = a4.b;
                    ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                    layoutParams.height = a3.height;
                    layoutParams.width = a3.width;
                    tbImageView.setLayoutParams(layoutParams);
                    if (aVar != null) {
                        tbImageView.f();
                        aVar.a(tbImageView);
                    } else {
                        tbImageView.setImageDrawable(null);
                        tbImageView.setTag(a);
                    }
                    tbImageView.setOnClickListener(new am(this, chatMessage));
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private com.baidu.tbadk.core.util.a.a a(int i, int i2, boolean z) {
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
            return new com.baidu.tbadk.core.util.a.a(i6, i7, z2);
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
        return new com.baidu.tbadk.core.util.a.a(i6, i7, z2);
    }

    private LocalViewSize.ImageSize getMsgSPicMaxSize() {
        int i;
        int b = com.baidu.adp.lib.util.j.b(getContext());
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
        return this.D;
    }

    public void setHeaderBackground(Drawable drawable) {
        if (drawable != null) {
            this.e.setBackgroundDrawable(drawable);
        }
    }

    public void setUserCount(int i) {
        this.h.setText(String.valueOf(i));
    }

    public void setIsHost(boolean z) {
        this.B = z;
    }

    public void a(int i, boolean z) {
        this.C = i;
        if (this.B) {
            if (this.C == 1) {
                h();
                g();
            } else if (this.C == 3) {
                h();
                j();
            } else if (this.C == 5) {
                h();
                m();
            } else if (this.C == 6) {
                h();
                g();
            }
        } else if (this.C == 1) {
            h();
            l();
        } else if (this.C == 3) {
            h();
            j();
        } else if (this.C == 5) {
            h();
            m();
        } else if (this.C == 6) {
            h();
            k();
        }
    }

    private void g() {
        this.m.setBackgroundDrawable(this.f.getResources().getDrawable(com.baidu.tieba.t.icon_live_voice_selector));
        this.l.setVisibility(0);
        this.m.setVisibility(0);
    }

    private void h() {
        this.u.setVisibility(8);
        this.z.setVisibility(8);
        this.n.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.y.setVisibility(8);
        this.p.setVisibility(8);
        this.q.b();
    }

    private void i() {
        this.y.setVisibility(0);
        this.p.setVisibility(0);
        this.q.a();
    }

    private void j() {
        h();
        i();
    }

    private void k() {
        this.q.b();
        this.n.setText(this.f.getResources().getString(com.baidu.tieba.x.live_room_end));
        this.y.setVisibility(0);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
    }

    private void l() {
        h();
        this.n.setText(this.f.getResources().getString(com.baidu.tieba.x.live_room_not_start));
        if (this.B) {
            this.z.setVisibility(0);
            this.y.setVisibility(0);
            this.o.setVisibility(0);
        } else {
            this.y.setVisibility(0);
            this.n.setVisibility(0);
            this.o.setVisibility(0);
        }
        this.q.b();
    }

    private void m() {
        h();
        this.n.setText(this.f.getResources().getString(com.baidu.tieba.x.live_room_pause));
        if (this.B) {
            this.z.setVisibility(0);
            this.y.setVisibility(0);
            this.o.setVisibility(0);
        } else {
            this.y.setVisibility(0);
            this.n.setVisibility(0);
            this.o.setVisibility(0);
        }
        this.q.b();
    }

    public ImageView getmLiveRoomLike() {
        return this.t;
    }

    public ImageView getAnchorImg() {
        return this.m;
    }

    public View getLiveStopView() {
        return this.n;
    }

    public View getLiveStopHost() {
        return this.z;
    }

    public void setHeaderImage(String str) {
        this.y.a(str, 12, false);
    }

    public HeadImageView getHeaderImage() {
        return this.y;
    }

    public void a() {
        this.i.setVisibility(0);
        this.j.setVisibility(0);
    }

    public void b() {
        this.i.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void setRecordTime(CharSequence charSequence) {
        int measureText;
        if (charSequence != null) {
            TextPaint paint = this.j.getPaint();
            if (charSequence.length() != this.k) {
                if (charSequence.length() <= 5) {
                    measureText = (int) paint.measureText("00:00");
                } else {
                    measureText = (int) paint.measureText("00:00:00");
                }
                this.j.setWidth(measureText);
            }
            this.j.setText(charSequence);
        }
    }

    public void c() {
        int measureText;
        String string = this.f.getString(com.baidu.tieba.x.live_chat_room_default_time);
        TextPaint paint = this.j.getPaint();
        if (string.length() != this.k) {
            if (string.length() <= 5) {
                measureText = (int) paint.measureText("00:00");
            } else {
                measureText = (int) paint.measureText("00:00:00");
            }
            this.j.setWidth(measureText);
        }
        this.j.setText(string);
    }

    public ImageView getSettingButton() {
        return this.s;
    }

    public int getIsLike() {
        return this.A;
    }

    public void setData(int i) {
        this.A = i;
        if (this.A == 1) {
            this.x = false;
            f();
            return;
        }
        this.x = true;
        e();
    }

    public boolean d() {
        return this.x;
    }

    public void e() {
        this.t.setBackgroundDrawable(this.f.getResources().getDrawable(com.baidu.tieba.t.btn_live_no_praise_selector));
    }

    public void f() {
        this.t.setBackgroundDrawable(this.f.getResources().getDrawable(com.baidu.tieba.t.btn_live_praise_selector));
    }

    public void a(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.f, com.baidu.tieba.o.praise_animation_scale2));
            new Handler().postDelayed(new an(this), 200L);
        }
    }

    public void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.f, com.baidu.tieba.o.praise_animation_scale3));
            new Handler().postDelayed(new ao(this), 600L);
        }
    }

    public void a(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.f, com.baidu.tieba.o.praise_animation_scale1));
    }

    public void setNoteText(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.B) {
                this.r.setText(this.f.getString(com.baidu.tieba.x.live_group_note));
                return;
            } else {
                this.r.setText("");
                return;
            }
        }
        this.r.setText(String.format(this.f.getString(com.baidu.tieba.x.live_chat_room_note), str));
    }
}
