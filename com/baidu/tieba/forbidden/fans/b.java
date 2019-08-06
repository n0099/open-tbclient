package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener fpz = null;
    private View.OnClickListener elJ = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a rb;
        if (aVar != null && (rb = rb(i)) != null) {
            aVar.fpB.startLoad(rb.portrait, 12, false);
            aVar.fpC.setText(rb.nameShow);
            aVar.fpD.setOnClickListener(this.fpz);
            aVar.fpD.setTag(rb);
            aVar.fpA.setOnClickListener(this.elJ);
            aVar.fpA.setTag(rb);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.Z(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a rb(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.c(this.fansList, i);
    }

    public void S(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean de(long j) {
        if (j == 0 || v.aa(this.fansList)) {
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

    public boolean bks() {
        return v.aa(this.fansList);
    }

    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View fpA;
        public ClickableHeaderImageView fpB;
        public TextView fpC;
        public TextView fpD;

        public a(View view) {
            super(view);
            this.fpA = view.findViewById(R.id.container_forbidden_item);
            this.fpB = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.fpB.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.fpB.setAutoChangeStyle(true);
            this.fpB.setClickable(false);
            this.fpC = (TextView) view.findViewById(R.id.view_fans_name);
            this.fpD = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        am.j(aVar.fpC, R.color.cp_cont_b);
        am.l(aVar.dividerLine, R.color.cp_bg_line_b);
        am.j(aVar.fpD, R.color.btn_color_remove);
        am.k(aVar.fpD, R.drawable.btn_transparent_focus_border_bg);
    }

    public void t(View.OnClickListener onClickListener) {
        this.fpz = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.elJ = onClickListener;
    }
}
