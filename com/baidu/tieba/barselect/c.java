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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends RecyclerView.ViewHolder {
    private TextView icA;
    private TextView icB;
    private TextView icC;
    private com.baidu.tieba.barselect.data.a icD;
    private View icE;
    private HeadImageView icz;
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
                if (c.this.icD != null) {
                    if (view2.getId() != c.this.icE.getId() && view2.getId() != c.this.icz.getId()) {
                        if (view2.getId() == c.this.icC.getId() && (c.this.itemView.getContext() instanceof Activity) && bh.checkUpIsLogin(c.this.itemView.getContext())) {
                            if (c.this.icD.icQ) {
                                l.showToast(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                                return;
                            }
                            CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(c.this.icD.uid, c.this.icD.forumId, c.this.icD.tid, 3);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.itemView.getContext()).createNormalConfig(c.this.icD.uid, c.this.icD.uid == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
                }
            }
        };
        this.icz = (HeadImageView) view.findViewById(R.id.img_head);
        this.icz.setIsRound(true);
        this.icz.setOnClickListener(this.mOnClickListener);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.icA = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.icB = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.icC = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.mOnClickListener);
        this.icC.setOnClickListener(this.mOnClickListener);
        this.icE = view.findViewById(R.id.candidate_info);
        this.icE.setOnClickListener(this.mOnClickListener);
    }

    public void a(com.baidu.tieba.barselect.data.a aVar) {
        this.icD = aVar;
        if (aVar != null) {
            this.icz.startLoad(aVar.icJ, 12, false);
            this.mName.setText(aVar.name);
            String valueOf = String.valueOf(aVar.icK);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.icK));
            }
            a(this.icA, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.icL)), aVar.icP);
            this.icB.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), au.ea(aVar.icM), au.ea(aVar.icN), au.ea(aVar.icO)));
            onChangeSkinType();
        }
    }

    private void onChangeSkinType() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.mSkinType) {
            ap.setViewTextColor(this.mName, R.color.CAM_X0106);
            ap.setViewTextColor(this.icA, R.color.CAM_X0108);
            ap.setViewTextColor(this.icB, R.color.CAM_X0109);
            ap.setViewTextColor(this.icC, R.color.CAM_X0302);
            ap.setBackgroundResource(this.icC, R.drawable.shape_vote_button);
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
