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
    private boolean ccA;
    private x ccB;
    private a ccC;
    View.OnClickListener ccD;
    private String ccr;
    private String cct;
    protected Button ccu;
    protected TbImageView ccv;
    private TbImageView ccw;
    private View ccx;
    private boolean ccy;
    private float ccz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void ajY();

        void ajZ();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(x xVar) {
        this.ccB = xVar;
        s.a(this.ccB.byF, this.ccw, this.ccB.byG, l.h(getContext(), d.e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.ccr = str;
            this.cct = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccr = "";
        this.cct = "";
        this.ccy = false;
        this.ccz = 0.16875f;
        this.ccA = false;
        this.ccD = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.ccu) {
                    if (!TextUtils.isEmpty(BannerView.this.cct)) {
                        TiebaStatic.log(BannerView.this.cct);
                    }
                    BannerView.this.ccy = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.ccC != null) {
                        BannerView.this.ccC.ajZ();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.ccr)) {
                    TiebaStatic.log(BannerView.this.ccr);
                }
                if (BannerView.this.ccC == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ba.adA().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.ccC.ajY();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.ccu = (Button) findViewById(d.g.btn_close);
        this.ccu.setOnClickListener(this.ccD);
        this.ccv = (TbImageView) findViewById(d.g.banner_image);
        this.ccv.setAutoChangeStyle(true);
        this.ccv.setOnClickListener(this.ccD);
        this.ccw = (TbImageView) findViewById(d.g.tv_advert);
        this.ccx = findViewById(d.g.banner_mask);
        al.l(this.ccx, d.C0277d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ccv != null && aVar != null) {
            this.ccv.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.ccw.setVisibility(0);
        } else {
            this.ccw.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.ccA = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ccy && this.ccA) {
            ViewGroup.LayoutParams layoutParams = this.ccv.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.ccz) + 0.5d);
            this.ccv.setLayoutParams(layoutParams);
            this.ccv.startLoad(str, 10, 640, 108, false);
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
        this.ccC = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.ccx.setBackgroundColor(i);
    }

    public boolean ajW() {
        return this.ccA;
    }

    public TbImageView getBannerView() {
        return this.ccv;
    }

    public void reset() {
        this.ccy = false;
        this.ccA = false;
    }

    public void ajX() {
        this.ccv.postInvalidate();
    }
}
