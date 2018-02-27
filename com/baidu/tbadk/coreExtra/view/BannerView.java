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
    private TbPageContext<?> aRG;
    private String blF;
    private String blG;
    protected Button blH;
    protected TbImageView blI;
    private TbImageView blJ;
    private View blK;
    private boolean blL;
    private float blM;
    private boolean blN;
    private v blO;
    private a blP;
    View.OnClickListener blQ;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Jb();

        void Jc();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(v vVar) {
        this.blO = vVar;
        s.a(this.blO.aMr, this.blJ, this.blO.aMs, l.t(getContext(), d.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blF = "";
        this.blG = "";
        this.blL = false;
        this.blM = 0.16875f;
        this.blN = false;
        this.blQ = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerView.this.blH) {
                    if (!TextUtils.isEmpty(BannerView.this.blG)) {
                        TiebaStatic.log(BannerView.this.blG);
                    }
                    BannerView.this.blL = true;
                    BannerView.this.setVisibility(8);
                    if (BannerView.this.blP != null) {
                        BannerView.this.blP.Jc();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(BannerView.this.blF)) {
                    TiebaStatic.log(BannerView.this.blF);
                }
                if (BannerView.this.blP == null) {
                    if (!TextUtils.isEmpty(BannerView.this.link)) {
                        aw.Dt().c(BannerView.this.aRG, new String[]{BannerView.this.link});
                        if (!BannerView.this.link.startsWith("game:detail:") || !"frs_banner".equals(BannerView.this.type)) {
                            if (BannerView.this.link.startsWith("game:detail:") && "enterforum_banner".equals(BannerView.this.type)) {
                                TiebaStatic.eventStat(BannerView.this.aRG.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                                return;
                            }
                            return;
                        }
                        TiebaStatic.eventStat(BannerView.this.aRG.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                        return;
                    }
                    return;
                }
                BannerView.this.blP.Jb();
            }
        };
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.bannerview, this);
        this.blH = (Button) findViewById(d.g.btn_close);
        this.blH.setOnClickListener(this.blQ);
        this.blI = (TbImageView) findViewById(d.g.banner_image);
        this.blI.setAutoChangeStyle(true);
        this.blI.setOnClickListener(this.blQ);
        this.blJ = (TbImageView) findViewById(d.g.tv_advert);
        this.blK = findViewById(d.g.banner_mask);
        aj.t(this.blK, d.C0141d.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.blI != null && aVar != null) {
            this.blI.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.blJ.setVisibility(0);
        } else {
            this.blJ.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.aRG = tbPageContext;
        this.link = str2;
        this.blN = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.blL && this.blN) {
            ViewGroup.LayoutParams layoutParams = this.blI.getLayoutParams();
            layoutParams.width = l.ao(getContext());
            layoutParams.height = (int) ((l.ao(getContext()) * this.blM) + 0.5d);
            this.blI.setLayoutParams(layoutParams);
            this.blI.startLoad(str, 10, 640, 108, false);
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
        this.blP = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.blK.setBackgroundColor(i);
    }

    public boolean IZ() {
        return this.blN;
    }

    public TbImageView getBannerView() {
        return this.blI;
    }

    public void reset() {
        this.blL = false;
        this.blN = false;
    }

    public void Ja() {
        this.blI.postInvalidate();
    }
}
