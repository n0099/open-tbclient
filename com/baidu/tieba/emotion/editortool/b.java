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
    private int JF;
    private i JG;
    private CustomMessageListener SV;
    private int aDG;
    private int aoZ;
    private EmotionTabContentView cbB;
    private EmotionTabWidgetView cbC;
    private View cbD;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbF;
    private String cbG;
    private boolean cbH;
    private boolean cbI;
    private boolean cbJ;
    private int cbK;
    private CustomMessageListener cbL;

    public b(Context context) {
        super(context);
        this.cbE = new ArrayList<>();
        this.cbF = new ArrayList<>();
        this.aDG = -1;
        this.cbG = null;
        this.aoZ = -1;
        this.cbI = true;
        this.cbJ = true;
        this.cbK = 0;
        this.JF = 0;
        this.SV = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.cbL = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.cbE.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.cbE.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.cbE.get(i2)).CO() != EmotionGroupType.USER_COLLECT) {
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
        LayoutInflater.from(context).inflate(d.j.emotion_tab_host, (ViewGroup) this, true);
        this.cbB = (EmotionTabContentView) findViewById(d.h.face_tab_content);
        this.cbC = (EmotionTabWidgetView) findViewById(d.h.face_tab_widget);
        this.cbD = findViewById(d.h.emotion_tab_widget_div_line);
        this.cbC.setOnTabSelectedListener(this);
        this.cbB.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aoZ = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.aoZ);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.cbC != null) {
            this.cbC.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cbJ = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> acm() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.acw().acy().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CO() != EmotionGroupType.BIG_EMOTION || this.cbI) {
                if (next.CO() != EmotionGroupType.USER_COLLECT || this.cbJ) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.cbE = g.acw().acy();
        if (!this.cbI || !this.cbJ) {
            this.cbF = acm();
            if (!this.cbJ && this.cbE != null) {
                this.cbE = new ArrayList<>(g.acw().acy());
                int i = 0;
                while (true) {
                    if (i < this.cbE.size()) {
                        if (this.cbE.get(i).CO() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.cbE.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cbF = g.acw().acy();
        }
        if ((this.cbE == null || this.cbE.size() <= 0) && this.cbK < 3) {
            this.cbK++;
            g.acw().acx();
            return;
        }
        this.cbC.setDatas(this.cbE);
        int size = this.cbE.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbE.get(i3);
            if (this.cbG != null && this.cbG.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SV);
        MessageManager.getInstance().registerListener(this.cbL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.SV);
        MessageManager.getInstance().unRegisterListener(this.cbL);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoZ) {
            this.aoZ = skinType;
            onChangeSkinType(this.aoZ);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cbC.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cbF.size() && i != this.aDG) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbF.get(i);
            this.cbB.h(this.cbF, i);
            if (this.cbH) {
                if (cVar.CO() == EmotionGroupType.LOCAL) {
                    this.cbC.setShowDelete(true);
                } else {
                    this.cbC.setShowDelete(false);
                }
            }
            this.cbC.setCurrentTab(i);
            this.aDG = i;
            this.cbG = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aDG = -1;
        this.cbE.clear();
        this.cbB.reset();
        this.cbC.reset();
    }

    public void setIsInChat(boolean z) {
        this.cbH = z;
        this.cbC.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.cbI = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fd(int i) {
        if (i >= 0 && i < this.cbE.size() && i != this.aDG && this.cbB != null) {
            this.cbB.ip(i);
            this.aDG = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.cbC.onChangeSkinType(i);
        this.cbB.onChangeSkinType(i);
        aj.e(this.cbD, d.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void iq(int i) {
        if (this.cbC != null && i != this.aDG) {
            this.cbC.setCurrentTab(i);
            this.aDG = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cbF.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.CN()) {
                                    arrayList.add(next);
                                }
                            }
                            this.cbB.h(arrayList, 0);
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
        this.JG = iVar;
        this.cbB.setOnDataSelected(iVar);
        this.cbC.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JG != null) {
            this.JG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JF = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JF;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lM() {
        if (this.cbC != null) {
            int size = this.cbE.size();
            for (int i = 0; i < size; i++) {
                this.cbC.k(i, this.cbI);
            }
            this.cbC.setTabWidgetBigEmontionVisibility(this.cbI);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
