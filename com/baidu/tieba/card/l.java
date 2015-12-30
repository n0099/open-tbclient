package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class l extends b<com.baidu.tieba.card.a.h> {
    private a[] aNJ;
    private String aNK;
    private String aNL;
    private final LinearLayout.LayoutParams avb;
    private View.OnClickListener mOnClickListener;

    public void an(String str, String str2) {
        this.aNL = str;
        this.aNK = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aNJ = new a[4];
        this.avb = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        this.aNK = null;
        this.aNL = null;
        this.mOnClickListener = new m(this);
        this.aNu.setOrientation(0);
        int dimensionPixelOffset = tbPageContext.getResources().getDimensionPixelOffset(n.e.ds36);
        this.aNu.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        this.aNu.setWeightSum(4.0f);
        for (int i = 0; i < 4; i++) {
            a Ij = Ij();
            this.aNu.addView(Ij.view, this.avb);
            this.aNJ[i] = Ij;
        }
        this.aNm.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.h hVar) {
        super.a((l) hVar);
        if (hVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<h.a> DS = hVar.DS();
        int l = com.baidu.tbadk.core.util.y.l(DS);
        if (l > 0) {
            getView().setVisibility(0);
            List<h.a> subList = l > 4 ? DS.subList(0, 4) : DS;
            int size = subList.size();
            for (int i = 0; i < 4; i++) {
                a aVar = this.aNJ[i];
                if (i < size) {
                    aVar.view.setVisibility(0);
                    h.a aVar2 = subList.get(i);
                    aVar.view.setTag(aVar2);
                    a(aVar, aVar2);
                } else {
                    aVar.view.setVisibility(8);
                }
            }
            onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (a aVar : this.aNJ) {
            com.baidu.tbadk.i.a.a(tbPageContext, aVar.view);
        }
        super.onChangeSkinType(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TbImageView Nm;
        public TextView aGr;
        private View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private a Ij() {
        View inflate = LayoutInflater.from(getContext()).inflate(n.h.card_group_category_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.Nm = (TbImageView) inflate.findViewById(n.g.icon);
        aVar.aGr = (TextView) inflate.findViewById(n.g.name);
        aVar.view = inflate;
        inflate.setOnClickListener(this.mOnClickListener);
        return aVar;
    }

    private void a(a aVar, h.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.aGr.setText(ax.d(aVar2.title, 4, null));
            if (!StringUtils.isNULL(aVar2.url)) {
                aVar.Nm.d(aVar2.url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aNm == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(getContext(), "")));
            if (!TextUtils.isEmpty(this.aNL)) {
                TiebaStatic.log(this.aNL);
            }
        }
    }
}
