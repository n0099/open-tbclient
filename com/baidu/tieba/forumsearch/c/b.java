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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private WrapLineLayout eXI;
    private List<a> eXJ;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eXJ = new ArrayList();
        this.mSkinType = 3;
        this.eXI = (WrapLineLayout) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            for (a aVar : this.eXJ) {
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
        if (aVar != null && !v.T(aVar.bbz())) {
            pQ(aVar.bbz().size());
            int size = this.eXJ.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.eXJ.get(i);
                if (aVar2 != null) {
                    aVar2.iQ(false);
                    aVar2.mTextView.setText(aVar.bbz().get(i));
                }
            }
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void pQ(int i) {
        int size = this.eXJ.size();
        if (size != i) {
            if (size < i) {
                int i2 = i - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    a bbE = bbE();
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.topMargin = l.h(TbadkCoreApplication.getInst(), d.e.ds2);
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    this.eXI.addView(bbE.getView(), marginLayoutParams);
                    this.eXJ.add(bbE);
                }
            } else if (i == 0) {
                this.eXI.removeAllViews();
                this.eXJ.clear();
            } else if (size > i) {
                int i4 = size - i;
                for (int i5 = 0; i5 < i4; i5++) {
                    this.eXI.removeView(this.eXJ.get(i5).getView());
                    this.eXJ.remove(i5);
                }
            }
        }
    }

    private a bbE() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        private ImageView eXr;
        private View mRootView;
        private TextView mTextView;

        public a() {
            this.mRootView = LayoutInflater.from(b.this.getTbPageContext().getPageActivity()).inflate(d.h.forum_search_history_info_item, (ViewGroup) null);
            this.mTextView = (TextView) this.mRootView.findViewById(d.g.content);
            this.eXr = (ImageView) this.mRootView.findViewById(d.g.delete);
            onChangeSkinType();
            this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    for (a aVar : b.this.eXJ) {
                        if (aVar != null && aVar.getView() != view) {
                            aVar.iQ(false);
                        }
                    }
                    a.this.iQ(true);
                    return true;
                }
            });
            this.mTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mTextView.getText() != null && !StringUtils.isNull(a.this.mTextView.getText().toString())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921021, a.this.mTextView.getText().toString()));
                    }
                }
            });
            this.eXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mTextView.getText() != null) {
                        e.uV(a.this.mTextView.getText().toString());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
                    }
                }
            });
        }

        public View getView() {
            return this.mRootView;
        }

        public void iQ(boolean z) {
            if (z) {
                this.eXr.setVisibility(0);
                al.c(this.eXr, d.f.del_search_btn);
                return;
            }
            this.eXr.setVisibility(4);
        }

        public void onChangeSkinType() {
            al.j(this.mTextView, d.C0277d.cp_cont_b);
            al.k(this.mTextView, d.f.search_history_item_bg);
            al.c(this.eXr, d.f.del_search_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
