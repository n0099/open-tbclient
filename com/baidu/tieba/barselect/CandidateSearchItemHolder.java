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
/* loaded from: classes7.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    private HeadImageView ikq;
    private TextView ikr;
    private TextView iks;
    private TextView ikt;
    private com.baidu.tieba.barselect.data.a iku;
    private View ikv;
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
                if (CandidateSearchItemHolder.this.iku != null) {
                    if (view2.getId() != CandidateSearchItemHolder.this.ikv.getId() && view2.getId() != CandidateSearchItemHolder.this.ikq.getId()) {
                        if (view2.getId() == CandidateSearchItemHolder.this.ikt.getId() && (CandidateSearchItemHolder.this.itemView.getContext() instanceof Activity) && bg.checkUpIsLogin(CandidateSearchItemHolder.this.itemView.getContext())) {
                            if (CandidateSearchItemHolder.this.iku.ikG) {
                                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(CandidateSearchItemHolder.this.iku.uid, CandidateSearchItemHolder.this.iku.forumId, CandidateSearchItemHolder.this.iku.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(CandidateSearchItemHolder.this.itemView.getContext()).createNormalConfig(CandidateSearchItemHolder.this.iku.uid, CandidateSearchItemHolder.this.iku.uid == b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.ikq = (HeadImageView) view.findViewById(R.id.img_head);
        this.ikq.setIsRound(true);
        this.ikq.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.ikr = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.iks = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.ikt = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.ikt.setOnClickListener(this.mOnClickListener);
        this.ikv = view.findViewById(R.id.candidate_info);
        this.ikv.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.iku = aVar;
        if (aVar != null) {
            this.ikq.startLoad(aVar.portraitUrl, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.ikA);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.ikA));
            }
            a(this.ikr, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.ikB)), aVar.ikF);
            this.iks.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), at.ea(aVar.ikC), at.ea(aVar.ikD), at.ea(aVar.ikE)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            ao.setViewTextColor(this.mName, R.color.CAM_X0106);
            ao.setViewTextColor(this.ikr, R.color.CAM_X0108);
            ao.setViewTextColor(this.iks, R.color.CAM_X0109);
            ao.setViewTextColor(this.ikt, R.color.CAM_X0302);
            ao.setBackgroundResource(this.ikt, R.drawable.shape_vote_button);
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
