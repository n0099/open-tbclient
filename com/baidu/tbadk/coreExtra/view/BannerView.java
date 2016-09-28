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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> Gd;
    private boolean anA;
    private float anB;
    private boolean anC;
    private com.baidu.tbadk.core.data.u anD;
    private a anE;
    View.OnClickListener anF;
    private String anv;
    private String anw;
    protected Button anx;
    protected TbImageView any;
    private TbImageView anz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AH();

        void AI();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public void setBannerData(com.baidu.tbadk.core.data.u uVar) {
        this.anD = uVar;
        com.baidu.tieba.recapp.g.a(this.anD.QK, this.anz, this.anD.QL, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds26));
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anv = "";
        this.anw = "";
        this.anA = false;
        this.anB = 0.16875f;
        this.anC = false;
        this.anF = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(r.h.bannerview, this);
        this.anx = (Button) findViewById(r.g.btn_close);
        this.anx.setOnClickListener(this.anF);
        this.any = (TbImageView) findViewById(r.g.banner_image);
        this.any.setAutoChangeStyle(true);
        this.any.setOnClickListener(this.anF);
        this.anz = (TbImageView) findViewById(r.g.tv_advert);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.any != null && aVar != null) {
            this.any.setEvent(aVar);
        }
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.anz.setVisibility(0);
        } else {
            this.anz.setVisibility(8);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.Gd = tbPageContext;
        this.link = str2;
        this.anC = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.anA && this.anC) {
            ViewGroup.LayoutParams layoutParams = this.any.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.K(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.anB) + 0.5d);
            this.any.setLayoutParams(layoutParams);
            this.any.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.anE = aVar;
    }

    public boolean AG() {
        return this.anC;
    }

    public void reset() {
        this.anA = false;
        this.anC = false;
    }

    public void lO() {
        this.any.postInvalidate();
    }
}
