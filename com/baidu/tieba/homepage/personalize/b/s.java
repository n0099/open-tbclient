package com.baidu.tieba.homepage.personalize.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private com.baidu.tieba.homepage.personalize.data.f crf;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.crf == null || this.crf.crT == null) {
            return 0;
        }
        return this.crf.crT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jB */
    public com.baidu.tieba.homepage.personalize.data.g getItem(int i) {
        if (this.crf == null || this.crf.crT == null) {
            return null;
        }
        return this.crf.crT.get(i);
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
        com.baidu.tieba.homepage.personalize.data.g item = getItem(i);
        if (item != null) {
            textView.setText(item.PR);
            if (item.crV) {
                ar.j((View) textView, r.d.cp_cont_g);
                ar.k(textView, r.f.shape_semi_circle_all_selected);
            } else {
                ar.j((View) textView, r.d.cp_cont_f);
                ar.k(textView, r.f.shape_semi_circle_all_line);
            }
        }
        return textView;
    }

    public void a(com.baidu.tieba.homepage.personalize.data.f fVar) {
        this.crf = fVar;
        notifyDataSetChanged();
    }

    public com.baidu.tieba.homepage.personalize.data.f ajo() {
        return this.crf;
    }
}
