package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.b.b.e.p.l;
import d.b.i0.d1.f.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MsgleftView extends e {
    public static final String B = "com.baidu.tieba.im.chat.MsgleftView";
    public View.OnLongClickListener A;
    public HeadImageView t;
    public TextView u;
    public ViewGroup v;
    public UserIconBox w;
    public ImageView x;
    public final TouchType y;
    public TbPageContext<MsglistActivity<?>> z;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public long f17764e = 0;

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f17764e = System.currentTimeMillis();
            } else if (motionEvent.getAction() == 1) {
                if (System.currentTimeMillis() - this.f17764e > 200) {
                    if (MsgleftView.this.y.get()) {
                        MsgleftView msgleftView = MsgleftView.this;
                        msgleftView.f53649c.onItemViewLongClick(view, 2, msgleftView.f53652f, 0L);
                        MsgleftView.this.y.set(false);
                    }
                } else {
                    MsgleftView msgleftView2 = MsgleftView.this;
                    msgleftView2.f53648b.onItemViewClick(view, 2, msgleftView2.f53652f, 0L);
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            MsgleftView.this.y.set(true);
            return true;
        }
    }

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.y = new TouchType();
        this.A = new b();
        this.z = tbPageContext;
        h();
        this.x = (ImageView) d(R.id.iv_live_group_host);
        this.u = (TextView) d(R.id.tex_msgitem_name);
        this.v = (ViewGroup) d(R.id.box_msgitem_bubble);
        HeadImageView headImageView = (HeadImageView) d(R.id.img_msgitem_photo);
        this.t = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.t.setDrawerType(1);
        this.t.setRadius(l.e(this.z.getContext(), 4.0f));
        this.t.setPlaceHolder(1);
        this.w = (UserIconBox) d(R.id.user_tshow_icon_box);
        this.t.setLongClickable(true);
        this.t.setOnLongClickListener(this.A);
        this.t.setOnTouchListener(new a());
        this.m.setIsLeft(true);
        this.n.setIsLeft(true);
    }

    public final void I(ChatMessage chatMessage) {
        String o = d.b.h0.r.d0.b.i().o("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(o)) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
    }

    public void J() {
        if (this.q) {
            this.u.setVisibility(0);
            this.w.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.v.setLayoutParams(marginLayoutParams);
        this.w.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(ChatMessage chatMessage) {
        int i;
        if (this.q) {
            if (chatMessage != null && chatMessage.getUserInfo() != null) {
                int sex = chatMessage.getUserInfo().getSex();
                if (sex == 1) {
                    i = R.drawable.icon_pop_qz_boy;
                } else if (sex == 2) {
                    i = R.drawable.icon_pop_qz_girl;
                }
                if (!this.q) {
                    i = 0;
                }
                this.u.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            }
            i = 0;
            if (!this.q) {
            }
            this.u.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0150 A[Catch: Exception -> 0x0156, TRY_LEAVE, TryCatch #0 {Exception -> 0x0156, blocks: (B:15:0x009d, B:17:0x00a3, B:18:0x00c5, B:20:0x00d1, B:23:0x00dc, B:25:0x00eb, B:37:0x0134, B:38:0x013a, B:39:0x0140, B:40:0x0144, B:41:0x014a, B:42:0x0150, B:24:0x00e4), top: B:47:0x009d }] */
    @Override // d.b.i0.d1.f.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(View view, ChatMessage chatMessage) {
        int msgType;
        super.l(view, chatMessage);
        String str = null;
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        J();
        UserIconBox userIconBox = this.w;
        if (userIconBox != null && this.q) {
            userIconBox.setVisibility(0);
            this.w.setAutoChangedStyle(false);
            Resources resources = this.z.getResources();
            this.w.h(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.u.setText((CharSequence) null);
            this.i.setVisibility(0);
            this.i.setText(null);
            m(8);
            this.p.getImage().setTag(null);
            this.j.setVisibility(8);
            this.j.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.x.setVisibility(8);
            return;
        }
        z(chatMessage);
        K(chatMessage);
        this.u.setText("");
        I(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.u.setText(chatMessage.getUserInfo().getName_show());
                this.t.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() != 1 && chatMessage.getUserInfo().getUserType() != 3) {
                this.t.W(str, 12, false);
                this.t.setContentDescription(chatMessage.getUserInfo().getName_show());
                this.i.setVisibility(8);
                m(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                this.o.setVisibility(8);
                msgType = chatMessage.getMsgType();
                if (msgType != 1) {
                    E(chatMessage, B);
                    return;
                } else if (msgType == 2) {
                    B(view, chatMessage, B);
                    return;
                } else if (msgType == 3) {
                    F(chatMessage, B);
                    return;
                } else if (msgType == 4) {
                    x(chatMessage, false);
                    return;
                } else if (msgType == 5) {
                    A(view, chatMessage, B);
                    return;
                } else if (msgType != 9) {
                    return;
                } else {
                    y(view, chatMessage, B);
                    return;
                }
            }
            this.t.W(str, 10, false);
            this.t.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.i.setVisibility(8);
            m(8);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            msgType = chatMessage.getMsgType();
            if (msgType != 1) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
