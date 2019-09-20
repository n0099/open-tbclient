package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class y extends v.a {
    public TextView dwZ;
    public ImageView fFE;
    public TextView fFF;
    public ImageView fFG;
    public View fFH;
    public View fFI;

    public y(View view) {
        super(view);
        if (view != null) {
            this.dwZ = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.fFE = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.fFF = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.fFG = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.fFH = view.findViewById(R.id.top_divider_line);
            this.fFI = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
