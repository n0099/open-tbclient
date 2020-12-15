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
    private View.OnClickListener iNP = null;
    private View.OnClickListener hat = null;

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
        com.baidu.tieba.forbidden.fans.a zp;
        if (aVar != null && (zp = zp(i)) != null) {
            aVar.iNQ.startLoad(zp.portrait, 12, false);
            aVar.gaX.setText(zp.nameShow);
            aVar.iNR.setOnClickListener(this.iNP);
            aVar.iNR.setTag(zp);
            aVar.containerView.setOnClickListener(this.hat);
            aVar.containerView.setTag(zp);
            a(aVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.fansList);
    }

    private com.baidu.tieba.forbidden.fans.a zp(int i) {
        return (com.baidu.tieba.forbidden.fans.a) y.getItem(this.fansList, i);
    }

    public void aw(ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList) {
        this.fansList = arrayList;
    }

    public ArrayList<com.baidu.tieba.forbidden.fans.a> getFansList() {
        return this.fansList;
    }

    public boolean gh(long j) {
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

    public boolean cAl() {
        return y.isEmpty(this.fansList);
    }

    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        public View containerView;
        public View dividerLine;
        public TextView gaX;
        public ClickableHeaderImageView iNQ;
        public TextView iNR;

        public a(View view) {
            super(view);
            this.containerView = view.findViewById(R.id.container_forbidden_item);
            this.iNQ = (ClickableHeaderImageView) view.findViewById(R.id.view_fans_photo);
            this.iNQ.setRadius(l.getDimens(view.getContext(), R.dimen.ds90));
            this.iNQ.setAutoChangeStyle(true);
            this.iNQ.setClickable(false);
            this.gaX = (TextView) view.findViewById(R.id.view_fans_name);
            this.iNR = (TextView) view.findViewById(R.id.view_fans_remove);
            this.dividerLine = view.findViewById(R.id.line_divider);
        }
    }

    private void a(a aVar) {
        ap.setViewTextColor(aVar.gaX, R.color.CAM_X0105);
        ap.setBackgroundColor(aVar.dividerLine, R.color.CAM_X0204);
        ap.setViewTextColor(aVar.iNR, R.color.btn_color_remove);
        ap.setBackgroundResource(aVar.iNR, R.drawable.btn_transparent_focus_border_bg);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iNP = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.hat = onClickListener;
    }
}
