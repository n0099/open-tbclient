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
    private EditorTools VN;
    private int VO;
    private int bUK;
    private int biS;
    private CustomMessageListener bvt;
    private int eAA;
    private CustomMessageListener eAB;
    private EmotionTabContentView eAs;
    private EmotionTabWidgetView eAt;
    private View eAu;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAv;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAw;
    private String eAx;
    private boolean eAy;
    private boolean eAz;

    public EmotionTabHost(Context context) {
        super(context);
        this.eAv = new ArrayList<>();
        this.eAw = new ArrayList<>();
        this.biS = -1;
        this.eAx = null;
        this.bUK = -1;
        this.eAy = true;
        this.eAz = true;
        this.eAA = 0;
        this.VO = 0;
        this.bvt = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eAB = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eAv.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eAv.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eAv.get(i2)).ami() != EmotionGroupType.USER_COLLECT) {
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
        this.eAv = new ArrayList<>();
        this.eAw = new ArrayList<>();
        this.biS = -1;
        this.eAx = null;
        this.bUK = -1;
        this.eAy = true;
        this.eAz = true;
        this.eAA = 0;
        this.VO = 0;
        this.bvt = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eAB = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eAv.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eAv.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eAv.get(i2)).ami() != EmotionGroupType.USER_COLLECT) {
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
        this.eAs = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.eAt = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.eAu = findViewById(d.g.emotion_tab_widget_div_line);
        this.eAt.setOnTabSelectedListener(this);
        this.eAs.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bUK = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bUK);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eAt != null) {
            this.eAt.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eAz = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVC() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.aVM().aVO().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ami() != EmotionGroupType.BIG_EMOTION || this.eAy) {
                if (next.ami() != EmotionGroupType.USER_COLLECT || this.eAz) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eAv = e.aVM().aVO();
        if (!this.eAy || !this.eAz) {
            this.eAw = aVC();
            if (!this.eAz && this.eAv != null) {
                this.eAv = new ArrayList<>(e.aVM().aVO());
                int i = 0;
                while (true) {
                    if (i < this.eAv.size()) {
                        if (this.eAv.get(i).ami() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eAv.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eAw = e.aVM().aVO();
        }
        if ((this.eAv == null || this.eAv.size() <= 0) && this.eAA < 3) {
            this.eAA++;
            e.aVM().aVN();
            return;
        }
        this.eAt.setDatas(this.eAv);
        int size = this.eAv.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eAv.get(i3);
            if (this.eAx != null && this.eAx.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bvt);
        MessageManager.getInstance().registerListener(this.eAB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bvt);
        MessageManager.getInstance().unRegisterListener(this.eAB);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bUK) {
            this.bUK = skinType;
            onChangeSkinType(this.bUK);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAt.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eAw.size() && i != this.biS) {
            this.eAs.i(this.eAw, i);
            this.eAt.setCurrentTab(i);
            this.biS = i;
            this.eAx = this.eAw.get(i).getGroupId();
        }
    }

    public void reset() {
        this.biS = -1;
        this.eAv.clear();
        this.eAs.reset();
        this.eAt.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eAy = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void jH(int i) {
        if (i >= 0 && i < this.eAv.size() && i != this.biS && this.eAs != null) {
            this.eAs.oU(i);
            this.biS = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eAt.onChangeSkinType(i);
        this.eAs.onChangeSkinType(i);
        al.f(this.eAu, d.C0277d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void oV(int i) {
        if (this.eAt != null && i != this.biS) {
            this.eAt.setCurrentTab(i);
            this.biS = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAw.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.amh()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eAs.i(arrayList, 0);
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
        this.VN = editorTools;
        this.eAs.setOnDataSelected(editorTools);
        this.eAt.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.eAt != null) {
            int size = this.eAv.size();
            for (int i = 0; i < size; i++) {
                this.eAt.setTabWidgetVisibility(i, this.eAy);
            }
            this.eAt.setTabWidgetBigEmontionVisibility(this.eAy);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
