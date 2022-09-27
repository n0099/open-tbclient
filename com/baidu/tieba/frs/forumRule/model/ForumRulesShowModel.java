package com.baidu.tieba.frs.forumRule.model;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.im6;
import com.baidu.tieba.km6;
import com.baidu.tieba.lm6;
import com.baidu.tieba.mm6;
import com.baidu.tieba.pb;
import com.baidu.tieba.r9;
import com.baidu.tieba.sm8;
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
/* loaded from: classes4.dex */
public class ForumRulesShowModel extends BdBaseModel<ForumRulesShowActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public lm6 g;
    public ForumRuleBaseData h;
    public im6 i;
    public pb j;

    /* loaded from: classes4.dex */
    public class a extends pb {
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

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                    if (this.a.i != null) {
                        this.a.i.f();
                    }
                } else if (this.a.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    if (this.a.i != null) {
                        this.a.i.f();
                    }
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (this.a.i != null) {
                        this.a.i.f();
                    }
                } else {
                    if (responsedMessage instanceof ForumRuleDetailHttpResMsg) {
                        this.a.g = ((ForumRuleDetailHttpResMsg) responsedMessage).getmForumRuleDetailData();
                    } else if (responsedMessage instanceof ForumRuleDetailScoketResMsg) {
                        this.a.g = ((ForumRuleDetailScoketResMsg) responsedMessage).getmForumRuleDetailData();
                    }
                    if (this.a.g == null || this.a.i == null) {
                        return;
                    }
                    this.a.i.c(this.a.g.b() == 2, this.a.g.a());
                    this.a.i.e(this.a.g.n());
                    this.a.i.d(this.a.g);
                    this.a.N();
                    this.a.i.a(this.a.g.o());
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = null;
        this.j = new a(this, CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690);
        this.a = forumRulesShowActivity;
        K();
        G();
    }

    public final ForumRuleDetailReqMsg D(String str) {
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

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.h == null) {
            return;
        }
        this.i.c(false, "");
        this.i.e(this.h.getTitle());
        lm6 lm6Var = new lm6();
        BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
        builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        builder.name_show = TbadkCoreApplication.getCurrentAccountNameShow();
        builder.user_level = Integer.valueOf(this.d);
        lm6Var.r(builder.build(true));
        ForumInfo.Builder builder2 = new ForumInfo.Builder();
        builder2.forum_name = this.c;
        lm6Var.s(builder2.build(true));
        lm6Var.t(false);
        lm6Var.v(this.h.getPreface());
        this.i.d(lm6Var);
        N();
        km6 km6Var = new km6();
        km6Var.k(this.c);
        km6Var.j(this.e);
        km6Var.l(TbadkCoreApplication.getCurrentAccountNameShow());
        km6Var.n(TbadkCoreApplication.getCurrentPortrait());
        this.i.a(km6Var);
        this.i.finish();
    }

    public void F(Bundle bundle) {
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

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(this.j);
        }
    }

    public final List<PbContent> H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                if ("".equals(str)) {
                    break;
                }
                int indexOf = str.indexOf("#(url");
                if (indexOf == 0) {
                    int indexOf2 = str.indexOf(SmallTailInfo.EMOTION_SUFFIX, indexOf) + 1;
                    I(arrayList, str.substring(0, indexOf2));
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

    public final void I(List<PbContent> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, str) == null) {
            String[] split = str.split(",");
            PbContent.Builder builder = new PbContent.Builder();
            builder.type = 1;
            if (split.length > 4) {
                builder.link = URLDecoder.decode(split[2]);
                builder.text = URLDecoder.decode(split[3].substring(0, split[3].length() - 1));
            }
            list.add(builder.build(true));
        }
    }

    public final mm6 J(ForumRuleBaseData.ForumRuleItemData forumRuleItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, forumRuleItemData)) == null) {
            if (forumRuleItemData != null) {
                mm6 mm6Var = new mm6();
                mm6Var.j(forumRuleItemData.getTitle());
                mm6Var.h(H(forumRuleItemData.getContent()));
                mm6Var.g(false);
                return mm6Var;
            }
            return null;
        }
        return (mm6) invokeL.objValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            sm8.h(309690, ForumRuleDetailScoketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_RULES_SHOW, sm8.a(TbConfig.FORUM_RULES_SHOW, 309690));
            tbHttpMessageTask.setResponsedClass(ForumRuleDetailHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.sendMessage(D(this.b));
        }
    }

    public void M(im6 im6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, im6Var) == null) {
            this.i = im6Var;
        }
    }

    public final void N() {
        ForumRuleBaseData forumRuleBaseData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f) && (forumRuleBaseData = this.h) != null) {
                List<ForumRuleBaseData.ForumRuleItemData> list = forumRuleBaseData.getList();
                if (list != null && list.size() > 0) {
                    for (ForumRuleBaseData.ForumRuleItemData forumRuleItemData : list) {
                        arrayList.add(J(forumRuleItemData));
                    }
                }
            } else {
                List<ForumRule> l = this.g.l();
                if (l != null && l.size() > 0) {
                    for (ForumRule forumRule : l) {
                        mm6 mm6Var = new mm6();
                        mm6Var.f(forumRule);
                        arrayList.add(mm6Var);
                    }
                }
            }
            this.i.b(arrayList);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a = null;
            MessageManager.getInstance().unRegisterListener(this.j);
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
        this.b = intent.getStringExtra("forum_id");
        this.f = intent.getStringExtra("from");
        this.c = intent.getStringExtra("forum_name");
        this.e = intent.getStringExtra("url");
        this.d = intent.getIntExtra(IntentConfig.USER_LEVEL, 1);
        this.a.setFrom(this.f);
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f)) {
            this.h = (ForumRuleBaseData) intent.getSerializableExtra(IntentConfig.DATAS);
            E();
            return;
        }
        L();
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
