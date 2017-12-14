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
    private i IR;
    private int IS;
    private CustomMessageListener TF;
    private int aES;
    private int apD;
    private EmotionTabContentView crZ;
    private EmotionTabWidgetView csa;
    private View csb;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> csc;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> csd;
    private String cse;
    private boolean csf;
    private boolean csg;
    private int csh;
    private CustomMessageListener csi;

    public b(Context context) {
        super(context);
        this.csc = new ArrayList<>();
        this.csd = new ArrayList<>();
        this.aES = -1;
        this.cse = null;
        this.apD = -1;
        this.csf = true;
        this.csg = true;
        this.csh = 0;
        this.IS = 0;
        this.TF = new CustomMessageListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED) { // from class: com.baidu.tieba.emotion.editortool.b.1
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
        this.csi = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_EMOTION_USER_CONNECTION_TOOL) { // from class: com.baidu.tieba.emotion.editortool.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921304 && b.this.csc.size() >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < b.this.csc.size()) {
                            if (((com.baidu.tbadk.editortools.emotiontool.c) b.this.csc.get(i2)).Dt() != EmotionGroupType.USER_COLLECT) {
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
        this.crZ = (EmotionTabContentView) findViewById(d.g.face_tab_content);
        this.csa = (EmotionTabWidgetView) findViewById(d.g.face_tab_widget);
        this.csb = findViewById(d.g.emotion_tab_widget_div_line);
        this.csa.setOnTabSelectedListener(this);
        this.crZ.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.apD = TbadkCoreApplication.getInst().getSkinType();
        onChangeSkinType(this.apD);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.csa != null) {
            this.csa.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.csg = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> agx() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.agH().agJ().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Dt() != EmotionGroupType.BIG_EMOTION || this.csf) {
                if (next.Dt() != EmotionGroupType.USER_COLLECT || this.csg) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.csc = g.agH().agJ();
        if (!this.csf || !this.csg) {
            this.csd = agx();
            if (!this.csg && this.csc != null) {
                this.csc = new ArrayList<>(g.agH().agJ());
                int i = 0;
                while (true) {
                    if (i < this.csc.size()) {
                        if (this.csc.get(i).Dt() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.csc.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.csd = g.agH().agJ();
        }
        if ((this.csc == null || this.csc.size() <= 0) && this.csh < 3) {
            this.csh++;
            g.agH().agI();
            return;
        }
        this.csa.setDatas(this.csc);
        int size = this.csc.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.csc.get(i3);
            if (this.cse != null && this.cse.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TF);
        MessageManager.getInstance().registerListener(this.csi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TF);
        MessageManager.getInstance().unRegisterListener(this.csi);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.apD) {
            this.apD = skinType;
            onChangeSkinType(this.apD);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.csa.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.csd.size() && i != this.aES) {
            this.crZ.i(this.csd, i);
            this.csa.setCurrentTab(i);
            this.aES = i;
            this.cse = this.csd.get(i).getGroupId();
        }
    }

    public void reset() {
        this.aES = -1;
        this.csc.clear();
        this.crZ.reset();
        this.csa.reset();
    }

    public void setShowBigEmotion(boolean z) {
        this.csf = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void fb(int i) {
        if (i >= 0 && i < this.csc.size() && i != this.aES && this.crZ != null) {
            this.crZ.jf(i);
            this.aES = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.csa.onChangeSkinType(i);
        this.crZ.onChangeSkinType(i);
        aj.e(this.csb, d.C0096d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void jg(int i) {
        if (this.csa != null && i != this.aES) {
            this.csa.setCurrentTab(i);
            this.aES = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.csd.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Ds()) {
                                    arrayList.add(next);
                                }
                            }
                            this.crZ.i(arrayList, 0);
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
        this.IR = iVar;
        this.crZ.setOnDataSelected(iVar);
        this.csa.setOnDataSelected(iVar);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IR != null) {
            this.IR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IS;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        if (this.csa != null) {
            int size = this.csc.size();
            for (int i = 0; i < size; i++) {
                this.csa.m(i, this.csf);
            }
            this.csa.setTabWidgetBigEmontionVisibility(this.csf);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }
}
