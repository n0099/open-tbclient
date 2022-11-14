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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.g75;
import com.baidu.tieba.h75;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import com.baidu.tieba.k65;
import com.baidu.tieba.l65;
import com.baidu.tieba.lb7;
import com.baidu.tieba.ta7;
import com.baidu.tieba.u85;
import com.baidu.tieba.v65;
import com.baidu.tieba.w65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public LinearLayout c;
    public LinearLayout d;
    public LinearLayout e;
    public OfficialSecondMenuPopupWindow f;
    public d[] g;
    public boolean h;

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

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public ArrayList<ReportPrivateMsgData> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l65 {
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

        @Override // com.baidu.tieba.l65
        public void B(k65 k65Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k65Var) == null) {
                this.a.y(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Animation b;
        public final /* synthetic */ OfficialBarMsglistView c;

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
            this.c = officialBarMsglistView;
            this.a = z;
            this.b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.a) {
                    this.c.c.setVisibility(0);
                    if (this.c.mTool != null) {
                        this.c.mTool.o();
                    }
                } else {
                    this.c.c.setVisibility(8);
                    if (this.c.mTool != null) {
                        this.c.mTool.j();
                    }
                    for (int i = 0; i < 3; i++) {
                        d dVar = this.c.g[i];
                        if (dVar.a) {
                            dVar.a = false;
                            this.c.z(i, false);
                            this.c.f.g();
                        }
                    }
                }
                this.c.getLayoutBottom().startAnimation(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public LinearLayout b;
        public TextView c;
        public ImageView d;

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
        this.h = true;
    }

    public void z(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            d dVar = this.g[i];
            if (z) {
                dVar.d.setImageResource(R.drawable.obfuscated_res_0x7f0806b4);
                dVar.c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0302));
                return;
            }
            dVar.d.setImageResource(R.drawable.obfuscated_res_0x7f0806b3);
            dVar.c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0106));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.a, R.color.CAM_X0302, 1);
        }
    }

    public int q(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            for (int i = 0; i < 3; i++) {
                if (view2 == this.g[i].b) {
                    return i;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void u(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (textView = this.a) != null) {
            textView.setText(i);
        }
    }

    public void x(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            LinearLayout linearLayout = this.e;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, talkableActivity, z) == null) {
            super.initHeader(talkableActivity, z);
            String string = talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f068f);
            if (string != null) {
                this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0387, talkableActivity);
                this.mNavigationBar.showBottomLine();
                TextView textView = (TextView) this.mBtnGroupInfo.findViewById(R.id.obfuscated_res_0x7f090d2c);
                this.a = textView;
                textView.setText(string);
            }
            LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091763)).inflate();
            this.c = linearLayout;
            linearLayout.setVisibility(0);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091767);
            this.b = imageView;
            imageView.setVisibility(0);
            this.g = new d[3];
            d dVar = new d();
            dVar.a = false;
            dVar.b = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09153e);
            dVar.c = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09153f);
            dVar.d = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091540);
            this.g[0] = dVar;
            d dVar2 = new d();
            dVar2.a = false;
            dVar2.b = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091546);
            dVar2.c = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091547);
            dVar2.d = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091548);
            this.g[1] = dVar2;
            d dVar3 = new d();
            dVar3.a = false;
            dVar3.b = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091549);
            dVar3.c = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09154a);
            dVar3.d = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09154b);
            this.g[2] = dVar3;
            for (int i = 0; i < 3; i++) {
                this.g[i].b.setOnClickListener(talkableActivity);
            }
            LinearLayout linearLayout2 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091762)).inflate();
            this.d = linearLayout2;
            linearLayout2.setVisibility(0);
            LinearLayout linearLayout3 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091764)).inflate();
            this.e = linearLayout3;
            linearLayout3.setVisibility(8);
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.o();
            }
            this.b.setOnClickListener(new a(this));
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, v65.class, talkableActivity.getActivity());
            if (runTask != null && runTask.getData() != null) {
                v65 v65Var = (v65) runTask.getData();
                this.mSendTool = v65Var;
                w65 w65Var = v65Var.m;
                if (w65Var != null && (w65Var instanceof ISendVoiceView)) {
                    ISendVoiceView iSendVoiceView = (ISendVoiceView) w65Var;
                    this.mSendVoiceView = iSendVoiceView;
                    if (iSendVoiceView instanceof View) {
                        ((View) iSendVoiceView).setOnTouchListener(((AbsMsglistView) this).mContext);
                    }
                }
                v65 v65Var2 = this.mSendTool;
                v65Var2.l = 1;
                this.mTool.d(v65Var2);
            }
            this.mTool.d(new g75(talkableActivity.getActivity(), 2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(6);
            arrayList.add(10);
            arrayList.add(5);
            this.mTool.h(arrayList);
            v65 n = this.mTool.n(5);
            if (n != null) {
                n.l = 3;
            }
            h75 h75Var = new h75(talkableActivity.getActivity(), false);
            h75Var.h(true);
            w65 w65Var2 = h75Var.m;
            if (w65Var2 != null && (w65Var2 instanceof EditText)) {
                ((EditText) w65Var2).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f));
            }
            this.mTool.d(h75Var);
            u85 u85Var = new u85(talkableActivity.getActivity());
            u85Var.g(R.string.obfuscated_res_0x7f0f1160);
            this.mTool.d(u85Var);
            if (this.h) {
                this.mTool.d(new ta7(talkableActivity.getActivity()));
            }
            this.mTool.f();
            this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
            this.mTool.setActionListener(24, this.mActionListener);
            this.mTool.setActionListener(8, this.mActionListener);
            this.mTool.setActionListener(4, this.mActionListener);
            this.mTool.setActionListener(14, this.mActionListener);
            if (TbadkCoreApplication.getInst().isFaceShopNew()) {
                this.mTool.A(new k65(2, 5, "N"));
            }
            if (this.h) {
                this.mTool.setActionListener(30, new b(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msglistActivity) == null) {
            super.initMsglist(msglistActivity);
            this.f = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
            getListMain().addView(this.f);
            this.f.setVisibility(8);
            this.f.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
            this.h = true;
        }
    }

    public void w(List<lb7> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                lb7 lb7Var = list.get(i);
                this.g[i].c.setText(lb7Var.d());
                if (lb7Var.a() != 0) {
                    this.g[i].d.setVisibility(8);
                }
            }
        }
    }

    public d[] r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (d[]) invokeV.objValue;
    }

    public OfficialSecondMenuPopupWindow s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (OfficialSecondMenuPopupWindow) invokeV.objValue;
    }

    public void t() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (viewGroup = this.mLayBottom) != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void v(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = this.h;
            if (z3 != z) {
                if (!z3) {
                    this.mTool.k(false, true);
                    return;
                }
                this.c.setVisibility(0);
                EditorTools editorTools = this.mTool;
                if (editorTools != null) {
                    editorTools.o();
                }
                this.d.setVisibility(0);
                return;
            }
            this.h = !z;
            if (z) {
                this.c.setVisibility(8);
                EditorTools editorTools2 = this.mTool;
                if (editorTools2 != null) {
                    this.mInputControl.removeView(editorTools2);
                    initMsgSend(((AbsMsglistView) this).mContext);
                    this.mTool.w(TbadkCoreApplication.getInst().getSkinType());
                    if (z2) {
                        this.mTool.k(true, true);
                    } else {
                        this.mTool.k(false, true);
                    }
                }
                this.d.setVisibility(8);
                return;
            }
            EditorTools editorTools3 = this.mTool;
            if (editorTools3 != null) {
                this.mInputControl.removeView(editorTools3);
                initMsgSend(((AbsMsglistView) this).mContext);
                this.mTool.w(TbadkCoreApplication.getInst().getSkinType());
            }
            this.c.setVisibility(0);
            EditorTools editorTools4 = this.mTool;
            if (editorTools4 != null) {
                editorTools4.o();
            }
            this.d.setVisibility(0);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f0100c2);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f0100c1);
            loadAnimation2.setAnimationListener(new c(this, z, loadAnimation));
            sendmsgCloseSoftkey();
            if (isMoreVisible()) {
                hideMore();
            }
            getLayoutBottom().startAnimation(loadAnimation2);
        }
    }
}
