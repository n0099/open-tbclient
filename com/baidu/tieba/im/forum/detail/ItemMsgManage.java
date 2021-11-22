package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.q0.c1.q;
import b.a.r0.l1.t.d;
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
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class ItemMsgManage extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SettingTextSwitchView f51339e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f51340f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f51341g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f51342h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f51343i;
    public TextView j;
    public RelativeLayout k;
    public RelativeLayout l;
    public TextView m;

    /* loaded from: classes9.dex */
    public class a implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemMsgManage f51344a;

        public a(ItemMsgManage itemMsgManage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemMsgManage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51344a = itemMsgManage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            this.f51344a.setSwitch(bool.booleanValue());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(context);
    }

    private void setShowState(RecommendForumInfo recommendForumInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, recommendForumInfo) == null) || recommendForumInfo == null) {
            return;
        }
        int intValue = recommendForumInfo.forum_type.intValue();
        if (intValue == 0) {
            this.f51339e.setVisibility(8);
            this.f51340f.setVisibility(8);
            this.f51341g.setVisibility(8);
        } else if (intValue == 1) {
            setVisibility(0);
            this.f51339e.setVisibility(0);
            this.f51340f.setVisibility(0);
            this.f51341g.setVisibility(0);
        } else if (intValue == 2) {
            this.f51341g.setVisibility(8);
            this.f51340f.setVisibility(0);
            this.f51339e.setVisibility(0);
            setVisibility(0);
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.forum_detail_msg_manage, (ViewGroup) this, true);
            SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) findViewById(R.id.bar_notify);
            this.f51339e = settingTextSwitchView;
            settingTextSwitchView.setTextLeftMargin(R.dimen.ds20);
            this.f51340f = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
            this.f51341g = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
            this.f51342h = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
            this.f51343i = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
            this.j = (TextView) findViewById(R.id.bar_info_member_status);
            this.k = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
            this.l = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
            this.m = (TextView) findViewById(R.id.bar_manager_apply_status);
            setVisibility(8);
        }
    }

    public void onChangeSkinType(ForumDetailActivity forumDetailActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumDetailActivity, i2) == null) {
            forumDetailActivity.getLayoutMode().k(i2 == 1);
            forumDetailActivity.getLayoutMode().j(this);
            this.f51339e.switchSkinType(i2);
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
                this.k.setVisibility(z2 ? 0 : 8);
                if (recommendForumInfo.is_like.intValue() == 0) {
                    this.f51339e.setVisibility(8);
                    this.f51340f.setVisibility(8);
                    this.f51341g.setVisibility(8);
                    this.k.setVisibility(8);
                }
                this.f51343i.setVisibility(z ? 0 : 8);
                findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
                if (managerElectionTab != null) {
                    if (managerElectionTab.is_new_strategy.intValue() == 1) {
                        this.l.setVisibility(0);
                        this.m.setText(managerElectionTab.new_strategy_text);
                    } else {
                        this.l.setVisibility(8);
                    }
                }
                setVisibility(0);
            }
            if (!z3) {
                this.j.setVisibility(8);
            } else if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.j.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), StringHelper.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.j.setText(format);
                    } else {
                        this.j.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.j.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.j.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.j.setVisibility(8);
                }
            }
            d.j().d(TbadkCoreApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new a(this));
        }
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f51340f.setOnClickListener(onClickListener);
            this.f51341g.setOnClickListener(onClickListener);
            this.f51342h.setOnClickListener(onClickListener);
            this.f51343i.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void setSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f51339e.getSwitchView().turnOnNoCallback();
            } else {
                this.f51339e.getSwitchView().turnOffNoCallback();
            }
        }
    }

    public void setSwitchChangeListener(BdSwitchView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f51339e.setSwitchStateChangeListener(bVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.setVisibility(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context);
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
