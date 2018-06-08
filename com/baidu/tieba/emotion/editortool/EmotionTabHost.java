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
/* loaded from: classes.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Qh;
    private int Qi;
    private int aOd;
    private CustomMessageListener acJ;
    private int ayX;
    private View cQA;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cQB;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cQC;
    private String cQD;
    private boolean cQE;
    private boolean cQF;
    private int cQG;
    private CustomMessageListener cQH;
    private EmotionTabContentView cQy;
    private EmotionTabWidgetView cQz;

    public EmotionTabHost(Context context) {
        super(context);
        this.cQB = new ArrayList<>();
        this.cQC = new ArrayList<>();
        this.aOd = -1;
        this.cQD = null;
        this.ayX = -1;
        this.cQE = true;
        this.cQF = true;
        this.cQG = 0;
        this.Qi = 0;
        this.acJ = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cQH = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cQB.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cQB.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cQB.get(i2)).Hv() != EmotionGroupType.USER_COLLECT) {
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
        this.cQB = new ArrayList<>();
        this.cQC = new ArrayList<>();
        this.aOd = -1;
        this.cQD = null;
        this.ayX = -1;
        this.cQE = true;
        this.cQF = true;
        this.cQG = 0;
        this.Qi = 0;
        this.acJ = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cQH = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cQB.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cQB.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cQB.get(i2)).Hv() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(d.i.emotion_tab_host, (ViewGroup) this, true);
        this.cQy = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.cQz = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.cQA = findViewById(d.g.emotion_tab_widget_div_line);
        this.cQz.setOnTabSelectedListener(this);
        this.cQy.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ayX = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.ayX);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cQz != null) {
            this.cQz.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cQF = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aoi() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.aos().aou().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Hv() != EmotionGroupType.BIG_EMOTION || this.cQE) {
                if (next.Hv() != EmotionGroupType.USER_COLLECT || this.cQF) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cQB = e.aos().aou();
        if (!this.cQE || !this.cQF) {
            this.cQC = aoi();
            if (!this.cQF && this.cQB != null) {
                this.cQB = new ArrayList<>(e.aos().aou());
                int i = 0;
                while (true) {
                    if (i < this.cQB.size()) {
                        if (this.cQB.get(i).Hv() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cQB.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cQC = e.aos().aou();
        }
        if ((this.cQB == null || this.cQB.size() <= 0) && this.cQG < 3) {
            this.cQG++;
            e.aos().aot();
            return;
        }
        this.cQz.setDatas(this.cQB);
        int size = this.cQB.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cQB.get(i3);
            if (this.cQD != null && this.cQD.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.acJ);
        MessageManager.getInstance().registerListener(this.cQH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.acJ);
        MessageManager.getInstance().unRegisterListener(this.cQH);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ayX) {
            this.ayX = skinType;
            onChangeSkinType(this.ayX);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cQz.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cQC.size() && i != this.aOd) {
            this.cQy.h(this.cQC, i);
            this.cQz.setCurrentTab(i);
            this.aOd = i;
            this.cQD = this.cQC.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aOd = -1;
        this.cQB.clear();
        this.cQy.reset();
        this.cQz.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cQE = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eX(int i) {
        if (i >= 0 && i < this.cQB.size() && i != this.aOd && this.cQy != null) {
            this.cQy.jq(i);
            this.aOd = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cQz.onChangeSkinType(i);
        this.cQy.onChangeSkinType(i);
        al.e(this.cQA, d.C0141d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void jr(int i) {
        if (this.cQz != null && i != this.aOd) {
            this.cQz.setCurrentTab(i);
            this.aOd = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cQC.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Hu()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cQy.h(arrayList, 0);
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
        this.Qh = editorTools;
        this.cQy.setOnDataSelected(editorTools);
        this.cQz.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.cQz != null) {
            int size = this.cQB.size();
            for (int i = 0; i < size; i++) {
                this.cQz.setTabWidgetVisibility(i, this.cQE);
            }
            this.cQz.setTabWidgetBigEmontionVisibility(this.cQE);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
