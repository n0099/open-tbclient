package com.baidu.tieba.frs.forumRule.model;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.u0.e1.c2.c.b;
import c.a.u0.e1.c2.c.c;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailHttpResMsg;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailReqMsg;
import com.baidu.tieba.frs.forumRule.message.ForumRuleDetailScoketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes12.dex */
public class ForumRulesShowModel extends BdBaseModel<ForumRulesShowActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ForumRulesShowActivity f43585e;

    /* renamed from: f  reason: collision with root package name */
    public String f43586f;

    /* renamed from: g  reason: collision with root package name */
    public String f43587g;

    /* renamed from: h  reason: collision with root package name */
    public int f43588h;

    /* renamed from: i  reason: collision with root package name */
    public String f43589i;

    /* renamed from: j  reason: collision with root package name */
    public String f43590j;
    public b k;
    public ForumRuleBaseData l;
    public c.a.u0.e1.c2.b.a m;
    public c.a.d.c.g.a n;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRulesShowModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumRulesShowModel forumRulesShowModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRulesShowModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRulesShowModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                    if (this.a.m != null) {
                        this.a.m.a();
                    }
                } else if (this.a.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    if (this.a.m != null) {
                        this.a.m.a();
                    }
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (this.a.m != null) {
                        this.a.m.a();
                    }
                } else {
                    if (responsedMessage instanceof ForumRuleDetailHttpResMsg) {
                        this.a.k = ((ForumRuleDetailHttpResMsg) responsedMessage).getmForumRuleDetailData();
                    } else if (responsedMessage instanceof ForumRuleDetailScoketResMsg) {
                        this.a.k = ((ForumRuleDetailScoketResMsg) responsedMessage).getmForumRuleDetailData();
                    }
                    if (this.a.k == null || this.a.m == null) {
                        return;
                    }
                    this.a.m.d(this.a.k.d() == 2, this.a.k.a());
                    this.a.m.f(this.a.k.o());
                    this.a.m.e(this.a.k);
                    this.a.J();
                    this.a.m.b(this.a.k.p());
                    this.a.m.finish();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRulesShowModel(ForumRulesShowActivity forumRulesShowActivity) {
        super(forumRulesShowActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = null;
        this.n = new a(this, CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690);
        this.f43585e = forumRulesShowActivity;
        G();
        initListener();
    }

    public final ForumRuleDetailReqMsg A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            ForumRuleDetailReqMsg forumRuleDetailReqMsg = new ForumRuleDetailReqMsg();
            forumRuleDetailReqMsg.setForumRuleId(Long.valueOf(Long.parseLong(str)));
            return forumRuleDetailReqMsg;
        }
        return (ForumRuleDetailReqMsg) invokeL.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.l == null) {
            return;
        }
        this.m.d(false, "");
        this.m.f(this.l.getTitle());
        b bVar = new b();
        BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
        builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        builder.name_show = TbadkCoreApplication.getCurrentAccountNameShow();
        builder.user_level = Integer.valueOf(this.f43588h);
        bVar.s(builder.build(true));
        ForumInfo.Builder builder2 = new ForumInfo.Builder();
        builder2.forum_name = this.f43587g;
        bVar.t(builder2.build(true));
        bVar.u(false);
        bVar.v(this.l.getPreface());
        this.m.e(bVar);
        J();
        c.a.u0.e1.c2.c.a aVar = new c.a.u0.e1.c2.c.a();
        aVar.l(this.f43587g);
        aVar.k(this.f43589i);
        aVar.n(TbadkCoreApplication.getCurrentAccountNameShow());
        aVar.o(TbadkCoreApplication.getCurrentPortrait());
        this.m.b(aVar);
        this.m.finish();
    }

    public void C(Bundle bundle) {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setUniqueId(getUniqueId());
            if (bundle == null && (forumRulesShowActivity = this.f43585e) != null) {
                initWithIntent(forumRulesShowActivity.getIntent());
            } else {
                initWithBundle(bundle);
            }
        }
    }

    public final List<PbContent> D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                if ("".equals(str)) {
                    break;
                }
                int indexOf = str.indexOf("#(url");
                if (indexOf == 0) {
                    int indexOf2 = str.indexOf(SmallTailInfo.EMOTION_SUFFIX, indexOf) + 1;
                    E(arrayList, str.substring(0, indexOf2));
                    str = str.substring(indexOf2, str.length());
                } else if (indexOf == -1) {
                    String substring = str.substring(0, str.length());
                    PbContent.Builder builder = new PbContent.Builder();
                    builder.text = substring;
                    builder.type = 0;
                    arrayList.add(builder.build(true));
                    break;
                } else {
                    String substring2 = str.substring(0, indexOf);
                    PbContent.Builder builder2 = new PbContent.Builder();
                    builder2.text = substring2;
                    builder2.type = 0;
                    arrayList.add(builder2.build(true));
                    str = str.substring(indexOf, str.length());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void E(List<PbContent> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            String[] split = str.split(",");
            PbContent.Builder builder = new PbContent.Builder();
            builder.type = 1;
            builder.link = URLDecoder.decode(split[2]);
            builder.text = URLDecoder.decode(split[3].substring(0, split[3].length() - 1));
            list.add(builder.build(true));
        }
    }

    public final c F(ForumRuleBaseData.ForumRuleItemData forumRuleItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, forumRuleItemData)) == null) {
            if (forumRuleItemData != null) {
                c cVar = new c();
                cVar.k(forumRuleItemData.getTitle());
                cVar.i(D(forumRuleItemData.getContent()));
                cVar.h(false);
                return cVar;
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.u0.z3.g0.a.h(309690, ForumRuleDetailScoketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_RULES_SHOW, c.a.u0.z3.g0.a.a(TbConfig.FORUM_RULES_SHOW, 309690));
            tbHttpMessageTask.setResponsedClass(ForumRuleDetailHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.sendMessage(A(this.f43586f));
        }
    }

    public void I(c.a.u0.e1.c2.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public final void J() {
        ForumRuleBaseData forumRuleBaseData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f43590j) && (forumRuleBaseData = this.l) != null) {
                List<ForumRuleBaseData.ForumRuleItemData> list = forumRuleBaseData.getList();
                if (list != null && list.size() > 0) {
                    for (ForumRuleBaseData.ForumRuleItemData forumRuleItemData : list) {
                        arrayList.add(F(forumRuleItemData));
                    }
                }
            } else {
                List<ForumRule> n = this.k.n();
                if (n != null && n.size() > 0) {
                    for (ForumRule forumRule : n) {
                        c cVar = new c();
                        cVar.g(forumRule);
                        arrayList.add(cVar);
                    }
                }
            }
            this.m.c(arrayList);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f43585e = null;
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    public final void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            registerListener(this.n);
        }
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
        }
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || intent == null) {
            return;
        }
        this.f43586f = intent.getStringExtra("forum_id");
        this.f43590j = intent.getStringExtra("from");
        this.f43587g = intent.getStringExtra("forum_name");
        this.f43589i = intent.getStringExtra("url");
        this.f43588h = intent.getIntExtra(IntentConfig.USER_LEVEL, 1);
        this.f43585e.setFrom(this.f43590j);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f43590j)) {
            this.l = (ForumRuleBaseData) intent.getSerializableExtra(IntentConfig.DATAS);
            B();
            return;
        }
        H();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
