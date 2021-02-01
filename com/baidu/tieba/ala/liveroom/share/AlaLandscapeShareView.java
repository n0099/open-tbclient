package com.baidu.tieba.ala.liveroom.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
/* loaded from: classes11.dex */
public class AlaLandscapeShareView extends LinearLayout implements View.OnClickListener {
    private ShareEntity hNI;
    private a hNJ;
    private TbPageContext mContext;
    private IShareChannel mShareChannel;

    /* loaded from: classes11.dex */
    interface a {
        void onClick(View view);
    }

    public AlaLandscapeShareView(TbPageContext tbPageContext, ShareEntity shareEntity, a aVar) {
        super(tbPageContext.getPageActivity());
        this.mContext = tbPageContext;
        this.hNI = shareEntity;
        this.hNJ = aVar;
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_live_share_view_landscape, this);
        ((ViewGroup) findViewById(a.f.ala_sdk_weixin_container)).setOnClickListener(this);
        ((ViewGroup) findViewById(a.f.ala_sdk_timeline_container)).setOnClickListener(this);
        ((ViewGroup) findViewById(a.f.ala_sdk_qq_container)).setOnClickListener(this);
        ((ViewGroup) findViewById(a.f.ala_sdk_sina_container)).setOnClickListener(this);
        ((TextView) findViewById(a.f.ala_sdk_cancel)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mShareChannel == null) {
            this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
        }
        if (this.mShareChannel == null) {
            this.mContext.showToast(a.h.ala_live_share_no_channel);
            return;
        }
        int id = view.getId();
        if (id == a.f.ala_sdk_weixin_container) {
            this.hNI.shareType = 2;
            this.mShareChannel.shareToWeixin(this.hNI, null);
        } else if (id == a.f.ala_sdk_timeline_container) {
            this.hNI.shareType = 3;
            this.mShareChannel.shareToWeixinCircle(this.hNI, null);
        } else if (id == a.f.ala_sdk_qq_container) {
            this.hNI.shareType = 4;
            this.mShareChannel.shareToQQ(this.hNI, null);
        } else if (id == a.f.ala_sdk_sina_container) {
            this.hNI.shareType = 1;
            this.mShareChannel.shareToSinaWeibo(this.hNI, null);
        }
        if (this.hNJ != null) {
            this.hNJ.onClick(view);
        }
    }
}
