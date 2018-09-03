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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener dhH = null;
    private View.OnClickListener con = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: l */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(f.h.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a kd;
        if (aVar != null && (kd = kd(i)) != null) {
            aVar.dhJ.startLoad(kd.portrait, 12, false);
            aVar.dhK.setText(kd.nameShow);
            aVar.dhL.setOnClickListener(this.dhH);
            aVar.dhL.setTag(kd);
            aVar.dhI.setOnClickListener(this.con);
            aVar.dhI.setTag(kd);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return w.y(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a kd(int i) {
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

    public boolean asM() {
        return w.z(this.fansList);
    }

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dhI;
        public ClickableHeaderImageView dhJ;
        public TextView dhK;
        public TextView dhL;
        public View dividerLine;

        public a(View view) {
            super(view);
            this.dhI = view.findViewById(f.g.container_forbidden_item);
            this.dhJ = (ClickableHeaderImageView) view.findViewById(f.g.view_fans_photo);
            this.dhJ.setRadius(l.f(view.getContext(), f.e.ds90));
            this.dhJ.setAutoChangeStyle(true);
            this.dhJ.setClickable(false);
            this.dhK = (TextView) view.findViewById(f.g.view_fans_name);
            this.dhL = (TextView) view.findViewById(f.g.view_fans_remove);
            this.dividerLine = view.findViewById(f.g.line_divider);
        }
    }

    private void a(a aVar) {
        am.h(aVar.dhK, f.d.cp_cont_b);
        am.j(aVar.dividerLine, f.d.cp_bg_line_b);
        am.h(aVar.dhL, f.d.btn_color_remove);
        am.i(aVar.dhL, f.C0146f.btn_transparent_focus_border_bg);
    }

    public void o(View.OnClickListener onClickListener) {
        this.dhH = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.con = onClickListener;
    }
}
