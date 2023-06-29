package com.baidu.tieba.ala.gamelist.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.atomdata.AlaAllGameLiveEntryActivityConfig;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ve6;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class AlaAllGameLiveEntryActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public NavigationBar b;
    public LinearLayout c;
    public TextView d;
    public ImageView e;
    public NoScrollGridView f;
    public View g;
    public LinearLayout h;
    public ve6 i;
    public int j;
    public ArrayList<AlaSquareTabInfo> k;
    public IAlaSquareTabController l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAllGameLiveEntryActivity a;

        public a(AlaAllGameLiveEntryActivity alaAllGameLiveEntryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAllGameLiveEntryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaAllGameLiveEntryActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.a.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAllGameLiveEntryActivity a;

        public b(AlaAllGameLiveEntryActivity alaAllGameLiveEntryActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAllGameLiveEntryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaAllGameLiveEntryActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            AlaSquareTabInfo alaSquareTabInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (alaSquareTabInfo = (AlaSquareTabInfo) ListUtils.getItem(this.a.i.a(), i)) != null && this.a.l != null) {
                int tabIndex = this.a.l.getTabIndex(alaSquareTabInfo.id);
                if (tabIndex >= 0) {
                    this.a.l.goToTab(tabIndex);
                    this.a.finish();
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaNewSquareSubListActivityConfig(this.a, alaSquareTabInfo)));
            }
        }
    }

    public AlaAllGameLiveEntryActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.l = null;
        }
    }

    public final void v1() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (intent = getIntent()) != null) {
            this.j = intent.getIntExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_HAS_SEARCH, 0);
            this.k = intent.getParcelableArrayListExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_DATA);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b.onChangeSkinType(getPageContext(), i);
            SkinManager.setImageResource(this.e, R.drawable.icon_search);
            SkinManager.setViewTextColor(this.d, (int) R.color.enter_forum_search_text_color);
            SkinManager.setBackgroundResource(this.c, R.drawable.all_game_search_frame);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(getPageContext().getPageActivity(), R.layout.obfuscated_res_0x7f0d00ea, null);
            this.a = linearLayout;
            NavigationBar navigationBar = (NavigationBar) linearLayout.findViewById(R.id.view_navigation_bar);
            this.b = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.b.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f022c));
            LinearLayout linearLayout2 = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09209f);
            this.c = linearLayout2;
            TextView textView = (TextView) linearLayout2.findViewById(R.id.obfuscated_res_0x7f0920cb);
            this.d = textView;
            textView.setClickable(false);
            this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0920b1);
            this.c.setOnClickListener(new a(this));
            if (this.j == 1) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            this.h = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00ec, (ViewGroup) null);
            this.g = this.a.findViewById(R.id.obfuscated_res_0x7f092088);
            this.i = new ve6(getPageContext());
            NoScrollGridView noScrollGridView = (NoScrollGridView) this.a.findViewById(R.id.obfuscated_res_0x7f0901f9);
            this.f = noScrollGridView;
            noScrollGridView.setOnItemClickListener(new b(this));
            this.f.setAdapter((ListAdapter) this.i);
            if (ListUtils.isEmpty(this.k)) {
                this.g.setVisibility(8);
                this.a.addView(this.h, 1);
            } else {
                this.a.removeView(this.h);
                this.g.setVisibility(0);
                this.i.b(this.k);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            setContentView(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            v1();
            initView();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class);
            if (runTask != null && runTask.getData() != null) {
                this.l = (IAlaSquareTabController) runTask.getData();
            }
        }
    }
}
