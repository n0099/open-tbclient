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
    private x ccA;
    private a ccB;
    View.OnClickListener ccC;
    private String ccq;
    private String ccr;
    protected Button cct;
    protected TbImageView ccu;
    private TbImageView ccv;
    private View ccw;
    private boolean ccx;
    private float ccy;
    private boolean ccz;
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
        this.ccA = xVar;
        s.a(this.ccA.byE, this.ccv, this.ccA.byF, l.h(getContext(), d.e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.ccq = str;
            this.ccr = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccq = "";
        this.ccr = "";
        this.ccx = false;
        this.ccy = 0.16875f;
        this.ccz = false;
        this.ccC = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.cct) {
                    if (!TextUtils.isEmpty(BannerView.this.ccr)) {
                        TiebaStatic.log(BannerView.this.ccr);
                    }
                    BannerView.this.ccx = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.ccB != null) {
                        BannerView.this.ccB.ajZ();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.ccq)) {
                    TiebaStatic.log(BannerView.this.ccq);
                }
                if (BannerView.this.ccB == null) {
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
                BannerView.this.ccB.ajY();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.cct = (Button) findViewById(d.g.btn_close);
        this.cct.setOnClickListener(this.ccC);
        this.ccu = (TbImageView) findViewById(d.g.banner_image);
        this.ccu.setAutoChangeStyle(true);
        this.ccu.setOnClickListener(this.ccC);
        this.ccv = (TbImageView) findViewById(d.g.tv_advert);
        this.ccw = findViewById(d.g.banner_mask);
        al.l(this.ccw, d.C0277d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ccu != null && aVar != null) {
            this.ccu.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.ccv.setVisibility(0);
        } else {
            this.ccv.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.ccz = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ccx && this.ccz) {
            ViewGroup.LayoutParams layoutParams = this.ccu.getLayoutParams();
            layoutParams.width = l.aO(getContext());
            layoutParams.height = (int) ((l.aO(getContext()) * this.ccy) + 0.5d);
            this.ccu.setLayoutParams(layoutParams);
            this.ccu.startLoad(str, 10, 640, 108, false);
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
        this.ccB = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.ccw.setBackgroundColor(i);
    }

    public boolean ajW() {
        return this.ccz;
    }

    public TbImageView getBannerView() {
        return this.ccu;
    }

    public void reset() {
        this.ccx = false;
        this.ccz = false;
    }

    public void ajX() {
        this.ccu.postInvalidate();
    }
}
