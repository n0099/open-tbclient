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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> Gf;
    private String aoo;
    private String aop;
    protected Button aoq;
    protected TbImageView aor;
    private TbImageView aos;
    private View aot;
    private boolean aou;
    private float aov;
    private boolean aow;
    private com.baidu.tbadk.core.data.w aox;
    private a aoy;
    View.OnClickListener aoz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AO();

        void AP();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.w wVar) {
        this.aox = wVar;
        com.baidu.tieba.recapp.g.a(this.aox.Rg, this.aos, this.aox.Rh, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoo = "";
        this.aop = "";
        this.aou = false;
        this.aov = 0.16875f;
        this.aow = false;
        this.aoz = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(r.h.bannerview, this);
        this.aoq = (Button) findViewById(r.g.btn_close);
        this.aoq.setOnClickListener(this.aoz);
        this.aor = (TbImageView) findViewById(r.g.banner_image);
        this.aor.setAutoChangeStyle(true);
        this.aor.setOnClickListener(this.aoz);
        this.aos = (TbImageView) findViewById(r.g.tv_advert);
        this.aot = findViewById(r.g.banner_mask);
        at.l(this.aot, r.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aor != null && aVar != null) {
            this.aor.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aos.setVisibility(0);
        } else {
            this.aos.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.Gf = tbPageContext;
        this.link = str2;
        this.aow = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aou && this.aow) {
            ViewGroup.LayoutParams layoutParams = this.aor.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.K(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.aov) + 0.5d);
            this.aor.setLayoutParams(layoutParams);
            this.aor.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
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
        this.aoy = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aot.setBackgroundColor(i);
    }

    public boolean AN() {
        return this.aow;
    }

    public TbImageView getBannerView() {
        return this.aor;
    }

    public void reset() {
        this.aou = false;
        this.aow = false;
    }

    public void lR() {
        this.aor.postInvalidate();
    }
}
