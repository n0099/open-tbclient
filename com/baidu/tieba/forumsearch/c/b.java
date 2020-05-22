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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.WrapLineLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.controller.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.forumsearch.b.a> {
    private WrapLineLayout hlO;
    private List<a> hlP;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hlP = new ArrayList();
        this.mSkinType = 3;
        this.hlO = (WrapLineLayout) getView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            for (a aVar : this.hlP) {
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
        if (aVar != null && !v.isEmpty(aVar.bTQ())) {
            tC(aVar.bTQ().size());
            int size = this.hlP.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.hlP.get(i);
                if (aVar2 != null) {
                    aVar2.mF(false);
                    aVar2.mTextView.setText(aVar.bTQ().get(i));
                }
            }
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void tC(int i) {
        int size = this.hlP.size();
        if (size != i) {
            if (size < i) {
                int i2 = i - size;
                for (int i3 = 0; i3 < i2; i3++) {
                    a bTW = bTW();
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds2);
                    marginLayoutParams.leftMargin = marginLayoutParams.topMargin;
                    this.hlO.addView(bTW.getView(), marginLayoutParams);
                    this.hlP.add(bTW);
                }
            } else if (i == 0) {
                this.hlO.removeAllViews();
                this.hlP.clear();
            } else if (size > i) {
                int i4 = size - i;
                for (int i5 = 0; i5 < i4; i5++) {
                    this.hlO.removeView(this.hlP.get(i5).getView());
                    this.hlP.remove(i5);
                }
            }
        }
    }

    private a bTW() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        private ImageView gxm;
        private View mRootView;
        private TextView mTextView;

        public a() {
            this.mRootView = LayoutInflater.from(b.this.getTbPageContext().getPageActivity()).inflate(R.layout.forum_search_history_info_item, (ViewGroup) null);
            this.mTextView = (TextView) this.mRootView.findViewById(R.id.content);
            this.gxm = (ImageView) this.mRootView.findViewById(R.id.delete);
            onChangeSkinType();
            this.mTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    for (a aVar : b.this.hlP) {
                        if (aVar != null && aVar.getView() != view) {
                            aVar.mF(false);
                        }
                    }
                    a.this.mF(true);
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
            this.gxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumsearch.c.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mTextView.getText() != null) {
                        e.EB(a.this.mTextView.getText().toString());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_SEARCH_FORUM_HISTORY));
                    }
                }
            });
        }

        public View getView() {
            return this.mRootView;
        }

        public void mF(boolean z) {
            if (z) {
                this.gxm.setVisibility(0);
                am.setImageResource(this.gxm, R.drawable.del_search_btn);
                return;
            }
            this.gxm.setVisibility(4);
        }

        public void onChangeSkinType() {
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundResource(this.mTextView, R.drawable.search_history_item_bg);
            am.setImageResource(this.gxm, R.drawable.del_search_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
