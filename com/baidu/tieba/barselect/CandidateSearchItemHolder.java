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
import com.baidu.tieba.eh;
import com.baidu.tieba.fj;
import com.baidu.tieba.p06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CandidateSearchItemHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public int f;
    public p06 g;
    public BdUniqueId h;
    public View i;
    public View.OnClickListener j;

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.g == null) {
                return;
            }
            if (view2.getId() != this.a.i.getId() && view2.getId() != this.a.a.getId()) {
                if (view2.getId() != this.a.e.getId() || !(this.a.itemView.getContext() instanceof Activity) || !ViewHelper.checkUpIsLogin(this.a.itemView.getContext())) {
                    return;
                }
                if (this.a.g.k) {
                    fj.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f084d);
                    return;
                }
                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.a.g.b, this.a.g.a, this.a.g.l, 3);
                if (this.a.h == null) {
                    if (this.a.itemView.getContext() instanceof BaseActivity) {
                        CandidateSearchItemHolder candidateSearchItemHolder = this.a;
                        candidateSearchItemHolder.h = ((BaseActivity) candidateSearchItemHolder.itemView.getContext()).getUniqueId();
                    } else if (this.a.itemView.getContext() instanceof BaseFragmentActivity) {
                        CandidateSearchItemHolder candidateSearchItemHolder2 = this.a;
                        candidateSearchItemHolder2.h = ((BaseFragmentActivity) candidateSearchItemHolder2.itemView.getContext()).getUniqueId();
                    }
                }
                commitVoteReqMsg.setTag(this.a.h);
                MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                return;
            }
            if (this.a.g.b == eh.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                z = true;
            } else {
                z = false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.itemView.getContext()).createNormalConfig(this.a.g.b, z, false)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CandidateSearchItemHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.f = 3;
        this.h = null;
        this.j = new a(this);
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090edb);
        this.a = headImageView;
        headImageView.setIsRound(true);
        this.a.setOnClickListener(this.j);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091612);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09170c);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090160);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09046b);
        this.itemView.setOnClickListener(this.j);
        this.e.setOnClickListener(this.j);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0904ae);
        this.i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void g(p06 p06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p06Var) == null) {
            this.g = p06Var;
            if (p06Var == null) {
                return;
            }
            this.a.L(p06Var.c, 12, false);
            this.b.setText(p06Var.d);
            String valueOf = String.valueOf(p06Var.e);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(p06Var.e));
            }
            h(this.c, String.format(this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0cf4), valueOf, Integer.valueOf(p06Var.f)), p06Var.j);
            this.d.setText(String.format(this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f00ea), StringHelper.numFormatOverWanWithNegative(p06Var.g), StringHelper.numFormatOverWanWithNegative(p06Var.h), StringHelper.numFormatOverWanWithNegative(p06Var.i)));
            i();
        }
    }

    public void h(TextView textView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, str, str2) == null) && textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
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
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && TbadkCoreApplication.getInst().getSkinType() != this.f) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.e, R.drawable.shape_vote_button);
        }
    }
}
