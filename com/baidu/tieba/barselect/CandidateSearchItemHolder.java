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
    public HeadImageView f14197a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14198b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14199c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14200d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14201e;

    /* renamed from: f  reason: collision with root package name */
    public int f14202f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.v.b.a f14203g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f14204h;

    /* renamed from: i  reason: collision with root package name */
    public View f14205i;
    public View.OnClickListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CandidateSearchItemHolder.this.f14203g == null) {
                return;
            }
            if (view.getId() != CandidateSearchItemHolder.this.f14205i.getId() && view.getId() != CandidateSearchItemHolder.this.f14197a.getId()) {
                if (view.getId() == CandidateSearchItemHolder.this.f14201e.getId() && (CandidateSearchItemHolder.this.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(CandidateSearchItemHolder.this.itemView.getContext())) {
                    if (CandidateSearchItemHolder.this.f14203g.k) {
                        l.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(CandidateSearchItemHolder.this.f14203g.f62278b, CandidateSearchItemHolder.this.f14203g.f62277a, CandidateSearchItemHolder.this.f14203g.l, 3);
                    if (CandidateSearchItemHolder.this.f14204h == null) {
                        if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = CandidateSearchItemHolder.this;
                            candidateSearchItemHolder.f14204h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (CandidateSearchItemHolder.this.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = CandidateSearchItemHolder.this;
                            candidateSearchItemHolder2.f14204h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(CandidateSearchItemHolder.this.f14204h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(CandidateSearchItemHolder.this.itemView.getContext()).createNormalConfig(CandidateSearchItemHolder.this.f14203g.f62278b, CandidateSearchItemHolder.this.f14203g.f62278b == b.f(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
        }
    }

    public CandidateSearchItemHolder(View view) {
        super(view);
        this.f14202f = 3;
        this.f14204h = null;
        this.j = new a();
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.f14197a = headImageView;
        headImageView.setIsRound(true);
        this.f14197a.setOnClickListener(this.j);
        this.f14198b = (TextView) view.findViewById(R.id.name);
        this.f14199c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f14200d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f14201e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.j);
        this.f14201e.setOnClickListener(this.j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.f14205i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void g(d.a.k0.v.b.a aVar) {
        this.f14203g = aVar;
        if (aVar == null) {
            return;
        }
        this.f14197a.V(aVar.f62279c, 12, false);
        this.f14198b.setText(aVar.f62280d);
        String valueOf = String.valueOf(aVar.f62281e);
        if (valueOf != null && valueOf.length() < 4) {
            valueOf = String.format("%04d", Long.valueOf(aVar.f62281e));
        }
        h(this.f14199c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f62282f)), aVar.j);
        this.f14200d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f62283g), StringHelper.numFormatOverWanWithNegative(aVar.f62284h), StringHelper.numFormatOverWanWithNegative(aVar.f62285i)));
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
        if (TbadkCoreApplication.getInst().getSkinType() != this.f14202f) {
            SkinManager.setViewTextColor(this.f14198b, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f14199c, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f14200d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f14201e, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.f14201e, R.drawable.shape_vote_button);
        }
    }
}
