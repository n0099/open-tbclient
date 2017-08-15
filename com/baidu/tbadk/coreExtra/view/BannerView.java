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
    private String avL;
    private String avM;
    protected Button avN;
    protected TbImageView avO;
    private TbImageView avP;
    private View avQ;
    private boolean avR;
    private float avS;
    private boolean avT;
    private x avU;
    private a avV;
    View.OnClickListener avW;
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
        this.avU = xVar;
        s.a(this.avU.WL, this.avP, this.avU.WM, k.g(getContext(), d.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avL = "";
        this.avM = "";
        this.avR = false;
        this.avS = 0.16875f;
        this.avT = false;
        this.avW = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.avN) {
                    if (!TextUtils.isEmpty(BannerView.this.avM)) {
                        TiebaStatic.log(BannerView.this.avM);
                    }
                    BannerView.this.avR = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.avV != null) {
                        BannerView.this.avV.Bh();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.avL)) {
                    TiebaStatic.log(BannerView.this.avL);
                }
                if (BannerView.this.avV == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        at.wf().c(BannerView.this.acr, new String[]{BannerView.this.link});
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
                BannerView.this.avV.Bg();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.bannerview, this);
        this.avN = (Button) findViewById(d.h.btn_close);
        this.avN.setOnClickListener(this.avW);
        this.avO = (TbImageView) findViewById(d.h.banner_image);
        this.avO.setAutoChangeStyle(true);
        this.avO.setOnClickListener(this.avW);
        this.avP = (TbImageView) findViewById(d.h.tv_advert);
        this.avQ = findViewById(d.h.banner_mask);
        ai.k(this.avQ, d.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.avO != null && aVar != null) {
            this.avO.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.avP.setVisibility(0);
        } else {
            this.avP.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.acr = tbPageContext;
        this.link = str2;
        this.avT = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.avR && this.avT) {
            ViewGroup.LayoutParams layoutParams = this.avO.getLayoutParams();
            layoutParams.width = k.ag(getContext());
            layoutParams.height = (int) ((k.ag(getContext()) * this.avS) + 0.5d);
            this.avO.setLayoutParams(layoutParams);
            this.avO.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.avV = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avQ.setBackgroundColor(i);
    }

    public boolean Be() {
        return this.avT;
    }

    public TbImageView getBannerView() {
        return this.avO;
    }

    public void reset() {
        this.avR = false;
        this.avT = false;
    }

    public void Bf() {
        this.avO.postInvalidate();
    }
}
