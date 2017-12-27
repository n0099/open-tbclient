package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class s extends r.a {
    public ImageView dDu;
    public TextView dDv;
    public ImageView dDw;
    public View dDx;
    public View dDy;
    public TextView mTitleTv;

    public s(View view) {
        super(view);
        if (view != null) {
            this.mTitleTv = (TextView) view.findViewById(d.g.video_activity_item_title);
            this.dDu = (ImageView) view.findViewById(d.g.video_activity_item_tip);
            this.dDv = (TextView) view.findViewById(d.g.video_activity_item_type);
            this.dDw = (ImageView) view.findViewById(d.g.video_activity_item_more);
            this.dDx = view.findViewById(d.g.top_divider_line);
            this.dDy = view.findViewById(d.g.bottom_divider_line);
        }
    }
}
