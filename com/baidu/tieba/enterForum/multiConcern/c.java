package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes.dex */
    public static class a {
        public View aVe;
        public TbImageView cdb;
        public TextView cdc;
        public TextView cdd;
        public TextView cde;
        public View cdf;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.u(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ir */
    public b getItem(int i) {
        return (b) v.c(this.mDatas, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        b item = getItem(i);
        if (view != null && view.getTag() != null) {
            aVar = (a) view.getTag();
            view2 = view;
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.cdb = (TbImageView) inflate.findViewById(d.h.imageview_forum);
            aVar.cdc = (TextView) inflate.findViewById(d.h.textview_forum_name);
            aVar.cdd = (TextView) inflate.findViewById(d.h.textview_forum_concern_count);
            aVar.cde = (TextView) inflate.findViewById(d.h.textview_forum_thread_count);
            aVar.cdf = inflate.findViewById(d.h.view_check_state);
            aVar.aVe = inflate.findViewById(d.h.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cdb.c(item.avatar, 10, false);
            aVar.cdc.setText(item.forumName);
            aVar.cdd.setText(String.format(this.mContext.getString(d.l.concern), am.u(item.followNum)));
            aVar.cde.setText(String.format(this.mContext.getString(d.l.forum_thread_number), am.u(item.threadNum)));
            if (item.isSelected) {
                aj.j(aVar.cdf, d.g.icon_list_confirm_s);
            } else {
                aj.j(aVar.cdf, d.g.icon_jinba_confirm_n);
            }
            aj.i(aVar.cdc, d.e.cp_cont_b);
            aj.i(aVar.cdd, d.e.cp_cont_f);
            aj.i(aVar.cde, d.e.cp_cont_f);
            aj.k(aVar.aVe, d.e.cp_bg_line_c);
        }
        return view2;
    }
}
