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
    private CustomMessageListener aMA;
    private b fSL;
    private d fSM;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        AF();
    }

    public void Cm(String str) {
        this.fSL = new b(this.mPageContext.getPageActivity());
        this.fSL.a(this);
        this.fSL.b(this);
        this.fSL.bsc().setBackgroundColor(AZ(str));
        this.fSL.show(str);
    }

    public void resume() {
        if (this.fSL != null && this.fSL.isShowing() && this.fSL.bsc() != null) {
            this.fSL.bsc().onResume();
            this.fSL.bsc().reload();
        }
    }

    public void pause() {
        if (this.fSL != null && this.fSL.isShowing() && this.fSL.bsc() != null) {
            this.fSL.bsc().onPause();
        }
    }

    public void release() {
        bAU();
        MessageManager.getInstance().unRegisterListener(this.aMA);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.fSM = new d(this.mPageContext.getPageActivity());
        this.fSM.setCancelable(false);
        this.fSM.setCanceledOnTouchOutside(false);
        this.fSM.cu(false);
        this.fSM.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.fSM.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // com.baidu.live.view.d.a
            public void Jq() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void Jr() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.fSM.show();
        return true;
    }

    private void AF() {
        this.aMA = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.bAU();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMA);
    }

    private int AZ(String str) {
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
    public void bAU() {
        if (this.fSL != null) {
            this.fSL.dismiss();
        }
        if (this.fSM != null) {
            this.fSM.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void dv(int i) {
        bAU();
    }
}
