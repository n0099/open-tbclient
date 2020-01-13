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
/* loaded from: classes8.dex */
public class b extends RecyclerView.Adapter<a> {
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fansList;
    private Context mContext;
    private View.OnClickListener ghn = null;
    private View.OnClickListener eIL = null;

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
        com.baidu.tieba.forbidden.fans.a sh;
        if (aVar != null && (sh = sh(i)) != null) {
            aVar.ghp.startLoad(sh.portrait, 12, false);
            aVar.ghq.setText(sh.nameShow);
            aVar.ghr.setOnClickListener(this.ghn);
            aVar.ghr.setTag(sh);
            aVar.gho.setOnClickListener(this.eIL);
            aVar.gho.setTag(sh);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a sh(int i) {
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

    public boolean bAF() {
        return v.isEmpty(this.fansList);
    }

    /* loaded from: classes8.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View dividerLine;
        public View gho;
        public ClickableHeaderImageView ghp;
        public TextView ghq;
        public TextView ghr;

        public a(View view) {
            super(view);
            this.gho = view.findViewById(R.id.container_forbidden_item);
            this.ghp = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.ghp.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.ghp.setAutoChangeStyle(true);
            this.ghp.setClickable(false);
            this.ghq = (TextView) view.findViewById(R.id.view_fans_name);
            this.ghr = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        am.setViewTextColor(aVar.ghq, (int) R.color.cp_cont_b);
        am.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
        am.setViewTextColor(aVar.ghr, (int) R.color.btn_color_remove);
        am.setBackgroundResource(aVar.ghr, R.drawable.btn_transparent_focus_border_bg);
    }

    public void v(View.OnClickListener onClickListener) {
        this.ghn = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.eIL = onClickListener;
    }
}
