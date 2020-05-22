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
    private b fSA;
    private d fSB;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        AF();
    }

    public void Cm(String str) {
        this.fSA = new b(this.mPageContext.getPageActivity());
        this.fSA.a(this);
        this.fSA.b(this);
        this.fSA.bsa().setBackgroundColor(AZ(str));
        this.fSA.show(str);
    }

    public void resume() {
        if (this.fSA != null && this.fSA.isShowing() && this.fSA.bsa() != null) {
            this.fSA.bsa().onResume();
            this.fSA.bsa().reload();
        }
    }

    public void pause() {
        if (this.fSA != null && this.fSA.isShowing() && this.fSA.bsa() != null) {
            this.fSA.bsa().onPause();
        }
    }

    public void release() {
        bAS();
        MessageManager.getInstance().unRegisterListener(this.aMA);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.fSB = new d(this.mPageContext.getPageActivity());
        this.fSB.setCancelable(false);
        this.fSB.setCanceledOnTouchOutside(false);
        this.fSB.cu(false);
        this.fSB.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.fSB.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
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
        this.fSB.show();
        return true;
    }

    private void AF() {
        this.aMA = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.bAS();
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
    public void bAS() {
        if (this.fSA != null) {
            this.fSA.dismiss();
        }
        if (this.fSB != null) {
            this.fSB.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void dt(int i) {
        bAS();
    }
}
