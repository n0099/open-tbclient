package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private Context mContext;
    private List<g> mDatas;

    /* loaded from: classes.dex */
    public static class a {
        public View aTe;
        public TbImageView bUa;
        public TextView bUb;
        public TextView bUc;
        public TextView bUd;
        public View bUe;
    }

    public h(Context context) {
        this.mContext = context;
    }

    public void setData(List<g> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return z.s(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hY */
    public g getItem(int i) {
        return (g) z.c(this.mDatas, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        g item = getItem(i);
        if (view != null && view.getTag() != null) {
            aVar = (a) view.getTag();
            view2 = view;
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.bUa = (TbImageView) inflate.findViewById(w.h.imageview_forum);
            aVar.bUb = (TextView) inflate.findViewById(w.h.textview_forum_name);
            aVar.bUc = (TextView) inflate.findViewById(w.h.textview_forum_concern_count);
            aVar.bUd = (TextView) inflate.findViewById(w.h.textview_forum_thread_count);
            aVar.bUe = inflate.findViewById(w.h.view_check_state);
            aVar.aTe = inflate.findViewById(w.h.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.bUa.c(item.avatar, 10, false);
            aVar.bUb.setText(item.forumName);
            aVar.bUc.setText(String.format(this.mContext.getString(w.l.forum_concern_number), aw.t(item.followNum)));
            aVar.bUd.setText(String.format(this.mContext.getString(w.l.forum_thread_number), aw.t(item.threadNum)));
            if (item.isSelected) {
                as.j(aVar.bUe, w.g.icon_list_confirm_s);
            } else {
                as.j(aVar.bUe, w.g.icon_jinba_confirm_n);
            }
            as.i(aVar.bUb, w.e.cp_cont_b);
            as.i(aVar.bUc, w.e.cp_cont_f);
            as.i(aVar.bUd, w.e.cp_cont_f);
            as.k(aVar.aTe, w.e.cp_bg_line_c);
        }
        return view2;
    }
}
