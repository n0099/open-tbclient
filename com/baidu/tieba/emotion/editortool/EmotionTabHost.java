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
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Qg;
    private int Qh;
    private int aOV;
    private CustomMessageListener acr;
    private int azF;
    private EmotionTabContentView cQZ;
    private EmotionTabWidgetView cRa;
    private View cRb;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cRc;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cRd;
    private String cRe;
    private boolean cRf;
    private boolean cRg;
    private int cRh;
    private CustomMessageListener cRi;

    public EmotionTabHost(Context context) {
        super(context);
        this.cRc = new ArrayList<>();
        this.cRd = new ArrayList<>();
        this.aOV = -1;
        this.cRe = null;
        this.azF = -1;
        this.cRf = true;
        this.cRg = true;
        this.cRh = 0;
        this.Qh = 0;
        this.acr = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cRi = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cRc.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cRc.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cRc.get(i2)).HI() != EmotionGroupType.USER_COLLECT) {
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
        this.cRc = new ArrayList<>();
        this.cRd = new ArrayList<>();
        this.aOV = -1;
        this.cRe = null;
        this.azF = -1;
        this.cRf = true;
        this.cRg = true;
        this.cRh = 0;
        this.Qh = 0;
        this.acr = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cRi = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cRc.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cRc.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cRc.get(i2)).HI() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(f.h.emotion_tab_host, (ViewGroup) this, true);
        this.cQZ = (EmotionTabContentView) findViewById(f.g.face_tab_content);
        this.cRa = (EmotionTabWidgetView) findViewById(f.g.face_tab_widget);
        this.cRb = findViewById(f.g.emotion_tab_widget_div_line);
        this.cRa.setOnTabSelectedListener(this);
        this.cQZ.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.azF = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.azF);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cRa != null) {
            this.cRa.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cRg = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aob() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.aol().aon().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.HI() != EmotionGroupType.BIG_EMOTION || this.cRf) {
                if (next.HI() != EmotionGroupType.USER_COLLECT || this.cRg) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cRc = e.aol().aon();
        if (!this.cRf || !this.cRg) {
            this.cRd = aob();
            if (!this.cRg && this.cRc != null) {
                this.cRc = new ArrayList<>(e.aol().aon());
                int i = 0;
                while (true) {
                    if (i < this.cRc.size()) {
                        if (this.cRc.get(i).HI() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cRc.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cRd = e.aol().aon();
        }
        if ((this.cRc == null || this.cRc.size() <= 0) && this.cRh < 3) {
            this.cRh++;
            e.aol().aom();
            return;
        }
        this.cRa.setDatas(this.cRc);
        int size = this.cRc.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cRc.get(i3);
            if (this.cRe != null && this.cRe.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.acr);
        MessageManager.getInstance().registerListener(this.cRi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.acr);
        MessageManager.getInstance().unRegisterListener(this.cRi);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.azF) {
            this.azF = skinType;
            onChangeSkinType(this.azF);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cRa.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cRd.size() && i != this.aOV) {
            this.cQZ.i(this.cRd, i);
            this.cRa.setCurrentTab(i);
            this.aOV = i;
            this.cRe = this.cRd.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aOV = -1;
        this.cRc.clear();
        this.cQZ.reset();
        this.cRa.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cRf = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eY(int i) {
        if (i >= 0 && i < this.cRc.size() && i != this.aOV && this.cQZ != null) {
            this.cQZ.jz(i);
            this.aOV = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cRa.onChangeSkinType(i);
        this.cQZ.onChangeSkinType(i);
        am.e(this.cRb, f.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void jA(int i) {
        if (this.cRa != null && i != this.aOV) {
            this.cRa.setCurrentTab(i);
            this.aOV = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cRd.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.HH()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cQZ.i(arrayList, 0);
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
        this.Qg = editorTools;
        this.cQZ.setOnDataSelected(editorTools);
        this.cRa.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oC() {
        if (this.cRa != null) {
            int size = this.cRc.size();
            for (int i = 0; i < size; i++) {
                this.cRa.setTabWidgetVisibility(i, this.cRf);
            }
            this.cRa.setTabWidgetBigEmontionVisibility(this.cRf);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
