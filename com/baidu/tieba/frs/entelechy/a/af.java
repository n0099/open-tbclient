package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class af extends v.a {
    public TextView ehl;
    public ImageView gyG;
    public TextView gyH;
    public ImageView gyI;
    public View gyJ;
    public View gyK;

    public af(View view) {
        super(view);
        if (view != null) {
            this.ehl = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.gyG = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.gyH = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.gyI = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.gyJ = view.findViewById(R.id.top_divider_line);
            this.gyK = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
