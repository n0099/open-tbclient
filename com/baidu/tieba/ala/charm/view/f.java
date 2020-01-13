package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends BaseAdapter {
    private ArrayList<com.baidu.live.data.f> cRO = new ArrayList<>();
    private View.OnClickListener esJ;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
    }

    public void n(View.OnClickListener onClickListener) {
        this.esJ = onClickListener;
    }

    public void setData(List<com.baidu.live.data.f> list) {
        if (list != null) {
            this.cRO.clear();
            this.cRO.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oL */
    public com.baidu.live.data.f getItem(int i) {
        if (this.cRO == null) {
            return null;
        }
        return this.cRO.get(i);
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
            gVar.p(this.esJ);
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
