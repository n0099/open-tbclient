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
/* loaded from: classes4.dex */
public class AlaLandscapeShareView extends LinearLayout implements View.OnClickListener {
    private ShareEntity hsj;
    private a hsk;
    private TbPageContext mContext;
    private IShareChannel mShareChannel;

    /* loaded from: classes4.dex */
    interface a {
        void onClick(View view);
    }

    public AlaLandscapeShareView(TbPageContext tbPageContext, ShareEntity shareEntity, a aVar) {
        super(tbPageContext.getPageActivity());
        this.mContext = tbPageContext;
        this.hsj = shareEntity;
        this.hsk = aVar;
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
            this.hsj.shareType = 2;
            this.mShareChannel.shareToWeixin(this.hsj, null);
        } else if (id == a.f.ala_sdk_timeline_container) {
            this.hsj.shareType = 3;
            this.mShareChannel.shareToWeixinCircle(this.hsj, null);
        } else if (id == a.f.ala_sdk_qq_container) {
            this.hsj.shareType = 4;
            this.mShareChannel.shareToQQ(this.hsj, null);
        } else if (id == a.f.ala_sdk_sina_container) {
            this.hsj.shareType = 1;
            this.mShareChannel.shareToSinaWeibo(this.hsj, null);
        }
        if (this.hsk != null) {
            this.hsk.onClick(view);
        }
    }
}
