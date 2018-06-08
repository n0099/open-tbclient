package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes2.dex */
    public static class a {
        public View bir;
        public TbImageView cTh;
        public TextView cTi;
        public TextView cTj;
        public TextView cTk;
        public View cTl;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jA */
    public b getItem(int i) {
        return (b) w.c(this.mDatas, i);
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
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.cTh = (TbImageView) inflate.findViewById(d.g.imageview_forum);
            aVar.cTi = (TextView) inflate.findViewById(d.g.textview_forum_name);
            aVar.cTj = (TextView) inflate.findViewById(d.g.textview_forum_concern_count);
            aVar.cTk = (TextView) inflate.findViewById(d.g.textview_forum_thread_count);
            aVar.cTl = inflate.findViewById(d.g.view_check_state);
            aVar.bir = inflate.findViewById(d.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cTh.startLoad(item.avatar, 10, false);
            aVar.cTi.setText(item.forumName);
            aVar.cTj.setText(String.format(this.mContext.getString(d.k.concern), ao.y(item.followNum)));
            aVar.cTk.setText(String.format(this.mContext.getString(d.k.forum_thread_number), ao.y(item.threadNum)));
            if (item.isSelected) {
                al.i(aVar.cTl, d.f.icon_list_confirm_s);
            } else {
                al.i(aVar.cTl, d.f.icon_jinba_confirm_n);
            }
            al.h(aVar.cTi, d.C0141d.cp_cont_b);
            al.h(aVar.cTj, d.C0141d.cp_cont_f);
            al.h(aVar.cTk, d.C0141d.cp_cont_f);
            al.j(aVar.bir, d.C0141d.cp_bg_line_c);
        }
        return view2;
    }
}
