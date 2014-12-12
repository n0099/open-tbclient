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
    private String Te;
    private String Tf;
    private Button Tg;
    private TbImageView Th;
    private boolean Ti;
    private float Tj;
    private boolean Tk;
    private b Tl;
    private String link;
    private TbPageContext<?> mContext;
    View.OnClickListener onClickListener;
    private String type;

    public void setBannerType(String str) {
        this.type = str;
    }

    public void ad(String str, String str2) {
        if (str != null && str2 != null) {
            this.Te = str;
            this.Tf = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Te = "";
        this.Tf = "";
        this.Ti = false;
        this.Tj = 0.1388889f;
        this.Tk = false;
        this.onClickListener = new a(this);
        init(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.bannerview, this);
        this.Tg = (Button) findViewById(com.baidu.tieba.w.btn_close);
        this.Tg.setOnClickListener(this.onClickListener);
        this.Th = (TbImageView) findViewById(com.baidu.tieba.w.banner_image);
        this.Th.setAutoChangeStyle(true);
        this.Th.setOnClickListener(this.onClickListener);
    }

    public void setBannerViewEvent(com.baidu.tbadk.widget.p pVar) {
        if (this.Th != null && pVar != null) {
            this.Th.setEvent(pVar);
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String str2) {
        this.mContext = tbPageContext;
        this.link = str2;
        this.Tk = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.Ti && this.Tk) {
            ViewGroup.LayoutParams layoutParams = this.Th.getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.M(getContext()) * this.Tj) + 0.5d);
            this.Th.setLayoutParams(layoutParams);
            this.Th.a(str, 10, 720, 100, false);
            setVisibility(0);
        }
    }

    public void b(TbPageContext<?> tbPageContext, String str) {
        a(tbPageContext, str, "");
    }

    public void setBannerViewClickListener(b bVar) {
        this.Tl = bVar;
    }

    public boolean tm() {
        return this.Tk;
    }

    public void reset() {
        this.Ti = false;
        this.Tk = false;
    }

    public void kE() {
        this.Th.postInvalidate();
    }
}
