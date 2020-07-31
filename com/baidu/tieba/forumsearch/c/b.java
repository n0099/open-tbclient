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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.forumsearch.b.a> {
    private WrapLineLayout hDU;
    private List<a> hDV;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hDV = new ArrayList();
        this.mSkinType = 3;
        this.hDU = (WrapLineLayout) getView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            for (a aVar : this.hDV) {
                if (aVar != null) {
                    aVar.onChangeSkinType();
                }
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.forum_search_history_info;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.forumsearch.b.a aVar) {
        if (aVar != null && !x.isEmpty(aVar.cai())) {
            ux(aVar.cai().size());
            int size = this.hDV.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.hDV.get(i);
                if (aVar2 != null) {
                    aVar2.nv(false);
                    aVar2.mTextView.setText(aVar.cai().get(i));
                }
            }
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ux(int i) {
        int size = this.hDV.size();
        if (size != i) {
            if (size < i) {
                int i2 = i - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    a cao = cao();
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds2);
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    this.hDU.addView(cao.getView(), marginLayoutParams);
                    this.hDV.add(cao);
                }
            } else if (i == 0) {
                this.hDU.removeAllViews();
                this.hDV.clear();
            } else if (size > i) {
                int i4 = size - i;
                for (int i5 = 0; i5 < i4; i5++) {
                    this.hDU.removeView(this.hDV.get(i5).getView());
                    this.hDV.remove(i5);
                }
            }
        }
    }

    private a cao() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a {
        private ImageView gPR;
        private View mRootView;
        private TextView mTextView;

        public a() {
            this.mRootView = LayoutInflater.from(b.this.getTbPageContext().getPageActivity()).inflate(R.layout.forum_search_history_info_item, (ViewGroup) null);
            this.mTextView = (TextView) this.mRootView.findViewById(R.id.content);
            this.gPR = (ImageView) this.mRootView.findViewById(R.id.delete);
            onChangeSkinType();
            this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    for (a aVar : b.this.hDV) {
                        if (aVar != null && aVar.getView() != view) {
                            aVar.nv(false);
                        }
                    }
                    a.this.nv(true);
                    return true;
                }
            });
            this.mTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mTextView.getText() != null && !StringUtils.isNull(a.this.mTextView.getText().toString())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEARCH_FORUM, a.this.mTextView.getText().toString()));
                    }
                }
            });
            this.gPR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mTextView.getText() != null) {
                        e.FN(a.this.mTextView.getText().toString());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY));
                    }
                }
            });
        }

        public View getView() {
            return this.mRootView;
        }

        public void nv(boolean z) {
            if (z) {
                this.gPR.setVisibility(0);
                ao.setImageResource(this.gPR, R.drawable.del_search_btn);
                return;
            }
            this.gPR.setVisibility(4);
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.mTextView, R.color.cp_cont_b);
            ao.setBackgroundResource(this.mTextView, R.drawable.search_history_item_bg);
            ao.setImageResource(this.gPR, R.drawable.del_search_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
