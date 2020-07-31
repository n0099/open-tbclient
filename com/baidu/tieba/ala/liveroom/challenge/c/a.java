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
    private int aBm;
    private Dialog aSj;
    private long axs;
    private long challengeId;
    private Context context;
    private CountDownTimer fFg;
    private GetChallengeMvpToastInfoResponseMessage ght;
    private b ghu;
    private i ghv;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.aBm = 10;
        this.context = context;
        this.liveId = j;
        this.axs = j2;
        this.challengeId = j3;
        this.ghv = iVar;
        this.ght = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.v.a.Hs().aZn != null) {
            this.aBm = com.baidu.live.v.a.Hs().aZn.aBm;
            if (this.aBm == 0) {
                this.aBm = 10;
            }
        }
    }

    public void showDialog() {
        if (this.context != null && this.ght != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.h.dialog_mvp_choose_punish, (ViewGroup) null);
            this.aSj = new Dialog(this.context, a.j.sdk_TransparentDialog);
            this.aSj.requestWindowFeature(1);
            this.aSj.setCancelable(false);
            this.aSj.setContentView(inflate);
            this.aSj.setCanceledOnTouchOutside(false);
            this.aSj.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.e.sdk_ds582);
            this.aSj.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.g.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.g.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.g.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.g.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.g.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.g.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.g.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.g.countdown_textView);
            if (!TextUtils.isEmpty(this.ght.toast)) {
                textView.setText(this.ght.toast);
            }
            if (this.ght.type == 0) {
                imageView.setVisibility(8);
                alphaGradientHListView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView4.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.zA();
                    }
                });
            } else {
                imageView.setVisibility(0);
                alphaGradientHListView.setVisibility(0);
                linearLayout.setVisibility(0);
                textView4.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView2.setEnabled(false);
                textView5.setText(this.aBm + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.e.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.f.sdk_transparent_bg));
                this.ghu = new b(this.context, this.ght.geG);
                alphaGradientHListView.setAdapter((ListAdapter) this.ghu);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.ghu != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.ghu.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.ghu.gek, bVar.id)) {
                                a.this.ghu.gek = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.ghu.gek = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.ghu.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aU(3, a.this.ghu.gek);
                        a.this.release();
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aU(2, "0");
                        a.this.release();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aU(1, "0");
                        a.this.release();
                    }
                });
                if (this.fFg != null) {
                    this.fFg.cancel();
                }
                this.fFg = new CountDownTimer(this.aBm * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.aU(1, "0");
                        a.this.zA();
                    }
                };
                this.fFg.start();
            }
            this.aSj.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA() {
        if (this.aSj != null && this.aSj.isShowing()) {
            Context context = this.aSj.getContext();
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
                this.aSj.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.aSj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, String str) {
        if (this.ghv != null) {
            this.ghv.a(this.challengeId, this.liveId, this.axs, i, str);
        }
    }

    public void release() {
        if (this.fFg != null) {
            this.fFg.cancel();
        }
        zA();
    }
}
