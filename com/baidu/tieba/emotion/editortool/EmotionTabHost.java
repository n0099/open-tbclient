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
    private int cdS;
    private EmotionTabContentView eUP;
    private EmotionTabWidgetView eUQ;
    private View eUR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eUS;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eUT;
    private String eUU;
    private boolean eUV;
    private boolean eUW;
    private int eUX;
    private CustomMessageListener eUY;

    public EmotionTabHost(Context context) {
        super(context);
        this.eUS = new ArrayList<>();
        this.eUT = new ArrayList<>();
        this.bpM = -1;
        this.eUU = null;
        this.cdS = -1;
        this.eUV = true;
        this.eUW = true;
        this.eUX = 0;
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
        this.eUY = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eUS.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eUS.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eUS.get(i2)).asq() != EmotionGroupType.USER_COLLECT) {
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
        this.eUS = new ArrayList<>();
        this.eUT = new ArrayList<>();
        this.bpM = -1;
        this.eUU = null;
        this.cdS = -1;
        this.eUV = true;
        this.eUW = true;
        this.eUX = 0;
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
        this.eUY = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eUS.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eUS.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eUS.get(i2)).asq() != EmotionGroupType.USER_COLLECT) {
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
        this.eUP = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.eUQ = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.eUR = findViewById(R.id.emotion_tab_widget_div_line);
        this.eUQ.setOnTabSelectedListener(this);
        this.eUP.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.cdS = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.cdS);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eUQ != null) {
            this.eUQ.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eUW = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> beP() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.beZ().bfb().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.asq() != EmotionGroupType.BIG_EMOTION || this.eUV) {
                if (next.asq() != EmotionGroupType.USER_COLLECT || this.eUW) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eUS = e.beZ().bfb();
        if (!this.eUV || !this.eUW) {
            this.eUT = beP();
            if (!this.eUW && this.eUS != null) {
                this.eUS = new ArrayList<>(e.beZ().bfb());
                int i = 0;
                while (true) {
                    if (i < this.eUS.size()) {
                        if (this.eUS.get(i).asq() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eUS.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eUT = e.beZ().bfb();
        }
        if ((this.eUS == null || this.eUS.size() <= 0) && this.eUX < 3) {
            this.eUX++;
            e.beZ().bfa();
            return;
        }
        this.eUQ.setDatas(this.eUS);
        int size = this.eUS.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eUS.get(i3);
            if (this.eUU != null && this.eUU.equals(cVar.getGroupId())) {
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
        MessageManager.getInstance().registerListener(this.eUY);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bDy);
        MessageManager.getInstance().unRegisterListener(this.eUY);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.cdS) {
            this.cdS = skinType;
            onChangeSkinType(this.cdS);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eUQ.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eUT.size() && i != this.bpM) {
            this.eUP.i(this.eUT, i);
            this.eUQ.setCurrentTab(i);
            this.bpM = i;
            this.eUU = this.eUT.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bpM = -1;
        this.eUS.clear();
        this.eUP.reset();
        this.eUQ.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eUV = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void kB(int i) {
        if (i >= 0 && i < this.eUS.size() && i != this.bpM && this.eUP != null) {
            this.eUP.qm(i);
            this.bpM = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eUQ.onChangeSkinType(i);
        this.eUP.onChangeSkinType(i);
        am.h(this.eUR, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void qn(int i) {
        if (this.eUQ != null && i != this.bpM) {
            this.eUQ.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eUT.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.asp()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eUP.i(arrayList, 0);
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
        this.eUP.setOnDataSelected(editorTools);
        this.eUQ.setOnDataSelected(editorTools);
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
        if (this.eUQ != null) {
            int size = this.eUS.size();
            for (int i = 0; i < size; i++) {
                this.eUQ.setTabWidgetVisibility(i, this.eUV);
            }
            this.eUQ.setTabWidgetBigEmontionVisibility(this.eUV);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
