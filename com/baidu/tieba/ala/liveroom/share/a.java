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
import com.baidu.live.data.w;
import com.baidu.live.gift.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes4.dex */
public class a extends Dialog {
    private w aES;
    private View hsA;
    private b hsz;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, w wVar, b bVar) {
        super(context);
        this.mContext = context;
        this.hsz = bVar;
        this.mPageContext = tbPageContext;
        this.aES = wVar;
        initView();
    }

    private void initView() {
        ShareEntity L = L(this.aES);
        if (L != null) {
            this.hsA = new AlaLandscapeShareView(this.mPageContext, L, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.hsz != null) {
                        a.this.hsz.dismiss();
                    }
                }
            });
            setContentView(this.hsA);
            int screenWidth = m.getScreenWidth(this.mContext);
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
            Iy();
        }
    }

    private void Iy() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.hsA.startAnimation(translateAnimation);
    }

    private ShareEntity L(w wVar) {
        if (wVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = wVar.aIV.userId;
        shareEntity.userName = wVar.aIV.userName;
        shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
        shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
        String str = wVar.mLiveInfo.cover;
        if (str != null && !str.contains(".jpg")) {
            str = str + ".jpg";
        }
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = wVar.mLiveInfo.share_url;
        shareEntity.liveId = wVar.mLiveInfo != null ? wVar.mLiveInfo.live_id : 0L;
        return shareEntity;
    }
}
