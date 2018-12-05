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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String aSN;
    private String aSO;
    protected Button aSP;
    protected TbImageView aSQ;
    private TbImageView aSR;
    private View aSS;
    private boolean aST;
    private float aSU;
    private boolean aSV;
    private v aSW;
    private a aSX;
    View.OnClickListener aSY;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Ko();

        void Kp();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.aSW = vVar;
        s.a(this.aSW.ari, this.aSR, this.aSW.arj, l.h(getContext(), e.C0210e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aSN = str;
            this.aSO = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSN = "";
        this.aSO = "";
        this.aST = false;
        this.aSU = 0.16875f;
        this.aSV = false;
        this.aSY = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aSP) {
                    if (!TextUtils.isEmpty(BannerView.this.aSO)) {
                        TiebaStatic.log(BannerView.this.aSO);
                    }
                    BannerView.this.aST = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aSX != null) {
                        BannerView.this.aSX.Kp();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aSN)) {
                    TiebaStatic.log(BannerView.this.aSN);
                }
                if (BannerView.this.aSX == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ay.Ef().c(BannerView.this.mContext, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.mContext.getPageActivity(), "enterforum_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.mContext.getPageActivity(), "frs_banner", AiAppsUBCStatistic.TYPE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.aSX.Ko();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.bannerview, this);
        this.aSP = (Button) findViewById(e.g.btn_close);
        this.aSP.setOnClickListener(this.aSY);
        this.aSQ = (TbImageView) findViewById(e.g.banner_image);
        this.aSQ.setAutoChangeStyle(true);
        this.aSQ.setOnClickListener(this.aSY);
        this.aSR = (TbImageView) findViewById(e.g.tv_advert);
        this.aSS = findViewById(e.g.banner_mask);
        al.j(this.aSS, e.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aSQ != null && aVar != null) {
            this.aSQ.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aSR.setVisibility(0);
        } else {
            this.aSR.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aSV = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aST && this.aSV) {
            ViewGroup.LayoutParams layoutParams = this.aSQ.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.aSU) + 0.5d);
            this.aSQ.setLayoutParams(layoutParams);
            this.aSQ.startLoad(str, 10, 640, 108, false);
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
        this.aSX = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aSS.setBackgroundColor(i);
    }

    public boolean Km() {
        return this.aSV;
    }

    public TbImageView getBannerView() {
        return this.aSQ;
    }

    public void reset() {
        this.aST = false;
        this.aSV = false;
    }

    public void Kn() {
        this.aSQ.postInvalidate();
    }
}
