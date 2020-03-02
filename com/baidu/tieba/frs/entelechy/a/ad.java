package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ad extends v.a {
    public TextView egI;
    public ImageView gxJ;
    public TextView gxK;
    public ImageView gxL;
    public View gxM;
    public View gxN;

    public ad(View view) {
        super(view);
        if (view != null) {
            this.egI = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.gxJ = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.gxK = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.gxL = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.gxM = view.findViewById(R.id.top_divider_line);
            this.gxN = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
