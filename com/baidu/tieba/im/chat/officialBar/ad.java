package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.chat.dm;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    private List<az> Wx;
    private View.OnClickListener aRo = new ae(this);
    Context mContext;

    public ad(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wx == null) {
            return 0;
        }
        return this.Wx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Wx == null || i >= getCount()) {
            return null;
        }
        return this.Wx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Wx == null || i >= this.Wx.size()) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.Wx == null || i >= this.Wx.size()) {
            return 0;
        }
        switch (this.Wx.get(i).type) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 7:
                return 2;
            default:
                return 0;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return d(i, view, viewGroup);
    }

    private View d(int i, View view, ViewGroup viewGroup) {
        az azVar = (az) getItem(i);
        if (azVar != null && azVar.content != null) {
            switch (getItemViewType(i)) {
                case 0:
                    View aVar = view == null ? new a(this.mContext) : view;
                    a aVar2 = (a) aVar;
                    aVar2.setClickable(false);
                    aVar2.setTime(azVar.time);
                    ChatMessage chatMessage = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$2
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage.setContent(azVar.content);
                    chatMessage.setMsgType(azVar.type);
                    dm.a(this.mContext, aVar2.getRichTextView(), chatMessage, "official_history_adapter");
                    return aVar;
                case 1:
                    View aVar3 = view == null ? new a(this.mContext) : view;
                    a aVar4 = (a) aVar3;
                    aVar4.setClickable(false);
                    aVar4.setTime(azVar.time);
                    ChatMessage chatMessage2 = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$3
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage2.setContent("[" + azVar.content + "]");
                    chatMessage2.setMsgType(azVar.type);
                    dm.a(this.mContext, aVar3, aVar4.getImageView(), chatMessage2, 0L, "official_history_adapter");
                    aVar4.getImageView().setTag(Integer.valueOf(i));
                    aVar4.getImageView().setOnClickListener(this.aRo);
                    return aVar3;
                case 2:
                    View aVar5 = view == null ? new a(this.mContext) : view;
                    MultiContentView multiContentView = new MultiContentView(this.mContext);
                    multiContentView.setTime(azVar.time);
                    multiContentView.a(o.ak(azVar.content, ""), viewGroup);
                    ((a) aVar5).J(multiContentView);
                    return aVar5;
                default:
                    return view;
            }
        }
        return view;
    }

    public void setData(List<az> list) {
        this.Wx = list;
        notifyDataSetChanged();
    }
}
