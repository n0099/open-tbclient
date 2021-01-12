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
/* loaded from: classes7.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {
    private ArrayList<a> fansList;
    private Context mContext;
    private View.OnClickListener iVt = null;
    private View.OnClickListener hhA = null;

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
        a xW;
        if (fansViewHolder != null && (xW = xW(i)) != null) {
            fansViewHolder.iVu.startLoad(xW.portrait, 12, false);
            fansViewHolder.gfG.setText(xW.nameShow);
            fansViewHolder.iVv.setOnClickListener(this.iVt);
            fansViewHolder.iVv.setTag(xW);
            fansViewHolder.containerView.setOnClickListener(this.hhA);
            fansViewHolder.containerView.setTag(xW);
            a(fansViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.fansList);
    }

    private a xW(int i) {
        return (a) x.getItem(this.fansList, i);
    }

    public void ar(ArrayList<a> arrayList) {
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

    public boolean czn() {
        return x.isEmpty(this.fansList);
    }

    /* loaded from: classes7.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {
        public View containerView;
        public View dividerLine;
        public TextView gfG;
        public ClickableHeaderImageView iVu;
        public TextView iVv;

        public FansViewHolder(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.container_forbidden_item);
            this.iVu = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.iVu.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.iVu.setAutoChangeStyle(true);
            this.iVu.setClickable(false);
            this.gfG = (TextView) view.findViewById(R.id.view_fans_name);
            this.iVv = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(FansViewHolder fansViewHolder) {
        ao.setViewTextColor(fansViewHolder.gfG, R.color.CAM_X0105);
        ao.setBackgroundColor(fansViewHolder.dividerLine, R.color.CAM_X0204);
        ao.setViewTextColor(fansViewHolder.iVv, R.color.btn_color_remove);
        ao.setBackgroundResource(fansViewHolder.iVv, R.drawable.btn_transparent_focus_border_bg);
    }

    public void z(View.OnClickListener onClickListener) {
        this.iVt = onClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.hhA = onClickListener;
    }
}
