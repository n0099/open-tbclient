package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ai extends ad.a {
    public TextView fiS;
    public ImageView hQg;
    public TextView hQh;
    public ImageView hQi;
    public View hQj;
    public View hQk;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fiS = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.hQg = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.hQh = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.hQi = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.hQj = view.findViewById(R.id.top_divider_line);
            this.hQk = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
