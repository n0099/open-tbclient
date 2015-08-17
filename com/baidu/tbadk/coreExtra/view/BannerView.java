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
    private TbPageContext<?> LS;
    private String aka;
    private String akb;
    private Button akc;
    private TbImageView akd;
    private boolean ake;
    private float akf;
    private boolean akg;
    private a akh;
    View.OnClickListener aki;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void yT();

        void yU();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aka = "";
        this.akb = "";
        this.ake = false;
        this.akf = 0.1388889f;
        this.akg = false;
        this.aki = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(i.g.bannerview, this);
        this.akc = (Button) findViewById(i.f.btn_close);
        this.akc.setOnClickListener(this.aki);
        this.akd = (TbImageView) findViewById(i.f.banner_image);
        this.akd.setAutoChangeStyle(true);
        this.akd.setOnClickListener(this.aki);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.akd != null && aVar != null) {
            this.akd.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.LS = tbPageContext;
        this.link = str2;
        this.akg = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.ake && this.akg) {
            ViewGroup.LayoutParams layoutParams = this.akd.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.K(getContext()) * this.akf) + 0.5d);
            this.akd.setLayoutParams(layoutParams);
            this.akd.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.akh = aVar;
    }

    public boolean yS() {
        return this.akg;
    }

    public void reset() {
        this.ake = false;
        this.akg = false;
    }

    public void oQ() {
        this.akd.postInvalidate();
    }
}
