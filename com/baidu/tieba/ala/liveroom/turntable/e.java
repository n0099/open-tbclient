package com.baidu.tieba.ala.liveroom.turntable;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.view.web.f;
/* loaded from: classes6.dex */
public class e {
    private CustomMessageListener dUZ;
    private d epc;
    private PopupWindow.OnDismissListener epd;
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
        aND();
    }

    public void a(String str, long j, long j2, long j3) {
        this.epc = new d(this.mContext);
        this.epc.setOnDismissListener(this.epd);
        this.epc.aNE().setBackgroundColor(tC(str));
        f fVar = new f();
        fVar.az(this.mContext).a(this.epc).a(this.epc.aNE().getSchemeCallback());
        com.baidu.live.view.web.a[] wO = fVar.wO();
        for (com.baidu.live.view.web.a aVar : wO) {
            this.epc.aNE().addJavascriptInterface(aVar, aVar.getName());
        }
        this.epc.tD(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.epc != null && this.epc.isShowing() && this.epc.aNE() != null) {
            this.epc.aNE().onResume();
        }
    }

    public void pause() {
        if (this.epc != null && this.epc.isShowing() && this.epc.aNE() != null) {
            this.epc.aNE().onPause();
        }
    }

    public void dismiss() {
        if (this.epc != null) {
            this.epc.aNF();
        }
    }

    public void bw(int i) {
        if (this.epc != null && this.epc.isShowing()) {
            this.epc.bw(i);
        }
    }

    public void rs() {
        dismiss();
    }

    public void release() {
        rs();
        MessageManager.getInstance().unRegisterListener(this.dUZ);
    }

    private void aND() {
        this.dUZ = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.epc != null && e.this.epc.isShowing()) {
                    e.this.epc.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dUZ);
    }

    private int tC(String str) {
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
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor('#' + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }

    private String b(String str, long j, long j2, long j3) {
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("live_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(j2);
        sb.append("&anchor_id=");
        sb.append(j3);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&client_type=");
        sb.append("2");
        return sb.toString();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.epd = onDismissListener;
    }

    public PopupWindow.OnDismissListener aWi() {
        return this.epd;
    }
}
