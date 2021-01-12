package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class HotTopicIntervalItemHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public View knD;
    public TextView knE;

    public HotTopicIntervalItemHolder(View view) {
        super(view);
        this.akf = 3;
        this.knD = null;
        this.knE = null;
        dl(view);
    }

    private void dl(View view) {
        if (view != null) {
            this.knD = view.findViewById(R.id.top_divider_line);
            this.knE = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
