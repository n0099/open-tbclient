package com.baidu.tieba.a;

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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.a.a.f;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class k extends b<com.baidu.tieba.a.a.f> {
    private a[] aMi;
    private String aMj;
    private String aMk;
    private final LinearLayout.LayoutParams atx;
    private View.OnClickListener mOnClickListener;

    public void ao(String str, String str2) {
        this.aMk = str;
        this.aMj = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aMi = new a[4];
        this.atx = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        this.aMj = null;
        this.aMk = null;
        this.mOnClickListener = new l(this);
        this.aLV.setOrientation(0);
        int dimensionPixelOffset = tbPageContext.getResources().getDimensionPixelOffset(n.d.ds36);
        this.aLV.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        this.aLV.setWeightSum(4.0f);
        for (int i = 0; i < 4; i++) {
            a Is = Is();
            this.aLV.addView(Is.view, this.atx);
            this.aMi[i] = Is;
        }
        this.aLN.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a.b
    public void a(com.baidu.tieba.a.a.f fVar) {
        super.a((k) fVar);
        if (fVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<f.a> Ed = fVar.Ed();
        int k = y.k(Ed);
        if (k > 0) {
            getView().setVisibility(0);
            List<f.a> subList = k > 4 ? Ed.subList(0, 4) : Ed;
            int size = subList.size();
            for (int i = 0; i < 4; i++) {
                a aVar = this.aMi[i];
                if (i < size) {
                    aVar.view.setVisibility(0);
                    f.a aVar2 = subList.get(i);
                    aVar.view.setTag(aVar2);
                    a(aVar, aVar2);
                } else {
                    aVar.view.setVisibility(8);
                }
            }
            onChangeSkinType(Io(), TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.a.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (a aVar : this.aMi) {
            com.baidu.tbadk.i.a.a(tbPageContext, aVar.view);
        }
        super.onChangeSkinType(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TbImageView MW;
        public TextView aER;
        private View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private a Is() {
        View inflate = LayoutInflater.from(getContext()).inflate(n.g.card_group_category_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.MW = (TbImageView) inflate.findViewById(n.f.icon);
        aVar.aER = (TextView) inflate.findViewById(n.f.name);
        aVar.view = inflate;
        inflate.setOnClickListener(this.mOnClickListener);
        return aVar;
    }

    private void a(a aVar, f.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.aER.setText(ax.d(aVar2.title, 4, null));
            if (!StringUtils.isNULL(aVar2.url)) {
                aVar.MW.d(aVar2.url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.a.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aLN == view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(getContext(), "")));
            if (!TextUtils.isEmpty(this.aMk)) {
                TiebaStatic.log(this.aMk);
            }
        }
    }
}
