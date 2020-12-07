package com.baidu.tieba.frs.forumRule.a;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.forumRule.c.c, e> {
    private TbRichText jhn;
    private Context mContext;
    private List<q> mData;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
    public e c(ViewGroup viewGroup) {
        e eVar = new e(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.forum_rules_item, viewGroup, false));
        this.Wx = eVar;
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(final int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.forumRule.c.c cVar, e eVar) {
        boolean z;
        if (cVar != null && this.mContext != null) {
            eVar.qD(cVar.cGM());
            if (!StringUtils.isNull(cVar.cGK())) {
                z = true;
                eVar.jhp.setVisibility(0);
                eVar.jhp.setText(cVar.cGK());
            } else {
                eVar.jhp.setVisibility(8);
                z = false;
            }
            if (cVar.cGL() != null && !StringUtils.isNull(cVar.cGL().toString())) {
                eVar.jhq.setVisibility(0);
                if (!z) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) eVar.jhq.getLayoutParams();
                    layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                    eVar.jhq.setLayoutParams(layoutParams);
                }
                this.jhn = TbRichTextView.a(this.mContext, cVar.cGL(), false);
                eVar.jhq.setText(this.jhn);
            } else {
                eVar.jhq.setVisibility(8);
            }
            eVar.jhq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.forumRule.a.d.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (d.this.mData != null) {
                        q qVar = (q) d.this.mData.get(i);
                        if (qVar instanceof com.baidu.tieba.frs.forumRule.c.c) {
                            TbRichText a2 = TbRichTextView.a(d.this.mContext, ((com.baidu.tieba.frs.forumRule.c.c) qVar).cGL(), false);
                            ClipboardManager clipboardManager = (ClipboardManager) d.this.mContext.getSystemService("clipboard");
                            clipboardManager.setText(a2.toString());
                            if (clipboardManager.getText() != null) {
                                l.showToast(d.this.mContext, R.string.forum_rules_copy_clip);
                            }
                        }
                    }
                    return false;
                }
            });
        }
        return view;
    }

    public void setData(List<q> list) {
        this.mData = list;
    }
}
