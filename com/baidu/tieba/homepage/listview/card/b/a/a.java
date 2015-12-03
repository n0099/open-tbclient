package com.baidu.tieba.homepage.listview.card.b.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.homepage.listview.card.b.b;
import com.baidu.tieba.homepage.listview.g;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends x.a implements g<b.a> {
    private TbClipImageView bzG;
    private TextView bzH;
    private TextView bzI;
    private final int bzJ;
    private final int bzK;
    private final int bzL;
    private final int bzM;
    private b.a bzN;
    private TbPageContext<?> mContext;
    private int position;
    private View rootView;

    public a(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.bzJ = 1;
        this.bzK = 2;
        this.bzL = 3;
        this.bzM = 4;
        this.position = -1;
        this.mContext = tbPageContext;
        this.rootView = view.findViewById(n.f.fun_center_game_item_ll);
        this.bzG = (TbClipImageView) view.findViewById(n.f.fun_center_game_item_pic);
        this.bzG.setDrawerType(1);
        this.bzG.setRadius(k.d(tbPageContext.getPageActivity(), n.d.ds26));
        this.bzG.setDrawBorder(true);
        this.bzG.setBorderWidth(1);
        this.bzH = (TextView) view.findViewById(n.f.fun_center_game_item_name);
        this.bzI = (TextView) view.findViewById(n.f.fun_center_game_item_class_name);
    }

    private String getText(int i) {
        switch (i) {
            case 1:
                return this.mContext.getResources().getString(n.i.game);
            case 2:
                return this.mContext.getResources().getString(n.i.kn_zhibo);
            case 3:
                return this.mContext.getResources().getString(n.i.chess);
            case 4:
                return this.mContext.getResources().getString(n.i.athletics);
            default:
                return "";
        }
    }

    private Drawable hB(int i) {
        switch (i) {
            case 1:
                return as.getDrawable(n.e.label_bg_orange);
            case 2:
                return as.getDrawable(n.e.label_bg_green);
            case 3:
                return as.getDrawable(n.e.label_bg_blue);
            case 4:
                return as.getDrawable(n.e.label_bg_pink);
            default:
                return null;
        }
    }

    private int hC(int i) {
        switch (i) {
            case 1:
                return as.getColor(n.c.cp_other_f);
            case 2:
                return as.getColor(n.c.cp_other_c);
            case 3:
                return as.getColor(n.c.cp_link_tip_a);
            case 4:
                return as.getColor(n.c.cp_other_b);
            default:
                return as.getColor(n.c.cp_other_f);
        }
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(b.a aVar) {
        if (aVar != null) {
            this.bzN = aVar;
            if (!StringUtils.isNull(aVar.bzx)) {
                this.bzG.d(aVar.bzx, 10, false);
            }
            if (!StringUtils.isNull(aVar.appName)) {
                this.bzH.setText(aVar.appName);
            }
            this.bzI.setText(getText(aVar.bzz));
            this.bzI.setBackgroundDrawable(hB(aVar.bzz));
            this.bzI.setTextColor(hC(aVar.bzz));
            if (!StringUtils.isNull(aVar.bzy)) {
                this.rootView.setOnClickListener(new b(this, aVar));
            }
        }
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void cZ(int i) {
        as.h((View) this.bzH, n.c.cp_cont_f);
        D(this.bzN);
    }
}
