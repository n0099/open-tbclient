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
    private TbPageContext<?> aQs;
    private String bjD;
    private String bjE;
    protected Button bjF;
    protected TbImageView bjG;
    private TbImageView bjH;
    private View bjI;
    private boolean bjJ;
    private float bjK;
    private boolean bjL;
    private v bjM;
    private a bjN;
    View.OnClickListener bjO;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Iw();

        void Ix();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.bjM = vVar;
        r.a(this.bjM.aLi, this.bjH, this.bjM.aLj, l.s(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjD = "";
        this.bjE = "";
        this.bjJ = false;
        this.bjK = 0.16875f;
        this.bjL = false;
        this.bjO = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.bjF) {
                    if (!TextUtils.isEmpty(BannerView.this.bjE)) {
                        TiebaStatic.log(BannerView.this.bjE);
                    }
                    BannerView.this.bjJ = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.bjN != null) {
                        BannerView.this.bjN.Ix();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.bjD)) {
                    TiebaStatic.log(BannerView.this.bjD);
                }
                if (BannerView.this.bjN == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        av.Da().c(BannerView.this.aQs, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aQs.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aQs.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.bjN.Iw();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.bjF = (Button) findViewById(d.g.btn_close);
        this.bjF.setOnClickListener(this.bjO);
        this.bjG = (TbImageView) findViewById(d.g.banner_image);
        this.bjG.setAutoChangeStyle(true);
        this.bjG.setOnClickListener(this.bjO);
        this.bjH = (TbImageView) findViewById(d.g.tv_advert);
        this.bjI = findViewById(d.g.banner_mask);
        aj.t(this.bjI, d.C0108d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.bjG != null && aVar != null) {
            this.bjG.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.bjH.setVisibility(0);
        } else {
            this.bjH.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aQs = tbPageContext;
        this.link = str2;
        this.bjL = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.bjJ && this.bjL) {
            ViewGroup.LayoutParams layoutParams = this.bjG.getLayoutParams();
            layoutParams.width = l.ao(getContext());
            layoutParams.height = (int) ((l.ao(getContext()) * this.bjK) + 0.5d);
            this.bjG.setLayoutParams(layoutParams);
            this.bjG.startLoad(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
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
        this.bjN = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.bjI.setBackgroundColor(i);
    }

    public boolean Iu() {
        return this.bjL;
    }

    public TbImageView getBannerView() {
        return this.bjG;
    }

    public void reset() {
        this.bjJ = false;
        this.bjL = false;
    }

    public void Iv() {
        this.bjG.postInvalidate();
    }
}
