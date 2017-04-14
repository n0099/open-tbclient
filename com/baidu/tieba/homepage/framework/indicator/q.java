package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private List<TagInfo> cvd = new ArrayList();
    private final int cve;
    private Context mContext;
    private int padding;
    private int textSize;

    public q(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(w.f.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(w.f.ds16);
        this.cve = i;
    }

    public void aY(List<TagInfo> list) {
        this.cvd.clear();
        if (list != null && list.size() > 0) {
            this.cvd.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cvd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jJ */
    public TagInfo getItem(int i) {
        if (i < 0 || i >= this.cvd.size()) {
            return null;
        }
        return this.cvd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.mContext);
            textView.setGravity(17);
            textView.setTextSize(0, this.textSize);
            textView.setPadding(0, this.padding, 0, this.padding);
        }
        TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.x.c(this.cvd, i);
        if (tagInfo == null) {
            return null;
        }
        textView.setText(au.d(tagInfo.tag_name, 8, null));
        aq.c(textView, w.e.cp_cont_f, 1);
        if (i == this.cve) {
            aq.j(textView, w.g.btn_label_white_s);
            return textView;
        }
        aq.j(textView, w.g.rec_frs_btn_more_item);
        return textView;
    }
}
