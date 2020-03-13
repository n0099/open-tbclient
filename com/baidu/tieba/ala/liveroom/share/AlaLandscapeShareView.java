package com.baidu.tieba.ala.liveroom.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaLandscapeShareView extends LinearLayout implements View.OnClickListener {
    private ShareEntity fkp;
    private a fkq;
    private TbPageContext mContext;
    private IShareChannel mShareChannel;

    /* loaded from: classes3.dex */
    interface a {
        void onClick(View view);
    }

    public AlaLandscapeShareView(TbPageContext tbPageContext, ShareEntity shareEntity, a aVar) {
        super(tbPageContext.getPageActivity());
        this.mContext = tbPageContext;
        this.fkp = shareEntity;
        this.fkq = aVar;
        this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_live_share_view_landscape, this);
        ((ViewGroup) findViewById(a.g.ala_sdk_weixin_container)).setOnClickListener(this);
        ((ViewGroup) findViewById(a.g.ala_sdk_timeline_container)).setOnClickListener(this);
        ((ViewGroup) findViewById(a.g.ala_sdk_qq_container)).setOnClickListener(this);
        ((ViewGroup) findViewById(a.g.ala_sdk_sina_container)).setOnClickListener(this);
        ((TextView) findViewById(a.g.ala_sdk_cancel)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mShareChannel == null) {
            this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
        }
        if (this.mShareChannel == null) {
            this.mContext.showToast(a.i.ala_live_share_no_channel);
            return;
        }
        int id = view.getId();
        if (id == a.g.ala_sdk_weixin_container) {
            this.fkp.shareType = 2;
            this.mShareChannel.shareToWeixin(this.fkp, null);
        } else if (id == a.g.ala_sdk_timeline_container) {
            this.fkp.shareType = 3;
            this.mShareChannel.shareToWeixinCircle(this.fkp, null);
        } else if (id == a.g.ala_sdk_qq_container) {
            this.fkp.shareType = 4;
            this.mShareChannel.shareToQQ(this.fkp, null);
        } else if (id == a.g.ala_sdk_sina_container) {
            this.fkp.shareType = 1;
            this.mShareChannel.shareToSinaWeibo(this.fkp, null);
        }
        if (this.fkq != null) {
            this.fkq.onClick(view);
        }
    }
}
