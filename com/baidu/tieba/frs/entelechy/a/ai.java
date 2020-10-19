package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ai extends af.a {
    public View bBe;
    public View bBf;
    public TextView fJM;
    public ImageView iAs;
    public TextView iAt;
    public ImageView iAu;

    public ai(View view) {
        super(view);
        if (view != null) {
            this.fJM = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.iAs = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.iAt = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.iAu = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bBe = view.findViewById(R.id.top_divider_line);
            this.bBf = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
