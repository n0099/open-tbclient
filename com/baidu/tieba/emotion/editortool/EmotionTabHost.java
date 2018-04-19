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
    private EmotionTabContentView cGl;
    private EmotionTabWidgetView cGm;
    private View cGn;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cGo;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cGp;
    private String cGq;
    private boolean cGr;
    private boolean cGs;
    private int cGt;
    private CustomMessageListener cGu;

    public EmotionTabHost(Context context) {
        super(context);
        this.cGo = new ArrayList<>();
        this.cGp = new ArrayList<>();
        this.aFG = -1;
        this.cGq = null;
        this.aqQ = -1;
        this.cGr = true;
        this.cGs = true;
        this.cGt = 0;
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
        this.cGu = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cGo.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cGo.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cGo.get(i2)).DU() != EmotionGroupType.USER_COLLECT) {
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
        this.cGo = new ArrayList<>();
        this.cGp = new ArrayList<>();
        this.aFG = -1;
        this.cGq = null;
        this.aqQ = -1;
        this.cGr = true;
        this.cGs = true;
        this.cGt = 0;
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
        this.cGu = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cGo.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cGo.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cGo.get(i2)).DU() != EmotionGroupType.USER_COLLECT) {
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
        this.cGl = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.cGm = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.cGn = findViewById(d.g.emotion_tab_widget_div_line);
        this.cGm.setOnTabSelectedListener(this);
        this.cGl.setOnEmotionSwitchedListener(this);
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
        if (this.cGm != null) {
            this.cGm.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cGs = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> akc() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.akm().ako().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.DU() != EmotionGroupType.BIG_EMOTION || this.cGr) {
                if (next.DU() != EmotionGroupType.USER_COLLECT || this.cGs) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cGo = e.akm().ako();
        if (!this.cGr || !this.cGs) {
            this.cGp = akc();
            if (!this.cGs && this.cGo != null) {
                this.cGo = new ArrayList<>(e.akm().ako());
                int i = 0;
                while (true) {
                    if (i < this.cGo.size()) {
                        if (this.cGo.get(i).DU() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cGo.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cGp = e.akm().ako();
        }
        if ((this.cGo == null || this.cGo.size() <= 0) && this.cGt < 3) {
            this.cGt++;
            e.akm().akn();
            return;
        }
        this.cGm.setDatas(this.cGo);
        int size = this.cGo.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cGo.get(i3);
            if (this.cGq != null && this.cGq.equals(cVar.getGroupId())) {
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
        MessageManager.getInstance().registerListener(this.cGu);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.UN);
        MessageManager.getInstance().unRegisterListener(this.cGu);
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
        this.cGm.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cGp.size() && i != this.aFG) {
            this.cGl.h(this.cGp, i);
            this.cGm.setCurrentTab(i);
            this.aFG = i;
            this.cGq = this.cGp.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aFG = -1;
        this.cGo.clear();
        this.cGl.reset();
        this.cGm.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cGr = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eS(int i) {
        if (i >= 0 && i < this.cGo.size() && i != this.aFG && this.cGl != null) {
            this.cGl.jo(i);
            this.aFG = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cGm.onChangeSkinType(i);
        this.cGl.onChangeSkinType(i);
        ak.e(this.cGn, d.C0126d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void jp(int i) {
        if (this.cGm != null && i != this.aFG) {
            this.cGm.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cGp.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.DT()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cGl.h(arrayList, 0);
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
        this.cGl.setOnDataSelected(editorTools);
        this.cGm.setOnDataSelected(editorTools);
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
        if (this.cGm != null) {
            int size = this.cGo.size();
            for (int i = 0; i < size; i++) {
                this.cGm.setTabWidgetVisibility(i, this.cGr);
            }
            this.cGm.setTabWidgetBigEmontionVisibility(this.cGr);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
