package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class bk extends bm<com.baidu.tbadk.core.data.a> {
    static final /* synthetic */ boolean ju;
    private View.OnClickListener aBk;

    static {
        ju = !bk.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bk(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_item_app_new, null);
        bl blVar = new bl(null);
        if (ju || inflate != 0) {
            blVar.aBY = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_app_item_parent);
            blVar.aBZ = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.frs_app_icon);
            blVar.aCa = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_name);
            blVar.aCb = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_time);
            blVar.aCc = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_desc);
            blVar.aCd = (TbImageView) inflate.findViewById(com.baidu.tieba.v.frs_app_url);
            blVar.aCe = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_download);
            inflate.setTag(blVar);
            return inflate;
        }
        throw new AssertionError();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.a aVar) {
        super.b(i, view, viewGroup, aVar);
        if (this.aBz != null) {
            this.aBz.FE();
        }
        bl blVar = (bl) view.getTag();
        blVar.aBY.setPadding(0, i - this.aCh == 0 ? this.aza : this.azb, 0, 0);
        this.aBz.getLayoutMode().L(this.mSkinType == 1);
        this.aBz.getLayoutMode().h(view);
        if (aVar instanceof com.baidu.tbadk.core.data.a) {
            if (!aVar.zv) {
                aVar.zv = true;
                this.aBz.a(aVar, "show");
                this.aBz.b(aVar, "show");
            }
            blVar.aCa.setText(fh(aVar.zu.userName));
            if (aVar.zu == null) {
                return null;
            }
            if (TextUtils.isEmpty(aVar.zu.zx) || TextUtils.isEmpty(aVar.zu.zx.trim())) {
                blVar.aCc.setVisibility(8);
            } else {
                blVar.aCc.setVisibility(0);
                blVar.aCc.setText(aVar.zu.zx);
            }
            blVar.aCb.setText(com.baidu.tbadk.core.util.az.j(aVar.zt));
            if (com.baidu.tbadk.core.l.js().ju()) {
                blVar.aBZ.setVisibility(0);
                blVar.aBZ.c(aVar.zu.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                blVar.aBZ.setVisibility(8);
            }
            blVar.aBZ.setTag(aVar.zu.userPortrait);
            if (com.baidu.tbadk.core.l.js().jw() && !TextUtils.isEmpty(aVar.zu.zy)) {
                blVar.aCd.setVisibility(0);
                blVar.aCd.c(aVar.zu.zy, this.mIsFromCDN ? 30 : 31, false);
                blVar.aCc.setPadding(0, 0, 0, 0);
            } else {
                blVar.aCd.setVisibility(8);
                blVar.aCc.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30));
            }
            blVar.aCe.setTag(Integer.valueOf(i));
            if (aVar.jH()) {
                blVar.aCe.setVisibility(8);
                return view;
            } else if (aVar.jG()) {
                blVar.aCe.setVisibility(0);
                switch (aVar.zf) {
                    case 0:
                        a(true, blVar);
                        blVar.aCe.setText(com.baidu.tieba.y.pb_app_download);
                        blVar.aCe.setOnClickListener(this.aBk);
                        return view;
                    case 1:
                        a(false, blVar);
                        blVar.aCe.setText(com.baidu.tieba.y.downloading2);
                        blVar.aCe.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, blVar);
                        blVar.aCe.setText(com.baidu.tieba.y.frs_new_style_download_text);
                        blVar.aCe.setOnClickListener(this.aBk);
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

    public void j(View.OnClickListener onClickListener) {
        this.aBk = onClickListener;
    }

    private void a(boolean z, bl blVar) {
        if (z) {
            com.baidu.tbadk.core.util.aw.h((View) blVar.aCe, com.baidu.tieba.u.btn_appdownload);
            com.baidu.tbadk.core.util.aw.b(blVar.aCe, com.baidu.tieba.s.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.aw.h((View) blVar.aCe, com.baidu.tieba.u.btn_content_download_d);
        com.baidu.tbadk.core.util.aw.b(blVar.aCe, com.baidu.tieba.s.faceshop_downloaded_text, 1);
    }

    private String fh(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bl);
    }
}
