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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools TT;
    private int TU;
    private CustomMessageListener bDW;
    private int bqk;
    private int ceL;
    private String eWA;
    private boolean eWB;
    private boolean eWC;
    private int eWD;
    private CustomMessageListener eWE;
    private EmotionTabContentView eWv;
    private EmotionTabWidgetView eWw;
    private View eWx;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eWy;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eWz;

    public EmotionTabHost(Context context) {
        super(context);
        this.eWy = new ArrayList<>();
        this.eWz = new ArrayList<>();
        this.bqk = -1;
        this.eWA = null;
        this.ceL = -1;
        this.eWB = true;
        this.eWC = true;
        this.eWD = 0;
        this.TU = 0;
        this.bDW = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eWE = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eWy.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eWy.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eWy.get(i2)).asC() != EmotionGroupType.USER_COLLECT) {
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
        this.eWy = new ArrayList<>();
        this.eWz = new ArrayList<>();
        this.bqk = -1;
        this.eWA = null;
        this.ceL = -1;
        this.eWB = true;
        this.eWC = true;
        this.eWD = 0;
        this.TU = 0;
        this.bDW = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eWE = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eWy.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eWy.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eWy.get(i2)).asC() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_host, (ViewGroup) this, true);
        this.eWv = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.eWw = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.eWx = findViewById(R.id.emotion_tab_widget_div_line);
        this.eWw.setOnTabSelectedListener(this);
        this.eWv.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ceL = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.ceL);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eWw != null) {
            this.eWw.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eWC = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bft() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bfD().bfF().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.asC() != EmotionGroupType.BIG_EMOTION || this.eWB) {
                if (next.asC() != EmotionGroupType.USER_COLLECT || this.eWC) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eWy = e.bfD().bfF();
        if (!this.eWB || !this.eWC) {
            this.eWz = bft();
            if (!this.eWC && this.eWy != null) {
                this.eWy = new ArrayList<>(e.bfD().bfF());
                int i = 0;
                while (true) {
                    if (i < this.eWy.size()) {
                        if (this.eWy.get(i).asC() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eWy.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eWz = e.bfD().bfF();
        }
        if ((this.eWy == null || this.eWy.size() <= 0) && this.eWD < 3) {
            this.eWD++;
            e.bfD().bfE();
            return;
        }
        this.eWw.setDatas(this.eWy);
        int size = this.eWy.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eWy.get(i3);
            if (this.eWA != null && this.eWA.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bDW);
        MessageManager.getInstance().registerListener(this.eWE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bDW);
        MessageManager.getInstance().unRegisterListener(this.eWE);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ceL) {
            this.ceL = skinType;
            onChangeSkinType(this.ceL);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eWw.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eWz.size() && i != this.bqk) {
            this.eWv.i(this.eWz, i);
            this.eWw.setCurrentTab(i);
            this.bqk = i;
            this.eWA = this.eWz.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bqk = -1;
        this.eWy.clear();
        this.eWv.reset();
        this.eWw.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eWB = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void kE(int i) {
        if (i >= 0 && i < this.eWy.size() && i != this.bqk && this.eWv != null) {
            this.eWv.qp(i);
            this.bqk = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eWw.onChangeSkinType(i);
        this.eWv.onChangeSkinType(i);
        am.h(this.eWx, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void qq(int i) {
        if (this.eWw != null && i != this.bqk) {
            this.eWw.setCurrentTab(i);
            this.bqk = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eWz.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.asB()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eWv.i(arrayList, 0);
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
        this.TT = editorTools;
        this.eWv.setOnDataSelected(editorTools);
        this.eWw.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void ql() {
        if (this.eWw != null) {
            int size = this.eWy.size();
            for (int i = 0; i < size; i++) {
                this.eWw.setTabWidgetVisibility(i, this.eWB);
            }
            this.eWw.setTabWidgetBigEmontionVisibility(this.eWB);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
