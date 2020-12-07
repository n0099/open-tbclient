package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b extends BaseAdapter {
    private final int khN;
    private Context mContext;
    private int padding;
    private List<p> tagList = new ArrayList();
    private int textSize;

    public b(Context context, int i) {
        this.textSize = 0;
        this.padding = 0;
        this.mContext = context;
        this.textSize = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.padding = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.khN = i;
    }

    public void setTagList(List<p> list) {
        this.tagList.clear();
        if (list != null && list.size() > 0) {
            this.tagList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.tagList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DC */
    public p getItem(int i) {
        if (i < 0 || i >= this.tagList.size()) {
            return null;
        }
        return this.tagList.get(i);
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
        p pVar = (p) y.getItem(this.tagList, i);
        if (pVar == null) {
            return null;
        }
        textView.setText(au.cutChineseAndEnglishWithSuffix(pVar.tabName, 8, null));
        ap.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i == this.khN) {
            ap.setBackgroundResource(textView, R.drawable.btn_label_white_s);
            return textView;
        } else if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
            textView.setBackgroundResource(R.drawable.topic_btn_more_item_1);
            return textView;
        } else {
            textView.setBackgroundResource(R.drawable.topic_btn_more_item);
            return textView;
        }
    }
}
