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
    private TbPageContext<?> acr;
    private String avM;
    private String avN;
    protected Button avO;
    protected TbImageView avP;
    private TbImageView avQ;
    private View avR;
    private boolean avS;
    private float avT;
    private boolean avU;
    private x avV;
    private a avW;
    View.OnClickListener avX;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Bg();

        void Bh();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.avV = xVar;
        s.a(this.avV.WM, this.avQ, this.avV.WN, k.g(getContext(), d.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avM = "";
        this.avN = "";
        this.avS = false;
        this.avT = 0.16875f;
        this.avU = false;
        this.avX = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.avO) {
                    if (!TextUtils.isEmpty(BannerView.this.avN)) {
                        TiebaStatic.log(BannerView.this.avN);
                    }
                    BannerView.this.avS = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.avW != null) {
                        BannerView.this.avW.Bh();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.avM)) {
                    TiebaStatic.log(BannerView.this.avM);
                }
                if (BannerView.this.avW == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        at.wg().c(BannerView.this.acr, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.acr.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.acr.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.avW.Bg();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.bannerview, this);
        this.avO = (Button) findViewById(d.h.btn_close);
        this.avO.setOnClickListener(this.avX);
        this.avP = (TbImageView) findViewById(d.h.banner_image);
        this.avP.setAutoChangeStyle(true);
        this.avP.setOnClickListener(this.avX);
        this.avQ = (TbImageView) findViewById(d.h.tv_advert);
        this.avR = findViewById(d.h.banner_mask);
        ai.k(this.avR, d.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.avP != null && aVar != null) {
            this.avP.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.avQ.setVisibility(0);
        } else {
            this.avQ.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.acr = tbPageContext;
        this.link = str2;
        this.avU = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.avS && this.avU) {
            ViewGroup.LayoutParams layoutParams = this.avP.getLayoutParams();
            layoutParams.width = k.ag(getContext());
            layoutParams.height = (int) ((k.ag(getContext()) * this.avT) + 0.5d);
            this.avP.setLayoutParams(layoutParams);
            this.avP.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.avW = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avR.setBackgroundColor(i);
    }

    public boolean Be() {
        return this.avU;
    }

    public TbImageView getBannerView() {
        return this.avP;
    }

    public void reset() {
        this.avS = false;
        this.avU = false;
    }

    public void Bf() {
        this.avP.postInvalidate();
    }
}
