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
import com.baidu.tieba.jb;
import com.baidu.tieba.k9;
import com.baidu.tieba.ri7;
import com.baidu.tieba.rx9;
import com.baidu.tieba.ti7;
import com.baidu.tieba.ui7;
import com.baidu.tieba.vi7;
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
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public ui7 g;
    public ForumRuleBaseData h;
    public ri7 i;
    public jb j;

    public void c0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    /* loaded from: classes5.dex */
    public class a extends jb {
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

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    if (this.a.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        if (this.a.i != null) {
                            this.a.i.f();
                        }
                    } else if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                        if (responsedMessage instanceof ForumRuleDetailHttpResMsg) {
                            this.a.g = ((ForumRuleDetailHttpResMsg) responsedMessage).getmForumRuleDetailData();
                        } else if (responsedMessage instanceof ForumRuleDetailScoketResMsg) {
                            this.a.g = ((ForumRuleDetailScoketResMsg) responsedMessage).getmForumRuleDetailData();
                        }
                        if (this.a.g != null && this.a.i != null) {
                            ri7 ri7Var = this.a.i;
                            if (this.a.g.b() == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ri7Var.c(z, this.a.g.a());
                            this.a.i.e(this.a.g.l());
                            this.a.i.d(this.a.g);
                            this.a.k0();
                            this.a.i.a(this.a.g.m());
                            this.a.i.finish();
                        }
                    } else if (this.a.i != null) {
                        this.a.i.f();
                    }
                } else if (this.a.i != null) {
                    this.a.i.f();
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
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = null;
        this.j = new a(this, CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690);
        this.a = forumRulesShowActivity;
        h0();
        b0();
    }

    public void d0(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, intent) == null) && intent != null) {
            this.b = intent.getStringExtra("forum_id");
            this.f = intent.getStringExtra("from");
            this.c = intent.getStringExtra("forum_name");
            this.e = intent.getStringExtra("url");
            this.d = intent.getIntExtra(IntentConfig.USER_LEVEL, 1);
            this.a.setFrom(this.f);
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f)) {
                this.h = (ForumRuleBaseData) intent.getSerializableExtra(IntentConfig.DATAS);
                Z();
                return;
            }
            i0();
        }
    }

    public final ForumRuleDetailReqMsg Y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!StringUtils.isNull(str)) {
                ForumRuleDetailReqMsg forumRuleDetailReqMsg = new ForumRuleDetailReqMsg();
                forumRuleDetailReqMsg.setForumRuleId(Long.valueOf(Long.parseLong(str)));
                return forumRuleDetailReqMsg;
            }
            return null;
        }
        return (ForumRuleDetailReqMsg) invokeL.objValue;
    }

    public void a0(Bundle bundle) {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            setUniqueId(getUniqueId());
            if (bundle == null && (forumRulesShowActivity = this.a) != null) {
                d0(forumRulesShowActivity.getIntent());
            } else {
                c0(bundle);
            }
        }
    }

    public void j0(ri7 ri7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ri7Var) == null) {
            this.i = ri7Var;
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h != null) {
            this.i.c(false, "");
            this.i.e(this.h.getTitle());
            ui7 ui7Var = new ui7();
            BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.name_show = TbadkCoreApplication.getCurrentAccountNameShow();
            builder.user_level = Integer.valueOf(this.d);
            ui7Var.o(builder.build(true));
            ForumInfo.Builder builder2 = new ForumInfo.Builder();
            builder2.forum_name = this.c;
            ui7Var.p(builder2.build(true));
            ui7Var.q(false);
            ui7Var.s(this.h.getPreface());
            this.i.d(ui7Var);
            k0();
            ti7 ti7Var = new ti7();
            ti7Var.i(this.c);
            ti7Var.h(this.e);
            ti7Var.k(TbadkCoreApplication.getCurrentAccountNameShow());
            ti7Var.l(TbadkCoreApplication.getCurrentPortrait());
            this.i.a(ti7Var);
            this.i.finish();
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(this.j);
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.sendMessage(Y(this.b));
        }
    }

    public final List<PbContent> e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                if ("".equals(str)) {
                    break;
                }
                int indexOf = str.indexOf("#(url");
                if (indexOf == 0) {
                    int indexOf2 = str.indexOf(SmallTailInfo.EMOTION_SUFFIX, indexOf) + 1;
                    f0(arrayList, str.substring(0, indexOf2));
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

    public final void f0(List<PbContent> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, list, str) == null) {
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

    public final vi7 g0(ForumRuleBaseData.ForumRuleItemData forumRuleItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, forumRuleItemData)) == null) {
            if (forumRuleItemData != null) {
                vi7 vi7Var = new vi7();
                vi7Var.h(forumRuleItemData.getTitle());
                vi7Var.f(e0(forumRuleItemData.getContent()));
                vi7Var.e(false);
                return vi7Var;
            }
            return null;
        }
        return (vi7) invokeL.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            rx9.h(309690, ForumRuleDetailScoketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_RULES_SHOW, rx9.a(TbConfig.FORUM_RULES_SHOW, 309690));
            tbHttpMessageTask.setResponsedClass(ForumRuleDetailHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void k0() {
        ForumRuleBaseData forumRuleBaseData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.f) && (forumRuleBaseData = this.h) != null) {
                List<ForumRuleBaseData.ForumRuleItemData> list = forumRuleBaseData.getList();
                if (list != null && list.size() > 0) {
                    for (ForumRuleBaseData.ForumRuleItemData forumRuleItemData : list) {
                        arrayList.add(g0(forumRuleItemData));
                    }
                }
            } else {
                List<ForumRule> k = this.g.k();
                if (k != null && k.size() > 0) {
                    for (ForumRule forumRule : k) {
                        vi7 vi7Var = new vi7();
                        vi7Var.d(forumRule);
                        arrayList.add(vi7Var);
                    }
                }
            }
            this.i.b(arrayList);
        }
    }
}
