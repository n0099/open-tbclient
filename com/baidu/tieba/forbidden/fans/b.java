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
    private View.OnClickListener gjq = null;
    private View.OnClickListener eMG = null;

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
        com.baidu.tieba.forbidden.fans.a sn;
        if (aVar != null && (sn = sn(i)) != null) {
            aVar.gjs.startLoad(sn.portrait, 12, false);
            aVar.gjt.setText(sn.nameShow);
            aVar.gju.setOnClickListener(this.gjq);
            aVar.gju.setTag(sn);
            aVar.gjr.setOnClickListener(this.eMG);
            aVar.gjr.setTag(sn);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a sn(int i) {
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

    public boolean bCj() {
        return v.isEmpty(this.fansList);
    }

    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View gjr;
        public ClickableHeaderImageView gjs;
        public TextView gjt;
        public TextView gju;

        public a(View view) {
            super(view);
            this.gjr = view.findViewById(R.id.container_forbidden_item);
            this.gjs = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.gjs.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.gjs.setAutoChangeStyle(true);
            this.gjs.setClickable(false);
            this.gjt = (TextView) view.findViewById(R.id.view_fans_name);
            this.gju = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        am.setViewTextColor(aVar.gjt, (int) R.color.cp_cont_b);
        am.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        am.setViewTextColor(aVar.gju, (int) R.color.btn_color_remove);
        am.setBackgroundResource(aVar.gju, R.drawable.btn_transparent_focus_border_bg);
    }

    public void w(View.OnClickListener onClickListener) {
        this.gjq = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.eMG = onClickListener;
    }
}
