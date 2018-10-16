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
    protected Button aOA;
    protected TbImageView aOB;
    private TbImageView aOC;
    private View aOD;
    private boolean aOE;
    private float aOF;
    private boolean aOG;
    private v aOH;
    private a aOI;
    View.OnClickListener aOJ;
    private String aOy;
    private String aOz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void IY();

        void IZ();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.aOH = vVar;
        s.a(this.aOH.amU, this.aOC, this.aOH.amV, l.h(getContext(), e.C0175e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aOy = str;
            this.aOz = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOy = "";
        this.aOz = "";
        this.aOE = false;
        this.aOF = 0.16875f;
        this.aOG = false;
        this.aOJ = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aOA) {
                    if (!TextUtils.isEmpty(BannerView.this.aOz)) {
                        TiebaStatic.log(BannerView.this.aOz);
                    }
                    BannerView.this.aOE = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aOI != null) {
                        BannerView.this.aOI.IZ();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aOy)) {
                    TiebaStatic.log(BannerView.this.aOy);
                }
                if (BannerView.this.aOI == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ay.CU().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.aOI.IY();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.bannerview, this);
        this.aOA = (Button) findViewById(e.g.btn_close);
        this.aOA.setOnClickListener(this.aOJ);
        this.aOB = (TbImageView) findViewById(e.g.banner_image);
        this.aOB.setAutoChangeStyle(true);
        this.aOB.setOnClickListener(this.aOJ);
        this.aOC = (TbImageView) findViewById(e.g.tv_advert);
        this.aOD = findViewById(e.g.banner_mask);
        al.j(this.aOD, e.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aOB != null && aVar != null) {
            this.aOB.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aOC.setVisibility(0);
        } else {
            this.aOC.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aOG = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aOE && this.aOG) {
            ViewGroup.LayoutParams layoutParams = this.aOB.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.aOF) + 0.5d);
            this.aOB.setLayoutParams(layoutParams);
            this.aOB.startLoad(str, 10, 640, 108, false);
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
        this.aOI = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aOD.setBackgroundColor(i);
    }

    public boolean IW() {
        return this.aOG;
    }

    public TbImageView getBannerView() {
        return this.aOB;
    }

    public void reset() {
        this.aOE = false;
        this.aOG = false;
    }

    public void IX() {
        this.aOB.postInvalidate();
    }
}
