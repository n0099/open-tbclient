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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Ta;
    private int Tb;
    private int aLF;
    private CustomMessageListener aof;
    private EmotionTabContentView dmU;
    private EmotionTabWidgetView dmV;
    private View dmW;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dmX;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dmY;
    private String dmZ;
    private boolean dna;
    private boolean dnb;
    private int dnc;
    private CustomMessageListener dnd;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.dmX = new ArrayList<>();
        this.dmY = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dmZ = null;
        this.aLF = -1;
        this.dna = true;
        this.dnb = true;
        this.dnc = 0;
        this.Tb = 0;
        this.aof = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001117:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dnd = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dmX.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dmX.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dmX.get(i2)).Mm() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                EmotionTabHost.this.setCurrentEmotionGroup(i2);
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

    public EmotionTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmX = new ArrayList<>();
        this.dmY = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dmZ = null;
        this.aLF = -1;
        this.dna = true;
        this.dnb = true;
        this.dnc = 0;
        this.Tb = 0;
        this.aof = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001117:
                        EmotionTabHost.this.reset();
                        EmotionTabHost.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dnd = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dmX.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dmX.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dmX.get(i2)).Mm() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                EmotionTabHost.this.setCurrentEmotionGroup(i2);
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
        LayoutInflater.from(context).inflate(e.h.emotion_tab_host, (ViewGroup) this, true);
        this.dmU = (EmotionTabContentView) findViewById(e.g.face_tab_content);
        this.dmV = (EmotionTabWidgetView) findViewById(e.g.face_tab_widget);
        this.dmW = findViewById(e.g.emotion_tab_widget_div_line);
        this.dmV.setOnTabSelectedListener(this);
        this.dmU.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aLF = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aLF);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dmV != null) {
            this.dmV.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dnb = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> auy() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.auI().auK().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Mm() != EmotionGroupType.BIG_EMOTION || this.dna) {
                if (next.Mm() != EmotionGroupType.USER_COLLECT || this.dnb) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dmX = e.auI().auK();
        if (!this.dna || !this.dnb) {
            this.dmY = auy();
            if (!this.dnb && this.dmX != null) {
                this.dmX = new ArrayList<>(e.auI().auK());
                int i = 0;
                while (true) {
                    if (i < this.dmX.size()) {
                        if (this.dmX.get(i).Mm() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dmX.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dmY = e.auI().auK();
        }
        if ((this.dmX == null || this.dmX.size() <= 0) && this.dnc < 3) {
            this.dnc++;
            e.auI().auJ();
            return;
        }
        this.dmV.setDatas(this.dmX);
        int size = this.dmX.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dmX.get(i3);
            if (this.dmZ != null && this.dmZ.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aof);
        MessageManager.getInstance().registerListener(this.dnd);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aof);
        MessageManager.getInstance().unRegisterListener(this.dnd);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aLF) {
            this.aLF = skinType;
            onChangeSkinType(this.aLF);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dmV.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dmY.size() && i != this.mCurrentIndex) {
            this.dmU.j(this.dmY, i);
            this.dmV.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.dmZ = this.dmY.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dmX.clear();
        this.dmU.reset();
        this.dmV.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dna = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fV(int i) {
        if (i >= 0 && i < this.dmX.size() && i != this.mCurrentIndex && this.dmU != null) {
            this.dmU.le(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.dmV.onChangeSkinType(i);
        this.dmU.onChangeSkinType(i);
        al.e(this.dmW, e.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void lf(int i) {
        if (this.dmV != null && i != this.mCurrentIndex) {
            this.dmV.setCurrentTab(i);
            this.mCurrentIndex = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dmY.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Ml()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dmU.j(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
        this.dmU.setOnDataSelected(editorTools);
        this.dmV.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        if (this.dmV != null) {
            int size = this.dmX.size();
            for (int i = 0; i < size; i++) {
                this.dmV.setTabWidgetVisibility(i, this.dna);
            }
            this.dmV.setTabWidgetBigEmontionVisibility(this.dna);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
