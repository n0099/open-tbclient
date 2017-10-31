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
    private int Ja;
    private i Jb;
    private CustomMessageListener Tc;
    private int aEe;
    private int api;
    private EmotionTabContentView ciW;
    private EmotionTabWidgetView ciX;
    private View ciY;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ciZ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cja;
    private String cjb;
    private boolean cjc;
    private boolean cjd;
    private int cje;
    private CustomMessageListener cjf;

    public b(Context context) {
        super(context);
        this.ciZ = new ArrayList<>();
        this.cja = new ArrayList<>();
        this.aEe = -1;
        this.cjb = null;
        this.api = -1;
        this.cjc = true;
        this.cjd = true;
        this.cje = 0;
        this.Ja = 0;
        this.Tc = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.cjf = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.ciZ.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.ciZ.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.ciZ.get(i2)).CW() != EmotionGroupType.USER_COLLECT) {
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
        this.ciW = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.ciX = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.ciY = findViewById(d.g.emotion_tab_widget_div_line);
        this.ciX.setOnTabSelectedListener(this);
        this.ciW.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.api = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.api);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.ciX != null) {
            this.ciX.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.cjd = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aer() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.aeB().aeD().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CW() != EmotionGroupType.BIG_EMOTION || this.cjc) {
                if (next.CW() != EmotionGroupType.USER_COLLECT || this.cjd) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.ciZ = g.aeB().aeD();
        if (!this.cjc || !this.cjd) {
            this.cja = aer();
            if (!this.cjd && this.ciZ != null) {
                this.ciZ = new ArrayList<>(g.aeB().aeD());
                int i = 0;
                while (true) {
                    if (i < this.ciZ.size()) {
                        if (this.ciZ.get(i).CW() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.ciZ.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.cja = g.aeB().aeD();
        }
        if ((this.ciZ == null || this.ciZ.size() <= 0) && this.cje < 3) {
            this.cje++;
            g.aeB().aeC();
            return;
        }
        this.ciX.setDatas(this.ciZ);
        int size = this.ciZ.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ciZ.get(i3);
            if (this.cjb != null && this.cjb.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Tc);
        MessageManager.getInstance().registerListener(this.cjf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Tc);
        MessageManager.getInstance().unRegisterListener(this.cjf);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.api) {
            this.api = skinType;
            onChangeSkinType(this.api);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ciX.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.cja.size() && i != this.aEe) {
            this.ciW.i(this.cja, i);
            this.ciX.setCurrentTab(i);
            this.aEe = i;
            this.cjb = this.cja.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aEe = -1;
        this.ciZ.clear();
        this.ciW.reset();
        this.ciX.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.cjc = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fd(int i) {
        if (i >= 0 && i < this.ciZ.size() && i != this.aEe && this.ciW != null) {
            this.ciW.iH(i);
            this.aEe = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.ciX.onChangeSkinType(i);
        this.ciW.onChangeSkinType(i);
        aj.e(this.ciY, d.C0080d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void iI(int i) {
        if (this.ciX != null && i != this.aEe) {
            this.ciX.setCurrentTab(i);
            this.aEe = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cja.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.CV()) {
                                    arrayList.add(next);
                                }
                            }
                            this.ciW.i(arrayList, 0);
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
        this.Jb = iVar;
        this.ciW.setOnDataSelected(iVar);
        this.ciX.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lG() {
        if (this.ciX != null) {
            int size = this.ciZ.size();
            for (int i = 0; i < size; i++) {
                this.ciX.l(i, this.cjc);
            }
            this.ciX.setTabWidgetBigEmontionVisibility(this.cjc);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
