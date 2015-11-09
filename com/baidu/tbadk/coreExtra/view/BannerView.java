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
    private Button ajA;
    private TbImageView ajB;
    private boolean ajC;
    private float ajD;
    private boolean ajE;
    private a ajF;
    View.OnClickListener ajG;
    private String ajy;
    private String ajz;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void yM();

        void yN();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajy = "";
        this.ajz = "";
        this.ajC = false;
        this.ajD = 0.1388889f;
        this.ajE = false;
        this.ajG = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(i.g.bannerview, this);
        this.ajA = (Button) findViewById(i.f.btn_close);
        this.ajA.setOnClickListener(this.ajG);
        this.ajB = (TbImageView) findViewById(i.f.banner_image);
        this.ajB.setAutoChangeStyle(true);
        this.ajB.setOnClickListener(this.ajG);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.ajB != null && aVar != null) {
            this.ajB.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.ajE = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ajC && this.ajE) {
            ViewGroup.LayoutParams layoutParams = this.ajB.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.ajD) + 0.5d);
            this.ajB.setLayoutParams(layoutParams);
            this.ajB.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.ajF = aVar;
    }

    public boolean yL() {
        return this.ajE;
    }

    public void reset() {
        this.ajC = false;
        this.ajE = false;
    }

    public void oP() {
        this.ajB.postInvalidate();
    }
}
