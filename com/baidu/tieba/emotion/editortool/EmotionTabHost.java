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
    private EditorTools VO;
    private int VP;
    private int bUN;
    private int biW;
    private CustomMessageListener bvx;
    private EmotionTabContentView eAe;
    private EmotionTabWidgetView eAf;
    private View eAg;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAh;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAi;
    private String eAj;
    private boolean eAk;
    private boolean eAl;
    private int eAm;
    private CustomMessageListener eAn;

    public EmotionTabHost(Context context) {
        super(context);
        this.eAh = new ArrayList<>();
        this.eAi = new ArrayList<>();
        this.biW = -1;
        this.eAj = null;
        this.bUN = -1;
        this.eAk = true;
        this.eAl = true;
        this.eAm = 0;
        this.VP = 0;
        this.bvx = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eAn = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eAh.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eAh.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eAh.get(i2)).amf() != EmotionGroupType.USER_COLLECT) {
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
        this.eAh = new ArrayList<>();
        this.eAi = new ArrayList<>();
        this.biW = -1;
        this.eAj = null;
        this.bUN = -1;
        this.eAk = true;
        this.eAl = true;
        this.eAm = 0;
        this.VP = 0;
        this.bvx = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eAn = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eAh.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eAh.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eAh.get(i2)).amf() != EmotionGroupType.USER_COLLECT) {
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
        this.eAe = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.eAf = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.eAg = findViewById(d.g.emotion_tab_widget_div_line);
        this.eAf.setOnTabSelectedListener(this);
        this.eAe.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bUN = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bUN);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eAf != null) {
            this.eAf.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eAl = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVA() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.aVK().aVM().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.amf() != EmotionGroupType.BIG_EMOTION || this.eAk) {
                if (next.amf() != EmotionGroupType.USER_COLLECT || this.eAl) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eAh = e.aVK().aVM();
        if (!this.eAk || !this.eAl) {
            this.eAi = aVA();
            if (!this.eAl && this.eAh != null) {
                this.eAh = new ArrayList<>(e.aVK().aVM());
                int i = 0;
                while (true) {
                    if (i < this.eAh.size()) {
                        if (this.eAh.get(i).amf() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eAh.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eAi = e.aVK().aVM();
        }
        if ((this.eAh == null || this.eAh.size() <= 0) && this.eAm < 3) {
            this.eAm++;
            e.aVK().aVL();
            return;
        }
        this.eAf.setDatas(this.eAh);
        int size = this.eAh.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eAh.get(i3);
            if (this.eAj != null && this.eAj.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bvx);
        MessageManager.getInstance().registerListener(this.eAn);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bvx);
        MessageManager.getInstance().unRegisterListener(this.eAn);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bUN) {
            this.bUN = skinType;
            onChangeSkinType(this.bUN);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAf.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eAi.size() && i != this.biW) {
            this.eAe.i(this.eAi, i);
            this.eAf.setCurrentTab(i);
            this.biW = i;
            this.eAj = this.eAi.get(i).getGroupId();
        }
    }

    public void reset() {
        this.biW = -1;
        this.eAh.clear();
        this.eAe.reset();
        this.eAf.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eAk = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void jG(int i) {
        if (i >= 0 && i < this.eAh.size() && i != this.biW && this.eAe != null) {
            this.eAe.oQ(i);
            this.biW = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eAf.onChangeSkinType(i);
        this.eAe.onChangeSkinType(i);
        al.f(this.eAg, d.C0277d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void oR(int i) {
        if (this.eAf != null && i != this.biW) {
            this.eAf.setCurrentTab(i);
            this.biW = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAi.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.ame()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eAe.i(arrayList, 0);
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
        this.VO = editorTools;
        this.eAe.setOnDataSelected(editorTools);
        this.eAf.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.eAf != null) {
            int size = this.eAh.size();
            for (int i = 0; i < size; i++) {
                this.eAf.setTabWidgetVisibility(i, this.eAk);
            }
            this.eAf.setTabWidgetBigEmontionVisibility(this.eAk);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
