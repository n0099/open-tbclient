package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.x.n;
import c.a.r0.x.p.c;
import c.a.s0.t0.b.e;
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
/* loaded from: classes12.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.c, EmotionTabContentView.d, n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabContentView f43938e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionTabWidgetView f43939f;

    /* renamed from: g  reason: collision with root package name */
    public View f43940g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f43941h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c> f43942i;

    /* renamed from: j  reason: collision with root package name */
    public int f43943j;

    /* renamed from: k  reason: collision with root package name */
    public String f43944k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public EditorTools p;
    public int q;
    public CustomMessageListener r;
    public CustomMessageListener s;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHost a;

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
            this.a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001117) {
                this.a.reset();
                this.a.f();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabHost a;

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
            this.a = emotionTabHost;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921304 || this.a.f43941h.size() < 0) {
                return;
            }
            for (int i2 = 0; i2 < this.a.f43941h.size(); i2++) {
                if (((c) this.a.f43941h.get(i2)).h() == EmotionGroupType.USER_COLLECT) {
                    this.a.setCurrentEmotionGroup(i2);
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
        this.f43941h = new ArrayList<>();
        this.f43942i = new ArrayList<>();
        this.f43943j = -1;
        this.f43944k = null;
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
            this.f43939f.addTabWidget(cVar);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
            this.f43938e = (EmotionTabContentView) findViewById(R.id.face_tab_content);
            this.f43939f = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
            this.f43940g = findViewById(R.id.emotion_tab_widget_div_line);
            this.f43939f.setOnTabSelectedListener(this);
            this.f43938e.setOnEmotionSwitchedListener(this);
            setOrientation(1);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.l = skinType;
            onChangeSkinType(skinType);
        }
    }

    @Override // c.a.r0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f43939f != null) {
                int size = this.f43941h.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f43939f.setTabWidgetVisibility(i2, this.m);
                }
                this.f43939f.setTabWidgetBigEmontionVisibility(this.m);
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
            this.f43941h = e.i().h();
            if (this.m && this.n) {
                this.f43942i = e.i().h();
            } else {
                this.f43942i = e();
                if (!this.n && this.f43941h != null) {
                    this.f43941h = new ArrayList<>(e.i().h());
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.f43941h.size()) {
                            break;
                        } else if (this.f43941h.get(i3).h() == EmotionGroupType.USER_COLLECT) {
                            this.f43941h.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            ArrayList<c> arrayList = this.f43941h;
            if ((arrayList == null || arrayList.size() <= 0) && (i2 = this.o) < 3) {
                this.o = i2 + 1;
                e.i().q();
                return;
            }
            this.f43939f.setDatas(this.f43941h);
            int size = this.f43941h.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                c cVar = this.f43941h.get(i5);
                String str = this.f43944k;
                if (str != null && str.equals(cVar.f())) {
                    i4 = i5;
                }
                c(cVar);
            }
            setCurrentEmotionGroup(i4);
        }
    }

    @Override // c.a.r0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.intValue;
    }

    @Override // c.a.r0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.r0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            f();
        }
    }

    @Override // c.a.r0.x.b
    public void onAction(c.a.r0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i2 == 34) {
            Object obj = aVar.f14019c;
            if (obj instanceof Integer) {
                setFrom(((Integer) obj).intValue());
            }
        } else if (i2 != 35) {
        } else {
            Object obj2 = aVar.f14019c;
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = this.f43942i.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.f43938e.showAllPackages(arrayList, 0);
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

    @Override // c.a.r0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f43939f.onChangeSkinType(i2);
            this.f43938e.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.f43940g, R.color.common_color_10288, i2);
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
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (emotionTabWidgetView = this.f43939f) == null || i2 == this.f43943j) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i2);
        this.f43943j = i2;
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
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || i2 < 0 || i2 >= this.f43941h.size() || i2 == this.f43943j || (emotionTabContentView = this.f43938e) == null) {
            return;
        }
        emotionTabContentView.toEmotionPage(i2);
        this.f43943j = i2;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f43943j = -1;
            this.f43941h.clear();
            this.f43938e.reset();
            this.f43939f.reset();
        }
    }

    @Override // c.a.r0.x.n
    public void sendAction(c.a.r0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || (editorTools = this.p) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    public void setCurrentEmotionGroup(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 < 0 || i2 >= this.f43942i.size() || i2 == this.f43943j) {
            return;
        }
        this.f43938e.showAllPackages(this.f43942i, i2);
        this.f43939f.setCurrentTab(i2);
        this.f43943j = i2;
        this.f43944k = this.f43942i.get(i2).f();
    }

    @Override // c.a.r0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.p = editorTools;
            this.f43938e.setOnDataSelected(editorTools);
            this.f43939f.setOnDataSelected(editorTools);
        }
    }

    public void setFrom(int i2) {
        EmotionTabWidgetView emotionTabWidgetView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (emotionTabWidgetView = this.f43939f) == null) {
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

    @Override // c.a.r0.x.n
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
        this.f43941h = new ArrayList<>();
        this.f43942i = new ArrayList<>();
        this.f43943j = -1;
        this.f43944k = null;
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
