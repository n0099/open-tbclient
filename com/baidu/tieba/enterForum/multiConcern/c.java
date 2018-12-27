package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes4.dex */
    public static class a {
        public View dividerLine;
        public TbImageView dss;
        public TextView dst;
        public TextView dsu;
        public TextView dsv;
        public View dsw;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lB */
    public b getItem(int i) {
        return (b) v.d(this.mDatas, i);
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
            View inflate = LayoutInflater.from(this.mContext).inflate(e.h.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.dss = (TbImageView) inflate.findViewById(e.g.imageview_forum);
            aVar.dst = (TextView) inflate.findViewById(e.g.textview_forum_name);
            aVar.dsu = (TextView) inflate.findViewById(e.g.textview_forum_concern_count);
            aVar.dsv = (TextView) inflate.findViewById(e.g.textview_forum_thread_count);
            aVar.dsw = inflate.findViewById(e.g.view_check_state);
            aVar.dividerLine = inflate.findViewById(e.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.dss.startLoad(item.avatar, 10, false);
            aVar.dst.setText(item.forumName);
            aVar.dsu.setText(String.format(this.mContext.getString(e.j.concern), ao.Q(item.followNum)));
            aVar.dsv.setText(String.format(this.mContext.getString(e.j.forum_thread_number), ao.Q(item.threadNum)));
            if (item.isSelected) {
                al.i(aVar.dsw, e.f.icon_list_confirm_s);
            } else {
                al.i(aVar.dsw, e.f.icon_jinba_confirm_n);
            }
            al.h(aVar.dst, e.d.cp_cont_b);
            al.h(aVar.dsu, e.d.cp_cont_f);
            al.h(aVar.dsv, e.d.cp_cont_f);
            al.j(aVar.dividerLine, e.d.cp_bg_line_c);
        }
        return view2;
    }
}
