package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.chat.df;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    Context a;
    private View.OnClickListener b = new ae(this);
    private List<ba> c;

    public ad(Context context) {
        this.a = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null || i >= getCount()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.c == null || i >= this.c.size()) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.c == null || i >= this.c.size()) {
            return 0;
        }
        switch (this.c.get(i).b) {
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
        return a(i, view, viewGroup);
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        ba baVar = (ba) getItem(i);
        if (baVar != null && baVar.c != null) {
            switch (getItemViewType(i)) {
                case 0:
                    View aVar = view == null ? new a(this.a) : view;
                    a aVar2 = (a) aVar;
                    aVar2.setClickable(false);
                    aVar2.setTime(baVar.a);
                    ChatMessage chatMessage = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$2
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage.setContent(baVar.c);
                    chatMessage.setMsgType(baVar.b);
                    df.a(this.a, aVar2.getRichTextView(), chatMessage, "official_history_adapter");
                    return aVar;
                case 1:
                    View aVar3 = view == null ? new a(this.a) : view;
                    a aVar4 = (a) aVar3;
                    aVar4.setClickable(false);
                    aVar4.setTime(baVar.a);
                    ChatMessage chatMessage2 = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$3
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage2.setContent("[" + baVar.c + "]");
                    chatMessage2.setMsgType(baVar.b);
                    df.a(this.a, aVar3, aVar4.getImageView(), chatMessage2, 0L, "official_history_adapter");
                    aVar4.getImageView().setTag(Integer.valueOf(i));
                    aVar4.getImageView().setOnClickListener(this.b);
                    return aVar3;
                case 2:
                    View aVar5 = view == null ? new a(this.a) : view;
                    MultiContentView multiContentView = new MultiContentView(this.a);
                    multiContentView.setTime(baVar.a);
                    multiContentView.a(o.a(baVar.c, ""), viewGroup);
                    ((a) aVar5).a(multiContentView);
                    return aVar5;
                default:
                    return view;
            }
        }
        return view;
    }

    public void a(List<ba> list) {
        this.c = list;
        notifyDataSetChanged();
    }
}
