package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.j.b;
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
public class a implements b {
    private w aFN;
    private FrameLayout ajk;
    private HeadImageView gSY;
    private int gSZ;
    private boolean isHost = false;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.ajk == null) {
            this.ajk = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.gSY == null) {
            this.gSY = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60));
            layoutParams.gravity = 17;
            this.ajk.addView(this.gSY, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.ajk.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gSY.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
        } else {
            this.gSY.setDefaultResource(a.e.sdk_icon_default_avatar100);
        }
        this.gSY.setIsRound(true);
        this.gSY.setDrawBorder(true);
        this.gSY.setBorderColor(this.mTbPageContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.gSY.setAutoChangeStyle(false);
        this.gSY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gSY.setVisibility(8);
        this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
        this.ajk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aFN != null && a.this.aFN.mLiveInfo != null && com.baidu.live.ae.a.RB().brA != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aFN.mLiveInfo.live_id), String.valueOf(a.this.aFN.mLiveInfo.user_id), com.baidu.live.ae.a.RB().brA.aOt, a.this.gSZ, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.j.b
    public void a(w wVar) {
        this.aFN = wVar;
        if (wVar != null) {
            String str = null;
            if (wVar.mLiveInfo != null) {
                str = wVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
                this.gSY.reset();
                this.gSY.setVisibility(8);
                return;
            }
            l.a(this.gSY, str, true, false);
            this.mIconView.setImageResource(a.e.icon_live_guardthrone_have);
            this.gSY.setVisibility(0);
        }
    }

    @Override // com.baidu.live.j.b
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.j.b
    public View getView() {
        return this.ajk;
    }

    @Override // com.baidu.live.j.b
    public void eX(int i) {
        this.gSZ = i;
    }
}
