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
        public TbImageView dpC;
        public TextView dpD;
        public TextView dpE;
        public TextView dpF;
        public View dpG;
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
    /* renamed from: lo */
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
            aVar.dpC = (TbImageView) inflate.findViewById(e.g.imageview_forum);
            aVar.dpD = (TextView) inflate.findViewById(e.g.textview_forum_name);
            aVar.dpE = (TextView) inflate.findViewById(e.g.textview_forum_concern_count);
            aVar.dpF = (TextView) inflate.findViewById(e.g.textview_forum_thread_count);
            aVar.dpG = inflate.findViewById(e.g.view_check_state);
            aVar.dividerLine = inflate.findViewById(e.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.dpC.startLoad(item.avatar, 10, false);
            aVar.dpD.setText(item.forumName);
            aVar.dpE.setText(String.format(this.mContext.getString(e.j.concern), ao.P(item.followNum)));
            aVar.dpF.setText(String.format(this.mContext.getString(e.j.forum_thread_number), ao.P(item.threadNum)));
            if (item.isSelected) {
                al.i(aVar.dpG, e.f.icon_list_confirm_s);
            } else {
                al.i(aVar.dpG, e.f.icon_jinba_confirm_n);
            }
            al.h(aVar.dpD, e.d.cp_cont_b);
            al.h(aVar.dpE, e.d.cp_cont_f);
            al.h(aVar.dpF, e.d.cp_cont_f);
            al.j(aVar.dividerLine, e.d.cp_bg_line_c);
        }
        return view2;
    }
}
