package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bt extends x.a {
    static final /* synthetic */ boolean $assertionsDisabled;
    public int ahU;
    public LinearLayout bhK;
    public HeadImageView bhM;
    public TextView bhN;
    public TextView bhO;
    public TextView bhQ;
    public ViewStub bhV;
    public ViewGroup bhW;
    public ViewStub bhX;
    public ViewGroup bhY;
    public AppDownloadView bii;
    public TbImageView bij;
    public TextView bik;

    static {
        $assertionsDisabled = !bt.class.desiredAssertionStatus();
    }

    public bt(View view) {
        super(view);
        this.ahU = 3;
        if (!$assertionsDisabled && view == null) {
            throw new AssertionError();
        }
        this.bhK = (LinearLayout) view.findViewById(t.g.frs_app_item_parent);
        this.bhM = (HeadImageView) view.findViewById(t.g.frs_app_icon);
        this.bhN = (TextView) view.findViewById(t.g.frs_app_name);
        this.bhO = (TextView) view.findViewById(t.g.frs_app_time);
        this.bii = (AppDownloadView) view.findViewById(t.g.frs_app_download_view);
        this.bhQ = (TextView) view.findViewById(t.g.frs_app_desc);
        this.bij = (TbImageView) view.findViewById(t.g.frs_app_url);
        this.bik = (TextView) view.findViewById(t.g.frs_app_download);
        this.bhV = (ViewStub) view.findViewById(t.g.frs_item_adkiller_tip);
        this.bhX = (ViewStub) view.findViewById(t.g.item_adkiller_close);
    }
}
