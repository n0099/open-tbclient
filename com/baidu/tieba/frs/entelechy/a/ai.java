package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ai extends ad.a {
    public TextView fdZ;
    public ImageView hKe;
    public TextView hKf;
    public ImageView hKg;
    public View hKh;
    public View hKi;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fdZ = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.hKe = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.hKf = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.hKg = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.hKh = view.findViewById(R.id.top_divider_line);
            this.hKi = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
