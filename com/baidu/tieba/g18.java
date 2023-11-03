package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes6.dex */
public class g18 extends g15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public String c;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ zz4 b;
        public final /* synthetic */ g18 c;

        public a(g18 g18Var, TbPageContext tbPageContext, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, tbPageContext, zz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g18Var;
            this.a = tbPageContext;
            this.b = zz4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.a, new String[]{privateForumPopInfoData.S()});
                z08.f(privateForumPopInfoData, booleanValue, this.c.b, this.c.c, true);
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                YunDialogManager.unMarkShowingDialogName("frsExam");
            }
        }
    }

    public g18() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    @Override // com.baidu.tieba.g15
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull Context context, @NonNull u05 u05Var) {
        ForumData forumData;
        UserData userData;
        PrivateForumPopInfoData privateForumPopInfoData;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, u05Var) == null) {
            if (!(context instanceof TbPageContextSupport)) {
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
            if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                kqa frsResponseData = TbSingleton.getInstance().getFrsResponseData();
                FrsViewData frsViewData = new FrsViewData();
                frsViewData.receiveData(frsResponseData);
                ny4 ny4Var = null;
                if (context instanceof c25) {
                    c25 c25Var = (c25) context;
                    if (c25Var.j1() != null) {
                        b25 j1 = c25Var.j1();
                        ny4Var = j1.g1();
                        userData = j1.K1();
                        privateForumPopInfoData = j1.j1();
                        forumData = j1.U0();
                        if (ny4Var == null) {
                            ny4Var = frsViewData.getPrivateForumTotalInfo();
                        }
                        if (userData == null) {
                            userData = frsViewData.getUserData();
                        }
                        if (privateForumPopInfoData == null) {
                            privateForumPopInfoData = frsViewData.getPrivateForumPopInfo();
                        }
                        if (forumData == null) {
                            forumData = frsViewData.getForum();
                        }
                        if (forumData != null) {
                            this.c = forumData.getName();
                            this.b = forumData.getId();
                        }
                        if (StringUtils.isNull(this.c) && !StringUtils.isNull(this.b)) {
                            if ((ny4Var == null || ny4Var.a() == null || userData.getIs_manager() != 1) && privateForumPopInfoData == null) {
                                YunDialogManager.unMarkShowingDialogName("frsExam");
                                return;
                            }
                            PrivateForumPopInfoData privateForumPopInfoData2 = new PrivateForumPopInfoData();
                            privateForumPopInfoData2.T(ny4Var.c());
                            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(tbPageContextSupport.getPageContext().getPageActivity());
                            PrivateForumInfo a2 = ny4Var.a();
                            if (a2 != null && a2.private_forum_status.intValue() == 1 && (qd.isEmpty(privateForumPopInfoData2.R()) || privateForumPopInfoData2.Q() != JavaTypesHelper.toInt(this.b, 0))) {
                                privateForumPopInfoData2.W("create_success");
                                privateForumPopInfoData2.X(String.format(e18.a, this.b, this.c));
                                privateForumPopInfoData2.V(JavaTypesHelper.toInt(this.b, -1));
                                privateForumPopInfoData2.setTitle(context.getString(R.string.obfuscated_res_0x7f0f173f));
                                privateForumPopInfoData2.U(context.getString(R.string.obfuscated_res_0x7f0f1740));
                                z = frsPrivateCommonDialogView.c(privateForumPopInfoData2, false);
                            } else if (privateForumPopInfoData2.Q() == JavaTypesHelper.toInt(this.b, 0)) {
                                z = frsPrivateCommonDialogView.c(privateForumPopInfoData2, false);
                            } else {
                                z = false;
                            }
                            if (!z) {
                                if (privateForumPopInfoData != null && privateForumPopInfoData.Q() == JavaTypesHelper.toInt(this.b, 0)) {
                                    this.a = true;
                                    frsPrivateCommonDialogView.c(privateForumPopInfoData, true);
                                }
                            } else {
                                privateForumPopInfoData = privateForumPopInfoData2;
                            }
                            TbPageContext pageContext = tbPageContextSupport.getPageContext();
                            zz4 zz4Var = new zz4(pageContext.getPageActivity());
                            zz4Var.setContentViewSize(10);
                            zz4Var.setContentView(frsPrivateCommonDialogView);
                            zz4Var.setCanceledOnTouchOutside(false);
                            frsPrivateCommonDialogView.setConfirmButton(new a(this, pageContext, zz4Var));
                            zz4Var.setCloseButton(new b(this));
                            zz4Var.setOnDismissListener(new c(this));
                            zz4Var.create(pageContext).show();
                            FrsPrivateCommonDialogView.setDialogShown(privateForumPopInfoData, this.a);
                            z08.f(privateForumPopInfoData, this.a, this.b, this.c, false);
                            return;
                        }
                        YunDialogManager.unMarkShowingDialogName("frsExam");
                        return;
                    }
                }
                forumData = null;
                userData = null;
                privateForumPopInfoData = null;
                if (ny4Var == null) {
                }
                if (userData == null) {
                }
                if (privateForumPopInfoData == null) {
                }
                if (forumData == null) {
                }
                if (forumData != null) {
                }
                if (StringUtils.isNull(this.c)) {
                }
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            YunDialogManager.unMarkShowingDialogName("frsExam");
        }
    }
}
