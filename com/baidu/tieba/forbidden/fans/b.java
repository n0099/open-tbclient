package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes17.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener hAq = null;
    private View.OnClickListener fWt = null;

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
        com.baidu.tieba.forbidden.fans.a um;
        if (aVar != null && (um = um(i)) != null) {
            aVar.hAs.startLoad(um.portrait, 12, false);
            aVar.hAt.setText(um.nameShow);
            aVar.hAu.setOnClickListener(this.hAq);
            aVar.hAu.setTag(um);
            aVar.hAr.setOnClickListener(this.fWt);
            aVar.hAr.setTag(um);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a um(int i) {
        return (com.baidu.tieba.forbidden.fans.a) x.getItem(this.fansList, i);
    }

    public void al(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean er(long j) {
        if (j == 0 || x.isEmpty(this.fansList)) {
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

    public boolean bZC() {
        return x.isEmpty(this.fansList);
    }

    /* loaded from: classes17.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View hAr;
        public ClickableHeaderImageView hAs;
        public TextView hAt;
        public TextView hAu;

        public a(View view) {
            super(view);
            this.hAr = view.findViewById(R.id.container_forbidden_item);
            this.hAs = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.hAs.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.hAs.setAutoChangeStyle(true);
            this.hAs.setClickable(false);
            this.hAt = (TextView) view.findViewById(R.id.view_fans_name);
            this.hAu = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        ao.setViewTextColor(aVar.hAt, R.color.cp_cont_b);
        ao.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        ao.setViewTextColor(aVar.hAu, R.color.btn_color_remove);
        ao.setBackgroundResource(aVar.hAu, R.drawable.btn_transparent_focus_border_bg);
    }

    public void x(View.OnClickListener onClickListener) {
        this.hAq = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.fWt = onClickListener;
    }
}
