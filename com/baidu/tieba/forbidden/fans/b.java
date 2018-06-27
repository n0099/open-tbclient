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
    private View.OnClickListener deT = null;
    private View.OnClickListener cmC = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a jT;
        if (aVar != null && (jT = jT(i)) != null) {
            aVar.deV.startLoad(jT.portrait, 12, false);
            aVar.deW.setText(jT.nameShow);
            aVar.deX.setOnClickListener(this.deT);
            aVar.deX.setTag(jT);
            aVar.deU.setOnClickListener(this.cmC);
            aVar.deU.setTag(jT);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return w.z(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a jT(int i) {
        return (com.baidu.tieba.forbidden.fans.a) w.d(this.fansList, i);
    }

    public void L(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean by(long j) {
        if (j == 0 || w.A(this.fansList)) {
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

    public boolean asj() {
        return w.A(this.fansList);
    }

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View bjR;
        public View deU;
        public ClickableHeaderImageView deV;
        public TextView deW;
        public TextView deX;

        public a(View view) {
            super(view);
            this.deU = view.findViewById(d.g.container_forbidden_item);
            this.deV = (ClickableHeaderImageView) view.findViewById(d.g.view_fans_photo);
            this.deV.setRadius(l.e(view.getContext(), d.e.ds90));
            this.deV.setAutoChangeStyle(true);
            this.deV.setClickable(false);
            this.deW = (TextView) view.findViewById(d.g.view_fans_name);
            this.deX = (TextView) view.findViewById(d.g.view_fans_remove);
            this.bjR = view.findViewById(d.g.line_divider);
        }
    }

    private void a(a aVar) {
        am.h(aVar.deW, d.C0142d.cp_cont_b);
        am.j(aVar.bjR, d.C0142d.cp_bg_line_b);
        am.h(aVar.deX, d.C0142d.btn_color_remove);
        am.i(aVar.deX, d.f.btn_transparent_focus_border_bg);
    }

    public void o(View.OnClickListener onClickListener) {
        this.deT = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.cmC = onClickListener;
    }
}
