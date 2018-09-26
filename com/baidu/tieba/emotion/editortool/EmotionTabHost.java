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
import com.baidu.tieba.e;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools SG;
    private int SH;
    private int aCJ;
    private int aSn;
    private CustomMessageListener aeT;
    private EmotionTabContentView cWQ;
    private EmotionTabWidgetView cWR;
    private View cWS;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cWT;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cWU;
    private String cWV;
    private boolean cWW;
    private boolean cWX;
    private int cWY;
    private CustomMessageListener cWZ;

    public EmotionTabHost(Context context) {
        super(context);
        this.cWT = new ArrayList<>();
        this.cWU = new ArrayList<>();
        this.aSn = -1;
        this.cWV = null;
        this.aCJ = -1;
        this.cWW = true;
        this.cWX = true;
        this.cWY = 0;
        this.SH = 0;
        this.aeT = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cWZ = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cWT.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cWT.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cWT.get(i2)).IY() != EmotionGroupType.USER_COLLECT) {
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
        this.cWT = new ArrayList<>();
        this.cWU = new ArrayList<>();
        this.aSn = -1;
        this.cWV = null;
        this.aCJ = -1;
        this.cWW = true;
        this.cWX = true;
        this.cWY = 0;
        this.SH = 0;
        this.aeT = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cWZ = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cWT.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cWT.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cWT.get(i2)).IY() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(e.h.emotion_tab_host, (ViewGroup) this, true);
        this.cWQ = (EmotionTabContentView) findViewById(e.g.face_tab_content);
        this.cWR = (EmotionTabWidgetView) findViewById(e.g.face_tab_widget);
        this.cWS = findViewById(e.g.emotion_tab_widget_div_line);
        this.cWR.setOnTabSelectedListener(this);
        this.cWQ.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aCJ = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aCJ);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cWR != null) {
            this.cWR.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cWX = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> apQ() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.aqa().aqc().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.IY() != EmotionGroupType.BIG_EMOTION || this.cWW) {
                if (next.IY() != EmotionGroupType.USER_COLLECT || this.cWX) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cWT = e.aqa().aqc();
        if (!this.cWW || !this.cWX) {
            this.cWU = apQ();
            if (!this.cWX && this.cWT != null) {
                this.cWT = new ArrayList<>(e.aqa().aqc());
                int i = 0;
                while (true) {
                    if (i < this.cWT.size()) {
                        if (this.cWT.get(i).IY() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cWT.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cWU = e.aqa().aqc();
        }
        if ((this.cWT == null || this.cWT.size() <= 0) && this.cWY < 3) {
            this.cWY++;
            e.aqa().aqb();
            return;
        }
        this.cWR.setDatas(this.cWT);
        int size = this.cWT.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cWT.get(i3);
            if (this.cWV != null && this.cWV.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aeT);
        MessageManager.getInstance().registerListener(this.cWZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aeT);
        MessageManager.getInstance().unRegisterListener(this.cWZ);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aCJ) {
            this.aCJ = skinType;
            onChangeSkinType(this.aCJ);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cWR.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cWU.size() && i != this.aSn) {
            this.cWQ.i(this.cWU, i);
            this.cWR.setCurrentTab(i);
            this.aSn = i;
            this.cWV = this.cWU.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aSn = -1;
        this.cWT.clear();
        this.cWQ.reset();
        this.cWR.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cWW = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fk(int i) {
        if (i >= 0 && i < this.cWT.size() && i != this.aSn && this.cWQ != null) {
            this.cWQ.jY(i);
            this.aSn = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cWR.onChangeSkinType(i);
        this.cWQ.onChangeSkinType(i);
        al.e(this.cWS, e.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void jZ(int i) {
        if (this.cWR != null && i != this.aSn) {
            this.cWR.setCurrentTab(i);
            this.aSn = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cWU.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.IX()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cWQ.i(arrayList, 0);
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
        this.SG = editorTools;
        this.cWQ.setOnDataSelected(editorTools);
        this.cWR.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pI() {
        if (this.cWR != null) {
            int size = this.cWT.size();
            for (int i = 0; i < size; i++) {
                this.cWR.setTabWidgetVisibility(i, this.cWW);
            }
            this.cWR.setTabWidgetBigEmontionVisibility(this.cWW);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
