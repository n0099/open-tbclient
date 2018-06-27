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
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Qj;
    private int Qk;
    private int aOZ;
    private CustomMessageListener acM;
    private int azP;
    private boolean cOA;
    private int cOB;
    private CustomMessageListener cOC;
    private EmotionTabContentView cOt;
    private EmotionTabWidgetView cOu;
    private View cOv;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cOw;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cOx;
    private String cOy;
    private boolean cOz;

    public EmotionTabHost(Context context) {
        super(context);
        this.cOw = new ArrayList<>();
        this.cOx = new ArrayList<>();
        this.aOZ = -1;
        this.cOy = null;
        this.azP = -1;
        this.cOz = true;
        this.cOA = true;
        this.cOB = 0;
        this.Qk = 0;
        this.acM = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cOC = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cOw.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cOw.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cOw.get(i2)).HN() != EmotionGroupType.USER_COLLECT) {
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
        this.cOw = new ArrayList<>();
        this.cOx = new ArrayList<>();
        this.aOZ = -1;
        this.cOy = null;
        this.azP = -1;
        this.cOz = true;
        this.cOA = true;
        this.cOB = 0;
        this.Qk = 0;
        this.acM = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.cOC = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.cOw.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.cOw.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.cOw.get(i2)).HN() != EmotionGroupType.USER_COLLECT) {
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
        this.cOt = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.cOu = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.cOv = findViewById(d.g.emotion_tab_widget_div_line);
        this.cOu.setOnTabSelectedListener(this);
        this.cOt.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.azP = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.azP);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cOu != null) {
            this.cOu.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cOA = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> anC() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.anM().anO().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.HN() != EmotionGroupType.BIG_EMOTION || this.cOz) {
                if (next.HN() != EmotionGroupType.USER_COLLECT || this.cOA) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cOw = e.anM().anO();
        if (!this.cOz || !this.cOA) {
            this.cOx = anC();
            if (!this.cOA && this.cOw != null) {
                this.cOw = new ArrayList<>(e.anM().anO());
                int i = 0;
                while (true) {
                    if (i < this.cOw.size()) {
                        if (this.cOw.get(i).HN() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cOw.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cOx = e.anM().anO();
        }
        if ((this.cOw == null || this.cOw.size() <= 0) && this.cOB < 3) {
            this.cOB++;
            e.anM().anN();
            return;
        }
        this.cOu.setDatas(this.cOw);
        int size = this.cOw.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cOw.get(i3);
            if (this.cOy != null && this.cOy.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.acM);
        MessageManager.getInstance().registerListener(this.cOC);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.acM);
        MessageManager.getInstance().unRegisterListener(this.cOC);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.azP) {
            this.azP = skinType;
            onChangeSkinType(this.azP);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cOu.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cOx.size() && i != this.aOZ) {
            this.cOt.i(this.cOx, i);
            this.cOu.setCurrentTab(i);
            this.aOZ = i;
            this.cOy = this.cOx.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aOZ = -1;
        this.cOw.clear();
        this.cOt.reset();
        this.cOu.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cOz = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eY(int i) {
        if (i >= 0 && i < this.cOw.size() && i != this.aOZ && this.cOt != null) {
            this.cOt.jo(i);
            this.aOZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cOu.onChangeSkinType(i);
        this.cOt.onChangeSkinType(i);
        am.e(this.cOv, d.C0142d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void jp(int i) {
        if (this.cOu != null && i != this.aOZ) {
            this.cOu.setCurrentTab(i);
            this.aOZ = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cOx.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.HM()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cOt.i(arrayList, 0);
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
        this.Qj = editorTools;
        this.cOt.setOnDataSelected(editorTools);
        this.cOu.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.cOu != null) {
            int size = this.cOw.size();
            for (int i = 0; i < size; i++) {
                this.cOu.setTabWidgetVisibility(i, this.cOz);
            }
            this.cOu.setTabWidgetBigEmontionVisibility(this.cOz);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
