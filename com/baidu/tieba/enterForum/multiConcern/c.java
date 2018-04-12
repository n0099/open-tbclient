package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
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
        public View bae;
        public TbImageView cIV;
        public TextView cIW;
        public TextView cIX;
        public TextView cIY;
        public View cIZ;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jz */
    public b getItem(int i) {
        return (b) v.c(this.mDatas, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        View view3;
        b item = getItem(i);
        if (view2 != null && view2.getTag() != null) {
            aVar = (a) view2.getTag();
            view3 = view2;
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.i.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.cIV = (TbImageView) inflate.findViewById(d.g.imageview_forum);
            aVar.cIW = (TextView) inflate.findViewById(d.g.textview_forum_name);
            aVar.cIX = (TextView) inflate.findViewById(d.g.textview_forum_concern_count);
            aVar.cIY = (TextView) inflate.findViewById(d.g.textview_forum_thread_count);
            aVar.cIZ = inflate.findViewById(d.g.view_check_state);
            aVar.bae = inflate.findViewById(d.g.view_bottom_line);
            inflate.setTag(aVar);
            view3 = inflate;
        }
        if (item != null) {
            aVar.cIV.startLoad(item.avatar, 10, false);
            aVar.cIW.setText(item.forumName);
            aVar.cIX.setText(String.format(this.mContext.getString(d.k.concern), an.v(item.followNum)));
            aVar.cIY.setText(String.format(this.mContext.getString(d.k.forum_thread_number), an.v(item.threadNum)));
            if (item.isSelected) {
                ak.i(aVar.cIZ, d.f.icon_list_confirm_s);
            } else {
                ak.i(aVar.cIZ, d.f.icon_jinba_confirm_n);
            }
            ak.h(aVar.cIW, d.C0126d.cp_cont_b);
            ak.h(aVar.cIX, d.C0126d.cp_cont_f);
            ak.h(aVar.cIY, d.C0126d.cp_cont_f);
            ak.j(aVar.bae, d.C0126d.cp_bg_line_c);
        }
        return view3;
    }
}
