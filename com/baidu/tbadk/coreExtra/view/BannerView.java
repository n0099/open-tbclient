package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String amp;
    private String amq;
    private Button amr;
    private TbImageView ams;
    private boolean amt;
    private float amu;
    private boolean amv;
    private a amw;
    View.OnClickListener amx;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void zu();

        void zv();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amp = "";
        this.amq = "";
        this.amt = false;
        this.amu = 0.1388889f;
        this.amv = false;
        this.amx = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(n.h.bannerview, this);
        this.amr = (Button) findViewById(n.g.btn_close);
        this.amr.setOnClickListener(this.amx);
        this.ams = (TbImageView) findViewById(n.g.banner_image);
        this.ams.setAutoChangeStyle(true);
        this.ams.setOnClickListener(this.amx);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ams != null && aVar != null) {
            this.ams.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.amv = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.amt && this.amv) {
            ViewGroup.LayoutParams layoutParams = this.ams.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.amu) + 0.5d);
            this.ams.setLayoutParams(layoutParams);
            this.ams.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.amw = aVar;
    }

    public boolean zt() {
        return this.amv;
    }

    public void reset() {
        this.amt = false;
        this.amv = false;
    }

    public void ot() {
        this.ams.postInvalidate();
    }
}
