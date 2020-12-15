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
import com.baidu.live.gift.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes4.dex */
public class a extends Dialog {
    private w aFN;
    private b hBM;
    private View hBN;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, w wVar, b bVar) {
        super(context);
        this.mContext = context;
        this.hBM = bVar;
        this.mPageContext = tbPageContext;
        this.aFN = wVar;
        initView();
    }

    private void initView() {
        ShareEntity Q = Q(this.aFN);
        if (Q != null) {
            this.hBN = new AlaLandscapeShareView(this.mPageContext, Q, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.hBM != null) {
                        a.this.hBM.dismiss();
                    }
                }
            });
            setContentView(this.hBN);
            int screenWidth = n.getScreenWidth(this.mContext);
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
            JG();
        }
    }

    private void JG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.hBN.startAnimation(translateAnimation);
    }

    private ShareEntity Q(w wVar) {
        if (wVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = wVar.aJV.userId;
        shareEntity.userName = wVar.aJV.userName;
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
