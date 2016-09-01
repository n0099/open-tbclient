package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private List<TagInfo> cCP = new ArrayList();
    private final int cCQ;
    private Context mContext;
    private int padding;
    private int textSize;

    public q(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(t.e.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(t.e.ds16);
        this.cCQ = i;
    }

    public void bs(List<TagInfo> list) {
        this.cCP.clear();
        if (list != null && list.size() > 0) {
            this.cCP.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cCP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jS */
    public TagInfo getItem(int i) {
        if (i < 0 || i >= this.cCP.size()) {
            return null;
        }
        return this.cCP.get(i);
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
        TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(this.cCP, i);
        if (tagInfo == null) {
            return null;
        }
        textView.setText(ba.d(tagInfo.tag_name, 8, null));
        av.c(textView, t.d.cp_cont_f, 1);
        if (i == this.cCQ) {
            av.k(textView, t.f.btn_label_white_s);
            return textView;
        }
        av.k(textView, t.f.rec_frs_btn_more_item);
        return textView;
    }
}
