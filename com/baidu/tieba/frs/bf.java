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
public class bf extends bh<com.baidu.tbadk.core.data.c> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private View.OnClickListener aDJ;

    static {
        $assertionsDisabled = !bf.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bf(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_item_app_new, null);
        bg bgVar = new bg();
        if ($assertionsDisabled || inflate != 0) {
            bgVar.aEy = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_app_item_parent);
            bgVar.aEz = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.frs_app_icon);
            bgVar.aEz.setSupportNoImage(false);
            bgVar.aEA = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_name);
            bgVar.aEB = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_time);
            bgVar.aEC = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_desc);
            bgVar.aED = (TbImageView) inflate.findViewById(com.baidu.tieba.w.frs_app_url);
            bgVar.aEE = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_app_download);
            inflate.setTag(bgVar);
            return inflate;
        }
        throw new AssertionError();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar) {
        super.b(i, view, viewGroup, cVar);
        if (this.aEa != null) {
            this.aEa.Ga();
        }
        bg bgVar = (bg) view.getTag();
        bgVar.aEy.setPadding(0, i - this.aEH == 0 ? this.aBZ : this.aCa, 0, 0);
        this.aEa.getLayoutMode().ab(this.mSkinType == 1);
        this.aEa.getLayoutMode().h(view);
        if (cVar instanceof com.baidu.tbadk.core.data.c) {
            if (!cVar.Dz) {
                cVar.Dz = true;
                this.aEa.a(cVar, "show");
                this.aEa.b(cVar, "show");
            }
            bgVar.aEA.setText(fC(cVar.Dy.userName));
            if (cVar.Dy == null) {
                return null;
            }
            if (TextUtils.isEmpty(cVar.Dy.DB) || TextUtils.isEmpty(cVar.Dy.DB.trim())) {
                bgVar.aEC.setVisibility(8);
            } else {
                bgVar.aEC.setVisibility(0);
                bgVar.aEC.setText(cVar.Dy.DB);
            }
            bgVar.aEB.setText(com.baidu.tbadk.core.util.bf.n(cVar.Dx));
            if (com.baidu.tbadk.core.l.lV().lX()) {
                bgVar.aEz.setVisibility(0);
                bgVar.aEz.d(cVar.Dy.userPortrait, this.mIsFromCDN ? 13 : 14, false);
            } else {
                bgVar.aEz.setVisibility(8);
            }
            bgVar.aEz.setTag(cVar.Dy.userPortrait);
            if (com.baidu.tbadk.core.l.lV().lZ() && !TextUtils.isEmpty(cVar.Dy.DD)) {
                bgVar.aED.setVisibility(0);
                bgVar.aED.d(cVar.Dy.DD, this.mIsFromCDN ? 30 : 31, false);
                bgVar.aEC.setPadding(0, 0, 0, 0);
            } else {
                bgVar.aED.setVisibility(8);
                bgVar.aEC.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30));
            }
            bgVar.aEE.setTag(Integer.valueOf(i));
            if (cVar.mp()) {
                bgVar.aEE.setVisibility(8);
                return view;
            } else if (cVar.mo()) {
                bgVar.aEE.setVisibility(0);
                switch (cVar.Dj) {
                    case 0:
                        a(true, bgVar);
                        bgVar.aEE.setText(com.baidu.tieba.z.pb_app_download);
                        bgVar.aEE.setOnClickListener(this.aDJ);
                        return view;
                    case 1:
                        a(false, bgVar);
                        bgVar.aEE.setText(com.baidu.tieba.z.downloading2);
                        bgVar.aEE.setOnClickListener(null);
                        return view;
                    case 2:
                        a(true, bgVar);
                        bgVar.aEE.setText(com.baidu.tieba.z.frs_new_style_download_text);
                        bgVar.aEE.setOnClickListener(this.aDJ);
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
        this.aDJ = onClickListener;
    }

    private void a(boolean z, bg bgVar) {
        if (z) {
            com.baidu.tbadk.core.util.bc.i((View) bgVar.aEE, com.baidu.tieba.v.btn_appdownload);
            com.baidu.tbadk.core.util.bc.b(bgVar.aEE, com.baidu.tieba.t.cp_cont_i, 1);
            return;
        }
        com.baidu.tbadk.core.util.bc.i((View) bgVar.aEE, com.baidu.tieba.v.btn_content_download_d);
        com.baidu.tbadk.core.util.bc.b(bgVar.aEE, com.baidu.tieba.t.faceshop_downloaded_text, 1);
    }

    private String fC(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof bg);
    }
}
