package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.q;
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
    private q aJj;
    private FrameLayout ddl;
    private HeadImageView fCb;
    private boolean isHost = false;
    private int mGiftTabId;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.ddl == null) {
            this.ddl = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.fCb == null) {
            this.fCb = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60));
            layoutParams.gravity = 17;
            this.ddl.addView(this.fCb, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.ddl.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fCb.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
        } else {
            this.fCb.setDefaultResource(a.f.sdk_icon_default_avatar100);
        }
        this.fCb.setIsRound(true);
        this.fCb.setDrawBorder(true);
        this.fCb.setBorderColor(this.mTbPageContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.fCb.setAutoChangeStyle(false);
        this.fCb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fCb.setVisibility(8);
        this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
        this.ddl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aJj != null && a.this.aJj.mLiveInfo != null && com.baidu.live.v.a.Ge().aWF != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aJj.mLiveInfo.live_id), String.valueOf(a.this.aJj.mLiveInfo.user_id), com.baidu.live.v.a.Ge().aWF.ayw, a.this.mGiftTabId, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.h.a
    public void a(q qVar) {
        this.aJj = qVar;
        if (qVar != null) {
            String str = null;
            if (qVar.mLiveInfo != null) {
                str = qVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
                this.fCb.reset();
                this.fCb.setVisibility(8);
                return;
            }
            k.a(this.fCb, str, true, false);
            this.mIconView.setImageResource(a.f.icon_live_guardthrone_have);
            this.fCb.setVisibility(0);
        }
    }

    @Override // com.baidu.live.h.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.h.a
    public View getView() {
        return this.ddl;
    }

    @Override // com.baidu.live.h.a
    public void cr(int i) {
        this.mGiftTabId = i;
    }
}
