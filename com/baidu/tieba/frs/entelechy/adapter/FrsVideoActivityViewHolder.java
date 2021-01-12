package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {
    public View bNf;
    public View bNg;
    public ImageView jmo;
    public TextView jmq;
    public ImageView jmr;
    public TextView mTitleTv;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.jmo = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.jmq = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.jmr = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bNf = view.findViewById(R.id.top_divider_line);
            this.bNg = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
