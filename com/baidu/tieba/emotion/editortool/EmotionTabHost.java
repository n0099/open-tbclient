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
    private EmotionTabContentView ePI;
    private EmotionTabWidgetView ePJ;
    private View ePK;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ePL;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ePM;
    private String ePN;
    private boolean ePO;
    private boolean ePP;
    private int ePQ;
    private CustomMessageListener ePR;

    public EmotionTabHost(Context context) {
        super(context);
        this.ePL = new ArrayList<>();
        this.ePM = new ArrayList<>();
        this.boZ = -1;
        this.ePN = null;
        this.ccI = -1;
        this.ePO = true;
        this.ePP = true;
        this.ePQ = 0;
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
        this.ePR = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ePL.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ePL.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ePL.get(i2)).ari() != EmotionGroupType.USER_COLLECT) {
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
        this.ePL = new ArrayList<>();
        this.ePM = new ArrayList<>();
        this.boZ = -1;
        this.ePN = null;
        this.ccI = -1;
        this.ePO = true;
        this.ePP = true;
        this.ePQ = 0;
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
        this.ePR = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.ePL.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.ePL.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.ePL.get(i2)).ari() != EmotionGroupType.USER_COLLECT) {
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
        this.ePI = (EmotionTabContentView) findViewById(R.id.face_tab_content);
        this.ePJ = (EmotionTabWidgetView) findViewById(R.id.face_tab_widget);
        this.ePK = findViewById(R.id.emotion_tab_widget_div_line);
        this.ePJ.setOnTabSelectedListener(this);
        this.ePI.setOnEmotionSwitchedListener(this);
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
        if (this.ePJ != null) {
            this.ePJ.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.ePP = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bcL() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.bcV().bcX().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ari() != EmotionGroupType.BIG_EMOTION || this.ePO) {
                if (next.ari() != EmotionGroupType.USER_COLLECT || this.ePP) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.ePL = e.bcV().bcX();
        if (!this.ePO || !this.ePP) {
            this.ePM = bcL();
            if (!this.ePP && this.ePL != null) {
                this.ePL = new ArrayList<>(e.bcV().bcX());
                int i = 0;
                while (true) {
                    if (i < this.ePL.size()) {
                        if (this.ePL.get(i).ari() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.ePL.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.ePM = e.bcV().bcX();
        }
        if ((this.ePL == null || this.ePL.size() <= 0) && this.ePQ < 3) {
            this.ePQ++;
            e.bcV().bcW();
            return;
        }
        this.ePJ.setDatas(this.ePL);
        int size = this.ePL.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ePL.get(i3);
            if (this.ePN != null && this.ePN.equals(cVar.getGroupId())) {
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
        MessageManager.getInstance().registerListener(this.ePR);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bCA);
        MessageManager.getInstance().unRegisterListener(this.ePR);
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
        this.ePJ.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.ePM.size() && i != this.boZ) {
            this.ePI.i(this.ePM, i);
            this.ePJ.setCurrentTab(i);
            this.boZ = i;
            this.ePN = this.ePM.get(i).getGroupId();
        }
    }

    public void reset() {
        this.boZ = -1;
        this.ePL.clear();
        this.ePI.reset();
        this.ePJ.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.ePO = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ku(int i) {
        if (i >= 0 && i < this.ePL.size() && i != this.boZ && this.ePI != null) {
            this.ePI.pU(i);
            this.boZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ePJ.onChangeSkinType(i);
        this.ePI.onChangeSkinType(i);
        al.h(this.ePK, R.color.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void pV(int i) {
        if (this.ePJ != null && i != this.boZ) {
            this.ePJ.setCurrentTab(i);
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ePM.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.arh()) {
                                    arrayList.add(next);
                                }
                            }
                            this.ePI.i(arrayList, 0);
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
        this.ePI.setOnDataSelected(editorTools);
        this.ePJ.setOnDataSelected(editorTools);
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
        if (this.ePJ != null) {
            int size = this.ePL.size();
            for (int i = 0; i < size; i++) {
                this.ePJ.setTabWidgetVisibility(i, this.ePO);
            }
            this.ePJ.setTabWidgetBigEmontionVisibility(this.ePO);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
