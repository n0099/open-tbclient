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
import d.a.c.e.m.b;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f14239a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14240b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14241c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14242d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14243e;

    /* renamed from: f  reason: collision with root package name */
    public int f14244f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.x.b.a f14245g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f14246h;

    /* renamed from: i  reason: collision with root package name */
    public View f14247i;
    public View.OnClickListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CandidateSearchItemHolder.this.f14245g == null) {
                return;
            }
            if (view.getId() != CandidateSearchItemHolder.this.f14247i.getId() && view.getId() != CandidateSearchItemHolder.this.f14239a.getId()) {
                if (view.getId() == CandidateSearchItemHolder.this.f14243e.getId() && (CandidateSearchItemHolder.this.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(CandidateSearchItemHolder.this.itemView.getContext())) {
                    if (CandidateSearchItemHolder.this.f14245g.k) {
                        l.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(CandidateSearchItemHolder.this.f14245g.f66980b, CandidateSearchItemHolder.this.f14245g.f66979a, CandidateSearchItemHolder.this.f14245g.l, 3);
                    if (CandidateSearchItemHolder.this.f14246h == null) {
                        if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = CandidateSearchItemHolder.this;
                            candidateSearchItemHolder.f14246h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = CandidateSearchItemHolder.this;
                            candidateSearchItemHolder2.f14246h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(CandidateSearchItemHolder.this.f14246h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(CandidateSearchItemHolder.this.itemView.getContext()).createNormalConfig(CandidateSearchItemHolder.this.f14245g.f66980b, CandidateSearchItemHolder.this.f14245g.f66980b == b.f(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
        }
    }

    public CandidateSearchItemHolder(View view) {
        super(view);
        this.f14244f = 3;
        this.f14246h = null;
        this.j = new a();
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.f14239a = headImageView;
        headImageView.setIsRound(true);
        this.f14239a.setOnClickListener(this.j);
        this.f14240b = (TextView) view.findViewById(R.id.name);
        this.f14241c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f14242d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f14243e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.j);
        this.f14243e.setOnClickListener(this.j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.f14247i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void g(d.a.o0.x.b.a aVar) {
        this.f14245g = aVar;
        if (aVar == null) {
            return;
        }
        this.f14239a.U(aVar.f66981c, 12, false);
        this.f14240b.setText(aVar.f66982d);
        String valueOf = String.valueOf(aVar.f66983e);
        if (valueOf != null && valueOf.length() < 4) {
            valueOf = String.format("%04d", Long.valueOf(aVar.f66983e));
        }
        h(this.f14241c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f66984f)), aVar.j);
        this.f14242d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f66985g), StringHelper.numFormatOverWanWithNegative(aVar.f66986h), StringHelper.numFormatOverWanWithNegative(aVar.f66987i)));
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
        if (TbadkCoreApplication.getInst().getSkinType() != this.f14244f) {
            SkinManager.setViewTextColor(this.f14240b, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f14241c, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f14242d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f14243e, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f14243e, R.drawable.shape_vote_button);
        }
    }
}
