package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class y extends v.a {
    public TextView dDB;
    public ImageView fEV;
    public TextView fEW;
    public ImageView fEX;
    public View fEY;
    public View fEZ;

    public y(View view) {
        super(view);
        if (view != null) {
            this.dDB = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.fEV = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.fEW = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.fEX = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.fEY = view.findViewById(R.id.top_divider_line);
            this.fEZ = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
