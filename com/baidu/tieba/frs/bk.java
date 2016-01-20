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
public class bk extends bp<com.baidu.tbadk.core.data.b, bl> {
    private View.OnClickListener bdS;
    private View.OnClickListener bdT;
    private DownloadData bfh;

    /* JADX INFO: Access modifiers changed from: protected */
    public bk(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bfh = new DownloadData();
    }

    public void i(View.OnClickListener onClickListener) {
        this.bdT = onClickListener;
    }

    public void h(View.OnClickListener onClickListener) {
        this.bdS = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public bl a(ViewGroup viewGroup) {
        return new bl(LayoutInflater.from(this.mContext).inflate(n.h.frs_app_muti_pic_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bl blVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) blVar);
        b(i, view, viewGroup, bVar, blVar);
        a(blVar, bVar);
        return view;
    }

    private void a(bl blVar, com.baidu.tbadk.core.data.b bVar) {
        if (bVar == null || bVar.Vb == null) {
            blVar.bfj.setVisibility(8);
            return;
        }
        List<String> list = bVar.Vb.Vm;
        if (list == null || list.size() <= 0) {
            blVar.bfj.setVisibility(8);
        } else if (!com.baidu.tbadk.core.m.qQ().qW()) {
            blVar.bfj.setVisibility(8);
        } else {
            blVar.bfj.setVisibility(0);
            int size = list.size();
            a(blVar, size);
            int i = this.mIsFromCDN ? 30 : 31;
            if (size == 1) {
                blVar.bfp.d(list.get(0), i, false);
            } else if (size == 2) {
                blVar.bfp.d(list.get(0), i, false);
                blVar.bfq.d(list.get(1), i, false);
            } else if (size >= 3) {
                blVar.bfp.d(list.get(0), i, false);
                blVar.bfq.d(list.get(1), i, false);
                blVar.bfr.d(list.get(2), i, false);
            }
        }
    }

    private void a(bl blVar, int i) {
        if (i > 0) {
            if (i == 1) {
                blVar.bfp.setVisibility(0);
                blVar.bfq.setVisibility(4);
                blVar.bfr.setVisibility(4);
            } else if (i == 2) {
                blVar.bfp.setVisibility(0);
                blVar.bfq.setVisibility(0);
                blVar.bfr.setVisibility(4);
            } else if (i >= 3) {
                blVar.bfp.setVisibility(0);
                blVar.bfq.setVisibility(0);
                blVar.bfr.setVisibility(0);
            }
        }
    }

    private void b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bl blVar) {
        if (this.bbA != null && bVar != null && bVar.Vb != null && this.bbA != null && (this.bbA instanceof FrsActivity)) {
            ((FrsActivity) this.bbA).Nr().Pn();
            blVar.bfi.setPadding(0, i - this.bdi == 0 ? this.bcm : this.bcn, 0, 0);
            this.bbA.getLayoutMode().ac(this.mSkinType == 1);
            this.bbA.getLayoutMode().k(view);
            if (!bVar.Vc && this.bbA != null && (this.bbA instanceof FrsActivity)) {
                bVar.Vc = true;
                ((FrsActivity) this.bbA).a(bVar, "show");
                ((FrsActivity) this.bbA).b(bVar, "show");
            }
            blVar.bfl.setText(hu(bVar.Vb.userName));
            if (StringUtils.isNull(bVar.Vb.Ve)) {
                blVar.bfn.setVisibility(8);
            } else {
                blVar.bfn.setVisibility(0);
                blVar.bfn.setText(bVar.Vb.Ve);
            }
            if (StringUtils.isNull(bVar.Vb.Vf)) {
                blVar.bfo.setVisibility(8);
            } else {
                blVar.bfo.setVisibility(0);
                blVar.bfo.setText(bVar.Vb.Vf);
            }
            blVar.bfm.setText(com.baidu.tbadk.core.util.ax.s(bVar.Va));
            if (com.baidu.tbadk.core.m.qQ().qS()) {
                blVar.bfk.setVisibility(0);
                blVar.bfk.d(bVar.Vb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                blVar.bfk.setVisibility(8);
            }
            blVar.bfk.setTag(bVar.Vb.userPortrait);
            blVar.bfs.setVisibility(0);
            blVar.bfs.setTag(Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blVar.bfl.getLayoutParams();
            layoutParams.width = -2;
            if (bVar.rm()) {
                blVar.beu.setVisibility(8);
                if (StringUtils.isNull(bVar.Vb.Vl)) {
                    blVar.bfs.setVisibility(8);
                    layoutParams.width = -1;
                    return;
                }
                a(true, blVar);
                blVar.bfs.setText(bVar.Vb.Vl);
                blVar.bfs.setOnClickListener(this.bdS);
            } else if (bVar.rl()) {
                this.bfh.setId(bVar.US);
                this.bfh.setUrl(bVar.UR);
                this.bfh.setName(bVar.UN);
                this.bfh.setPosition(i);
                this.bfh.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.UM, 0));
                int b = AppDownloadView.b(this.bfh);
                this.bfh.setStatus(b);
                blVar.beu.a(this.Ht, this.bfh);
                a(true, blVar);
                switch (b) {
                    case 1:
                        blVar.bfs.setText(n.j.downloading2);
                        break;
                    case 3:
                        blVar.bfs.setText(n.j.frs_new_style_download_text);
                        break;
                    case 6:
                        if (TextUtils.isEmpty(bVar.Vb.Vl) || TextUtils.isEmpty(bVar.Vb.Vl.trim())) {
                            blVar.bfs.setText(n.j.pb_app_download);
                            break;
                        } else {
                            blVar.bfs.setText(bVar.Vb.Vl);
                            break;
                        }
                        break;
                    case 7:
                        blVar.bfs.setText(n.j.frs_new_style_download_pause);
                        break;
                }
                ((FrsActivity.b) this.bdT).b(blVar.beu);
                blVar.bfs.setOnClickListener(this.bdT);
            }
        }
    }

    private void a(boolean z, bl blVar) {
        com.baidu.tbadk.core.util.as.i((View) blVar.bfs, n.f.btn_appdownload);
        com.baidu.tbadk.core.util.as.b(blVar.bfs, n.d.cp_cont_i, 1);
    }

    private String hu(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }
}
