package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> abI;
    private TbImageView auA;
    private View auB;
    private boolean auC;
    private float auD;
    private boolean auE;
    private x auF;
    private a auG;
    View.OnClickListener auH;
    private String auw;
    private String aux;
    protected Button auy;
    protected TbImageView auz;
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

    public void setBannerData(x xVar) {
        this.auF = xVar;
        s.a(this.auF.Wp, this.auA, this.auF.Wq, l.f(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auw = "";
        this.aux = "";
        this.auC = false;
        this.auD = 0.16875f;
        this.auE = false;
        this.auH = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.auy) {
                    if (!TextUtils.isEmpty(BannerView.this.aux)) {
                        TiebaStatic.log(BannerView.this.aux);
                    }
                    BannerView.this.auC = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.auG != null) {
                        BannerView.this.auG.AP();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.auw)) {
                    TiebaStatic.log(BannerView.this.auw);
                }
                if (BannerView.this.auG == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.vI().c(BannerView.this.abI, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.abI.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.abI.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.auG.AO();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.auy = (Button) findViewById(d.g.btn_close);
        this.auy.setOnClickListener(this.auH);
        this.auz = (TbImageView) findViewById(d.g.banner_image);
        this.auz.setAutoChangeStyle(true);
        this.auz.setOnClickListener(this.auH);
        this.auA = (TbImageView) findViewById(d.g.tv_advert);
        this.auB = findViewById(d.g.banner_mask);
        aj.k(this.auB, d.C0080d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.auz != null && aVar != null) {
            this.auz.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.auA.setVisibility(0);
        } else {
            this.auA.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.abI = tbPageContext;
        this.link = str2;
        this.auE = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.auC && this.auE) {
            ViewGroup.LayoutParams layoutParams = this.auz.getLayoutParams();
            layoutParams.width = l.ac(getContext());
            layoutParams.height = (int) ((l.ac(getContext()) * this.auD) + 0.5d);
            this.auz.setLayoutParams(layoutParams);
            this.auz.startLoad(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.auG = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.auB.setBackgroundColor(i);
    }

    public boolean AM() {
        return this.auE;
    }

    public TbImageView getBannerView() {
        return this.auz;
    }

    public void reset() {
        this.auC = false;
        this.auE = false;
    }

    public void AN() {
        this.auz.postInvalidate();
    }
}
