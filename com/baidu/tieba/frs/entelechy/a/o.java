package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class o extends q.a {
    public ImageView doH;
    public TextView doI;
    public ImageView doJ;
    public View doK;
    public View doL;
    public TextView mTitleTv;

    public o(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.doH = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.doI = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.doJ = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.doK = view.findViewById(d.g.top_divider_line);
            this.doL = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
