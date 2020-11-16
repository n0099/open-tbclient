package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ai extends af.a {
    public View bHW;
    public View bHX;
    public TextView fXE;
    public ImageView iTA;
    public ImageView iTy;
    public TextView iTz;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fXE = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.iTy = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.iTz = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.iTA = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bHW = view.findViewById(R.id.top_divider_line);
            this.bHX = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
