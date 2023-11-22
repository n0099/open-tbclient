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
import com.baidu.searchbox.player.model.YYOption;
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
import com.baidu.tieba.me5;
import com.baidu.tieba.rw6;
import com.baidu.tieba.se5;
import com.baidu.tieba.yd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
/* loaded from: classes5.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.b, EmotionTabContentView.j, me5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionTabContentView a;
    public EmotionTabWidgetView b;
    public ArrayList<se5> c;
    public ArrayList<se5> d;
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

    /* loaded from: classes5.dex */
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
                this.a.h();
                this.a.i();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHost a;

        public b(EmotionTabHost emotionTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("status", YYOption.IsLive.VALUE_TRUE);
                hashMap.put("containerHeight", String.valueOf(this.a.getHeight()));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921776, hashMap));
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
        e(context);
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            setOrientation(1);
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02bb, (ViewGroup) this, true);
            this.a = (EmotionTabContentView) findViewById(R.id.obfuscated_res_0x7f090b0b);
            EmotionTabWidgetView emotionTabWidgetView = (EmotionTabWidgetView) findViewById(R.id.obfuscated_res_0x7f090b10);
            this.b = emotionTabWidgetView;
            emotionTabWidgetView.setOnTabSelectedListener(this);
            this.a.setOnEmotionSwitchedListener(this);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.g = skinType;
            onChangeSkinType(skinType);
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
        e(context);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.b
    public void a(int i) {
        EmotionTabContentView emotionTabContentView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i >= 0 && i < this.c.size() && i != this.e && (emotionTabContentView = this.a) != null) {
            emotionTabContentView.R(i);
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.j
    public void b(int i) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (emotionTabWidgetView = this.b) != null && i != this.e) {
            emotionTabWidgetView.setCurrentTab(i);
            this.e = i;
        }
    }

    public final void d(se5 se5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, se5Var) == null) {
            this.b.b(se5Var);
        }
    }

    @Override // com.baidu.tieba.me5
    public void g0(yd5 yd5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yd5Var) == null) && (editorTools = this.l) != null) {
            editorTools.K(yd5Var);
        }
    }

    @Override // com.baidu.tieba.me5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b.d(i);
            this.a.K(i);
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

    @Override // com.baidu.tieba.me5
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

    @Override // com.baidu.tieba.me5
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

    @Override // com.baidu.tieba.zd5
    public void S(yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, yd5Var) != null) || yd5Var == null) {
            return;
        }
        int i = yd5Var.a;
        if (i != 1) {
            if (i == 35) {
                Object obj = yd5Var.c;
                if (obj instanceof Boolean) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    setShowBigEmotion(booleanValue);
                    if (!booleanValue) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<se5> it = this.d.iterator();
                        while (it.hasNext()) {
                            se5 next = it.next();
                            if (next != null && next.j()) {
                                arrayList.add(next);
                            }
                        }
                        this.a.O(arrayList, 0);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
    }

    @Override // com.baidu.tieba.me5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.b != null) {
                int size = this.c.size();
                for (int i = 0; i < size; i++) {
                    this.b.setTabWidgetVisibility(i, this.h);
                }
                this.b.setTabWidgetBigEmontionVisibility(this.h);
            }
            post(new b(this));
            EmotionTabContentView emotionTabContentView = this.a;
            if (emotionTabContentView != null) {
                emotionTabContentView.M();
            }
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.me5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (getVisibility() == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("status", "false");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921776, hashMap));
            }
            setVisibility(8);
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || i < 0 || i >= this.d.size() || i == this.e) {
            return;
        }
        this.a.O(this.d, i);
        this.b.setCurrentTab(i);
        this.e = i;
        this.f = this.d.get(i).f();
    }

    public final ArrayList<se5> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList<se5> arrayList = new ArrayList<>();
            Iterator<se5> it = rw6.k().i().iterator();
            while (it.hasNext()) {
                se5 next = it.next();
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

    @Override // com.baidu.tieba.me5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = -1;
            this.c.clear();
            this.a.N();
            this.b.e();
        }
    }

    @Override // com.baidu.tieba.me5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            i();
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    public final void i() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c = rw6.k().i();
            if (this.h && this.i && this.j) {
                this.d = rw6.k().i();
            } else {
                this.d = g();
                if ((!this.i || !this.j) && this.c != null) {
                    ArrayList<se5> arrayList = new ArrayList<>(rw6.k().i());
                    this.c = arrayList;
                    ListIterator<se5> listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        se5 next = listIterator.next();
                        if (next.h() == EmotionGroupType.USER_COLLECT && !this.i) {
                            listIterator.remove();
                        }
                        if (next.h() == EmotionGroupType.USER_DIY && !this.j) {
                            listIterator.remove();
                        }
                    }
                }
            }
            ArrayList<se5> arrayList2 = this.c;
            if ((arrayList2 == null || arrayList2.size() <= 0) && (i = this.k) < 3) {
                this.k = i + 1;
                rw6.k().v();
                return;
            }
            this.b.setDatas(this.c);
            int size = this.c.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                se5 se5Var = this.c.get(i3);
                String str = this.f;
                if (str != null && str.equals(se5Var.f())) {
                    i2 = i3;
                }
                d(se5Var);
            }
            f(i2);
        }
    }
}
