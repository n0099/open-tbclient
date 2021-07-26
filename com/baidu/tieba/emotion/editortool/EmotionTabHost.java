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
import d.a.p0.x.n;
import d.a.p0.x.p.c;
import d.a.q0.k0.b.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.c, EmotionTabContentView.d, n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabContentView f14663e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionTabWidgetView f14664f;

    /* renamed from: g  reason: collision with root package name */
    public View f14665g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f14666h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c> f14667i;
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

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHost f14668a;

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
            this.f14668a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001117) {
                this.f14668a.k();
                this.f14668a.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionTabHost f14669a;

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
            this.f14669a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921304 || this.f14669a.f14666h.size() < 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f14669a.f14666h.size(); i2++) {
                if (((c) this.f14669a.f14666h.get(i2)).h() == EmotionGroupType.USER_COLLECT) {
                    this.f14669a.setCurrentEmotionGroup(i2);
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
        this.f14666h = new ArrayList<>();
        this.f14667i = new ArrayList<>();
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
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 < 0 || i2 >= this.f14666h.size() || i2 == this.j || (emotionTabContentView = this.f14663e) == null) {
            return;
        }
        emotionTabContentView.B(i2);
        this.j = i2;
    }

    @Override // d.a.p0.x.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f14664f != null) {
                int size = this.f14666h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f14664f.setTabWidgetVisibility(i2, this.m);
                }
                this.f14664f.setTabWidgetBigEmontionVisibility(this.m);
            }
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.d
    public void c(int i2) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (emotionTabWidgetView = this.f14664f) == null || i2 == this.j) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i2);
        this.j = i2;
    }

    @Override // d.a.p0.x.n
    public void d(d.a.p0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (editorTools = this.p) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    @Override // d.a.p0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : invokeV.intValue;
    }

    public final void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f14664f.b(cVar);
        }
    }

    @Override // d.a.p0.x.n
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
            this.f14663e = (EmotionTabContentView) findViewById(R.id.face_tab_content);
            this.f14664f = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
            this.f14665g = findViewById(R.id.emotion_tab_widget_div_line);
            this.f14664f.setOnTabSelectedListener(this);
            this.f14663e.setOnEmotionSwitchedListener(this);
            setOrientation(1);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.l = skinType;
            onChangeSkinType(skinType);
        }
    }

    @Override // d.a.p0.x.n
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
            this.f14666h.clear();
            this.f14663e.y();
            this.f14664f.e();
        }
    }

    public final void l() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f14666h = e.i().h();
            if (this.m && this.n) {
                this.f14667i = e.i().h();
            } else {
                this.f14667i = j();
                if (!this.n && this.f14666h != null) {
                    this.f14666h = new ArrayList<>(e.i().h());
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.f14666h.size()) {
                            break;
                        } else if (this.f14666h.get(i3).h() == EmotionGroupType.USER_COLLECT) {
                            this.f14666h.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f14666h;
            if ((arrayList == null || arrayList.size() <= 0) && (i2 = this.o) < 3) {
                this.o = i2 + 1;
                e.i().q();
                return;
            }
            this.f14664f.setDatas(this.f14666h);
            int size = this.f14666h.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                c cVar = this.f14666h.get(i5);
                String str = this.k;
                if (str != null && str.equals(cVar.f())) {
                    i4 = i5;
                }
                h(cVar);
            }
            setCurrentEmotionGroup(i4);
        }
    }

    @Override // d.a.p0.x.b
    public void onAction(d.a.p0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f54158a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i2 == 34) {
            Object obj = aVar.f54160c;
            if (obj instanceof Integer) {
                setFrom(((Integer) obj).intValue());
            }
        } else if (i2 != 35) {
        } else {
            Object obj2 = aVar.f54160c;
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = this.f14667i.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.f14663e.z(arrayList, 0);
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

    @Override // d.a.p0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f14664f.d(i2);
            this.f14663e.w(i2);
            SkinManager.setBackgroundColor(this.f14665g, R.color.common_color_10288, i2);
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
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 < 0 || i2 >= this.f14667i.size() || i2 == this.j) {
            return;
        }
        this.f14663e.z(this.f14667i, i2);
        this.f14664f.setCurrentTab(i2);
        this.j = i2;
        this.k = this.f14667i.get(i2).f();
    }

    @Override // d.a.p0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.p = editorTools;
            this.f14663e.setOnDataSelected(editorTools);
            this.f14664f.setOnDataSelected(editorTools);
        }
    }

    public void setFrom(int i2) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (emotionTabWidgetView = this.f14664f) == null) {
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

    @Override // d.a.p0.x.n
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
        this.f14666h = new ArrayList<>();
        this.f14667i = new ArrayList<>();
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
