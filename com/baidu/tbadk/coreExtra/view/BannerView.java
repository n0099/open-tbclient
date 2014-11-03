package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    View.OnClickListener NA;
    private String Ns;
    private String Nt;
    private Button Nu;
    private TbImageView Nv;
    private boolean Nw;
    private float Nx;
    private boolean Ny;
    private b Nz;
    private String link;
    private Context mContext;

    public void R(String str, String str2) {
        if (str != null && str2 != null) {
            this.Ns = str;
            this.Nt = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ns = "";
        this.Nt = "";
        this.Nw = false;
        this.Nx = 0.1388889f;
        this.Ny = false;
        this.NA = new a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.bannerview, this);
        this.Nu = (Button) findViewById(com.baidu.tieba.v.btn_close);
        this.Nu.setOnClickListener(this.NA);
        this.Nv = (TbImageView) findViewById(com.baidu.tieba.v.banner_image);
        this.Nv.setAutoChangeStyle(true);
        this.Nv.setOnClickListener(this.NA);
    }

    public void S(String str, String str2) {
        this.link = str2;
        this.Ny = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.Nw && this.Ny) {
            ViewGroup.LayoutParams layoutParams = this.Nv.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.m.n(getContext()) * this.Nx) + 0.5d);
            this.Nv.setLayoutParams(layoutParams);
            this.Nv.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void setData(String str) {
        S(str, "");
    }

    public void setBannerViewClickListener(b bVar) {
        this.Nz = bVar;
    }

    public boolean pT() {
        return this.Ny;
    }

    public void reset() {
        this.Nw = false;
        this.Ny = false;
    }

    public void pU() {
        this.Nv.postInvalidate();
    }
}
