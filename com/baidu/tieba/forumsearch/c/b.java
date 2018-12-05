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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private WrapLineLayout dGU;
    private List<a> dGV;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dGV = new ArrayList();
        this.mSkinType = 3;
        this.dGU = (WrapLineLayout) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            for (a aVar : this.dGV) {
                if (aVar != null) {
                    aVar.onChangeSkinType();
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.forum_search_history_info;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.a aVar) {
        if (aVar != null && !v.I(aVar.azO())) {
            lR(aVar.azO().size());
            int size = this.dGV.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.dGV.get(i);
                if (aVar2 != null) {
                    aVar2.go(false);
                    aVar2.mTextView.setText(aVar.azO().get(i));
                }
            }
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void lR(int i) {
        int size = this.dGV.size();
        if (size != i) {
            if (size < i) {
                int i2 = i - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    a azT = azT();
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.topMargin = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds2);
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    this.dGU.addView(azT.getView(), marginLayoutParams);
                    this.dGV.add(azT);
                }
            } else if (i == 0) {
                this.dGU.removeAllViews();
                this.dGV.clear();
            } else if (size > i) {
                int i4 = size - i;
                for (int i5 = 0; i5 < i4; i5++) {
                    this.dGU.removeView(this.dGV.get(i5).getView());
                    this.dGV.remove(i5);
                }
            }
        }
    }

    private a azT() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private ImageView dGD;
        private View mRootView;
        private TextView mTextView;

        public a() {
            this.mRootView = LayoutInflater.from(b.this.getTbPageContext().getPageActivity()).inflate(e.h.forum_search_history_info_item, (ViewGroup) null);
            this.mTextView = (TextView) this.mRootView.findViewById(e.g.content);
            this.dGD = (ImageView) this.mRootView.findViewById(e.g.delete);
            onChangeSkinType();
            this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    for (a aVar : b.this.dGV) {
                        if (aVar != null && aVar.getView() != view) {
                            aVar.go(false);
                        }
                    }
                    a.this.go(true);
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
            this.dGD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mTextView.getText() != null) {
                        com.baidu.tieba.forumsearch.controller.e.nX(a.this.mTextView.getText().toString());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
                    }
                }
            });
        }

        public View getView() {
            return this.mRootView;
        }

        public void go(boolean z) {
            if (z) {
                this.dGD.setVisibility(0);
                al.c(this.dGD, e.f.del_search_btn);
                return;
            }
            this.dGD.setVisibility(4);
        }

        public void onChangeSkinType() {
            al.h(this.mTextView, e.d.cp_cont_b);
            al.i(this.mTextView, e.f.search_history_item_bg);
            al.c(this.dGD, e.f.del_search_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
