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
import com.baidu.live.data.q;
import com.baidu.live.gift.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView;
/* loaded from: classes4.dex */
public class a extends Dialog {
    private q avf;
    private b gwu;
    private View gwv;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, q qVar, b bVar) {
        super(context);
        this.mContext = context;
        this.gwu = bVar;
        this.mPageContext = tbPageContext;
        this.avf = qVar;
        initView();
    }

    private void initView() {
        ShareEntity x = x(this.avf);
        if (x != null) {
            this.gwv = new AlaLandscapeShareView(this.mPageContext, x, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.gwu != null) {
                        a.this.gwu.dismiss();
                    }
                }
            });
            setContentView(this.gwv);
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
            AD();
        }
    }

    private void AD() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.gwv.startAnimation(translateAnimation);
    }

    private ShareEntity x(q qVar) {
        if (qVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = qVar.ayC.userId;
        shareEntity.userName = qVar.ayC.userName;
        shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
        shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
        String str = qVar.mLiveInfo.cover;
        if (str != null && !str.contains(".jpg")) {
            str = str + ".jpg";
        }
        shareEntity.imageUrl = str;
        shareEntity.linkUrl = qVar.mLiveInfo.share_url;
        shareEntity.liveId = qVar.mLiveInfo != null ? qVar.mLiveInfo.live_id : 0L;
        return shareEntity;
    }
}
