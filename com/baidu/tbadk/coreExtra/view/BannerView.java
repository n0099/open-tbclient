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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> Do;
    private String ajn;
    private String ajo;
    protected Button ajp;
    protected TbImageView ajq;
    private boolean ajr;
    private float ajs;
    private boolean ajt;
    private a aju;
    View.OnClickListener ajv;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void zj();

        void zk();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajn = "";
        this.ajo = "";
        this.ajr = false;
        this.ajs = 0.1388889f;
        this.ajt = false;
        this.ajv = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(t.h.bannerview, this);
        this.ajp = (Button) findViewById(t.g.btn_close);
        this.ajp.setOnClickListener(this.ajv);
        this.ajq = (TbImageView) findViewById(t.g.banner_image);
        this.ajq.setAutoChangeStyle(true);
        this.ajq.setOnClickListener(this.ajv);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ajq != null && aVar != null) {
            this.ajq.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.Do = tbPageContext;
        this.link = str2;
        this.ajt = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ajr && this.ajt) {
            ViewGroup.LayoutParams layoutParams = this.ajq.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.B(getContext()) * this.ajs) + 0.5d);
            this.ajq.setLayoutParams(layoutParams);
            this.ajq.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.aju = aVar;
    }

    public boolean zi() {
        return this.ajt;
    }

    public void reset() {
        this.ajr = false;
        this.ajt = false;
    }

    public void kU() {
        this.ajq.postInvalidate();
    }
}
