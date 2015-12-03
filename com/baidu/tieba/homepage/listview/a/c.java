package com.baidu.tieba.homepage.listview.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.listview.g;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends x.a implements g<b> {
    private View MF;
    private TbImageView bCf;
    private TbImageView bCg;
    private TbImageView bCh;
    private TbImageView bCi;
    private List<TbImageView> bCj;
    private TextView bCk;
    private TextView bCl;
    private TextView bCm;
    private TextView bCn;
    private List<TextView> bCo;
    private LinearLayout bCp;
    private LinearLayout bCq;
    private LinearLayout bCr;
    private LinearLayout bCs;
    private List<LinearLayout> bCt;
    private TbPageContext<?> mContext;
    private View mRootView;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        this.mRootView = view;
        this.bCp = (LinearLayout) view.findViewById(n.f.entry_ll_01);
        this.bCq = (LinearLayout) view.findViewById(n.f.entry_ll_02);
        this.bCr = (LinearLayout) view.findViewById(n.f.entry_ll_03);
        this.bCs = (LinearLayout) view.findViewById(n.f.entry_ll_04);
        this.bCt = new ArrayList();
        this.bCt.add(this.bCp);
        this.bCt.add(this.bCq);
        this.bCt.add(this.bCr);
        this.bCt.add(this.bCs);
        this.MF = view.findViewById(n.f.sudoku_bottom_line);
        this.bCf = (TbImageView) view.findViewById(n.f.entry_image_01);
        this.bCg = (TbImageView) view.findViewById(n.f.entry_image_02);
        this.bCh = (TbImageView) view.findViewById(n.f.entry_image_03);
        this.bCi = (TbImageView) view.findViewById(n.f.entry_image_04);
        this.bCj = new ArrayList();
        this.bCj.add(this.bCf);
        this.bCj.add(this.bCg);
        this.bCj.add(this.bCh);
        this.bCj.add(this.bCi);
        this.bCk = (TextView) view.findViewById(n.f.entry_name_01);
        this.bCl = (TextView) view.findViewById(n.f.entry_name_02);
        this.bCm = (TextView) view.findViewById(n.f.entry_name_03);
        this.bCn = (TextView) view.findViewById(n.f.entry_name_04);
        this.bCo = new ArrayList();
        this.bCo.add(this.bCk);
        this.bCo.add(this.bCl);
        this.bCo.add(this.bCm);
        this.bCo.add(this.bCn);
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(b bVar) {
        if (bVar != null) {
            if (y.k(bVar.awS) <= 0) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.mRootView.setVisibility(0);
            if (bVar.bCe) {
                this.MF.setVisibility(0);
            } else {
                this.MF.setVisibility(8);
            }
            for (int i = 0; i < 4; i++) {
                a aVar = (a) y.b(bVar.awS, i);
                LinearLayout linearLayout = this.bCt.get(i);
                if (aVar == null) {
                    linearLayout.setVisibility(8);
                } else if (StringUtils.isNull(aVar.byT) || StringUtils.isNull(aVar.bzW)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setVisibility(0);
                    if (aVar.bCd != null) {
                        linearLayout.setOnClickListener(aVar.bCd);
                    }
                    this.bCj.get(i).d(aVar.byT, 10, false);
                    this.bCo.get(i).setText(aVar.bzW.trim());
                }
            }
        }
    }

    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
        }
        this.mSkinType = i;
    }

    private void TX() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 4) {
                as.i(this.bCt.get(i2), n.e.topic_name_selector);
                as.h((View) this.bCo.get(i2), n.c.cp_cont_f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
