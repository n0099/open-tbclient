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
import com.baidu.live.data.r;
import com.baidu.live.gift.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes7.dex */
public class a extends Dialog {
    private r aAj;
    private b gIx;
    private View gIy;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, r rVar, b bVar) {
        super(context);
        this.mContext = context;
        this.gIx = bVar;
        this.mPageContext = tbPageContext;
        this.aAj = rVar;
        initView();
    }

    private void initView() {
        ShareEntity z = z(this.aAj);
        if (z != null) {
            this.gIy = new AlaLandscapeShareView(this.mPageContext, z, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.gIx != null) {
                        a.this.gIx.dismiss();
                    }
                }
            });
            setContentView(this.gIy);
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
            Gg();
        }
    }

    private void Gg() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.gIy.startAnimation(translateAnimation);
    }

    private ShareEntity z(r rVar) {
        if (rVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = rVar.aDG.userId;
        shareEntity.userName = rVar.aDG.userName;
        shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
        shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
        String str = rVar.mLiveInfo.cover;
        if (str != null && !str.contains(".jpg")) {
            str = str + ".jpg";
        }
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = rVar.mLiveInfo.share_url;
        shareEntity.liveId = rVar.mLiveInfo != null ? rVar.mLiveInfo.live_id : 0L;
        return shareEntity;
    }
}
