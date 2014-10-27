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
    private View.OnClickListener aBa;

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
            blVar.aBO = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_app_item_parent);
            blVar.aBP = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.frs_app_icon);
            blVar.aBQ = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_name);
            blVar.aBR = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_time);
            blVar.aBS = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_desc);
            blVar.aBT = (TbImageView) inflate.findViewById(com.baidu.tieba.v.frs_app_url);
            blVar.aBU = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_download);
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
        if (this.aBp != null) {
            this.aBp.FC();
        }
        bl blVar = (bl) view.getTag();
        blVar.aBO.setPadding(0, i - this.aBX == 0 ? this.ayR : this.ayS, 0, 0);
        this.aBp.getLayoutMode().L(this.mSkinType == 1);
        this.aBp.getLayoutMode().h(view);
        if (aVar instanceof com.baidu.tbadk.core.data.a) {
            if (!aVar.zv) {
                aVar.zv = true;
                this.aBp.a(aVar, "show");
                this.aBp.b(aVar, "show");
            }
            blVar.aBQ.setText(fh(aVar.zu.userName));
            if (aVar.zu == null) {
                return null;
            }
            if (TextUtils.isEmpty(aVar.zu.zx) || TextUtils.isEmpty(aVar.zu.zx.trim())) {
                blVar.aBS.setVisibility(8);
            } else {
                blVar.aBS.setVisibility(0);
                blVar.aBS.setText(aVar.zu.zx);
            }
            blVar.aBR.setText(com.baidu.tbadk.core.util.ay.j(aVar.zt));
            if (com.baidu.tbadk.core.k.js().ju()) {
                blVar.aBP.setVisibility(0);
                blVar.aBP.c(aVar.zu.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                blVar.aBP.setVisibility(8);
            }
            blVar.aBP.setTag(aVar.zu.userPortrait);
            if (com.baidu.tbadk.core.k.js().jw() && !TextUtils.isEmpty(aVar.zu.zy)) {
                blVar.aBT.setVisibility(0);
                blVar.aBT.c(aVar.zu.zy, this.mIsFromCDN ? 30 : 31, false);
                blVar.aBS.setPadding(0, 0, 0, 0);
            } else {
                blVar.aBT.setVisibility(8);
                blVar.aBS.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30));
            }
            blVar.aBU.setTag(Integer.valueOf(i));
            if (aVar.jH()) {
                blVar.aBU.setVisibility(8);
                return view;
            } else if (aVar.jG()) {
                blVar.aBU.setVisibility(0);
                switch (aVar.zf) {
                    case 0:
                        a(true, blVar);
                        blVar.aBU.setText(com.baidu.tieba.y.pb_app_download);
                        blVar.aBU.setOnClickListener(this.aBa);
                        return view;
                    case 1:
                        a(false, blVar);
                        blVar.aBU.setText(com.baidu.tieba.y.downloading2);
                        blVar.aBU.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, blVar);
                        blVar.aBU.setText(com.baidu.tieba.y.frs_new_style_download_text);
                        blVar.aBU.setOnClickListener(this.aBa);
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
        this.aBa = onClickListener;
    }

    private void a(boolean z, bl blVar) {
        if (z) {
            com.baidu.tbadk.core.util.aw.h((View) blVar.aBU, com.baidu.tieba.u.btn_appdownload);
            com.baidu.tbadk.core.util.aw.b(blVar.aBU, com.baidu.tieba.s.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.aw.h((View) blVar.aBU, com.baidu.tieba.u.btn_content_download_d);
        com.baidu.tbadk.core.util.aw.b(blVar.aBU, com.baidu.tieba.s.faceshop_downloaded_text, 1);
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
