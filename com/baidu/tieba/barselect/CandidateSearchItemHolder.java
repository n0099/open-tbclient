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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import d.b.b.e.m.b;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f15124a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15125b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15126c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15127d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15128e;

    /* renamed from: f  reason: collision with root package name */
    public int f15129f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.v.b.a f15130g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f15131h;
    public View i;
    public View.OnClickListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CandidateSearchItemHolder.this.f15130g == null) {
                return;
            }
            if (view.getId() != CandidateSearchItemHolder.this.i.getId() && view.getId() != CandidateSearchItemHolder.this.f15124a.getId()) {
                if (view.getId() == CandidateSearchItemHolder.this.f15128e.getId() && (CandidateSearchItemHolder.this.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(CandidateSearchItemHolder.this.itemView.getContext())) {
                    if (CandidateSearchItemHolder.this.f15130g.k) {
                        l.K(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(CandidateSearchItemHolder.this.f15130g.f61897b, CandidateSearchItemHolder.this.f15130g.f61896a, CandidateSearchItemHolder.this.f15130g.l, 3);
                    if (CandidateSearchItemHolder.this.f15131h == null) {
                        if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = CandidateSearchItemHolder.this;
                            candidateSearchItemHolder.f15131h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = CandidateSearchItemHolder.this;
                            candidateSearchItemHolder2.f15131h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(CandidateSearchItemHolder.this.f15131h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(CandidateSearchItemHolder.this.itemView.getContext()).createNormalConfig(CandidateSearchItemHolder.this.f15130g.f61897b, CandidateSearchItemHolder.this.f15130g.f61897b == b.f(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
        }
    }

    public CandidateSearchItemHolder(View view) {
        super(view);
        this.f15129f = 3;
        this.f15131h = null;
        this.j = new a();
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.f15124a = headImageView;
        headImageView.setIsRound(true);
        this.f15124a.setOnClickListener(this.j);
        this.f15125b = (TextView) view.findViewById(R.id.name);
        this.f15126c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f15127d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f15128e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.j);
        this.f15128e.setOnClickListener(this.j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void g(d.b.i0.v.b.a aVar) {
        this.f15130g = aVar;
        if (aVar == null) {
            return;
        }
        this.f15124a.W(aVar.f61898c, 12, false);
        this.f15125b.setText(aVar.f61899d);
        String valueOf = String.valueOf(aVar.f61900e);
        if (valueOf != null && valueOf.length() < 4) {
            valueOf = String.format("%04d", Long.valueOf(aVar.f61900e));
        }
        h(this.f15126c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f61901f)), aVar.j);
        this.f15127d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f61902g), StringHelper.numFormatOverWanWithNegative(aVar.f61903h), StringHelper.numFormatOverWanWithNegative(aVar.i)));
        i();
    }

    public void h(TextView textView, String str, String str2) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public final void i() {
        if (TbadkCoreApplication.getInst().getSkinType() != this.f15129f) {
            SkinManager.setViewTextColor(this.f15125b, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f15126c, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f15127d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15128e, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f15128e, R.drawable.shape_vote_button);
        }
    }
}
