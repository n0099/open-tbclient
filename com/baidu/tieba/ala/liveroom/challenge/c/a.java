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
    private int aLt;
    private long anchorId;
    private Dialog beG;
    private long challengeId;
    private Context context;
    private GetChallengeMvpToastInfoResponseMessage gXv;
    private b gXw;
    private i gXx;
    private CountDownTimer gqh;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.aLt = 10;
        this.context = context;
        this.liveId = j;
        this.anchorId = j2;
        this.challengeId = j3;
        this.gXx = iVar;
        this.gXv = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.z.a.Pq().bmJ != null) {
            this.aLt = com.baidu.live.z.a.Pq().bmJ.aLt;
            if (this.aLt == 0) {
                this.aLt = 10;
            }
        }
    }

    public void PJ() {
        if (this.context != null && this.gXv != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.h.dialog_mvp_choose_punish, (ViewGroup) null);
            this.beG = new Dialog(this.context, a.j.sdk_TransparentDialog);
            this.beG.requestWindowFeature(1);
            this.beG.setCancelable(false);
            this.beG.setContentView(inflate);
            this.beG.setCanceledOnTouchOutside(false);
            this.beG.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.e.sdk_ds582);
            this.beG.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.g.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.g.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.g.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.g.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.g.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.g.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.g.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.g.countdown_textView);
            if (!TextUtils.isEmpty(this.gXv.toast)) {
                textView.setText(this.gXv.toast);
            }
            if (this.gXv.type == 0) {
                imageView.setVisibility(8);
                alphaGradientHListView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView4.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.GU();
                    }
                });
            } else {
                imageView.setVisibility(0);
                alphaGradientHListView.setVisibility(0);
                linearLayout.setVisibility(0);
                textView4.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView2.setEnabled(false);
                textView5.setText(this.aLt + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.e.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.f.sdk_transparent_bg));
                this.gXw = new b(this.context, this.gXv.gUy);
                alphaGradientHListView.setAdapter((ListAdapter) this.gXw);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.gXw != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.gXw.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.gXw.gTY, bVar.id)) {
                                a.this.gXw.gTY = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.gXw.gTY = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.gXw.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.be(3, a.this.gXw.gTY);
                        a.this.release();
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.be(2, "0");
                        a.this.release();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.be(1, "0");
                        a.this.release();
                    }
                });
                if (this.gqh != null) {
                    this.gqh.cancel();
                }
                this.gqh = new CountDownTimer(this.aLt * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.be(1, "0");
                        a.this.GU();
                    }
                };
                this.gqh.start();
            }
            this.beG.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        if (this.beG != null && this.beG.isShowing()) {
            Context context = this.beG.getContext();
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
                this.beG.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.beG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, String str) {
        if (this.gXx != null) {
            this.gXx.a(this.challengeId, this.liveId, this.anchorId, i, str);
        }
    }

    public void release() {
        if (this.gqh != null) {
            this.gqh.cancel();
        }
        GU();
    }
}
