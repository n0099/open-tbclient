package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class g extends ProxyAdkBaseActivity<g> {
    private TbImageView fgY;
    private int from = 0;
    private int height;
    private TextView iNA;
    private String iNB;
    private String iNC;
    private int iND;
    private int iNE;
    private GifView iNy;
    private TextView iNz;
    private String iconUrl;
    private NavigationBar mNavigationBar;
    private String pid;
    private String pname;
    private String sharpText;
    private int width;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.emotion_activity);
        initData(bundle);
        initUI();
    }

    private void initData(Bundle bundle) {
        float f = getResources().getDisplayMetrics().density;
        this.iND = ((double) f) < 1.5d ? 160 : 240;
        this.iNE = ((double) f) >= 1.5d ? 240 : 160;
        if (bundle != null) {
            this.pid = bundle.getString("pid");
            this.pname = bundle.getString("panme");
            this.iconUrl = bundle.getString("iconUrl");
            this.iNB = bundle.getString("gifUrl");
            this.iNC = bundle.getString("staticUrl");
            this.sharpText = bundle.getString("sharpText");
            this.width = bundle.getInt("width");
            this.height = bundle.getInt("height");
        } else {
            Intent intent = getIntent();
            this.pid = intent.getStringExtra("pid");
            this.pname = intent.getStringExtra("panme");
            this.iconUrl = intent.getStringExtra("iconUrl");
            this.iNB = intent.getStringExtra("gifUrl");
            this.iNC = intent.getStringExtra("staticUrl");
            this.sharpText = intent.getStringExtra("sharpText");
            this.width = intent.getIntExtra("width", this.iND);
            this.height = intent.getIntExtra("height", this.iNE);
        }
        this.from = getIntent().getIntExtra("from", 0);
    }

    private void initUI() {
        FrameLayout.LayoutParams layoutParams;
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setTitleText(getString(R.string.emotion_image_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.finish();
            }
        });
        this.iNy = (GifView) findViewById(R.id.gifview);
        if (this.width == 0 || this.height == 0) {
            layoutParams = new FrameLayout.LayoutParams(this.iND, this.iNE, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.width, this.height, 17);
        }
        this.iNy.setLayoutParams(layoutParams);
        boolean bEZ = com.baidu.tbadk.util.m.bEZ();
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = this.sharpText;
        gifInfo.mGid = this.pid;
        gifInfo.mGifHeight = this.height;
        gifInfo.mGifWidth = this.width;
        if (bEZ) {
            gifInfo.mDynamicUrl = this.iNB;
        } else {
            gifInfo.mStaticUrl = this.iNC;
        }
        this.iNy.a(gifInfo);
        this.fgY = (TbImageView) findViewById(R.id.emotion_icon);
        if (!TextUtils.isEmpty(this.iconUrl)) {
            this.fgY.startLoad(this.iconUrl, 10, false);
        } else {
            Bitmap eQ = b.eQ(this.pid, "panel.png");
            if (eQ != null) {
                new com.baidu.adp.widget.ImageView.a(eQ, false).drawImageTo(this.fgY);
            }
        }
        this.iNz = (TextView) findViewById(R.id.emotion_pname);
        this.iNz.setText(this.pname);
        this.iNA = (TextView) findViewById(R.id.emotion_detail);
        this.iNA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                switch (g.this.from) {
                    case 1:
                        str = "faceshop_from_forum_detail";
                        break;
                    case 2:
                        str = "faceshop_from_pchat_detail";
                        break;
                    case 3:
                        str = "faceshop_from_gchat_detail";
                        break;
                    default:
                        str = "emotion_image";
                        break;
                }
                g.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(g.this.getPageContext().getPageActivity(), g.this.pid, false, str)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pid", this.pid);
        bundle.putString("panme", this.pname);
        bundle.putString("iconUrl", this.iconUrl);
        bundle.putString("gifUrl", this.iNB);
        bundle.putString("staticUrl", this.iNC);
        bundle.putString("sharpText", this.sharpText);
        bundle.putInt("width", this.width);
        bundle.putInt("height", this.height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(R.id.emotion_image_root));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
    }
}
