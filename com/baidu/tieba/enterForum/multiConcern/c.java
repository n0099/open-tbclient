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
        public TbImageView diZ;
        public View dividerLine;
        public TextView dja;
        public TextView djb;
        public TextView djc;
        public View djd;
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
    /* renamed from: kY */
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
            aVar.diZ = (TbImageView) inflate.findViewById(e.g.imageview_forum);
            aVar.dja = (TextView) inflate.findViewById(e.g.textview_forum_name);
            aVar.djb = (TextView) inflate.findViewById(e.g.textview_forum_concern_count);
            aVar.djc = (TextView) inflate.findViewById(e.g.textview_forum_thread_count);
            aVar.djd = inflate.findViewById(e.g.view_check_state);
            aVar.dividerLine = inflate.findViewById(e.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.diZ.startLoad(item.avatar, 10, false);
            aVar.dja.setText(item.forumName);
            aVar.djb.setText(String.format(this.mContext.getString(e.j.concern), ao.I(item.followNum)));
            aVar.djc.setText(String.format(this.mContext.getString(e.j.forum_thread_number), ao.I(item.threadNum)));
            if (item.isSelected) {
                al.i(aVar.djd, e.f.icon_list_confirm_s);
            } else {
                al.i(aVar.djd, e.f.icon_jinba_confirm_n);
            }
            al.h(aVar.dja, e.d.cp_cont_b);
            al.h(aVar.djb, e.d.cp_cont_f);
            al.h(aVar.djc, e.d.cp_cont_f);
            al.j(aVar.dividerLine, e.d.cp_bg_line_c);
        }
        return view2;
    }
}
