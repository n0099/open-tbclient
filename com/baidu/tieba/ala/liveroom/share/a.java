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
/* loaded from: classes3.dex */
public class a extends Dialog {
    private q aLQ;
    private b gqY;
    private View gqZ;
    private Context mContext;
    private TbPageContext mPageContext;

    public a(@NonNull Context context, TbPageContext tbPageContext, q qVar, b bVar) {
        super(context);
        this.mContext = context;
        this.gqY = bVar;
        this.mPageContext = tbPageContext;
        this.aLQ = qVar;
        initView();
    }

    private void initView() {
        ShareEntity x = x(this.aLQ);
        if (x != null) {
            this.gqZ = new AlaLandscapeShareView(this.mPageContext, x, new AlaLandscapeShareView.a() { // from class: com.baidu.tieba.ala.liveroom.share.a.1
                @Override // com.baidu.tieba.ala.liveroom.share.AlaLandscapeShareView.a
                public void onClick(View view) {
                    if (a.this.gqY != null) {
                        a.this.gqY.dismiss();
                    }
                }
            });
            setContentView(this.gqZ);
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
            Ab();
        }
    }

    private void Ab() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.gqZ.startAnimation(translateAnimation);
    }

    private ShareEntity x(q qVar) {
        if (qVar == null) {
            return null;
        }
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.userId = qVar.axp.userId;
        shareEntity.userName = qVar.axp.userName;
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
