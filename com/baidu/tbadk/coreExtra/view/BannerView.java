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
    private String aSP;
    private String aSQ;
    protected Button aSR;
    protected TbImageView aSS;
    private TbImageView aST;
    private View aSU;
    private boolean aSV;
    private float aSW;
    private boolean aSX;
    private v aSY;
    private a aSZ;
    View.OnClickListener aTa;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Kp();

        void Kq();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.aSY = vVar;
        s.a(this.aSY.ari, this.aST, this.aSY.arj, l.h(getContext(), e.C0210e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aSP = str;
            this.aSQ = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSP = "";
        this.aSQ = "";
        this.aSV = false;
        this.aSW = 0.16875f;
        this.aSX = false;
        this.aTa = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aSR) {
                    if (!TextUtils.isEmpty(BannerView.this.aSQ)) {
                        TiebaStatic.log(BannerView.this.aSQ);
                    }
                    BannerView.this.aSV = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aSZ != null) {
                        BannerView.this.aSZ.Kq();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aSP)) {
                    TiebaStatic.log(BannerView.this.aSP);
                }
                if (BannerView.this.aSZ == null) {
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
                BannerView.this.aSZ.Kp();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.bannerview, this);
        this.aSR = (Button) findViewById(e.g.btn_close);
        this.aSR.setOnClickListener(this.aTa);
        this.aSS = (TbImageView) findViewById(e.g.banner_image);
        this.aSS.setAutoChangeStyle(true);
        this.aSS.setOnClickListener(this.aTa);
        this.aST = (TbImageView) findViewById(e.g.tv_advert);
        this.aSU = findViewById(e.g.banner_mask);
        al.j(this.aSU, e.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aSS != null && aVar != null) {
            this.aSS.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aST.setVisibility(0);
        } else {
            this.aST.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aSX = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aSV && this.aSX) {
            ViewGroup.LayoutParams layoutParams = this.aSS.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.aSW) + 0.5d);
            this.aSS.setLayoutParams(layoutParams);
            this.aSS.startLoad(str, 10, 640, 108, false);
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
        this.aSZ = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aSU.setBackgroundColor(i);
    }

    public boolean Kn() {
        return this.aSX;
    }

    public TbImageView getBannerView() {
        return this.aSS;
    }

    public void reset() {
        this.aSV = false;
        this.aSX = false;
    }

    public void Ko() {
        this.aSS.postInvalidate();
    }
}
