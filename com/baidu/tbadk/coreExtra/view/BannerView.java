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
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    View.OnClickListener ccA;
    private String cco;
    private String ccp;
    protected Button ccq;
    protected TbImageView ccr;
    private TbImageView cct;
    private View ccu;
    private boolean ccv;
    private float ccw;
    private boolean ccx;
    private x ccy;
    private a ccz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void akb();

        void akc();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.ccy = xVar;
        s.a(this.ccy.byB, this.cct, this.ccy.byC, l.h(getContext(), d.e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.cco = str;
            this.ccp = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cco = "";
        this.ccp = "";
        this.ccv = false;
        this.ccw = 0.16875f;
        this.ccx = false;
        this.ccA = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.ccq) {
                    if (!TextUtils.isEmpty(BannerView.this.ccp)) {
                        TiebaStatic.log(BannerView.this.ccp);
                    }
                    BannerView.this.ccv = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.ccz != null) {
                        BannerView.this.ccz.akc();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.cco)) {
                    TiebaStatic.log(BannerView.this.cco);
                }
                if (BannerView.this.ccz == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.adD().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.ccz.akb();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.ccq = (Button) findViewById(d.g.btn_close);
        this.ccq.setOnClickListener(this.ccA);
        this.ccr = (TbImageView) findViewById(d.g.banner_image);
        this.ccr.setAutoChangeStyle(true);
        this.ccr.setOnClickListener(this.ccA);
        this.cct = (TbImageView) findViewById(d.g.tv_advert);
        this.ccu = findViewById(d.g.banner_mask);
        al.l(this.ccu, d.C0277d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ccr != null && aVar != null) {
            this.ccr.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.cct.setVisibility(0);
        } else {
            this.cct.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.ccx = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ccv && this.ccx) {
            ViewGroup.LayoutParams layoutParams = this.ccr.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.ccw) + 0.5d);
            this.ccr.setLayoutParams(layoutParams);
            this.ccr.startLoad(str, 10, 640, 108, false);
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
        this.ccz = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.ccu.setBackgroundColor(i);
    }

    public boolean ajZ() {
        return this.ccx;
    }

    public TbImageView getBannerView() {
        return this.ccr;
    }

    public void reset() {
        this.ccv = false;
        this.ccx = false;
    }

    public void aka() {
        this.ccr.postInvalidate();
    }
}
