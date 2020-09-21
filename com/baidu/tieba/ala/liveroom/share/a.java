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
import com.baidu.live.data.u;
import com.baidu.live.gift.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes4.dex */
public class a extends Dialog {
    private u aAP;
    private b gLO;
    private View gLP;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, u uVar, b bVar) {
        super(context);
        this.mContext = context;
        this.gLO = bVar;
        this.mPageContext = tbPageContext;
        this.aAP = uVar;
        initView();
    }

    private void initView() {
        ShareEntity C = C(this.aAP);
        if (C != null) {
            this.gLP = new AlaLandscapeShareView(this.mPageContext, C, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.gLO != null) {
                        a.this.gLO.dismiss();
                    }
                }
            });
            setContentView(this.gLP);
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
            GG();
        }
    }

    private void GG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.gLP.startAnimation(translateAnimation);
    }

    private ShareEntity C(u uVar) {
        if (uVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = uVar.aEz.userId;
        shareEntity.userName = uVar.aEz.userName;
        shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
        shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
        String str = uVar.mLiveInfo.cover;
        if (str != null && !str.contains(".jpg")) {
            str = str + ".jpg";
        }
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = uVar.mLiveInfo.share_url;
        shareEntity.liveId = uVar.mLiveInfo != null ? uVar.mLiveInfo.live_id : 0L;
        return shareEntity;
    }
}
