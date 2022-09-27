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
import com.baidu.tieba.ih5;
import com.baidu.tieba.mb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class ItemMsgManage extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SettingTextSwitchView a;
    public RelativeLayout b;
    public RelativeLayout c;
    public RelativeLayout d;
    public TextView e;
    public RelativeLayout f;
    public RelativeLayout g;
    public TextView h;

    /* loaded from: classes4.dex */
    public class a implements ih5<Boolean> {
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
        @Override // com.baidu.tieba.ih5
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
        } else if (intValue == 1) {
            setVisibility(0);
            this.a.setVisibility(0);
            this.b.setVisibility(0);
        } else if (intValue == 2) {
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            setVisibility(0);
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02ad, (ViewGroup) this, true);
            SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) findViewById(R.id.obfuscated_res_0x7f090343);
            this.a = settingTextSwitchView;
            settingTextSwitchView.setTextLeftMargin(R.dimen.obfuscated_res_0x7f0701d5);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090335);
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09033c);
            this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09033b);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09033d);
            this.f = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090337);
            this.g = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09033e);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f09033f);
            setVisibility(8);
        }
    }

    public void b(ForumDetailActivity forumDetailActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumDetailActivity, i) == null) {
            forumDetailActivity.getLayoutMode().l(i == 1);
            forumDetailActivity.getLayoutMode().k(this);
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
                this.f.setVisibility(z2 ? 0 : 8);
                if (recommendForumInfo.is_like.intValue() == 0) {
                    this.a.setVisibility(8);
                    this.b.setVisibility(8);
                    this.f.setVisibility(8);
                }
                this.d.setVisibility(z ? 0 : 8);
                findViewById(R.id.obfuscated_res_0x7f09033a).setVisibility(z ? 0 : 8);
                if (managerElectionTab != null) {
                    if (managerElectionTab.is_new_strategy.intValue() == 1) {
                        this.g.setVisibility(0);
                        this.h.setText(managerElectionTab.new_strategy_text);
                    } else {
                        this.g.setVisibility(8);
                    }
                }
                setVisibility(0);
            }
            if (!z3) {
                this.e.setVisibility(8);
            } else if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.e.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0680), StringHelper.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.e.setText(format);
                    } else {
                        this.e.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0681));
                } else if (intValue == 2) {
                    this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f067f));
                } else {
                    this.e.setVisibility(8);
                }
            }
            mb7.j().d(TbadkCoreApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new a(this));
        }
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
            this.c.setOnClickListener(onClickListener);
            this.d.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
        }
    }

    public void setSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.a.getSwitchView().m();
            } else {
                this.a.getSwitchView().j();
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
