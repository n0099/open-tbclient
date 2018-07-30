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
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String aGJ;
    private String aGK;
    protected Button aGL;
    protected TbImageView aGM;
    private TbImageView aGN;
    private View aGO;
    private boolean aGP;
    private float aGQ;
    private boolean aGR;
    private v aGS;
    private a aGT;
    View.OnClickListener aGU;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void FH();

        void FI();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.aGS = vVar;
        s.a(this.aGS.afy, this.aGN, this.aGS.afz, l.f(getContext(), d.e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aGJ = str;
            this.aGK = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGJ = "";
        this.aGK = "";
        this.aGP = false;
        this.aGQ = 0.16875f;
        this.aGR = false;
        this.aGU = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aGL) {
                    if (!TextUtils.isEmpty(BannerView.this.aGK)) {
                        TiebaStatic.log(BannerView.this.aGK);
                    }
                    BannerView.this.aGP = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aGT != null) {
                        BannerView.this.aGT.FI();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aGJ)) {
                    TiebaStatic.log(BannerView.this.aGJ);
                }
                if (BannerView.this.aGT == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        ay.zK().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.aGT.FH();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.aGL = (Button) findViewById(d.g.btn_close);
        this.aGL.setOnClickListener(this.aGU);
        this.aGM = (TbImageView) findViewById(d.g.banner_image);
        this.aGM.setAutoChangeStyle(true);
        this.aGM.setOnClickListener(this.aGU);
        this.aGN = (TbImageView) findViewById(d.g.tv_advert);
        this.aGO = findViewById(d.g.banner_mask);
        am.j(this.aGO, d.C0140d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aGM != null && aVar != null) {
            this.aGM.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aGN.setVisibility(0);
        } else {
            this.aGN.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aGR = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aGP && this.aGR) {
            ViewGroup.LayoutParams layoutParams = this.aGM.getLayoutParams();
            layoutParams.width = l.ah(getContext());
            layoutParams.height = (int) ((l.ah(getContext()) * this.aGQ) + 0.5d);
            this.aGM.setLayoutParams(layoutParams);
            this.aGM.startLoad(str, 10, 640, 108, false);
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
        this.aGT = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aGO.setBackgroundColor(i);
    }

    public boolean FF() {
        return this.aGR;
    }

    public TbImageView getBannerView() {
        return this.aGM;
    }

    public void reset() {
        this.aGP = false;
        this.aGR = false;
    }

    public void FG() {
        this.aGM.postInvalidate();
    }
}
