package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.w.m;
import c.a.q0.w.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f43463e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f43464f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f43465g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f43466h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f43467i;

    /* renamed from: j  reason: collision with root package name */
    public OfficialSecondMenuPopupWindow f43468j;
    public d[] k;
    public boolean l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarMsglistView f43469e;

        public a(OfficialBarMsglistView officialBarMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43469e = officialBarMsglistView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43469e.r(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.q0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarMsglistView f43470e;

        public b(OfficialBarMsglistView officialBarMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43470e = officialBarMsglistView;
        }

        @Override // c.a.q0.w.b
        public void onAction(c.a.q0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f43470e.r(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animation f43471b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OfficialBarMsglistView f43472c;

        public c(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarMsglistView, Boolean.valueOf(z), animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43472c = officialBarMsglistView;
            this.a = z;
            this.f43471b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.a) {
                    this.f43472c.f43465g.setVisibility(0);
                    if (this.f43472c.mTool != null) {
                        this.f43472c.mTool.hide();
                    }
                } else {
                    this.f43472c.f43465g.setVisibility(8);
                    if (this.f43472c.mTool != null) {
                        this.f43472c.mTool.display();
                    }
                    for (int i2 = 0; i2 < 3; i2++) {
                        d dVar = this.f43472c.k[i2];
                        if (dVar.a) {
                            dVar.a = false;
                            this.f43472c.s(i2, false);
                            this.f43472c.f43468j.hidePopupWindow();
                        }
                    }
                }
                this.f43472c.getLayoutBottom().startAnimation(this.f43471b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f43473b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f43474c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f43475d;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MsglistActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, talkableActivity, z) == null) {
            super.initHeader(talkableActivity, z);
            String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
            if (string != null) {
                this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
                this.mNavigationBar.showBottomLine();
                TextView textView = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
                this.f43463e = textView;
                textView.setText(string);
            }
            LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
            this.f43465g = linearLayout;
            linearLayout.setVisibility(0);
            ImageView imageView = (ImageView) this.f43465g.findViewById(R.id.official_bar_toggle_button);
            this.f43464f = imageView;
            imageView.setVisibility(0);
            this.k = new d[3];
            d dVar = new d();
            dVar.a = false;
            dVar.f43473b = (LinearLayout) this.f43465g.findViewById(R.id.menu_frist);
            dVar.f43474c = (TextView) this.f43465g.findViewById(R.id.menu_frist_text);
            dVar.f43475d = (ImageView) this.f43465g.findViewById(R.id.menu_frist_tip);
            this.k[0] = dVar;
            d dVar2 = new d();
            dVar2.a = false;
            dVar2.f43473b = (LinearLayout) this.f43465g.findViewById(R.id.menu_second);
            dVar2.f43474c = (TextView) this.f43465g.findViewById(R.id.menu_second_text);
            dVar2.f43475d = (ImageView) this.f43465g.findViewById(R.id.menu_second_tip);
            this.k[1] = dVar2;
            d dVar3 = new d();
            dVar3.a = false;
            dVar3.f43473b = (LinearLayout) this.f43465g.findViewById(R.id.menu_third);
            dVar3.f43474c = (TextView) this.f43465g.findViewById(R.id.menu_third_text);
            dVar3.f43475d = (ImageView) this.f43465g.findViewById(R.id.menu_third_tip);
            this.k[2] = dVar3;
            for (int i2 = 0; i2 < 3; i2++) {
                this.k[i2].f43473b.setOnClickListener(talkableActivity);
            }
            LinearLayout linearLayout2 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
            this.f43466h = linearLayout2;
            linearLayout2.setVisibility(0);
            LinearLayout linearLayout3 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
            this.f43467i = linearLayout3;
            linearLayout3.setVisibility(8);
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.hide();
            }
            this.f43464f.setOnClickListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsgSend(TalkableActivity talkableActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, talkableActivity) == null) {
            EditorTools editorTools = new EditorTools(talkableActivity.getActivity());
            this.mTool = editorTools;
            editorTools.setBarMaxLauCount(1);
            this.mTool.setMoreButtonAtEnd(true);
            this.mTool.setBackgroundColorId(R.color.CAM_X0204);
            this.mTool.setBarBackgroundColorId(R.color.CAM_X0207);
            this.mTool.setDeskBackgroundColorId(R.color.CAM_X0206);
            this.mTool.setMoreDeskBgColorId(R.color.CAM_X0206);
            this.mTool.showLinePositionBottom(true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, m.class, talkableActivity.getActivity());
            if (runTask != null && runTask.getData() != null) {
                m mVar = (m) runTask.getData();
                this.mSendTool = mVar;
                n nVar = mVar.k;
                if (nVar != null && (nVar instanceof ISendVoiceView)) {
                    ISendVoiceView iSendVoiceView = (ISendVoiceView) nVar;
                    this.mSendVoiceView = iSendVoiceView;
                    if (iSendVoiceView instanceof View) {
                        ((View) iSendVoiceView).setOnTouchListener(((AbsMsglistView) this).mContext);
                    }
                }
                m mVar2 = this.mSendTool;
                mVar2.f14006j = 1;
                this.mTool.addTool(mVar2);
            }
            this.mTool.addTool(new c.a.q0.w.r.d(talkableActivity.getActivity(), 2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(6);
            arrayList.add(10);
            arrayList.add(5);
            this.mTool.collect(arrayList);
            m findToolById = this.mTool.findToolById(5);
            if (findToolById != null) {
                findToolById.f14006j = 3;
            }
            c.a.q0.w.s.a aVar = new c.a.q0.w.s.a(talkableActivity.getActivity(), false);
            aVar.g(true);
            n nVar2 = aVar.k;
            if (nVar2 != null && (nVar2 instanceof EditText)) {
                ((EditText) nVar2).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
            }
            this.mTool.addTool(aVar);
            c.a.q0.w.z.a aVar2 = new c.a.q0.w.z.a(talkableActivity.getActivity());
            aVar2.f(R.string.send_msg);
            this.mTool.addTool(aVar2);
            if (this.l) {
                this.mTool.addTool(new c.a.r0.s1.f.j.a(talkableActivity.getActivity()));
            }
            this.mTool.build();
            this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
            this.mTool.setActionListener(24, this.mActionListener);
            this.mTool.setActionListener(8, this.mActionListener);
            this.mTool.setActionListener(4, this.mActionListener);
            this.mTool.setActionListener(14, this.mActionListener);
            if (TbadkCoreApplication.getInst().isFaceShopNew()) {
                this.mTool.sendAction(new c.a.q0.w.a(2, 5, "N"));
            }
            if (this.l) {
                this.mTool.setActionListener(30, new b(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msglistActivity) == null) {
            super.initMsglist(msglistActivity);
            this.f43468j = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
            getListMain().addView(this.f43468j);
            this.f43468j.setVisibility(8);
            this.f43468j.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
            this.l = true;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isFromReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int j(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                if (view == this.k[i2].f43473b) {
                    return i2;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public d[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (d[]) invokeV.objValue;
    }

    public OfficialSecondMenuPopupWindow l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43468j : (OfficialSecondMenuPopupWindow) invokeV.objValue;
    }

    public void m() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewGroup = this.mLayBottom) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void n(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (textView = this.f43463e) == null) {
            return;
        }
        textView.setText(i2);
    }

    public void o(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = this.l;
            if (z3 != z) {
                if (!z3) {
                    this.mTool.display(false);
                    return;
                }
                this.f43465g.setVisibility(0);
                EditorTools editorTools = this.mTool;
                if (editorTools != null) {
                    editorTools.hide();
                }
                this.f43466h.setVisibility(0);
                return;
            }
            this.l = !z;
            if (z) {
                this.f43465g.setVisibility(8);
                EditorTools editorTools2 = this.mTool;
                if (editorTools2 != null) {
                    this.mInputControl.removeView(editorTools2);
                    initMsgSend(((AbsMsglistView) this).mContext);
                    this.mTool.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    if (z2) {
                        this.mTool.display(true);
                    } else {
                        this.mTool.display(false);
                    }
                }
                this.f43466h.setVisibility(8);
                return;
            }
            EditorTools editorTools3 = this.mTool;
            if (editorTools3 != null) {
                this.mInputControl.removeView(editorTools3);
                initMsgSend(((AbsMsglistView) this).mContext);
                this.mTool.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            this.f43465g.setVisibility(0);
            EditorTools editorTools4 = this.mTool;
            if (editorTools4 != null) {
                editorTools4.hide();
            }
            this.f43466h.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.f43463e, R.color.CAM_X0302, 1);
        }
    }

    public void p(List<c.a.r0.s1.g.b> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && list != null && list.size() == 3) {
            for (int i2 = 0; i2 < 3; i2++) {
                c.a.r0.s1.g.b bVar = list.get(i2);
                this.k[i2].f43474c.setText(bVar.d());
                if (bVar.a() != 0) {
                    this.k[i2].f43475d.setVisibility(8);
                }
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f43467i.setVisibility(z ? 0 : 8);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.parent_menu_up);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.parent_menu_down);
            loadAnimation2.setAnimationListener(new c(this, z, loadAnimation));
            sendmsgCloseSoftkey();
            if (isMoreVisible()) {
                hideMore();
            }
            getLayoutBottom().startAnimation(loadAnimation2);
        }
    }

    public void s(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d dVar = this.k[i2];
            if (z) {
                dVar.f43475d.setImageResource(R.drawable.icon_bottombar_arrow_s);
                dVar.f43474c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0302));
                return;
            }
            dVar.f43475d.setImageResource(R.drawable.icon_bottombar_arrow_n);
            dVar.f43474c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0106));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public Map<String, String> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }
}
