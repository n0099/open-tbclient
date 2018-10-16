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
        public TbImageView dhU;
        public TextView dhV;
        public TextView dhW;
        public TextView dhX;
        public View dhY;
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
        return v.I(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kG */
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
            aVar.dhU = (TbImageView) inflate.findViewById(e.g.imageview_forum);
            aVar.dhV = (TextView) inflate.findViewById(e.g.textview_forum_name);
            aVar.dhW = (TextView) inflate.findViewById(e.g.textview_forum_concern_count);
            aVar.dhX = (TextView) inflate.findViewById(e.g.textview_forum_thread_count);
            aVar.dhY = inflate.findViewById(e.g.view_check_state);
            aVar.dividerLine = inflate.findViewById(e.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.dhU.startLoad(item.avatar, 10, false);
            aVar.dhV.setText(item.forumName);
            aVar.dhW.setText(String.format(this.mContext.getString(e.j.concern), ao.G(item.followNum)));
            aVar.dhX.setText(String.format(this.mContext.getString(e.j.forum_thread_number), ao.G(item.threadNum)));
            if (item.isSelected) {
                al.i(aVar.dhY, e.f.icon_list_confirm_s);
            } else {
                al.i(aVar.dhY, e.f.icon_jinba_confirm_n);
            }
            al.h(aVar.dhV, e.d.cp_cont_b);
            al.h(aVar.dhW, e.d.cp_cont_f);
            al.h(aVar.dhX, e.d.cp_cont_f);
            al.j(aVar.dividerLine, e.d.cp_bg_line_c);
        }
        return view2;
    }
}
