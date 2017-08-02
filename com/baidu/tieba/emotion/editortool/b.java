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
import com.baidu.tbadk.core.util.ai;
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
    private int JS;
    private i JT;
    private CustomMessageListener Se;
    private int aDH;
    private int aoR;
    private EmotionTabContentView bVV;
    private EmotionTabWidgetView bVW;
    private View bVX;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bVY;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bVZ;
    private String bWa;
    private boolean bWb;
    private boolean bWc;
    private boolean bWd;
    private int bWe;

    public b(Context context) {
        super(context);
        this.bVY = new ArrayList<>();
        this.bVZ = new ArrayList<>();
        this.aDH = -1;
        this.bWa = null;
        this.aoR = -1;
        this.bWc = true;
        this.bWd = true;
        this.bWe = 0;
        this.JS = 0;
        this.Se = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.emotion_tab_host, (ViewGroup) this, true);
        this.bVV = (EmotionTabContentView) findViewById(d.h.face_tab_content);
        this.bVW = (EmotionTabWidgetView) findViewById(d.h.face_tab_widget);
        this.bVX = findViewById(d.h.emotion_tab_widget_div_line);
        this.bVW.setOnTabSelectedListener(this);
        this.bVV.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aoR = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aoR);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bVW != null) {
            this.bVW.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.bWd = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aaO() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.aaY().aba().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Dh() != EmotionGroupType.BIG_EMOTION || this.bWc) {
                if (next.Dh() != EmotionGroupType.USER_COLLECT || this.bWd) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bVY = g.aaY().aba();
        if (!this.bWc || !this.bWd) {
            this.bVZ = aaO();
            if (!this.bWd && this.bVY != null) {
                this.bVY = new ArrayList<>(g.aaY().aba());
                int i = 0;
                while (true) {
                    if (i < this.bVY.size()) {
                        if (this.bVY.get(i).Dh() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.bVY.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.bVZ = g.aaY().aba();
        }
        if ((this.bVY == null || this.bVY.size() <= 0) && this.bWe < 3) {
            this.bWe++;
            g.aaY().aaZ();
            return;
        }
        this.bVW.setDatas(this.bVY);
        int size = this.bVY.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bVY.get(i3);
            if (this.bWa != null && this.bWa.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Se);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Se);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoR) {
            this.aoR = skinType;
            onChangeSkinType(this.aoR);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bVW.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bVZ.size() && i != this.aDH) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bVZ.get(i);
            this.bVV.h(this.bVZ, i);
            if (this.bWb) {
                if (cVar.Dh() == EmotionGroupType.LOCAL) {
                    this.bVW.setShowDelete(true);
                } else {
                    this.bVW.setShowDelete(false);
                }
            }
            this.bVW.setCurrentTab(i);
            this.aDH = i;
            this.bWa = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aDH = -1;
        this.bVY.clear();
        this.bVV.reset();
        this.bVW.reset();
    }

    public void setIsInChat(boolean z) {
        this.bWb = z;
        this.bVW.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bWc = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eR(int i) {
        if (i >= 0 && i < this.bVY.size() && i != this.aDH && this.bVV != null) {
            this.bVV.hT(i);
            this.aDH = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.bVW.onChangeSkinType(i);
        this.bVV.onChangeSkinType(i);
        ai.e(this.bVX, d.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hU(int i) {
        if (this.bVW != null && i != this.aDH) {
            this.bVW.setCurrentTab(i);
            this.aDH = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bVZ.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Dg()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bVV.h(arrayList, 0);
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
        this.JT = iVar;
        this.bVV.setOnDataSelected(iVar);
        this.bVW.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lJ() {
        if (this.bVW != null) {
            int size = this.bVY.size();
            for (int i = 0; i < size; i++) {
                this.bVW.n(i, this.bWc);
            }
            this.bVW.setTabWidgetBigEmontionVisibility(this.bWc);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
