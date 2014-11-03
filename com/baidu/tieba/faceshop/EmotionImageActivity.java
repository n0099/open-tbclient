package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class EmotionImageActivity extends BaseActivity {
    private String Li;
    private TbImageView anO;
    private int asA;
    private GifView asu;
    private TextView asv;
    private TextView asw;
    private String asx;
    private String asy;
    private int asz;
    private int from = 0;
    private int height;
    private String iconUrl;
    private NavigationBar mNavigationBar;
    private String pname;
    private String sharpText;
    private int width;

    static {
        TbadkApplication.m251getInst().RegisterIntent(EmotionImageActivityConfig.class, EmotionImageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ca.emotion_activity);
        d(bundle);
        initUI();
    }

    private void d(Bundle bundle) {
        float f = getResources().getDisplayMetrics().density;
        this.asz = ((double) f) < 1.5d ? 160 : 240;
        this.asA = ((double) f) >= 1.5d ? 240 : 160;
        if (bundle != null) {
            this.Li = bundle.getString("pid");
            this.pname = bundle.getString("panme");
            this.iconUrl = bundle.getString("iconUrl");
            this.asx = bundle.getString("gifUrl");
            this.asy = bundle.getString("staticUrl");
            this.sharpText = bundle.getString("sharpText");
            this.width = bundle.getInt("width");
            this.height = bundle.getInt("height");
        } else {
            Intent intent = getIntent();
            this.Li = intent.getStringExtra("pid");
            this.pname = intent.getStringExtra("panme");
            this.iconUrl = intent.getStringExtra("iconUrl");
            this.asx = intent.getStringExtra("gifUrl");
            this.asy = intent.getStringExtra("staticUrl");
            this.sharpText = intent.getStringExtra("sharpText");
            this.width = intent.getIntExtra("width", this.asz);
            this.height = intent.getIntExtra("height", this.asA);
        }
        this.from = getIntent().getIntExtra("from", 0);
    }

    private void initUI() {
        FrameLayout.LayoutParams layoutParams;
        com.baidu.adp.widget.a.a rR;
        this.mNavigationBar = (NavigationBar) findViewById(bz.navigation_bar);
        this.mNavigationBar.setTitleText(getString(cb.emotion_image_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.asu = (GifView) findViewById(bz.gifview);
        if (this.width == 0 || this.height == 0) {
            layoutParams = new FrameLayout.LayoutParams(this.asz, this.asA, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.width, this.height, 17);
        }
        this.asu.setLayoutParams(layoutParams);
        boolean vc = com.baidu.tbadk.util.e.vc();
        com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
        aVar.Tj = this.sharpText;
        aVar.Tm = this.Li;
        aVar.To = this.height;
        aVar.Tn = this.width;
        if (vc) {
            aVar.Tl = this.asx;
        } else {
            aVar.Tk = this.asy;
        }
        this.asu.a(aVar);
        this.anO = (TbImageView) findViewById(bz.emotion_icon);
        if (!TextUtils.isEmpty(this.iconUrl)) {
            this.anO.c(this.iconUrl, 10, false);
        } else {
            com.baidu.tbadk.editortool.ad dh = com.baidu.tbadk.editortool.aa.rB().dh(this.Li);
            if (dh != null && (rR = dh.rR()) != null) {
                rR.a(this.anO);
            }
        }
        this.asv = (TextView) findViewById(bz.emotion_pname);
        this.asv.setText(this.pname);
        this.asw = (TextView) findViewById(bz.emotion_detail);
        this.asw.setOnClickListener(new l(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pid", this.Li);
        bundle.putString("panme", this.pname);
        bundle.putString("iconUrl", this.iconUrl);
        bundle.putString("gifUrl", this.asx);
        bundle.putString("staticUrl", this.asy);
        bundle.putString("sharpText", this.sharpText);
        bundle.putInt("width", this.width);
        bundle.putInt("height", this.height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(findViewById(bz.emotion_image_root));
        this.mNavigationBar.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
