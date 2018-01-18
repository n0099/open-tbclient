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
    private TbPageContext<?> aQp;
    private View bjA;
    private boolean bjB;
    private float bjC;
    private boolean bjD;
    private v bjE;
    private a bjF;
    View.OnClickListener bjG;
    private String bjv;
    private String bjw;
    protected Button bjx;
    protected TbImageView bjy;
    private TbImageView bjz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Iu();

        void Iv();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.bjE = vVar;
        r.a(this.bjE.aLf, this.bjz, this.bjE.aLg, l.s(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjv = "";
        this.bjw = "";
        this.bjB = false;
        this.bjC = 0.16875f;
        this.bjD = false;
        this.bjG = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.bjx) {
                    if (!TextUtils.isEmpty(BannerView.this.bjw)) {
                        TiebaStatic.log(BannerView.this.bjw);
                    }
                    BannerView.this.bjB = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.bjF != null) {
                        BannerView.this.bjF.Iv();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.bjv)) {
                    TiebaStatic.log(BannerView.this.bjv);
                }
                if (BannerView.this.bjF == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.CZ().c(BannerView.this.aQp, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aQp.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aQp.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.bjF.Iu();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.bjx = (Button) findViewById(d.g.btn_close);
        this.bjx.setOnClickListener(this.bjG);
        this.bjy = (TbImageView) findViewById(d.g.banner_image);
        this.bjy.setAutoChangeStyle(true);
        this.bjy.setOnClickListener(this.bjG);
        this.bjz = (TbImageView) findViewById(d.g.tv_advert);
        this.bjA = findViewById(d.g.banner_mask);
        aj.t(this.bjA, d.C0107d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.bjy != null && aVar != null) {
            this.bjy.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.bjz.setVisibility(0);
        } else {
            this.bjz.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aQp = tbPageContext;
        this.link = str2;
        this.bjD = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.bjB && this.bjD) {
            ViewGroup.LayoutParams layoutParams = this.bjy.getLayoutParams();
            layoutParams.width = l.ao(getContext());
            layoutParams.height = (int) ((l.ao(getContext()) * this.bjC) + 0.5d);
            this.bjy.setLayoutParams(layoutParams);
            this.bjy.startLoad(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
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
        this.bjF = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.bjA.setBackgroundColor(i);
    }

    public boolean Is() {
        return this.bjD;
    }

    public TbImageView getBannerView() {
        return this.bjy;
    }

    public void reset() {
        this.bjB = false;
        this.bjD = false;
    }

    public void It() {
        this.bjy.postInvalidate();
    }
}
