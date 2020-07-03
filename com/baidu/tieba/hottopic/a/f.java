package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f extends ad.a {
    public int ahx;
    public View gCZ;
    public BarImageView iFJ;
    public TextView iFK;
    public TextView iFL;
    public TextView iFM;
    public TextView iFN;
    public TextView iFO;
    public TextView ifo;
    public TextView ifp;

    public f(View view) {
        super(view);
        this.ahx = 3;
        this.iFK = (TextView) view.findViewById(R.id.forum_name);
        this.iFJ = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.iFM = (TextView) view.findViewById(R.id.member_num_label);
        this.iFL = (TextView) view.findViewById(R.id.post_num_label);
        this.ifp = (TextView) view.findViewById(R.id.member_num);
        this.ifo = (TextView) view.findViewById(R.id.post_num);
        this.iFN = (TextView) view.findViewById(R.id.forum_content);
        this.iFO = (TextView) view.findViewById(R.id.forum_add_love);
        this.gCZ = view.findViewById(R.id.forum_item_divider);
    }
}
