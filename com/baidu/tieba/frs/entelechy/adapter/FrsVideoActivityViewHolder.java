package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsVideoActivityViewHolder extends TypeAdapter.ViewHolder {
    public View bRR;
    public View bRS;
    public ImageView jqV;
    public TextView jqW;
    public ImageView jqX;
    public TextView mTitleTv;

    public FrsVideoActivityViewHolder(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.jqV = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.jqW = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.jqX = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bRR = view.findViewById(R.id.top_divider_line);
            this.bRS = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
