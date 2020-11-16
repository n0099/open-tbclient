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
    private w aDh;
    private FrameLayout ail;
    private HeadImageView gJN;
    private boolean isHost = false;
    private int mGiftTabId;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.ail == null) {
            this.ail = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.gJN == null) {
            this.gJN = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60));
            layoutParams.gravity = 17;
            this.ail.addView(this.gJN, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.ail.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gJN.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
        } else {
            this.gJN.setDefaultResource(a.e.sdk_icon_default_avatar100);
        }
        this.gJN.setIsRound(true);
        this.gJN.setDrawBorder(true);
        this.gJN.setBorderColor(this.mTbPageContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.gJN.setAutoChangeStyle(false);
        this.gJN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gJN.setVisibility(8);
        this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
        this.ail.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aDh != null && a.this.aDh.mLiveInfo != null && com.baidu.live.aa.a.Ph().bms != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aDh.mLiveInfo.live_id), String.valueOf(a.this.aDh.mLiveInfo.user_id), com.baidu.live.aa.a.Ph().bms.aLy, a.this.mGiftTabId, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.h.a
    public void a(w wVar) {
        this.aDh = wVar;
        if (wVar != null) {
            String str = null;
            if (wVar.mLiveInfo != null) {
                str = wVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
                this.gJN.reset();
                this.gJN.setVisibility(8);
                return;
            }
            l.a(this.gJN, str, true, false);
            this.mIconView.setImageResource(a.e.icon_live_guardthrone_have);
            this.gJN.setVisibility(0);
        }
    }

    @Override // com.baidu.live.h.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.h.a
    public View getView() {
        return this.ail;
    }

    @Override // com.baidu.live.h.a
    public void eB(int i) {
        this.mGiftTabId = i;
    }
}
