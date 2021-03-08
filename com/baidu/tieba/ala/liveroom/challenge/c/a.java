package com.baidu.tieba.ala.liveroom.challenge.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.challenge.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.tieba.ala.liveroom.challenge.adapter.b;
import com.baidu.tieba.ala.liveroom.challenge.message.GetChallengeMvpToastInfoResponseMessage;
/* loaded from: classes10.dex */
public class a {
    private int aNE;
    private long anchorId;
    private Dialog bka;
    private long challengeId;
    private Context context;
    private CountDownTimer gPV;
    private GetChallengeMvpToastInfoResponseMessage hAm;
    private b hAn;
    private i hAo;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.aNE = 10;
        this.context = context;
        this.liveId = j;
        this.anchorId = j2;
        this.challengeId = j3;
        this.hAo = iVar;
        this.hAm = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.ae.a.Qm().bwx != null) {
            this.aNE = com.baidu.live.ae.a.Qm().bwx.aNE;
            if (this.aNE == 0) {
                this.aNE = 10;
            }
        }
    }

    public void QH() {
        if (this.context != null && this.hAm != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.g.dialog_mvp_choose_punish, (ViewGroup) null);
            this.bka = new Dialog(this.context, a.i.sdk_TransparentDialog);
            this.bka.requestWindowFeature(1);
            this.bka.setCancelable(false);
            this.bka.setContentView(inflate);
            this.bka.setCanceledOnTouchOutside(false);
            this.bka.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.d.sdk_ds582);
            this.bka.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.f.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.f.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.f.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.f.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.f.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.f.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.f.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.f.countdown_textView);
            if (!TextUtils.isEmpty(this.hAm.toast)) {
                textView.setText(this.hAm.toast);
            }
            if (this.hAm.type == 0) {
                imageView.setVisibility(8);
                alphaGradientHListView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView4.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.FD();
                    }
                });
            } else {
                imageView.setVisibility(0);
                alphaGradientHListView.setVisibility(0);
                linearLayout.setVisibility(0);
                textView4.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView2.setEnabled(false);
                textView5.setText(this.aNE + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.d.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.e.sdk_transparent_bg));
                this.hAn = new b(this.context, this.hAm.hxq);
                alphaGradientHListView.setAdapter((ListAdapter) this.hAn);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.hAn != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.hAn.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.hAn.hwQ, bVar.id)) {
                                a.this.hAn.hwQ = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.hAn.hwQ = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.hAn.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bo(3, a.this.hAn.hwQ);
                        a.this.release();
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bo(2, "0");
                        a.this.release();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bo(1, "0");
                        a.this.release();
                    }
                });
                if (this.gPV != null) {
                    this.gPV.cancel();
                }
                this.gPV = new CountDownTimer(this.aNE * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.bo(1, "0");
                        a.this.FD();
                    }
                };
                this.gPV.start();
            }
            this.bka.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        if (this.bka != null && this.bka.isShowing()) {
            Context context = this.bka.getContext();
            if (context != null && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                } else if (activity.isFinishing()) {
                    return;
                }
            }
            try {
                this.bka.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.bka = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(int i, String str) {
        if (this.hAo != null) {
            this.hAo.a(this.challengeId, this.liveId, this.anchorId, i, str);
        }
    }

    public void release() {
        if (this.gPV != null) {
            this.gPV.cancel();
        }
        FD();
    }
}
