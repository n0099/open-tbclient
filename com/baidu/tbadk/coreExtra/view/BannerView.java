package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private TbPageContext<?> DQ;
    private String akI;
    private String akJ;
    protected Button akK;
    protected TbImageView akL;
    private boolean akM;
    private float akN;
    private boolean akO;
    private a akP;
    View.OnClickListener akQ;
    private String link;
    private String type;

    /* loaded from: classes.dex */
    public interface a {
        void zp();

        void zq();
    }

    public void setBannerType(String str) {
        this.type = str;
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akI = "";
        this.akJ = "";
        this.akM = false;
        this.akN = 0.16875f;
        this.akO = false;
        this.akQ = new com.baidu.tbadk.coreExtra.view.a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(u.h.bannerview, this);
        this.akK = (Button) findViewById(u.g.btn_close);
        this.akK.setOnClickListener(this.akQ);
        this.akL = (TbImageView) findViewById(u.g.banner_image);
        this.akL.setAutoChangeStyle(true);
        this.akL.setOnClickListener(this.akQ);
    }

    public void setBannerViewEvent(TbImageView.a aVar) {
        if (this.akL != null && aVar != null) {
            this.akL.setEvent(aVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.DQ = tbPageContext;
        this.link = str2;
        this.akO = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.akM && this.akO) {
            ViewGroup.LayoutParams layoutParams = this.akL.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.k.A(getContext());
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.A(getContext()) * this.akN) + 0.5d);
            this.akL.setLayoutParams(layoutParams);
            this.akL.a(str, 10, TbConfig.PB_IMAGE_NEW_MAX_WIDTH, 108, false);
            setVisibility(0);
        }
    }

    public void c(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(a aVar) {
        this.akP = aVar;
    }

    public boolean zo() {
        return this.akO;
    }

    public void reset() {
        this.akM = false;
        this.akO = false;
    }

    public void kT() {
        this.akL.postInvalidate();
    }
}
