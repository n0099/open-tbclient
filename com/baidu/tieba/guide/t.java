package com.baidu.tieba.guide;

import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.aa;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.au;
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    private NewUserGuideActivity aNO;
    private a aNP;
    private au aNQ;
    private InterestFrsData.Tag aNm;
    private ac zm;

    public t(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, p pVar) {
        this.aNO = newUserGuideActivity;
        this.aNm = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.aNP = new r(this.aNO.getPageContext().getPageActivity(), aa.NewUserDialog);
        } else if (btype == 2) {
            this.aNP = new e(this.aNO.getPageContext().getPageActivity(), aa.NewUserDialog);
        } else if (btype == 3) {
            this.aNP = new i(this.aNO.getPageContext().getPageActivity(), aa.NewUserDialog);
        }
        this.zm = new ac(newUserGuideActivity.getPageContext());
        this.zm.setLoadDataCallBack(new u(this));
        this.aNQ = new au();
        this.aNQ.a(new v(this));
        this.aNP.setOnClickListener(this);
        this.aNP.a(this.aNm);
        ((Dialog) this.aNP).setOnDismissListener(new w(this, pVar));
    }

    public void n(int i, boolean z) {
        for (int i2 = 0; i2 < this.aNm.getCard_list().size(); i2++) {
            if (this.aNm.getCard_list().get(i2).getFid() == i) {
                this.aNm.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.box_close_layout) {
            this.aNP.hide();
        } else if ((view.getId() == com.baidu.tieba.w.ll_like || view.getId() == com.baidu.tieba.w.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.aNQ.i(card.getFname(), card.getFid());
            } else {
                this.zm.r(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.aNO == null || com.baidu.adp.lib.g.k.k(this.aNO.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.aNP.getRootView().setAnimation(scaleAnimation);
            this.aNP.show();
        }
    }
}
