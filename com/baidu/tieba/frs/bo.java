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
public class bo extends x.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    public int ahf;
    public AppDownloadView bfB;
    public TbImageView bfC;
    public TextView bfD;
    public LinearLayout bfi;
    public HeadImageView bfk;
    public TextView bfl;
    public TextView bfm;
    public TextView bfo;

    static {
        $assertionsDisabled = !bo.class.desiredAssertionStatus();
    }

    public bo(View view) {
        super(view);
        this.ahf = 3;
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.bfi = (LinearLayout) view.findViewById(n.g.frs_app_item_parent);
        this.bfk = (HeadImageView) view.findViewById(n.g.frs_app_icon);
        this.bfl = (TextView) view.findViewById(n.g.frs_app_name);
        this.bfm = (TextView) view.findViewById(n.g.frs_app_time);
        this.bfB = (AppDownloadView) view.findViewById(n.g.frs_app_download_view);
        this.bfo = (TextView) view.findViewById(n.g.frs_app_desc);
        this.bfC = (TbImageView) view.findViewById(n.g.frs_app_url);
        this.bfD = (TextView) view.findViewById(n.g.frs_app_download);
    }
}
