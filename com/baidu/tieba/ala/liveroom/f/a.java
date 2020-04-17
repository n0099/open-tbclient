package com.baidu.tieba.ala.liveroom.f;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.webkit.JsResult;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import com.baidu.live.view.d;
import com.baidu.live.view.web.f;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.ala.liveroom.f.b;
/* loaded from: classes3.dex */
public class a implements f, b.a {
    private CustomMessageListener aGM;
    private b fEB;
    private d fEC;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        zr();
    }

    public void AB(String str) {
        this.fEB = new b(this.mPageContext.getPageActivity());
        this.fEB.a(this);
        this.fEB.b(this);
        this.fEB.bmE().setBackgroundColor(zq(str));
        this.fEB.show(str);
    }

    public void resume() {
        if (this.fEB != null && this.fEB.isShowing() && this.fEB.bmE() != null) {
            this.fEB.bmE().onResume();
            this.fEB.bmE().reload();
        }
    }

    public void pause() {
        if (this.fEB != null && this.fEB.isShowing() && this.fEB.bmE() != null) {
            this.fEB.bmE().onPause();
        }
    }

    public void release() {
        buV();
        MessageManager.getInstance().unRegisterListener(this.aGM);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.fEC = new d(this.mPageContext.getPageActivity());
        this.fEC.setCancelable(false);
        this.fEC.setCanceledOnTouchOutside(false);
        this.fEC.ci(false);
        this.fEC.n(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.fEC.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // com.baidu.live.view.d.a
            public void Hy() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void Hz() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.fEC.show();
        return true;
    }

    private void zr() {
        this.aGM = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.buV();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGM);
    }

    private int zq(String str) {
        int indexOf;
        String queryParameter = Uri.parse(str).getQueryParameter("background");
        if ((TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) && (indexOf = str.indexOf("background=")) >= 0 && indexOf + 19 <= str.length()) {
            queryParameter = str.substring(indexOf + 11, indexOf + 19);
        }
        if (TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(queryParameter.substring(6, 8), 16);
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor(UgcConstant.TOPIC_PATTERN_TAG + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buV() {
        if (this.fEB != null) {
            this.fEB.dismiss();
        }
        if (this.fEC != null) {
            this.fEC.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    /* renamed from: do */
    public void mo22do(int i) {
        buV();
    }
}
