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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class u extends b<com.baidu.tieba.card.a.l> {
    private a[] aSH;
    private String aSI;
    private String aSJ;
    private final LinearLayout.LayoutParams awA;
    private View.OnClickListener mOnClickListener;

    public void at(String str, String str2) {
        this.aSJ = str;
        this.aSI = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aSH = new a[4];
        this.awA = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        this.aSI = null;
        this.aSJ = null;
        this.mOnClickListener = new v(this);
        this.aRx.setOrientation(0);
        int dimensionPixelOffset = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds36);
        this.aRx.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        this.aRx.setWeightSum(4.0f);
        for (int i = 0; i < 4; i++) {
            a Lj = Lj();
            this.aRx.addView(Lj.view, this.awA);
            this.aSH[i] = Lj;
        }
        this.aRp.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.l lVar) {
        super.a((u) lVar);
        if (lVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<l.a> FZ = lVar.FZ();
        int p = com.baidu.tbadk.core.util.y.p(FZ);
        if (p > 0) {
            getView().setVisibility(0);
            List<l.a> subList = p > 4 ? FZ.subList(0, 4) : FZ;
            int size = subList.size();
            for (int i = 0; i < 4; i++) {
                a aVar = this.aSH[i];
                if (i < size) {
                    aVar.view.setVisibility(0);
                    l.a aVar2 = subList.get(i);
                    aVar.view.setTag(aVar2);
                    a(aVar, aVar2);
                } else {
                    aVar.view.setVisibility(8);
                }
            }
            d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        for (a aVar : this.aSH) {
            com.baidu.tbadk.i.a.a(tbPageContext, aVar.view);
        }
        super.d(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TbImageView NV;
        public TextView aKg;
        private View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private a Lj() {
        View inflate = LayoutInflater.from(getContext()).inflate(t.h.card_group_category_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.NV = (TbImageView) inflate.findViewById(t.g.icon);
        aVar.aKg = (TextView) inflate.findViewById(t.g.name);
        aVar.view = inflate;
        inflate.setOnClickListener(this.mOnClickListener);
        return aVar;
    }

    private void a(a aVar, l.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.aKg.setText(com.baidu.tbadk.core.util.ay.c(aVar2.title, 4, null));
            if (!StringUtils.isNULL(aVar2.url)) {
                aVar.NV.c(aVar2.url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aRp == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(getContext(), "")));
            if (!TextUtils.isEmpty(this.aSJ)) {
                TiebaStatic.log(this.aSJ);
            }
        }
    }
}
