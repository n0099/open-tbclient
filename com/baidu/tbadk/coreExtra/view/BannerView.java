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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> aat;
    private String atB;
    private String atC;
    protected Button atD;
    protected TbImageView atE;
    private TbImageView atF;
    private View atG;
    private boolean atH;
    private float atI;
    private boolean atJ;
    private com.baidu.tbadk.core.data.y atK;
    private a atL;
    View.OnClickListener atM;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AN();

        void AO();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.y yVar) {
        this.atK = yVar;
        com.baidu.tieba.recapp.ad.a(this.atK.UX, this.atF, this.atK.UY, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atB = "";
        this.atC = "";
        this.atH = false;
        this.atI = 0.16875f;
        this.atJ = false;
        this.atM = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(w.j.bannerview, this);
        this.atD = (Button) findViewById(w.h.btn_close);
        this.atD.setOnClickListener(this.atM);
        this.atE = (TbImageView) findViewById(w.h.banner_image);
        this.atE.setAutoChangeStyle(true);
        this.atE.setOnClickListener(this.atM);
        this.atF = (TbImageView) findViewById(w.h.tv_advert);
        this.atG = findViewById(w.h.banner_mask);
        as.k(this.atG, w.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.atE != null && aVar != null) {
            this.atE.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.atF.setVisibility(0);
        } else {
            this.atF.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aat = tbPageContext;
        this.link = str2;
        this.atJ = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.atH && this.atJ) {
            ViewGroup.LayoutParams layoutParams = this.atE.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.af(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.af(getContext()) * this.atI) + 0.5d);
            this.atE.setLayoutParams(layoutParams);
            this.atE.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.atL = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.atG.setBackgroundColor(i);
    }

    public boolean AL() {
        return this.atJ;
    }

    public TbImageView getBannerView() {
        return this.atE;
    }

    public void reset() {
        this.atH = false;
        this.atJ = false;
    }

    public void AM() {
        this.atE.postInvalidate();
    }
}
