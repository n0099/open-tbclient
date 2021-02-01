package com.baidu.tieba.forbidden.fans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class MyForbiddenFansListAdapter extends RecyclerView.Adapter<FansViewHolder> {
    private ArrayList<a> fansList;
    private Context mContext;
    private View.OnClickListener jba = null;
    private View.OnClickListener hlQ = null;

    public MyForbiddenFansListAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B */
    public FansViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FansViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forbidden_fans_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(FansViewHolder fansViewHolder, int i) {
        a yg;
        if (fansViewHolder != null && (yg = yg(i)) != null) {
            fansViewHolder.jbb.startLoad(yg.portrait, 12, false);
            fansViewHolder.ghV.setText(yg.nameShow);
            fansViewHolder.jbc.setOnClickListener(this.jba);
            fansViewHolder.jbc.setTag(yg);
            fansViewHolder.containerView.setOnClickListener(this.hlQ);
            fansViewHolder.containerView.setTag(yg);
            a(fansViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.fansList);
    }

    private a yg(int i) {
        return (a) y.getItem(this.fansList, i);
    }

    public void aq(ArrayList<a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<a> getFansList() {
        return this.fansList;
    }

    public boolean gm(long j) {
        if (j == 0 || y.isEmpty(this.fansList)) {
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

    public boolean cAy() {
        return y.isEmpty(this.fansList);
    }

    /* loaded from: classes8.dex */
    public static class FansViewHolder extends RecyclerView.ViewHolder {
        public View containerView;
        public View dividerLine;
        public TextView ghV;
        public ClickableHeaderImageView jbb;
        public TextView jbc;

        public FansViewHolder(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.container_forbidden_item);
            this.jbb = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.jbb.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.jbb.setAutoChangeStyle(true);
            this.jbb.setClickable(false);
            this.ghV = (TextView) view.findViewById(R.id.view_fans_name);
            this.jbc = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(FansViewHolder fansViewHolder) {
        ap.setViewTextColor(fansViewHolder.ghV, R.color.CAM_X0105);
        ap.setBackgroundColor(fansViewHolder.dividerLine, R.color.CAM_X0204);
        ap.setViewTextColor(fansViewHolder.jbc, R.color.btn_color_remove);
        ap.setBackgroundResource(fansViewHolder.jbc, R.drawable.btn_transparent_focus_border_bg);
    }

    public void z(View.OnClickListener onClickListener) {
        this.jba = onClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.hlQ = onClickListener;
    }
}
