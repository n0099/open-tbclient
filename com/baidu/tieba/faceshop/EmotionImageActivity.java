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
    private String Lh;
    private TbImageView anF;
    private GifView asl;
    private TextView asm;
    private TextView asn;
    private String aso;
    private String asp;
    private int asq;
    private int asr;
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
        this.asq = ((double) f) < 1.5d ? 160 : 240;
        this.asr = ((double) f) >= 1.5d ? 240 : 160;
        if (bundle != null) {
            this.Lh = bundle.getString("pid");
            this.pname = bundle.getString("panme");
            this.iconUrl = bundle.getString("iconUrl");
            this.aso = bundle.getString("gifUrl");
            this.asp = bundle.getString("staticUrl");
            this.sharpText = bundle.getString("sharpText");
            this.width = bundle.getInt("width");
            this.height = bundle.getInt("height");
        } else {
            Intent intent = getIntent();
            this.Lh = intent.getStringExtra("pid");
            this.pname = intent.getStringExtra("panme");
            this.iconUrl = intent.getStringExtra("iconUrl");
            this.aso = intent.getStringExtra("gifUrl");
            this.asp = intent.getStringExtra("staticUrl");
            this.sharpText = intent.getStringExtra("sharpText");
            this.width = intent.getIntExtra("width", this.asq);
            this.height = intent.getIntExtra("height", this.asr);
        }
        this.from = getIntent().getIntExtra("from", 0);
    }

    private void initUI() {
        FrameLayout.LayoutParams layoutParams;
        com.baidu.adp.widget.a.a rP;
        this.mNavigationBar = (NavigationBar) findViewById(bz.navigation_bar);
        this.mNavigationBar.setTitleText(getString(cb.emotion_image_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.asl = (GifView) findViewById(bz.gifview);
        if (this.width == 0 || this.height == 0) {
            layoutParams = new FrameLayout.LayoutParams(this.asq, this.asr, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.width, this.height, 17);
        }
        this.asl.setLayoutParams(layoutParams);
        boolean va = com.baidu.tbadk.util.e.va();
        com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
        aVar.Tf = this.sharpText;
        aVar.Ti = this.Lh;
        aVar.Tk = this.height;
        aVar.Tj = this.width;
        if (va) {
            aVar.Th = this.aso;
        } else {
            aVar.Tg = this.asp;
        }
        this.asl.a(aVar);
        this.anF = (TbImageView) findViewById(bz.emotion_icon);
        if (!TextUtils.isEmpty(this.iconUrl)) {
            this.anF.c(this.iconUrl, 10, false);
        } else {
            com.baidu.tbadk.editortool.ad dh = com.baidu.tbadk.editortool.aa.rz().dh(this.Lh);
            if (dh != null && (rP = dh.rP()) != null) {
                rP.a(this.anF);
            }
        }
        this.asm = (TextView) findViewById(bz.emotion_pname);
        this.asm.setText(this.pname);
        this.asn = (TextView) findViewById(bz.emotion_detail);
        this.asn.setOnClickListener(new l(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pid", this.Lh);
        bundle.putString("panme", this.pname);
        bundle.putString("iconUrl", this.iconUrl);
        bundle.putString("gifUrl", this.aso);
        bundle.putString("staticUrl", this.asp);
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
