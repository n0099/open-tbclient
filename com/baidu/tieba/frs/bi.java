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
    private View.OnClickListener aUA;
    private View.OnClickListener aUz;

    /* JADX INFO: Access modifiers changed from: protected */
    public bi(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    public void i(View.OnClickListener onClickListener) {
        this.aUA = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aUz = onClickListener;
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
        if (bVar == null || bVar.Uj == null) {
            bjVar.aVM.setVisibility(8);
            return;
        }
        List<String> list = bVar.Uj.Uu;
        if (list == null || list.size() <= 0) {
            bjVar.aVM.setVisibility(8);
        } else if (!com.baidu.tbadk.core.m.qX().rb()) {
            bjVar.aVM.setVisibility(8);
        } else {
            bjVar.aVM.setVisibility(0);
            int size = list.size();
            a(bjVar, size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                bjVar.aVS.d(list.get(0), i, false);
            } else if (size == 2) {
                bjVar.aVS.d(list.get(0), i, false);
                bjVar.aVT.d(list.get(1), i, false);
            } else if (size >= 3) {
                bjVar.aVS.d(list.get(0), i, false);
                bjVar.aVT.d(list.get(1), i, false);
                bjVar.aVU.d(list.get(2), i, false);
            }
        }
    }

    private void a(bj bjVar, int i) {
        if (i > 0) {
            if (i == 1) {
                bjVar.aVS.setVisibility(0);
                bjVar.aVT.setVisibility(4);
                bjVar.aVU.setVisibility(4);
            } else if (i == 2) {
                bjVar.aVS.setVisibility(0);
                bjVar.aVT.setVisibility(0);
                bjVar.aVU.setVisibility(4);
            } else if (i >= 3) {
                bjVar.aVS.setVisibility(0);
                bjVar.aVT.setVisibility(0);
                bjVar.aVU.setVisibility(0);
            }
        }
    }

    private void b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bj bjVar) {
        if (this.aSe != null && bVar != null && bVar.Uj != null && this.aSe != null && (this.aSe instanceof FrsActivity)) {
            ((FrsActivity) this.aSe).Lm().Nb();
            bjVar.aVL.setPadding(0, i - this.aTQ == 0 ? this.aSR : this.aSS, 0, 0);
            this.aSe.getLayoutMode().ad(this.mSkinType == 1);
            this.aSe.getLayoutMode().k(view);
            if (!bVar.Uk && this.aSe != null && (this.aSe instanceof FrsActivity)) {
                bVar.Uk = true;
                ((FrsActivity) this.aSe).a(bVar, "show");
                ((FrsActivity) this.aSe).b(bVar, "show");
            }
            bjVar.aVO.setText(gP(bVar.Uj.userName));
            if (StringUtils.isNull(bVar.Uj.Um)) {
                bjVar.aVQ.setVisibility(8);
            } else {
                bjVar.aVQ.setVisibility(0);
                bjVar.aVQ.setText(bVar.Uj.Um);
            }
            if (StringUtils.isNull(bVar.Uj.Un)) {
                bjVar.aVR.setVisibility(8);
            } else {
                bjVar.aVR.setVisibility(0);
                bjVar.aVR.setText(bVar.Uj.Un);
            }
            bjVar.aVP.setText(com.baidu.tbadk.core.util.as.o(bVar.Ui));
            if (com.baidu.tbadk.core.m.qX().qZ()) {
                bjVar.aVN.setVisibility(0);
                bjVar.aVN.d(bVar.Uj.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bjVar.aVN.setVisibility(8);
            }
            bjVar.aVN.setTag(bVar.Uj.userPortrait);
            bjVar.aVV.setTag(Integer.valueOf(i));
            if (bVar.rr()) {
                if (StringUtils.isNull(bVar.Uj.Ut)) {
                    bjVar.aVV.setVisibility(8);
                    return;
                }
                a(true, bjVar);
                bjVar.aVV.setText(bVar.Uj.Ut);
                bjVar.aVV.setOnClickListener(this.aUz);
            } else if (bVar.rq()) {
                bjVar.aVV.setVisibility(0);
                switch (bVar.TU) {
                    case 0:
                        if (StringUtils.isNull(bVar.Uj.Ut)) {
                            bjVar.aVV.setText(i.h.pb_app_download);
                        } else {
                            bjVar.aVV.setText(bVar.Uj.Ut);
                        }
                        a(true, bjVar);
                        bjVar.aVV.setOnClickListener(this.aUA);
                        return;
                    case 1:
                        a(false, bjVar);
                        bjVar.aVV.setText(i.h.downloading2);
                        bjVar.aVV.setOnClickListener(null);
                        return;
                    case 2:
                        a(true, bjVar);
                        bjVar.aVV.setText(i.h.frs_new_style_download_text);
                        bjVar.aVV.setOnClickListener(this.aUA);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void a(boolean z, bj bjVar) {
        if (z) {
            com.baidu.tbadk.core.util.an.i((View) bjVar.aVV, i.e.btn_appdownload);
            com.baidu.tbadk.core.util.an.b(bjVar.aVV, i.c.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.an.i((View) bjVar.aVV, i.e.btn_content_download_d);
        com.baidu.tbadk.core.util.an.b(bjVar.aVV, i.c.faceshop_downloaded_text, 1);
    }

    private String gP(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }
}
