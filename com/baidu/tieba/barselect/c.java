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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c extends RecyclerView.ViewHolder {
    private HeadImageView fDk;
    private TextView fDl;
    private TextView fDm;
    private TextView fDn;
    private com.baidu.tieba.barselect.data.a fDo;
    private View fDp;
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
                if (c.this.fDo != null) {
                    if (view2.getId() != c.this.fDp.getId() && view2.getId() != c.this.fDk.getId()) {
                        if (view2.getId() == c.this.fDn.getId() && (c.this.itemView.getContext() instanceof Activity) && bc.checkUpIsLogin(c.this.itemView.getContext())) {
                            if (c.this.fDo.fDA) {
                                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(c.this.fDo.uid, c.this.fDo.forumId, c.this.fDo.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.itemView.getContext()).createNormalConfig(c.this.fDo.uid, c.this.fDo.uid == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.fDk = (HeadImageView) view.findViewById(R.id.img_head);
        this.fDk.setIsRound(true);
        this.fDk.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.fDl = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.fDm = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.fDn = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.fDn.setOnClickListener(this.mOnClickListener);
        this.fDp = view.findViewById(R.id.candidate_info);
        this.fDp.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.fDo = aVar;
        if (aVar != null) {
            this.fDk.startLoad(aVar.fDt, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.fDu);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.fDu));
            }
            a(this.fDl, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.fDv)), aVar.fDz);
            this.fDm.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), aq.bF(aVar.fDw), aq.bF(aVar.fDx), aq.bF(aVar.fDy)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.fDl, (int) R.color.cp_cont_c);
            am.setViewTextColor(this.fDm, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fDn, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this.fDn, R.drawable.shape_vote_button);
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
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
