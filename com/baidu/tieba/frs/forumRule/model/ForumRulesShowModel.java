package com.baidu.tieba.frs.forumRule.model;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.p0.f1.s1.c.b;
import c.a.p0.f1.s1.c.c;
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
/* loaded from: classes5.dex */
public class ForumRulesShowModel extends BdBaseModel<ForumRulesShowActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;

    /* renamed from: b  reason: collision with root package name */
    public String f32513b;

    /* renamed from: c  reason: collision with root package name */
    public String f32514c;

    /* renamed from: d  reason: collision with root package name */
    public int f32515d;

    /* renamed from: e  reason: collision with root package name */
    public String f32516e;

    /* renamed from: f  reason: collision with root package name */
    public String f32517f;

    /* renamed from: g  reason: collision with root package name */
    public b f32518g;

    /* renamed from: h  reason: collision with root package name */
    public ForumRuleBaseData f32519h;
    public c.a.p0.f1.s1.b.a i;
    public c.a.d.c.g.a j;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRulesShowModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumRulesShowModel forumRulesShowModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRulesShowModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                    if (this.a.i != null) {
                        this.a.i.a();
                    }
                } else if (this.a.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    if (this.a.i != null) {
                        this.a.i.a();
                    }
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (this.a.i != null) {
                        this.a.i.a();
                    }
                } else {
                    if (responsedMessage instanceof ForumRuleDetailHttpResMsg) {
                        this.a.f32518g = ((ForumRuleDetailHttpResMsg) responsedMessage).getmForumRuleDetailData();
                    } else if (responsedMessage instanceof ForumRuleDetailScoketResMsg) {
                        this.a.f32518g = ((ForumRuleDetailScoketResMsg) responsedMessage).getmForumRuleDetailData();
                    }
                    if (this.a.f32518g == null || this.a.i == null) {
                        return;
                    }
                    this.a.i.d(this.a.f32518g.b() == 2, this.a.f32518g.a());
                    this.a.i.f(this.a.f32518g.n());
                    this.a.i.e(this.a.f32518g);
                    this.a.L();
                    this.a.i.b(this.a.f32518g.p());
                    this.a.i.finish();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32518g = null;
        this.f32519h = null;
        this.j = new a(this, CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690);
        this.a = forumRulesShowActivity;
        I();
        initListener();
    }

    public final ForumRuleDetailReqMsg C(String str) {
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

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f32519h == null) {
            return;
        }
        this.i.d(false, "");
        this.i.f(this.f32519h.getTitle());
        b bVar = new b();
        BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
        builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        builder.name_show = TbadkCoreApplication.getCurrentAccountNameShow();
        builder.user_level = Integer.valueOf(this.f32515d);
        bVar.r(builder.build(true));
        ForumInfo.Builder builder2 = new ForumInfo.Builder();
        builder2.forum_name = this.f32514c;
        bVar.s(builder2.build(true));
        bVar.u(false);
        bVar.v(this.f32519h.getPreface());
        this.i.e(bVar);
        L();
        c.a.p0.f1.s1.c.a aVar = new c.a.p0.f1.s1.c.a();
        aVar.k(this.f32514c);
        aVar.j(this.f32516e);
        aVar.m(TbadkCoreApplication.getCurrentAccountNameShow());
        aVar.n(TbadkCoreApplication.getCurrentPortrait());
        this.i.b(aVar);
        this.i.finish();
    }

    public void E(Bundle bundle) {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setUniqueId(getUniqueId());
            if (bundle == null && (forumRulesShowActivity = this.a) != null) {
                initWithIntent(forumRulesShowActivity.getIntent());
            } else {
                initWithBundle(bundle);
            }
        }
    }

    public final List<PbContent> F(String str) {
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
                    G(arrayList, str.substring(0, indexOf2));
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

    public final void G(List<PbContent> list, String str) {
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

    public final c H(ForumRuleBaseData.ForumRuleItemData forumRuleItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, forumRuleItemData)) == null) {
            if (forumRuleItemData != null) {
                c cVar = new c();
                cVar.j(forumRuleItemData.getTitle());
                cVar.i(F(forumRuleItemData.getContent()));
                cVar.g(false);
                return cVar;
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.a4.g0.a.h(309690, ForumRuleDetailScoketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_RULES_SHOW, c.a.p0.a4.g0.a.a(TbConfig.FORUM_RULES_SHOW, 309690));
            tbHttpMessageTask.setResponsedClass(ForumRuleDetailHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.sendMessage(C(this.f32513b));
        }
    }

    public void K(c.a.p0.f1.s1.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.i = aVar;
        }
    }

    public final void L() {
        ForumRuleBaseData forumRuleBaseData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f32517f) && (forumRuleBaseData = this.f32519h) != null) {
                List<ForumRuleBaseData.ForumRuleItemData> list = forumRuleBaseData.getList();
                if (list != null && list.size() > 0) {
                    for (ForumRuleBaseData.ForumRuleItemData forumRuleItemData : list) {
                        arrayList.add(H(forumRuleItemData));
                    }
                }
            } else {
                List<ForumRule> m = this.f32518g.m();
                if (m != null && m.size() > 0) {
                    for (ForumRule forumRule : m) {
                        c cVar = new c();
                        cVar.f(forumRule);
                        arrayList.add(cVar);
                    }
                }
            }
            this.i.c(arrayList);
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
            this.a = null;
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public final void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            registerListener(this.j);
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
        this.f32513b = intent.getStringExtra("forum_id");
        this.f32517f = intent.getStringExtra("from");
        this.f32514c = intent.getStringExtra("forum_name");
        this.f32516e = intent.getStringExtra("url");
        this.f32515d = intent.getIntExtra(IntentConfig.USER_LEVEL, 1);
        this.a.setFrom(this.f32517f);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f32517f)) {
            this.f32519h = (ForumRuleBaseData) intent.getSerializableExtra(IntentConfig.DATAS);
            D();
            return;
        }
        J();
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
