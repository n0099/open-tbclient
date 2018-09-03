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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String aGI;
    private String aGJ;
    protected Button aGK;
    protected TbImageView aGL;
    private TbImageView aGM;
    private View aGN;
    private boolean aGO;
    private float aGP;
    private boolean aGQ;
    private v aGR;
    private a aGS;
    View.OnClickListener aGT;
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
        this.aGR = vVar;
        s.a(this.aGR.afy, this.aGM, this.aGR.afz, l.f(getContext(), f.e.ds26));
    }

    public void setMtjInfo(String str, String str2) {
        if (str != null && str2 != null) {
            this.aGI = str;
            this.aGJ = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGI = "";
        this.aGJ = "";
        this.aGO = false;
        this.aGP = 0.16875f;
        this.aGQ = false;
        this.aGT = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.aGK) {
                    if (!TextUtils.isEmpty(BannerView.this.aGJ)) {
                        TiebaStatic.log(BannerView.this.aGJ);
                    }
                    BannerView.this.aGO = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.aGS != null) {
                        BannerView.this.aGS.FI();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.aGI)) {
                    TiebaStatic.log(BannerView.this.aGI);
                }
                if (BannerView.this.aGS == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        az.zI().c(BannerView.this.mContext, new String[]{BannerView.this.link});
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
                BannerView.this.aGS.FH();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(f.h.bannerview, this);
        this.aGK = (Button) findViewById(f.g.btn_close);
        this.aGK.setOnClickListener(this.aGT);
        this.aGL = (TbImageView) findViewById(f.g.banner_image);
        this.aGL.setAutoChangeStyle(true);
        this.aGL.setOnClickListener(this.aGT);
        this.aGM = (TbImageView) findViewById(f.g.tv_advert);
        this.aGN = findViewById(f.g.banner_mask);
        am.j(this.aGN, f.d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.aGL != null && aVar != null) {
            this.aGL.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.aGM.setVisibility(0);
        } else {
            this.aGM.setVisibility(8);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aGQ = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aGO && this.aGQ) {
            ViewGroup.LayoutParams layoutParams = this.aGL.getLayoutParams();
            layoutParams.width = l.ah(getContext());
            layoutParams.height = (int) ((l.ah(getContext()) * this.aGP) + 0.5d);
            this.aGL.setLayoutParams(layoutParams);
            this.aGL.startLoad(str, 10, 640, 108, false);
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
        this.aGS = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.aGN.setBackgroundColor(i);
    }

    public boolean FF() {
        return this.aGQ;
    }

    public TbImageView getBannerView() {
        return this.aGL;
    }

    public void reset() {
        this.aGO = false;
        this.aGQ = false;
    }

    public void FG() {
        this.aGL.postInvalidate();
    }
}
