package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
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
import com.repackage.g46;
import com.repackage.j15;
import com.repackage.p15;
import com.repackage.w05;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.c, EmotionTabContentView.d, j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionTabContentView a;
    public EmotionTabWidgetView b;
    public View c;
    public ArrayList<p15> d;
    public ArrayList<p15> e;
    public int f;
    public String g;
    public int h;
    public boolean i;
    public boolean j;
    public int k;
    public EditorTools l;
    public int m;
    public CustomMessageListener n;
    public CustomMessageListener o;

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

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHost a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionTabHost emotionTabHost, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921304 || this.a.d.size() < 0) {
                return;
            }
            for (int i = 0; i < this.a.d.size(); i++) {
                if (((p15) this.a.d.get(i)).h() == EmotionGroupType.USER_COLLECT) {
                    this.a.setCurrentEmotionGroup(i);
                    return;
                }
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
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = -1;
        this.g = null;
        this.h = -1;
        this.i = true;
        this.j = true;
        this.k = 0;
        this.m = 0;
        this.n = new a(this, 2001117);
        this.o = new b(this, 2921304);
        h(context);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.c
    public void a(int i) {
        EmotionTabContentView emotionTabContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i < 0 || i >= this.d.size() || i == this.f || (emotionTabContentView = this.a) == null) {
            return;
        }
        emotionTabContentView.B(i);
        this.f = i;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.d
    public void b(int i) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (emotionTabWidgetView = this.b) == null || i == this.f) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i);
        this.f = i;
    }

    @Override // com.repackage.j15
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.b != null) {
                int size = this.d.size();
                for (int i = 0; i < size; i++) {
                    this.b.setTabWidgetVisibility(i, this.i);
                }
                this.b.setTabWidgetBigEmontionVisibility(this.i);
            }
            setVisibility(0);
        }
    }

    public final void f(p15 p15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p15Var) == null) {
            this.b.b(p15Var);
        }
    }

    @Override // com.repackage.j15
    public void g(w05 w05Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, w05Var) == null) || (editorTools = this.l) == null) {
            return;
        }
        editorTools.A(w05Var);
    }

    @Override // com.repackage.j15
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0269, (ViewGroup) this, true);
            this.a = (EmotionTabContentView) findViewById(R.id.obfuscated_res_0x7f09095b);
            this.b = (EmotionTabWidgetView) findViewById(R.id.obfuscated_res_0x7f090961);
            this.c = findViewById(R.id.obfuscated_res_0x7f0908b2);
            this.b.setOnTabSelectedListener(this);
            this.a.setOnEmotionSwitchedListener(this);
            setOrientation(1);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.h = skinType;
            onChangeSkinType(skinType);
        }
    }

    @Override // com.repackage.j15
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    public final ArrayList<p15> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList<p15> arrayList = new ArrayList<>();
            Iterator<p15> it = g46.j().i().iterator();
            while (it.hasNext()) {
                p15 next = it.next();
                if (next.h() != EmotionGroupType.BIG_EMOTION || this.i) {
                    if (next.h() != EmotionGroupType.USER_COLLECT || this.j) {
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.repackage.j15
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f = -1;
            this.d.clear();
            this.a.y();
            this.b.e();
        }
    }

    public final void l() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d = g46.j().i();
            if (this.i && this.j) {
                this.e = g46.j().i();
            } else {
                this.e = i();
                if (!this.j && this.d != null) {
                    this.d = new ArrayList<>(g46.j().i());
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.d.size()) {
                            break;
                        } else if (this.d.get(i2).h() == EmotionGroupType.USER_COLLECT) {
                            this.d.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            ArrayList<p15> arrayList = this.d;
            if ((arrayList == null || arrayList.size() <= 0) && (i = this.k) < 3) {
                this.k = i + 1;
                g46.j().r();
                return;
            }
            this.b.setDatas(this.d);
            int size = this.d.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                p15 p15Var = this.d.get(i4);
                String str = this.g;
                if (str != null && str.equals(p15Var.f())) {
                    i3 = i4;
                }
                f(p15Var);
            }
            setCurrentEmotionGroup(i3);
        }
    }

    @Override // com.repackage.x05
    public void onAction(w05 w05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, w05Var) == null) || w05Var == null) {
            return;
        }
        int i = w05Var.a;
        if (i == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i == 34) {
            Object obj = w05Var.c;
            if (obj instanceof Integer) {
                setFrom(((Integer) obj).intValue());
            }
        } else if (i != 35) {
        } else {
            Object obj2 = w05Var.c;
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<p15> it = this.e.iterator();
                while (it.hasNext()) {
                    p15 next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.a.z(arrayList, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.n);
            MessageManager.getInstance().registerListener(this.o);
        }
    }

    @Override // com.repackage.j15
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b.d(i);
            this.a.w(i);
            SkinManager.setBackgroundColor(this.c, R.color.common_color_10288, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            requestDisallowInterceptTouchEvent(true);
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setCurrentEmotionGroup(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || i < 0 || i >= this.e.size() || i == this.f) {
            return;
        }
        this.a.z(this.e, i);
        this.b.setCurrentTab(i);
        this.f = i;
        this.g = this.e.get(i).f();
    }

    @Override // com.repackage.j15
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.l = editorTools;
            this.a.setOnDataSelected(editorTools);
            this.b.setOnDataSelected(editorTools);
        }
    }

    public void setFrom(int i) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (emotionTabWidgetView = this.b) == null) {
            return;
        }
        emotionTabWidgetView.setFrom(i);
    }

    public void setShowBigEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.i = z;
        }
    }

    public void setShowUserCollect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.j = z;
        }
    }

    @Override // com.repackage.j15
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
            if (skinType != this.h) {
                this.h = skinType;
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
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = -1;
        this.g = null;
        this.h = -1;
        this.i = true;
        this.j = true;
        this.k = 0;
        this.m = 0;
        this.n = new a(this, 2001117);
        this.o = new b(this, 2921304);
        h(context);
    }
}
