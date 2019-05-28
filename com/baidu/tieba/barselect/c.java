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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends RecyclerView.ViewHolder {
    private HeadImageView eqG;
    private TextView eqH;
    private TextView eqI;
    private TextView eqJ;
    private com.baidu.tieba.barselect.data.a eqK;
    private View eqL;
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
                if (c.this.eqK != null) {
                    if (view2.getId() != c.this.eqL.getId() && view2.getId() != c.this.eqG.getId()) {
                        if (view2.getId() == c.this.eqJ.getId() && (c.this.itemView.getContext() instanceof Activity) && bc.cE(c.this.itemView.getContext())) {
                            if (c.this.eqK.eqW) {
                                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(c.this.eqK.uid, c.this.eqK.forumId, c.this.eqK.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(c.this.itemView.getContext()).createNormalConfig(c.this.eqK.uid, c.this.eqK.uid == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.eqG = (HeadImageView) view.findViewById(R.id.img_head);
        this.eqG.setIsRound(true);
        this.eqG.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.eqH = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.eqI = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.eqJ = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.eqJ.setOnClickListener(this.mOnClickListener);
        this.eqL = view.findViewById(R.id.candidate_info);
        this.eqL.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.eqK = aVar;
        if (aVar != null) {
            this.eqG.startLoad(aVar.eqP, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.eqQ);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.eqQ));
            }
            a(this.eqH, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.eqR)), aVar.eqV);
            this.eqI.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), ap.aO(aVar.eqS), ap.aO(aVar.eqT), ap.aO(aVar.eqU)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            al.j(this.mName, R.color.cp_cont_f);
            al.j(this.eqH, R.color.cp_cont_c);
            al.j(this.eqI, R.color.cp_cont_d);
            al.j(this.eqJ, R.color.cp_link_tip_a);
            al.k(this.eqJ, R.drawable.shape_vote_button);
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
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_a));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
