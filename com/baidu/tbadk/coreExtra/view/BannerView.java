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
    private TbPageContext<?> abX;
    private String avc;
    private String avd;
    protected Button ave;
    protected TbImageView avf;
    private TbImageView avg;
    private View avh;
    private boolean avi;
    private float avj;
    private boolean avk;
    private u avl;
    private a avm;
    View.OnClickListener avn;
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
        this.avl = uVar;
        r.a(this.avl.WG, this.avg, this.avl.WH, l.f(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avc = "";
        this.avd = "";
        this.avi = false;
        this.avj = 0.16875f;
        this.avk = false;
        this.avn = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.ave) {
                    if (!TextUtils.isEmpty(BannerView.this.avd)) {
                        TiebaStatic.log(BannerView.this.avd);
                    }
                    BannerView.this.avi = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.avm != null) {
                        BannerView.this.avm.Ba();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.avc)) {
                    TiebaStatic.log(BannerView.this.avc);
                }
                if (BannerView.this.avm == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.vI().c(BannerView.this.abX, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.abX.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.abX.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.avm.AZ();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.ave = (Button) findViewById(d.g.btn_close);
        this.ave.setOnClickListener(this.avn);
        this.avf = (TbImageView) findViewById(d.g.banner_image);
        this.avf.setAutoChangeStyle(true);
        this.avf.setOnClickListener(this.avn);
        this.avg = (TbImageView) findViewById(d.g.tv_advert);
        this.avh = findViewById(d.g.banner_mask);
        aj.k(this.avh, d.C0096d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.avf != null && aVar != null) {
            this.avf.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.avg.setVisibility(0);
        } else {
            this.avg.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.abX = tbPageContext;
        this.link = str2;
        this.avk = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.avi && this.avk) {
            ViewGroup.LayoutParams layoutParams = this.avf.getLayoutParams();
            layoutParams.width = l.ac(getContext());
            layoutParams.height = (int) ((l.ac(getContext()) * this.avj) + 0.5d);
            this.avf.setLayoutParams(layoutParams);
            this.avf.startLoad(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
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
        this.avm = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.avh.setBackgroundColor(i);
    }

    public boolean AX() {
        return this.avk;
    }

    public TbImageView getBannerView() {
        return this.avf;
    }

    public void reset() {
        this.avi = false;
        this.avk = false;
    }

    public void AY() {
        this.avf.postInvalidate();
    }
}
