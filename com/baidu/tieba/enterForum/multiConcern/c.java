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
        public View bjR;
        public TbImageView cRf;
        public TextView cRg;
        public TextView cRh;
        public TextView cRi;
        public View cRj;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.z(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jy */
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
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.cRf = (TbImageView) inflate.findViewById(d.g.imageview_forum);
            aVar.cRg = (TextView) inflate.findViewById(d.g.textview_forum_name);
            aVar.cRh = (TextView) inflate.findViewById(d.g.textview_forum_concern_count);
            aVar.cRi = (TextView) inflate.findViewById(d.g.textview_forum_thread_count);
            aVar.cRj = inflate.findViewById(d.g.view_check_state);
            aVar.bjR = inflate.findViewById(d.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cRf.startLoad(item.avatar, 10, false);
            aVar.cRg.setText(item.forumName);
            aVar.cRh.setText(String.format(this.mContext.getString(d.k.concern), ap.z(item.followNum)));
            aVar.cRi.setText(String.format(this.mContext.getString(d.k.forum_thread_number), ap.z(item.threadNum)));
            if (item.isSelected) {
                am.i(aVar.cRj, d.f.icon_list_confirm_s);
            } else {
                am.i(aVar.cRj, d.f.icon_jinba_confirm_n);
            }
            am.h(aVar.cRg, d.C0142d.cp_cont_b);
            am.h(aVar.cRh, d.C0142d.cp_cont_f);
            am.h(aVar.cRi, d.C0142d.cp_cont_f);
            am.j(aVar.bjR, d.C0142d.cp_bg_line_c);
        }
        return view2;
    }
}
