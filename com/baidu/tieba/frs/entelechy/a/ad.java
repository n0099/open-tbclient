package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ad extends v.a {
    public TextView egV;
    public ImageView gxV;
    public TextView gxW;
    public ImageView gxX;
    public View gxY;
    public View gxZ;

    public ad(View view) {
        super(view);
        if (view != null) {
            this.egV = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.gxV = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.gxW = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.gxX = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.gxY = view.findViewById(R.id.top_divider_line);
            this.gxZ = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
