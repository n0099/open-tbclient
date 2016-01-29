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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> MR;
    private String ani;
    private String anj;
    private Button ank;
    private TbImageView anl;
    private boolean anm;
    private float ann;
    private boolean ano;
    private a anp;
    View.OnClickListener anq;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void AM();

        void AN();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ani = "";
        this.anj = "";
        this.anm = false;
        this.ann = 0.1388889f;
        this.ano = false;
        this.anq = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(t.h.bannerview, this);
        this.ank = (Button) findViewById(t.g.btn_close);
        this.ank.setOnClickListener(this.anq);
        this.anl = (TbImageView) findViewById(t.g.banner_image);
        this.anl.setAutoChangeStyle(true);
        this.anl.setOnClickListener(this.anq);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.anl != null && aVar != null) {
            this.anl.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.MR = tbPageContext;
        this.link = str2;
        this.ano = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.anm && this.ano) {
            ViewGroup.LayoutParams layoutParams = this.anl.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.ann) + 0.5d);
            this.anl.setLayoutParams(layoutParams);
            this.anl.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.anp = aVar;
    }

    public boolean AL() {
        return this.ano;
    }

    public void reset() {
        this.anm = false;
        this.ano = false;
    }

    public void oO() {
        this.anl.postInvalidate();
    }
}
