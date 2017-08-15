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
    private CustomMessageListener TD;
    private int aEY;
    private int aqm;
    private EmotionTabContentView bXN;
    private EmotionTabWidgetView bXO;
    private View bXP;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bXQ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bXR;
    private String bXS;
    private boolean bXT;
    private boolean bXU;
    private boolean bXV;
    private int bXW;

    public b(Context context) {
        super(context);
        this.bXQ = new ArrayList<>();
        this.bXR = new ArrayList<>();
        this.aEY = -1;
        this.bXS = null;
        this.aqm = -1;
        this.bXU = true;
        this.bXV = true;
        this.bXW = 0;
        this.Ls = 0;
        this.TD = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.bXN = (EmotionTabContentView) findViewById(d.h.face_tab_content);
        this.bXO = (EmotionTabWidgetView) findViewById(d.h.face_tab_widget);
        this.bXP = findViewById(d.h.emotion_tab_widget_div_line);
        this.bXO.setOnTabSelectedListener(this);
        this.bXN.setOnEmotionSwitchedListener(this);
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
        if (this.bXO != null) {
            this.bXO.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.bXV = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> abo() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.aby().abA().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Dp() != EmotionGroupType.BIG_EMOTION || this.bXU) {
                if (next.Dp() != EmotionGroupType.USER_COLLECT || this.bXV) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bXQ = g.aby().abA();
        if (!this.bXU || !this.bXV) {
            this.bXR = abo();
            if (!this.bXV && this.bXQ != null) {
                this.bXQ = new ArrayList<>(g.aby().abA());
                int i = 0;
                while (true) {
                    if (i < this.bXQ.size()) {
                        if (this.bXQ.get(i).Dp() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.bXQ.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.bXR = g.aby().abA();
        }
        if ((this.bXQ == null || this.bXQ.size() <= 0) && this.bXW < 3) {
            this.bXW++;
            g.aby().abz();
            return;
        }
        this.bXO.setDatas(this.bXQ);
        int size = this.bXQ.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bXQ.get(i3);
            if (this.bXS != null && this.bXS.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TD);
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
        this.bXO.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bXR.size() && i != this.aEY) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bXR.get(i);
            this.bXN.h(this.bXR, i);
            if (this.bXT) {
                if (cVar.Dp() == EmotionGroupType.LOCAL) {
                    this.bXO.setShowDelete(true);
                } else {
                    this.bXO.setShowDelete(false);
                }
            }
            this.bXO.setCurrentTab(i);
            this.aEY = i;
            this.bXS = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aEY = -1;
        this.bXQ.clear();
        this.bXN.reset();
        this.bXO.reset();
    }

    public void setIsInChat(boolean z) {
        this.bXT = z;
        this.bXO.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bXU = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eT(int i) {
        if (i >= 0 && i < this.bXQ.size() && i != this.aEY && this.bXN != null) {
            this.bXN.hV(i);
            this.aEY = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.bXO.onChangeSkinType(i);
        this.bXN.onChangeSkinType(i);
        ai.e(this.bXP, d.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hW(int i) {
        if (this.bXO != null && i != this.aEY) {
            this.bXO.setCurrentTab(i);
            this.aEY = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bXR.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Do()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bXN.h(arrayList, 0);
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
        this.bXN.setOnDataSelected(iVar);
        this.bXO.setOnDataSelected(iVar);
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
    public void lT() {
        if (this.bXO != null) {
            int size = this.bXQ.size();
            for (int i = 0; i < size; i++) {
                this.bXO.n(i, this.bXU);
            }
            this.bXO.setTabWidgetBigEmontionVisibility(this.bXU);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
