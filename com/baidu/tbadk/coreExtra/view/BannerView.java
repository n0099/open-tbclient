package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> LN;
    private String adH;
    private String adI;
    private Button adJ;
    private TbImageView adK;
    private boolean adL;
    private float adM;
    private boolean adN;
    private b adO;
    View.OnClickListener adP;
    private String link;
    private String type;

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adH = "";
        this.adI = "";
        this.adL = false;
        this.adM = 0.1388889f;
        this.adN = false;
        this.adP = new a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.bannerview, this);
        this.adJ = (Button) findViewById(com.baidu.tieba.v.btn_close);
        this.adJ.setOnClickListener(this.adP);
        this.adK = (TbImageView) findViewById(com.baidu.tieba.v.banner_image);
        this.adK.setAutoChangeStyle(true);
        this.adK.setOnClickListener(this.adP);
    }

    public void setBannerViewEvent(com.baidu.tbadk.widget.n nVar) {
        if (this.adK != null && nVar != null) {
            this.adK.setEvent(nVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.LN = tbPageContext;
        this.link = str2;
        this.adN = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.adL && this.adN) {
            ViewGroup.LayoutParams layoutParams = this.adK.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.n.M(getContext()) * this.adM) + 0.5d);
            this.adK.setLayoutParams(layoutParams);
            this.adK.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(b bVar) {
        this.adO = bVar;
    }

    public boolean wQ() {
        return this.adN;
    }

    public void reset() {
        this.adL = false;
        this.adN = false;
    }

    public void oq() {
        this.adK.postInvalidate();
    }
}
