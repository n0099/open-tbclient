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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> Dp;
    private String ajT;
    private String ajU;
    protected Button ajV;
    protected TbImageView ajW;
    private boolean ajX;
    private float ajY;
    private boolean ajZ;
    private a aka;
    View.OnClickListener akb;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void zp();

        void zq();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajT = "";
        this.ajU = "";
        this.ajX = false;
        this.ajY = 0.1388889f;
        this.ajZ = false;
        this.akb = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(u.h.bannerview, this);
        this.ajV = (Button) findViewById(u.g.btn_close);
        this.ajV.setOnClickListener(this.akb);
        this.ajW = (TbImageView) findViewById(u.g.banner_image);
        this.ajW.setAutoChangeStyle(true);
        this.ajW.setOnClickListener(this.akb);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ajW != null && aVar != null) {
            this.ajW.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.Dp = tbPageContext;
        this.link = str2;
        this.ajZ = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ajX && this.ajZ) {
            ViewGroup.LayoutParams layoutParams = this.ajW.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.A(getContext()) * this.ajY) + 0.5d);
            this.ajW.setLayoutParams(layoutParams);
            this.ajW.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.aka = aVar;
    }

    public boolean zo() {
        return this.ajZ;
    }

    public void reset() {
        this.ajX = false;
        this.ajZ = false;
    }

    public void kX() {
        this.ajW.postInvalidate();
    }
}
