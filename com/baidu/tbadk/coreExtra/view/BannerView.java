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
    private TbPageContext<?> aas;
    protected Button asA;
    protected TbImageView asB;
    private TbImageView asC;
    private View asD;
    private boolean asE;
    private float asF;
    private boolean asG;
    private com.baidu.tbadk.core.data.x asH;
    private a asI;
    View.OnClickListener asJ;
    private String asy;
    private String asz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void As();

        void At();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.x xVar) {
        this.asH = xVar;
        com.baidu.tieba.recapp.ac.a(this.asH.UY, this.asC, this.asH.UZ, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asy = "";
        this.asz = "";
        this.asE = false;
        this.asF = 0.16875f;
        this.asG = false;
        this.asJ = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.bannerview, this);
        this.asA = (Button) findViewById(w.h.btn_close);
        this.asA.setOnClickListener(this.asJ);
        this.asB = (TbImageView) findViewById(w.h.banner_image);
        this.asB.setAutoChangeStyle(true);
        this.asB.setOnClickListener(this.asJ);
        this.asC = (TbImageView) findViewById(w.h.tv_advert);
        this.asD = findViewById(w.h.banner_mask);
        aq.k(this.asD, w.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.asB != null && aVar != null) {
            this.asB.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.asC.setVisibility(0);
        } else {
            this.asC.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aas = tbPageContext;
        this.link = str2;
        this.asG = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.asE && this.asG) {
            ViewGroup.LayoutParams layoutParams = this.asB.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.af(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.af(getContext()) * this.asF) + 0.5d);
            this.asB.setLayoutParams(layoutParams);
            this.asB.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.asI = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.asD.setBackgroundColor(i);
    }

    public boolean Aq() {
        return this.asG;
    }

    public TbImageView getBannerView() {
        return this.asB;
    }

    public void reset() {
        this.asE = false;
        this.asG = false;
    }

    public void Ar() {
        this.asB.postInvalidate();
    }
}
