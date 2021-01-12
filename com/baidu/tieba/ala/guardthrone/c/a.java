package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.k.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import org.apache.http.HttpHost;
/* loaded from: classes10.dex */
public class a implements b {
    private x aBr;
    private FrameLayout ajf;
    private HeadImageView hah;
    private int hai;
    private boolean isHost = false;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.ajf == null) {
            this.ajf = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.hah == null) {
            this.hah = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60));
            layoutParams.gravity = 17;
            this.ajf.addView(this.hah, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.ajf.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hah.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
        } else {
            this.hah.setDefaultResource(a.e.sdk_icon_default_avatar100);
        }
        this.hah.setIsRound(true);
        this.hah.setDrawBorder(true);
        this.hah.setBorderColor(this.mTbPageContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hah.setAutoChangeStyle(false);
        this.hah.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hah.setVisibility(8);
        this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
        this.ajf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aBr != null && a.this.aBr.mLiveInfo != null && com.baidu.live.af.a.OJ().bru != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aBr.mLiveInfo.live_id), String.valueOf(a.this.aBr.mLiveInfo.user_id), com.baidu.live.af.a.OJ().bru.aKn, a.this.hai, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.k.b
    public void a(x xVar) {
        this.aBr = xVar;
        if (xVar != null) {
            String str = null;
            if (xVar.mLiveInfo != null) {
                str = xVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
                this.hah.reset();
                this.hah.setVisibility(8);
                return;
            }
            m.a(this.hah, str, true, false);
            this.mIconView.setImageResource(a.e.icon_live_guardthrone_have);
            this.hah.setVisibility(0);
        }
    }

    @Override // com.baidu.live.k.b
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.k.b
    public View getView() {
        return this.ajf;
    }

    @Override // com.baidu.live.k.b
    public void dp(int i) {
        this.hai = i;
    }
}
