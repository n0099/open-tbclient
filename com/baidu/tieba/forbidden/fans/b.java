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
    private View.OnClickListener fpH = null;
    private View.OnClickListener dRU = null;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        com.baidu.tieba.forbidden.fans.a pW;
        if (aVar != null && (pW = pW(i)) != null) {
            aVar.fpJ.startLoad(pW.portrait, 12, false);
            aVar.fpK.setText(pW.nameShow);
            aVar.fpL.setOnClickListener(this.fpH);
            aVar.fpL.setTag(pW);
            aVar.fpI.setOnClickListener(this.dRU);
            aVar.fpI.setTag(pW);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a pW(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.getItem(this.fansList, i);
    }

    public void X(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean cG(long j) {
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

    public boolean bii() {
        return v.isEmpty(this.fansList);
    }

    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View fpI;
        public ClickableHeaderImageView fpJ;
        public TextView fpK;
        public TextView fpL;

        public a(View view) {
            super(view);
            this.fpI = view.findViewById(R.id.container_forbidden_item);
            this.fpJ = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.fpJ.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.fpJ.setAutoChangeStyle(true);
            this.fpJ.setClickable(false);
            this.fpK = (TextView) view.findViewById(R.id.view_fans_name);
            this.fpL = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        am.setViewTextColor(aVar.fpK, (int) R.color.cp_cont_b);
        am.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        am.setViewTextColor(aVar.fpL, (int) R.color.btn_color_remove);
        am.setBackgroundResource(aVar.fpL, R.drawable.btn_transparent_focus_border_bg);
    }

    public void u(View.OnClickListener onClickListener) {
        this.fpH = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.dRU = onClickListener;
    }
}
