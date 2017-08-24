package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes.dex */
    public static class a {
        public View aVv;
        public TbImageView cah;
        public TextView cai;
        public TextView caj;
        public TextView cak;
        public View cal;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return u.u(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ih */
    public b getItem(int i) {
        return (b) u.c(this.mDatas, i);
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
            aVar.cah = (TbImageView) inflate.findViewById(d.h.imageview_forum);
            aVar.cai = (TextView) inflate.findViewById(d.h.textview_forum_name);
            aVar.caj = (TextView) inflate.findViewById(d.h.textview_forum_concern_count);
            aVar.cak = (TextView) inflate.findViewById(d.h.textview_forum_thread_count);
            aVar.cal = inflate.findViewById(d.h.view_check_state);
            aVar.aVv = inflate.findViewById(d.h.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cah.c(item.avatar, 10, false);
            aVar.cai.setText(item.forumName);
            aVar.caj.setText(String.format(this.mContext.getString(d.l.forum_concern_number), al.u(item.followNum)));
            aVar.cak.setText(String.format(this.mContext.getString(d.l.forum_thread_number), al.u(item.threadNum)));
            if (item.isSelected) {
                ai.j(aVar.cal, d.g.icon_list_confirm_s);
            } else {
                ai.j(aVar.cal, d.g.icon_jinba_confirm_n);
            }
            ai.i(aVar.cai, d.e.cp_cont_b);
            ai.i(aVar.caj, d.e.cp_cont_f);
            ai.i(aVar.cak, d.e.cp_cont_f);
            ai.k(aVar.aVv, d.e.cp_bg_line_c);
        }
        return view2;
    }
}
