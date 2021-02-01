package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {
    public View bQV;
    public View bQW;
    public ImageView jrV;
    public TextView jrW;
    public ImageView jrX;
    public TextView mTitleTv;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.jrV = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.jrW = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.jrX = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bQV = view.findViewById(R.id.top_divider_line);
            this.bQW = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
