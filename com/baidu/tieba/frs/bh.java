package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class bh extends bm<com.baidu.tbadk.core.data.b, bi> {
    private View.OnClickListener aZV;
    private View.OnClickListener aZW;
    private DownloadData bbi;

    /* JADX INFO: Access modifiers changed from: protected */
    public bh(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bbi = new DownloadData();
    }

    public void i(View.OnClickListener onClickListener) {
        this.aZW = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aZV = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public bi a(ViewGroup viewGroup) {
        return new bi(LayoutInflater.from(this.mContext).inflate(n.g.frs_app_muti_pic_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bi biVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) biVar);
        b(i, view, viewGroup, bVar, biVar);
        a(biVar, bVar);
        return view;
    }

    private void a(bi biVar, com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || bVar.UA == null) {
            biVar.bbk.setVisibility(8);
            return;
        }
        List<String> list = bVar.UA.UL;
        if (list == null || list.size() <= 0) {
            biVar.bbk.setVisibility(8);
        } else if (!com.baidu.tbadk.core.m.rh().rn()) {
            biVar.bbk.setVisibility(8);
        } else {
            biVar.bbk.setVisibility(0);
            int size = list.size();
            a(biVar, size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                biVar.bbq.d(list.get(0), i, false);
            } else if (size == 2) {
                biVar.bbq.d(list.get(0), i, false);
                biVar.bbr.d(list.get(1), i, false);
            } else if (size >= 3) {
                biVar.bbq.d(list.get(0), i, false);
                biVar.bbr.d(list.get(1), i, false);
                biVar.bbs.d(list.get(2), i, false);
            }
        }
    }

    private void a(bi biVar, int i) {
        if (i > 0) {
            if (i == 1) {
                biVar.bbq.setVisibility(0);
                biVar.bbr.setVisibility(4);
                biVar.bbs.setVisibility(4);
            } else if (i == 2) {
                biVar.bbq.setVisibility(0);
                biVar.bbr.setVisibility(0);
                biVar.bbs.setVisibility(4);
            } else if (i >= 3) {
                biVar.bbq.setVisibility(0);
                biVar.bbr.setVisibility(0);
                biVar.bbs.setVisibility(0);
            }
        }
    }

    private void b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bi biVar) {
        if (this.aXA != null && bVar != null && bVar.UA != null && this.aXA != null && (this.aXA instanceof FrsActivity)) {
            ((FrsActivity) this.aXA).MX().OV();
            biVar.bbj.setPadding(0, i - this.aZm == 0 ? this.aYn : this.aYo, 0, 0);
            this.aXA.getLayoutMode().af(this.mSkinType == 1);
            this.aXA.getLayoutMode().k(view);
            if (!bVar.UB && this.aXA != null && (this.aXA instanceof FrsActivity)) {
                bVar.UB = true;
                ((FrsActivity) this.aXA).a(bVar, "show");
                ((FrsActivity) this.aXA).b(bVar, "show");
            }
            biVar.bbm.setText(hi(bVar.UA.userName));
            if (StringUtils.isNull(bVar.UA.UD)) {
                biVar.bbo.setVisibility(8);
            } else {
                biVar.bbo.setVisibility(0);
                biVar.bbo.setText(bVar.UA.UD);
            }
            if (StringUtils.isNull(bVar.UA.UE)) {
                biVar.bbp.setVisibility(8);
            } else {
                biVar.bbp.setVisibility(0);
                biVar.bbp.setText(bVar.UA.UE);
            }
            biVar.bbn.setText(com.baidu.tbadk.core.util.ax.s(bVar.Uz));
            if (com.baidu.tbadk.core.m.rh().rj()) {
                biVar.bbl.setVisibility(0);
                biVar.bbl.d(bVar.UA.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                biVar.bbl.setVisibility(8);
            }
            biVar.bbl.setTag(bVar.UA.userPortrait);
            biVar.bbt.setVisibility(0);
            biVar.bbt.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) biVar.bbm.getLayoutParams();
            layoutParams.width = -2;
            if (bVar.rD()) {
                biVar.bav.setVisibility(8);
                if (StringUtils.isNull(bVar.UA.UK)) {
                    biVar.bbt.setVisibility(8);
                    layoutParams.width = -1;
                    return;
                }
                a(true, biVar);
                biVar.bbt.setText(bVar.UA.UK);
                biVar.bbt.setOnClickListener(this.aZV);
            } else if (bVar.rC()) {
                this.bbi.setId(bVar.Ur);
                this.bbi.setUrl(bVar.Uq);
                this.bbi.setName(bVar.Un);
                this.bbi.setPosition(i);
                this.bbi.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.Um, 0));
                int b = AppDownloadView.b(this.bbi);
                this.bbi.setStatus(b);
                biVar.bav.a(this.Hd, this.bbi);
                a(true, biVar);
                switch (b) {
                    case 1:
                        biVar.bbt.setText(n.i.downloading2);
                        break;
                    case 3:
                        biVar.bbt.setText(n.i.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(bVar.UA.UK) || TextUtils.isEmpty(bVar.UA.UK.trim())) {
                            biVar.bbt.setText(n.i.pb_app_download);
                            break;
                        } else {
                            biVar.bbt.setText(bVar.UA.UK);
                            break;
                        }
                        break;
                    case 7:
                        biVar.bbt.setText(n.i.frs_new_style_download_pause);
                        break;
                }
                ((FrsActivity.b) this.aZW).b(biVar.bav);
                biVar.bbt.setOnClickListener(this.aZW);
            }
        }
    }

    private void a(boolean z, bi biVar) {
        com.baidu.tbadk.core.util.as.i((View) biVar.bbt, n.e.btn_appdownload);
        com.baidu.tbadk.core.util.as.b(biVar.bbt, n.c.cp_cont_i, 1);
    }

    private String hi(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }
}
