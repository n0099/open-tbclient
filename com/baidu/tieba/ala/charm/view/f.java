package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.live.data.g> cWf = new ArrayList<>();
    private View.OnClickListener exE;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
    }

    public void n(View.OnClickListener onClickListener) {
        this.exE = onClickListener;
    }

    public void setData(List<com.baidu.live.data.g> list) {
        if (list != null) {
            this.cWf.clear();
            this.cWf.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWf == null) {
            return 0;
        }
        return this.cWf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pe */
    public com.baidu.live.data.g getItem(int i) {
        if (this.cWf == null) {
            return null;
        }
        return this.cWf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.online_item_layout, (ViewGroup) null);
            gVar = new g(view);
            gVar.p(this.exE);
            view.setTag(gVar);
        } else {
            gVar = (g) view.getTag();
        }
        if (gVar != null) {
            gVar.a(i, getItem(i));
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }
}
