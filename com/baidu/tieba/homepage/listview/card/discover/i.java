package com.baidu.tieba.homepage.listview.card.discover;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.listview.card.discover.h;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i extends x.a implements com.baidu.tieba.homepage.listview.g<h.b> {
    private h.b bzg;
    public ViewGroup bzh;
    public TbImageView bzi;
    public ImageView bzj;
    public ImageView bzk;
    public TextView bzl;
    public View bzm;
    private int mSkinType;
    private TbPageContext<?> pageContext;

    public i(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bzg = null;
        this.pageContext = tbPageContext;
        view.setLayoutParams(new ViewGroup.LayoutParams(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp()) / 4, -1));
        this.bzh = (ViewGroup) view.findViewById(n.f.cell_root);
        this.bzi = (TbImageView) view.findViewById(n.f.cell_image_view);
        this.bzi.setDefaultBgResource(0);
        this.bzj = (ImageView) view.findViewById(n.f.cell_red_point);
        this.bzk = (ImageView) view.findViewById(n.f.cell_new_point);
        this.bzl = (TextView) view.findViewById(n.f.cell_text_view);
        this.bzm = view.findViewById(n.f.right_line);
        TX();
    }

    private void TX() {
        as.i(this.bzh, n.e.topic_name_selector);
        as.h((View) this.bzl, n.c.cp_cont_f);
        as.i(this.bzj, n.e.icon_dot_red);
        as.i(this.bzk, n.e.icon_new);
        as.j(this.bzm, n.c.cp_bg_line_c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(h.b bVar) {
        if (bVar == null) {
            this.bzh.setVisibility(8);
            return;
        }
        this.bzg = bVar;
        this.bzh.setVisibility(0);
        ar(bVar.iconUrl, bVar.statistics);
        this.bzl.setText(bVar.title);
        da(bVar.auC);
        if (!bVar.auC && bVar.bze) {
            bW(true);
        } else {
            bW(false);
        }
        this.bzh.setOnClickListener(new j(this, bVar));
    }

    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
        }
        this.mSkinType = i;
    }

    public void ar(String str, String str2) {
        if (this.bzi != null) {
            this.bzi.setDefaultResource(c.gG(str2));
            if (!StringUtils.isNull(str)) {
                this.bzi.d(str, 10, false);
            }
        }
    }

    public void bW(boolean z) {
        if (z) {
            this.bzj.setVisibility(0);
        } else {
            this.bzj.setVisibility(8);
        }
    }

    public void da(boolean z) {
        if (z) {
            this.bzk.setVisibility(0);
        } else {
            this.bzk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h.b bVar) {
        if (bVar != null) {
            bVar.auC = false;
            bVar.bze = false;
            bW(false);
            da(false);
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("discover_tip_show_" + bVar.title, false);
            if ("discover_friend".equals(bVar.statistics)) {
                com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "friend_feed_tip_show", false);
                TbadkCoreApplication.m411getInst().setFriendFeedNew(false);
            }
        }
    }
}
