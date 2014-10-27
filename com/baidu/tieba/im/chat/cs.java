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
public class cs extends BaseAdapter {
    private Context mContext;
    private List<ChatMessage> mData = null;
    private Long aPr = 0L;
    private long aOZ = 0;
    private Long aPs = null;
    private Long aPt = null;
    private com.baidu.adp.lib.c.a aOK = null;
    private com.baidu.adp.lib.c.b aOL = null;
    private boolean mNeedShowName = true;
    private boolean aPu = false;

    public cs(Context context) {
        this.mContext = context;
    }

    public void cA(boolean z) {
        this.mNeedShowName = z;
    }

    public void cB(boolean z) {
        this.aPu = z;
    }

    public void JW() {
        this.aPr = Long.valueOf(System.currentTimeMillis() / 1000);
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.aOK = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.aOL = bVar;
    }

    public void setGid(long j) {
        this.aOZ = j;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        if (this.mData == null || (size = this.mData.size()) < 0) {
            return 0;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
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
        ChatMessage chatMessage = this.mData.get(i);
        if (chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        switch (itemViewType) {
            case 0:
                if (view == null) {
                    msgleftView2 = new MsgleftView(this.mContext);
                    view = msgleftView2.O();
                } else {
                    msgleftView2 = (MsgleftView) view.getTag();
                }
                msgleftView2.cA(this.mNeedShowName);
                msgleftView2.cB(this.aPu);
                chatMessage.getCacheData().setIs_left(1);
                byVar = null;
                cbVar = null;
                bzVar = null;
                msgleftView = msgleftView2;
                msgActivityView = null;
                break;
            case 1:
                if (view == null) {
                    msgrightView = new MsgrightView(this.mContext);
                    view = msgrightView.O();
                } else {
                    msgrightView = (MsgrightView) view.getTag();
                }
                msgrightView.cB(this.aPu);
                chatMessage.getCacheData().setIs_left(0);
                byVar = null;
                cbVar = null;
                bzVar = null;
                msgleftView = msgrightView;
                msgActivityView = null;
                break;
            case 2:
                if (view == null) {
                    bz bzVar2 = new bz(this.mContext);
                    view = bzVar2.O();
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
                    cb cbVar2 = new cb(this.mContext);
                    view = cbVar2.O();
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
                    by byVar2 = new by(this.mContext);
                    view = byVar2.O();
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
                    msgActivityView = new MsgActivityView(this.mContext);
                    view = msgActivityView.O();
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
                    MsgMultiImageTextView msgMultiImageTextView2 = new MsgMultiImageTextView(this.mContext);
                    view = msgMultiImageTextView2.O();
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
            msgleftView.a(this.aOK);
            msgleftView.setOnItemViewLongClickListener(this.aOL);
            msgleftView.setPosition(i);
            msgleftView.setGid(this.aOZ);
            msgleftView.I(this.aPr.longValue());
            if (i > 0) {
                msgleftView.H(this.mData.get(i - 1).getTime());
            } else {
                msgleftView.H(0L);
            }
            msgleftView.a(viewGroup, chatMessage);
            msgleftView.b(viewGroup, chatMessage);
        } else if (bzVar != null) {
            bzVar.setData(chatMessage);
        } else if (cbVar != null) {
            cbVar.setData(chatMessage);
        } else if (byVar != null) {
            byVar.setData(chatMessage);
        } else if (msgActivityView != null) {
            msgActivityView.setPosition(i);
            msgActivityView.setData(chatMessage);
            msgActivityView.a(this.aOK);
            msgActivityView.setOnItemViewLongClickListener(this.aOL);
            msgActivityView.I(this.aPr.longValue());
            if (i > 0) {
                msgActivityView.H(this.mData.get(i - 1).getTime());
            } else {
                msgActivityView.H(0L);
            }
        } else if (msgMultiImageTextView != null) {
            msgMultiImageTextView.setOnItemViewLongClickListener(this.aOL);
            msgMultiImageTextView.setPosition(i);
            msgMultiImageTextView.I(this.aPr.longValue());
            if (i > 0) {
                msgMultiImageTextView.H(this.mData.get(i - 1).getTime());
            } else {
                msgMultiImageTextView.H(0L);
            }
            msgMultiImageTextView.a(chatMessage, viewGroup);
        }
        ((MsglistActivity) this.mContext).getLayoutMode().L(false);
        ((MsglistActivity) this.mContext).getLayoutMode().h(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        try {
            ChatMessage chatMessage = this.mData.get(i);
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

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void k(ChatMessage chatMessage) {
        notifyDataSetChanged();
    }

    public void setData(List<ChatMessage> list) {
        this.mData = list;
        int size = this.mData.size();
        if (size > 0) {
            this.aPt = Long.valueOf(this.mData.get(size - 1).getMsgId());
            this.aPs = Long.valueOf(this.mData.get(0).getMsgId());
            return;
        }
        this.aPt = null;
        this.aPs = null;
    }
}
