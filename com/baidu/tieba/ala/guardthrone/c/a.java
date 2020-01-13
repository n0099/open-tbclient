package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.h.a {
    private l aiW;
    private FrameLayout coW;
    private HeadImageView eFn;
    private boolean isHost = false;
    private int mGiftTabId;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    public void initView() {
        if (this.coW == null) {
            this.coW = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.eFn == null) {
            this.eFn = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60));
            layoutParams.gravity = 17;
            this.coW.addView(this.eFn, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.coW.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eFn.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
        } else {
            this.eFn.setDefaultResource(a.f.sdk_icon_default_avatar100);
        }
        this.eFn.setIsRound(true);
        this.eFn.setDrawBorder(true);
        this.eFn.setBorderColor(this.mTbPageContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eFn.setAutoChangeStyle(false);
        this.eFn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eFn.setVisibility(8);
        this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
        this.coW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aiW != null && a.this.aiW.mLiveInfo != null && com.baidu.live.s.a.wR().asq != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aiW.mLiveInfo.live_id), String.valueOf(a.this.aiW.mLiveInfo.user_id), com.baidu.live.s.a.wR().asq.Zb, a.this.mGiftTabId, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.h.a
    public void a(l lVar) {
        this.aiW = lVar;
        if (lVar != null) {
            String str = null;
            if (lVar.mLiveInfo != null) {
                str = lVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
                this.eFn.reset();
                this.eFn.setVisibility(8);
                return;
            }
            k.a(this.eFn, str, true, false);
            this.mIconView.setImageResource(a.f.icon_live_guardthrone_have);
            this.eFn.setVisibility(0);
        }
    }

    @Override // com.baidu.live.h.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.h.a
    public View getView() {
        return this.coW;
    }

    @Override // com.baidu.live.h.a
    public void bJ(int i) {
        this.mGiftTabId = i;
    }
}
