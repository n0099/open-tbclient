package com.baidu.tieba.homepage.personalize.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private com.baidu.tieba.homepage.personalize.data.f cZv;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cZv == null || this.cZv.dai == null) {
            return 0;
        }
        return this.cZv.dai.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lg */
    public com.baidu.tieba.homepage.personalize.data.g getItem(int i) {
        if (this.cZv == null || this.cZv.dai == null) {
            return null;
        }
        return this.cZv.dai.get(i);
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
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            textView = new TextView(viewGroup.getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.fontsize28));
            textView.setLayoutParams(new AbsListView.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds146), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60)));
        }
        com.baidu.tieba.homepage.personalize.data.g item = getItem(i);
        if (item != null) {
            textView.setText(item.tagName);
            if (item.isSelect) {
                aj.i(textView, d.e.cp_cont_g);
                aj.j(textView, d.g.shape_semi_circle_all_selected);
            } else {
                aj.i(textView, d.e.cp_cont_f);
                aj.j(textView, d.g.shape_semi_circle_all_line);
            }
        }
        return textView;
    }

    public void a(com.baidu.tieba.homepage.personalize.data.f fVar) {
        this.cZv = fVar;
        notifyDataSetChanged();
    }

    public com.baidu.tieba.homepage.personalize.data.f apF() {
        return this.cZv;
    }
}
