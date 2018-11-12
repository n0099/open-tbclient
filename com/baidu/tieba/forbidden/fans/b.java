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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener dwU = null;
    private View.OnClickListener cDP = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a ls;
        if (aVar != null && (ls = ls(i)) != null) {
            aVar.dwW.startLoad(ls.portrait, 12, false);
            aVar.dwX.setText(ls.nameShow);
            aVar.dwY.setOnClickListener(this.dwU);
            aVar.dwY.setTag(ls);
            aVar.dwV.setOnClickListener(this.cDP);
            aVar.dwV.setTag(ls);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.H(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a ls(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.d(this.fansList, i);
    }

    public void L(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean bJ(long j) {
        if (j == 0 || v.I(this.fansList)) {
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

    public boolean axu() {
        return v.I(this.fansList);
    }

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View dwV;
        public ClickableHeaderImageView dwW;
        public TextView dwX;
        public TextView dwY;

        public a(View view) {
            super(view);
            this.dwV = view.findViewById(e.g.container_forbidden_item);
            this.dwW = (ClickableHeaderImageView) view.findViewById(e.g.view_fans_photo);
            this.dwW.setRadius(l.h(view.getContext(), e.C0200e.ds90));
            this.dwW.setAutoChangeStyle(true);
            this.dwW.setClickable(false);
            this.dwX = (TextView) view.findViewById(e.g.view_fans_name);
            this.dwY = (TextView) view.findViewById(e.g.view_fans_remove);
            this.dividerLine = view.findViewById(e.g.line_divider);
        }
    }

    private void a(a aVar) {
        al.h(aVar.dwX, e.d.cp_cont_b);
        al.j(aVar.dividerLine, e.d.cp_bg_line_b);
        al.h(aVar.dwY, e.d.btn_color_remove);
        al.i(aVar.dwY, e.f.btn_transparent_focus_border_bg);
    }

    public void q(View.OnClickListener onClickListener) {
        this.dwU = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.cDP = onClickListener;
    }
}
