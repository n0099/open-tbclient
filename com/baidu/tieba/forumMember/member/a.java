package com.baidu.tieba.forumMember.member;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.widget.ListView.a<b, ComplaintBarlordViewHolder> {
    private View.OnClickListener mClickListener;
    private int mSkinType;

    public a(com.baidu.adp.base.f fVar) {
        super(fVar.getPageActivity(), b.iWz, fVar.getUniqueId());
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
    /* renamed from: bm */
    public ComplaintBarlordViewHolder e(ViewGroup viewGroup) {
        return new ComplaintBarlordViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_complaint_bar_lord_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        if (bVar != null && complaintBarlordViewHolder != null) {
            a(complaintBarlordViewHolder);
            a(complaintBarlordViewHolder, bVar);
        }
        return view;
    }

    private void a(ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (complaintBarlordViewHolder.mSkinType != this.mSkinType) {
            complaintBarlordViewHolder.mSkinType = this.mSkinType;
            ao.setBackgroundResource(complaintBarlordViewHolder.bIt, R.drawable.frs_member_manito_bg);
            ao.setBackgroundColor(complaintBarlordViewHolder.mLineView, R.color.CAM_X0204);
            ao.setViewTextColor(complaintBarlordViewHolder.mTitleView, R.color.CAM_X0105, 1);
            ao.setImageResource(complaintBarlordViewHolder.hYP, R.drawable.icon_arrow12_gray66_right);
        }
    }

    private void a(ComplaintBarlordViewHolder complaintBarlordViewHolder, b bVar) {
        complaintBarlordViewHolder.mTitleView.setText(bVar.iWA);
        complaintBarlordViewHolder.bIt.setTag(bVar.mUrl);
        complaintBarlordViewHolder.bIt.setOnClickListener(this.mClickListener);
    }
}
