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
import com.baidu.tieba.f05;
import com.baidu.tieba.frs.FrsPrivateCommonDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PrivateForumInfo;
/* loaded from: classes5.dex */
public class c48 extends m15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public String c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ f05 b;
        public final /* synthetic */ c48 c;

        public a(c48 c48Var, TbPageContext tbPageContext, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c48Var, tbPageContext, f05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c48Var;
            this.a = tbPageContext;
            this.b = f05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.is_forum_owner_check)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.private_pop_info);
                UrlManager.getInstance().dealOneLink(this.a, new String[]{privateForumPopInfoData.S()});
                u38.f(privateForumPopInfoData, booleanValue, this.c.b, this.c.c, true);
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c48 c48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(c48 c48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c48Var};
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

    public c48() {
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
    @Override // com.baidu.tieba.m15
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull Context context, @NonNull a15 a15Var) {
        ForumData forumData;
        UserData userData;
        PrivateForumPopInfoData privateForumPopInfoData;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, a15Var) == null) {
            if (!(context instanceof TbPageContextSupport)) {
                YunDialogManager.unMarkShowingDialogName("frsExam");
                return;
            }
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) context;
            if (tbPageContextSupport.getPageContext() != null && tbPageContextSupport.getPageContext().getPageActivity() != null) {
                eva frsResponseData = TbSingleton.getInstance().getFrsResponseData();
                FrsViewData frsViewData = new FrsViewData();
                frsViewData.receiveData(frsResponseData);
                sy4 sy4Var = null;
                if (context instanceof i25) {
                    i25 i25Var = (i25) context;
                    if (i25Var.i1() != null) {
                        h25 i1 = i25Var.i1();
                        sy4Var = i1.n1();
                        userData = i1.W1();
                        privateForumPopInfoData = i1.r1();
                        forumData = i1.a1();
                        if (sy4Var == null) {
                            sy4Var = frsViewData.getPrivateForumTotalInfo();
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
                            if ((sy4Var == null || sy4Var.a() == null || userData.getIs_manager() != 1) && privateForumPopInfoData == null) {
                                YunDialogManager.unMarkShowingDialogName("frsExam");
                                return;
                            }
                            PrivateForumPopInfoData privateForumPopInfoData2 = new PrivateForumPopInfoData();
                            privateForumPopInfoData2.T(sy4Var.c());
                            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(tbPageContextSupport.getPageContext().getPageActivity());
                            PrivateForumInfo a2 = sy4Var.a();
                            if (a2 != null && a2.private_forum_status.intValue() == 1 && (rd.isEmpty(privateForumPopInfoData2.R()) || privateForumPopInfoData2.Q() != JavaTypesHelper.toInt(this.b, 0))) {
                                privateForumPopInfoData2.W("create_success");
                                privateForumPopInfoData2.X(String.format(a48.a, this.b, this.c));
                                privateForumPopInfoData2.V(JavaTypesHelper.toInt(this.b, -1));
                                privateForumPopInfoData2.setTitle(context.getString(R.string.obfuscated_res_0x7f0f1750));
                                privateForumPopInfoData2.U(context.getString(R.string.obfuscated_res_0x7f0f1751));
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
                            f05 f05Var = new f05(pageContext.getPageActivity());
                            f05Var.setContentViewSize(10);
                            f05Var.setContentView(frsPrivateCommonDialogView);
                            f05Var.setCanceledOnTouchOutside(false);
                            frsPrivateCommonDialogView.setConfirmButton(new a(this, pageContext, f05Var));
                            f05Var.setCloseButton(new b(this));
                            f05Var.setOnDismissListener(new c(this));
                            f05Var.create(pageContext).show();
                            FrsPrivateCommonDialogView.setDialogShown(privateForumPopInfoData, this.a);
                            u38.f(privateForumPopInfoData, this.a, this.b, this.c, false);
                            return;
                        }
                        YunDialogManager.unMarkShowingDialogName("frsExam");
                        return;
                    }
                }
                forumData = null;
                userData = null;
                privateForumPopInfoData = null;
                if (sy4Var == null) {
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
