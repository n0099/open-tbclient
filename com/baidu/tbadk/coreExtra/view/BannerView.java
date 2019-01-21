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
    protected Button aTA;
    protected TbImageView aTB;
    private TbImageView aTC;
    private View aTD;
    private boolean aTE;
    private float aTF;
    private boolean aTG;
    private v aTH;
    private a aTI;
    View.OnClickListener aTJ;
    private String aTy;
    private String aTz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void KE();

        void KF();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.aTH = vVar;
        s.a(this.aTH.arL, this.aTC, this.aTH.arM, l.h(getContext(), e.C0210e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aTy = str;
            this.aTz = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTy = "";
        this.aTz = "";
        this.aTE = false;
        this.aTF = 0.16875f;
        this.aTG = false;
        this.aTJ = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aTA) {
                    if (!TextUtils.isEmpty(BannerView.this.aTz)) {
                        TiebaStatic.log(BannerView.this.aTz);
                    }
                    BannerView.this.aTE = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aTI != null) {
                        BannerView.this.aTI.KF();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aTy)) {
                    TiebaStatic.log(BannerView.this.aTy);
                }
                if (BannerView.this.aTI == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ay.Es().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.aTI.KE();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.bannerview, this);
        this.aTA = (Button) findViewById(e.g.btn_close);
        this.aTA.setOnClickListener(this.aTJ);
        this.aTB = (TbImageView) findViewById(e.g.banner_image);
        this.aTB.setAutoChangeStyle(true);
        this.aTB.setOnClickListener(this.aTJ);
        this.aTC = (TbImageView) findViewById(e.g.tv_advert);
        this.aTD = findViewById(e.g.banner_mask);
        al.j(this.aTD, e.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aTB != null && aVar != null) {
            this.aTB.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aTC.setVisibility(0);
        } else {
            this.aTC.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aTG = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aTE && this.aTG) {
            ViewGroup.LayoutParams layoutParams = this.aTB.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.aTF) + 0.5d);
            this.aTB.setLayoutParams(layoutParams);
            this.aTB.startLoad(str, 10, 640, 108, false);
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
        this.aTI = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aTD.setBackgroundColor(i);
    }

    public boolean KC() {
        return this.aTG;
    }

    public TbImageView getBannerView() {
        return this.aTB;
    }

    public void reset() {
        this.aTE = false;
        this.aTG = false;
    }

    public void KD() {
        this.aTB.postInvalidate();
    }
}
