package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.cp;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.e<FrsActivity> {
    private final View.OnClickListener bPS;
    private final FrsActivity bVk;
    private final cp cek;
    private boolean cel;
    private boolean cem;
    private boolean cen;
    private final Runnable ceo;
    private final BdSwitchView.a cep;

    public ao(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.cel = false;
        this.cem = false;
        this.cen = false;
        this.ceo = new ap(this);
        this.bPS = new aq(this);
        this.cep = new ar(this);
        this.bVk = frsActivity;
        this.cek = new cp(frsActivity.getPageContext());
        afh();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.cek != null) {
            this.cek.c(tbPageContext, i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.cek != null) {
            this.cek.destroy();
        }
        if (this.ceo != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.ceo);
        }
    }

    public View aff() {
        return this.cek.getView();
    }

    public cp afg() {
        return this.cek;
    }

    private void afh() {
        com.baidu.adp.lib.g.h.fS().postDelayed(this.ceo, 10L);
    }

    public void ea(boolean z) {
        this.cem = z;
        if (this.cek != null) {
            this.cek.ea(z);
        }
    }

    public void ew(boolean z) {
        this.cen = z;
        if (this.cek != null) {
            this.cek.a(z, this.cep);
        }
    }

    public void eb(boolean z) {
        this.cel = z;
        if (this.cek != null) {
            this.cek.eb(z);
        }
    }

    public void a(bq bqVar) {
        if (this.cek != null) {
            this.cek.a(bqVar, FrsActivityStatic.bQh);
        }
    }
}
