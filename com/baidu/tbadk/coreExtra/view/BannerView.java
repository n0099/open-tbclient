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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> aRR;
    private String blS;
    private String blT;
    protected Button blU;
    protected TbImageView blV;
    private TbImageView blW;
    private View blX;
    private boolean blY;
    private float blZ;
    private boolean bma;
    private v bmb;
    private a bmc;
    View.OnClickListener bmd;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Jc();

        void Jd();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.bmb = vVar;
        s.a(this.bmb.aMC, this.blW, this.bmb.aMD, l.t(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blS = "";
        this.blT = "";
        this.blY = false;
        this.blZ = 0.16875f;
        this.bma = false;
        this.bmd = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.blU) {
                    if (!TextUtils.isEmpty(BannerView.this.blT)) {
                        TiebaStatic.log(BannerView.this.blT);
                    }
                    BannerView.this.blY = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.bmc != null) {
                        BannerView.this.bmc.Jd();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.blS)) {
                    TiebaStatic.log(BannerView.this.blS);
                }
                if (BannerView.this.bmc == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        aw.Du().c(BannerView.this.aRR, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aRR.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aRR.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.bmc.Jc();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.blU = (Button) findViewById(d.g.btn_close);
        this.blU.setOnClickListener(this.bmd);
        this.blV = (TbImageView) findViewById(d.g.banner_image);
        this.blV.setAutoChangeStyle(true);
        this.blV.setOnClickListener(this.bmd);
        this.blW = (TbImageView) findViewById(d.g.tv_advert);
        this.blX = findViewById(d.g.banner_mask);
        aj.t(this.blX, d.C0140d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.blV != null && aVar != null) {
            this.blV.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.blW.setVisibility(0);
        } else {
            this.blW.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aRR = tbPageContext;
        this.link = str2;
        this.bma = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.blY && this.bma) {
            ViewGroup.LayoutParams layoutParams = this.blV.getLayoutParams();
            layoutParams.width = l.ao(getContext());
            layoutParams.height = (int) ((l.ao(getContext()) * this.blZ) + 0.5d);
            this.blV.setLayoutParams(layoutParams);
            this.blV.startLoad(str, 10, 640, 108, false);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = layoutParams.height;
                setLayoutParams(layoutParams2);
            }
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.bmc = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.blX.setBackgroundColor(i);
    }

    public boolean Ja() {
        return this.bma;
    }

    public TbImageView getBannerView() {
        return this.blV;
    }

    public void reset() {
        this.blY = false;
        this.bma = false;
    }

    public void Jb() {
        this.blV.postInvalidate();
    }
}
