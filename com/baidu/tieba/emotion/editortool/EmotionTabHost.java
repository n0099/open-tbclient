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
    private EditorTools JO;
    private int JP;
    private CustomMessageListener UJ;
    private int aFH;
    private int aqQ;
    private CustomMessageListener cHA;
    private EmotionTabContentView cHr;
    private EmotionTabWidgetView cHs;
    private View cHt;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cHu;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cHv;
    private String cHw;
    private boolean cHx;
    private boolean cHy;
    private int cHz;

    public EmotionTabHost(Context context) {
        super(context);
        this.cHu = new ArrayList<>();
        this.cHv = new ArrayList<>();
        this.aFH = -1;
        this.cHw = null;
        this.aqQ = -1;
        this.cHx = true;
        this.cHy = true;
        this.cHz = 0;
        this.JP = 0;
        this.UJ = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cHA = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cHu.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cHu.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cHu.get(i2)).DS() != EmotionGroupType.USER_COLLECT) {
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
        this.cHu = new ArrayList<>();
        this.cHv = new ArrayList<>();
        this.aFH = -1;
        this.cHw = null;
        this.aqQ = -1;
        this.cHx = true;
        this.cHy = true;
        this.cHz = 0;
        this.JP = 0;
        this.UJ = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cHA = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cHu.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cHu.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cHu.get(i2)).DS() != EmotionGroupType.USER_COLLECT) {
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
        this.cHr = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.cHs = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.cHt = findViewById(d.g.emotion_tab_widget_div_line);
        this.cHs.setOnTabSelectedListener(this);
        this.cHr.setOnEmotionSwitchedListener(this);
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
        if (this.cHs != null) {
            this.cHs.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cHy = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> akc() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.akm().ako().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.DS() != EmotionGroupType.BIG_EMOTION || this.cHx) {
                if (next.DS() != EmotionGroupType.USER_COLLECT || this.cHy) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cHu = e.akm().ako();
        if (!this.cHx || !this.cHy) {
            this.cHv = akc();
            if (!this.cHy && this.cHu != null) {
                this.cHu = new ArrayList<>(e.akm().ako());
                int i = 0;
                while (true) {
                    if (i < this.cHu.size()) {
                        if (this.cHu.get(i).DS() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cHu.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cHv = e.akm().ako();
        }
        if ((this.cHu == null || this.cHu.size() <= 0) && this.cHz < 3) {
            this.cHz++;
            e.akm().akn();
            return;
        }
        this.cHs.setDatas(this.cHu);
        int size = this.cHu.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cHu.get(i3);
            if (this.cHw != null && this.cHw.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.UJ);
        MessageManager.getInstance().registerListener(this.cHA);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.UJ);
        MessageManager.getInstance().unRegisterListener(this.cHA);
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
        this.cHs.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cHv.size() && i != this.aFH) {
            this.cHr.h(this.cHv, i);
            this.cHs.setCurrentTab(i);
            this.aFH = i;
            this.cHw = this.cHv.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aFH = -1;
        this.cHu.clear();
        this.cHr.reset();
        this.cHs.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cHx = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eT(int i) {
        if (i >= 0 && i < this.cHu.size() && i != this.aFH && this.cHr != null) {
            this.cHr.jn(i);
            this.aFH = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cHs.onChangeSkinType(i);
        this.cHr.onChangeSkinType(i);
        ak.e(this.cHt, d.C0126d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void jo(int i) {
        if (this.cHs != null && i != this.aFH) {
            this.cHs.setCurrentTab(i);
            this.aFH = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cHv.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.DR()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cHr.h(arrayList, 0);
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
        this.JO = editorTools;
        this.cHr.setOnDataSelected(editorTools);
        this.cHs.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JO != null) {
            this.JO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lM() {
        if (this.cHs != null) {
            int size = this.cHu.size();
            for (int i = 0; i < size; i++) {
                this.cHs.setTabWidgetVisibility(i, this.cHx);
            }
            this.cHs.setTabWidgetBigEmontionVisibility(this.cHx);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
