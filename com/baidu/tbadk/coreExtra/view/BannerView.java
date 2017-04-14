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
    private TbPageContext<?> aaX;
    private String asI;
    private String asJ;
    protected Button asK;
    protected TbImageView asL;
    private TbImageView asM;
    private View asN;
    private boolean asO;
    private float asP;
    private boolean asQ;
    private com.baidu.tbadk.core.data.x asR;
    private a asS;
    View.OnClickListener asT;
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
        this.asR = xVar;
        com.baidu.tieba.recapp.y.a(this.asR.VQ, this.asM, this.asR.VR, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asI = "";
        this.asJ = "";
        this.asO = false;
        this.asP = 0.16875f;
        this.asQ = false;
        this.asT = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.bannerview, this);
        this.asK = (Button) findViewById(w.h.btn_close);
        this.asK.setOnClickListener(this.asT);
        this.asL = (TbImageView) findViewById(w.h.banner_image);
        this.asL.setAutoChangeStyle(true);
        this.asL.setOnClickListener(this.asT);
        this.asM = (TbImageView) findViewById(w.h.tv_advert);
        this.asN = findViewById(w.h.banner_mask);
        aq.k(this.asN, w.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.asL != null && aVar != null) {
            this.asL.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.asM.setVisibility(0);
        } else {
            this.asM.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aaX = tbPageContext;
        this.link = str2;
        this.asQ = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.asO && this.asQ) {
            ViewGroup.LayoutParams layoutParams = this.asL.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.af(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.af(getContext()) * this.asP) + 0.5d);
            this.asL.setLayoutParams(layoutParams);
            this.asL.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.asS = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.asN.setBackgroundColor(i);
    }

    public boolean Bm() {
        return this.asQ;
    }

    public TbImageView getBannerView() {
        return this.asL;
    }

    public void reset() {
        this.asO = false;
        this.asQ = false;
    }

    public void Bn() {
        this.asL.postInvalidate();
    }
}
