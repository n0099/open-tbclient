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
    private String TI;
    private String TJ;
    private Button TK;
    private TbImageView TL;
    private boolean TM;
    private float TN;
    private boolean TO;
    private b TP;
    View.OnClickListener TQ;
    private String link;
    private TbPageContext<?> mContext;
    private String type;

    public void setBannerType(String str) {
        this.type = str;
    }

    public void ag(String str, String str2) {
        if (str != null && str2 != null) {
            this.TI = str;
            this.TJ = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TI = "";
        this.TJ = "";
        this.TM = false;
        this.TN = 0.1388889f;
        this.TO = false;
        this.TQ = new a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.bannerview, this);
        this.TK = (Button) findViewById(com.baidu.tieba.w.btn_close);
        this.TK.setOnClickListener(this.TQ);
        this.TL = (TbImageView) findViewById(com.baidu.tieba.w.banner_image);
        this.TL.setAutoChangeStyle(true);
        this.TL.setOnClickListener(this.TQ);
    }

    public void setBannerViewEvent(com.baidu.tbadk.widget.p pVar) {
        if (this.TL != null && pVar != null) {
            this.TL.setEvent(pVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.TO = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.TM && this.TO) {
            ViewGroup.LayoutParams layoutParams = this.TL.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.M(getContext()) * this.TN) + 0.5d);
            this.TL.setLayoutParams(layoutParams);
            this.TL.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(b bVar) {
        this.TP = bVar;
    }

    public boolean tD() {
        return this.TO;
    }

    public void reset() {
        this.TM = false;
        this.TO = false;
    }

    public void kE() {
        this.TL.postInvalidate();
    }
}
