package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener huE = null;
    private View.OnClickListener fRa = null;

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
        com.baidu.tieba.forbidden.fans.a tU;
        if (aVar != null && (tU = tU(i)) != null) {
            aVar.huG.startLoad(tU.portrait, 12, false);
            aVar.huH.setText(tU.nameShow);
            aVar.huI.setOnClickListener(this.huE);
            aVar.huI.setTag(tU);
            aVar.huF.setOnClickListener(this.fRa);
            aVar.huF.setTag(tU);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return w.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a tU(int i) {
        return (com.baidu.tieba.forbidden.fans.a) w.getItem(this.fansList, i);
    }

    public void ak(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean ee(long j) {
        if (j == 0 || w.isEmpty(this.fansList)) {
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

    public boolean bWj() {
        return w.isEmpty(this.fansList);
    }

    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View huF;
        public ClickableHeaderImageView huG;
        public TextView huH;
        public TextView huI;

        public a(View view) {
            super(view);
            this.huF = view.findViewById(R.id.container_forbidden_item);
            this.huG = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.huG.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.huG.setAutoChangeStyle(true);
            this.huG.setClickable(false);
            this.huH = (TextView) view.findViewById(R.id.view_fans_name);
            this.huI = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        an.setViewTextColor(aVar.huH, (int) R.color.cp_cont_b);
        an.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        an.setViewTextColor(aVar.huI, (int) R.color.btn_color_remove);
        an.setBackgroundResource(aVar.huI, R.drawable.btn_transparent_focus_border_bg);
    }

    public void x(View.OnClickListener onClickListener) {
        this.huE = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.fRa = onClickListener;
    }
}
