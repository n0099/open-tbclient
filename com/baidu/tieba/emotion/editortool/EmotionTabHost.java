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
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools VM;
    private int VN;
    private int bUJ;
    private int biR;
    private CustomMessageListener bvr;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAA;
    private String eAB;
    private boolean eAC;
    private boolean eAD;
    private int eAE;
    private CustomMessageListener eAF;
    private EmotionTabContentView eAw;
    private EmotionTabWidgetView eAx;
    private View eAy;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAz;

    public EmotionTabHost(Context context) {
        super(context);
        this.eAz = new ArrayList<>();
        this.eAA = new ArrayList<>();
        this.biR = -1;
        this.eAB = null;
        this.bUJ = -1;
        this.eAC = true;
        this.eAD = true;
        this.eAE = 0;
        this.VN = 0;
        this.bvr = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eAF = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eAz.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eAz.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eAz.get(i2)).amj() != EmotionGroupType.USER_COLLECT) {
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
        this.eAz = new ArrayList<>();
        this.eAA = new ArrayList<>();
        this.biR = -1;
        this.eAB = null;
        this.bUJ = -1;
        this.eAC = true;
        this.eAD = true;
        this.eAE = 0;
        this.VN = 0;
        this.bvr = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eAF = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eAz.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eAz.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eAz.get(i2)).amj() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(d.h.emotion_tab_host, (ViewGroup) this, true);
        this.eAw = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.eAx = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.eAy = findViewById(d.g.emotion_tab_widget_div_line);
        this.eAx.setOnTabSelectedListener(this);
        this.eAw.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bUJ = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bUJ);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eAx != null) {
            this.eAx.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eAD = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVC() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.aVM().aVO().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.amj() != EmotionGroupType.BIG_EMOTION || this.eAC) {
                if (next.amj() != EmotionGroupType.USER_COLLECT || this.eAD) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eAz = e.aVM().aVO();
        if (!this.eAC || !this.eAD) {
            this.eAA = aVC();
            if (!this.eAD && this.eAz != null) {
                this.eAz = new ArrayList<>(e.aVM().aVO());
                int i = 0;
                while (true) {
                    if (i < this.eAz.size()) {
                        if (this.eAz.get(i).amj() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eAz.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eAA = e.aVM().aVO();
        }
        if ((this.eAz == null || this.eAz.size() <= 0) && this.eAE < 3) {
            this.eAE++;
            e.aVM().aVN();
            return;
        }
        this.eAx.setDatas(this.eAz);
        int size = this.eAz.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eAz.get(i3);
            if (this.eAB != null && this.eAB.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bvr);
        MessageManager.getInstance().registerListener(this.eAF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bvr);
        MessageManager.getInstance().unRegisterListener(this.eAF);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bUJ) {
            this.bUJ = skinType;
            onChangeSkinType(this.bUJ);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAx.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eAA.size() && i != this.biR) {
            this.eAw.i(this.eAA, i);
            this.eAx.setCurrentTab(i);
            this.biR = i;
            this.eAB = this.eAA.get(i).getGroupId();
        }
    }

    public void reset() {
        this.biR = -1;
        this.eAz.clear();
        this.eAw.reset();
        this.eAx.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eAC = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void jH(int i) {
        if (i >= 0 && i < this.eAz.size() && i != this.biR && this.eAw != null) {
            this.eAw.oU(i);
            this.biR = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eAx.onChangeSkinType(i);
        this.eAw.onChangeSkinType(i);
        al.f(this.eAy, d.C0236d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void oV(int i) {
        if (this.eAx != null && i != this.biR) {
            this.eAx.setCurrentTab(i);
            this.biR = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAA.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.ami()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eAw.i(arrayList, 0);
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
        this.VM = editorTools;
        this.eAw.setOnDataSelected(editorTools);
        this.eAx.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VM != null) {
            this.VM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VN = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VN;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.eAx != null) {
            int size = this.eAz.size();
            for (int i = 0; i < size; i++) {
                this.eAx.setTabWidgetVisibility(i, this.eAC);
            }
            this.eAx.setTabWidgetBigEmontionVisibility(this.eAC);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
