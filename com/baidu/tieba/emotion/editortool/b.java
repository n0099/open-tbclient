package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends NoPressedLinearLayout implements s, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private CustomMessageListener aIh;
    private i axO;
    private int axP;
    private int bdE;
    private int bsN;
    private EmotionTabContentView dgB;
    private EmotionTabWidgetView dgC;
    private View dgD;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dgE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dgF;
    private String dgG;
    private boolean dgH;
    private boolean dgI;
    private int dgJ;
    private CustomMessageListener dgK;

    public b(Context context) {
        super(context);
        this.dgE = new ArrayList<>();
        this.dgF = new ArrayList<>();
        this.bsN = -1;
        this.dgG = null;
        this.bdE = -1;
        this.dgH = true;
        this.dgI = true;
        this.dgJ = 0;
        this.axP = 0;
        this.aIh = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                switch (customResponsedMessage.getCmd()) {
                    case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                        b.this.reset();
                        b.this.setup();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dgK = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.dgE.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.dgE.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.dgE.get(i2)).KU() != EmotionGroupType.USER_COLLECT) {
                                i = i2 + 1;
                            } else {
                                b.this.setCurrentEmotionGroup(i2);
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
        this.dgB = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.dgC = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.dgD = findViewById(d.g.emotion_tab_widget_div_line);
        this.dgC.setOnTabSelectedListener(this);
        this.dgB.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.bdE = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.bdE);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.dgC != null) {
            this.dgC.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.dgI = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> anX() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.aoh().aoj().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.KU() != EmotionGroupType.BIG_EMOTION || this.dgH) {
                if (next.KU() != EmotionGroupType.USER_COLLECT || this.dgI) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.dgE = g.aoh().aoj();
        if (!this.dgH || !this.dgI) {
            this.dgF = anX();
            if (!this.dgI && this.dgE != null) {
                this.dgE = new ArrayList<>(g.aoh().aoj());
                int i = 0;
                while (true) {
                    if (i < this.dgE.size()) {
                        if (this.dgE.get(i).KU() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.dgE.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.dgF = g.aoh().aoj();
        }
        if ((this.dgE == null || this.dgE.size() <= 0) && this.dgJ < 3) {
            this.dgJ++;
            g.aoh().aoi();
            return;
        }
        this.dgC.setDatas(this.dgE);
        int size = this.dgE.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dgE.get(i3);
            if (this.dgG != null && this.dgG.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.aIh);
        MessageManager.getInstance().registerListener(this.dgK);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.aIh);
        MessageManager.getInstance().unRegisterListener(this.dgK);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.bdE) {
            this.bdE = skinType;
            onChangeSkinType(this.bdE);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dgC.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.dgF.size() && i != this.bsN) {
            this.dgB.l(this.dgF, i);
            this.dgC.setCurrentTab(i);
            this.bsN = i;
            this.dgG = this.dgF.get(i).getGroupId();
        }
    }

    public void reset() {
        this.bsN = -1;
        this.dgE.clear();
        this.dgB.reset();
        this.dgC.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.dgH = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void hZ(int i) {
        if (i >= 0 && i < this.dgE.size() && i != this.bsN && this.dgB != null) {
            this.dgB.md(i);
            this.bsN = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.dgC.onChangeSkinType(i);
        this.dgB.onChangeSkinType(i);
        aj.g(this.dgD, d.C0108d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void me(int i) {
        if (this.dgC != null && i != this.bsN) {
            this.dgC.setCurrentTab(i);
            this.bsN = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dgF.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.KT()) {
                                    arrayList.add(next);
                                }
                            }
                            this.dgB.l(arrayList, 0);
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

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axO = iVar;
        this.dgB.setOnDataSelected(iVar);
        this.dgC.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axP = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axP;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.dgC != null) {
            int size = this.dgE.size();
            for (int i = 0; i < size; i++) {
                this.dgC.y(i, this.dgH);
            }
            this.dgC.setTabWidgetBigEmontionVisibility(this.dgH);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
