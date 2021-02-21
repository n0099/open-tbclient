package com.baidu.tieba.frs.forumRule.adapter;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.forumRule.b.c, ForumRuleDetailItemVH> {
    private TbRichText jvd;
    private Context mContext;
    private List<n> mData;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public ForumRuleDetailItemVH e(ViewGroup viewGroup) {
        ForumRuleDetailItemVH forumRuleDetailItemVH = new ForumRuleDetailItemVH(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.forum_rules_item, viewGroup, false));
        this.Wo = forumRuleDetailItemVH;
        return forumRuleDetailItemVH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(final int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.forumRule.b.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        boolean z;
        if (cVar != null && this.mContext != null) {
            forumRuleDetailItemVH.rh(cVar.cHp());
            if (!StringUtils.isNull(cVar.cHn())) {
                z = true;
                forumRuleDetailItemVH.jvf.setVisibility(0);
                forumRuleDetailItemVH.jvf.setText(cVar.cHn());
            } else {
                forumRuleDetailItemVH.jvf.setVisibility(8);
                z = false;
            }
            if (cVar.cHo() != null && !StringUtils.isNull(cVar.cHo().toString())) {
                forumRuleDetailItemVH.jvg.setVisibility(0);
                if (!z) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) forumRuleDetailItemVH.jvg.getLayoutParams();
                    layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                    forumRuleDetailItemVH.jvg.setLayoutParams(layoutParams);
                }
                this.jvd = TbRichTextView.a(this.mContext, cVar.cHo(), false);
                forumRuleDetailItemVH.jvg.setText(this.jvd);
            } else {
                forumRuleDetailItemVH.jvg.setVisibility(8);
            }
            forumRuleDetailItemVH.jvg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.forumRule.adapter.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (c.this.mData != null) {
                        n nVar = (n) c.this.mData.get(i);
                        if (nVar instanceof com.baidu.tieba.frs.forumRule.b.c) {
                            TbRichText a2 = TbRichTextView.a(c.this.mContext, ((com.baidu.tieba.frs.forumRule.b.c) nVar).cHo(), false);
                            ClipboardManager clipboardManager = (ClipboardManager) c.this.mContext.getSystemService("clipboard");
                            clipboardManager.setText(a2.toString());
                            if (clipboardManager.getText() != null) {
                                l.showToast(c.this.mContext, R.string.forum_rules_copy_clip);
                            }
                        }
                    }
                    return false;
                }
            });
        }
        return view;
    }

    public void setData(List<n> list) {
        this.mData = list;
    }
}
