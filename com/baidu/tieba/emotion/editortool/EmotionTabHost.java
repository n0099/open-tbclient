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
import com.baidu.tbadk.core.util.ak;
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
    private EditorTools JS;
    private int JT;
    private CustomMessageListener UN;
    private int aFG;
    private int aqQ;
    private EmotionTabContentView cGi;
    private EmotionTabWidgetView cGj;
    private View cGk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cGl;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cGm;
    private String cGn;
    private boolean cGo;
    private boolean cGp;
    private int cGq;
    private CustomMessageListener cGr;

    public EmotionTabHost(Context context) {
        super(context);
        this.cGl = new ArrayList<>();
        this.cGm = new ArrayList<>();
        this.aFG = -1;
        this.cGn = null;
        this.aqQ = -1;
        this.cGo = true;
        this.cGp = true;
        this.cGq = 0;
        this.JT = 0;
        this.UN = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cGr = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cGl.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cGl.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cGl.get(i2)).DU() != EmotionGroupType.USER_COLLECT) {
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
        this.cGl = new ArrayList<>();
        this.cGm = new ArrayList<>();
        this.aFG = -1;
        this.cGn = null;
        this.aqQ = -1;
        this.cGo = true;
        this.cGp = true;
        this.cGq = 0;
        this.JT = 0;
        this.UN = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cGr = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cGl.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cGl.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cGl.get(i2)).DU() != EmotionGroupType.USER_COLLECT) {
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
        this.cGi = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.cGj = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.cGk = findViewById(d.g.emotion_tab_widget_div_line);
        this.cGj.setOnTabSelectedListener(this);
        this.cGi.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aqQ = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aqQ);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cGj != null) {
            this.cGj.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cGp = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> akc() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.akm().ako().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.DU() != EmotionGroupType.BIG_EMOTION || this.cGo) {
                if (next.DU() != EmotionGroupType.USER_COLLECT || this.cGp) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cGl = e.akm().ako();
        if (!this.cGo || !this.cGp) {
            this.cGm = akc();
            if (!this.cGp && this.cGl != null) {
                this.cGl = new ArrayList<>(e.akm().ako());
                int i = 0;
                while (true) {
                    if (i < this.cGl.size()) {
                        if (this.cGl.get(i).DU() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cGl.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cGm = e.akm().ako();
        }
        if ((this.cGl == null || this.cGl.size() <= 0) && this.cGq < 3) {
            this.cGq++;
            e.akm().akn();
            return;
        }
        this.cGj.setDatas(this.cGl);
        int size = this.cGl.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cGl.get(i3);
            if (this.cGn != null && this.cGn.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.UN);
        MessageManager.getInstance().registerListener(this.cGr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.UN);
        MessageManager.getInstance().unRegisterListener(this.cGr);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aqQ) {
            this.aqQ = skinType;
            onChangeSkinType(this.aqQ);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cGj.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cGm.size() && i != this.aFG) {
            this.cGi.h(this.cGm, i);
            this.cGj.setCurrentTab(i);
            this.aFG = i;
            this.cGn = this.cGm.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aFG = -1;
        this.cGl.clear();
        this.cGi.reset();
        this.cGj.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cGo = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eS(int i) {
        if (i >= 0 && i < this.cGl.size() && i != this.aFG && this.cGi != null) {
            this.cGi.jo(i);
            this.aFG = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cGj.onChangeSkinType(i);
        this.cGi.onChangeSkinType(i);
        ak.e(this.cGk, d.C0126d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void jp(int i) {
        if (this.cGj != null && i != this.aFG) {
            this.cGj.setCurrentTab(i);
            this.aFG = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cGm.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.DT()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cGi.h(arrayList, 0);
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
        this.JS = editorTools;
        this.cGi.setOnDataSelected(editorTools);
        this.cGj.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JS != null) {
            this.JS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lN() {
        if (this.cGj != null) {
            int size = this.cGl.size();
            for (int i = 0; i < size; i++) {
                this.cGj.setTabWidgetVisibility(i, this.cGo);
            }
            this.cGj.setTabWidgetBigEmontionVisibility(this.cGo);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
