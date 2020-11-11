package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes23.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener iCg = null;
    private View.OnClickListener gRx = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: w */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a ym;
        if (aVar != null && (ym = ym(i)) != null) {
            aVar.iCh.startLoad(ym.portrait, 12, false);
            aVar.fTe.setText(ym.nameShow);
            aVar.iCi.setOnClickListener(this.iCg);
            aVar.iCi.setTag(ym);
            aVar.containerView.setOnClickListener(this.gRx);
            aVar.containerView.setTag(ym);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a ym(int i) {
        return (com.baidu.tieba.forbidden.fans.a) y.getItem(this.fansList, i);
    }

    public void au(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean fA(long j) {
        if (j == 0 || y.isEmpty(this.fansList)) {
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

    public boolean cws() {
        return y.isEmpty(this.fansList);
    }

    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View containerView;
        public View dividerLine;
        public TextView fTe;
        public ClickableHeaderImageView iCh;
        public TextView iCi;

        public a(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.container_forbidden_item);
            this.iCh = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.iCh.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.iCh.setAutoChangeStyle(true);
            this.iCh.setClickable(false);
            this.fTe = (TextView) view.findViewById(R.id.view_fans_name);
            this.iCi = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        ap.setViewTextColor(aVar.fTe, R.color.cp_cont_b);
        ap.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(aVar.iCi, R.color.btn_color_remove);
        ap.setBackgroundResource(aVar.iCi, R.drawable.btn_transparent_focus_border_bg);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iCg = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.gRx = onClickListener;
    }
}
