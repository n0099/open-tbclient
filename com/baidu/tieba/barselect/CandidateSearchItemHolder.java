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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.b;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f14413a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14414b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14415c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14416d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14417e;

    /* renamed from: f  reason: collision with root package name */
    public int f14418f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.x.b.a f14419g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f14420h;

    /* renamed from: i  reason: collision with root package name */
    public View f14421i;
    public View.OnClickListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateSearchItemHolder f14422e;

        public a(CandidateSearchItemHolder candidateSearchItemHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchItemHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14422e = candidateSearchItemHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14422e.f14419g == null) {
                return;
            }
            if (view.getId() != this.f14422e.f14421i.getId() && view.getId() != this.f14422e.f14413a.getId()) {
                if (view.getId() == this.f14422e.f14417e.getId() && (this.f14422e.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(this.f14422e.itemView.getContext())) {
                    if (this.f14422e.f14419g.k) {
                        l.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.f14422e.f14419g.f66785b, this.f14422e.f14419g.f66784a, this.f14422e.f14419g.l, 3);
                    if (this.f14422e.f14420h == null) {
                        if (this.f14422e.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = this.f14422e;
                            candidateSearchItemHolder.f14420h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (this.f14422e.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = this.f14422e;
                            candidateSearchItemHolder2.f14420h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(this.f14422e.f14420h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14422e.itemView.getContext()).createNormalConfig(this.f14422e.f14419g.f66785b, this.f14422e.f14419g.f66785b == b.f(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CandidateSearchItemHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14418f = 3;
        this.f14420h = null;
        this.j = new a(this);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.f14413a = headImageView;
        headImageView.setIsRound(true);
        this.f14413a.setOnClickListener(this.j);
        this.f14414b = (TextView) view.findViewById(R.id.name);
        this.f14415c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f14416d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f14417e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.j);
        this.f14417e.setOnClickListener(this.j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.f14421i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void g(d.a.q0.x.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f14419g = aVar;
            if (aVar == null) {
                return;
            }
            this.f14413a.M(aVar.f66786c, 12, false);
            this.f14414b.setText(aVar.f66787d);
            String valueOf = String.valueOf(aVar.f66788e);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.f66788e));
            }
            h(this.f14415c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f66789f)), aVar.j);
            this.f14416d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f66790g), StringHelper.numFormatOverWanWithNegative(aVar.f66791h), StringHelper.numFormatOverWanWithNegative(aVar.f66792i)));
            i();
        }
    }

    public void h(TextView textView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, str, str2) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TbadkCoreApplication.getInst().getSkinType() == this.f14418f) {
            return;
        }
        SkinManager.setViewTextColor(this.f14414b, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f14415c, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f14416d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f14417e, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f14417e, R.drawable.shape_vote_button);
    }
}
