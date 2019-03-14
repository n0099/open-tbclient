package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener eUe = null;
    private View.OnClickListener dWZ = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: o */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a pF;
        if (aVar != null && (pF = pF(i)) != null) {
            aVar.eUg.startLoad(pF.portrait, 12, false);
            aVar.eUh.setText(pF.nameShow);
            aVar.eUi.setOnClickListener(this.eUe);
            aVar.eUi.setTag(pF);
            aVar.eUf.setOnClickListener(this.dWZ);
            aVar.eUf.setTag(pF);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.S(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a pF(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.c(this.fansList, i);
    }

    public void O(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean cA(long j) {
        if (j == 0 || v.T(this.fansList)) {
            return false;
        }
        Iterator<com.baidu.tieba.forbidden.fans.a> it = this.fansList.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.forbidden.fans.a next = it.next();
            if (next != null && next.id == j) {
                this.fansList.remove(next);
                return true;
            }
        }
        return false;
    }

    public boolean baP() {
        return v.T(this.fansList);
    }

    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View eUf;
        public ClickableHeaderImageView eUg;
        public TextView eUh;
        public TextView eUi;

        public a(View view) {
            super(view);
            this.eUf = view.findViewById(d.g.container_forbidden_item);
            this.eUg = (ClickableHeaderImageView) view.findViewById(d.g.view_fans_photo);
            this.eUg.setRadius(l.h(view.getContext(), d.e.ds90));
            this.eUg.setAutoChangeStyle(true);
            this.eUg.setClickable(false);
            this.eUh = (TextView) view.findViewById(d.g.view_fans_name);
            this.eUi = (TextView) view.findViewById(d.g.view_fans_remove);
            this.dividerLine = view.findViewById(d.g.line_divider);
        }
    }

    private void a(a aVar) {
        al.j(aVar.eUh, d.C0277d.cp_cont_b);
        al.l(aVar.dividerLine, d.C0277d.cp_bg_line_b);
        al.j(aVar.eUi, d.C0277d.btn_color_remove);
        al.k(aVar.eUi, d.f.btn_transparent_focus_border_bg);
    }

    public void r(View.OnClickListener onClickListener) {
        this.eUe = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.dWZ = onClickListener;
    }
}
