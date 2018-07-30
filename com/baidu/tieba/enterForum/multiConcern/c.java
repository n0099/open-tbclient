package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
        public View bkw;
        public TbImageView cTS;
        public TextView cTT;
        public TextView cTU;
        public TextView cTV;
        public View cTW;
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
    /* renamed from: jK */
    public b getItem(int i) {
        return (b) w.d(this.mDatas, i);
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
            aVar.cTS = (TbImageView) inflate.findViewById(d.g.imageview_forum);
            aVar.cTT = (TextView) inflate.findViewById(d.g.textview_forum_name);
            aVar.cTU = (TextView) inflate.findViewById(d.g.textview_forum_concern_count);
            aVar.cTV = (TextView) inflate.findViewById(d.g.textview_forum_thread_count);
            aVar.cTW = inflate.findViewById(d.g.view_check_state);
            aVar.bkw = inflate.findViewById(d.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cTS.startLoad(item.avatar, 10, false);
            aVar.cTT.setText(item.forumName);
            aVar.cTU.setText(String.format(this.mContext.getString(d.j.concern), ap.A(item.followNum)));
            aVar.cTV.setText(String.format(this.mContext.getString(d.j.forum_thread_number), ap.A(item.threadNum)));
            if (item.isSelected) {
                am.i(aVar.cTW, d.f.icon_list_confirm_s);
            } else {
                am.i(aVar.cTW, d.f.icon_jinba_confirm_n);
            }
            am.h(aVar.cTT, d.C0140d.cp_cont_b);
            am.h(aVar.cTU, d.C0140d.cp_cont_f);
            am.h(aVar.cTV, d.C0140d.cp_cont_f);
            am.j(aVar.bkw, d.C0140d.cp_bg_line_c);
        }
        return view2;
    }
}
