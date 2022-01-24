package com.baidu.tieba.barselect;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.m.b;
import c.a.d.f.p.n;
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
/* loaded from: classes12.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f42186b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42187c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42188d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42189e;

    /* renamed from: f  reason: collision with root package name */
    public int f42190f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.c0.b.a f42191g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f42192h;

    /* renamed from: i  reason: collision with root package name */
    public View f42193i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f42194j;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateSearchItemHolder f42195e;

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
            this.f42195e = candidateSearchItemHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f42195e.f42191g == null) {
                return;
            }
            if (view.getId() != this.f42195e.f42193i.getId() && view.getId() != this.f42195e.a.getId()) {
                if (view.getId() == this.f42195e.f42189e.getId() && (this.f42195e.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(this.f42195e.itemView.getContext())) {
                    if (this.f42195e.f42191g.k) {
                        n.M(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.f42195e.f42191g.f15418b, this.f42195e.f42191g.a, this.f42195e.f42191g.l, 3);
                    if (this.f42195e.f42192h == null) {
                        if (this.f42195e.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = this.f42195e;
                            candidateSearchItemHolder.f42192h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (this.f42195e.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = this.f42195e;
                            candidateSearchItemHolder2.f42192h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(this.f42195e.f42192h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f42195e.itemView.getContext()).createNormalConfig(this.f42195e.f42191g.f15418b, this.f42195e.f42191g.f15418b == b.g(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
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
        this.f42190f = 3;
        this.f42192h = null;
        this.f42194j = new a(this);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.a = headImageView;
        headImageView.setIsRound(true);
        this.a.setOnClickListener(this.f42194j);
        this.f42186b = (TextView) view.findViewById(R.id.name);
        this.f42187c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f42188d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f42189e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.f42194j);
        this.f42189e.setOnClickListener(this.f42194j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.f42193i = findViewById;
        findViewById.setOnClickListener(this.f42194j);
    }

    public void bindData(c.a.t0.c0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f42191g = aVar;
            if (aVar == null) {
                return;
            }
            this.a.startLoad(aVar.f15419c, 12, false);
            this.f42186b.setText(aVar.f15420d);
            String valueOf = String.valueOf(aVar.f15421e);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.f15421e));
            }
            handleKeyWordColor(this.f42187c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f15422f)), aVar.f15426j);
            this.f42188d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f15423g), StringHelper.numFormatOverWanWithNegative(aVar.f15424h), StringHelper.numFormatOverWanWithNegative(aVar.f15425i)));
            onChangeSkinType();
        }
    }

    public void handleKeyWordColor(TextView textView, String str, String str2) {
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

    public final void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TbadkCoreApplication.getInst().getSkinType() == this.f42190f) {
            return;
        }
        SkinManager.setViewTextColor(this.f42186b, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f42187c, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f42188d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f42189e, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f42189e, R.drawable.shape_vote_button);
    }
}
