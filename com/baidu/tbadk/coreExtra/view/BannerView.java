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
    private TbPageContext<?> MX;
    private String anA;
    private Button anB;
    private TbImageView anC;
    private boolean anD;
    private float anE;
    private boolean anF;
    private a anG;
    View.OnClickListener anH;
    private String anz;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void Bp();

        void Bq();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anz = "";
        this.anA = "";
        this.anD = false;
        this.anE = 0.1388889f;
        this.anF = false;
        this.anH = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(t.h.bannerview, this);
        this.anB = (Button) findViewById(t.g.btn_close);
        this.anB.setOnClickListener(this.anH);
        this.anC = (TbImageView) findViewById(t.g.banner_image);
        this.anC.setAutoChangeStyle(true);
        this.anC.setOnClickListener(this.anH);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.anC != null && aVar != null) {
            this.anC.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.MX = tbPageContext;
        this.link = str2;
        this.anF = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.anD && this.anF) {
            ViewGroup.LayoutParams layoutParams = this.anC.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.B(getContext()) * this.anE) + 0.5d);
            this.anC.setLayoutParams(layoutParams);
            this.anC.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.anG = aVar;
    }

    public boolean Bo() {
        return this.anF;
    }

    public void reset() {
        this.anD = false;
        this.anF = false;
    }

    public void oH() {
        this.anC.postInvalidate();
    }
}
