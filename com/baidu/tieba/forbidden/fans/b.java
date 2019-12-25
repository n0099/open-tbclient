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
/* loaded from: classes7.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener ged = null;
    private View.OnClickListener eHB = null;

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
        com.baidu.tieba.forbidden.fans.a sc;
        if (aVar != null && (sc = sc(i)) != null) {
            aVar.gef.startLoad(sc.portrait, 12, false);
            aVar.geg.setText(sc.nameShow);
            aVar.geh.setOnClickListener(this.ged);
            aVar.geh.setTag(sc);
            aVar.gee.setOnClickListener(this.eHB);
            aVar.gee.setTag(sc);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a sc(int i) {
        return (com.baidu.tieba.forbidden.fans.a) v.getItem(this.fansList, i);
    }

    public void ai(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean dm(long j) {
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

    public boolean bzD() {
        return v.isEmpty(this.fansList);
    }

    /* loaded from: classes7.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View gee;
        public ClickableHeaderImageView gef;
        public TextView geg;
        public TextView geh;

        public a(View view) {
            super(view);
            this.gee = view.findViewById(R.id.container_forbidden_item);
            this.gef = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.gef.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.gef.setAutoChangeStyle(true);
            this.gef.setClickable(false);
            this.geg = (TextView) view.findViewById(R.id.view_fans_name);
            this.geh = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        am.setViewTextColor(aVar.geg, (int) R.color.cp_cont_b);
        am.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        am.setViewTextColor(aVar.geh, (int) R.color.btn_color_remove);
        am.setBackgroundResource(aVar.geh, R.drawable.btn_transparent_focus_border_bg);
    }

    public void w(View.OnClickListener onClickListener) {
        this.ged = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.eHB = onClickListener;
    }
}
