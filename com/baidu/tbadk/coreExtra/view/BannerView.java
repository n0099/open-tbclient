package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private String alj;
    private String alk;
    private Button all;
    private TbImageView alm;
    private boolean aln;
    private float alo;
    private boolean alp;
    private a alq;
    View.OnClickListener alr;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void zI();

        void zJ();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alj = "";
        this.alk = "";
        this.aln = false;
        this.alo = 0.1388889f;
        this.alp = false;
        this.alr = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(n.g.bannerview, this);
        this.all = (Button) findViewById(n.f.btn_close);
        this.all.setOnClickListener(this.alr);
        this.alm = (TbImageView) findViewById(n.f.banner_image);
        this.alm.setAutoChangeStyle(true);
        this.alm.setOnClickListener(this.alr);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.alm != null && aVar != null) {
            this.alm.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.alp = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aln && this.alp) {
            ViewGroup.LayoutParams layoutParams = this.alm.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.alo) + 0.5d);
            this.alm.setLayoutParams(layoutParams);
            this.alm.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.alq = aVar;
    }

    public boolean zH() {
        return this.alp;
    }

    public void reset() {
        this.aln = false;
        this.alp = false;
    }

    public void oV() {
        this.alm.postInvalidate();
    }
}
