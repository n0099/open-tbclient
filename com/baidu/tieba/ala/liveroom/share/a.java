package com.baidu.tieba.ala.liveroom.share;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes3.dex */
public class a extends Dialog {
    private n aDK;
    private b fPj;
    private View fPk;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, n nVar, b bVar) {
        super(context);
        this.mContext = context;
        this.fPj = bVar;
        this.mPageContext = tbPageContext;
        this.aDK = nVar;
        initView();
    }

    private void initView() {
        ShareEntity v = v(this.aDK);
        if (v != null) {
            this.fPk = new AlaLandscapeShareView(this.mPageContext, v, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.fPj != null) {
                        a.this.fPj.dismiss();
                    }
                }
            });
            setContentView(this.fPk);
            int screenWidth = com.baidu.live.gift.n.getScreenWidth(this.mContext);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
            Window window = getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
                window.setSoftInputMode(16);
                window.setGravity(81);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = screenWidth;
                window.setAttributes(attributes);
            }
            yl();
        }
    }

    private void yl() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.fPk.startAnimation(translateAnimation);
    }

    private ShareEntity v(n nVar) {
        if (nVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = nVar.aqk.userId;
        shareEntity.userName = nVar.aqk.userName;
        shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
        shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
        String str = nVar.mLiveInfo.cover;
        if (str != null && !str.contains(".jpg")) {
            str = str + ".jpg";
        }
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = nVar.mLiveInfo.share_url;
        shareEntity.liveId = nVar.mLiveInfo != null ? nVar.mLiveInfo.live_id : 0L;
        return shareEntity;
    }
}
