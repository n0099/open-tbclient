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
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes2.dex */
    public static class a {
        public View bOc;
        public TbImageView dnn;
        public TextView dno;
        public TextView dnp;
        public TextView dnq;
        public View dnr;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.D(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mp */
    public b getItem(int i) {
        return (b) v.f(this.mDatas, i);
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
            aVar.dnn = (TbImageView) inflate.findViewById(d.g.imageview_forum);
            aVar.dno = (TextView) inflate.findViewById(d.g.textview_forum_name);
            aVar.dnp = (TextView) inflate.findViewById(d.g.textview_forum_concern_count);
            aVar.dnq = (TextView) inflate.findViewById(d.g.textview_forum_thread_count);
            aVar.dnr = inflate.findViewById(d.g.view_check_state);
            aVar.bOc = inflate.findViewById(d.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.dnn.startLoad(item.avatar, 10, false);
            aVar.dno.setText(item.forumName);
            aVar.dnp.setText(String.format(this.mContext.getString(d.j.concern), am.C(item.followNum)));
            aVar.dnq.setText(String.format(this.mContext.getString(d.j.forum_thread_number), am.C(item.threadNum)));
            if (item.isSelected) {
                aj.s(aVar.dnr, d.f.icon_list_confirm_s);
            } else {
                aj.s(aVar.dnr, d.f.icon_jinba_confirm_n);
            }
            aj.r(aVar.dno, d.C0107d.cp_cont_b);
            aj.r(aVar.dnp, d.C0107d.cp_cont_f);
            aj.r(aVar.dnq, d.C0107d.cp_cont_f);
            aj.t(aVar.bOc, d.C0107d.cp_bg_line_c);
        }
        return view2;
    }
}
