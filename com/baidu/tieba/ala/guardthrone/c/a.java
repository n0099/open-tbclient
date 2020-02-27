package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.h.a {
    private m ald;
    private FrameLayout csX;
    private HeadImageView eJh;
    private boolean isHost = false;
    private int mGiftTabId;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.csX == null) {
            this.csX = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.eJh == null) {
            this.eJh = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60));
            layoutParams.gravity = 17;
            this.csX.addView(this.eJh, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.csX.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eJh.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
        } else {
            this.eJh.setDefaultResource(a.f.sdk_icon_default_avatar100);
        }
        this.eJh.setIsRound(true);
        this.eJh.setDrawBorder(true);
        this.eJh.setBorderColor(this.mTbPageContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eJh.setAutoChangeStyle(false);
        this.eJh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eJh.setVisibility(8);
        this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
        this.csX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.ald != null && a.this.ald.mLiveInfo != null && com.baidu.live.v.a.zj().awA != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.ald.mLiveInfo.live_id), String.valueOf(a.this.ald.mLiveInfo.user_id), com.baidu.live.v.a.zj().awA.aaT, a.this.mGiftTabId, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.h.a
    public void a(m mVar) {
        this.ald = mVar;
        if (mVar != null) {
            String str = null;
            if (mVar.mLiveInfo != null) {
                str = mVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
                this.eJh.reset();
                this.eJh.setVisibility(8);
                return;
            }
            k.a(this.eJh, str, true, false);
            this.mIconView.setImageResource(a.f.icon_live_guardthrone_have);
            this.eJh.setVisibility(0);
        }
    }

    @Override // com.baidu.live.h.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.h.a
    public View getView() {
        return this.csX;
    }

    @Override // com.baidu.live.h.a
    public void bV(int i) {
        this.mGiftTabId = i;
    }
}
