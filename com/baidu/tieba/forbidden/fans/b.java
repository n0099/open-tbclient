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
/* loaded from: classes10.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener gkl = null;
    private View.OnClickListener eNp = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a sp;
        if (aVar != null && (sp = sp(i)) != null) {
            aVar.gkn.startLoad(sp.portrait, 12, false);
            aVar.gko.setText(sp.nameShow);
            aVar.gkp.setOnClickListener(this.gkl);
            aVar.gkp.setTag(sp);
            aVar.gkm.setOnClickListener(this.eNp);
            aVar.gkm.setTag(sp);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a sp(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.getItem(this.fansList, i);
    }

    public void ai(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean dr(long j) {
        if (j == 0 || v.isEmpty(this.fansList)) {
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

    public boolean bCq() {
        return v.isEmpty(this.fansList);
    }

    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View gkm;
        public ClickableHeaderImageView gkn;
        public TextView gko;
        public TextView gkp;

        public a(View view) {
            super(view);
            this.gkm = view.findViewById(R.id.container_forbidden_item);
            this.gkn = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.gkn.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.gkn.setAutoChangeStyle(true);
            this.gkn.setClickable(false);
            this.gko = (TextView) view.findViewById(R.id.view_fans_name);
            this.gkp = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        am.setViewTextColor(aVar.gko, (int) R.color.cp_cont_b);
        am.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        am.setViewTextColor(aVar.gkp, (int) R.color.btn_color_remove);
        am.setBackgroundResource(aVar.gkp, R.drawable.btn_transparent_focus_border_bg);
    }

    public void w(View.OnClickListener onClickListener) {
        this.gkl = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.eNp = onClickListener;
    }
}
