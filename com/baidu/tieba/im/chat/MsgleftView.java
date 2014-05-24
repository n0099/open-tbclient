package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.live.room.LiveRoomChatActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.view.HeadImageShaderView;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MsgleftView extends cc {
    private static final String p = MsgleftView.class.getName();
    View.OnLongClickListener o;
    private HeadImageShaderView q;
    private TextView r;
    private ImageView s;
    private ViewGroup t;
    private UserIconBox u;
    private ImageView v;
    private final TouchType w;
    private Context x;

    public MsgleftView(Context context) {
        super(context, com.baidu.tieba.w.msg_msgleft_view);
        this.w = new TouchType();
        this.o = new cj(this);
        this.x = context;
        b();
        this.v = (ImageView) a(com.baidu.tieba.v.iv_live_group_host);
        this.r = (TextView) a(com.baidu.tieba.v.tex_msgitem_name);
        this.s = (ImageView) a(com.baidu.tieba.v.iv_sex);
        this.t = (ViewGroup) a(com.baidu.tieba.v.box_msgitem_bubble);
        this.q = (HeadImageShaderView) a(com.baidu.tieba.v.img_msgitem_photo);
        this.q.setAutoChangeStyle(false);
        this.u = (UserIconBox) a(com.baidu.tieba.v.user_tshow_icon_box);
        this.q.setOnClickListener(new ck(this));
        this.q.setLongClickable(true);
        this.q.setOnLongClickListener(this.o);
        this.q.setOnTouchListener(new cl(this));
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        LinkedList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        c();
        if (this.u != null && this.n) {
            this.u.setVisibility(0);
            this.u.a(tShowInfo, 2, this.x.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.x.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.x.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.r.setText((CharSequence) null);
            this.i.setVisibility(0);
            this.i.setText(null);
            c(8);
            this.j.setTag(null);
            this.k.setVisibility(8);
            this.k.setTag(null);
            this.m.setVisibility(8);
            this.m.setTag(null);
            this.v.setVisibility(8);
            return;
        }
        b(chatMessage);
        c(chatMessage);
        this.r.setText("");
        a(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.r.setText(chatMessage.getUserInfo().getUserName());
                this.q.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1) {
                this.q.getHeadImageView().a(str, 10, false);
            } else {
                this.q.getHeadImageView().a(str, 12, false);
            }
            this.i.setVisibility(8);
            c(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, p);
                    return;
                case 2:
                    a(view, chatMessage, p);
                    return;
                case 3:
                    b(chatMessage, p);
                    return;
                case 4:
                    a(chatMessage, false);
                    return;
                case 5:
                    b(view, chatMessage, p);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            BdLog.e("MsgleftView", "setData", "error = " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void a(ChatMessage chatMessage) {
        if (this.x instanceof LiveRoomChatActivity) {
            LiveRoomChatActivity liveRoomChatActivity = (LiveRoomChatActivity) this.x;
            if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(liveRoomChatActivity.m)) {
                this.v.setVisibility(0);
                return;
            } else {
                this.v.setVisibility(8);
                return;
            }
        }
        this.v.setVisibility(8);
    }

    private void c(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.n) {
                this.s.setVisibility(8);
                return;
            }
            this.s.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.s.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.s.setImageResource(com.baidu.tieba.u.icon_pop_qz_boy);
                this.s.setVisibility(0);
            } else if (sex == 2) {
                this.s.setImageResource(com.baidu.tieba.u.icon_pop_qz_girl);
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
        }
    }

    public void c() {
        if (this.n) {
            this.r.setVisibility(0);
            this.s.setVisibility(0);
            this.u.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
        this.r.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.t.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.t.setLayoutParams(marginLayoutParams);
        this.u.setVisibility(8);
    }
}
