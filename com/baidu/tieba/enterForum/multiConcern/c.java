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
        public View aVb;
        public TbImageView cdT;
        public TextView cdU;
        public TextView cdV;
        public TextView cdW;
        public View cdX;
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
    /* renamed from: it */
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
            aVar.cdT = (TbImageView) inflate.findViewById(d.h.imageview_forum);
            aVar.cdU = (TextView) inflate.findViewById(d.h.textview_forum_name);
            aVar.cdV = (TextView) inflate.findViewById(d.h.textview_forum_concern_count);
            aVar.cdW = (TextView) inflate.findViewById(d.h.textview_forum_thread_count);
            aVar.cdX = inflate.findViewById(d.h.view_check_state);
            aVar.aVb = inflate.findViewById(d.h.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cdT.c(item.avatar, 10, false);
            aVar.cdU.setText(item.forumName);
            aVar.cdV.setText(String.format(this.mContext.getString(d.l.concern), am.u(item.followNum)));
            aVar.cdW.setText(String.format(this.mContext.getString(d.l.forum_thread_number), am.u(item.threadNum)));
            if (item.isSelected) {
                aj.j(aVar.cdX, d.g.icon_list_confirm_s);
            } else {
                aj.j(aVar.cdX, d.g.icon_jinba_confirm_n);
            }
            aj.i(aVar.cdU, d.e.cp_cont_b);
            aj.i(aVar.cdV, d.e.cp_cont_f);
            aj.i(aVar.cdW, d.e.cp_cont_f);
            aj.k(aVar.aVb, d.e.cp_bg_line_c);
        }
        return view2;
    }
}
