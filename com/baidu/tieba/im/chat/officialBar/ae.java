package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.chat.dc;
import java.util.List;
/* loaded from: classes.dex */
public final class ae extends BaseAdapter {
    Context a;
    private View.OnClickListener b = new af(this);
    private List<bf> c;

    public ae(Context context) {
        this.a = context;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.c == null || i >= getCount()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (this.c == null || i >= this.c.size()) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
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
    public final int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        bf bfVar = (bf) getItem(i);
        if (bfVar != null && bfVar.c != null) {
            switch (getItemViewType(i)) {
                case 0:
                    View aVar = view == null ? new a(this.a) : view;
                    a aVar2 = (a) aVar;
                    aVar2.setClickable(false);
                    aVar2.setTime(bfVar.a);
                    ag agVar = new ag(this, 501126);
                    agVar.d(bfVar.c);
                    agVar.e(bfVar.b);
                    dc.a(this.a, aVar2.getRichTextView(), agVar);
                    return aVar;
                case 1:
                    View aVar3 = view == null ? new a(this.a) : view;
                    a aVar4 = (a) aVar3;
                    aVar4.setClickable(false);
                    aVar4.setTime(bfVar.a);
                    ah ahVar = new ah(this, 501126);
                    ahVar.d("[" + bfVar.c + "]");
                    ahVar.e(bfVar.b);
                    dc.a(this.a, aVar3, aVar4.getImageView(), ahVar, "official_history_adapter");
                    aVar4.getImageView().setTag(Integer.valueOf(i));
                    aVar4.getImageView().setOnClickListener(this.b);
                    return aVar3;
                case 2:
                    View aVar5 = view == null ? new a(this.a) : view;
                    MultiContentView multiContentView = new MultiContentView(this.a);
                    multiContentView.setTime(bfVar.a);
                    multiContentView.a(s.a(bfVar.c), viewGroup);
                    ((a) aVar5).a(multiContentView);
                    return aVar5;
            }
        }
        return view;
    }

    public final void a(List<bf> list) {
        this.c = list;
        notifyDataSetChanged();
    }
}
