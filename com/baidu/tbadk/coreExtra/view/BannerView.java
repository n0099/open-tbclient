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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    View.OnClickListener ajA;
    private String ajs;
    private String ajt;
    private Button aju;
    private TbImageView ajv;
    private boolean ajw;
    private float ajx;
    private boolean ajy;
    private a ajz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void yK();

        void yL();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajs = "";
        this.ajt = "";
        this.ajw = false;
        this.ajx = 0.1388889f;
        this.ajy = false;
        this.ajA = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(i.g.bannerview, this);
        this.aju = (Button) findViewById(i.f.btn_close);
        this.aju.setOnClickListener(this.ajA);
        this.ajv = (TbImageView) findViewById(i.f.banner_image);
        this.ajv.setAutoChangeStyle(true);
        this.ajv.setOnClickListener(this.ajA);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ajv != null && aVar != null) {
            this.ajv.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.ajy = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ajw && this.ajy) {
            ViewGroup.LayoutParams layoutParams = this.ajv.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.ajx) + 0.5d);
            this.ajv.setLayoutParams(layoutParams);
            this.ajv.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.ajz = aVar;
    }

    public boolean yJ() {
        return this.ajy;
    }

    public void reset() {
        this.ajw = false;
        this.ajy = false;
    }

    public void oO() {
        this.ajv.postInvalidate();
    }
}
