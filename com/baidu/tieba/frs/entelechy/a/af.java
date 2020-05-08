package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class af extends y.a {
    public TextView eHg;
    public ImageView hii;
    public TextView hij;
    public ImageView hik;
    public View hil;
    public View him;

    public af(View view) {
        super(view);
        if (view != null) {
            this.eHg = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.hii = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.hij = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.hik = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.hil = view.findViewById(R.id.top_divider_line);
            this.him = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
