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
    private String No;
    private String Np;
    private Button Nq;
    private TbImageView Nr;
    private boolean Ns;
    private float Nt;
    private boolean Nu;
    private b Nv;
    View.OnClickListener Nw;
    private String link;
    private Context mContext;

    public void R(String str, String str2) {
        if (str != null && str2 != null) {
            this.No = str;
            this.Np = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.No = "";
        this.Np = "";
        this.Ns = false;
        this.Nt = 0.1388889f;
        this.Nu = false;
        this.Nw = new a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.bannerview, this);
        this.Nq = (Button) findViewById(com.baidu.tieba.v.btn_close);
        this.Nq.setOnClickListener(this.Nw);
        this.Nr = (TbImageView) findViewById(com.baidu.tieba.v.banner_image);
        this.Nr.setAutoChangeStyle(true);
        this.Nr.setOnClickListener(this.Nw);
    }

    public void S(String str, String str2) {
        this.link = str2;
        this.Nu = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.Ns && this.Nu) {
            ViewGroup.LayoutParams layoutParams = this.Nr.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.m.n(getContext()) * this.Nt) + 0.5d);
            this.Nr.setLayoutParams(layoutParams);
            this.Nr.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void setData(String str) {
        S(str, "");
    }

    public void setBannerViewClickListener(b bVar) {
        this.Nv = bVar;
    }

    public boolean pR() {
        return this.Nu;
    }

    public void reset() {
        this.Ns = false;
        this.Nu = false;
    }

    public void pS() {
        this.Nr.postInvalidate();
    }
}
