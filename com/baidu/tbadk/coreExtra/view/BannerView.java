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
    private a ajA;
    View.OnClickListener ajB;
    private String ajt;
    private String aju;
    private Button ajv;
    private TbImageView ajw;
    private boolean ajx;
    private float ajy;
    private boolean ajz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void yH();

        void yI();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajt = "";
        this.aju = "";
        this.ajx = false;
        this.ajy = 0.1388889f;
        this.ajz = false;
        this.ajB = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(i.g.bannerview, this);
        this.ajv = (Button) findViewById(i.f.btn_close);
        this.ajv.setOnClickListener(this.ajB);
        this.ajw = (TbImageView) findViewById(i.f.banner_image);
        this.ajw.setAutoChangeStyle(true);
        this.ajw.setOnClickListener(this.ajB);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ajw != null && aVar != null) {
            this.ajw.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.ajz = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ajx && this.ajz) {
            ViewGroup.LayoutParams layoutParams = this.ajw.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.ajy) + 0.5d);
            this.ajw.setLayoutParams(layoutParams);
            this.ajw.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.ajA = aVar;
    }

    public boolean yG() {
        return this.ajz;
    }

    public void reset() {
        this.ajx = false;
        this.ajz = false;
    }

    public void oO() {
        this.ajw.postInvalidate();
    }
}
