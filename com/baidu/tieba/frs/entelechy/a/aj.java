package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class aj extends af.a {
    public View bNe;
    public View bNf;
    public TextView gfR;
    public ImageView jew;
    public TextView jex;
    public ImageView jey;

    public aj(View view) {
        super(view);
        if (view != null) {
            this.gfR = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.jew = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.jex = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.jey = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bNe = view.findViewById(R.id.top_divider_line);
            this.bNf = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
