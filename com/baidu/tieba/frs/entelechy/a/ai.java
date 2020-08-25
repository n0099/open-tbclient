package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ai extends af.a {
    public TextView fuo;
    public ImageView iep;
    public TextView ieq;
    public ImageView ier;
    public View ies;
    public View iet;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fuo = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.iep = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.ieq = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.ier = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.ies = view.findViewById(R.id.top_divider_line);
            this.iet = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
