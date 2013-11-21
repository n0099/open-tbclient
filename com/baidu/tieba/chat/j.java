package com.baidu.tieba.chat;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.chat.ChatData;
import com.baidu.tieba.data.chat.ChatMessageData;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ChatActivity f1143a;
    private ChatData b = null;
    private int c = 0;
    private com.baidu.tieba.util.i d;

    public j(ChatActivity chatActivity) {
        this.f1143a = null;
        this.d = null;
        this.f1143a = chatActivity;
        this.d = new com.baidu.tieba.util.i(chatActivity);
    }

    public com.baidu.tieba.util.i a() {
        return this.d;
    }

    public void a(ChatData chatData) {
        this.b = chatData;
    }

    public void a(int i) {
        this.c = i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = b(itemViewType);
        }
        a((l) view.getTag(), (ChatMessageData) getItem(i), i, itemViewType);
        return view;
    }

    private View b(int i) {
        View inflate;
        l lVar = new l(this);
        LayoutInflater from = LayoutInflater.from(this.f1143a);
        if (i == 0) {
            inflate = from.inflate(R.layout.chat_item_opposite, (ViewGroup) null);
        } else {
            inflate = from.inflate(R.layout.chat_item_own, (ViewGroup) null);
        }
        lVar.f1144a = (HeadImageView) inflate.findViewById(R.id.photo);
        lVar.b = (TbRichTextView) inflate.findViewById(R.id.text);
        lVar.c = (TextView) inflate.findViewById(R.id.time);
        lVar.f1144a.setOnClickListener(this.f1143a);
        lVar.b.setOnLongClickListener(this.f1143a);
        inflate.setTag(lVar);
        return inflate;
    }

    private void a(l lVar, ChatMessageData chatMessageData, int i, int i2) {
        long serverTime;
        String userPortrait;
        if (i <= 0) {
            serverTime = chatMessageData.getServerTime();
        } else {
            ChatMessageData chatMessageData2 = (ChatMessageData) getItem(i - 1);
            serverTime = (chatMessageData2 == null || chatMessageData.getServerTime() - chatMessageData2.getServerTime() <= 60) ? 0L : chatMessageData.getServerTime();
        }
        if (serverTime > 0) {
            lVar.c.setVisibility(0);
            if (new Date().getDay() != new Date(serverTime * 1000).getDay()) {
                lVar.c.setText(be.a(new Date(serverTime * 1000)));
            } else {
                lVar.c.setText(be.b(new Date(serverTime * 1000)));
            }
        } else {
            lVar.c.setVisibility(8);
        }
        lVar.b.setVoiceViewRes(R.layout.voice_play_btn);
        lVar.b.setText(chatMessageData.getRichText(this.f1143a));
        lVar.b.setTag(chatMessageData);
        if (chatMessageData.getStatus() == 1) {
            lVar.f1144a.setUserId(chatMessageData.getFriendId());
            userPortrait = this.b.getFriendPortrait();
        } else {
            lVar.f1144a.setUserId(chatMessageData.getOwnerId());
            userPortrait = this.b.getUserPortrait();
        }
        com.baidu.adp.widget.ImageView.e c = this.d.c(userPortrait);
        if (c != null) {
            c.a(lVar.f1144a);
        } else {
            lVar.f1144a.setTag(userPortrait);
            lVar.f1144a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.util.m.a((int) R.drawable.photo)));
        }
        if (this.c == 1) {
            if (i2 == 0) {
                lVar.b.setBackgroundResource(R.drawable.bj_bubble_chat_friends_1);
            } else {
                lVar.b.setBackgroundResource(R.drawable.bj_bubble_chat_me_1);
            }
            lVar.b.setTextColor(this.f1143a.getResources().getColor(R.color.gray_night_4));
            lVar.c.setTextColor(this.f1143a.getResources().getColor(R.color.gray_night_2));
            return;
        }
        if (i2 == 0) {
            lVar.b.setBackgroundResource(R.drawable.bj_bubble_chat_friends);
        } else {
            lVar.b.setBackgroundResource(R.drawable.bj_bubble_chat_me);
        }
        lVar.b.setTextColor(this.f1143a.getResources().getColor(R.color.black));
        lVar.c.setTextColor(this.f1143a.getResources().getColor(R.color.white));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.getChatList().size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < 0 || i >= this.b.getChatList().size()) {
            return 0;
        }
        return this.b.getChatList().get(i).getStatus() == 1 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null) {
            return null;
        }
        return this.b.getMsg(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
