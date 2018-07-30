package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener dhJ = null;
    private View.OnClickListener coq = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a ke;
        if (aVar != null && (ke = ke(i)) != null) {
            aVar.dhL.startLoad(ke.portrait, 12, false);
            aVar.dhM.setText(ke.nameShow);
            aVar.dhN.setOnClickListener(this.dhJ);
            aVar.dhN.setTag(ke);
            aVar.dhK.setOnClickListener(this.coq);
            aVar.dhK.setTag(ke);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return w.y(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a ke(int i) {
        return (com.baidu.tieba.forbidden.fans.a) w.d(this.fansList, i);
    }

    public void L(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean bC(long j) {
        if (j == 0 || w.z(this.fansList)) {
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

    public boolean asN() {
        return w.z(this.fansList);
    }

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View bkw;
        public View dhK;
        public ClickableHeaderImageView dhL;
        public TextView dhM;
        public TextView dhN;

        public a(View view) {
            super(view);
            this.dhK = view.findViewById(d.g.container_forbidden_item);
            this.dhL = (ClickableHeaderImageView) view.findViewById(d.g.view_fans_photo);
            this.dhL.setRadius(l.f(view.getContext(), d.e.ds90));
            this.dhL.setAutoChangeStyle(true);
            this.dhL.setClickable(false);
            this.dhM = (TextView) view.findViewById(d.g.view_fans_name);
            this.dhN = (TextView) view.findViewById(d.g.view_fans_remove);
            this.bkw = view.findViewById(d.g.line_divider);
        }
    }

    private void a(a aVar) {
        am.h(aVar.dhM, d.C0140d.cp_cont_b);
        am.j(aVar.bkw, d.C0140d.cp_bg_line_b);
        am.h(aVar.dhN, d.C0140d.btn_color_remove);
        am.i(aVar.dhN, d.f.btn_transparent_focus_border_bg);
    }

    public void o(View.OnClickListener onClickListener) {
        this.dhJ = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.coq = onClickListener;
    }
}
