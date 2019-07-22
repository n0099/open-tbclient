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
    private View.OnClickListener foZ = null;
    private View.OnClickListener elC = null;

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
        com.baidu.tieba.forbidden.fans.a qZ;
        if (aVar != null && (qZ = qZ(i)) != null) {
            aVar.fpb.startLoad(qZ.portrait, 12, false);
            aVar.fpc.setText(qZ.nameShow);
            aVar.fpd.setOnClickListener(this.foZ);
            aVar.fpd.setTag(qZ);
            aVar.fpa.setOnClickListener(this.elC);
            aVar.fpa.setTag(qZ);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.Z(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a qZ(int i) {
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

    public boolean bkl() {
        return v.aa(this.fansList);
    }

    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View fpa;
        public ClickableHeaderImageView fpb;
        public TextView fpc;
        public TextView fpd;

        public a(View view) {
            super(view);
            this.fpa = view.findViewById(R.id.container_forbidden_item);
            this.fpb = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.fpb.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.fpb.setAutoChangeStyle(true);
            this.fpb.setClickable(false);
            this.fpc = (TextView) view.findViewById(R.id.view_fans_name);
            this.fpd = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        am.j(aVar.fpc, R.color.cp_cont_b);
        am.l(aVar.dividerLine, R.color.cp_bg_line_b);
        am.j(aVar.fpd, R.color.btn_color_remove);
        am.k(aVar.fpd, R.drawable.btn_transparent_focus_border_bg);
    }

    public void t(View.OnClickListener onClickListener) {
        this.foZ = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.elC = onClickListener;
    }
}
