package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.n;
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
    private n aDK;
    private FrameLayout cSk;
    private HeadImageView fon;
    private boolean isHost = false;
    private int mGiftTabId;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.cSk == null) {
            this.cSk = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.fon == null) {
            this.fon = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60));
            layoutParams.gravity = 17;
            this.cSk.addView(this.fon, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.cSk.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fon.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
        } else {
            this.fon.setDefaultResource(a.f.sdk_icon_default_avatar100);
        }
        this.fon.setIsRound(true);
        this.fon.setDrawBorder(true);
        this.fon.setBorderColor(this.mTbPageContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.fon.setAutoChangeStyle(false);
        this.fon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fon.setVisibility(8);
        this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
        this.cSk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aDK != null && a.this.aDK.mLiveInfo != null && com.baidu.live.v.a.En().aQu != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aDK.mLiveInfo.live_id), String.valueOf(a.this.aDK.mLiveInfo.user_id), com.baidu.live.v.a.En().aQu.aty, a.this.mGiftTabId, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.h.a
    public void a(n nVar) {
        this.aDK = nVar;
        if (nVar != null) {
            String str = null;
            if (nVar.mLiveInfo != null) {
                str = nVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
                this.fon.reset();
                this.fon.setVisibility(8);
                return;
            }
            k.a(this.fon, str, true, false);
            this.mIconView.setImageResource(a.f.icon_live_guardthrone_have);
            this.fon.setVisibility(0);
        }
    }

    @Override // com.baidu.live.h.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.h.a
    public View getView() {
        return this.cSk;
    }

    @Override // com.baidu.live.h.a
    public void ck(int i) {
        this.mGiftTabId = i;
    }
}
