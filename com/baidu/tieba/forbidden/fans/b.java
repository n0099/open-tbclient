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
    private View.OnClickListener eTR = null;
    private View.OnClickListener dWy = null;

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
        com.baidu.tieba.forbidden.fans.a pB;
        if (aVar != null && (pB = pB(i)) != null) {
            aVar.eTT.startLoad(pB.portrait, 12, false);
            aVar.eTU.setText(pB.nameShow);
            aVar.eTV.setOnClickListener(this.eTR);
            aVar.eTV.setTag(pB);
            aVar.eTS.setOnClickListener(this.dWy);
            aVar.eTS.setTag(pB);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.S(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a pB(int i) {
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

    public boolean baN() {
        return v.T(this.fansList);
    }

    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View eTS;
        public ClickableHeaderImageView eTT;
        public TextView eTU;
        public TextView eTV;

        public a(View view) {
            super(view);
            this.eTS = view.findViewById(d.g.container_forbidden_item);
            this.eTT = (ClickableHeaderImageView) view.findViewById(d.g.view_fans_photo);
            this.eTT.setRadius(l.h(view.getContext(), d.e.ds90));
            this.eTT.setAutoChangeStyle(true);
            this.eTT.setClickable(false);
            this.eTU = (TextView) view.findViewById(d.g.view_fans_name);
            this.eTV = (TextView) view.findViewById(d.g.view_fans_remove);
            this.dividerLine = view.findViewById(d.g.line_divider);
        }
    }

    private void a(a aVar) {
        al.j(aVar.eTU, d.C0277d.cp_cont_b);
        al.l(aVar.dividerLine, d.C0277d.cp_bg_line_b);
        al.j(aVar.eTV, d.C0277d.btn_color_remove);
        al.k(aVar.eTV, d.f.btn_transparent_focus_border_bg);
    }

    public void r(View.OnClickListener onClickListener) {
        this.eTR = onClickListener;
    }

    public void k(View.OnClickListener onClickListener) {
        this.dWy = onClickListener;
    }
}
