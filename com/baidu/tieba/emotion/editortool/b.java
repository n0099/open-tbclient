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
    private int Ls;
    private i Lt;
    private CustomMessageListener TE;
    private int aEZ;
    private int aqm;
    private EmotionTabContentView bXO;
    private EmotionTabWidgetView bXP;
    private View bXQ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bXR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bXS;
    private String bXT;
    private boolean bXU;
    private boolean bXV;
    private boolean bXW;
    private int bXX;

    public b(Context context) {
        super(context);
        this.bXR = new ArrayList<>();
        this.bXS = new ArrayList<>();
        this.aEZ = -1;
        this.bXT = null;
        this.aqm = -1;
        this.bXV = true;
        this.bXW = true;
        this.bXX = 0;
        this.Ls = 0;
        this.TE = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.bXO = (EmotionTabContentView) findViewById(d.h.face_tab_content);
        this.bXP = (EmotionTabWidgetView) findViewById(d.h.face_tab_widget);
        this.bXQ = findViewById(d.h.emotion_tab_widget_div_line);
        this.bXP.setOnTabSelectedListener(this);
        this.bXO.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aqm = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aqm);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bXP != null) {
            this.bXP.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.bXW = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> abl() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.abv().abx().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Dp() != EmotionGroupType.BIG_EMOTION || this.bXV) {
                if (next.Dp() != EmotionGroupType.USER_COLLECT || this.bXW) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bXR = g.abv().abx();
        if (!this.bXV || !this.bXW) {
            this.bXS = abl();
            if (!this.bXW && this.bXR != null) {
                this.bXR = new ArrayList<>(g.abv().abx());
                int i = 0;
                while (true) {
                    if (i < this.bXR.size()) {
                        if (this.bXR.get(i).Dp() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.bXR.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.bXS = g.abv().abx();
        }
        if ((this.bXR == null || this.bXR.size() <= 0) && this.bXX < 3) {
            this.bXX++;
            g.abv().abw();
            return;
        }
        this.bXP.setDatas(this.bXR);
        int size = this.bXR.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bXR.get(i3);
            if (this.bXT != null && this.bXT.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TE);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aqm) {
            this.aqm = skinType;
            onChangeSkinType(this.aqm);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bXP.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bXS.size() && i != this.aEZ) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bXS.get(i);
            this.bXO.h(this.bXS, i);
            if (this.bXU) {
                if (cVar.Dp() == EmotionGroupType.LOCAL) {
                    this.bXP.setShowDelete(true);
                } else {
                    this.bXP.setShowDelete(false);
                }
            }
            this.bXP.setCurrentTab(i);
            this.aEZ = i;
            this.bXT = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aEZ = -1;
        this.bXR.clear();
        this.bXO.reset();
        this.bXP.reset();
    }

    public void setIsInChat(boolean z) {
        this.bXU = z;
        this.bXP.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bXV = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eT(int i) {
        if (i >= 0 && i < this.bXR.size() && i != this.aEZ && this.bXO != null) {
            this.bXO.hV(i);
            this.aEZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.bXP.onChangeSkinType(i);
        this.bXO.onChangeSkinType(i);
        ai.e(this.bXQ, d.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hW(int i) {
        if (this.bXP != null && i != this.aEZ) {
            this.bXP.setCurrentTab(i);
            this.aEZ = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bXS.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Do()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bXO.h(arrayList, 0);
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
        this.Lt = iVar;
        this.bXO.setOnDataSelected(iVar);
        this.bXP.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ls = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ls;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lS() {
        if (this.bXP != null) {
            int size = this.bXR.size();
            for (int i = 0; i < size; i++) {
                this.bXP.n(i, this.bXV);
            }
            this.bXP.setTabWidgetBigEmontionVisibility(this.bXV);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
