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
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes2.dex */
    public static class a {
        public TbImageView cZF;
        public TextView cZG;
        public TextView cZH;
        public TextView cZI;
        public View cZJ;
        public View dividerLine;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.y(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ki */
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
            aVar.cZF = (TbImageView) inflate.findViewById(e.g.imageview_forum);
            aVar.cZG = (TextView) inflate.findViewById(e.g.textview_forum_name);
            aVar.cZH = (TextView) inflate.findViewById(e.g.textview_forum_concern_count);
            aVar.cZI = (TextView) inflate.findViewById(e.g.textview_forum_thread_count);
            aVar.cZJ = inflate.findViewById(e.g.view_check_state);
            aVar.dividerLine = inflate.findViewById(e.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cZF.startLoad(item.avatar, 10, false);
            aVar.cZG.setText(item.forumName);
            aVar.cZH.setText(String.format(this.mContext.getString(e.j.concern), ao.E(item.followNum)));
            aVar.cZI.setText(String.format(this.mContext.getString(e.j.forum_thread_number), ao.E(item.threadNum)));
            if (item.isSelected) {
                al.i(aVar.cZJ, e.f.icon_list_confirm_s);
            } else {
                al.i(aVar.cZJ, e.f.icon_jinba_confirm_n);
            }
            al.h(aVar.cZG, e.d.cp_cont_b);
            al.h(aVar.cZH, e.d.cp_cont_f);
            al.h(aVar.cZI, e.d.cp_cont_f);
            al.j(aVar.dividerLine, e.d.cp_bg_line_c);
        }
        return view2;
    }
}
