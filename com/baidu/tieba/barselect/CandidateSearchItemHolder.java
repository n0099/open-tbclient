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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    private HeadImageView ioZ;
    private TextView ipa;
    private TextView ipb;
    private TextView ipc;
    private com.baidu.tieba.barselect.data.a ipd;
    private View ipe;
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
                if (CandidateSearchItemHolder.this.ipd != null) {
                    if (view2.getId() != CandidateSearchItemHolder.this.ipe.getId() && view2.getId() != CandidateSearchItemHolder.this.ioZ.getId()) {
                        if (view2.getId() == CandidateSearchItemHolder.this.ipc.getId() && (CandidateSearchItemHolder.this.itemView.getContext() instanceof Activity) && bg.checkUpIsLogin(CandidateSearchItemHolder.this.itemView.getContext())) {
                            if (CandidateSearchItemHolder.this.ipd.ipp) {
                                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(CandidateSearchItemHolder.this.ipd.uid, CandidateSearchItemHolder.this.ipd.forumId, CandidateSearchItemHolder.this.ipd.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(CandidateSearchItemHolder.this.itemView.getContext()).createNormalConfig(CandidateSearchItemHolder.this.ipd.uid, CandidateSearchItemHolder.this.ipd.uid == b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.ioZ = (HeadImageView) view.findViewById(R.id.img_head);
        this.ioZ.setIsRound(true);
        this.ioZ.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.ipa = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.ipb = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.ipc = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.ipc.setOnClickListener(this.mOnClickListener);
        this.ipe = view.findViewById(R.id.candidate_info);
        this.ipe.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.ipd = aVar;
        if (aVar != null) {
            this.ioZ.startLoad(aVar.portraitUrl, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.ipj);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.ipj));
            }
            a(this.ipa, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.ipk)), aVar.ipo);
            this.ipb.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), at.ea(aVar.ipl), at.ea(aVar.ipm), at.ea(aVar.ipn)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            ao.setViewTextColor(this.mName, R.color.CAM_X0106);
            ao.setViewTextColor(this.ipa, R.color.CAM_X0108);
            ao.setViewTextColor(this.ipb, R.color.CAM_X0109);
            ao.setViewTextColor(this.ipc, R.color.CAM_X0302);
            ao.setBackgroundResource(this.ipc, R.drawable.shape_vote_button);
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
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
