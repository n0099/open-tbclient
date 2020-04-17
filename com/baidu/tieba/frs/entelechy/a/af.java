package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class af extends y.a {
    public TextView eHb;
    public ImageView hib;
    public TextView hic;
    public ImageView hie;
    public View hif;
    public View hig;

    public af(View view) {
        super(view);
        if (view != null) {
            this.eHb = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.hib = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.hic = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.hie = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.hif = view.findViewById(R.id.top_divider_line);
            this.hig = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
