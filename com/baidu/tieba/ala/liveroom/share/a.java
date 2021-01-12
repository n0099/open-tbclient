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
import com.baidu.live.data.x;
import com.baidu.live.gift.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes10.dex */
public class a extends Dialog {
    private x aBr;
    private b hJh;
    private View hJi;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, x xVar, b bVar) {
        super(context);
        this.mContext = context;
        this.hJh = bVar;
        this.mPageContext = tbPageContext;
        this.aBr = xVar;
        initView();
    }

    private void initView() {
        ShareEntity R = R(this.aBr);
        if (R != null) {
            this.hJi = new AlaLandscapeShareView(this.mPageContext, R, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.hJh != null) {
                        a.this.hJh.dismiss();
                    }
                }
            });
            setContentView(this.hJi);
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
            Fn();
        }
    }

    private void Fn() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.hJi.startAnimation(translateAnimation);
    }

    private ShareEntity R(x xVar) {
        if (xVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = xVar.aFH.userId;
        shareEntity.userName = xVar.aFH.userName;
        shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
        shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
        String str = xVar.mLiveInfo.cover;
        if (str != null && !str.contains(".jpg")) {
            str = str + ".jpg";
        }
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = xVar.mLiveInfo.share_url;
        shareEntity.liveId = xVar.mLiveInfo != null ? xVar.mLiveInfo.live_id : 0L;
        return shareEntity;
    }
}
