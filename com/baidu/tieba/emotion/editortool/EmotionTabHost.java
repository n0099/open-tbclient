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
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools TB;
    private int TC;
    private CustomMessageListener bCA;
    private int boZ;
    private int ccI;
    private EmotionTabContentView ePH;
    private EmotionTabWidgetView ePI;
    private View ePJ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ePK;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ePL;
    private String ePM;
    private boolean ePN;
    private boolean ePO;
    private int ePP;
    private CustomMessageListener ePQ;

    public EmotionTabHost(Context context) {
        super(context);
        this.ePK = new ArrayList<>();
        this.ePL = new ArrayList<>();
        this.boZ = -1;
        this.ePM = null;
        this.ccI = -1;
        this.ePN = true;
        this.ePO = true;
        this.ePP = 0;
        this.TC = 0;
        this.bCA = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.ePQ = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ePK.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ePK.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ePK.get(i2)).ari() != EmotionGroupType.USER_COLLECT) {
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
        this.ePK = new ArrayList<>();
        this.ePL = new ArrayList<>();
        this.boZ = -1;
        this.ePM = null;
        this.ccI = -1;
        this.ePN = true;
        this.ePO = true;
        this.ePP = 0;
        this.TC = 0;
        this.bCA = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.ePQ = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ePK.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ePK.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ePK.get(i2)).ari() != EmotionGroupType.USER_COLLECT) {
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
        this.ePH = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.ePI = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.ePJ = findViewById(R.id.emotion_tab_widget_div_line);
        this.ePI.setOnTabSelectedListener(this);
        this.ePH.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ccI = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.ccI);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.ePI != null) {
            this.ePI.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.ePO = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bcI() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bcS().bcU().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ari() != EmotionGroupType.BIG_EMOTION || this.ePN) {
                if (next.ari() != EmotionGroupType.USER_COLLECT || this.ePO) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.ePK = e.bcS().bcU();
        if (!this.ePN || !this.ePO) {
            this.ePL = bcI();
            if (!this.ePO && this.ePK != null) {
                this.ePK = new ArrayList<>(e.bcS().bcU());
                int i = 0;
                while (true) {
                    if (i < this.ePK.size()) {
                        if (this.ePK.get(i).ari() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.ePK.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.ePL = e.bcS().bcU();
        }
        if ((this.ePK == null || this.ePK.size() <= 0) && this.ePP < 3) {
            this.ePP++;
            e.bcS().bcT();
            return;
        }
        this.ePI.setDatas(this.ePK);
        int size = this.ePK.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ePK.get(i3);
            if (this.ePM != null && this.ePM.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bCA);
        MessageManager.getInstance().registerListener(this.ePQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bCA);
        MessageManager.getInstance().unRegisterListener(this.ePQ);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ccI) {
            this.ccI = skinType;
            onChangeSkinType(this.ccI);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ePI.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.ePL.size() && i != this.boZ) {
            this.ePH.i(this.ePL, i);
            this.ePI.setCurrentTab(i);
            this.boZ = i;
            this.ePM = this.ePL.get(i).getGroupId();
        }
    }

    public void reset() {
        this.boZ = -1;
        this.ePK.clear();
        this.ePH.reset();
        this.ePI.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.ePN = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ku(int i) {
        if (i >= 0 && i < this.ePK.size() && i != this.boZ && this.ePH != null) {
            this.ePH.pU(i);
            this.boZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ePI.onChangeSkinType(i);
        this.ePH.onChangeSkinType(i);
        al.h(this.ePJ, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void pV(int i) {
        if (this.ePI != null && i != this.boZ) {
            this.ePI.setCurrentTab(i);
            this.boZ = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ePL.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.arh()) {
                                    arrayList.add(next);
                                }
                            }
                            this.ePH.i(arrayList, 0);
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
        this.TB = editorTools;
        this.ePH.setOnDataSelected(editorTools);
        this.ePI.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TB != null) {
            this.TB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TC = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TC;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.ePI != null) {
            int size = this.ePK.size();
            for (int i = 0; i < size; i++) {
                this.ePI.setTabWidgetVisibility(i, this.ePN);
            }
            this.ePI.setTabWidgetBigEmontionVisibility(this.ePN);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
