package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.write.view.WriteEvaluationHeaderView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class gu9 extends uu9<hv9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public WriteEvaluationHeaderView g;
    public final CustomMessageListener h;

    public final int D(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)})) == null) ? (int) ((d + 1.0d) / 2.0d) : invokeCommon.intValue;
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gu9 gu9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                return;
            }
            this.a.E((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements WriteEvaluationHeaderView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu9 a;

        public b(gu9 gu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu9Var;
        }

        @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.c
        public void onClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gu9(TbPageContext<?> tbPageContext) {
        super(tbPageContext, hv9.class);
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
        this.h = new a(this, 2921516);
    }

    @Override // com.baidu.tieba.zu9
    public void e(@NonNull WriteData writeData) {
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, writeData) != null) || (writeEvaluationHeaderView = this.g) == null) {
            return;
        }
        writeData.setItemInfo(writeEvaluationHeaderView.getEvaluateItemInfo());
        writeData.setEvaluationStar(this.g.getStarCount());
    }

    @Override // com.baidu.tieba.uu9, com.baidu.tieba.zu9
    public void j(@NonNull bv9 bv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bv9Var) == null) {
            super.j(bv9Var);
            this.a.registerListener(this.h);
        }
    }

    @Override // com.baidu.tieba.zu9
    public void onChangeSkinType(int i) {
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (writeEvaluationHeaderView = this.g) != null) {
            writeEvaluationHeaderView.f();
        }
    }

    public final String C() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.g;
            if (writeEvaluationHeaderView != null) {
                i = writeEvaluationHeaderView.getStarCount();
            } else {
                i = 0;
            }
            arrayList.add(new HeadItem("", String.valueOf(i), 2));
            return new Gson().toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final void E(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, evaluateRelevanceItemSelectedMessage) != null) || (writeEvaluationHeaderView = this.g) == null) {
            return;
        }
        writeEvaluationHeaderView.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.setItemID(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.setScore(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.g.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    @Override // com.baidu.tieba.zu9
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) && this.g != null && writeData.getItemInfo() != null) {
            WriteData writeData2 = this.e;
            if (writeData2 != null) {
                writeData2.setItemInfo(writeData.getItemInfo());
                this.e.setEvaluationStar(writeData.getEvaluationStar());
            }
            this.g.setItemInfo(writeData.getItemInfo());
            this.g.setStarCount(writeData.getEvaluationStar());
        }
    }

    @Override // com.baidu.tieba.zu9
    public void c(WriteData writeData) {
        WriteEvaluationHeaderView writeEvaluationHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) && (writeEvaluationHeaderView = this.g) != null) {
            writeData.setItemInfo(writeEvaluationHeaderView.getEvaluateItemInfo());
            if (this.g.getEvaluateItemInfo() != null) {
                writeData.setItem_id(this.g.getEvaluateItemInfo().getItemID());
                writeData.setComment_head(C());
            }
        }
    }

    @Override // com.baidu.tieba.zu9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04d7, viewGroup, false);
            this.c = inflate;
            WriteEvaluationHeaderView writeEvaluationHeaderView = (WriteEvaluationHeaderView) inflate.findViewById(R.id.obfuscated_res_0x7f0928cc);
            this.g = writeEvaluationHeaderView;
            if (writeEvaluationHeaderView != null) {
                writeEvaluationHeaderView.setItemCloseListener(new b(this));
                WriteData writeData = this.e;
                if (writeData != null) {
                    if (writeData.isFromItemDetail()) {
                        this.g.setShowItemInfo(false);
                    }
                    if (this.e.getIntentItemInfo() != null) {
                        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                        tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.e.getIntentItemInfo().id));
                        tbRichTextEvaluateItemInfo.setTags(this.e.getIntentItemInfo().tags);
                        tbRichTextEvaluateItemInfo.setScore(this.e.getIntentItemInfo().averageScore);
                        tbRichTextEvaluateItemInfo.setStar(D(this.e.getIntentItemInfo().averageScore));
                        tbRichTextEvaluateItemInfo.setIconUrl(this.e.getIntentItemInfo().icon_url);
                        tbRichTextEvaluateItemInfo.setIconSize(this.e.getIntentItemInfo().icon_size);
                        tbRichTextEvaluateItemInfo.setTitle(this.e.getIntentItemInfo().name);
                        this.g.setItemInfo(tbRichTextEvaluateItemInfo);
                        this.g.setStarCount(this.e.getIntentStarCount());
                        this.e.setItemInfo(tbRichTextEvaluateItemInfo);
                        WriteData writeData2 = this.e;
                        writeData2.setEvaluationStar(writeData2.getIntentStarCount());
                    } else if (this.e.getItemInfo() != null) {
                        this.g.setItemInfo(this.e.getItemInfo());
                        this.g.setStarCount(this.e.getEvaluationStar());
                    }
                }
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uu9, com.baidu.tieba.zu9
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            WriteEvaluationHeaderView writeEvaluationHeaderView = this.g;
            if (writeEvaluationHeaderView != null && writeEvaluationHeaderView.e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
