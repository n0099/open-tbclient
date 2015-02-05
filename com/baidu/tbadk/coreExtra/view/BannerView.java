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
    private String TF;
    private String TG;
    private Button TH;
    private TbImageView TI;
    private boolean TJ;
    private float TK;
    private boolean TL;
    private b TM;
    View.OnClickListener TN;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    public void setBannerType(String str) {
        this.type = str;
    }

    public void ag(String str, String str2) {
        if (str != null && str2 != null) {
            this.TF = str;
            this.TG = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TF = "";
        this.TG = "";
        this.TJ = false;
        this.TK = 0.1388889f;
        this.TL = false;
        this.TN = new a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.bannerview, this);
        this.TH = (Button) findViewById(com.baidu.tieba.w.btn_close);
        this.TH.setOnClickListener(this.TN);
        this.TI = (TbImageView) findViewById(com.baidu.tieba.w.banner_image);
        this.TI.setAutoChangeStyle(true);
        this.TI.setOnClickListener(this.TN);
    }

    public void setBannerViewEvent(com.baidu.tbadk.widget.p pVar) {
        if (this.TI != null && pVar != null) {
            this.TI.setEvent(pVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.TL = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.TJ && this.TL) {
            ViewGroup.LayoutParams layoutParams = this.TI.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.M(getContext()) * this.TK) + 0.5d);
            this.TI.setLayoutParams(layoutParams);
            this.TI.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(b bVar) {
        this.TM = bVar;
    }

    public boolean tx() {
        return this.TL;
    }

    public void reset() {
        this.TJ = false;
        this.TL = false;
    }

    public void kx() {
        this.TI.postInvalidate();
    }
}
