package com.baidu.tieba.ala.live.guess.group;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.data.AlaGuessQuesData;
import com.baidu.live.data.ab;
import com.baidu.live.data.n;
import com.baidu.live.guess.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.utils.j;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private ab hfW;
    private e.b hgB;
    private AlaGuessQuesData hgC;
    private e hgc;
    private AlaGuessGroupView hgz;
    private boolean hgA = false;
    private Handler mHandler = new Handler();
    private Runnable hgD = new Runnable() { // from class: com.baidu.tieba.ala.live.guess.group.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hgC != null) {
                a.this.hgC.setIsFirst(0);
                a.this.g(a.this.hgC);
            }
        }
    };

    public a(Context context, e eVar) {
        this.hgz = new AlaGuessGroupView(context);
        this.hgc = eVar;
        if (this.hgc != null) {
            this.hgc.a(new e.b() { // from class: com.baidu.tieba.ala.live.guess.group.a.2
                @Override // com.baidu.live.guess.e.b
                public void N(List<n> list) {
                    if (a.this.hgB != null) {
                        a.this.hgB.N(list);
                    }
                }

                @Override // com.baidu.live.guess.e.b
                public void onFailure(int i, String str) {
                    if (a.this.hgB != null) {
                        a.this.hgB.onFailure(i, str);
                    }
                }
            });
        }
    }

    public void bXv() {
        bXw();
        this.mHandler.postDelayed(this.hgD, 5000L);
    }

    public void bXw() {
        this.mHandler.removeCallbacks(this.hgD);
    }

    public void b(e.b bVar) {
        this.hgB = bVar;
    }

    public void a(ab abVar) {
        this.hfW = abVar;
    }

    public void g(AlaGuessQuesData alaGuessQuesData) {
        this.hgC = alaGuessQuesData;
        if (this.hgc != null && this.hfW.aIz != null) {
            this.hgc.c(ExtraParamsManager.getEncryptionUserId(String.valueOf(this.hfW.aIz.userId)), this.hgC.getQuesId(), alaGuessQuesData.isFirst());
        }
    }

    public boolean bXx() {
        return this.hgA;
    }

    public void av(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (viewGroup.getVisibility() == 8) {
                viewGroup.setVisibility(0);
            }
            viewGroup.addView(this.hgz, new ViewGroup.LayoutParams(-1, -1));
            this.hgA = true;
        }
    }

    public void aw(ViewGroup viewGroup) {
        if (viewGroup != null && this.hgz != null) {
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeView(this.hgz);
            }
            this.hgA = false;
        }
    }

    public void a(n nVar, AlaGuessGroupInfoView alaGuessGroupInfoView) {
        if (nVar != null && alaGuessGroupInfoView != null) {
            alaGuessGroupInfoView.setHeadImage(nVar.getAvatar());
            alaGuessGroupInfoView.setNickName(j.K(nVar.getNickname(), 8));
            if (!nVar.Bw()) {
                alaGuessGroupInfoView.getTickImage().setVisibility(8);
            } else {
                alaGuessGroupInfoView.getTickImage().setVisibility(0);
            }
            a(nVar, alaGuessGroupInfoView.getStatusImage());
        }
    }

    private void a(n nVar, ImageView imageView) {
        if (nVar.Bv()) {
            imageView.setImageResource(a.e.ala_guess_state_answer);
        } else {
            imageView.setImageResource(a.e.ala_guess_state_unanswer);
        }
    }

    public void a(n nVar) {
        a(nVar, this.hgz.getFirstInfo());
    }

    public void b(n nVar) {
        a(nVar, this.hgz.getSecondInfo());
    }

    public void c(n nVar) {
        a(nVar, this.hgz.getThirdInfo());
    }

    public void o(List<n> list, boolean z) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).bv(z);
            if (i == 0) {
                a(list.get(0));
            } else if (i == 1) {
                b(list.get(1));
            } else {
                c(list.get(2));
            }
        }
    }
}
