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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.forumsearch.controller.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.forumsearch.b.a> {
    private WrapLineLayout dgF;
    private List<a> dgG;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dgG = new ArrayList();
        this.mSkinType = 3;
        this.dgF = (WrapLineLayout) getView();
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            for (a aVar : this.dgG) {
                if (aVar != null) {
                    aVar.onChangeSkinType();
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.forum_search_history_info;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.forumsearch.b.a aVar) {
        if (aVar != null && !w.z(aVar.asI())) {
            jZ(aVar.asI().size());
            int size = this.dgG.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.dgG.get(i);
                if (aVar2 != null) {
                    aVar2.fs(false);
                    aVar2.mTextView.setText(aVar.asI().get(i));
                }
            }
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void jZ(int i) {
        int size = this.dgG.size();
        if (size != i) {
            if (size < i) {
                int i2 = i - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    a asN = asN();
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.topMargin = l.e(TbadkCoreApplication.getInst(), d.e.ds2);
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    this.dgF.addView(asN.getView(), marginLayoutParams);
                    this.dgG.add(asN);
                }
            } else if (i == 0) {
                this.dgF.removeAllViews();
                this.dgG.clear();
            } else if (size > i) {
                int i4 = size - i;
                for (int i5 = 0; i5 < i4; i5++) {
                    this.dgF.removeView(this.dgG.get(i5).getView());
                    this.dgG.remove(i5);
                }
            }
        }
    }

    private a asN() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private ImageView dgo;
        private View mRootView;
        private TextView mTextView;

        public a() {
            this.mRootView = LayoutInflater.from(b.this.aiH().getPageActivity()).inflate(d.i.forum_search_history_info_item, (ViewGroup) null);
            this.mTextView = (TextView) this.mRootView.findViewById(d.g.content);
            this.dgo = (ImageView) this.mRootView.findViewById(d.g.delete);
            onChangeSkinType();
            this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    for (a aVar : b.this.dgG) {
                        if (aVar != null && aVar.getView() != view) {
                            aVar.fs(false);
                        }
                    }
                    a.this.fs(true);
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
            this.dgo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mTextView.getText() != null) {
                        e.ms(a.this.mTextView.getText().toString());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921020));
                    }
                }
            });
        }

        public View getView() {
            return this.mRootView;
        }

        public void fs(boolean z) {
            if (z) {
                this.dgo.setVisibility(0);
                al.c(this.dgo, d.f.del_search_btn);
                return;
            }
            this.dgo.setVisibility(4);
        }

        public void onChangeSkinType() {
            al.h(this.mTextView, d.C0141d.cp_cont_b);
            al.i(this.mTextView, d.f.search_history_item_bg);
            al.c(this.dgo, d.f.del_search_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
