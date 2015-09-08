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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    View.OnClickListener akA;
    private String aks;
    private String akt;
    private Button aku;
    private TbImageView akv;
    private boolean akw;
    private float akx;
    private boolean aky;
    private a akz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void za();

        void zb();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aks = "";
        this.akt = "";
        this.akw = false;
        this.akx = 0.1388889f;
        this.aky = false;
        this.akA = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(i.g.bannerview, this);
        this.aku = (Button) findViewById(i.f.btn_close);
        this.aku.setOnClickListener(this.akA);
        this.akv = (TbImageView) findViewById(i.f.banner_image);
        this.akv.setAutoChangeStyle(true);
        this.akv.setOnClickListener(this.akA);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.akv != null && aVar != null) {
            this.akv.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.aky = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.akw && this.aky) {
            ViewGroup.LayoutParams layoutParams = this.akv.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.akx) + 0.5d);
            this.akv.setLayoutParams(layoutParams);
            this.akv.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.akz = aVar;
    }

    public boolean yZ() {
        return this.aky;
    }

    public void reset() {
        this.akw = false;
        this.aky = false;
    }

    public void oN() {
        this.akv.postInvalidate();
    }
}
