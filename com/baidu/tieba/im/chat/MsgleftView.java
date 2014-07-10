package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.live.room.LiveRoomChatActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MsgleftView extends cd {
    private static final String q = MsgleftView.class.getName();
    View.OnLongClickListener p;
    private HeadImageView r;
    private TextView s;
    private ImageView t;
    private ViewGroup u;
    private UserIconBox v;
    private ImageView w;
    private final TouchType x;
    private Context y;

    public MsgleftView(Context context) {
        super(context, com.baidu.tieba.w.msg_msgleft_view);
        this.x = new TouchType();
        this.p = new cm(this);
        this.y = context;
        b();
        this.w = (ImageView) a(com.baidu.tieba.v.iv_live_group_host);
        this.s = (TextView) a(com.baidu.tieba.v.tex_msgitem_name);
        this.t = (ImageView) a(com.baidu.tieba.v.iv_sex);
        this.u = (ViewGroup) a(com.baidu.tieba.v.box_msgitem_bubble);
        this.r = (HeadImageView) a(com.baidu.tieba.v.img_msgitem_photo);
        this.r.setAutoChangeStyle(false);
        this.r.setDrawerType(1);
        this.r.setRadius(com.baidu.adp.lib.util.j.a(this.y, 4.0f));
        this.v = (UserIconBox) a(com.baidu.tieba.v.user_tshow_icon_box);
        this.r.setOnClickListener(new cn(this));
        this.r.setLongClickable(true);
        this.r.setOnLongClickListener(this.p);
        this.r.setOnTouchListener(new co(this));
    }

    @Override // com.baidu.tieba.im.chat.cd
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        LinkedList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        c();
        if (this.v != null && this.o) {
            this.v.setVisibility(0);
            this.v.a(tShowInfo, 2, this.y.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.y.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.y.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.s.setText((CharSequence) null);
            this.i.setVisibility(0);
            this.i.setText(null);
            c(8);
            this.j.setTag(null);
            this.k.setVisibility(8);
            this.k.setTag(null);
            this.m.setVisibility(8);
            this.m.setTag(null);
            this.n.setVisibility(8);
            this.w.setVisibility(8);
            return;
        }
        b(chatMessage);
        c(chatMessage);
        this.s.setText("");
        a(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.s.setText(chatMessage.getUserInfo().getUserName());
                this.r.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1) {
                this.r.a(str, 10, false);
            } else {
                this.r.a(str, 12, false);
            }
            this.i.setVisibility(8);
            c(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, q);
                    return;
                case 2:
                    a(view, chatMessage, q);
                    return;
                case 3:
                    b(chatMessage, q);
                    return;
                case 4:
                    a(chatMessage, false);
                    return;
                case 5:
                    b(view, chatMessage, q);
                    return;
                case 6:
                case 7:
                case 8:
                default:
                    return;
                case 9:
                    c(view, chatMessage, q);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(ChatMessage chatMessage) {
        if (this.y instanceof LiveRoomChatActivity) {
            LiveRoomChatActivity liveRoomChatActivity = (LiveRoomChatActivity) this.y;
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(liveRoomChatActivity.a)) {
                this.w.setVisibility(0);
                return;
            } else {
                this.w.setVisibility(8);
                return;
            }
        }
        this.w.setVisibility(8);
    }

    private void c(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.o) {
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.t.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.t.setImageResource(com.baidu.tieba.u.icon_pop_qz_boy);
                this.t.setVisibility(0);
            } else if (sex == 2) {
                this.t.setImageResource(com.baidu.tieba.u.icon_pop_qz_girl);
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
        }
    }

    public void c() {
        if (this.o) {
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.v.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
        this.s.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.u.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.u.setLayoutParams(marginLayoutParams);
        this.v.setVisibility(8);
    }
}
