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
    private TbPageContext<?> LP;
    private String adP;
    private String adQ;
    private Button adR;
    private TbImageView adS;
    private boolean adT;
    private float adU;
    private boolean adV;
    private b adW;
    View.OnClickListener adX;
    private String link;
    private String type;

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adP = "";
        this.adQ = "";
        this.adT = false;
        this.adU = 0.1388889f;
        this.adV = false;
        this.adX = new a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.hH().inflate(context, com.baidu.tieba.w.bannerview, this);
        this.adR = (Button) findViewById(com.baidu.tieba.v.btn_close);
        this.adR.setOnClickListener(this.adX);
        this.adS = (TbImageView) findViewById(com.baidu.tieba.v.banner_image);
        this.adS.setAutoChangeStyle(true);
        this.adS.setOnClickListener(this.adX);
    }

    public void setBannerViewEvent(com.baidu.tbadk.widget.n nVar) {
        if (this.adS != null && nVar != null) {
            this.adS.setEvent(nVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.LP = tbPageContext;
        this.link = str2;
        this.adV = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.adT && this.adV) {
            ViewGroup.LayoutParams layoutParams = this.adS.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.n.M(getContext()) * this.adU) + 0.5d);
            this.adS.setLayoutParams(layoutParams);
            this.adS.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(b bVar) {
        this.adW = bVar;
    }

    public boolean wW() {
        return this.adV;
    }

    public void reset() {
        this.adT = false;
        this.adV = false;
    }

    public void oq() {
        this.adS.postInvalidate();
    }
}
