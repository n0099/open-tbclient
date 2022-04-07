package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ic5;
import com.repackage.z77;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SettingTextSwitchView a;
    public RelativeLayout b;
    public RelativeLayout c;
    public RelativeLayout d;
    public RelativeLayout e;
    public TextView f;
    public RelativeLayout g;
    public RelativeLayout h;
    public TextView i;

    /* loaded from: classes3.dex */
    public class a implements ic5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemMsgManage a;

        public a(ItemMsgManage itemMsgManage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemMsgManage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemMsgManage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ic5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            this.a.setSwitch(bool.booleanValue());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemMsgManage(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    private void setShowState(RecommendForumInfo recommendForumInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, recommendForumInfo) == null) || recommendForumInfo == null) {
            return;
        }
        int intValue = recommendForumInfo.forum_type.intValue();
        if (intValue == 0) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        } else if (intValue == 1) {
            setVisibility(0);
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
        } else if (intValue == 2) {
            this.c.setVisibility(8);
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            setVisibility(0);
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02b3, (ViewGroup) this, true);
            SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) findViewById(R.id.obfuscated_res_0x7f090328);
            this.a = settingTextSwitchView;
            settingTextSwitchView.setTextLeftMargin(R.dimen.obfuscated_res_0x7f0701d5);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090319);
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09031e);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090321);
            this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090320);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090322);
            this.g = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09031b);
            this.h = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090323);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090324);
            setVisibility(8);
        }
    }

    public void b(ForumDetailActivity forumDetailActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumDetailActivity, i) == null) {
            forumDetailActivity.getLayoutMode().k(i == 1);
            forumDetailActivity.getLayoutMode().j(this);
            this.a.d(i);
        }
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{recommendForumInfo, Boolean.valueOf(z), Boolean.valueOf(z2), managerApplyInfo, priManagerApplyInfo, managerElectionTab}) == null) {
            boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
            setShowState(recommendForumInfo);
            if (!TbadkCoreApplication.isLogin()) {
                setVisibility(8);
            } else {
                this.g.setVisibility(z2 ? 0 : 8);
                if (recommendForumInfo.is_like.intValue() == 0) {
                    this.a.setVisibility(8);
                    this.b.setVisibility(8);
                    this.c.setVisibility(8);
                    this.g.setVisibility(8);
                }
                this.e.setVisibility(z ? 0 : 8);
                findViewById(R.id.obfuscated_res_0x7f09031f).setVisibility(z ? 0 : 8);
                if (managerElectionTab != null) {
                    if (managerElectionTab.is_new_strategy.intValue() == 1) {
                        this.h.setVisibility(0);
                        this.i.setText(managerElectionTab.new_strategy_text);
                    } else {
                        this.h.setVisibility(8);
                    }
                }
                setVisibility(0);
            }
            if (!z3) {
                this.f.setVisibility(8);
            } else if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.f.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0655), StringHelper.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.f.setText(format);
                    } else {
                        this.f.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.f.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0656));
                } else if (intValue == 2) {
                    this.f.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0654));
                } else {
                    this.f.setVisibility(8);
                }
            }
            z77.j().d(TbadkCoreApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new a(this));
        }
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
            this.c.setOnClickListener(onClickListener);
            this.d.setOnClickListener(onClickListener);
            this.e.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.h.setOnClickListener(onClickListener);
        }
    }

    public void setSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.a.getSwitchView().l();
            } else {
                this.a.getSwitchView().i();
            }
        }
    }

    public void setSwitchChangeListener(BdSwitchView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.a.setSwitchStateChangeListener(bVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.setVisibility(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemMsgManage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    public void setShowState(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, recommendForumInfo, z) == null) {
            setShowState(recommendForumInfo);
            if (!z) {
                setVisibility(8);
            } else {
                setVisibility(0);
            }
        }
    }
}
