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
import com.baidu.live.data.l;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes2.dex */
public class a extends Dialog {
    private l aiW;
    private b fgS;
    private View fgT;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, l lVar, b bVar) {
        super(context);
        this.mContext = context;
        this.fgS = bVar;
        this.mPageContext = tbPageContext;
        this.aiW = lVar;
        initView();
    }

    private void initView() {
        ShareEntity r = r(this.aiW);
        if (r != null) {
            this.fgT = new AlaLandscapeShareView(this.mPageContext, r, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.fgS != null) {
                        a.this.fgS.dismiss();
                    }
                }
            });
            setContentView(this.fgT);
            int screenWidth = com.baidu.live.gift.b.c.getScreenWidth(this.mContext);
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
            sB();
        }
    }

    private void sB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.fgT.startAnimation(translateAnimation);
    }

    private ShareEntity r(l lVar) {
        if (lVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = lVar.Wf.userId;
        shareEntity.userName = lVar.Wf.userName;
        shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
        shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
        String str = lVar.mLiveInfo.cover;
        if (str != null && !str.contains(".jpg")) {
            str = str + ".jpg";
        }
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = lVar.mLiveInfo.share_url;
        return shareEntity;
    }
}
