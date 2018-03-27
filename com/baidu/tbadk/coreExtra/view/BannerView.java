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
    private TbPageContext<?> aRI;
    private String blI;
    private String blJ;
    protected Button blK;
    protected TbImageView blL;
    private TbImageView blM;
    private View blN;
    private boolean blO;
    private float blP;
    private boolean blQ;
    private v blR;
    private a blS;
    View.OnClickListener blT;
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
        this.blR = vVar;
        s.a(this.blR.aMs, this.blM, this.blR.aMt, l.t(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blI = "";
        this.blJ = "";
        this.blO = false;
        this.blP = 0.16875f;
        this.blQ = false;
        this.blT = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.blK) {
                    if (!TextUtils.isEmpty(BannerView.this.blJ)) {
                        TiebaStatic.log(BannerView.this.blJ);
                    }
                    BannerView.this.blO = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.blS != null) {
                        BannerView.this.blS.Jd();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.blI)) {
                    TiebaStatic.log(BannerView.this.blI);
                }
                if (BannerView.this.blS == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        aw.Du().c(BannerView.this.aRI, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aRI.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aRI.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.blS.Jc();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.blK = (Button) findViewById(d.g.btn_close);
        this.blK.setOnClickListener(this.blT);
        this.blL = (TbImageView) findViewById(d.g.banner_image);
        this.blL.setAutoChangeStyle(true);
        this.blL.setOnClickListener(this.blT);
        this.blM = (TbImageView) findViewById(d.g.tv_advert);
        this.blN = findViewById(d.g.banner_mask);
        aj.t(this.blN, d.C0141d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.blL != null && aVar != null) {
            this.blL.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.blM.setVisibility(0);
        } else {
            this.blM.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aRI = tbPageContext;
        this.link = str2;
        this.blQ = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.blO && this.blQ) {
            ViewGroup.LayoutParams layoutParams = this.blL.getLayoutParams();
            layoutParams.width = l.ao(getContext());
            layoutParams.height = (int) ((l.ao(getContext()) * this.blP) + 0.5d);
            this.blL.setLayoutParams(layoutParams);
            this.blL.startLoad(str, 10, 640, 108, false);
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
        this.blS = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.blN.setBackgroundColor(i);
    }

    public boolean Ja() {
        return this.blQ;
    }

    public TbImageView getBannerView() {
        return this.blL;
    }

    public void reset() {
        this.blO = false;
        this.blQ = false;
    }

    public void Jb() {
        this.blL.postInvalidate();
    }
}
