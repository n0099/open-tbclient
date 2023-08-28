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
/* loaded from: classes5.dex */
public class f2b extends m2b<f3b> implements o2b {
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
    public x4b k;

    @Override // com.baidu.tieba.r2b
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.r2b
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.r2b
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, writeData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f2b a;

        public a(f2b f2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f2bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.L()) {
                    if (this.a.b != null) {
                        this.a.b.b(this.a.a.getString(R.string.obfuscated_res_0x7f0f043e));
                    }
                } else if (this.a.g == null) {
                    if (!TextUtils.isEmpty(this.a.h)) {
                        this.a.N();
                    } else {
                        this.a.M();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements u4b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f2b a;

        public b(f2b f2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f2bVar;
        }

        @Override // com.baidu.tieba.u4b
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
    public f2b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, f3b.class);
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

    @Override // com.baidu.tieba.r2b
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            NormalItemCell normalItemCell = this.j;
            if (normalItemCell != null) {
                normalItemCell.e();
            }
            x4b x4bVar = this.k;
            if (x4bVar != null) {
                x4bVar.r();
            }
        }
    }

    @Override // com.baidu.tieba.o2b
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, obj) == null) && (obj instanceof SelectForumData)) {
            SelectForumData selectForumData = (SelectForumData) obj;
            this.g = selectForumData.forumTagInfo;
            this.h = selectForumData.firstCategory;
            O();
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.e;
            if (writeData == null || !"2".equals(writeData.getCallFrom()) || this.g != null || !TextUtils.isEmpty(this.e.getForumName())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.e != null && this.j != null && this.a.getPageActivity() != null && !this.a.getPageActivity().isFinishing()) {
            if (this.k == null) {
                this.k = new x4b();
            }
            String str = null;
            if (this.g == null) {
                str = this.j.getSubTitleContent();
            }
            this.k.u(this.a.getPageActivity(), str, this.e.getForumId(), new b(this));
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.j == null) {
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
        this.j.h();
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            QuestionTagChooseActivityConfig questionTagChooseActivityConfig = new QuestionTagChooseActivityConfig(this.a.getPageActivity());
            questionTagChooseActivityConfig.setCategory(this.h);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, questionTagChooseActivityConfig));
        }
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            x4b x4bVar = this.k;
            if (x4bVar != null) {
                x4bVar.s();
            }
        }
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            if (bundle != null) {
                this.h = bundle.getString(WriteActivityConfig.FORUM_FIRST_CATEGORY);
                this.g = (ForumTagInfo) bundle.getSerializable(WriteActivityConfig.FORUM_TAG_INFO);
            } else if (intent != null) {
                this.h = intent.getStringExtra(WriteActivityConfig.FORUM_FIRST_CATEGORY);
                this.g = (ForumTagInfo) intent.getSerializableExtra(WriteActivityConfig.FORUM_TAG_INFO);
            }
        }
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || i != 25072 || intent == null || this.e == null || this.j == null) {
                return;
            }
            if (intent.getBooleanExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_CREATE_TAG, false)) {
                M();
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

    @Override // com.baidu.tieba.r2b
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        ForumTagInfo forumTagInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0551, viewGroup, false);
            this.i = inflate;
            this.j = (NormalItemCell) inflate.findViewById(R.id.obfuscated_res_0x7f091e15);
            NormalItemCell.a aVar = new NormalItemCell.a();
            aVar.b = 1;
            aVar.f = this.a.getString(R.string.obfuscated_res_0x7f0f044b);
            aVar.e = this.a.getString(R.string.obfuscated_res_0x7f0f044a);
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
