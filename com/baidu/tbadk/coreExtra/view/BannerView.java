package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> Gd;
    private String anN;
    private String anO;
    protected Button anP;
    protected TbImageView anQ;
    private TbImageView anR;
    private boolean anS;
    private float anT;
    private boolean anU;
    private com.baidu.tbadk.core.data.t anV;
    private a anW;
    View.OnClickListener anX;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AE();

        void AF();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.t tVar) {
        this.anV = tVar;
        com.baidu.tieba.recapp.f.a(this.anV.QH, this.anR, this.anV.QI, com.baidu.adp.lib.util.k.e(getContext(), t.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anN = "";
        this.anO = "";
        this.anS = false;
        this.anT = 0.16875f;
        this.anU = false;
        this.anX = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(t.h.bannerview, this);
        this.anP = (Button) findViewById(t.g.btn_close);
        this.anP.setOnClickListener(this.anX);
        this.anQ = (TbImageView) findViewById(t.g.banner_image);
        this.anQ.setAutoChangeStyle(true);
        this.anQ.setOnClickListener(this.anX);
        this.anR = (TbImageView) findViewById(t.g.tv_advert);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.anQ != null && aVar != null) {
            this.anQ.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.Gd = tbPageContext;
        this.link = str2;
        this.anU = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.anS && this.anU) {
            ViewGroup.LayoutParams layoutParams = this.anQ.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.K(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.anT) + 0.5d);
            this.anQ.setLayoutParams(layoutParams);
            this.anQ.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.anW = aVar;
    }

    public boolean AD() {
        return this.anU;
    }

    public void reset() {
        this.anS = false;
        this.anU = false;
    }

    public void lO() {
        this.anQ.postInvalidate();
    }
}
