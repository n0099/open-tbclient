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
    private View.OnClickListener ijL = null;
    private View.OnClickListener gzX = null;

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
        com.baidu.tieba.forbidden.fans.a xG;
        if (aVar != null && (xG = xG(i)) != null) {
            aVar.ijM.startLoad(xG.portrait, 12, false);
            aVar.fET.setText(xG.nameShow);
            aVar.ijN.setOnClickListener(this.ijL);
            aVar.ijN.setTag(xG);
            aVar.containerView.setOnClickListener(this.gzX);
            aVar.containerView.setTag(xG);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a xG(int i) {
        return (com.baidu.tieba.forbidden.fans.a) y.getItem(this.fansList, i);
    }

    public void at(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean fd(long j) {
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

    public boolean cqK() {
        return y.isEmpty(this.fansList);
    }

    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View containerView;
        public View dividerLine;
        public TextView fET;
        public ClickableHeaderImageView ijM;
        public TextView ijN;

        public a(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.container_forbidden_item);
            this.ijM = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.ijM.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.ijM.setAutoChangeStyle(true);
            this.ijM.setClickable(false);
            this.fET = (TextView) view.findViewById(R.id.view_fans_name);
            this.ijN = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        ap.setViewTextColor(aVar.fET, R.color.cp_cont_b);
        ap.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(aVar.ijN, R.color.btn_color_remove);
        ap.setBackgroundResource(aVar.ijN, R.drawable.btn_transparent_focus_border_bg);
    }

    public void x(View.OnClickListener onClickListener) {
        this.ijL = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.gzX = onClickListener;
    }
}
