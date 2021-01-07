package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {
    private ArrayList<a> fansList;
    private Context mContext;
    private View.OnClickListener jaa = null;
    private View.OnClickListener hmh = null;

    public MyForbiddenFansListAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: A */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FansViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i) {
        a zC;
        if (fansViewHolder != null && (zC = zC(i)) != null) {
            fansViewHolder.jab.startLoad(zC.portrait, 12, false);
            fansViewHolder.gko.setText(zC.nameShow);
            fansViewHolder.jac.setOnClickListener(this.jaa);
            fansViewHolder.jac.setTag(zC);
            fansViewHolder.containerView.setOnClickListener(this.hmh);
            fansViewHolder.containerView.setTag(zC);
            a(fansViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.fansList);
    }

    private a zC(int i) {
        return (a) x.getItem(this.fansList, i);
    }

    public void aw(ArrayList<a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<a> getFansList() {
        return this.fansList;
    }

    public boolean gh(long j) {
        if (j == 0 || x.isEmpty(this.fansList)) {
            return false;
        }
        Iterator<a> it = this.fansList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.id == j) {
                this.fansList.remove(next);
                return true;
            }
        }
        return false;
    }

    public boolean cDf() {
        return x.isEmpty(this.fansList);
    }

    /* loaded from: classes8.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {
        public View containerView;
        public View dividerLine;
        public TextView gko;
        public ClickableHeaderImageView jab;
        public TextView jac;

        public FansViewHolder(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.container_forbidden_item);
            this.jab = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.jab.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.jab.setAutoChangeStyle(true);
            this.jab.setClickable(false);
            this.gko = (TextView) view.findViewById(R.id.view_fans_name);
            this.jac = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(FansViewHolder fansViewHolder) {
        ao.setViewTextColor(fansViewHolder.gko, R.color.CAM_X0105);
        ao.setBackgroundColor(fansViewHolder.dividerLine, R.color.CAM_X0204);
        ao.setViewTextColor(fansViewHolder.jac, R.color.btn_color_remove);
        ao.setBackgroundResource(fansViewHolder.jac, R.drawable.btn_transparent_focus_border_bg);
    }

    public void z(View.OnClickListener onClickListener) {
        this.jaa = onClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.hmh = onClickListener;
    }
}
