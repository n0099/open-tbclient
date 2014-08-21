package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class cr extends BaseAdapter {
    private Context a;
    private List<ChatMessage> b = null;
    private Long c = 0L;
    private long d = 0;
    private Long e = null;
    private Long f = null;
    private com.baidu.adp.lib.b.a g = null;
    private com.baidu.adp.lib.b.b h = null;
    private boolean i = true;

    public cr(Context context) {
        this.a = context;
    }

    public void a(boolean z) {
        this.i = z;
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
        by byVar;
        cb cbVar;
        bz bzVar;
        MsgleftView msgleftView;
        MsgActivityView msgActivityView;
        MsgrightView msgrightView;
        MsgleftView msgleftView2;
        MsgMultiImageTextView msgMultiImageTextView = null;
        int itemViewType = getItemViewType(i);
        ChatMessage chatMessage = this.b.get(i);
        if (chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        switch (itemViewType) {
            case 0:
                if (view == null) {
                    msgleftView2 = new MsgleftView(this.a);
                    view = msgleftView2.a();
                } else {
                    msgleftView2 = (MsgleftView) view.getTag();
                }
                msgleftView2.a(this.i);
                chatMessage.getCacheData().setIs_left(1);
                byVar = null;
                cbVar = null;
                bzVar = null;
                msgleftView = msgleftView2;
                msgActivityView = null;
                break;
            case 1:
                if (view == null) {
                    msgrightView = new MsgrightView(this.a);
                    view = msgrightView.a();
                } else {
                    msgrightView = (MsgrightView) view.getTag();
                }
                chatMessage.getCacheData().setIs_left(0);
                byVar = null;
                cbVar = null;
                bzVar = null;
                msgleftView = msgrightView;
                msgActivityView = null;
                break;
            case 2:
                if (view == null) {
                    bz bzVar2 = new bz(this.a);
                    view = bzVar2.a();
                    byVar = null;
                    cbVar = null;
                    bzVar = bzVar2;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    byVar = null;
                    cbVar = null;
                    bzVar = (bz) view.getTag();
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 3:
                if (view == null) {
                    cb cbVar2 = new cb(this.a);
                    view = cbVar2.a();
                    byVar = null;
                    cbVar = cbVar2;
                    bzVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    byVar = null;
                    cbVar = (cb) view.getTag();
                    bzVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 4:
                if (view == null) {
                    by byVar2 = new by(this.a);
                    view = byVar2.a();
                    byVar = byVar2;
                    cbVar = null;
                    bzVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                } else {
                    byVar = (by) view.getTag();
                    cbVar = null;
                    bzVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    break;
                }
            case 5:
                if (view == null) {
                    msgActivityView = new MsgActivityView(this.a);
                    view = msgActivityView.a();
                    byVar = null;
                    cbVar = null;
                    bzVar = null;
                    msgleftView = null;
                    break;
                } else {
                    msgActivityView = (MsgActivityView) view.getTag();
                    byVar = null;
                    cbVar = null;
                    bzVar = null;
                    msgleftView = null;
                    break;
                }
            case 6:
                if (view == null) {
                    MsgMultiImageTextView msgMultiImageTextView2 = new MsgMultiImageTextView(this.a);
                    view = msgMultiImageTextView2.a();
                    byVar = null;
                    cbVar = null;
                    bzVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    msgMultiImageTextView = msgMultiImageTextView2;
                    break;
                } else {
                    byVar = null;
                    cbVar = null;
                    bzVar = null;
                    msgleftView = null;
                    msgActivityView = null;
                    msgMultiImageTextView = (MsgMultiImageTextView) view.getTag();
                    break;
                }
            default:
                msgActivityView = null;
                byVar = null;
                cbVar = null;
                bzVar = null;
                msgleftView = null;
                break;
        }
        if (msgleftView != null) {
            msgleftView.a(this.g);
            msgleftView.a(this.h);
            msgleftView.b(i);
            msgleftView.a(this.d);
            msgleftView.c(this.c.longValue());
            if (i > 0) {
                msgleftView.b(this.b.get(i - 1).getTime());
            } else {
                msgleftView.b(0L);
            }
            msgleftView.a(viewGroup, chatMessage);
            msgleftView.b(viewGroup, chatMessage);
        } else if (bzVar != null) {
            bzVar.a(chatMessage);
        } else if (cbVar != null) {
            cbVar.a(chatMessage);
        } else if (byVar != null) {
            byVar.a(chatMessage);
        } else if (msgActivityView != null) {
            msgActivityView.b(i);
            msgActivityView.a(chatMessage);
            msgActivityView.a(this.g);
            msgActivityView.a(this.h);
            msgActivityView.c(this.c.longValue());
            if (i > 0) {
                msgActivityView.b(this.b.get(i - 1).getTime());
            } else {
                msgActivityView.b(0L);
            }
        } else if (msgMultiImageTextView != null) {
            msgMultiImageTextView.a(this.h);
            msgMultiImageTextView.b(i);
            msgMultiImageTextView.c(this.c.longValue());
            if (i > 0) {
                msgMultiImageTextView.b(this.b.get(i - 1).getTime());
            } else {
                msgMultiImageTextView.b(0L);
            }
            msgMultiImageTextView.a(chatMessage, viewGroup);
        }
        ((MsglistActivity) this.a).getLayoutMode().a(false);
        ((MsglistActivity) this.a).getLayoutMode().a(view);
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
                if (chatMessage.getMsgType() == 12) {
                    return 3;
                }
                if (chatMessage.getMsgType() == 13) {
                    return 4;
                }
                if (chatMessage.getMsgType() == 6) {
                    return 5;
                }
                if (chatMessage.getMsgType() == 7) {
                    return 6;
                }
                if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null) {
                    return chatMessage.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount()) ? 1 : 0;
                }
            }
        } catch (Exception e) {
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 7;
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
