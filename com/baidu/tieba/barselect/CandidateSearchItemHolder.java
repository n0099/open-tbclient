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
import d.b.c.e.m.b;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f14795a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14796b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14797c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14798d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14799e;

    /* renamed from: f  reason: collision with root package name */
    public int f14800f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.v.b.a f14801g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f14802h;
    public View i;
    public View.OnClickListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CandidateSearchItemHolder.this.f14801g == null) {
                return;
            }
            if (view.getId() != CandidateSearchItemHolder.this.i.getId() && view.getId() != CandidateSearchItemHolder.this.f14795a.getId()) {
                if (view.getId() == CandidateSearchItemHolder.this.f14799e.getId() && (CandidateSearchItemHolder.this.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(CandidateSearchItemHolder.this.itemView.getContext())) {
                    if (CandidateSearchItemHolder.this.f14801g.k) {
                        l.K(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(CandidateSearchItemHolder.this.f14801g.f63327b, CandidateSearchItemHolder.this.f14801g.f63326a, CandidateSearchItemHolder.this.f14801g.l, 3);
                    if (CandidateSearchItemHolder.this.f14802h == null) {
                        if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = CandidateSearchItemHolder.this;
                            candidateSearchItemHolder.f14802h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = CandidateSearchItemHolder.this;
                            candidateSearchItemHolder2.f14802h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(CandidateSearchItemHolder.this.f14802h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(CandidateSearchItemHolder.this.itemView.getContext()).createNormalConfig(CandidateSearchItemHolder.this.f14801g.f63327b, CandidateSearchItemHolder.this.f14801g.f63327b == b.f(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
        }
    }

    public CandidateSearchItemHolder(View view) {
        super(view);
        this.f14800f = 3;
        this.f14802h = null;
        this.j = new a();
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.f14795a = headImageView;
        headImageView.setIsRound(true);
        this.f14795a.setOnClickListener(this.j);
        this.f14796b = (TextView) view.findViewById(R.id.name);
        this.f14797c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f14798d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f14799e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.j);
        this.f14799e.setOnClickListener(this.j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void g(d.b.j0.v.b.a aVar) {
        this.f14801g = aVar;
        if (aVar == null) {
            return;
        }
        this.f14795a.W(aVar.f63328c, 12, false);
        this.f14796b.setText(aVar.f63329d);
        String valueOf = String.valueOf(aVar.f63330e);
        if (valueOf != null && valueOf.length() < 4) {
            valueOf = String.format("%04d", Long.valueOf(aVar.f63330e));
        }
        h(this.f14797c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f63331f)), aVar.j);
        this.f14798d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f63332g), StringHelper.numFormatOverWanWithNegative(aVar.f63333h), StringHelper.numFormatOverWanWithNegative(aVar.i)));
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
        if (TbadkCoreApplication.getInst().getSkinType() != this.f14800f) {
            SkinManager.setViewTextColor(this.f14796b, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f14797c, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f14798d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f14799e, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f14799e, R.drawable.shape_vote_button);
        }
    }
}
