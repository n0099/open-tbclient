package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c49 extends n49<a59> implements p49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ForumTabSelectedView g;
    @Nullable
    public View h;
    public final ForumTabSelectedView.d i;

    /* loaded from: classes3.dex */
    public class a implements ForumTabSelectedView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c49 a;

        public a(c49 c49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c49Var;
        }

        @Override // com.baidu.tieba.write.view.ForumTabSelectedView.d
        public void a(FrsTabItemData frsTabItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, frsTabItemData) == null) {
                ((a59) this.a.d).b = frsTabItemData;
                c49 c49Var = this.a;
                c49Var.w(c49Var.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c49(TbPageContext<?> tbPageContext) {
        super(tbPageContext, a59.class);
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
        this.i = new a(this);
    }

    @Override // com.baidu.tieba.s49
    public void b(WriteData writeData) {
        ForumTabSelectedView forumTabSelectedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || (forumTabSelectedView = this.g) == null || forumTabSelectedView.getVisibility() != 0 || writeData == null) {
            return;
        }
        D d = this.d;
        if (((a59) d).a != null) {
            writeData.setIsForumBusinessAccount(((a59) d).a.isForumBusinessAccount);
        }
        FrsTabItemData selectedTabItemData = this.g.getSelectedTabItemData();
        if (selectedTabItemData == null) {
            return;
        }
        writeData.setTabId(selectedTabItemData.tabId);
        writeData.setTabName(selectedTabItemData.name);
        writeData.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    @Override // com.baidu.tieba.s49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.s49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.s49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            ForumTabSelectedView forumTabSelectedView = this.g;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.o(i);
            }
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0210);
        }
    }

    @Override // com.baidu.tieba.p49
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, obj) == null) && (obj instanceof SelectForumData) && this.c != null) {
            SelectForumData selectForumData = (SelectForumData) obj;
            if (!ListUtils.isEmpty(selectForumData.tabInfoList)) {
                FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
                frsTabInfoData.selectedTabId = -1;
                List<FrsTabItemData> list = selectForumData.tabInfoList;
                frsTabInfoData.tabList = list;
                if (selectForumData.isForumBusinessAccount && list != null) {
                    FrsTabItemData frsTabItemData = new FrsTabItemData();
                    frsTabItemData.tabId = 505;
                    frsTabItemData.name = "官方";
                    frsTabInfoData.tabList.add(0, frsTabItemData);
                }
                frsTabInfoData.isForumBusinessAccount = selectForumData.isForumBusinessAccount;
                ForumTabSelectedView forumTabSelectedView = this.g;
                if (forumTabSelectedView != null) {
                    forumTabSelectedView.setData(frsTabInfoData);
                    if (this.g.getVisibility() == 0) {
                        this.c.setVisibility(0);
                    } else {
                        this.c.setVisibility(8);
                    }
                }
                ((a59) this.d).a = frsTabInfoData;
                WriteData writeData = this.e;
                if (writeData != null) {
                    writeData.setFrsTabInfoData(frsTabInfoData);
                    return;
                }
                return;
            }
            this.c.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.s49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04a1, viewGroup, false);
            this.c = inflate;
            this.g = (ForumTabSelectedView) inflate.findViewById(R.id.obfuscated_res_0x7f090c09);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f090c06);
            ForumTabSelectedView forumTabSelectedView = this.g;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.setBgColor(R.color.CAM_X0205);
                WriteData writeData = this.e;
                if (writeData != null) {
                    this.g.setData(writeData.getFrsTabInfoData());
                    if (this.g.getVisibility() == 0) {
                        this.c.setVisibility(0);
                    } else {
                        this.c.setVisibility(8);
                    }
                }
                this.g.setActivity(this.a);
                this.g.setTabSelectedListener(this.i);
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
