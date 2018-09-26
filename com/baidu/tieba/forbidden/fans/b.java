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
    private View.OnClickListener dnz = null;
    private View.OnClickListener cue = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a kC;
        if (aVar != null && (kC = kC(i)) != null) {
            aVar.dnB.startLoad(kC.portrait, 12, false);
            aVar.dnC.setText(kC.nameShow);
            aVar.dnD.setOnClickListener(this.dnz);
            aVar.dnD.setTag(kC);
            aVar.dnA.setOnClickListener(this.cue);
            aVar.dnA.setTag(kC);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.y(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a kC(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.d(this.fansList, i);
    }

    public void L(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean bG(long j) {
        if (j == 0 || v.z(this.fansList)) {
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

    public boolean auA() {
        return v.z(this.fansList);
    }

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View dnA;
        public ClickableHeaderImageView dnB;
        public TextView dnC;
        public TextView dnD;

        public a(View view) {
            super(view);
            this.dnA = view.findViewById(e.g.container_forbidden_item);
            this.dnB = (ClickableHeaderImageView) view.findViewById(e.g.view_fans_photo);
            this.dnB.setRadius(l.h(view.getContext(), e.C0141e.ds90));
            this.dnB.setAutoChangeStyle(true);
            this.dnB.setClickable(false);
            this.dnC = (TextView) view.findViewById(e.g.view_fans_name);
            this.dnD = (TextView) view.findViewById(e.g.view_fans_remove);
            this.dividerLine = view.findViewById(e.g.line_divider);
        }
    }

    private void a(a aVar) {
        al.h(aVar.dnC, e.d.cp_cont_b);
        al.j(aVar.dividerLine, e.d.cp_bg_line_b);
        al.h(aVar.dnD, e.d.btn_color_remove);
        al.i(aVar.dnD, e.f.btn_transparent_focus_border_bg);
    }

    public void o(View.OnClickListener onClickListener) {
        this.dnz = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cue = onClickListener;
    }
}
