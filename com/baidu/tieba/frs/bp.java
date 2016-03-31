package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class bp extends bx<com.baidu.tbadk.core.data.c, br> {
    private View.OnClickListener bkY;
    private View.OnClickListener bkZ;
    private View.OnClickListener bla;
    private Set<String> bms;
    private DownloadData bmv;

    /* JADX INFO: Access modifiers changed from: protected */
    public bp(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bms = new HashSet();
        this.bmv = new DownloadData();
    }

    public void m(View.OnClickListener onClickListener) {
        this.bkZ = onClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.bkY = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.bla = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public br b(ViewGroup viewGroup) {
        return new br(LayoutInflater.from(this.mContext).inflate(t.h.frs_app_muti_pic_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, br brVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) brVar);
        b(i, view, viewGroup, cVar, brVar);
        a(brVar, cVar);
        return view;
    }

    private void a(br brVar, com.baidu.tbadk.core.data.c cVar) {
        if (cVar == null || cVar.Sn == null) {
            brVar.bmy.setVisibility(8);
            return;
        }
        List<String> list = cVar.Sn.SB;
        if (list == null || list.size() <= 0) {
            brVar.bmy.setVisibility(8);
        } else if (!com.baidu.tbadk.core.l.qE().qK()) {
            brVar.bmy.setVisibility(8);
        } else {
            brVar.bmy.setVisibility(0);
            int size = list.size();
            a(brVar, size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                brVar.bmE.c(list.get(0), i, false);
            } else if (size == 2) {
                brVar.bmE.c(list.get(0), i, false);
                brVar.bmF.c(list.get(1), i, false);
            } else if (size >= 3) {
                brVar.bmE.c(list.get(0), i, false);
                brVar.bmF.c(list.get(1), i, false);
                brVar.bmG.c(list.get(2), i, false);
            }
        }
    }

    private void a(br brVar, int i) {
        if (i > 0) {
            if (i == 1) {
                brVar.bmE.setVisibility(0);
                brVar.bmF.setVisibility(4);
                brVar.bmG.setVisibility(4);
            } else if (i == 2) {
                brVar.bmE.setVisibility(0);
                brVar.bmF.setVisibility(0);
                brVar.bmG.setVisibility(4);
            } else {
                brVar.bmE.setVisibility(0);
                brVar.bmF.setVisibility(0);
                brVar.bmG.setVisibility(0);
            }
        }
    }

    private void b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, br brVar) {
        if (this.bix != null && cVar != null && cVar.Sn != null && this.bix != null && (this.bix instanceof FrsActivity)) {
            ((FrsActivity) this.bix).Rd().Te();
            brVar.bmx.setPadding(0, i - this.bkj == 0 ? this.bjn : this.bjo, 0, 0);
            this.bix.getLayoutMode().ab(this.mSkinType == 1);
            this.bix.getLayoutMode().x(view);
            if (cVar.Sp) {
                if (brVar.bmJ == null) {
                    brVar.bmJ = (ViewGroup) brVar.bmI.inflate().findViewById(t.g.frs_item_adkiller_tip);
                    com.baidu.tbadk.i.a.a(this.bix.getPageContext(), brVar.bmJ);
                }
                brVar.bmJ.setVisibility(0);
                brVar.bmJ.setOnClickListener(new bq(this, cVar));
                if (!this.bms.contains(cVar.Sr)) {
                    this.bms.add(cVar.Sr);
                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10828");
                    awVar.ac("obj_id", new StringBuilder(String.valueOf(cVar.getFid())).toString());
                    TiebaStatic.log(awVar);
                }
            } else if (brVar.bmJ != null) {
                brVar.bmJ.setVisibility(8);
            }
            if (cVar.Ss) {
                if (brVar.bmL == null) {
                    brVar.bmL = (ViewGroup) brVar.bmK.inflate().findViewById(t.g.item_adkiller_close);
                    com.baidu.tbadk.i.a.a(this.bix.getPageContext(), brVar.bmL);
                }
                brVar.bmL.setVisibility(0);
                brVar.bmL.setOnClickListener(this.bla);
                brVar.bmL.setTag(Integer.valueOf(i));
            } else if (brVar.bmL != null) {
                brVar.bmL.setVisibility(8);
            }
            if (!cVar.So && this.bix != null && (this.bix instanceof FrsActivity)) {
                cVar.So = true;
                ((FrsActivity) this.bix).a(cVar, "show");
                ((FrsActivity) this.bix).b(cVar, "show");
            }
            brVar.bmA.setText(hK(cVar.Sn.userName));
            if (StringUtils.isNull(cVar.Sn.Su)) {
                brVar.bmC.setVisibility(8);
            } else {
                brVar.bmC.setVisibility(0);
                brVar.bmC.setText(cVar.Sn.Su);
            }
            if (StringUtils.isNull(cVar.Sn.Sv)) {
                brVar.bmD.setVisibility(8);
            } else {
                brVar.bmD.setVisibility(0);
                brVar.bmD.setText(cVar.Sn.Sv);
            }
            brVar.bmB.setText(com.baidu.tbadk.core.util.ay.w(cVar.Sm));
            if (com.baidu.tbadk.core.l.qE().qG()) {
                brVar.bmz.setVisibility(0);
                brVar.bmz.c(cVar.Sn.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                brVar.bmz.setVisibility(8);
            }
            brVar.bmz.setTag(cVar.Sn.userPortrait);
            brVar.bmH.setVisibility(0);
            brVar.bmH.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) brVar.bmA.getLayoutParams();
            layoutParams.width = -2;
            if (cVar.rm()) {
                brVar.blz.setVisibility(8);
                if (StringUtils.isNull(cVar.Sn.OJ)) {
                    brVar.bmH.setVisibility(8);
                    layoutParams.width = -1;
                    return;
                }
                a(true, brVar);
                brVar.bmH.setText(cVar.Sn.OJ);
                brVar.bmH.setOnClickListener(this.bkY);
            } else if (cVar.rl()) {
                this.bmv.setId(cVar.Se);
                this.bmv.setUrl(cVar.Sd);
                this.bmv.setName(cVar.Sa);
                this.bmv.setPosition(i);
                this.bmv.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.RZ, 0));
                int b = AppDownloadView.b(this.bmv);
                this.bmv.setStatus(b);
                brVar.blz.a(this.HL, this.bmv);
                a(true, brVar);
                switch (b) {
                    case 1:
                        brVar.bmH.setText(t.j.downloading2);
                        break;
                    case 3:
                        brVar.bmH.setText(t.j.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(cVar.Sn.OJ) || TextUtils.isEmpty(cVar.Sn.OJ.trim())) {
                            brVar.bmH.setText(t.j.pb_app_download);
                            break;
                        } else {
                            brVar.bmH.setText(cVar.Sn.OJ);
                            break;
                        }
                        break;
                    case 7:
                        brVar.bmH.setText(t.j.frs_new_style_download_pause);
                        break;
                }
                ((FrsActivity.b) this.bkZ).b(brVar.blz);
                brVar.bmH.setOnClickListener(this.bkZ);
            }
        }
    }

    private void a(boolean z, br brVar) {
        com.baidu.tbadk.core.util.at.k(brVar.bmH, t.f.btn_appdownload);
        com.baidu.tbadk.core.util.at.b(brVar.bmH, t.d.cp_cont_i, 1);
    }

    private String hK(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }
}
