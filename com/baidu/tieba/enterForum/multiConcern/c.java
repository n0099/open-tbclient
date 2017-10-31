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
        public View aWS;
        public TbImageView cld;
        public TextView cle;
        public TextView clf;
        public TextView clg;
        public View clh;
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
    /* renamed from: iQ */
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
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.cld = (TbImageView) inflate.findViewById(d.g.imageview_forum);
            aVar.cle = (TextView) inflate.findViewById(d.g.textview_forum_name);
            aVar.clf = (TextView) inflate.findViewById(d.g.textview_forum_concern_count);
            aVar.clg = (TextView) inflate.findViewById(d.g.textview_forum_thread_count);
            aVar.clh = inflate.findViewById(d.g.view_check_state);
            aVar.aWS = inflate.findViewById(d.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cld.startLoad(item.avatar, 10, false);
            aVar.cle.setText(item.forumName);
            aVar.clf.setText(String.format(this.mContext.getString(d.j.concern), am.u(item.followNum)));
            aVar.clg.setText(String.format(this.mContext.getString(d.j.forum_thread_number), am.u(item.threadNum)));
            if (item.isSelected) {
                aj.j(aVar.clh, d.f.icon_list_confirm_s);
            } else {
                aj.j(aVar.clh, d.f.icon_jinba_confirm_n);
            }
            aj.i(aVar.cle, d.C0080d.cp_cont_b);
            aj.i(aVar.clf, d.C0080d.cp_cont_f);
            aj.i(aVar.clg, d.C0080d.cp_cont_f);
            aj.k(aVar.aWS, d.C0080d.cp_bg_line_c);
        }
        return view2;
    }
}
