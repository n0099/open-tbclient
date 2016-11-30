package com.baidu.tieba.homepage.personalize.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends BaseAdapter {
    private com.baidu.tieba.homepage.personalize.data.h cLV;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cLV == null || this.cLV.cMO == null) {
            return 0;
        }
        return this.cLV.cMO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kq */
    public com.baidu.tieba.homepage.personalize.data.i getItem(int i) {
        if (this.cLV == null || this.cLV.cMO == null) {
            return null;
        }
        return this.cLV.cMO.get(i);
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
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10);
            textView = new TextView(viewGroup.getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.fontsize28));
            textView.setLayoutParams(new AbsListView.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds146), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds60)));
        }
        com.baidu.tieba.homepage.personalize.data.i item = getItem(i);
        if (item != null) {
            textView.setText(item.PW);
            if (item.cMQ) {
                at.j((View) textView, r.d.cp_cont_g);
                at.k(textView, r.f.shape_semi_circle_all_selected);
            } else {
                at.j((View) textView, r.d.cp_cont_f);
                at.k(textView, r.f.shape_semi_circle_all_line);
            }
        }
        return textView;
    }

    public void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
        this.cLV = hVar;
        notifyDataSetChanged();
    }

    public com.baidu.tieba.homepage.personalize.data.h aoN() {
        return this.cLV;
    }
}
