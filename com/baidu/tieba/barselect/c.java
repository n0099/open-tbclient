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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends RecyclerView.ViewHolder {
    private HeadImageView evE;
    private TextView evF;
    private TextView evG;
    private TextView evH;
    private com.baidu.tieba.barselect.data.a evI;
    private View evJ;
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
                if (c.this.evI != null) {
                    if (view2.getId() != c.this.evJ.getId() && view2.getId() != c.this.evE.getId()) {
                        if (view2.getId() == c.this.evH.getId() && (c.this.itemView.getContext() instanceof Activity) && bd.cF(c.this.itemView.getContext())) {
                            if (c.this.evI.evU) {
                                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(c.this.evI.uid, c.this.evI.forumId, c.this.evI.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(c.this.itemView.getContext()).createNormalConfig(c.this.evI.uid, c.this.evI.uid == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.evE = (HeadImageView) view.findViewById(R.id.img_head);
        this.evE.setIsRound(true);
        this.evE.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.evF = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.evG = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.evH = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.evH.setOnClickListener(this.mOnClickListener);
        this.evJ = view.findViewById(R.id.candidate_info);
        this.evJ.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.evI = aVar;
        if (aVar != null) {
            this.evE.startLoad(aVar.evN, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.evO);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.evO));
            }
            a(this.evF, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.evP)), aVar.evT);
            this.evG.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), aq.aP(aVar.evQ), aq.aP(aVar.evR), aq.aP(aVar.evS)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            am.j(this.mName, R.color.cp_cont_f);
            am.j(this.evF, R.color.cp_cont_c);
            am.j(this.evG, R.color.cp_cont_d);
            am.j(this.evH, R.color.cp_link_tip_a);
            am.k(this.evH, R.drawable.shape_vote_button);
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
