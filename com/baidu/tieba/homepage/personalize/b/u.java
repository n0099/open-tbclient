package com.baidu.tieba.homepage.personalize.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private com.baidu.tieba.homepage.personalize.data.f cAw;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cAw == null || this.cAw.cBm == null) {
            return 0;
        }
        return this.cAw.cBm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jZ */
    public com.baidu.tieba.homepage.personalize.data.g getItem(int i) {
        if (this.cAw == null || this.cAw.cBm == null) {
            return null;
        }
        return this.cAw.cBm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10);
            textView = new TextView(viewGroup.getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize28));
            textView.setLayoutParams(new AbsListView.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds146), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60)));
        }
        com.baidu.tieba.homepage.personalize.data.g item = getItem(i);
        if (item != null) {
            textView.setText(item.Uw);
            if (item.cBo) {
                aq.i(textView, w.e.cp_cont_g);
                aq.j(textView, w.g.shape_semi_circle_all_selected);
            } else {
                aq.i(textView, w.e.cp_cont_f);
                aq.j(textView, w.g.shape_semi_circle_all_line);
            }
        }
        return textView;
    }

    public void a(com.baidu.tieba.homepage.personalize.data.f fVar) {
        this.cAw = fVar;
        notifyDataSetChanged();
    }

    public com.baidu.tieba.homepage.personalize.data.f akC() {
        return this.cAw;
    }
}
