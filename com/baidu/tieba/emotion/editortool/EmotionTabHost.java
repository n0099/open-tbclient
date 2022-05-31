package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f05;
import com.repackage.l05;
import com.repackage.s26;
import com.repackage.sz4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
/* loaded from: classes3.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.b, EmotionTabContentView.h, f05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionTabContentView a;
    public EmotionTabWidgetView b;
    public ArrayList<l05> c;
    public ArrayList<l05> d;
    public int e;
    public String f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public EditorTools l;
    public int m;
    public CustomMessageListener n;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionTabHost emotionTabHost, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHost, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001117) {
                this.a.j();
                this.a.l();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHost(Context context) {
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
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = 0;
        this.m = 0;
        this.n = new a(this, 2001117);
        f(context);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.b
    public void a(int i) {
        EmotionTabContentView emotionTabContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i < 0 || i >= this.c.size() || i == this.e || (emotionTabContentView = this.a) == null) {
            return;
        }
        emotionTabContentView.K(i);
        this.e = i;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.h
    public void b(int i) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (emotionTabWidgetView = this.b) == null || i == this.e) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i);
        this.e = i;
    }

    public final void d(l05 l05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l05Var) == null) {
            this.b.b(l05Var);
        }
    }

    @Override // com.repackage.f05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.b != null) {
                int size = this.c.size();
                for (int i = 0; i < size; i++) {
                    this.b.setTabWidgetVisibility(i, this.h);
                }
                this.b.setTabWidgetBigEmontionVisibility(this.h);
            }
            setVisibility(0);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            setOrientation(1);
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0264, (ViewGroup) this, true);
            this.a = (EmotionTabContentView) findViewById(R.id.obfuscated_res_0x7f090946);
            EmotionTabWidgetView emotionTabWidgetView = (EmotionTabWidgetView) findViewById(R.id.obfuscated_res_0x7f09094b);
            this.b = emotionTabWidgetView;
            emotionTabWidgetView.setOnTabSelectedListener(this);
            this.a.setOnEmotionSwitchedListener(this);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.g = skinType;
            onChangeSkinType(skinType);
        }
    }

    @Override // com.repackage.f05
    public void g(sz4 sz4Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, sz4Var) == null) || (editorTools = this.l) == null) {
            return;
        }
        editorTools.A(sz4Var);
    }

    @Override // com.repackage.f05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m : invokeV.intValue;
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || i < 0 || i >= this.d.size() || i == this.e) {
            return;
        }
        this.a.I(this.d, i);
        this.b.setCurrentTab(i);
        this.e = i;
        this.f = this.d.get(i).f();
    }

    @Override // com.repackage.f05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
        }
    }

    public final ArrayList<l05> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList<l05> arrayList = new ArrayList<>();
            Iterator<l05> it = s26.k().i().iterator();
            while (it.hasNext()) {
                l05 next = it.next();
                if (next.h() != EmotionGroupType.BIG_EMOTION || this.h) {
                    if (next.h() != EmotionGroupType.USER_COLLECT || this.i) {
                        if (next.h() != EmotionGroupType.USER_DIY || this.j) {
                            arrayList.add(next);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.repackage.f05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            l();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e = -1;
            this.c.clear();
            this.a.H();
            this.b.e();
        }
    }

    public final void l() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c = s26.k().i();
            if (this.h && this.i && this.j) {
                this.d = s26.k().i();
            } else {
                this.d = i();
                if ((!this.i || !this.j) && this.c != null) {
                    ArrayList<l05> arrayList = new ArrayList<>(s26.k().i());
                    this.c = arrayList;
                    ListIterator<l05> listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        l05 next = listIterator.next();
                        if (next.h() == EmotionGroupType.USER_COLLECT && !this.i) {
                            listIterator.remove();
                        }
                        if (next.h() == EmotionGroupType.USER_DIY && !this.j) {
                            listIterator.remove();
                        }
                    }
                }
            }
            ArrayList<l05> arrayList2 = this.c;
            if ((arrayList2 == null || arrayList2.size() <= 0) && (i = this.k) < 3) {
                this.k = i + 1;
                s26.k().v();
                return;
            }
            this.b.setDatas(this.c);
            int size = this.c.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                l05 l05Var = this.c.get(i3);
                String str = this.f;
                if (str != null && str.equals(l05Var.f())) {
                    i2 = i3;
                }
                d(l05Var);
            }
            h(i2);
        }
    }

    @Override // com.repackage.tz4
    public void onAction(sz4 sz4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, sz4Var) == null) || sz4Var == null) {
            return;
        }
        int i = sz4Var.a;
        if (i == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i != 35) {
        } else {
            Object obj = sz4Var.c;
            if (obj instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<l05> it = this.d.iterator();
                while (it.hasNext()) {
                    l05 next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.a.I(arrayList, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    @Override // com.repackage.f05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b.d(i);
            this.a.F(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            requestDisallowInterceptTouchEvent(true);
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.f05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.l = editorTools;
            this.a.setOnDataSelected(editorTools);
            this.b.setOnDataSelected(editorTools);
        }
    }

    public void setShowBigEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.h = z;
        }
    }

    public void setShowDiyEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.j = z;
        }
    }

    public void setShowUserCollect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.i = z;
        }
    }

    @Override // com.repackage.f05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.m = i;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            super.setVisibility(i);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != this.g) {
                this.g = skinType;
                onChangeSkinType(skinType);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabHost(Context context, AttributeSet attributeSet) {
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
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = 0;
        this.m = 0;
        this.n = new a(this, 2001117);
        f(context);
    }
}
