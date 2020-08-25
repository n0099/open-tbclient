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
/* loaded from: classes15.dex */
public class c extends RecyclerView.ViewHolder {
    private HeadImageView hcN;
    private TextView hcO;
    private TextView hcP;
    private TextView hcQ;
    private com.baidu.tieba.barselect.data.a hcR;
    private View hcS;
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
                if (c.this.hcR != null) {
                    if (view2.getId() != c.this.hcS.getId() && view2.getId() != c.this.hcN.getId()) {
                        if (view2.getId() == c.this.hcQ.getId() && (c.this.itemView.getContext() instanceof Activity) && bg.checkUpIsLogin(c.this.itemView.getContext())) {
                            if (c.this.hcR.hdd) {
                                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(c.this.hcR.uid, c.this.hcR.forumId, c.this.hcR.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.itemView.getContext()).createNormalConfig(c.this.hcR.uid, c.this.hcR.uid == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.hcN = (HeadImageView) view.findViewById(R.id.img_head);
        this.hcN.setIsRound(true);
        this.hcN.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.hcO = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.hcP = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.hcQ = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.hcQ.setOnClickListener(this.mOnClickListener);
        this.hcS = view.findViewById(R.id.candidate_info);
        this.hcS.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.hcR = aVar;
        if (aVar != null) {
            this.hcN.startLoad(aVar.hcW, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.hcX);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.hcX));
            }
            a(this.hcO, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.hcY)), aVar.hdc);
            this.hcP.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), at.cU(aVar.hcZ), at.cU(aVar.hda), at.cU(aVar.hdb)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            ap.setViewTextColor(this.mName, R.color.cp_cont_f);
            ap.setViewTextColor(this.hcO, R.color.cp_cont_c);
            ap.setViewTextColor(this.hcP, R.color.cp_cont_d);
            ap.setViewTextColor(this.hcQ, R.color.cp_link_tip_a);
            ap.setBackgroundResource(this.hcQ, R.drawable.shape_vote_button);
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
