package com.baidu.tieba.barselect;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.m.b;
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f49909a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f49910b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49911c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f49912d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f49913e;

    /* renamed from: f  reason: collision with root package name */
    public int f49914f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.x.b.a f49915g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f49916h;

    /* renamed from: i  reason: collision with root package name */
    public View f49917i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f49918j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateSearchItemHolder f49919e;

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
            this.f49919e = candidateSearchItemHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49919e.f49915g == null) {
                return;
            }
            if (view.getId() != this.f49919e.f49917i.getId() && view.getId() != this.f49919e.f49909a.getId()) {
                if (view.getId() == this.f49919e.f49913e.getId() && (this.f49919e.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(this.f49919e.itemView.getContext())) {
                    if (this.f49919e.f49915g.k) {
                        l.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.f49919e.f49915g.f28250b, this.f49919e.f49915g.f28249a, this.f49919e.f49915g.l, 3);
                    if (this.f49919e.f49916h == null) {
                        if (this.f49919e.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = this.f49919e;
                            candidateSearchItemHolder.f49916h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (this.f49919e.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = this.f49919e;
                            candidateSearchItemHolder2.f49916h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(this.f49919e.f49916h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f49919e.itemView.getContext()).createNormalConfig(this.f49919e.f49915g.f28250b, this.f49919e.f49915g.f28250b == b.g(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
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
        this.f49914f = 3;
        this.f49916h = null;
        this.f49918j = new a(this);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.img_head);
        this.f49909a = headImageView;
        headImageView.setIsRound(true);
        this.f49909a.setOnClickListener(this.f49918j);
        this.f49910b = (TextView) view.findViewById(R.id.name);
        this.f49911c = (TextView) view.findViewById(R.id.num_and_vote_count);
        this.f49912d = (TextView) view.findViewById(R.id.agree_publish_reply);
        this.f49913e = (TextView) view.findViewById(R.id.btn_vote);
        this.itemView.setOnClickListener(this.f49918j);
        this.f49913e.setOnClickListener(this.f49918j);
        View findViewById = view.findViewById(R.id.candidate_info);
        this.f49917i = findViewById;
        findViewById.setOnClickListener(this.f49918j);
    }

    public void bindData(c.a.r0.x.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f49915g = aVar;
            if (aVar == null) {
                return;
            }
            this.f49909a.startLoad(aVar.f28251c, 12, false);
            this.f49910b.setText(aVar.f28252d);
            String valueOf = String.valueOf(aVar.f28253e);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.f28253e));
            }
            handleKeyWordColor(this.f49911c, String.format(this.itemView.getContext().getString(R.string.num_and_vote_count), valueOf, Integer.valueOf(aVar.f28254f)), aVar.f28258j);
            this.f49912d.setText(String.format(this.itemView.getContext().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(aVar.f28255g), StringHelper.numFormatOverWanWithNegative(aVar.f28256h), StringHelper.numFormatOverWanWithNegative(aVar.f28257i)));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TbadkCoreApplication.getInst().getSkinType() == this.f49914f) {
            return;
        }
        SkinManager.setViewTextColor(this.f49910b, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f49911c, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f49912d, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f49913e, R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f49913e, R.drawable.shape_vote_button);
    }
}
