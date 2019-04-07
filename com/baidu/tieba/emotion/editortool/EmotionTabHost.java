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
    private int bUM;
    private int biV;
    private CustomMessageListener bvw;
    private EmotionTabContentView eAd;
    private EmotionTabWidgetView eAe;
    private View eAf;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAg;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eAh;
    private String eAi;
    private boolean eAj;
    private boolean eAk;
    private int eAl;
    private CustomMessageListener eAm;

    public EmotionTabHost(Context context) {
        super(context);
        this.eAg = new ArrayList<>();
        this.eAh = new ArrayList<>();
        this.biV = -1;
        this.eAi = null;
        this.bUM = -1;
        this.eAj = true;
        this.eAk = true;
        this.eAl = 0;
        this.VO = 0;
        this.bvw = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eAm = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eAg.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eAg.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eAg.get(i2)).amf() != EmotionGroupType.USER_COLLECT) {
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
        this.eAg = new ArrayList<>();
        this.eAh = new ArrayList<>();
        this.biV = -1;
        this.eAi = null;
        this.bUM = -1;
        this.eAj = true;
        this.eAk = true;
        this.eAl = 0;
        this.VO = 0;
        this.bvw = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.eAm = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.eAg.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.eAg.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.eAg.get(i2)).amf() != EmotionGroupType.USER_COLLECT) {
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
        this.eAd = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.eAe = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.eAf = findViewById(d.g.emotion_tab_widget_div_line);
        this.eAe.setOnTabSelectedListener(this);
        this.eAd.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bUM = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bUM);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.eAe != null) {
            this.eAe.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.eAk = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVA() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.aVK().aVM().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.amf() != EmotionGroupType.BIG_EMOTION || this.eAj) {
                if (next.amf() != EmotionGroupType.USER_COLLECT || this.eAk) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.eAg = e.aVK().aVM();
        if (!this.eAj || !this.eAk) {
            this.eAh = aVA();
            if (!this.eAk && this.eAg != null) {
                this.eAg = new ArrayList<>(e.aVK().aVM());
                int i = 0;
                while (true) {
                    if (i < this.eAg.size()) {
                        if (this.eAg.get(i).amf() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.eAg.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.eAh = e.aVK().aVM();
        }
        if ((this.eAg == null || this.eAg.size() <= 0) && this.eAl < 3) {
            this.eAl++;
            e.aVK().aVL();
            return;
        }
        this.eAe.setDatas(this.eAg);
        int size = this.eAg.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eAg.get(i3);
            if (this.eAi != null && this.eAi.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bvw);
        MessageManager.getInstance().registerListener(this.eAm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bvw);
        MessageManager.getInstance().unRegisterListener(this.eAm);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bUM) {
            this.bUM = skinType;
            onChangeSkinType(this.bUM);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAe.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.eAh.size() && i != this.biV) {
            this.eAd.i(this.eAh, i);
            this.eAe.setCurrentTab(i);
            this.biV = i;
            this.eAi = this.eAh.get(i).getGroupId();
        }
    }

    public void reset() {
        this.biV = -1;
        this.eAg.clear();
        this.eAd.reset();
        this.eAe.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.eAj = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void jG(int i) {
        if (i >= 0 && i < this.eAg.size() && i != this.biV && this.eAd != null) {
            this.eAd.oQ(i);
            this.biV = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.eAe.onChangeSkinType(i);
        this.eAd.onChangeSkinType(i);
        al.f(this.eAf, d.C0277d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void oR(int i) {
        if (this.eAe != null && i != this.biV) {
            this.eAe.setCurrentTab(i);
            this.biV = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAh.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.ame()) {
                                    arrayList.add(next);
                                }
                            }
                            this.eAd.i(arrayList, 0);
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
        this.eAd.setOnDataSelected(editorTools);
        this.eAe.setOnDataSelected(editorTools);
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
        if (this.eAe != null) {
            int size = this.eAg.size();
            for (int i = 0; i < size; i++) {
                this.eAe.setTabWidgetVisibility(i, this.eAj);
            }
            this.eAe.setTabWidgetBigEmontionVisibility(this.eAj);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
