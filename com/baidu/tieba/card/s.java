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
import com.baidu.tieba.card.a.k;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class s extends b<com.baidu.tieba.card.a.k> {
    private a[] aPM;
    private String aPN;
    private String aPO;
    private final LinearLayout.LayoutParams avT;
    private View.OnClickListener mOnClickListener;

    public void an(String str, String str2) {
        this.aPO = str;
        this.aPN = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aPM = new a[4];
        this.avT = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        this.aPN = null;
        this.aPO = null;
        this.mOnClickListener = new t(this);
        this.aOI.setOrientation(0);
        int dimensionPixelOffset = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds36);
        this.aOI.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        this.aOI.setWeightSum(4.0f);
        for (int i = 0; i < 4; i++) {
            a JR = JR();
            this.aOI.addView(JR.view, this.avT);
            this.aPM[i] = JR;
        }
        this.aOA.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.k kVar) {
        super.a((s) kVar);
        if (kVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<k.a> Fm = kVar.Fm();
        int o = com.baidu.tbadk.core.util.x.o(Fm);
        if (o > 0) {
            getView().setVisibility(0);
            List<k.a> subList = o > 4 ? Fm.subList(0, 4) : Fm;
            int size = subList.size();
            for (int i = 0; i < 4; i++) {
                a aVar = this.aPM[i];
                if (i < size) {
                    aVar.view.setVisibility(0);
                    k.a aVar2 = subList.get(i);
                    aVar.view.setTag(aVar2);
                    a(aVar, aVar2);
                } else {
                    aVar.view.setVisibility(8);
                }
            }
            d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        for (a aVar : this.aPM) {
            com.baidu.tbadk.i.a.a(tbPageContext, aVar.view);
        }
        super.d(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TbImageView NM;
        public TextView aHk;
        private View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private a JR() {
        View inflate = LayoutInflater.from(getContext()).inflate(t.h.card_group_category_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.NM = (TbImageView) inflate.findViewById(t.g.icon);
        aVar.aHk = (TextView) inflate.findViewById(t.g.name);
        aVar.view = inflate;
        inflate.setOnClickListener(this.mOnClickListener);
        return aVar;
    }

    private void a(a aVar, k.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.aHk.setText(com.baidu.tbadk.core.util.aw.d(aVar2.title, 4, null));
            if (!StringUtils.isNULL(aVar2.url)) {
                aVar.NM.d(aVar2.url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aOA == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(getContext(), "")));
            if (!TextUtils.isEmpty(this.aPO)) {
                TiebaStatic.log(this.aPO);
            }
        }
    }
}
