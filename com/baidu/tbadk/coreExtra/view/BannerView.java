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
    private TbPageContext<?> abm;
    private String atR;
    private String atS;
    protected Button atT;
    protected TbImageView atU;
    private TbImageView atV;
    private View atW;
    private boolean atX;
    private float atY;
    private boolean atZ;
    private x aua;
    private a aub;
    View.OnClickListener auc;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void At();

        void Au();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.aua = xVar;
        s.a(this.aua.VX, this.atV, this.aua.VY, l.f(getContext(), d.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atR = "";
        this.atS = "";
        this.atX = false;
        this.atY = 0.16875f;
        this.atZ = false;
        this.auc = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.atT) {
                    if (!TextUtils.isEmpty(BannerView.this.atS)) {
                        TiebaStatic.log(BannerView.this.atS);
                    }
                    BannerView.this.atX = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aub != null) {
                        BannerView.this.aub.Au();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.atR)) {
                    TiebaStatic.log(BannerView.this.atR);
                }
                if (BannerView.this.aub == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.vA().c(BannerView.this.abm, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.abm.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.abm.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.aub.At();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.bannerview, this);
        this.atT = (Button) findViewById(d.h.btn_close);
        this.atT.setOnClickListener(this.auc);
        this.atU = (TbImageView) findViewById(d.h.banner_image);
        this.atU.setAutoChangeStyle(true);
        this.atU.setOnClickListener(this.auc);
        this.atV = (TbImageView) findViewById(d.h.tv_advert);
        this.atW = findViewById(d.h.banner_mask);
        aj.k(this.atW, d.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.atU != null && aVar != null) {
            this.atU.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.atV.setVisibility(0);
        } else {
            this.atV.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.abm = tbPageContext;
        this.link = str2;
        this.atZ = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.atX && this.atZ) {
            ViewGroup.LayoutParams layoutParams = this.atU.getLayoutParams();
            layoutParams.width = l.ad(getContext());
            layoutParams.height = (int) ((l.ad(getContext()) * this.atY) + 0.5d);
            this.atU.setLayoutParams(layoutParams);
            this.atU.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.aub = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.atW.setBackgroundColor(i);
    }

    public boolean Ar() {
        return this.atZ;
    }

    public TbImageView getBannerView() {
        return this.atU;
    }

    public void reset() {
        this.atX = false;
        this.atZ = false;
    }

    public void As() {
        this.atU.postInvalidate();
    }
}
