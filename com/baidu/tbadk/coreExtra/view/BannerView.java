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
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> acd;
    private String auX;
    private String auY;
    protected Button auZ;
    protected TbImageView ava;
    private TbImageView avb;
    private View avc;
    private boolean avd;
    private float ave;
    private boolean avf;
    private u avg;
    private a avh;
    View.OnClickListener avi;
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

    public void setBannerData(u uVar) {
        this.avg = uVar;
        r.a(this.avg.WM, this.avb, this.avg.WN, l.f(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auX = "";
        this.auY = "";
        this.avd = false;
        this.ave = 0.16875f;
        this.avf = false;
        this.avi = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.auZ) {
                    if (!TextUtils.isEmpty(BannerView.this.auY)) {
                        TiebaStatic.log(BannerView.this.auY);
                    }
                    BannerView.this.avd = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.avh != null) {
                        BannerView.this.avh.AZ();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.auX)) {
                    TiebaStatic.log(BannerView.this.auX);
                }
                if (BannerView.this.avh == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.vL().c(BannerView.this.acd, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.acd.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.acd.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.avh.AY();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.auZ = (Button) findViewById(d.g.btn_close);
        this.auZ.setOnClickListener(this.avi);
        this.ava = (TbImageView) findViewById(d.g.banner_image);
        this.ava.setAutoChangeStyle(true);
        this.ava.setOnClickListener(this.avi);
        this.avb = (TbImageView) findViewById(d.g.tv_advert);
        this.avc = findViewById(d.g.banner_mask);
        aj.k(this.avc, d.C0082d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ava != null && aVar != null) {
            this.ava.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.avb.setVisibility(0);
        } else {
            this.avb.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.acd = tbPageContext;
        this.link = str2;
        this.avf = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.avd && this.avf) {
            ViewGroup.LayoutParams layoutParams = this.ava.getLayoutParams();
            layoutParams.width = l.ac(getContext());
            layoutParams.height = (int) ((l.ac(getContext()) * this.ave) + 0.5d);
            this.ava.setLayoutParams(layoutParams);
            this.ava.startLoad(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.avh = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avc.setBackgroundColor(i);
    }

    public boolean AW() {
        return this.avf;
    }

    public TbImageView getBannerView() {
        return this.ava;
    }

    public void reset() {
        this.avd = false;
        this.avf = false;
    }

    public void AX() {
        this.ava.postInvalidate();
    }
}
