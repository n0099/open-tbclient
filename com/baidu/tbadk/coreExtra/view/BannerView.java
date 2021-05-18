package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.r.q.f0;
import d.a.k0.s2.y;
/* loaded from: classes3.dex */
public class BannerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public String f12715e;

    /* renamed from: f  reason: collision with root package name */
    public String f12716f;

    /* renamed from: g  reason: collision with root package name */
    public Button f12717g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f12718h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f12719i;
    public TbImageView j;
    public View k;
    public boolean l;
    public float m;
    public String n;
    public boolean o;
    public f0 p;
    public String q;
    public b r;
    public View.OnClickListener s;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BannerView bannerView = BannerView.this;
            if (view == bannerView.f12717g) {
                if (!TextUtils.isEmpty(bannerView.f12716f)) {
                    TiebaStatic.log(BannerView.this.f12716f);
                }
                BannerView.this.l = true;
                BannerView.this.setVisibility(8);
                if (BannerView.this.r != null) {
                    BannerView.this.r.a();
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(bannerView.f12715e)) {
                TiebaStatic.log(BannerView.this.f12715e);
            }
            if (BannerView.this.r == null) {
                if (TextUtils.isEmpty(BannerView.this.n)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(BannerView.this.f12719i, new String[]{BannerView.this.n});
                if (!BannerView.this.n.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) || !"frs_banner".equals(BannerView.this.q)) {
                    if (BannerView.this.n.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL) && "enterforum_banner".equals(BannerView.this.q)) {
                        TiebaStatic.eventStat(BannerView.this.f12719i.getPageActivity(), "enterforum_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000401", "ref_type", "603");
                        return;
                    }
                    return;
                }
                TiebaStatic.eventStat(BannerView.this.f12719i.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                return;
            }
            BannerView.this.r.b();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12715e = "";
        this.f12716f = "";
        this.l = false;
        this.m = 0.16875f;
        this.o = false;
        this.s = new a();
        h(context);
    }

    public TbImageView getBannerView() {
        return this.f12718h;
    }

    public final void h(Context context) {
        LayoutInflater.from(context).inflate(R.layout.bannerview, this);
        Button button = (Button) findViewById(R.id.btn_close);
        this.f12717g = button;
        button.setOnClickListener(this.s);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.banner_image);
        this.f12718h = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.f12718h.setOnClickListener(this.s);
        this.j = (TbImageView) findViewById(R.id.tv_advert);
        View findViewById = findViewById(R.id.banner_mask);
        this.k = findViewById;
        SkinManager.setBackgroundColor(findViewById, R.color.black_alpha0);
    }

    public boolean i() {
        return this.o;
    }

    public void j() {
        this.f12718h.postInvalidate();
    }

    public void k() {
        this.l = false;
        this.o = false;
    }

    public void setBannerData(f0 f0Var) {
        this.p = f0Var;
        y.k(f0Var.f49973g, this.j, f0Var.f49974h, l.g(getContext(), R.dimen.ds26));
    }

    public void setBannerMaskColor(int i2) {
        this.k.setBackgroundColor(i2);
    }

    public void setBannerType(String str) {
        this.q = str;
    }

    public void setBannerViewClickListener(b bVar) {
        this.r = bVar;
    }

    public void setBannerViewEvent(TbImageView.f fVar) {
        TbImageView tbImageView = this.f12718h;
        if (tbImageView == null || fVar == null) {
            return;
        }
        tbImageView.setEvent(fVar);
    }

    public void setData(TbPageContext<?> tbPageContext, String str, String str2) {
        this.f12719i = tbPageContext;
        this.n = str2;
        this.o = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
        setVisibility(8);
        if (!this.l && this.o) {
            ViewGroup.LayoutParams layoutParams = this.f12718h.getLayoutParams();
            layoutParams.width = l.k(getContext());
            layoutParams.height = (int) ((l.k(getContext()) * this.m) + 0.5d);
            this.f12718h.setLayoutParams(layoutParams);
            this.f12718h.R(str, 10, 640, 108, false);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = layoutParams.height;
                setLayoutParams(layoutParams2);
            }
            setVisibility(0);
        }
    }

    public void setMtjInfo(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f12715e = str;
        this.f12716f = str2;
    }

    public void setTagViewVisible(boolean z) {
        if (z) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public BannerView(Context context) {
        this(context, null);
    }

    public void setData(TbPageContext<?> tbPageContext, String str) {
        setData(tbPageContext, str, "");
    }
}
