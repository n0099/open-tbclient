package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private List<TagInfo> cve = new ArrayList();
    private final int cvf;
    private Context mContext;
    private int padding;
    private int textSize;

    public q(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(r.f.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(r.f.ds16);
        this.cvf = i;
    }

    public void bs(List<TagInfo> list) {
        this.cve.clear();
        if (list != null && list.size() > 0) {
            this.cve.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cve.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kd */
    public TagInfo getItem(int i) {
        if (i < 0 || i >= this.cve.size()) {
            return null;
        }
        return this.cve.get(i);
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
        TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.w.c(this.cve, i);
        if (tagInfo == null) {
            return null;
        }
        textView.setText(at.d(tagInfo.tag_name, 8, null));
        ap.c(textView, r.e.cp_cont_f, 1);
        if (i == this.cvf) {
            ap.j((View) textView, r.g.btn_label_white_s);
            return textView;
        }
        ap.j((View) textView, r.g.rec_frs_btn_more_item);
        return textView;
    }
}
