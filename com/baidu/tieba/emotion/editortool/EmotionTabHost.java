package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import d.a.m0.w.n;
import d.a.m0.w.p.c;
import d.a.n0.i0.b.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.c, EmotionTabContentView.d, n {

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabContentView f14407e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionTabWidgetView f14408f;

    /* renamed from: g  reason: collision with root package name */
    public View f14409g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f14410h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c> f14411i;
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
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() != 2001117) {
                return;
            }
            EmotionTabHost.this.k();
            EmotionTabHost.this.l();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921304 || EmotionTabHost.this.f14410h.size() < 0) {
                return;
            }
            for (int i2 = 0; i2 < EmotionTabHost.this.f14410h.size(); i2++) {
                if (((c) EmotionTabHost.this.f14410h.get(i2)).h() == EmotionGroupType.USER_COLLECT) {
                    EmotionTabHost.this.setCurrentEmotionGroup(i2);
                    return;
                }
            }
        }
    }

    public EmotionTabHost(Context context) {
        super(context);
        this.f14410h = new ArrayList<>();
        this.f14411i = new ArrayList<>();
        this.j = -1;
        this.k = null;
        this.l = -1;
        this.m = true;
        this.n = true;
        this.o = 0;
        this.q = 0;
        this.r = new a(2001117);
        this.s = new b(2921304);
        i(context);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.c
    public void a(int i2) {
        EmotionTabContentView emotionTabContentView;
        if (i2 < 0 || i2 >= this.f14410h.size() || i2 == this.j || (emotionTabContentView = this.f14407e) == null) {
            return;
        }
        emotionTabContentView.B(i2);
        this.j = i2;
    }

    @Override // d.a.m0.w.n
    public void b() {
        if (this.f14408f != null) {
            int size = this.f14410h.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f14408f.setTabWidgetVisibility(i2, this.m);
            }
            this.f14408f.setTabWidgetBigEmontionVisibility(this.m);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.d
    public void c(int i2) {
        EmotionTabWidgetView emotionTabWidgetView = this.f14408f;
        if (emotionTabWidgetView == null || i2 == this.j) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i2);
        this.j = i2;
    }

    @Override // d.a.m0.w.n
    public void d(d.a.m0.w.a aVar) {
        EditorTools editorTools = this.p;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.m0.w.n
    public int getToolId() {
        return this.q;
    }

    public final void h(c cVar) {
        this.f14408f.b(cVar);
    }

    @Override // d.a.m0.w.n
    public void hide() {
        setVisibility(8);
    }

    public final void i(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
        this.f14407e = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.f14408f = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.f14409g = findViewById(R.id.emotion_tab_widget_div_line);
        this.f14408f.setOnTabSelectedListener(this);
        this.f14407e.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.l = skinType;
        onChangeSkinType(skinType);
    }

    @Override // d.a.m0.w.n
    public void init() {
        l();
    }

    public final ArrayList<c> j() {
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

    public void k() {
        this.j = -1;
        this.f14410h.clear();
        this.f14407e.y();
        this.f14408f.e();
    }

    public final void l() {
        int i2;
        this.f14410h = e.i().h();
        if (this.m && this.n) {
            this.f14411i = e.i().h();
        } else {
            this.f14411i = j();
            if (!this.n && this.f14410h != null) {
                this.f14410h = new ArrayList<>(e.i().h());
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f14410h.size()) {
                        break;
                    } else if (this.f14410h.get(i3).h() == EmotionGroupType.USER_COLLECT) {
                        this.f14410h.remove(i3);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        ArrayList<c> arrayList = this.f14410h;
        if ((arrayList == null || arrayList.size() <= 0) && (i2 = this.o) < 3) {
            this.o = i2 + 1;
            e.i().q();
            return;
        }
        this.f14408f.setDatas(this.f14410h);
        int size = this.f14410h.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            c cVar = this.f14410h.get(i5);
            String str = this.k;
            if (str != null && str.equals(cVar.f())) {
                i4 = i5;
            }
            h(cVar);
        }
        setCurrentEmotionGroup(i4);
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f54518a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i2 == 34) {
            Object obj = aVar.f54520c;
            if (obj instanceof Integer) {
                setFrom(((Integer) obj).intValue());
            }
        } else if (i2 != 35) {
        } else {
            Object obj2 = aVar.f54520c;
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = this.f14411i.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.f14407e.z(arrayList, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.r);
        MessageManager.getInstance().registerListener(this.s);
    }

    @Override // d.a.m0.w.n
    public void onChangeSkinType(int i2) {
        this.f14408f.d(i2);
        this.f14407e.w(i2);
        SkinManager.setBackgroundColor(this.f14409g, R.color.common_color_10288, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.s);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCurrentEmotionGroup(int i2) {
        if (i2 < 0 || i2 >= this.f14411i.size() || i2 == this.j) {
            return;
        }
        this.f14407e.z(this.f14411i, i2);
        this.f14408f.setCurrentTab(i2);
        this.j = i2;
        this.k = this.f14411i.get(i2).f();
    }

    @Override // d.a.m0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.p = editorTools;
        this.f14407e.setOnDataSelected(editorTools);
        this.f14408f.setOnDataSelected(editorTools);
    }

    public void setFrom(int i2) {
        EmotionTabWidgetView emotionTabWidgetView = this.f14408f;
        if (emotionTabWidgetView != null) {
            emotionTabWidgetView.setFrom(i2);
        }
    }

    public void setShowBigEmotion(boolean z) {
        this.m = z;
    }

    public void setShowUserCollect(boolean z) {
        this.n = z;
    }

    @Override // d.a.m0.w.n
    public void setToolId(int i2) {
        this.q = i2;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.l) {
            this.l = skinType;
            onChangeSkinType(skinType);
        }
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14410h = new ArrayList<>();
        this.f14411i = new ArrayList<>();
        this.j = -1;
        this.k = null;
        this.l = -1;
        this.m = true;
        this.n = true;
        this.o = 0;
        this.q = 0;
        this.r = new a(2001117);
        this.s = new b(2921304);
        i(context);
    }
}
