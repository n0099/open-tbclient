package com.baidu.tieba.barselect;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class c extends RecyclerView.ViewHolder {
    private HeadImageView hjQ;
    private TextView hjR;
    private TextView hjS;
    private TextView hjT;
    private com.baidu.tieba.barselect.data.a hjU;
    private View hjV;
    private TextView mName;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mSkinType;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.mPageId = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.hjU != null) {
                    if (view2.getId() != c.this.hjV.getId() && view2.getId() != c.this.hjQ.getId()) {
                        if (view2.getId() == c.this.hjT.getId() && (c.this.itemView.getContext() instanceof Activity) && bg.checkUpIsLogin(c.this.itemView.getContext())) {
                            if (c.this.hjU.hkh) {
                                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(c.this.hjU.uid, c.this.hjU.forumId, c.this.hjU.tid, 3);
                            if (c.this.mPageId == null) {
                                if (c.this.itemView.getContext() instanceof BaseActivity) {
                                    c.this.mPageId = ((BaseActivity) c.this.itemView.getContext()).getUniqueId();
                                } else if (c.this.itemView.getContext() instanceof BaseFragmentActivity) {
                                    c.this.mPageId = ((BaseFragmentActivity) c.this.itemView.getContext()).getUniqueId();
                                }
                            }
                            commitVoteReqMsg.setTag(c.this.mPageId);
                            MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.itemView.getContext()).createNormalConfig(c.this.hjU.uid, c.this.hjU.uid == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.hjQ = (HeadImageView) view.findViewById(R.id.img_head);
        this.hjQ.setIsRound(true);
        this.hjQ.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.hjR = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.hjS = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.hjT = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.hjT.setOnClickListener(this.mOnClickListener);
        this.hjV = view.findViewById(R.id.candidate_info);
        this.hjV.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.hjU = aVar;
        if (aVar != null) {
            this.hjQ.startLoad(aVar.hka, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.hkb);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.hkb));
            }
            a(this.hjR, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.hkc)), aVar.hkg);
            this.hjS.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), at.cV(aVar.hkd), at.cV(aVar.hke), at.cV(aVar.hkf)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            ap.setViewTextColor(this.mName, R.color.cp_cont_f);
            ap.setViewTextColor(this.hjR, R.color.cp_cont_c);
            ap.setViewTextColor(this.hjS, R.color.cp_cont_d);
            ap.setViewTextColor(this.hjT, R.color.cp_link_tip_a);
            ap.setBackgroundResource(this.hjT, R.drawable.shape_vote_button);
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
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
