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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener fkc = null;
    private View.OnClickListener egY = null;

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
        com.baidu.tieba.forbidden.fans.a qH;
        if (aVar != null && (qH = qH(i)) != null) {
            aVar.fke.startLoad(qH.portrait, 12, false);
            aVar.fkf.setText(qH.nameShow);
            aVar.fkg.setOnClickListener(this.fkc);
            aVar.fkg.setTag(qH);
            aVar.fkd.setOnClickListener(this.egY);
            aVar.fkd.setTag(qH);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.Z(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a qH(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.c(this.fansList, i);
    }

    public void S(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean cX(long j) {
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

    public boolean bij() {
        return v.aa(this.fansList);
    }

    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View fkd;
        public ClickableHeaderImageView fke;
        public TextView fkf;
        public TextView fkg;

        public a(View view) {
            super(view);
            this.fkd = view.findViewById(R.id.container_forbidden_item);
            this.fke = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.fke.setRadius(l.g(view.getContext(), R.dimen.ds90));
            this.fke.setAutoChangeStyle(true);
            this.fke.setClickable(false);
            this.fkf = (TextView) view.findViewById(R.id.view_fans_name);
            this.fkg = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        al.j(aVar.fkf, R.color.cp_cont_b);
        al.l(aVar.dividerLine, R.color.cp_bg_line_b);
        al.j(aVar.fkg, R.color.btn_color_remove);
        al.k(aVar.fkg, R.drawable.btn_transparent_focus_border_bg);
    }

    public void t(View.OnClickListener onClickListener) {
        this.fkc = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.egY = onClickListener;
    }
}
