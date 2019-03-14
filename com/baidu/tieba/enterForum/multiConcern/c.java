package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes4.dex */
    public static class a {
        public View dividerLine;
        public TbImageView eEj;
        public TextView eEk;
        public TextView eEl;
        public TextView eEm;
        public View eEn;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pi */
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
            aVar.eEj = (TbImageView) inflate.findViewById(d.g.imageview_forum);
            aVar.eEk = (TextView) inflate.findViewById(d.g.textview_forum_name);
            aVar.eEl = (TextView) inflate.findViewById(d.g.textview_forum_concern_count);
            aVar.eEm = (TextView) inflate.findViewById(d.g.textview_forum_thread_count);
            aVar.eEn = inflate.findViewById(d.g.view_check_state);
            aVar.dividerLine = inflate.findViewById(d.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.eEj.startLoad(item.avatar, 10, false);
            aVar.eEk.setText(item.forumName);
            aVar.eEl.setText(String.format(this.mContext.getString(d.j.concern), ap.as(item.followNum)));
            aVar.eEm.setText(String.format(this.mContext.getString(d.j.forum_thread_number), ap.as(item.threadNum)));
            if (item.isSelected) {
                al.k(aVar.eEn, d.f.icon_list_confirm_s);
            } else {
                al.k(aVar.eEn, d.f.icon_jinba_confirm_n);
            }
            al.j(aVar.eEk, d.C0277d.cp_cont_b);
            al.j(aVar.eEl, d.C0277d.cp_cont_f);
            al.j(aVar.eEm, d.C0277d.cp_cont_f);
            al.l(aVar.dividerLine, d.C0277d.cp_bg_line_c);
        }
        return view2;
    }
}
