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
    static final /* synthetic */ boolean $assertionsDisabled;
    public int afY;
    public AppDownloadView bbC;
    public TbImageView bbD;
    public TextView bbE;
    public LinearLayout bbj;
    public HeadImageView bbl;
    public TextView bbm;
    public TextView bbn;
    public TextView bbp;

    static {
        $assertionsDisabled = !bl.class.desiredAssertionStatus();
    }

    public bl(View view) {
        super(view);
        this.afY = 3;
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.bbj = (LinearLayout) view.findViewById(n.f.frs_app_item_parent);
        this.bbl = (HeadImageView) view.findViewById(n.f.frs_app_icon);
        this.bbm = (TextView) view.findViewById(n.f.frs_app_name);
        this.bbn = (TextView) view.findViewById(n.f.frs_app_time);
        this.bbC = (AppDownloadView) view.findViewById(n.f.frs_app_download_view);
        this.bbp = (TextView) view.findViewById(n.f.frs_app_desc);
        this.bbD = (TbImageView) view.findViewById(n.f.frs_app_url);
        this.bbE = (TextView) view.findViewById(n.f.frs_app_download);
    }
}
