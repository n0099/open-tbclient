package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ad extends v.a {
    public TextView ecv;
    public View gsA;
    public View gsB;
    public ImageView gsx;
    public TextView gsy;
    public ImageView gsz;

    public ad(View view) {
        super(view);
        if (view != null) {
            this.ecv = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.gsx = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.gsy = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.gsz = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.gsA = view.findViewById(R.id.top_divider_line);
            this.gsB = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
