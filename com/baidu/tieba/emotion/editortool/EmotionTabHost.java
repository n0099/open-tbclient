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
import d.b.h0.w.n;
import d.b.h0.w.p.c;
import d.b.i0.h0.b.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements EmotionTabWidgetView.c, EmotionTabContentView.d, n {

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabContentView f15343e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionTabWidgetView f15344f;

    /* renamed from: g  reason: collision with root package name */
    public View f15345g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f15346h;
    public ArrayList<c> i;
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
        public a(int i) {
            super(i);
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
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921304 || EmotionTabHost.this.f15346h.size() < 0) {
                return;
            }
            for (int i = 0; i < EmotionTabHost.this.f15346h.size(); i++) {
                if (((c) EmotionTabHost.this.f15346h.get(i)).h() == EmotionGroupType.USER_COLLECT) {
                    EmotionTabHost.this.setCurrentEmotionGroup(i);
                    return;
                }
            }
        }
    }

    public EmotionTabHost(Context context) {
        super(context);
        this.f15346h = new ArrayList<>();
        this.i = new ArrayList<>();
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
    public void a(int i) {
        EmotionTabContentView emotionTabContentView;
        if (i < 0 || i >= this.f15346h.size() || i == this.j || (emotionTabContentView = this.f15343e) == null) {
            return;
        }
        emotionTabContentView.A(i);
        this.j = i;
    }

    @Override // d.b.h0.w.n
    public void b() {
        if (this.f15344f != null) {
            int size = this.f15346h.size();
            for (int i = 0; i < size; i++) {
                this.f15344f.setTabWidgetVisibility(i, this.m);
            }
            this.f15344f.setTabWidgetBigEmontionVisibility(this.m);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.d
    public void c(int i) {
        EmotionTabWidgetView emotionTabWidgetView = this.f15344f;
        if (emotionTabWidgetView == null || i == this.j) {
            return;
        }
        emotionTabWidgetView.setCurrentTab(i);
        this.j = i;
    }

    @Override // d.b.h0.w.n
    public void d(d.b.h0.w.a aVar) {
        EditorTools editorTools = this.p;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.q;
    }

    public final void h(c cVar) {
        this.f15344f.b(cVar);
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    public final void i(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
        this.f15343e = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.f15344f = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.f15345g = findViewById(R.id.emotion_tab_widget_div_line);
        this.f15344f.setOnTabSelectedListener(this);
        this.f15343e.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.l = skinType;
        onChangeSkinType(skinType);
    }

    @Override // d.b.h0.w.n
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
        this.f15346h.clear();
        this.f15343e.x();
        this.f15344f.e();
    }

    public final void l() {
        int i;
        this.f15346h = e.i().h();
        if (this.m && this.n) {
            this.i = e.i().h();
        } else {
            this.i = j();
            if (!this.n && this.f15346h != null) {
                this.f15346h = new ArrayList<>(e.i().h());
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f15346h.size()) {
                        break;
                    } else if (this.f15346h.get(i2).h() == EmotionGroupType.USER_COLLECT) {
                        this.f15346h.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        ArrayList<c> arrayList = this.f15346h;
        if ((arrayList == null || arrayList.size() <= 0) && (i = this.o) < 3) {
            this.o = i + 1;
            e.i().q();
            return;
        }
        this.f15344f.setDatas(this.f15346h);
        int size = this.f15346h.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            c cVar = this.f15346h.get(i4);
            String str = this.k;
            if (str != null && str.equals(cVar.f())) {
                i3 = i4;
            }
            h(cVar);
        }
        setCurrentEmotionGroup(i3);
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i = aVar.f51524a;
        if (i == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 7));
        } else if (i == 34) {
            Object obj = aVar.f51526c;
            if (obj instanceof Integer) {
                setFrom(((Integer) obj).intValue());
            }
        } else if (i != 35) {
        } else {
            Object obj2 = aVar.f51526c;
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                setShowBigEmotion(booleanValue);
                if (booleanValue) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<c> it = this.i.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.j()) {
                        arrayList.add(next);
                    }
                }
                this.f15343e.y(arrayList, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.r);
        MessageManager.getInstance().registerListener(this.s);
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
        this.f15344f.d(i);
        this.f15343e.v(i);
        SkinManager.setBackgroundColor(this.f15345g, R.color.common_color_10288, i);
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

    public void setCurrentEmotionGroup(int i) {
        if (i < 0 || i >= this.i.size() || i == this.j) {
            return;
        }
        this.f15343e.y(this.i, i);
        this.f15344f.setCurrentTab(i);
        this.j = i;
        this.k = this.i.get(i).f();
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.p = editorTools;
        this.f15343e.setOnDataSelected(editorTools);
        this.f15344f.setOnDataSelected(editorTools);
    }

    public void setFrom(int i) {
        EmotionTabWidgetView emotionTabWidgetView = this.f15344f;
        if (emotionTabWidgetView != null) {
            emotionTabWidgetView.setFrom(i);
        }
    }

    public void setShowBigEmotion(boolean z) {
        this.m = z;
    }

    public void setShowUserCollect(boolean z) {
        this.n = z;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.q = i;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.l) {
            this.l = skinType;
            onChangeSkinType(skinType);
        }
    }

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15346h = new ArrayList<>();
        this.i = new ArrayList<>();
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
