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
    private int Lq;
    private i Lr;
    private CustomMessageListener TB;
    private int aEX;
    private int aql;
    private EmotionTabContentView bXb;
    private EmotionTabWidgetView bXc;
    private View bXd;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bXe;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bXf;
    private String bXg;
    private boolean bXh;
    private boolean bXi;
    private boolean bXj;
    private int bXk;

    public b(Context context) {
        super(context);
        this.bXe = new ArrayList<>();
        this.bXf = new ArrayList<>();
        this.aEX = -1;
        this.bXg = null;
        this.aql = -1;
        this.bXi = true;
        this.bXj = true;
        this.bXk = 0;
        this.Lq = 0;
        this.TB = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.bXb = (EmotionTabContentView) findViewById(d.h.face_tab_content);
        this.bXc = (EmotionTabWidgetView) findViewById(d.h.face_tab_widget);
        this.bXd = findViewById(d.h.emotion_tab_widget_div_line);
        this.bXc.setOnTabSelectedListener(this);
        this.bXb.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aql = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aql);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bXc != null) {
            this.bXc.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.bXj = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aaT() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.abd().abf().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Dp() != EmotionGroupType.BIG_EMOTION || this.bXi) {
                if (next.Dp() != EmotionGroupType.USER_COLLECT || this.bXj) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bXe = g.abd().abf();
        if (!this.bXi || !this.bXj) {
            this.bXf = aaT();
            if (!this.bXj && this.bXe != null) {
                this.bXe = new ArrayList<>(g.abd().abf());
                int i = 0;
                while (true) {
                    if (i < this.bXe.size()) {
                        if (this.bXe.get(i).Dp() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.bXe.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.bXf = g.abd().abf();
        }
        if ((this.bXe == null || this.bXe.size() <= 0) && this.bXk < 3) {
            this.bXk++;
            g.abd().abe();
            return;
        }
        this.bXc.setDatas(this.bXe);
        int size = this.bXe.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bXe.get(i3);
            if (this.bXg != null && this.bXg.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TB);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aql) {
            this.aql = skinType;
            onChangeSkinType(this.aql);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bXc.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bXf.size() && i != this.aEX) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bXf.get(i);
            this.bXb.h(this.bXf, i);
            if (this.bXh) {
                if (cVar.Dp() == EmotionGroupType.LOCAL) {
                    this.bXc.setShowDelete(true);
                } else {
                    this.bXc.setShowDelete(false);
                }
            }
            this.bXc.setCurrentTab(i);
            this.aEX = i;
            this.bXg = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aEX = -1;
        this.bXe.clear();
        this.bXb.reset();
        this.bXc.reset();
    }

    public void setIsInChat(boolean z) {
        this.bXh = z;
        this.bXc.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bXi = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eT(int i) {
        if (i >= 0 && i < this.bXe.size() && i != this.aEX && this.bXb != null) {
            this.bXb.hT(i);
            this.aEX = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.bXc.onChangeSkinType(i);
        this.bXb.onChangeSkinType(i);
        ai.e(this.bXd, d.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hU(int i) {
        if (this.bXc != null && i != this.aEX) {
            this.bXc.setCurrentTab(i);
            this.aEX = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bXf.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Do()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bXb.h(arrayList, 0);
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
        this.Lr = iVar;
        this.bXb.setOnDataSelected(iVar);
        this.bXc.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Lq = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Lq;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lT() {
        if (this.bXc != null) {
            int size = this.bXe.size();
            for (int i = 0; i < size; i++) {
                this.bXc.n(i, this.bXi);
            }
            this.bXc.setTabWidgetBigEmontionVisibility(this.bXi);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
