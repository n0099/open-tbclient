package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> aaY;
    private String asK;
    private String asL;
    protected Button asM;
    protected TbImageView asN;
    private TbImageView asO;
    private View asP;
    private boolean asQ;
    private float asR;
    private boolean asS;
    private com.baidu.tbadk.core.data.x asT;
    private a asU;
    View.OnClickListener asV;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Bo();

        void Bp();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.x xVar) {
        this.asT = xVar;
        com.baidu.tieba.recapp.y.a(this.asT.VS, this.asO, this.asT.VT, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asK = "";
        this.asL = "";
        this.asQ = false;
        this.asR = 0.16875f;
        this.asS = false;
        this.asV = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.bannerview, this);
        this.asM = (Button) findViewById(w.h.btn_close);
        this.asM.setOnClickListener(this.asV);
        this.asN = (TbImageView) findViewById(w.h.banner_image);
        this.asN.setAutoChangeStyle(true);
        this.asN.setOnClickListener(this.asV);
        this.asO = (TbImageView) findViewById(w.h.tv_advert);
        this.asP = findViewById(w.h.banner_mask);
        aq.k(this.asP, w.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.asN != null && aVar != null) {
            this.asN.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.asO.setVisibility(0);
        } else {
            this.asO.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aaY = tbPageContext;
        this.link = str2;
        this.asS = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.asQ && this.asS) {
            ViewGroup.LayoutParams layoutParams = this.asN.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.af(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.af(getContext()) * this.asR) + 0.5d);
            this.asN.setLayoutParams(layoutParams);
            this.asN.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.asU = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.asP.setBackgroundColor(i);
    }

    public boolean Bm() {
        return this.asS;
    }

    public TbImageView getBannerView() {
        return this.asN;
    }

    public void reset() {
        this.asQ = false;
        this.asS = false;
    }

    public void Bn() {
        this.asN.postInvalidate();
    }
}
