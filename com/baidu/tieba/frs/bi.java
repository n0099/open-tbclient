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
public class bi extends x.a {
    public AppDownloadView bav;
    public LinearLayout bbj;
    public View bbk;
    public HeadImageView bbl;
    public TextView bbm;
    public TextView bbn;
    public TextView bbo;
    public TextView bbp;
    public TbImageView bbq;
    public TbImageView bbr;
    public TbImageView bbs;
    public TextView bbt;

    public bi(View view) {
        super(view);
        this.bbj = (LinearLayout) view.findViewById(n.f.frs_app_item_parent);
        this.bbl = (HeadImageView) view.findViewById(n.f.frs_app_multi_pic_icon);
        this.bbm = (TextView) view.findViewById(n.f.frs_app_multi_pic_name);
        this.bbn = (TextView) view.findViewById(n.f.frs_app_multi_pic_time);
        this.bav = (AppDownloadView) view.findViewById(n.f.frs_app_download_view);
        this.bbo = (TextView) view.findViewById(n.f.frs_app_multi_pic_title);
        this.bbp = (TextView) view.findViewById(n.f.frs_app_multi_pic_desc);
        this.bbq = (TbImageView) view.findViewById(n.f.frs_app_multi_pic_left);
        this.bbr = (TbImageView) view.findViewById(n.f.frs_app_multi_pic_center);
        this.bbs = (TbImageView) view.findViewById(n.f.frs_app_multi_pic_right);
        this.bbt = (TextView) view.findViewById(n.f.frs_app_download);
        this.bbk = view.findViewById(n.f.frs_app_multi_pic_container);
    }
}
