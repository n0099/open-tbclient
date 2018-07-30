package com.baidu.tieba.forumMember.member;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, c> {
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public a(com.baidu.adp.base.e eVar) {
        super(eVar.getPageActivity(), b.diQ, eVar.getUniqueId());
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    String str = (String) view.getTag();
                    if (a.this.mSkinType == 1) {
                        str = str + "?isNightModel=1";
                    }
                    CustomMessage customMessage = new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.mContext, a.this.mContext.getString(d.j.complaint_bar_lord), str, true));
                    customMessage.setTag(a.this.mPageId);
                    MessageManager.getInstance().sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.h.item_complaint_bar_lord_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        if (bVar != null && cVar != null) {
            a(cVar);
            a(cVar, bVar);
        }
        return view;
    }

    private void a(c cVar) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (cVar.mSkinType != this.mSkinType) {
            cVar.mSkinType = this.mSkinType;
            am.i(cVar.cSA, d.f.frs_member_manito_bg);
            am.j(cVar.akS, d.C0140d.cp_bg_line_b);
            am.c(cVar.mTitleView, d.C0140d.cp_cont_b, 1);
            am.c(cVar.cpb, d.f.icon_arrow_tab);
        }
    }

    private void a(c cVar, b bVar) {
        cVar.mTitleView.setText(bVar.diR);
        cVar.cSA.setTag(bVar.mUrl);
        cVar.cSA.setOnClickListener(this.mClickListener);
    }
}
