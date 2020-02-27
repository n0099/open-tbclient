package com.baidu.tieba.forumMember.member;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, c> {
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public a(com.baidu.adp.base.e eVar) {
        super(eVar.getPageActivity(), b.gkx, eVar.getUniqueId());
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    String str = (String) view.getTag();
                    if (a.this.mSkinType == 1 || a.this.mSkinType == 4) {
                        str = str + "?isNightModel=1";
                    }
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(a.this.mContext, a.this.mContext.getString(R.string.complaint_bar_lord), str, true));
                    customMessage.setTag(a.this.mPageId);
                    MessageManager.getInstance().sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public c b(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(R.layout.item_complaint_bar_lord_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
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
            am.setBackgroundResource(cVar.aCP, R.drawable.frs_member_manito_bg);
            am.setBackgroundColor(cVar.mLineView, R.color.cp_bg_line_c);
            am.setViewTextColor(cVar.mTitleView, R.color.cp_cont_b, 1);
            am.setImageResource(cVar.fxP, R.drawable.icon_arrow12_gray66_right);
        }
    }

    private void a(c cVar, b bVar) {
        cVar.mTitleView.setText(bVar.gky);
        cVar.aCP.setTag(bVar.mUrl);
        cVar.aCP.setOnClickListener(this.mClickListener);
    }
}
