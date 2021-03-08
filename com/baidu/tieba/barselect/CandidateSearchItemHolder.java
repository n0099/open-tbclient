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
/* loaded from: classes7.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    private HeadImageView irV;
    private TextView irW;
    private TextView irX;
    private TextView irY;
    private com.baidu.tieba.barselect.data.a irZ;
    private View isa;
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
                if (CandidateSearchItemHolder.this.irZ != null) {
                    if (view2.getId() != CandidateSearchItemHolder.this.isa.getId() && view2.getId() != CandidateSearchItemHolder.this.irV.getId()) {
                        if (view2.getId() == CandidateSearchItemHolder.this.irY.getId() && (CandidateSearchItemHolder.this.itemView.getContext() instanceof Activity) && bh.checkUpIsLogin(CandidateSearchItemHolder.this.itemView.getContext())) {
                            if (CandidateSearchItemHolder.this.irZ.isl) {
                                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(CandidateSearchItemHolder.this.irZ.uid, CandidateSearchItemHolder.this.irZ.forumId, CandidateSearchItemHolder.this.irZ.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(CandidateSearchItemHolder.this.itemView.getContext()).createNormalConfig(CandidateSearchItemHolder.this.irZ.uid, CandidateSearchItemHolder.this.irZ.uid == b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.irV = (HeadImageView) view.findViewById(R.id.img_head);
        this.irV.setIsRound(true);
        this.irV.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.irW = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.irX = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.irY = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.irY.setOnClickListener(this.mOnClickListener);
        this.isa = view.findViewById(R.id.candidate_info);
        this.isa.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.irZ = aVar;
        if (aVar != null) {
            this.irV.startLoad(aVar.portraitUrl, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.isf);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.isf));
            }
            a(this.irW, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.isg)), aVar.isk);
            this.irX.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), au.eg(aVar.ish), au.eg(aVar.isi), au.eg(aVar.isj)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            ap.setViewTextColor(this.mName, R.color.CAM_X0106);
            ap.setViewTextColor(this.irW, R.color.CAM_X0108);
            ap.setViewTextColor(this.irX, R.color.CAM_X0109);
            ap.setViewTextColor(this.irY, R.color.CAM_X0302);
            ap.setBackgroundResource(this.irY, R.drawable.shape_vote_button);
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
