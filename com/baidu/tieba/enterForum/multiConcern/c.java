package com.baidu.tieba.enterForum.multiConcern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes4.dex */
    public static class a {
        public View dividerLine;
        public TbImageView eYR;
        public TextView eYS;
        public TextView eYT;
        public TextView eYU;
        public View eYV;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void setData(List<b> list) {
        this.mDatas = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qB */
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
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.eYR = (TbImageView) inflate.findViewById(R.id.imageview_forum);
            aVar.eYS = (TextView) inflate.findViewById(R.id.textview_forum_name);
            aVar.eYT = (TextView) inflate.findViewById(R.id.textview_forum_concern_count);
            aVar.eYU = (TextView) inflate.findViewById(R.id.textview_forum_thread_count);
            aVar.eYV = inflate.findViewById(R.id.view_check_state);
            aVar.dividerLine = inflate.findViewById(R.id.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.eYR.startLoad(item.avatar, 10, false);
            aVar.eYS.setText(item.forumName);
            aVar.eYT.setText(String.format(this.mContext.getString(R.string.concern), aq.aH(item.followNum)));
            aVar.eYU.setText(String.format(this.mContext.getString(R.string.forum_thread_number), aq.aH(item.threadNum)));
            if (item.isSelected) {
                am.k(aVar.eYV, R.drawable.icon_list_confirm_s);
            } else {
                am.k(aVar.eYV, R.drawable.icon_jinba_confirm_n);
            }
            am.j(aVar.eYS, R.color.cp_cont_b);
            am.j(aVar.eYT, R.color.cp_cont_f);
            am.j(aVar.eYU, R.color.cp_cont_f);
            am.l(aVar.dividerLine, R.color.cp_bg_line_c);
        }
        return view2;
    }
}
