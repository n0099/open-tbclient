package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class bi extends bn<com.baidu.tbadk.core.data.b, bj> {
    private View.OnClickListener aUo;
    private View.OnClickListener aUp;

    /* JADX INFO: Access modifiers changed from: protected */
    public bi(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUp = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUo = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public bj a(ViewGroup viewGroup) {
        return new bj(LayoutInflater.from(this.mContext).inflate(i.g.frs_app_muti_pic_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bj bjVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) bjVar);
        b(i, view, viewGroup, bVar, bjVar);
        a(bjVar, bVar);
        return view;
    }

    private void a(bj bjVar, com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || bVar.Ui == null) {
            bjVar.aVB.setVisibility(8);
            return;
        }
        List<String> list = bVar.Ui.Ut;
        if (list == null || list.size() <= 0) {
            bjVar.aVB.setVisibility(8);
        } else if (!com.baidu.tbadk.core.m.qX().rb()) {
            bjVar.aVB.setVisibility(8);
        } else {
            bjVar.aVB.setVisibility(0);
            int size = list.size();
            a(bjVar, size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                bjVar.aVH.d(list.get(0), i, false);
            } else if (size == 2) {
                bjVar.aVH.d(list.get(0), i, false);
                bjVar.aVI.d(list.get(1), i, false);
            } else if (size >= 3) {
                bjVar.aVH.d(list.get(0), i, false);
                bjVar.aVI.d(list.get(1), i, false);
                bjVar.aVJ.d(list.get(2), i, false);
            }
        }
    }

    private void a(bj bjVar, int i) {
        if (i > 0) {
            if (i == 1) {
                bjVar.aVH.setVisibility(0);
                bjVar.aVI.setVisibility(4);
                bjVar.aVJ.setVisibility(4);
            } else if (i == 2) {
                bjVar.aVH.setVisibility(0);
                bjVar.aVI.setVisibility(0);
                bjVar.aVJ.setVisibility(4);
            } else if (i >= 3) {
                bjVar.aVH.setVisibility(0);
                bjVar.aVI.setVisibility(0);
                bjVar.aVJ.setVisibility(0);
            }
        }
    }

    private void b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bj bjVar) {
        if (this.aRT != null && bVar != null && bVar.Ui != null && this.aRT != null && (this.aRT instanceof FrsActivity)) {
            ((FrsActivity) this.aRT).Lm().Nb();
            bjVar.aVA.setPadding(0, i - this.aTF == 0 ? this.aSG : this.aSH, 0, 0);
            this.aRT.getLayoutMode().ad(this.mSkinType == 1);
            this.aRT.getLayoutMode().k(view);
            if (!bVar.Uj && this.aRT != null && (this.aRT instanceof FrsActivity)) {
                bVar.Uj = true;
                ((FrsActivity) this.aRT).a(bVar, "show");
                ((FrsActivity) this.aRT).b(bVar, "show");
            }
            bjVar.aVD.setText(gP(bVar.Ui.userName));
            if (StringUtils.isNull(bVar.Ui.Ul)) {
                bjVar.aVF.setVisibility(8);
            } else {
                bjVar.aVF.setVisibility(0);
                bjVar.aVF.setText(bVar.Ui.Ul);
            }
            if (StringUtils.isNull(bVar.Ui.Um)) {
                bjVar.aVG.setVisibility(8);
            } else {
                bjVar.aVG.setVisibility(0);
                bjVar.aVG.setText(bVar.Ui.Um);
            }
            bjVar.aVE.setText(com.baidu.tbadk.core.util.ar.o(bVar.Uh));
            if (com.baidu.tbadk.core.m.qX().qZ()) {
                bjVar.aVC.setVisibility(0);
                bjVar.aVC.d(bVar.Ui.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bjVar.aVC.setVisibility(8);
            }
            bjVar.aVC.setTag(bVar.Ui.userPortrait);
            bjVar.aVK.setTag(Integer.valueOf(i));
            if (bVar.rr()) {
                if (StringUtils.isNull(bVar.Ui.Us)) {
                    bjVar.aVK.setVisibility(8);
                    return;
                }
                a(true, bjVar);
                bjVar.aVK.setText(bVar.Ui.Us);
                bjVar.aVK.setOnClickListener(this.aUo);
            } else if (bVar.rq()) {
                bjVar.aVK.setVisibility(0);
                switch (bVar.TT) {
                    case 0:
                        if (StringUtils.isNull(bVar.Ui.Us)) {
                            bjVar.aVK.setText(i.h.pb_app_download);
                        } else {
                            bjVar.aVK.setText(bVar.Ui.Us);
                        }
                        a(true, bjVar);
                        bjVar.aVK.setOnClickListener(this.aUp);
                        return;
                    case 1:
                        a(false, bjVar);
                        bjVar.aVK.setText(i.h.downloading2);
                        bjVar.aVK.setOnClickListener(null);
                        return;
                    case 2:
                        a(true, bjVar);
                        bjVar.aVK.setText(i.h.frs_new_style_download_text);
                        bjVar.aVK.setOnClickListener(this.aUp);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void a(boolean z, bj bjVar) {
        if (z) {
            com.baidu.tbadk.core.util.am.i((View) bjVar.aVK, i.e.btn_appdownload);
            com.baidu.tbadk.core.util.am.b(bjVar.aVK, i.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.am.i((View) bjVar.aVK, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.am.b(bjVar.aVK, i.c.faceshop_downloaded_text, 1);
    }

    private String gP(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }
}
