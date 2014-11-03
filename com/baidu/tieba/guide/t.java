package com.baidu.tieba.guide;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ag;
import com.baidu.tieba.model.bc;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    private NewUserGuideActivity aLW;
    private a aLX;
    private bc aLY;
    private InterestFrsData.Tag aLs;
    private ag avA;

    public t(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, p pVar) {
        this.aLW = newUserGuideActivity;
        this.aLs = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.aLX = new r(this.aLW, z.NewUserDialog);
        } else if (btype == 2) {
            this.aLX = new e(this.aLW, z.NewUserDialog);
        } else if (btype == 3) {
            this.aLX = new i(this.aLW, z.NewUserDialog);
        }
        this.avA = new ag(newUserGuideActivity);
        this.avA.setLoadDataCallBack(new u(this));
        this.aLY = new bc();
        this.aLY.a(new v(this));
        this.aLX.setOnClickListener(this);
        this.aLX.a(this.aLs);
        ((Dialog) this.aLX).setOnDismissListener(new w(this, pVar));
    }

    public void n(int i, boolean z) {
        for (int i2 = 0; i2 < this.aLs.getCard_list().size(); i2++) {
            if (this.aLs.getCard_list().get(i2).getFid() == i) {
                this.aLs.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.box_close_layout) {
            this.aLX.hide();
        } else if ((view.getId() == com.baidu.tieba.v.ll_like || view.getId() == com.baidu.tieba.v.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.aLY.g(card.getFname(), card.getFid());
            } else {
                this.avA.o(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (!(this.aLW instanceof Activity) || com.baidu.adp.lib.g.j.e(this.aLW)) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.aLX.getRootView().setAnimation(scaleAnimation);
            this.aLX.show();
        }
    }
}
