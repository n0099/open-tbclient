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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> aby;
    private String auV;
    private String auW;
    protected Button auX;
    protected TbImageView auY;
    private TbImageView auZ;
    private View ava;
    private boolean avb;
    private float avc;
    private boolean avd;
    private x ave;
    private a avf;
    View.OnClickListener avg;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Bb();

        void Bc();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.ave = xVar;
        s.a(this.ave.VV, this.auZ, this.ave.VW, k.f(getContext(), d.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auV = "";
        this.auW = "";
        this.avb = false;
        this.avc = 0.16875f;
        this.avd = false;
        this.avg = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.auX) {
                    if (!TextUtils.isEmpty(BannerView.this.auW)) {
                        TiebaStatic.log(BannerView.this.auW);
                    }
                    BannerView.this.avb = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.avf != null) {
                        BannerView.this.avf.Bc();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.auV)) {
                    TiebaStatic.log(BannerView.this.auV);
                }
                if (BannerView.this.avf == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        au.wd().c(BannerView.this.aby, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aby.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aby.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.avf.Bb();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.bannerview, this);
        this.auX = (Button) findViewById(d.h.btn_close);
        this.auX.setOnClickListener(this.avg);
        this.auY = (TbImageView) findViewById(d.h.banner_image);
        this.auY.setAutoChangeStyle(true);
        this.auY.setOnClickListener(this.avg);
        this.auZ = (TbImageView) findViewById(d.h.tv_advert);
        this.ava = findViewById(d.h.banner_mask);
        aj.k(this.ava, d.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.auY != null && aVar != null) {
            this.auY.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.auZ.setVisibility(0);
        } else {
            this.auZ.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aby = tbPageContext;
        this.link = str2;
        this.avd = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.avb && this.avd) {
            ViewGroup.LayoutParams layoutParams = this.auY.getLayoutParams();
            layoutParams.width = k.ae(getContext());
            layoutParams.height = (int) ((k.ae(getContext()) * this.avc) + 0.5d);
            this.auY.setLayoutParams(layoutParams);
            this.auY.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.avf = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.ava.setBackgroundColor(i);
    }

    public boolean AZ() {
        return this.avd;
    }

    public TbImageView getBannerView() {
        return this.auY;
    }

    public void reset() {
        this.avb = false;
        this.avd = false;
    }

    public void Ba() {
        this.auY.postInvalidate();
    }
}
