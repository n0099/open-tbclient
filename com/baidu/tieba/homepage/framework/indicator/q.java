package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private List<TagInfo> crH = new ArrayList();
    private final int crI;
    private Context mContext;
    private int padding;
    private int textSize;

    public q(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(u.e.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(u.e.ds16);
        this.crI = i;
    }

    public void bq(List<TagInfo> list) {
        this.crH.clear();
        if (list != null && list.size() > 0) {
            this.crH.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.crH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jq */
    public TagInfo getItem(int i) {
        if (i < 0 || i >= this.crH.size()) {
            return null;
        }
        return this.crH.get(i);
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
        TagInfo tagInfo = (TagInfo) com.baidu.tbadk.core.util.y.c(this.crH, i);
        if (tagInfo == null) {
            return null;
        }
        textView.setText(ba.d(tagInfo.tag_name, 8, null));
        av.c(textView, u.d.cp_cont_f, 1);
        if (i == this.crI) {
            av.k(textView, u.f.btn_label_white_s);
            return textView;
        }
        av.k(textView, u.f.rec_frs_btn_more_item);
        return textView;
    }
}
