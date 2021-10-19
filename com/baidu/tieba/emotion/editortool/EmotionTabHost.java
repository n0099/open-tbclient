package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.x.n;
import c.a.q0.x.p.c;
import c.a.r0.n0.b.e;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.c, EmotionTabContentView.d, n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabContentView f50160e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionTabWidgetView f50161f;

    /* renamed from: g  reason: collision with root package name */
    public View f50162g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f50163h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c> f50164i;

    /* renamed from: j  reason: collision with root package name */
    public int f50165j;
    public String k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public EditorTools p;
    public int q;
    public CustomMessageListener r;
    public CustomMessageListener s;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHost f50166a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmotionTabHost emotionTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50166a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001117) {
                this.f50166a.reset();
                this.f50166a.f();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHost f50167a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionTabHost emotionTabHost, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabHost, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50167a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921304 || this.f50167a.f50163h.size() < 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f50167a.f50163h.size(); i2++) {
                if (((c) this.f50167a.f50163h.get(i2)).h() == EmotionGroupType.USER_COLLECT) {
                    this.f50167a.setCurrentEmotionGroup(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50163h = new ArrayList<>();
        this.f50164i = new ArrayList<>();
        this.f50165j = -1;
        this.k = null;
        this.l = -1;
        this.m = true;
        this.n = true;
        this.o = 0;
        this.q = 0;
        this.r = new a(this, 2001117);
        this.s = new b(this, 2921304);
        d(context);
    }

    public final void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f50161f.addTabWidget(cVar);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
            this.f50160e = (EmotionTabContentView) findViewById(R.id.face_tab_content);
            this.f50161f = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
            this.f50162g = findViewById(R.id.emotion_tab_widget_div_line);
            this.f50161f.setOnTabSelectedListener(this);
            this.f50160e.setOnEmotionSwitchedListener(this);
            setOrientation(1);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.l = skinType;
            onChangeSkinType(skinType);
        }
    }

    @Override // c.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f50161f != null) {
                int size = this.f50163h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f50161f.setTabWidgetVisibility(i2, this.m);
                }
                this.f50161f.setTabWidgetBigEmontionVisibility(this.m);
            }
            setVisibility(0);
        }
    }

    public final ArrayList<c> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<c> arrayList = new ArrayList<>();
            Iterator<c> it = e.i().h().iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.h() != EmotionGroupType.BIG_EMOTION || this.m) {
                    if (next.h() != EmotionGroupType.USER_COLLECT || this.n) {
                        arrayList.add(next);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void f() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f50163h = e.i().h();
            if (this.m && this.n) {
                this.f50164i = e.i().h();
            } else {
                this.f50164i = e();
                if (!this.n && this.f50163h != null) {
                    this.f50163h = new ArrayList<>(e.i().h());
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.f50163h.size()) {
                            break;
                        } else if (this.f50163h.get(i3).h() == EmotionGroupType.USER_COLLECT) {
                            this.f50163h.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f50163h;
            if ((arrayList == null || arrayList.size() <= 0) && (i2 = this.o) < 3) {
                this.o = i2 + 1;
                e.i().q();
                return;
            }
            this.f50161f.setDatas(this.f50163h);
            int size = this.f50163h.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                c cVar = this.f50163h.get(i5);
                String str = this.k;
                if (str != null && str.equals(cVar.f())) {
                    i4 = i5;
                }
                c(cVar);
            }
            setCurrentEmotionGroup(i4);
        }
    }

    @Override // c.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.intValue;
    }

    @Override // c.a.q0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            f();
        }
    }

    @Override // c.a.q0.x.b
    public void onAction(c.a.q0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f15109a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i2 == 34) {
            Object obj = aVar.f15111c;
            if (obj instanceof Integer) {
                setFrom(((Integer) obj).intValue());
            }
        } else if (i2 != 35) {
        } else {
            Object obj2 = aVar.f15111c;
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = this.f50164i.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.f50160e.showAllPackages(arrayList, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.s);
        }
    }

    @Override // c.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f50161f.onChangeSkinType(i2);
            this.f50160e.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f50162g, R.color.common_color_10288, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
        }
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.d
    public void onEmotionSwitched(int i2) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (emotionTabWidgetView = this.f50161f) == null || i2 == this.f50165j) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i2);
        this.f50165j = i2;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            requestDisallowInterceptTouchEvent(true);
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.c
    public void onTabSelected(int i2) {
        EmotionTabContentView emotionTabContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || i2 < 0 || i2 >= this.f50163h.size() || i2 == this.f50165j || (emotionTabContentView = this.f50160e) == null) {
            return;
        }
        emotionTabContentView.toEmotionPage(i2);
        this.f50165j = i2;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f50165j = -1;
            this.f50163h.clear();
            this.f50160e.reset();
            this.f50161f.reset();
        }
    }

    @Override // c.a.q0.x.n
    public void sendAction(c.a.q0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || (editorTools = this.p) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    public void setCurrentEmotionGroup(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 < 0 || i2 >= this.f50164i.size() || i2 == this.f50165j) {
            return;
        }
        this.f50160e.showAllPackages(this.f50164i, i2);
        this.f50161f.setCurrentTab(i2);
        this.f50165j = i2;
        this.k = this.f50164i.get(i2).f();
    }

    @Override // c.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.p = editorTools;
            this.f50160e.setOnDataSelected(editorTools);
            this.f50161f.setOnDataSelected(editorTools);
        }
    }

    public void setFrom(int i2) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (emotionTabWidgetView = this.f50161f) == null) {
            return;
        }
        emotionTabWidgetView.setFrom(i2);
    }

    public void setShowBigEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.m = z;
        }
    }

    public void setShowUserCollect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.n = z;
        }
    }

    @Override // c.a.q0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.q = i2;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            super.setVisibility(i2);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != this.l) {
                this.l = skinType;
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
        this.f50163h = new ArrayList<>();
        this.f50164i = new ArrayList<>();
        this.f50165j = -1;
        this.k = null;
        this.l = -1;
        this.m = true;
        this.n = true;
        this.o = 0;
        this.q = 0;
        this.r = new a(this, 2001117);
        this.s = new b(this, 2921304);
        d(context);
    }
}
