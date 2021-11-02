package com.baidu.tieba.barselect;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.m.b;
import b.a.e.e.p.l;
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
/* loaded from: classes9.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f47263a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f47264b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f47265c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f47266d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f47267e;

    /* renamed from: f  reason: collision with root package name */
    public int f47268f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.y.b.a f47269g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f47270h;

    /* renamed from: i  reason: collision with root package name */
    public View f47271i;
    public View.OnClickListener j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateSearchItemHolder f47272e;

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
            this.f47272e = candidateSearchItemHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47272e.f47269g == null) {
                return;
            }
            if (view.getId() != this.f47272e.f47271i.getId() && view.getId() != this.f47272e.f47263a.getId()) {
                if (view.getId() == this.f47272e.f47267e.getId() && (this.f47272e.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(this.f47272e.itemView.getContext())) {
                    if (this.f47272e.f47269g.k) {
                        l.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.f47272e.f47269g.f27159b, this.f47272e.f47269g.f27158a, this.f47272e.f47269g.l, 3);
                    if (this.f47272e.f47270h == null) {
                        if (this.f47272e.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = this.f47272e;
                            candidateSearchItemHolder.f47270h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (this.f47272e.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = this.f47272e;
                            candidateSearchItemHolder2.f47270h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(this.f47272e.f47270h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f47272e.itemView.getContext()).createNormalConfig(this.f47272e.f47269g.f27159b, this.f47272e.f47269g.f27159b == b.g(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
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
        this.f47268f = 3;
        this.f47270h = null;
        this.j = new a(this);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.f47263a = headImageView;
        headImageView.setIsRound(true);
        this.f47263a.setOnClickListener(this.j);
        this.f47264b = (TextView) view.findViewById(R.id.name);
        this.f47265c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f47266d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f47267e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.j);
        this.f47267e.setOnClickListener(this.j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.f47271i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void bindData(b.a.r0.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f47269g = aVar;
            if (aVar == null) {
                return;
            }
            this.f47263a.startLoad(aVar.f27160c, 12, false);
            this.f47264b.setText(aVar.f27161d);
            String valueOf = String.valueOf(aVar.f27162e);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.f27162e));
            }
            handleKeyWordColor(this.f47265c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f27163f)), aVar.j);
            this.f47266d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f27164g), StringHelper.numFormatOverWanWithNegative(aVar.f27165h), StringHelper.numFormatOverWanWithNegative(aVar.f27166i)));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TbadkCoreApplication.getInst().getSkinType() == this.f47268f) {
            return;
        }
        SkinManager.setViewTextColor(this.f47264b, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f47265c, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f47266d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f47267e, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f47267e, R.drawable.shape_vote_button);
    }
}
