package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class e extends af.a {
    public int ajq;
    public TextView evg;
    public View jQG;
    public TextView jQH;
    public RelativeLayout jQN;
    public View jQO;
    public TbImageView jQP;
    public TextView jQQ;
    public TextView jQR;
    public TextView jQS;
    public TextView jQT;
    public View rootView;

    public e(View view) {
        super(view);
        this.ajq = 3;
        this.rootView = null;
        this.jQG = null;
        this.jQH = null;
        this.jQN = null;
        this.jQO = null;
        this.jQP = null;
        this.rootView = view;
        cP(this.rootView);
    }

    private void cP(View view) {
        if (view != null) {
            this.jQG = view.findViewById(R.id.top_divider_line);
            this.jQH = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.jQO = view.findViewById(R.id.divider_line);
            this.jQN = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.jQP = (TbImageView) view.findViewById(R.id.img);
            this.evg = (TextView) view.findViewById(R.id.title);
            this.jQQ = (TextView) view.findViewById(R.id.desc);
            this.jQR = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.jQS = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.jQT = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
