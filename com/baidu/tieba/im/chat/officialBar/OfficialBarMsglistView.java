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
import c.a.o0.w.m;
import c.a.o0.w.n;
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
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33731b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f33732c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f33733d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f33734e;

    /* renamed from: f  reason: collision with root package name */
    public OfficialSecondMenuPopupWindow f33735f;

    /* renamed from: g  reason: collision with root package name */
    public d[] f33736g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33737h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarMsglistView a;

        public a(OfficialBarMsglistView officialBarMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarMsglistView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.t(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarMsglistView a;

        public b(OfficialBarMsglistView officialBarMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarMsglistView;
        }

        @Override // c.a.o0.w.b
        public void onAction(c.a.o0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.t(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animation f33738b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OfficialBarMsglistView f33739c;

        public c(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarMsglistView, Boolean.valueOf(z), animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33739c = officialBarMsglistView;
            this.a = z;
            this.f33738b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.a) {
                    this.f33739c.f33732c.setVisibility(0);
                    if (this.f33739c.mTool != null) {
                        this.f33739c.mTool.o();
                    }
                } else {
                    this.f33739c.f33732c.setVisibility(8);
                    if (this.f33739c.mTool != null) {
                        this.f33739c.mTool.j();
                    }
                    for (int i = 0; i < 3; i++) {
                        d dVar = this.f33739c.f33736g[i];
                        if (dVar.a) {
                            dVar.a = false;
                            this.f33739c.u(i, false);
                            this.f33739c.f33735f.g();
                        }
                    }
                }
                this.f33739c.getLayoutBottom().startAnimation(this.f33738b);
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
        public LinearLayout f33740b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f33741c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f33742d;

        public d() {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MsglistActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33737h = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, talkableActivity, z) == null) {
            super.initHeader(talkableActivity, z);
            String string = talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0650);
            if (string != null) {
                this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d038d, talkableActivity);
                this.mNavigationBar.showBottomLine();
                TextView textView = (TextView) this.mBtnGroupInfo.findViewById(R.id.obfuscated_res_0x7f090cf6);
                this.a = textView;
                textView.setText(string);
            }
            LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f0915ee)).inflate();
            this.f33732c = linearLayout;
            linearLayout.setVisibility(0);
            ImageView imageView = (ImageView) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0915f2);
            this.f33731b = imageView;
            imageView.setVisibility(0);
            this.f33736g = new d[3];
            d dVar = new d();
            dVar.a = false;
            dVar.f33740b = (LinearLayout) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913ec);
            dVar.f33741c = (TextView) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913ed);
            dVar.f33742d = (ImageView) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913ee);
            this.f33736g[0] = dVar;
            d dVar2 = new d();
            dVar2.a = false;
            dVar2.f33740b = (LinearLayout) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913f4);
            dVar2.f33741c = (TextView) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913f5);
            dVar2.f33742d = (ImageView) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913f6);
            this.f33736g[1] = dVar2;
            d dVar3 = new d();
            dVar3.a = false;
            dVar3.f33740b = (LinearLayout) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913f7);
            dVar3.f33741c = (TextView) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913f8);
            dVar3.f33742d = (ImageView) this.f33732c.findViewById(R.id.obfuscated_res_0x7f0913f9);
            this.f33736g[2] = dVar3;
            for (int i = 0; i < 3; i++) {
                this.f33736g[i].f33740b.setOnClickListener(talkableActivity);
            }
            LinearLayout linearLayout2 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f0915ed)).inflate();
            this.f33733d = linearLayout2;
            linearLayout2.setVisibility(0);
            LinearLayout linearLayout3 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f0915ef)).inflate();
            this.f33734e = linearLayout3;
            linearLayout3.setVisibility(8);
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.o();
            }
            this.f33731b.setOnClickListener(new a(this));
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
            this.mTool.C(true);
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
                mVar2.j = 1;
                this.mTool.d(mVar2);
            }
            this.mTool.d(new c.a.o0.w.r.d(talkableActivity.getActivity(), 2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(6);
            arrayList.add(10);
            arrayList.add(5);
            this.mTool.h(arrayList);
            m n = this.mTool.n(5);
            if (n != null) {
                n.j = 3;
            }
            c.a.o0.w.s.a aVar = new c.a.o0.w.s.a(talkableActivity.getActivity(), false);
            aVar.g(true);
            n nVar2 = aVar.k;
            if (nVar2 != null && (nVar2 instanceof EditText)) {
                ((EditText) nVar2).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f));
            }
            this.mTool.d(aVar);
            c.a.o0.w.z.a aVar2 = new c.a.o0.w.z.a(talkableActivity.getActivity());
            aVar2.f(R.string.obfuscated_res_0x7f0f10e0);
            this.mTool.d(aVar2);
            if (this.f33737h) {
                this.mTool.d(new c.a.p0.u1.f.j.a(talkableActivity.getActivity()));
            }
            this.mTool.f();
            this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
            this.mTool.setActionListener(24, this.mActionListener);
            this.mTool.setActionListener(8, this.mActionListener);
            this.mTool.setActionListener(4, this.mActionListener);
            this.mTool.setActionListener(14, this.mActionListener);
            if (TbadkCoreApplication.getInst().isFaceShopNew()) {
                this.mTool.A(new c.a.o0.w.a(2, 5, "N"));
            }
            if (this.f33737h) {
                this.mTool.setActionListener(30, new b(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msglistActivity) == null) {
            super.initMsglist(msglistActivity);
            this.f33735f = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
            getListMain().addView(this.f33735f);
            this.f33735f.setVisibility(8);
            this.f33735f.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
            this.f33737h = true;
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

    public int l(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            for (int i = 0; i < 3; i++) {
                if (view == this.f33736g[i].f33740b) {
                    return i;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public d[] m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33736g : (d[]) invokeV.objValue;
    }

    public OfficialSecondMenuPopupWindow n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33735f : (OfficialSecondMenuPopupWindow) invokeV.objValue;
    }

    public void o() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewGroup = this.mLayBottom) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.a, R.color.CAM_X0302, 1);
        }
    }

    public void p(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || (textView = this.a) == null) {
            return;
        }
        textView.setText(i);
    }

    public void q(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = this.f33737h;
            if (z3 != z) {
                if (!z3) {
                    this.mTool.k(false);
                    return;
                }
                this.f33732c.setVisibility(0);
                EditorTools editorTools = this.mTool;
                if (editorTools != null) {
                    editorTools.o();
                }
                this.f33733d.setVisibility(0);
                return;
            }
            this.f33737h = !z;
            if (z) {
                this.f33732c.setVisibility(8);
                EditorTools editorTools2 = this.mTool;
                if (editorTools2 != null) {
                    this.mInputControl.removeView(editorTools2);
                    initMsgSend(((AbsMsglistView) this).mContext);
                    this.mTool.w(TbadkCoreApplication.getInst().getSkinType());
                    if (z2) {
                        this.mTool.k(true);
                    } else {
                        this.mTool.k(false);
                    }
                }
                this.f33733d.setVisibility(8);
                return;
            }
            EditorTools editorTools3 = this.mTool;
            if (editorTools3 != null) {
                this.mInputControl.removeView(editorTools3);
                initMsgSend(((AbsMsglistView) this).mContext);
                this.mTool.w(TbadkCoreApplication.getInst().getSkinType());
            }
            this.f33732c.setVisibility(0);
            EditorTools editorTools4 = this.mTool;
            if (editorTools4 != null) {
                editorTools4.o();
            }
            this.f33733d.setVisibility(0);
        }
    }

    public void r(List<c.a.p0.u1.g.b> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                c.a.p0.u1.g.b bVar = list.get(i);
                this.f33736g[i].f33741c.setText(bVar.d());
                if (bVar.a() != 0) {
                    this.f33736g[i].f33742d.setVisibility(8);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f33734e.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public ArrayList<ReportPrivateMsgData> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f0100b5);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f0100b4);
            loadAnimation2.setAnimationListener(new c(this, z, loadAnimation));
            sendmsgCloseSoftkey();
            if (isMoreVisible()) {
                hideMore();
            }
            getLayoutBottom().startAnimation(loadAnimation2);
        }
    }

    public void u(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            d dVar = this.f33736g[i];
            if (z) {
                dVar.f33742d.setImageResource(R.drawable.obfuscated_res_0x7f0806a4);
                dVar.f33741c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0302));
                return;
            }
            dVar.f33742d.setImageResource(R.drawable.obfuscated_res_0x7f0806a3);
            dVar.f33741c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0106));
        }
    }
}
