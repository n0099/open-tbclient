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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class c extends RecyclerView.ViewHolder {
    private HeadImageView gPX;
    private TextView gPY;
    private TextView gPZ;
    private TextView gQa;
    private com.baidu.tieba.barselect.data.a gQb;
    private View gQc;
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
                if (c.this.gQb != null) {
                    if (view2.getId() != c.this.gQc.getId() && view2.getId() != c.this.gPX.getId()) {
                        if (view2.getId() == c.this.gQa.getId() && (c.this.itemView.getContext() instanceof Activity) && bf.checkUpIsLogin(c.this.itemView.getContext())) {
                            if (c.this.gQb.gQn) {
                                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(c.this.gQb.uid, c.this.gQb.forumId, c.this.gQb.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.itemView.getContext()).createNormalConfig(c.this.gQb.uid, c.this.gQb.uid == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.gPX = (HeadImageView) view.findViewById(R.id.img_head);
        this.gPX.setIsRound(true);
        this.gPX.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.gPY = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.gPZ = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.gQa = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.gQa.setOnClickListener(this.mOnClickListener);
        this.gQc = view.findViewById(R.id.candidate_info);
        this.gQc.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.gQb = aVar;
        if (aVar != null) {
            this.gPX.startLoad(aVar.gQg, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.gQh);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.gQh));
            }
            a(this.gPY, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.gQi)), aVar.gQm);
            this.gPZ.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), as.cJ(aVar.gQj), as.cJ(aVar.gQk), as.cJ(aVar.gQl)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            ao.setViewTextColor(this.mName, R.color.cp_cont_f);
            ao.setViewTextColor(this.gPY, R.color.cp_cont_c);
            ao.setViewTextColor(this.gPZ, R.color.cp_cont_d);
            ao.setViewTextColor(this.gQa, R.color.cp_link_tip_a);
            ao.setBackgroundResource(this.gQa, R.drawable.shape_vote_button);
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
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_a));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }
}
