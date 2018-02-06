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
        public View bQs;
        public TbImageView dqC;
        public TextView dqD;
        public TextView dqE;
        public TextView dqF;
        public View dqG;
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
    /* renamed from: mm */
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
            aVar.dqC = (TbImageView) inflate.findViewById(d.g.imageview_forum);
            aVar.dqD = (TextView) inflate.findViewById(d.g.textview_forum_name);
            aVar.dqE = (TextView) inflate.findViewById(d.g.textview_forum_concern_count);
            aVar.dqF = (TextView) inflate.findViewById(d.g.textview_forum_thread_count);
            aVar.dqG = inflate.findViewById(d.g.view_check_state);
            aVar.bQs = inflate.findViewById(d.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.dqC.startLoad(item.avatar, 10, false);
            aVar.dqD.setText(item.forumName);
            aVar.dqE.setText(String.format(this.mContext.getString(d.j.concern), am.C(item.followNum)));
            aVar.dqF.setText(String.format(this.mContext.getString(d.j.forum_thread_number), am.C(item.threadNum)));
            if (item.isSelected) {
                aj.s(aVar.dqG, d.f.icon_list_confirm_s);
            } else {
                aj.s(aVar.dqG, d.f.icon_jinba_confirm_n);
            }
            aj.r(aVar.dqD, d.C0140d.cp_cont_b);
            aj.r(aVar.dqE, d.C0140d.cp_cont_f);
            aj.r(aVar.dqF, d.C0140d.cp_cont_f);
            aj.t(aVar.bQs, d.C0140d.cp_bg_line_c);
        }
        return view2;
    }
}
