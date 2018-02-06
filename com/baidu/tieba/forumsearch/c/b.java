package com.baidu.tieba.forumsearch.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private WrapLineLayout dDC;
    private List<a> dDD;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dDD = new ArrayList();
        this.mSkinType = 3;
        this.dDC = (WrapLineLayout) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            for (a aVar : this.dDD) {
                if (aVar != null) {
                    aVar.onChangeSkinType();
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.forum_search_history_info;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.a aVar) {
        if (aVar != null && !v.E(aVar.aup())) {
            mL(aVar.aup().size());
            int size = this.dDD.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.dDD.get(i);
                if (aVar2 != null) {
                    aVar2.fI(false);
                    aVar2.rz.setText(aVar.aup().get(i));
                }
            }
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void mL(int i) {
        int size = this.dDD.size();
        if (size != i) {
            if (size < i) {
                int i2 = i - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    a auu = auu();
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.topMargin = l.t(TbadkCoreApplication.getInst(), d.e.ds2);
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    this.dDC.addView(auu.getView(), marginLayoutParams);
                    this.dDD.add(auu);
                }
            } else if (i == 0) {
                this.dDC.removeAllViews();
                this.dDD.clear();
            } else if (size > i) {
                int i4 = size - i;
                for (int i5 = 0; i5 < i4; i5++) {
                    this.dDC.removeView(this.dDD.get(i5).getView());
                    this.dDD.remove(i5);
                }
            }
        }
    }

    private a auu() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private ImageView dDl;
        private View mRootView;
        private TextView rz;

        public a() {
            this.mRootView = LayoutInflater.from(b.this.akO().getPageActivity()).inflate(d.h.forum_search_history_info_item, (ViewGroup) null);
            this.rz = (TextView) this.mRootView.findViewById(d.g.content);
            this.dDl = (ImageView) this.mRootView.findViewById(d.g.delete);
            onChangeSkinType();
            this.rz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    for (a aVar : b.this.dDD) {
                        if (aVar != null && aVar.getView() != view) {
                            aVar.fI(false);
                        }
                    }
                    a.this.fI(true);
                    return true;
                }
            });
            this.rz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.rz.getText() != null && !StringUtils.isNull(a.this.rz.getText().toString())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, a.this.rz.getText().toString()));
                    }
                }
            });
            this.dDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.rz.getText() != null) {
                        e.lF(a.this.rz.getText().toString());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
                    }
                }
            });
        }

        public View getView() {
            return this.mRootView;
        }

        public void fI(boolean z) {
            if (z) {
                this.dDl.setVisibility(0);
                aj.c(this.dDl, d.f.del_search_btn);
                return;
            }
            this.dDl.setVisibility(4);
        }

        public void onChangeSkinType() {
            aj.r(this.rz, d.C0140d.cp_cont_b);
            aj.s(this.rz, d.f.search_history_item_bg);
            aj.c(this.dDl, d.f.del_search_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
