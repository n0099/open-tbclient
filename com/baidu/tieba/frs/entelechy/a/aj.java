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
    public TextView gfP;
    public ImageView jeu;
    public TextView jev;
    public ImageView jew;

    public aj(View view) {
        super(view);
        if (view != null) {
            this.gfP = (TextView) view.findViewById(R.id.video_activity_item_title);
            this.jeu = (ImageView) view.findViewById(R.id.video_activity_item_tip);
            this.jev = (TextView) view.findViewById(R.id.video_activity_item_type);
            this.jew = (ImageView) view.findViewById(R.id.video_activity_item_more);
            this.bNe = view.findViewById(R.id.top_divider_line);
            this.bNf = view.findViewById(R.id.bottom_divider_line);
        }
    }
}
