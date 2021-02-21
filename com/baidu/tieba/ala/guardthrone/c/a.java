package com.baidu.tieba.ala.guardthrone.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.j.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class a implements b {
    private ab aDd;
    private FrameLayout aiT;
    private HeadImageView hdf;
    private int hdg;
    private boolean isHost = false;
    private ImageView mIconView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.aiT == null) {
            this.aiT = new FrameLayout(this.mTbPageContext.getPageActivity());
        }
        if (this.hdf == null) {
            this.hdf = new HeadImageView(this.mTbPageContext.getPageActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60), BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds60));
            layoutParams.gravity = 17;
            this.aiT.addView(this.hdf, layoutParams);
        }
        if (this.mIconView == null) {
            this.mIconView = new ImageView(this.mTbPageContext.getPageActivity());
            this.aiT.addView(this.mIconView, new FrameLayout.LayoutParams(-2, -2));
        }
        this.hdf.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hdf.setIsRound(true);
        this.hdf.setDrawBorder(true);
        this.hdf.setBorderColor(this.mTbPageContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hdf.setAutoChangeStyle(false);
        this.hdf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hdf.setVisibility(8);
        this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
        this.aiT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UtilHelper.isFastDoubleClick() && a.this.aDd != null && a.this.aDd.mLiveInfo != null && com.baidu.live.ae.a.Qj().buX != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(a.this.aDd.mLiveInfo.live_id), String.valueOf(a.this.aDd.mLiveInfo.user_id), com.baidu.live.ae.a.Qj().buX.aNa, a.this.hdg, a.this.isHost)));
                }
            }
        });
    }

    @Override // com.baidu.live.j.b
    public void a(ab abVar) {
        this.aDd = abVar;
        if (abVar != null) {
            String str = null;
            if (abVar.mLiveInfo != null) {
                str = abVar.mLiveInfo.guardPortrait;
            }
            if (str == null || TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mIconView.setImageResource(a.e.icon_live_guardthrone_no);
                this.hdf.reset();
                this.hdf.setVisibility(8);
                return;
            }
            m.a(this.hdf, str, true, false);
            this.mIconView.setImageResource(a.e.icon_live_guardthrone_have);
            this.hdf.setVisibility(0);
        }
    }

    @Override // com.baidu.live.j.b
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.j.b
    public View getView() {
        return this.aiT;
    }

    @Override // com.baidu.live.j.b
    public void du(int i) {
        this.hdg = i;
    }
}
