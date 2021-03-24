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
import d.b.i0.d1.f.h;
import d.b.i0.d1.w.c;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarHistoryAdapter extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f17844e;

    /* renamed from: f  reason: collision with root package name */
    public BaseActivity f17845f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f17846g = new a();

    /* renamed from: h  reason: collision with root package name */
    public List<ResponseHistoryMessage.a> f17847h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue < 0 || intValue >= OfficialBarHistoryAdapter.this.f17847h.size()) {
                return;
            }
            ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) OfficialBarHistoryAdapter.this.f17847h.get(intValue);
            String f2 = c.f("[" + aVar.f17883c + "]", true);
            if (f2 == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialHistoryImageActivityConfig(OfficialBarHistoryAdapter.this.f17844e, f2, String.valueOf(aVar.f17884d))));
        }
    }

    public OfficialBarHistoryAdapter(BaseActivity baseActivity, Context context) {
        this.f17844e = context;
        this.f17845f = baseActivity;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        ResponseHistoryMessage.a aVar = (ResponseHistoryMessage.a) getItem(i);
        if (aVar != null && aVar.f17883c != null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view == null) {
                    view = new HistoryItemView(this.f17844e);
                }
                HistoryItemView historyItemView = (HistoryItemView) view;
                historyItemView.setClickable(false);
                historyItemView.setTime(aVar.f17881a);
                ChatMessage chatMessage = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter.2
                    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                    public Object encode() {
                        return null;
                    }
                };
                chatMessage.setContent(aVar.f17883c);
                chatMessage.setMsgType(aVar.f17882b);
                h.e(this.f17844e, historyItemView.getRichTextView(), chatMessage, "official_history_adapter", 0);
            } else if (itemViewType == 1) {
                if (view == null) {
                    view = new HistoryItemView(this.f17844e);
                }
                HistoryItemView historyItemView2 = (HistoryItemView) view;
                historyItemView2.setClickable(false);
                historyItemView2.setTime(aVar.f17881a);
                ChatMessage chatMessage2 = new ChatMessage(501126) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter.3
                    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
                    public Object encode() {
                        return null;
                    }
                };
                chatMessage2.setContent("[" + aVar.f17883c + "]");
                chatMessage2.setMsgType(aVar.f17882b);
                h.d(this.f17844e, view, historyItemView2.getImageView(), chatMessage2, 0L, "official_history_adapter");
                historyItemView2.getImageView().setTag(Integer.valueOf(i));
                historyItemView2.getImageView().setOnClickListener(this.f17846g);
            } else if (itemViewType == 2) {
                if (view == null) {
                    view = new HistoryItemView(this.f17844e);
                }
                MultiContentView multiContentView = new MultiContentView(this.f17844e);
                multiContentView.setNeedNightMode(true);
                multiContentView.setTime(aVar.f17881a);
                multiContentView.setData(this.f17845f.getPageContext(), d.b.i0.d1.l.c.a.a(aVar.f17883c, "", 0L, 0L), viewGroup);
                ((HistoryItemView) view).a(multiContentView);
            }
        }
        return view;
    }

    public void c(List<ResponseHistoryMessage.a> list) {
        this.f17847h = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ResponseHistoryMessage.a> list = this.f17847h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f17847h == null || i >= getCount()) {
            return null;
        }
        return this.f17847h.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        List<ResponseHistoryMessage.a> list = this.f17847h;
        if (list == null || i >= list.size()) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        List<ResponseHistoryMessage.a> list = this.f17847h;
        if (list == null || i >= list.size()) {
            return 0;
        }
        int i2 = this.f17847h.get(i).f17882b;
        if (i2 != 2) {
            return i2 != 7 ? 0 : 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return b(i, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }
}
