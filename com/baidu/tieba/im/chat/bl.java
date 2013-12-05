package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class bl extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1570a;
    private List<ChatMessage> b = null;
    private Long c = 0L;
    private long d = 0;
    private Long e = null;
    private Long f = null;
    private com.baidu.adp.lib.b.a g = null;
    private com.baidu.adp.lib.b.b h = null;
    private com.baidu.tieba.util.i i;

    public bl(Context context) {
        this.i = null;
        this.f1570a = context;
        this.i = new com.baidu.tieba.util.i(context);
    }

    public void a() {
        this.c = Long.valueOf(System.currentTimeMillis() / 1000);
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        this.g = aVar;
    }

    public void a(com.baidu.adp.lib.b.b bVar) {
        this.h = bVar;
    }

    public void a(long j) {
        this.d = j;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        if (this.b == null || (size = this.b.size()) < 0) {
            return 0;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        am amVar;
        MsgrightView msgrightView;
        MsgleftView msgleftView;
        MsgleftView msgleftView2 = null;
        int itemViewType = getItemViewType(i);
        ChatMessage chatMessage = this.b.get(i);
        if (chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        switch (itemViewType) {
            case 0:
                if (view == null) {
                    msgleftView = new MsgleftView(this.f1570a);
                    view = msgleftView.a();
                } else {
                    msgleftView = (MsgleftView) view.getTag();
                }
                chatMessage.getCacheData().setIs_left(1);
                msgleftView.a(this.i);
                msgleftView2 = msgleftView;
                amVar = null;
                break;
            case 1:
                if (view == null) {
                    msgrightView = new MsgrightView(this.f1570a);
                    view = msgrightView.a();
                } else {
                    msgrightView = (MsgrightView) view.getTag();
                }
                msgrightView.a(this.i);
                chatMessage.getCacheData().setIs_left(0);
                msgleftView2 = msgrightView;
                amVar = null;
                break;
            case 2:
                if (view == null) {
                    amVar = new am(this.f1570a);
                    view = amVar.a();
                    break;
                } else {
                    amVar = (am) view.getTag();
                    break;
                }
            default:
                com.baidu.adp.lib.h.e.b(getClass().getName(), "getView", "view type error");
                amVar = null;
                break;
        }
        if (msgleftView2 != null) {
            msgleftView2.a(this.g);
            msgleftView2.a(this.h);
            msgleftView2.b(i);
            msgleftView2.a(this.d);
            msgleftView2.c(this.c.longValue());
            if (i > 0) {
                msgleftView2.b(this.b.get(i - 1).getTime());
            } else {
                msgleftView2.b(0L);
            }
            msgleftView2.a(viewGroup, chatMessage);
            msgleftView2.b(viewGroup, chatMessage);
        } else if (amVar != null) {
            amVar.a(chatMessage);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        try {
            ChatMessage chatMessage = this.b.get(i);
            if (chatMessage != null) {
                if (chatMessage.getMsgType() == 11) {
                    return 2;
                }
                if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getId() != null) {
                    return chatMessage.getUserInfo().getId().equals(TiebaApplication.B()) ? 1 : 0;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(getClass().getName(), "getItemViewType", e.getMessage());
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public List<ChatMessage> b() {
        return this.b;
    }

    public void a(ChatMessage chatMessage) {
        notifyDataSetChanged();
    }

    public void a(List<ChatMessage> list) {
        this.b = list;
        int size = this.b.size();
        if (size > 0) {
            this.f = Long.valueOf(this.b.get(size - 1).getMsgId());
            this.e = Long.valueOf(this.b.get(0).getMsgId());
            return;
        }
        this.f = null;
        this.e = null;
    }
}
