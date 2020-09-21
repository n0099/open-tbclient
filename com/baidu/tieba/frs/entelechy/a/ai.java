package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ai extends af.a {
    public TextView fxD;
    public ImageView ilv;
    public TextView ilw;
    public ImageView ilx;
    public View ily;
    public View ilz;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fxD = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.ilv = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.ilw = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.ilx = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.ily = view.findViewById(R.id.top_divider_line);
            this.ilz = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
