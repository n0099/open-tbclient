package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.h.a {
    private w aEc;
    private FrameLayout aii;
    private HeadImageView gEt;
    private boolean isHost = false;
    private int mGiftTabId;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.aii == null) {
            this.aii = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.gEt == null) {
            this.gEt = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60));
            layoutParams.gravity = 17;
            this.aii.addView(this.gEt, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.aii.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gEt.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
        } else {
            this.gEt.setDefaultResource(a.f.sdk_icon_default_avatar100);
        }
        this.gEt.setIsRound(true);
        this.gEt.setDrawBorder(true);
        this.gEt.setBorderColor(this.mTbPageContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.gEt.setAutoChangeStyle(false);
        this.gEt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gEt.setVisibility(8);
        this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
        this.aii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aEc != null && a.this.aEc.mLiveInfo != null && com.baidu.live.z.a.Pq().bmJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aEc.mLiveInfo.live_id), String.valueOf(a.this.aEc.mLiveInfo.user_id), com.baidu.live.z.a.Pq().bmJ.aMj, a.this.mGiftTabId, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.h.a
    public void a(w wVar) {
        this.aEc = wVar;
        if (wVar != null) {
            String str = null;
            if (wVar.mLiveInfo != null) {
                str = wVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
                this.gEt.reset();
                this.gEt.setVisibility(8);
                return;
            }
            l.a(this.gEt, str, true, false);
            this.mIconView.setImageResource(a.f.icon_live_guardthrone_have);
            this.gEt.setVisibility(0);
        }
    }

    @Override // com.baidu.live.h.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.h.a
    public View getView() {
        return this.aii;
    }

    @Override // com.baidu.live.h.a
    public void eF(int i) {
        this.mGiftTabId = i;
    }
}
