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
    private EditorTools TU;
    private int TV;
    private CustomMessageListener bDy;
    private int bpM;
    private int cdL;
    private EmotionTabContentView eUI;
    private EmotionTabWidgetView eUJ;
    private View eUK;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eUL;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eUM;
    private String eUN;
    private boolean eUO;
    private boolean eUP;
    private int eUQ;
    private CustomMessageListener eUR;

    public EmotionTabHost(Context context) {
        super(context);
        this.eUL = new ArrayList<>();
        this.eUM = new ArrayList<>();
        this.bpM = -1;
        this.eUN = null;
        this.cdL = -1;
        this.eUO = true;
        this.eUP = true;
        this.eUQ = 0;
        this.TV = 0;
        this.bDy = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eUR = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eUL.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eUL.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eUL.get(i2)).aso() != EmotionGroupType.USER_COLLECT) {
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
        this.eUL = new ArrayList<>();
        this.eUM = new ArrayList<>();
        this.bpM = -1;
        this.eUN = null;
        this.cdL = -1;
        this.eUO = true;
        this.eUP = true;
        this.eUQ = 0;
        this.TV = 0;
        this.bDy = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eUR = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eUL.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eUL.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eUL.get(i2)).aso() != EmotionGroupType.USER_COLLECT) {
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
        this.eUI = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.eUJ = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.eUK = findViewById(R.id.emotion_tab_widget_div_line);
        this.eUJ.setOnTabSelectedListener(this);
        this.eUI.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.cdL = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.cdL);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eUJ != null) {
            this.eUJ.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eUP = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> beN() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.beX().beZ().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.aso() != EmotionGroupType.BIG_EMOTION || this.eUO) {
                if (next.aso() != EmotionGroupType.USER_COLLECT || this.eUP) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eUL = e.beX().beZ();
        if (!this.eUO || !this.eUP) {
            this.eUM = beN();
            if (!this.eUP && this.eUL != null) {
                this.eUL = new ArrayList<>(e.beX().beZ());
                int i = 0;
                while (true) {
                    if (i < this.eUL.size()) {
                        if (this.eUL.get(i).aso() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eUL.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eUM = e.beX().beZ();
        }
        if ((this.eUL == null || this.eUL.size() <= 0) && this.eUQ < 3) {
            this.eUQ++;
            e.beX().beY();
            return;
        }
        this.eUJ.setDatas(this.eUL);
        int size = this.eUL.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eUL.get(i3);
            if (this.eUN != null && this.eUN.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bDy);
        MessageManager.getInstance().registerListener(this.eUR);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bDy);
        MessageManager.getInstance().unRegisterListener(this.eUR);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.cdL) {
            this.cdL = skinType;
            onChangeSkinType(this.cdL);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eUJ.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eUM.size() && i != this.bpM) {
            this.eUI.i(this.eUM, i);
            this.eUJ.setCurrentTab(i);
            this.bpM = i;
            this.eUN = this.eUM.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bpM = -1;
        this.eUL.clear();
        this.eUI.reset();
        this.eUJ.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eUO = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void kA(int i) {
        if (i >= 0 && i < this.eUL.size() && i != this.bpM && this.eUI != null) {
            this.eUI.ql(i);
            this.bpM = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eUJ.onChangeSkinType(i);
        this.eUI.onChangeSkinType(i);
        am.h(this.eUK, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void qm(int i) {
        if (this.eUJ != null && i != this.bpM) {
            this.eUJ.setCurrentTab(i);
            this.bpM = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eUM.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.asn()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eUI.i(arrayList, 0);
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
        this.TU = editorTools;
        this.eUI.setOnDataSelected(editorTools);
        this.eUJ.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qk() {
        if (this.eUJ != null) {
            int size = this.eUL.size();
            for (int i = 0; i < size; i++) {
                this.eUJ.setTabWidgetVisibility(i, this.eUO);
            }
            this.eUJ.setTabWidgetBigEmontionVisibility(this.eUO);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
