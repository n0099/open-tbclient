package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import com.baidu.tieba.im.chat.j;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    BaseActivity bwX;
    private View.OnClickListener eBX = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue >= 0 && intValue < d.this.mList.size()) {
                ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) d.this.mList.get(intValue);
                String N = com.baidu.tieba.im.util.e.N("[" + aVar.content + "]", true);
                if (N != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialHistoryImageActivityConfig(d.this.mContext, N, String.valueOf(aVar.id))));
                }
            }
        }
    };
    Context mContext;
    private List<ResponseHistoryMessage.a> mList;

    public d(BaseActivity baseActivity, Context context) {
        this.mContext = context;
        this.bwX = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mList == null || i >= this.mList.size()) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.mList == null || i >= this.mList.size()) {
            return 0;
        }
        switch (this.mList.get(i).type) {
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
        ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) getItem(i);
        if (aVar != null && aVar.content != null) {
            switch (getItemViewType(i)) {
                case 0:
                    View historyItemView = view == null ? new HistoryItemView(this.mContext) : view;
                    HistoryItemView historyItemView2 = (HistoryItemView) historyItemView;
                    historyItemView2.setClickable(false);
                    historyItemView2.setTime(aVar.time);
                    ChatMessage chatMessage = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$2
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage.setContent(aVar.content);
                    chatMessage.setMsgType(aVar.type);
                    j.a(this.mContext, historyItemView2.getRichTextView(), chatMessage, "official_history_adapter", 0);
                    return historyItemView;
                case 1:
                    View historyItemView3 = view == null ? new HistoryItemView(this.mContext) : view;
                    HistoryItemView historyItemView4 = (HistoryItemView) historyItemView3;
                    historyItemView4.setClickable(false);
                    historyItemView4.setTime(aVar.time);
                    ChatMessage chatMessage2 = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$3
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage2.setContent("[" + aVar.content + "]");
                    chatMessage2.setMsgType(aVar.type);
                    j.a(this.mContext, historyItemView3, historyItemView4.getImageView(), chatMessage2, 0L, "official_history_adapter");
                    historyItemView4.getImageView().setTag(Integer.valueOf(i));
                    historyItemView4.getImageView().setOnClickListener(this.eBX);
                    return historyItemView3;
                case 2:
                    View historyItemView5 = view == null ? new HistoryItemView(this.mContext) : view;
                    MultiContentView multiContentView = new MultiContentView(this.mContext);
                    multiContentView.setNeedNightMode(true);
                    multiContentView.setTime(aVar.time);
                    multiContentView.setData(this.bwX.getPageContext(), c.a(aVar.content, "", 0L), viewGroup);
                    ((HistoryItemView) historyItemView5).ba(multiContentView);
                    return historyItemView5;
                default:
                    return view;
            }
        }
        return view;
    }

    public void setData(List<ResponseHistoryMessage.a> list) {
        this.mList = list;
        notifyDataSetChanged();
    }
}
