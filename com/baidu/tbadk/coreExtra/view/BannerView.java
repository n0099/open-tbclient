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
    private TbPageContext<?> abz;
    private String aud;
    private String aue;
    protected Button auf;
    protected TbImageView aug;
    private TbImageView auh;
    private View aui;
    private boolean auj;
    private float auk;
    private boolean aul;
    private x aum;
    private a aun;
    View.OnClickListener auo;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AA();

        void Az();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.aum = xVar;
        s.a(this.aum.Wj, this.auh, this.aum.Wk, l.f(getContext(), d.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aud = "";
        this.aue = "";
        this.auj = false;
        this.auk = 0.16875f;
        this.aul = false;
        this.auo = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.auf) {
                    if (!TextUtils.isEmpty(BannerView.this.aue)) {
                        TiebaStatic.log(BannerView.this.aue);
                    }
                    BannerView.this.auj = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aun != null) {
                        BannerView.this.aun.AA();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aud)) {
                    TiebaStatic.log(BannerView.this.aud);
                }
                if (BannerView.this.aun == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.vH().c(BannerView.this.abz, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.abz.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.abz.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.aun.Az();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.bannerview, this);
        this.auf = (Button) findViewById(d.h.btn_close);
        this.auf.setOnClickListener(this.auo);
        this.aug = (TbImageView) findViewById(d.h.banner_image);
        this.aug.setAutoChangeStyle(true);
        this.aug.setOnClickListener(this.auo);
        this.auh = (TbImageView) findViewById(d.h.tv_advert);
        this.aui = findViewById(d.h.banner_mask);
        aj.k(this.aui, d.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aug != null && aVar != null) {
            this.aug.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.auh.setVisibility(0);
        } else {
            this.auh.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.abz = tbPageContext;
        this.link = str2;
        this.aul = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.auj && this.aul) {
            ViewGroup.LayoutParams layoutParams = this.aug.getLayoutParams();
            layoutParams.width = l.ad(getContext());
            layoutParams.height = (int) ((l.ad(getContext()) * this.auk) + 0.5d);
            this.aug.setLayoutParams(layoutParams);
            this.aug.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, SapiSafeFacade.SAPIWEBVIEW_SMS_LOGIN, false);
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
        this.aun = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aui.setBackgroundColor(i);
    }

    public boolean Ax() {
        return this.aul;
    }

    public TbImageView getBannerView() {
        return this.aug;
    }

    public void reset() {
        this.auj = false;
        this.aul = false;
    }

    public void Ay() {
        this.aug.postInvalidate();
    }
}
