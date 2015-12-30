package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bl extends x.a {
    public AppDownloadView beu;
    public LinearLayout bfi;
    public View bfj;
    public HeadImageView bfk;
    public TextView bfl;
    public TextView bfm;
    public TextView bfn;
    public TextView bfo;
    public TbImageView bfp;
    public TbImageView bfq;
    public TbImageView bfr;
    public TextView bfs;

    public bl(View view) {
        super(view);
        this.bfi = (LinearLayout) view.findViewById(n.g.frs_app_item_parent);
        this.bfk = (HeadImageView) view.findViewById(n.g.frs_app_multi_pic_icon);
        this.bfl = (TextView) view.findViewById(n.g.frs_app_multi_pic_name);
        this.bfm = (TextView) view.findViewById(n.g.frs_app_multi_pic_time);
        this.beu = (AppDownloadView) view.findViewById(n.g.frs_app_download_view);
        this.bfn = (TextView) view.findViewById(n.g.frs_app_multi_pic_title);
        this.bfo = (TextView) view.findViewById(n.g.frs_app_multi_pic_desc);
        this.bfp = (TbImageView) view.findViewById(n.g.frs_app_multi_pic_left);
        this.bfq = (TbImageView) view.findViewById(n.g.frs_app_multi_pic_center);
        this.bfr = (TbImageView) view.findViewById(n.g.frs_app_multi_pic_right);
        this.bfs = (TextView) view.findViewById(n.g.frs_app_download);
        this.bfj = view.findViewById(n.g.frs_app_multi_pic_container);
    }
}
