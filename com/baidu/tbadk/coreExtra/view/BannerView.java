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
    private TbPageContext<?> acp;
    private String avK;
    private String avL;
    protected Button avM;
    protected TbImageView avN;
    private TbImageView avO;
    private View avP;
    private boolean avQ;
    private float avR;
    private boolean avS;
    private x avT;
    private a avU;
    View.OnClickListener avV;
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
        this.avT = xVar;
        s.a(this.avT.WJ, this.avO, this.avT.WK, k.g(getContext(), d.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avK = "";
        this.avL = "";
        this.avQ = false;
        this.avR = 0.16875f;
        this.avS = false;
        this.avV = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.avM) {
                    if (!TextUtils.isEmpty(BannerView.this.avL)) {
                        TiebaStatic.log(BannerView.this.avL);
                    }
                    BannerView.this.avQ = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.avU != null) {
                        BannerView.this.avU.Bh();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.avK)) {
                    TiebaStatic.log(BannerView.this.avK);
                }
                if (BannerView.this.avU == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        at.wf().c(BannerView.this.acp, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.acp.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.acp.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.avU.Bg();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.bannerview, this);
        this.avM = (Button) findViewById(d.h.btn_close);
        this.avM.setOnClickListener(this.avV);
        this.avN = (TbImageView) findViewById(d.h.banner_image);
        this.avN.setAutoChangeStyle(true);
        this.avN.setOnClickListener(this.avV);
        this.avO = (TbImageView) findViewById(d.h.tv_advert);
        this.avP = findViewById(d.h.banner_mask);
        ai.k(this.avP, d.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.avN != null && aVar != null) {
            this.avN.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.avO.setVisibility(0);
        } else {
            this.avO.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.acp = tbPageContext;
        this.link = str2;
        this.avS = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.avQ && this.avS) {
            ViewGroup.LayoutParams layoutParams = this.avN.getLayoutParams();
            layoutParams.width = k.ag(getContext());
            layoutParams.height = (int) ((k.ag(getContext()) * this.avR) + 0.5d);
            this.avN.setLayoutParams(layoutParams);
            this.avN.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.avU = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avP.setBackgroundColor(i);
    }

    public boolean Be() {
        return this.avS;
    }

    public TbImageView getBannerView() {
        return this.avN;
    }

    public void reset() {
        this.avQ = false;
        this.avS = false;
    }

    public void Bf() {
        this.avN.postInvalidate();
    }
}
