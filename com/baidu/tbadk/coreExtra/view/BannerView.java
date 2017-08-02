package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> aaS;
    private float auA;
    private boolean auB;
    private x auC;
    private a auD;
    View.OnClickListener auE;
    private String aut;
    private String auu;
    protected Button auv;
    protected TbImageView auw;
    private TbImageView aux;
    private View auy;
    private boolean auz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AY();

        void AZ();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.auC = xVar;
        s.a(this.auC.Vn, this.aux, this.auC.Vo, k.g(getContext(), d.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aut = "";
        this.auu = "";
        this.auz = false;
        this.auA = 0.16875f;
        this.auB = false;
        this.auE = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.auv) {
                    if (!TextUtils.isEmpty(BannerView.this.auu)) {
                        TiebaStatic.log(BannerView.this.auu);
                    }
                    BannerView.this.auz = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.auD != null) {
                        BannerView.this.auD.AZ();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aut)) {
                    TiebaStatic.log(BannerView.this.aut);
                }
                if (BannerView.this.auD == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        at.vV().c(BannerView.this.aaS, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aaS.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aaS.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.auD.AY();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.bannerview, this);
        this.auv = (Button) findViewById(d.h.btn_close);
        this.auv.setOnClickListener(this.auE);
        this.auw = (TbImageView) findViewById(d.h.banner_image);
        this.auw.setAutoChangeStyle(true);
        this.auw.setOnClickListener(this.auE);
        this.aux = (TbImageView) findViewById(d.h.tv_advert);
        this.auy = findViewById(d.h.banner_mask);
        ai.k(this.auy, d.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.auw != null && aVar != null) {
            this.auw.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aux.setVisibility(0);
        } else {
            this.aux.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aaS = tbPageContext;
        this.link = str2;
        this.auB = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.auz && this.auB) {
            ViewGroup.LayoutParams layoutParams = this.auw.getLayoutParams();
            layoutParams.width = k.af(getContext());
            layoutParams.height = (int) ((k.af(getContext()) * this.auA) + 0.5d);
            this.auw.setLayoutParams(layoutParams);
            this.auw.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.auD = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.auy.setBackgroundColor(i);
    }

    public boolean AW() {
        return this.auB;
    }

    public TbImageView getBannerView() {
        return this.auw;
    }

    public void reset() {
        this.auz = false;
        this.auB = false;
    }

    public void AX() {
        this.auw.postInvalidate();
    }
}
