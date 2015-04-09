package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.chat.cg;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends BaseAdapter {
    private View.OnClickListener aZx = new af(this);
    BaseActivity mActivity;
    Context mContext;
    private List<au> mList;

    public ae(BaseActivity baseActivity, Context context) {
        this.mContext = context;
        this.mActivity = baseActivity;
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
        return a(i, view, viewGroup);
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        au auVar = (au) getItem(i);
        if (auVar != null && auVar.content != null) {
            switch (getItemViewType(i)) {
                case 0:
                    View aVar = view == null ? new a(this.mContext) : view;
                    a aVar2 = (a) aVar;
                    aVar2.setClickable(false);
                    aVar2.setTime(auVar.time);
                    ChatMessage chatMessage = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$2
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage.setContent(auVar.content);
                    chatMessage.setMsgType(auVar.type);
                    cg.a(this.mContext, aVar2.getRichTextView(), chatMessage, "official_history_adapter", 0);
                    return aVar;
                case 1:
                    View aVar3 = view == null ? new a(this.mContext) : view;
                    a aVar4 = (a) aVar3;
                    aVar4.setClickable(false);
                    aVar4.setTime(auVar.time);
                    ChatMessage chatMessage2 = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter$3
                        @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                        protected Object encode() {
                            return null;
                        }
                    };
                    chatMessage2.setContent("[" + auVar.content + "]");
                    chatMessage2.setMsgType(auVar.type);
                    cg.a(this.mContext, aVar3, aVar4.getImageView(), chatMessage2, 0L, "official_history_adapter");
                    aVar4.getImageView().setTag(Integer.valueOf(i));
                    aVar4.getImageView().setOnClickListener(this.aZx);
                    return aVar3;
                case 2:
                    View aVar5 = view == null ? new a(this.mContext) : view;
                    MultiContentView multiContentView = new MultiContentView(this.mContext);
                    multiContentView.setNeedNightMode(true);
                    multiContentView.setTime(auVar.time);
                    multiContentView.a(this.mActivity.getPageContext(), p.ax(auVar.content, ""), viewGroup);
                    ((a) aVar5).A(multiContentView);
                    return aVar5;
                default:
                    return view;
            }
        }
        return view;
    }

    public void setData(List<au> list) {
        this.mList = list;
        notifyDataSetChanged();
    }
}
