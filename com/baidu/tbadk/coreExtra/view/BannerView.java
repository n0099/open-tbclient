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
    private TbImageView axA;
    private View axB;
    private boolean axC;
    private float axD;
    private boolean axE;
    private w axF;
    private a axG;
    View.OnClickListener axH;
    private String axw;
    private String axx;
    protected Button axy;
    protected TbImageView axz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void BQ();

        void BR();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(w wVar) {
        this.axF = wVar;
        s.a(this.axF.XO, this.axA, this.axF.XP, l.e(getContext(), d.e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.axw = str;
            this.axx = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axw = "";
        this.axx = "";
        this.axC = false;
        this.axD = 0.16875f;
        this.axE = false;
        this.axH = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == BannerView.this.axy) {
                    if (!TextUtils.isEmpty(BannerView.this.axx)) {
                        TiebaStatic.log(BannerView.this.axx);
                    }
                    BannerView.this.axC = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.axG != null) {
                        BannerView.this.axG.BR();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.axw)) {
                    TiebaStatic.log(BannerView.this.axw);
                }
                if (BannerView.this.axG == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ax.wf().c(BannerView.this.mContext, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.mContext.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.mContext.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.axG.BQ();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.bannerview, this);
        this.axy = (Button) findViewById(d.g.btn_close);
        this.axy.setOnClickListener(this.axH);
        this.axz = (TbImageView) findViewById(d.g.banner_image);
        this.axz.setAutoChangeStyle(true);
        this.axz.setOnClickListener(this.axH);
        this.axA = (TbImageView) findViewById(d.g.tv_advert);
        this.axB = findViewById(d.g.banner_mask);
        ak.j(this.axB, d.C0126d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.axz != null && aVar != null) {
            this.axz.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.axA.setVisibility(0);
        } else {
            this.axA.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.axE = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.axC && this.axE) {
            ViewGroup.LayoutParams layoutParams = this.axz.getLayoutParams();
            layoutParams.width = l.af(getContext());
            layoutParams.height = (int) ((l.af(getContext()) * this.axD) + 0.5d);
            this.axz.setLayoutParams(layoutParams);
            this.axz.startLoad(str, 10, 640, 108, false);
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
        this.axG = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.axB.setBackgroundColor(i);
    }

    public boolean BO() {
        return this.axE;
    }

    public TbImageView getBannerView() {
        return this.axz;
    }

    public void reset() {
        this.axC = false;
        this.axE = false;
    }

    public void BP() {
        this.axz.postInvalidate();
    }
}
