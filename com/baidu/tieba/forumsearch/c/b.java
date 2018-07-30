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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private WrapLineLayout dlm;
    private List<a> dln;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dln = new ArrayList();
        this.mSkinType = 3;
        this.dlm = (WrapLineLayout) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            for (a aVar : this.dln) {
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
        if (aVar != null && !w.z(aVar.atx())) {
            kn(aVar.atx().size());
            int size = this.dln.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.dln.get(i);
                if (aVar2 != null) {
                    aVar2.fu(false);
                    aVar2.mTextView.setText(aVar.atx().get(i));
                }
            }
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void kn(int i) {
        int size = this.dln.size();
        if (size != i) {
            if (size < i) {
                int i2 = i - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    a atC = atC();
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.topMargin = l.f(TbadkCoreApplication.getInst(), d.e.ds2);
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    this.dlm.addView(atC.getView(), marginLayoutParams);
                    this.dln.add(atC);
                }
            } else if (i == 0) {
                this.dlm.removeAllViews();
                this.dln.clear();
            } else if (size > i) {
                int i4 = size - i;
                for (int i5 = 0; i5 < i4; i5++) {
                    this.dlm.removeView(this.dln.get(i5).getView());
                    this.dln.remove(i5);
                }
            }
        }
    }

    private a atC() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private ImageView dkV;
        private View mRootView;
        private TextView mTextView;

        public a() {
            this.mRootView = LayoutInflater.from(b.this.aiy().getPageActivity()).inflate(d.h.forum_search_history_info_item, (ViewGroup) null);
            this.mTextView = (TextView) this.mRootView.findViewById(d.g.content);
            this.dkV = (ImageView) this.mRootView.findViewById(d.g.delete);
            onChangeSkinType();
            this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    for (a aVar : b.this.dln) {
                        if (aVar != null && aVar.getView() != view) {
                            aVar.fu(false);
                        }
                    }
                    a.this.fu(true);
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
            this.dkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mTextView.getText() != null) {
                        e.mr(a.this.mTextView.getText().toString());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
                    }
                }
            });
        }

        public View getView() {
            return this.mRootView;
        }

        public void fu(boolean z) {
            if (z) {
                this.dkV.setVisibility(0);
                am.c(this.dkV, d.f.del_search_btn);
                return;
            }
            this.dkV.setVisibility(4);
        }

        public void onChangeSkinType() {
            am.h(this.mTextView, d.C0140d.cp_cont_b);
            am.i(this.mTextView, d.f.search_history_item_bg);
            am.c(this.dkV, d.f.del_search_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
