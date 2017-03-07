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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> aaI;
    private boolean asA;
    private com.baidu.tbadk.core.data.x asB;
    private a asC;
    View.OnClickListener asD;
    private String ass;
    private String ast;
    protected Button asu;
    protected TbImageView asv;
    private TbImageView asw;
    private View asx;
    private boolean asy;
    private float asz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AP();

        void AQ();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.x xVar) {
        this.asB = xVar;
        com.baidu.tieba.recapp.t.a(this.asB.Vz, this.asw, this.asB.VA, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ass = "";
        this.ast = "";
        this.asy = false;
        this.asz = 0.16875f;
        this.asA = false;
        this.asD = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.bannerview, this);
        this.asu = (Button) findViewById(w.h.btn_close);
        this.asu.setOnClickListener(this.asD);
        this.asv = (TbImageView) findViewById(w.h.banner_image);
        this.asv.setAutoChangeStyle(true);
        this.asv.setOnClickListener(this.asD);
        this.asw = (TbImageView) findViewById(w.h.tv_advert);
        this.asx = findViewById(w.h.banner_mask);
        aq.k(this.asx, w.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.asv != null && aVar != null) {
            this.asv.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.asw.setVisibility(0);
        } else {
            this.asw.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aaI = tbPageContext;
        this.link = str2;
        this.asA = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.asy && this.asA) {
            ViewGroup.LayoutParams layoutParams = this.asv.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.ag(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.ag(getContext()) * this.asz) + 0.5d);
            this.asv.setLayoutParams(layoutParams);
            this.asv.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
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
        this.asC = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.asx.setBackgroundColor(i);
    }

    public boolean AN() {
        return this.asA;
    }

    public TbImageView getBannerView() {
        return this.asv;
    }

    public void reset() {
        this.asy = false;
        this.asA = false;
    }

    public void AO() {
        this.asv.postInvalidate();
    }
}
