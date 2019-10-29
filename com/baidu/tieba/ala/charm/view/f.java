package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.live.data.d> bbZ = new ArrayList<>();
    private View.OnClickListener dGl;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
    }

    public void n(View.OnClickListener onClickListener) {
        this.dGl = onClickListener;
    }

    public void setData(List<com.baidu.live.data.d> list) {
        if (list != null) {
            this.bbZ.clear();
            this.bbZ.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mA */
    public com.baidu.live.data.d getItem(int i) {
        if (this.bbZ == null) {
            return null;
        }
        return this.bbZ.get(i);
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
            gVar.p(this.dGl);
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
