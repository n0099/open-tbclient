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
/* loaded from: classes4.dex */
public class a {
    private int aKR;
    private long anchorId;
    private Dialog bdq;
    private long challengeId;
    private Context context;
    private GetChallengeMvpToastInfoResponseMessage gLG;
    private b gLH;
    private i gLI;
    private CountDownTimer gge;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.aKR = 10;
        this.context = context;
        this.liveId = j;
        this.anchorId = j2;
        this.challengeId = j3;
        this.gLI = iVar;
        this.gLG = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.x.a.OS().blo != null) {
            this.aKR = com.baidu.live.x.a.OS().blo.aKR;
            if (this.aKR == 0) {
                this.aKR = 10;
            }
        }
    }

    public void Pd() {
        if (this.context != null && this.gLG != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.h.dialog_mvp_choose_punish, (ViewGroup) null);
            this.bdq = new Dialog(this.context, a.j.sdk_TransparentDialog);
            this.bdq.requestWindowFeature(1);
            this.bdq.setCancelable(false);
            this.bdq.setContentView(inflate);
            this.bdq.setCanceledOnTouchOutside(false);
            this.bdq.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.e.sdk_ds582);
            this.bdq.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.g.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.g.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.g.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.g.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.g.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.g.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.g.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.g.countdown_textView);
            if (!TextUtils.isEmpty(this.gLG.toast)) {
                textView.setText(this.gLG.toast);
            }
            if (this.gLG.type == 0) {
                imageView.setVisibility(8);
                alphaGradientHListView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView4.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Gz();
                    }
                });
            } else {
                imageView.setVisibility(0);
                alphaGradientHListView.setVisibility(0);
                linearLayout.setVisibility(0);
                textView4.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView2.setEnabled(false);
                textView5.setText(this.aKR + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.e.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.f.sdk_transparent_bg));
                this.gLH = new b(this.context, this.gLG.gIJ);
                alphaGradientHListView.setAdapter((ListAdapter) this.gLH);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.gLH != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.gLH.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.gLH.gIj, bVar.id)) {
                                a.this.gLH.gIj = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.gLH.gIj = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.gLH.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bc(3, a.this.gLH.gIj);
                        a.this.release();
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bc(2, "0");
                        a.this.release();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bc(1, "0");
                        a.this.release();
                    }
                });
                if (this.gge != null) {
                    this.gge.cancel();
                }
                this.gge = new CountDownTimer(this.aKR * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.bc(1, "0");
                        a.this.Gz();
                    }
                };
                this.gge.start();
            }
            this.bdq.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gz() {
        if (this.bdq != null && this.bdq.isShowing()) {
            Context context = this.bdq.getContext();
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
                this.bdq.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.bdq = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, String str) {
        if (this.gLI != null) {
            this.gLI.a(this.challengeId, this.liveId, this.anchorId, i, str);
        }
    }

    public void release() {
        if (this.gge != null) {
            this.gge.cancel();
        }
        Gz();
    }
}
