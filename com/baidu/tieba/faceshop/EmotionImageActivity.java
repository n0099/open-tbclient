package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.h0.z0.o;
/* loaded from: classes4.dex */
public class EmotionImageActivity extends ProxyAdkBaseActivity<EmotionImageActivity> {

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f15572e;

    /* renamed from: f  reason: collision with root package name */
    public GifView f15573f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15574g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15575h;
    public TextView i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t = 0;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EmotionImageActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = EmotionImageActivity.this.t;
            EmotionImageActivity.this.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(EmotionImageActivity.this.getPageContext().getPageActivity(), EmotionImageActivity.this.j, false, i != 1 ? i != 2 ? i != 3 ? "emotion_image" : "faceshop_from_gchat_detail" : "faceshop_from_pchat_detail" : "faceshop_from_forum_detail")));
        }
    }

    public final void h(Bundle bundle) {
        double d2 = getResources().getDisplayMetrics().density;
        this.r = d2 < 1.5d ? 160 : 240;
        this.s = d2 >= 1.5d ? 240 : 160;
        if (bundle != null) {
            this.j = bundle.getString("pid");
            this.k = bundle.getString("panme");
            this.l = bundle.getString("iconUrl");
            this.m = bundle.getString("gifUrl");
            this.n = bundle.getString("staticUrl");
            this.o = bundle.getString("sharpText");
            this.p = bundle.getInt("width");
            this.q = bundle.getInt("height");
        } else {
            Intent intent = getIntent();
            this.j = intent.getStringExtra("pid");
            this.k = intent.getStringExtra("panme");
            this.l = intent.getStringExtra("iconUrl");
            this.m = intent.getStringExtra("gifUrl");
            this.n = intent.getStringExtra("staticUrl");
            this.o = intent.getStringExtra("sharpText");
            this.p = intent.getIntExtra("width", this.r);
            this.q = intent.getIntExtra("height", this.s);
        }
        this.t = getIntent().getIntExtra("from", 0);
    }

    public final void i() {
        FrameLayout.LayoutParams layoutParams;
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.f15572e = navigationBar;
        navigationBar.setTitleText(getString(R.string.emotion_image_title));
        this.f15572e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.f15573f = (GifView) findViewById(R.id.gifview);
        if (this.p != 0 && this.q != 0) {
            layoutParams = new FrameLayout.LayoutParams(this.p, this.q, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.r, this.s, 17);
        }
        this.f15573f.setLayoutParams(layoutParams);
        boolean f2 = o.f();
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = this.o;
        gifInfo.mGid = this.j;
        gifInfo.mGifHeight = this.q;
        gifInfo.mGifWidth = this.p;
        if (f2) {
            gifInfo.mDynamicUrl = this.m;
        } else {
            gifInfo.mStaticUrl = this.n;
        }
        this.f15573f.w0(gifInfo);
        this.f15574g = (TbImageView) findViewById(R.id.emotion_icon);
        if (!TextUtils.isEmpty(this.l)) {
            this.f15574g.W(this.l, 10, false);
        } else {
            Bitmap f3 = d.b.i0.l0.b.f(this.j, "panel.png");
            if (f3 != null) {
                new d.b.b.j.d.a(f3, false).h(this.f15574g);
            }
        }
        TextView textView = (TextView) findViewById(R.id.emotion_pname);
        this.f15575h = textView;
        textView.setText(this.k);
        TextView textView2 = (TextView) findViewById(R.id.emotion_detail);
        this.i = textView2;
        textView2.setOnClickListener(new b());
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().k(i == 1);
        getLayoutMode().j(findViewById(R.id.emotion_image_root));
        this.f15572e.onChangeSkinType(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.emotion_activity);
        h(bundle);
        i();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pid", this.j);
        bundle.putString("panme", this.k);
        bundle.putString("iconUrl", this.l);
        bundle.putString("gifUrl", this.m);
        bundle.putString("staticUrl", this.n);
        bundle.putString("sharpText", this.o);
        bundle.putInt("width", this.p);
        bundle.putInt("height", this.q);
    }
}
