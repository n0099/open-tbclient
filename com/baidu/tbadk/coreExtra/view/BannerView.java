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
    private String auY;
    private String auZ;
    protected Button ava;
    protected TbImageView avb;
    private TbImageView avc;
    private View avd;
    private boolean ave;
    private float avf;
    private boolean avg;
    private x avh;
    private a avi;
    View.OnClickListener avj;
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
        this.avh = xVar;
        s.a(this.avh.VV, this.avc, this.avh.VW, k.g(getContext(), d.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auY = "";
        this.auZ = "";
        this.ave = false;
        this.avf = 0.16875f;
        this.avg = false;
        this.avj = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.ava) {
                    if (!TextUtils.isEmpty(BannerView.this.auZ)) {
                        TiebaStatic.log(BannerView.this.auZ);
                    }
                    BannerView.this.ave = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.avi != null) {
                        BannerView.this.avi.Bc();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.auY)) {
                    TiebaStatic.log(BannerView.this.auY);
                }
                if (BannerView.this.avi == null) {
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
                BannerView.this.avi.Bb();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.bannerview, this);
        this.ava = (Button) findViewById(d.h.btn_close);
        this.ava.setOnClickListener(this.avj);
        this.avb = (TbImageView) findViewById(d.h.banner_image);
        this.avb.setAutoChangeStyle(true);
        this.avb.setOnClickListener(this.avj);
        this.avc = (TbImageView) findViewById(d.h.tv_advert);
        this.avd = findViewById(d.h.banner_mask);
        aj.k(this.avd, d.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.avb != null && aVar != null) {
            this.avb.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.avc.setVisibility(0);
        } else {
            this.avc.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aby = tbPageContext;
        this.link = str2;
        this.avg = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ave && this.avg) {
            ViewGroup.LayoutParams layoutParams = this.avb.getLayoutParams();
            layoutParams.width = k.ad(getContext());
            layoutParams.height = (int) ((k.ad(getContext()) * this.avf) + 0.5d);
            this.avb.setLayoutParams(layoutParams);
            this.avb.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.avi = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avd.setBackgroundColor(i);
    }

    public boolean AZ() {
        return this.avg;
    }

    public TbImageView getBannerView() {
        return this.avb;
    }

    public void reset() {
        this.ave = false;
        this.avg = false;
    }

    public void Ba() {
        this.avb.postInvalidate();
    }
}
