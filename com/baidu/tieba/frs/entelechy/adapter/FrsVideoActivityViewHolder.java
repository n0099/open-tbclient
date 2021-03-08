package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {
    public View bSv;
    public View bSw;
    public ImageView jtS;
    public TextView jtT;
    public ImageView jtU;
    public TextView mTitleTv;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.jtS = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.jtT = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.jtU = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bSv = view.findViewById(R.id.top_divider_line);
            this.bSw = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
