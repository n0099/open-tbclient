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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> aQq;
    private String bjl;
    private String bjm;
    protected Button bjn;
    protected TbImageView bjo;
    private TbImageView bjp;
    private View bjq;
    private boolean bjr;
    private float bjs;
    private boolean bjt;
    private v bju;
    private a bjv;
    View.OnClickListener bjw;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void IB();

        void IC();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.bju = vVar;
        r.a(this.bju.aLh, this.bjp, this.bju.aLi, l.s(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjl = "";
        this.bjm = "";
        this.bjr = false;
        this.bjs = 0.16875f;
        this.bjt = false;
        this.bjw = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.bjn) {
                    if (!TextUtils.isEmpty(BannerView.this.bjm)) {
                        TiebaStatic.log(BannerView.this.bjm);
                    }
                    BannerView.this.bjr = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.bjv != null) {
                        BannerView.this.bjv.IC();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.bjl)) {
                    TiebaStatic.log(BannerView.this.bjl);
                }
                if (BannerView.this.bjv == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.Di().c(BannerView.this.aQq, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aQq.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aQq.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.bjv.IB();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.bjn = (Button) findViewById(d.g.btn_close);
        this.bjn.setOnClickListener(this.bjw);
        this.bjo = (TbImageView) findViewById(d.g.banner_image);
        this.bjo.setAutoChangeStyle(true);
        this.bjo.setOnClickListener(this.bjw);
        this.bjp = (TbImageView) findViewById(d.g.tv_advert);
        this.bjq = findViewById(d.g.banner_mask);
        aj.t(this.bjq, d.C0108d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.bjo != null && aVar != null) {
            this.bjo.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.bjp.setVisibility(0);
        } else {
            this.bjp.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aQq = tbPageContext;
        this.link = str2;
        this.bjt = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.bjr && this.bjt) {
            ViewGroup.LayoutParams layoutParams = this.bjo.getLayoutParams();
            layoutParams.width = l.ao(getContext());
            layoutParams.height = (int) ((l.ao(getContext()) * this.bjs) + 0.5d);
            this.bjo.setLayoutParams(layoutParams);
            this.bjo.startLoad(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
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
        this.bjv = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.bjq.setBackgroundColor(i);
    }

    public boolean Iz() {
        return this.bjt;
    }

    public TbImageView getBannerView() {
        return this.bjo;
    }

    public void reset() {
        this.bjr = false;
        this.bjt = false;
    }

    public void IA() {
        this.bjo.postInvalidate();
    }
}
