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
/* loaded from: classes5.dex */
public class EmotionTabHost extends NoPressedLinearLayout implements l, EmotionTabContentView.b, EmotionTabWidgetView.a {
    private EditorTools Tj;
    private int Tk;
    private int aMk;
    private CustomMessageListener aoI;
    private EmotionTabWidgetView dqA;
    private View dqB;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dqC;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dqD;
    private String dqE;
    private boolean dqF;
    private boolean dqG;
    private int dqH;
    private CustomMessageListener dqI;
    private EmotionTabContentView dqz;
    private int mCurrentIndex;

    public EmotionTabHost(Context context) {
        super(context);
        this.dqC = new ArrayList<>();
        this.dqD = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dqE = null;
        this.aMk = -1;
        this.dqF = true;
        this.dqG = true;
        this.dqH = 0;
        this.Tk = 0;
        this.aoI = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.dqI = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dqC.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dqC.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dqC.get(i2)).ME() != EmotionGroupType.USER_COLLECT) {
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
        this.dqC = new ArrayList<>();
        this.dqD = new ArrayList<>();
        this.mCurrentIndex = -1;
        this.dqE = null;
        this.aMk = -1;
        this.dqF = true;
        this.dqG = true;
        this.dqH = 0;
        this.Tk = 0;
        this.aoI = new CustomMessageListener(2001117) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.1
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
        this.dqI = new CustomMessageListener(2921304) { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && EmotionTabHost.this.dqC.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < EmotionTabHost.this.dqC.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHost.this.dqC.get(i2)).ME() != EmotionGroupType.USER_COLLECT) {
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
        this.dqz = (EmotionTabContentView) findViewById(e.g.face_tab_content);
        this.dqA = (EmotionTabWidgetView) findViewById(e.g.face_tab_widget);
        this.dqB = findViewById(e.g.emotion_tab_widget_div_line);
        this.dqA.setOnTabSelectedListener(this);
        this.dqz.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aMk = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aMk);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dqA != null) {
            this.dqA.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dqG = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> avL() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = e.avV().avX().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.ME() != EmotionGroupType.BIG_EMOTION || this.dqF) {
                if (next.ME() != EmotionGroupType.USER_COLLECT || this.dqG) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dqC = e.avV().avX();
        if (!this.dqF || !this.dqG) {
            this.dqD = avL();
            if (!this.dqG && this.dqC != null) {
                this.dqC = new ArrayList<>(e.avV().avX());
                int i = 0;
                while (true) {
                    if (i < this.dqC.size()) {
                        if (this.dqC.get(i).ME() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dqC.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dqD = e.avV().avX();
        }
        if ((this.dqC == null || this.dqC.size() <= 0) && this.dqH < 3) {
            this.dqH++;
            e.avV().avW();
            return;
        }
        this.dqA.setDatas(this.dqC);
        int size = this.dqC.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dqC.get(i3);
            if (this.dqE != null && this.dqE.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aoI);
        MessageManager.getInstance().registerListener(this.dqI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aoI);
        MessageManager.getInstance().unRegisterListener(this.dqI);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aMk) {
            this.aMk = skinType;
            onChangeSkinType(this.aMk);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dqA.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dqD.size() && i != this.mCurrentIndex) {
            this.dqz.j(this.dqD, i);
            this.dqA.setCurrentTab(i);
            this.mCurrentIndex = i;
            this.dqE = this.dqD.get(i).getGroupId();
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dqC.clear();
        this.dqz.reset();
        this.dqA.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dqF = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fW(int i) {
        if (i >= 0 && i < this.dqC.size() && i != this.mCurrentIndex && this.dqz != null) {
            this.dqz.ls(i);
            this.mCurrentIndex = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.dqA.onChangeSkinType(i);
        this.dqz.onChangeSkinType(i);
        al.e(this.dqB, e.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.b
    public void lt(int i) {
        if (this.dqA != null && i != this.mCurrentIndex) {
            this.dqA.setCurrentTab(i);
            this.mCurrentIndex = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dqD.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.MD()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dqz.j(arrayList, 0);
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
        this.Tj = editorTools;
        this.dqz.setOnDataSelected(editorTools);
        this.dqA.setOnDataSelected(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        if (this.dqA != null) {
            int size = this.dqC.size();
            for (int i = 0; i < size; i++) {
                this.dqA.setTabWidgetVisibility(i, this.dqF);
            }
            this.dqA.setTabWidgetBigEmontionVisibility(this.dqF);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }
}
