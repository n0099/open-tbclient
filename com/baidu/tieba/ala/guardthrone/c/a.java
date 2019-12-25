package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.g.a {
    private k aio;
    private FrameLayout coJ;
    private HeadImageView eEc;
    private int eEd;
    private boolean isHost = false;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    public void initView() {
        if (this.coJ == null) {
            this.coJ = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.eEc == null) {
            this.eEc = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds60));
            layoutParams.gravity = 17;
            this.coJ.addView(this.eEc, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.coJ.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eEc.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
        } else {
            this.eEc.setDefaultResource(a.f.sdk_icon_default_avatar100);
        }
        this.eEc.setIsRound(true);
        this.eEc.setDrawBorder(true);
        this.eEc.setBorderColor(this.mTbPageContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.eEc.setAutoChangeStyle(false);
        this.eEc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eEc.setVisibility(8);
        this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
        this.coJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aio != null && a.this.aio.mLiveInfo != null && com.baidu.live.r.a.wA().arE != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aio.mLiveInfo.live_id), String.valueOf(a.this.aio.mLiveInfo.user_id), com.baidu.live.r.a.wA().arE.YP, a.this.eEd, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.g.a
    public void a(k kVar) {
        this.aio = kVar;
        if (kVar != null) {
            String str = null;
            if (kVar.mLiveInfo != null) {
                str = kVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.f.icon_live_guardthrone_no);
                this.eEc.reset();
                this.eEc.setVisibility(8);
                return;
            }
            com.baidu.live.utils.k.a(this.eEc, str, true, false);
            this.mIconView.setImageResource(a.f.icon_live_guardthrone_have);
            this.eEc.setVisibility(0);
        }
    }

    @Override // com.baidu.live.g.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.g.a
    public View getView() {
        return this.coJ;
    }

    @Override // com.baidu.live.g.a
    public void bJ(int i) {
        this.eEd = i;
    }
}
