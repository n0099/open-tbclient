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
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> aca;
    private String avf;
    private String avg;
    protected Button avh;
    protected TbImageView avi;
    private TbImageView avj;
    private View avk;
    private boolean avl;
    private float avm;
    private boolean avn;
    private u avo;
    private a avp;
    View.OnClickListener avq;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AZ();

        void Ba();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(u uVar) {
        this.avo = uVar;
        r.a(this.avo.WJ, this.avj, this.avo.WK, l.f(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avf = "";
        this.avg = "";
        this.avl = false;
        this.avm = 0.16875f;
        this.avn = false;
        this.avq = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.avh) {
                    if (!TextUtils.isEmpty(BannerView.this.avg)) {
                        TiebaStatic.log(BannerView.this.avg);
                    }
                    BannerView.this.avl = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.avp != null) {
                        BannerView.this.avp.Ba();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.avf)) {
                    TiebaStatic.log(BannerView.this.avf);
                }
                if (BannerView.this.avp == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.vI().c(BannerView.this.aca, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aca.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aca.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.avp.AZ();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.avh = (Button) findViewById(d.g.btn_close);
        this.avh.setOnClickListener(this.avq);
        this.avi = (TbImageView) findViewById(d.g.banner_image);
        this.avi.setAutoChangeStyle(true);
        this.avi.setOnClickListener(this.avq);
        this.avj = (TbImageView) findViewById(d.g.tv_advert);
        this.avk = findViewById(d.g.banner_mask);
        aj.k(this.avk, d.C0095d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.avi != null && aVar != null) {
            this.avi.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.avj.setVisibility(0);
        } else {
            this.avj.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aca = tbPageContext;
        this.link = str2;
        this.avn = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.avl && this.avn) {
            ViewGroup.LayoutParams layoutParams = this.avi.getLayoutParams();
            layoutParams.width = l.ac(getContext());
            layoutParams.height = (int) ((l.ac(getContext()) * this.avm) + 0.5d);
            this.avi.setLayoutParams(layoutParams);
            this.avi.startLoad(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
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
        this.avp = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avk.setBackgroundColor(i);
    }

    public boolean AX() {
        return this.avn;
    }

    public TbImageView getBannerView() {
        return this.avi;
    }

    public void reset() {
        this.avl = false;
        this.avn = false;
    }

    public void AY() {
        this.avi.postInvalidate();
    }
}
