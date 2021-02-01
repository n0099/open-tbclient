package com.baidu.tieba.barselect;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    private HeadImageView ipY;
    private TextView ipZ;
    private TextView iqa;
    private TextView iqb;
    private com.baidu.tieba.barselect.data.a iqc;
    private View iqd;
    private TextView mName;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mSkinType;

    public CandidateSearchItemHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.CandidateSearchItemHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (CandidateSearchItemHolder.this.iqc != null) {
                    if (view2.getId() != CandidateSearchItemHolder.this.iqd.getId() && view2.getId() != CandidateSearchItemHolder.this.ipY.getId()) {
                        if (view2.getId() == CandidateSearchItemHolder.this.iqb.getId() && (CandidateSearchItemHolder.this.itemView.getContext() instanceof Activity) && bh.checkUpIsLogin(CandidateSearchItemHolder.this.itemView.getContext())) {
                            if (CandidateSearchItemHolder.this.iqc.iqo) {
                                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(CandidateSearchItemHolder.this.iqc.uid, CandidateSearchItemHolder.this.iqc.forumId, CandidateSearchItemHolder.this.iqc.tid, 3);
                            if (CandidateSearchItemHolder.this.mPageId == null) {
                                if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseActivity) {
                                    CandidateSearchItemHolder.this.mPageId = ((BaseActivity) CandidateSearchItemHolder.this.itemView.getContext()).getUniqueId();
                                } else if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseFragmentActivity) {
                                    CandidateSearchItemHolder.this.mPageId = ((BaseFragmentActivity) CandidateSearchItemHolder.this.itemView.getContext()).getUniqueId();
                                }
                            }
                            commitVoteReqMsg.setTag(CandidateSearchItemHolder.this.mPageId);
                            MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(CandidateSearchItemHolder.this.itemView.getContext()).createNormalConfig(CandidateSearchItemHolder.this.iqc.uid, CandidateSearchItemHolder.this.iqc.uid == b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.ipY = (HeadImageView) view.findViewById(R.id.img_head);
        this.ipY.setIsRound(true);
        this.ipY.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.ipZ = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.iqa = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.iqb = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.iqb.setOnClickListener(this.mOnClickListener);
        this.iqd = view.findViewById(R.id.candidate_info);
        this.iqd.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.iqc = aVar;
        if (aVar != null) {
            this.ipY.startLoad(aVar.portraitUrl, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.iqi);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.iqi));
            }
            a(this.ipZ, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.iqj)), aVar.iqn);
            this.iqa.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), au.eg(aVar.iqk), au.eg(aVar.iql), au.eg(aVar.iqm)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            ap.setViewTextColor(this.mName, R.color.CAM_X0106);
            ap.setViewTextColor(this.ipZ, R.color.CAM_X0108);
            ap.setViewTextColor(this.iqa, R.color.CAM_X0109);
            ap.setViewTextColor(this.iqb, R.color.CAM_X0302);
            ap.setBackgroundResource(this.iqb, R.drawable.shape_vote_button);
        }
    }

    public void a(TextView textView, String str, String str2) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = str2.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
