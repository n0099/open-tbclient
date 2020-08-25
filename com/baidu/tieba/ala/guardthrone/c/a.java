package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class a implements com.baidu.live.h.a {
    private r aAh;
    private FrameLayout aht;
    private HeadImageView geN;
    private boolean isHost = false;
    private int mGiftTabId;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.aht == null) {
            this.aht = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.geN == null) {
            this.geN = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60));
            layoutParams.gravity = 17;
            this.aht.addView(this.geN, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.aht.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.geN.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
        } else {
            this.geN.setDefaultResource(a.f.sdk_icon_default_avatar100);
        }
        this.geN.setIsRound(true);
        this.geN.setDrawBorder(true);
        this.geN.setBorderColor(this.mTbPageContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.geN.setAutoChangeStyle(false);
        this.geN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.geN.setVisibility(8);
        this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
        this.aht.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aAh != null && a.this.aAh.mLiveInfo != null && com.baidu.live.w.a.Nk().beH != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aAh.mLiveInfo.live_id), String.valueOf(a.this.aAh.mLiveInfo.user_id), com.baidu.live.w.a.Nk().beH.aHi, a.this.mGiftTabId, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.h.a
    public void a(r rVar) {
        this.aAh = rVar;
        if (rVar != null) {
            String str = null;
            if (rVar.mLiveInfo != null) {
                str = rVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
                this.geN.reset();
                this.geN.setVisibility(8);
                return;
            }
            k.a(this.geN, str, true, false);
            this.mIconView.setImageResource(a.f.icon_live_guardthrone_have);
            this.geN.setVisibility(0);
        }
    }

    @Override // com.baidu.live.h.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.h.a
    public View getView() {
        return this.aht;
    }

    @Override // com.baidu.live.h.a
    public void ev(int i) {
        this.mGiftTabId = i;
    }
}
