package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class af extends aa.a {
    public TextView eTD;
    public ImageView hwV;
    public TextView hwW;
    public ImageView hwX;
    public View hwY;
    public View hwZ;

    public af(View view) {
        super(view);
        if (view != null) {
            this.eTD = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.hwV = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.hwW = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.hwX = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.hwY = view.findViewById(R.id.top_divider_line);
            this.hwZ = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
