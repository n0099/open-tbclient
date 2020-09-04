package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ai extends af.a {
    public TextView fus;
    public ImageView iev;
    public TextView iew;
    public ImageView iex;
    public View iey;
    public View iez;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fus = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.iev = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.iew = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.iex = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.iey = view.findViewById(R.id.top_divider_line);
            this.iez = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
