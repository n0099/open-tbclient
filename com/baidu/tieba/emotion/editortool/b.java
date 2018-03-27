package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends NoPressedLinearLayout implements s, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private CustomMessageListener aJs;
    private i axH;
    private int axI;
    private int bfC;
    private int bvi;
    private EmotionTabContentView dog;
    private EmotionTabWidgetView doh;
    private View doi;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> doj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dok;
    private String dol;
    private boolean dom;
    private boolean don;
    private int doo;
    private CustomMessageListener dop;

    public b(Context context) {
        super(context);
        this.doj = new ArrayList<>();
        this.dok = new ArrayList<>();
        this.bvi = -1;
        this.dol = null;
        this.bfC = -1;
        this.dom = true;
        this.don = true;
        this.doo = 0;
        this.axI = 0;
        this.aJs = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001117:
                        b.this.reset();
                        b.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dop = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.doj.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.doj.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.doj.get(i2)).Lr() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                b.this.setCurrentEmotionGroup(i2);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(d.h.emotion_tab_host, (ViewGroup) this, true);
        this.dog = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.doh = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.doi = findViewById(d.g.emotion_tab_widget_div_line);
        this.doh.setOnTabSelectedListener(this);
        this.dog.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bfC = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bfC);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.doh != null) {
            this.doh.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.don = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> apU() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.aqe().aqg().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Lr() != EmotionGroupType.BIG_EMOTION || this.dom) {
                if (next.Lr() != EmotionGroupType.USER_COLLECT || this.don) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.doj = g.aqe().aqg();
        if (!this.dom || !this.don) {
            this.dok = apU();
            if (!this.don && this.doj != null) {
                this.doj = new ArrayList<>(g.aqe().aqg());
                int i = 0;
                while (true) {
                    if (i < this.doj.size()) {
                        if (this.doj.get(i).Lr() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.doj.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dok = g.aqe().aqg();
        }
        if ((this.doj == null || this.doj.size() <= 0) && this.doo < 3) {
            this.doo++;
            g.aqe().aqf();
            return;
        }
        this.doh.setDatas(this.doj);
        int size = this.doj.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.doj.get(i3);
            if (this.dol != null && this.dol.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aJs);
        MessageManager.getInstance().registerListener(this.dop);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aJs);
        MessageManager.getInstance().unRegisterListener(this.dop);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bfC) {
            this.bfC = skinType;
            onChangeSkinType(this.bfC);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.doh.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dok.size() && i != this.bvi) {
            this.dog.l(this.dok, i);
            this.doh.setCurrentTab(i);
            this.bvi = i;
            this.dol = this.dok.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bvi = -1;
        this.doj.clear();
        this.dog.reset();
        this.doh.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dom = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void hT(int i) {
        if (i >= 0 && i < this.doj.size() && i != this.bvi && this.dog != null) {
            this.dog.md(i);
            this.bvi = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.doh.onChangeSkinType(i);
        this.dog.onChangeSkinType(i);
        aj.g(this.doi, d.C0141d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void me(int i) {
        if (this.doh != null && i != this.bvi) {
            this.doh.setCurrentTab(i);
            this.bvi = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 34:
                    if (aVar.data instanceof Integer) {
                        setFrom(((Integer) aVar.data).intValue());
                        return;
                    }
                    return;
                case 35:
                    if (aVar.data instanceof Boolean) {
                        boolean booleanValue = ((Boolean) aVar.data).booleanValue();
                        setShowBigEmotion(booleanValue);
                        if (!booleanValue) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dok.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Lq()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dog.l(arrayList, 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axH = iVar;
        this.dog.setOnDataSelected(iVar);
        this.doh.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axI;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.doh != null) {
            int size = this.doj.size();
            for (int i = 0; i < size; i++) {
                this.doh.C(i, this.dom);
            }
            this.doh.setTabWidgetBigEmontionVisibility(this.dom);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
