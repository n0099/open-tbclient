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
import d.a.j0.w.n;
import d.a.j0.w.p.c;
import d.a.k0.h0.b.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.c, EmotionTabContentView.d, n {

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabContentView f14447e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionTabWidgetView f14448f;

    /* renamed from: g  reason: collision with root package name */
    public View f14449g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f14450h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c> f14451i;
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
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921304 || EmotionTabHost.this.f14450h.size() < 0) {
                return;
            }
            for (int i2 = 0; i2 < EmotionTabHost.this.f14450h.size(); i2++) {
                if (((c) EmotionTabHost.this.f14450h.get(i2)).h() == EmotionGroupType.USER_COLLECT) {
                    EmotionTabHost.this.setCurrentEmotionGroup(i2);
                    return;
                }
            }
        }
    }

    public EmotionTabHost(Context context) {
        super(context);
        this.f14450h = new ArrayList<>();
        this.f14451i = new ArrayList<>();
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
        if (i2 < 0 || i2 >= this.f14450h.size() || i2 == this.j || (emotionTabContentView = this.f14447e) == null) {
            return;
        }
        emotionTabContentView.A(i2);
        this.j = i2;
    }

    @Override // d.a.j0.w.n
    public void b() {
        if (this.f14448f != null) {
            int size = this.f14450h.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f14448f.setTabWidgetVisibility(i2, this.m);
            }
            this.f14448f.setTabWidgetBigEmontionVisibility(this.m);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.d
    public void c(int i2) {
        EmotionTabWidgetView emotionTabWidgetView = this.f14448f;
        if (emotionTabWidgetView == null || i2 == this.j) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i2);
        this.j = i2;
    }

    @Override // d.a.j0.w.n
    public void d(d.a.j0.w.a aVar) {
        EditorTools editorTools = this.p;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.j0.w.n
    public int getToolId() {
        return this.q;
    }

    public final void h(c cVar) {
        this.f14448f.b(cVar);
    }

    @Override // d.a.j0.w.n
    public void hide() {
        setVisibility(8);
    }

    public final void i(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
        this.f14447e = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.f14448f = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.f14449g = findViewById(R.id.emotion_tab_widget_div_line);
        this.f14448f.setOnTabSelectedListener(this);
        this.f14447e.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.l = skinType;
        onChangeSkinType(skinType);
    }

    @Override // d.a.j0.w.n
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
        this.f14450h.clear();
        this.f14447e.x();
        this.f14448f.e();
    }

    public final void l() {
        int i2;
        this.f14450h = e.i().h();
        if (this.m && this.n) {
            this.f14451i = e.i().h();
        } else {
            this.f14451i = j();
            if (!this.n && this.f14450h != null) {
                this.f14450h = new ArrayList<>(e.i().h());
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f14450h.size()) {
                        break;
                    } else if (this.f14450h.get(i3).h() == EmotionGroupType.USER_COLLECT) {
                        this.f14450h.remove(i3);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        ArrayList<c> arrayList = this.f14450h;
        if ((arrayList == null || arrayList.size() <= 0) && (i2 = this.o) < 3) {
            this.o = i2 + 1;
            e.i().q();
            return;
        }
        this.f14448f.setDatas(this.f14450h);
        int size = this.f14450h.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            c cVar = this.f14450h.get(i5);
            String str = this.k;
            if (str != null && str.equals(cVar.f())) {
                i4 = i5;
            }
            h(cVar);
        }
        setCurrentEmotionGroup(i4);
    }

    @Override // d.a.j0.w.b
    public void onAction(d.a.j0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f50768a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i2 == 34) {
            Object obj = aVar.f50770c;
            if (obj instanceof Integer) {
                setFrom(((Integer) obj).intValue());
            }
        } else if (i2 != 35) {
        } else {
            Object obj2 = aVar.f50770c;
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = this.f14451i.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.f14447e.y(arrayList, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.r);
        MessageManager.getInstance().registerListener(this.s);
    }

    @Override // d.a.j0.w.n
    public void onChangeSkinType(int i2) {
        this.f14448f.d(i2);
        this.f14447e.v(i2);
        SkinManager.setBackgroundColor(this.f14449g, R.color.common_color_10288, i2);
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
        if (i2 < 0 || i2 >= this.f14451i.size() || i2 == this.j) {
            return;
        }
        this.f14447e.y(this.f14451i, i2);
        this.f14448f.setCurrentTab(i2);
        this.j = i2;
        this.k = this.f14451i.get(i2).f();
    }

    @Override // d.a.j0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.p = editorTools;
        this.f14447e.setOnDataSelected(editorTools);
        this.f14448f.setOnDataSelected(editorTools);
    }

    public void setFrom(int i2) {
        EmotionTabWidgetView emotionTabWidgetView = this.f14448f;
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

    @Override // d.a.j0.w.n
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
        this.f14450h = new ArrayList<>();
        this.f14451i = new ArrayList<>();
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
