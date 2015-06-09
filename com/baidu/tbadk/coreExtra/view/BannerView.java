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
    private TbPageContext<?> LH;
    private String aeT;
    private String aeU;
    private Button aeV;
    private TbImageView aeW;
    private boolean aeX;
    private float aeY;
    private boolean aeZ;
    private b afa;
    View.OnClickListener afb;
    private String link;
    private String type;

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeT = "";
        this.aeU = "";
        this.aeX = false;
        this.aeY = 0.1388889f;
        this.aeZ = false;
        this.afb = new a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.bannerview, this);
        this.aeV = (Button) findViewById(com.baidu.tieba.q.btn_close);
        this.aeV.setOnClickListener(this.afb);
        this.aeW = (TbImageView) findViewById(com.baidu.tieba.q.banner_image);
        this.aeW.setAutoChangeStyle(true);
        this.aeW.setOnClickListener(this.afb);
    }

    public void setBannerViewEvent(com.baidu.tbadk.widget.n nVar) {
        if (this.aeW != null && nVar != null) {
            this.aeW.setEvent(nVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.LH = tbPageContext;
        this.link = str2;
        this.aeZ = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.aeX && this.aeZ) {
            ViewGroup.LayoutParams layoutParams = this.aeW.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.n.M(getContext()) * this.aeY) + 0.5d);
            this.aeW.setLayoutParams(layoutParams);
            this.aeW.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(b bVar) {
        this.afa = bVar;
    }

    public boolean xJ() {
        return this.aeZ;
    }

    public void reset() {
        this.aeX = false;
        this.aeZ = false;
    }

    public void oG() {
        this.aeW.postInvalidate();
    }
}
