package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    BaseActivity bSF;
    private View.OnClickListener eyl = new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue >= 0 && intValue < h.this.mList.size()) {
                ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) h.this.mList.get(intValue);
                String I = com.baidu.tieba.im.util.e.I("[" + aVar.content + "]", true);
                if (I != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialHistoryImageActivityConfig(h.this.mContext, I, String.valueOf(aVar.id))));
                }
            }
        }
    };
    Context mContext;
    private List<ResponseHistoryMessage.a> mList;

    public h(BaseActivity baseActivity, Context context) {
        this.mContext = context;
        this.bSF = baseActivity;
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
                    View aVar2 = view == null ? new a(this.mContext) : view;
                    a aVar3 = (a) aVar2;
                    aVar3.setClickable(false);
                    aVar3.setTime(aVar.time);
                    ChatMessage chatMessage = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$2
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage.setContent(aVar.content);
                    chatMessage.setMsgType(aVar.type);
                    com.baidu.tieba.im.chat.j.a(this.mContext, aVar3.getRichTextView(), chatMessage, "official_history_adapter", 0);
                    return aVar2;
                case 1:
                    View aVar4 = view == null ? new a(this.mContext) : view;
                    a aVar5 = (a) aVar4;
                    aVar5.setClickable(false);
                    aVar5.setTime(aVar.time);
                    ChatMessage chatMessage2 = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$3
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage2.setContent("[" + aVar.content + "]");
                    chatMessage2.setMsgType(aVar.type);
                    com.baidu.tieba.im.chat.j.a(this.mContext, aVar4, aVar5.getImageView(), chatMessage2, 0L, "official_history_adapter");
                    aVar5.getImageView().setTag(Integer.valueOf(i));
                    aVar5.getImageView().setOnClickListener(this.eyl);
                    return aVar4;
                case 2:
                    View aVar6 = view == null ? new a(this.mContext) : view;
                    MultiContentView multiContentView = new MultiContentView(this.mContext);
                    multiContentView.setNeedNightMode(true);
                    multiContentView.setTime(aVar.time);
                    multiContentView.a(this.bSF.getPageContext(), g.a(aVar.content, "", 0L), viewGroup);
                    ((a) aVar6).bZ(multiContentView);
                    return aVar6;
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
