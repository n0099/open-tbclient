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
/* loaded from: classes11.dex */
public class a implements b {
    private x aGe;
    private FrameLayout ajW;
    private HeadImageView heN;
    private int heO;
    private boolean isHost = false;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.ajW == null) {
            this.ajW = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.heN == null) {
            this.heN = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60));
            layoutParams.gravity = 17;
            this.ajW.addView(this.heN, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.ajW.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.heN.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
        } else {
            this.heN.setDefaultResource(a.e.sdk_icon_default_avatar100);
        }
        this.heN.setIsRound(true);
        this.heN.setDrawBorder(true);
        this.heN.setBorderColor(this.mTbPageContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.heN.setAutoChangeStyle(false);
        this.heN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.heN.setVisibility(8);
        this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
        this.ajW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aGe != null && a.this.aGe.mLiveInfo != null && com.baidu.live.af.a.SE().bwi != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aGe.mLiveInfo.live_id), String.valueOf(a.this.aGe.mLiveInfo.user_id), com.baidu.live.af.a.SE().bwi.aPa, a.this.heO, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.k.b
    public void a(x xVar) {
        this.aGe = xVar;
        if (xVar != null) {
            String str = null;
            if (xVar.mLiveInfo != null) {
                str = xVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
                this.heN.reset();
                this.heN.setVisibility(8);
                return;
            }
            m.a(this.heN, str, true, false);
            this.mIconView.setImageResource(a.e.icon_live_guardthrone_have);
            this.heN.setVisibility(0);
        }
    }

    @Override // com.baidu.live.k.b
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.k.b
    public View getView() {
        return this.ajW;
    }

    @Override // com.baidu.live.k.b
    public void eV(int i) {
        this.heO = i;
    }
}
