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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> Gf;
    private String anQ;
    private String anR;
    protected Button anS;
    protected TbImageView anT;
    private TbImageView anU;
    private View anV;
    private boolean anW;
    private float anX;
    private boolean anY;
    private com.baidu.tbadk.core.data.v anZ;
    private a aoa;
    View.OnClickListener aob;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AB();

        void AC();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.v vVar) {
        this.anZ = vVar;
        com.baidu.tieba.recapp.l.a(this.anZ.Rd, this.anU, this.anZ.Re, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anQ = "";
        this.anR = "";
        this.anW = false;
        this.anX = 0.16875f;
        this.anY = false;
        this.aob = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(r.h.bannerview, this);
        this.anS = (Button) findViewById(r.g.btn_close);
        this.anS.setOnClickListener(this.aob);
        this.anT = (TbImageView) findViewById(r.g.banner_image);
        this.anT.setAutoChangeStyle(true);
        this.anT.setOnClickListener(this.aob);
        this.anU = (TbImageView) findViewById(r.g.tv_advert);
        this.anV = findViewById(r.g.banner_mask);
        ar.l(this.anV, r.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.anT != null && aVar != null) {
            this.anT.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.anU.setVisibility(0);
        } else {
            this.anU.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.Gf = tbPageContext;
        this.link = str2;
        this.anY = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.anW && this.anY) {
            ViewGroup.LayoutParams layoutParams = this.anT.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.I(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.I(getContext()) * this.anX) + 0.5d);
            this.anT.setLayoutParams(layoutParams);
            this.anT.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = layoutParams.height;
                setLayoutParams(layoutParams2);
            }
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.aoa = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.anV.setBackgroundColor(i);
    }

    public boolean AA() {
        return this.anY;
    }

    public TbImageView getBannerView() {
        return this.anT;
    }

    public void reset() {
        this.anW = false;
        this.anY = false;
    }

    public void lR() {
        this.anT.postInvalidate();
    }
}
