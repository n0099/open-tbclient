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
    private View.OnClickListener dGQ = null;
    private View.OnClickListener cJz = null;

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
        com.baidu.tieba.forbidden.fans.a lW;
        if (aVar != null && (lW = lW(i)) != null) {
            aVar.dGS.startLoad(lW.portrait, 12, false);
            aVar.dGT.setText(lW.nameShow);
            aVar.dGU.setOnClickListener(this.dGQ);
            aVar.dGU.setTag(lW);
            aVar.dGR.setOnClickListener(this.cJz);
            aVar.dGR.setTag(lW);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.H(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a lW(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.d(this.fansList, i);
    }

    public void L(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean bV(long j) {
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

    public boolean aAq() {
        return v.I(this.fansList);
    }

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dGR;
        public ClickableHeaderImageView dGS;
        public TextView dGT;
        public TextView dGU;
        public View dividerLine;

        public a(View view) {
            super(view);
            this.dGR = view.findViewById(e.g.container_forbidden_item);
            this.dGS = (ClickableHeaderImageView) view.findViewById(e.g.view_fans_photo);
            this.dGS.setRadius(l.h(view.getContext(), e.C0210e.ds90));
            this.dGS.setAutoChangeStyle(true);
            this.dGS.setClickable(false);
            this.dGT = (TextView) view.findViewById(e.g.view_fans_name);
            this.dGU = (TextView) view.findViewById(e.g.view_fans_remove);
            this.dividerLine = view.findViewById(e.g.line_divider);
        }
    }

    private void a(a aVar) {
        al.h(aVar.dGT, e.d.cp_cont_b);
        al.j(aVar.dividerLine, e.d.cp_bg_line_b);
        al.h(aVar.dGU, e.d.btn_color_remove);
        al.i(aVar.dGU, e.f.btn_transparent_focus_border_bg);
    }

    public void q(View.OnClickListener onClickListener) {
        this.dGQ = onClickListener;
    }

    public void j(View.OnClickListener onClickListener) {
        this.cJz = onClickListener;
    }
}
