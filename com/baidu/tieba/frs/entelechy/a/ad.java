package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ad extends v.a {
    public TextView ecE;
    public ImageView gvG;
    public TextView gvH;
    public ImageView gvI;
    public View gvJ;
    public View gvK;

    public ad(View view) {
        super(view);
        if (view != null) {
            this.ecE = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.gvG = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.gvH = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.gvI = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.gvJ = view.findViewById(R.id.top_divider_line);
            this.gvK = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
