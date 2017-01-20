package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> Fp;
    private String amX;
    private String amY;
    protected Button amZ;
    protected TbImageView ana;
    private TbImageView anb;
    private View anc;
    private boolean and;
    private float ane;
    private boolean anf;
    private com.baidu.tbadk.core.data.w ang;
    private a anh;
    View.OnClickListener ani;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Aw();

        void Ax();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.w wVar) {
        this.ang = wVar;
        com.baidu.tieba.recapp.r.a(this.ang.Qm, this.anb, this.ang.Qn, com.baidu.adp.lib.util.k.e(getContext(), r.f.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amX = "";
        this.amY = "";
        this.and = false;
        this.ane = 0.16875f;
        this.anf = false;
        this.ani = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(r.j.bannerview, this);
        this.amZ = (Button) findViewById(r.h.btn_close);
        this.amZ.setOnClickListener(this.ani);
        this.ana = (TbImageView) findViewById(r.h.banner_image);
        this.ana.setAutoChangeStyle(true);
        this.ana.setOnClickListener(this.ani);
        this.anb = (TbImageView) findViewById(r.h.tv_advert);
        this.anc = findViewById(r.h.banner_mask);
        ap.k(this.anc, r.e.black_alpha0);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ana != null && aVar != null) {
            this.ana.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.anb.setVisibility(0);
        } else {
            this.anb.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.Fp = tbPageContext;
        this.link = str2;
        this.anf = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.and && this.anf) {
            ViewGroup.LayoutParams layoutParams = this.ana.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.I(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.I(getContext()) * this.ane) + 0.5d);
            this.ana.setLayoutParams(layoutParams);
            this.ana.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = layoutParams.height;
                setLayoutParams(layoutParams2);
            }
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.anh = aVar;
    }

    public void setBannerMaskColor(int i) {
        this.anc.setBackgroundColor(i);
    }

    public boolean Av() {
        return this.anf;
    }

    public TbImageView getBannerView() {
        return this.ana;
    }

    public void reset() {
        this.and = false;
        this.anf = false;
    }

    public void lJ() {
        this.ana.postInvalidate();
    }
}
