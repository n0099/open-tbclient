package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ad extends v.a {
    public TextView egH;
    public ImageView gxH;
    public TextView gxI;
    public ImageView gxJ;
    public View gxK;
    public View gxL;

    public ad(View view) {
        super(view);
        if (view != null) {
            this.egH = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.gxH = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.gxI = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.gxJ = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.gxK = view.findViewById(R.id.top_divider_line);
            this.gxL = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
