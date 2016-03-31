package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class bn extends bx<com.baidu.tbadk.core.data.c, bu> {
    private View.OnClickListener bkY;
    private View.OnClickListener bkZ;
    private View.OnClickListener bla;
    private Set<String> bms;

    /* JADX INFO: Access modifiers changed from: protected */
    public bn(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bms = new HashSet();
    }

    private void a(boolean z, bu buVar) {
        if (z) {
            com.baidu.tbadk.core.util.at.k(buVar.bmS, t.f.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.at.b(buVar.bmS, t.d.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.at.k(buVar.bmS, t.f.btn_content_download_d);
        com.baidu.tbadk.core.util.at.b(buVar.bmS, t.d.faceshop_downloaded_text, 1);
    }

    public void l(View.OnClickListener onClickListener) {
        this.bkY = onClickListener;
    }

    public void m(View.OnClickListener onClickListener) {
        this.bkZ = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bla = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public bu b(ViewGroup viewGroup) {
        return new bu(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, bu buVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) buVar);
        if (this.bix == null) {
            return null;
        }
        if (this.bix != null && (this.bix instanceof FrsActivity)) {
            ((FrsActivity) this.bix).Rd().Te();
        }
        buVar.bmO.setPadding(0, i - this.bkj == 0 ? this.bjn : this.bjo, 0, 0);
        this.bix.getLayoutMode().ab(this.mSkinType == 1);
        this.bix.getLayoutMode().x(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.So && (this.bix instanceof FrsActivity)) {
                cVar.So = true;
                ((FrsActivity) this.bix).a(cVar, "show");
                ((FrsActivity) this.bix).b(cVar, "show");
            }
            if (cVar.Sp) {
                if (buVar.bmJ == null) {
                    buVar.bmJ = (ViewGroup) buVar.bmI.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    com.baidu.tbadk.i.a.a(this.bix.getPageContext(), buVar.bmJ);
                }
                buVar.bmJ.setVisibility(0);
                buVar.bmJ.setOnClickListener(new bo(this, cVar));
                if (!this.bms.contains(cVar.Sr)) {
                    this.bms.add(cVar.Sr);
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10828");
                    awVar.ac("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(awVar);
                }
            } else if (buVar.bmJ != null) {
                buVar.bmJ.setVisibility(8);
            }
            if (cVar.Ss) {
                if (buVar.bmL == null) {
                    buVar.bmL = (ViewGroup) buVar.bmK.inflate().findViewById(t.g.item_adkiller_close);
                    com.baidu.tbadk.i.a.a(this.bix.getPageContext(), buVar.bmL);
                }
                buVar.bmL.setVisibility(0);
                buVar.bmL.setOnClickListener(this.bla);
                buVar.bmL.setTag(Integer.valueOf(i));
            } else if (buVar.bmL != null) {
                buVar.bmL.setVisibility(8);
            }
            buVar.aSh.setText(cVar.Sn.userName);
            buVar.bmR.setText(cVar.Sn.Su);
            if (com.baidu.tbadk.core.l.qE().qK()) {
                buVar.bmQ.setVisibility(0);
                buVar.bmQ.c(cVar.Sn.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                buVar.bmQ.setVisibility(8);
            }
            buVar.bmQ.setTag(cVar.Sn.userPortrait);
            buVar.bmS.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.at.k(buVar.bmP, t.f.bg_label);
            if (cVar.rm()) {
                a(true, buVar);
                if (TextUtils.isEmpty(cVar.Sn.OJ) || TextUtils.isEmpty(cVar.Sn.OJ.trim())) {
                    buVar.bmS.setText(t.j.view);
                } else {
                    buVar.bmS.setText(cVar.Sn.OJ);
                }
                buVar.bmS.setOnClickListener(this.bkY);
                return view;
            } else if (cVar.rl()) {
                switch (cVar.RY) {
                    case 0:
                        if (TextUtils.isEmpty(cVar.Sn.OJ) || TextUtils.isEmpty(cVar.Sn.OJ.trim())) {
                            buVar.bmS.setText(t.j.game_center_download);
                        } else {
                            buVar.bmS.setText(cVar.Sn.OJ);
                        }
                        a(true, buVar);
                        buVar.bmS.setOnClickListener(this.bkZ);
                        return view;
                    case 1:
                        a(false, buVar);
                        buVar.bmS.setText(t.j.downloading2);
                        buVar.bmS.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, buVar);
                        buVar.bmS.setText(t.j.frs_old_style_download_text);
                        buVar.bmS.setOnClickListener(this.bkZ);
                        return view;
                    default:
                        return view;
                }
            } else {
                return view;
            }
        }
        return view;
    }
}
