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
/* loaded from: classes10.dex */
public class a {
    private ab hhF;
    private e hhL;
    private AlaGuessGroupView hij;
    private e.b hil;
    private AlaGuessQuesData him;
    private boolean hik = false;
    private Handler mHandler = new Handler();
    private Runnable hin = new Runnable() { // from class: com.baidu.tieba.ala.live.guess.group.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.him != null) {
                a.this.him.setIsFirst(0);
                a.this.g(a.this.him);
            }
        }
    };

    public a(Context context, e eVar) {
        this.hij = new AlaGuessGroupView(context);
        this.hhL = eVar;
        if (this.hhL != null) {
            this.hhL.a(new e.b() { // from class: com.baidu.tieba.ala.live.guess.group.a.2
                @Override // com.baidu.live.guess.e.b
                public void N(List<n> list) {
                    if (a.this.hil != null) {
                        a.this.hil.N(list);
                    }
                }

                @Override // com.baidu.live.guess.e.b
                public void onFailure(int i, String str) {
                    if (a.this.hil != null) {
                        a.this.hil.onFailure(i, str);
                    }
                }
            });
        }
    }

    public void bXB() {
        bXC();
        this.mHandler.postDelayed(this.hin, 5000L);
    }

    public void bXC() {
        this.mHandler.removeCallbacks(this.hin);
    }

    public void b(e.b bVar) {
        this.hil = bVar;
    }

    public void a(ab abVar) {
        this.hhF = abVar;
    }

    public void g(AlaGuessQuesData alaGuessQuesData) {
        this.him = alaGuessQuesData;
        if (this.hhL != null && this.hhF.aJZ != null) {
            this.hhL.c(ExtraParamsManager.getEncryptionUserId(String.valueOf(this.hhF.aJZ.userId)), this.him.getQuesId(), alaGuessQuesData.isFirst());
        }
    }

    public boolean bXD() {
        return this.hik;
    }

    public void av(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (viewGroup.getVisibility() == 8) {
                viewGroup.setVisibility(0);
            }
            viewGroup.addView(this.hij, new ViewGroup.LayoutParams(-1, -1));
            this.hik = true;
        }
    }

    public void aw(ViewGroup viewGroup) {
        if (viewGroup != null && this.hij != null) {
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeView(this.hij);
            }
            this.hik = false;
        }
    }

    public void a(n nVar, AlaGuessGroupInfoView alaGuessGroupInfoView) {
        if (nVar != null && alaGuessGroupInfoView != null) {
            alaGuessGroupInfoView.setHeadImage(nVar.getAvatar());
            alaGuessGroupInfoView.setNickName(j.K(nVar.getNickname(), 8));
            if (!nVar.Bz()) {
                alaGuessGroupInfoView.getTickImage().setVisibility(8);
            } else {
                alaGuessGroupInfoView.getTickImage().setVisibility(0);
            }
            a(nVar, alaGuessGroupInfoView.getStatusImage());
        }
    }

    private void a(n nVar, ImageView imageView) {
        if (nVar.By()) {
            imageView.setImageResource(a.e.ala_guess_state_answer);
        } else {
            imageView.setImageResource(a.e.ala_guess_state_unanswer);
        }
    }

    public void a(n nVar) {
        a(nVar, this.hij.getFirstInfo());
    }

    public void b(n nVar) {
        a(nVar, this.hij.getSecondInfo());
    }

    public void c(n nVar) {
        a(nVar, this.hij.getThirdInfo());
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
