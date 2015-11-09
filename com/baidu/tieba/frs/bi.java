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
    private View.OnClickListener aUH;
    private View.OnClickListener aUI;

    /* JADX INFO: Access modifiers changed from: protected */
    public bi(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUI = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUH = onClickListener;
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
        if (bVar == null || bVar.Uk == null) {
            bjVar.aVU.setVisibility(8);
            return;
        }
        List<String> list = bVar.Uk.Uv;
        if (list == null || list.size() <= 0) {
            bjVar.aVU.setVisibility(8);
        } else if (!com.baidu.tbadk.core.m.qV().qZ()) {
            bjVar.aVU.setVisibility(8);
        } else {
            bjVar.aVU.setVisibility(0);
            int size = list.size();
            a(bjVar, size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                bjVar.aWa.d(list.get(0), i, false);
            } else if (size == 2) {
                bjVar.aWa.d(list.get(0), i, false);
                bjVar.aWb.d(list.get(1), i, false);
            } else if (size >= 3) {
                bjVar.aWa.d(list.get(0), i, false);
                bjVar.aWb.d(list.get(1), i, false);
                bjVar.aWc.d(list.get(2), i, false);
            }
        }
    }

    private void a(bj bjVar, int i) {
        if (i > 0) {
            if (i == 1) {
                bjVar.aWa.setVisibility(0);
                bjVar.aWb.setVisibility(4);
                bjVar.aWc.setVisibility(4);
            } else if (i == 2) {
                bjVar.aWa.setVisibility(0);
                bjVar.aWb.setVisibility(0);
                bjVar.aWc.setVisibility(4);
            } else if (i >= 3) {
                bjVar.aWa.setVisibility(0);
                bjVar.aWb.setVisibility(0);
                bjVar.aWc.setVisibility(0);
            }
        }
    }

    private void b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bj bjVar) {
        if (this.aSm != null && bVar != null && bVar.Uk != null && this.aSm != null && (this.aSm instanceof FrsActivity)) {
            ((FrsActivity) this.aSm).Ly().Np();
            bjVar.aVT.setPadding(0, i - this.aTY == 0 ? this.aSZ : this.aTa, 0, 0);
            this.aSm.getLayoutMode().ad(this.mSkinType == 1);
            this.aSm.getLayoutMode().k(view);
            if (!bVar.Ul && this.aSm != null && (this.aSm instanceof FrsActivity)) {
                bVar.Ul = true;
                ((FrsActivity) this.aSm).a(bVar, "show");
                ((FrsActivity) this.aSm).b(bVar, "show");
            }
            bjVar.aVW.setText(gR(bVar.Uk.userName));
            if (StringUtils.isNull(bVar.Uk.Un)) {
                bjVar.aVY.setVisibility(8);
            } else {
                bjVar.aVY.setVisibility(0);
                bjVar.aVY.setText(bVar.Uk.Un);
            }
            if (StringUtils.isNull(bVar.Uk.Uo)) {
                bjVar.aVZ.setVisibility(8);
            } else {
                bjVar.aVZ.setVisibility(0);
                bjVar.aVZ.setText(bVar.Uk.Uo);
            }
            bjVar.aVX.setText(com.baidu.tbadk.core.util.as.m(bVar.Uj));
            if (com.baidu.tbadk.core.m.qV().qX()) {
                bjVar.aVV.setVisibility(0);
                bjVar.aVV.d(bVar.Uk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bjVar.aVV.setVisibility(8);
            }
            bjVar.aVV.setTag(bVar.Uk.userPortrait);
            bjVar.aWd.setTag(Integer.valueOf(i));
            if (bVar.rp()) {
                if (StringUtils.isNull(bVar.Uk.Uu)) {
                    bjVar.aWd.setVisibility(8);
                    return;
                }
                a(true, bjVar);
                bjVar.aWd.setText(bVar.Uk.Uu);
                bjVar.aWd.setOnClickListener(this.aUH);
            } else if (bVar.ro()) {
                bjVar.aWd.setVisibility(0);
                switch (bVar.TV) {
                    case 0:
                        if (StringUtils.isNull(bVar.Uk.Uu)) {
                            bjVar.aWd.setText(i.h.pb_app_download);
                        } else {
                            bjVar.aWd.setText(bVar.Uk.Uu);
                        }
                        a(true, bjVar);
                        bjVar.aWd.setOnClickListener(this.aUI);
                        return;
                    case 1:
                        a(false, bjVar);
                        bjVar.aWd.setText(i.h.downloading2);
                        bjVar.aWd.setOnClickListener(null);
                        return;
                    case 2:
                        a(true, bjVar);
                        bjVar.aWd.setText(i.h.frs_new_style_download_text);
                        bjVar.aWd.setOnClickListener(this.aUI);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void a(boolean z, bj bjVar) {
        if (z) {
            com.baidu.tbadk.core.util.an.i((View) bjVar.aWd, i.e.btn_appdownload);
            com.baidu.tbadk.core.util.an.b(bjVar.aWd, i.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.an.i((View) bjVar.aWd, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.an.b(bjVar.aWd, i.c.faceshop_downloaded_text, 1);
    }

    private String gR(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }
}
