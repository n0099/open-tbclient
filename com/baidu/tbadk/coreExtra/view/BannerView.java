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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> adf;
    private View axA;
    private boolean axB;
    private float axC;
    private boolean axD;
    private w axE;
    private a axF;
    View.OnClickListener axG;
    private String axv;
    private String axw;
    protected Button axx;
    protected TbImageView axy;
    private TbImageView axz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void BS();

        void BT();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(w wVar) {
        this.axE = wVar;
        s.a(this.axE.XN, this.axz, this.axE.XO, l.e(getContext(), d.e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.axv = str;
            this.axw = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axv = "";
        this.axw = "";
        this.axB = false;
        this.axC = 0.16875f;
        this.axD = false;
        this.axG = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == BannerView.this.axx) {
                    if (!TextUtils.isEmpty(BannerView.this.axw)) {
                        TiebaStatic.log(BannerView.this.axw);
                    }
                    BannerView.this.axB = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.axF != null) {
                        BannerView.this.axF.BT();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.axv)) {
                    TiebaStatic.log(BannerView.this.axv);
                }
                if (BannerView.this.axF == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ax.wg().c(BannerView.this.adf, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.adf.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.adf.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.axF.BS();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.bannerview, this);
        this.axx = (Button) findViewById(d.g.btn_close);
        this.axx.setOnClickListener(this.axG);
        this.axy = (TbImageView) findViewById(d.g.banner_image);
        this.axy.setAutoChangeStyle(true);
        this.axy.setOnClickListener(this.axG);
        this.axz = (TbImageView) findViewById(d.g.tv_advert);
        this.axA = findViewById(d.g.banner_mask);
        ak.j(this.axA, d.C0126d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.axy != null && aVar != null) {
            this.axy.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.axz.setVisibility(0);
        } else {
            this.axz.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.adf = tbPageContext;
        this.link = str2;
        this.axD = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.axB && this.axD) {
            ViewGroup.LayoutParams layoutParams = this.axy.getLayoutParams();
            layoutParams.width = l.af(getContext());
            layoutParams.height = (int) ((l.af(getContext()) * this.axC) + 0.5d);
            this.axy.setLayoutParams(layoutParams);
            this.axy.startLoad(str, 10, 640, 108, false);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = layoutParams.height;
                setLayoutParams(layoutParams2);
            }
            setVisibility(0);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str) {
        setData(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.axF = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.axA.setBackgroundColor(i);
    }

    public boolean BQ() {
        return this.axD;
    }

    public TbImageView getBannerView() {
        return this.axy;
    }

    public void reset() {
        this.axB = false;
        this.axD = false;
    }

    public void BR() {
        this.axy.postInvalidate();
    }
}
