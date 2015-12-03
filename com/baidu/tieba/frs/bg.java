package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bg extends bm<com.baidu.tbadk.core.data.b, bk> {
    private View.OnClickListener aZV;
    private View.OnClickListener aZW;

    /* JADX INFO: Access modifiers changed from: protected */
    public bg(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private void a(boolean z, bk bkVar) {
        if (z) {
            com.baidu.tbadk.core.util.as.i((View) bkVar.bbB, n.e.frs_praise_btn_bg);
            com.baidu.tbadk.core.util.as.b(bkVar.bbB, n.c.cp_cont_f, 1);
            return;
        }
        com.baidu.tbadk.core.util.as.i((View) bkVar.bbB, n.e.btn_content_download_d);
        com.baidu.tbadk.core.util.as.b(bkVar.bbB, n.c.faceshop_downloaded_text, 1);
    }

    public void h(View.OnClickListener onClickListener) {
        this.aZV = onClickListener;
    }

    public void i(View.OnClickListener onClickListener) {
        this.aZW = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public bk a(ViewGroup viewGroup) {
        return new bk(LayoutInflater.from(this.mContext).inflate(n.g.frs_item_app, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, bk bkVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) bkVar);
        if (this.aXA == null) {
            return null;
        }
        if (this.aXA != null && (this.aXA instanceof FrsActivity)) {
            ((FrsActivity) this.aXA).MX().OV();
        }
        bkVar.bbx.setPadding(0, i - this.aZm == 0 ? this.aYn : this.aYo, 0, 0);
        this.aXA.getLayoutMode().af(this.mSkinType == 1);
        this.aXA.getLayoutMode().k(view);
        if (bVar instanceof com.baidu.tbadk.core.data.b) {
            if (!bVar.UB && (this.aXA instanceof FrsActivity)) {
                bVar.UB = true;
                ((FrsActivity) this.aXA).a(bVar, "show");
                ((FrsActivity) this.aXA).b(bVar, "show");
            }
            bkVar.aUB.setText(bVar.UA.userName);
            bkVar.bbA.setText(bVar.UA.UD);
            if (com.baidu.tbadk.core.m.rh().rn()) {
                bkVar.bbz.setVisibility(0);
                bkVar.bbz.d(bVar.UA.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bkVar.bbz.setVisibility(8);
            }
            bkVar.bbz.setTag(bVar.UA.userPortrait);
            bkVar.bbB.setTag(Integer.valueOf(i));
            com.baidu.tbadk.core.util.as.i((View) bkVar.bby, n.e.bg_label);
            if (bVar.rD()) {
                a(true, bkVar);
                if (TextUtils.isEmpty(bVar.UA.UK) || TextUtils.isEmpty(bVar.UA.UK.trim())) {
                    bkVar.bbB.setText(n.i.view);
                } else {
                    bkVar.bbB.setText(bVar.UA.UK);
                }
                bkVar.bbB.setOnClickListener(this.aZV);
                return view;
            } else if (bVar.rC()) {
                switch (bVar.Ul) {
                    case 0:
                        if (TextUtils.isEmpty(bVar.UA.UK) || TextUtils.isEmpty(bVar.UA.UK.trim())) {
                            bkVar.bbB.setText(n.i.game_center_download);
                        } else {
                            bkVar.bbB.setText(bVar.UA.UK);
                        }
                        a(true, bkVar);
                        bkVar.bbB.setOnClickListener(this.aZW);
                        return view;
                    case 1:
                        a(false, bkVar);
                        bkVar.bbB.setText(n.i.downloading2);
                        bkVar.bbB.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bkVar);
                        bkVar.bbB.setText(n.i.frs_old_style_download_text);
                        bkVar.bbB.setOnClickListener(this.aZW);
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
