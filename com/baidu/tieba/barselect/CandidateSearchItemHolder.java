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
import com.baidu.tieba.wg;
import com.baidu.tieba.xi;
import com.baidu.tieba.z16;
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
    public z16 g;
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
                    xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0854);
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
            if (this.a.g.b == wg.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
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
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f14);
        this.a = headImageView;
        headImageView.setIsRound(true);
        this.a.setOnClickListener(this.j);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091651);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09174d);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090168);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090478);
        this.itemView.setOnClickListener(this.j);
        this.e.setOnClickListener(this.j);
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0904bb);
        this.i = findViewById;
        findViewById.setOnClickListener(this.j);
    }

    public void g(z16 z16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z16Var) == null) {
            this.g = z16Var;
            if (z16Var == null) {
                return;
            }
            this.a.K(z16Var.c, 12, false);
            this.b.setText(z16Var.d);
            String valueOf = String.valueOf(z16Var.e);
            if (valueOf != null && valueOf.length() < 4) {
                valueOf = String.format("%04d", Long.valueOf(z16Var.e));
            }
            h(this.c, String.format(this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0d0b), valueOf, Integer.valueOf(z16Var.f)), z16Var.j);
            this.d.setText(String.format(this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f00ea), StringHelper.numFormatOverWanWithNegative(z16Var.g), StringHelper.numFormatOverWanWithNegative(z16Var.h), StringHelper.numFormatOverWanWithNegative(z16Var.i)));
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
