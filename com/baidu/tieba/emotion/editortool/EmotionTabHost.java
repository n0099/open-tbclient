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
import d.a.r0.w.n;
import d.a.r0.w.p.c;
import d.a.s0.k0.b.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.c, EmotionTabContentView.d, n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabContentView f14576e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionTabWidgetView f14577f;

    /* renamed from: g  reason: collision with root package name */
    public View f14578g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f14579h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c> f14580i;
    public int j;
    public String k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public EditorTools p;
    public int q;
    public CustomMessageListener r;
    public CustomMessageListener s;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHost f14581a;

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
            this.f14581a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001117) {
                this.f14581a.k();
                this.f14581a.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHost f14582a;

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
            this.f14582a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921304 || this.f14582a.f14579h.size() < 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f14582a.f14579h.size(); i2++) {
                if (((c) this.f14582a.f14579h.get(i2)).h() == EmotionGroupType.USER_COLLECT) {
                    this.f14582a.setCurrentEmotionGroup(i2);
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
        this.f14579h = new ArrayList<>();
        this.f14580i = new ArrayList<>();
        this.j = -1;
        this.k = null;
        this.l = -1;
        this.m = true;
        this.n = true;
        this.o = 0;
        this.q = 0;
        this.r = new a(this, 2001117);
        this.s = new b(this, 2921304);
        i(context);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.c
    public void a(int i2) {
        EmotionTabContentView emotionTabContentView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 < 0 || i2 >= this.f14579h.size() || i2 == this.j || (emotionTabContentView = this.f14576e) == null) {
            return;
        }
        emotionTabContentView.B(i2);
        this.j = i2;
    }

    @Override // d.a.r0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f14577f != null) {
                int size = this.f14579h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f14577f.setTabWidgetVisibility(i2, this.m);
                }
                this.f14577f.setTabWidgetBigEmontionVisibility(this.m);
            }
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.d
    public void c(int i2) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (emotionTabWidgetView = this.f14577f) == null || i2 == this.j) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i2);
        this.j = i2;
    }

    @Override // d.a.r0.w.n
    public void d(d.a.r0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (editorTools = this.p) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    @Override // d.a.r0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : invokeV.intValue;
    }

    public final void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f14577f.b(cVar);
        }
    }

    @Override // d.a.r0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
            this.f14576e = (EmotionTabContentView) findViewById(R.id.face_tab_content);
            this.f14577f = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
            this.f14578g = findViewById(R.id.emotion_tab_widget_div_line);
            this.f14577f.setOnTabSelectedListener(this);
            this.f14576e.setOnEmotionSwitchedListener(this);
            setOrientation(1);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.l = skinType;
            onChangeSkinType(skinType);
        }
    }

    @Override // d.a.r0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            l();
        }
    }

    public final ArrayList<c> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.j = -1;
            this.f14579h.clear();
            this.f14576e.y();
            this.f14577f.e();
        }
    }

    public final void l() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f14579h = e.i().h();
            if (this.m && this.n) {
                this.f14580i = e.i().h();
            } else {
                this.f14580i = j();
                if (!this.n && this.f14579h != null) {
                    this.f14579h = new ArrayList<>(e.i().h());
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.f14579h.size()) {
                            break;
                        } else if (this.f14579h.get(i3).h() == EmotionGroupType.USER_COLLECT) {
                            this.f14579h.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f14579h;
            if ((arrayList == null || arrayList.size() <= 0) && (i2 = this.o) < 3) {
                this.o = i2 + 1;
                e.i().q();
                return;
            }
            this.f14577f.setDatas(this.f14579h);
            int size = this.f14579h.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                c cVar = this.f14579h.get(i5);
                String str = this.k;
                if (str != null && str.equals(cVar.f())) {
                    i4 = i5;
                }
                h(cVar);
            }
            setCurrentEmotionGroup(i4);
        }
    }

    @Override // d.a.r0.w.b
    public void onAction(d.a.r0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f56766a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i2 == 34) {
            Object obj = aVar.f56768c;
            if (obj instanceof Integer) {
                setFrom(((Integer) obj).intValue());
            }
        } else if (i2 != 35) {
        } else {
            Object obj2 = aVar.f56768c;
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = this.f14580i.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.f14576e.z(arrayList, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.s);
        }
    }

    @Override // d.a.r0.w.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f14577f.d(i2);
            this.f14576e.w(i2);
            SkinManager.setBackgroundColor(this.f14578g, R.color.common_color_10288, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
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

    public void setCurrentEmotionGroup(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 < 0 || i2 >= this.f14580i.size() || i2 == this.j) {
            return;
        }
        this.f14576e.z(this.f14580i, i2);
        this.f14577f.setCurrentTab(i2);
        this.j = i2;
        this.k = this.f14580i.get(i2).f();
    }

    @Override // d.a.r0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.p = editorTools;
            this.f14576e.setOnDataSelected(editorTools);
            this.f14577f.setOnDataSelected(editorTools);
        }
    }

    public void setFrom(int i2) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (emotionTabWidgetView = this.f14577f) == null) {
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

    @Override // d.a.r0.w.n
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
        this.f14579h = new ArrayList<>();
        this.f14580i = new ArrayList<>();
        this.j = -1;
        this.k = null;
        this.l = -1;
        this.m = true;
        this.n = true;
        this.o = 0;
        this.q = 0;
        this.r = new a(this, 2001117);
        this.s = new b(this, 2921304);
        i(context);
    }
}
