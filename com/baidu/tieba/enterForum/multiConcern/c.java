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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private List<b> mDatas;

    /* loaded from: classes2.dex */
    public static class a {
        public TbImageView cTO;
        public TextView cTP;
        public TextView cTQ;
        public TextView cTR;
        public View cTS;
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
        return w.y(this.mDatas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jJ */
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
            View inflate = LayoutInflater.from(this.mContext).inflate(f.h.item_recommend_forum_by_tag, viewGroup, false);
            aVar = new a();
            aVar.cTO = (TbImageView) inflate.findViewById(f.g.imageview_forum);
            aVar.cTP = (TextView) inflate.findViewById(f.g.textview_forum_name);
            aVar.cTQ = (TextView) inflate.findViewById(f.g.textview_forum_concern_count);
            aVar.cTR = (TextView) inflate.findViewById(f.g.textview_forum_thread_count);
            aVar.cTS = inflate.findViewById(f.g.view_check_state);
            aVar.dividerLine = inflate.findViewById(f.g.view_bottom_line);
            inflate.setTag(aVar);
            view2 = inflate;
        }
        if (item != null) {
            aVar.cTO.startLoad(item.avatar, 10, false);
            aVar.cTP.setText(item.forumName);
            aVar.cTQ.setText(String.format(this.mContext.getString(f.j.concern), ap.A(item.followNum)));
            aVar.cTR.setText(String.format(this.mContext.getString(f.j.forum_thread_number), ap.A(item.threadNum)));
            if (item.isSelected) {
                am.i(aVar.cTS, f.C0146f.icon_list_confirm_s);
            } else {
                am.i(aVar.cTS, f.C0146f.icon_jinba_confirm_n);
            }
            am.h(aVar.cTP, f.d.cp_cont_b);
            am.h(aVar.cTQ, f.d.cp_cont_f);
            am.h(aVar.cTR, f.d.cp_cont_f);
            am.j(aVar.dividerLine, f.d.cp_bg_line_c);
        }
        return view2;
    }
}
