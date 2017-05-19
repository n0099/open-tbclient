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
    private TbPageContext<?> aat;
    private String asO;
    private String asP;
    protected Button asQ;
    protected TbImageView asR;
    private TbImageView asS;
    private View asT;
    private boolean asU;
    private float asV;
    private boolean asW;
    private com.baidu.tbadk.core.data.x asX;
    private a asY;
    View.OnClickListener asZ;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AA();

        void Az();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.x xVar) {
        this.asX = xVar;
        com.baidu.tieba.recapp.aa.a(this.asX.Vl, this.asS, this.asX.Vm, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asO = "";
        this.asP = "";
        this.asU = false;
        this.asV = 0.16875f;
        this.asW = false;
        this.asZ = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.bannerview, this);
        this.asQ = (Button) findViewById(w.h.btn_close);
        this.asQ.setOnClickListener(this.asZ);
        this.asR = (TbImageView) findViewById(w.h.banner_image);
        this.asR.setAutoChangeStyle(true);
        this.asR.setOnClickListener(this.asZ);
        this.asS = (TbImageView) findViewById(w.h.tv_advert);
        this.asT = findViewById(w.h.banner_mask);
        aq.k(this.asT, w.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.asR != null && aVar != null) {
            this.asR.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.asS.setVisibility(0);
        } else {
            this.asS.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aat = tbPageContext;
        this.link = str2;
        this.asW = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.asU && this.asW) {
            ViewGroup.LayoutParams layoutParams = this.asR.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.af(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.af(getContext()) * this.asV) + 0.5d);
            this.asR.setLayoutParams(layoutParams);
            this.asR.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.asY = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.asT.setBackgroundColor(i);
    }

    public boolean Ax() {
        return this.asW;
    }

    public TbImageView getBannerView() {
        return this.asR;
    }

    public void reset() {
        this.asU = false;
        this.asW = false;
    }

    public void Ay() {
        this.asR.postInvalidate();
    }
}
