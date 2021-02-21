package com.baidu.tieba.ala.liveroom.share;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ab;
import com.baidu.live.gift.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes11.dex */
public class a extends Dialog {
    private ab aDd;
    private b hNT;
    private View hNU;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, ab abVar, b bVar) {
        super(context);
        this.mContext = context;
        this.hNT = bVar;
        this.mPageContext = tbPageContext;
        this.aDd = abVar;
        initView();
    }

    private void initView() {
        ShareEntity T = T(this.aDd);
        if (T != null) {
            this.hNU = new AlaLandscapeShareView(this.mPageContext, T, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.hNT != null) {
                        a.this.hNT.dismiss();
                    }
                }
            });
            setContentView(this.hNU);
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
            GD();
        }
    }

    private void GD() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.hNU.startAnimation(translateAnimation);
    }

    private ShareEntity T(ab abVar) {
        if (abVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = abVar.aId.userId;
        shareEntity.userName = abVar.aId.userName;
        shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
        shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
        String str = abVar.mLiveInfo.cover;
        if (str != null && !str.contains(".jpg")) {
            str = str + ".jpg";
        }
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = abVar.mLiveInfo.share_url;
        shareEntity.liveId = abVar.mLiveInfo != null ? abVar.mLiveInfo.live_id : 0L;
        return shareEntity;
    }
}
