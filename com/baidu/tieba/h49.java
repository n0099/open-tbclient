package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.QuestionTagChooseActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.view.NormalItemCell;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.write.data.QuestionTagListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h49 extends n49<e59> implements p49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ForumTagInfo g;
    @Nullable
    public String h;
    @Nullable
    public View i;
    @Nullable
    public NormalItemCell j;
    @Nullable
    public p69 k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h49 a;

        public a(h49 h49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h49Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.J()) {
                    if (this.a.b != null) {
                        this.a.b.d(this.a.a.getString(R.string.obfuscated_res_0x7f0f03c7));
                    }
                } else if (this.a.g == null) {
                    if (!TextUtils.isEmpty(this.a.h)) {
                        this.a.L();
                    } else {
                        this.a.K();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements m69 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h49 a;

        public b(h49 h49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h49Var;
        }

        @Override // com.baidu.tieba.m69
        public void a(@NonNull QuestionTagListData.QuestionTag questionTag) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, questionTag) == null) {
                if (this.a.e != null) {
                    this.a.e.setQuestionTagId(questionTag.id);
                    this.a.e.setQuestionTagManualCreated(true);
                }
                if (this.a.j != null) {
                    this.a.j.setSubTitle(questionTag.tagName);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h49(TbPageContext<?> tbPageContext) {
        super(tbPageContext, e59.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.e;
            return writeData != null && "2".equals(writeData.getCallFrom()) && this.g == null && TextUtils.isEmpty(this.e.getForumName());
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.e == null || this.j == null || this.a.getPageActivity() == null || this.a.getPageActivity().isFinishing()) {
            return;
        }
        if (this.k == null) {
            this.k = new p69();
        }
        this.k.u(this.a.getPageActivity(), this.g == null ? this.j.getSubTitleContent() : null, this.e.getForumId(), new b(this));
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            QuestionTagChooseActivityConfig questionTagChooseActivityConfig = new QuestionTagChooseActivityConfig(this.a.getPageActivity());
            questionTagChooseActivityConfig.setCategory(this.h);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, questionTagChooseActivityConfig));
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.j == null) {
            return;
        }
        ForumTagInfo forumTagInfo = this.g;
        if (forumTagInfo != null) {
            WriteData writeData = this.e;
            if (writeData != null) {
                writeData.setQuestionTagId(forumTagInfo.id);
                this.e.setQuestionTagManualCreated(false);
            }
            this.j.setSubTitle(this.g.name);
            this.j.a();
            return;
        }
        WriteData writeData2 = this.e;
        if (writeData2 != null) {
            writeData2.setQuestionTagId(null);
            this.e.setQuestionTagManualCreated(false);
        }
        this.j.setSubTitle(null);
        this.j.e();
    }

    @Override // com.baidu.tieba.s49
    public void b(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.c();
            p69 p69Var = this.k;
            if (p69Var != null) {
                p69Var.s();
            }
        }
    }

    @Override // com.baidu.tieba.s49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.s49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void l(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, intent, writeData) == null) {
            super.l(bundle, intent, writeData);
            if (bundle != null) {
                this.h = bundle.getString(WriteActivityConfig.FORUM_FIRST_CATEGORY);
                this.g = (ForumTagInfo) bundle.getSerializable(WriteActivityConfig.FORUM_TAG_INFO);
            } else if (intent != null) {
                this.h = intent.getStringExtra(WriteActivityConfig.FORUM_FIRST_CATEGORY);
                this.g = (ForumTagInfo) intent.getSerializableExtra(WriteActivityConfig.FORUM_TAG_INFO);
            }
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || i != 25072 || intent == null || this.e == null || this.j == null) {
                return;
            }
            if (intent.getBooleanExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_CREATE_TAG, false)) {
                K();
                return;
            }
            QuestionTagListData.QuestionTag questionTag = (QuestionTagListData.QuestionTag) intent.getParcelableExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_TAG);
            if (questionTag == null) {
                return;
            }
            this.e.setQuestionTagId(questionTag.id);
            this.e.setQuestionTagManualCreated(false);
            this.j.setSubTitle(questionTag.tagName);
        }
    }

    @Override // com.baidu.tieba.s49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            NormalItemCell normalItemCell = this.j;
            if (normalItemCell != null) {
                normalItemCell.c();
            }
            p69 p69Var = this.k;
            if (p69Var != null) {
                p69Var.r();
            }
        }
    }

    @Override // com.baidu.tieba.p49
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, obj) == null) && (obj instanceof SelectForumData)) {
            SelectForumData selectForumData = (SelectForumData) obj;
            this.g = selectForumData.forumTagInfo;
            this.h = selectForumData.firstCategory;
            M();
        }
    }

    @Override // com.baidu.tieba.s49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        ForumTagInfo forumTagInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04cd, viewGroup, false);
            this.i = inflate;
            this.j = (NormalItemCell) inflate.findViewById(R.id.obfuscated_res_0x7f091b38);
            NormalItemCell.a aVar = new NormalItemCell.a();
            aVar.b = 1;
            aVar.f = this.a.getString(R.string.obfuscated_res_0x7f0f03d4);
            aVar.e = this.a.getString(R.string.obfuscated_res_0x7f0f03d3);
            NormalItemCell normalItemCell = this.j;
            if (normalItemCell != null) {
                normalItemCell.setConfig(aVar);
                this.j.setOnClickListener(new a(this));
                WriteData writeData = this.e;
                if (writeData != null && "2".equals(writeData.getCallFrom()) && (forumTagInfo = this.g) != null && forumTagInfo.isValid()) {
                    this.e.setQuestionTagId(this.g.id);
                    this.e.setQuestionTagManualCreated(false);
                    this.j.setSubTitle(this.g.name);
                    this.j.setOnClickListener(null);
                    this.j.a();
                }
            }
            return this.i;
        }
        return (View) invokeL.objValue;
    }
}
