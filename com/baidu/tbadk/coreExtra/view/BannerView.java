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
    private String auo;
    private String aup;
    protected Button auq;
    protected TbImageView aur;
    private TbImageView aus;
    private View aut;
    private boolean auu;
    private float auv;
    private boolean auw;
    private x aux;
    private a auy;
    View.OnClickListener auz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AC();

        void AD();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.aux = xVar;
        s.a(this.aux.Wp, this.aus, this.aux.Wq, l.f(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auo = "";
        this.aup = "";
        this.auu = false;
        this.auv = 0.16875f;
        this.auw = false;
        this.auz = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.auq) {
                    if (!TextUtils.isEmpty(BannerView.this.aup)) {
                        TiebaStatic.log(BannerView.this.aup);
                    }
                    BannerView.this.auu = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.auy != null) {
                        BannerView.this.auy.AD();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.auo)) {
                    TiebaStatic.log(BannerView.this.auo);
                }
                if (BannerView.this.auy == null) {
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
                BannerView.this.auy.AC();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.auq = (Button) findViewById(d.g.btn_close);
        this.auq.setOnClickListener(this.auz);
        this.aur = (TbImageView) findViewById(d.g.banner_image);
        this.aur.setAutoChangeStyle(true);
        this.aur.setOnClickListener(this.auz);
        this.aus = (TbImageView) findViewById(d.g.tv_advert);
        this.aut = findViewById(d.g.banner_mask);
        aj.k(this.aut, d.C0080d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aur != null && aVar != null) {
            this.aur.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aus.setVisibility(0);
        } else {
            this.aus.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.abI = tbPageContext;
        this.link = str2;
        this.auw = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.auu && this.auw) {
            ViewGroup.LayoutParams layoutParams = this.aur.getLayoutParams();
            layoutParams.width = l.ac(getContext());
            layoutParams.height = (int) ((l.ac(getContext()) * this.auv) + 0.5d);
            this.aur.setLayoutParams(layoutParams);
            this.aur.startLoad(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.auy = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aut.setBackgroundColor(i);
    }

    public boolean AA() {
        return this.auw;
    }

    public TbImageView getBannerView() {
        return this.aur;
    }

    public void reset() {
        this.auu = false;
        this.auw = false;
    }

    public void AB() {
        this.aur.postInvalidate();
    }
}
