package com.baidu.tieba.barselect;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.m.b;
import c.a.d.f.p.m;
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
/* loaded from: classes11.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f43564b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f43565c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f43566d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f43567e;

    /* renamed from: f  reason: collision with root package name */
    public int f43568f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.c0.b.a f43569g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f43570h;

    /* renamed from: i  reason: collision with root package name */
    public View f43571i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f43572j;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateSearchItemHolder f43573e;

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
            this.f43573e = candidateSearchItemHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43573e.f43569g == null) {
                return;
            }
            if (view.getId() != this.f43573e.f43571i.getId() && view.getId() != this.f43573e.a.getId()) {
                if (view.getId() == this.f43573e.f43567e.getId() && (this.f43573e.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(this.f43573e.itemView.getContext())) {
                    if (this.f43573e.f43569g.f15330k) {
                        m.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.f43573e.f43569g.f15321b, this.f43573e.f43569g.a, this.f43573e.f43569g.l, 3);
                    if (this.f43573e.f43570h == null) {
                        if (this.f43573e.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = this.f43573e;
                            candidateSearchItemHolder.f43570h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (this.f43573e.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = this.f43573e;
                            candidateSearchItemHolder2.f43570h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(this.f43573e.f43570h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f43573e.itemView.getContext()).createNormalConfig(this.f43573e.f43569g.f15321b, this.f43573e.f43569g.f15321b == b.g(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
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
        this.f43568f = 3;
        this.f43570h = null;
        this.f43572j = new a(this);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.a = headImageView;
        headImageView.setIsRound(true);
        this.a.setOnClickListener(this.f43572j);
        this.f43564b = (TextView) view.findViewById(R.id.name);
        this.f43565c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f43566d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f43567e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.f43572j);
        this.f43567e.setOnClickListener(this.f43572j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.f43571i = findViewById;
        findViewById.setOnClickListener(this.f43572j);
    }

    public void bindData(c.a.s0.c0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f43569g = aVar;
            if (aVar == null) {
                return;
            }
            this.a.startLoad(aVar.f15322c, 12, false);
            this.f43564b.setText(aVar.f15323d);
            String valueOf = String.valueOf(aVar.f15324e);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.f15324e));
            }
            handleKeyWordColor(this.f43565c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f15325f)), aVar.f15329j);
            this.f43566d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f15326g), StringHelper.numFormatOverWanWithNegative(aVar.f15327h), StringHelper.numFormatOverWanWithNegative(aVar.f15328i)));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TbadkCoreApplication.getInst().getSkinType() == this.f43568f) {
            return;
        }
        SkinManager.setViewTextColor(this.f43564b, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f43565c, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f43566d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f43567e, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f43567e, R.drawable.shape_vote_button);
    }
}
