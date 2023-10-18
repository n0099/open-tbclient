package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.holder.PersonInfoAddUserPicViewHolder;
import com.baidu.tieba.person.holder.PersonInfoUserPicViewHolder;
import com.baidu.tieba.rz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ht9 extends dt9 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public final WriteImagesInfo c;
    public boolean d;
    public kt9 e;
    public PersonChangeData f;
    public PermissionJudgePolicy g;
    public HttpMessageListener h;
    public HttpMessageListener i;
    public Runnable j;
    public CustomMessageListener k;

    /* loaded from: classes6.dex */
    public class a implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz4 a;
        public final /* synthetic */ ht9 b;

        public a(ht9 ht9Var, pz4 pz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht9Var, pz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ht9Var;
            this.a = pz4Var;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.b.d = false;
                if (i != 0) {
                    if (i == 1) {
                        this.b.u();
                    }
                } else {
                    this.b.s();
                }
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic5 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ pz4 d;
        public final /* synthetic */ ht9 e;

        public b(ht9 ht9Var, ic5 ic5Var, List list, int i, pz4 pz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht9Var, ic5Var, list, Integer.valueOf(i), pz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ht9Var;
            this.a = ic5Var;
            this.b = list;
            this.c = i;
            this.d = pz4Var;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.e.d = true;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                                this.e.t();
                            }
                        } else {
                            ht9 ht9Var = this.e;
                            if (ht9Var.a && ht9Var.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                                if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                                    BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                                } else {
                                    BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f1074);
                                }
                            } else {
                                this.e.u();
                            }
                        }
                    } else {
                        ht9 ht9Var2 = this.e;
                        if (ht9Var2.a && ht9Var2.e != null && this.e.e.j() != null && !this.e.e.j().canModifyAvatar()) {
                            if (!StringUtils.isNull(this.e.e.j().getCantModifyAvatarDesc())) {
                                BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), this.e.e.j().getCantModifyAvatarDesc());
                            } else {
                                BdUtilHelper.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f1074);
                            }
                        } else {
                            this.e.s();
                        }
                    }
                } else {
                    this.e.x(this.a, this.b, this.c);
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic5 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ int c;
        public final /* synthetic */ pz4 d;
        public final /* synthetic */ ht9 e;

        public c(ht9 ht9Var, ic5 ic5Var, List list, int i, pz4 pz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht9Var, ic5Var, list, Integer.valueOf(i), pz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ht9Var;
            this.a = ic5Var;
            this.b = list;
            this.c = i;
            this.d = pz4Var;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            it9.b(this.a, this.b);
                        }
                    } else {
                        it9.d(this.a, this.e.b.getUniqueId());
                    }
                } else {
                    this.e.x(this.a, this.b, this.c);
                }
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ht9 ht9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht9Var, Integer.valueOf(i)};
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
            this.a = ht9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ht9 ht9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht9Var, Integer.valueOf(i)};
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
            this.a = ht9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() == 0) {
                    this.a.A();
                } else {
                    this.a.b.showToast(setUserPicsResponse.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(ht9 ht9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ht9 ht9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht9Var, Integer.valueOf(i)};
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
            this.a = ht9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.a.y((PersonChangeData) customResponsedMessage.getData());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ht9(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new WriteImagesInfo(1);
        this.d = true;
        this.h = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.i = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.j = new f(this);
        g gVar = new g(this, 2001380);
        this.k = gVar;
        this.b = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.i.setTag(bdUniqueId);
        this.h.setTag(bdUniqueId);
        this.b.registerListener(this.k);
        this.b.registerListener(this.i);
        this.b.registerListener(this.h);
    }

    public final void x(ic5 ic5Var, List<yh> list, int i) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048590, this, ic5Var, list, i) == null) && this.b != null && ic5Var != null && list != null && !StringUtils.isNull(ic5Var.a())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (yh yhVar : list) {
                if (yhVar instanceof ic5) {
                    ic5 ic5Var2 = (ic5) yhVar;
                    if (ic5Var2.c() && !ic5Var2.a().startsWith("http")) {
                        arrayList.add(it9.c(this.b, ic5Var2.a()));
                    } else {
                        arrayList.add(ic5Var2.a());
                    }
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                str = arrayList.get(size - 1);
            } else {
                str = "";
            }
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            builder.setData(arrayList).setIndex(i).setIsCDN(true).setLastId(str).setIsReserve(true).setIsShowHost(false);
            ImageViewerConfig bulid = builder.bulid(this.b.getPageActivity());
            bulid.getIntent().putExtra("from", "portrait");
            this.b.sendMessage(new CustomMessage(2010000, bulid));
        }
    }

    public void B(kt9 kt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kt9Var) == null) {
            this.e = kt9Var;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().postDelayed(this.j, 300L);
        }
    }

    public void n() {
        kt9 kt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (kt9Var = this.e) != null && kt9Var.j() != null) {
            TbImageMemoryCache.B().q(this.e.j().getPortrait());
        }
    }

    public List<yh> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            kt9 kt9Var = this.e;
            if (kt9Var == null) {
                return null;
            }
            return kt9Var.k();
        }
        return (List) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.b.getPageActivity())));
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.j);
        }
    }

    public final void C() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.b.getString(R.string.change_system_photo)};
        pz4 pz4Var = new pz4(this.b);
        pz4Var.i(null, strArr, new a(this, pz4Var));
        pz4Var.l();
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.b.getPageActivity(), 12014, this.d)));
    }

    public final void D(ic5 ic5Var, List<yh> list, int i) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048579, this, ic5Var, list, i) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f09c0), this.b.getString(R.string.change_photo), this.b.getString(R.string.change_system_photo), this.b.getString(R.string.check_headpendant)};
        pz4 pz4Var = new pz4(this.b);
        pz4Var.i(null, strArr, new b(this, ic5Var, list, i, pz4Var));
        pz4Var.l();
    }

    public final void E(ic5 ic5Var, List<yh> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, ic5Var, list, i) == null) {
            String[] strArr = {this.b.getString(R.string.look_big_photo), this.b.getString(R.string.set_as_portrait_photo), this.b.getString(R.string.obfuscated_res_0x7f0f0551)};
            pz4 pz4Var = new pz4(this.b);
            pz4Var.i(null, strArr, new c(this, ic5Var, list, i, pz4Var));
            pz4Var.l();
        }
    }

    public void o(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, intent) == null) && intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.c.parseJson(stringExtra);
            this.c.updateQuality();
            if (!ListUtils.isEmpty(this.c.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.b.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.c.getChosedFiles().get(0).getFilePath(), 1.0f, this.d).setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData())));
            }
            this.c.clear();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && view2 != null && p() != null) {
            yh yhVar = null;
            if (view2.getTag() instanceof PersonInfoUserPicViewHolder) {
                yhVar = ((PersonInfoUserPicViewHolder) view2.getTag()).b();
            } else if (view2.getTag() instanceof PersonInfoAddUserPicViewHolder) {
                yhVar = ((PersonInfoAddUserPicViewHolder) view2.getTag()).b();
            }
            int position = ListUtils.getPosition(p(), yhVar);
            if (position < 0) {
                return;
            }
            q(yhVar, p(), position);
        }
    }

    public void q(yh yhVar, List<yh> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, yhVar, list, i) == null) {
            r(yhVar, list, i, false);
        }
    }

    public void r(yh yhVar, List<yh> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{yhVar, list, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || yhVar == null) {
            return;
        }
        if (z) {
            if (yhVar instanceof ic5) {
                x((ic5) yhVar, list, i);
                return;
            }
            return;
        }
        kt9 kt9Var = this.e;
        if (kt9Var != null) {
            this.a = kt9Var.m();
        }
        if (!BdUtilHelper.isNetOk()) {
            this.b.showToast(R.string.obfuscated_res_0x7f0f0e4f);
        } else if (!this.a) {
            if (yhVar instanceof ic5) {
                x((ic5) yhVar, list, i);
            }
        } else if (yhVar instanceof mp9) {
            C();
        } else if (yhVar instanceof ic5) {
            ic5 ic5Var = (ic5) yhVar;
            if (ic5Var.c()) {
                D(ic5Var, list, i);
            } else {
                E(ic5Var, list, i);
            }
        }
    }

    public void s() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (tbPageContext = this.b) == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.g == null) {
            this.g = new PermissionJudgePolicy();
        }
        this.g.clearRequestPermissionList();
        this.g.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.g.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.b.getPageActivity(), this.c.toJsonString(), true);
        albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public final void y(PersonChangeData personChangeData) {
        kt9 kt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, personChangeData) == null) && personChangeData != null && (kt9Var = this.e) != null && kt9Var.j() != null && this.e.m() && personChangeData.getPhotoChanged()) {
            if (this.f == null) {
                this.f = new PersonChangeData();
            }
            this.f.setPhotoChanged(true);
            n();
        }
    }
}
