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
/* loaded from: classes5.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f31513b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31514c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31515d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31516e;

    /* renamed from: f  reason: collision with root package name */
    public int f31517f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.e0.b.a f31518g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f31519h;
    public View i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchItemHolder a;

        public a(CandidateSearchItemHolder candidateSearchItemHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchItemHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchItemHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f31518g == null) {
                return;
            }
            if (view.getId() != this.a.i.getId() && view.getId() != this.a.a.getId()) {
                if (view.getId() == this.a.f31516e.getId() && (this.a.itemView.getContext() instanceof Activity) && ViewHelper.checkUpIsLogin(this.a.itemView.getContext())) {
                    if (this.a.f31518g.k) {
                        n.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0808);
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.a.f31518g.f13715b, this.a.f31518g.a, this.a.f31518g.l, 3);
                    if (this.a.f31519h == null) {
                        if (this.a.itemView.getContext() instanceof BaseActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder = this.a;
                            candidateSearchItemHolder.f31519h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                        } else if (this.a.itemView.getContext() instanceof BaseFragmentActivity) {
                            CandidateSearchItemHolder candidateSearchItemHolder2 = this.a;
                            candidateSearchItemHolder2.f31519h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                        }
                    }
                    commitVoteReqMsg.setTag(this.a.f31519h);
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.itemView.getContext()).createNormalConfig(this.a.f31518g.f13715b, this.a.f31518g.f13715b == b.g(TbadkCoreApplication.getCurrentAccount(), 0L), false)));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31517f = 3;
        this.f31519h = null;
        this.j = new a(this);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090eb7);
        this.a = headImageView;
        headImageView.setIsRound(true);
        this.a.setOnClickListener(this.j);
        this.f31513b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0914e9);
        this.f31514c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0915df);
        this.f31515d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09015c);
        this.f31516e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09043e);
        this.itemView.setOnClickListener(this.j);
        this.f31516e.setOnClickListener(this.j);
        View findViewById = view.findViewById(R.id.obfuscated_res_0x7f09049a);
        this.i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void g(c.a.p0.e0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f31518g = aVar;
            if (aVar == null) {
                return;
            }
            this.a.J(aVar.f13716c, 12, false);
            this.f31513b.setText(aVar.f13717d);
            String valueOf = String.valueOf(aVar.f13718e);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(aVar.f13718e));
            }
            h(this.f31514c, String.format(this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0c9c), valueOf, Integer.valueOf(aVar.f13719f)), aVar.j);
            this.f31515d.setText(String.format(this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f00e0), StringHelper.numFormatOverWanWithNegative(aVar.f13720g), StringHelper.numFormatOverWanWithNegative(aVar.f13721h), StringHelper.numFormatOverWanWithNegative(aVar.i)));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TbadkCoreApplication.getInst().getSkinType() == this.f31517f) {
            return;
        }
        SkinManager.setViewTextColor(this.f31513b, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.f31514c, (int) R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f31515d, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f31516e, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f31516e, R.drawable.shape_vote_button);
    }
}
